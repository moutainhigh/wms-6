<style>
	.boder-right-scroll{
		width:100%;
		overflow-x:scroll;
	}
	.row-fluid{
		height: 50px;
	}
</style>
<div class="container-fluid">
			<!-- BEGIN PAGE HEADER-->
			<div class="row-fluid">
				<div class="span12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
						修改密码
					</h3>
					<ul class="breadcrumb">
						<li>
							<i class="icon-home"></i>
							<a href="${baseUrl}/index.htm">首页</a>
							<i class="icon-angle-right"></i>
						</li>
						<li>
							<a href="${baseUrl}/user/updatePassView.htm">修改密码</a>
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<div class="control-group">
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" style="height:27px;" type="password" placeholder="旧密码" name="oldPassword" id="oldPassword"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" style="height:27px;" type="password" placeholder="新密码" name="newPassword1" id="newPassword1"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" style="height:27px;" type="password" placeholder="确认新密码" name="newPassword2" id="newPassword2"/>
					</div>
				</div>
			</div>
			<div>
          		<button onclick="submitUpdate()" class="btn">修改</button>
       		</div>
		</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->	
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {       
		// initiate layout and plugins
		App.init();
		
	});
	function submitUpdate(){
		if($("#oldPassword").val()=="" || $("#oldPassword").val()==null){
			$.dopAlert("请输入旧密码!");
			return ;
		}
		if($("#newPassword1").val()=="" || $("#oldPassword").val()==null){
			$.dopAlert("新密码不能为空!");
			return ;
		}
		if($("#newPassword2").val()=="" || $("#newPassword2").val()==null){
			$.dopAlert("确认新密码不能为空!");
			return ;
		}
		if($("#newPassword1").val() != $("#newPassword2").val()){
			$.dopAlert("输入的新密码与确认新密码不一致！");
			return ;
		}
		$.ajax({
		url : 'updatePassWord.json?oldPassword='+$("#oldPassword").val()+"&newPassword1="+$("#newPassword1").val()+"&newPassword2="+$("#newPassword2").val(),// 请求url
		type : "POST",
		async : false,
		dataType : "json",
		contentType : "application/json",
		timeout : 30000,
		success : function(data) {
			if (data) {
				$.dopAlert('修改成功！');
				jQuery.dopAlert.destoryAlert = function() {
					$('#dop_alert_Modal').modal('hide');
					window.location.href="${baseUrl}/user/loginout.do";
				};				
			}else{
				$.dopAlert("旧密码不正确！");
			}
			
		},
		error: function(data){
			$.dopAlert("生成出现异常,请重试!");
		}
	});
	}
</script>
<!-- END PAGE LEVEL SCRIPTS -->
