/***************************************************************
 * \ The skeleton of this class is generated by an automatic * code generator
 * for NC product. It is based on Velocity. * \
 ***************************************************************/
package nc.vo.pu.m25trantype.enumeration;

import nc.md.model.IEnumValue;
import nc.md.model.impl.MDEnum;
import nc.vo.pubapp.enumeration.NCMDEnum;

/**
 * ��Ӧ�����ƣ�0���ƥ�䡢1������
 * 
 * @author GGR
 * @time 2009-12-22 ����04:33:56
 * @since 6.0
 */
public class SendControlMode extends NCMDEnum {
  // ���ƥ��
  public static final SendControlMode MODE_ENTER_STORE_MATCH = MDEnum.valueOf(
      SendControlMode.class, Integer.valueOf(0));

  // ������
  public static final SendControlMode MODE_NO_CTRL = MDEnum.valueOf(
      SendControlMode.class, Integer.valueOf(1));

  /**
   * ������
   * 
   * @param enumvalue
   */
  public SendControlMode(IEnumValue enumvalue) {
    super(enumvalue);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}