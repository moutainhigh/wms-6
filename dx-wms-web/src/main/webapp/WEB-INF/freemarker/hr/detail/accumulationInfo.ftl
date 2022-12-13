<#macro info title="" value="">
	<div class="span6 responsive">
    	<label class="control-label" style="text-align: left;width:100%">${title}：${value}</label>
    </div>
</#macro>
    <#if detail.employeeEntryVo.socialVo.isshanghai?exists>
    <#if detail.employeeEntryVo.socialVo.isshanghai==1>
	<div class="row-fluid">
		缴纳上海社保公积金
	</div>
	<div id="provinceIn">
		<h4 class="form-section">上海社保</h4>
		<div class="row-fluid">
        <@info title="本市首次开户" value=detail.employeeEntryVo.socialVo.firstOpenSocialView />
        <@info title="已通知上家单位转出" value=detail.employeeEntryVo.socialVo.removeSocialVew />
		</div>	
		<h4 class="form-section">上海公积金</h4>
		<div class="row-fluid">
        <@info title="本市首次开户" value=detail.employeeEntryVo.socialVo.firstOpenFundView />
        <@info title="已通知上家单位转出" value=detail.employeeEntryVo.socialVo.removeFundView />
		</div>
		<div class="row-fluid">
        <@info title="个人公积金账号" value=detail.employeeEntryVo.socialVo.fundAccount />
		</div>
	</div>
	<#else>
    <div class="row-fluid">
        <@info title="新参保" value=detail.employeeEntryVo.socialVo.firstInsuredView />
	</div>
    <div class="row-fluid">
        <@info title="参保地点" value=detail.employeeEntryVo.insured />
	</div>
  </#if>
  </#if>  