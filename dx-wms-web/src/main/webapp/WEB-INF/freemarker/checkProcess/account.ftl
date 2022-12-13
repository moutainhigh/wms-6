<style>
.row-fluid{
	height: 50px;
}
h4{
	text-align: left;
}    
</style>
<h4 class="form-section">个人信息</h4>
<div class="row-fluid">
	<div class="span6 responsive">
    	<label class="control-label">客户编号：</label>
        <div class="controls">
        	<input type="text" class="span10 m-wrap" name="custAccountId" id="custAccountId" value="${custAccountApplyVo.custAccount.lenderCustCode}" disabled />
        </div>
    </div>
	<div class="span6 responsive right">
    	<label class="control-label">账户级别：</label>
      	<div class="controls">
        	<input type="text" class="span10 m-wrap" name="accountLevelId" id="accountLevelId" value="" disabled />
        </div>
    </div>
 </div>      
 <div class="row-fluid">
 	<div class="span6 responsive">
    	<label class="control-label">姓名：</label>
       	<div class="controls">
        	<input type="text" class="span10  m-wrap" name="custName" id="custName" value="${custAccountApplyVo.custAccount.custName}" disabled />
        </div>
    </div>
    <div class="span6 responsive right">
    	<label class="control-label">姓名(拼音)：</label>
        <div class="controls">
        	<input type="text" class="span10 m-wrap" name="custNameSpell" id="custNameSpell" value="${custAccountApplyVo.custAccount.custNameSpell}" disabled />
        </div>
    </div>
</div>
<div class="row-fluid">
	<div class="span6 responsive">
    	<label class="control-label">性别：</label>
        <div class="controls">
        	<select class="span10 m-wrap" name="sex" id="sex" value="${custAccountApplyVo.custAccount.sex}" disabled>
            	<#if sex?exists>
                	<#list sex?keys as key>
                    	<#if key==custAccountApplyVo.custAccount.sex>
                        	<option value=${key} selected="selected">${sex[key]}</option>
                       	<#else>
                        	<option value=${key}>${sex[key]}</option>
                        </#if> 
                    </#list>
                 </#if>
      		</select>
     	</div>
	</div>
    <div class="span6 responsive right">
    	<label class="control-label">国籍：</label>
        <div class="controls">
        	<input type="text" class="span10 m-wrap" name="nationality" id="nationality" value="中国" disabled />
        </div>
    </div>
</div>
<div class="row-fluid">
	<div class="span6 responsive">
    	<label class="control-label">婚姻状况：</label>
        <div class="controls">
        	<select class="span10 m-wrap" name="maritalStatus" id="maritalStatus" value="${custAccountApplyVo.custAccount.maritalStatus}" disabled>
            	<#if maritalStatus?exists>
                	<#list maritalStatus?keys as key>
                    	<#if key==custAccountApplyVo.custAccount.maritalStatus>
                        	<option value=${key} selected="selected">${maritalStatus[key]}</option>
                       	<#else>
                        	<option value=${key}>${maritalStatus[key]}</option>
                        </#if> 
                    </#list>
               	</#if>
           	</select>
  		</div>
  	</div>
    <div class="span6 responsive right">
    	<label class="control-label">使用语言：</label>
        <div class="controls">
        	<input type="text" class="span10 m-wrap" name="commonLanguage" id="commonLanguage" value="中文" disabled/>
        </div>
    </div>
