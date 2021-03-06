package nc.bs.pub.action;

import nc.bs.pub.compiler.AbstractCompiler2;
import nc.vo.pub.BusinessException;
import nc.vo.pub.compiler.PfParameterVO;
import nc.vo.uap.pf.PFBusinessException;

/**
 * 备注：请购单的弃审 单据动作执行中的动态执行类的动态执行类。 创建日期：(2010-2-2)
 * 
 * @author 平台脚本生成
 */
public class N_24_UNAPPROVE extends AbstractCompiler2 {

  /**
   * N_20_UNAPPROVE 构造子注解。
   */
  public N_24_UNAPPROVE() {
    super();
  }

  /*
   * 备注：平台编写原始脚本
   */
  @Override
  public String getCodeRemark() {
    return "	//####本脚本必须含有返回值,返回DLG和PNL的组件不允许有返回值####\n	Object retObj=null;\n nc.vo.pu.m24.entity.PricestlVO[] inObject = (nc.vo.pu.m24.entity.PricestlVO[]) getVos();\n          Object retValue =nc.bs.framework.common.NCLocator.getInstance().lookup(nc.itf.pu.m24.IPricestlApprove.class).unApprove(inObject, this);\n          return retValue;\n";/* -=notranslate=- */
  }

  /*
   * 备注：平台编写规则类 接口执行类
   */
  @Override
  public Object runComClass(PfParameterVO vo) throws BusinessException {
    try {
      super.m_tmpVo = vo;
      // ####本脚本必须含有返回值,返回DLG和PNL的组件不允许有返回值####

      nc.vo.pu.m24.entity.PricestlVO[] inObject =
        (nc.vo.pu.m24.entity.PricestlVO[]) this.getVos();
      Object retValue =
        nc.bs.framework.common.NCLocator.getInstance()
        .lookup(nc.itf.pu.m24.IPricestlApprove.class)
        .unApprove(inObject, this);
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
