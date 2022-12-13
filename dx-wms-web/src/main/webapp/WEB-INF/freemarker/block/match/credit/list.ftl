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
	    <@mPortlet title="债权列表" formId="findForm">
	    	<@hidden name="userId" id="userId" value=userId />
	    	<@datatable id="resultCredit" items=["信贷客户","剩余债权","初始债权","还款期数","剩余期数","年利率","还款日","产品类型"] />
			<@mBottom />	 
		</@mPortlet>
	</div>			
</div>
<script src="${baseUrl}/assets/js/block/match/credit/list.js" type="text/javascript"></script> 