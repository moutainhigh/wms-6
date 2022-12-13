<html>
<head>
<title>登录界面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="${baseUrl}/assets/css/credit.css?12" rel="stylesheet" type="text/css"/>
	<link href="${baseUrl}/assets/css/viewer.css" rel="stylesheet" type="text/css"/>
	<link href="${baseUrl}/assets/css/login-soft.css" rel="stylesheet" type="text/css"/>
    <link href="${baseUrl}/assets/css/login.css" rel="stylesheet" type="text/css"/>
	<link href="${baseUrl}/assets/css/font-awesome.min.css?121" rel="stylesheet" type="text/css"/>
	<link href="${baseUrl}/assets/css/main.css" type="text/css" rel="stylesheet">
	<link href="${baseUrl}/assets/css/lrtk.css" rel="stylesheet" type="text/css" />
	<link href="${baseUrl}/assets/css/bootstrap.min2.css" rel="stylesheet" />
	<script src="${baseUrl}/assets/js/login/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="${baseUrl}/assets/js/login/bootstrap.min.js"></script>
    <script src="${baseUrl}/assets/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
	<script src="${baseUrl}/assets/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
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
	<style>
		.help-inline {
	        color: rgb(185, 74, 72);
	     }
	    .help-inline.ok::before {
	        content: "\f00c";
	        display: inline-block;
	        font-family: FontAwesome;
	        font-size: 16px;
	        font-style: normal;
	        font-weight: normal;
	
	    }
	    .help-inline.noTitle::before{
		    content: "\f00d";
	        display: inline-block;
	        font-family: FontAwesome;
	        font-size: 16px;
	        font-style: normal;
	        font-weight: normal;
	        cursor: pointer;
	    }
	    .no-left-padding{
		    margin-left:28px;
	    }
	    #ver,#help{
	    	overflow:hidden;
	    } 
	    .modal-body{
	    	overflow-y:auto;
	    	height:450px;
	    }
		</style>
</head>
<body style="overflow-y:hidden">
    <#assign dxf=JspTaglibs["http://it.dx.com/dxf"]>
	<div class="logo">
		<img src="${baseUrl}/assets/image/bg/logo.png">
	</div>
	<div class="help">
		<img src="${baseUrl}/assets/image/i.png" align="bottom"><a href="#" data-toggle="modal"  data-target="#ver">公司简介</a>
		<img src="${baseUrl}/assets/image/w.png" align="bottom"><a href="#" data-toggle="modal"  data-target="#help">企业文化</a>
	</div>
	<div class="entering">
	    <form class="form-vertical login-form" action="${baseUrl}/user/validate.do" method="post">
		<@dxf.noRepeatSubmit formName="loginForm"/>
        <div class="title" style="margin-left:30px">财富投资管理系统</div>
        <div id="showMsg" style="height:5px;line-height:30px;">
			<font color="red" style="margin-left:32px">${promptMsg}</font>
		</div>
		<div class="control-group"  style="height: 69px;">
		    <div class="input-icon left">
		        <div class="item" style="margin-top: 7%">
			        <img src="${baseUrl}/assets/image/r.png">
			        <input type="text" required="required" tabindex="1" placeholder="请输入您的用户名" id="userName" name="userName" value="${userName}"/>
		        </div>
		    </div>
		</div>
		<div class="control-group"  style="height: 69px;">
            <div class="input-icon left">
		        <div class="item">
			        <img src="${baseUrl}/assets/image/s.png">
			        <input type="password" required="required" tabindex="1" placeholder="请输入您的密码" id="password" name="pwd" value="${password}"/>
		        </div>
		    </div>
        </div>	
        <!-- 验证码
		<div class="control-group" id="validateCodeDiv"  style="height: 69px;">
             <div class="input-icon left">
		         <div class="item2">
			         <img src="${baseUrl}/assets/image/m.png">
			         <input class="m-wrap placeholder-no-fix" type="text" required="required" tabindex="1" placeholder="验证码" name="validateCode" id="validateCode"
						onpaste="return false" maxlength="4"></input>
                     <span class="help-inline" id="validateCodeSpan" style="position: relative; right: 25px; padding: 0px 0px 0px 1px;" color:"#b94a48";></span>
			         <img src="${baseUrl}/user/validateCode.do" 
						onclick="this.src='${baseUrl}/user/validateCode.do?'+Math.random();" title="点击切换" class="input3" id="validateCodeDraw"
						style="cursor:pointer;margin-left:10px;margin-top:-2px"/>
		          </div>
             </div>
		</div>
		-->
		<lable class="help-inline help-small no-left-padding" class="loginNote" id="loginNote" style="display:none;margin-left:-28px"></lable>
	
		<div class="input">
			<button class="jt-btn" type="submit" id="checkLogin" style="margin:9px -32px 0px -33px;width:210px">登&nbsp;&nbsp;录</button>
		</div>
			<input type="text" name="versionId" style="display:none" value="1" />
        </form>
	</div>
	<div class="foot-txt" style="bottom:53px">
		<p>达信财富投资管理(上海)有限公司©2015 CreditCrest.cn, Inc</p>
		<p>上海市浦东新区花园石桥路33号花旗大厦803室</p>
	</div>
	<section id="h1" class="jawbone-takeover-minimulti jawbone-hero"><i class="jawbone-hero-image" data-hero-image-fixed="true" data-hero-image-fade="true" data-hero-min-opacity=".3" style="opacity: 1.05;"></i></section>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="ver" tabindex="-1" role="dialog" aria-labelledby="ver2" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close"
							data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="ver2">
						  <center><b>公司简介</b></center>
					</h4>
				</div>
				<div class="modal-body">
					<#import "login/version_notice1.ftl" as versionnotice/>
					<@versionnotice.versionNotice/>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	<div class="modal fade" id="help" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close"
							data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						<center><b>企业文化</b></center>
					</h4>
				</div>
				<div class="modal-body">
					<#import "login/version_notice2.ftl" as versionhelp/>
					<@versionhelp.versionHelp/>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
</body>
	<script>
		var base = "${baseUrl}";
		
		jQuery(document).ready(function() {    
		  	
		  App.init();
		  Login.init();
		  var promptMsg = "${promptMsg}";//用于验证码输入框focus事件
		  if( promptMsg=="您输入的验证码超时!"
				|| promptMsg=="您输入的验证码不正确!"){
			  document.getElementById("validateCode").focus();
		  }
		  checkValidateCode();
		});
	</script>
</html>