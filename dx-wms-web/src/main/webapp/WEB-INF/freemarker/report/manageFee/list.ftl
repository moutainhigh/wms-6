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
    <@head title="服务费收取明细" home="报告管理" item={"服务费收取明细":"/report/manage/list.htm"} />
    <@portlet title="服务费收取明细" formId="queryForm">
    	<div class="row-fluid h50">
	    	<@div title="出借编号">
	        	<@text id="lenderCode" name="lenderCode"/>
	        </@div>
	        <@div title="账单日">
	        	<@select id="billDay" name="billDay" source=port />
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="统计日期（年/月）">
	        	<@date1 id="statisticDate" name="statisticDate" />
	        </@div>
			<div class="span5 responsive" style="float: right;">
	       		<@query/><@reset/><@btn value="导出" id="" name="report" />
    	 	</div>
	    </div>
	    <@datatable id="result" items=["出借编号","客户姓名","身份证号","账户级别","资金出借及回收方式","账单日","服务费","开户银行","账户名","账号","营业部","统计日期"] />
	</@portlet>
</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/report/manageFee/list.js" type="text/javascript"></script> 
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
 