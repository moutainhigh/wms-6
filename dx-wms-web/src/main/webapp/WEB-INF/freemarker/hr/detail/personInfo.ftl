<style>
	.btn-print{
		float:right;
		position:relative;
		bottom:5px;
		right:5px;	
	}
</style>
<#import "hr/print/laborContract.ftl" as printPage>
<#macro info title="" value="">
	<div class="span3 responsive">
    	<label class="control-label everylabel" style="text-align: left;width:100%" >${title}：${value}</label>
    </div>
</#macro>
<#macro biginfo title="" value="">
	<div class="span3 responsive">
    	<label class="control-label everylabel" style="text-align: left;width:200%" >${title}：${value}</label>
    </div>
</#macro>
<div>
	<input type="button" value="打印合同" class="btn-print" id="print-btn"/>
	<h4 class="form-section">基本信息</h4>
</div>
<div class="row-fluid" style="margin-bottom:2%" >
	<@info title="姓名" value=detail.employeeEntryVo.employeeVo.name />
    <@info title="员工编号" value=detail.employeeEntryVo.employeeVo.employeeNo />
    <@info title="任职部门" value=detail.employeeEntryVo.employeeVo.orgName />
    <@info title="岗位职务" value=detail.employeeEntryVo.employeeVo.positionName />
</div>
<div class="row-fluid" style="margin-bottom:2%">
    <@info title="理财管理账号" value=detail.employeeEntryVo.employeeVo.userName />
    <@info title="入职日期" value=detail.employeeEntryVo.employeeVo.entryDateView  />
    <@info title="移动电话" value=detail.employeeEntryVo.employeeVo.mobilePhone />
</div>
<h4 class="form-section">详细信息</h4>
<div class="row-fluid" style="margin-bottom:2%" >
    <@info title="证件类型" value=detail.employeeEntryVo.employeeVo.certTypeView />  
    <@info title="证件号码" value=detail.employeeEntryVo.employeeVo.certNo /> 
    <@biginfo title="有效时间" value=detail.employeeEntryVo.detailInfoVo.certValidView /> 
</div>
<div class="row-fluid" style="margin-bottom:2%">
    <@info title="性别" value=detail.employeeEntryVo.employeeVo.sexView />
    <@info title="出生年月" value=detail.employeeEntryVo.detailInfoVo.birthDateView /> 
    <@info title="婚姻状况" value=detail.employeeEntryVo.detailInfoVo.maritalStatusView /> 
    <@info title="国籍 " value=detail.employeeEntryVo.detailInfoVo.countryView /> 
</div>
<div class="row-fluid" style="margin-bottom:2%">
	<@info title="政治面貌" value=detail.employeeEntryVo.detailInfoVo.politicalStatusView /> 
    <@info title="文化程度" value=detail.employeeEntryVo.detailInfoVo.degreeView /> 
    <@biginfo title="服务单位" value=detail.employeeEntryVo.detailInfoVo.workUnitView /> 
</div>
<div class="row-fluid" style="margin-bottom:2%">
    <@info title="民族 " value=detail.employeeEntryVo.detailInfoVo.nationView />
    <@info title="工作性质" value=detail.employeeEntryVo.employeeVo.jobCategoryView /> 
    <@info title="首次参加工作年月" value=detail.employeeEntryVo.detailInfoVo.firstWorkDateView /> 
    <@info title="户籍性质" value=detail.employeeEntryVo.detailInfoVo.censusRegisterView /> 
</div>
<div class="row-fluid" style="margin-bottom:2%">
    <@info title="Email" value=detail.employeeEntryVo.detailInfoVo.email /> 
    <@info title="入职来源" value=detail.employeeEntryVo.detailInfoVo.entrySourceView /> 
    <@info title="户籍所在地" value=hj_pca />
    <@info title="现居住地" value=jzd_pca /> 
</div>
<h4 class="form-section">账户信息</h4>
<div class="row-fluid" style="margin-bottom:2%" >
    <@info title="开户省份" value=detail.employeeEntryVo.detailInfoVo.bankProvince /> 
    <@info title="开户城市" value=detail.employeeEntryVo.detailInfoVo.bankCity />
    <@info title="开户银行" value="招商银行" />
</div>
<div class="row-fluid" style="margin-bottom:2%">
	<#if detail.employeeEntryVo.detailInfoVo.openAddress=="招商银行">
    <@info title="支行" value=detail.employeeEntryVo.detailInfoVo.otherAddress />
	<#else>
	<@info title="支行" value=detail.employeeEntryVo.detailInfoVo.openAddress />
	</#if>
    <@info title="户名" value=detail.employeeEntryVo.employeeVo.name />
    <@info title="账号" value=detail.employeeEntryVo.detailInfoVo.bankCardNo />
</div>
<h4 class="form-section">家庭主要成员</h4>
<#if detail.employeeEntryVo.familyVos?exists>
 <#list detail.employeeEntryVo.familyVos as family>
    <div class="row-fluid" style="margin-bottom:2%" >
    <@info title="称谓" value=family.relationShipView />  
    <@info title="姓名" value=family.name />
    <@info title="工作单位" value=family.workUnit />
    <@info title="移动电话" value=family.mobilePhone /> 
    </div>
  </#list>
  <#else>
  <span class='label label-danger'>待完善</span>
  </#if>

<h4 class="form-section">主要学习经验</h4>
<#if detail.employeeEntryVo.educationVos?exists>
 <#list detail.employeeEntryVo.educationVos as educationVo>
    <div class="row-fluid" style="margin-bottom:2%" >
    <@biginfo title="学习时间" value=educationVo.learnView /> 
    <@info title="学校" value=educationVo.school />
    <@info title="所学专业" value=educationVo.major />
    <@info title="学习情况" value=educationVo.isGraduateView /> 
    </div>
  </#list>
  <#else>
  <span class='label label-danger'>待完善</span>
  </#if>
<h4 class="form-section">主要工作经验</h4>
<#if detail.employeeEntryVo.workExperienceVos?exists>
 <#list detail.employeeEntryVo.workExperienceVos as workExperienceVo>
    <div class="row-fluid" style="margin-bottom:2%" >
    <@biginfo title="工作时间" value=workExperienceVo.workTime /> 
    <@info title="单位名称" value=workExperienceVo.companyName />
    <@info title="部门" value=workExperienceVo.department />
    <@info title="职务" value=workExperienceVo.duties /> 
    </div>
  </#list>
  <#else>
  <span class='label label-danger'>待完善</span>
  </#if>
<h4 class="form-section">培训经历</h4>
<#if detail.employeeEntryVo.trainedExperienceVos?exists>
 <#list detail.employeeEntryVo.trainedExperienceVos as trainedExperienceVo>
    <div class="row-fluid" style="margin-bottom:2%" >
    <@biginfo title="培训时间" value=trainedExperienceVo.trainingDate />
    <@info title="培训机构" value=trainedExperienceVo.trainingOrg />
    <@info title="培训项目" value=trainedExperienceVo.trainingProject />
    <@info title="获得证书" value=trainedExperienceVo.certificate /> 
    </div>
  </#list>
  <#else>
  <span class='label label-danger'>待完善</span>
  </#if>

<script>
	var base = "${baseUrl}";
	var employeeId = "${detail.employeeEntryVo.employeeVo.employeeId}";
	var status = "${detail.employeeEntryVo.employeeDto.dataStatus}";
	var biz = "${biz}";
</script>
<script src="${baseUrl}/assets/js/hr/print_list.js"></script>