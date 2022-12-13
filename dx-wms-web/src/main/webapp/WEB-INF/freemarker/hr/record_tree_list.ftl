<style>
    .boder-right-scroll{
        width:100%;
        overflow-x:scroll;
    }
    .row-fluid{
        height: 50px;
    }
    .tooLong{
    	display: block; 
    	word-wrap: break-word; 
    	word-break: break-all; 
    }
</style>
<#import "macro/base.ftl" as base>
<#import "fileBase/baseInfo.ftl" as baseInfo>
<#import "hr/record_log.ftl" as logInfo>
<div class="container-fluid">
<@base.head title="员工管理" home="员工管理" item={"审批记录":"/hrFlow/approveLog.htm"}/>
<@base.portlet title="审批记录" formId="" formClass="formClass">
	<div id="content" class="row-fluid">
		<div class="span3">
			<@baseInfo.portlet title="组织列表" shrink=false>
	            <ul class="tree" id="tree_1"></ul>
			</@baseInfo.portlet>
		</div>
		<div class="span9">
			<@baseInfo.portlet title="员工列表" shrink=false>
		   		<form action="#" role="form" class="form-horizontal">
		          	<div class="row-fluid">
		          		<@base.div title="工作性质">
							<@base.select source=jobCategory id="jobCategory" name="jobCategory" />
						</@base.div>
						<@base.div title="岗位职务">
							<@base.select source=position id="positionName" name="positionName" />
						</@base.div>
					</div>
					<div class="row-fluid">
					    <@base.div title="移动电话">
							<@base.text id="mobile" name="mobile" />
						</@base.div>
						<@base.div title="员工姓名">
							<@base.text id="employeeName" name="employeeName" />
						</@base.div>
						<@base.hidden id="orgId" name="orgId" value="" />
					</div>
					<div class="row-fluid">
						<@baseInfo.queryPlaceholder />
						<@baseInfo.queryButtonModel />
					</div>
					<@base.line />
		            <div>
		               <@base.datatable id="resultList" items=["员工姓名","性别","任职部门","岗位职务","工作性质","移动电话","入职日期","操作"] />
		            </div>
		         </form>
		   	</@baseInfo.portlet>
	   	</div>
	</div>
	<div style="clear:both;height:1px;width:100%; overflow:hidden; margin-top:-1px;"></div>
</@base.portlet>
</div>
<div id="logModel" class="modal hide fade" tabindex="-1" data-width="960" style="width:80%; margin-left: -520px; height:90%; overflow-y:scroll;overflow-x:hidden;" >
	<@logInfo.recordLog />
</div>

<div class="clearfix"></div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/bootstrap-tree.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/hr/record_list.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/hr/tree_list.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
	var base = "${baseUrl}";
	var resBase = "${resRoot}";
	var biz = "${biz}";
    (function($) {
        $(function() {
            App.init();
            FormComponents.init();
        });
    })(jQuery);
</script>
 