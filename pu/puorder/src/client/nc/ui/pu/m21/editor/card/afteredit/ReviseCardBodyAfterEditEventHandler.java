package nc.ui.pu.m21.editor.card.afteredit;

import java.util.Map;

import nc.ui.pu.m21.editor.card.afteredit.body.ArriveStoreOrg;
import nc.ui.pu.m21.editor.card.afteredit.body.AssistUnit;
import nc.ui.pu.m21.editor.card.afteredit.body.BatchCode;
import nc.ui.pu.m21.editor.card.afteredit.body.Blargess;
import nc.ui.pu.m21.editor.card.afteredit.body.Customer;
import nc.ui.pu.m21.editor.card.afteredit.body.Material;
import nc.ui.pu.m21.editor.card.afteredit.body.QtUnit;
import nc.ui.pu.m21.editor.card.afteredit.body.ReceiveAddress;
import nc.ui.pu.m21.editor.card.afteredit.body.ReceiveWarehouse;
import nc.ui.pu.m21.editor.card.afteredit.body.RequestStoreOrg;
import nc.ui.pu.m21.editor.card.afteredit.body.SupplierAddrress;
import nc.ui.pu.pub.editor.card.afteredit.CProject;
import nc.ui.pu.pub.editor.card.handler.AbstractCardBodyAfterEditEventHandler;
import nc.ui.pu.pub.editor.card.listener.AbstractRelationCalculateListener;
import nc.ui.pu.pub.editor.card.listener.ICardBodyAfterEditEventListener;
import nc.vo.pu.m21.entity.OrderItemVO;
import nc.vo.pu.pub.enumeration.PuAttrNameEnum;

/**
 * <p>
 * <b>本类主要完成以下功能：</b>
 * <ul>
 * <li>采购订单修订卡片表体编辑后事件处理类
 * </ul>
 * <p>
 * <p>
 * 
 * @version 6.0
 * @since 6.0
 * @author wuxla
 * @time 2010-3-21 上午09:06:48
 */
public class ReviseCardBodyAfterEditEventHandler extends
    AbstractCardBodyAfterEditEventHandler {

  @Override
  public AbstractRelationCalculateListener getCalculateListener() {
    return null;
  }

  @Override
  public void registerEventListener(
      Map<String, ICardBodyAfterEditEventListener> listenerMap) {

    // 收货地址
    listenerMap.put(OrderItemVO.PK_RECEIVEADDRESS, new ReceiveAddress());

    // 供应商发货地址
    listenerMap.put(OrderItemVO.VVENDDEVADDR, new SupplierAddrress());

    // 收货仓库
    listenerMap.put(OrderItemVO.PK_RECVSTORDOC, new ReceiveWarehouse());

    // 是否赠品
    listenerMap.put(OrderItemVO.BLARGESS, new Blargess());

    // 物料
    listenerMap.put(OrderItemVO.PK_MATERIAL, new Material());

    // 需求库存组织编辑处理
    listenerMap.put(OrderItemVO.PK_REQSTOORG_V, new RequestStoreOrg());
    // 收货库存组织
    listenerMap.put(OrderItemVO.PK_ARRVSTOORG_V, new ArriveStoreOrg());

    // 业务单位的编辑后事件
    listenerMap.put(OrderItemVO.CASTUNITID, new AssistUnit());
    // 报价单位的编辑后事件
    listenerMap.put(OrderItemVO.CQTUNITID, new QtUnit());

    listenerMap.put(OrderItemVO.VBATCHCODE, new BatchCode());

    // 项目
    listenerMap.put(PuAttrNameEnum.cprojectid.name(), new CProject());

    // 客户编辑后事件
    listenerMap.put(OrderItemVO.CASSCUSTID, new Customer());

  }

}
