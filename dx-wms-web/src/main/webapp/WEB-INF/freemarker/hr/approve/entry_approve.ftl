<#import "hr/entry/fileInfo.ftl" as fileInfo>
<#import "fileBase/baseInfo.ftl" as baseInfo>
<#import "hr/approve_log.ftl" as logInfo>
<#import "/macro/base.ftl" as base>
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
                        <i class="icon-reorder"></i> 入职审批
                    </div>
                </div>
                <div class="portlet-body">
                    <form action="#" class="form-horizontal" id="approve_form">
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
	                        <div class="tab-content form" style="overflow-y:scroll; width:1018x; height:200px;position:relative">
	                            <div class="tab-pane active" id="tab1">
	                                <div class="row-fluid" id="personInfo" style="height:auto;">
	                                	<#include "hr/detail/personInfo.ftl" />
	                                </div>
	                            </div>
	                            <div class="tab-pane active" id="tab2">
	                            	<div class="row-fluid" id="personInfo" style="height:auto;">
	                                	<#include "hr/detail/accumulationInfo.ftl" />
	                                </div>
	                            </div>
	                            <div class="tab-pane active" id="tab3">
	                            	<h4 class="form-section">入职文件</h4>
		                            <div class="row-fluid" id="fileInfo" style="height:auto;text-align:center;">
		                            	<#if empFiles?exists>
		                            		<@fileInfo.files datas=empFiles rootPath=resRoot fileLength=empFiles?size  isReadOnly=true/>
		                            	</#if>
		                            </div>
									<div  id="remarkMsg" style="height:auto;">
		                            	<span>备注信息:
		                            	<#list approveLogs as log >
											<#if log.userId == applicant && log.content != "提交申请单">
											<span id="remarkContent">${log.content}</span>
											</#if>
										</#list>	
										</span>
									</div>
	                            </div>
	                            <div class="tab-pane" id="tab4">
	                            	<h4 class="form-section">审批记录</h4>
	                            	<@logInfo.logModel results=approveLogs />
	                            	<div class="row-fluid" style="height: auto;">
				                        <@baseInfo.textareaModel title="审批内容" isnece=true id="approveMsg" name="approveMsg"/>
				                        <div class="span6 responsive"></div>
	                            	</div>
	                            </div>
	                        </div>
	                    </div>
                    </form>
                </div>
                <@base.mBottom>
		    		<@base.aLeft id="previous_tab"/><@base.aRight id="save" content="下一页"/>
		    		<a href="javascript:;" id="refuse_tab" class="btn blue button-refuse" >
	                                                     拒绝</i>
	                 </a>
		            <a href="javascript:;" id="submit_tab" class="btn blue button-submit" >
	                                                      提交</i>
	                 </a>
		        </@base.mBottom>
            </div>
        </div>
    </div>

    <!-- END PAGE CONTENT-->         

</div>
<script src="${baseUrl}/assets/js/hr/approve/approve_validate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/hr/approve/approve.js" type="text/javascript"></script>
<script>
$(function(){
	var $remarkContent = $("#remarkContent").text().trim();
	if ($remarkContent == null || $remarkContent=="") {
		$("#remarkMsg").hide();
	}else{
		$("#remarkMsg").show();
	}
});
</script>