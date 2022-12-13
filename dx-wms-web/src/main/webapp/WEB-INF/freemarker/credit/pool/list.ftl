<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="债权明细" home="债权管理" item={"债权明细":"/credit/pool/list.htm"} />
    <@portlet title="债权明细" formId="queryForm">
    	<div class="row-fluid h50">
	    	<@div title="姓名">
	        	<@text id="custName" name="custName"/>
	        </@div>
	        <@div title="身份证">
	        	<@text id="idCard" name="idCard"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="合同编号">
	        	<@text id="contractNo" name="contractNo"/>
	        </@div>
	        <@div title="还款日">
	        	<@select source=port name="repayDay" id="repayDay"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="统计日期（起）">
	        	<@date id="createDateBegin" name="createDateBegin" />
	        </@div>
	        <@div title="统计日期（止）">
		        <@date id="createDateEnd" name="createDateEnd" />
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<div class="span7 responsive">
	    	</div>
	        <div class="span5 responsive">
	            <@query/><@reset/><@btn value="导出" id="" name="excelReport" />
	        </div>
	    </div>
	    <@datatable id="result" items=["客户姓名","身份证","合同编号","还款日","初始借款金额","还款起始","还款期限"," 剩余还款月数","年利率","产品类型","每期还款","月利率","已还款期数"," 当期剩余本金","当期新增资金","当前剩余债权","上期债权总价值","上期已匹配价值","上期未匹配价值","上期应还利息","上期应还本金"] />
	</@portlet>
</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/credit/pool/list.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/reset/reset.js" type="text/javascript"></script> 
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
 