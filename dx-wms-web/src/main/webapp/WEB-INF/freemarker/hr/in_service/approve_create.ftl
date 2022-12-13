<style>
    .control-group{
        height: 50px;
    }
    .row-fluid{
        height: 60px;
    }
    .tableborder{
    	border:1px solid black;
    	width:20%;
    }
    .employeedetail{
        width:25%;
    }
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
    .inservice {
       padding-right: 0px;
       padding-left: 0px;
    }
</style>
<div class="container-fluid inservice">
    <!-- BEGIN PAGE HEADER-->
    <!-- END PAGE HEADER-->
    <div class="row-fluid">
        <div class="span12">
            <div class="portlet box blue" style="margin-bottom: 0;">
            <div class="portlet-title">
                <div class="caption"><i class="icon-reorder"></i>职级组织调整</div>
            </div>
            <div class="portlet-body" style="overflow: auto;overflow-x: hidden;">
                <!-- BEGIN FORM-->
                <form action="#" class="form-horizontal" id="submit_form">
                    <div style="height:25px;width:100%;margin-top:2px;margin-bottom:5px">
                    <table style="margin-left: 15px;width: 100%;margin-bottom: 10px;" >
                    	<tr> 
	                    	<td class="employeedetail">员工姓名：${employeeInfo.name}</td> 
	                    	<td class="employeedetail">员工编号：${employeeInfo.employeeNo}</td> 
	                   	 	<td class="employeedetail">原始岗位：${positionView}</td> 
	                   	 	<td class="employeedetail">原始组织：${departmentView}</td>  
                        </tr> 
                     </table>
                    </div>
                    <input type="hidden" id="employeeId" value="${employeeId}">
                    <input type="hidden" id="procInsId" value="${procInsId}">
                    <input type="hidden" id="taskId" value="${taskId}">
                    <div style="width: 100%; margin-left: 15px; margin-top: 20px; text-align: left; padding-top: 10px;"><b>调整目标</b></div>
                    <hr style="height:1px;border:none;border-top:1px solid #555555;margin: 5px;" />
                    <div class="control-group">
                          <div style="width:100%;text-align: -webkit-auto;margin-top: 5px;"><center>目标岗位：<select class="small m-wrap" name="orgName" id="orgName" style="width: 273px !important;" disabled="disabled" >
                                            <option value='-1'>${targetPosition}</option>
                                        </select>目标组织：<select class="small m-wrap" name="orgName" id="orgName" style="width: 273px !important;" disabled="disabled">
                                            <option value='-1'>${targetOrg}</option>
                                        </select></center></div>
                                        </div>
                    <div style="width: 100%;text-align: -webkit-auto;margin-left: 15px;text-align: left;"><b>审批内容</b></div>  
                    <hr style="height:1px;border:none;border-top:1px solid #555555;margin: 5px;" />
                    <div style="margin-left: auto; margin-right: auto;"><textarea rows="2" cols="2" style="width:80%;margin-left: 5%;resize: none; " id="approveMsg"></textarea></div>                
                    <div style="width: 100%;text-align: -webkit-auto;margin-left: 15px;margin-top: 5px;text-align: left;"><b>审批记录</b></div>  
                    <hr style="height:1px;border:none;border-top:1px solid #555555;margin: 10px;" />
                    <div class="control-group" style="min-height: 140px;margin-bottom: 10px;">  
                    <table style="margin-left: 15px;width: 95%;">
                    <tr style="height:20px"><td class="tableborder">审批人</td><td class="tableborder">审批时间</td><td class="tableborder">审批结果</td><td class="tableborder">审批内容</td><tr>
                    <#if commentResultVos?exists>
					<#list commentResultVos as key>
                    <tr style="height:20px"><td class="tableborder">${key.userName}</td><td class="tableborder">${key.ctimeView}</td><td class="tableborder">同意</td><td class="tableborder">${key.content}</td><tr>
                   </#list>
                    </#if>
                    </table>
                    <div style="width: 100%;text-align: -webkit-auto;margin-left: 15px;margin-top: 5px;text-align: left;"><b>调整记录</b></div>  
                    <hr style="height:1px;border:none;border-top:1px solid #555555;margin: 10px;" />
                    <table style="margin-left: 15px;width: 95%;">
                    <tr style="height:20px"><td class="tableborder">操作时间</td><td class="tableborder">原岗位</td><td class="tableborder">原组织</td><td class="tableborder">现岗位</td><td class="tableborder">现组织</td><tr>
                    <#if pushAdjustResultDtos?exists>
					<#list pushAdjustResultDtos as key>
                    <tr style="height:20px"><td class="tableborder">${key.createTime}</td><td class="tableborder">${key.oldPositionName}</td><td class="tableborder">${key.oldOrgName}</td><td class="tableborder">${key.positionName}</td><td class="tableborder">${key.orgName}</td><tr>
                   </#list>
                    </#if>
                    </table>
                    </div>
                        
                 <!-- END FORM-->
                </form>   
            </div>
            <div class="form-actions clearfix txt-right bottom">
                            <input type="button" class="btn blue mini" value="拒绝" onclick="approveto(2)">
                            <input type="button" class="btn blue mini" value="通过" onclick="approveto(1)">
                            <input type="button" class="btn red mini" value="关闭" id="close">
                        </div>
        </div>
    </div>
    </div>
</div>

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/form-components.js"></script>
<script src="${baseUrl}/assets/js/hr/in_service/approve_create.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>var base = "${baseUrl}"</script>
<script>
    (function($) {
        $(function() {
        	 FormComponents.init();
        });
    })(jQuery);
    
</script>
 