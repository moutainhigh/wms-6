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
<#include "/macro/imageData.ftl">
<div class="container-fluid">
    <@head title="综合信息管理" home="理财管理 " item={"综合信息管理":"#"} />
    <@portlet title="综合信息管理" formId="accountForm">
	<div class="portlet-title" style="height: 30px;margin-bottom: 5px;">
		<span>${detail.applyVo.lenderCode}</span>
	</div>
	<div class="row-fluid" >
		<div class="span6">
		<@imageDataFrag  style = "margin-left: 155px; margin-top:40px;" approve="影像件"/>
		</div>
		<div class="span6">
		<div class="portlet box blue tabbable " style="width: 100%;">           
				<@mPortlet title=detail.title formId="submit_form">
	            <!--BEGIN TABS-->
	            <div class="tabbable portlet-tabs">
	                <ul class="nav nav-tabs">
	                	<#list detail.tabs as tab>
	                    	<li class="${tab.tabClass}"><a href="#${tab.tabId}" data-toggle="tab" >${tab.tabTitle}</a></li>
	                    </#list>
	                </ul>
	                <div class="tab-content h550-y" style="overflow-x: hidden;">
	                	<#list detail.tabs as tab>
	                		<div class="tab-pane ${tab.tabClass}" id="${tab.tabId}">
								<#include tab.tabUrl>               
	                        </div>
	                    </#list>                           	       
	                </div>
	            </div>
     			</@mPortlet>
			</div>
			</div>
	</div>
</@portlet>
</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<link href="${baseUrl}/assets/css/detail/detail.css" rel="stylesheet" type="text/css" />     	
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/infoManage/detail.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/infoManage/detail.js" type="text/javascript"></script>
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
 