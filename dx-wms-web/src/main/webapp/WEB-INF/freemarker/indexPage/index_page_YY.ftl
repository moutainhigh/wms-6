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
					<i class="icon-home"></i>
						<a href="index.htm">首页</a> 
					</li>
			</ul>
		</div>
	</div>
	<!-- END PAGE HEADER-->
	<!-- BEGIN PAGE CONTENT-->
		<div class="tiles">
			<div class="tile double-down bg-blue">
				<div class="tile-body">
					<i class="icon-bell"></i>
				</div>
				<div class="tile-object">
				<div class="name">

								Notifications

							</div>

							<div class="number">

								6

							</div>

						</div>

					</div>

					<div class="tile bg-green">

						<div class="tile-body">

							<i class="icon-calendar"></i>

						</div>

						<div class="tile-object">

							<div class="name">

								Meetings

							</div>

							<div class="number">

								12

							</div>

						</div>

					</div>

					<div class="tile double selected bg-blue">

						<div class="corner"></div>

						<div class="check"></div>

						<div class="tile-body">

							<h4>support@metronic.com</h4>

							<p>Re: Metronic v1.2 - Project Update!</p>

							<p>24 March 2013 12.30PM confirmed for the project plan update meeting...</p>

						</div>

						<div class="tile-object">

							<div class="name">

								<i class="icon-envelope"></i>

							</div>

							<div class="number">

								14

							</div>

						</div>

					</div>

					<div class="tile selected bg-red">

						<div class="corner"></div>

						<div class="tile-body">

							<i class="icon-user"></i>

						</div>

						<div class="tile-object">

							<div class="name">

								Members

							</div>

							<div class="number">

								452

							</div>

						</div>

					</div>

					<div class="tile double bg-purple">

						<div class="tile-body">

							<img src="${baseUrl}/assets/image/photo1.jpg" alt="">

							<h3>Announements</h3>

							<p>

								Easily style icon color, size, shadow, and anything that's possible with CSS.

							</p>

						</div>

						<div class="tile-object">

							<div class="name">

								Bob Nilson

							</div>

							<div class="number">

								24 Jan 2013

							</div>

						</div>

					</div>

					<div class="tile bg-yellow">

						<div class="tile-body">

							<i class="icon-shopping-cart"></i>

						</div>

						<div class="tile-object">

							<div class="name">

								Orders

							</div>

							<div class="number">

								121

							</div>

						</div>

					</div>

					<div class="tile image selected">

						<div class="tile-body">

							<img src="${baseUrl}/assets/image/image2.jpg" alt="">

						</div>

						<div class="tile-object">

							<div class="name">

								Media

							</div>

						</div>

					</div>

					<div class="tile bg-green">

						<div class="tile-body">

							<i class="icon-comments-alt"></i>

						</div>

						<div class="tile-object">

							<div class="name">

								Feedback

							</div>

							<div class="number">

								12

							</div>

						</div>

					</div>

					<div class="tile double bg-grey">

						<div class="tile-body">

							<img src="${baseUrl}/assets/image/photo2.jpg" alt="" class="pull-right">

							<h3>@lisa_wong</h3>

							<p>

								I really love this theme. I look forward to check the next release!

							</p>

						</div>

						<div class="tile-object">

							<div class="name">

								<i class="icon-twitter"></i>

							</div>

							<div class="number">

								10:45PM, 23 Jan

							</div>

						</div>

					</div>

					<div class="tile bg-blue">

						<div class="tile-body">

							<i class="icon-coffee"></i>

						</div>

						<div class="tile-object">

							<div class="name">

								Meetups

							</div>

							<div class="number">

								12 Jan

							</div>

						</div>

					</div>

					<div class="tile bg-green">

						<div class="tile-body">

							<i class="icon-bar-chart"></i>

						</div>

						<div class="tile-object">

							<div class="name">

								Reports

							</div>

							<div class="number">

							</div>

						</div>

					</div>

					<div class="tile bg-purple">

						<div class="tile-body">

							<i class="icon-briefcase"></i>

						</div>

						<div class="tile-object">

							<div class="name">

								Documents

							</div>

							<div class="number">

								124

							</div>

						</div>

					</div>

					<div class="tile image double selected">

						<div class="tile-body">

							<img src="${baseUrl}/assets/image/image4.jpg" alt="">

						</div>

						<div class="tile-object">

							<div class="name">

								Gallery

							</div>

							<div class="number">

								124

							</div>

						</div>

					</div>

					<div class="tile bg-yellow selected">

						<div class="corner"></div>

						<div class="check"></div>

						<div class="tile-body">

							<i class="icon-cogs"></i>

						</div>

						<div class="tile-object">

							<div class="name">

								Settings

							</div>

						</div>

					</div>

					<div class="tile bg-purple">

						<div class="tile-body">

							<i class="icon-plane"></i>

						</div>

						<div class="tile-object">

							<div class="name">

								Projects

							</div>

							<div class="number">

								34

							</div>

						</div>

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


<!-- END PAGE LEVEL SCRIPTS -->
<script>
	jQuery(document).ready(function() {
		App.init();
		FormComponents.init();
	});
</script>			
