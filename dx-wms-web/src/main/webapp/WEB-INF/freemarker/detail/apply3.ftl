<h4 class="form-section">出借信息</h4>
<div class="row-fluid">
	<div class="span5 responsive">
	    <label class="control-label">合同编号：</label>
	    <div class="controls content">${detail.applyVo.contractCode}</div>
	</div>
	<div class="span5 responsive">
	    <label class="control-label">出借方式：</label>
	    <div class="controls content">${detail.applyVo.product}</div>
	</div>
</div>
<div class="row-fluid">
	<div class="span8 responsive">     
		<label class="control-label">预计出借日期：</label>
		<div class="controls content">${detail.applyVo.expectLenderDate}</div>
	</div>
</div>
<div class="row-fluid">
	<div class="span5 responsive">     
		<label class="control-label">出借金额(元)：</label>
		<div class="controls content">${detail.applyVo.lenderAmount}</div>
	</div> 
	<div class="span5 responsive">     
		<label class="control-label">大写金额：</label>
		<div class="controls content">${detail.applyVo.lenderAmountCn}</div>
	</div> 
</div>
<div class="row-fluid">
	<div class="span5 responsive">     
		<label class="control-label">支付方式：</label>
		<div class="controls content">${detail.applyVo.payWay}</div>
	</div> 
	<div class="span5 responsive">     
		<label class="control-label">签约手机：</label>
		<div class="controls content">${detail.applyVo.signMobile}</div>
	</div>
</div>
<div class="row-fluid">
	<div class="span5 responsive">     
		<label class="control-label">签单日期：</label>
		<div class="controls content">${detail.applyVo.signDate}</div>
	</div>
</div>
<div class="row-fluid">
	<div class="span6 responsive">     
		<label class="control-label">回收方式：</label>
		<div class="controls content">${detail.applyVo.recovery}</div>
	</div>
</div>
<#if detail.financesVos?exists>
	<#list detail.financesVos as finance>
		<#if finance.accountCategory="支付账户信息" && detail.apply.parentId != null>
		<#else>
			<h4 class="form-section">${finance.accountCategory} </h4>
			<div class="row-fluid" >  
				<div class="span8 responsive">     
					<label class="control-label">开户银行：</label>
					<div class="controls content">${finance.bankCategory}</div>
				</div> 
			</div>
			<div class="row-fluid" >  
				<div class="span8 responsive">     
					<label class="control-label">开户城市：</label>
					<div class="controls content">${finance.provinceRegionView}</div>
				</div> 
			</div>
			<div class="row-fluid" >  
				<div class="span8 responsive">     
					<label class="control-label">开户省份：</label>
					<div class="controls content">${finance.cityRegionView}</div>
				</div> 
			</div>
			<div class="row-fluid" >
				<div class="span8 responsive">     
					<label class="control-label">支行：</label>
					<div class="controls content">${finance.subBank}</div>
				</div> 
			</div>
			<div class="row-fluid" >  
				<div class="span6 responsive">     
					<label class="control-label">户名：</label>
					<div class="controls content">${finance.accountName}</div>
				</div>
			</div>
			<div class="row-fluid" >
				<div class="span8 responsive">     
					<label class="control-label">账号：</label>
					<div class="controls content">${finance.accountNum}</div>
				</div> 
			</div>
		</#if>	
	</#list>
</#if>
<#if detail.conditionVos?exists>
	<#list detail.conditionVos as condition>
		<h4 class="form-section">${condition.category}</h4>
		<div class="row-fluid" >  
			<div class="span5 responsive">     
				<#if condition.category=="特殊收益信息">
					<label class="control-label">特殊收益(%)：</label>
				</#if>
				<#if condition.category=="特殊额度信息">
					<label class="control-label">特殊额度(元)：</label>
				</#if>
				<div class="controls content condition">${condition.condition}</div>
			</div> 
			<div class="span8 responsive">     
				<label class="control-label">备注：</label>
				<div class="controls content">${condition.remark}</div>
			</div> 
		</div>
	</#list>
</#if>
