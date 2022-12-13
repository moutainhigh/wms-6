<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="理财信息管理" home="理财管理" item={"理财信息管理":"/wealthManagementInfo/list.htm"} />
	<@portlet title="理财信息管理" formId="accountForm">
		<div class="row-fluid h50">
			<@div title="出借编号">
	        	<@text id="lenderCodeQuery"/>
	        </@div>
	        <@div title="客户姓名">
	        	<@text id="custNameQuery"/>
	        </@div>
		</div>
		<div class="row-fluid h50">
			<@div title="出借方式">
				<@select name="loanWayQuery" id="loanWayQuery" source=product />
	        </@div>
	        <@div title="出借金额">
	        	<@select name="lenderAmountQuery" id="lenderAmountQuery" source=amountArea />
	        </@div>
		</div>
		<div class="row-fluid h50">
			<@div title="证件号码">
				<@text id="idCardQuery"/>
	        </@div>
	        <@div title="状态">
	        	<@mSelect name="currentStepQuery" id="currentStepQuery" source=currentStep array=["10","17","18","14","15","13","11","12","10","20","21","22","23","19"]/>
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
		<@datatable id="resultList" items=["出借编号","客户姓名","证件号码","移动电话","出借方式","出借金额(元)","签单日期","生效时间","到期时间","账单日","状态","操作"] />
	</@portlet>
</div>
<@modal id="detailModal" name="detail-modal"/>
<div id="imgModal" class="modal hide fade" tabindex="-1" data-width="100%" style="width:800px;height:500px">
	<div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
       <font size="3.5">图片信息</font>
       <div id="imgChangeDiv"></div>
   	</div>
	<div style="position:absolute;left:0px;top:50px;">
		<div id="documentViewer" class="flexpaper_viewer" style="width:800px;height:500px"></div>
	</div>
</div>
<div id="failReasonDiv" class="modal hide fade" tabindex="-1" data-width="100%" style="height:auto;width:60%;margin-left:-28%;border-radius:0px;"> 
	<div id="reasonTitle"  style="border-radius:0px;width:auto;overflow-y:auto;height:auto;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="close" onclick="closed();"></button>
			<h3 id="myModalLabel3">失败原因</h3>
		</div>
		<div class="control-group" style="text-align:left;">
	    	<div class="responsive">
	            <label class="control-label" id="showFailReason" style="margin-left: 18px;line-height:25px;letter-spacing:1px;">
	          	 	未说明支付失败理由  
	            </label>
	        </div>
	    </div>
	    <div class="modal-footer">
            <button  class="btn" type='button' class='btn mini close red' data-dismiss="modal">关闭</button>
        </div>
	</div>
<div class="clearfix"></div>
<!-- BEGIN PAGE L SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js"></script>
<script src="${baseUrl}/assets/flexpaper/js/flexpaper.js"></script>
<script src="${baseUrl}/assets/js/contents/image_goto_change.js"></script>
<script src="${baseUrl}/assets/js/contents/file_show.js"></script>
<script src="${baseUrl}/assets/js/wealthManagementInfo/manager_list.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/detail/detail.js" type="text/javascript"></script>  
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
		
  
				 
												
					
                    		
                    	
                      
                               	   


