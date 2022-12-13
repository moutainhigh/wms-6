<style>
	.edit-modal{
    	left: 31%;
		width: 80%;
		height:auto;
    }
    .mW1{
    	width:65px;
    }
</style>

<#import "hr/emBaseInfo.ftl" as base>
<#import "fileBase/baseInfo.ftl" as baseInfo>
<#import "hr/entry/fileInfo.ftl" as fileInfo>
<#include "/macro/base.ftl">
<div class="container-fluid" >
	<@base.queryPage hTitle="员工管理" hHome="员工管理" hItem={"入职管理":"/hrFlow/entry.htm"} isShow="${isShow}"
	mTitle="入职管理" mButton=["load","create","import"] tableItem=["员工姓名","性别","任职部门","岗位职务","工作性质","移动电话","计划入职日期","状态","操作"] />
</div>
<@modal id="createBaseDiv" name="edit-modal" />
<@modal id="createEntryDiv" name="edit-modal" />
<@baseInfo.previewFileModel />
<div id="loadModel" class="modal hide fade" tabindex="-1" data-width="960">
	<div class="container-fluid">
 		<div class="top"></div>
       	<div class="portlet box blue tabbable">
        		<@mPortlet title="下载模板" formId="loadForm">
        			<div class="top"></div>
				<div class="row-fluid">
					<@div  title="岗位">
						<@select source=position name="position"/>
					</@div>
     			</div>
        		</@mPortlet>
        		<@mBottom>
		    	<input type="button" class="btn blue" id ="confirm" value="确定" >
		    </@mBottom>
		</div>
	</div>
</div>

<div id="importData" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true" style="height:200px;width:700px;">
	<div class="portlet-title" style="line-height:30px;">
		<div class="caption"><i class="icon-reorder" style="margin-top:8px;"></i>导入预入职名单</div>
	</div>
	<@fileInfo.uploadCommonFile2 title="选择需要导入的材料" formId="fileImportForm" uploadId="importBtn" display="block" />
	<div style="position:relative;top:100px;left:510px;" id="uoloading">
		<a href="javascript:;" class="btn blue button-previous" data-dismiss='modal' id="affirm">确认</a>
		<@close />
	</div>
</div>
<div class="clearfix"></div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/flexpaper/js/flexpaper.js"></script>
<script src="${baseUrl}/assets/js/contents/image_goto_change.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/hr/entry_list.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/hr/detail.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
	var base = "${baseUrl}";
	var resBase = "${resRoot}";
    (function($) {
        $(function() {
            App.init();
            uploadFiles("importBtn", base + "/dataDeal/importHRData.json", null, null, validExcelFile,"fileImportForm");
            $("#uoloading .close-modal,#affirm").click(function(){
            	window.location.reload();
            });
        });
    })(jQuery);
    
</script>
 