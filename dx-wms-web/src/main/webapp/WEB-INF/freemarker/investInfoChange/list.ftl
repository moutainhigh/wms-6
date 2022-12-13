<style>
    .boder-right-scroll{
        width:100%;
        overflow-x:scroll;
    }
    .row-fluid{
        height: 50px;
    }
    .span12.m-wrap{
    	width:247px;
    }
</style>
<div class="container-fluid">
    <!-- BEGIN PAGE HEADER-->
    <div class="row-fluid">
        <div class="span12">
            <!-- BEGIN PAGE TITLE & BREADCRUMB-->
            <h3 class="page-title">
                                        投资信息变更
            </h3>
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                   		 变更管理
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="${baseUrl}/infoChange/investInfo.htm?biz=investInfo">投资信息变更</a>
                </li>
            </ul>
            <!-- END PAGE TITLE & BREADCRUMB-->
        </div>
    </div>
    <!-- END PAGE HEADER-->
    <div class="row-fluid">
        <div class="span12">
            <div class="portlet box blue">
                <div class="portlet-title">
                    <div class="caption"><i class="icon-reorder"></i>投资信息变更</div>
                </div>
                <div class="portlet-body">
                    <!-- BEGIN FORM-->
                    <form action="#" role="form" class="form-horizontal" id="refundForm">
                    	<div class="row-fluid">
                            <div class="span5 responsive">
                                <label class="control-label" >出借编号：</label>
                                <div class="controls">
                                    <input type="text" class="span12 m-wrap" name="lenderCode" id="lenderCode">
                                </div>
                            </div>
                            <div class="span5 responsive">
                                <label class="control-label" >客户姓名：</label>
                                <div class="controls">
                                    <input type="text" maxlength="20"  class="span12 m-wrap" name="custNameQuery" id="custNameQuery">
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span5 responsive">
                                <label class="control-label" >出借方式：</label>
                                <div class="controls">
                                    <select class="span12 m-wrap" name="loanWayQuery" id="loanWayQuery" >
										<option value=''>请选择</option>
										<#if product?exists>
											<#list product?keys as key>
												<option value=${key}>${product[key]}</option> 
                                       		</#list>
                                    	</#if>
									</select> 
                                </div>
                            </div>
                            <div class="span5 responsive">
                                <label class="control-label" >出借金额：</label>
                                <div class="controls">
                                    <select class="span12 m-wrap" name="loanAmount" id="loanAmount" >
										<option value=''>请选择</option>
										<#if amountArea?exists>
											<#list amountArea?keys as key>
												<option value=${key}>${amountArea[key]}</option> 
                                       		</#list>
                                    	</#if>
									</select> 
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span5 responsive">
                                <label class="control-label" >营业部：</label>
                                <div class="controls">
                                    <select class="span12 m-wrap" name="salesDepartment" id="salesDepartment" >
										<option value=''>请选择</option>
										<#if department?exists>
											<#list department?keys as key>
												<option value=${key}>${department[key]}</option> 
                                       		</#list>
                                    	</#if>
									</select> 
                                </div>
                            </div>
                            <div class="span5 responsive">
                                <label class="control-label" >状态：</label>
                                	<div class="controls">
                                 		<select class="span12 m-wrap" name="currentStep" id="currentStep" >
										<option value=''>请选择</option>
										<#if currentStep?exists>
											<#list currentStep?keys as key>
												<#if key=='14'||key=='15'||key=='17'||key=='18'||key=='19'||key=='21'||key=='20'||key='23'|| key=='22'>
												<option value=${key}>${currentStep[key]}</option> 
												</#if>
                                       		</#list>
                                    	</#if>
									</select> 
									</div>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span5 responsive">
                                <label class="control-label">签单日期（起）：</label>
                                <div class="controls">
                                        <input class="span12 m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" value="" name="signDateBegin" id="signDateBegin" data-date-format="yyyy-mm-dd" >
                                </div>
                            </div>
                            <div class="span5 responsive">
                                <label class="control-label">签单日期（止）：</label>
                                <div class="controls">
                                    <input class="span12 m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" value="" name="signDateEnd" id="signDateEnd"  data-date-format="yyyy-mm-dd">
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                        	<div class="span5 responsive" style="margin-left: 635px;">
                                <input type="button" class="btn blue" value="查询" id="query">
                                <input type="button" class="btn red" value="重置" id="reset">
                            </div>
                        </div>
                        <div class="form-section"></div>
                        <div style="overflow-x: hidden;">
                        <table id="resultList" class="table table-striped table-bordered table-hover" >
                            <thead>
                                    <th>出借编号</th>
                                    <th>客户姓名</th>
                                    <th>证件号码</th>
                                    <th>出借方式</th>
                                    <th>出借金额(元)</th>
                                    <th>签单日期</th>
                                    <th>营业部</th>
                                    <th>大团</th>
                                    <th>团队</th>
                                    <th>客户经理</th>
                                    <th>状态</th>
                                    <th>生效时间</th>
                                    <th>操作</th>
                                </thead>
                            </table>
                        </div>
                    </form>
                    <!-- END FORM-->
                </div>
            </div>
        </div>
    </div>
</div>
<div id="investInfoChangeDiv" class="modal hide fade" tabindex="-1" data-width="960" style="width:75%;position:absolute;left:480px;top:60px;"> 
 </div>
 <div id="investLogDiv" class="modal hide fade" tabindex="-1" data-width="960" style="width:62%;position:absolute;left:700px;top:60px;"></div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-wizard.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/contents/file_show.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/investInfoChange/list.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
var base = "${baseUrl}"
var resBase = "${resRoot}";
</script>
<script>
    (function($) {
        $(function() {
            App.init();
            FormComponents.init();
            queryData();
        });
    })(jQuery);
    
</script>
 