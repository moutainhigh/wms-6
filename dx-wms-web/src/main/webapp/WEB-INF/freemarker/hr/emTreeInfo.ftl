<#include "macro/base.ftl">
<#import "/fileBase/baseInfo.ftl" as baseInfo>
<#macro queryPage hTitle="" hHome="" hItem="" mTitle="" mTableTitle="" array=[]  tableItem=[]>
	
	<@head title=hTitle home=hHome item=hItem/>
  	<@portlet title=mTitle formId="refundForm" formClass="formClass">
  		<div id="content" class="row-fluid">
			<div class="span2">
				<@portlet title="组织列表" isForm=false name="org">
  					<input type="hidden" id="orgId">
  					<ul class="tree" id="tree_1">
  					</ul>
  				</@portlet>
			</div>
			<div class="span10" >
				<@portlet title=mTableTitle  isForm=false>
					<div class="top"></div>
   						<div class="row-fluid mleft h50">
	   						<@div title="工作性质">
	   							<@select source=jobCategory name="jobCategory"/>
	   						</@div>
	   						<@div title="岗位职务">
	   							<@select source=position name="positionName"/>
	   						</@div>
   						</div>
   						<div class="row-fluid mleft h50">
   							<@div title="移动电话">
   								<@text name="mobile"/>
   							</@div>
   							<@div title="员工姓名">
   								<@text name="employeeName"/>
   							</@div>
   							
   						</div>
   						<div class="row-fluid mleft h50">
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
   							<@baseInfo.queryButtonModel />
   						</div>
   						<@line />
   						<@datatable id="resultList" items=tableItem />
				</@portlet>
   			</div>
   			<div style="clear:both;height:1px;width:100%; overflow:hidden; margin-top:-1px;"></div>
		</div>
  	</@portlet>
</#macro>