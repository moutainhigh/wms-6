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

<div class="container-fluid" id="applyInfo">
    <form action="#" role="form" class="form-horizontal" id="refundForm">
        <div class="row-fluid">
            <div class="span12">
                <div class="portlet-body">
                    <h4 class="form-section">出借信息</h4>
                    <div class="control-group">
                        <div class="span6 responsive">
                            <label class="control-label">合同编号：<span class="required">*</span></label>
                            <div class="controls">
                                <input type="text" class="span10 m-wrap" name="contractCode" id="contractCode" value="${custAccountApplyVo.lenderApply.contractCode}">
                                
                            </div>
                        </div>
                      <div class="span6 responsive" style="margin-left: -55px;">
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
                        <div class="span6 responsive" style="margin-left: -20x;"  name="expectLenderDate" id="expectLenderDate"  >
                            <label class="control-label">预计出借日期起：<span class="required">*</span></label>
                            <div class="controls">
                                <input class="span10 m-wrap m-ctrl-medium date-picker" readonly size="12" type="text" value="${custAccountApplyVo.lenderApply.expectLenderDateBegin}" name="expectLenderDateBegin" id="expectLenderDateBegin" data-date-format="yyyy-mm-dd"  >
                         	</div>
                    	</div> 
                        <div class="span6 responsive" style="margin-left: -50px;"  name="expectLenderDate" id="expectLenderDate"  >
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
                        
                        <div class="span6 responsive" >
                            <label class="control-label">签单日期：<span class="required">*</span></label>
                            <div class="controls">
                                <input class="span10 m-wrap m-ctrl-medium date-picker" readonly size="12" type="text" value="${custAccountApplyVo.lenderApply.signDate}" name="signDate" id="signDate" data-date-format="yyyy-mm-dd" >
                            </div>
                        </div>
                        <div class="span6 responsive" style="margin-left: -50px;">
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
                                <input type="text" class="span10 m-wrap" name="refundAccountName" id="refundAccountName" value="${refundCustFinance.accountName}" >
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
                    <h4 class="form-section">
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
                        <div class="span6 responsive" id ="specialLimitRemarkDiv"style="margin-left: -50px;" >
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
                        <div class="span6 responsive" id ="specialBenefitRemarkDiv" style="margin-left: -50px;">
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
    </form> 
</div>
             

<script>
    jQuery(document).ready(function() {   
        $("#applyInfo input").attr("disabled","disabled");
        $("#applyInfo select").attr("disabled","disabled");
        $("#bankInfoDiv").hide();
        $("#expectLenderDateBegin").val($("#expectLenderDateBegin").val().substring(0,10));
        $("#expectLenderDateEnd").val($("#expectLenderDateEnd").val().substring(0,10));
        $("#signDate").val($("#signDate").val().substring(0,10));
        $("#lenderIncomeRatioDiv").hide();
        $("#lenderIncomeRemarkDiv").hide();
        $("#save").hide();
        $("#specialLimitRemark").attr("disabled","disabled");
        $("#specialBenefitRemark").attr("disabled","disabled");
        showAccountInfo($("#custAccountId").val());
        if($("#bankInfo").val()==3){
            $("#bankInfoDiv").show();
        }else{
            $("#bankInfoDiv").hide();
        }
        if($("#isIncome").val()==1){
            $("#lenderIncomeRatioDiv").show();
            $("#lenderIncomeRemarkDiv").show();
        }else{
            $("#lenderIncomeRatioDiv").hide();
            $("#lenderIncomeRemarkDiv").hide();
        }
        if ($("#payWayId").val() == '3') {
		$("#signMobileDiv").show();
	} else {
		$("#signMobileDiv").hide();
	}
    });
    
</script>    
<script src="${baseUrl}/assets/js/form-wizard.js"></script>
<!-- BEGIN PAGE LEVEL SCRIPTS -->


 