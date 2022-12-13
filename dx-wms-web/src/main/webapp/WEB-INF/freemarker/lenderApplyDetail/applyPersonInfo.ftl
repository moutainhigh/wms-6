<style>
    .boder-right-scroll{
        width:100%;
        overflow-x:scroll;
    }
    .row-fluid{
        height: 50px;
    }
    .form-section{
    	text-align:left;
    }
</style>
<div class="container-fluid" >
    <div class="row-fluid" >
        <div class="span12" id="applyPersonInfo"  >
            <div class="portlet-body" >
            	<div class="row-fluid">
			        <div class="span6 responsive">
                        <label class="control-label">出借编号：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10  m-wrap" name="lenderCode" id="lenderCode" value="${lenderCode}">
                        </div>
                    </div>
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">&nbsp;</label>
                        <div class="controls">
                            &nbsp;
                        </div>
                    </div>
                </div>
            
                <div class="row-fluid">
			        <div class="span6 responsive">
                        <label class="control-label">姓名：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10  m-wrap" name="custName" id="custName" value="${custAccountApplyVo.custAccount.custName}">
                        </div>
                    </div>
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">姓名(拼音)：</label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="custNameSpell" id="custNameSpell" value="${custAccountApplyVo.custAccount.custNameSpell}">
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>
                
                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">性别：<span class="required">*</span></label>
                        <div class="controls">
                            <select class="span10 m-wrap" name="sex" id="sex" value="${custAccountApplyVo.custAccount.sex}">
                                <option value='-1'>请选择</option>
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
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">国籍：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="nationality" id="nationality" value="中国">
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>

                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">婚姻状况：</label>
                        <div class="controls">
                            <select class="span10 m-wrap" name="maritalStatus" id="maritalStatus" value="${custAccountApplyVo.custAccount.maritalStatus}">
                                <option value='-1'>请选择</option>
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
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">使用语言：</label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="commonLanguage" id="commonLanguage" value="中文">
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>
                
                <div class="row-fluid">
                    <div class="span6 responsive" >
                        <label class="control-label">证件类型：<span class="required">*</span></label>
                        <div class="controls">
                            <select class="span10 m-wrap" name="idType" id="idType" value="${custAccountApplyVo.custAccount.idType}">
                                <option value='-1'>请选择</option>
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
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">证件号码：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="idCard" id="idCard" value="${custAccountApplyVo.custAccount.idCard}">
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>
                
                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">出生日期：</label>
                        <div class="controls">
                            <input class="span10 m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" value="<#if custAccountApplyVo.custAccount.birthDate?exists>${custAccountApplyVo.custAccount.birthDate?string("yyyy-MM-dd")}</#if>" name="birthDate" id="birthDate" data-date-format="yyyy-mm-dd" >
                        </div>
                    </div>
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">移动电话：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="mobile" id="mobile" value="${custAccountApplyVo.custAccount.mobile}">
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>
                
                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">职业：</label>
                        <div class="controls">
                            <select class="span10 m-wrap" name="profession" id="profession" value="${custAccountApplyVo.custProfession.profession}">
                                <option value='-1'>请选择</option>
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
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">行业：</label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="industry" id="industry" value="${custAccountApplyVo.custProfession.industry}">
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>
                
                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">单位名称：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="companyName" id="companyName" value="${custAccountApplyVo.custProfession.companyName}">
                        </div>
                    </div>
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">职位：</label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap"  name="post" id="post" value="${custAccountApplyVo.custProfession.post}">
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>
                
                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">最高学历：</label>
                        <div class="controls">
                            <select class="span10 m-wrap" name="education" id="education" value="${custAccountApplyVo.custAccount.education}">
                                <option value='-1'>请选择</option>
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
                    <div class="span12 responsive" style="margin-left:12px;">
                        <label class="control-label">通讯地址：<span class="required">*</span></label>
                        <div class="controls">
                            <div class="span7 responsive">
                                <div class="span4 responsive" id="provinceRegionCodeDiv">   
                                    <select class="span10 m-wrap" name="provinceRegionCode" id="provinceRegionCode" value="${custAccountApplyVo.custComm.provinceRegionCode}" >
                                        <option value='-1'>请选择省</option>
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
                                <div class="span3 responsive" id="cityRegionCodeDiv">   
                                   <select class="span10 m-wrap" name="cityRegionCode" id="cityRegionCode" >
                                      <option value='-1'>请选择市</option>
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
                                      <option value='-1'>请选择区</option>
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
                             <div class="span6 responsive" style="margin-left: -80px;">
                                <div class="span12 responsive"  id="streetInfoDiv">
                                    <input type="text" class="m-wrap span10"  placeholder="街道信息" name="streetInfo" id="streetInfo" value="${custAccountApplyVo.custComm.streetInfo}" title="${custAccountApplyVo.custComm.streetInfo}"/>
                                </div>
                            </div>   
                        </div>
                    </div>
                </div>

                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">邮政编码：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap"  name="zipCode" id="zipCode" value="${custAccountApplyVo.custComm.zipCode}">
                        </div>
                    </div>
                    <div class="span6 responsive"  style="margin-left: -38px;">
                        <label class="control-label">固定电话：</label>
                        <div class="controls">
                            <div class="span4 responsive">
                                <input type="text" class="span10 m-wrap"  name="areaCode" id="areaCode" value="${custAccountApplyVo.custComm.areaCode}">
                            </div>
                            <div class="span1 responsive" style="line-height: 30px;">
                             - 
                            </div>
                            <div class="span5 responsive">
                                <input type="text" class="span10 m-wrap"  name="telNum" id="telNum" value="${custAccountApplyVo.custComm.telNum}">
                            </div>
                        </div>
                    </div>
                </div>
                                
                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">电子邮箱：<span class="required">*</span></label>
                        <div class="controls">
                        	<input type="text" class="span10 m-wrap" name="email" id="email" value="${custAccountApplyVo.custComm.email}" >
                        </div>
                    </div>
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">微信号：</label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap"  name="wechat" id="wechat" value="${custAccountApplyVo.custComm.wechat}" >
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>

                <h4 class="form-section">紧急联系人信息   </h4>

                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">姓名：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap"   name="linkmanName" id="linkmanName" value="${custAccountApplyVo.custLinkman.linkmanName}" >
                        </div>
                    </div>
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">姓名(拼音)：</label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap"  name="linkmanNameSpell" id="linkmanNameSpell" value="${custAccountApplyVo.custLinkman.linkmanNameSpell}" >
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>
                
                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">性别：<span class="required">*</span></label>
                        <div class="controls">
                            <select class="span10 m-wrap" name="linkmanSex" id="linkmanSex" value="${custAccountApplyVo.custLinkman.linkmanSex}">
                                <option value='-1'>请选择</option>
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
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">关系：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="linkmanRelation" id="linkmanRelation" value="${custAccountApplyVo.custLinkman.linkmanRelation}" >
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>
                
                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">证件类型：</label>
                        <div class="controls">
                            <select class="span10 m-wrap" name="linkmanIdType" id="linkmanIdType" value="${custAccountApplyVo.custLinkman.linkmanIdType}">
                                <option value='-1'>请选择</option>
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
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">证件号码：</label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="linkmanIdCard" id="linkmanIdCard" value="${custAccountApplyVo.custLinkman.linkmanIdCard}" >
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>
                
                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">移动电话：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap"  name="linkmanMobile" id="linkmanMobile" value="${custAccountApplyVo.custLinkman.linkmanMobile}" >
                        </div>
                    </div>
                    <div class="span6 responsive"  style="margin-left: -38px;">
                        <label class="control-label">固定电话：</label>
                        <div class="controls">
                            <div class="span4 responsive">
                                <input type="text" class="span10 m-wrap" name="linkmanAreaCode" id="linkmanAreaCode" value="${custAccountApplyVo.custLinkman.areaCode}" >
                            </div>
                            <div class="span1 responsive" style="line-height: 30px;">
                             - 
                            </div>
                            <div class="span5 responsive">
                                <input type="text" class="span10 m-wrap" name="linkmanTelNum" id="linkmanTelNum" value="${custAccountApplyVo.custLinkman.telNum}" >
                            </div>
                        </div>
                    </div>
                </div>
                
                <h4 class="form-section">其他 </h4>
                                
                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">接受文件方式：<span class="required">*</span></label>
                        <div class="controls">
                            <select class="span10 m-wrap" name="msgWay" id="msgWay" value="${custAccountApplyVo.custAccount.msgWay}">
                                <option value='-1'>请选择</option>
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
                    <div class="span6 responsive"  style="margin-left: -55px;">
                        <label class="control-label">开户日期：<span class="required">*</span></label>
                        <div class="controls">
                            <input class="span10 m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" value="<#if custAccountApplyVo.custAccount.openDate?exists>${custAccountApplyVo.custAccount.openDate?string("yyyy-MM-dd")}</#if>" name="openDate" id="openDate"  data-date-format="yyyy-mm-dd">
                        </div>
                    </div>
                </div>
                
                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">客户来源：<span class="required">*</span></label>
                        <div class="controls">
                            <select class="span10 m-wrap" name="custSource" id="custSource" value="${custAccountApplyVo.custAccount.custSource}">
                                <option value='-1'>请选择</option>
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
                    <div class="span6 responsive" id="custSourceOtherDiv" style="margin-left: -50px;">
                        <label class="control-label">其他：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="custSourceOther" id="custSourceOther" value="${custAccountApplyVo.custAccount.custSourceOther}" >
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>
                
                <div class="row-fluid">
                    <div class="span6 responsive">
                        <label class="control-label">客户分类：<span class="required">*</span></label>
                        <div class="controls">
                            <select class="span10 m-wrap" name="custCategory" id="custCategory" value="${custAccountApplyVo.custAccount.custCategory}">
                                <option value='-1'>请选择</option>
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
            </div>
        </div>
    </div>
</div>

<script>
var base = "${baseUrl}"; 
var resBase = "${resRoot}";
</script>
<script>
        $(function() {
            if($("#custSource").val()!=20){
                $("#custSourceOtherDiv").hide();
            }
        	$("#applyPersonInfo input").attr("disabled","disabled");
        	$("#applyPersonInfo select").attr("disabled","disabled");
        });
</script>    
<!-- BEGIN PAGE LEVEL SCRIPTS -->


 