<style>
	.detail-modal{
    	left: 31%;
		width: 80%;
    }
    .content{
    	margin-top:8px;
    }
</style>

<#include "/macro/base.ftl">
<#import "hr/emBaseInfo.ftl" as base>
<div class="container-fluid">
	<@base.queryPage hTitle="明细审批管理" hHome="明细审批管理" hItem={"入职审批":"/hrApprove/entryApprove.htm"} 
	mTitle="入职审批"   tableItem=["员工姓名","性别","任职部门","岗位职务","工作性质","移动电话","入职日期","操作"]  />
</div>
<@modal id="detailModal" name="detail-modal"/>
<div id="imgModal" class="modal hide fade" tabindex="-1" data-width="100%" style="width:80%;height:95%;z-index: 10051 !important;margin-left: -500px;">
	<div class="modal-header">
       	<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <font size="3.5">图片信息</font>
        <div id="imgChangeDiv" style="width:100%;"></div>
    </div>
	<div style="position:absolute;left:0px;top:50px;width:100%;height:90%">
		<div id="documentViewer" class="flexpaper_viewer" style="width:100%;height:100%"></div>
	</div>
</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/hr/entry_approve_list.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/flexpaper/js/flexpaper.js"></script>
<script src="${baseUrl}/assets/js/contents/image_goto_change.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/contents/file_show.js"></script>
</script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
  	var base = "${baseUrl}";
  	var resBase = "${resRoot}"; 
  	(function($) {
	    $(function() {
	      	App.init();
	      	FormComponents.init();
	    });
  	})(jQuery);
</script>