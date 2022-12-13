<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="理财管理" home="理财管理" item={"产品变更":"/op/invest/update/list.htm"} />
    <@portlet title="产品变更" formId="queryForm">
    	<div class="row-fluid h50">
	    	<@div title="出借编号">
	        	<@text id="lenderCode" name="lenderCode"/>
	        </@div>
	        <@div title="姓名">
	        	<@text id="custName" name="custName"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<div class="span7 responsive">
	    	</div>
	        <div class="span5 responsive">
	           <@query/> <@reset/>
	        </div>
	    </div>
	    <@datatable id="result" items=["客户姓名","出借编号","客户编号","身份证号","初始出借金额","出借方式","当前资产价值","首次匹配日期","账单日","计息日","操作"] />
	</@portlet>
</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/reset/reset.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/op/invest/update/list.js" type="text/javascript"></script>  
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
 