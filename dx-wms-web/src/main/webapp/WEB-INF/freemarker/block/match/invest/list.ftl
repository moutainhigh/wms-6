<style>
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
 		<@mPortlet title="投资列表" formId="findForm">
	    	<@hidden name="userId" id="userId" value=userId />
	    	<@datatable id="resultInvest" items=["理财客户","身份证号","出借编号","需匹配金额"] />
			<@mBottom />	 
		</@mPortlet>
	</div>
</div>
<script src="${baseUrl}/assets/js/block/match/invest/list.js" type="text/javascript"></script> 