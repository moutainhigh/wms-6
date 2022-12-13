<#macro files datas={} rootPath="" fileLength="0" employeeId="" isReadOnly=false >
<div class="control-group" id="vFile" style="text-align:center;height:auto;">
	<#if datas?exists && datas?size gt 0>
		<#list datas as file>  
		<input type='hidden' name='videosImg' value='${file.saveFileName};${file.filePath};${file.fileType};${file.sourceFileName}.${file.fileType}'/>
		<div  id='${file.employeeVideoId}FileDiv'>
		<input type='hidden' name='videoImg' value='${file.employeeVideoId};${file.filePath};${file.fileType};${file.sourceFileName}'/>
			<div class='span3 file del${file.employeeVideoId}' style="margin-left: 0px;margin-bottom: 10px;">
				<div>
					<a data-toggle='modal' class="vdfile" 
						data-id="${file.employeeVideoId}" 
						data-path="${file.filePath}" 
					   	data-saveName="${file.saveFileName}" 
					   	data-sname="${file.sourceFileName}.${file.fileType}" 
					    data-type="${file.fileType}"  
					   	data-size="${file_index+1}" title='' href='#responsive'>
						<img src="${rootPath}/image/file150921.jpg" alt=""><br/>
						<strong>
							<span>${file.sourceFileName}.${file.fileType}</span>
						</strong>
					</a>
					<br>
				</div>
				<#if !isReadOnly>
				<div style='width:100%;height:auto;'>
					<span class='btn red deletebtn'>
						<span class='icon-trash'></span>&nbsp;删除
					</span>
					<br>
				</div>
				</#if>
			</div>
</div>		
		</#list>
	
	</#if>
</div>
</#macro>

<!-- 文件上传处 -->
<#macro uploadFile title="选择需要上传的资料" employeeId="" display="none" rootDiv="uploadDiv" formId="fileUploadFormFrom" uploadId="upload">
<div id="${rootDiv}" style="display:${display};position:absolute;top:200px;">
	<!-- 文件上传处 -->  
 	<form id="${formId}" class="uploadForm"> 	
	    <!-- 当前员工主键  -->
	    <input type="hidden" name="employeeId" value="${employeeId}" />
        <div class="controls" style="margin-left: 0px">
            <div class="fileupload fileupload-new span12" data-provides="fileupload">
                <h4 class="span2">${title}</h4>
                <div class="input-append span5">
                    <div class="uneditable-input">
                        <i class="icon-file fileupload-exists"></i>
                        <span class="fileupload-preview"></span>
                    </div>
                    <span class="btn blue btn-file">
                        <span class="fileupload-new file_choose">选择</span>
                        <span class="fileupload-exists file_update">更改</span>
                        <input type="file" class="default file" name="file">
                    </span>
                    <a href="#" class="btn blue fileupload-exists file_del" data-dismiss="fileupload">移除</a>
                    <button class="btn blue" type='button' id="${uploadId}">上传</button>
                    <div class="uneditable-input upLoadImg" style="display:none;text-align:center;width:23px;height:23px;border:0px">
                        <img src="${resRoot}/image/u37.png">
                    </div>
                </div>
            </div>
        </div>      
    </form> 
</div>
</#macro>

<#macro logInfo logName>
<div class="logArea">
	<h4 class="form-section" style="text-align:left">${logName}</h4>
	<div class="control-group" style="text-align:center;height:auto;">
        <!-- 影像资料文件夹 -->     
        <div class="form-group">
			<table cellspacing="0" class="table table-striped table-bordered table-advance table-hover">
				<thead>
					<tr class="logHead"></tr>
				</thead>
				<tbody class="logBody">
					<#nested>
				</tbody>
  			</table>
		</div>
    </div>
</div>
</#macro>

<#macro uploadCommonFile title="选择需要上传的资料" employeeId="" display="none" rootDiv="uploadDiv" formId="fileUploadFormFrom" uploadId="upload" showModel="folder">
<div id="${rootDiv}" style="display:${display};position:absolute;top:200px;">
	<!-- 文件上传处 -->  
 	<form id="${formId}" class="uploadForm">
 		<!-- 影像文件显示模式设置  folder/file -->
        <input type="hidden" class="fileShowModel" name="fileShowModel" value="${showModel}" />
    	<div style="display:none">
		    <!-- 当前员工主键  -->
		    <input type="hidden" name="employeeId" value="${employeeId}" />
		    <#nested>
		</div>   
        <div class="controls" style="margin-left: 0px">
            <div class="fileupload fileupload-new span12" data-provides="fileupload">
            <h4 class="span2">${title}</h4>
                <div class="input-append">
                    <div class="uneditable-input">
                        <i class="icon-file fileupload-exists"></i>
                        <span class="fileupload-preview"></span>
                    </div>
                    <span class="btn blue btn-file">
                        <span class="fileupload-new file_choose">选择</span>
                    	<span class="fileupload-exists file_update">更改</span>
                    	<input type="file" class="default file" name="file">
                    </span>
                    <a href="#" class="btn blue fileupload-exists file_del" data-dismiss="fileupload">移除</a>
                    <button type='button'  class="btn blue" id="${uploadId}">上传</button>
                    <div class="uneditable-input upLoadImg" style="display:none;text-align:center;width:23px;height:23px;border:0px">
                        <img src="${resRoot}/image/u37.png">
                    </div>              
                </div>
            </div>
        </div>
    </form> 
