<style>
    .control-group{
        height: 60px;
    }
    .control-group{
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
   
    .beyondRmb{
    	color:#CD6563;
    	position:relative;
    	left:180px;
    }
   .span10.m-wrap.bank{
   		width:256px;
   }
   .bankAccount{
   		color:#b94a48;
   		position:relative;
    	left:180px;
   }
   .refundAccount{
   		color:#b94a48;
   		position:relative;
    	left:180px;
   }
	.span6.responsive.right{
		margin-left: -50px;
	}
</style>

<!-- BEGIN PAGE CONTAINER-->
<#include "/macro/base.ftl">
<div class="container-fluid">
    <!-- BEGIN PAGE HEADER-->
    <!-- END PAGE HEADER-->
    <!-- BEGIN PAGE CONTENT-->
    <input type="hidden" name="custAccountId" id="custAccountId" value="${custAccountApplyVo.custAccount.custAccountId}">
    <input type="hidden" name="lenderApplyId" id="lenderApplyId" value="${custAccountApplyVo.lenderApply.lenderApplyId}">
    <input type="hidden" name="lenderCode" id="lenderCode" value="${custAccountApplyVo.lenderApply.lenderCode}">
    <input type="hidden" name="payCustFinanceId" id="payCustFinanceId" value="${payCustFinance.custFinanceId}">
    <input type="hidden" name="refundCustFinanceId" id="refundCustFinanceId" value="${refundCustFinance.custFinanceId}">
	<input type="hidden" name="specialLimitId" id="specialLimitId" value="${specialLimitInfo.lenderConditionId}">
    <input type="hidden" name="specialBenefitId" id="specialBenefitId" value="${specialBenefitInfo.lenderConditionId}">
    <input type="hidden" name="parentId" id="parentId" value="${parentId}">
    <div class="row-fluid">
        <div class="span12">
        	<br>
            <div class="portlet box blue" id="form_wizard_1">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-reorder"></i> 理财申请
                    </div>
                </div>
                <div class="portlet-body" >
                    <form action="#" class="form-horizontal" id="submit_form">
                    <div class="form-wizard" >
                        <div class="navbar steps">
                            <div class="navbar-inner">
                                <ul class="row-fluid">
                                    <li class="span4">
                                        <a href="#tab1" data-toggle="tab" class="step">
                                            <span class="number">1</span>
                                            <span class="desc"><i class="icon-ok"></i> 账户信息</span>
                                        </a>
                                    </li>
                                    <li class="span4">
                                        <a href="#tab2" data-toggle="tab" class="step">
                                            <span class="number">2</span>
                                            <span class="desc"><i class="icon-ok"></i> 投资信息</span>
                                        </a>
                                    </li>
                                    <li class="span4">
                                        <a href="#tab3" data-toggle="tab" class="step">
                                            <span class="number">3</span>
                                            <span class="desc"><i class="icon-ok"></i> 影像信息</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div id="bar" class="progress progress-success progress-striped">
                            <div class="bar"></div>
                        </div>
                        <div class="tab-content h250-y">
                            <div class="alert alert-error hide">
                                <button class="close" data-dismiss="alert"></button>
                            		您提交的信息有误，请修改后保存！
                            </div>
                            <div class="alert alert-success hide">
                                <button class="close" data-dismiss="alert"></button>
                            		您提交的信息正确!
                            </div>
                            <div class="tab-pane active" id="tab1">
                                <div class="row-fluid" id="account" style="text-align:center;height:auto;">
                                        <!-- 客户信息-->                
                                </div>
                            </div>
                            <div class="tab-pane active" id="tab2">
                                <h4 class="form-section">出借信息</h4>
                                <div class="control-group">
                                	 <div class="span6 responsive">
                                        <label class="control-label">合同编号：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" maxlength="20" name="contractCode" id="contractCode" value="${custAccountApplyVo.lenderApply.contractCode}">
                                        </div>
                                    </div>
                                    <div class="span6 responsive" style="margin-left: -50px;">
                                        <label class="control-label">出借方式：<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap" name="productId" id="productId"  value="${custAccountApplyVo.lenderApply.productId}">
                                                <option value='-1'>请选择</option>
                                                <#if product?exists>
                                                    <#list product?keys as key>
                                                        <#if key==custAccountApplyVo.lenderApply.productId>
                                                            <option value=${key} selected="selected">${product[key]}</option>
                                                        <#else>    
                                                            <option value=${key}>${product[key]}</option> 
                                                        </#if> 
                                                    </#list>
                                                </#if>
                                            </select>
                                        </div>
                                    </div>
                                    
                                </div>
                                <div class="control-group" >
                                    <div class="span6 responsive"   name="expectLenderDate" id="expectLenderDate"  >
                                        <label class="control-label">预计出借日期起：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input class="span10 m-wrap m-ctrl-medium date-picker" readonly size="12" type="text" value="${custAccountApplyVo.lenderApply.expectLenderDateBegin}" name="expectLenderDateBegin" id="expectLenderDateBegin" data-date-format="yyyy-mm-dd"  >
                                  		</div>
                                  	 </div> 
 										<div class="span6 responsive right"  style="margin-left: -50px;" name="expectLenderDate" id="expectLenderDate"  >                                  		
                                        <label class="control-label">预计出借日期止：<span class="required">*</span></label>
                                        <div class="controls">        
                                            <input class="span10 m-wrap m-ctrl-medium date-picker" readonly size="12" type="text" value="${custAccountApplyVo.lenderApply.expectLenderDateEnd}" name="expectLenderDateEnd" id="expectLenderDateEnd" data-date-format="yyyy-mm-dd" >
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="span6 responsive">
                                        <label class="control-label">出借金额：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" maxlength="13" class="span10 m-wrap" name="lenderAmount" id="lenderAmount" value="${custAccountApplyVo.lenderApply.lenderAmount}">
                                           <span class="rmb2"  style="line-height: 40px;">元</span>
                                        </div>
                                        <span class="beyondRmb" id="beyondRmb"></span>
                                    </div>
                                    <div class="span6 responsive" style="margin-left: -50px;">
                                        <label class="control-label">大写金额：</label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="bigLenderAmount" id="bigLenderAmount" value="${custAccountApplyVo.biglenderAmount}">
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="span6 responsive">
                                        <label class="control-label">支付方式：<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap bank" name="payWayId" id="payWayId"  value="${custAccountApplyVo.lenderApply.payWayId}">
                                                <option value='-1'>请选择</option>
                                                <#if payWay?exists>
                                                    <#list payWay?keys as key>
                                                        <#if key==custAccountApplyVo.lenderApply.payWayId>
                                                            <option value=${key} selected="selected">${payWay[key]}</option>
                                                        <#else>    
                                                            <option value=${key}>${payWay[key]}</option> 
                                                        </#if> 
                                                    </#list>
                                                </#if>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="span6 responsive" style="margin-left: -50px;">
                                        <label class="control-label">签单日期：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input class="span10 m-wrap m-ctrl-medium date-picker" readonly size="12" type="text" value="${custAccountApplyVo.lenderApply.signDate}" name="signDate" id="signDate" data-date-format="yyyy-mm-dd" >
                                        </div>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="span6 responsive">
                                        <label class="control-label">回收方式：<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap bank" name="recovery" id="recovery"  value="${custAccountApplyVo.lenderApply.recovery}">
                                                <option value='-1'>请选择</option>
                                                <#if recoveryMode?exists>
                                                    <#list recoveryMode?keys as key>
                                                        <#if key==custAccountApplyVo.lenderApply.recovery>
                                                            <option value="${key}" selected="selected">${recoveryMode[key]}</option>
                                                        <#else>    
                                                            <option value="${key}">${recoveryMode[key]}</option> 
                                                        </#if> 
                                                    </#list>
                                                </#if>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="span6 responsive" id="signMobileDiv">
                                        <label class="control-label" style="width: 19%;">签约手机：<span class="required">*</span></label>
                                        <div class="controls" style="position: relative;right: 15%;">
                                            <input type="text" class="span10 m-wrap" maxlength="11" name="signMobile" id="signMobile" value="${custAccountApplyVo.lenderApply.signMobile}">
                                        </div>
                                    </div>
                                </div>
                                <h4 class="form-section">支付帐户信息 </h4>
                                <div class="control-group">
                                    <div class="span6 responsive">
                                        <label class="control-label">请选择省<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap bank" name="payprovinceRegionCode" id="payprovinceRegionCode" value="${payCustFinance.provinceRegionCode}" >
                                                <option value='-1'>请选择</option>
                                                <#if areas?exists>
                                                    <#list areas?keys as key>
                                                        <#if key==payCustFinance.provinceRegionCode>
                                                           <option value=${key} selected="selected">${areas[key]}</option>
                                                        <#else>
                                                            <option value=${key}>${areas[key]}</option>
                                                        </#if>
                                                    </#list>
                                                </#if>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="span6 responsive" style="position: relative;right: 75px;">
                                        <label class="control-label">请选择市<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap bank" name="paycityRegionCode" id="paycityRegionCode" value="${payCustFinance.cityRegionCode}">
                                                <option value='-1'>请选择</option>
                                                <#if paycityRegionCode?exists>
														     <#list paycityRegionCode as area>
															    <#if area.area_code_id==payCustFinance.cityRegionCode>   
																   <option value=${area.area_code_id} selected="selected">${area.area_code_name}</option>
															    <#else>
																   <option value=${area.area_code_id}>${area.area_code_name}</option>
															    </#if>
                                                    </#list>    
                                                </#if>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="span6 responsive">
                                        <label class="control-label">开户银行：<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap bank" name="payBankCategory" id="payBankCategory" value="${payCustFinance.bankCategory}">
                                                <option value='-1'>请选择</option>
                                                <#if bankCategory?exists>
                                                    <#list bankCategory?keys as key>
                                                        <#if key==payCustFinance.bankCategory>
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
                                            <select class="span10 m-wrap bank" name="paySubBank" id="paySubBank" value="${payCustFinance.subBank}">
                                                <option value='-1'>请选择</option>
                                               <#if subBank?exists>
														     <#list subBank as area>
															    <#if area==payCustFinance.subBank>   
																   <option value=${payCustFinance.subBank} selected="selected">${payCustFinance.subBank}</option>
															    <#else>
																   <option value=${payCustFinance.subBank}>${payCustFinance.subBank}</option>
															    </#if>
                                                    </#list>    
                                                </#if>
                                            </select>
                                            
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="control-group otherBank">
									<div class="span6 responsive hide-div" id="" style="">
									    <label class="control-label ">其他支行：
										    	<span class="required">*</span>
									    </label>
									    <div class="controls ">
									<input class="span10 m-wrap otherAddress" name="otherAddress" id="otherAddress1" value="" type="text">
									    </div>
									</div>
								</div>
                                
                                <div class="control-group">
                                    <div class="span6 responsive">
                                        <label class="control-label">户名：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="payAccountName" id="payAccountName" value="${custAccountApplyVo.custAccount.custName}" >
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">账号：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" maxlength="30" class="span10 m-wrap" name="payAccountNum" id="payAccountNum" value="${payCustFinance.accountNum}" >
                                        </div>
                                        <span class="bankAccount" id="bankAccount"></span>
                                    </div>
                                </div>
                
                                <h4 class="form-section">回款帐户信息 </h4>
                                <div class="control-group">
                                    <div class="span6 responsive">
                                        <label class="control-label">请选择省<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap bank" name="refundprovinceRegionCode" id="refundprovinceRegionCode" value="${refundCustFinance.provinceRegionCode}">
                                                <option value='-1'>请选择</option>
                                                <#if areas?exists>
                                                    <#list areas?keys as key>
                                                        <#if key==refundCustFinance.provinceRegionCode>
                                                           <option value=${key} selected="selected">${areas[key]}</option>
                                                        <#else>
                                                            <option value=${key}>${areas[key]}</option>
                                                        </#if> 
                                                    </#list>
                                                </#if>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="span6 responsive" style="position: relative;right: 75px;">
                                        <label class="control-label">请选择市<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap bank" name="refundcityRegionCode" id="refundcityRegionCode" value="${refundCustFinance.cityRegionCode}">
                                                <option value='-1'>请选择</option>
                                                <#if refundcityRegionCode?exists>
														     <#list refundcityRegionCode as area>
															    <#if area.area_code_id=refundCustFinance.cityRegionCode>
																   <option value=${area.area_code_id} selected="selected">${area.area_code_name}</option>
															    <#else>
																   <option value=${area.area_code_id}>${area.area_code_name}</option>
															    </#if>
														 </#list>
													  </#if>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="control-group">
                                    <div class="span6 responsive">
                                        <label class="control-label">开户银行：<span class="required">*</span></label>
                                        <div class="controls">
                                            <select class="span10 m-wrap bank" name="refundBankCategory" id="refundBankCategory" value="${refundCustFinance.bankCategory}">
                                                <option value='-1'>请选择</option>
                                                <#if bankCategory?exists>
                                                    <#list bankCategory?keys as key>
                                                        <#if key==refundCustFinance.bankCategory>
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
                                            <select class="span10 m-wrap bank" name="refundSubBank" id="refundSubBank" value="${payCustFinance.subBank}">
                                                <option value='-1'>请选择</option>
                                               <#if subBank?exists>
														     <#list subBank as area>
															    <#if area==payCustFinance.subBank>   
																   <option value=${payCustFinance.subBank} selected="selected">${payCustFinance.subBank}</option>
															    <#else>
																   <option value=${payCustFinance.subBank}>${payCustFinance.subBank}</option>
															    </#if>
                                                    </#list>    
                                                </#if>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                				 <div class="control-group otherBank">
									<div class="span6 responsive hide-div" id="" style="">
									    <label class="control-label ">其他支行：
										    	<span class="required">*</span>
									    </label>
									    <div class="controls ">
									<input class="span10 m-wrap otherAddress" name="otherAddress" id="otherAddress2" value="" type="text">
									    </div>
									</div>
								</div>
                                <div class="control-group">
                                    <div class="span6 responsive">
                                        <label class="control-label">户名：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" class="span10 m-wrap" name="refundAccountName" id="refundAccountName" value="${custAccountApplyVo.custAccount.custName}" >
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                    <div class="span6 responsive"  style="margin-left: -50px;">
                                        <label class="control-label">账号：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" maxlength="30" class="span10 m-wrap" name="refundAccountNum" id="refundAccountNum" value="${refundCustFinance.accountNum}" >
                                        </div>
                                        <span class="refundAccount" id="refundAccount"></span>
                                    </div>
                                </div>  
                                <h4 class="form-section">
                            		特殊情况说明：&nbsp;&nbsp;
                                 	<label class="checkbox inline">
										<input type="checkbox" name="specialData" value="specialCredits" <#if specialLimitInfo.lenderConditionVal?exists> checked="checked" </#if> /> &nbsp;&nbsp;特殊额度&nbsp;&nbsp;
									</label>
									<label class="checkbox inline">
										<input type="checkbox" name="specialData" value="specialProfits" <#if specialBenefitInfo.lenderConditionVal?exists> checked="checked" </#if> /> &nbsp;&nbsp;特殊收益&nbsp;&nbsp;
									</label>
                                </h4>
                                <br/>
                                <div class="control-group" id ="specialCredits" style="height:auto" >
                                    <div class="span6 responsive" >
                                        <label class="control-label" >特殊额度：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" maxlength="13" class="span10 m-wrap" id ="specialLimit" name="specialLimit" value="${specialLimitInfo.lenderConditionVal}">
                                       		<span class="rmb3" style="line-height: 40px;">元</span>
                                        </div>
                                    </div>
                                    <div class="span6 responsive" style="margin-left: -50px;">
                                        <label class="control-label">备注：<span class="required">*</span></label>
                                        <div class="controls">
                                            <textarea rows="3" maxlength="200" class="span10 m-wrap" type="text" id = "specialLimitRemark" name="specialLimitRemark" >${specialLimitInfo.lenderConditionRemark}</textarea>
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div> 
                                <br/>
                                <div class="control-group" id ="specialProfits" style="height:auto" >  
                                    <div class="span6 responsive" >
                                        <label class="control-label">特殊收益：<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" maxlength="13" class="span10 m-wrap" id = "specialBenefit" name="specialBenefit" value="${specialBenefitInfo.lenderConditionVal}">
                                        	<span class="percent"  style="line-height: 40px;">%</span>
                                        </div>
                                    </div>
                                    <div class="span6 responsive" style="margin-left: -50px;">
                                        <label class="control-label">备注：<span class="required">*</span></label>
                                        <div class="controls">
                                            <textarea rows="3" maxlength="200" class="span10 m-wrap" type="text" id = "specialBenefitRemark" name="specialBenefitRemark" >${specialBenefitInfo.lenderConditionRemark}</textarea>
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>
                                </div>
                         	</div>
                            <div class="tab-pane" id="tab3">
                                <h4 class="form-section">影像信息 &nbsp;&nbsp;&nbsp;&nbsp;</h4>
                                <div class="control-group" id="vFolder" style="text-align:center;height:auto;">
                                    <!-- 影像资料文件夹 -->                
                                </div>
                                <br >
                                <h4 class="form-section"></h4> 
                                <div class="control-group" id="vFile" style="text-align:center;height:auto;">
                                    <!-- 影像资料文件 -->
                                </div>
                                <#if lenderApplyLogs?? && lenderApplyLogs?size!=0>
                                    <div id="checkRecords" >
                                        <h4 class="form-section" style="text-align:left">  操作记录  </h4>
                                        <div class="control-group" id="ckResults" style="text-align:center;height:auto;">
                                        <!-- 影像资料文件夹 -->     
                                            <div class="form-group">
                                                <table cellspacing="0" class="table table-striped table-bordered table-advance table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>操作人</th>
															<th>操作时间</th>
															<th>操作环节</th>
															<th>操作结果</th>
															<th>操作内容</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="logList">
                                                        <#if lenderApplyLogs?exists>
                                                            <#list lenderApplyLogs as log>
                                                                <tr>
                                                                    <td width="150">${log.createUser}</td>
																	<td width="250">${log.createTime}</td> 
																	<td width="150">${log.currentStep}</td> 
																	<td width="150">${log.currentAction}</td>
																	<td width="400" style="word-break:break-all">${log.approveComment}</td>
                                                                </tr>
                                                            </#list>
                                                        </#if>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </#if>
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
                    <input type="hidden" id="resKey" name="resKey" value="wmsCustLenderApply" >
                    <!-- 系统 编码-->
                    <input type="hidden" id="appCode" name="appCode" value="wms" >
                    <!-- 当前查看文件的目录 -->
                    <input type="hidden" id="currentFileDir" name="currentFileDir" value="" >
                    <!-- 上传文件 -->
                    <input type="hidden" id="cmAction" name="cmAction" value="uploadFile" >
                    <!-- 用户编号  -->
                    <input type="hidden" id="userUniqueId" name="userUniqueId" value="${custAccountApplyVo.custAccount.custAccountId}" >
                    <input type="hidden" id="lenderCustCode" name="lenderCustCode" value="${custAccountApplyVo.custAccount.lenderCustCode}" >
                    <!-- 某用户理财序号 -->
                    <input type="hidden" id="lenderUniqueId" name="lenderUniqueId" value="${custAccountApplyVo.lenderApply.lenderApplyId}" >
                    <input type="hidden" id="lenderCode" name="lenderCode" value="${custAccountApplyVo.custAccount.lenderCode}" >
                    
                    <!-- 某用户理财序号 -->
                    <div class="modal-body">    
                        <div class="controls" style="margin-left: 0px">
                            <div class="fileupload fileupload-new" data-provides="fileupload">
                                <div class="input-append">
                                    <div class="uneditable-input">
                                        <i class="icon-file fileupload-exists"></i>
                                        <span class="fileupload-preview"></span>
                                    </div>
                                    <span class="btn blue btn-file">
                                        <span class="fileupload-new" id="file_choose">选择</span>
                                        <span class="fileupload-exists" id="file_update">更改</span>
                                        <input type="file" class="default" id="file" name="file">
                                    </span>
                                    <a href="#" class="btn blue fileupload-exists" data-dismiss="fileupload" id="file_del">移除</a>
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
            </div>
            <@mBottom>
	    		<@aLeft/><@aRight id="save"/>
	            <a href="javascript:;" class="btn blue button-submit"  onclick="submitToSalesService()"><span id="createUserAccount">提交销售客服</span> <i class="m-icon-swapright m-icon-white"></i></a>
	        </@mBottom>
        </div>
    </div>
</div>

    <!-- END PAGE CONTENT-->         




<!-- END PAGE CONTAINER-->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script>
var base = "${baseUrl}"; 
var resBase = "${resRoot}";
</script>
<script src="${baseUrl}/assets/js/custApply/create.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/form-wizard.js"></script>
<link href="${baseUrl}/assets/css/detail/detail.css" rel="stylesheet" type="text/css" />   
<!-- END PAGE LEVEL SCRIPTS -->
<script>
    (function($) {
        $(function() {
        	//App.init();
            FormWizard.init();
            FormComponents.init();
			uploadFiles("upload");
			$("#next").click(function(){
	            $('#createCustApplyDiv').scrollTop(0);
			});	
        });
    })(jQuery);
    
</script>
 