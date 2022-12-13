<style>
.control-group{
    height: 40px;
}
.row-fluid{
    height: 60px;
}
.form-horizontal .control-label {
    float: left;
    width: 160px;
    padding-top: 5px;
    text-align: right;
}
.form-horizontal .controls {
    margin-left: 180px;
}
.responsive.success .validate-inline {
    color: #468847;
}

.responsive.error .validate-inline {
    color: #b94a48;
}

.responsive.error .control-label, .responsive.error .help-block,
.responsive.error .help-inline {
    color: #b94a48
}

.responsive.error .checkbox, .responsive.error .radio,
.responsive.error input, .responsive.error select, .responsive.error textarea{
    color: #b94a48
}

.responsive.error input, .responsive.error select, .responsive.error textarea{
    border-color: #b94a48;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075)
}

.responsive.error input:focus, .responsive.error select:focus,
.responsive.error textarea:focus {
    border-color: #953b39;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px
        #d59392;
    -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px #d59392;
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px #d59392
}

.responsive.error .input-prepend .add-on, .responsive.error .input-append .add-on{
    color: #b94a48;
    background-color: #f2dede;
    border-color: #b94a48
}

.responsive.success .control-label, .responsive.success .help-block,
.responsive.success .help-inline {
    color: #468847
}

.responsive.success .checkbox, .responsive.success .radio,
.responsive.success input, .responsive.success select,
.responsive.success textarea {
    color: #468847
}

.responsive.success input, .responsive.success select,
.responsive.success textarea {
    border-color: #468847;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075)
}

.responsive.success input:focus, .responsive.success select:focus,
.responsive.success textarea:focus {
    border-color: #356635;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px
        #7aba7b;
    -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px #7aba7b;
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px #7aba7b
}

.responsive.success .input-prepend .add-on, .responsive.success .input-append .add-on{
    color: #468847;
    background-color: #dff0d8;
    border-color: #468847
}
.span6.responsive select.span10.m-wrap{
	width:253px;
}
.span2.responsive.selectOne{
	color:#b94a48;
	width:230px;
	position:relative;
	left:166px;
	margin-left:-150px;
	margin-top:5px;
}

</style>
<#include "/macro/base.ftl">
<div class="container-fluid">
	<div class="top"/>
    <div class="portlet box blue" id="save_wizard" >
    	<@hidden name="custName" id="custName" value=saver.account.custName />
    	<@hidden name="custNameSpell" id="custNameSpell" value=saver.account.custNameSpell />
		<@hidden name="sex" id="sex" value=saver.account.sex />
		<@hidden name="mobile" id="mobile" value=saver.account.mobile />
		<@hidden name="idType" id="idType" value=saver.account.idType />
		<@hidden name="idCard" id="idCard" value=saver.account.idCard />
		<@hidden name="custSource" id="custSource" value=saver.account.custSource />
		<@hidden name="custSourceOther" id="custSourceOther" value=saver.account.custSourceOther />
		<@hidden name="nationality" id="nationality" value=saver.account.nationality />
		<@hidden name="commonLanguage" id="commonLanguage" value=saver.account.commonLanguage />
		<@hidden name="custCode" id="custCode" value=saver.account.custCode />
		<@hidden name="custAccountId" id="custAccountId" value=saver.account.custAccountId />
		<@hidden name="custProfessionId" id="custProfessionId" value=saver.profession.custProfessionId />
		<@hidden name="custCommId" id="custCommId" value=saver.comm.custCommId />
		<@hidden name="custLinkmanId" id="custLinkmanId" value=saver.linkman.custLinkmanId />
		<@hidden name="lenderApplyId" id="lenderApplyId" value=saver.apply.lenderApplyId />
		<@hidden name="formStatus" id="formStatus" value=saver.apply.formStatus />
		<@hidden name="parentId" id="parentId" value=saver.apply.parentId />
		<@hidden name="initApplyId" id="initApplyId" value=saver.initApplyId />
		<@hidden name="payCustFinanceId" id="payCustFinanceId" value=saver.payFinanceVo.custFinanceId />
		<@hidden name="refundCustFinanceId" id="refundCustFinanceId" value=saver.refundFinanceVo.custFinanceId />
		<@hidden name="" id="specialLimitId" value=saver.limitVo.conditionId />
		<@hidden name="" id="specialBenefitId" value=saver.benefitVo.conditionId />
		<@hidden name="biz" id="biz" value=biz />
		<@hidden name="lenderId" id="lenderId" value=id />
		<@mPortlet title=saver.title formId="save_form">
			<div class="form-wizard" >
				<div class="navbar steps">
					<div class="navbar-inner">
						<ul class="row-fluid">
							<#list saver.tabs as tab>
								<li class="span${saver.width}">
									<a href="#${tab.tabId}" data-toggle="tab" class="step">
										<span class="number">${tab.index}</span>
										<span class="desc"><i class="icon-ok"></i> ${tab.tabTitle}</span>
									</a>
								</li>
							</#list>
						</ul>
					</div>
				</div>
				<div id="bar" class="progress progress-success progress-striped" style="margin-bottom: 0;">
					<div class="bar"/>
				</div>
				<div class="tab-content h250-y">
					<div class="alert alert-error hide">
						<button class="close" data-dismiss="alert"></button>您提交的信息有误，请修改后保存！
					</div>
					<div class="alert alert-success hide">
						<button class="close" data-dismiss="alert"></button>您提交的信息正确!
					</div>
					<#list saver.tabs as tab>
					    <div class="tab-pane  ${tab.tabClass}" id="${tab.tabId}">
							<#include tab.tabUrl>               
						</div>
						
					</#list>  
				</div>
			</div>		       
		</@mPortlet>	
		<@fileInfo.uploadCommonFile>
			<!-- 资源标示 wmsCustOpenApply wmsCustLenderApply  wmsLenderCheck-->
			<input type="hidden" id="resKey" name="resKey" value="${resKey}" >
			<!-- 系统 编码-->
			<input type="hidden" id="appCode" name="appCode" value="wms" >
			<!-- 当前查看文件的目录 -->
			<input type="hidden" id="currentFileDir" name="currentFileDir" value="" >
			<!-- 上传文件 -->
			<input type="hidden" id="cmAction" name="cmAction" value="uploadFile" >
			<!-- 用户编号  -->
			<input type="hidden" id="userUniqueId" name="userUniqueId" value="${saver.account.custAccountId}" >
			<input type="hidden" id="lenderCustCode" name="lenderCustCode" value="${saver.account.lenderCustCode}" >
			<!-- 用户编号  -->
			<input type="hidden" id="lenderUniqueId" name="lenderUniqueId" value="${lenderApplyId}" >
			<input type="hidden" id="lenderCode" name="lenderCode" value="${saver.apply.lenderCode}" >
		</@fileInfo.uploadCommonFile>
		
		<@mBottom>
    		<@aLeft/><@aRight id="save"/>
            <a href="javascript:;" class="btn blue button-submit"  onclick="doCreateUserAccount()"><span id="createUserAccount">确认开户</span> <i class="m-icon-swapright m-icon-white"></i></a>
        </@mBottom>
    </div>      
</div>
<script src="${baseUrl}/assets/js/save/saveFormWizard.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/save/openAccount.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/save/lenderApply.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/save/save.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<link href="${baseUrl}/assets/css/detail/detail.css" rel="stylesheet" type="text/css" />   

<!-- END PAGE LEVEL SCRIPTS -->
<script>
    (function($) {
        $(function() {
            FormWizard.init();
           	FormComponents.init();
            uploadFiles("upload");
        });
    })(jQuery);
    
</script>
 