</div>
<div class="row-fluid">
	<div class="span6 responsive" >
    	<label class="control-label">证件类型：</label>
        <div class="controls">
        	<select class="span10 m-wrap" name="idType" id="idType" value="${custAccountApplyVo.custAccount.idType}" disabled>
	        	<#if idType?exists>
                	<#list idType?keys as key>
                    	<#if key==custAccountApplyVo.custAccount.idType>
                        	<option value=${key} selected="selected">${idType[key]}</option>
                        <#else>
                        	<option value=${key}>${idType[key]}</option>
                        </#if> 
                    </#list>
              	</#if>
           	</select>
      	</div>
 	</div>
	<div class="span6 responsive right">
    	<label class="control-label">证件号码：</label>
    	<div class="controls">
          	<input type="text" class="span10 m-wrap" name="idCard" id="idCard" value="${custAccountApplyVo.custAccount.idCard}" disabled />
    	</div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6 responsive">
        <label class="control-label">出生日期：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap" name="birthDate" id="birthDate" value="<#if custAccountApplyVo.custAccount.birthDate?exists>${custAccountApplyVo.custAccount.birthDate?string("yyyy-MM-dd")}</#if>" disabled />
        </div>
    </div>
    <div class="span6 responsive right">
        <label class="control-label">移动电话：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap" name="mobile" id="mobile" value="${custAccountApplyVo.custAccount.mobile}" disabled />
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6 responsive">
        <label class="control-label">职业：</label>
        <div class="controls">
            <select class="span10 m-wrap" name="profession" id="profession" value="${custAccountApplyVo.custProfession.profession}" disabled >
           		<#if profession?exists>
	                <#list profession?keys as key>
	                    <#if key==custAccountApplyVo.custProfession.profession>
	                        <option value=${key} selected="selected">${profession[key]}</option>
	                    <#else>
	                        <option value=${key}>${profession[key]}</option>
	                    </#if> 
	                </#list>
	            </#if>
            </select>
        </div>
    </div>
    <div class="span6 responsive right">
        <label class="control-label">行业：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap" name="industry" id="industry" value="${custAccountApplyVo.custProfession.industry}" disabled />
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6 responsive">
        <label class="control-label">单位名称：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap" name="companyName" id="companyName" value="${custAccountApplyVo.custProfession.companyName}" disabled />
        </div>
    </div>
    <div class="span6 responsive right">
        <label class="control-label">职位：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap"  name="post" id="post" value="${custAccountApplyVo.custProfession.post}" disabled />
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6 responsive">
        <label class="control-label">最高学历：</label>
        <div class="controls">
            <select class="span10 m-wrap" name="education" id="education" value="${custAccountApplyVo.custAccount.education}" disabled >
                <#if education?exists>
                    <#list education?keys as key>
                        <#if key==custAccountApplyVo.custAccount.education>
                            <option value=${key} selected="selected">${education[key]}</option>
                        <#else>
                            <option value=${key}>${education[key]}</option>
                        </#if> 
                    </#list>
                </#if>
            </select>
        </div>
    </div>
</div>
<div class="row-fluid">
        <label class="control-label">通讯地址：</label>
        <div class="controls">
            <div class="span6 responsive" >
                <div class="span4 responsive" id="provinceRegionCodeDiv" style="margin-left:14px;">   
                    <select class="span10 m-wrap" name="provinceRegionCode" id="provinceRegionCode" value="${custAccountApplyVo.custComm.provinceRegionCode}" >
                        <#if areas?exists>
                            <#list areas?keys as key>
                                <#if key==custAccountApplyVo.custComm.provinceRegionCode>
                                    <option value=${key} selected="selected">${areas[key]}</option>
                                <#else>
                                    <option value=${key}>${areas[key]}</option>
                                </#if> 
                            </#list>
                        </#if>
                    </select>
                </div>
                <div class="span4 responsive" id="cityRegionCodeDiv">   
                   <select class="span10 m-wrap" name="cityRegionCode" id="cityRegionCode" >
                   		<#if cityRegionCode?exists>
                      		<#list cityRegionCode as area>
                                <#if area.area_code_id=custAccountApplyVo.custComm.cityRegionCode>
                                   <option value=${area.area_code_id} selected="selected">${area.area_code_name}</option>
                                <#else>
                                   <option value=${area.area_code_id}>${area.area_code_name}</option>
                                </#if>
                         	</#list>
                      	</#if>
                   </select>
                </div>
                <div class="span3 responsive" id="districtRegionCodeDiv">   
                   <select class="span10 m-wrap" name="districtRegionCode" id="districtRegionCode" >
                      <#if districtRegionCode?exists>
                         <#list districtRegionCode as area>
                            <#if area.area_code_id=custAccountApplyVo.custComm.districtRegionCode>
                                <option value=${area.area_code_id} selected="selected">${area.area_code_name}</option>
                            <#else>
                                <option value=${area.area_code_id}>${area.area_code_name}</option>
                            </#if>
                         </#list>
                      </#if>
                   </select>
                </div>  
          	</div>
         	<div class="span5 responsive">
                <div class="span12 responsive"  id="streetInfoDiv">
                    <input type="text" class="m-wrap span12"  placeholder="街道信息" name="streetInfo" id="streetInfo" value="${custAccountApplyVo.custComm.streetInfo}" title="${custAccountApplyVo.custComm.streetInfo}"/>
                </div>
            </div>   
        </div>
