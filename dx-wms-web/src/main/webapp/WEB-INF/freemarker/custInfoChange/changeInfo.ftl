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
    select.m-wrap.small {
        width: 90px !important;
    }
    .m-wrap.medium {
        width: 180px !important;
    }
    .m-wrap.small {
        width: 50px !important;
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
    .selectOne{
    	display: inline-block;
    	margin-top: 3px;
    	padding-left: 5px;
    	vertical-align: middle;
 		color: #b94a48;
    }

</style>

<!-- BEGIN PAGE CONTAINER-->
<div class="container-fluid">
    <!-- BEGIN PAGE HEADER-->
    <div class="top">
    </div>
    <!-- END PAGE HEADER-->
    <!-- BEGIN PAGE CONTENT-->
    <input type="hidden" name="custAccountId" id="custAccountId" value="${custAccountApplyVo.custAccount.custAccountId}">
    <input type="hidden" name="custCommId" id="custCommId" value="${custAccountApplyVo.custComm.custCommId}">
    <input type="hidden" name="custLinkmanId" id="custLinkmanId" value="${custAccountApplyVo.custLinkman.custLinkmanId}">
    <input type="hidden" name="custProfessionId" id="custProfessionId" value="${custAccountApplyVo.custProfession.custProfessionId}">
    <input type="hidden" name="custCode" id="custCode" value="${custAccountApplyVo.custAccount.custCode}">
    <input type="hidden" name="custId" id="custId" value="${custId}">
    <div class="row-fluid">
        <div class="span12">
            <div class="portlet box blue" id="form_wizard_1">
                 <div class="portlet-title">
                	<div class="caption"><i class="icon-reorder"></i>账户信息变更</div>
            	</div>
                <div class="portlet-body form">
                    <form action="#" class="form-horizontal" id="submit_form">
                    <div class="form-wizard" >
                        <div class="tab-content">
                            <div class="alert alert-error hide">
                                <button class="close" data-dismiss="alert"></button>
                                	您提交的信息有误，请修改后保存！
                            </div>
                            <div class="alert alert-success hide">
                                <button class="close" data-dismiss="alert"></button>
                                	您提交的信息正确!
                            </div>
                            <div class="tab-pane active" id="tab1">
                                <h4 class="form-section">个人信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</h4>
                                
                                <div class="row-fluid">
						        <div class="span12">
						            <div class="portlet-body">
				                <div class="row-fluid">
				                    <div class="span6 responsive">
				                        <label class="control-label">客户编号：<span class="required">*</span></label>
				                        <div class="controls">
				                            <input type="text" class="span10  m-wrap" name="customerId" id="customerId" value="${custAccountApplyVo.custAccount.lenderCustCode}">
				                        </div>
				                    </div>
				                </div>      
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">姓名：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10  m-wrap" name="custName" id="custName" source_val="${custAccountApplyVo.custAccount.custName}" value="${custAccountApplyVo.custAccount.custName}">
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">姓名(拼音)：</label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="custNameSpell" id="custNameSpell" source_val="${custAccountApplyVo.custAccount.custNameSpell}" value="${custAccountApplyVo.custAccount.custNameSpell}">
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">性别：<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap" name="sex" id="sex" source_val="${custAccountApplyVo.custAccount.sex}">
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
                                    <div class="span6 responsive" style="margin-left: -50px;">
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
                                            <select class="span10 m-wrap" name="maritalStatus" id="maritalStatus" source_val="${custAccountApplyVo.custAccount.maritalStatus}">
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
                                    <div class="span6 responsive" style="margin-left: -50px;" >
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
                                            <select class="span10 m-wrap" name="idType" id="idType" source_val="${custAccountApplyVo.custAccount.idType}">
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
                                    <div class="span6 responsive" style="margin-left: -50px;" >
                                        <label class="control-label">证件号码：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="idCardNum" id="idCardNum" source_val="${custAccountApplyVo.custAccount.idCard}" value="${custAccountApplyVo.custAccount.idCard}">
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">出生日期：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input class="span10 m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" value="<#if custAccountApplyVo.custAccount.birthDate?exists>${custAccountApplyVo.custAccount.birthDate?string("yyyy-MM-dd")}</#if>" source_val="<#if custAccountApplyVo.custAccount.birthDate?exists>${custAccountApplyVo.custAccount.birthDate?string("yyyy-MM-dd")}</#if>" name="birthDate" id="birthDate" data-date-format="yyyy-mm-dd" >
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">移动电话：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="mobileNum" id="mobileNum" source_val="${custAccountApplyVo.custAccount.mobile}" value="${custAccountApplyVo.custAccount.mobile}">
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">职业：</label>
                                        <div class="controls">
                                            <select class="span10 m-wrap" name="profession" id="profession" source_val="${custAccountApplyVo.custProfession.profession}">
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
                                            <input type="text" class="span10 m-wrap" name="industry" id="industry" source_val="${custAccountApplyVo.custProfession.industry}" value="${custAccountApplyVo.custProfession.industry}">
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">单位名称：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="companyName" id="companyName" source_val="${custAccountApplyVo.custProfession.companyName}" value="${custAccountApplyVo.custProfession.companyName}">
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">职位：</label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap"  name="post" id="post" source_val="${custAccountApplyVo.custProfession.post}" value="${custAccountApplyVo.custProfession.post}">
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">最高学历：</label>
                                        <div class="controls">
                                            <select class="span10 m-wrap" name="education" id="education" source_val="${custAccountApplyVo.custAccount.education}">
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
                                    <div class="span12 responsive" style="margin-left:-11px;">
                                        <label class="control-label">通讯地址：<span class="required">*</span></label>
                                        <div class="controls">
                                            <div class="span7 responsive" style="margin-left:12px;">
                                                <div class="span4 responsive" id="provinceRegionCodeDiv">   
                                                    <select class="span10 m-wrap" name="provinceRegionCode" id="provinceRegionCode" source_val="${custAccountApplyVo.custComm.provinceRegionCode}" >
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
                                                <div class="span4 responsive" id="cityRegionCodeDiv">   
                                                   <select class="span8 m-wrap" name="cityRegionCode" id="cityRegionCode" source_val="${custAccountApplyVo.custComm.cityRegionCode}">
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
                                                <div class="span4 responsive" id="districtRegionCodeDiv" style="margin-left:-5px;" >   
                                                   <select class="span8 m-wrap" name="districtRegionCode" id="districtRegionCode" source_val="${custAccountApplyVo.custComm.districtRegionCode}">
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
                                             <div class="span5 responsive" style="margin-left: -25px;">
                                                <div class="span11 responsive"  id="streetInfoDiv">
                                                    <input type="text" class="m-wrap span10"  placeholder="街道信息" name="streetInfo" id="streetInfo"  value="${custAccountApplyVo.custComm.streetInfo}" source_val="${custAccountApplyVo.custComm.streetInfo}" />
                                                </div>
                                            </div>   
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">邮政编码：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap"  name="zipCode" id="zipCode" source_val="${custAccountApplyVo.custComm.zipCode}" value="${custAccountApplyVo.custComm.zipCode}">
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">固定电话：</label>
                                        <div class="controls">
                                            <div class="span5 responsive">
                                                <input type="text" class="span9 m-wrap"  name="areaCode" id="areaCode" source_val="${custAccountApplyVo.custComm.areaCode}" value="${custAccountApplyVo.custComm.areaCode}">
                                            </div>
                                            <div class="span1 responsive" style="line-height: 30px; margin-left: -10px;">
                                             - 
                                            </div>
                                            <div class="span6 responsive">
                                                <input type="text" class="span10 m-wrap"  name="telNum" id="telNum" source_val="${custAccountApplyVo.custComm.telNum}" value="${custAccountApplyVo.custComm.telNum}">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">电子邮箱：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="email" id="email" source_val="${custAccountApplyVo.custComm.email}" value="${custAccountApplyVo.custComm.email}" >
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">微信号：</label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap"  name="wechat" id="wechat" source_val="${custAccountApplyVo.custComm.wechat}" value="${custAccountApplyVo.custComm.wechat}" >
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <h4 class="form-section" style="text-align:left;">紧急联系人信息   </h4>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">姓名：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap"   name="linkmanName" id="linkmanName" source_val="${custAccountApplyVo.custLinkman.linkmanName}"  value="${custAccountApplyVo.custLinkman.linkmanName}">
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">姓名(拼音)：</label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap"  name="linkmanNameSpell" id="linkmanNameSpell" value="${custAccountApplyVo.custLinkman.linkmanNameSpell}" source_val="${custAccountApplyVo.custLinkman.linkmanNameSpell}" >
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">性别：<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap" name="linkmanSex" id="linkmanSex" source_val="${custAccountApplyVo.custLinkman.linkmanSex}">
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
                                            <input type="text" class="span10 m-wrap" name="linkmanRelation" id="linkmanRelation" source_val="${custAccountApplyVo.custLinkman.linkmanRelation}" value="${custAccountApplyVo.custLinkman.linkmanRelation}">
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">证件类型：</label>
                                        <div class="controls">
                                            <select class="span10 m-wrap" name="linkmanIdType" id="linkmanIdType" source_val="${custAccountApplyVo.custLinkman.linkmanIdType}">
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
                                            <input type="text" class="span10 m-wrap" name="linkmanIdCard" id="linkmanIdCard" value="${custAccountApplyVo.custLinkman.linkmanIdCard}" source_val="${custAccountApplyVo.custLinkman.linkmanIdCard}" >
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">移动电话：</label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap"  name="linkmanMobile" id="linkmanMobile" value="${custAccountApplyVo.custLinkman.linkmanMobile}"  source_val="${custAccountApplyVo.custLinkman.linkmanMobile}" >
                                        	<span class="selectOne" id="selectOne"></span>
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">固定电话：</label>
                                        <div class="controls">
                                            <div class="span5 responsive">
                                                <input type="text" class="span9 m-wrap" name="linkmanAreaCode" id="linkmanAreaCode" value="${custAccountApplyVo.custLinkman.areaCode}" source_val="${custAccountApplyVo.custLinkman.areaCode}" >
                                            </div>
                                            <div class="span1 responsive" style="line-height: 30px; margin-left: -10px;">
                                             - 
                                            </div>
                                            <div class="span6 responsive">
                                                <input type="text" class="span10 m-wrap" name="linkmanTelNum" id="linkmanTelNum" source_val="${custAccountApplyVo.custLinkman.telNum}" value="${custAccountApplyVo.custLinkman.telNum}" >
                                            </div>
                                        </div>
                                    </div>
                                </div>
                               
                                 <h4 class="form-section" style="text-align:left;">其他 </h4>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">接受文件方式：<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap" name="msgWay" id="msgWay" source_val="${custAccountApplyVo.custAccount.msgWay}">
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
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">开户日期：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input class="span10 m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" source_val="<#if custAccountApplyVo.custAccount.openDate?exists>${custAccountApplyVo.custAccount.openDate?string("yyyy-MM-dd")}</#if>" value="<#if custAccountApplyVo.custAccount.openDate?exists>${custAccountApplyVo.custAccount.openDate?string("yyyy-MM-dd")}</#if>" name="openDate" id="openDate"  data-date-format="yyyy-mm-dd">
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">客户来源：<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap" name="custSource" id="custSource" source_val="${custAccountApplyVo.custAccount.custSource}">
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
                                            <input type="text" class="span10 m-wrap" name="custSourceOther" id="custSourceOther" source_val="${custAccountApplyVo.custAccount.custSourceOther}" value="${custAccountApplyVo.custAccount.custSourceOther}" >
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">客户分类：<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap" name="custCategory" id="custCategory" source_val="${custAccountApplyVo.custAccount.custCategory}">
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
                 <!-- END FORM-->
                
                </form>   
            </div>
        </div>
                            </div>
                        </div>
                        
                    </div>
                </form>

                <div class="form-actions clearfix">
	                <a href="javascript:;" class="btn blue"  id="saveChange" onclick="doSaveChange()" >
	                      	变更
	                </a>
	               <a href="javascript:;" class="btn red" onclick="doChangeCloseDiv()">
	                      	关闭
	                </a>
	            </div>
	            
            </div>
        </div>
    </div>
    </div>

    <!-- END PAGE CONTENT-->         

</div>

<!-- END PAGE CONTAINER-->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/custAccount/create.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/custInfoChange/save.js" type="text/javascript"></script> 
<!-- END PAGE LEVEL SCRIPTS -->
<script>
    (function($) {
        $(function() {
        	//App.init();
            FormWizard.init();
           	FormComponents.init();
            initChangeInfo();
            initCustComm();
            initCustProfession();
            initCustFinance();
            initCustLinkman();
        });
    })(jQuery);
    
</script>

 