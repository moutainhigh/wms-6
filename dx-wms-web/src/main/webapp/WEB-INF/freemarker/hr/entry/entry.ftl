
<style>
    #tab3{
        margin-top: 50px;
    }
    .control-group{
        height: 40px;
    }
    .form-horizontal .control-label {
        float: left;
        width: 160px;
        padding-top: 5px;
        text-align: right;
    }
    .form-horizontal .controls {
        margin-left: 180px;
    }
    select.m-wrap.small {
        width: 90px !important;
    }
    
    .m-wrap.small {
        width: 50px !important;
    }
    .responsive.success .validate-inline {
        color: #468847;
    }

    .responsive.error .validate-inline {
        color: #b94a48;
    }

    .responsive.error .control-label, .responsive.error .help-block,
    .responsive.error .help-inline {
        color: #b94a48
    }

    .responsive.error .checkbox, .responsive.error .radio,
    .responsive.error input, .responsive.error select, .responsive.error textarea{
        color: #b94a48
    }

    .responsive.error input, .responsive.error select, .responsive.error textarea{
        border-color: #b94a48;
        -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075)
    }

    .responsive.error input:focus, .responsive.error select:focus,
    .responsive.error textarea:focus {
        border-color: #953b39;
        -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px
            #d59392;
        -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px #d59392;
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px #d59392
    }

    .responsive.error .input-prepend .add-on, .responsive.error .input-append .add-on{
        color: #b94a48;
        background-color: #f2dede;
        border-color: #b94a48
    }

    .responsive.success .control-label, .responsive.success .help-block,
    .responsive.success .help-inline {
        color: #468847
    }

    .responsive.success .checkbox, .responsive.success .radio,
    .responsive.success input, .responsive.success select,
    .responsive.success textarea {
        color: #468847
    }

    .responsive.success input, .responsive.success select,
    .responsive.success textarea {
        border-color: #468847;
        -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075)
    }

    .responsive.success input:focus, .responsive.success select:focus,
    .responsive.success textarea:focus {
        border-color: #356635;
        -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px
            #7aba7b;
        -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px #7aba7b;
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px #7aba7b
    }

    .responsive.success .input-prepend .add-on, .responsive.success .input-append .add-on{
        color: #468847;
        background-color: #dff0d8;
        border-color: #468847
    }
   .top{
   		height:20px;
   }
	.bottom {
		margin-bottom: 0px;
    	margin-top: 0px;
	}
</style>
<#import "hr/entry/personInfo.ftl" as createPersonInfo>
<#import "hr/entry/accumulationInfo.ftl" as createAccumulationInfo>
<#import "hr/entry/fileInfo.ftl" as fileInfo>
<#import "fileBase/baseInfo.ftl" as baseInfo>
<#import "hr/approve_log.ftl" as logInfo>
<#import "/macro/base.ftl" as base>
<!-- BEGIN PAGE CONTAINER-->
<div class="container-fluid">
    <!-- BEGIN PAGE HEADER-->
    <div class="top"></div>
    <!-- END PAGE HEADER-->
    <!-- BEGIN PAGE CONTENT-->
    <input type="hidden" name="employeeId" id="employeeId" value="${employeeId}">
    <input type="hidden" name="procInsId" id="procInsId" value="${procInsId}">
    <input type="hidden" name="taskId" id="taskId" value="${taskId}">
    
    <div class="row-fluid">
        <div class="span12">
            <div class="portlet box blue " id="form_wizard_1">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-reorder"></i> 入职事项管理
                    </div>
                </div>
                <div class="portlet-body">
                    <form action="#" class="form-horizontal" id="entry_form">
	                    <div class="form-wizard" >
	                        <div class="navbar steps">
	                            <div class="navbar-inner">
	                                <ul class="row-fluid">
	                                    <li class="span3">
	                                        <a href="#tab1" data-toggle="tab" class="step">
	                                            <span class="number">1</span>
	                                            <span class="desc"><i class="icon-ok"></i> 个人信息</span>
	                                        </a>
	                                    </li>
	                                    <li class="span3">
	                                        <a href="#tab2" data-toggle="tab" class="step">
	                                            <span class="number">2</span>
	                                            <span class="desc"><i class="icon-ok"></i> 公积金信息</span>
	                                        </a>
	                                    </li>
	                                    <li class="span3">
	                                        <a href="#tab3" data-toggle="tab" class="step">
	                                            <span class="number">3</span>
	                                            <span class="desc"><i class="icon-ok"></i> 入职材料</span>
	                                        </a>
	                                    </li>
	                                    <li class="span3">
	                                        <a href="#tab4" data-toggle="tab" class="step">
	                                            <span class="number">4</span>
	                                            <span class="desc"><i class="icon-ok"></i> 审批记录</span>
	                                        </a>
	                                    </li>
	                                </ul>
	                            </div>
	                        </div>
	                        <div id="bar" class="progress progress-success progress-striped">
	                            <div class="bar"></div>
	                        </div>
	                        <div class="tab-content form" style="overflow-y:scroll; width:1018x; height:200px;">
	                            <div class="alert alert-error hide">
	                                <button class="close" data-dismiss="alert"></button>
	                                            您提交的信息有误，请修改后保存！
	                            </div>
	                            <div class="alert alert-success hide">
	                                <button class="close" data-dismiss="alert"></button>
	                                    您提交的信息正确!
	                            </div>
	                            <div class="tab-pane active" id="tab1">
	                                <div class="row-fluid" id="personInfo">
	                                	<@createPersonInfo.startPersonInfo/>              
	                                </div>
	                            </div>
	                            <div class="tab-pane active" id="tab2">
	                            	<@createAccumulationInfo.startAccumulation/>
                                </div> 
		                            <div class="tab-pane active" id="tab3">
			                            <div class="row-fluid" id="fileInfo">
			                            	<#if empFiles?exists>
		                            		<@fileInfo.files datas=empFiles rootPath=resRoot fileLength=empFiles?size employeeId=employeeId/>
		                            	</#if>	
		                            	</div>
		                        	</div> 
								  
	                            <div class="tab-pane" id="tab4">
	                            	<h4 class="form-section">备注信息</h4>
	                            	<div class="row-fluid" style="height: auto;">
				                        <@baseInfo.textareaModel title="备注信息" name="approveMsg"/>
				                        <div class="span6 responsive"></div>
	                            	</div>
	                            	<h4 class="form-section">审批记录</h4>
	                            	<@logInfo.logModel results=approveLogs />
	                            </div>
	                        </div>                       
	                    </div>
                    </form>
					                   
                </div>
                <@base.mBottom>
		    		<@base.aLeft/><@base.aRight id="save"/>
		            <a href="javascript:;" id="submit_tab" class="btn blue button-submit">入职 <i class="m-icon-swapright m-icon-white"></i></a>
		        </@base.mBottom>
            </div>
        </div>
    </div>
    <@fileInfo.uploadFile employeeId=employeeId/>
    <!-- END PAGE CONTENT-->         

</div>

<!-- END PAGE CONTAINER-->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script>
var base = "${baseUrl}"; 
var resBase = "${resRoot}";
var employeeId = "${employeeId}";
</script>
<script src="${baseUrl}/assets/js/hr/entry/entry_validate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/hr/entry/entry.js" type="text/javascript"></script>

<!-- END PAGE LEVEL SCRIPTS -->
<script>
    (function($) {
        $(function() {
            FormComponents.init();
            uploadFiles("upload", base + "/hrFile/upload.json", initEntryFiles, false);
			initFileEvents(false);
        });
    })(jQuery);
    
</script>
