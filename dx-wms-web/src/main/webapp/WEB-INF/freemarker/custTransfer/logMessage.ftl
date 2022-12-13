<style>
	.error{
		color: #b94a48;
		margin-right:30%;
	}
	.modal-fluid{
		padding-top: 20px !important; 
		padding-bottom: 20px !important;
	}
	.modal-fluid .portlet{
		margin-bottom: 0px !important;
	}
	.modal-fluid .portlet .portlet-body{
		padding-bottom: 0px !important;
	}
</style>
<#include "/macro/base.ftl">
<div class="container-fluid modal-fluid">
    <div class="portlet box blue">
	    <@portlet title="转移记录" formId="queryForm">
        <@hidden id="lenderCustCode" name="lenderCustCode" value=lenderCustCode/>
        <@datatable id="result" items=["客户编号","客户姓名","原营业部","原大团","原团队","原客户经理","转移后营业部","转移后大团","转移后团队","转移后客户经理","转移时间"] />
    </@portlet>
	</div>			
</div>
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/custTransfer/logMessage.js" type="text/javascript"></script>
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
 