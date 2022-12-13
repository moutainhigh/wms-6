<style>
.control-group{
    height: 40px;
}
.form-horizontal .control-label {
    float: left;
    width: 160px;
    padding-top: 5px;
    text-align: right;
}
.form-horizontal .controls {
    margin-left: 180px;
}
.form-section{
    text-align:left;
 }
</style>
<!-- BEGIN PAGE CONTAINER-->
<div class="container-fluid">
    <!-- BEGIN PAGE CONTENT-->
    <div class="row-fluid">
        <div class="span12">
            <!-- BEGIN PAGE TITLE & BREADCRUMB-->
            <h3 class="page-title">理财申请</h3>
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i> 理财管理<i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="${baseUrl}/wealthManagementInfo/list.htm">理财信息管理</a>
                </li> 
                <li>
                    <i class="icon-angle-right"></i>理财申请
                </li>
            </ul>
            <!-- END PAGE TITLE & BREADCRUMB-->
            <div class="portlet box blue tabbable">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-reorder"></i> 理财申请
                    </div>
                </div>
                <div class="portlet-body">
                    <form action="#" class="form-horizontal" id="submit_form">
                        <!-- one step-->
                        <input type="hidden" name="custAccountId" id="custAccountId" value="${custAccountId}">
                        <input type="hidden" name="lenderApplyId" id="lenderApplyId" value="${lenderApplyId}">
                        <input type="hidden" name="lenderCode" id="lenderCode" value="${lenderCode}">

                        <!--BEGIN TABS-->
                        <div class="tabbable portlet-tabs">
                            <ul class="nav nav-tabs">
                                <li><a href="#tab_1_3" data-toggle="tab" >影像信息</a></li>
                                <li><a href="#tab_1_2" data-toggle="tab" >投资信息</a></li>
                                <li class="active"><a href="#tab_1_1" data-toggle="tab">账户信息</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="tab_1_1">
                                <h4 class="form-section">个人信息</h4>
                                    <div class="control-group" id="applyPersonInfo" style="text-align:center;height:auto;">
                                        <!-- 申请单信息  -->                
                                    </div>
                                </div>
                                
                                <div class="tab-pane" id="tab_1_2">
                                    <div class="control-group" id="applyInfo" style="text-align:center;height:auto;">
                                        <!-- 投资信息 --> 
                                    </div>
                                </div>
                                
                                <div class="tab-pane" id="tab_1_3">
                                	<h4 class="form-section">影像信息</h4>
                                    <div class="control-group" id="applyVideoInfo" style="text-align:center;height:auto;">
                                        <!-- 影像信息 --> 
                                    </div>    
                                </div>          
	                         	<div class="form-actions clearfix">
	                            <a href="javascript:;" class="btn red" onclick="doCloseDiv()">
	                                                                关闭 
	                            </a>
                            </div>
                        </div>  
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script>
var base = "${baseUrl}"; 
var resBase = "${resRoot}";
</script>
<script src="${baseUrl}/assets/js/app.js"></script>
<script src="${baseUrl}/assets/js/form-components.js"></script>
<script src="${baseUrl}/assets/js/lenderApplyDetail/detail.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
    jQuery(document).ready(function() {       
       
    });
    
</script>               