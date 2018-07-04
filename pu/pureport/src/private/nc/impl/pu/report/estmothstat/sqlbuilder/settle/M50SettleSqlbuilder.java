package nc.impl.pu.report.estmothstat.sqlbuilder.settle;

import nc.bs.pubapp.AppBsContext;
import nc.impl.pu.report.estmothstat.sqlbuilder.AbstractEstMonthStatSqlBuilder;
import nc.vo.pu.report.enumeration.EstMonthStatQryFieldCode;
import nc.vo.pu.report.queryinfo.eststat.PuEstStatQryInfoPara;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pubapp.pattern.pub.SqlBuilder;
import nc.vo.scmpub.res.billtype.POBillType;

import org.apache.commons.lang.StringUtils;

/**
 * @since 6.0
 * @version 2011-8-22 ����04:48:47
 * @author �����
 */

public class M50SettleSqlbuilder extends AbstractEstMonthStatSqlBuilder {

  /**
   * @param queryPara
   */
  public M50SettleSqlbuilder(PuEstStatQryInfoPara queryPara) {
    super(queryPara);
  }

  @Override
  public String getQuerySql() {

    String whereSql = this.builderWhereSql();
    if (StringUtils.isEmpty(whereSql)) {
      return null;
    }
    SqlBuilder sql = new SqlBuilder();
    // �������
    sql.append(this.getGoodSettleSql(whereSql));
    sql.append(" union all ");
    // ���ý���
    sql.append(this.getFeeSettleSql(whereSql));
    return sql.toString();

  }

  /**
   * @param whereSql
   * @return
   */
  private String getFeeSettleSql(String whereSql) {
    SqlBuilder sb = new SqlBuilder();
    // ���ûس�
    sb.append(this.getFeeSettleSqlForClash(whereSql));
    sb.append(" union all ");
    // ���ý���
    sb.append(this.getFeeSettleSqlForSettle(whereSql));
    return sb.toString();
  }

  /**
   * @param whereSql
   * @return
   */
  private String getFeeSettleSqlForClash(String whereSql) {
    SqlBuilder sql = new SqlBuilder();
    sql.append(" SELECT ");
    sql.append("     eb.pk_storeorg pk_storeorg, ");
    sql.append("     eb.pk_storeorg_v pk_storeorg_v, ");
    sql.append("     sb.pk_org pk_org, ");
    sql.append("     sb.pk_org_v pk_org_v, ");
    sql.append("     ( '' ) pk_purchaseorg, ");
    sql.append("     ( '' ) pk_purchaseorg_v, ");
    sql.append("     bd_material.pk_marbasclass pk_marbasclass, ");
    sql.append("     bd_material.pk_measdoc cunitid, ");
    sql.append("     eb.pk_material pk_material, ");// ��������
    sql.append("     ef.pk_supplier pk_supplier, ");// ���ù�Ӧ��
    // sql.append("     bd_supplier.pk_areacl pk_areacl, ");
    sql.append("     ( '' ) pk_dept, ");
    sql.append("     ( '' ) pk_dept_v, ");
    sql.append("     ( '' ) pk_psndoc, ");
    sql.append("     ( '' ) cwhsmanagerid, ");
    sql.append("     eb.pk_stordoc pk_stordoc, ");
    sql.append("     0 nsettlenum, ");// ���ý�������
    sql.append("     0 ngoodsmoney, ");// ���ý������̯�Ľ��
    // sql.append("     ef.nestmny nclashestmoney, ");//
    // ����Ƿ����ݹ������Ľ��ǳ����Ľ�����ȫ��������
    sql.append("     ef.ncalcostmny nclashestmoney, ");// ����Ƿ����ݹ������Ľ��ǳ����Ľ�����ȫ��������v61=>ncalcostmny
    sql.append("     eb.ccurrencyid ccurrencyid ");
    sql.append(" FROM po_settlebill sh ");
    sql.append(" INNER JOIN po_settlebill_b sb ON sh.pk_settlebill = sb.pk_settlebill ");
    sql.append(" INNER JOIN  po_vmifi_fee ef ON ef.pk_firstsettle_b = sb.pk_settlebill_b ");
    sql.append(" INNER JOIN po_vmifi eb ON ef.pk_stockps_b = eb.pk_stockps_b ");
    sql.append(" INNER JOIN bd_material bd_material ON eb.pk_material = bd_material.pk_material ");
    if (this.containSupplier()) {
      sql.append(" INNER JOIN bd_supplier bd_supplier ON ef.pk_supplier = bd_supplier.pk_supplier ");
    }
    sql.append(" WHERE sh.dr= 0 ");
    sql.append("   AND isnull(sh.btoia,'N')='Y'");// ����ȷ�ϣ��س�����ֻ�д������ʱ��ͳ��
    sql.append("   AND sb.dr= 0 ");
    sql.append("   AND eb.dr= 0 ");
    sql.append("   AND ef.dr= 0 ");
    sql.append("   AND sh.pk_group ", AppBsContext.getInstance().getPkGroup());
    sql.append(" AND ");
    // �滻Ϊ���õĹ�Ӧ��
    sql.append(whereSql.replace("eb.pk_supplier", "ef.pk_supplier"));
    // .replace("eb.pk_srcmaterial",
    // "fe.pk_srcmaterial")
    sql.appendIDIsNotNull(" and ef.pk_firstsettle");// ֻͳ���ݹ�������
    sql.append(" AND  ");
    sql.append(this.buildAddWhere().replace("DTOCOSTAPDATE", "ef.destdate"));
    return sql.toString();
  }