</div>
<div class="row-fluid">
    <div class="span6 responsive">
        <label class="control-label">邮政编码：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap"  name="zipCode" id="zipCode" value="${custAccountApplyVo.custComm.zipCode}">
        </div>
    </div>
    <div class="span6 responsive right" >
        <label class="control-label">固定电话：</label>
        <div class="controls">
            <div class="span4 responsive" style="margin-left:17px;">
                <input type="text" class="span10 m-wrap"  name="areaCode" id="areaCode" value="${custAccountApplyVo.custComm.areaCode}">
            </div>
            <div class="span1 responsive" style="line-height: 30px;">
             	- 
            </div>
            <div class="span6 responsive">
                <input type="text" class="span10 m-wrap"  name="telNum" id="telNum" value="${custAccountApplyVo.custComm.telNum}">
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6 responsive">
        <label class="control-label">电子邮箱：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap" name="email" id="email" value="${custAccountApplyVo.custComm.email}" >
        </div>
    </div>
    <div class="span6 responsive right">
        <label class="control-label">微信号：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap"  name="wechat" id="wechat" value="${custAccountApplyVo.custComm.wechat}" >
        </div>
    </div>
</div>
<h4 class="form-section" style="text-align:left;">紧急联系人信息   </h4>
<div class="row-fluid">
    <div class="span6 responsive">
        <label class="control-label">姓名：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap"   name="linkmanName" id="linkmanName" value="${custAccountApplyVo.custLinkman.linkmanName}" >
        </div>
    </div>
    <div class="span6 responsive right" >
        <label class="control-label">姓名(拼音)：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap"  name="linkmanNameSpell" id="linkmanNameSpell" value="${custAccountApplyVo.custLinkman.linkmanNameSpell}" >
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6 responsive">
        <label class="control-label">性别：</label>
        <div class="controls">
            <select class="span10 m-wrap" name="linkmanSex" id="linkmanSex" value="${custAccountApplyVo.custLinkman.linkmanSex}">
                <#if sex?exists>
                    <#list sex?keys as key>
                        <#if key==custAccountApplyVo.custLinkman.linkmanSex>
                            <option value=${key} selected="selected">${sex[key]}</option>
                        <#else>
                            <option value=${key}>${sex[key]}</option>
                        </#if> 
                    </#list>
                </#if>
            </select>
        </div>
    </div>
    <div class="span6 responsive right">
        <label class="control-label">关系：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap" name="linkmanRelation" id="linkmanRelation" value="${custAccountApplyVo.custLinkman.linkmanRelation}" >
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6 responsive">
        <label class="control-label">证件类型：</label>
        <div class="controls">
            <select class="span10 m-wrap" name="linkmanIdType" id="linkmanIdType" value="${custAccountApplyVo.custLinkman.linkmanIdType}">
                <#if idType?exists>
                    <#list idType?keys as key>
                        <#if key==custAccountApplyVo.custLinkman.linkmanIdType>
                            <option value=${key} selected="selected">${idType[key]}</option>
                        <#else>
                            <option value=${key}>${idType[key]}</option>
                        </#if> 
                    </#list>
                </#if>
            </select>
        </div>
    </div>
    <div class="span6 responsive right" >
        <label class="control-label">证件号码：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap" name="linkmanIdCard" id="linkmanIdCard" value="${custAccountApplyVo.custLinkman.linkmanIdCard}">
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6 responsive">
        <label class="control-label">移动电话：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap"  name="linkmanMobile" id="linkmanMobile" value="${custAccountApplyVo.custLinkman.linkmanMobile}" >
        </div>
    </div>
    <div class="span6 responsive right">
        <label class="control-label">固定电话：</label>
        <div class="controls">
            <div class="span4 responsive" style="margin-left:17px;">
                <input type="text" class="span10 m-wrap" name="linkmanAreaCode" id="linkmanAreaCode" value="${custAccountApplyVo.custLinkman.areaCode}" >
            </div>
            <div class="span1 responsive" style="line-height: 30px;">
             - 
            </div>
            <div class="span6 responsive">
                <input type="text" class="span10 m-wrap" name="linkmanTelNum" id="linkmanTelNum" value="${custAccountApplyVo.custLinkman.telNum}" >
            </div>
        </div>
    </div>
