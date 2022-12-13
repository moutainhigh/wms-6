<#include "/macro/base.ftl">
<#macro startPersonInfo>
<style>
	.boder-right-scroll {
		width: 100%;
		overflow-x: scroll;
	}
	.row-fluid {
		height: 60px;
	}
	.portlet.box{
		border: 1px solid #d84a38;
	}
	.lineSolid {
	    border-bottom: 1px dashed #ccc;
	    height: 0;
	    margin-bottom: 10px;
	}
	.row-fluid select{
		width:230px;
	}
	#homeAddress,#censusAddress{
		width:278px;
	}
</style>
<div class="container-fluid">
	<div class="portlet-body">
		<input type="hidden" colName="sex" value="${emDetailVo.employeeVo.sex}"/>
		<input type="hidden" colName="certType" value="${emDetailVo.employeeVo.certType}"/>
		<input type="hidden" colName="department" value="${emDetailVo.employeeVo.orgId}"/>
		<input type="hidden" colName="positionId" value="${emDetailVo.employeeVo.positionId}"/>
		<input type="hidden" colName="jobCategory" value="${emDetailVo.employeeVo.jobCategory}"/>
		<input type="hidden" colName="employeeDetailId" value="${emDetailVo.detailInfoVo.employeeDetailId}"/>
		<input type="hidden" id="entryDate" value="${emDetailVo.employeeVo.entryDateView}"/>
		<input type="hidden" id="status"/>
		<input type="hidden" id="plandate"/>
		<h4 class="form-section">基本信息</h4>
		<div class="row-fluid">
			<@div span="span6" title="员工编号">
				<@text class="span10" name="employeeId" />
			</@div>
			<@div span="span6" title="理财管理系统账号">
				<@text class="span10" name="userId" />
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="员工姓名" required=true>
				<@text class="span10" name="name" value=emDetailVo.employeeVo.name/>
			</@div>
			<@div span="span6" title="性别" required=true>
				<@text class="span10" name="sex" value=emDetailVo.employeeVo.sexView/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="证件类型" required=true>
				<@text class="span10" name="certType" value=emDetailVo.employeeVo.certTypeView/>
			</@div>
			<@div span="span6" title="证件号码" required=true>
				<@text class="span10" name="certNo" value=emDetailVo.employeeVo.certNo/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="有效时间(起)" required=true>
				<@date class="span10" name="certValidStart" value=emDetailVo.detailInfoVo.certValidStartView/>
			</@div>
			<@div span="span6" title="有效时间(止)" required=true>
				<@date class="span10" name="certValidEnd" value=emDetailVo.detailInfoVo.certValidEndView/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="出生年月" required=true>
				<@date class="span10" name="birthDate" value=emDetailVo.detailInfoVo.birthDateView/>
			</@div>
			<@div span="span6" title="婚姻状况" required=true>
				<@select source=marriage class="span10" name="maritalStatus" target=emDetailVo.detailInfoVo.maritalStatus/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="国籍" required=true>
				<@select source=country class="span10" name="country" target=emDetailVo.detailInfoVo.country/>
			</@div>
			<@div span="span6" title="民族" required=true>
				<@select source=nation class="span10" name="nation" target=emDetailVo.detailInfoVo.nation/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="服务单位" required=true>
				<@select source=workUnit class="span10" name="workUnit" target=emDetailVo.detailInfoVo.workUnit/>
			</@div>
			<@div span="span6" title="政治面貌" required=true>
				<@select source=politicalStatus class="span10" name="politicalStatus" target=emDetailVo.detailInfoVo.politicalStatus/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="文化程度" required=true>
				<@select source=hrEducation class="span10" name="HrEducation" target=emDetailVo.detailInfoVo.degree/>
			</@div>
			<@div span="span6" title="任职部门" required=true>
				<@text class="span10" name="department" value=emDetailVo.employeeVo.orgName/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="岗位职务" required=true>
				<@text class="span10" name="positionId" value=emDetailVo.employeeVo.positionName+emDetailVo.employeeDto.levelName/>
			</@div>
			<@div span="span6" title="工作性质" required=true>
				<@text class="span10" name="jobCategory" value=emDetailVo.employeeVo.jobCategoryView/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="入职日期" required=true>
				<@date class="span10" name="entryDate" value=emDetailVo.employeeVo.entryDateView/>
			</@div>
			<@div span="span6" title="首次参加工作年月">
				<@date class="span10" name="firstWorkDate" value=emDetailVo.detailInfoVo.firstWorkDateView/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="户籍性质" required=true>
				<@select source=census class="span10" name="censusRegister" target=emDetailVo.detailInfoVo.censusRegister/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span12" title="户籍所在地" required=true>
				<div class="span11 responsive">
					<div class="span4 responsive">
						<@select source=areas class="span10" name="censusProvinceCode" target=emDetailVo.detailInfoVo.censusProvinceCode/>
					</div>
					<div class="span4 responsive">
						<select class="span10 m-wrap censusCityCode" name="censusCityCode">
						  	<option value='-1'>请选择市</option>
							<#if censusCityCode?exists>
						     	<#list censusCityCode as area>
							    	<#if area.area_code_id=emDetailVo.detailInfoVo.censusCityCode>
								   		<option value=${area.area_code_id} selected="selected">${area.area_code_name}</option>
							    	<#else>
								   		<option value=${area.area_code_id}>${area.area_code_name}</option>
							    	</#if>
						 		</#list>
					  		</#if>
					   	</select>
					</div>
					<div class="span4 responsive">
						<select class="span10 m-wrap censusAreaCode" name="censusAreaCode" id="censusAreaCode" >
						  	<option value='-1'>请选择区</option>
							<#if censusAreaCode?exists>
						     	<#list censusAreaCode as area>
							    	<#if area.area_code_id=emDetailVo.detailInfoVo.censusAreaCode>
								   		<option value=${area.area_code_id} selected="selected">${area.area_code_name}</option>
							    	<#else>
								   		<option value=${area.area_code_id}>${area.area_code_name}</option>
							    	</#if>
						 		</#list>
					  		</#if>
					   	</select>
					</div>
				</div>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" required=true style="width:482px;">
				<@text class="span17" name="censusAddress" id="censusAddress" value=emDetailVo.detailInfoVo.censusAddress placeholder="街道信息"/>
			</@div>
			<@div span="span6" title="邮政编码" required=true style="margin-left:0px;">
				<@text class="span10" name="censusZipCode" value=emDetailVo.detailInfoVo.censusZipCode/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span12" title="现居住地址" required=true>
				<div class="span11 responsive">
					<div class="span4 responsive">
						<@select source=areas class="span10" name="homeProvinceCode" target=emDetailVo.detailInfoVo.homeProvinceCode/>
					</div>
					<div class="span4 responsive">
						<select class="span10 m-wrap homeCityCode" name="homeCityCode" id="homeCityCode" >
						  	<option value='-1'>请选择市</option>
							<#if homeCityCode?exists>
						     	<#list homeCityCode as area>
							    	<#if area.area_code_id=emDetailVo.detailInfoVo.homeCityCode>
								   		<option value=${area.area_code_id} selected="selected">${area.area_code_name}</option>
							    	<#else>
								   		<option value=${area.area_code_id}>${area.area_code_name}</option>
							    	</#if>
						 		</#list>
					  		</#if>
					   	</select>
					</div>
					<div class="span4 responsive">
					<select class="span10 m-wrap homeAreaCode" name="homeAreaCode" id="homeAreaCode" >
					  	<option value='-1'>请选择区</option>
						<#if homeAreaCode?exists>
					     	<#list homeAreaCode as area>
						    	<#if area.area_code_id=emDetailVo.detailInfoVo.homeAreaCode>
							   		<option value=${area.area_code_id} selected="selected">${area.area_code_name}</option>
						    	<#else>
							   		<option value=${area.area_code_id}>${area.area_code_name}</option>
						    	</#if>
					 		</#list>
				  		</#if>
				   	</select>
				</div>
				</div>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" required=true style="width:482px;">
				<@text class="span17" name="homeAddress" id="homeAddress" value=emDetailVo.detailInfoVo.homeAddress placeholder="街道信息"/>
			</@div>
			<@div span="span6" title="邮政编码" required=true style="margin-left:0px;">
				<@text class="span10" name="homeZipCode" value=emDetailVo.detailInfoVo.homeZipCode/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="移动电话" required=true>
				<@text class="span10" name="mobilePhone" value=emDetailVo.employeeVo.mobilePhone/>
			</@div>
			<@div span="span6" title="入职来源" required=true>
				<@select source=entrySource class="span10" name="entrySource" target=emDetailVo.detailInfoVo.entrySource/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="邮箱" required=true>
				<@text class="span10" name="hrEmail" value=emDetailVo.detailInfoVo.email/>
			</@div>
		</div>
		<h4 class="form-section">帐户信息 </h4>
		<div class="row-fluid">
			<@div span="span6" title="开户省份" required=true>
				<@select source=areas class="span10" name="bankProvinceCode" target=emDetailVo.detailInfoVo.bankProvinceCode/>
			</@div>
			<@div span="span6" title="开户城市" required=true>
				<select class="span10 m-wrap bankCityCode" name="bankCityCode" id="bankCityCode" >
				  	<option value='-1'>请选择市</option>
					<#if bankCityCode?exists>
				     	<#list bankCityCode as area>
					    	<#if area.area_code_id=emDetailVo.detailInfoVo.bankCityCode>
						   		<option value=${area.area_code_id} selected="selected">${area.area_code_name}</option>
					    	<#else>
						   		<option value=${area.area_code_id}>${area.area_code_name}</option>
					    	</#if>
				 		</#list>
			  		</#if>
			   	</select>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="开户银行" required=true>
				<@text class="span10" name="bankName" value="招商银行"/>
			</@div>
			<@div span="span6" title="支行" required=true>
				<select class="span10 m-wrap openAddress" name="openAddress">
					<option value='-1'>请选择</option>
					<#if openAddress?exists>
				     	<#list openAddress as open>
					    	<#if open.subBankName=emDetailVo.detailInfoVo.otherAddress>
						   		<option value=${open.subBankName} selected="selected">${open.subBankName}</option>
					    	<#else>
						   		<option value=${open.subBankName} selected="selected">${open.subBankName}</option>
					    	</#if>
					    	
				 		</#list>
				    		<option value='1'>其他</option>
			  		</#if>
			  		
				</select>
				
				<!--  <@select source=payBankCategory class="span10" name="openAddress" /> -->
			</@div>
		</div>
		<div class="row-fluid hide otherBank">
			<@div span="span6" title="其他支行"  divClass="hide-div" required=true>
				<@text class="span10" name="otherAddress" value=emDetailVo.detailInfoVo.otherAddress/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="户名" required=true>
				<@text class="span10" name="payAccountName" value=emDetailVo.employeeVo.name/>
			</@div>
			<@div span="span6" title="账号" required=true>
				<@text class="span10" name="bankCardNo" value=emDetailVo.detailInfoVo.bankCardNo/>
			</@div>
		</div>
		<h4 class="form-section">家庭主要成员&nbsp;&nbsp;<button type="button" class="btn blue deletetype" id="addMember">+添加</button></h4>
			<#if emDetailVo.familyVos?exists && emDetailVo.familyVos?size gt 0>
				<#list emDetailVo.familyVos as familyVo>
					<@family initValue=familyVo initIndex=familyVo_index/>
				</#list>
			<#else>
				<@family/>
			</#if>
	  	<h4 class="form-section">主要学习经历&nbsp;&nbsp;<button type="button" class="btn blue deletetype" id="addLearnExperience">+添加</button></h4>
	  	<#if emDetailVo.educationVos?exists && emDetailVo.educationVos?size gt 0>
			<#list emDetailVo.educationVos as eduVo>
				<@learn initValue=eduVo initIndex=eduVo_index/>
			</#list>
		<#else>
			<@learn />
		</#if>
	  	
        <h4 class="form-section">主要工作经历&nbsp;&nbsp;<button type="button" class="btn blue addWorkExperience deletetype">+添加</button></h4>
	   	<#if emDetailVo.workExperienceVos?exists && emDetailVo.workExperienceVos?size gt 0>
			<#list emDetailVo.workExperienceVos as workVo>
				<@work initValue=workVo initIndex=workVo_index/>
			</#list>
		<#else>
			<@work />
		</#if>
	   	
   		<h4 class="form-section">培训经历&nbsp;&nbsp;<button type="button" class="btn blue addTrainExperience deletetype">+添加</button></h4>
	   	<#if emDetailVo.trainedExperienceVos?exists && emDetailVo.trainedExperienceVos?size gt 0>
			<#list emDetailVo.trainedExperienceVos as trainVo>
				<@train initValue=trainVo initIndex=trainVo_index/>
			</#list>
		<#else>
			<@train />
		</#if>
	   	
   	</div>
	<!-- END FORM-->
