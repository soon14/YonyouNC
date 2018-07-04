package nc.ui.pu.qst.newoaspwh.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

import nc.bs.framework.common.NCLocator;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.ArrayListProcessor;
//import nc.bs.uif2.IActionCode;
import nc.md.data.access.NCObject;
import nc.md.model.MetaDataException;
import nc.md.persist.framework.MDPersistenceService;
import nc.ui.ls.MessageBox;
import nc.ui.pu.qst.newoaspwh.ace.serviceproxy.AceNewoaspwhMaintainProxy;
import nc.ui.pu.qst.newoaspwh.websrv.ALLDATAINFO;
import nc.ui.pu.qst.newoaspwh.websrv.APPROVEFLOWINFO;
import nc.ui.pu.qst.newoaspwh.websrv.GMCGFAOA;
import nc.ui.pu.qst.newoaspwh.websrv.GMCGFAOA_Service;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.vo.pp.m28.entity.PriceAuditHeaderVO;
import nc.vo.pp.m28.entity.PriceAuditVO;
import nc.vo.pu.cgfa.AggCgfa;
import nc.vo.pu.cgfa.Cgfa;
import nc.vo.pu.qst.newoaspwh.AggNewoaspwhaHeadVO;
import nc.vo.pu.qst.newoaspwh.NewoaspwhaHeadVO;
import nc.vo.pu.qst.newoaspwh.NewoaspwhbBodyVO;
import nc.vo.pub.pf.BillStatusEnum;
import nc.vo.pub.BusinessException;
import nc.vo.pub.BusinessRuntimeException;
import nc.vo.pub.VOStatus;
import nc.ui.pubapp.uif2app.query2.model.ModelDataManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.eclipse.swt.layout.GridData;

import nc.ui.pub.beans.UIButton;
import nc.ui.pub.beans.UIComboBox;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.beans.UITextField;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.so.mreturnassign.model.returnassign_base_config;
import nc.ui.uif2.ShowStatusBarMsgUtil;

//public class SendToOaAction extends NCAction {
public class SendToOaAction extends nc.ui.uif2.actions.EditAction {
	private ModelDataManager dataManager;
	
	private ShowUpableBillForm editor;
	
	private BillManageModel mymodel;
	
