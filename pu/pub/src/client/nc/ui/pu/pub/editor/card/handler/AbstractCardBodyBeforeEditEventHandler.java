package nc.ui.pu.pub.editor.card.handler;

import nc.ui.pu.pub.editor.card.listener.ICardBodyBeforeEditEventListener;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardBodyBeforeEditEvent;

/**
 * <p>
 * <b>����������༭�¼��Ĵ��������࣬������Ҫ������¹��ܣ�</b>
 * <ul>
 * <li>�����༭ǰ�¼�
 * </ul>
 * <p>
 * <p>
 * 
 * @version 6.0
 * @since 6.0
 * @author hanbin
 * @time 2010-1-24 ����05:00:09
 */
public abstract class AbstractCardBodyBeforeEditEventHandler
    extends
    AbstractCardEventHandler<ICardBodyBeforeEditEventListener, CardBodyBeforeEditEvent>
    implements IAppEventHandler<CardBodyBeforeEditEvent> {

  public AbstractCardBodyBeforeEditEventHandler() {
    super();
  }

  public void afterHandleEvent() {
    // ������Ը�д
  }

  public void beforeHandleEvent() {
    // ������Ը�д
  }

  @Override
  public void handleAppEvent(CardBodyBeforeEditEvent e) {
    this.setCardEditEvent(e);

    // ����ǵ�һ�δ����¼���ע���¼�������
    if (this.isFirstFlag()) {
      this.registerEventListener(this.getListenerMap());
      this.setFirstFlag(false);
    }

    if (e.getReturnValue() == null) {
      e.setReturnValue(Boolean.TRUE);
    }

    this.beforeHandleEvent();

    // û������,ֱ�ӷ���
    if (this.getEventListener(e) != null) {
      this.getEventListener(e).beforeEdit(e);
    }

    this.afterHandleEvent();
  }

  private ICardBodyBeforeEditEventListener getEventListener(
      CardBodyBeforeEditEvent e) {
    String itemKey = e.getKey();
    return this.getListenerMap().get(itemKey);
  }
}