<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div id="portlet-config" class="modal hide">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button"></button>
					<h3>Widget Settings</h3>
				</div>
				<div class="modal-body">
					Widget settings form goes here
				</div>
			</div>
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							我的任务
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="${baseUrl}/index.htm">首页</a>
							</li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div id="dashboard">
					<!-- BEGIN DASHBOARD STATS -->
					<div class="row-fluid">
						<#if tasks?exists>
						<#list tasks as task>
							<div class="span3 responsive" data-tablet="span6" data-desktop="span3">
							<div class="dashboard-stat 
							<#if task_index==0>
							blue
							</#if>
							<#if task_index==1>
							green
							</#if>
							<#if task_index==2>
							yellow
							</#if>
							<#if task_index==3>
							red
							</#if>
							">
								<div class="visual">
									<i class="icon-comments"></i>
								</div>
								<div class="details">
									<div class="number">
										${task.taskNum}
									</div>
									<div class="desc">                           
										${task.taskName}
									</div>
								</div>
								<a class="more" href="${baseUrl}${task.taskUrl}">
								更多 <i class="m-icon-swapright m-icon-white"></i>
								</a>                 
							</div>
						</div>
						</#list>
						</#if>
					</div>
					<!-- END DASHBOARD STATS -->
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
													<span class="datetime">2015-3-28 11:09</span>
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

				</div>

			</div>

			<!-- END PAGE CONTAINER-->   

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>

	<script src="${baseUrl}/assets/js/index.js" type="text/javascript"></script>        

	<!-- END PAGE LEVEL SCRIPTS -->  

	<script>

		jQuery(document).ready(function() {    

		   App.init(); // initlayout and core plugins

		   Index.init();

		   Index.initCalendar(); // init index page's custom scripts

		   Index.initChat();

		});

	</script>

	<!-- END JAVASCRIPTS -->

<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script></body>
		