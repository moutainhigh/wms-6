<style>
    .boder-right-scroll{
        width:100%;
        overflow-x:scroll;
    }
    .row-fluid{
        height: 50px;
    }
    .rmb1{
    	line-height: 30px;
    	position:absolute;
    }
</style>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="portlet-body" id="apply">
                <h4 class="form-section" style="text-align:left;" >出借信息</h4>
                <div class="control-group">
                    <div class="span6 responsive">
                        <label class="control-label">合同编号：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="contractCode" id="contractCode" value="${custAccountApplyVo.lenderApply.contractCode}">
                            
                        </div>
                    </div>
                     <div class="span6 responsive"style="margin-left: -50px;"> 
                        <label class="control-label">出借方式：<span class="required">*</span></label>
                        <div class="controls">
                            <select class="span10 m-wrap" name="productId" id="productId"  value="${custAccountApplyVo.lenderApply.productId}">
                                <option value='-1'>请选择</option>
                                <#if productId?exists>
                                    <#list productId?keys as key>
                                        <#if key==custAccountApplyVo.lenderApply.productId>
                                            <option value=${key} selected="selected">${productId[key]}</option>
                                        <#else>    
                                            <option value=${key}>${productId[key]}</option> 
                                        </#if> 
                                    </#list>
                                </#if>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="control-group" >       
                    <div class="span6 responsive" style="margin-left: -50x;"  name="expectLenderDate" id="expectLenderDate"  >
                        <label class="control-label">预计出借日期起：<span class="required">*</span></label>
                        <div class="controls">
                            <input class="span10 m-wrap m-ctrl-medium date-picker" readonly size="12" type="text" value="<#if custAccountApplyVo.lenderApply.expectLenderDateBegin?exists>${custAccountApplyVo.lenderApply.expectLenderDateBegin?string("yyyy-MM-dd")}</#if>" name="expectLenderDateBegin" id="expectLenderDateBegin" data-date-format="yyyy-mm-dd"  >
                   		 </div>
                     </div> 
				<div class="span6 responsive" style="margin-left: -50px;"  name="expectLenderDate" id="expectLenderDate"  >
                        <label class="control-label">预计出借日期止：<span class="required">*</span></label>
                        <div class="controls">             
                            <input class="span10 m-wrap m-ctrl-medium date-picker" readonly size="12" type="text" value="<#if custAccountApplyVo.lenderApply.expectLenderDateEnd?exists>${custAccountApplyVo.lenderApply.expectLenderDateEnd?string("yyyy-MM-dd")}</#if>" name="expectLenderDateEnd" id="expectLenderDateEnd" data-date-format="yyyy-mm-dd" >
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="span6 responsive">
                        <label class="control-label">出借金额：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="lenderAmount" id="lenderAmount" value="${custAccountApplyVo.lenderApply.lenderAmount}">
                            <span class="rmb1">元</span>
                        </div>
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
                            <select class="span10 m-wrap" name="payWayId" id="payWayId"  value="${custAccountApplyVo.lenderApply.payWayId}">
                                <option value='-1'>请选择</option>
                                <#if payWayId?exists>
                                    <#list payWayId?keys as key>
                                        <#if key==custAccountApplyVo.lenderApply.payWayId>
                                            <option value=${key} selected="selected">${payWayId[key]}</option>
                                        <#else>    
                                            <option value=${key}>${payWayId[key]}</option> 
                                        </#if> 
                                    </#list>
                                </#if>
                            </select>
                        </div>
                    </div>
                    <div class="span6 responsive" style="margin-left: -55px;">
                        <label class="control-label">签单日期：<span class="required">*</span></label>
                        <div class="controls">
                            <input class="span10 m-wrap m-ctrl-medium date-picker" readonly size="12" type="text" value="<#if custAccountApplyVo.lenderApply.signDate?exists>${custAccountApplyVo.lenderApply.signDate?string("yyyy-MM-dd")}</#if>" name="signDate" id="signDate" data-date-format="yyyy-mm-dd" >
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
                                      <div class="controls" style="position: relative;right: 17%;">
                                     <input type="text" class="span10 m-wrap" maxlength="11" name="signMobile" id="signMobile" value="${custAccountApplyVo.lenderApply.signMobile}">
                                 </div>
                              </div>
                                </div>
                <h4 class="form-section" style="text-align:left;">支付帐户信息 </h4>
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
                            <select class="span10 m-wrap" name="payBankCategory" id="payBankCategory" value="${payCustFinance.bankCategory}">
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
                            <input type="text" class="span10 m-wrap" name="paySubBank" id="paySubBank" value="${payCustFinance.subBank}" >
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>
                
                <div class="control-group">
                    <div class="span6 responsive">
                        <label class="control-label">户名：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="payAccountName" id="payAccountName" value="${custAccountApplyVo.custAccount.custName}" >
                        </div>
                    </div>
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">账号：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="payAccountNum" id="payAccountNum" value="${payCustFinance.accountNum}" >
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>

                <h4 class="form-section" style="text-align:left;">回款帐户信息 </h4>
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
                            <select class="span10 m-wrap" name="refundBankCategory" id="refundBankCategory" value="${refundCustFinance.bankCategory}">
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
                            <input type="text" class="span10 m-wrap" name="refundSubBank" id="refundSubBank" value="${refundCustFinance.subBank}">
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>

                <div class="control-group">
                    <div class="span6 responsive">
                        <label class="control-label">户名：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="refundAccountName" id="refundAccountName" value="${custAccountApplyVo.custAccount.custName}" >
                        </div>
                    </div>
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">账号：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" name="refundAccountNum" id="refundAccountNum" value="${refundCustFinance.accountNum}" >
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>  
                <h4 class="form-section" style="text-align:left;">
                                               特殊情况说明
                </h4>
                <br/>
                <div class="control-group" id ="specialLimitDiv" style="height:auto" >
                    <div class="span6 responsive" >
                        <label class="control-label">特殊额度：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" id = "specialLimit" name="specialLimit" value="${specialLimitInfo.lenderConditionVal}">
                        	<span class="rmb1">元</span>
                        </div>
                    </div>
                    <div class="span6 responsive" id ="specialLimitRemarkDiv" style="margin-left:-50px;">
                        <label class="control-label">备注：<span class="required">*</span></label>
                        <div class="controls">
                            <textarea rows="3" maxlength="50" class="span10 m-wrap" type="text" id = "specialLimitRemark" name="specialLimitRemark" >${specialLimitInfo.lenderConditionRemark}</textarea>
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div> 
                <br/>
                <div class="control-group" id ="specialBenefitDiv" style="height:auto" >  
                    <div class="span6 responsive" >
                        <label class="control-label">特殊收益：<span class="required">*</span></label>
                        <div class="controls">
                            <input type="text" class="span10 m-wrap" id = "specialBenefit" name="specialBenefit" value="${specialBenefitInfo.lenderConditionVal}">
                        	<span class="percent">%</span>
                        </div>
                    </div>
                    <div class="span6 responsive" id ="specialBenefitRemarkDiv" style="margin-left:-50px;">
                        <label class="control-label">备注：<span class="required">*</span></label>
                        <div class="controls">
                            <textarea rows="3" maxlength="50" class="span10 m-wrap" type="text" id = "specialBenefitRemark" name="specialBenefitRemark" >${specialBenefitInfo.lenderConditionRemark}</textarea>
                            <span class="help-inline"></span>
                        </div>
                    </div>
                </div>
            </div>  
        </div>
    </div>
</div>
             

<script>
    jQuery(document).ready(function() {       
         $("#apply input").attr("disabled","disabled");
       	 $("#apply select").attr("disabled","disabled");
         $("#lenderIncomeRemark").attr("disabled","disabled");
         $("#specialLimitRemark").attr("disabled","disabled");
         $("#specialBenefitRemark").attr("disabled","disabled");
         if ($("#payWayId").val() == '3') {
		$("#signMobileDiv").show();
	} else {
		$("#signMobileDiv").hide();
	}
         
    });
    
    
</script>    
<!-- BEGIN PAGE LEVEL SCRIPTS -->


 