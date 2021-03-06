package nc.bs.pub.action;

import nc.bs.pub.compiler.AbstractCompiler2;
import nc.vo.pub.BusinessException;
import nc.vo.pub.compiler.PfParameterVO;
import nc.vo.uap.pf.PFBusinessException;

/**
 * 备注：到货单的送审 单据动作执行中的动态执行类的动态执行类。 创建日期：(2010-3-10)
 * 
 * @author 平台脚本生成
 */
public class N_23_SAVE extends AbstractCompiler2 {

  /**
   * N_23_SAVE 构造子注解。
   */
  public N_23_SAVE() {
    super();
  }

  /*
   * 备注：平台编写原始脚本
   */
  @Override
  public String getCodeRemark() {
    return "	Object retValue = null;\n      /*********************** 调用到货单的送审操作 不可修改 ******************/\n      nc.vo.pu.m23.entity.ArriveVO[] inObject = (nc.vo.pu.m23.entity.ArriveVO[]) getVos();\n      retValue = nc.bs.framework.common.NCLocator.getInstance().lookup(nc.itf.pu.m23.approve.IArriveApprove.class)\n          .sendArrive(inObject, this);\n      /***********************************************************************/\n      return retValue;\n";/* -=notranslate=- */
  }

  /*
   * 备注：平台编写规则类 接口执行类
   */
  @Override
  public Object runComClass(PfParameterVO vo) throws BusinessException {
    try {
      super.m_tmpVo = vo;
      Object retValue = null;
      /*********************** 调用到货单的送审操作 不可修改 ******************/
      nc.vo.pu.m23.entity.ArriveVO[] inObject =
        (nc.vo.pu.m23.entity.ArriveVO[]) this.getVos();
      retValue =
        nc.bs.framework.common.NCLocator.getInstance()
        .lookup(nc.itf.pu.m23.approve.IArriveApprove.class)
        .sendArrive(inObject, this);
      /***********************************************************************/
      return retValue;
    }
    catch (Exception ex) {
      if (ex instanceof BusinessException) {
        throw (BusinessException) ex;
      }
      throw new PFBusinessException(ex.getMessage(), ex);
    }
  }
}
