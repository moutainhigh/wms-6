<#include "/macro/base.ftl">
<div class="container-fluid">
    <@head title="账户管理" home="债权匹配" item={"账户管理":"/account/list.htm"} />
    <@portlet title="账户管理" formId="queryForm">
	    <div class="row-fluid h50">
	    	<@div title="客户姓名">
	        	<@text id="custName" name="custName" />
	        </@div>
	        <@div title="账户级别">
		        <@select source=accountLevel name="accountLevelId" id="accountLevelId"/>
	        </@div>
	    </div>        
	    <div class="row-fluid h50">
	    	<div class="span7 responsive">
	    	</div>
	        <div class="span5 responsive">
	            <@query/><@reset/><@btn value="导出" id="" name="excelReport" />
	        </div>
	    </div>
	    <@datatable id="resultList" items=["#","客户姓名","身份证","当前账户金额","投资数量","账户级别"] />
	</@portlet>
</div>

<div id="importData" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true">
	<form id="fileUploadForm">
		<input type="hidden" id="userId" name="userId" value="${userId}"/>
		<div class="modal-header">
			<h4 id="myModalLabel3">选择需要上传的数据文件</h4>
		</div>
		<div class="modal-body">
			<div class="controls">
				<div class="fileupload fileupload-new" data-provides="fileupload">
					<div class="input-append">
						<div class="uneditable-input">
							<i class="icon-file fileupload-exists"></i> <span
								class="fileupload-preview"></span>
						</div>
						<span class="btn btn-file"> 
							<span class="fileupload-new" id="file_choose">选择</span> 
							<span class="fileupload-exists" id="file_update">更改</span> 
							<input type="file" class="default" id="file" name="file" />
						</span> 
						<button class="btn blue" id="upload">上传</button>
						<div class="uneditable-input" id="upLoadImg" style="display: none; text-align: center; width: 23px; height: 23px; border: 0px">
							<img src="${baseUrl}/assets/image/upLoad.jpg" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true" id="file_close">关闭</button>
		</div>
	</form>
</div>
<!-- BEGIN PAGE L SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/account/list.js" type="text/javascript"></script> 
	
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
 