	public SendToOaAction() {
		super();
	}
	@Override
	public void doAction(ActionEvent e) throws Exception {
		// TODO ȡ����������Ϣ������װ
		//0.���������źͷ�������¼�����
		mymodel = (BillManageModel)getModel();
		JComponent parentWin = mymodel.getContext().getEntranceUI();
		//�жϷ������Ƿ�Ϊͬһ��
		Object[] objs = mymodel.getSelectedOperaDatas();
		if (objs==null) {//=====wzj add 2018-04-04===
			MessageBox.showMessageDialog("������ʾ", "����ѡ������!");
			return;
		}
		if(!checkFqroa(objs)){
			MessageBox.showMessageDialog("������ʾ", "������OA������ͬһ��!");
			ShowStatusBarMsgUtil.showErrorMsg("������ʾ", "������OA������ͬһ��!", mymodel.getContext());
			return;
		}
		final UIDialog dia = new UIDialog(parentWin,"-������Ϣ-");
		dia.setSize(new Dimension(460,300));
		dia.setLocationRelativeTo(parentWin);
		JPanel Panelpanel1=new JPanel();
		JPanel Panelpanel2=new JPanel();
		JPanel Panelpanel3=new JPanel();
		
		
//		final UITextField fah = new UITextField(30);  //wzj note 2018-04-02

		String [] lsplxs= {"","��������", "�۸�����"};		//wzj add 2018-04-02
		final UIComboBox fah = new UIComboBox();//wzj add 2018-04-02
		final UITextField famc = new UITextField(25);
		final UIComboBox splx = new UIComboBox(lsplxs);//wzj add 2018-04-02
		fah.setAutoscrolls(true);
//		splx.setBounds(90,20,250,30);//wzj add 2018-04-02
//		fah.setBounds(90,80,300,30);
//		famc.setBounds(90,140,150,30);
		
		//=================wzj add 2018-04-02  start
		ItemListener itemListener = new ItemListener() {   
		      public void itemStateChanged(ItemEvent itemEvent) {   
				if(itemEvent.getStateChange() == ItemEvent.SELECTED)
				             {
				                 String splxString=(String)splx.getSelectdItemValue();
				                 Object[] fahObjects=GetFah(splxString);
				                 fah.removeAllItems();
				                 if(fahObjects !=null){
					                 fah.addItems(fahObjects); 
				                 }
		
				             }
				}

		};   
		splx.addItemListener(itemListener);
		
//		ItemListener litemListener = new ItemListener() {   
//		      public void itemStateChanged(ItemEvent itemEvent) {   
//				if(itemEvent.getStateChange() == ItemEvent.SELECTED)
//				             {
//				                 String fahString=(String)fah.getSelectdItemValue();
//				                 famc.setValue(fahString);
//		
//				             }
//				}
//
//		};   
//		fah.addItemListener(litemListener);
		//=================wzj add 2018-04-02  end
		
		JLabel lfah = new JLabel("������:");
		JLabel lfamc = new JLabel("��������:");
		JLabel lsplx = new JLabel("��������:");//wzj add 2018-04-02
//		lsplx.setBounds(20,20,200,30);//wzj add 2018-04-02
//		lfah.setBounds(20,80,200,30);
//		lfamc.setBounds(20,140,200,30);

		UIButton btn = new UIButton("ȷ  ��");
//		btn.setBounds(200,0,40,20);
//		btn.setSize(20, 20);
		btn.setPreferredSize(new Dimension(100,40));
//		btn.setFont(new Font("����", Font.BOLD, 12));
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
//				if(!"".equals(fah.getValue()) && null != fah.getValue()){
				if(!"".equals(fah.getSelectdItemValue().toString()) && null != fah.getSelectdItemValue().toString()){
				
					try{
						//��ȡѡ�е�AggVO
						Object[] object = mymodel.getSelectedOperaDatas();
						//������Ҫ���µ�AggVO����
						AggNewoaspwhaHeadVO[] avo = new AggNewoaspwhaHeadVO[object.length];
						/*HashMap<String, AggNewoaspwhaHeadVO> map = new HashMap<>();
						for (Object aggNewoaspwhaHeadVO : object) {
							AggNewoaspwhaHeadVO vo = (AggNewoaspwhaHeadVO) aggNewoaspwhaHeadVO;
							map.put(vo.getParentVO().getPrimaryKey(), vo);
						}*/
						/*IQueryScheme queryScheme = QuerySchemaUtil.createQuerySchemeByFullClassName("nc.vo.pu.qst.newoaspwh.NewoaspwhaHeadVO");
						FromWhereSQL whereSQL = queryScheme.getTableJoinFromWhereSQL();
						((FromWhereSQLImpl)whereSQL).setWhere(whereSQL.getWhere());*/
						
						/*NCObject[] ncObjects = MDPersistenceService.lookupPersistenceQueryService()
								.queryBillOfNCObjectByPKs(NewoaspwhaHeadVO.class, map.keySet().toArray(new String[]{}),null,false);*/
//						return;
						for(int i=0 ; i<object.length; i++){
							AggNewoaspwhaHeadVO agg = (AggNewoaspwhaHeadVO)object[i];
							//������������-���밴�������²�ѯ���ݿ�
							NCObject[] ncObjects = MDPersistenceService.lookupPersistenceQueryService().queryBillOfNCObjectByCond
									(NewoaspwhaHeadVO.class,"pk_id_a='"+ agg.getParent().getPrimaryKey() +"'",false);
							agg = (AggNewoaspwhaHeadVO)ncObjects[0].getContainmentObject();
							//���ü�¼״̬Ϊ"�ύ"
							agg.getParent().setAttributeValue("approvestatus", BillStatusEnum.COMMIT.toIntValue());
//							agg.getParent().setAttributeValue("spfah", fah.getValue().toString());  //wzj note 2018-03-30
							agg.getParent().setAttributeValue("spfah", fah.getSelectdItemValue().toString());//wzj add 2018-04-02
							agg.getParent().setAttributeValue("spfamc", famc.getValue().toString());
							agg.getParent().setStatus(VOStatus.UPDATED);
							agg.setChildrenVO(bodyVoDelDR((NewoaspwhbBodyVO[])agg.getChildrenVO()));
							avo[i] = agg;
						}			

						//����Ŀ��VO-���͵�OA
						AggNewoaspwhaHeadVO oav = changeVos(avo);
						if(!"success".equals(sendToOa(oav))){
							MessageBox.showMessageDialog("OA����ʧ��", "�Է����񲻿��û������������쳣!");
							return;
						}
						//================wzj add 2018-04-04 start======================
						if("��������".equals(splx.getSelectdItemValue())){
							String fahString=fah.getSelectdItemValue().toString();
							AggCgfa[] CgfaTempVos=getCgfaVOByCond(fahString);
							if(CgfaTempVos !=null){
								AggCgfa cgfaVo=getCgfaVOByPk(CgfaTempVos[0].getPrimaryKey());
								cgfaVo.getParent().setAttributeValue("hdef1", "1");
								cgfaVo.getParent().setStatus(VOStatus.UPDATED);
								AggCgfa[] cgfaVos=new AggCgfa[]{cgfaVo};
	    						try {
	    							NCObject[] objs = new NCObject[cgfaVos.length];
	    							for(int i = 0; i<cgfaVos.length; i++){
	    								objs[i] = NCObject.newInstance(cgfaVos[i]);
	    							}
	    							MDPersistenceService.lookupPersistenceService().saveBill(objs);
	    				
	    						} catch (BusinessException ee) {
	    							throw new BusinessRuntimeException(ee.getMessage(), ee);
	    						}
							}
						}else  if("�۸�����".equals(splx.getSelectdItemValue())){
							String fahString=fah.getSelectdItemValue().toString();
							PriceAuditVO[] PriceTempVos=getPriceVOByCond(fahString);
							if(PriceTempVos !=null){
								PriceAuditVO PriceVo=getPriceVOByPk(PriceTempVos[0].getPrimaryKey());
								PriceVo.getParent().setAttributeValue("vdef16", "1");
								PriceVo.getParent().setStatus(VOStatus.UPDATED);
								PriceAuditVO[] priceVos=new PriceAuditVO[]{PriceVo};
	    						try {
	    							NCObject[] objs = new NCObject[priceVos.length];
	    							for(int i = 0; i<priceVos.length; i++){
	    								objs[i] = NCObject.newInstance(priceVos[i]);
	    							}
	    							MDPersistenceService.lookupPersistenceService().saveBill(objs);
	    				
	    						} catch (BusinessException eer1) {
	    							throw new BusinessRuntimeException(eer1.getMessage(), eer1);
	    						}
							}
						}
						
						//================wzj add 2018-04-04 end======================
						
						//���÷�����и���
						AceNewoaspwhMaintainProxy anm = new AceNewoaspwhMaintainProxy();
						anm.update(avo);
						MessageBox.showMessageDialog("��ʾ", "OA����������Ϣ���ͳɹ�!");
//						editor.setValue(avo);
						dataManager.refresh();
					}catch(Exception ex){
						ex.printStackTrace();
						MessageBox.showMessageDialog("ʧ��", "����ʧ��!,������ϸ:"+ ex.getMessage());
					}
					dia.setVisible(false);
					
				}else{
					MessageBox.showMessageDialog("��ʾ", "�����뷽����!");
				}
			}
		});
