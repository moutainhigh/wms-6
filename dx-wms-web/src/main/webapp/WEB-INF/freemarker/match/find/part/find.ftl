<style>
	.error{
		color: #b94a48;
		margin-right:30%;
	}
	.modal-fluid{
		padding-top: 20px !important; 
		padding-bottom: 20px !important;
	}
	.modal-fluid .portlet{
		margin-bottom: 0px !important;
	}
	.modal-fluid .portlet .portlet-body{
		padding-bottom: 0px !important;
	}
</style>
<#include "/macro/base.ftl">
<div class="container-fluid modal-fluid">
    <div class="portlet box blue">
	    <@mPortlet title="多对多匹配" formId="findForm">
	    	<#include findHead>
			<div id="findBody">
				<#include "/match/find/list.ftl">			
			</div>
			<@mBottom>
				<span class="error">${msg}</span>
				<#if flag?exists && flag > 
					<@btn value="自动匹配" name="find-next" color="blue" />
					<@btn value="推荐" id="join" name="join" />
					<@btn value="回推荐" name="find-last" color="blue"  />
					<@btn value="匹配" name="match" />
				</#if>	
			</@mBottom>	 
		</@mPortlet>
	</div>			
</div>
<script src="${baseUrl}/assets/js/match/find/find.js" type="text/javascript"/>
<script src="${baseUrl}/assets/js/match/find/part/find.js" type="text/javascript"/>