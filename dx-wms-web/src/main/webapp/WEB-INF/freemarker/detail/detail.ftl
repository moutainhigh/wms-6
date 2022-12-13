<#include "/macro/base.ftl">
<div class="container-fluid">
    <div class="top"/>
    <!-- END PAGE TITLE & BREADCRUMB-->
    <div class="portlet box blue tabbable">
    	<@mPortlet title=detail.title formId="submit_form">
        	<@hidden name="custAccountId" id="custAccountId" value="detail.account.custAccountId"/>
            <!--BEGIN TABS-->
            <div class="tabbable portlet-tabs">
                <ul class="nav nav-tabs">
                	<#list detail.tabs as tab>
                    	<li class="${tab.tabClass}"><a href="#${tab.tabId}" data-toggle="tab" >${tab.tabTitle}</a></li>
                    </#list>
                </ul>
                <div class="tab-content h350-y" style="overflow-x: hidden;">
                	<#list detail.tabs as tab>
                		<div class="tab-pane ${tab.tabClass}" id="${tab.tabId}">
							<#include tab.tabUrl>               
                        </div>
                    </#list>                           	       
                </div>
            </div>
        </@mPortlet>
        <@mBottom/>	
    </div>
</div>     
<link href="${baseUrl}/assets/css/detail/detail.css" rel="stylesheet" type="text/css" />   

<script>
	<#--查看详情时除掉特殊收益后的'%'以及特殊额度后的'元'-->
	$(function(){
		var conditions=$(".condition");
		$.each(conditions,function(index,item){
			var condition=$(item).text();
			$(item).text($.trim(condition.substring(0,condition.length-1)))
		});
	});
</script>