/**
 * $文件说明$
 * 
 * @author tianft
 * @version 6.0
 * @see
 * @since 6.0
 * @time 2010-4-5 下午02:43:26
 */
package nc.ui.pu.m25.action;

import java.awt.event.ActionEvent;

import nc.ui.pu.m25.editor.utils.ExchangeRateUtil;
import nc.ui.pu.pub.editor.CardEditorHelper;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pubapp.uif2app.actions.CopyAction;

/**
 * <p>
 * <b>本类主要完成以下功能：</b>
 * <ul>
 * <li>
 * </ul>
 * <p>
 * <p>
 * 
 * @version 6.0
 * @since 6.0
 * @author tianft
 * @time 2010-4-5 下午02:43:26
 */
public class InvoiceCopyAction extends CopyAction {

  /**
   * 
   */
  private static final long serialVersionUID = 5294690646619221536L;
  
  
  @Override
  public void doAction(ActionEvent e) throws Exception {
	  super.doAction(e);
//	  added by wangzhqf 2015-03-27 16:01 改变汇率及改变汇率后的处理
	  BillCardPanel panel = this.getEditor().getBillCardPanel();
	  CardEditorHelper util = new CardEditorHelper(panel);
	  ExchangeRateUtil.changeExchangeRate(util);
	  panel.getHeadItem("pk_busitype").setEnabled(true);
  }

}
