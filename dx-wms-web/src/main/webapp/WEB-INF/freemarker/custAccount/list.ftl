<style>
	.edit-modal{
    	left: 31%;
		width: 80%;
		height:auto;
    }
    .mW1{
    	width:65px;
    }
</style>
<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="账户管理" home="理财管理" item={"账户管理":"/custAccountApply/list.htm"} />
    <@portlet title="账户管理" formId="accountForm">
	    <div class="row-fluid h50">
	    	<@div title="客户姓名">
	        	<@text id="custNameQuery"/>
	        </@div>
	        <@div title="证件号码">
	        	<@text id="idCardQuery"/>
	        </@div>
	    </div>
	    <div class="row-fluid h50">
	    	<@div title="开户日期（起）">
	        	<@date id="openDateBegin" name="openDateBegin" />
	        </@div>
	        <@div title="开户日期（止）">
		        <@date id="openDateEnd" name="openDateEnd" />
	        </@div>
	    </div>
	     <div class="row-fluid h50">
	        <@div title="移动电话" span="span7">
	        	<@text id="mobileQuery"/>
	        </@div>
	        <div class="span5 responsive">
	            <@query/>
	            <@create value="开户"/>
	            <@reset/>
	        </div>
	    </div>
	    <@datatable id="result" items=["客户编号","客户姓名","证件号码","移动电话","开户日期","状态","操作"] />
	</@portlet>
</div>
<div id="waitexper" tabindex="-1"  class="modal hide fade" style="width:300px;text-align:center;position:fixed;left:50%;top:50%;margin-left:width/2;margin-top:height/2">
	<div class="row-fluid">
        <div class="span12">
            <div class="portlet box blue" style="border-bottom: 0;">
            	<div class="portlet-title">
            		<div class="caption"><i class="icon-reorder">提示信息</i></div>
             	</div>
             	确认开户之前,请先上传完整文件<br/><br/><br/>
                <a href="javascript:;" class="btn blue button-submit" onclick="waitforexport();"><span>确定</span></a>
          	</div>
        </div>
     </div>
 </div>
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
<@modal id="editModal" name="edit-modal"/>
<@modal id="detailModal" name="edit-modal"/>
<link href="${baseUrl}/assets/css/cust_account/list.css" rel="stylesheet" type="text/css" />
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/flexpaper/js/flexpaper.js"></script>
<script src="${baseUrl}/assets/js/custAccount/list.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/contents/image_goto_change.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/contents/file_show.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/detail/detail.js" type="text/javascript"></script>  
<script src="${baseUrl}/assets/js/checkDate/checkDate.js" type="text/javascript"></script>  
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
 