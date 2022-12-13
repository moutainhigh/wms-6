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
    <@head title="续投匹配" home="匹配管理" item={"续投匹配":"/match/continue/list.htm"} />
    <@portlet title="续投匹配" formId="queryForm">
    	<div class="row-fluid h50">
	    	<@div title="出借编号">
	        	<@text id="lenderCode" name="lenderCode"/>
	        </@div>
	        <@div title="出借方式">
	        	<@select source=product name="productId" id="productId"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="待匹配金额-起（万）">
	        	<@text id="matchAmountFrom" name="matchAmountFrom"/>
	        </@div>
	        <@div title="待匹配金额-止（万）">
	        	<@text id="matchAmountTo" name="matchAmountTo"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="进件日期-起">
	        	<@date id="createDateBegin" name="createDateBegin" />
	        </@div>
	        <@div title="进件日期-止">
		        <@date id="createDateEnd" name="createDateEnd" />
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    <!--
	    	<@div title="客户分类" span="span7">
	        	<@select source=category name="category" id="category"/>
	        </@div>
		-->
	        <div style="float:right;margin:5px 10px 0 0"class="span5 responsive">
	            <@query/><@reset/>
	        </div>
	    </div>
	    <div class="row-fluid" id="statBody"></div>
	    <@line/>
	    <@datatable id="result" items=["客户姓名","身份证","原出借编号","原出借金额","投资到期日","出借编号","出借方式","出借金额","进件日期","操作"] />
	</@portlet>
</div>
<@modal id="findModal" name="find-modal"/>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/reset/reset.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/credit/current/list.js" type="text/javascript"></script>  
<script src="${baseUrl}/assets/js/match/continue/list.js" type="text/javascript"></script>  
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
 