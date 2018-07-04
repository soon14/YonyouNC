package nc.vo.pu.dw70tom20.vochange;

import java.util.ArrayList;
import java.util.List;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.bs.trade.business.HYPubBO;
import nc.itf.bd.material.baseinfo.IMaterialBaseInfoService;
import nc.itf.bd.material.measdoc.IMeasdocService;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.BeanProcessor;
import nc.pubitf.para.SysInitQuery;
import nc.ui.trade.business.HYPubBO_Client;
import nc.vo.bd.material.MaterialVO;
import nc.vo.bd.material.marbasclass.MarBasClassVO;
import nc.vo.bd.material.measdoc.MeasdocVO;
import nc.vo.lm.kycgjhxxjk.KycgjhxxjkHVO;
import nc.vo.pf.change.ChangeVOAdjustContext;
import nc.vo.pf.change.IChangeVOAdjust;
import nc.vo.pu.m20.entity.PraybillItemVO;
import nc.vo.pu.m20.entity.PraybillVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pub.para.SysInitVO;

public class ToBillForPrayAfterChg implements IChangeVOAdjust {

	@Override
	public AggregatedValueObject adjustBeforeChange(
			AggregatedValueObject srcVO, ChangeVOAdjustContext adjustContext)
			throws BusinessException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public AggregatedValueObject adjustAfterChange(AggregatedValueObject srcVO,
			AggregatedValueObject destVO, ChangeVOAdjustContext adjustContext)
			throws BusinessException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public AggregatedValueObject[] batchAdjustBeforeChange(
			AggregatedValueObject[] srcVOs, ChangeVOAdjustContext adjustContext)
			throws BusinessException {
		// TODO �Զ����ɵķ������
		return null;
	}

	/*
	 * 1. �����빺������Դ�����������м��������ϱ��룬������λ���ƣ���֯��
	 * 2.ͨ���м�������ϱ��룬������λ���ƣ������Ӧ����ص�����������ֵ���빺����Ӧ���ֶ�
	 */
	@Override
	public AggregatedValueObject[] batchAdjustAfterChange(
			AggregatedValueObject[] srcVOs, AggregatedValueObject[] destVOs,
			ChangeVOAdjustContext adjustContext) throws BusinessException {
		HYPubBO bo = new HYPubBO();
		IUAPQueryBS bs = NCLocator.getInstance().lookup(IUAPQueryBS.class);

		if (destVOs == null || destVOs.length == 0) {
			return destVOs;
		}
		PraybillVO newaggvo=new PraybillVO();
		List<PraybillItemVO>newparbvos=new ArrayList<PraybillItemVO>();
		for (AggregatedValueObject aggvo : destVOs) {
			PraybillVO outvo = (PraybillVO) aggvo;
			if (outvo == null || outvo.getChildrenVO().length == 0) {
				continue;
			}
			newaggvo.setParentVO(outvo.getParentVO());
			
			String pk_group = "0001N610000000000IT0";// ��֯������ֱ��д��
			String pk_org = "0001N610000000000IT0";
			PraybillItemVO[] bvos = (PraybillItemVO[]) aggvo.getChildrenVO();
			for (PraybillItemVO bvo:bvos) {
//				PraybillItemVO praybillItemVO = bvos[i];// �빺���ֱ�
				String srcid = bvo.getCfirstid();// ��Դ��������
				KycgjhxxjkHVO srchvo = (KycgjhxxjkHVO) bo.queryByPrimaryKey(
						KycgjhxxjkHVO.class, srcid);// ��Դ����VO
				String wucode = srchvo.getCode();// ��Դ�����ϱ���
				String sqlmact = "select * from bd_material where code ='"
						+ wucode + "' and nvl(dr,0)=0 ";// ���ϵ���
				MaterialVO matervo = (MaterialVO) bs.executeQuery(sqlmact,
						new BeanProcessor(MaterialVO.class));
				if (matervo != null) {
					bvo.setPk_material(matervo.getPk_material());// �빺������
					bvo.setPk_srcmaterial(matervo.getPk_material());// �빺��������Ϣ
					bvo.setCunitid(matervo.getPk_measdoc());// ������λ
					bvo.setCastunitid(matervo.getPk_measdoc());// ��λ
				} else {
					matervo = insertMaterial(srchvo, pk_org, pk_group);// ���ø������ϵ�������
					bvo.setPk_material(matervo.getPk_material());// �빺������
					bvo.setPk_srcmaterial(matervo.getPk_material());// �빺��������Ϣ
					bvo.setCunitid(matervo.getPk_measdoc());// ������λ
					bvo.setCastunitid(matervo.getPk_measdoc());// ��λ
				}
				int size = 0;
				if (newparbvos != null) {
					size = newparbvos.size();
				}
				bvo.setCrowno((size + 1) + "0");// ���¸�ֵ�к�
				newaggvo.setParentVO(outvo.getParentVO());
				newparbvos.add(bvo);
			}

		}
		newaggvo.setChildrenVO(newparbvos.toArray(new PraybillItemVO[0]));
		return new AggregatedValueObject[] { newaggvo };
//		return destVOs;
	}

	private MaterialVO insertMaterial(KycgjhxxjkHVO srchvo, String pk_org,
			String pk_group) throws BusinessException {
		HYPubBO bo = new HYPubBO();
		IMaterialBaseInfoService maservice = NCLocator.getInstance().lookup(
				IMaterialBaseInfoService.class);
//		String code = "99";// ȡ���룬���ݱ����ȡ���Ϸ���������99Ϊ��ʱ�ģ��Ⱥ�����ʽ��������ȷ�����ٽ��и���
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
		// maVO.setMaterialspec(srchvo.getMaterialspec());
		// �����ͺ�
		// maVO.setMaterialtype(srchvo.getMaterialspec());
		// ���Ϸ���
		String Pk_marbasclass = null;
		String code=this.getMarbasclasscode();
		MarBasClassVO[] classVO = (MarBasClassVO[])bo
				.queryByCondition(MarBasClassVO.class, " code='" + code + "'");
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
//				MeasdocVO.class, " name='" + srchvo.getCastunitid() + "'and code='" + srchvo.getCastunitid() + "'");
				MeasdocVO.class, " name='" + srchvo.getCastunitid() + "'");

		String pk_measdoc = null;
		if (measdocVOs != null && measdocVOs.length > 0) {
			pk_measdoc = measdocVOs[0].getPk_measdoc();
		} else {
			// �Զ�������������
			MeasdocVO measdocVO = new MeasdocVO();
			measdocVO.setCode(srchvo.getCastunitid());// ����
			measdocVO.setName(srchvo.getCastunitid());// ����
			measdocVO.setPk_group(pk_group);
			measdocVO.setPk_org("GLOBLE00000000000000");//ȫ����֯
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
		return maservice.insertMaterial(maVO);
	}
	
	/**
	 * 
	 * @author zjf
	 * ���ݲ���ֵ��ȡ���Ϸ������
	 */
	public String getMarbasclasscode(){
		SysInitVO initVO = null;
		String pk_org="GLOBLE00000000000000";//ȫ�ֲ�����֯����
		
		try {
			initVO = SysInitQuery.querySysinitVO(pk_org, "KSCGJH001");//��ȡҵ�������������֯�������������룩
		} catch (BusinessException e1) {
			Logger.error("��ɽ�ɹ��ƻ����ϻ������������ѯ�쳣��", e1);
		}
		String code =initVO.getValue();//��ȡ����ֵ(���Ϸ������)
		
		return code ;
		
	}

}