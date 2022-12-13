<#macro startAccumulation>
<#include "/macro/base.ftl">
	<input type="hidden" name="employeeSocialSecurityId" value="${emDetailVo.socialVo.employeeSocialSecurityId}"/>
	<div class="row-fluid">
		<@div title="缴纳" span="span6" required=true>
			<select class="span4 m-wrap isshanghai" name="isshanghai">
			    <#if insuredCity?exists>
			    	<#list insuredCity?keys as key>
				    	<#if key==emDetailVo.socialVo.isshanghai>
			            	<option value=${key} selected="selected">${insuredCity[key]}</option>
			           	<#else>
			            	<option value=${key}>${insuredCity[key]}</option>
			            </#if> 
			        </#list>
			     </#if>
			</select>
			<span> 社保公积金</span>
		</@div>
	</div>
	<div class="provinceIn">
		<h4 class="form-section">上海社保</h4>
		<div class="row-fluid">
			<@div title="本市首次开户" span="span6" required=true>
				<label class="radio">
					<input type="radio" value="1" name="firstOpenSocial" onclick="firstOpenSocialChange()" dataValue="${emDetailVo.socialVo.firstOpenSocial}" style="margin-left: 0px;">是
				</label>
				<label class="radio">
					<input type="radio" value="2" name="firstOpenSocial" onclick="firstOpenSocialChange()" dataValue="${emDetailVo.socialVo.firstOpenSocial}" style="margin-left: 0px;">否
				</label>
			</@div>
			<@div title="已通知上家单位转出" span="span6" required=true>
				<label class="radio">
					<input type="radio" value="1" name="removeSocial" dataValue="${emDetailVo.socialVo.removeSocial}" style="margin-left: 0px;">是
				</label>
				<label class="radio">
					<input type="radio" value="2" name="removeSocial" dataValue="${emDetailVo.socialVo.removeSocial}" style="margin-left: 0px;">否
				</label>
			</@div>
		</div>	
		<h4 class="form-section">上海公积金</h4>
		<div class="row-fluid">
			<@div title="本市首次开户" span="span6" required=true>
				<label class="radio">
					<input type="radio" value="1" name="firstOpenFund" onclick="firstOpenFundChange()" dataValue="${emDetailVo.socialVo.firstOpenFund}"   style="margin-left: 0px;">是
				</label>
				<label class="radio">
					<input type="radio" value="2" name="firstOpenFund" onclick="firstOpenFundChange()" dataValue="${emDetailVo.socialVo.firstOpenFund}"   style="margin-left: 0px;">否
				</label>
			</@div>
			<@div title="已通知上家单位转出" span="span6" required=true>
				<label class="radio">
					<input type="radio" value="1" name="removeFund" dataValue="${emDetailVo.socialVo.removeFund}" style="margin-left: 0px;">是
				</label>
				<label class="radio">
					<input type="radio" value="2" name="removeFund" dataValue="${emDetailVo.socialVo.removeFund}" style="margin-left: 0px;">否
				</label>
			</@div>
		</div>
		<div class="row-fluid">
			<@div title="个人公积金账号" span="span6" required=true>
				<@text class="span10" name="fundAccount" value=emDetailVo.socialVo.fundAccount/>
			</@div>
		</div>
	</div>
	
	<!-- 上海社保结束 -->
    <!-- 省外社保开始 -->
    <div class="provinceOut hide">
        <h4 class="form-section">缴纳外省市社保公积金</h4>
        <div class="row-fluid">
			<@div title="新参保" span="span4" required=true>
				<label class="radio">
					<input type="radio" value="1" name="firstInsured" dataValue="${emDetailVo.socialVo.firstInsured }" style="margin-left: 0px;">是
				</label>
				<label class="radio">
					<input type="radio" value="2" name="firstInsured" dataValue="${emDetailVo.socialVo.firstInsured }" style="margin-left: 0px;">否
				</label>
			</@div>
			<@div title="参保地点" span="span8" required=true>
				<div class="span12 responsive">
					<div class="span4 responsive">
						<@select source=areas class="span10" name="insuredProvinceCode" target=emDetailVo.socialVo.insuredProvinceCode/>
					</div>
					<div class="span4 responsive">
						<select class="span10 m-wrap insuredCityCode" name="insuredCityCode" id="insuredCityCode" >
						  	<option value='-1'>请选择市</option>
							<#if insuredCityCode?exists>
						     	<#list insuredCityCode as area>
							    	<#if area.area_code_id=emDetailVo.socialVo.insuredCityCode>
								   		<option value=${area.area_code_id} selected="selected">${area.area_code_name}</option>
							    	<#else>
								   		<option value=${area.area_code_id}>${area.area_code_name}</option>
							    	</#if>
						 		</#list>
					  		</#if>
					   	</select>
					</div>
				</div>
			</@div>
		</div>
	</div>
    <!-- 省外社保结束 -->
</#macro>           
<#macro provinceIn initValue={}>
	
</#macro>   

<#macro provinceOut>
	
</#macro>        