//		dia.setLayout(new FlowLayout());
		dia.setLayout(new BorderLayout(5, 5));
//		dia.setLayout(null);
		splx.setPreferredSize(new Dimension(150,20));
		fah.setPreferredSize(new Dimension(350,20));
		Panelpanel1.setLayout(new GridLayout(4,1,5,5));
		Panelpanel1.add(createPanelForGrid(new JComponent[] {lsplx,splx}));
		Panelpanel1.add(createPanelForGrid(new JComponent[] {lfah,fah}));
		Panelpanel1.add(createPanelForGrid(new JComponent[] {lfamc,famc}));
//		Panelpanel1.add(createPanelForGrid(new JComponent[] {btn}));
		Panelpanel2.add(btn);
		
//		Panelpanel3.setSize(dia.WIDTH, 1);
		dia.add(BorderLayout.NORTH,Panelpanel1);
		dia.add(BorderLayout.CENTER,Panelpanel2);
//		dia.add(BorderLayout.SOUTH,Panelpanel2);
//		dia.add(lsplx);
//		dia.add(splx);
//		dia.add(lfah);
//		dia.add(fah);
//		dia.add(lfamc);
//		dia.add(famc);
//
//		dia.add(BorderLayout.CENTER,btn);
		dia.setVisible(true);
		
	}
	
	//��ť�����߼�����,��ѡʱ:�ж��Ƿ����ύ�ļ�¼
	@Override
	protected boolean isActionEnable() {
		/*setMymodel();
		boolean bb = false;
		if (mymodel.getSelectedOperaDatas() != null) {
			boolean b = true;
			Object[] object = mymodel.getSelectedOperaDatas();
			for(int i = 0; i<object.length;i++){
				Integer fstatusflag = ApproveFlowUtil.getBillStatus(NCObject.newInstance(object[i]));
				b = b && tryMakeFlow(fstatusflag);
			}
			bb = b;
		}
		return bb;*/
		return true;
	}
	
	//�ж�OA�������Ƿ�Ϊͬһ��
	public boolean checkFqroa(Object[] objs){
		if(objs.length == 1) return true;
		String baseFqr="";
		for(int i = 0; i<objs.length ; i++){
			if(i==0){
				baseFqr=((AggNewoaspwhaHeadVO)objs[i]).getParent().getAttributeValue("fqroah").toString();
			}else{
				if(!baseFqr.equals(((AggNewoaspwhaHeadVO)objs[i]).getParent().getAttributeValue("fqroah").toString())){
					return false;
				}
			}
		}
		return true;
	}
	
	//����Ŀ��VO-���͸�OA
	public AggNewoaspwhaHeadVO changeVos (AggNewoaspwhaHeadVO[] avos){
		AggNewoaspwhaHeadVO ao = new AggNewoaspwhaHeadVO();
		ao.setParent(avos[0].getParent());
		List<NewoaspwhbBodyVO> lb = new ArrayList<NewoaspwhbBodyVO>();
		for(int i = 0;i<avos.length;i++){
			NewoaspwhbBodyVO[] nb = (NewoaspwhbBodyVO[])avos[i].getChildrenVO();
			//���ݶ����������������
			nb = changeSped(nb, Double.parseDouble(avos[i].getParent().getAttributeValue("sped").toString()));
			for(int j=0;j<nb.length;j++){
				lb = singleCpcj(lb, nb[j]);
			}
		}
		//��lb��������
		NewoaspwhbBodyVO[] lbv = lb.toArray(new NewoaspwhbBodyVO[lb.size()]);
		Arrays.sort(lbv, new Comparator<NewoaspwhbBodyVO>(){
			@Override
			public int compare(NewoaspwhbBodyVO paramT1,NewoaspwhbBodyVO paramT2) {
				Integer val = Integer.valueOf((String) paramT1.getAttributeValue("spcj"));
				Integer val2 = Integer.valueOf((String) paramT2.getAttributeValue("spcj"));
				return val.compareTo(val2);
			}});
		ao.setChildrenVO(lbv);
		return ao;
	}
	
	//����-��װ�ϲ�BodyVO
	public List<NewoaspwhbBodyVO> singleCpcj(List<NewoaspwhbBodyVO> lb,NewoaspwhbBodyVO bvo){
		boolean flag = false;
		List<NewoaspwhbBodyVO> lbb = new ArrayList<NewoaspwhbBodyVO>();
		for(NewoaspwhbBodyVO b : lb){
			String spcj = b.getAttributeValue("spcj").toString();
			if(spcj.equals(bvo.getAttributeValue("spcj").toString())){
				//�����Ϊnull�Ϳմ�
				if(null != b.getAttributeValue("sproah") && !"".equals(b.getAttributeValue("sproah").toString())){
					//�����������ƴ�ӵ�����
					if(b.getAttributeValue("sproah").toString().indexOf(bvo.getAttributeValue("sproah").toString()) == -1){
						b.setAttributeValue("sproah", b.getAttributeValue("sproah").toString() + ";" + bvo.getAttributeValue("sproah").toString());
					}
				}else{
					b.setAttributeValue("sproah", b.getAttributeValue("sproah").toString());
				}
				flag = true;
			}
			lbb.add(b);
		}
		if(!flag){
			lbb.add(bvo);
		}
		return lbb;
	} 
	
	//����������ȶ�Ӧ��OA������
	public NewoaspwhbBodyVO[] changeSped(NewoaspwhbBodyVO[] bvo,double sped){
		List<NewoaspwhbBodyVO> lbb = new ArrayList<NewoaspwhbBodyVO>();
		for(NewoaspwhbBodyVO b : bvo){
			//�������Ϊ�յĲ�������
			if(null == b.getAttributeValue("sped") || Double.parseDouble(b.getAttributeValue("spedxx").toString())==0 || "".equals(b.getAttributeValue("sped").toString()) || "0".equals(b.getAttributeValue("sped").toString())){
				
			}else{
				double l0 =Double.parseDouble(b.getAttributeValue("spedxx").toString());
				double l1 =Double.parseDouble(b.getAttributeValue("sped").toString());
				//����ڸ�����Ĳ�������
				if(l0 < sped && sped <= l1){
					
				}else{
					if(l1>sped){
						b.setAttributeValue("sproah", "");
					}
				}
			}
			lbb.add(b);
		}
		return lbb.toArray(new NewoaspwhbBodyVO[lbb.size()]);
	}
	
	//��vo���DR=1�ļ�¼
	public NewoaspwhbBodyVO[] bodyVoDelDR(NewoaspwhbBodyVO[] bvo){
		List<NewoaspwhbBodyVO> l = new ArrayList<NewoaspwhbBodyVO>();
		for(NewoaspwhbBodyVO bv : bvo){
			if(!"1".equals(bv.getAttributeValue("dr").toString())){
				l.add(bv);
			}
		}
		return l.toArray(new NewoaspwhbBodyVO[l.size()]);
	}
	
	//����OA
	public String sendToOa(AggNewoaspwhaHeadVO oav){
		GMCGFAOA_Service goas = new GMCGFAOA_Service();
		GMCGFAOA goa = goas.getDomino();
		ALLDATAINFO adf = new ALLDATAINFO();
		//�����������ͣ���OAϵͳ�ڴ��ݲ���
		//�������ͣ�1-��������,2-�۸�����,3-�ɹ�����ȷ��,4-�ɹ���Ϣȷ��,5-��һ��Դ����
		//�ƻ����ͣ�1-����,2-����,3-���,4-����,5-������6-ά��
		//2017-05-04�޸����Ӽ��ġ�����ķ������۸��������̲���
//		if((oav.getParent().getAttributeValue("splx").toString()).equals("2")){
//			adf.setGMTYPE("BBDB");//����������Ȧ�۸�����
//		}else{
//			adf.setGMTYPE("GMLS");//����������Ȧ��������
//		}
		//�ɹ��۸�����
		if((oav.getParent().getAttributeValue("splx").toString()).equals("2")){
			//�ƻ�����Ϊ���ġ�����ļ۸�������OA�ڴ���JGJC�������ƻ����ʹ���BBDB	
			if((oav.getParent().getAttributeValue("jhlx").toString()).equals("1") || (oav.getParent().getAttributeValue("jhlx").toString()).equals("2") ){
				adf.setGMTYPE("JGJC");//�ƻ�����Ϊ���ġ�����ļ۸�����	
			}else{
				adf.setGMTYPE("BBDB");//����������Ȧ�۸�����
			}
			if(oav.getParent().getAttributeValue("pk_scc").toString().equals("1001C0100000000SO5U8")){
				adf.setGMTYPE("DYLYCY");//�����۸�����
			}			
		//�ɹ���������
		}else if((oav.getParent().getAttributeValue("splx").toString()).equals("1")){
			//�ƻ�����Ϊ���ġ�����ķ���������OA�ڴ���JGJC�������ƻ����ʹ���GMLS
			if((oav.getParent().getAttributeValue("jhlx").toString()).equals("1") || (oav.getParent().getAttributeValue("jhlx").toString()).equals("2") ){
				adf.setGMTYPE("JGJC");//�ƻ�����Ϊ���ġ�����ķ�������	
			}else{
				adf.setGMTYPE("GMLS");//����������Ȧ��������
			}
			if(oav.getParent().getAttributeValue("pk_scc").toString().equals("1001C0100000000SO5U8")){
				adf.setGMTYPE("DYLYCY");//������������
			}
		}
		//
		adf.setGMPRONO(oav.getParent().getAttributeValue("spfah").toString());
		adf.setGMTITLE(oav.getParent().getAttributeValue("spfamc").toString());
		adf.setGMCREATER(oav.getParent().getAttributeValue("fqroah").toString());
		
		//=============wzj add 2018-04-02 start
		String spjg=GetSpjg(oav.getParent().getAttributeValue("spfah").toString());
		adf.setGMRESERVE1(spjg);
		//=============wzj add 2018-04-02 end

		List<APPROVEFLOWINFO> list = adf.getAPPROVEFLOWINFOOBJ();
		for(NewoaspwhbBodyVO b:(NewoaspwhbBodyVO[])oav.getChildrenVO()){
			APPROVEFLOWINFO a = new APPROVEFLOWINFO();
			a.setGMSPLEV(Integer.parseInt((String)b.getAttributeValue("spcj")));
			a.setGMAPPER((String)b.getAttributeValue("sproah"));
			list.add(a);
		}
		return goa.process(adf);
	}
	
	protected boolean tryMakeFlow(Integer fstatusflag) {
		return fstatusflag == null || BillStatusEnum.FREE.equalsValue(fstatusflag);
	}
	
	public void setEditor(ShowUpableBillForm editor) {
		this.editor = editor;
	}
	
	public void setDataManager(ModelDataManager dataManager) {
		this.dataManager = dataManager;
	}
	public void setMymodel() {
		this.mymodel = (BillManageModel)getModel();
	}
	

	//��ȡ�����������б��е�ֵ
	private Object[] GetFah(String splx) {
  
		  String sql="";
		  if("��������".equals(splx)){
			  sql="select billno from PU_CGFA where HDEF1 !='1' and dr=0 and bill_status='1' and HDEF2 !='Y' and TYPEBUY !='07' order by audittime desc";
		  }else if("�۸�����".equals(splx)){
			  sql="select VBILLCODE from PURP_PRICEAUDIT where VDEF16 !='1' and dr=0 and fbillstatus='3' and vdef6 !='Y' order by taudittime desc"; 
		  }
		
		  Object[] result=null;
		   
			try {
				 result= this.getSql(sql);
			} catch (BusinessException e) {
				e.printStackTrace();
			}

			return result;

	  }
	  
	//ͨ��sql��� ��ȡ�����������б������
	@SuppressWarnings("unused")
	private Object[] getSql(String sql) throws BusinessException {
		IUAPQueryBS uapQuery = (IUAPQueryBS) NCLocator.getInstance().lookup(nc.itf.uap.IUAPQueryBS.class);
		List<?> userList = (List<?>) uapQuery.executeQuery(sql, new ArrayListProcessor());
		if(userList.isEmpty()){
			return null;
		}else{
			Object[] obj=new Object[userList.size()+1];
			obj[0]="";
			for(int i=0;i<userList.size();i++){
				Object[] obj1=(Object[])userList.get(i);
				obj[i+1]=obj1[0];
			}
			return obj;
		}
		
	}	
	
	//��ȡ�������ֵ
	private String GetSpjg(String fah) {
 
		String sql="select sm_user.user_name,substr(to_char(nvl(pub_workflownote.dealdate,'1900-01-01')),1,10),nvl(pub_workflownote.checknote,' ') from pub_workflownote join sm_user on pub_workflownote.checkman=sm_user.cuserid where billno='"+fah +"' and actiontype!='BIZ' and Approvestatus !='4' order by dealdate"; 
	
		  String result=null;
		   
			try {
				 result= this.getSpjgSql(sql);
			} catch (BusinessException e) {
				e.printStackTrace();
			}

			return result;

	  }
	  
	//ͨ��sql��� ��ȡ���������
	@SuppressWarnings("unused")
	private String getSpjgSql(String sql) throws BusinessException {
		IUAPQueryBS uapQuery = (IUAPQueryBS) NCLocator.getInstance().lookup(nc.itf.uap.IUAPQueryBS.class);
		List<?> userList = (List<?>) uapQuery.executeQuery(sql, new ArrayListProcessor());
		if(userList.isEmpty()){
			return null;
		}else{
			Object[] obj=new Object[userList.size()];
			String spjgString="";
			for(int i=0;i<userList.size();i++){
				Object[] objj=(Object[])userList.get(i);
				if ("1900-01-01".equals(objj[1])){
					spjgString=spjgString+objj[0]+"  "+"  "+objj[2]+"<br>";
				}else{
					spjgString=spjgString+objj[0]+"  "+objj[1]+"  "+objj[2]+"<br>";
				}
				
			}
			return spjgString;
		}
		
	}
	
	
	private AggCgfa[] getCgfaVOByCond(String billno) {
		String sql;

		sql=" PU_CGFA.dr =0 and billno = '" + billno + "'";
		
		try {
			NCObject[] ncObjects = MDPersistenceService.lookupPersistenceQueryService().queryBillOfNCObjectByCond(Cgfa.class, sql, false);
			if (ncObjects == null) { return null; }
			AggCgfa[] aggCgfaVOs = new AggCgfa[ncObjects.length];
			for (int i = 0; i < ncObjects.length; i++) {
				aggCgfaVOs[i] = (AggCgfa) ncObjects[i].getContainmentObject();
			}
			return aggCgfaVOs;
		} catch (MetaDataException e) {
			throw new BusinessRuntimeException(e.getMessage(), e);
		}
	}
	
	private AggCgfa getCgfaVOByPk(String pk_cgfa) {

		try {
			NCObject ncObjects = MDPersistenceService.lookupPersistenceQueryService().queryBillOfNCObjectByPKWithDR(Cgfa.class, pk_cgfa, true);
			if (ncObjects == null) { return null; }
			AggCgfa CgfaHeadVOs= (AggCgfa) ncObjects.getContainmentObject();
			return CgfaHeadVOs;
		} catch (MetaDataException e) {
			throw new BusinessRuntimeException(e.getMessage(), e);
		}
	}
	
	private PriceAuditVO[] getPriceVOByCond(String billno) {
		String sql;

		sql=" PURP_PRICEAUDIT.dr =0 and vbillcode = '" + billno + "'";
		
		try {
			NCObject[] ncObjects = MDPersistenceService.lookupPersistenceQueryService().queryBillOfNCObjectByCond(PriceAuditHeaderVO.class, sql, false);
			if (ncObjects == null) { return null; }
			PriceAuditVO[] aggPriceVOs = new PriceAuditVO[ncObjects.length];
			for (int i = 0; i < ncObjects.length; i++) {
				aggPriceVOs[i] = (PriceAuditVO) ncObjects[i].getContainmentObject();
			}
			return aggPriceVOs;
		} catch (MetaDataException e) {
			throw new BusinessRuntimeException(e.getMessage(), e);
		}
	}
	
	private PriceAuditVO getPriceVOByPk(String pk_priceaudit) {

		try {
			NCObject ncObjects = MDPersistenceService.lookupPersistenceQueryService().queryBillOfNCObjectByPKWithDR(PriceAuditHeaderVO.class, pk_priceaudit, true);
			if (ncObjects == null) { return null; }
			PriceAuditVO PriceHeadVOs= (PriceAuditVO) ncObjects.getContainmentObject();
			return PriceHeadVOs;
		} catch (MetaDataException e) {
			throw new BusinessRuntimeException(e.getMessage(), e);
		}
	}
	
	private JPanel createPanelForGrid(JComponent[] allComponents) {

		JPanel theContentForNorthPanel=new JPanel();
		theContentForNorthPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		if(null !=allComponents && allComponents.length>0){
			for(JComponent component :allComponents){
				theContentForNorthPanel.add(component);
				
			}
		}
		return  theContentForNorthPanel; 
	}	
	
}