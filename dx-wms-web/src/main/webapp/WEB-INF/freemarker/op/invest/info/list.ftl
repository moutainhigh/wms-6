<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="理财管理" home="理财管理" item={"理财信息管理":"/op/invest/list.htm"} />
    <@portlet title="理财信息管理" formId="queryForm">
    	<div class="row-fluid h50">
	    	<@div title="出借编号">
	        	<@text id="lenderCode" name="lenderCode"/>
	        </@div>
	        <@div title="客户姓名">
	        	<@text id="custName" name="custName"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="身份证">
	        	<@text id="idCard" name="idCard" />
	        </@div>
	        <@div title="出借方式">
		        <@select id="productId" name="productId" source=products/>
	       </@div>
	    </div>
	     <div class="row-fluid h50">
	    	<@div title="状态">
	        	<@select  id="currentStepKey" name="currentStepKey" source=status />
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<div class="span7 responsive">
	    	</div>
	        <div class="span5 responsive">
	           <@query/> <@reset/>
	        </div>
	    </div>
	    <@datatable id="result" items=["出借编号","客户姓名","身份证号","出借方式","出借金额","状态","操作"] />
	</@portlet>
</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/reset/reset.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/op/invest/info/list.js" type="text/javascript"></script> 
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
 