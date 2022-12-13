
 <#import "macro/base.ftl" as base>

<#macro portlet title="" iconClass="icon-reorder" isShow=true shrink=true>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="${iconClass}"></i>${title}
			</div>
			<#if shrink>
			<div class="tools">
				<a href="javascript:;" class="<#if isShow>collapse<#else>expand</#if>"></a>
			</div>
			<#else></#if>
		</div>
		<div class="portlet-body" style="<#if !isShow>display: none;<#else></#if>">
			<#nested>
		</div>
	</div>
</#macro>

<#macro textareaModel title="" id="" name="" value="" isnece=false maxLen="500" rows="3" cols="80">
	<div class="span6 responsive">
		<label class="control-label">
			${title}:<#if isnece><span class="required">*</span></#if>
		</label>
		<div class="controls">
			<textarea rows="${rows}" cols="${cols}" maxlength="${maxLen}" id="<#if id?exists && id?trim!=''>${id}<#else>${name}</#if>" class="span10 m-wrap" name="${name}" style="overflow-y:auto;resize:none" >${value}</textarea>
			<span class="help-inline"></span>
		</div>
	</div>
</#macro>

<#macro queryButtonModel>
	<@placeholderOfButton>
		<@base.query />
		<@base.reset />
		<#nested>
	</@placeholderOfButton>
</#macro>

<#macro previewFileModel>
	<div id="imgModal" class="modal hide fade" tabindex="-1" data-width="100%" style="width:800px;height:500px">
		<div class="modal-header">
	       	<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
	        <font size="3.5">图片信息</font>
	        <div id="imgChangeDiv"></div>
	    </div>
		<div style="position:absolute;left:0px;top:50px;">
			<div id="documentViewer" class="flexpaper_viewer" style="width:800px;height:500px"></div>
		</div>
	</div>
</#macro>
<!-- 列表查询  空占位块 -->
<#macro queryPlaceholder>
	<div class="span5 responsive">
	  	<label class="control-label" >&nbsp;</label>
	    <div class="controls">&nbsp;</div>
	</div>
</#macro>
<#macro placeholderOfButton>
	<div class="span7 responsive">
	  	<label class="control-label" >&nbsp;</label>
	    <div class="controls"><#nested></div>
	</div>
</#macro>
