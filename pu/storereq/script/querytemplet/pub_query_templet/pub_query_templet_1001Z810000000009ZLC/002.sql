insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLE','库存组织',5,0,1,null,null,'pk_org','库存组织',null,'N','Y','N','Y','N','N','N','N','Y','Y','N','N','N','Y','Y',null,'Y',9999,null,'=@','等于@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020045',2,null,null,'2014-05-26 19:07:54','N','#mainorg#')
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLF','-99',3,1,1,null,null,'po_storereq.dbilldate','申请日期',null,'N','Y','N','Y','N','N','N','N','Y','Y','N','N','N','Y','Y',null,'Y',9999,null,'between@=@','介于@等于@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020039',2,null,null,'2014-05-18 12:53:56','N','#month(0)#,#day(0)#')
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLG','-99',0,2,1,null,null,'po_storereq.vbillcode','申请单号',null,'N','Y','N','Y','N','N','N','N','N','Y','N','N','N','N','Y',null,'Y',9999,null,'=@left like','等于@左包含@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020040',2,null,null,'2014-05-17 15:26:38','N',null)
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLH','IM,d8fc6206-3373-492c-9710-0f9f36da6100',6,3,1,null,null,'po_storereq.freqtypeflag','需求类型',null,'N','Y','N','Y','N','N','N','N','Y','Y','N','N','N','N','Y',null,'Y',9999,null,'=@','等于@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020041',2,null,null,'2014-05-18 12:29:28','N','0')
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLI','IM,ff16f639-dc98-467a-a376-9baa8407cca7',6,4,1,null,null,'po_storereq.fbillstatus','单据状态',null,'N','Y','N','Y','N','N','N','N','Y','Y','N','N','N','N','Y',null,'Y',9999,null,'=@','等于@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020042',2,null,null,'2014-05-18 12:29:28','N','3')
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLJ','物料基本分类',5,5,0,null,null,'po_storereq_b.pk_srcmaterial.pk_marbasclass.code','物料基本分类编码',null,'N','N','N','Y','N','N','N','N','N','Y','N','N','N','N','Y',null,'Y',9999,null,'=@left like','等于@左包含@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020043',0,null,null,'2014-05-26 19:07:54','N',null)
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLK','物料',5,6,0,null,null,'po_storereq_b.pk_srcmaterial.code','物料编码',null,'N','N','N','Y','N','N','N','N','N','Y','N','N','N','N','Y',null,'Y',9999,null,'=@left like','等于@左包含@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020044',0,null,null,'2014-05-26 19:07:54','N',null)
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLL','物料',5,7,1,null,null,'po_storereq_b.pk_srcmaterial.name','物料名称',null,'N','N','N','Y','N','N','N','N','N','Y','N','N','N','N','Y',null,'Y',9999,null,'=@left like','等于@左包含@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020046',1,null,null,'2014-05-26 19:07:54','N',null)
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLM','仓库',5,8,1,null,null,'po_storereq_b.pk_reqstordoc','需求仓库',null,'N','Y','N','Y','N','N','N','N','N','Y','N','N','N','N','Y',null,'Y',9999,null,'=@','等于@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020047',2,null,null,'2014-05-25 16:25:39','N',null)
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLN','-99',3,9,1,null,null,'po_storereq_b.dreqdate','需求日期',null,'N','Y','N','Y','N','N','N','N','N','Y','N','N','N','Y','Y',null,'Y',9999,null,'between@=@','介于@等于@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020048',2,null,null,'2014-05-18 12:53:56','N','#month(0)#,#day(0)#')
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLO','人员',5,10,1,null,null,'po_storereq_b.pk_apppsn','申请人',null,'N','Y','N','Y','N','N','N','N','N','Y','N','N','N','N','Y',null,'Y',9999,null,'=@','等于@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020049',2,null,null,'2014-05-26 19:08:51','N',null)
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLP','部门',5,11,1,null,null,'po_storereq_b.pk_appdept','申请部门',null,'N','Y','N','Y','N','N','N','N','N','Y','N','N','N','N','Y',null,'Y',9999,null,'=@','等于@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020050',2,null,null,'2014-05-26 19:08:51','N',null)
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLQ','项目',5,12,1,null,null,'po_storereq.pk_project','项目',null,'N','Y','N','N','N','N','N','N','N','Y','N','N','N','N','Y',null,'Y',9999,null,'=@','等于@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020051',2,null,null,'2014-05-18 12:53:56','N',null)
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLR','地区分类',5,13,1,null,null,'po_storereq_b.cdevareaid','收货地区',null,'N','Y','N','N','N','N','N','N','N','Y','N','Y','N','N','Y',null,'Y',9999,null,'=@','等于@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020052',2,null,null,'2014-05-26 19:07:54','N',null)
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1001Z810000000009ZLS','地点档案',5,14,1,null,null,'po_storereq_b.cdevaddrid','收货地点',null,'N','Y','N','N','N','N','N','N','N','Y','N','Y','N','N','Y',null,'Y',9999,null,'=@','等于@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020053',2,null,null,'2014-05-26 19:07:54','N',null)
go

insert into pub_query_condition(id,consult_code,data_type,disp_sequence,disp_type,disp_value,dr,field_code,field_name,guideline,if_attrrefused,if_autocheck,if_datapower,if_default,if_desc,if_group,if_immobility,if_multicorpref,if_must,if_notmdcondition,if_order,if_subincluded,if_sum,if_sysfuncrefused,if_used,instrumentsql,iscondition,limits,max_length,opera_code,opera_name,order_sequence,pk_corp,pk_templet,prerestrict,resid,return_type,table_code,table_name,ts,userdefflag,value) values('1002Z81000000000KOLN','影响因素交 易类型',5,15,1,null,0,'ctrantypeid','物资需求申请类型',null,'N','Y','N','N','N','N','N','N','N','Y','N','N','N','N','Y',null,'Y',9999,null,'=@','等于@',0,'@@@@','1001Z810000000009ZLC',null,'1400400020054',2,null,null,'2015-07-08 11:35:04','N',null)
go
