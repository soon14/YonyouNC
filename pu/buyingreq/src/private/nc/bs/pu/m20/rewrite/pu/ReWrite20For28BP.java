/**
 * $文件说明$
 * 
 * @author linsf
 * @version 6.0
 * @see
 * @since 6.0
 * @time 2010-2-4 下午04:53:22
 */
package nc.bs.pu.m20.rewrite.pu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import nc.impl.pubapp.pattern.data.vo.VOUpdateTS;
import nc.impl.pubapp.pattern.database.DataAccessUtils;
import nc.itf.scmpub.reference.uap.group.SysInitGroupQuery;
import nc.vo.pu.m20.entity.PraybillHeaderVO;
import nc.vo.pu.m20.entity.PraybillItemVO;
import nc.vo.pu.m20.entity.writeback.M28WriteBackVO;
import nc.vo.pu.m20.enumeration.EnumOperate;
import nc.vo.pub.JavaType;

import org.apache.commons.lang.ArrayUtils;

/**
 * <p>
 * <b>本类主要完成以下功能：</b>
 * <ul>
 * <li>价格审批单回写请购单BP
 * </ul>
 * <p>
 * <p>
 * 
 * @version 6.0
 * @since 6.0
 * @author linsf
 * @time 2010-5-18 下午04:53:22
 */
public class ReWrite20For28BP {

  /**
   * 方法功能描述：回写生成价格审批单次数。
   * <p>
   * <b>参数说明</b>
   * 
   * @param vos
   * @since 6.0
   * @author gaogr
   * @time 2010-8-18 上午10:56:32
   * modify by wangzym	2017-05-08
   * 新增对于请购单状态的回写
   */
  public void backWriteGenNum(M28WriteBackVO[] vos) {

    if (!SysInitGroupQuery.isPPEnabled()) {
      return;
    }

    if (ArrayUtils.isEmpty(vos)) {
      return;
    }
    List<List<Object>> adddata = new ArrayList<List<Object>>();
    List<List<Object>> deldata = new ArrayList<List<Object>>();
    ArrayList<PraybillItemVO> items = new ArrayList<PraybillItemVO>();
    ArrayList<PraybillHeaderVO> heads = new ArrayList<PraybillHeaderVO>();
    HashSet<String> headPks = new HashSet<String>();
    for (M28WriteBackVO vo : vos) {
      PraybillItemVO item = new PraybillItemVO();
      item.setPk_praybill_b(vo.getPk_praybill_b());

      if (!headPks.contains(vo.getPk_praybill())
          && (EnumOperate.ADD == vo.getOperateFlag() || EnumOperate.DELETE == vo
              .getOperateFlag())) {
        PraybillHeaderVO head = new PraybillHeaderVO();
        head.setPk_praybill(vo.getPk_praybill());
        heads.add(head);
      }

      List<Object> rowData = new ArrayList<Object>();
      rowData.add(vo.getPk_praybill_b());

      if (EnumOperate.ADD == vo.getOperateFlag()) {
        items.add(item);
        adddata.add(rowData);
      }
      if (EnumOperate.DELETE == vo.getOperateFlag()) {
        items.add(item);
        deldata.add(rowData);
      }
    }

    this.upAdd(adddata);

    this.upDel(deldata);

    this.upTs(items/*, heads*/);
  }

  private void upAdd(List<List<Object>> adddata) {
    if (adddata.size() > 0) {
    	//增加回写请购单的状态枚举
      String addsql =
          "UPDATE po_praybill_b set npriceauditbill = coalesce(npriceauditbill,0) + 1 ,sts_req='08'  WHERE pk_praybill_b = ? ";
      new DataAccessUtils().update(addsql, new JavaType[] {
        JavaType.String
      }, adddata);
    }
  }

  private void upDel(List<List<Object>> deldata) {
    if (deldata.size() > 0) {
    	//增加回写请购单的状态枚举
      String delsql =
          "UPDATE po_praybill_b set npriceauditbill = coalesce(npriceauditbill,0) - 1 ，,sts_req='03'  WHERE pk_praybill_b = ? ";
      new DataAccessUtils().update(delsql, new JavaType[] {
        JavaType.String
      }, deldata);
    }
  }

  private void upTs(ArrayList<PraybillItemVO> items/*,
      ArrayList<PraybillHeaderVO> heads*/) {
    if (items.size() == 0) {
      return;
    }

    new VOUpdateTS<PraybillItemVO>().update(items
        .toArray(new PraybillItemVO[items.size()]));

//    new VOUpdateTS<PraybillHeaderVO>().update(heads
//        .toArray(new PraybillHeaderVO[heads.size()]));
  }
}
