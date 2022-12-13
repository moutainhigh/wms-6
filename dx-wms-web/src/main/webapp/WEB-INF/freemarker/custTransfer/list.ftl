<style>
    .boder-right-scroll{
        width:100%;
        overflow-x:scroll;
    }
    .row-fluid{
        height: 50px;
    }
    .find-modal{
    	width:80%;
    	position:absolute;
    	left:420px;
    	top:60px;
    }
</style>
<#include "/macro/base.ftl">
<div class="container-fluid">
    <!-- BEGIN PAGE HEADER-->
    <div class="row-fluid">
        <div class="span12">
            <!-- BEGIN PAGE TITLE & BREADCRUMB-->
            <h3 class="page-title">
                	客户转移管理
            </h3>
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    客户转移
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="${baseUrl}/custTransfer/list.htm">客户转移管理</a>
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
                    <div class="caption"><i class="icon-reorder"></i>客户转移管理</div>
                </div>
                <div class="portlet-body">
                    <!-- BEGIN FORM-->
                    <form action="#" role="form" class="form-horizontal" id="refundForm">
                        <div class="row-fluid">
                        	<div class="span5 responsive">
                                <label class="control-label" >客户编号：</label>
                                <div class="controls">
                                    <input type="text" maxlength="30" class="span12 m-wrap" name="lenderCustCode" id="lenderCustCodeQuery">
                                </div>
                            </div>
                            <div class="span5 responsive">
                                <label class="control-label" >客户姓名：</label>
                                <div class="controls">
                                    <input type="text" maxlength="20" class="span12 m-wrap" name="custName" id="custNameQuery">
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                        	<div class="span5 responsive">
                                <label class="control-label" >移动电话：</label>
                                <div class="controls">
                                    <input type="text" maxlength="11" class="span12 m-wrap" name="mobile" id="mobileQuery">
                                </div>
                            </div>
                            <div class="span5 responsive">
                                <label class="control-label" >证件号码：</label>
                                <div class="controls">
                                    <input type="text" maxlength="30" class="span12 m-wrap" name="idCard" id="idCardQuery">
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span5 responsive">
                                <label class="control-label" >营业部：</label>
                                <div class="controls">
                                    <select class="span12 m-wrap" name="orgId" id="orgIdQuery" >
										<option value='-1'>请选择</option>
										<#if orgIds?exists>
											<#list orgIds?keys as key>
												<option value=${key}>${orgIds[key]}</option> 
                                       		</#list>
                                    	</#if>
									</select> 
                                </div>
                            </div>
                            <div class="span6 responsive">
                                <label class="control-label" >大团：</label>
                                <div class="controls">
                                    <select class="span9 m-wrap" name="cluster" id="clusterQuery" >
										<option value='-1'>请选择</option>
										<#if clusters?exists>
											<#list cluster?keys as key>
												<option value=${key}>${clusters[key]}</option> 
                                       		</#list>
                                    	</#if>
									</select> 
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span5 responsive">
                                <label class="control-label" >团队：</label>
                                <div class="controls">
                                    <select class="span12 m-wrap" name="team" id="teamQuery" >
										<option value='-1'>请选择</option>
										<#if teams?exists>
											<#list teams?keys as key>
												<option value=${key}>${teams[key]}</option> 
                                       		</#list>
                                    	</#if>
									</select> 
                                </div>
                            </div>
                            <div class="span6 responsive">
                                <label class="control-label" >客户经理：</label>
                                <div class="controls">
                                    <select class="span9 m-wrap" name="custManagerId" id="custManagerIdQuery" >
										<option value='-1'>请选择</option>
									</select>
                                </div>
                            </div>
                        </div>
                         <div class="row-fluid">
                            <div class="span5 responsive">
                                &nbsp;
                            </div>
                            <div class="span5 responsive" style="margin-left: 200px;">
                                <input type="button" class="btn blue" value="查询" id="query">
                                <input type="button" class="btn red" value="重置" id="reset">
                                <input type="button" class="btn blue" value="转移" id="transfer">
                            </div>
                        </div>
                        <div class="form-section"></div>
                        <div style="overflow-x: hidden;">
	                        <table id="resultList" class="table table-striped table-bordered table-hover" >
	                        	<thead>
	                        		<th><input type="checkbox" name="selectAll" id="selectAll"></th>
	                                <th>客户编号</th>
	                                <th>客户姓名</th>
	                                <th>证件号码</th>
	                                <th>营业部</th>
	                                <th>大团</th>
	                                <th>团队</th>
	                                <th>客户经理</th>
	                                <th>状态</th>
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
<div id="transferFrame" class="modal hide fade" tabindex="-1" data-width="360" style="width:65%; margin-left: -520px; height:55%; overflow-y:scroll;" > 
    <div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="close"></button>
		<h3 id="myModalLabel3"> 客户转移</h3> 
	</div>
	<div class="control-group" style="text-align:left;height:60px;">
		<br />	
    	<div class="span4 responsive">
            <div class="controls">
				营业部：&nbsp;&nbsp;
               <select class="span5 m-wrap" name="orgIdFrame" id="orgIdFrame" > 
					<option value='-1'>请选择</option>
					<#if orgIds?exists>
						<#list orgIds?keys as key> 
							<option value=${key}>${orgIds[key]}</option>
                    	</#list>
                    </#if>
			  </select> 
            </div>
        </div>
        <div class="span4 responsive">
            <div class="controls">
				大团：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <select class="span5 m-wrap" name="clusterFrame" id="clusterFrame" >
					<option value='-1'>请选择</option>
					<#if clusters?exists>
						<#list cluster?keys as key>
							<option value=${key}>${clusters[key]}</option> 
                   		</#list>
                	</#if>
				</select> 
            </div>
        </div>
    </div>
	<div class="control-group" style="text-align:left;height:60px;">
		<br />	
    	<div class="span4 responsive">
            <div class="controls">
				团队：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <select class="span5 m-wrap" name="teamFrame" id="teamFrame" > 
					<option value='-1'>请选择</option>
					<#if teams?exists>
					<#list teams?keys as key> 
						<option value=${key}>${teams[key]}</option> 
                    </#list>
                    </#if>
			  </select> 
            </div>
        </div>
        <div class="span4 responsive">
            <div class="controls">
				客户经理：&nbsp;&nbsp;&nbsp;&nbsp;
               <select class="span5 m-wrap" name="custManagerFrame" id="custManagerFrame" >
					<option value='-1'>请选择</option>
				</select> 
            </div>
        </div>
    </div>
    <p>&nbsp;</p>
    <div class="control-group" style="text-align:right;margin-right: 50px;">
    	<input type="button" class="btn blue" value="转移" id="transferBtnFrame">
        <input type="button" class="btn red" value="关闭" id="closeBtnFrame">
	</div>   
</div>

 <div id="responsive" class="modal hide fade" tabindex="-1" data-width="100%" style="width:800px;height:500px">
	<div class="modal-header">
       	<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <font size="3.5">图片信息</font>
        <div id="imgChangeDiv"></div>
    </div>
	<div style="position:absolute;left:0px;top:50px;">
		<div id="documentViewer" class="flexpaper_viewer" style="width:800px;height:500px"></div>
	</div>
</div>


<@modal id="findModal" name="find-modal"/>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-wizard.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/custTransfer/list.js" type="text/javascript"></script>

<!-- END PAGE LEVEL SCRIPTS -->
<script>
	var base = "${baseUrl}";
	var resBase = "${resRoot}";
    (function($) {
        $(function() {
            App.init();
     		FormComponents.init();
     		queryData();
        });
    })(jQuery);
    
</script>
 