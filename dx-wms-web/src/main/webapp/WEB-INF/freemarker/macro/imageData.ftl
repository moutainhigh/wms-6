<#include "/macro/base.ftl">
<#macro imageDataFrag hdisplay="block"  datas ={} style="" approve="">
<div class="control-group span5" id="imageDataDiv" style="width: 100%;" approve="${approve}">
	<div  style="height: auto;">
		<div class="portlet box blue" id="imageDataportlet" >
			<div class="portlet-title" style="height: 40px;">
				<div id="fileTitle" style="margin-left: 1%;margin-top: 1%;">${approve}</div>
				<div id="dir" class="span4" style="margin-left: 20%;margin-top: -4.3%;">
					<@select source=file.files name="" id="dirs"/>
				</div>
				<div id="fileName" class="span4" style="margin-left: 10%;margin-top: -4.3%;">
					<@select  source=dirs name="" />
				</div>
				<#list file.urls as url>
					<div id=${file.fileIds[url_index]} class="span4"   style="display:none;margin-left: 10%;margin-top: -4.3%;">
						<@select source=url name="files" id=""/>
					</div>
                </#list>
			</div>
			<div class="portlet-body">
				<div  id="showDrawTools" class="tools" style="text-align:center;margin-top:10px;">
					<i class="enlarge"></i>
					<i class="narrow"></i>
				</div>
				<div id="showDraw" style="width:100%;height:480px;">
					<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" 
										width="100%" height="100%">
				          <param name="quality" value="high" />
				          <param value="always" name="allowscriptaccess">
				          <param value="transparent" name="wmode">
						  <param value="true" name="allowfullscreen">
						  <object id="flashObj" data=""  quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" 
				          	width="100%" height="100%" >
				          </object>
				     </object>
				</div>
			</div>
		</div>
	</div>
</div>
</#macro> 
