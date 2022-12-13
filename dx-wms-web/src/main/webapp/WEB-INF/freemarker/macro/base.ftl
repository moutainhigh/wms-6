<#--
 * common input
-->
<#macro btn value="" id="" name="" color="red">
	<input type="button" class="btn btn-shadow ${color} ${name}"  value="${value}" id="${id}" name="${name}">
</#macro>
<#macro create value="新增" id="create" name="create">
	<input type="button" class="btn btn-shadow red ${name}"  value="+ ${value}" id="${id}" name="${name}">
</#macro>
<#macro date class="medium" name="" id="" format="yyyy-mm-dd" value="">
	<input class="${class} m-wrap m-ctrl-medium date-picker ${name}" readonly size="16" type="text" value="${value}"  name="${name}" id="${id}"  data-date-format="${format}">	            
</#macro>
<#macro date1 class="medium" name="" id="" format="yyyy-mm" value="">
	<input class="${class} m-wrap m-ctrl-medium date-picker ${name}" readonly size="16" type="text" value="${value}"  name="${name}" id="${id}"  data-date-format="${format}">	            
</#macro>
<#macro hidden id="" name="" value="">
	<input type="hidden" name="${name}" id="${id}" value="${value}">
</#macro>
<#macro text class="medium" name="" value="" inline=false readonly=false id="" placeholder="">
	<input type="text" class="${class} m-wrap ${name}" <#if readonly=true>readonly</#if> name="${name}" id="${id}"value="${value}" placeholder="${placeholder }">
	<#if inline=true>
		<span class="help-inline"/>
	</#if>
</#macro>
<#macro close>
	<input type='button' class='btn red close-modal' value="关闭" data-dismiss='modal' />
</#macro>
<#macro reset id="reset" value="重置">
	<input type="reset" class="btn btn-shadow red" value="${value}" id="${id}" />
</#macro>
<#macro query id="query" value="查询" name="">
	<input type="button" class="btn btn-shadow blue ${name}" value="${value}" id="${id}" name="${name}" />
</#macro>
<#macro select source={} target="" class="medium" name="" inline=false id="" disabled=false default=true>
	<select class="${class} m-wrap ${name}" name="${name}" id="${id}" value="${target}" value="${target}" <#if disabled=true>disabled</#if>>
		<#if default>
			<option value='-1'>请选择</option>
		</#if>
	    <#if source?exists>
	    	<#list source?keys as key>
	        	<#if key==target>
	            	<option value=${key} selected="selected">${source[key]}</option>
	           	<#else>
	            	<option value=${key}>${source[key]}</option>
	            </#if> 
	        </#list>
	     </#if>
	</select>
	<#if inline=true>
		<span class="help-inline"/>
	</#if>
</#macro>
<!-- 请选择时某些选项不需要 -->
<#macro mSelect source={} class="medium" name="" inline=false id="" array=[]>
	<select class="${class} m-wrap ${name}" name="${name}" id="${id}" >
		<option value='-1'>请选择</option>
	    <#if source?exists>
	    	<#list source?keys as key>
	        	<#if array?seq_contains(key)>
	            	<option value=${key}>${source[key]}</option>
	            </#if> 
	        </#list>
	     </#if>
	</select>
	<#if inline=true>
		<span class="help-inline"/>
	</#if>
</#macro>
<#--
 * jquery data table
 -->
<#macro datatable id="" items=[] checkId="all" >
	<div>
		<table id="${id}" class="table table-striped table-bordered table-hover" >
		    <thead>
		    	<#list items as item>
		    		<#if item='checkbox'>
		    			<th><input type='checkbox' value='-1' id="${checkId}"/></th>
		    		<#else>
		        		<th>${item}</th>
		        	</#if>
		        </#list>
		    </thead>
		</table>
	</div>
</#macro>	
<#macro table id="" items=[] class="txt-center">
	<div>
		<table id="${id}" class="table table-striped table-bordered table-hover" >
		    <thead>
		    	<#list items as item>
		    		<th class="${class}" >${item}</th>
		        </#list>
		    </thead>
		    <tbody><#nested></tbody>
		</table>
	</div>
</#macro>
 <#macro info title="" value="" span="span3">
	<div class="${span} responsive ">
    	<label class="control-label everylabel" style="text-align: left;width:100%" >${title}：${value}</label>
    </div>
</#macro>

<#macro counter items=[] body="">
	<div class="span12">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<#list items as item>
			        	<th>${item}</th>
			    	</#list>
				</tr>
			</thead>
			<tbody id="${body}"></tbody>
		</table>
	</div>
</#macro>
	
<#macro div span="span5" required=false labelClass="" controlsClass="" id="" title="" divClass=""  style="">
	<div class="${span} responsive ${divClass}" id="${id}" style="${style}">
	    <label class="control-label ${labelClass}">${title}：
		    <#if required=true>
		    	<span class="required">*</span>
		    </#if>
	    </label>
	    <div class="controls ${controlsClass}">
	    	<#nested>
	    </div>
	</div>
</#macro>

<#macro line>
	<div class="form-section"></div>
</#macro>

<#macro head title="" home="" item={} indexTo=true>
	<!-- BEGIN PAGE HEADER-->
	<div class="row-fluid">
	    <div class="span12">
	        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
	        <h3 class="page-title">${title}</h3>
	        <ul class="breadcrumb">
				<li>
	                <i class="icon-home"></i>
	                	${home}
	                <i class="icon-angle-right"></i>
	            </li>
	            <#list item?keys as key>
		            <li>
		            	<#if indexTo?exists && indexTo>
		               		<a href="${baseUrl}${item[key]}">${key}</a>
		               	<#else>
		               		${key}
		               	</#if>	
		            </li>
		            <#if key_index != (item?size-1)>
		            	<i class="icon-angle-right"></i>
		            </#if>
	            </#list>
	        </ul>
	        <!-- END PAGE TITLE & BREADCRUMB-->
	    </div>
	</div>
	<!-- END PAGE HEADER-->
</#macro>

<#macro portlet title="" formId="" id="" formClass="" isForm =true name="">
	<div class="portlet box blue ${name}" id="${id}">
		<div class="portlet-title">
		    <div class="caption"><i class="icon-reorder"></i>${title}</div>
		</div>
		<div class="portlet-body">
			<#if isForm = true>
				<form action="#" role="form" class="form-horizontal ${formClass}" id="${formId}">
		    		<#nested>	
		    	</form>
		    <#else>
		    	<#nested>
			</#if>
	    </div>
	</div>        	
</#macro>

<#macro mBottom>
	<div class="form-actions clearfix txt-right bottom">
		<#nested>
		<@close />
	</div>
</#macro>
<#macro mPortlet title="" formId="">
	<div class="portlet-title">
		<div class="caption"><i class="icon-reorder"></i>${title}</div>
	</div>
	<div class="portlet-body">
   		<form class="form-horizontal" id="${formId}">
        	<#nested>		
        </form>   
    </div>   
</#macro>		

<#macro aLeft content="上一页" id="">
	<a href="javascript:;" class="btn blue button-previous" id="${id}"><@iLeft/>${content}</a>
</#macro>
<#macro aRight content="保存 " id="">
	<a href="javascript:;" class="btn blue button-next" id="${id}">${content}<@iRight/></a>
</#macro>
<#macro iLeft>
	<i class="m-icon-swapleft m-icon-white"/>
</#macro>
<#macro iRight>
	<i class="m-icon-swapright m-icon-white"/>
</#macro>

<#macro modal id="" name="">
	<div id="${id}" class="modal hide fade ${name}" tabindex="-1" data-width="960"></div>
</#macro>