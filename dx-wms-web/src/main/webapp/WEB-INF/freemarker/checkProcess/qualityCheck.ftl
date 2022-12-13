<style>
.boder-right-scroll{
    width:100%;
    overflow-x:scroll;
}
.row-fluid{
    height: 50px;
}
</style>
<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="业务明细质检" home="理财管理" item={"业务明细质检 ":"/process/quality.htm?biz=quality"} />
    <@portlet title="业务明细质检" formId="refundForm" formClass="form-horizontal" name="refundForm">
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
	    	<@div title="签单日期（起）">
	        	<@date id="signDateBegin" name="signDateBegin" />
	        </@div>
	        <@div title="签单日期（止）">
		        <@date id="signDateEnd" name="signDateEnd" />
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<div class="span7 responsive"></div>
	    	<div class="span5 responsive">
		    	<@query/>
		        <@reset/>
	    	</div>
	    </div>
	    <@datatable id="resultList" items=["出借编号","客户姓名","证件号码","出借方式","出借金额(元)","签单日期","支付方式","操作"] />
    </@portlet>
</div>
<div id="detailModal" class="modal hide fade detail-modal in" tabindex="-1" data-width="960"></div>

 <div id="failReasonDiv" class="modal hide fade" tabindex="-1" data-width="100%" style="min-width:610px;min-height:165px;" margin-left: 160px;> 
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="close"></button>
		<h3 id="myModalLabel3"> 出资失败</h3>
	</div>
	<div class="control-group" style="text-align:left;">
    	<div class="span6 responsive">
            <label class="control-label" id="showFailReason">未说明出资失败理由</label>
        </div>
    </div>
    <p>&nbsp;</p>
    <div class="control-group" style="text-align:right;margin-right: 20px;">
    	<input type="button" class="btn blue" value="交易明细" id="dealDetail" onclick="dealDetail()">
        <input type="button" class="btn red" value="关闭" id="closed" onclick="closed()">
	</div>
</div>

<div id="dealDetailDiv" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h3 id="myModalLabel3">交易明细</h3>
    </div>
    <div class="modal-body">
        <table class="table table-hover">
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
    <div class="modal-footer">
        <button class="btn red" data-dismiss="modal" aria-hidden="true">关闭 </button>
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
<div class="clearfix"></div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script>
var base = "${baseUrl}";
var role = "${role}"
</script>
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js"></script>
<script src="${baseUrl}/assets/js/form-wizard.js"></script>
<script src="${baseUrl}/assets/js/contents/file_show.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/flexpaper/js/flexpaper.js"></script>
<script src="${baseUrl}/assets/js/contents/image_goto_change.js"></script>
<script src="${baseUrl}/assets/js/checkProcess/qualityCheck.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->

<script>
    (function($) {
        $(function() {
            App.init();
            FormComponents.init();
        });
    })(jQuery);
    
</script>