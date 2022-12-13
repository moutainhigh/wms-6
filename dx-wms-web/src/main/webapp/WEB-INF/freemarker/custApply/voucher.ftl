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
<div class="container-fluid">
	<div class="top"/>
		<div class="portlet box blue" id="form_wizard_1" >
			<div class="portlet-title">
				<div class="caption"><i class="icon-reorder"></i>上传支付凭证</div>
				<div class="caption" id="remit">
					<i class="icon-reorder"></i>(债权确认--汇款)
				</div>
				<div class="caption" id="directDraw">
	                <i class="icon-reorder"></i> (债权确认--直接划扣)
	            </div>
			</div>
			<div class="portlet-body">
	   			<form class="form-horizontal" id="${formId}">
	        		<div id="">
                		<!-- 文件上传处 -->  
                    	<input type="hidden" id="payWayName" name="payWayName" value="${payWayName}" >
                    	
                    	<!--终端号划扣-->
                    	<div class="row-fluid" id="directDrawDiv">
                    		<div class="span6 responsive">
                                <label class="control-label">终端号：<span class="required">*</span></label>
                                <div class="controls">
                                    <input type="text" disabled="disabled" class="span8  m-wrap" name="terminalCode" id="terminalCode" value="">
                                    <span class="help-inline"></span>
                                </div>
                            </div>
                            <div class="span6 responsive"  style="margin-left: -50px;">
                                <label class="control-label">划扣时间：<span class="required">*</span></label>
                                <div class="controls">
                                    <input class="span8 m-wrap m-ctrl-medium date-picker tradeTime" readonly="" size="16" value="" name="tradeTime" id="tradeTime" data-date-format="yyyy-mm-dd" type="text">	            
                                </div>
                            </div>
						</div>
                    	<h4 class="form-section">
                                                                支付凭证 &nbsp;&nbsp;&nbsp;&nbsp;
                        </h4>
                    	<!-- 某用户理财序号 -->
                		<div class="form-wizard" >
                        	<div class="tab-content" style="overflow:auto;height:180px;;margin-top:5%">
                            	
                                <div class="control-group" id="vFolder" style="text-align:center;height:auto;display:none">
                                    <!-- 影像资料文件夹 -->                
                                </div>
                                <br ><h4 class="form-section" style="display:none"></h4> 
                                <div class="control-group" id="vFile" style="text-align:center;height:auto;white-space:nowrap;">
                                    <!-- 影像资料文件 -->
                                </div>
                     	 	</div>
                    	</div>
                	</div>	
	        	</form>
	        	<div class="form-actions clearfix">
	        		<a href="javascript:;" class="btn red" onclick="doCloseDiv()" style="float: right; margin-right: 20px;">关闭</a>
					<a href="javascript:;" class="btn blue" onclick="doSubmitPaymentVouchers()" style="float: right; margin-right: 5px;">提交</a>
		        </div>   
	    	</div> 
	    	
        </div>
        
        <@fileInfo.voucherFile>
        <!-- 资源标示 wmsCustOpenApply wmsCustLenderApply  wmsLenderCheck-->
                    	<input type="hidden" id="resKey" name="resKey" value="wmsPaymentVouchers" >
                    	<!-- 系统 编码-->
                    	<input type="hidden" id="appCode" name="appCode" value="wms" >
                    	<!-- 当前查看文件的目录 -->
                    	<input type="hidden" id="currentFileDir" name="currentFileDir" value="9" >
                    	<!-- 上传文件 -->
                    	<input type="hidden" id="cmAction" name="cmAction" value="uploadFile" >
                    	<!-- 用户编号  -->
                    	<input type="hidden" id="userUniqueId" name="userUniqueId" value="${lenderApply.custAccountId}" >
                    	<input type="hidden" id="lenderCustCode" name="lenderCustCode" value="${lenderApply.lenderCustCode}" >
                    	<!-- 某用户理财序号 -->
                    	<input type="hidden" id="lenderUniqueId" name="lenderUniqueId" value="${lenderApply.lenderApplyId}" >
                    	<input type="hidden" id="lenderCode" name="lenderCode" value="${lenderApply.lenderCode}" >
        </@fileInfo.voucherFile>  
    </div>
    <!-- END PAGE CONTENT-->         
</div>


<!-- END PAGE CONTAINER-->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script>
var base = "${baseUrl}"; 
var resBase = "${resRoot}";
</script>
<script src="${baseUrl}/assets/js/custApply/voucher.js" type="text/javascript"></script> 
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
 