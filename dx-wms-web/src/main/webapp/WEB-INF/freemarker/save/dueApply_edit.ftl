<#include "/macro/base.ftl">
<h4 class="form-section">出借信息</h4>
<div class="row-fluid">
	<@div title="合同编号" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
        <@text name="contractCode" value=saver.apply.contractCode inline=true class="span10"/>
    </@div>
    <@div title="出借方式" required=true labelClass="w140" controlsClass="ml160" >
		<@select source=productAll target=saver.apply.productId name="productId" id ="productId" class="span10"/>
	</@div>
</div>  
<div class="row-fluid">
       <@div title="预计出借日期起" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">
    	<input class="span10 m-wrap m-ctrl-medium date-picker expectLenderDateBegin" readonly size="16" type="text" name="expectLenderDateBegin" value="<#if saver.apply.expectLenderDateBegin?exists>${saver.apply.expectLenderDateBegin?string("yyyy-MM-dd")}</#if>" data-date-format="yyyy-mm-dd" />
    </@div>
    <@div title="预计出借日期止" required=true labelClass="w140" controlsClass="ml160" >	
    	<input class="span10 m-wrap m-ctrl-medium date-picker expectLenderDateEnd" readonly size="16" type="text" name="expectLenderDateEnd" value="<#if saver.apply.expectLenderDateEnd?exists>${saver.apply.expectLenderDateEnd?string("yyyy-MM-dd")}</#if>" data-date-format="yyyy-mm-dd" />
    </@div>
</div>   
<div class="row-fluid">
	<@div title="出借金额(元)" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
        <@text name="lenderAmount" value=saver.apply.lenderAmount inline=true class="span10"/>
    </@div>
    <@div title="大写金额" labelClass="w140" controlsClass="ml160" >	
        <@text name="bigLenderAmount" value=saver.applyVo.lenderAmountCn inline=true class="span10" readonly=true />
    </@div>
</div>  
<div class="row-fluid">
    <@div title="签单日期" labelClass="w140" required=true controlsClass="ml160" style="margin-left: 50px;">	
         <input class="span10 m-wrap m-ctrl-medium date-picker signDate" readonly size="16" type="text" name="signDate" value="<#if saver.apply.signDate?exists>${saver.apply.signDate?string("yyyy-MM-dd")}</#if>" data-date-format="yyyy-mm-dd" />
    </@div>
    <@div title="回收方式" labelClass="w140" required=true controlsClass="ml160">	
         <@select source=recoveryMode target=saver.apply.recovery name="recovery" class="span10"/>
    </@div>
</div>                 
<h4 class="form-section">回款帐户信息 </h4>   
<div class="row-fluid">  
	<@div title="请选择省" labelClass="w140" required=true controlsClass="ml160" style="margin-left: 50px;">	
        <@select source=areas target=saver.refundFinanceVo.provinceRegionCode name="refundProvinceRegionCode" id="refundProvinceRegionCode" class="span10 refundProvinceRegionCode"/>
    </@div>
	<@div title="请选择市" labelClass="w140" required=true controlsClass="ml160" >	
		<select class="span10 m-wrap bank refundCityRegionCode" name="refundCityRegionCode" id="refundCityRegionCode" value="${saver.refundFinanceVo.cityRegionCode}">
        	<option value='-1'>请选择</option>
        	<#if refundCityRegionCode?exists>
	     		<#list refundCityRegionCode as area>
				    <#if area.area_code_id==saver.refundFinanceVo.cityRegionCode>   
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
		<@div title="开户银行" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
        <@select source=bankCategory target=saver.refundFinanceVo.bankCategory name="refundBankCategory" class="span10 refundBankCategory" />
    </@div>
    <@div title="支行" required=true labelClass="w140" controlsClass="ml160">	
        <select class="span10 m-wrap bank refundSubBank" name="refundSubBank" id="refundSubBank" value="${saver.refundFinanceVo.subBank}">
        	<option value='-1'>请选择</option>
        	<#if refundSubBankName?exists>
	     		<#list refundSubBankName as area>
				    <#if area.area_code_id==saver.refundFinanceVo.subBank>   
					   	<option value=${area.area_code_id} selected="selected">${area.area_code_name}</option>
				    <#else>
				  	 	<option value=${area.area_code_id}>${area.area_code_name}</option>
				    </#if>
                </#list>  
                <option value='-2'>其他</option>  
            </#if>
        </select>
    </@div>
</div>  
<div class="row-fluid">
	<@div title="其他支行" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
        <@text name="refundOtherSubBank" value="${saver.refundFinanceVo.subBank}" inline=true class="span10 refundOtherSubBank" />
    </@div>
</div> 
 <div class="row-fluid">
	<@div title="户名" labelClass="w140" required=true controlsClass="ml160" style="margin-left: 50px;">	
        <@text name="refundAccountName" value=saver.account.custName inline=true class="span10" readonly=true />
    </@div>
    <@div title="账号" labelClass="w140" required=true controlsClass="ml160">	
        <@text name="refundAccountNum" value=saver.refundFinanceVo.accountNum inline=true class="span10"/>
    </@div>
</div>  
<h4 class="form-section">特殊情况说明：&nbsp;&nbsp;&nbsp;&nbsp;
<label class="checkbox inline">
	<input type="checkbox" name="specialData" value="specialCredits" <#if saver.limitVo.lenderConditionVal?exists> checked="checked" </#if> /> &nbsp;&nbsp;特殊额度&nbsp;&nbsp;
</label>
<label class="checkbox inline">
	<input type="checkbox" name="specialData" value="specialProfits" <#if saver.limitVo.lenderConditionVal?exists> checked="checked" </#if> /> &nbsp;&nbsp;特殊收益&nbsp;&nbsp;
</label>
</h4>
<br/>
<div class="row-fluid" id ="specialCredits" style="height:auto"  >
	<@div title="特殊额度(元)" labelClass="w140" required=true controlsClass="ml160" style="margin-left: 10px;">	
        <@text name="specialLimit" value="${saver.limitVo.condition}" inline=true class="span10"/>
    </@div>
    <div class="span5 responsive" style="margin-left: 50px;">
        <label class="control-label">备注：<span class="required">*</span></label>
        <div class="controls">
            <textarea style="resize:none;" rows="3" maxlength="200" class="span11 m-wrap" type="text" id = "specialLimitRemark" name="specialLimitRemark" >${saver.limitVo.remark}</textarea>
            <span class="help-inline"></span>
        </div>
    </div>
</div> 
<br/>
<div class="row-fluid" id ="specialProfits" style="height:auto" > 
	<@div title="特殊收益(%)" labelClass="w140" required=true controlsClass="ml160" style="margin-left: 10px;">	
        <@text name="specialBenefit" value="${saver.benefitVo.condition}" inline=true class="span10"/>
    </@div> 
    <div class="span5 responsive" style="margin-left: 50px;">
        <label class="control-label">备注：<span class="required">*</span></label>
        <div class="controls">
            <textarea style="resize:none;" rows="3" maxlength="200" class="span11 m-wrap" type="text" id = "specialBenefitRemark" name="specialBenefitRemark" >${saver.benefitVo.remark}</textarea>
            <span class="help-inline"></span>
        </div>
    </div>
</div>