  /**
   * @param whereSql
   * @return
   */
  private String getFeeSettleSqlForSettle(String whereSql) {
    SqlBuilder sql = new SqlBuilder();
    sql.append(" SELECT ");
    sql.append("     eb.pk_storeorg pk_storeorg, ");
    sql.append("     eb.pk_storeorg_v pk_storeorg_v, ");
    sql.append("     sb.pk_org pk_org, ");
    sql.append("     sb.pk_org_v pk_org_v, ");
    sql.append("     ( '' ) pk_purchaseorg, ");
    sql.append("     ( '' ) pk_purchaseorg_v, ");
    sql.append("     bd_material.pk_marbasclass pk_marbasclass, ");
    sql.append("     bd_material.pk_measdoc cunitid, ");
    sql.append("     eb.pk_material pk_material, ");// ��������
    sql.append("     ef.pk_supplier pk_supplier, ");// ���ù�Ӧ��
    // sql.append("     bd_supplier.pk_areacl pk_areacl, ");
    sql.append("     ( '' ) pk_dept, ");
    sql.append("     ( '' ) pk_dept_v, ");
    sql.append("     ( '' ) pk_psndoc, ");
    sql.append("     ( '' ) cwhsmanagerid, ");
    sql.append("     eb.pk_stordoc pk_stordoc, ");
    sql.append("     0 nsettlenum, ");// ���ý�������
    sql.append("     fe.nallotmoney ngoodsmoney, ");// ���ý������̯�Ľ��
    sql.append("     0 nclashestmoney, ");// ����Ƿ����ݹ������Ľ��ǳ����Ľ�����ȫ��������
    sql.append("     eb.ccurrencyid ccurrencyid ");
    sql.append(" FROM po_settlebill sh ");
    sql.append(" INNER JOIN po_settlebill_b sb ON sh.pk_settlebill = sb.pk_settlebill ");
    sql.append(" INNER JOIN po_settle_feeallot fe ON fe.pk_settlebill_b = sb.pk_settlebill_b ");
    sql.append(" INNER JOIN po_vmifi_fee ef ON ef.pk_stockps_b = sb.pk_stock_b ");
    sql.append("            and ef.pk_srcfeematerial = fe.pk_srcmaterial ");
    sql.append(" INNER JOIN po_vmifi eb ON ef.pk_stockps_b  = eb.pk_stockps_b ");
    sql.append(" INNER JOIN bd_material bd_material ON eb.pk_material = bd_material.pk_material ");

    if (this.containSupplier()) {
      sql.append(" INNER JOIN bd_supplier bd_supplier ON ef.pk_supplier = bd_supplier.pk_supplier ");
    }
    sql.append(" WHERE sh.dr= 0 ");
    sql.append("   AND sb.dr= 0 ");
    sql.append("   AND isnull(ef.btoia,'N')   = 'Y' ");
    sql.append("   AND eb.dr= 0 ");
    sql.append("   AND ef.dr= 0 ");
    sql.append("   AND sh.pk_group ", AppBsContext.getInstance().getPkGroup());
    sql.append(" AND ");
    // �滻Ϊ���õĹ�Ӧ��
    sql.append(whereSql.replace("eb.pk_supplier", "ef.pk_supplier"));
    // .replace("eb.pk_srcmaterial",
    // "fe.pk_srcmaterial")
    sql.appendIDIsNotNull(" and ef.pk_firstsettle");// ֻͳ���ݹ�������
    sql.append(" AND  ");
    sql.append(this.buildAddWhere().replace("DTOCOSTAPDATE", "ef.destdate"));
    return sql.toString();
  }

