<#include "/macro/base.ftl">
<h4 class="form-section">通讯信息   </h4>
<div class="row-fluid">
    <div class="span12 responsive" style="margin-left: 30px;">
        <label class="control-label">通讯地址：<span class="required">*</span></label>
        <div class="controls">
            <div class="span7 responsive">
				<div class="span3 responsive">	
					<@select source=areas target=saver.comm.provinceRegionCode class="span10" name="provinceRegionCode" inline="true"/>
				</div>
			    <div class="span4 responsive">	
					<select class="span9 m-wrap" name="cityRegionCode" id="cityRegionCode" >
					  	<option value='-1'>请选择市</option>
						<#if cityRegionCode?exists>
						     <#list cityRegionCode as area>
							    <#if area.area_code_id=saver.comm.cityRegionCode>
								   <option value=${area.area_code_id} selected="selected">${area.area_code_name}</option>
							    <#else>
								   <option value=${area.area_code_id}>${area.area_code_name}</option>
							    </#if>
						 </#list>
					  </#if>
				   </select>
				</div>
			    <div class="span4 responsive" style="margin-left: -8px;">	
					<select class="span9 m-wrap" name="districtRegionCode" id="districtRegionCode" >
					  	<option value='-1'>请选择区</option>
					  	<#if districtRegionCode?exists>
						 	<#list districtRegionCode as area>
								<#if area.area_code_id=saver.comm.districtRegionCode>
									<option value=${area.area_code_id} selected="selected">${area.area_code_name}</option>
								<#else>
									<option value=${area.area_code_id}>${area.area_code_name}</option>
								</#if>
						 	</#list>
					  	</#if>
				   </select>
				</div>	
		    </div>
            <div class="span5 responsive" style="margin-left: -70px;">
                <div class="span12 responsive"  id="streetInfoDiv">
                    <input type="text" class="span10 m-wrap" name ="streetInfo" id="streetInfo" placeholder="街道信息" value="${saver.comm.streetInfo}">
               	</div>
            </div>   
        </div>
    </div>
</div>
<div class="row-fluid">
	<@div title="邮政编码" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
       <@text name="zipCode" value=saver.comm.zipCode inline=true class="span10" />
    </@div>
    <@div title="固定电话" span="span6" labelClass="w140" controlsClass="ml160" >	
    	<div class="span4 responsive">
            <input type="text" class="span9 m-wrap areaCode" name="areaCode" id="areaCode" value="${saver.comm.areaCode}">
        </div>
        <div class="span1 responsive" style="line-height: 30px; margin-left: -10px;">
         - 
        </div>
        <div class="span5 responsive" tyle="margin-left: -10px;">
            <input type="text" class="span10 m-wrap telNum" name="telNum" id="telNum" value="${saver.comm.telNum}">
        </div>
    </@div>
</div>

<div class="row-fluid">
    <@div title="电子邮箱" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
        <@text name="accountEmail"  class="span10" value=saver.comm.email/>
    </@div>
    <@div title="微信号" labelClass="w140" controlsClass="ml160" >	
        <@text name="wechat" class="span10" value=saver.comm.wechat inline=true />
    </@div>
</div>

<h4 class="form-section">紧急联系人信息  </h4>
<div class="row-fluid">
	<@div title="姓名" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
        <@text name="linkmanName"  class="span10" value=saver.linkman.linkmanName inline=true />
    </@div>
    <@div title="姓名(拼音)" required=true labelClass="w140" controlsClass="ml160">	
        <@text name="linkmanNameSpell" class="span10" value=saver.linkman.linkmanNameSpell inline=true />
    </@div>
</div>
<div class="row-fluid">
	<@div title="性别" required=true labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
       <@select source=sex target=saver.linkman.linkmanSex name="linkmanSex" inline="true" class="span10" />
    </@div>
    <@div title="关系" required=true labelClass="w140" controlsClass="ml160" >	
        <@text name="linkmanRelation" class="span10" value=saver.linkman.linkmanRelation inline=true />
    </@div>
</div>
<div class="row-fluid">
	<@div title="证件类型" labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
       <@select source=idType target=saver.linkman.linkmanIdType name="linkmanIdType" id = "linkmanIdType" class="span10" />
    </@div>
    <@div title="证件号码" labelClass="w140" controlsClass="ml160">	
    	<@text name="linkmanIdCard" id="linkmanIdCard" value=saver.linkman.linkmanIdCard inline=true class="span10" />
    </@div>
</div>
<div class="row-fluid">
	 <@div title="移动电话" labelClass="w140" controlsClass="ml160" style="margin-left: 50px;">	
    	<@text name="linkmanMobile" id = "linkmanMobile" value=saver.linkman.linkmanMobile inline=true class="span10" />
    	<span class="span2 responsive selectOne" id="selectOne">
     	</span>
    </@div>
    <@div title="固定电话" span="span6" labelClass="w140" controlsClass="ml160" >	
    	<div class="span4 responsive">
            <input type="text" class="span8 m-wrap linkmanAreaCode" name="linkmanAreaCode" id="linkmanAreaCode" value="${saver.linkman.areaCode}">
        </div>
        <div class="span1 responsive" style="line-height: 30px; margin-left: -10px;">
         - 
        </div>
        <div class="span5 responsive" style="margin-left: -10px;">
            <input type="text" class="span10 m-wrap linkmanTelNum" name="linkmanTelNum" id="linkmanTelNum" value="${saver.linkman.telNum}">
        </div>
    </@div>
</div>

<script>
    jQuery(document).ready(function() {  
        $("#openDate").attr("disabled","disabled");
        if($("#custSource").val()!=20){
            $("#custSourceOtherDiv").hide();
        }
    });
    
</script> 