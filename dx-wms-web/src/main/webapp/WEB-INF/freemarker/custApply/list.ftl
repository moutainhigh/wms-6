<style>
    .row-fluid{
        height: 50px;
    }
    .edit-modal{
    	left: 31%;
		width: 80%;
		height:auto;
    }
	.account{
		left: 30%;
		width: 80%;
	}
	.selectModal{
    	left: 31%;
		width: 80%;
		height:auto;
    }
</style>
<#include "/macro/base.ftl">
<div class="container-fluid">
	<@head title="投资申请管理" home="理财管理" item={"投资申请管理":"/process/add.htm"} />
	<@portlet title="投资申请管理" formId="applyForm">
		<div class="row-fluid h50">
	        <@div title="出借编号">
	        	<@text id="lenderCodeQuery"/>
	        </@div>
	        <@div title="客户姓名">
	        	<@text id="custNameQuery"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	        <@div title="出借金额">
	        	<@select name="lenderAmountQuery" id="lenderAmountQuery" source=amountArea />
	        </@div>                            
	        <@div title="证件号码">
	        	<@text id="idCardQuery"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	        <@div title="出借方式">
	        	<@select name="loanWayQuery" id="loanWayQuery" source=product />
	        </@div>
	        <@div title="移动电话">
	        	<@text id="mobile"/>
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
	    	<div class="span7 responsive" ></div>
	    	<div class="span5 responsive">
	    		<@query/>
	    		<@create value="申请"/>
	    		<@reset/>
	        </div>
	    </div>
	    <@datatable id="resultList" items=["出借编号","客户姓名","证件号码","移动电话","签单日期","出借方式","出借金额(元)","支付方式","状态","操作"] />
	</@portlet>
</div>

<@modal id="editModal" name="edit-modal"/>
<@modal id="detailModal" name="detail-modal"/>
<div id="imgModal" class="modal hide fade" tabindex="-1" data-width="100%" style="width:80%;height:95%;z-index: 10051 !important;margin-left: -500px;">
	<div class="modal-header">
       	<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <font size="3.5">图片信息</font>
        <div id="imgChangeDiv" style="width:100%;"></div>
    </div>
	<div style="position:absolute;left:0px;top:50px;width:100%;height:90%">
		<div id="documentViewer" class="flexpaper_viewer" style="width:100%;height:100%"></div>
	</div>
</div>
<div class="clearfix"></div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-wizard.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/flexpaper/js/flexpaper.js"></script>
<script src="${baseUrl}/assets/js/custApply/list.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/contents/image_goto_change.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/contents/file_show.js"></script>
<script src="${baseUrl}/assets/js/detail/detail.js" type="text/javascript"></script>
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
 