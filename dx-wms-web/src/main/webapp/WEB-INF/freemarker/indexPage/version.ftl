<#macro versionInfo>
<style>
.close2 {
    color: #000;
    float: right;
    font-size: 21px;
    font-weight: 700;
    line-height: 1;
    opacity: 0.2;
    text-shadow: 0 1px 0 #fff;
    background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
    border: 0 none;
    cursor: pointer;
    padding: 0;
    margin-top: 2px;
}
</style>
<a href="#" data-toggle="modal"  data-target="#ver" id="v1" style="display:none">版本公告</a>
<!-- 模态框（Modal） -->
	<div class="modal fade" id="ver" tabindex="-1" role="dialog" aria-labelledby="ver2" aria-hidden="true" style="display:none">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close2"
							data-dismiss="modal" aria-hidden="true">
							&times;
					</button>
					<h4 class="modal-title" id="ver2">
						<center><b>公司简介</b></center>
					</h4>
				</div>
				<div class="modal-body">
				<#if versionId == 1>
					<#import "login/version_notice1.ftl" as versionnotice/>
					<@versionnotice.versionNotice/>
				</#if>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
<script>
	jQuery(document).ready(function() {       
		var verSts = ${versionStatus};
		if(eval(verSts)==eval(1)){
			 $("#v1")[0].click();
		}
	});
</script>	
</#macro>