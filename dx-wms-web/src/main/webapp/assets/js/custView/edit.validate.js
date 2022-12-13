$(function(){ 
	var form = $('#submit_form');
	var error = $('.alert-error', form);
	var success = $('.alert-success', form);
	jQuery.validator.addMethod("checkCustName", function(value, element) {
		if (value != '') {
			var reg = /^[\u4E00-\u9FA5]+$/;
			if (reg.test(value)) {
				return true;
			}
		}
		return false;
	}, "请输入姓名，且必须为汉字.");
	jQuery.validator.addMethod("checkCustSourceOther", function(value, element) {
		if ($(".custSource").val() == 20) {
			if (value != '') {
				var reg = /^[\u4E00-\u9FA5]+$/;
				if (reg.test(value)) {
					return true;
				}
			}
			return false;
		}
		return true;
	}, "请输入其他客户来源，且必须为汉字.");
	jQuery.validator.addMethod("checkMobile", function(value, element) {
		if (value != '') {
			// 手机号
			var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
			if (reg.test(value)) {
				return true;
			}
		}
		return false;
	}, "请输入正确的移动电话.");
	// 证件类型
	jQuery.validator.addMethod("checkSelect", function(value, element) {
		if (value == '-1') {
			return false;
		}
		return true;
	}, "请选择至少一项.");

	// 身份证号码验证
	jQuery.validator.addMethod("checkIdCard",function(value, element) {
		if ($(".idType").val() == 1) {
			var idCard = $(".idCard").val();		
			var reg_18 = /^[1-9][0-7]\d{4}((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))\d{3}(\d|X)?$/;
			var reg_15 = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9]|[1|2]\d)|3[0-1])\d{3}$/;
			if (reg_15.test(idCard)) {
				return true;
			} 
			if (reg_18.test(idCard)) {
				var Y, JYM;
				var S, M;
				var idcard_array = new Array();
				idcard_array = idCard.split("");
				if(idcard_array.length==17){
					return false;
				}
				// 计算校验位
				var S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
					  + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
					  + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
					  + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
					  + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
					  + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
					  + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
					  + parseInt(idcard_array[7]) * 1 + parseInt(idcard_array[8]) * 6 + parseInt(idcard_array[9]) * 3;
				Y = S % 11;
				M = "F";
				JYM = "10X98765432";
				M = JYM.substr(Y, 1);
				/* 判断校验位 */
				if (M == idcard_array[17].toUpperCase()) {
					return true;
					/* 检测ID的校验位false; */
				} else {
					return false;
				}
			}
			return false;			
		} 
		if ($(".idType").val() == 2) {
			var rex = /^((G\d{8})|(P\.?\d{7})|((S\.?\d{7}))|((14|15)\d{7})|(E\d{8}))$/;
			if (rex.test(value)) {
				return true
			}
			return false;
		} 
		if ($(".idType").val() == 3) {
			var reg = /^[\u4E00-\u9FA5]+$/;
			if (value == '') {
				return false;
			}
			for (var i = 0; i < value.length; i++) {
				if (reg.test(value[i])) {
					return false;
				}
			}
			return true;
		}
		if ($(".idType").val() == 4) {
			var rex = /^[HM]{1}\d{10}$/;
			if (rex.test(value)) {
				return true
			}
			return false;
		}
		
		return false;
	}, "请输入正确的证件号.");
	form.validate({
		doNotHideMessage : true, 
		errorElement : 'span',
		errorClass : 'validate-inline', 
		focusInvalid : false, 
		rules : {
			custName : {
				checkCustName : true
			},
			mobile : {
				checkMobile : true,
				remote: {
					url: base + "/common/check_mobile.json",
					async:false,
					data:{
						custId: function(){ return $("#custId").val()},
						mobile: function(){ return $(".mobile").val()}
					}
				}
			},
			idCard : {
				checkIdCard : true,
				remote: {
					url: base + "/common/check_id_card.json",
					async:false,
					data:{
						custId: function(){ return $("#custId").val()},
						idCard: function(){ return $(".idCard").val()}
					}
				}
			},
			custSource : {
				checkSelect : true
			},
			custSourceOther : {
				checkCustSourceOther : true
			}
		},
		messages : { 
			mobile : {
				remote: "移动电话已存在."
			},
			idCard : {
				remote: "证件号已存在."
			}
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element); 
		},
		invalidHandler : function(event, validator) { 
			success.hide();
			error.show();
		},
		highlight : function(element) { 
			$(element).closest('.help-inline').removeClass('ok'); 
			$(element).closest('.responsive').removeClass('success').addClass('error'); 
		},
		unhighlight : function(element) {
			$(element).closest('.responsive').removeClass('error'); 
		},
		success : function(label) {
			label.addClass('valid ok').closest('.responsive').removeClass('error').addClass('success'); 
		}
	});
	
});