package nc.ui.pu.m20.action;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import nc.bs.framework.common.NCLocator;
import nc.itf.bd.material.assign.IMaterialAssignService;
import nc.itf.bd.material.baseinfo.IMaterialBaseInfoService;
import nc.itf.bd.material.measdoc.IMeasdocService;
import nc.itf.bd.material.stock.IMaterialStockService;
import nc.itf.uap.IUAPQueryBS;
import nc.itf.uap.pf.busiflow.PfButtonClickContext;
import nc.jdbc.framework.processor.ColumnListProcessor;
import nc.jdbc.framework.processor.ColumnProcessor;
import nc.md.model.MetaDataException;
import nc.md.persist.framework.IMDPersistenceQueryService;
import nc.md.persist.framework.MDPersistenceService;
import nc.pubitf.para.SysInitQuery;
import nc.ui.pub.pf.PfUtilClient;
import nc.ui.pubapp.uif2app.actions.AbstractReferenceAction;
import nc.ui.pubapp.uif2app.funcnode.trantype.TrantypeFuncUtils;
import nc.ui.trade.business.HYPubBO_Client;
import nc.ui.uif2.UIState;
import nc.ui.uif2.editor.IBillCardPanelEditor;
import nc.ui.uif2.model.AbstractAppModel;
import nc.vo.bd.material.MaterialVO;
import nc.vo.bd.material.cost.MaterialCostmodeVO;
import nc.vo.bd.material.marbasclass.MarBasClassVO;
import nc.vo.bd.material.measdoc.MeasdocVO;
import nc.vo.bd.material.stock.MaterialStockVO;
import nc.vo.lm.erpcgjhjk.ErpcgjhjkHVO;
import nc.vo.pu.m20.entity.PraybillVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pub.para.SysInitVO;
import nc.vo.pubapp.pattern.pub.SqlBuilder;

