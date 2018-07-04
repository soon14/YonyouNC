package nc.ui.pu.m25.editor.card.afteredit.header;

import java.util.ArrayList;
import java.util.List;

import nc.itf.pu.pub.IPURemoteCallCombinator;
import nc.ui.pu.pub.editor.CardEditorHelper;
import nc.ui.pu.pub.editor.card.listener.ICardHeadTailAfterEditEventListener;
import nc.ui.pubapp.uif2app.event.card.CardHeadTailAfterEditEvent;
import nc.vo.pu.m25.entity.InvoiceItemVO;
import nc.vo.pu.pub.rule.BusitypeFillRule;
import nc.vo.pu.pub.util.AggVOUtil;
import nc.vo.scmpub.res.billtype.POBillType;

/**
 * �������ͱ༭��Ĵ���
 * <ul>
 * <li>ȷ������(����ȷ��,�������̵�һЩ�����������̼�麯�����޷����)
 * </ul>
 * 
 * @since 6.0
 * @version 2011-8-3 ����09:24:53
 * @author zhaoyha
 */
public class InvoiceTranstype implements ICardHeadTailAfterEditEventListener {

  @Override
  public void afterEdit(CardHeadTailAfterEditEvent event) {
    List<IPURemoteCallCombinator> rccRuleLst =
        new ArrayList<IPURemoteCallCombinator>();
    // ע��Զ�̵���
    this.registerRccRule(rccRuleLst, event);
    // ִ��Զ�̵���
    this.doRccRule(rccRuleLst);
  }

  private void doRccRule(List<IPURemoteCallCombinator> rccRuleLst) {
    for (IPURemoteCallCombinator rccRule : rccRuleLst) {
      if (null != rccRule) {
        rccRule.process();
      }
    }
  }

  private void regiest_bizRule(List<IPURemoteCallCombinator> rccRuleLst,
      CardHeadTailAfterEditEvent event) {
    CardEditorHelper billhelper =
        new CardEditorHelper(event.getBillCardPanel());
    // ֻ�����ƵĲ�ȷ������
    //��������ֱ�Ӹ�pk_busitypeû���⣬���Ǹ��ƹ��ܾͻ�������⣬Ϲ��
    /*if (AggVOUtil.isSelfMade(billhelper, InvoiceItemVO.CSOURCEID)) {
      BusitypeFillRule biz =
          new BusitypeFillRule(billhelper, POBillType.Invoice.getCode());
      biz.prepare();
      rccRuleLst.add(biz);
    }*/
  }

  private void registerRccRule(List<IPURemoteCallCombinator> rccRuleLst,
      CardHeadTailAfterEditEvent event) {
    // ֧������Զ�̵��ã�ȷ��ҵ�����̣�ע��
    this.regiest_bizRule(rccRuleLst, event);
  }

}