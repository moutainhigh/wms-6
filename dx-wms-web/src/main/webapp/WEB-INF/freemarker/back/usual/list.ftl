<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="往期回款" home="回款管理" item={"往期回款":"/back/usual/list.htm"} />
    <@portlet title="往期回款" formId="queryForm">
    	<div class="row-fluid h50">
	    	<@div title="出借编号">
	        	<@text id="lenderCode" name="lenderCode"/>
	        </@div>
	        <@div title="账单日">
	        	<@select id="billDay" name="billDay" source=port/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="出借方式">
	        	<@select id="productId" name="productId" source=productsForBackUsul/>
	        </@div>
	        <div style="float:right;margin:5px 10px 0 0"class="span5 responsive">
	            <@query/><@reset/><@btn value="导出" id="excelReport" name="excelReport" /><@btn value="推送" id="" name="push" />
	        </div>
	    </div>
	    <@datatable id="result" items=["checkbox","客户姓名","身份证","出借编号","出借方式","本报告日出借人实际回收利息","账单日","账户级别","开户行","账户名","账号","营业部"] />
	</@portlet>
</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/back/usual/list.js" type="text/javascript"></script> 
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
 