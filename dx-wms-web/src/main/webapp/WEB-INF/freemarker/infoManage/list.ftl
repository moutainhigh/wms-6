<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="综合信息管理" home="综合信息" item={"综合信息管理":"/infoManage/list.htm"} />
    <@portlet title="综合信息管理" formId="accountForm">
    	<div class="row-fluid h50">
	    	<@div title="出借编号">
	        	<@text id="lenderCode" name="lenderCode"/>
	        </@div>
	        <@div title="客户姓名">
	        	<@text id="custName" name="custName"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	   	 	<@div title="证件号码">
	        	<@text id="idCard" name="idCard"/>
	        </@div>
	    	<@div title="出借方式">
				<@select id="productId" name="productId" source=product />
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	   	 	<@div title="状态">
	        	<@select id="currentStep" name="currentStep" source=currentStep />
	        </@div>
	    	<div class="span5 responsive pull-right">
                <@query/>
   				<@reset/>
          	</div>
	    </div>
	    <@datatable id="resultList" items=["出借编号","客户姓名","证件号码","出借方式","出借金额(元)","签单日期","状态","生效时间","账单日","到期日","操作"] />
	</@portlet>
</div>
<@modal id="infoManageModel" name="infoManage-modal"/>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/reset/reset.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/infoManage/list.js" type="text/javascript"></script>  
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
 