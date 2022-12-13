<style>
	.control-group{
		height: 40px;
	}
	.form-horizontal .control-label {
		float: left;
		width: 160px;
		padding-top: 5px;
		text-align: right;
	}
	.form-horizontal .controls {
		margin-left: 180px;
	}
	select.m-wrap.small {
		width: 90px !important;
	}
	.m-wrap.medium {
		width: 180px !important;
	}
	.m-wrap.small {
		width: 50px !important;
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
<div class="container-fluid">
	<!-- BEGIN PAGE HEADER-->
	<@version.versionInfo />
	<div class="row-fluid">
		<div class="span12">
			<h3 class="page-title">
				理财管理
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
	<div class="clearfix"></div>
					<div class="row-fluid">
						<div class="span6">
							<!-- BEGIN PORTLET-->
							<div class="portlet box blue calendar">
								<div class="portlet-title">
									<div class="caption"><i class="icon-calendar"></i>日历</div>
								</div>
								<div class="portlet-body light-grey">
									<div id="calendar">
									</div>
								</div>
							</div>
							<!-- END PORTLET-->
						</div>
						<div class="span6">
							<!-- BEGIN PORTLET-->
							<div class="portlet">
								<div class="portlet-title line">
									<div class="caption"><i class="icon-comments"></i>公告栏</div>
									<div class="tools">
										<a href="" class="collapse"></a>
										<a href="#portlet-config" data-toggle="modal" class="config"></a>
										<a href="" class="reload"></a>
										<a href="" class="remove"></a>
									</div>
								</div>
								<div class="portlet-body" id="chats">
									<div class="scroller" data-height="435px" data-always-visible="1" data-rail-visible1="1">
										<ul class="chats">
											<li class="in">
												<img class="avatar" alt="" src="${baseUrl}/assets/image/login2_mini.jpg" />
												<div class="message">
													<span class="arrow"></span>
													<a href="#" class="name">信息技术中心</a>
													<span class="datetime"></span>
													<span class="body">
														<font size="4px">热烈庆祝达信财富核心业务系统上线</font>
													</span>
												</div>
											</li>
											
										</ul>
									</div>
									<!--<div class="chat-form">
										<div class="input-cont">   
											<input class="m-wrap" type="text" placeholder="在这里留下你的工作与生活脚印" />
										</div>
										<div class="btn-cont"> 
											<span class="arrow"></span>
											<a href="" class="btn blue icn-only"><i class="icon-ok icon-white"></i></a>
										</div>
									</div>-->
								</div>
							</div>

							<!-- END PORTLET-->

						</div>

					</div>
		
	<!-- END PAGE CONTENT-->         
</div>

<!-- END PAGE CONTAINER-->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script>
var base = "${baseUrl}"; 
var resBase = "${resRoot}";
</script>

<script src="${baseUrl}/assets/js/form-components.js"></script>
<script src="${baseUrl}/assets/js/app.js"></script>
<script src="${baseUrl}/assets/js/index.js" type="text/javascript"></script>

<!-- END PAGE LEVEL SCRIPTS -->
<script>
	function format_number(number) {
    return number< 10 ? '0' + number : number;
	}
	jQuery(document).ready(function() {       
		App.init();
		FormComponents.init();
		Index.init();
		Index.initCalendar();
		var myDate=new Date();
        $(".datetime").append(myDate.getFullYear()+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate()+" "+format_number(myDate.getHours())+":"+format_number(myDate.getMinutes())+":"+format_number(myDate.getSeconds()));
	});
</script>			
