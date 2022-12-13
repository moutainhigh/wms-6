<style>
	.find-modal{
    	left: 31%;
		width: 80%;
		height:auto;
		top: 1% !important;
    }
</style>
<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="回款匹配" home="匹配管理" item={"回款匹配":"/match/back/list.htm"} />
    <@portlet title="回款匹配" formId="queryForm">
    	<div class="row-fluid h50">
	    	<@div title="待匹配金额-起（万）">
	        	<@text id="matchAmountFrom" name="matchAmountFrom"/>
	        </@div>
	        <@div title="待匹配金额-止（万）">
	        	<@text id="matchAmountTo" name="matchAmountTo"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
		    <@div title="出借编号">
		        	<@text id="lenderCode" name="matchAmountTo"/>
		    </@div>
		    <@div title="出借方式" span="span7">
	        	<@select source=product name="productId" id="productId"/>
	        </@div>
        </div>
	    <div class="row-fluid h50" >
	    	<div class="span5 responsive" style="float: right;">
	            <@query/><@btn id="more" name="more" value="多对多匹配"/><@reset/>
	        </div>
	    </div>
	    <div class="row-fluid" id="statBody"></div>
	    <@line/>
	    <@datatable id="result" items=["checkbox","客户姓名","身份证","出借编号","出借金额","待匹配金额","出借方式","冻结周期","当前期数","报告日","投资生效日","操作"] checkId="investAll"/>
	</@portlet>
</div>
<@modal id="findModal" name="find-modal"/>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/reset/reset.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/credit/current/list.js" type="text/javascript"></script>  
<script src="${baseUrl}/assets/js/match/back/list.js" type="text/javascript"></script>  
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
 