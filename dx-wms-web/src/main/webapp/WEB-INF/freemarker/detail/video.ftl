<style>
.folder {
	width: 50%;
	length: 50%;
}
.h90 {
	height: 90%;
}
.mt4 {
	margin-top: 4%;
}
.mt2 {
	margin-top: 3%;
}
.center {
	text-align: center;
}
.file_div {
	display: none;
}
.file {
	width: 60px;
	height: 80px;
}
.show-detail {
	font-weight: bold;
	color: #000;
}
</style>
<div class="row-fluid h90" id="folders">
<#if detail.folderVos?exists>
	<#list detail.folderVos as folder>
		<div class='span3 center'>
			<div class="mt2"><img src="${resRoot}/image/u37.png" class="folder"/></div>
			<div class="mt2"><strong>${folder.name}(${folder.num})</strong></div>
			<div class="mt2"><span class="${folder.btnClass}" folderId="${folder.id}" name="folder">${folder.btnContent}</span></div>
			<#if detail.folderVos?exists>
				<div id="${folder.id}" class="file_div">
					<#list folder.files as file>
                  <input type='hidden' name='videosImg' value='${file.saveName};${file.dir};${file.typeKey};${folder.name}${file.sourceName}.${file.type};'/>
                   <div class='span3' style='margin-left: 5%;' id='${file.fileId}FileDiv'>
	               <input type='hidden' name='videoImg' value='${file.saveName};${file.dir};${file.typeKey};${folder.name}${file.sourceName}.${file.type};'/>
						<div class='span3' style='margin-left:2.6%;width:100%'>
							<div class="mt2"><img src="${resRoot}/image/file150921.jpg" class="file"/></div>
							<div class="mt2">
								<a onclick="videoImgClick('${file.fileId}','${file.saveName}','${file.typeKey}','${file.sourceName}','${file_index+1}')" data-toggle="modal" class="show-detail">
									${folder.name}${file.sourceName}.${file.type}
								</a>
							</div>
						</div>
						</div>	
					</#list>
				</div>
			</#if>
		</div>
	</#list>
</#if>                
</div>
<div class="form-section mt2"></div> 
<div class="row-fluid mt2 h90 center" id="vFile">
    <!-- 影像资料文件 -->
</div> 
<script type="text/javascript">
$(function() {
});
</script>


 