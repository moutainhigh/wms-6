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
<#include "/macro/base.ftl">
<#import "hr/emBaseInfo.ftl" as base>
<div class="container-fluid">
  	<@base.queryPage hTitle="明细审批管理" hHome="明细审批管理" hItem={"异动审批":"/hrApprove/moveApprove.htm"} 
	mTitle="异动审批"   tableItem=["员工姓名","性别","任职部门","岗位职务","工作性质","移动电话","入职日期","操作"]  />
</div>
<@modal id="peoplechange" name="edit-modal"/>

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/hr/move_approve_list.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
    var base = "${baseUrl}";
    var resBase = "${resRoot}"; (function($) {
        $(function() {
            App.init();
            FormComponents.init();
        });
    })(jQuery);
</script>