  /**
   * @param whereSql
   * @return
   */
  private String getGoodSettleSql(String whereSql) {
    SqlBuilder sql = new SqlBuilder();
    sql.append(" SELECT ");
    sql.append("     eb.pk_storeorg pk_storeorg, ");
    sql.append("     eb.pk_storeorg_v pk_storeorg_v, ");
    sql.append("     sb.pk_org pk_org, ");
    sql.append("     sb.pk_org_v pk_org_v, ");
    sql.append("     ( '' ) pk_purchaseorg, ");
    sql.append("     ( '' ) pk_purchaseorg_v, ");
    sql.append("     bd_material.pk_marbasclass pk_marbasclass, ");
    sql.append("     bd_material.pk_measdoc cunitid, ");
    sql.append("     eb.pk_material pk_material, ");
    sql.append("     eb.pk_supplier pk_supplier, ");
    // sql.append("     bd_supplier.pk_areacl pk_areacl, ");
    sql.append("     ( '' ) pk_dept, ");
    sql.append("     ( '' ) pk_dept_v, ");
    sql.append("     ( '' ) pk_psndoc, ");
    sql.append("     ( '' ) cwhsmanagerid, ");
    sql.append("     eb.pk_stordoc pk_stordoc, ");
    sql.append("     sb.nsettlenum nsettlenum, ");
    sql.append("     sb.ngoodsmoney ngoodsmoney, ");
    sql.append("     case when isnull(sh.btoia,'N')='Y'");
    sql.append("          then  sb.nclashestmoney ");
    sql.append("          else   0 ");
    sql.append("     end nclashestmoney, ");// �����ݹ�������ȷ�ϣ��س�����ֻ�д������ʱ��ͳ�ƣ�
    // sql.append("     sb.nclashestmoney nclashestmoney, ");
    sql.append("     eb.ccurrencyid ccurrencyid ");
    sql.append(" FROM po_settlebill sh ");
    sql.append(" INNER JOIN po_settlebill_b sb ON sh.pk_settlebill = sb.pk_settlebill ");
    sql.append(" INNER JOIN po_vmifi eb ON sb.pk_stock_b = eb.pk_stockps_b ");
    sql.append(" INNER JOIN bd_material bd_material ON eb.pk_material = bd_material.pk_material ");
    if (this.containSupplier()) {
      sql.append(" INNER JOIN bd_supplier bd_supplier ON eb.pk_supplier = bd_supplier.pk_supplier ");
    }
    sql.append(" WHERE sh.dr           = 0 ");
    sql.append("   AND sh.pk_group ", AppBsContext.getInstance().getPkGroup());
    sql.append("  AND sb.dr     = 0 ");
    sql.append("  AND isnull(sb.nclashestmoney,0) <> 0 ");

    sql.append("   AND isnull(sh.btoia,'N')='Y'");// ����ȷ�ϣ��س�����ֻ�д������ʱ��ͳ��
    sql.append("  and eb.baffectcost", UFBoolean.TRUE);

    sql.append(" AND ");
    sql.append(whereSql);
    sql.append(" AND  ");
    sql.append(this.buildAddWhere());
    return sql.toString();
  }

  protected String buildAddWhere() {
    SqlBuilder sql = new SqlBuilder();
    if (!StringUtils.isEmpty(this.getAddWhereSql())) {
      sql.append(this.getAddWhereSql().replace("DSETTLEDATE", "sh.dbilldate")
          .replace("DBILLDATE", "eb.dbilldate"));
    }
    else {
      sql.append(" 1=1 ");
    }
    return sql.toString();
  }

  protected String builderWhereSql() {
    if (this.getQueryPara() == null) {
      return " 1=1 ";// Ԥ��ʱ���״�
    }
    // ͳ�����ݲ��������Ļ���
    if (!this.getQueryPara().getQueryTypes()
        .contains(POBillType.VoiConsumeFinance.getCode())) {
      return null;
    }
    String dlgWhere = this.getQueryPara().getDlgWherePart();
    // ���Ļ��ܲ��������ֶ�
    if (dlgWhere.contains(EstMonthStatQryFieldCode.pk_purchaseorg.code())
        || dlgWhere.contains(EstMonthStatQryFieldCode.pk_dept.code())
        || dlgWhere.contains(EstMonthStatQryFieldCode.pk_psndoc.code())
        || dlgWhere.contains(EstMonthStatQryFieldCode.cwhsmanagerid.code())) {
      return null;
    }
    dlgWhere = this.replaceWhereSql(dlgWhere);
    return dlgWhere;
  }

  /**
   * @param dlgWhere
   * @return
   */
  protected String replaceWhereSql(String dlgWhere) {
    String sql = dlgWhere;
    String[][] matchFields = new String[][] {
      {
        "pk_financeorg", "eb.pk_financeorg"
      }, {
        "pk_storeorg", "eb.pk_org"
      }, {
        "pk_supplier", "eb.pk_supplier"
      }, {
        "pk_srcmaterial", "eb.pk_srcmaterial"
      }, {
        "suppliername", "bd_supplier.name"// ����ʱ��
      }, {
        "materialname", "bd_material.name"
      }, {
        "pk_group", "eb.pk_group"
      }, {
        "pk_stordoc", "eb.pk_stordoc"
      }

    };
    for (int i = 0; i < matchFields.length; i++) {
      sql = sql.replace(matchFields[i][0], matchFields[i][1]);
    }
    return sql;
  }
}