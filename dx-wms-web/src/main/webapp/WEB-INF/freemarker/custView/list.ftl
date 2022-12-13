<#include "/macro/base.ftl">
<div class="container-fluid">
	<@head title="客户关系管理" home="客户关系管理" item={"客户360视图管理":"/custView/list.htm"} />
    <@portlet title="客户360视图管理" formId="viewForm">
	    <div class="row-fluid h50">
	    	<@div title="客户姓名">
	        	<@text id="custName"/>
	        </@div>
	        <@div title="证件号码">
	        	<@text id="idCard"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="注册日期（起）">
	        	<@date id="registerTimeBegin" name="registerTimeBegin" />
	        </@div>
	        <@div title="注册日期（止）">
	        	<@date id="registerTimeEnd" name="registerTimeEnd" />
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	        <@div title="移动电话" span="span7">
	        	<@text id="mobile"/>
	     	</@div>
	        <div class="span5 responsive">
	            <@query/>
	            <@create/>
	            <@reset/>
	        </div>
	    </div>
	    <@datatable id="result" items=["客户姓名","证件类型","证件号码","移动电话","性别","客户来源","注册日期","操作"] />
	</@portlet>	            
</div>
<@modal id="editModal" name="edit-modal"/>
<link href="${baseUrl}/assets/css/cust_view/list.css" rel="stylesheet" type="text/css" />
<!-- BEGIN PAGE L SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js"></script>
<script src="${baseUrl}/assets/js/form-components.js"></script>
<script type="text/javascript" src="${baseUrl}/assets/js/custView/list.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
	var base = "${baseUrl}";
    (function($) {
        $(function() {
            App.init();
            FormComponents.init();
        });
    })(jQuery);    
</script>
 