/**
 * $�ļ�˵��$
 * 
 * @author wuxla
 * @version 6.0
 * @see
 * @since 6.0
 * @time 2010-7-20 ����10:13:22
 */
package nc.impl.pu.m422x.action;

import nc.bs.pu.m422x.maintain.StoreReqAppSaveBP;
import nc.bs.pu.m422x.plugin.StoreReqAppPluginPoint;
import nc.impl.pu.m422x.action.rule.ParaValidateRule;
import nc.impl.pubapp.pattern.data.bill.tool.BillTransferTool;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.vo.pu.m422x.entity.StoreReqAppVO;

/**
 * <p>
 * <b>������Ҫ������¹��ܣ�</b>
 * <ul>
 * <li>�޸�
 * </ul>
 * <p>
 * <p>
 * 
 * @version 6.0
 * @since 6.0
 * @author wuxla
 * @time 2010-7-20 ����10:13:22
 */
public class StoreReqAppUpdateAction {

  public StoreReqAppVO[] update(StoreReqAppVO[] vos) {
    BillTransferTool<StoreReqAppVO> tool =
        new BillTransferTool<StoreReqAppVO>(vos);
    StoreReqAppVO[] originVOs = tool.getOriginBills();
    StoreReqAppVO[] fullVOs = tool.getClientFullInfoBill();

    AroundProcesser<StoreReqAppVO> processer =
        new AroundProcesser<StoreReqAppVO>(StoreReqAppPluginPoint.UI_UPDATE);
    this.addRule(processer);

    processer.before(fullVOs);
    fullVOs = new StoreReqAppSaveBP().save(null, fullVOs, originVOs);
    processer.after(fullVOs);

    return tool.getBillForToClient(fullVOs);
  }

  private void addRule(AroundProcesser<StoreReqAppVO> processer) {
    processer.addBeforeRule(new ParaValidateRule());
  }
}