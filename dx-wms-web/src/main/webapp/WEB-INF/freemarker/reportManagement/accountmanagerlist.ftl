<style>
    .boder-right-scroll{
        width:100%;
        overflow-x:scroll;
    }
    .row-fluid{
        height: 50px;
    }
</style>
<div class="container-fluid">
    <!-- BEGIN PAGE HEADER-->
    <div class="row-fluid">
        <div class="span12">
            <!-- BEGIN PAGE TITLE & BREADCRUMB-->
            <h3 class="page-title">
                报表管理
            </h3>
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    报表管理
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="${baseUrl}/reportManagement/list.htm">报表信息管理</a>
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
                    <div class="caption"><i class="icon-reorder"></i>报表信息管理</div>
                </div>
                <div class="portlet-body">
                    <!-- BEGIN FORM-->
                    <form action="#" role="form" class="form-horizontal" id="refundForm">
                    <input type="hidden" value=${createUser} id="createUserQuery">
                       <div class="row-fluid">
						<div class="span5 responsive">	
							<label class="control-label" >出借方式：</label>
							<div class="controls">
								<select class="span12 m-wrap" name="loanWayQuery" id="loanWayQuery" >
									<option value='-1'>请选择</option>
									<#if loanWay?exists>
										<#list loanWay?keys as key>
											<option value=${key}>${loanWay[key]}</option> 
										</#list>
									</#if>
								</select>
	                    	</div>
	                	</div>
                       	<div class="span6 responsive">
                           <label class="control-label">出借金额：</label>
                            <div class="controls">
                             <select class="span9 m-wrap" name="lenderAmountQuery" id="lenderAmountQuery" >
								<option value='-1'>请选择</option>
								<#if lenderAmountArea?exists>
									<#list lenderAmountArea?keys as key>
										<option value=${key}>${lenderAmountArea[key]}</option> 
                               		</#list>
                            	</#if>
							</select>
                            </div>
                        </div>
                   	</div>
                   	<div class="row-fluid">
                   	<div class="span6 responsive" style="max-width: 425px;">
                   	
                                <label class="control-label" >客户姓名：</label>
                                <div class="controls">
                                    <input type="text" maxlength="20" class="span9 m-wrap" name="custNameQuery" id="custNameQuery" style="width: 100%;">
                                </div>
                            </div>
                       	<div class="span6 responsive">
                           <label class="control-label">账单日：</label>
                            <div class="controls">
                             <select class="span9 m-wrap" name="statementDateQuery" id="statementDateQuery" >
								<option value='-1'>请选择</option>
								<option value='1'>1</option>
								<option value='16'>16</option>
							</select>
                            </div>
                        </div>
                   	</div>
                   	<div class="row-fluid">
                            <div class="span5 responsive">
                                <label class="control-label">生效日期（起）：</label>
                                <div class="controls">
                                        <input class="span12 m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" value="" name="settlementDateBegQuery" id="settlementDateBegQuery" data-date-format="yyyy-mm-dd" >
                                </div>
                            </div>
                            <div class="span5 responsive">
                                <label class="control-label">生效日期（止）：</label>
                                <div class="controls">
                                    <input class="span12 m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" value="" name="settlementDateEndQuery" id="settlementDateEndQuery"  data-date-format="yyyy-mm-dd">
                                </div>
                            </div>
                        </div>
                   	<div class="control-group">
                        <div class="span5 responsive"></div>
                        <div class="span5 responsive" style="margin-left: 61%;">
                            <input type="button" class="btn blue" value="查询" id="query">
                            <input type="button" class="btn red" value="重置" id="reset">
                            <input type="button" class="btn blue" value="导出当前报表" id="export">
                        </div>
                    </div>
                    <div><div style="float: left;margin-right: 120px;" id="allLenderAmount">出借总额:</div><div id="investment">投资数:</div></div>
                        <div class="form-section"></div>
                        <div>
                        <div class="btn-group" style="float: right;">

										<a class="btn blue" href="#" data-toggle="dropdown">

										显示列表项

										<i class="icon-angle-down"></i>

										</a>

										<div style="overflow-x: hidden;" id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
										</div>

									</div>
                        <table id="resultList" class="table table-striped table-bordered table-hover">
                            <thead id="tableName">
                            		<th class='signDate'>签单日期</th>
                                    <th class='lenderCode'>出借编号</th>
                                    <th class='custName'>客户姓名</th>
                                    <th class='sex'>性别</th>
                                    <th class='idCard'>证件号码</th>
                                    <th class='productName'>出借方式</th>
                                    <th class='lenderAmount'>出借金额</th>
                                    <th class='custCategory'>客户分类</th>
                                    <th class='expectLenderDate'>预计出借日期</th>
                                    <th class='settlementDate'>生效日期</th>
                                    <th class='statementDate'>账单日</th>
                                    <th class='matchDate'>匹配时间</th>
                                    <th class='payWayName'>支付方式</th>
                                    <th class='giveBankCategory'>划扣银行</th>
                                    <th class='giveAccountNum'>划扣账号</th>
                                    <th class='getBankCategory'>回款银行</th>
                                    <th class='getAccountNum'>回款账号</th>
                                    <th class='accountName'>帐户名</th>
                                    <th class='address'>联系地址</th>
                                    <th class='zipCode'>邮编</th>
                                    <th class='msgWay'>接受文件方式</th>
                                    <th class='email'>电子邮箱</th>
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
<div id="listupdate" tabindex="-1"  class="modal hide fade" style="width: 500px;">
        <div class="row-fluid">
        <div class="span12">
            <div class="portlet box blue" style="border-bottom: 0;">
                <div class="portlet-title">
                    <div class="caption"><i class="icon-reorder"></i>选择列表项</div>
                </div>
                       <div style="margin-top: 15px;">
                   				<div class="controls" style="width:200px;float:left;margin-left: 30px;">
                                        <div style="border:1px solid;border-color: #ccc;background-color: gray;text-shadow: white;color: white;">显示列表项</div>
											<select class="span6 m-wrap" multiple="multiple" style="width:100%" data-placeholder="Choose a Category" tabindex="1" id="beforechoose">


											</select>
				</div>
				<img src="${baseUrl}/assets/image/switch.png" style="position: relative;top: 42px;left: 8px;">
				<div class="controls" style="width:200px;float:right;margin-right: 30px;margin-bottom: 30px;">
                                        <div style="border:1px solid;border-color: #ccc;background-color: gray;text-shadow: white;color: white;">隐藏列表项</div>
											<select class="span6 m-wrap" style="width:100%" multiple="multiple" data-placeholder="Choose a Category" tabindex="1" id="choosed">


											</select>
											<div><input type="button" class="btn blue" value="关闭" id="closechoose" style="position: relative;float: right;margin-left: 5px;"></div>
											<div><input type="button" class="btn blue" value="生成列表" id="updatelist" style="position: relative;float: right;"></div>
											
				</div>
				
				</div>
				
				</div>
                </div>
                <input type="hidden" id="chooselistvalue" value=${chooselistvalue}>
				</div>
      </div>
<div id="waitexper" tabindex="-1"  class="modal hide fade" style="width:300px;text-align:center;position:fixed;left:50%;top:50%;margin-left:width/2;margin-top:height/2"><div class="row-fluid">
        <div class="span12">
            <div class="portlet box blue" style="border-bottom: 0;"><div class="portlet-title">
                    <div class="caption"><i class="icon-reorder">提示信息</i></div>
                </div>请稍等，正在导出报表</div></div></div></div>
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



<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-wizard.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/contents/file_show.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/flexpaper/js/flexpaper.js"></script>
<script src="${baseUrl}/assets/js/reportManagement/accountmanagerlist.js"></script>
<script src="${baseUrl}/assets/js/contents/image_goto_change.js" type="text/javascript"></script> 
<!-- END PAGE LEVEL SCRIPTS -->
<script>
	var base = "${baseUrl}";
	var resBase = "${resRoot}";
    (function($) {
        $(function() {
            App.init();
            FormComponents.init();
        });
    })(jQuery);
    
</script>
 