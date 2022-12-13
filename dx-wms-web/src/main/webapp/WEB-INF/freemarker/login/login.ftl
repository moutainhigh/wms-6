<!DOCTYPE html>
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>财富投资管理平台</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="${baseUrl}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="${baseUrl}/assets/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="${baseUrl}/assets/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="${baseUrl}/assets/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="${baseUrl}/assets/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="${baseUrl}/assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="${baseUrl}/assets/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="${baseUrl}/assets/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link href="${baseUrl}/assets/css/login-soft.css" rel="stylesheet" type="text/css"/>
	<!-- END PAGE LEVEL STYLES -->
	<link rel="shortcut icon" href="${baseUrl}/assets/image/logos.jpg" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
	<!-- BEGIN LOGO -->
	<!--<div class="logo">
		<img src="${baseUrl}/assets/image/logo-big.png" alt="" /> 
	</div>-->
	<!-- END LOGO -->
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="form-vertical login-form" action="${baseUrl}/user/validate.do" method="post">
			<h3 class="form-title">财富投资管理平台</h3>
			<div id="showMsg">
				<font color="red">${promptMsg}</font>
			</div>
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">登陆名</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="用户名" name="userName"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" type="password" placeholder="密码" name="pwd"/>
					</div>
				</div>
			</div>
			<div class="form-actions">
				<label class="checkbox">
				<input type="checkbox" name="remember" value="1"/>记住密码
				</label>
				<button type="submit" class="btn blue pull-right">
				登陆<i class="m-icon-swapright m-icon-white"></i>
				</button>            
			</div>
			<!--<div class="forget-password">
				<h4>忘记密码?</h4>
				<p>
					<a href="javascript:;" id="forget-password" style="color:rgb(200,200,200)">点击这里</a>找回密码
				</p>
			</div>-->
			<div class="create-account">
				<p>
				</p>
			</div>
		</form>
		<!-- END LOGIN FORM -->        
		<!-- BEGIN FORGOT PASSWORD FORM -->
		<!--<form class="form-vertical forget-form" action="${baseUrl}/index.htm">
			<h3 class="">忘记密码?</h3>
			<p>输入您的电子邮件地址找回密码.</p>
			<div class="control-group">
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-envelope"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="Email" name="email" />
					</div>
				</div>
			</div>
			<div class="form-actions">
				<button type="button" id="back-btn" class="btn">
				<i class="m-icon-swapleft"></i> Back
				</button>
				<button type="submit" class="btn blue pull-right">
				Submit <i class="m-icon-swapright m-icon-white"></i>
				</button>            
			</div>
		</form>-->
		<!-- END FORGOT PASSWORD FORM -->
		<!-- BEGIN REGISTRATION FORM -->
		<form class="form-vertical register-form" action="${base}/user/validate.do">
			<h3 class="">Sign Up</h3>
			<p>Enter your account details below:</p>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Username</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="Username" name="username"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Password</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" type="password" id="register_password" placeholder="Password" name="password"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Re-type Your Password</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-ok"></i>
						<input class="m-wrap placeholder-no-fix" type="password" placeholder="Re-type Your Password" name="rpassword"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">Email</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-envelope"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="Email" name="email"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<label class="checkbox">
					<input type="checkbox" name="tnc"/> I agree to the <a href="#">Terms of Service</a> and <a href="#">Privacy Policy</a>
					</label>  
					<div id="register_tnc_error"></div>
				</div>
			</div>
			<div class="form-actions">
				<button id="register-back-btn" type="button" class="btn">
				<i class="m-icon-swapleft"></i>  Back
				</button>
				<button type="submit" id="register-submit-btn" class="btn blue pull-right">
				Sign Up <i class="m-icon-swapright m-icon-white"></i>
				</button>            
			</div>
		</form>
		<!-- END REGISTRATION FORM -->
	</div>
	<!-- END LOGIN -->
	<!-- BEGIN COPYRIGHT -->
	<div class="copyright" style="font-size:16px; color:#888888">
		达信财富投资管理(上海)有限公司
	</div>
	<!-- END COPYRIGHT -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<script src="${baseUrl}/assets/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="${baseUrl}/assets/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="${baseUrl}/assets/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="${baseUrl}/assets/js/bootstrap.min.js" type="text/javascript"></script>
	<!--[if lt IE 9]>
	<script src="${baseUrl}/assets/js/excanvas.min.js"></script>
	<script src="${baseUrl}/assets/js/respond.min.js"></script>  
	<![endif]-->   
	<script src="${baseUrl}/assets/js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="${baseUrl}/assets/js/jquery.blockui.min.js" type="text/javascript"></script>  
	<script src="${baseUrl}/assets/js/jquery.cookie.min.js" type="text/javascript"></script>
	<script src="${baseUrl}/assets/js/jquery.uniform.min.js" type="text/javascript" ></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="${baseUrl}/assets/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${baseUrl}/assets/js/jquery.backstretch.min.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
	<script src="${baseUrl}/assets/js/login/login.js" type="text/javascript"></script>     
	<!-- END PAGE LEVEL SCRIPTS --> 
	<script>
		jQuery(document).ready(function() {     
		  App.init();
		  Login.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
<!-- END BODY -->
</html>