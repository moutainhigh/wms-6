<style>
  
    .row-fluid{
        height: 50px;
    }
    .modal {
    position: fixed;
    top: 10%;
    left: 50%;
    z-index: 1050;
    width: 800px;
    margin-left: -400px;
    background-color: #fff;
    border: 1px solid #999;
    border: 1px solid rgba(0, 0, 0, 0.3);
    *border: 1px solid #999;
    -webkit-border-radius: 6px;
    -moz-border-radius: 6px;
    border-radius: 6px;
    outline: 0;
    -webkit-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
    -moz-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
    box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
    -webkit-background-clip: padding-box;
    -moz-background-clip: padding-box;
    background-clip: padding-box
}
    
</style>
<div class="container-fluid">
    <!-- BEGIN PAGE HEADER-->
    <div class="row-fluid">
        <div class="span12">
            <!-- BEGIN PAGE TITLE & BREADCRUMB-->
            <h3 class="page-title">
                账户信息变更
            </h3>
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    变更管理
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="${baseUrl}/infoChange/custInfo.htm?biz=custInfo">账户信息变更</a>
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
                <div class="caption"><i class="icon-reorder"></i>账户信息变更</div>
            </div>
            <div class="portlet-body">
                <!-- BEGIN FORM-->
                <form action="#" role="form" class="form-horizontal" id="refundForm">
                    <div class="row-fluid">
                        <div class="span5 responsive">
                            <label class="control-label" >客户姓名：</label>
                            <div class="controls">
                                <input type="text" class="span12 m-wrap" name="custNameQuery" id="custNameQuery" maxlength="20">
                            </div>
                        </div>
                        <div class="span5 responsive">
                            <label class="control-label" >证件号码：</label>
                            <div class="controls">
                                    <input type="text" class="span12 m-wrap" name="idCardQuery" id="idCardQuery">
                            </div>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="span5 responsive">
                            <label class="control-label" >移动电话：</label>
                            <div class="controls">
                                    <input type="text" class="span12 m-wrap" name="mobileQuery" id="mobileQuery">
                            </div>
                        </div>
                         <div class="span5 responsive">
                            <label class="control-label" >客户编号：</label>
                            <div class="controls">
                                    <input type="text" class="span12 m-wrap" name="lenderCustCode" id="lenderCustCode">
                            </div>
                        </div>
                        </div>
                    <div class="row-fluid">
                        <div class="span5 responsive">
                            <label class="control-label" >状态：</label>
                            <div class="controls">
                                <select class="span12 m-wrap" name="status" id="status" >
										<option value=''>请选择</option>
										<#if accountStatus?exists>
											<#list accountStatus?keys as key>
												<#if key=='C' || key =='S'>
													<option value=${key}>${accountStatus[key]}</option>
												</#if>
                                       		</#list>
                                    	</#if>
								</select> 
                            </div>
                        </div>
                        <div class="span5 responsive" style="margin-left: 200px;">
                            <input type="button" class="btn blue" value="查询" id="query">
                            <input type="button" class="btn red" value="重置" id="reset">
                        </div>
                    </div>
                 <!-- END FORM-->
                <div class="form-section"></div>
                <div style="overflow-x: hidden;">
                        <table id="resultList" class="table table-striped table-bordered table-hover" >
                            <thead>
                                <th>客户编号</th>
                                <th>客户姓名</th>
                                <th>证件号码</th>
                                <th>状态</th>
                                <th>操作</th>
                            </thead>
                        </table>
                </div>
                </form>   
            </div>
        </div>
    </div>
    </div>
</div>
<div id="createCustBaseDiv" class="modal hide fade" tabindex="-1" data-width="960" style="width:75%;position:absolute;left:560px;top:60px;"></div>
<div id="changeLogDiv" class="modal hide fade" tabindex="-1" data-width="960" style="width:62%;position:absolute;left:700px;top:60px;"></div>

<div id="test" class="modal hide fade" tabindex="-1" data-width="960" style="width:75%;position:absolute;left:560px;top:60px;"></div>
<!-- BEGIN PAGE L SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js"></script>
<script src="${baseUrl}/assets/js/custInfoChange/list.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/contents/file_show.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-wizard.js" type="text/javascript"></script>
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
 