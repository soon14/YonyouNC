package nc.ui.pu.m23.action.maintain;

import java.awt.event.ActionEvent;
import java.util.Map;

import nc.itf.scmpub.reference.uap.bd.material.MaterialPubService;
import nc.itf.uap.pf.busiflow.PfButtonClickContext;
import nc.ui.pu.m23.editor.card.utils.BackReasonEditUtil;
import nc.ui.pu.pub.util.PuVDefFilterUtil;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pub.pf.PfUtilClient;
import nc.ui.pubapp.uif2app.actions.AbstractReferenceAction;
import nc.ui.pubapp.uif2app.funcnode.trantype.TrantypeFuncUtils;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.ui.uif2.model.AbstractAppModel;
import nc.vo.bd.material.stock.MaterialStockVO;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pu.m23.entity.ArriveItemVO;
import nc.vo.pu.m23.entity.ArriveVO;
import nc.vo.pu.m23.rule.transfer.CalcValidDay;
import nc.vo.pu.pub.util.AggVOUtil;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.scmpub.res.billtype.POBillType;

import org.apache.commons.lang.ArrayUtils;

/**
 * <p>
 * <b>本类主要完成以下功能：</b>
 * <ul>
 * <li>到货单 增加--采购订单 按钮处理类Action
 * </ul>
 * <p>
 * <p>
 * 
 * @version 6.0
 * @since 6.0
 * @author hanbin
 * @time 2010-1-12 下午02:15:12
 */
public class AddFrom21UIAction extends AbstractReferenceAction {

  private static final long serialVersionUID = 6197534415524885685L;

  private ShowUpableBillForm editor = null;

  private AbstractAppModel model = null;

  public AddFrom21UIAction() {
    super();
    this.setSourceBillName(POBillType.Order.getName());
    this.setSourceBillType(POBillType.Order.getCode());
    editor.getBillCardPanel().getBillModel().loadLoadRelationItemValue();
  }

  @Override
  public void doAction(ActionEvent e) throws Exception {
    PfUtilClient.childButtonClickedNew(this.createPfButtonClickContext());

    if (PfUtilClient.isCloseOK()) {
      AggregatedValueObject[] retObjArray = PfUtilClient.getRetVos();
      if (ArrayUtils.isEmpty(retObjArray)) {
        return;
      }

      ArriveVO[] retVOArray = (ArriveVO[]) retObjArray;

      // 转单公共处理
      this.getTransferViewProcessor().processBillTransfer(retVOArray);

      BillCardPanel card = this.editor.getBillCardPanel();
      // 设置退货理由
      new BackReasonEditUtil(card).setEnabled();

      // 触发编辑事件
      // String stockOrg = retVOArray[0].getHVO().getPk_org();
      // this.model.fireEvent(new OrgChangedEvent(null, stockOrg));
      new PuVDefFilterUtil()
          .setOrgForDefRef(card, this.getModel().getContext());

      // 补充保质期天数
      this.setValiday(card, retVOArray);
    }
    this.setEditable();
  }

  public ShowUpableBillForm getEditor() {
    return this.editor;
  }

  public AbstractAppModel getModel() {
    return this.model;
  }

  public void setEditor(ShowUpableBillForm editor) {
    this.editor = editor;
  }

  public void setModel(AbstractAppModel model) {
    this.model = model;
  }

  private PfButtonClickContext createPfButtonClickContext() {
    PfButtonClickContext context = new PfButtonClickContext();
    context.setParent(this.getModel().getContext().getEntranceUI());
    context.setSrcBillType(this.getSourceBillType());
    context.setPk_group(this.getModel().getContext().getPk_group());
    context.setUserId(this.getModel().getContext().getPk_loginUser());
    // 如果该节点是由交易类型发布的，那么这个参数应该传交易类型，否则传单据类型
    String vtrantype =
        TrantypeFuncUtils.getTrantype(this.getModel().getContext());
    if (StringUtil.isEmptyWithTrim(vtrantype)) {
      context.setCurrBilltype(POBillType.Arrive.getCode());
    }
    else {
      context.setCurrBilltype(vtrantype);
    }
    context.setUserObj(null);
    context.setSrcBillId(null);
    context.setBusiTypes(this.getBusitypes());
    // 上面的参数在原来调用的方法中都有涉及，只不过封成了一个整结构，下面两个参数是新加的参数
    // 上游的交易类型集合
    context.setTransTypes(this.getTranstypes());
    // 标志在交换根据目的交易类型分组时，查找目的交易类型的依据，有三个可设置值：1（根据接口定义）、
    // 2（根据流程配置）、-1（不根据交易类型分组）
    context.setClassifyMode(PfButtonClickContext.ClassifyByBusiflow);
    return context;
  }

  /**
   * 设置编辑性
   */
  private void setEditable() {
    BillCardPanel panel = this.editor.getBillCardPanel();
    for (int i = 0; i < panel.getRowCount(); ++i) {
      // zhangshqb 2015-4-28 636需求新增收货利润中心以及结算利润中心，均不可编辑
      panel.setCellEditable(i, ArriveItemVO.PK_APLIABCENTER, false);
      panel.setCellEditable(i, ArriveItemVO.PK_APLIABCENTER_V, false);
      panel.setCellEditable(i, ArriveItemVO.PK_ARRLIABCENTER, false);
      panel.setCellEditable(i, ArriveItemVO.PK_ARRLIABCENTER_V, false);
    }
  }

  private void setValiday(BillCardPanel card, ArriveVO[] vos) {
    CalcValidDay util = new CalcValidDay();
    String[] fields =
        new String[] {
          MaterialStockVO.QUALITYMANFLAG, MaterialStockVO.QUALITYUNIT,
          MaterialStockVO.QUALITYNUM
        };
    // 得到物料主键数组
    String[] mrls =
        (String[]) AggVOUtil.getDistinctItemFieldArray(vos,
            ArriveItemVO.PK_MATERIAL, String.class);
    String org = vos[0].getHVO().getPk_org();
    Map<String, MaterialStockVO> map =
        MaterialPubService.queryMaterialStockInfo(mrls, org, fields);
    for (int i = 0; i < card.getRowCount(); i++) {
      String mrl = (String) card.getBodyValueAt(i, ArriveItemVO.PK_MATERIAL);
      if (map != null && map.get(mrl) != null) {
        Integer validDay = util.calcValidDay(map.get(mrl));
        card.setBodyValueAt(validDay, i, ArriveItemVO.IVALIDDAY);
      }
    }
  }
}
