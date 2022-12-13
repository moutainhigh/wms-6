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
.top{
	height: 20px;
}
.body{
	max-height: 350px;
    overflow-y: auto;
}
.right{
	text-align: right;
}
</style>
<!-- BEGIN PAGE CONTAINER-->
<div class="container-fluid">
    <!-- BEGIN PAGE CONTENT-->
    <div class="row-fluid">
        <div class="span12">
        	<div class="top"></div>
            <!-- END PAGE TITLE & BREADCRUMB-->
            <div class="portlet box blue tabbable">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-reorder"></i> 开户申请
                    </div>
                </div>
                <div class="portlet-body">
                    <form action="#" class="form-horizontal" id="submit_form">
                        <input type="hidden" name="custAccountId" id="custAccountId" value="${custAccountId}">
                        <!--BEGIN TABS-->
                        <div class="tabbable portlet-tabs">
                            <ul class="nav nav-tabs">
                                <li><a href="#tab_1_2" data-toggle="tab" >影像信息</a></li>
                                <li class="active"><a href="#tab_1_1" data-toggle="tab">开户信息</a></li>
                            </ul>
                            <div class="tab-content body">
                            	<div class="tab-pane active" id="tab_1_1">
                                	<div class="control-group">
                                        <#include "detail/account.ftl">               
                                    </div>
                                </div>
                                <div class="tab-pane" id="tab_1_2">
                                	<div class="control-group" id="applyVideoInfo"></div>
                                </div>          
                            </div>
                        </div>
                    </form>
                </div>
                <div class="form-actions clearfix right">
                	<button type='button' data-dismiss='modal' class='btn'>关闭</button>
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
<script src="${baseUrl}/assets/js/detail/detail.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
    jQuery(document).ready(function() {   
      // FormComponents.init();
    });
    
</script>               