package nc.ui.pu.m20.action;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import nc.ui.bd.ref.AbstractRefGridTreeModel;
import nc.ui.bd.ref.model.PsndocDefaultRefModel;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pubapp.uif2app.actions.batch.BatchCancelAction;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pubapp.AppContext;
import nc.vo.pu.m20.entity.PrayarrangeViewVO;
import nc.ui.pu.m20.model.PrayarrangeModelService;
import nc.ui.uif2.model.BatchBillTableModel;


public class LotsArrangePraybillsAction extends BatchCancelAction{
	
	private PrayarrangeModelService daoService;
	/**
	 * 用于显示按钮和设置按钮名称
	 */
	public LotsArrangePraybillsAction() {
		super.setBtnName("批量安排");
		this.setCode("lotArrange");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8896021827884863395L;
	
	 @Override
	  public void doAction(ActionEvent e) throws Exception {
		 /**获取弹出的人员档案内的人员编码和人员名称**/
		 UIRefPane userRefPane = new UIRefPane();
		 PsndocDefaultRefModel usermodel = new PsndocDefaultRefModel();
		 AbstractRefGridTreeModel model = (AbstractRefGridTreeModel)usermodel;
		 String newWherePart="enablestate=2";
		 model.setWherePart(newWherePart);
		 model.setClassWherePart("1=1");
		 
		 userRefPane.setRefModel(model);
		 //增加多公司支持
		 userRefPane.setMultiCorpRef(true);
		 userRefPane.showModel();
		 String code = usermodel.getPkValue();
		 Integer[] rowlen = this.getModel().getSelectedOperaRows();
		 int len = rowlen.length;
		 
		 String pk_Group=AppContext.getInstance().getPkGroup();
		 String pk_Org=super.getModel().getContext().getPk_org();
		 //////批量安排功能实现（最少需要同时安排两条）
		 
		 if(code != null){//点击批量安排按钮无操作时，直接返回
			 for(int j = 0; j < len; j++){
				 this.getEditor().getBillCardPanel().setBodyValueAt(code, rowlen[j], "pk_employee");//设置采购员
		    	 this.getEditor().getBillCardPanel().setBodyValueAt("02", rowlen[j], "sts_req");//设置计划状态为以分配
		    	 //不需要将bisarrange设置为true，在保存后会有自动取反操作；
		    	 this.getEditor().getBillCardPanel().getBodyValueAt(2, "bisarrange");
		    	 this.getEditor().getBillCardPanel().setBodyValueAt(AppContext.getInstance().getServerTime(), rowlen[j], "tmstp_dispatch");//设置计划分配时间
		    	 this.getEditor().getBillCardPanel().setBodyValueAt(pk_Group, rowlen[j], "pk_group");
		    	 this.getEditor().getBillCardPanel().setBodyValueAt(pk_Org, rowlen[j], "pk_org");
		    	 //将vo增加到updateLine的list数组里;
		    	 /**
		    	  * modified by wangzym 2017-01-17
		    	  * */
		    	 Object objrow = getEditingLineVO(rowlen[j]); 
		    	 this.getEditor().getModel().updateLine(rowlen[j], objrow);
		    	 
			 }
		 }
	 }

	/**
	 * @return daoService
	 */
	public PrayarrangeModelService getDaoService() {
		return daoService;
	}

	/**
	 * @param daoService 要设置的 daoService
	 */
	public void setDaoService(PrayarrangeModelService daoService) {
		this.daoService = daoService;
	}
	
	protected Object getEditingLineVO(int rowIndex) {
		
		Object obj = null;
		obj = this.getEditor().getBillCardPanel().getBillModel().getBodyValueRowVO(rowIndex, PrayarrangeViewVO.class.getName());
		
		return obj;
	} 

	 
}
