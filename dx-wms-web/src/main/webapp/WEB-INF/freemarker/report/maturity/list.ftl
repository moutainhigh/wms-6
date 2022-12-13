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
    <@head title="到期匹配详情" home="报告管理" item={"到期匹配详情":"/report/maturity/list.htm"} />
    <@portlet title="到期匹配详情" formId="queryForm">
    	<div class="row-fluid h50">
	    	<@div title="出借编号">
	        	<@text id="lenderCode" name="lenderCode"/>
	        </@div>
	        <@div title="身份证">
	        	<@text id="idCard" name="idCard"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
		    <@div title="转让日期-起">
		        <@date id="transTimeBegin" name="transTimeBegin"/>
		    </@div>
		    <@div title="转让日期-止">
		        <@date id="transTimeEnd" name="transTimeEnd" />
	        </@div>
	     </div>
	    <div class="row-fluid h50">
	    	<@div title="出借方式">
	        	<@select id="productId" name="productId" source=products />
	        </@div>
	    	<@div title="账单日">
				<@select id="billDay" name="billDay" source=port />
	        </@div>
	    </div>
	    <div class="row-fluid" style="height: 70px !important;">
	    	<div class="span7 responsive">
	    	</div>
	        <div class="span5 responsive">
	           <@query/> <@reset/><@btn value="导出" id="" name="report" />
   				<div id="waitexper"  style="display:none;margin-right: 10%; margin-left: 28.3%; margin-top: -7.8%;">
	   				<div>
	   					<@btn value="列表导出" id="" name="excelReport" />
	   				</div> 
	   				<div style="margin-top: 2%; margin-left: 0.5%;">
	   					<@btn value="PDF导出" id="" name="pdfReport" />
	   				</div>  
   				</div> 
	        </div>
	    </div>
	    <@datatable id="result" items=["checkbox","出借编号","客户姓名","身份证号","邮编","地址",
	    				"资金出借及回收方式","初始出借金额","初始出借日期","转让日债权价值","转让对价","转让服务费",
						"账户管理费","账户名","开户银行","账号","账单日","转让日期","操作"] />
	</@portlet>
</div>
<@modal id="reportModal" name="report-modal"/>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/reset/reset.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/report/maturity/list.js" type="text/javascript"></script>  
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
 