</div>
<div class="top"></div>
<template id="familyInfo">
	<@family/>
</template>
<template id="learnInfo">
	<@learn />
</template>
<template id="workInfo">
	<@work />
</template>
<template id="trainInfo">
	<@train />
</template>
</#macro>
<#macro family initValue={} initIndex="">
	<div  class="familyMember">
		<input type="hidden" name="employeeFamilyId${initIndex }" value="${initValue.employeeFamilyId}" class="employeeFamilyId"/>
		<@lineSolid />
		<div class="row-fluid">
			<@div span="span6" title="称谓" required=true>
				<@select source=relationShip class="span10" name="relationShip"+initIndex  target=initValue.relationShip />
			</@div>
			<@div span="span6" title="姓名" required=true>
				<@text class="span10"name="familyName"+initIndex  value=initValue.name/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="工作单位" required=true>
				<@text class="span10"name="fyWorkUnit"+initIndex  value=initValue.workUnit/>
			</@div>
			<@div span="span6" title="移动 电话" required=true>
				<@text class="span10"name="fyMobilePhone"+initIndex  value=initValue.mobilePhone/>
			</@div>
		</div>
		<div class='row-fluid deleteFamily'>
			<div class='span7 responsive'></div>
			<div class='span4 responsive'>
				<input type="button" class="btn btn-shadow red deletetype" value="删除" id="deleteFamily${initIndex}" onclick='deleteFamily(this)'/>
			</div>
		</div>
  	</div>
