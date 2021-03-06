/**
 * $文件说明$
 * 
 * @author wanghuid
 * @version 6.0
 * @see
 * @since 6.0
 * @time 2010-9-2 上午10:40:14
 */
package nc.ui.pu.m21.service.onway;

import nc.vo.pu.m21.entity.OrderOnwayItemVO;
import nc.vo.pu.m21.rule.OnwayValidationTool;
import nc.vo.pu.m21transtype.entity.PoTransTypeVO;
import nc.vo.pu.pub.enumeration.OnwayStatusQryEnum;
import nc.vo.pub.BusinessException;

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
 * @author wanghuid
 * @time 2010-9-2 上午10:40:14
 */
public class OrderOutcustomValidationService extends
    AbstractOnwayValidationService {

  /**
   * 父类方法重写
   * 
   * @see nc.ui.pu.m21.service.onway.AbstractOnwayValidationService#docheck(nc.vo.pu.m21transtype.entity.PoTransTypeVO,
   *      nc.vo.pu.m21.entity.OrderOnwayItemVO[])
   */
  @Override
  void docheck(PoTransTypeVO transtypeVO, OrderOnwayItemVO[] voitems)
      throws BusinessException {

    OnwayValidationTool.chkEmptyForOnway(transtypeVO, voitems,
        PoTransTypeVO.BOUTCUSTOMCODE, PoTransTypeVO.BOUTCUSTOMDATE,
        OnwayStatusQryEnum.bisoutcustom.getName());

  }
}
