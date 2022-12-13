<style>
    .control-group{
        height: 50px;
    }
    .row-fluid{
        height: 50px;
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
	            <div class="portlet-body" style="overflow: auto;overflow-x: hidden;>
	                <!-- BEGIN FORM-->
                	<form action="#" class="form-horizontal" id="submit_form">
                		<input type="hidden" id="employeeId" value="${employeeId}">
                    	<div style="height:25px;width:100%;margin-top:15px;margin-bottom:5px">
                    	<table style="margin-left: 15px;width: 100%;margin-bottom: 10px;" >
                    	<tr>	                    	<td class="employeedetail">员工姓名：${employeeInfo.name}</td>
	                    	<td class="employeedetail">员工编号：${employeeInfo.employeeNo}</td>
	                   	 	<td class="employeedetail">原始岗位：${positionView}</td>
	                   	 	<td class="employeedetail">原始组织：${departmentView}</td> 
                        </tr>
                        </table>
	                    </div>
	                    <div style="width: 100%; margin-left: 15px; margin-top: 20px; text-align: left; padding-top: 10px;"><b>调整目标</b></div>
	                    <hr style="height:1px;border:none;border-top:1px solid #555555;margin-top: 10px;" />
	                    <div class="control-group">
                  			<div style="float: left;text-align: -webkit-auto;margin-left: 15px;width: 100%;" ><center>目标职位：
                  				<select class="small m-wrap" name="positionName" id="positionName">
	                            	<option value='-1'>请选择</option>
                             		<#if position?exists>
								      	<#list position?keys as key>
									     	<option value=${key}>${position[key]}</option> 
								      	</#list>
							        </#if>
                            	</select>
                            	<select class="small m-wrap" name="levelName" id="levelName" style="margin-left: 5px;">
                                	<option value='-1'>选择级别</option>
	                            </select>
	                            目标组织：
                    			<select class="small m-wrap" name="orgName" id="orgName" style="width: 273px !important;">
                                	<option value='-1'>请选择</option>
                        		</select>
                            </center>
                            </div>
                        </div>
                    	<div style="width: 100%; margin-left: 15px; margin-top: 20px; text-align: left; padding-top: 10px;">
                    		<b>调整记录</b>
                		</div>  
                    	<hr style="height:1px;border:none;border-top:1px solid #555555;margin-top: 10px;" />
                    	<div class="control-group" min-height: 180px;margin-bottom: 10px;">
                    		<table style="margin-left: 15px;width: 100%;margin-bottom: 10px;">
                    			<tr style="height:20px">
		                			<td class="tableborder">操作时间</td>
		                			<td class="tableborder">原岗位</td>
		                			<td class="tableborder">原组织</td>
		                			<td class="tableborder">现岗位</td>
		                			<td class="tableborder">现组织</td>
                    			<tr>
                    			<#if pushAdjustResultDtos?exists>
									<#list pushAdjustResultDtos as key>
	                    				<tr style="height:20px">
	                    				<td class="tableborder">${key.createTime}</td>
	                    				<td class="tableborder">${key.oldPositionName}</td>
	                    				<td class="tableborder">${key.oldOrgName}</td>
	                    				<td class="tableborder">${key.positionName}</td>
	                    				<td class="tableborder">${key.orgName}</td><tr>
                   					</#list>
                   	 			</#if>
                   	 		</table>
                    	</div>
                        
                 	<!-- END FORM-->
                	</form>  
            	</div>
            	<div class="form-actions clearfix txt-right bottom">
                    <input type="button" class="btn blue mini" value="提交审批" id="submitto" style="min-width: 70px;">
                    <input type="button" class="btn red mini" value="关闭" id="close" style="min-width: 70px;">
                </div> 
        	</div>
    	</div>
    </div>
</div>

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/form-components.js"></script>
<script src="${baseUrl}/assets/js/hr/in_service/create.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>var base = "${baseUrl}"</script>
<script>
    (function($) {
        $(function() {
        	 FormComponents.init();
        });
    })(jQuery);
    
</script>
 