</div>
<h4 class="form-section" style="text-align:left;">其他信息</h4>
<div class="row-fluid">
    <div class="span6 responsive">
        <label class="control-label">接受文件方式：</label>
        <div class="controls">
            <select class="span10 m-wrap" name="msgWay" id="msgWay" value="${custAccountApplyVo.custAccount.msgWay}">
                <#if msgWay?exists>
                    <#list msgWay?keys as key>
                        <#if key==custAccountApplyVo.custAccount.msgWay>
                            <option value=${key} selected="selected">${msgWay[key]}</option>
                        <#else>
                            <option value=${key}>${msgWay[key]}</option>
                        </#if> 
                    </#list>
                </#if>
            </select>
        </div>
    </div>
    <div class="span6 responsive right" >
        <label class="control-label">开户日期：</label>
        <div class="controls">
            <input class="span10 m-wrap m-ctrl-span10 date-picker" readonly size="16" type="text" value="<#if custAccountApplyVo.custAccount.openDate?exists>${custAccountApplyVo.custAccount.openDate?string("yyyy-MM-dd")}</#if>" name="openDate" id="openDate"  data-date-format="yyyy-mm-dd">
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6 responsive">
        <label class="control-label">客户来源：</label>
        <div class="controls">
            <select class="span10 m-wrap" name="custSource" id="custSource" value="${custAccountApplyVo.custAccount.custSource}">
                <#if custSource?exists>
                    <#list custSource?keys as key>
                        <#if key==custAccountApplyVo.custAccount.custSource>
                            <option value=${key} selected="selected">${custSource[key]}</option>
                        <#else>
                            <option value=${key}>${custSource[key]}</option>
                        </#if> 
                    </#list>
                </#if>
            </select>
        </div>
    </div>
    <div class="span6 responsive right" id="custSourceOtherDiv">
        <label class="control-label">其他：</label>
        <div class="controls">
            <input type="text" class="span10 m-wrap" name="custSourceOther" id="custSourceOther" value="${custAccountApplyVo.custAccount.custSourceOther}" >
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6 responsive">
        <label class="control-label">客户分类：</label>
        <div class="controls">
            <select class="span10 m-wrap" name="custCategory" id="custCategory" value="${custAccountApplyVo.custAccount.custCategory}">
                <#if custCategory?exists>
                    <#list custCategory?keys as key>
                        <#if key==custAccountApplyVo.custAccount.custCategory>
                            <option value=${key} selected="selected">${custCategory[key]}</option>
                        <#else>
                            <option value=${key}>${custCategory[key]}</option>
                        </#if> 
                    </#list>
                </#if>
            </select>
        </div>
    </div>
</div>
<script>
    jQuery(document).ready(function() {  
       // FormComponents.init();
        $("#tab1 input").attr("disabled","disabled");
        $("#tab1 select").attr("disabled","disabled");
        $("#openDate").attr("disabled","disabled");
        if($("#custSource").val()!=20){
            $("#custSourceOtherDiv").hide();
        }
    });
    
</script>    
<!-- BEGIN PAGE LEVEL SCRIPTS -->


 