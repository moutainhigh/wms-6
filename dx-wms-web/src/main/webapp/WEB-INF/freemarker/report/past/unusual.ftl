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
    <@head title="异常匹配详情" home="报告管理" item={"异常匹配详情":"/report/past/unusual.htm"} />
    <@portlet title="异常匹配详情" formId="queryForm">
		<@hidden id="createTimePre" name="createTimePre" value=createTimePre/>
		<@hidden id="reportDayPre" name="reportDayPre" value=reportDayPre/>
    	<div class="row-fluid h50">
	    	<@div title="出借编号">
	        	<@text id="lenderCode" name="lenderCode"/>
	        </@div>
	        <@div title="出借人身份证">
	        	<@text id="idCard" name="idCard"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="报告日">
				<@select id="reportDay" name="reportDay" source=port />
	        </@div>
			<div class="span5 responsive" style="float: right;">
	           <@query/> <@reset/><@btn value="导出" id="" name="report" />
   				<div id="waitexper"  style="display:none;margin-right: 10%; margin-left: 28.3%; margin-top: -7.8%;">
	   				<div>
	   					<@btn value="列表导出" id="" name="excelReport" />
	   				</div> 
	   				<div style="margin-top: 2%; margin-left: 0.5%;">
	   					<@btn value="PDF导出" id="" name="pdfReport" />
	   				</div>  
   				</div> 
	        </div>
	    </div>
	    <@datatable id="result" items=["checkbox","客户姓名","身份证","出借编号","出借金额","异常匹配金额","出借方式","报告日","投资生效日","操作"] />
	</@portlet>
</div>
<@modal id="reportModal" name="report-modal"/>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/reset/reset.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/report/past/unusual.js" type="text/javascript"></script>  
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
 