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
<div class="row-fluid">
<#if detail.employeeEntryVo.employeeVideoDtos?exists>
       <div id="files" class="row-fluid ">
       <#list detail.employeeEntryVo.employeeVideoDtos as file> 
       <div class='span3'  id='${file.employeeVideoId}FileDiv' style="width:20%;margin-left:2.6%;">
	               <input type='hidden' name='videoImg' value='${file.saveFileName};${file.filePath};${file.fileType};${file.sourceFileName};'/>
						<div class='span3' style='width:100%'>
							<div class="mt2"  ><img src="${resRoot}/image/file150921.jpg" class="file"/></div>
							<div class="mt2">
								<a onclick="videoImgClick('${file.employeeVideoId}','${file.saveFileName}','${file.fileType}','${file.sourceFileName}','1')" data-toggle="modal" class="show-detail">
									${file.sourceFileName}.${file.fileType}
								</a>
							</div>
						</div>
						</div>
        </#list>
		</div>
        </#if>
</div>
<div  id="remarkMsg" style="height:auto;margin-left:20px;">
	<span>备注信息:
	<#list approveLogs as log >
		<#if log.userId == applicant && log.content != "提交申请单">
		<span id="remarkContent">${log.content}</span>
		</#if>
	</#list>	
	</span>
</div>
<script>
</script>
