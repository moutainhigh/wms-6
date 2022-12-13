<#include "/macro/base.ftl">
<div class="container-fluid">
    <div class="top"/>
    <div class="portlet box blue">
	    <@mPortlet title="选择客户" formId="selectForm">  
	    	<@hidden name="biz" id="biz" value=biz />
		    <div class="row-fluid h50">
		    	<@div title="客户姓名">
	            	<@text name="custName" class="span10"/>
	            </@div>
	            <@div title="证件号码">	
	            	<@text name="idCard" class="span10"/>
	            </@div>
	            <@query name="query"/>
	        </div>
		    <@line/>
			<@datatable id="selectList" items=["客户姓名","证件类型","证件号码","移动电话","性别","操作"] />
		<@mBottom /> 
		</@mPortlet>
	</div>			
</div>
<script src="${baseUrl}/assets/js/select/select.js" type="text/javascript"/>