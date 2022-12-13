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
    <@head title="异常利息详情" home="异常管理" item={"异常利息详情":"/block/interest/list.htm"} />
    <@portlet title="异常利息详情" formId="queryForm">
        <@datatable id="result" items=["出借客户","出借编号","借款客户","身份证","合同编号","转让债权价值","转让还款金额","转让债权比例","转让本金","转让利息","差异利息","当前债权总价值","初始债权价值","还款金额","还款期限","剩余期限"] />
	</@portlet>
</div>
<@modal id="findModal" name="find-modal"/>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/block/interest/list.js" type="text/javascript"></script>  

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
 