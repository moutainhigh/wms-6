<#include "/macro/base.ftl">
<h4 class="form-section">个人信息</h4>
<div class="row-fluid">
    <@div title="出生日期" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">
    	<input class="span10 m-wrap m-ctrl-medium date-picker birthDate" readonly size="16" name="birthDate" type="text" value="<#if saver.account.birthDate?exists>${saver.account.birthDate?string("yyyy-MM-dd")}</#if>" data-date-format="yyyy-mm-dd" />
    </@div>
    <@div title="开户日期" required=true labelClass="w140" controlsClass="ml160" >	
        <input class="span10 m-wrap m-ctrl-medium date-picker openDate" readonly size="16" name="openDate" type="text" value="<#if saver.account.openDate?exists>${saver.account.openDate?string("yyyy-MM-dd")}</#if>" data-date-format="yyyy-mm-dd">
    </@div>
</div>
<div class="row-fluid">
	<@div title="婚姻状况" labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">
		<@select source=maritalStatus target=saver.account.maritalStatus name="maritalStatus" class="span10"/>
	</@div>
	<@div title="最高学历"  labelClass="w140" controlsClass="ml160" >	
       <@select source=education target=saver.account.education  class="span10 education"/>
    </@div>
</div>
<div class="row-fluid" >
	 <@div title="接受文件方式" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
       <@select source=msgWay target=saver.account.msgWay name="msgWay" class="span10"  />
    </@div>
	<@div title="客户分类" required=true labelClass="w140" controlsClass="ml160" >
    	<@select source=custCategory target=saver.account.custCategory name="custCategory" inline="true" class="span10" />
    </@div>
</div>
<div class="row-fluid">
    <@div title="职业" labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">
		<@select source=profession target=saver.profession.profession name="profession" class="span10"/>
	</@div>
	<@div title="行业" labelClass="w140" controlsClass="ml160">	
        <@text name="industry" value=saver.profession.industry inline=true class="span10"/>
    </@div>
</div>
<div class="row-fluid">
   	<@div title="单位名称" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
        <@text name="companyName"value=saver.profession.companyName inline=true class="span10"/>
    </@div>
	<@div title="职位" labelClass="w140" controlsClass="ml160" >	
        <@text name="post"value=saver.profession.post inline=true class="span10"/>
    </@div>
</div>