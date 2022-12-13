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
			<@div title="营业部">
				<@select name="orgIdQuery" id="orgIdQuery" source=department />
	        </@div>
	        <@div title="状态">
	        	<@mSelect name="currentStepQuery" id="currentStepQuery" source=currentStep array=["10","17","18","14","15","13","11","12","10","20","21","22","23","19"]/>
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
			<@div title="移动电话" span="span7">
				<@text id="mobileQuery"/>
	        </@div>
            <div class="span5 responsive">
                <@query/>
   				<@reset/>
				<@btn value="导出" id="" name="excelReport" />
          	</div>
       	</div>
		<@datatable id="resultList" items=["出借编号","客户姓名","证件号码","出借方式","出借金额(元)","签单日期","生效时间","到期时间","账单日","营业部","大团","团队","客户经理","状态","操作"] />
	</@portlet>
</div>
<@modal id="createWealthManagementInfoExeDiv" name="detail-modal"/>
<div class="modal fade" id="logModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:65%;margin-left:-32%"></div>
<!-- BEGIN PAGE L SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js"></script>
<script src="${baseUrl}/assets/js/wealthManagementInfo/executive_list.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/log/log.js" type="text/javascript"></script> 
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