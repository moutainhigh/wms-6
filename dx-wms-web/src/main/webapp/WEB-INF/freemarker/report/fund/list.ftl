<style>
	.report-modal{
    	left: 41%;
		width: 765px;
		height:auto;
		top: 1% !important;
		position:absolute;
    }
</style>
<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="资金报告" home="报告管理" item={"资金报告":"/report/fund/list.htm"} />
    <@portlet title="资金报告" formId="queryForm">
    	<div class="row-fluid h50">
    		<@div title="客户编号">
	        	<@text id="lenderCustCode" name="lenderCustCode"/>
	        </@div>
	    	<@div title="出借编号">
	        	<@text id="lenderCode" name="lenderCode"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
   			<@div title="账单日">
				<@select id="billDay" name="billDay" source=port />
	        </@div>
	    	<@div title="统计日期（年/月）">
	        	<@date id="countTime" name="countTime" format="yyyy/mm"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
   			<div class="span5 responsive" style="float: right;">
	       		<@query/><@reset/><@btn value="导出" id="report" name="report" />
				<div id="waitexper"  style="display:none;margin-right: 10%; margin-left: 28.3%; margin-top: -7.8%;">
	   				<div>
	   					<@btn value="列表导出" id="" name="excReport" />
	   				</div> 
	   				<div style="margin-top: 2%; margin-left: 0.5%;">
	   					<@btn value="PDF导出" id="" name="pdfReport" />
	   				</div>  
   				</div>
    	 	</div>
	    </div>
	    <@datatable id="result" items=["checkbox","客户编号","客户姓名","客户地址","客户邮编","报告周期起期","报告日","账户级别","出借编号","资金出借及回收方式","初始出借日期","初始出借金额","上一个报告日资产总额","本报告日资产总额","本报告日出借人应回收款金额","本报告日预计出借金额","本报告日出借人实际回收款金额","服务费率(月)","服务费","本报告日实际资产总额"] />
	</@portlet>
</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/report/fund/list.js" type="text/javascript"></script> 
<!-- END PAGE LEVEL SCRIPTS -->
<script>
	var base = "${baseUrl}";
	var resBase = "${resRoot}";
    (function($) {
        $(function() {
            App.init();
            FormComponents.init();
        });
    })(jQuery);    
</script>
 