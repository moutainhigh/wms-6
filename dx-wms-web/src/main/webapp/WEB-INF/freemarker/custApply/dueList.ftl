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
    <@head title="投资到期管理" home="理财管理" item={"投资到期管理":"/process/due.htm"} />
    <@portlet title="投资到期管理" formId="refundForm" formClass="form-horizontal" name="refundForm">
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
	        <@div title="移动电话">
	        	<@text id="mobile" name="mobile"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="出借方式">
	        	<@select source=product id="loanWayQuery" name="loanWayQuery"/>
	        </@div>
	        <@div title="证件号码">
	        	<@text id="idCardQuery" name="idCardQuery"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="生效时间（起）">
	        	<@date id="settlementDateBegin" name="settlementDateBegin" />
	        </@div>
	        <@div title="生效时间（止）">
		        <@date id="settlementDateEnd" name="settlementDateEnd" />
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<div class="span7 responsive"></div>
	    	<div class="span5 responsive">
		    	<@query/>
		        <@reset/>
	    	</div>
	    </div>
	    <@datatable id="resultList" items=["出借编号","客户姓名","证件号码","移动电话","生效时间","到期时间","出借方式","出借金额(元)","支付方式","状态","操作"] />
    </@portlet>
</div>
<div id="createCustApplyDiv" class="modal hide fade" tabindex="-1" data-width="960" style="width:80%; left: 31%; height:auto;" > 
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
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-wizard.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/contents/file_show.js"></script>
<script src="${baseUrl}/assets/flexpaper/js/flexpaper.js"></script>
<script src="${baseUrl}/assets/js/custApply/dueList.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/contents/image_goto_change.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>var base = "${baseUrl}"</script>
<script>var resBase = "${resRoot}"</script>
<script>
    (function($) {
        $(function() {
            App.init();
            FormComponents.init();
        });
    })(jQuery);
    
</script>
 