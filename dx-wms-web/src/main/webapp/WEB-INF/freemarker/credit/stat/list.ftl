<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="债权统计" home="债权管理" item={"债权统计":"/credit/stat/list.htm"} />
    <@portlet title="债权统计" formId="queryForm">
	    <div class="row-fluid h50">
	    	<@div title="统计日期（起）">
	        	<@date id="createDateBegin" name="createDateBegin" />
	        </@div>
	        <@div title="统计日期（止）">
		        <@date id="createDateEnd" name="createDateEnd" />
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<div class="span7 responsive">
	    	</div>
	        <div class="span5 responsive">
	            <@query/><@reset/>
	        </div>
	    </div>
	    <div class="row-fluid" id="statBody"></div>
	    <@datatable id="result" items=["统计时间","1号端新增债权笔数","1号端新增债权总价值","16号端新增债权笔数","16号端新增债权总价值"] />
	</@portlet>
</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/credit/stat/list.js" type="text/javascript"></script>  
<script src="${baseUrl}/assets/js/reset/reset.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/credit/current/list.js" type="text/javascript"></script>  
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
 