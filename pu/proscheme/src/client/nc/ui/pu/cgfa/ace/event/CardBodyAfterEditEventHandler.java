/**
 * 
 */
package nc.ui.pu.cgfa.ace.event;

import java.math.BigDecimal;
import java.util.Map;

import nc.itf.scmpub.reference.uap.bd.material.MaterialPubService;
import nc.ui.pub.bill.BillModel;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardBodyAfterEditEvent;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

/**
 * @author wangzym
 * @version 2017��4��24�� ����11:11:57
 */
public class CardBodyAfterEditEventHandler implements
		IAppEventHandler<CardBodyAfterEditEvent> {
	private nc.ui.pubapp.uif2app.view.ShowUpableBillForm billForm;

	public nc.ui.pubapp.uif2app.view.ShowUpableBillForm getBillForm() {
		return billForm;
	}

	public void setBillForm(
			nc.ui.pubapp.uif2app.view.ShowUpableBillForm billForm) {
		this.billForm = billForm;
	}

	public CardBodyAfterEditEventHandler() {
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void handleAppEvent(CardBodyAfterEditEvent e) {
		String key = e.getKey();
		nc.ui.pub.bill.BillCardPanel bcp = e.getBillCardPanel();
		BillModel bModel = bcp.getBillModel();
		if ("materialcode".equals(key)) {
			String value = (String) e.getValue();

			Map<String, String> assistunitMap = MaterialPubService
					.queryPuMeasdocIDByPks(new String[] { value });
			String assistunit = assistunitMap.get(value);
			if (assistunit != null) {
				int row = e.getRow();
				e.getBillCardPanel().setBodyValueAt(assistunit, row, "unit");
			}
		} else if ("vbdef1".equals(key) || "plan_num".equals(key)) {
			UFDouble ycdj = bcp.getBodyValueAt(e.getRow(), "vbdef1") == null ? UFDouble.ZERO_DBL
					: new UFDouble(bcp.getBodyValueAt(e.getRow(), "vbdef1")
							.toString());
			Integer num = bcp.getBodyValueAt(e.getRow(), "plan_num") == null ? 0
					: (Integer) bcp.getBodyValueAt(e.getRow(), "plan_num");
			UFDouble ycjg = ycdj.multiply(num == null ? UFDouble.ZERO_DBL
					: new UFDouble(num));
			bcp.setBodyValueAt(ycjg.setScale(2, BigDecimal.ROUND_HALF_UP),
					e.getRow(), "vbdef2");
			int rowCount = bcp.getRowCount();
			UFDouble hSum = UFDouble.ZERO_DBL;
			for (int i = 0; i < rowCount; i++) {
				hSum = hSum
						.add(bcp.getBodyValueAt(i, "vbdef2") == null ? UFDouble.ZERO_DBL
								: new UFDouble(bcp.getBodyValueAt(i, "vbdef2")
										.toString()));
			}
			hSum.setScale(2, BigDecimal.ROUND_HALF_UP);
			bcp.setHeadItem("forecastprice", hSum);

		} else if ("vbdef2".equals(e.getKey())) {
			// ���㵥��
			Object value = e.getValue() == null ? 0 : e.getValue();
			Integer num = bcp.getBodyValueAt(e.getRow(), "plan_num") == null ? 0
					: (Integer) bcp.getBodyValueAt(e.getRow(), "plan_num");
			if (num == 0) {
				ExceptionUtils.wrappBusinessException("���������ļƻ��������Լ���Ԥ�ⵥ��");
			}
			UFDouble ycdj = (new UFDouble(value.toString())).div(num).setScale(
					2, BigDecimal.ROUND_HALF_UP);
			bcp.setBodyValueAt(ycdj, e.getRow(), "vbdef1");
			UFDouble hSum = UFDouble.ZERO_DBL;
			int rowCount = bcp.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				hSum = hSum
						.add(bcp.getBodyValueAt(i, "vbdef2") == null ? UFDouble.ZERO_DBL
								: new UFDouble(bcp.getBodyValueAt(i, "vbdef2")
										.toString()));
			}
			hSum.setScale(2, BigDecimal.ROUND_HALF_UP);
			bcp.setHeadItem("forecastprice", hSum);

		}

	}

}