</#macro>
<#macro learn initValue={} initIndex="">
	<div class="learnExperience">
		<input type="hidden" name="employeeEducationId${initIndex }" value="${initValue.employeeEducationId}" class="employeeEducationId"/>
		<@lineSolid />
	  	<div class="row-fluid">
			<@div span="span6" title="学习时间(起)">
				<@date class="span10"  name="learnStartdate"+initIndex value=initValue.startdateView/>
			</@div>
			<@div span="span6" title="学习时间(止)">
				<@date class="span10"  name="learnEnddate"+initIndex value=initValue.enddateView/>
			</@div>
		</div>
	  	<div class="row-fluid">
			<@div span="span6" title="学校名称">
				<@text class="span10" name="learnSchool"+initIndex value=initValue.school/>
			</@div>
			<@div span="span6" title="所学专业">
				<@text class="span10" name="learnMajor"+initIndex value=initValue.major/>
			</@div>
		</div>
		<div class="row-fluid">
			<@div span="span6" title="学习情况">
				<@select source=graduateType class="span10" name="isGraduate"+initIndex target=initValue.isGraduate/>
			</@div>
			<div class='span4 responsive deleteLearn'>
				<input type="button" class="btn btn-shadow red deletetype" value="删除" id="deleteLearn${initIndex }" onclick='deleteLearn(this)'/>
			</div>
		</div>
	</div>
