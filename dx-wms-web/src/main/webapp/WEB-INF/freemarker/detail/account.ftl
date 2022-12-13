<style>
	.width{
		width:180px;
	}
</style>
<h4 class="form-section txt-left">基本信息</h4>
<div class="row-fluid h40">
	<@div title="客户编号" span="span4" controlsClass="content">${detail.accountVo.lenderCustCode}</@div>
	<@div title="姓名" span="span4" controlsClass="content">${detail.accountVo.custName}</@div>
	<@div title="移动电话" span="span4" controlsClass="content">${detail.accountVo.mobile}</@div>
</div>
<h4 class="form-section txt-left">详细信息</h4>    
<div class="row-fluid h40">
 	<@div title="姓名(拼音)" span="span4" controlsClass="content">${detail.accountVo.custNameSpell}</@div>
	<@div title="性别" span="span4" controlsClass="content">${detail.accountVo.sex}</@div>
	<@div title="账户级别" span="span4" controlsClass="content"><span class="label label-danger">待完善</span></@div>
</div>
<div class="row-fluid h40">
	<@div title="国籍" span="span4" controlsClass="content">${detail.accountVo.nationality}</@div>
	<@div title="使用语言" span="span4" controlsClass="content">${detail.accountVo.commonLanguage}</@div>
	<@div title="婚姻状况" span="span4" controlsClass="content">${detail.accountVo.maritalStatus}</@div>
</div>
<div class="row-fluid h40">
	<@div title="证件类型" span="span4" controlsClass="content  width">${detail.accountVo.idType}</@div>
	<@div title="证件号码" span="span4" controlsClass="content">${detail.accountVo.idCard}</@div>
	<@div title="出生日期" span="span4" controlsClass="content">${detail.accountVo.birthDate}</@div>
</div>
<div class="row-fluid h40">
	<@div title="开户日期" span="span4" controlsClass="content">${detail.accountVo.openDate}</@div>
	<@div title="接受文件方式" span="span4" controlsClass="content">${detail.accountVo.msgWay}</@div>
	<@div title="最高学历" span="span4" controlsClass="content">${detail.accountVo.education}</@div>	 
</div>
<div class="row-fluid h40">
	<@div title="客户分类" span="span4" controlsClass="content">${detail.accountVo.custCategory}</@div>	 
 	<@div title="客户来源" span="span8" controlsClass="content">${detail.accountVo.custSource}</@div>	 
</div>
<h4 class="form-section txt-left">联系方式</h4>
<div class="row-fluid h40">
	<@div title="固定电话" span="span4" controlsClass="content">${detail.commVo.telNum}</@div>
	<@div title="电子邮箱" span="span4" controlsClass="content">${detail.commVo.email}</@div>
</div>
<div class="row-fluid h40">
	<@div title="邮政编码" span="span4" controlsClass="content">${detail.commVo.zipCode}</@div>
    <@div title="微信号" span="span4" controlsClass="content">${detail.commVo.wechat}</@div>
</div> 
<div class="row-fluid h40">
	<@div title="通讯地址" span="span8" controlsClass="content">${detail.commVo.address}</@div>
</div> 
<h4 class="form-section txt-left">职业信息</h4>
<div class="row-fluid h40">
	<@div title="职业" span="span4" controlsClass="content">${detail.professionVo.profession}</@div>
	<@div title="行业" span="span8" controlsClass="content">${detail.professionVo.industry}</@div>
</div>
<div class="row-fluid h40">
	<@div title="职位" span="span4" controlsClass="content">${detail.professionVo.post}</@div>
	<@div title="单位名称" span="span8" controlsClass="content">${detail.professionVo.companyName}</@div>
</div>
<h4 class="form-section txt-left">紧急联系人信息 </h4>
<div class="row-fluid h40">
	<@div title="姓名" span="span4" controlsClass="content">${detail.linkmanVo.name}</@div>
	<@div title="姓名(拼音)" span="span4" controlsClass="content">${detail.linkmanVo.nameSpell}</@div>
	<@div title="移动电话" span="span4" controlsClass="content">${detail.linkmanVo.mobile}</@div>
</div>
<div class="row-fluid h40">
	<@div title="性别" span="span4" controlsClass="content">${detail.linkmanVo.sex}</@div>
	<@div title="关系" span="span4" controlsClass="content">${detail.linkmanVo.relation}</@div>
	<@div title="固定电话" span="span4" controlsClass="content">${detail.linkmanVo.telNum}</@div>
</div>
<div class="row-fluid h40">
	<@div title="证件类型" span="span4" controlsClass="content width">${detail.linkmanVo.idType}</@div>
	<@div title="证件号码" span="span4" controlsClass="content">${detail.linkmanVo.idCard}</@div>
</div>

 