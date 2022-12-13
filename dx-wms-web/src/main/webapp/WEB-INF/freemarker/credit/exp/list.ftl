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
	    <@mPortlet title="异常债权" formId="findForm">
	    	<@hidden name="port" id="port" value=port />
	    	<@datatable id="resultCredit" items=["信贷客户","身份证","合同编号","产品类型","还款日","初始债权","剩余债权","还款期数","剩余期数","年利率","匹配数"] />
			<@mBottom />	 
		</@mPortlet>
	</div>			
</div>
<script src="${baseUrl}/assets/js/credit/exp/list.js" type="text/javascript"></script> 