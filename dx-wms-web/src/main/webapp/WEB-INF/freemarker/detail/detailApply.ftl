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
                    <a href="${baseUrl}/custApply/list.htm">投资申请管理</a>
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
                                    <div class="control-group" id="account" style="text-align:center;height:auto;">
                                        <!-- 客户信息-->                
                                    </div>
                                </div>
                                <div class="tab-pane" id="tab_1_2">
                                    <div class="control-group" id="applyDiv" style="text-align:center;height:auto;">
                                        <!-- 投资信息-->                
                                    </div>
                                </div>
                                <div class="tab-pane" id="tab_1_3">
                                <h4 class="form-section">影像信息</h4>
                                    <div class="control-group" id="applyVideoInfo" style="text-align:center;height:auto;">
                                        <!-- 影像信息 --> 
                                    </div>
                                </div>          
                        </div>
                    </form>
                        
                     <div class="form-actions clearfix">
                        <a href="javascript:;" class="btn red button-submit" onclick="closePage()">
                                                        关闭 
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- BEGIN     PAGE LEVEL SCRIPTS -->
<script>
var base = "${baseUrl}"; 
var resBase = "${resRoot}";
</script>
<script src="${baseUrl}/assets/js/detail/detailApply.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
    (function($) {
        $(function() {
          //  App.init();
          //  FormComponents.init();
        });
    })(jQuery);
</script>               