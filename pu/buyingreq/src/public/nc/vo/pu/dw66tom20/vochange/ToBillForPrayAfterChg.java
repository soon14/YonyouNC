package nc.vo.pu.dw66tom20.vochange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import nc.bs.framework.common.NCLocator;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.BeanProcessor;
import nc.vo.bd.material.MaterialVO;
import nc.vo.pf.change.ChangeVOAdjustContext;
import nc.vo.pf.change.IChangeVOAdjust;
import nc.vo.pu.m20.entity.PraybillItemVO;
import nc.vo.pu.m20.entity.PraybillVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;

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
		// ����ܲ 2018-05-16 ���Ӷ��ڵ����༭�������
		AggregatedValueObject[] srcVOs = new AggregatedValueObject[] { srcVO };
		AggregatedValueObject[] destVOs = new AggregatedValueObject[] { destVO };
		return this.batchAdjustAfterChange(srcVOs, destVOs, adjustContext)[0];
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
		IUAPQueryBS bs = NCLocator.getInstance().lookup(IUAPQueryBS.class);

		if (destVOs == null || destVOs.length == 0) {
			return destVOs;
		}

		PraybillVO newaggvo = new PraybillVO();
		newaggvo.setParentVO(destVOs[0].getParentVO());
		List<PraybillItemVO> newparbvos = new ArrayList<PraybillItemVO>();
		// ���ݰ��������Ҫ���ձ���Ĳɹ������ �Ͳɹ������к�������
		Arrays.sort(destVOs, new Comparator<AggregatedValueObject>() {

			@Override
			public int compare(AggregatedValueObject a1,
					AggregatedValueObject a2) {

				String banfn = (String) a1.getChildrenVO()[0]
						.getAttributeValue("banfn");
				String banfn2 = (String) a2.getChildrenVO()[0]
						.getAttributeValue("banfn");
				int result = banfn.compareTo(banfn2);
				if (result == 0) {

					String bnfpo = (String) a1.getChildrenVO()[0]
							.getAttributeValue("bnfpo");
					String bnfpo2 = (String) a2.getChildrenVO()[0]
							.getAttributeValue("bnfpo");
					return bnfpo.compareTo(bnfpo2);
				}
				return result;
			}
		});

		for (AggregatedValueObject aggvo : destVOs) {
			PraybillItemVO[] bvos = (PraybillItemVO[]) aggvo.getChildrenVO();
			for (PraybillItemVO bvo : bvos) {
				String wucode = bvo.getPk_material();// ���ϱ���
				String wuname = bvo.getMaterialname();// ��������
				String sqlmact = "select * from bd_material where code ='"
						+ wucode + "' and nvl(dr,0)=0 " + " and name='"
						+ wuname + "'";// ���ϵ���
				MaterialVO matervo = (MaterialVO) bs.executeQuery(sqlmact,
						new BeanProcessor(MaterialVO.class));
				if (matervo != null) {
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
				newparbvos.add(bvo);
			}

		}
		newaggvo.setChildrenVO(newparbvos.toArray(new PraybillItemVO[0]));
		return new AggregatedValueObject[] { newaggvo };
	}

}