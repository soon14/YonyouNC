package nc.ui.pu.qst.newoabase.action;

import nc.ui.pubapp.uif2app.actions.intf.ICopyActionProcessor;
import nc.vo.pub.BusinessException;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pu.qst.newoabase.AggNewoabaseaHeadVO;
import nc.vo.uif2.LoginContext;

public class CopyActionProcessor implements
		ICopyActionProcessor<AggNewoabaseaHeadVO> {

	@Override
	public void processVOAfterCopy(AggNewoabaseaHeadVO paramT,
			LoginContext paramLoginContext) {
		paramT.getParentVO().setPrimaryKey(null);
//		paramT.getParentVO().setModifier(null);
//    	paramT.getParentVO().setModifiedtime(null);
//    	paramT.getParentVO().setCreator(null);
//    	paramT.getParentVO().setCreationtime(null);		
//    	paramT.getParentVO().setBillno(null);
//    	paramT.getParentVO().setApprover(null);
//    	paramT.getParentVO().setApprovedate(null);
		//TODO 根据需要业务自己补充处理清空
		String[] codes =paramT.getTableCodes();
		if (codes != null && codes.length>0) {
			for (int i = 0; i < codes.length; i++) {
				String tableCode = codes[i];
				 CircularlyAccessibleValueObject[] childVOs = 	paramT.getTableVO(tableCode);
				 for (CircularlyAccessibleValueObject childVO : childVOs) {
					 try {
						childVO.setPrimaryKey(null);
					} catch (BusinessException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		}
	}
}
