<style>
	.report-modal{
    	left: 41%;
		width: 765px;
		height:auto;
		top: 1% !important;
		position:absolute;
    }
</style>
<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="每日匹配详情" home="投资管理" item={"每日匹配详情":"/invest/pool/list.htm"} />
    <@portlet title="每日匹配详情" formId="queryForm">
    	<div class="row-fluid h50">
	    	<@div title="出借编号">
	        	<@text id="lenderCode" name="lenderCode"/>
	        </@div>
	        <@div title="身份证">
	        	<@text id="idCard" name="idCard"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="匹配日期（起）">
	        	<@date id="initMatchDateBegin" name="initMatchDateBegin" />
	        </@div>
	        <@div title="匹配日期（止）">
		        <@date id="initMatchDateEnd" name="initMatchDateEnd" />
	        </@div>
	    </div>
	    <div class="row-fluid" style="height: 70px !important;">
	    	<div class="span7 responsive">
	    	</div>
	        <div class="span5 responsive">
	           <@query/> <@reset/><@btn value="导出" id="" name="report" />
   				<div id="waitexper"  style="display:none;margin-right: 10%; margin-left: 28.3%; margin-top: -7.8%;">
	   				<div>
	   					<@btn value="列表导出" id="" name="listReport" />
	   				</div> 
	   				<div style="margin-top: 2%; margin-left: 0.5%;">
	   					<@btn value="PDF导出" id="" name="pdfReport" />
	   				</div>  
   				</div> 
	        </div>
	    </div>
	    <@datatable id="result" items=["checkbox","申请日期","出借编号","客户姓名","性别","身份证号","出借方式","出借金额","客户分类","预计出借日期","支付方式","划扣银行","划扣账号","账户名","回款银行","回款账号","账户名","联系地址","邮编","团队主管","客户经理","区域","营业部","接受文件方式","电子邮箱","手机号","账单日","匹配日期","操作"] />
	</@portlet>
</div>
<@modal id="reportModal" name="report-modal"/>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/reset/reset.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/invest/pool/list.js" type="text/javascript"></script>  
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
 