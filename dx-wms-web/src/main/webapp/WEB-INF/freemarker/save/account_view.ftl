<style>
	.width{
		width: 180px;
	}
</style>
<#include "/macro/base.ftl">
<h4 class="form-section txt-left">基本信息</h4>
<div class="row-fluid h40">
	<@div title="姓名" span="span4" controlsClass="content">${saver.accountVo.custName}</@div>
	<@div title="移动电话" span="span4" controlsClass="content">${saver.accountVo.mobile}</@div>
</div>
<h4 class="form-section txt-left">详细信息</h4>    
<div class="row-fluid h40">
 	<@div title="姓名(拼音)" span="span4" controlsClass="content">${saver.accountVo.custNameSpell}</@div>
	<@div title="性别" span="span4" controlsClass="content">${saver.accountVo.sex}</@div>
	<@div title="账户级别" span="span4" controlsClass="content"><span class="label label-danger">待完善</span></@div>
</div>
<div class="row-fluid h40">
	<@div title="国籍" span="span4" controlsClass="content">${saver.accountVo.nationality}</@div>
	<@div title="使用语言" span="span4" controlsClass="content">${saver.accountVo.commonLanguage}</@div>
	<@div title="婚姻状况" span="span4" controlsClass="content">${saver.accountVo.maritalStatus}</@div>
</div>
<div class="row-fluid h40">
	<@div title="证件类型" span="span4" controlsClass="content width">${saver.accountVo.idType}</@div>
	<@div title="证件号码" span="span4" controlsClass="content">${saver.accountVo.idCard}</@div>
	<@div title="出生日期" span="span4" controlsClass="content">${saver.accountVo.birthDate}</@div>
</div>
<div class="row-fluid h40">
	<@div title="开户日期" span="span4" controlsClass="content">${saver.accountVo.openDate}</@div>
	<@div title="接受文件方式" span="span4" controlsClass="content">${saver.accountVo.msgWay}</@div>
	<@div title="最高学历" span="span4" controlsClass="content">${saver.accountVo.education}</@div>	 
</div>
<div class="row-fluid h40">
	<@div title="客户分类" span="span4" controlsClass="content">${saver.accountVo.custCategory}</@div>	 
 	<@div title="客户来源" span="span8" controlsClass="content">${saver.accountVo.custSource}</@div>	 
</div>
<h4 class="form-section txt-left">联系方式</h4>
<div class="row-fluid h40">
	<@div title="固定电话" span="span4" controlsClass="content">${saver.commVo.telNum}</@div>
	<@div title="电子邮箱" span="span4" controlsClass="content">${saver.commVo.email}</@div>
	
</div>
<div class="row-fluid h40">
    <@div title="邮政编码" span="span4" controlsClass="content">${saver.commVo.zipCode}</@div>
    <@div title="微信号" span="span4" controlsClass="content">${saver.commVo.wechat}</@div>
</div> 
<div class="row-fluid h40">
    <@div title="通讯地址" span="span8" controlsClass="content">${saver.commVo.address}</@div>
</div> 
<h4 class="form-section txt-left">职业信息</h4>
<div class="row-fluid h40">
	<@div title="职业" span="span4" controlsClass="content">${saver.professionVo.profession}</@div>
	<@div title="行业" span="span8" controlsClass="content">${saver.professionVo.industry}</@div>
</div>
<div class="row-fluid h40">
	<@div title="职位" span="span4" controlsClass="content">${saver.professionVo.post}</@div>
	<@div title="单位名称" span="span8" controlsClass="content">${saver.professionVo.companyName}</@div>
</div>
<h4 class="form-section txt-left">紧急联系人信息</h4>
<div class="row-fluid h40">
	<@div title="姓名" span="span4" controlsClass="content">${saver.linkmanVo.name}</@div>
	<@div title="姓名(拼音)" span="span4" controlsClass="content">${saver.linkmanVo.nameSpell}</@div>
	<@div title="移动电话" span="span4" controlsClass="content">${saver.linkmanVo.mobile}</@div>
</div>
<div class="row-fluid h40">
	<@div title="性别" span="span4" controlsClass="content">${saver.linkmanVo.sex}</@div>
	<@div title="关系" span="span4" controlsClass="content">${saver.linkmanVo.relation}</@div>
	<@div title="固定电话" span="span4" controlsClass="content">${saver.linkmanVo.telNum}</@div>
</div>
<div class="row-fluid h40">
	<@div title="证件类型" span="span4" controlsClass="content width">${saver.linkmanVo.idType}</@div>
	<@div title="证件号码" span="span4" controlsClass="content">${saver.linkmanVo.idCard}</@div>
</div>