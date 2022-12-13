<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="每日匹配统计" home="投资管理" item={"每日匹配统计":"/invest/stat/list.htm"} />
    <@portlet title="每日匹配统计" formId="statForm">
	    <div class="row-fluid h50">
	    	<@div title="统计日期（起）">
	        	<@date id="initMatchDateBegin" name="createDateBegin" />
	        </@div>
	        <@div title="统计日期（止）">
		        <@date id="initMatchDateEnd" name="initMatchDateEnd" />
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<div class="span7 responsive">
	    	</div>
	        <div class="span5 responsive">
	            <@query/>
	        </div>
	    </div>
	    <@datatable id="result" items=["统计日期","1号端匹配笔数","1号端匹配金额","16号端匹配笔数","16号端匹配金额"] />
	</@portlet>
</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/invest/stat/list.js" type="text/javascript"></script>  
<!-- END PAGE LEVEL SCRIPTS -->
<script>
	var base = "${baseUrl}";
	var resBase = "${resRoot}";
    (function($) {
        $(function() {
            App.init();
            FormComponents.init();
        });
    })(jQuery);    
</script>
 