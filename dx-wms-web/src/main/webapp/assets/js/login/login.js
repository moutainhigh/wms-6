
var Login = function () {
    return {
        //main function to initiate the module
        init: function () {
           $('.login-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            rules: {
	            	userName: {
	                    required: true
	                },
					pwd: {
	                    required: true
	                },
	                validateCode: {
	                	required: true
	                },
	                remember: {
	                    required: false
	                }
	            },

	            messages: {
	            	userName: {
	                    required: "请输入用户名"
	                },
	                validateCode: {
	                	required: "请输入验证码"
	                },
	                pwd: {
	                    required: "请输入密码"
	                }
	                
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   
	                $('.alert-error', $('.login-form')).show();
	            },

	            highlight: function (element) { // hightlight error inputs
	            	
	                $(element).closest('.control-group').addClass('error'); // set error class to the control group     
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
	            	form.submit();
	            }
	        });

	        $('.login-form input').keypress(function (e) {
	            if (e.which == 13) {
	            	var form = $('.login-form');
	                if ($('.login-form').validate().form()) {
		            	form.submit();
	                }
	                return false;
	            }
	        });

	        $('.forget-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",
	            rules: {
	                email: {
	                    required: true,
	                    email: true
	                }
	            },

	            messages: {
	                email: {
	                    required: "Email is required."
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   

	            },

	            highlight: function (element) { // hightlight error inputs
	            	
            			
	                $(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
	                window.location.href = "index.html";
	            }
	        });

	        $('.forget-form input').keypress(function (e) {
	            if (e.which == 13) {
	                if ($('.forget-form').validate().form()) {
	                    window.location.href = "index.html";
	                }
	                return false;
	            }
	        });

	        jQuery('#forget-password').click(function () {
	            jQuery('.login-form').hide();
	            jQuery('.forget-form').show();
	        });

	        jQuery('#back-btn').click(function () {
	            jQuery('.login-form').show();
	            jQuery('.forget-form').hide();
	        });

	        $('.register-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",
	            rules: {
	                username: {
	                    required: true
	                },
	                password: {
	                    required: true
	                },
	                rpassword: {
	                    equalTo: "#register_password"
	                },
	                email: {
	                    required: true,
	                    email: true
	                },
	                tnc: {
	                    required: true
	                }
	            },

	            messages: { // custom messages for radio buttons and checkboxes
	                tnc: {
	                    required: "Please accept TNC first."
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   

	            },

	            highlight: function (element) { // hightlight error inputs
	            	
	            	
	            	$(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	                
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                if (element.attr("name") == "tnc") { // insert checkbox errors after the container                  
	                    error.addClass('help-small no-left-padding').insertAfter($('#register_tnc_error'));
	                } else {
	                    error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	                }
	            },

	            submitHandler: function (form) {
	                window.location.href = "index.html";
	            }
	        });

	        jQuery('#register-btn').click(function () {
	            jQuery('.login-form').hide();
	            jQuery('.register-form').show();
	        });

	        jQuery('#register-back-btn').click(function () {
	            jQuery('.login-form').show();
	            jQuery('.register-form').hide();
	        });

	        //$.backstretch([
		        //"assets/image/bg/1.jpg",
		        //"assets/image/bg/2.jpg",
		        //"assets/image/bg/3.jpg",
		        //"assets/image/bg/4.jpg"
		        //], {
		        //  fade: 1000,
		        //  duration: 8000
		      //});
        }

    };

}();

$("#checkLogin").click(function(){
	$("#showMsg font").html("");
	if($("#validateCode").val()=="" || $("#validateCode").val()==null){
		document.getElementById("validateCode").focus();
	}
	if($("#password").val()=="" || $("#password").val()==null){
		document.getElementById("password").focus();
		
	}
	if($("#userName").val()=="" || $("#userName").val()==null ){
		document.getElementById("userName").focus();
		
	}
	
});

