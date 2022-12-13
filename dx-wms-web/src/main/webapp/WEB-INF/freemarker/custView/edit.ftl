<#include "/macro/base.ftl">
<div class="container-fluid">
	<div class="top"/>
    <div class="portlet box blue">
    	<@mPortlet title="客户360视图" formId="submit_form">
       		<@hidden name="custId" id="custId" value=base.custId />
       		<@hidden name="dataStatus" value=base.dataStatus />
       		<@hidden name="createUser" value=base.createUser />
       		<@hidden name="custCode" value=base.custCode />
       		<div class="row-fluid h70">
       			<@div title="客户姓名" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
                	<@text name="custName" value=base.custName inline=true />
                </@div>
                <@div title="移动电话" required=true labelClass="w140" controlsClass="ml160">	
                	<@text name="mobile" value=base.mobile inline=true />
                </@div>
        	</div>
        	<div class="row-fluid h70">
        		<@div title="证件类型" labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">
                    <@select source=idType target=base.idType name="idType" inline="true"/>
                </@div>
                <@div title="证件号码" labelClass="w140" controlsClass="ml160">
                    <@text name="idCard" value=base.idCard inline=true />
               	</@div>
        	</div>
        	<div class="row-fluid h70">
                <@div title="性别" labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">
                    <@select source=sex target=base.sex name="sex"/>
                </@div>
                <@div title="注册日期" labelClass="w140" controlsClass="ml160" >
                    <@text name="createTime" value=base.registerTime readonly=true />
                </@div>
            </div>
            <div class="row-fluid h70">
                <@div title="客户来源" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
                	<@select source=custSource target=base.custSource name="custSource"/>
                </@div>
                <@div title="其他" divClass="hide-div" required=true labelClass="w140" controlsClass="ml160" >	
                    <@text name="custSourceOther" value=base.custSourceOther inline=true />
                </@div>
        	</div>
        </@mPortlet> 
    	<@mBottom>
    		<input type="button" class="btn blue save" value="保存" />
        </@mBottom>
	</div>    	
</div>
<script type="text/javascript" src="${baseUrl}/assets/js/custView/edit.js" /> 
<script type="text/javascript" src="${baseUrl}/assets/js/custView/edit.validate.js" /> 

 