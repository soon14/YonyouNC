package nc.ui.pu.m20.editor.list;

import nc.ui.pu.m20.editor.util.PraybillScaleUtil;
import nc.ui.pub.bill.BillListPanel;
import nc.ui.pub.bill.IBillItem;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.list.ListHeadRowChangedEvent;
import nc.vo.pu.m20.entity.PraybillHeaderVO;

/**
 * <p>
 * <b>������Ҫ������¹��ܣ�</b>
 * <ul>
 * <li>�б���ͷ�иı��¼���������
 * </ul>
 * <p>
 * <p>
 * 
 * @version 6.0
 * @since 6.0
 * @author GGR
 * @time 2010-6-21 ����08:45:18
 */
public class HeadRowChangeHandler implements
    IAppEventHandler<ListHeadRowChangedEvent> {

  @Override
  public void handleAppEvent(ListHeadRowChangedEvent e) {
    // ���ȴ���
    this.setScale(e);

  }

  /**
   * ���������������б��ľ��ȴ�����
   * <p>
   * <b>����˵��</b>
   * 
   * @param e
   *          <p>
   * @since 6.0
   * @author GGR
   * @time 2010-6-21 ����08:45:32
   */
  private void setScale(ListHeadRowChangedEvent e) {
    int oldrow = e.getOldRow();
    int row = e.getRow();
    BillListPanel blp = e.getBillListPanel();
    Object oldOrg =
        blp.getHeadBillModel().getValueAt(oldrow,
            PraybillHeaderVO.PK_ORG + IBillItem.ID_SUFFIX);
    Object newOrg =
        blp.getHeadBillModel().getValueAt(row,
            PraybillHeaderVO.PK_ORG + IBillItem.ID_SUFFIX);
    if (null == newOrg) {
      return;
    }
    if (newOrg.equals(oldOrg)) {
      return;
    }
    new PraybillScaleUtil().setListScale(blp, e.getContext().getPk_group());
  }

}