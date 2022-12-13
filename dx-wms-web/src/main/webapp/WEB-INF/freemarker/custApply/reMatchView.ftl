<style>
    .control-group{
        height: 60px;
    }
    .control-group{
        height: 60px;
    }
</style>

<!-- BEGIN PAGE CONTAINER-->
<!-- BEGIN PAGE CONTENT-->
<#import "hr/entry/fileInfo.ftl" as fileInfo>
<div class="container-fluid" >
    <input type="hidden" id="lenderApplyId" value="${lenderApply.lenderApplyId}">
    <input type="hidden" id="lenderCode" value="${lenderApply.lenderCode}">
	<div class="top"/>
		<div class="portlet box blue" id="form_wizard_1" >
			<div class="portlet-title">
				<div class="caption"><i class="icon-reorder"></i>重新匹配</div>
			</div>
	    	<div class="portlet-body">
	    		<div class="form-wizard" >
	            	<div class="tab-content" style="overflow:auto;height:150px;margin-top:4%">
	                    <div class="control-group" id="vFile" style="text-align:center;height:auto;white-space:nowrap;">
	                        <!-- 影像资料文件 -->
	                    </div>
	         	 	</div>
	        	</div>
             	<div id="list" >
					<#include "/custApply/matchList.ftl">			
				</div>
				<div class="form-actions clearfix text-right bottom">
				    <a href="javascript:;" class="btn blue" onclick="reMatchUI()">提交</a>
			        <a href="javascript:;" class="btn red" onclick="doCloseDiv()">关闭</a>
			    </div>
				<@fileInfo.reMatch>
	            	<!-- 资源标示 wmsCustOpenApply wmsCustLenderApply  wmsLenderCheck-->
			        <input type="hidden" id="resKey" name="resKey" value="wmsRefuseReceipt" >
			        <!-- 系统 编码-->
			        <input type="hidden" id="appCode" name="appCode" value="wms" >
			        <!-- 当前查看文件的目录 -->
			        <input type="hidden" id="currentFileDir" name="currentFileDir" value="10" >
			        <!-- 上传文件 -->
			        <input type="hidden" id="cmAction" name="cmAction" value="uploadFile" >
			        <!-- 用户编号  -->
			        <input type="hidden" id="userUniqueId" name="userUniqueId" value="${lenderApply.custAccountId}" >
			        <input type="hidden" id="lenderCustCode" name="lenderCustCode" value="${lenderApply.lenderCustCode}" >
			        <!-- 某用户理财序号 -->
			        <input type="hidden" id="lenderUniqueId" name="lenderUniqueId" value="${lenderApply.lenderApplyId}" >
			        <input type="hidden" id="lenderCode" name="lenderCode" value="${lenderApply.lenderCode}" >
	            </@fileInfo.reMatch>
	    	</div>
        </div>
    </div>
    <!-- END PAGE CONTENT-->         
</div>


<!-- END PAGE CONTAINER-->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script>
var base = "${baseUrl}"; 
var resBase = "${resRoot}";
</script>
<script src="${baseUrl}/assets/js/custApply/reMatchView.js" type="text/javascript"></script> 
<!-- END PAGE LEVEL SCRIPTS -->
<script>
    (function($) {
        $(function() {
        	//App.init();
            //FormWizard.init();
            FormComponents.init();
			uploadFiles("upload");
        });
    })(jQuery);
    
</script>
 