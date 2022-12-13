$(function(){ 
	var form = $('#submit_form');
	var error = $('.alert-error', form);
	var success = $('.alert-success', form);
	jQuery.validator.addMethod("checkProBasicSalary", function(value, element) {
		if (value) {
			var reg = /^[1-9]\d*$/;
			if (!reg.test(value)) {
				return false;
			}
			return true;
		}
		return false;
	}, "输入的工资有误");
	jQuery.validator.addMethod("checkPerfSalary", function(value, element) {
		if (value) {
			var reg = /^\+?(0|[1-9][0-9]*)$/;
			if (!reg.test(value)) {
				return false;
			}
			return true;
		}
		return false;
	}, "输入的绩效工资有误");
	jQuery.validator.addMethod("checkPlannedEntryDate", function(value, element) {
		if (value=='') {
			return false;
		}
		return true;
	}, "请输入日期");
	jQuery.validator.addMethod("checkCustName", function(value, element) {
		if (value != '') {
			var reg = /^[\u4E00-\u9FA5]+$/;
			if (reg.test(value)) {
				return true;
			}
			return false;
		}
	}, "姓名不能为空，且必须为汉字.");
	
	jQuery.validator.addMethod("checkSelect", function(value, element) {
		if (value == '-1') {
			return false;
		}
		return true;
	}, "请选择至少一项.");
	jQuery.validator.addMethod("checkLevelId", function(value, element) {
		if($(".isLevel").val()){
			return true;
		}
		if (value == '-1') {
			return false;
		}
		return true;
	}, "请选择至少一项.");
	// 身份证号码验证
	jQuery.validator.addMethod("checkIdCard",function(value, element) {
		if ($(".certType").val() == 1) {
			var idCard = $(".certNo").val();
			var Y, JYM;
			var S, M;
			var idcard_array = new Array();
			idcard_array = idCard.split("");
			var reg_18 = /^[1-9][0-7]\d{4}((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))\d{3}(\d|X)?$/;
			var reg_15 = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9]|[1|2]\d)|3[0-1])\d{3}$/;
			if (reg_15.test(idCard)) {
				return true;
			} else if (reg_18.test(idCard)) {
				// 计算校验位
				var S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
					  + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
					  + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
					  + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
					  + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
					  + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
					  + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
					  + parseInt(idcard_array[7]) * 1
					  + parseInt(idcard_array[8]) * 6
					  + parseInt(idcard_array[9]) * 3;
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
			} else {
				return false;
			}
		} else if ($(".certType").val() == 2) {
			var rex = /^((G\d{8})|(P\.?\d{7})|((S\.?\d{7})|(S\d{8}))|((14|15)\d{7})|(E\d{8}))$/;
			if (rex.test(value)) {
				return true
			}
			return false;
		} 
	}, "证件号码不符合规范.");
	form.validate({
		doNotHideMessage : true, 
		errorElement : 'span',
		errorClass : 'validate-inline', 
		focusInvalid : false, 
		rules : {
			// 任职部门
			orgId : {
				checkSelect : true
			},
			//岗位职务
			positionId : {
				checkSelect : true
			},
			//职务级别
			levelId:{
				checkLevelId:true
			},
			//职工姓名
			name:{
				checkCustName:true
			},
			//试用期基本工资
			proBasicSalary:{
				checkProBasicSalary:true
			},
			//试用期绩效工资
			proPerformanceSalary:{
				checkPerfSalary:true
			},
			//转正基本工资
			regularBasicSalary:{
				checkProBasicSalary:true
			},
			//转正绩效工资
			regularPerformanceSalary:{
				checkPerfSalary:true
			},
			//计划入职日期
			plannedEntryDate:{
				checkPlannedEntryDate:true
			},
			sex:{
				checkSelect:true
			},
			certType:{
				checkSelect:true
			},
			certNo:{
				checkIdCard:true,
				remote: {
					url: base + "/common/check_certNo.json",
					data:{
						mobile: function(){ return $(".certNo").val()}
					}
				}
			},
			jobCategory:{
				checkSelect:true
			}
		},
		messages : { 
			certNo : {
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
		},
		submitHandler : function(form) {
			//console.log("submitHandler");
			success.show();
			error.hide();
			//form.submit();
		}
	});
	
	/**
	 * 改变证件类型时清空证件号码和提示信息
	 */
	$(".certType").change(function(){
		$(".certNo").val("");
		var spanFlag=$(".certNo").siblings();
		$(spanFlag).text("");
	});
});