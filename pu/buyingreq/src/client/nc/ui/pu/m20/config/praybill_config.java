package nc.ui.pu.m20.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.ui.uif2.factory.AbstractJavaBeanDefinition;

public class praybill_config extends AbstractJavaBeanDefinition {
	private Map<String, Object> context = new HashMap();

	public nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor getFormInterceptor() {
		if (context.get("formInterceptor") != null)
			return (nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor) context
					.get("formInterceptor");
		nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor bean = new nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor();
		context.put("formInterceptor", bean);
		bean.setShowUpComponent(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor getListInterceptor() {
		if (context.get("listInterceptor") != null)
			return (nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor) context
					.get("listInterceptor");
		nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor bean = new nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor();
		context.put("listInterceptor", bean);
		bean.setShowUpComponent(getListView());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.funcnode.ui.action.SeparatorAction getSeparatorAction() {
		if (context.get("separatorAction") != null)
			return (nc.funcnode.ui.action.SeparatorAction) context
					.get("separatorAction");
		nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
		context.put("separatorAction", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillAddAction getAddManualAction() {
		if (context.get("addManualAction") != null)
			return (nc.ui.pu.m20.action.PraybillAddAction) context
					.get("addManualAction");
		nc.ui.pu.m20.action.PraybillAddAction bean = new nc.ui.pu.m20.action.PraybillAddAction();
		context.put("addManualAction", bean);
		bean.setBtnName(getI18nFB_1a1da95());
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		bean.setInterceptor(getCompositeActionInterceptor_12f3528());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private java.lang.String getI18nFB_1a1da95() {
		if (context.get("nc.ui.uif2.I18nFB#1a1da95") != null)
			return (java.lang.String) context.get("nc.ui.uif2.I18nFB#1a1da95");
		nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
		context.put("&nc.ui.uif2.I18nFB#1a1da95", bean);
		bean.setResDir("common");
		bean.setResId("14004000-0000");
		bean.setDefaultValue("自制");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		try {
			Object product = bean.getObject();
			context.put("nc.ui.uif2.I18nFB#1a1da95", product);
			return (java.lang.String) product;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor getCompositeActionInterceptor_12f3528() {
		if (context
				.get("nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor#12f3528") != null)
			return (nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor) context
					.get("nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor#12f3528");
		nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor bean = new nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor();
		context.put(
				"nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor#12f3528",
				bean);
		bean.setInterceptors(getManagedList0());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList0() {
		List list = new ArrayList();
		list.add(getShowUpComponentInterceptor_1d04053());
		return list;
	}

	private nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor getShowUpComponentInterceptor_1d04053() {
		if (context
				.get("nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#1d04053") != null)
			return (nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor) context
					.get("nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#1d04053");
		nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor bean = new nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor();
		context.put(
				"nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#1d04053",
				bean);
		bean.setShowUpComponent(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.AddFrom422xAction getAddFrom422xAction() {
		if (context.get("addFrom422xAction") != null)
			return (nc.ui.pu.m20.action.AddFrom422xAction) context
					.get("addFrom422xAction");
		nc.ui.pu.m20.action.AddFrom422xAction bean = new nc.ui.pu.m20.action.AddFrom422xAction();
		context.put("addFrom422xAction", bean);
		bean.setSourceBillType("422X");
		bean.setSourceBillName(getI18nFB_4b03dc());
		bean.setFlowBillType(false);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		bean.setTransferViewProcessor(getTransferViewProcessor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private java.lang.String getI18nFB_4b03dc() {
		if (context.get("nc.ui.uif2.I18nFB#4b03dc") != null)
			return (java.lang.String) context.get("nc.ui.uif2.I18nFB#4b03dc");
		nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
		context.put("&nc.ui.uif2.I18nFB#4b03dc", bean);
		bean.setResDir("common");
		bean.setResId("14004000-0091");
		bean.setDefaultValue("物资需求申请单");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		try {
			Object product = bean.getObject();
			context.put("nc.ui.uif2.I18nFB#4b03dc", product);
			return (java.lang.String) product;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public nc.ui.pubapp.uif2app.actions.AddMenuAction getAddMenu() {
		if (context.get("addMenu") != null)
			return (nc.ui.pubapp.uif2app.actions.AddMenuAction) context
					.get("addMenu");
		nc.ui.pubapp.uif2app.actions.AddMenuAction bean = new nc.ui.pubapp.uif2app.actions.AddMenuAction();
		context.put("addMenu", bean);
		bean.setBillType("20");
		bean.setTooltip(getI18nFB_ea9e37());
		bean.setActions(getManagedList1());
		bean.setModel(getManageAppModel());
		bean.setPfAddInfoLoader(getPfAddInfoLoader());
		bean.initUI();
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private java.lang.String getI18nFB_ea9e37() {
		if (context.get("nc.ui.uif2.I18nFB#ea9e37") != null)
			return (java.lang.String) context.get("nc.ui.uif2.I18nFB#ea9e37");
		nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
		context.put("&nc.ui.uif2.I18nFB#ea9e37", bean);
		bean.setResDir("common");
		bean.setResId("04004000-0001");
		bean.setDefaultValue("新增业务数据(Ctrl+N)");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		try {
			Object product = bean.getObject();
			context.put("nc.ui.uif2.I18nFB#ea9e37", product);
			return (java.lang.String) product;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private List getManagedList1() {
		List list = new ArrayList();
		list.add(getAddManualAction());
		list.add(getSeparatorAction());
		list.add(getAddFrom422xAction());
		list.add(getSeparatorAction());
		list.add(getAddFromDW60Action());
		list.add(getAddFromDW70Action());
		list.add(getSeparatorAction());
		list.add(getAddFromDW66Action());
		return list;
	}

	public nc.ui.pu.m20.action.PraybillEditAction getEditAction() {
		if (context.get("editAction") != null)
			return (nc.ui.pu.m20.action.PraybillEditAction) context
					.get("editAction");
		nc.ui.pu.m20.action.PraybillEditAction bean = new nc.ui.pu.m20.action.PraybillEditAction();
		context.put("editAction", bean);
		bean.setModel(getManageAppModel());
		bean.setInterceptor(getShowUpComponentInterceptor_1392f66());
		bean.setPowercheck(true);
		bean.setPermissioncode("20");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor getShowUpComponentInterceptor_1392f66() {
		if (context
				.get("nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#1392f66") != null)
			return (nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor) context
					.get("nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#1392f66");
		nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor bean = new nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor();
		context.put(
				"nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#1392f66",
				bean);
		bean.setShowUpComponent(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PrayBillReviseInApprovingAction getReviseAction() {
		if (context.get("reviseAction") != null)
			return (nc.ui.pu.m20.action.PrayBillReviseInApprovingAction) context
					.get("reviseAction");
		nc.ui.pu.m20.action.PrayBillReviseInApprovingAction bean = new nc.ui.pu.m20.action.PrayBillReviseInApprovingAction();
		context.put("reviseAction", bean);
		bean.setModel(getManageAppModel());
		bean.setInterceptor(getShowUpComponentInterceptor_156f611());
		bean.setPowercheck(true);
		bean.setPermissioncode("20");
		bean.setBillForm(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor getShowUpComponentInterceptor_156f611() {
		if (context
				.get("nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#156f611") != null)
			return (nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor) context
					.get("nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#156f611");
		nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor bean = new nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor();
		context.put(
				"nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#156f611",
				bean);
		bean.setShowUpComponent(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillDeleteAction getDeleteAction() {
		if (context.get("deleteAction") != null)
			return (nc.ui.pu.m20.action.PraybillDeleteAction) context
					.get("deleteAction");
		nc.ui.pu.m20.action.PraybillDeleteAction bean = new nc.ui.pu.m20.action.PraybillDeleteAction();
		context.put("deleteAction", bean);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		bean.setActionName("DISCARD");
		bean.setBillType("20");
		bean.setValidationService(getPowerDeleteservice());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.pub.power.PowerValidateService getPowerDeleteservice() {
		if (context.get("powerDeleteservice") != null)
			return (nc.ui.pubapp.pub.power.PowerValidateService) context
					.get("powerDeleteservice");
		nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
		context.put("powerDeleteservice", bean);
		bean.setActionCode("delete");
		bean.setBillCodeFiledName("vbillcode");
		bean.setPermissionCode("20");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.actions.CopyAction getCopyAction() {
		if (context.get("copyAction") != null)
			return (nc.ui.pubapp.uif2app.actions.CopyAction) context
					.get("copyAction");
		nc.ui.pubapp.uif2app.actions.CopyAction bean = new nc.ui.pubapp.uif2app.actions.CopyAction();
		context.put("copyAction", bean);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		bean.setCopyActionProcessor(getCopyActionProcessor());
		bean.setInterceptor(getFormInterceptor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.CopyActionProcessor getCopyActionProcessor() {
		if (context.get("copyActionProcessor") != null)
			return (nc.ui.pu.m20.action.CopyActionProcessor) context
					.get("copyActionProcessor");
		nc.ui.pu.m20.action.CopyActionProcessor bean = new nc.ui.pu.m20.action.CopyActionProcessor();
		context.put("copyActionProcessor", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.query.PraybillQueryDLGInitializer getPraybillQryDLGInitializer() {
		if (context.get("praybillQryDLGInitializer") != null)
			return (nc.ui.pu.m20.query.PraybillQueryDLGInitializer) context
					.get("praybillQryDLGInitializer");
		nc.ui.pu.m20.query.PraybillQueryDLGInitializer bean = new nc.ui.pu.m20.query.PraybillQueryDLGInitializer();
		context.put("praybillQryDLGInitializer", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.query2.action.DefaultQueryAction getQueryAction() {
		if (context.get("queryAction") != null)
			return (nc.ui.pubapp.uif2app.query2.action.DefaultQueryAction) context
					.get("queryAction");
		nc.ui.pubapp.uif2app.query2.action.DefaultQueryAction bean = new nc.ui.pubapp.uif2app.query2.action.DefaultQueryAction();
		context.put("queryAction", bean);
		bean.setDataManager(getModelDataManager());
		bean.setQryCondDLGInitializer(getPraybillQryDLGInitializer());
		bean.setModel(getManageAppModel());
		bean.setShowUpComponent(getListView());
		bean.setTemplateContainer(getQueryTemplateContainer());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.query2.action.DefaultRefreshAction getRefreshAction() {
		if (context.get("refreshAction") != null)
			return (nc.ui.pubapp.uif2app.query2.action.DefaultRefreshAction) context
					.get("refreshAction");
		nc.ui.pubapp.uif2app.query2.action.DefaultRefreshAction bean = new nc.ui.pubapp.uif2app.query2.action.DefaultRefreshAction();
		context.put("refreshAction", bean);
		bean.setDataManager(getModelDataManager());
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.actions.RefreshSingleAction getCardRefreshAction() {
		if (context.get("cardRefreshAction") != null)
			return (nc.ui.pubapp.uif2app.actions.RefreshSingleAction) context
					.get("cardRefreshAction");
		nc.ui.pubapp.uif2app.actions.RefreshSingleAction bean = new nc.ui.pubapp.uif2app.actions.RefreshSingleAction();
		context.put("cardRefreshAction", bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillSaveAction getSaveAction() {
		if (context.get("saveAction") != null)
			return (nc.ui.pu.m20.action.PraybillSaveAction) context
					.get("saveAction");
		nc.ui.pu.m20.action.PraybillSaveAction bean = new nc.ui.pu.m20.action.PraybillSaveAction();
		context.put("saveAction", bean);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		bean.setActionName("SAVEBASE");
		bean.setBillType("20");
		bean.setValidationService(getValidateService());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.validation.CompositeValidation getValidateService() {
		if (context.get("validateService") != null)
			return (nc.ui.pubapp.uif2app.validation.CompositeValidation) context
					.get("validateService");
		nc.ui.pubapp.uif2app.validation.CompositeValidation bean = new nc.ui.pubapp.uif2app.validation.CompositeValidation();
		context.put("validateService", bean);
		bean.setValidators(getManagedList2());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList2() {
		List list = new ArrayList();
		list.add(getPowervalidservice());
		return list;
	}

	public nc.ui.pubapp.pub.power.PowerSaveValidateService getPowervalidservice() {
		if (context.get("powervalidservice") != null)
			return (nc.ui.pubapp.pub.power.PowerSaveValidateService) context
					.get("powervalidservice");
		nc.ui.pubapp.pub.power.PowerSaveValidateService bean = new nc.ui.pubapp.pub.power.PowerSaveValidateService();
		context.put("powervalidservice", bean);
		bean.setEditActionCode("edit");
		bean.setBillCodeFiledName("vbillcode");
		bean.setPermissionCode("20");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.actions.CancelAction getCancelAction() {
		if (context.get("cancelAction") != null)
			return (nc.ui.pubapp.uif2app.actions.CancelAction) context
					.get("cancelAction");
		nc.ui.pubapp.uif2app.actions.CancelAction bean = new nc.ui.pubapp.uif2app.actions.CancelAction();
		context.put("cancelAction", bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillSendApproveAction getSendApproveAction() {
		if (context.get("sendApproveAction") != null)
			return (nc.ui.pu.m20.action.PraybillSendApproveAction) context
					.get("sendApproveAction");
		nc.ui.pu.m20.action.PraybillSendApproveAction bean = new nc.ui.pu.m20.action.PraybillSendApproveAction();
		context.put("sendApproveAction", bean);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		bean.setPreActionNames(getManagedList3());
		bean.setActionName("SAVE");
		bean.setBillType("20");
		bean.setFilledUpInFlow(true);
		bean.setValidationService(getSendpowervalidservice());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList3() {
		List list = new ArrayList();
		list.add("SAVEBASE");
		return list;
	}

	public nc.ui.pubapp.uif2app.actions.pflow.SaveAndCommitScriptAction getSaveApproveAction() {
		if (context.get("saveApproveAction") != null)
			return (nc.ui.pubapp.uif2app.actions.pflow.SaveAndCommitScriptAction) context
					.get("saveApproveAction");
		nc.ui.pubapp.uif2app.actions.pflow.SaveAndCommitScriptAction bean = new nc.ui.pubapp.uif2app.actions.pflow.SaveAndCommitScriptAction(
				getSaveAction(), getSendApproveAction());
		context.put("saveApproveAction", bean);
		bean.setModel(getManageAppModel());
		bean.setBtnName(getI18nFB_1d83ce7());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private java.lang.String getI18nFB_1d83ce7() {
		if (context.get("nc.ui.uif2.I18nFB#1d83ce7") != null)
			return (java.lang.String) context.get("nc.ui.uif2.I18nFB#1d83ce7");
		nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
		context.put("&nc.ui.uif2.I18nFB#1d83ce7", bean);
		bean.setResDir("common");
		bean.setResId("2SCMPUB-000027");
		bean.setDefaultValue("保存提交");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		try {
			Object product = bean.getObject();
			context.put("nc.ui.uif2.I18nFB#1d83ce7", product);
			return (java.lang.String) product;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public nc.ui.pu.pub.action.UnSaveScriptAction getUnSendApproveAction() {
		if (context.get("unSendApproveAction") != null)
			return (nc.ui.pu.pub.action.UnSaveScriptAction) context
					.get("unSendApproveAction");
		nc.ui.pu.pub.action.UnSaveScriptAction bean = new nc.ui.pu.pub.action.UnSaveScriptAction();
		context.put("unSendApproveAction", bean);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		bean.setActionName("UNSAVEBILL");
		bean.setBillType("20");
		bean.setFilledUpInFlow(true);
		bean.setValidationService(getUnsendpowervalidservice());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.pub.power.PowerValidateService getSendpowervalidservice() {
		if (context.get("sendpowervalidservice") != null)
			return (nc.ui.pubapp.pub.power.PowerValidateService) context
					.get("sendpowervalidservice");
		nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
		context.put("sendpowervalidservice", bean);
		bean.setActionCode("commit");
		bean.setBillCodeFiledName("vbillcode");
		bean.setPermissionCode("20");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.pub.power.PowerValidateService getUnsendpowervalidservice() {
		if (context.get("unsendpowervalidservice") != null)
			return (nc.ui.pubapp.pub.power.PowerValidateService) context
					.get("unsendpowervalidservice");
		nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
		context.put("unsendpowervalidservice", bean);
		bean.setActionCode("uncommit");
		bean.setBillCodeFiledName("vbillcode");
		bean.setPermissionCode("20");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.funcnode.ui.action.GroupAction getSendApproveMenuAction() {
		if (context.get("sendApproveMenuAction") != null)
			return (nc.funcnode.ui.action.GroupAction) context
					.get("sendApproveMenuAction");
		nc.funcnode.ui.action.GroupAction bean = new nc.funcnode.ui.action.GroupAction();
		context.put("sendApproveMenuAction", bean);
		bean.setCode("sendApproveMenuAction");
		bean.setActions(getManagedList4());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList4() {
		List list = new ArrayList();
		list.add(getSendApproveAction());
		list.add(getUnSendApproveAction());
		return list;
	}

	public nc.ui.pu.m20.action.PraybillApproveAction getApproveAction() {
		if (context.get("approveAction") != null)
			return (nc.ui.pu.m20.action.PraybillApproveAction) context
					.get("approveAction");
		nc.ui.pu.m20.action.PraybillApproveAction bean = new nc.ui.pu.m20.action.PraybillApproveAction();
		context.put("approveAction", bean);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		bean.setFilledUpInFlow(false);
		bean.setActionName("APPROVE");
		bean.setBillType("20");
		bean.setValidationService(getPowerApproveService());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.pub.power.PowerValidateService getPowerApproveService() {
		if (context.get("powerApproveService") != null)
			return (nc.ui.pubapp.pub.power.PowerValidateService) context
					.get("powerApproveService");
		nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
		context.put("powerApproveService", bean);
		bean.setActionCode("approve");
		bean.setBillCodeFiledName("vbillcode");
		bean.setPermissionCode("20");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillUnApproveAction getUnApproveAction() {
		if (context.get("unApproveAction") != null)
			return (nc.ui.pu.m20.action.PraybillUnApproveAction) context
					.get("unApproveAction");
		nc.ui.pu.m20.action.PraybillUnApproveAction bean = new nc.ui.pu.m20.action.PraybillUnApproveAction();
		context.put("unApproveAction", bean);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		bean.setFilledUpInFlow(false);
		bean.setActionName("UNAPPROVE");
		bean.setBillType("20");
		bean.setValidationService(getPowerUNApproveService());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.pub.power.PowerValidateService getPowerUNApproveService() {
		if (context.get("powerUNApproveService") != null)
			return (nc.ui.pubapp.pub.power.PowerValidateService) context
					.get("powerUNApproveService");
		nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
		context.put("powerUNApproveService", bean);
		bean.setActionCode("unapprove");
		bean.setBillCodeFiledName("vbillcode");
		bean.setPermissionCode("20");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.funcnode.ui.action.GroupAction getAuditMenuAction() {
		if (context.get("auditMenuAction") != null)
			return (nc.funcnode.ui.action.GroupAction) context
					.get("auditMenuAction");
		nc.funcnode.ui.action.GroupAction bean = new nc.funcnode.ui.action.GroupAction();
		context.put("auditMenuAction", bean);
		bean.setCode("auditMenuAction");
		bean.setActions(getManagedList5());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList5() {
		List list = new ArrayList();
		list.add(getApproveAction());
		list.add(getUnApproveAction());
		list.add(getSeparatorAction_1867620());
		list.add(getApproveStatusAction());
		return list;
	}

	private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1867620() {
		if (context.get("nc.funcnode.ui.action.SeparatorAction#1867620") != null)
			return (nc.funcnode.ui.action.SeparatorAction) context
					.get("nc.funcnode.ui.action.SeparatorAction#1867620");
		nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
		context.put("nc.funcnode.ui.action.SeparatorAction#1867620", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillCloseAction getCloseAction() {
		if (context.get("closeAction") != null)
			return (nc.ui.pu.m20.action.PraybillCloseAction) context
					.get("closeAction");
		nc.ui.pu.m20.action.PraybillCloseAction bean = new nc.ui.pu.m20.action.PraybillCloseAction();
		context.put("closeAction", bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillOpenAction getOpenAction() {
		if (context.get("openAction") != null)
			return (nc.ui.pu.m20.action.PraybillOpenAction) context
					.get("openAction");
		nc.ui.pu.m20.action.PraybillOpenAction bean = new nc.ui.pu.m20.action.PraybillOpenAction();
		context.put("openAction", bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillCloseLineAction getRowCloseAction() {
		if (context.get("rowCloseAction") != null)
			return (nc.ui.pu.m20.action.PraybillCloseLineAction) context
					.get("rowCloseAction");
		nc.ui.pu.m20.action.PraybillCloseLineAction bean = new nc.ui.pu.m20.action.PraybillCloseLineAction();
		context.put("rowCloseAction", bean);
		bean.setModel(getManageAppModel());
		bean.setBillForm(getBillFormEditor());
		bean.setList(getListView());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillOpenLineAction getRowOpenAction() {
		if (context.get("rowOpenAction") != null)
			return (nc.ui.pu.m20.action.PraybillOpenLineAction) context
					.get("rowOpenAction");
		nc.ui.pu.m20.action.PraybillOpenLineAction bean = new nc.ui.pu.m20.action.PraybillOpenLineAction();
		context.put("rowOpenAction", bean);
		bean.setModel(getManageAppModel());
		bean.setBillForm(getBillFormEditor());
		bean.setList(getListView());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.actions.FileDocManageAction getAccessoriesAction() {
		if (context.get("accessoriesAction") != null)
			return (nc.ui.pubapp.uif2app.actions.FileDocManageAction) context
					.get("accessoriesAction");
		nc.ui.pubapp.uif2app.actions.FileDocManageAction bean = new nc.ui.pubapp.uif2app.actions.FileDocManageAction();
		context.put("accessoriesAction", bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillAssistAction getAssistMenuAction() {
		if (context.get("assistMenuAction") != null)
			return (nc.ui.pu.m20.action.PraybillAssistAction) context
					.get("assistMenuAction");
		nc.ui.pu.m20.action.PraybillAssistAction bean = new nc.ui.pu.m20.action.PraybillAssistAction();
		context.put("assistMenuAction", bean);
		bean.setActions(getManagedList6());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList6() {
		List list = new ArrayList();
		list.add(getCloseAction());
		list.add(getOpenAction());
		list.add(getRowCloseAction());
		list.add(getRowOpenAction());
		list.add(getSeparatorAction_b562f2());
		list.add(getAccessoriesAction());
		return list;
	}

	private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_b562f2() {
		if (context.get("nc.funcnode.ui.action.SeparatorAction#b562f2") != null)
			return (nc.funcnode.ui.action.SeparatorAction) context
					.get("nc.funcnode.ui.action.SeparatorAction#b562f2");
		nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
		context.put("nc.funcnode.ui.action.SeparatorAction#b562f2", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.pub.action.PULinkQueryAction getLinkQueryAction() {
		if (context.get("linkQueryAction") != null)
			return (nc.ui.pu.pub.action.PULinkQueryAction) context
					.get("linkQueryAction");
		nc.ui.pu.pub.action.PULinkQueryAction bean = new nc.ui.pu.pub.action.PULinkQueryAction();
		context.put("linkQueryAction", bean);
		bean.setModel(getManageAppModel());
		bean.setBillType("20");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillATPAction getATPAction() {
		if (context.get("ATPAction") != null)
			return (nc.ui.pu.m20.action.PraybillATPAction) context
					.get("ATPAction");
		nc.ui.pu.m20.action.PraybillATPAction bean = new nc.ui.pu.m20.action.PraybillATPAction();
		context.put("ATPAction", bean);
		bean.setModel(getManageAppModel());
		bean.setBillForm(getBillFormEditor());
		bean.setList(getListView());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillPriceAction getPriceAction() {
		if (context.get("priceAction") != null)
			return (nc.ui.pu.m20.action.PraybillPriceAction) context
					.get("priceAction");
		nc.ui.pu.m20.action.PraybillPriceAction bean = new nc.ui.pu.m20.action.PraybillPriceAction();
		context.put("priceAction", bean);
		bean.setContext(getContext());
		bean.setModel(getManageAppModel());
		bean.setNodeKey("40040200PRICE");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.pub.action.QueryOnhandAction getATPQueryAction() {
		if (context.get("ATPQueryAction") != null)
			return (nc.ui.pu.pub.action.QueryOnhandAction) context
					.get("ATPQueryAction");
		nc.ui.pu.pub.action.QueryOnhandAction bean = new nc.ui.pu.pub.action.QueryOnhandAction();
		context.put("ATPQueryAction", bean);
		bean.setModel(getManageAppModel());
		bean.setForm(getBillFormEditor());
		bean.setList(getListView());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.actions.pflow.PFApproveStatusInfoAction getApproveStatusAction() {
		if (context.get("approveStatusAction") != null)
			return (nc.ui.pubapp.uif2app.actions.pflow.PFApproveStatusInfoAction) context
					.get("approveStatusAction");
		nc.ui.pubapp.uif2app.actions.pflow.PFApproveStatusInfoAction bean = new nc.ui.pubapp.uif2app.actions.pflow.PFApproveStatusInfoAction();
		context.put("approveStatusAction", bean);
		bean.setModel(getManageAppModel());
		bean.setBtnName(getI18nFB_732e71());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private java.lang.String getI18nFB_732e71() {
		if (context.get("nc.ui.uif2.I18nFB#732e71") != null)
			return (java.lang.String) context.get("nc.ui.uif2.I18nFB#732e71");
		nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
		context.put("&nc.ui.uif2.I18nFB#732e71", bean);
		bean.setResDir("4001002_0");
		bean.setResId("04001002-0579");
		bean.setDefaultValue("查看审批意见");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		try {
			Object product = bean.getObject();
			context.put("nc.ui.uif2.I18nFB#732e71", product);
			return (java.lang.String) product;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public nc.ui.pu.m20.action.PraybillLinkQueryMppAction getLinkMppAction() {
		if (context.get("linkMppAction") != null)
			return (nc.ui.pu.m20.action.PraybillLinkQueryMppAction) context
					.get("linkMppAction");
		nc.ui.pu.m20.action.PraybillLinkQueryMppAction bean = new nc.ui.pu.m20.action.PraybillLinkQueryMppAction();
		context.put("linkMppAction", bean);
		bean.setModel(getManageAppModel());
		bean.setBillForm(getBillFormEditor());
		bean.setList(getListView());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillLinkQueryMenuAction getLinkQueryMenuAction() {
		if (context.get("linkQueryMenuAction") != null)
			return (nc.ui.pu.m20.action.PraybillLinkQueryMenuAction) context
					.get("linkQueryMenuAction");
		nc.ui.pu.m20.action.PraybillLinkQueryMenuAction bean = new nc.ui.pu.m20.action.PraybillLinkQueryMenuAction();
		context.put("linkQueryMenuAction", bean);
		bean.setActions(getManagedList7());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList7() {
		List list = new ArrayList();
		list.add(getLinkQueryAction());
		list.add(getLinkMppAction());
		list.add(getATPAction());
		list.add(getPriceAction());
		list.add(getATPQueryAction());
		return list;
	}

	public nc.ui.pu.m20.action.PraybillLinkQueryMenuAction getEditLinkQueryMenuAction() {
		if (context.get("editLinkQueryMenuAction") != null)
			return (nc.ui.pu.m20.action.PraybillLinkQueryMenuAction) context
					.get("editLinkQueryMenuAction");
		nc.ui.pu.m20.action.PraybillLinkQueryMenuAction bean = new nc.ui.pu.m20.action.PraybillLinkQueryMenuAction();
		context.put("editLinkQueryMenuAction", bean);
		bean.setActions(getManagedList8());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList8() {
		List list = new ArrayList();
		list.add(getATPAction());
		list.add(getATPQueryAction());
		return list;
	}

	public nc.ui.pu.m20.action.processor.PraybillPrintProcessor getPrintProcessor() {
		if (context.get("printProcessor") != null)
			return (nc.ui.pu.m20.action.processor.PraybillPrintProcessor) context
					.get("printProcessor");
		nc.ui.pu.m20.action.processor.PraybillPrintProcessor bean = new nc.ui.pu.m20.action.processor.PraybillPrintProcessor();
		context.put("printProcessor", bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction getPreviewAction() {
		if (context.get("previewAction") != null)
			return (nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction) context
					.get("previewAction");
		nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction bean = new nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction();
		context.put("previewAction", bean);
		bean.setModel(getManageAppModel());
		bean.setNodeKey("4004020002");
		bean.setPreview(true);
		bean.setBeforePrintDataProcess(getPrintProcessor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction getPrintAction() {
		if (context.get("printAction") != null)
			return (nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction) context
					.get("printAction");
		nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction bean = new nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction();
		context.put("printAction", bean);
		bean.setModel(getManageAppModel());
		bean.setNodeKey("4004020002");
		bean.setPreview(false);
		bean.setBeforePrintDataProcess(getPrintProcessor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.actions.OutputAction getOutputAction() {
		if (context.get("outputAction") != null)
			return (nc.ui.pubapp.uif2app.actions.OutputAction) context
					.get("outputAction");
		nc.ui.pubapp.uif2app.actions.OutputAction bean = new nc.ui.pubapp.uif2app.actions.OutputAction();
		context.put("outputAction", bean);
		bean.setNodeKey("4004020002");
		bean.setModel(getManageAppModel());
		bean.setParent(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.PraybillCombineShowAction getCombineShowAction() {
		if (context.get("combineShowAction") != null)
			return (nc.ui.pu.m20.action.PraybillCombineShowAction) context
					.get("combineShowAction");
		nc.ui.pu.m20.action.PraybillCombineShowAction bean = new nc.ui.pu.m20.action.PraybillCombineShowAction();
		context.put("combineShowAction", bean);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.scmpub.action.SCMPrintCountQueryAction getPrintCountQueryAction() {
		if (context.get("printCountQueryAction") != null)
			return (nc.ui.scmpub.action.SCMPrintCountQueryAction) context
					.get("printCountQueryAction");
		nc.ui.scmpub.action.SCMPrintCountQueryAction bean = new nc.ui.scmpub.action.SCMPrintCountQueryAction();
		context.put("printCountQueryAction", bean);
		bean.setModel(getManageAppModel());
		bean.setBilldateFieldName("dbilldate");
		bean.setBillType("20");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.funcnode.ui.action.GroupAction getPraybillPrintMenuAction() {
		if (context.get("praybillPrintMenuAction") != null)
			return (nc.funcnode.ui.action.GroupAction) context
					.get("praybillPrintMenuAction");
		nc.funcnode.ui.action.GroupAction bean = new nc.funcnode.ui.action.GroupAction();
		context.put("praybillPrintMenuAction", bean);
		bean.setCode("printMenuAction");
		bean.setActions(getManagedList9());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList9() {
		List list = new ArrayList();
		list.add(getPrintAction());
		list.add(getPreviewAction());
		list.add(getOutputAction());
		list.add(getPrintCountQueryAction());
		list.add(getSeparatorAction_1ee290e());
		list.add(getCombineShowAction());
		return list;
	}

	private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1ee290e() {
		if (context.get("nc.funcnode.ui.action.SeparatorAction#1ee290e") != null)
			return (nc.funcnode.ui.action.SeparatorAction) context
					.get("nc.funcnode.ui.action.SeparatorAction#1ee290e");
		nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
		context.put("nc.funcnode.ui.action.SeparatorAction#1ee290e", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.uif2.actions.ActionContributors getToftpanelActionContributors() {
		if (context.get("toftpanelActionContributors") != null)
			return (nc.ui.uif2.actions.ActionContributors) context
					.get("toftpanelActionContributors");
		nc.ui.uif2.actions.ActionContributors bean = new nc.ui.uif2.actions.ActionContributors();
		context.put("toftpanelActionContributors", bean);
		bean.setContributors(getManagedList10());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList10() {
		List list = new ArrayList();
		list.add(getActionsOfList());
		list.add(getActionsOfCard());
		return list;
	}

	public nc.ui.uif2.actions.StandAloneToftPanelActionContainer getActionsOfList() {
		if (context.get("actionsOfList") != null)
			return (nc.ui.uif2.actions.StandAloneToftPanelActionContainer) context
					.get("actionsOfList");
		nc.ui.uif2.actions.StandAloneToftPanelActionContainer bean = new nc.ui.uif2.actions.StandAloneToftPanelActionContainer(
				getListView());
		context.put("actionsOfList", bean);
		bean.setActions(getManagedList11());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList11() {
		List list = new ArrayList();
		list.add(getAddMenu());
		list.add(getEditAction());
		list.add(getReviseAction());
		list.add(getDeleteAction());
		list.add(getCopyAction());
		list.add(getSeparatorAction());
		list.add(getQueryAction());
		list.add(getRefreshAction());
		list.add(getSeparatorAction());
		list.add(getSendApproveMenuAction());
		list.add(getAuditMenuAction());
		list.add(getAssistMenuAction());
		list.add(getSeparatorAction());
		list.add(getLinkQueryMenuAction());
		list.add(getSeparatorAction());
		list.add(getSeparatorAction());
		list.add(getPraybillPrintMenuAction());
		list.add(getSeparatorAction());
		list.add(getExcelImportAndExportActiongroup());
		return list;
	}

	public nc.ui.uif2.actions.StandAloneToftPanelActionContainer getActionsOfCard() {
		if (context.get("actionsOfCard") != null)
			return (nc.ui.uif2.actions.StandAloneToftPanelActionContainer) context
					.get("actionsOfCard");
		nc.ui.uif2.actions.StandAloneToftPanelActionContainer bean = new nc.ui.uif2.actions.StandAloneToftPanelActionContainer(
				getBillFormEditor());
		context.put("actionsOfCard", bean);
		bean.setModel(getManageAppModel());
		bean.setActions(getManagedList12());
		bean.setEditActions(getManagedList13());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList12() {
		List list = new ArrayList();
		list.add(getAddMenu());
		list.add(getEditAction());
		list.add(getReviseAction());
		list.add(getDeleteAction());
		list.add(getCopyAction());
		list.add(getSeparatorAction());
		list.add(getQueryAction());
		list.add(getCardRefreshAction());
		list.add(getSeparatorAction());
		list.add(getSendApproveMenuAction());
		list.add(getAuditMenuAction());
		list.add(getAssistMenuAction());
		list.add(getSeparatorAction());
		list.add(getLinkQueryMenuAction());
		list.add(getSeparatorAction());
		list.add(getSeparatorAction());
		list.add(getPraybillPrintMenuAction());
		list.add(getSeparatorAction());
		list.add(getIMAction());
		list.add(getSeparatorAction());
		list.add(getExcelImportAndExportActiongroup());
		list.add(getSeparatorAction());
		list.add(getRefuseAction());
		list.add(getUNrefuseAction());
		return list;
	}

	private List getManagedList13() {
		List list = new ArrayList();
		list.add(getSaveAction());
		list.add(getSaveApproveAction());
		list.add(getSeparatorAction());
		list.add(getCancelAction());
		list.add(getSeparatorAction());
		list.add(getEditLinkQueryMenuAction());
		list.add(getSeparatorAction());
		list.add(getAddFromDW66LineAction());
		return list;
	}

	public nc.ui.uif2.actions.IMGroupChatAction getIMAction() {
		if (context.get("IMAction") != null)
			return (nc.ui.uif2.actions.IMGroupChatAction) context
					.get("IMAction");
		nc.ui.uif2.actions.IMGroupChatAction bean = new nc.ui.uif2.actions.IMGroupChatAction();
		context.put("IMAction", bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.funcnode.ui.action.GroupAction getExcelImportAndExportActiongroup() {
		if (context.get("excelImportAndExportActiongroup") != null)
			return (nc.funcnode.ui.action.GroupAction) context
					.get("excelImportAndExportActiongroup");
		nc.funcnode.ui.action.GroupAction bean = new nc.funcnode.ui.action.GroupAction();
		context.put("excelImportAndExportActiongroup", bean);
		bean.setCode("importActionActiongroup");
		bean.setName("导入导出");
		bean.setActions(getManagedList14());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList14() {
		List list = new ArrayList();
		list.add(getImportAction());
		list.add(getExportAction());
		list.add(getExportTemplateAction());
		return list;
	}

	public nc.ui.pu.m20.action.ImportableEditorFor20 getImportableEditor() {
		if (context.get("importableEditor") != null)
			return (nc.ui.pu.m20.action.ImportableEditorFor20) context
					.get("importableEditor");
		nc.ui.pu.m20.action.ImportableEditorFor20 bean = new nc.ui.pu.m20.action.ImportableEditorFor20();
		context.put("importableEditor", bean);
		bean.setBillcardPanelEditor(getBillFormEditor());
		bean.setAppModel(getManageAppModel());
		bean.setAddAction(getAddManualAction());
		bean.setSaveAction(getSaveAction());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.ImportActionFor20 getImportAction() {
		if (context.get("importAction") != null)
			return (nc.ui.pu.m20.action.ImportActionFor20) context
					.get("importAction");
		nc.ui.pu.m20.action.ImportActionFor20 bean = new nc.ui.pu.m20.action.ImportActionFor20();
		context.put("importAction", bean);
		bean.setModel(getManageAppModel());
		bean.setImportableEditor(getImportableEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.ExportActionFor20 getExportAction() {
		if (context.get("exportAction") != null)
			return (nc.ui.pu.m20.action.ExportActionFor20) context
					.get("exportAction");
		nc.ui.pu.m20.action.ExportActionFor20 bean = new nc.ui.pu.m20.action.ExportActionFor20();
		context.put("exportAction", bean);
		bean.setModel(getManageAppModel());
		bean.setImportableEditor(getImportableEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.ExportBillTemplateActionFor20 getExportTemplateAction() {
		if (context.get("exportTemplateAction") != null)
			return (nc.ui.pu.m20.action.ExportBillTemplateActionFor20) context
					.get("exportTemplateAction");
		nc.ui.pu.m20.action.ExportBillTemplateActionFor20 bean = new nc.ui.pu.m20.action.ExportBillTemplateActionFor20();
		context.put("exportTemplateAction", bean);
		bean.setModel(getManageAppModel());
		bean.setImportableEditor(getImportableEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.AddFromDW60Action2 getAddFromDW60Action() {
		if (context.get("AddFromDW60Action") != null)
			return (nc.ui.pu.m20.action.AddFromDW60Action2) context
					.get("AddFromDW60Action");
		nc.ui.pu.m20.action.AddFromDW60Action2 bean = new nc.ui.pu.m20.action.AddFromDW60Action2();
		context.put("AddFromDW60Action", bean);
		bean.setSourceBillType("DW60");
		bean.setSourceBillName("攀钢采购计划");
		bean.setFlowBillType(false);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		bean.setTransferViewProcessor(getTransferViewProcessor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.AddFromDW70Action getAddFromDW70Action() {
		if (context.get("AddFromDW70Action") != null)
			return (nc.ui.pu.m20.action.AddFromDW70Action) context
					.get("AddFromDW70Action");
		nc.ui.pu.m20.action.AddFromDW70Action bean = new nc.ui.pu.m20.action.AddFromDW70Action();
		context.put("AddFromDW70Action", bean);
		bean.setSourceBillType("DW70");
		bean.setSourceBillName("矿山采购计划");
		bean.setFlowBillType(false);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		bean.setTransferViewProcessor(getTransferViewProcessor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.AddFromDW66Action getAddFromDW66Action() {
		if (context.get("AddFromDW66Action") != null)
			return (nc.ui.pu.m20.action.AddFromDW66Action) context
					.get("AddFromDW66Action");
		nc.ui.pu.m20.action.AddFromDW66Action bean = new nc.ui.pu.m20.action.AddFromDW66Action();
		context.put("AddFromDW66Action", bean);
		bean.setSourceBillType("DW66");
		bean.setSourceBillName("股份采购计划");
		bean.setFlowBillType(false);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		bean.setTransferViewProcessor(getTransferViewProcessor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.RefuseAction getRefuseAction() {
		if (context.get("refuseAction") != null)
			return (nc.ui.pu.m20.action.RefuseAction) context
					.get("refuseAction");
		nc.ui.pu.m20.action.RefuseAction bean = new nc.ui.pu.m20.action.RefuseAction();
		context.put("refuseAction", bean);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.UnRefuseAction getUNrefuseAction() {
		if (context.get("UNrefuseAction") != null)
			return (nc.ui.pu.m20.action.UnRefuseAction) context
					.get("UNrefuseAction");
		nc.ui.pu.m20.action.UnRefuseAction bean = new nc.ui.pu.m20.action.UnRefuseAction();
		context.put("UNrefuseAction", bean);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.AddFromDW66LineAction getAddFromDW66LineAction() {
		if (context.get("AddFromDW66LineAction") != null)
			return (nc.ui.pu.m20.action.AddFromDW66LineAction) context
					.get("AddFromDW66LineAction");
		nc.ui.pu.m20.action.AddFromDW66LineAction bean = new nc.ui.pu.m20.action.AddFromDW66LineAction();
		context.put("AddFromDW66LineAction", bean);
		bean.setSourceBillType("DW66");
		bean.setSourceBillName("参照股份采购计划行");
		bean.setFlowBillType(false);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		bean.setTransferViewProcessor(getTransferViewProcessor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.uif2.ReviseInAppoveActionProcesser getReviseActionProcesser() {
		if (context.get("reviseActionProcesser") != null)
			return (nc.ui.pu.uif2.ReviseInAppoveActionProcesser) context
					.get("reviseActionProcesser");
		nc.ui.pu.uif2.ReviseInAppoveActionProcesser bean = new nc.ui.pu.uif2.ReviseInAppoveActionProcesser();
		context.put("reviseActionProcesser", bean);
		bean.setActionContributor(getToftpanelActionContributors());
		bean.setReviseAction(getReviseAction());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.view.CardPanelOrgSetterForAllRefMediator getCardPanelOrgSetterForAllRefMediator_0() {
		if (context
				.get("nc.ui.pubapp.uif2app.view.CardPanelOrgSetterForAllRefMediator#0") != null)
			return (nc.ui.pubapp.uif2app.view.CardPanelOrgSetterForAllRefMediator) context
					.get("nc.ui.pubapp.uif2app.view.CardPanelOrgSetterForAllRefMediator#0");
		nc.ui.pubapp.uif2app.view.CardPanelOrgSetterForAllRefMediator bean = new nc.ui.pubapp.uif2app.view.CardPanelOrgSetterForAllRefMediator(
				getBillFormEditor());
		context.put(
				"nc.ui.pubapp.uif2app.view.CardPanelOrgSetterForAllRefMediator#0",
				bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.model.AppEventHandlerMediator getAppEventHandlerMediator() {
		if (context.get("appEventHandlerMediator") != null)
			return (nc.ui.pubapp.uif2app.model.AppEventHandlerMediator) context
					.get("appEventHandlerMediator");
		nc.ui.pubapp.uif2app.model.AppEventHandlerMediator bean = new nc.ui.pubapp.uif2app.model.AppEventHandlerMediator();
		context.put("appEventHandlerMediator", bean);
		bean.setModel(getManageAppModel());
		bean.setHandlerMap(getManagedMap0());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private Map getManagedMap0() {
		Map map = new HashMap();
		map.put("nc.ui.pubapp.uif2app.event.OrgChangedEvent",
				getManagedList15());
		map.put("nc.ui.pubapp.uif2app.event.card.CardHeadTailBeforeEditEvent",
				getManagedList16());
		map.put("nc.ui.pubapp.uif2app.event.card.CardHeadTailAfterEditEvent",
				getManagedList17());
		map.put("nc.ui.pubapp.uif2app.event.list.ListHeadRowChangedEvent",
				getManagedList18());
		map.put("nc.ui.pubapp.uif2app.event.card.CardBodyBeforeEditEvent",
				getManagedList19());
		map.put("nc.ui.pubapp.uif2app.event.card.CardBodyAfterEditEvent",
				getManagedList20());
		map.put("nc.ui.uif2.AppEvent", getManagedList21());
		map.put("nc.ui.pubapp.uif2app.event.card.CardPanelLoadEvent",
				getManagedList22());
		return map;
	}

	private List getManagedList15() {
		List list = new ArrayList();
		list.add(getOrgChgEventHandler_19d2b2f());
		return list;
	}

	private nc.ui.pu.m20.editor.org.OrgChgEventHandler getOrgChgEventHandler_19d2b2f() {
		if (context.get("nc.ui.pu.m20.editor.org.OrgChgEventHandler#19d2b2f") != null)
			return (nc.ui.pu.m20.editor.org.OrgChgEventHandler) context
					.get("nc.ui.pu.m20.editor.org.OrgChgEventHandler#19d2b2f");
		nc.ui.pu.m20.editor.org.OrgChgEventHandler bean = new nc.ui.pu.m20.editor.org.OrgChgEventHandler();
		context.put("nc.ui.pu.m20.editor.org.OrgChgEventHandler#19d2b2f", bean);
		bean.setCardForm(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList16() {
		List list = new ArrayList();
		list.add(getHanderBeforeEditHandler_17e4ec7());
		return list;
	}

	private nc.ui.pu.m20.editor.card.beforeedit.HanderBeforeEditHandler getHanderBeforeEditHandler_17e4ec7() {
		if (context
				.get("nc.ui.pu.m20.editor.card.beforeedit.HanderBeforeEditHandler#17e4ec7") != null)
			return (nc.ui.pu.m20.editor.card.beforeedit.HanderBeforeEditHandler) context
					.get("nc.ui.pu.m20.editor.card.beforeedit.HanderBeforeEditHandler#17e4ec7");
		nc.ui.pu.m20.editor.card.beforeedit.HanderBeforeEditHandler bean = new nc.ui.pu.m20.editor.card.beforeedit.HanderBeforeEditHandler();
		context.put(
				"nc.ui.pu.m20.editor.card.beforeedit.HanderBeforeEditHandler#17e4ec7",
				bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList17() {
		List list = new ArrayList();
		list.add(getHanderAfterEditHandler_1660433());
		return list;
	}

	private nc.ui.pu.m20.editor.card.afteredit.HanderAfterEditHandler getHanderAfterEditHandler_1660433() {
		if (context
				.get("nc.ui.pu.m20.editor.card.afteredit.HanderAfterEditHandler#1660433") != null)
			return (nc.ui.pu.m20.editor.card.afteredit.HanderAfterEditHandler) context
					.get("nc.ui.pu.m20.editor.card.afteredit.HanderAfterEditHandler#1660433");
		nc.ui.pu.m20.editor.card.afteredit.HanderAfterEditHandler bean = new nc.ui.pu.m20.editor.card.afteredit.HanderAfterEditHandler();
		context.put(
				"nc.ui.pu.m20.editor.card.afteredit.HanderAfterEditHandler#1660433",
				bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList18() {
		List list = new ArrayList();
		list.add(getHeadRowChangeHandler_9ddf26());
		return list;
	}

	private nc.ui.pu.m20.editor.list.HeadRowChangeHandler getHeadRowChangeHandler_9ddf26() {
		if (context.get("nc.ui.pu.m20.editor.list.HeadRowChangeHandler#9ddf26") != null)
			return (nc.ui.pu.m20.editor.list.HeadRowChangeHandler) context
					.get("nc.ui.pu.m20.editor.list.HeadRowChangeHandler#9ddf26");
		nc.ui.pu.m20.editor.list.HeadRowChangeHandler bean = new nc.ui.pu.m20.editor.list.HeadRowChangeHandler();
		context.put("nc.ui.pu.m20.editor.list.HeadRowChangeHandler#9ddf26",
				bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList19() {
		List list = new ArrayList();
		list.add(getBodyBeforeEditHandler_a53b2e());
		return list;
	}

	private nc.ui.pu.m20.editor.card.beforeedit.BodyBeforeEditHandler getBodyBeforeEditHandler_a53b2e() {
		if (context
				.get("nc.ui.pu.m20.editor.card.beforeedit.BodyBeforeEditHandler#a53b2e") != null)
			return (nc.ui.pu.m20.editor.card.beforeedit.BodyBeforeEditHandler) context
					.get("nc.ui.pu.m20.editor.card.beforeedit.BodyBeforeEditHandler#a53b2e");
		nc.ui.pu.m20.editor.card.beforeedit.BodyBeforeEditHandler bean = new nc.ui.pu.m20.editor.card.beforeedit.BodyBeforeEditHandler();
		context.put(
				"nc.ui.pu.m20.editor.card.beforeedit.BodyBeforeEditHandler#a53b2e",
				bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList20() {
		List list = new ArrayList();
		list.add(getBodyAfterEditHandler_1d07da7());
		return list;
	}

	private nc.ui.pu.m20.editor.card.afteredit.BodyAfterEditHandler getBodyAfterEditHandler_1d07da7() {
		if (context
				.get("nc.ui.pu.m20.editor.card.afteredit.BodyAfterEditHandler#1d07da7") != null)
			return (nc.ui.pu.m20.editor.card.afteredit.BodyAfterEditHandler) context
					.get("nc.ui.pu.m20.editor.card.afteredit.BodyAfterEditHandler#1d07da7");
		nc.ui.pu.m20.editor.card.afteredit.BodyAfterEditHandler bean = new nc.ui.pu.m20.editor.card.afteredit.BodyAfterEditHandler();
		context.put(
				"nc.ui.pu.m20.editor.card.afteredit.BodyAfterEditHandler#1d07da7",
				bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList21() {
		List list = new ArrayList();
		list.add(getReviseActionProcesser());
		return list;
	}

	private List getManagedList22() {
		List list = new ArrayList();
		list.add(getScmCardLoadhandler());
		return list;
	}

	public nc.ui.scmpub.listener.ScmCardItemsFillableHandler getScmCardLoadhandler() {
		if (context.get("scmCardLoadhandler") != null)
			return (nc.ui.scmpub.listener.ScmCardItemsFillableHandler) context
					.get("scmCardLoadhandler");
		nc.ui.scmpub.listener.ScmCardItemsFillableHandler bean = new nc.ui.scmpub.listener.ScmCardItemsFillableHandler();
		context.put("scmCardLoadhandler", bean);
		bean.setEnabledItems(getManagedMap1());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private Map getManagedMap1() {
		Map map = new HashMap();
		map.put("pk_praybill_b", getManagedList23());
		return map;
	}

	private List getManagedList23() {
		List list = new ArrayList();
		list.add("ycg");
		list.add("rating_life");
		return list;
	}

	public nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener getInitDataListener() {
		if (context.get("InitDataListener") != null)
			return (nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener) context
					.get("InitDataListener");
		nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener bean = new nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener();
		context.put("InitDataListener", bean);
		bean.setContext(getContext());
		bean.setModel(getManageAppModel());
		bean.setQueryAction(getQueryAction());
		bean.setVoClassName("nc.vo.pu.m20.entity.PraybillVO");
		bean.setAutoShowUpComponent(getBillFormEditor());
		bean.setProcessorMap(getManagedMap2());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private Map getManagedMap2() {
		Map map = new HashMap();
		map.put("36", getInitProcessor());
		map.put("19", getInitProcessorm30());
		map.put("48", getInitProcessorm4b32());
		map.put("55", getInitProcessorm52A1());
		map.put("40", getInitProcessormTbb());
		map.put("89", getPUMutiPkLinkQueryProcessor());
		map.put("470", getInitProcessorm4F());
		map.put("426", getInitProcessorm4D26());
		return map;
	}

	private nc.ui.pu.m20.billref.am.m4b36.InitDataProcessor getInitProcessor() {
		if (context.get("initProcessor") != null)
			return (nc.ui.pu.m20.billref.am.m4b36.InitDataProcessor) context
					.get("initProcessor");
		nc.ui.pu.m20.billref.am.m4b36.InitDataProcessor bean = new nc.ui.pu.m20.billref.am.m4b36.InitDataProcessor();
		context.put("initProcessor", bean);
		bean.setProcessor(getTransferViewProcessor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pu.m20.billref.so.m30.M30InitDataProcessor getInitProcessorm30() {
		if (context.get("initProcessorm30") != null)
			return (nc.ui.pu.m20.billref.so.m30.M30InitDataProcessor) context
					.get("initProcessorm30");
		nc.ui.pu.m20.billref.so.m30.M30InitDataProcessor bean = new nc.ui.pu.m20.billref.so.m30.M30InitDataProcessor();
		context.put("initProcessorm30", bean);
		bean.setProcessor(getTransferViewProcessor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pu.m20.billref.ewm.m4b32.M4B32InitDataProcessor getInitProcessorm4b32() {
		if (context.get("initProcessorm4b32") != null)
			return (nc.ui.pu.m20.billref.ewm.m4b32.M4B32InitDataProcessor) context
					.get("initProcessorm4b32");
		nc.ui.pu.m20.billref.ewm.m4b32.M4B32InitDataProcessor bean = new nc.ui.pu.m20.billref.ewm.m4b32.M4B32InitDataProcessor();
		context.put("initProcessorm4b32", bean);
		bean.setProcessor(getTransferViewProcessor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pu.m20.billref.m52A1.M52A1InitDataProcessor getInitProcessorm52A1() {
		if (context.get("initProcessorm52A1") != null)
			return (nc.ui.pu.m20.billref.m52A1.M52A1InitDataProcessor) context
					.get("initProcessorm52A1");
		nc.ui.pu.m20.billref.m52A1.M52A1InitDataProcessor bean = new nc.ui.pu.m20.billref.m52A1.M52A1InitDataProcessor();
		context.put("initProcessorm52A1", bean);
		bean.setModel(getManageAppModel());
		bean.setListview(getListView());
		bean.setBillFormEditor(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pu.m20.billref.tbb.TbbInitDataProcessor getInitProcessormTbb() {
		if (context.get("initProcessormTbb") != null)
			return (nc.ui.pu.m20.billref.tbb.TbbInitDataProcessor) context
					.get("initProcessormTbb");
		nc.ui.pu.m20.billref.tbb.TbbInitDataProcessor bean = new nc.ui.pu.m20.billref.tbb.TbbInitDataProcessor();
		context.put("initProcessormTbb", bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pu.billref.PUMutiPkLinkQueryProcessor getPUMutiPkLinkQueryProcessor() {
		if (context.get("PUMutiPkLinkQueryProcessor") != null)
			return (nc.ui.pu.billref.PUMutiPkLinkQueryProcessor) context
					.get("PUMutiPkLinkQueryProcessor");
		nc.ui.pu.billref.PUMutiPkLinkQueryProcessor bean = new nc.ui.pu.billref.PUMutiPkLinkQueryProcessor();
		context.put("PUMutiPkLinkQueryProcessor", bean);
		bean.setModel(getManageAppModel());
		bean.setAutoShowUpComponent(getListView());
		bean.setVoClass("nc.vo.pu.m20.entity.PraybillVO");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pu.m20.billref.invp.m4f.InitDataProcessor4Fto20 getInitProcessorm4F() {
		if (context.get("initProcessorm4F") != null)
			return (nc.ui.pu.m20.billref.invp.m4f.InitDataProcessor4Fto20) context
					.get("initProcessorm4F");
		nc.ui.pu.m20.billref.invp.m4f.InitDataProcessor4Fto20 bean = new nc.ui.pu.m20.billref.invp.m4f.InitDataProcessor4Fto20();
		context.put("initProcessorm4F", bean);
		bean.setProcessor(getTransferViewProcessor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pu.billref.PuInitDataProcessor getInitProcessorm4D26() {
		if (context.get("initProcessorm4D26") != null)
			return (nc.ui.pu.billref.PuInitDataProcessor) context
					.get("initProcessorm4D26");
		nc.ui.pu.billref.PuInitDataProcessor bean = new nc.ui.pu.billref.PuInitDataProcessor();
		context.put("initProcessorm4D26", bean);
		bean.setProcessor(getTransferViewProcessor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.pub.editor.ClientContext getContext() {
		if (context.get("context") != null)
			return (nc.ui.pu.pub.editor.ClientContext) context.get("context");
		nc.ui.pu.pub.editor.ClientContext bean = new nc.ui.pu.pub.editor.ClientContext();
		context.put("context", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.view.value.AggVOMetaBDObjectAdapterFactory getBoadatorfactory() {
		if (context.get("boadatorfactory") != null)
			return (nc.ui.pubapp.uif2app.view.value.AggVOMetaBDObjectAdapterFactory) context
					.get("boadatorfactory");
		nc.ui.pubapp.uif2app.view.value.AggVOMetaBDObjectAdapterFactory bean = new nc.ui.pubapp.uif2app.view.value.AggVOMetaBDObjectAdapterFactory();
		context.put("boadatorfactory", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.model.PraybillModelService getManageModelService() {
		if (context.get("manageModelService") != null)
			return (nc.ui.pu.m20.model.PraybillModelService) context
					.get("manageModelService");
		nc.ui.pu.m20.model.PraybillModelService bean = new nc.ui.pu.m20.model.PraybillModelService();
		context.put("manageModelService", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.uif2.PUBillManageModel getManageAppModel() {
		if (context.get("manageAppModel") != null)
			return (nc.ui.pu.uif2.PUBillManageModel) context
					.get("manageAppModel");
		nc.ui.pu.uif2.PUBillManageModel bean = new nc.ui.pu.uif2.PUBillManageModel();
		context.put("manageAppModel", bean);
		bean.setService(getManageModelService());
		bean.setBusinessObjectAdapterFactory(getBoadatorfactory());
		bean.setContext(getContext());
		bean.setBillType("20");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.scmpub.page.model.SCMBillPageModelDataManager getModelDataManager() {
		if (context.get("modelDataManager") != null)
			return (nc.ui.scmpub.page.model.SCMBillPageModelDataManager) context
					.get("modelDataManager");
		nc.ui.scmpub.page.model.SCMBillPageModelDataManager bean = new nc.ui.scmpub.page.model.SCMBillPageModelDataManager();
		context.put("modelDataManager", bean);
		bean.setModel(getManageAppModel());
		bean.setPageQuery(getPageQuery());
		bean.setPageDelegator(getPageDelegator());
		bean.setPagePanel(getQueryInfo());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.view.MouseClickShowPanelMediator getMouseClickShowPanelMediator() {
		if (context.get("mouseClickShowPanelMediator") != null)
			return (nc.ui.pubapp.uif2app.view.MouseClickShowPanelMediator) context
					.get("mouseClickShowPanelMediator");
		nc.ui.pubapp.uif2app.view.MouseClickShowPanelMediator bean = new nc.ui.pubapp.uif2app.view.MouseClickShowPanelMediator();
		context.put("mouseClickShowPanelMediator", bean);
		bean.setListView(getListView());
		bean.setShowUpComponent(getBillFormEditor());
		bean.setHyperLinkColumn("vbillcode");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.view.RowNoMediator getRowNoMediator() {
		if (context.get("rowNoMediator") != null)
			return (nc.ui.pubapp.uif2app.view.RowNoMediator) context
					.get("rowNoMediator");
		nc.ui.pubapp.uif2app.view.RowNoMediator bean = new nc.ui.pubapp.uif2app.view.RowNoMediator();
		context.put("rowNoMediator", bean);
		bean.setModel(getManageAppModel());
		bean.setEditor(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.common.validateservice.ClosingCheck getClosingListener() {
		if (context.get("ClosingListener") != null)
			return (nc.ui.pubapp.common.validateservice.ClosingCheck) context
					.get("ClosingListener");
		nc.ui.pubapp.common.validateservice.ClosingCheck bean = new nc.ui.pubapp.common.validateservice.ClosingCheck();
		context.put("ClosingListener", bean);
		bean.setModel(getManageAppModel());
		bean.setSaveAction(getSaveAction());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.scmpub.listener.BillCodeEditMediator getBillCodeMediator() {
		if (context.get("billCodeMediator") != null)
			return (nc.ui.scmpub.listener.BillCodeEditMediator) context
					.get("billCodeMediator");
		nc.ui.scmpub.listener.BillCodeEditMediator bean = new nc.ui.scmpub.listener.BillCodeEditMediator();
		context.put("billCodeMediator", bean);
		bean.setBillForm(getBillFormEditor());
		bean.setBillCodeKey("vbillcode");
		bean.setBillType("20");
		bean.initUI();
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.funcnode.trantype.TrantypeBillTemplateMender getTrantypeTempMender() {
		if (context.get("trantypeTempMender") != null)
			return (nc.ui.pubapp.uif2app.funcnode.trantype.TrantypeBillTemplateMender) context
					.get("trantypeTempMender");
		nc.ui.pubapp.uif2app.funcnode.trantype.TrantypeBillTemplateMender bean = new nc.ui.pubapp.uif2app.funcnode.trantype.TrantypeBillTemplateMender(
				getContext());
		context.put("trantypeTempMender", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.view.TemplateContainer getTemplateContainer() {
		if (context.get("templateContainer") != null)
			return (nc.ui.pubapp.uif2app.view.TemplateContainer) context
					.get("templateContainer");
		nc.ui.pubapp.uif2app.view.TemplateContainer bean = new nc.ui.pubapp.uif2app.view.TemplateContainer();
		context.put("templateContainer", bean);
		bean.setContext(getContext());
		bean.setBillTemplateMender(getTrantypeTempMender());
		bean.load();
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.uif2.editor.QueryTemplateContainer getQueryTemplateContainer() {
		if (context.get("queryTemplateContainer") != null)
			return (nc.ui.uif2.editor.QueryTemplateContainer) context
					.get("queryTemplateContainer");
		nc.ui.uif2.editor.QueryTemplateContainer bean = new nc.ui.uif2.editor.QueryTemplateContainer();
		context.put("queryTemplateContainer", bean);
		bean.setContext(getContext());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.actions.PfAddInfoLoader getPfAddInfoLoader() {
		if (context.get("pfAddInfoLoader") != null)
			return (nc.ui.pubapp.uif2app.actions.PfAddInfoLoader) context
					.get("pfAddInfoLoader");
		nc.ui.pubapp.uif2app.actions.PfAddInfoLoader bean = new nc.ui.pubapp.uif2app.actions.PfAddInfoLoader();
		context.put("pfAddInfoLoader", bean);
		bean.setBillType("20");
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.view.FractionFixMediator getFractionFixMediator() {
		if (context.get("fractionFixMediator") != null)
			return (nc.ui.pubapp.uif2app.view.FractionFixMediator) context
					.get("fractionFixMediator");
		nc.ui.pubapp.uif2app.view.FractionFixMediator bean = new nc.ui.pubapp.uif2app.view.FractionFixMediator(
				getBillFormEditor(), getListView());
		context.put("fractionFixMediator", bean);
		bean.initUI();
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.view.BillListView getListView() {
		if (context.get("listView") != null)
			return (nc.ui.pu.m20.view.BillListView) context.get("listView");
		nc.ui.pu.m20.view.BillListView bean = new nc.ui.pu.m20.view.BillListView();
		context.put("listView", bean);
		bean.setModel(getManageAppModel());
		bean.setMultiSelectionEnable(true);
		bean.setPaginationBar(getPageBar());
		bean.setTemplateContainer(getTemplateContainer());
		bean.setUserdefitemListPreparator(getUserdefAndMarAsstListPreparator());
		bean.initUI();
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator getVsourcecodeMediator() {
		if (context.get("vsourcecodeMediator") != null)
			return (nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator) context
					.get("vsourcecodeMediator");
		nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator bean = new nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator();
		context.put("vsourcecodeMediator", bean);
		bean.setModel(getManageAppModel());
		bean.setSrcBillIdField("csourceid");
		bean.setSrcBillNOField("vsourcecode");
		bean.setSrcBillTypeField("csourcetypecode");
		bean.setSrcBillTypeFieldPos(1);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator getVfirstcodeMediator() {
		if (context.get("vfirstcodeMediator") != null)
			return (nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator) context
					.get("vfirstcodeMediator");
		nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator bean = new nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator();
		context.put("vfirstcodeMediator", bean);
		bean.setModel(getManageAppModel());
		bean.setSrcBillIdField("cfirstid");
		bean.setSrcBillNOField("vfirstcode");
		bean.setSrcBillTypeField("cfirsttypecode");
		bean.setSrcBillTypeFieldPos(1);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.view.PraybillBillForm getBillFormEditor() {
		if (context.get("billFormEditor") != null)
			return (nc.ui.pu.m20.view.PraybillBillForm) context
					.get("billFormEditor");
		nc.ui.pu.m20.view.PraybillBillForm bean = new nc.ui.pu.m20.view.PraybillBillForm();
		context.put("billFormEditor", bean);
		bean.setModel(getManageAppModel());
		bean.setTemplateContainer(getTemplateContainer());
		bean.setUserdefitemPreparator(getUserdefAndMarAsstCardPreparator());
		bean.setTemplateNotNullValidate(true);
		bean.setAutoAddLine(false);
		bean.setBlankChildrenFilter(getSingleFieldBlankChildrenFilter_54413d());
		bean.setClearHyperlink(getManagedList24());
		bean.setBodyLineActions(getManagedList25());
		bean.initUI();
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter getSingleFieldBlankChildrenFilter_54413d() {
		if (context
				.get("nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter#54413d") != null)
			return (nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter) context
					.get("nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter#54413d");
		nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter bean = new nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter();
		context.put(
				"nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter#54413d",
				bean);
		bean.setFieldName("pk_material");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList24() {
		List list = new ArrayList();
		list.add("vbillcode");
		return list;
	}

	private List getManagedList25() {
		List list = new ArrayList();
		list.add(getPraybillBodyAddLineAction_1871117());
		list.add(getPraybillInsertLineAction_730e33());
		list.add(getPraybillDelLineAction_1a94c0a());
		list.add(getBodyCopyLineAction_1bf59b1());
		list.add(getBodyPasteLineAction_19981b2());
		list.add(getBodyPasteToTailAction_111e588());
		list.add(getActionsBar_ActionsBarSeparator_1f44758());
		list.add(getBodyLineEditAction_77f6e6());
		list.add(getRearrangeRowNoBodyLineAction_1f28190());
		list.add(getActionsBar_ActionsBarSeparator_18244c());
		list.add(getDefaultBodyZoomAction_f707fc());
		return list;
	}

	private nc.ui.pu.m20.action.PraybillBodyAddLineAction getPraybillBodyAddLineAction_1871117() {
		if (context
				.get("nc.ui.pu.m20.action.PraybillBodyAddLineAction#1871117") != null)
			return (nc.ui.pu.m20.action.PraybillBodyAddLineAction) context
					.get("nc.ui.pu.m20.action.PraybillBodyAddLineAction#1871117");
		nc.ui.pu.m20.action.PraybillBodyAddLineAction bean = new nc.ui.pu.m20.action.PraybillBodyAddLineAction();
		context.put("nc.ui.pu.m20.action.PraybillBodyAddLineAction#1871117",
				bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pu.m20.action.PraybillInsertLineAction getPraybillInsertLineAction_730e33() {
		if (context.get("nc.ui.pu.m20.action.PraybillInsertLineAction#730e33") != null)
			return (nc.ui.pu.m20.action.PraybillInsertLineAction) context
					.get("nc.ui.pu.m20.action.PraybillInsertLineAction#730e33");
		nc.ui.pu.m20.action.PraybillInsertLineAction bean = new nc.ui.pu.m20.action.PraybillInsertLineAction();
		context.put("nc.ui.pu.m20.action.PraybillInsertLineAction#730e33", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pu.m20.action.PraybillDelLineAction getPraybillDelLineAction_1a94c0a() {
		if (context.get("nc.ui.pu.m20.action.PraybillDelLineAction#1a94c0a") != null)
			return (nc.ui.pu.m20.action.PraybillDelLineAction) context
					.get("nc.ui.pu.m20.action.PraybillDelLineAction#1a94c0a");
		nc.ui.pu.m20.action.PraybillDelLineAction bean = new nc.ui.pu.m20.action.PraybillDelLineAction();
		context.put("nc.ui.pu.m20.action.PraybillDelLineAction#1a94c0a", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pubapp.uif2app.actions.BodyCopyLineAction getBodyCopyLineAction_1bf59b1() {
		if (context
				.get("nc.ui.pubapp.uif2app.actions.BodyCopyLineAction#1bf59b1") != null)
			return (nc.ui.pubapp.uif2app.actions.BodyCopyLineAction) context
					.get("nc.ui.pubapp.uif2app.actions.BodyCopyLineAction#1bf59b1");
		nc.ui.pubapp.uif2app.actions.BodyCopyLineAction bean = new nc.ui.pubapp.uif2app.actions.BodyCopyLineAction();
		context.put("nc.ui.pubapp.uif2app.actions.BodyCopyLineAction#1bf59b1",
				bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pubapp.uif2app.actions.BodyPasteLineAction getBodyPasteLineAction_19981b2() {
		if (context
				.get("nc.ui.pubapp.uif2app.actions.BodyPasteLineAction#19981b2") != null)
			return (nc.ui.pubapp.uif2app.actions.BodyPasteLineAction) context
					.get("nc.ui.pubapp.uif2app.actions.BodyPasteLineAction#19981b2");
		nc.ui.pubapp.uif2app.actions.BodyPasteLineAction bean = new nc.ui.pubapp.uif2app.actions.BodyPasteLineAction();
		context.put("nc.ui.pubapp.uif2app.actions.BodyPasteLineAction#19981b2",
				bean);
		bean.setClearItems(getManagedList26());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList26() {
		List list = new ArrayList();
		list.add("bpublishtoec");
		list.add("browclose");
		list.add("naccumulatenum");
		list.add("npriceauditbill");
		list.add("nquotebill");
		list.add("ngenct");
		list.add("pk_praybill_b");
		list.add("ts");
		return list;
	}

	private nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction getBodyPasteToTailAction_111e588() {
		if (context
				.get("nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction#111e588") != null)
			return (nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction) context
					.get("nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction#111e588");
		nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction bean = new nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction();
		context.put(
				"nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction#111e588",
				bean);
		bean.setClearItems(getManagedList27());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList27() {
		List list = new ArrayList();
		list.add("bpublishtoec");
		list.add("browclose");
		list.add("naccumulatenum");
		list.add("npriceauditbill");
		list.add("nquotebill");
		list.add("ngenct");
		list.add("pk_praybill_b");
		list.add("ts");
		return list;
	}

	private nc.ui.pub.beans.ActionsBar.ActionsBarSeparator getActionsBar_ActionsBarSeparator_1f44758() {
		if (context
				.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1f44758") != null)
			return (nc.ui.pub.beans.ActionsBar.ActionsBarSeparator) context
					.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1f44758");
		nc.ui.pub.beans.ActionsBar.ActionsBarSeparator bean = new nc.ui.pub.beans.ActionsBar.ActionsBarSeparator();
		context.put("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1f44758",
				bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pubapp.uif2app.actions.BodyLineEditAction getBodyLineEditAction_77f6e6() {
		if (context
				.get("nc.ui.pubapp.uif2app.actions.BodyLineEditAction#77f6e6") != null)
			return (nc.ui.pubapp.uif2app.actions.BodyLineEditAction) context
					.get("nc.ui.pubapp.uif2app.actions.BodyLineEditAction#77f6e6");
		nc.ui.pubapp.uif2app.actions.BodyLineEditAction bean = new nc.ui.pubapp.uif2app.actions.BodyLineEditAction();
		context.put("nc.ui.pubapp.uif2app.actions.BodyLineEditAction#77f6e6",
				bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction getRearrangeRowNoBodyLineAction_1f28190() {
		if (context
				.get("nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction#1f28190") != null)
			return (nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction) context
					.get("nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction#1f28190");
		nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction bean = new nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction();
		context.put(
				"nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction#1f28190",
				bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pub.beans.ActionsBar.ActionsBarSeparator getActionsBar_ActionsBarSeparator_18244c() {
		if (context
				.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#18244c") != null)
			return (nc.ui.pub.beans.ActionsBar.ActionsBarSeparator) context
					.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#18244c");
		nc.ui.pub.beans.ActionsBar.ActionsBarSeparator bean = new nc.ui.pub.beans.ActionsBar.ActionsBarSeparator();
		context.put("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#18244c",
				bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction getDefaultBodyZoomAction_f707fc() {
		if (context
				.get("nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction#f707fc") != null)
			return (nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction) context
					.get("nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction#f707fc");
		nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction bean = new nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction();
		context.put(
				"nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction#f707fc",
				bean);
		bean.setPos(1);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.tangramlayout.UEQueryAreaShell getQueryArea() {
		if (context.get("queryArea") != null)
			return (nc.ui.pubapp.uif2app.tangramlayout.UEQueryAreaShell) context
					.get("queryArea");
		nc.ui.pubapp.uif2app.tangramlayout.UEQueryAreaShell bean = new nc.ui.pubapp.uif2app.tangramlayout.UEQueryAreaShell();
		context.put("queryArea", bean);
		bean.setQueryAreaCreator(getQueryAction());
		bean.initUI();
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel getQueryInfo() {
		if (context.get("queryInfo") != null)
			return (nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel) context
					.get("queryInfo");
		nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel bean = new nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel();
		context.put("queryInfo", bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.tangramlayout.UECardLayoutToolbarPanel getCardInfoPnl() {
		if (context.get("cardInfoPnl") != null)
			return (nc.ui.pubapp.uif2app.tangramlayout.UECardLayoutToolbarPanel) context
					.get("cardInfoPnl");
		nc.ui.pubapp.uif2app.tangramlayout.UECardLayoutToolbarPanel bean = new nc.ui.pubapp.uif2app.tangramlayout.UECardLayoutToolbarPanel();
		context.put("cardInfoPnl", bean);
		bean.setActions(getManagedList28());
		bean.setTitleAction(getReturnaction());
		bean.setModel(getManageAppModel());
		bean.setRightExActions(getManagedList29());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList28() {
		List list = new ArrayList();
		list.add(getFirstLineAction());
		list.add(getPreLineAction());
		list.add(getNextLineAction());
		list.add(getLastLineAction());
		return list;
	}

	private nc.ui.uif2.actions.FirstLineAction getFirstLineAction() {
		if (context.get("firstLineAction") != null)
			return (nc.ui.uif2.actions.FirstLineAction) context
					.get("firstLineAction");
		nc.ui.uif2.actions.FirstLineAction bean = new nc.ui.uif2.actions.FirstLineAction();
		context.put("firstLineAction", bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.actions.PreLineAction getPreLineAction() {
		if (context.get("preLineAction") != null)
			return (nc.ui.uif2.actions.PreLineAction) context
					.get("preLineAction");
		nc.ui.uif2.actions.PreLineAction bean = new nc.ui.uif2.actions.PreLineAction();
		context.put("preLineAction", bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.actions.NextLineAction getNextLineAction() {
		if (context.get("nextLineAction") != null)
			return (nc.ui.uif2.actions.NextLineAction) context
					.get("nextLineAction");
		nc.ui.uif2.actions.NextLineAction bean = new nc.ui.uif2.actions.NextLineAction();
		context.put("nextLineAction", bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.actions.LastLineAction getLastLineAction() {
		if (context.get("lastLineAction") != null)
			return (nc.ui.uif2.actions.LastLineAction) context
					.get("lastLineAction");
		nc.ui.uif2.actions.LastLineAction bean = new nc.ui.uif2.actions.LastLineAction();
		context.put("lastLineAction", bean);
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pubapp.uif2app.actions.UEReturnAction getReturnaction() {
		if (context.get("returnaction") != null)
			return (nc.ui.pubapp.uif2app.actions.UEReturnAction) context
					.get("returnaction");
		nc.ui.pubapp.uif2app.actions.UEReturnAction bean = new nc.ui.pubapp.uif2app.actions.UEReturnAction();
		context.put("returnaction", bean);
		bean.setGoComponent(getListView());
		bean.setSaveAction(getSaveAction());
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList29() {
		List list = new ArrayList();
		list.add(getActionsBar_ActionsBarSeparator_2d6d62());
		list.add(getHeadZoomAction());
		return list;
	}

	private nc.ui.pub.beans.ActionsBar.ActionsBarSeparator getActionsBar_ActionsBarSeparator_2d6d62() {
		if (context
				.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#2d6d62") != null)
			return (nc.ui.pub.beans.ActionsBar.ActionsBarSeparator) context
					.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#2d6d62");
		nc.ui.pub.beans.ActionsBar.ActionsBarSeparator bean = new nc.ui.pub.beans.ActionsBar.ActionsBarSeparator();
		context.put("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#2d6d62",
				bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pubapp.uif2app.actions.DefaultHeadZoomAction getHeadZoomAction() {
		if (context.get("headZoomAction") != null)
			return (nc.ui.pubapp.uif2app.actions.DefaultHeadZoomAction) context
					.get("headZoomAction");
		nc.ui.pubapp.uif2app.actions.DefaultHeadZoomAction bean = new nc.ui.pubapp.uif2app.actions.DefaultHeadZoomAction();
		context.put("headZoomAction", bean);
		bean.setBillForm(getBillFormEditor());
		bean.setModel(getManageAppModel());
		bean.setPos(0);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.uif2.components.pagination.PaginationBar getPageBar() {
		if (context.get("pageBar") != null)
			return (nc.ui.uif2.components.pagination.PaginationBar) context
					.get("pageBar");
		nc.ui.uif2.components.pagination.PaginationBar bean = new nc.ui.uif2.components.pagination.PaginationBar();
		context.put("pageBar", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.actions.pagination.BillModelPaginationDelegator getPageDelegator() {
		if (context.get("pageDelegator") != null)
			return (nc.ui.pubapp.uif2app.actions.pagination.BillModelPaginationDelegator) context
					.get("pageDelegator");
		nc.ui.pubapp.uif2app.actions.pagination.BillModelPaginationDelegator bean = new nc.ui.pubapp.uif2app.actions.pagination.BillModelPaginationDelegator(
				getManageAppModel());
		context.put("pageDelegator", bean);
		bean.setPaginationQuery(getPageQuery());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.model.PrayBillPageService getPageQuery() {
		if (context.get("pageQuery") != null)
			return (nc.ui.pu.m20.model.PrayBillPageService) context
					.get("pageQuery");
		nc.ui.pu.m20.model.PrayBillPageService bean = new nc.ui.pu.m20.model.PrayBillPageService();
		context.put("pageQuery", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.scmpub.page.model.SCMBillPageMediator getPageMediator() {
		if (context.get("pageMediator") != null)
			return (nc.ui.scmpub.page.model.SCMBillPageMediator) context
					.get("pageMediator");
		nc.ui.scmpub.page.model.SCMBillPageMediator bean = new nc.ui.scmpub.page.model.SCMBillPageMediator();
		context.put("pageMediator", bean);
		bean.setListView(getListView());
		bean.setRecordInPage(10);
		bean.setCachePages(10);
		bean.setPageDelegator(getPageDelegator());
		bean.init();
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.uif2.TangramContainer getContainer() {
		if (context.get("container") != null)
			return (nc.ui.uif2.TangramContainer) context.get("container");
		nc.ui.uif2.TangramContainer bean = new nc.ui.uif2.TangramContainer();
		context.put("container", bean);
		bean.setModel(getManageAppModel());
		bean.setTangramLayoutRoot(getTBNode_44d213());
		bean.initUI();
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.tangramlayout.node.TBNode getTBNode_44d213() {
		if (context.get("nc.ui.uif2.tangramlayout.node.TBNode#44d213") != null)
			return (nc.ui.uif2.tangramlayout.node.TBNode) context
					.get("nc.ui.uif2.tangramlayout.node.TBNode#44d213");
		nc.ui.uif2.tangramlayout.node.TBNode bean = new nc.ui.uif2.tangramlayout.node.TBNode();
		context.put("nc.ui.uif2.tangramlayout.node.TBNode#44d213", bean);
		bean.setShowMode("CardLayout");
		bean.setTabs(getManagedList30());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList30() {
		List list = new ArrayList();
		list.add(getHSNode_350c7b());
		list.add(getVSNode_165b4db());
		return list;
	}

	private nc.ui.uif2.tangramlayout.node.HSNode getHSNode_350c7b() {
		if (context.get("nc.ui.uif2.tangramlayout.node.HSNode#350c7b") != null)
			return (nc.ui.uif2.tangramlayout.node.HSNode) context
					.get("nc.ui.uif2.tangramlayout.node.HSNode#350c7b");
		nc.ui.uif2.tangramlayout.node.HSNode bean = new nc.ui.uif2.tangramlayout.node.HSNode();
		context.put("nc.ui.uif2.tangramlayout.node.HSNode#350c7b", bean);
		bean.setLeft(getCNode_684019());
		bean.setRight(getVSNode_492d2d());
		bean.setDividerLocation(0.22f);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.tangramlayout.node.CNode getCNode_684019() {
		if (context.get("nc.ui.uif2.tangramlayout.node.CNode#684019") != null)
			return (nc.ui.uif2.tangramlayout.node.CNode) context
					.get("nc.ui.uif2.tangramlayout.node.CNode#684019");
		nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
		context.put("nc.ui.uif2.tangramlayout.node.CNode#684019", bean);
		bean.setComponent(getQueryArea());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.tangramlayout.node.VSNode getVSNode_492d2d() {
		if (context.get("nc.ui.uif2.tangramlayout.node.VSNode#492d2d") != null)
			return (nc.ui.uif2.tangramlayout.node.VSNode) context
					.get("nc.ui.uif2.tangramlayout.node.VSNode#492d2d");
		nc.ui.uif2.tangramlayout.node.VSNode bean = new nc.ui.uif2.tangramlayout.node.VSNode();
		context.put("nc.ui.uif2.tangramlayout.node.VSNode#492d2d", bean);
		bean.setUp(getCNode_4831b9());
		bean.setDown(getTBNode_14f221f());
		bean.setDividerLocation(30f);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.tangramlayout.node.CNode getCNode_4831b9() {
		if (context.get("nc.ui.uif2.tangramlayout.node.CNode#4831b9") != null)
			return (nc.ui.uif2.tangramlayout.node.CNode) context
					.get("nc.ui.uif2.tangramlayout.node.CNode#4831b9");
		nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
		context.put("nc.ui.uif2.tangramlayout.node.CNode#4831b9", bean);
		bean.setComponent(getQueryInfo());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.tangramlayout.node.TBNode getTBNode_14f221f() {
		if (context.get("nc.ui.uif2.tangramlayout.node.TBNode#14f221f") != null)
			return (nc.ui.uif2.tangramlayout.node.TBNode) context
					.get("nc.ui.uif2.tangramlayout.node.TBNode#14f221f");
		nc.ui.uif2.tangramlayout.node.TBNode bean = new nc.ui.uif2.tangramlayout.node.TBNode();
		context.put("nc.ui.uif2.tangramlayout.node.TBNode#14f221f", bean);
		bean.setShowMode("CardLayout");
		bean.setTabs(getManagedList31());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList31() {
		List list = new ArrayList();
		list.add(getCNode_1b3dc77());
		return list;
	}

	private nc.ui.uif2.tangramlayout.node.CNode getCNode_1b3dc77() {
		if (context.get("nc.ui.uif2.tangramlayout.node.CNode#1b3dc77") != null)
			return (nc.ui.uif2.tangramlayout.node.CNode) context
					.get("nc.ui.uif2.tangramlayout.node.CNode#1b3dc77");
		nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
		context.put("nc.ui.uif2.tangramlayout.node.CNode#1b3dc77", bean);
		bean.setName(getI18nFB_1b87f65());
		bean.setComponent(getListView());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private java.lang.String getI18nFB_1b87f65() {
		if (context.get("nc.ui.uif2.I18nFB#1b87f65") != null)
			return (java.lang.String) context.get("nc.ui.uif2.I18nFB#1b87f65");
		nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
		context.put("&nc.ui.uif2.I18nFB#1b87f65", bean);
		bean.setResDir("common");
		bean.setResId("UC001-0000107");
		bean.setDefaultValue("列表");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		try {
			Object product = bean.getObject();
			context.put("nc.ui.uif2.I18nFB#1b87f65", product);
			return (java.lang.String) product;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private nc.ui.uif2.tangramlayout.node.VSNode getVSNode_165b4db() {
		if (context.get("nc.ui.uif2.tangramlayout.node.VSNode#165b4db") != null)
			return (nc.ui.uif2.tangramlayout.node.VSNode) context
					.get("nc.ui.uif2.tangramlayout.node.VSNode#165b4db");
		nc.ui.uif2.tangramlayout.node.VSNode bean = new nc.ui.uif2.tangramlayout.node.VSNode();
		context.put("nc.ui.uif2.tangramlayout.node.VSNode#165b4db", bean);
		bean.setUp(getCNode_c68c7b());
		bean.setDown(getVSNode_b59d3b());
		bean.setDividerLocation(30f);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.tangramlayout.node.CNode getCNode_c68c7b() {
		if (context.get("nc.ui.uif2.tangramlayout.node.CNode#c68c7b") != null)
			return (nc.ui.uif2.tangramlayout.node.CNode) context
					.get("nc.ui.uif2.tangramlayout.node.CNode#c68c7b");
		nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
		context.put("nc.ui.uif2.tangramlayout.node.CNode#c68c7b", bean);
		bean.setComponent(getCardInfoPnl());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.tangramlayout.node.VSNode getVSNode_b59d3b() {
		if (context.get("nc.ui.uif2.tangramlayout.node.VSNode#b59d3b") != null)
			return (nc.ui.uif2.tangramlayout.node.VSNode) context
					.get("nc.ui.uif2.tangramlayout.node.VSNode#b59d3b");
		nc.ui.uif2.tangramlayout.node.VSNode bean = new nc.ui.uif2.tangramlayout.node.VSNode();
		context.put("nc.ui.uif2.tangramlayout.node.VSNode#b59d3b", bean);
		bean.setUp(getCNode_1ed9494());
		bean.setDown(getOnhandNode());
		bean.setDividerLocation(0.75f);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.tangramlayout.node.CNode getCNode_1ed9494() {
		if (context.get("nc.ui.uif2.tangramlayout.node.CNode#1ed9494") != null)
			return (nc.ui.uif2.tangramlayout.node.CNode) context
					.get("nc.ui.uif2.tangramlayout.node.CNode#1ed9494");
		nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
		context.put("nc.ui.uif2.tangramlayout.node.CNode#1ed9494", bean);
		bean.setComponent(getBillFormEditor());
		bean.setName(getI18nFB_130e0a9());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private java.lang.String getI18nFB_130e0a9() {
		if (context.get("nc.ui.uif2.I18nFB#130e0a9") != null)
			return (java.lang.String) context.get("nc.ui.uif2.I18nFB#130e0a9");
		nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
		context.put("&nc.ui.uif2.I18nFB#130e0a9", bean);
		bean.setResDir("common");
		bean.setResId("UC001-0000106");
		bean.setDefaultValue("卡片");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		try {
			Object product = bean.getObject();
			context.put("nc.ui.uif2.I18nFB#130e0a9", product);
			return (java.lang.String) product;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private nc.ui.uif2.tangramlayout.node.CNode getOnhandNode() {
		if (context.get("onhandNode") != null)
			return (nc.ui.uif2.tangramlayout.node.CNode) context
					.get("onhandNode");
		nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
		context.put("onhandNode", bean);
		bean.setComponent(getOhandcard());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.action.billref.dest.PraybillTransferListProcessor getPraybillTransferListProcessor() {
		if (context.get("praybillTransferListProcessor") != null)
			return (nc.ui.pu.m20.action.billref.dest.PraybillTransferListProcessor) context
					.get("praybillTransferListProcessor");
		nc.ui.pu.m20.action.billref.dest.PraybillTransferListProcessor bean = new nc.ui.pu.m20.action.billref.dest.PraybillTransferListProcessor();
		context.put("praybillTransferListProcessor", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.billref.dest.TransferViewProcessor getTransferViewProcessor() {
		if (context.get("transferViewProcessor") != null)
			return (nc.ui.pubapp.billref.dest.TransferViewProcessor) context
					.get("transferViewProcessor");
		nc.ui.pubapp.billref.dest.TransferViewProcessor bean = new nc.ui.pubapp.billref.dest.TransferViewProcessor();
		context.put("transferViewProcessor", bean);
		bean.setList(getListView());
		bean.setActionContainer(getActionsOfList());
		bean.setCardActionContainer(getActionsOfCard());
		bean.setSaveAction(getSaveAction());
		bean.setCommitAction(getSendApproveAction());
		bean.setCancelAction(getCancelAction());
		bean.setBillForm(getBillFormEditor());
		bean.setQueryAreaShell(getQueryArea());
		bean.setListProcessor(getPraybillTransferListProcessor());
		bean.setQueryInfoToolbarPanel(getQueryInfo());
		bean.setTransferLogic(getDefaultBillDataLogic_3c12df());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pubapp.billref.dest.DefaultBillDataLogic getDefaultBillDataLogic_3c12df() {
		if (context
				.get("nc.ui.pubapp.billref.dest.DefaultBillDataLogic#3c12df") != null)
			return (nc.ui.pubapp.billref.dest.DefaultBillDataLogic) context
					.get("nc.ui.pubapp.billref.dest.DefaultBillDataLogic#3c12df");
		nc.ui.pubapp.billref.dest.DefaultBillDataLogic bean = new nc.ui.pubapp.billref.dest.DefaultBillDataLogic();
		context.put("nc.ui.pubapp.billref.dest.DefaultBillDataLogic#3c12df",
				bean);
		bean.setBillForm(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pu.m20.handpanel.PraybillOnhandPanelSrc getOnhandPanelSrc() {
		if (context.get("onhandPanelSrc") != null)
			return (nc.ui.pu.m20.handpanel.PraybillOnhandPanelSrc) context
					.get("onhandPanelSrc");
		nc.ui.pu.m20.handpanel.PraybillOnhandPanelSrc bean = new nc.ui.pu.m20.handpanel.PraybillOnhandPanelSrc();
		context.put("onhandPanelSrc", bean);
		bean.setBillForm(getBillFormEditor());
		bean.setModel(getManageAppModel());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.ic.onhand.pane.QueryOnHandInfoPanel getOhandcard() {
		if (context.get("ohandcard") != null)
			return (nc.ui.ic.onhand.pane.QueryOnHandInfoPanel) context
					.get("ohandcard");
		nc.ui.ic.onhand.pane.QueryOnHandInfoPanel bean = new nc.ui.ic.onhand.pane.QueryOnHandInfoPanel();
		context.put("ohandcard", bean);
		bean.setLogincontext(getContext());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.model.BillBodySortMediator getBillBodySortMediator() {
		if (context.get("billBodySortMediator") != null)
			return (nc.ui.pubapp.uif2app.model.BillBodySortMediator) context
					.get("billBodySortMediator");
		nc.ui.pubapp.uif2app.model.BillBodySortMediator bean = new nc.ui.pubapp.uif2app.model.BillBodySortMediator(
				getManageAppModel(), getBillFormEditor(), getListView());
		context.put("billBodySortMediator", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.view.CompositeBillDataPrepare getUserdefAndMarAsstCardPreparator() {
		if (context.get("userdefAndMarAsstCardPreparator") != null)
			return (nc.ui.pubapp.uif2app.view.CompositeBillDataPrepare) context
					.get("userdefAndMarAsstCardPreparator");
		nc.ui.pubapp.uif2app.view.CompositeBillDataPrepare bean = new nc.ui.pubapp.uif2app.view.CompositeBillDataPrepare();
		context.put("userdefAndMarAsstCardPreparator", bean);
		bean.setBillDataPrepares(getManagedList32());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList32() {
		List list = new ArrayList();
		list.add(getUserdefitemPreparator());
		list.add(getMarAsstPreparator());
		return list;
	}

	public nc.ui.pubapp.uif2app.view.CompositeBillListDataPrepare getUserdefAndMarAsstListPreparator() {
		if (context.get("userdefAndMarAsstListPreparator") != null)
			return (nc.ui.pubapp.uif2app.view.CompositeBillListDataPrepare) context
					.get("userdefAndMarAsstListPreparator");
		nc.ui.pubapp.uif2app.view.CompositeBillListDataPrepare bean = new nc.ui.pubapp.uif2app.view.CompositeBillListDataPrepare();
		context.put("userdefAndMarAsstListPreparator", bean);
		bean.setBillListDataPrepares(getManagedList33());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList33() {
		List list = new ArrayList();
		list.add(getUserdefitemlistPreparator());
		list.add(getMarAsstPreparator());
		return list;
	}

	public nc.ui.uif2.editor.UserdefitemContainerPreparator getUserdefitemPreparator() {
		if (context.get("userdefitemPreparator") != null)
			return (nc.ui.uif2.editor.UserdefitemContainerPreparator) context
					.get("userdefitemPreparator");
		nc.ui.uif2.editor.UserdefitemContainerPreparator bean = new nc.ui.uif2.editor.UserdefitemContainerPreparator();
		context.put("userdefitemPreparator", bean);
		bean.setContainer(getUserdefitemContainer());
		bean.setParams(getManagedList34());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList34() {
		List list = new ArrayList();
		list.add(getUserdefQueryParam_1fb2f38());
		list.add(getUserdefQueryParam_1d912db());
		return list;
	}

	private nc.ui.uif2.editor.UserdefQueryParam getUserdefQueryParam_1fb2f38() {
		if (context.get("nc.ui.uif2.editor.UserdefQueryParam#1fb2f38") != null)
			return (nc.ui.uif2.editor.UserdefQueryParam) context
					.get("nc.ui.uif2.editor.UserdefQueryParam#1fb2f38");
		nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
		context.put("nc.ui.uif2.editor.UserdefQueryParam#1fb2f38", bean);
		bean.setMdfullname("pu.po_praybill");
		bean.setPos(0);
		bean.setPrefix("vdef");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.editor.UserdefQueryParam getUserdefQueryParam_1d912db() {
		if (context.get("nc.ui.uif2.editor.UserdefQueryParam#1d912db") != null)
			return (nc.ui.uif2.editor.UserdefQueryParam) context
					.get("nc.ui.uif2.editor.UserdefQueryParam#1d912db");
		nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
		context.put("nc.ui.uif2.editor.UserdefQueryParam#1d912db", bean);
		bean.setMdfullname("pu.po_praybill_b");
		bean.setPos(1);
		bean.setPrefix("vbdef");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.uif2.editor.UserdefitemContainerListPreparator getUserdefitemlistPreparator() {
		if (context.get("userdefitemlistPreparator") != null)
			return (nc.ui.uif2.editor.UserdefitemContainerListPreparator) context
					.get("userdefitemlistPreparator");
		nc.ui.uif2.editor.UserdefitemContainerListPreparator bean = new nc.ui.uif2.editor.UserdefitemContainerListPreparator();
		context.put("userdefitemlistPreparator", bean);
		bean.setContainer(getUserdefitemContainer());
		bean.setParams(getManagedList35());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList35() {
		List list = new ArrayList();
		list.add(getUserdefQueryParam_650588());
		list.add(getUserdefQueryParam_4e5215());
		return list;
	}

	private nc.ui.uif2.editor.UserdefQueryParam getUserdefQueryParam_650588() {
		if (context.get("nc.ui.uif2.editor.UserdefQueryParam#650588") != null)
			return (nc.ui.uif2.editor.UserdefQueryParam) context
					.get("nc.ui.uif2.editor.UserdefQueryParam#650588");
		nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
		context.put("nc.ui.uif2.editor.UserdefQueryParam#650588", bean);
		bean.setMdfullname("pu.po_praybill");
		bean.setPos(0);
		bean.setPrefix("vdef");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.editor.UserdefQueryParam getUserdefQueryParam_4e5215() {
		if (context.get("nc.ui.uif2.editor.UserdefQueryParam#4e5215") != null)
			return (nc.ui.uif2.editor.UserdefQueryParam) context
					.get("nc.ui.uif2.editor.UserdefQueryParam#4e5215");
		nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
		context.put("nc.ui.uif2.editor.UserdefQueryParam#4e5215", bean);
		bean.setMdfullname("pu.po_praybill_b");
		bean.setPos(1);
		bean.setTabcode("pk_praybill_b");
		bean.setPrefix("vbdef");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.view.material.assistant.MarAsstPreparator getMarAsstPreparator() {
		if (context.get("marAsstPreparator") != null)
			return (nc.ui.pubapp.uif2app.view.material.assistant.MarAsstPreparator) context
					.get("marAsstPreparator");
		nc.ui.pubapp.uif2app.view.material.assistant.MarAsstPreparator bean = new nc.ui.pubapp.uif2app.view.material.assistant.MarAsstPreparator();
		context.put("marAsstPreparator", bean);
		bean.setModel(getManageAppModel());
		bean.setContainer(getUserdefitemContainer());
		bean.setPrefix("vfree");
		bean.setMaterialField("pk_material");
		bean.setProjectField("cprojectid");
		bean.setProductorField("cproductorid");
		bean.setCustomerField("casscustid");
		bean.setSignatureField("cffileid");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.uif2.userdefitem.UserDefItemContainer getUserdefitemContainer() {
		if (context.get("userdefitemContainer") != null)
			return (nc.ui.uif2.userdefitem.UserDefItemContainer) context
					.get("userdefitemContainer");
		nc.ui.uif2.userdefitem.UserDefItemContainer bean = new nc.ui.uif2.userdefitem.UserDefItemContainer();
		context.put("userdefitemContainer", bean);
		bean.setContext(getContext());
		bean.setParams(getManagedList36());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList36() {
		List list = new ArrayList();
		list.add(getQueryParam_1eef03e());
		list.add(getQueryParam_1de8aed());
		list.add(getQueryParam_172ea42());
		return list;
	}

	private nc.ui.uif2.userdefitem.QueryParam getQueryParam_1eef03e() {
		if (context.get("nc.ui.uif2.userdefitem.QueryParam#1eef03e") != null)
			return (nc.ui.uif2.userdefitem.QueryParam) context
					.get("nc.ui.uif2.userdefitem.QueryParam#1eef03e");
		nc.ui.uif2.userdefitem.QueryParam bean = new nc.ui.uif2.userdefitem.QueryParam();
		context.put("nc.ui.uif2.userdefitem.QueryParam#1eef03e", bean);
		bean.setMdfullname("pu.po_praybill");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.userdefitem.QueryParam getQueryParam_1de8aed() {
		if (context.get("nc.ui.uif2.userdefitem.QueryParam#1de8aed") != null)
			return (nc.ui.uif2.userdefitem.QueryParam) context
					.get("nc.ui.uif2.userdefitem.QueryParam#1de8aed");
		nc.ui.uif2.userdefitem.QueryParam bean = new nc.ui.uif2.userdefitem.QueryParam();
		context.put("nc.ui.uif2.userdefitem.QueryParam#1de8aed", bean);
		bean.setMdfullname("pu.po_praybill_b");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.uif2.userdefitem.QueryParam getQueryParam_172ea42() {
		if (context.get("nc.ui.uif2.userdefitem.QueryParam#172ea42") != null)
			return (nc.ui.uif2.userdefitem.QueryParam) context
					.get("nc.ui.uif2.userdefitem.QueryParam#172ea42");
		nc.ui.uif2.userdefitem.QueryParam bean = new nc.ui.uif2.userdefitem.QueryParam();
		context.put("nc.ui.uif2.userdefitem.QueryParam#172ea42", bean);
		bean.setRulecode("materialassistant");
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.lazilyload.DefaultBillLazilyLoader getBillLazilyLoader() {
		if (context.get("billLazilyLoader") != null)
			return (nc.ui.pubapp.uif2app.lazilyload.DefaultBillLazilyLoader) context
					.get("billLazilyLoader");
		nc.ui.pubapp.uif2app.lazilyload.DefaultBillLazilyLoader bean = new nc.ui.pubapp.uif2app.lazilyload.DefaultBillLazilyLoader();
		context.put("billLazilyLoader", bean);
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad getLazyActions() {
		if (context.get("lazyActions") != null)
			return (nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad) context
					.get("lazyActions");
		nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad bean = new nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad();
		context.put("lazyActions", bean);
		bean.setModel(getManageAppModel());
		bean.setActionList(getManagedList37());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList37() {
		List list = new ArrayList();
		list.add(getPrintAction());
		list.add(getPreviewAction());
		list.add(getOutputAction());
		return list;
	}

	public nc.ui.pubapp.uif2app.lazilyload.LazilyLoadManager getLasilyLodadMediator() {
		if (context.get("LasilyLodadMediator") != null)
			return (nc.ui.pubapp.uif2app.lazilyload.LazilyLoadManager) context
					.get("LasilyLodadMediator");
		nc.ui.pubapp.uif2app.lazilyload.LazilyLoadManager bean = new nc.ui.pubapp.uif2app.lazilyload.LazilyLoadManager();
		context.put("LasilyLodadMediator", bean);
		bean.setModel(getManageAppModel());
		bean.setLoader(getBillLazilyLoader());
		bean.setLazilyLoadSupporter(getManagedList38());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList38() {
		List list = new ArrayList();
		list.add(getLazyActions());
		list.add(getCardPanelLazilyLoad_171ce44());
		list.add(getListPanelLazilyLoad_9d12b3());
		return list;
	}

	private nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad getCardPanelLazilyLoad_171ce44() {
		if (context
				.get("nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad#171ce44") != null)
			return (nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad) context
					.get("nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad#171ce44");
		nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad bean = new nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad();
		context.put(
				"nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad#171ce44",
				bean);
		bean.setBillform(getBillFormEditor());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad getListPanelLazilyLoad_9d12b3() {
		if (context
				.get("nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad#9d12b3") != null)
			return (nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad) context
					.get("nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad#9d12b3");
		nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad bean = new nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad();
		context.put(
				"nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad#9d12b3",
				bean);
		bean.setListView(getListView());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	public nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller getRemoteCallCombinatorCaller() {
		if (context.get("remoteCallCombinatorCaller") != null)
			return (nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller) context
					.get("remoteCallCombinatorCaller");
		nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller bean = new nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller();
		context.put("remoteCallCombinatorCaller", bean);
		bean.setRemoteCallers(getManagedList39());
		setBeanFacotryIfBeanFacatoryAware(bean);
		invokeInitializingBean(bean);
		return bean;
	}

	private List getManagedList39() {
		List list = new ArrayList();
		list.add(getQueryTemplateContainer());
		list.add(getTemplateContainer());
		list.add(getUserdefitemContainer());
		list.add(getPfAddInfoLoader());
		return list;
	}

}