</div>
</#macro>

<#macro uploadCommonFile2 title="选择需要上传的资料" employeeId="" display="none" rootDiv="uploadDiv" formId="fileUploadFormFrom" uploadId="upload" showModel="folder">
<div id="${rootDiv}" style="display:${display};position:absolute;top:60px;">
	<!-- 文件上传处 -->  
 	<form id="${formId}" class="uploadForm">
    	<div style="display:none">
		    <!-- 当前员工主键  -->
		    <input type="hidden" name="employeeId" value="${employeeId}" />
		    <#nested>
		</div>   
       	<div class="modal-body">
            <div class="controls" style="margin-left: 0px">
                <div class="fileupload fileupload-new span12" data-provides="fileupload" style="width:700px;">
                <h4 class="span2">${title}</h4>
                    <div class="input-append">
                        <div class="uneditable-input">
                            <i class="icon-file fileupload-exists"></i>
                            <span class="fileupload-preview"></span>
                        </div>
                        <span class="btn blue btn-file">
                            <span class="fileupload-new file_choose">选择</span>
                        	<span class="fileupload-exists file_update">更改</span>
                        	<input type="file" class="default file" name="file">
                        </span>
                        <a href="#" class="btn blue fileupload-exists file_del" data-dismiss="fileupload">移除</a>
	                    <button class="btn blue" id="${uploadId}">上传</button>
	                    <div class="uneditable-input upLoadImg" style="display:none;text-align:center;width:23px;height:23px;border:0px">
	                        <img src="${resRoot}/image/u37.png">
	                    </div>
	                    <!-- 影像文件显示模式设置  folder/file  -->
                        <input type="hidden" class="fileShowModel" name="fileShowModel" value="${showModel}" />
                    </div>
                </div>
            </div>
        </div>
    </form> 
</div>
</#macro>

<#macro voucherFile title="选择需要上传的资料" display="none" rootDiv="uploadDiv" formId="fileUploadFormFrom" uploadId="upload" showModel="file">
<div style="display:block;position:absolute;top:5%;margin-left:1%;width:90%" id="uploadDiv" >
	<!-- 文件上传处 -->  
 	<form class="uploadForm" id="fileUploadFormFrom">
    	<div style="display:none">
		    <#nested>
		</div>   
       	<div class="row-fluid">
            <div style="margin-left: 0px" class="controls">
                <div data-provides="fileupload" class="fileupload span12 fileupload-new"><input type="hidden" value="" name="file">
                <h4 class="span2" style="width:20%;margin-left:0">选择需要上传的资料</h4>
                    <div class="input-append">
                        <div class="uneditable-input">
                            <i class="icon-file fileupload-exists"></i>
                            <span class="fileupload-preview"></span>
                        </div>
                        <span class="btn blue btn-file">
                            <span class="fileupload-new file_choose">选择</span>
                        	<span class="fileupload-exists file_update">更改</span>
                        	<input type="file" name="file" class="default file">
                        </span>
                        <a data-dismiss="fileupload" class="btn blue fileupload-exists file_del" href="#">移除</a>
	                    <button id="upload" type='button' class="btn blue">上传</button>
	                    <div style="text-align: center; width: 23px; height: 23px; border: 0px none; display: none;" class="uneditable-input upLoadImg">
	                        <img src="${resRoot}/image/u37.png">
	                    </div>
	                    <!-- 影像文件显示模式设置  folder/file  -->
                        <input type="hidden" value="${showModel}" name="fileShowModel" class="fileShowModel">
                    </div>
                </div>
            </div>
        </div>
    </form> 
</div>
</#macro> 

<#macro reMatch title="上传回执拒绝" employeeId="" display="block" rootDiv="uploadDiv" formId="fileUploadFormFrom" uploadId="upload" showModel="file">
<div id="${rootDiv}" style="display:block;position:absolute;top:10%;left:-2.5%">
	<!-- 文件上传处 -->  
 	<form id="${formId}" class="uploadForm" >
 		<!-- 影像文件显示模式设置  folder/file -->
        <input type="hidden" class="fileShowModel" name="fileShowModel" value="${showModel}" />
    	<div style="display:none">
		    <!-- 当前员工主键  -->
		    <input type="hidden" name="employeeId" value="${employeeId}" />
		    <#nested>
		</div>   
        <div class="controls" style="margin-left: 0px">
            <div class="fileupload fileupload-new span12" data-provides="fileupload">
            <h4 class="span2">${title}</h4>
                <div class="input-append">
                    <div class="uneditable-input">
                        <i class="icon-file fileupload-exists"></i>
                        <span class="fileupload-preview"></span>
                    </div>
                    <span class="btn blue btn-file">
                        <span class="fileupload-new file_choose">选择</span>
                    	<span class="fileupload-exists file_update">更改</span>
                    	<input type="file" class="default file" name="file">
                    </span>
                    <a href="#" class="btn blue fileupload-exists file_del" data-dismiss="fileupload">移除</a>
                    <button type='button'  class="btn blue" id="${uploadId}">上传</button>
                    <div class="uneditable-input upLoadImg" style="display:none;text-align:center;width:23px;height:23px;border:0px">
                        <img src="${resRoot}/image/u37.png">
                    </div>   
                    <input type="hidden" value="${showModel}" name="fileShowModel" class="fileShowModel">           
                </div>
            </div>
        </div>
    </form> 
</div>
</#macro>