public class AddFromDW66Action extends AbstractReferenceAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IBillCardPanelEditor editor;
	
	String pk_group = "0001N610000000000IT0";// ��֯������ֱ��д��
	String pk_org = "0001N610000000000IT0";

	public AddFromDW66Action() {
		super();
		this.setBtnName("��ɽ�ɹ��ƻ�");
		this.setCode("dw66");
	}

	private AbstractAppModel model;

	public IBillCardPanelEditor getEditor() {
		return editor;
	}

	public void setEditor(IBillCardPanelEditor editor) {
		this.editor = editor;
	}

	public AbstractAppModel getModel() {
		return model;
	}

	public void setModel(AbstractAppModel model) {
		this.model = model;
	}

	@Override
	public void doAction(ActionEvent e) throws Exception {
		// �򿪴��������ε��ݵĴ���
		PfUtilClient.childButtonClickedNew(this.createPfButtonClickContext());
		// �жϵ�ǰ���ս����Ƿ������ر�
		if (PfUtilClient.isCloseOK()) {
			AggregatedValueObject[] srcVOs = PfUtilClient.getRetOldVos();
			List<String> maPkList = new ArrayList<String>();//����������������
			for(AggregatedValueObject aggvo:srcVOs){
				ErpcgjhjkHVO hvo = (ErpcgjhjkHVO) aggvo.getParentVO();
				String wucode = hvo.getCode();//���ϱ���
				String name = hvo.getName();//��������
				//�ж������Ƿ����
				if(!isHas(wucode,name)){
					MaterialVO returnVO = insertMaterial(hvo, pk_org, pk_group);// ���ø������ϵ�������
					String pk = returnVO.getPk_material();
					maPkList.add(pk);
				}
			}
			if(maPkList != null && maPkList.size()>0){
				//�Զ���������
				autoMaterialAssign(maPkList);

				//�Զ����óɱ���Ϣ���κ���
				autoEnableBatch(maPkList);
				
				//�Զ����ÿ����Ϣ���ι���
				autoEnableStock(maPkList);
			}
			
			PraybillVO[] vos = (PraybillVO[]) PfUtilClient.getRetVos();
			// ��ʾ��ת��������
			this.getTransferViewProcessor().processBillTransfer(vos);

		}

	}

	private PfButtonClickContext createPfButtonClickContext() {
		PfButtonClickContext context = new PfButtonClickContext();
		context.setParent(this.getModel().getContext().getEntranceUI());
		context.setSrcBillType(this.getSourceBillType());
		context.setPk_group(this.getModel().getContext().getPk_group());
		context.setUserId(this.getModel().getContext().getPk_loginUser());
		// ����ýڵ����ɽ������ͷ����ģ���ô�������Ӧ�ô��������ͣ����򴫵�������
		// ����ýڵ����ɽ������ͷ����ģ���ô�������Ӧ�ô��������ͣ����򴫵�������
		String vtrantype = TrantypeFuncUtils.getTrantype(this.getModel()
				.getContext());
		// if (StringUtil.isEmptyWithTrim(vtrantype)) {
		// context.setCurrBilltype(POBillType.PrayBill.getCode());
		// }
		// else {
		// }
		context.setCurrBilltype("20");
		context.setUserObj(null);
		context.setSrcBillId(null);
		context.setBusiTypes(this.getBusitypes());
		// ����Ĳ�����ԭ�����õķ����ж����漰��ֻ���������һ�����ṹ�����������������¼ӵĲ���
		// ���εĽ������ͼ���
		context.setTransTypes(this.getTranstypes());
		// ��־�ڽ�������Ŀ�Ľ������ͷ���ʱ������Ŀ�Ľ������͵����ݣ�������������ֵ��1�����ݽӿڶ��壩��
		// 2�������������ã���-1�������ݽ������ͷ��飩
		context.setClassifyMode(PfButtonClickContext.ClassifyByItfdef);
		return context;
	}

	@Override
	protected boolean isActionEnable() {
		return this.model.getUiState() == UIState.NOT_EDIT;
	}

	
	/**
	 *  �Զ����ÿ����Ϣ���ι���
	 * @author ljf
	 * @throws BusinessException 
	 */
	@SuppressWarnings("unchecked")
	private void autoEnableStock(List<String> maPkList) throws BusinessException {
		String orgsql = "select pk_org from org_orgs where pk_group <> pk_org and (orgtype43='Y' or isbusinessunit ='Y' or orgtype19='Y' ) and (enablestate = 2) and pk_group = '0001N610000000000IT0'";
		
		List<String> orglist = (List<String>) getQueryBS().executeQuery(orgsql, new ColumnListProcessor());
		if(orglist == null || orglist.size() == 0){
			return;
		}
		
		IMaterialStockService stockservice = NCLocator.getInstance().lookup(IMaterialStockService.class);
		
		SqlBuilder querysql = new SqlBuilder();
		querysql.append(MaterialStockVO.PK_MATERIAL, maPkList.toArray(new String[maPkList.size()]));
		List<MaterialStockVO> stockvolist = (List<MaterialStockVO>) getMDQueryService().queryBillOfVOByCond(MaterialStockVO.class, querysql.toString(), false);
		if(stockvolist == null || stockvolist.size() == 0){
			return;
		}
		
		for(int i = 0; i < stockvolist.size(); i++){
			MaterialStockVO stockvo = stockvolist.get(i);
			stockvo.setWholemanaflag(UFBoolean.TRUE);
		}
		
		stockservice.updateMaterialStockVOs(stockvolist.toArray(new MaterialStockVO[stockvolist.size()]));
	}
	
	private IMDPersistenceQueryService getMDQueryService() {
	    return MDPersistenceService.lookupPersistenceQueryService();
	 }

	/**
	 *  �Զ����óɱ���Ϣ���κ���
	 * @author ljf
	 * @throws MetaDataException 
	 */
	@SuppressWarnings("unchecked")
	private void autoEnableBatch(List<String> maPkList) throws BusinessException {
		SqlBuilder sql = new SqlBuilder();
		sql.append(MaterialCostmodeVO.PK_MATERIAL, maPkList.toArray(new String[maPkList.size()]));
		
		List<MaterialCostmodeVO> costmodevolist = (List<MaterialCostmodeVO>) getMDQueryService().queryBillOfVOByCond(MaterialCostmodeVO.class, sql.toString(), false);
		if(costmodevolist == null || costmodevolist.size() == 0){
			return;
		}
		
		for(int i = 0; i < costmodevolist.size(); i++){
			MaterialCostmodeVO costmodevo = costmodevolist.get(i);
			costmodevo.setBatchcost(UFBoolean.TRUE);
		}
		
		HYPubBO_Client.updateAry(costmodevolist.toArray(new MaterialCostmodeVO[costmodevolist.size()]));
	}
	
	/**
	 * �ж������Ƿ����
	 * @param name 
	 * @throws BusinessException 
	 */
	public Boolean isHas(String wucode, String name) throws BusinessException{
		String sqlmact = "select count(pk_material) from bd_material where code ='"+ wucode + "' and nvl(dr,0)=0 "+"and name='"+name+"'";// ���ϵ���
		int k = 0;
		k = (Integer)getQueryBS().executeQuery(sqlmact,new ColumnProcessor());
		if (k==0) {
			return false;
		}
		return true;
	}

	public MaterialVO insertMaterial(ErpcgjhjkHVO srchvo, String pk_group,
			String pk_org) throws BusinessException {
		HYPubBO_Client bo = new HYPubBO_Client();
		IMaterialBaseInfoService maservice = NCLocator.getInstance().lookup(
				IMaterialBaseInfoService.class);
		
		MaterialVO maVO = new MaterialVO();
		maVO.setPk_group(pk_group);
		maVO.setPk_org(pk_org);
		// Ĭ�ϳ�һ����˰��Ʒ����ʽ��δ֪
		maVO.setPk_mattaxes("1001Z01000000003W0WH");
		// ���Ӳɹ���
		maVO.setIselectrans(UFBoolean.FALSE);
		// ��Ʒ�ز���
		maVO.setProductfamily(UFBoolean.FALSE);
		// �������۲���
		maVO.setElectronicsale(UFBoolean.FALSE);
		// �������۲���
		maVO.setRetail(UFBoolean.FALSE);
		// ����״̬,������
		maVO.setEnablestate(2);
		// ����ݲ�
		maVO.setIntolerance(new UFDouble(0));
		// ����ݲ�
		maVO.setOuttolerance(new UFDouble(0));
		// ����ݲ�
		maVO.setOutcloselowerlimit(new UFDouble(0));
		// ��������
		maVO.setName(srchvo.getName());
		// ���Ϲ��
		maVO.setMaterialspec(srchvo.getMaterialspec());// materialspec
		// �����ͺ�
		maVO.setMaterialtype(srchvo.getMaterialspec());
		// ���Ϸ���
		String Pk_marbasclass = null;
		String code = this.getMarbasclasscode();// ���Ϸ������
		MarBasClassVO[] classVO = (MarBasClassVO[]) bo.queryByCondition(
				MarBasClassVO.class, " code='" + code + "'");
		Pk_marbasclass = classVO[0].getPk_marbasclass();
		maVO.setPk_marbasclass(Pk_marbasclass);
		// ���ϱ���
		if (srchvo.getCode() == null || srchvo.getCode().trim().length() == 0) {
			// �豸ϵͳû�����ϱ��룬�õ��ݺ���Ϊ���ϱ���
			maVO.setCode(srchvo.getBillno());
		} else {
			// ����ϵͳ
			maVO.setCode(srchvo.getCode());
		}
		// ���ϵ�λ
		MeasdocVO[] measdocVOs = (MeasdocVO[]) bo.queryByCondition(
		// MeasdocVO.class, " name='" + srchvo.getCastunitid() + "' and code='"
		// + srchvo.getCastunitid() + "'");
				MeasdocVO.class, " code='" + srchvo.getCastunitid() + "'");

		String pk_measdoc = null;
		if (measdocVOs != null && measdocVOs.length > 0) {
			pk_measdoc = measdocVOs[0].getPk_measdoc();
		} else {
			// �Զ�������������
			MeasdocVO measdocVO = new MeasdocVO();
			measdocVO.setCode(srchvo.getCastunitid());// ����
			measdocVO.setName(srchvo.getCastunitid());// ����
			measdocVO.setPk_group(pk_group);
			measdocVO.setPk_org("GLOBLE00000000000000");// ȫ����֯
			measdocVO.setOppdimen("E");// ��������
			measdocVO.setBasecodeflag(UFBoolean.FALSE);// �Ƿ�Ϊ������λ
			measdocVO.setBitnumber(4);// С��λ��
			IMeasdocService measdocSer = NCLocator.getInstance().lookup(
					IMeasdocService.class);
			measdocVO = measdocSer.insertMeasdocForPfxx(measdocVO);
			pk_measdoc = measdocVO.getPk_measdoc();
		}
		maVO.setPk_measdoc(pk_measdoc);
		// ������
		maVO.setIsfeature(UFBoolean.FALSE);
		// ���׼�
		maVO.setSetpartsflag(UFBoolean.FALSE);
		// ������
		maVO.setFee(UFBoolean.FALSE);
		// ������Ʒ
		maVO.setIshproitems(UFBoolean.FALSE);
		// �ۿۼ۸�
		maVO.setDiscountflag(UFBoolean.FALSE);
		// �Ƿ�����
		maVO.setLatest(UFBoolean.FALSE);
		// �Զ�׷�Ӹ�������λ
		// MaterialConvertVO conVO = new MaterialConvertVO();
		// // ������λͬ������
		// String main_measdocID = pk_measdoc;
		// conVO.setPk_measdoc(main_measdocID);
		// // ����������λ������Ϊ1/1
		// conVO.setMeasrate("1/1");
		// // Ĭ��Ϊ�̶�����
		// conVO.setFixedflag(UFBoolean.TRUE);
		// // �Զ�������и�����
		// conVO.setIsprodmeasdoc(UFBoolean.TRUE);
		// conVO.setIspumeasdoc(UFBoolean.TRUE);
		// conVO.setIsretailmeasdoc(UFBoolean.TRUE);
		// conVO.setIssalemeasdoc(UFBoolean.TRUE);
		// conVO.setIsstockmeasdoc(UFBoolean.TRUE);
		// ϵͳ����Ķ�û�и������������Զ����ӵ�Ҳ�����ø�����
		// maVO.setMaterialconvert(new MaterialConvertVO[]{conVO});
//		MaterialVO returnVO = maservice.insertMaterial(maVO);
		
		return maservice.insertMaterial(maVO);
	}

	/**
	 *  �Զ���������
	 * @author ljf
	 */
	@SuppressWarnings("unchecked")
	private void autoMaterialAssign(List<String> maPkList) throws BusinessException {
		String sql = "select pk_org from org_orgs where pk_group <> pk_org and (orgtype43='Y' or isbusinessunit ='Y' or orgtype19='Y' ) and (enablestate = 2) and pk_group = '0001N610000000000IT0'";
		
		List<String> orglist = (List<String>) getQueryBS().executeQuery(sql, new ColumnListProcessor());
		if(orglist == null || orglist.size() == 0){
			return;
		}
		getAssignService().assignMaterialByPks(maPkList.toArray(new String[maPkList.size()]), orglist.toArray(new String[orglist.size()]), null);
	}
	
	/**
	 * 
	 * @author zjf ���ݲ���ֵ��ȡ���Ϸ������
	 * @throws BusinessException 
	 */
	public String getMarbasclasscode() throws BusinessException {
		SysInitVO initVO = null;
		String pk_org = "GLOBLE00000000000000";// ȫ�ֲ�����֯����

		initVO = SysInitQuery.querySysinitVO(pk_org, "GFCGJH001");// ��ȡҵ�������������֯�������������룩
		String code = initVO.getValue();// ��ȡ����ֵ(���Ϸ������)

		return code;

	}
	
	private IMaterialAssignService getAssignService() {
	    return NCLocator.getInstance().lookup(IMaterialAssignService.class);
	}
	
	private IUAPQueryBS getQueryBS(){
		return NCLocator.getInstance().lookup(IUAPQueryBS.class);
	}
}