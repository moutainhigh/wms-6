<style>
    .form-horizontal .control-label {
        float: left;
        width: 160px;
        padding-top: 5px;
        text-align: right;
    }
    .responsive.error .validate-inline{
    	color:#b94a48;
    }
    .validate-inline{
    	display:inline-block;
    	margin-top:3px;
    	padding-left:5px;
    	vertical-align:middle;
    }
    .responsive.error input, .responsive.error select, .responsive.error textarea{
    	border-color:#b94a48;
    	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
    }
    .success .validate-inline.ok::before, .success .help-inline.ok::before{
    	content:"";
    	display:inline-block;
    	font-family:FontAwesome;
    	font-size:13px;
    	font-style:normal;
    	font-weight:normal;
    }
    .responsive.success .validate-inline{
    	color:#468847;
    }
    .high {
		height: 60px !important;
	}
	.right {
		text-align: right;
	}
	.bottom {
		margin-bottom: 0px !important;
		margin-top: 0px !important;
	}
	.top {
		height: 20px;
	}
</style>
<#import "/macro/base.ftl" as base>
<div class="container-fluid">
	<div class="top"></div>
	<div class="portlet box blue tabbable">
		<@base.mPortlet title="创建" formId="submit_form">
			<input type="hidden" class="isLevel"  value="${isLevel}">
			<div class="top"></div>
	        <div class="row-fluid high">
	        	<@base.div span="span6" title="岗位职务" required=true>
	        		<div class="span7 responsive">
	        			<@base.select source=position class="span9" name="positionId"/>
	        		</div>
	        		<div class="span4 responsive positionLevel">
	        			<@base.select class="span9" name="levelId"/>
	        		</div>
	        	</@base.div>
	        	<@base.div span="span6" title="任职部门" required=true>
	        		<@base.select class="span10" name="orgId"/>
	        	</@base.div>
	        </div>
	        <div class="row-fluid high">
	        	<@base.div title="员工姓名" span="span6" required=true>
	        		<@base.text class="span10" name="name"/>
	        	</@base.div>
	        	<@base.div title="性别" span="span6" required=true>
	        		<@base.select source=sexType class="span10" name="sex"/>
	        	</@base.div>
	        </div>
	        <div class="row-fluid high">
	        	<@base.div title="证件类型" span="span6" required=true>
	        		<@base.select source=certType target=1 class="span10" name="certType"/>
	        	</@base.div>
	        	<@base.div title="证件号码" span="span6" required=true>
	        		<@base.text class="span10" name="certNo"/>
	        	</@base.div>
	        </div>
	        <div class="row-fluid high">
	        	<@base.div title="试用期基本工资" span="span6" required=true>
	        		<@base.text class="span10" name="proBasicSalary"/>
	        	</@base.div>
	        	<@base.div title="试用期绩效工资" span="span6" required=true>
	        		<@base.text class="span10" name="proPerformanceSalary"/>
	        	</@base.div>
	        </div>
	        <div class="row-fluid high">
	        	<@base.div title="转正后基本工资" span="span6" required=true>
	        		<@base.text class="span10" name="regularBasicSalary"/>
	        	</@base.div>
	        	<@base.div title="转正后绩效工资" span="span6" required=true>
	        		<@base.text class="span10" name="regularPerformanceSalary"/>
	        	</@base.div>
	        </div>
	        <div class="row-fluid high">
	        	<@base.div title="计划入职日期" span="span6" required=true>
	        		<@base.date class="span10" name="plannedEntryDate"/>
	        	</@base.div>
	        	<@base.div title="工作性质" span="span6" required=true>
	        		<@base.select source=jobCategory class="span10" name="jobCategory"/>
	        	</@base.div>
	        </div>
		</@base.mPortlet>
		<@base.mBottom>
			<input type="button" class="btn blue button-submit" value="提交" >
		</@base.mBottom>
	</div>
</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/hr/entry/create.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/hr/entry/create_validate.js" type="text/javascript"></script> 
<script>
    (function($) {
        $(function() {
        	FormComponents.init();
        });
    })(jQuery);
</script>
