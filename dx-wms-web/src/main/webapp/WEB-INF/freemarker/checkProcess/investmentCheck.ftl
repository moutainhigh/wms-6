<style>
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
               投资审核
            </h3>
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    理财管理
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="${baseUrl}/process/invest.htm?biz=invest">投资审核</a>
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
                    <div class="caption"><i class="icon-reorder"></i>投资审核</div>
                </div>
                <div class="portlet-body">
                    <!-- BEGIN FORM-->
                    <form action="#" role="form" class="form-horizontal" id="refundForm">
                        <div class="row-fluid">
                            <div class="span5 responsive">
                                <label class="control-label" >出借编号：</label>
                                <div class="controls">
                                    <input type="text" maxlength="25"  class="span12 m-wrap" name="lenderCodeQuery" id="lenderCodeQuery">
                                </div>
                            </div>
                            <div class="span5 responsive">
                                <label class="control-label" >客户姓名：</label>
                                <div class="controls">
                                     <input type="text" class="span12 m-wrap" name="custNameQuery" id="custNameQuery" maxlength="20">
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                        	<div class="span5 responsive">
                               <label class="control-label">出借金额：</label>
                                	<div class="controls">
                                 		<select class="span12 m-wrap" name="lenderAmountQuery" id="lenderAmountQuery" >
											<option value='-1'>请选择</option>
											<#if amountArea?exists>
												<#list amountArea?keys as key>
													<option value=${key}>${amountArea[key]}</option> 
                                   				</#list>
                                			</#if>
										</select>
                                	</div>
                            </div>
                            <div class="span5 responsive">
                                <label class="control-label" >证件号码：</label>
                                <div class="controls">
                                     <input type="text" class="span12 m-wrap" name="idCardQuery" id="idCardQuery" maxlength="18">
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
                         </div>
                        <div class="row-fluid">
	                    	<div class="span5 responsive">
	                        	<label class="control-label">签单日期（起）：</label>
                               		<div class="controls">
                                        <input class="span12 m-wrap m-ctrl-medium date-picker" readonly size="16" name="signDateTimeBegin" id="signDateBegin" data-date-format="yyyy-mm-dd" >
                                	</div>
	                        </div>
                            <div class="span5 responsive">
                                <label class="control-label">签单日期（止）：</label>
                                <div class="controls">
                                    <input class="span12 m-wrap m-ctrl-medium date-picker" readonly size="16" name="signDateEnd" id="signDateEnd" data-date-format="yyyy-mm-dd">
                                </div>
                           	</div>
                         </div> 
						<div class="row-fluid">
							<div class="span7 responsive" > </div>
                        	<div class="span5 responsive" >
                        		<input type="button" class="btn blue" value="查询" id="query">
                            	<input type="button" class="btn red" value="重置" id="reset">
                       		</div>
                    	</div>
                 	<!-- END FORM-->
                        <div class="form-section"></div>
                        <div style="overflow-x: hidden;">
                        	<table id="resultList" class="table table-striped table-bordered table-hover" >
                            	<thead>
                                    <th>出借编号</th>
                                    <th>客户姓名</th>
                                    <th>证件号码</th>
                                    <th>出借方式</th>
                                    <th>出借金额（元）</th>
                                    <th>签单日期</th>
                                    <th>营业部</th>
                                    <th>大团</th>
                                    <th>团队</th>
                                    <th>客户经理</th>
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
<div id="createCustApplyDiv" class="modal hide fade" tabindex="-1" data-width="960" style="width:80%; margin-left: -520px; height:auto;" > 
             
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
<div class="clearfix"></div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script>
var base = "${baseUrl}";
var role = "${role}"
</script>
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js"></script>
<script src="${baseUrl}/assets/js/contents/file_show.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/flexpaper/js/flexpaper.js"></script>
<script src="${baseUrl}/assets/js/contents/image_goto_change.js"></script>
<script src="${baseUrl}/assets/js/checkProcess/investmentCheck.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->

<script>
    (function($) {
        $(function() {
            App.init();
            FormComponents.init();
        });
    })(jQuery);
</script>