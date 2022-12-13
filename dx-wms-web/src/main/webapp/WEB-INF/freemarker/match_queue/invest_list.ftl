<style> 
    .row-fluid{
        height: 50px;
    }
	.view{
	    float: left;
	    padding-top: 5px;
	    text-align: left;
	    width: 200px;
	    margin-top: 2px;
	    margin-left: 10px;
	}
	.show{
		float: left;
	    padding-top: 5px;
	    text-align: right;
	    width: 100px;
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
               	投资队列
            </h3>
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                   	债权匹配管理  	
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                                                                     匹配队列管理   	
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="${baseUrl}/matchQueue/invest.htm">投资队列</a>
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
                <div class="caption"><i class="icon-reorder"></i>投资队列</div>
            </div>
            <div class="portlet-body">
                <!-- BEGIN FORM-->
                <form action="#" role="form" class="form-horizontal" id="matchQueueForm">
                    <input type="hidden" id="userId" name="userId" value="${userId}"/>
                    <div class="row-fluid">
                        <div class="span5 responsive">
                            <label class="control-label" >客户姓名：</label>
                            <div class="controls">
                                <input type="text" class="medium m-wrap" name="custName" id="custName">
                            </div>
                        </div>
                        <div class="span5 responsive">
                            <label class="control-label" >出借方式：</label>
                            <div class="controls">
	                            <select class="medium m-wrap" name="lenderWay" id="lenderWay">
									<option value=''>请选择</option>
									<#if products?exists>
						                <#list products?keys as key> 
						                	<option value=${key}>${products[key]}</option>
						                </#list>
            						</#if>
	                			</select>	
                            </div>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="span5 responsive"></div>
                        <div class="span5 responsive" style="margin-left: 110px;">
                            <input type="button" class="btn blue" value="查询" id="query">
                            <input type="button" class="btn blue" value="重置" id="reset">
                            <input type="button" class="btn green" value="加入" id="add">
                        </div>
                    </div>
                 <div class="control-group">
					<div class="span6">
						<table id="statList" class="table table-striped table-bordered table-advance table-hover">
							<thead>
								<tr>
									<th>出借方式</th>
									<th>出借数量</th>
									<th>出借金额</th>
								</tr>
							</thead>
						</table>
					</div>
					<div class="span6">
						<table id="statList_" class="table table-striped table-bordered table-advance table-hover">
							<thead>
								<tr>
									<th>账单日</th>
									<th>队列债权</th>
									<th>在库未使用债权</th>
								</tr>
							</thead>	
						</table>
					</div>				
				</div>
			    <div class="form-section"></div>
                <div>
                	<table id="resultList" class="table table-striped table-bordered table-hover" >
                    	<thead>
                        	<th><input type='checkbox' value='-1' id="all"/></th>
                            <th>出借编号</th>
                            <th>客户姓名</th>
                            <th>证件号</th>
                            <th>客户编号</th>
                            <th>出借方式</th>
                            <th>出借金额</th>
                            <th>申请日期</th>
                            <th>预计出借日期</th>
                            <th>进件日期</th>
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
<!-- BEGIN PAGE L SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js"></script>
<script src="${baseUrl}/assets/js/match_queue/invest_list.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/match_queue/invest_stat_list.js" type="text/javascript"></script> 
<!-- END PAGE LEVEL SCRIPTS -->
<script>var base = "${baseUrl}"</script>
<script>
    (function($) {
        $(function() {
            App.init();
            FormComponents.init();
            count();
        });
    })(jQuery);
    
</script>
 