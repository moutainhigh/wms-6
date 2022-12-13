<style>
.boder-right-scroll{
    width:100%;
    overflow-x:scroll;
}
.row-fluid{
    height: 50px;
}

.report-modal{
	left: 41%;
	width: 765px;
	height:auto;
	top: 1% !important;
	position:absolute;
}

</style>
<#include "/macro/base.ftl">

<div class="container-fluid">
    <!-- BEGIN PAGE HEADER-->
    <@head title="出资管理" home="理财管理" item={"出资管理":"/process/creditor.htm"} />
    <@portlet title="出资管理" formId="refundForm" formClass="form-horizontal" name="refundForm">
       <div class="row-fluid h50">
	    	<@div title="出借编号">
	        	<@text id="lenderCodeQuery" name="lenderCodeQuery"/>
	        </@div>
	        <@div title="客户姓名">
	        	<@text id="custNameQuery" name="custNameQuery"/>
	        </@div>
	    </div>
	     <div class="row-fluid h50">
	    	<@div title="出借金额">
	        	<@select source=amountArea id="lenderAmountQuery" name="lenderAmountQuery"/>
	        </@div>
	        <@div title="出借方式">
	        	<@select source=product id="loanWayQuery" name="loanWayQuery"/>
	     	</@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="账单日">
	        	<@select source=billDay id="bizBillDayQuery" name="bizBillDayQuery"/>
	     	</@div>
	        <@div title="状态">
	        	<@select source=currentStep id="currentStepQuery" name="currentStepQuery"/>
	        </@div>
	    </div>
       <div class="row-fluid h50">
	    	<@div title="匹配日期（起）">
	        	<@date id="signDateBegin" name="signDateBegin" />
	        </@div>
	        <@div title="匹配日期（止）">
		        <@date id="signDateEnd" name="signDateEnd" />
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<div class="span7 responsive"></div>
	    	<div class="span5 responsive">
		    	<@query/>
		        <@reset />
		        <@btn value="导出协议" color="blue" id="export"/>
	    	</div>
		</div>
		 <@datatable id="resultList" items=["checkbox","出借编号","客户姓名","证件号码","出借方式","出借金额(元)","签单日期","账单日","匹配日期","支付方式","状态","操作"] />
    </@portlet>
    
    <#--导出协议时提示框-->
	<div id="waitexper" tabindex="-1"  class="modal hide fade" style="width:300px;text-align:center;position:fixed;left:50%;top:50%;margin-left:width/2;margin-top:height/2"><div class="row-fluid">
	    <div class="span12">
	        <div class="portlet box blue" style="border-bottom: 0;">
	        	<div class="portlet-title">
	                <div class="caption"><i class="icon-reorder">提示信息</i></div>
	            </div>
	                                    正在生成PDF文件，请不要刷新页面，耐心等候<input type="hidden" id="downname" value=${downpathname}>
	        </div>
	    </div>
	</div>
</div>

<#--确认弹出层-->
<div id="createCustApplyDiv" class="modal hide fade" tabindex="-1" data-width="960" style="width:80%; margin-left: -520px; height:auto; overflow-y:auto;" > 
</div>
<#--重新匹配弹出层-->
<div id="returnMatchDiv" class="modal hide fade" tabindex="-1" data-width="960" style="min-width: 80%; margin-left: -520px;margin-top: -4%; height:auto;" > 
</div>

<#--预浏览弹出层-->
<div id="browserDiv" class="modal hide fade" tabindex="-1" data-width="960" style="width:80%; margin-left: -520px; height:auto; overflow-y:auto;" > 
</div>

<div id="createMatchDiv" class="modal hide fade" tabindex="-1" data-width="960" style="width:80%; margin-left: -520px; height:90%; overflow-y:scroll;" > 
             
</div>
<#--失败原因弹出层-->
<div id="failReasonDiv" class="modal hide fade" tabindex="-1" data-width="100%" style="height:auto;width:60%;margin-left:-28%;border-radius:0px;"> 
	<div id="reasonTitle"  style="border-radius:0px;width:auto;overflow-y:auto;height:auto;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="close" onclick="closed();"></button>
			<h3 id="myModalLabel3">出资失败</h3>
		</div>
		<div class="control-group" style="text-align:left;">
	    	<div class="responsive">
	            <label class="control-label" id="showFailReason" style="margin-left: 18px;line-height:25px;letter-spacing:1px;">
	          	 	未说明出资失败理由  
	            </label>
	        	
	        </div>
	    </div>
	    <div id="dealDetailDiv" class="hide">
		    <div class="modal-header">
		        <h3 id="myModalLabel3">交易明细</h3>
		    </div>
		    <div style="padding:15px;">
		        <table class="table table-striped table-bordered table-advance table-hover">
		            <thead>
		                <tr>
		                    <th>交易提交时间</th>
		                    <th>交易金额</th>
		                    <th>交易结果</th>
		                    <th>备注</th>
		                </tr>
		            </thead>
		            <tbody id="dealDetailList"></tbody>
		        </table>
		    </div>
		</div>
	</div>
    
    <div class="form-actions clearfix text-right bottom">
    	<input type="button" class="btn blue hide" value="展开交易明细" id="dealDetail">
        <input type="button" class="btn red" value="关闭" id="closed" onclick="closed()">
	</div>
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
<@modal id="reportModal" name="report-modal"/>
<div class="clearfix"></div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-wizard.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/flexpaper/js/flexpaper.js"></script>
<script src="${baseUrl}/assets/js/contents/image_goto_change.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/contents/file_show.js"></script>
<script src="${baseUrl}/assets/js/checkProcess/creditorConfirm.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
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