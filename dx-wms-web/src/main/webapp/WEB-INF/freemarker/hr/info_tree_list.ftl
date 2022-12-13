<#include "/macro/base.ftl">
<#import "hr/emTreeInfo.ftl" as base>
<#import "fileBase/baseInfo.ftl" as baseInfo>
<div class="container-fluid">
	<@base.queryPage hTitle="员工信息查询" hHome="员工信息查询" hItem={"员工信息查询":"/hrFlow/list.htm"} 
	mTitle="员工信息查询" mTableTitle="员工信息查询"  array=["formStatus"] tableItem=["员工姓名","性别","任职部门","岗位职务","工作性质","移动电话","入职日期","状态","操作"]  />
</div>
<@modal id="detailModal" name="detail-modal"/>
<@baseInfo.previewFileModel />
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/bootstrap-tree.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/flexpaper/js/flexpaper.js"></script>
<script src="${baseUrl}/assets/js/contents/image_goto_change.js"></script>
<script src="${baseUrl}/assets/js/hr/detail.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/hr/info_list.js"></script>
<script src="${baseUrl}/assets/js/hr/tree_list.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
  	var base = "${baseUrl}";
  	var resBase = "${resRoot}"; 
  	(function($) {
	    $(function() {
	      	App.init();
	    });
  	})(jQuery);
</script>