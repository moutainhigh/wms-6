<#include "/macro/base.ftl">
<#import "hr/approve_log.ftl" as logInfo>
<#import "fileBase/baseInfo.ftl" as baseInfo>
<div class="container-fluid">
	<div class="portlet-body">
        <#if detail.employeeEntryVo.logDtos?exists>
		<h4 class="form-section">员工日志</h4>
		<div class="row-fluid">
			<!-- <#list detail.employeeEntryVo.logDtos as logDto> 
			</#list>-->
			<@logInfo.approveLogModel results=detail.employeeEntryVo.logDtos />
		</div>
        <#else>
        </#if>
	</div>
</div>
<script src="${baseUrl}/assets/js/hr/entry/entry_approve.js"></script>