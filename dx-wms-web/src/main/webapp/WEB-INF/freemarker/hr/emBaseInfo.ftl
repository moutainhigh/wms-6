<#include "/macro/base.ftl">
<#import "/fileBase/baseInfo.ftl" as baseInfo>
<#macro  queryPage hTitle="" hHome="" hItem="" mTitle="" mButton=[] array=[]  tableItem=[] isShow="">
	<@head title=hTitle home=hHome item=hItem />
	<@portlet title=mTitle formId="refundForm">
		<input type="hidden" class="isShow" name="isShow" value="${isShow}">
		<div class="top"></div>
		<div class="row-fluid h50">
			<@div title="工作性质">	
            	<@select source=jobCategory name="jobCategory"/>
            </@div>
            <@div title="岗位职务">	
            	<@select source=position name="positionName"/>
            </@div>
		</div>
		<div class="row-fluid h50">
			<@div title="移动电话">
				<@text name="mobile" />
			</@div>
			<@div title="员工姓名">
				<@text name="employeeName" />
			</@div>
		</div>
		<div class="row-fluid h50">
			<#if array?seq_contains("formStatus")>
				<@div title="状态" span="span5">
					<@mSelect source=employeeStatus name="formStatus" array=["E","Q"]/>
				</@div>
			<#elseif array?seq_contains("employeeNo")>
				<@div title="员工编号" span="span5">
                     <@text name="employeeNo" name="employeeNo"/> 
				</@div>
			<#else>
				<div class="span5 responsive"></div>
			</#if>
			<@baseInfo.queryButtonModel>
				<#if mButton?seq_contains("load")>
					<input type="button" class="btn blue" value="下载模板" id="load">
				</#if>
				<#if mButton?seq_contains("create")>
					<input type="button" class="btn red" value="+创建" id="create">
				</#if>
				<#if mButton?seq_contains("import")>
					<input type="button" class="btn red" value="导入" id="import">
				</#if>
			</@baseInfo.queryButtonModel>
		</div>
		<@line />
		<@datatable id="resultList" items=tableItem />
	</@portlet>
</#macro>