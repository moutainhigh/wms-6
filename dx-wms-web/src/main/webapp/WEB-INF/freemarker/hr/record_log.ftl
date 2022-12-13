<#import "macro/base.ftl" as base>
<#import "fileBase/baseInfo.ftl" as baseInfo>
<#import "hr/approve_log.ftl" as logInfo>

<#macro recordLog>
<div class="container-fluid">
	<@base.head title="员工管理" home="员工管理" item={"审批记录":"/hrApproveLog/"+biz+".htm","日志":"/hrApproveLog/showLog.htm?employeeId="+employeeId} indexTo=false />
	<@base.portlet title="日志" formId="" formClass="formClass">
		<@logInfo.simpleLogModel title="入职审批记录" block="entryRecords" titles=["审批人","审批时间","审批结果","审批内容"] />
		<@logInfo.simpleLogModel title="异动审批记录" block="moveRecords" titles=["审批人","审批时间","审批结果","审批内容"] />
		<div style="text-align: right;" class="control-group span6">
			<input type="button" class="btn red" value="关闭" id="close">
		</div>
		<div style="clear:both;height:1px;width:100%; overflow:hidden; margin-top:-1px;"></div>
	</@base.portlet>
</div>	
</#macro>

