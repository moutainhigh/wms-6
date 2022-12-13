<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>财富投资管理平台</title>
	<link href="${baseUrl}/assets/css/credit.css" rel="stylesheet" type="text/css"/>
	<link href="${baseUrl}/assets/css/viewer.css" rel="stylesheet" type="text/css"/>
	<link href="${baseUrl}/assets/css/login-soft.css" rel="stylesheet" type="text/css"/>
	<link href="${baseUrl}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<#assign dxf=JspTaglibs["http://it.dx.com/dxf"]>
<div class="all">
  <div class="top">
    <div class="logo"></div>
  </div>
  <div class="form">
    <div class="form_group">
      <form class="form-vertical login-form" action="${baseUrl}/user/validate.do" method="post">
      <@dxf.noRepeatSubmit formName="loginForm"/>
        <div class="form_txt">财富投资管理平台</div>
        <div id="showMsg" style="height:35px;line-height:50px;">
			<font color="red">${promptMsg}</font>
		</div>
		<div class="control-group">
			<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
			<label class="control-label visible-ie8 visible-ie9"></label>
			<div class="controls">
				<div class="input-icon left">
					<i class="icon-user" style="margin-left: 20px;"></i>
					<input class="m-wrap placeholder-no-fix" type="text" style="height:27px;" placeholder="用户名" name="userName"/ >
				</div>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<div class="input-icon left">
					<i class="icon-lock" style="margin-left: 20px;"></i>
					<input class="m-wrap placeholder-no-fix" style="height:27px;" type="password" placeholder="密码" name="pwd"/>
				</div>
			</div>
		</div>
		
        <div class="input2"><label class="checkbox">
				<input type="checkbox" name="remember" value="1"/>记住密码
				</label></div>
        <div class="input">
          <button type="submit" class="check">登  录</button>
        </div>
      </form>
    </div>
  </div>
  <div class="foot">
    <div class="foot_txt">财富投资管理平台</div>
  </div>
  <div class="info"><span>达信财富投资管理(上海)有限公司©2015 CreditCrest.cn, Inc</span><br>
    <span>上海市浦东新区花园石桥路33号花旗大厦803室</span></div>
</div>
</body>

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
</html>
