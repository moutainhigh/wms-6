<h4 class="form-section">出借信息</h4>
<div class="row-fluid">
	<div class="span4 responsive">
	    <label class="control-label">出借编号：</label>
	    <div class="controls content">${custAccountApplyVo.lenderApplyVo.lenderCode}</div>
	</div>
	<div class="span8 responsive">
	    <label class="control-label">合同编号：</label>
	    <div class="controls content">${custAccountApplyVo.lenderApplyVo.contractCode}</div>
	</div>
</div>
<div class="row-fluid" >  
	<div class="span4 responsive">
	    <label class="control-label">出借方式：</label>
	    <div class="controls content">${custAccountApplyVo.lenderApplyVo.product}</div>
	</div>
	<div class="span4 responsive">     
		<label class="control-label">出借金额(元)：</label>
		<div class="controls content">${custAccountApplyVo.lenderApplyVo.lenderAmount}</div>
	</div> 
	<div class="span4 responsive">     
		<label class="control-label">大写金额：</label>
		<div class="controls content">${custAccountApplyVo.lenderApplyVo.lenderAmountCn}</div>
	</div> 
</div>
<div class="row-fluid" >  
	<div class="span4 responsive">     
		<label class="control-label">支付方式：</label>
		<div class="controls content">${custAccountApplyVo.lenderApplyVo.payWay}</div>
	</div> 
	<div class="span4 responsive">     
		<label class="control-label">签约手机：</label>
		<div class="controls content">${custAccountApplyVo.lenderApplyVo.signMobile}</div>
	</div>
	<div class="span4 responsive">     
		<label class="control-label">回收方式：</label>
		<div class="controls content">${custAccountApplyVo.lenderApplyVo.recovery}</div>
	</div> 
</div>
<div class="row-fluid">	 
	<div class="span4 responsive">     
		<label class="control-label">签单日期：</label>
		<div class="controls content">${custAccountApplyVo.lenderApplyVo.signDate}</div>
	</div> 
	<div class="span8 responsive">     
		<label class="control-label">预计出借日期：</label>
		<div class="controls content">${custAccountApplyVo.lenderApplyVo.expectLenderDate}</div>
	</div> 
</div>
<#if custAccountApplyVo.custFinanceVos?exists>
	<#list custAccountApplyVo.custFinanceVos as custFinanceVo>
		<h4 class="form-section">${custFinanceVo.accountCategory} </h4>
		<div class="row-fluid" >  
			<div class="span4 responsive">     
				<label class="control-label">户名：</label>
				<div class="controls content">${custFinanceVo.accountName}</div>
			</div> 
			<div class="span8 responsive">     
				<label class="control-label">账号：</label>
				<div class="controls content">${custFinanceVo.accountNum}</div>
			</div> 
		</div>
		<div class="row-fluid" >  
			<div class="span4 responsive">     
				<label class="control-label">开户银行：</label>
				<div class="controls content">${custFinanceVo.bankCategory}</div>
			</div> 
			<div class="span8 responsive">     
				<label class="control-label">支行：</label>
				<div class="controls content">${custFinanceVo.subBank}</div>
			</div> 
		</div>	
	</#list>
</#if>
<#if custAccountApplyVo.lenderConditionVos?exists>
	<#list custAccountApplyVo.lenderConditionVos as lenderConditionVo>
		<h4 class="form-section">${lenderConditionVo.category}</h4>
		<div class="row-fluid" >  
			<div class="span4 responsive">     
				<#if lenderConditionVo.category=="特殊收益信息">
					<label class="control-label">特殊收益(%)：</label>
				</#if>
				<#if lenderConditionVo.category=="特殊额度信息">
					<label class="control-label">特殊额度(元)：</label>
				</#if>
				<div class="controls content condition">${lenderConditionVo.condition}</div>
			</div> 
			<div class="span8 responsive">     
				<label class="control-label">备注：</label>
				<div class="controls content">${lenderConditionVo.remark}</div>
			</div> 
		</div>
	</#list>
</#if>

<script>
	<#--查看详情时除掉特殊收益后的'%'以及特殊额度后的'元'-->
	$(function(){
		var conditions=$(".condition");
		$.each(conditions,function(index,item){
			var condition=$(item).text();
			$(item).text($.trim(condition.substring(0,condition.length-1)))
		});
		
	});
</script>
      