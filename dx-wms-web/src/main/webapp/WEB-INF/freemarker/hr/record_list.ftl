<style>
    .boder-right-scroll {
        width:100%;
        overflow-x:scroll;
    }
    .row-fluid {
        height: 50px;
    }
    .tooLong {
    	display: block; 
    	word-wrap: break-word; 
    	word-break: break-all; 
    }
    #close {
    	margin-left:910px;
    }
</style>
<#import "macro/base.ftl" as base>
<#import "fileBase/baseInfo.ftl" as baseInfo>
<#import "hr/record_log.ftl" as logInfo>

<div class="container-fluid">
  	<@base.head title="员工管理" home="员工管理" item={"审批记录":"/hrFlow/approveLog.htm"}/>
  	<@base.portlet title="审批记录" formId="" formClass="formClass">
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
		</div>
		<div class="row-fluid">
			<@baseInfo.queryPlaceholder />
			<@baseInfo.queryButtonModel />
		</div>
		<@base.line />
		<div>
           <@base.datatable id="resultList" items=["员工姓名","性别","任职部门","岗位职务","工作性质","移动电话","入职日期","操作"] />
        </div>
     </@base.portlet>   
</div>

<div id="logModel" class="modal hide fade" tabindex="-1" data-width="960" style="width:80%; margin-left: -520px; height:90%; overflow-y:scroll;overflow-x:hidden;" >
	<@logInfo.recordLog />
</div>

<div class="clearfix"></div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/hr/record_list.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
	var base = "${baseUrl}";
	var resBase = "${resRoot}";
	var biz = "${biz}";
    (function($) {
        $(function() {
            App.init();
            query();
        });
    })(jQuery);
</script>
 