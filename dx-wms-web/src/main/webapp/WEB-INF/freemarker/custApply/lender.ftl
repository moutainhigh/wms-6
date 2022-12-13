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
</style>

<!-- BEGIN PAGE CONTAINER-->
<div class="container-fluid">
    <!-- BEGIN PAGE HEADER-->
    <div class="row-fluid">
        <div class="span12">
            <h3 class="page-title">
                客户开户管理
            </h3>
        </div>
    </div>
    <!-- END PAGE HEADER-->
    <!-- BEGIN PAGE CONTENT-->
    <input type="hidden" name="custAccountId" id="custAccountId" value="${custAccountApplyVo.custAccount.custAccountId}">
    <input type="hidden" name="custCommId" id="custCommId" value="${custAccountApplyVo.custComm.custCommId}">
    <input type="hidden" name="custLinkmanId" id="custLinkmanId" value="${custAccountApplyVo.custLinkman.custLinkmanId}">
    <input type="hidden" name="remitCustFinanceId" id="remitCustFinanceId" value="${custAccountApplyVo.remitCustFinance.custFinanceId}">
    <input type="hidden" name="refundCustFinanceId" id="refundCustFinanceId" value="${custAccountApplyVo.refundCustFinance.custFinanceId}">
    <input type="hidden" name="custProfessionId" id="custProfessionId" value="${custAccountApplyVo.custProfession.custProfessionId}">
    <div class="row-fluid">
        <div class="span12">
            <div class="portlet box blue" id="form_wizard_1">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-reorder"></i> 开户申请
                    </div>
                </div>
                <div class="portlet-body form">
                
                    <form action="#" class="form-horizontal" id="submit_form">
                    <div class="form-wizard" >
      					<div class="navbar steps">
                            <div class="navbar-inner">
                                <ul class="row-fluid">
                                    <li class="span6">
                                        <a href="#tab1" data-toggle="tab" class="step">
                                            <span class="number">1</span>
                                            <span class="desc"><i class="icon-ok"></i> 开户信息</span>
                                        </a>
                                    </li>
                                    <li class="span6">
                                        <a href="#tab2" data-toggle="tab" class="step">
                                            <span class="number">2</span>
                                            <span class="desc"><i class="icon-ok"></i> 影像信息</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div id="bar" class="progress progress-success progress-striped">
                            <div class="bar"></div>
                        </div>
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
                                <h4 class="form-section">个人信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="btn blue" value="+选择客户" onclick="selectCust()" id="selectButton"></h4>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">姓名：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10  m-wrap" name="custName" id="custName" value="${custAccountApplyVo.custAccount.custName}">
                                            <span class="help-inline"></span>
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
                                            <span class="help-inline"></span>
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
                                    <div class="span12 responsive">
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
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
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
                                            <span class="help-inline"></span>
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
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
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
                                <h4 class="form-section">汇款帐户信息 </h4>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                    <label class="control-label">开户银行：<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap" name="remitBankCategory" id="remitBankCategory" value="${custAccountApplyVo.remitCustFinance.bankCategory}">
                                                <option value='-1'>请选择</option>
                                                <#if bankCategory?exists>
                                                    <#list bankCategory?keys as key>
                                                        <#if key==custAccountApplyVo.remitCustFinance.bankCategory>
                                                            <option value=${key} selected="selected">${bankCategory[key]}</option>
                                                        <#else>
                                                            <option value=${key}>${bankCategory[key]}</option>
                                                        </#if> 
                                                    </#list>
                                                </#if>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">支行：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="remitSubBank" id="remitSubBank" value="${custAccountApplyVo.remitCustFinance.subBank}" >
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">户名：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="remitAccountName" id="remitAccountName" value="${custAccountApplyVo.remitCustFinance.accountName}" >
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">账号：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="remitAccountNum" id="remitAccountNum" value="${custAccountApplyVo.remitCustFinance.accountNum}" >
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <h4 class="form-section">回款帐户信息 </h4>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">开户银行：<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap" name="refundBankCategory" id="refundBankCategory" value="${custAccountApplyVo.refundCustFinance.bankCategory}">
                                                <option value='-1'>请选择</option>
                                                <#if bankCategory?exists>
                                                    <#list bankCategory?keys as key>
                                                        <#if key==custAccountApplyVo.refundCustFinance.bankCategory>
                                                           <option value=${key} selected="selected">${bankCategory[key]}</option>
                                                        <#else>
                                                            <option value=${key}>${bankCategory[key]}</option>
                                                        </#if> 
                                                    </#list>
                                                </#if>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">支行：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="refundSubBank" id="refundSubBank" value="${custAccountApplyVo.refundCustFinance.subBank}">
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6 responsive">
                                        <label class="control-label">户名：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="refundAccountName" id="refundAccountName" value="${custAccountApplyVo.refundCustFinance.accountName}" >
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">账号：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="refundAccountNum" id="refundAccountNum" value="${custAccountApplyVo.refundCustFinance.accountNum}" >
                                            <span class="help-inline"></span>
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
                                    <div class="span6 responsive"  style="margin-left: -50px;">
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
                                        <label class="control-label">其他：</label>
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
                            <div class="tab-pane" id="tab2">
                            	
								<h4 class="form-section">
									影像信息 &nbsp;&nbsp;&nbsp;&nbsp;
								</h4>
								<div class="control-group" id="vFolder" style="text-align:center;height:auto;">
								    <!-- 影像资料文件夹 -->				
								</div>
								<br ><h4 class="form-section"></h4>	
								<div class="control-group" id="vFile" style="text-align:center;height:auto;">
									<!-- 影像资料文件 -->
								</div>
                            </div>
                        </div>
                        
                    </div>
                </form>

				<div id="uploadDiv">
                <!-- 文件上传处 -->	
					<h4 class="form-section">
						选择需要上传的资料 &nbsp;&nbsp;&nbsp;&nbsp;
					</h4>	
	        		<form id="fileUploadFormFrom">
						<!-- 资源标示 wmsCustOpenApply wmsCustLenderApply  wmsLenderCheck-->
						<input type="hidden" id="resKey" name="resKey" value="wmsCustOpenApply" >
						<!-- 系统 编码-->
						<input type="hidden" id="appCode" name="appCode" value="wms" >
						<!-- 当前查看文件的目录 -->
						<input type="hidden" id="currentFileDir" name="currentFileDir" value="" >
						<!-- 上传文件 -->
						<input type="hidden" id="cmAction" name="cmAction" value="uploadFile" >
						<!-- 用户编号  -->
						<input type="hidden" id="userUniqueId" name="userUniqueId" value="${custAccountApplyVo.custAccount.custAccountId}" >
						<input type="hidden" id="lenderCustCode" name="lenderCustCode" value="${lenderCustCode}" >
						<!-- 某用户理财序号 -->
						<input type="hidden" id="lenderUniqueId" name="lenderUniqueId" value="${lenderApplyId}" >
						<input type="hidden" id="lenderCode" name="lenderCode" value="${lenderCode}" >
							
						<div class="modal-body">	
							<div class="controls" style="margin-left: 0px">
								<div class="fileupload fileupload-new" data-provides="fileupload">
									<div class="input-append">
										<div class="uneditable-input">
											<i class="icon-file fileupload-exists"></i>
											<span class="fileupload-preview"></span>
										</div>
										<span class="btn btn-file">
											<span class="fileupload-new" id="file_choose">选择</span>
											<span class="fileupload-exists" id="file_update">更改</span>
											<input type="file" class="default" id="file" name="file">
										</span>
										<a href="#" class="btn fileupload-exists" data-dismiss="fileupload" id="file_del">移除</a>
										<button class="btn blue" id="upload">上传</button>
										<div class="uneditable-input" id="upLoadImg" style="display:none;text-align:center;width:23px;height:23px;border:0px">
											<img src="${resRoot}/image/u37.png">
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>	
	            </div>	

                <div class="form-actions clearfix">
	                <a href="javascript:;" class="btn blue button-next"  id="save">
	                      	保存 <i class="m-icon-swapright m-icon-white"></i>
	                </a>
	                 <a href="javascript:;" class="btn blue button-next" id="nextPage">
	                                           下一页 
	                </a>
	                 <a href="javascript:;" class="btn blue button-submit" onclick="doCreateUserAccount()">
	                    	确认开户 <i class="m-icon-swapright m-icon-white"></i>
	                </a>
	               <a href="javascript:;" class="btn red" onclick="doCloseDiv()">
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
<script>
var base = "${baseUrl}"; 
var resBase = "${resRoot}";
</script>
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-wizard.js"></script>
<script src="${baseUrl}/assets/js/form-components.js"></script>
<script src="${baseUrl}/assets/js/custAccount/create.js" type="text/javascript"></script> 
<!-- END PAGE LEVEL SCRIPTS -->
<script>
    (function($) {
        $(function() {
            App.init();
            FormWizard.init();
            FormComponents.init();
            initCustAccount();
            initCustComm();
            initCustProfession();
            initCustFinance();
            initCustLinkman();

			uploadFiles("upload");	
        });
    })(jQuery);
    
</script>
 