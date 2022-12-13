<style>
	.width{
		width: 180px;
	}
</style>
<#include "/macro/base.ftl">
<h4 class="form-section">基本信息</h4>
<div class="row-fluid" >
	<@div title="姓名" span="span4" controlsClass="content">${saver.accountVo.custName}</@div>
	<@div title="姓名(拼音)" span="span4" controlsClass="content">${saver.accountVo.custNameSpell}</@div>
	<@div title="性别" span="span4" controlsClass="content"  style="margin-left:-5px">${saver.accountVo.sex}</@div>
</div>
<div class="row-fluid" >
	<@div title="移动电话" span="span4" controlsClass="content">${saver.accountVo.mobile}</@div>
	<@div title="证件类型" span="span4" controlsClass="content width">${saver.accountVo.idType}</@div>
	<@div title="证件号码" span="span4" controlsClass="content"  style="margin-left:-5px">${saver.accountVo.idCard}</@div>
</div>
<div class="row-fluid ">
	<@div title="客户来源" span="span4" controlsClass="content">${saver.accountVo.custSource}</@div>
	<@div title="国籍" span="span4" controlsClass="content">中国</@div>
	<@div title="使用语言" span="span4" controlsClass="content"  style="margin-left:-5px">汉语</@div>
</div>

