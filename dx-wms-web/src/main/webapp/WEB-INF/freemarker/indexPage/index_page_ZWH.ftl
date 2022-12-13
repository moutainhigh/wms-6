<style>
	.tile {
	    border: 4px solid transparent;
	    color: #ffffff;
	    cursor: pointer;
	    display: block;
	    float: left;
	    font-size: 12px;
	    font-weight: 300;
	    height: 200px;//此处可设置单模块高度
	    letter-spacing: 0.02em;
	    line-height: 20px;
	    margin: 0 10px 10px 0;
	    overflow: hidden;
	    position: relative;
	    text-decoration: none; 
	    width: 22.3% !important;
	}
	.tile.double-down {
    	height: 418px !important;
	}
	.tile .tile-object > .name {
	    bottom: 0;
	    color: #ffffff;
	    font-size: 18px;
	    font-weight: 400;
	    left: 0;
	    margin-bottom: 5px;
	    margin-left: 10px;
	    margin-right: 15px;
	    position: absolute;
	}
.btn-default{
    border-radius: 4px;
}
.modal-content{
    border-radius: 9px;
}	
.dropdown-menu{
    overflow: auto; 
    width: auto; 
    max-height: 400px;
}
</style>
<!-- BEGIN PAGE CONTAINER-->	
<#import "indexPage/version.ftl" as version>
<@version.versionInfo />

										
<div class="container-fluid">
	<!-- BEGIN PAGE HEADER-->
	<div class="row-fluid">
		<div class="span12">
			<h3 class="page-title">
				首页
			</h3>
			<ul class="breadcrumb">
				<li>
					<span>理财管理</span>
					<span class="icon-angle-right"></span>
				</li>
				<li>
					<i class="icon-home"></i>
					<a href="${baseUrl}/index.htm">首页</a>
				</li>
			</ul>
		</div>
	</div>
	<!-- END PAGE HEADER-->
	<!-- BEGIN PAGE CONTENT-->
	<div class="row-fluid">
		<div class="span12">
			<div class="portlet box blue" id="form_wizard_1">
				<div class="portlet-title">
					<div class="caption">
						<i class="icon-reorder"></i> 首页
					</div>
				</div>
				<div class="portlet-body form">
					<input type="hidden" id="currentUser" name="currentUser" value="${currentUser}" />
					<div class="portlet-body" style="height:430px;">
						<div class="tiles">
							<div class="tile double-down bg-red" id="effectiveApplyNum">
								<div class="tile-body">
									<div style="text-align:center;vertical-align:middle;line-height:360px;">
										<font color="white" size="10" id="theFirstValue" >${theFirstValue}</font>
									</div>
								</div>
								<div class="tile-object">
									<div class="name">
										生效投资数
									</div>
									<div class="number"></div>
								</div>
							</div>
							
							<div class="tile bg-yellow" id="refusedApplyNum">
								<div class="tile-body">
									<div style="text-align:center;vertical-align:middle;line-height:160px;">
										<font color="white" size="10" id="theSecondValue" >${theSecondValue}</font>
									</div>
								</div>
								<div class="tile-object">
									<div class="name">
										被拒绝申请单数
									</div>
									<div class="number"></div>
								</div>
							</div>
							
							<div class="tile bg-green" id="pendingCheckApplyNum">
								<div class="tile-body">
									<div style="text-align:center;vertical-align:middle;line-height:160px;">
										<font color="white" size="10" id="theThirdValue" >${theThirdValue}</font>
									</div>
								</div>
								<div class="tile-object">
									<div class="name">
										待投资审核申请单数
									</div>
									<div class="number"></div>
								</div>
							</div>
							
							<div class="tile bg-blue" id="">
								<div class="tile-body" style="vertical-align:top;">
									<h4>人员迁移</h4>
								</div>
								<div class="tile-object">
								</div>
							</div>

							<div class="tile double bg-grey" style="width:46.3% !important" id="sumLenderAmount">
								<div class="tile-body">
									<div style="text-align:center;vertical-align:middle;line-height:160px;">
										<font color="white" size="10" id="theFifthValue" >${theFifthValue}</font>
									</div>
								</div>
								<div class="tile-object">
									<div class="name">
										已申请投资总额
									</div>
									<div class="number"></div>
								</div>
							</div>		

							<div class="tile bg-purple" id="">
								<div class="tile-body">
									<h4>（待续）</h4>
								</div>
								<div class="tile-object">
									<div class="name"></div>
									<div class="number"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END PAGE CONTENT-->         
<div id="openUploads" class="modal hide fade" tabindex="-1" data-width="506" style="width:65%">
	<div class="modal-body">	
		<div class="controls">
			<div id="site_activities_loading_big">
				<img src="${resRoot}/image/loading.gif" alt="loading" />
			</div>
			<div id="site_activities_content_big" class="hide"  style="height: 160px; padding: 0px;">
				<div id="site_activities_big" style="height:160px;"></div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true" id="file_close">关闭 </button>
	</div>
</div>
</div>




<!-- END PAGE CONTAINER-->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script>
var base = "${baseUrl}"; 
var resBase = "${resRoot}";
var checkRes = "${theForthValue}";
var lenderRes = "${theSixthValue}";
</script>
<script src="${baseUrl}/assets/js/indexPage/index_page_ZWH.js"></script>

<script src="${baseUrl}/assets/js/jquery.flot.js"></script>
<script src="${baseUrl}/assets/js/jquery.flot.resize.js"></script>
<script src="${baseUrl}/assets/js/jquery.flot.pie.js"></script>
<script src="${baseUrl}/assets/js/jquery.flot.stack.js"></script>
<script src="${baseUrl}/assets/js/jquery.flot.crosshair.js"></script>

<script src="${baseUrl}/assets/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/jquery.blockui.min.js" type="text/javascript"></script>  
<script src="${baseUrl}/assets/js/jquery.cookie.min.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/jquery.uniform.min.js" type="text/javascript" ></script>
<script src="${baseUrl}/assets/js/charts.js"></script> 

<script src="${baseUrl}/assets/js/app.js"></script>




<!-- END PAGE LEVEL SCRIPTS -->
<script>
	jQuery(document).ready(function() {
		App.init();
		Charts.init();
		Charts.initCharts();
		Charts.initPieCharts();
	});
</script>		