function checkValidateCode(){
	$("#validateCode").keyup(function(){
		var validate = $("#validateCode").val();
		if(validate.length!='4'){
			if(validate==""){
				$("#validateCodeSpan").removeClass("ok");
				$("#validateCodeSpan").removeClass("noTitle");
				$("#loginNote").hide();
				$("#validateCodeDraw").css("margin-left","10px");
				return;
			}
			$("#validateCode").css({"border-color": "#ccc","color": "#555"});
			$("#validateCodeSpan").removeClass("ok");
			$("#validateCodeSpan").removeClass("noTitle");
			$("#loginNote").text("");
			$("#loginNote").hide();
			$("#validateCodeDraw").css("margin-left","10px");
			$("#checkLogin").attr("disabled","disabled");
			$("#checkLogin").attr("title","请输入正确验证码");
			
			return;
		}
		
		$.ajax({
			url : base + '/user/checkValidate.json',// 请求url
			type : "POST",
			async : true,
			dataType : "json",
			contentType : "application/json",
			data : validate ,
			timeout : 30000,
			success : function(data) {
				if(data.length!=""){
					if(data.checkStatus=='0'){
						$("#validateCodeSpan").removeClass("noTitle");
						$("#validateCodeSpan").addClass("ok");
						$("#validateCodeSpan").css("color","#468847");
						$("#validateCode").css({"border-color": "#468847","color": "#468847"});
						$("#loginNote").text("");
						$("#loginNote").hide();
						$("#validateCodeDraw").css("margin-left","-10px");
						$("#validateCodeSpan").removeAttr("title");
						$("#checkLogin").removeAttr("disabled");
						$("#checkLogin").removeAttr("title");
					}else if(data.checkStatus=='1'){
						$("#validateCodeSpan").removeClass("ok");
						$("#validateCodeSpan").addClass("noTitle");
						$("#validateCodeSpan").css("color","#b94a48");
						$("#loginNote").text(data.checkInfo);
						$("#loginNote").css("color","#b94a48");
						$("#loginNote").show();
						$("#validateCode").css({"border-color": "#b94a48","color": "#b94a48"});
						$("#validateCodeDraw").css("margin-left","-6px");
						$("#validateCodeSpan").attr("title","点击删除");
						$("#checkLogin").attr("disabled","disabled");
						$("#checkLogin").attr("title","请输入正确验证码");
					}else{
						$("#validateCodeSpan").removeClass("ok");
						$("#validateCodeSpan").addClass("noTitle");
						$("#validateCodeSpan").css("color","#b94a48");
						$("#validateCodeSpan").attr("title","点击删除");
						$("#validateCode").css({"border-color": "#b94a48","color": "#b94a48"});
						$("#loginNote").text("");
						$("#loginNote").hide();
						$("#validateCodeDraw").css("margin-left","-6px");
						$("#checkLogin").attr("disabled","disabled");
						$("#checkLogin").attr("title","请输入正确验证码");
						
					}
				}
			},
			error : function(data) {
				$("#checkLogin").removeAttr("disabled");
			}
		});
		
	});
}

//$("#validateCode").keydown(function(){
//	var validate = $("#validateCode").val();
//	if(validate.length!='4'){
//		if(validate==""){
//			$("#validateCodeDiv").removeClass("success");
//			$("#validateCodeDiv").addClass("error");
//			$("#validateCodeSpan").removeClass("ok");
//			$("#validateCodeSpan").removeClass("noTitle");
//			$("#loginNote").show();
//			$("#loginNote").text("请输入验证码");
//			$("#validateCodeDraw").css("margin-left","20px");
//			return;
//		}
//
//		$("#validateCodeDiv").removeClass("error");
//		$("#validateCodeDiv").removeClass("success");
//		$("#validateCodeSpan").removeClass("ok");
//		$("#validateCodeSpan").removeClass("noTitle");
//		$("#loginNote").text("");
//		$("#loginNote").hide();
//		$("#validateCodeDraw").css("margin-left","20px");
//		return;
//	}
//	
//	$.ajax({
//		url : base + '/user/checkValidate.json',// 请求url
//		type : "POST",
//		async : true,
//		dataType : "json",
//		contentType : "application/json",
//		data : validate ,
//		timeout : 30000,
//		success : function(data) {
//			if(data.length!=""){
//				if(data.checkStatus=='0'){
//					$("#validateCodeDiv").removeClass("error");
//					$("#validateCodeDiv").addClass("success");
//					$("#validateCodeSpan").removeClass("noTitle");
//					$("#validateCodeSpan").addClass("ok");
//					$("#loginNote").text("");
//					$("#loginNote").hide();
//					$("#validateCodeDraw").css("margin-left","4px");
//					$("#validateCodeSpan").removeAttr("title");
//				}else if(data.checkStatus=='1'){
//					$("#validateCodeDiv").removeClass("success");
//					$("#validateCodeDiv").addClass("error");
//					$("#validateCodeSpan").removeClass("ok");
//					$("#validateCodeSpan").addClass("noTitle");
//					$("#loginNote").text(data.checkInfo);
//					$("#loginNote").show();
//					$("#validateCodeDraw").css("margin-left","8px");
//					$("#validateCodeSpan").attr("title","点击删除");
//				}else{
//					$("#validateCodeDiv").removeClass("success");
//					$("#validateCodeDiv").addClass("error");
//					$("#validateCodeSpan").removeClass("ok");
//					$("#validateCodeSpan").addClass("noTitle");
//					$("#loginNote").text("");
//					$("#loginNote").hide();
//					$("#validateCodeDraw").css("margin-left","8px");
//					$("#validateCodeSpan").attr("title","点击删除");
//					
//				}
//			}
//		},
//		error : function(data) {
//			
//		}
//	});
//	
//});

$(".noTitle").live("click",function(){
	$("#validateCode").val("");
	$("#validateCode").css({"border-color": "#ccc","color": "#555"});
	$("#loginNote").hide();
	$("#loginNote").text("");
	$("#validateCodeDraw").css("margin-left","10px");
	$("#validateCodeSpan").removeClass("noTitle");
	
});