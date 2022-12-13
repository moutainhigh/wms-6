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
    <@head title="异常匹配详情" home="异常管理" item={"异常匹配详情":"/block/match/list.htm"} />
    <@portlet title="异常匹配详情" formId="queryForm">
        <@datatable id="result" items=["当前匹配人","占用投资数","占用债权数","操作"] />
	</@portlet>
</div>
<@modal id="findModal" name="find-modal"/>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/block/match/list.js" type="text/javascript"></script>  

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
 