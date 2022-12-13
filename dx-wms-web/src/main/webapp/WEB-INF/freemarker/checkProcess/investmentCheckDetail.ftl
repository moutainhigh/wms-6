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
.span6.responsive.right{
		margin-left: -50px;
}
</style>
<!-- BEGIN PAGE CONTAINER-->
<div class="container-fluid">
    <!-- BEGIN PAGE CONTENT-->
    <div class="row-fluid">
        <div class="span12">
            <!-- BEGIN PAGE TITLE & BREADCRUMB-->
            <br>
            <div class="portlet box blue tabbable">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-reorder"></i> 投资审核
                    </div>
                </div>
                <div class="portlet-body">
                    <form action="#" class="form-horizontal" id="submit_form">
                        <!-- one step-->
                        <input type="hidden" name="custAccountId" id="custAccountId" value="${custAccountApplyVo.custAccount.custAccountId}">
                        <input type="hidden" name="lenderApplyId" id="lenderApplyId" value="${custAccountApplyVo.lenderApply.lenderApplyId}">
                        <input type="hidden" name="lenderCode" id="lenderCode" value="${custAccountApplyVo.lenderApply.lenderCode}">
                        <input type="hidden" name="lenderCustCode" id="lenderCustCode" value="${custAccountApplyVo.lenderApply.lenderCustCode}">
                        
                        <!--BEGIN TABS-->
                        <div class="tabbable portlet-tabs">
                            <ul class="nav nav-tabs">
                            	<li><a href="#tab_1_4" data-toggle="tab" >审批记录 </a></li>
                                <li><a href="#tab_1_3" data-toggle="tab" >影像信息</a></li>
                                <li><a href="#tab_1_2" data-toggle="tab" >投资信息</a></li>
                                <li class="active"><a href="#tab_1_1" data-toggle="tab">账户信息</a></li>
                            </ul>
                            <div class="tab-content h350-y">
                                <div class="tab-pane active" id="tab_1_1">
                                    <div class="control-group" id="applyPersonInfo">
                                        <!-- 申请单信息  -->                
                                    </div>
                                </div>
                                
                                <div class="tab-pane" id="tab_1_2">
                                    <div class="control-group" id="applyInfo">
                                        <!-- 投资信息 --> 
                                    </div>
                                </div>
                                
                                <div class="tab-pane" id="tab_1_3">
                                    <div class="control-group" id="applyVideoInfo">
                                        <!-- 影像信息 --> 
                                    </div>     
                                </div> 
                                
                                <div class="tab-pane" id="tab_1_4">
                                    <div class="control-group" id="approveInfo">
                                        <!-- 影像信息 --> 
                                    </div>     
                                </div>               
                        </div>  
                    </form>
                </div>
                <div class="form-actions clearfix txt-right bottom">
	                <a href="javascript:;" id="close_tab" class="btn red button-submit" onclick="doCloseTab('createCustApplyDiv')">关闭 </a>
	     			<a href="javascript:;" id="submit_tab" class="btn blue button-submit" onclick="doSubmitTab('1','createCustApplyDiv',this)">提交运营</a>
					<a href="javascript:;" id="refuse_tab" class="btn blue button-submit" onclick="doSubmitTab('2','createCustApplyDiv',this)"> 拒绝  </a>	
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
<link href="${baseUrl}/assets/css/detail/detail.css" rel="stylesheet" type="text/css" /> 
<script src="${baseUrl}/assets/js/checkProcess/checkDetail.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->