<style> 
    .row-fluid{
        height: 50px;
    }
    .modal {
	    background-clip: padding-box;
	    background-color: #fff;
	    border: 1px solid rgba(0, 0, 0, 0.3);
	    border-radius: 6px;
	    box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
	    left: 50%;
	    margin-left: -680px;
	    outline: 0 none;
	    position: fixed;
	    top: 10%;
	    width: 600px;
	    z-index: 1050;
	}
	.div_font{
		font-family: "microsoft yahei";
	    font-size: 16px;
	    text-align: left;
	    width: 200px;
	    font-weight: bold;
	    margin-left: 50px;
	}
	.div_btn{
		margin-left: 50px;
	}
	.show{
		float: left;
	    padding-top: 5px;
	    text-align: left;
	    width: 400px;
	    margin-top: 2px;
	    margin-left: 10px;
	}
</style>
<div class="container-fluid">
    <!-- BEGIN PAGE HEADER-->
    <div class="row-fluid">
        <div class="span12">
            <!-- BEGIN PAGE TITLE & BREADCRUMB-->
            <h3 class="page-title">
               	匹配视图管理
            </h3>
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                   		债权匹配管理  	
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                                                     匹配管理   	
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="${baseUrl}/matchView/list.htm">匹配视图管理</a>
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
                <div class="caption"><i class="icon-reorder"></i>匹配视图管理</div>
            </div>
            <div class="portlet-body">
                <!-- BEGIN FORM-->
                <form action="#" role="form" class="form-horizontal" id="matchQueueForm">
                    <input type="hidden" id="userId" name="userId" value="${userId}"/>
                    <div class="control-group">
                        <div class="span5 responsive">
                            <label class="control-label" >客户姓名：</label>
                            <div class="controls">
                                <input type="text" class="medium m-wrap" name="custName" id="custName">
                            </div>
                        </div>
                        <div class="span5 responsive">
                            <label class="control-label" >出借方式：</label>
                            <div class="controls">
	                            <select "medium m-wrap" name="productId" id="productId">
									<option value=''>请选择</option>
									<#if products?exists>
						                <#list products as product> 
						                	<option value=${product.productId}>${product.productName}</option>
						              	</#list>
	         						</#if>
	                			</select>	
                            </div>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="span5 responsive">
                            <label class="control-label" >出借编号：</label>
                            <div class="controls">
                                <input type="text" class="medium m-wrap" name="lenderCode" id="lenderCode">
                            </div>
                        </div>
                        <div class="span5 responsive">
                            <label class="control-label" >账单日：</label>
                            <div class="controls">
	                            <select class="medium m-wrap" name="billDay" id="billDay">
									<option value=''>请选择</option>
	                				<option value='1'>1</option>
	                				<option value='16'>16</option>
								</select>	
                            </div>
                        </div>
                    </div>
                    <div class="control-group">
                    	<div class="span5 responsive">
                        	<label class="control-label">匹配日期（起）：</label>
                           	<div class="controls">
                            	<input class="medium m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" value="" name="matchDateBegin" id="matchDateBegin" data-date-format="yyyy-mm-dd">
                            </div>
                       	</div>
                        <div class="span5 responsive">
                        	<label class="control-label">匹配日期（止）：</label>
                            <div class="controls">
                            	<input class="medium m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" value="" name="matchDateEnd" id="matchDateEnd" data-date-format="yyyy-mm-dd">
                            </div>
                        </div>
                   </div> 
                    <div class="control-group">
                    	<div class="span5 responsive">
                        	<label class="control-label">首次匹配日期（起）：</label>
                           	<div class="controls">
                            	<input class="medium m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" value="" name="initMatchDateBegin" id="initMatchDateBegin" data-date-format="yyyy-mm-dd">
                            </div>
                       	</div>
                        <div class="span5 responsive">
                        	<label class="control-label">首次匹配日期（止）：</label>
                            <div class="controls">
                            	<input class="medium m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" value="" name="initMatchDateEnd" id="initMatchDateEnd" data-date-format="yyyy-mm-dd">
                            </div>
                        </div>
                   </div>   
                    <div class="control-group">
                    	<div class="span5 responsive">
                        	<label class="control-label">转让日期（起）：</label>
                           	<div class="controls">
                            	<input class="medium m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" value="" name="transDateBegin" id="transDateBegin" data-date-format="yyyy-mm-dd">
                            </div>
                       	</div>
                        <div class="span5 responsive">
                        	<label class="control-label">转让日期（止）：</label>
                            <div class="controls">
                            	<input class="medium m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" value="" name="transDateEnd" id="transDateEnd" data-date-format="yyyy-mm-dd">
                            </div>
                        </div>
                   </div>           
                   <div class="control-group">
                    	<input type="button" class="btn blue" value="查询" id="query">
                        <input type="button" class="btn blue" value="重置" id="reset">
                    </div>
               		<div class="form-section"></div>
	                <div>
	                	<table id="resultList" class="table table-striped table-bordered table-hover" >
	                    	<thead>
	                    		<th></th>
	                        	<th>出借编号</th>
	                            <th>客户姓名</th>
	                            <th>出借方式</th>
	                            <th>出借金额(元)</th>
	                            <th>报告日</th>
	                            <th>转让对价</th>
	                            <th>转让日债权价值</th>
	                            <th>转让日期</th>
	                            <th>生效日期</th>
	                            <th>首次匹配日期</th>
	                            <th>匹配日期</th> 
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
<div id="matchModel" class="modal hide fade" tabindex="-1" data-width="960" style="width:100%"></div>
<!-- BEGIN PAGE L SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/match_view/match_view_list.js" type="text/javascript"></script> 
<link href="${baseUrl}/assets/css/match_view/first_transfer_view.css" rel="stylesheet" type="text/css">
	
<!-- END PAGE LEVEL SCRIPTS -->
<script>var base = "${baseUrl}"</script>
<script>
    (function($) {
        $(function() {
            App.init();
            FormComponents.init();
        });
    })(jQuery);
    
</script>
 