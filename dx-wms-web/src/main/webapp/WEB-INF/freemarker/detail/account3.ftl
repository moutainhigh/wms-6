<style>
	.width{
		width:180px;
	}
</style>
<h4 class="form-section txt-left">个人信息</h4>
<div class="row-fluid h40">
	<@div title="姓名" span="span5" controlsClass="content">${detail.accountVo.custName}</@div>
	<@div title="姓名(拼音)" span="span5" controlsClass="content">${detail.accountVo.custNameSpell}</@div>
</div>
<div class="row-fluid h40">
	<@div title="性别" span="span5" controlsClass="content">${detail.accountVo.sex}</@div>
	<@div title="国籍" span="span5" controlsClass="content">${detail.accountVo.nationality}</@div>
</div>
<div class="row-fluid h40">
	<@div title="婚姻状况" span="span5" controlsClass="content">${detail.accountVo.maritalStatus}</@div>
	<@div title="使用语言" span="span5" controlsClass="content">${detail.accountVo.commonLanguage}</@div>
</div>
<div class="row-fluid h40">
	<@div title="证件类型" span="span5" controlsClass="content  width">${detail.accountVo.idType}</@div>
	<@div title="证件号码" span="span5" controlsClass="content">${detail.accountVo.idCard}</@div>
</div>
<div class="row-fluid h40">
	<@div title="出生日期" span="span5" controlsClass="content">${detail.accountVo.birthDate}</@div>
	<@div title="移动电话" span="span5" controlsClass="content">${detail.accountVo.mobile}</@div>
</div>
<div class="row-fluid h40">
	<@div title="职业" span="span5" controlsClass="content">${detail.professionVo.profession}</@div>
	<@div title="行业" span="span5" controlsClass="content">${detail.professionVo.industry}</@div>
</div>
<div class="row-fluid h40">
	<@div title="单位名称" span="span5" controlsClass="content">${detail.professionVo.companyName}</@div>
	<@div title="职位" span="span5" controlsClass="content">${detail.professionVo.post}</@div>
</div>
<div class="row-fluid h40">
	<@div title="最高学历" span="span5" controlsClass="content">${detail.accountVo.education}</@div>	
</div>
<div class="row-fluid h40">
	<@div title="通讯地址" span="span10" controlsClass="content">${detail.commVo.address}</@div>
</div>
<div class="row-fluid h40">
	<@div title="邮政编码" span="span5" controlsClass="content">${detail.commVo.zipCode}</@div>
	<@div title="固定电话" span="span5" controlsClass="content">${detail.commVo.telNum}</@div>
</div>
<div class="row-fluid h40">
	<@div title="电子邮箱" span="span5" controlsClass="content">${detail.commVo.email}</@div>
    <@div title="微信号" span="span5" controlsClass="content">${detail.commVo.wechat}</@div>
</div>
<h4 class="form-section txt-left">紧急人信息 </h4>
<div class="row-fluid h40">
	<@div title="姓名" span="span5" controlsClass="content">${detail.linkmanVo.name}</@div>
	<@div title="姓名(拼音)" span="span5" controlsClass="content">${detail.linkmanVo.nameSpell}</@div>
</div>
<div class="row-fluid h40">
	<@div title="性别" span="span5" controlsClass="content">${detail.linkmanVo.sex}</@div>
	<@div title="关系" span="span5" controlsClass="content">${detail.linkmanVo.relation}</@div>
</div>
<div class="row-fluid h40">
	<@div title="证件类型" span="span5" controlsClass="content width">${detail.linkmanVo.idType}</@div>
	<@div title="证件号码" span="span5" controlsClass="content">${detail.linkmanVo.idCard}</@div>
</div>
<div class="row-fluid h40">
	<@div title="移动电话" span="span5" controlsClass="content">${detail.linkmanVo.mobile}</@div>
	<@div title="固定电话" span="span5" controlsClass="content">${detail.linkmanVo.telNum}</@div>
</div>
<h4 class="form-section txt-left">其他</h4>
<div class="row-fluid h40">
	<@div title="接受文件方式" span="span5" controlsClass="content">${detail.accountVo.msgWay}</@div>
	<@div title="开户日期" span="span5" controlsClass="content">${detail.accountVo.openDate}</@div>
</div>
<div class="row-fluid h40">
 	<@div title="客户来源" span="span5" controlsClass="content">${detail.accountVo.custSource}</@div>	
 	<@div title="其他" span="span5" controlsClass="content">${detail.accountVo.custSourceOther}</@div>	 
</div>
<div class="row-fluid h40">
	<@div title="客户分类" span="span5" controlsClass="content">${detail.accountVo.custCategory}</@div>	 
</div>