</#macro>
<#macro work initValue={} initIndex="">
	<div class="workExperience">
		<input type="hidden" name="employeeWorkExperienceId${initIndex}" value="${initValue.employeeWorkExperienceId}" class="employeeWorkExperienceId"/>
		<@lineSolid />
		<div class="row-fluid">
			<@div span="span6" title="工作时间(起)">
				<@date class="span10"  name="entryDateBegin"+initIndex value=initValue.entryDateView/>
			</@div>
			<@div span="span6" title="工作时间(止)">
				<@date class="span10"  name="quitDate"+initIndex value=initValue.quitDateView/>
			</@div>
		</div>
	             <div class="row-fluid">
			<@div span="span6" title="单位名称">
				<@text class="span10" name="companyName"+initIndex value=initValue.companyName/>
			</@div>
			<@div span="span6" title="部门">
				<@text class="span10" name="companyDepart"+initIndex value=initValue.department/>
			</@div>
		</div>
       	<div class="row-fluid">
       		<@div span="span6" title="职务">
				<@text class="span10" name="duties"+initIndex value=initValue.duties/>
			</@div>
			<div class='span4 responsive deleteWork'>
				<input type="button" class="btn btn-shadow red deletetype" value="删除" id="deleteWork${initIndex }" onclick='deleteWork(this)'/>
			</div>
		</div>
	</div>
</#macro>
<#macro train initValue={} initIndex="">
	<div class="trainExperience">
		<input type="hidden" name="trainedId${initIndex}" value="${initValue.trainedId}" class="trainedId"/>
		<@lineSolid />
		<div class="row-fluid">
			<@div span="span6" title="培训时间(起)">
				<@date class="span10"  name="startDate"+initIndex value=initValue.startDateView/>
			</@div>
			<@div span="span6" title="培训时间(止)">
				<@date class="span10"  name="endDate"+initIndex value=initValue.endDateView/>
			</@div>
		</div>
        <div class="row-fluid">
			<@div span="span6" title="培训机构">
				<@text class="span10" name="trainingOrg"+initIndex value=initValue.trainingOrg/>
			</@div>
			<@div span="span6" title="培训项目">
				<@text class="span10" name="trainingProject"+initIndex value=initValue.trainingProject/>
			</@div>
		</div>
		<div class="row-fluid">
		    <@div span="span6" title="获得证书">
				<@text class="span10" name="certificate"+initIndex value=initValue.certificate/>
			</@div>
			<div class='span4 responsive deleteTrain'>
				<input type="button" class="btn btn-shadow red deletetype" value="删除" id="deleteTrain${initIndex }" onclick='deleteTrain(this)'/>
			</div>
		</div>
   	</div>
</#macro>
<#macro lineSolid>
	<div class="lineSolid"> </div>
</#macro>