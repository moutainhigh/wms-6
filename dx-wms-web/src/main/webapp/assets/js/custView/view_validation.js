var ViewValidation = function() {
	return {
		// main function to initiate the module
		init : function() {
			function format(state) {
				if (!state.id)
					return state.text; // optgroup
				return "<img class='flag' src='assets/image/flags/"
						+ state.id.toLowerCase() + ".png'/>&nbsp;&nbsp;"
						+ state.text;
			}
			var form = $('#submit_form');
			var error = $('.alert-error', form);
			var success = $('.alert-success', form);
			// 校验
			// 公用

			// 姓名验证
			jQuery.validator.addMethod("checkCustName",
					function(value, element) {
						// console.log(value);
						if (value != '') {
							var reg = /^[\u4E00-\u9FA5]+$/;
							if (reg.test(value)) {
								return true;
							}
							return false;
						}
					}, "名字不能为空，且必须为汉字");
			// 手机验证
			jQuery.validator.addMethod("checkMobile", function(value, element) {
				if (value != '') {
					// 手机号
					var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
					if (reg.test(value)) {
						return true;
					}
					return false;
				}

			}, "手机号不符合规范");
			jQuery.validator.addMethod("checkCustSource", function(value,
					element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "客户来源不能为空");
			jQuery.validator.addMethod("checkCustSourceOther", function(value,
					element) {
				if (value == '') {
					return false;
				}
				return true;
			}, "客户其他来源不能为空");
			jQuery.validator
					.addMethod(
							"checkIdCard",
							function(value, element) {
								if (value == '') {
									return false;
								} else {
									if ($("#idType").val() == 1) {
										var idCard = $("#idCard").val();
										var Y, JYM;
										var S, M;
										var idcard_array = new Array();
										idcard_array = idCard.split("");
										// console.log("len"+
										// idcard_array.length);
										// var reg_18 =
										// /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;
										var reg_18 = /^[1-9][0-7]\d{4}((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))\d{3}(\d|X)?$/;
										var reg_15 = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9]|[1|2]\d)|3[0-1])\d{3}$/;
										if (reg_15.test(idCard)) {
											return true;
										} else if (reg_18.test(idCard)) {
											// 计算校验位
											var S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10]))
													* 7
													+ (parseInt(idcard_array[1]) + parseInt(idcard_array[11]))
													* 9
													+ (parseInt(idcard_array[2]) + parseInt(idcard_array[12]))
													* 10
													+ (parseInt(idcard_array[3]) + parseInt(idcard_array[13]))
													* 5
													+ (parseInt(idcard_array[4]) + parseInt(idcard_array[14]))
													* 8
													+ (parseInt(idcard_array[5]) + parseInt(idcard_array[15]))
													* 4
													+ (parseInt(idcard_array[6]) + parseInt(idcard_array[16]))
													* 2
													+ parseInt(idcard_array[7])
													* 1
													+ parseInt(idcard_array[8])
													* 6
													+ parseInt(idcard_array[9])
													* 3;
											Y = S % 11;
											M = "F";
											JYM = "10X98765432";
											M = JYM.substr(Y, 1);
											/* 判断校验位 */
											if (M == idcard_array[17]
													.toUpperCase()) {
												return true;
												/* 检测ID的校验位false; */
											} else {
												return false;
											}
										} else {
											return false;
										}
									} else if ($("#idType").val() == 2) {
										var rex = /^((G\d{8})|(P\.?\d{7})|((S\.?\d{7})|(S\d{8}))|((14|15)\d{7})|(E\d{8}))$/;
										if (rex.test(value)) {
											return true;
										}
										return false;
									} else if ($("#idType").val() == 4) {
										var rex = /^[HM]{1}\d{10}$/;
										if (rex.test(value)) {
											return true;
										}
										return false;
									} else if ($("#idType").val() == 3) {
										var reg = /^[\u4E00-\u9FA5]+$/;
										if (reg.test(value)) {
											return false;
										}
										return true;
									}
								}
							}, "证件号码不符合规范.");
			form.validate({
				doNotHideMessage : true, // this option enables to show the
				// error/success messages on tab
				// switch.
				errorElement : 'span', // default input error message container
				errorClass : 'validate-inline', // default input error message
				// class
				focusInvalid : false, // do not focus the last invalid input
				rules : {
					// 检查姓名
					custName : {
						"checkCustName" : true
					},
					// 检查电话号码
					mobile : {
						"checkMobile" : true
					},
					custSource : {
						"checkCustSource" : true
					},
					custSourceOther : {
						"checkCustSourceOther" : true
					},
					idCard : {
						"checkIdCard" : true
					}
				},
				messages : { // custom messages for radio buttons and
					// checkboxes
					'payment[]' : {
						required : "Please select at least one option",
						minlength : jQuery
								.format("Please select at least one option")
					}
				},
				errorPlacement : function(error, element) { // render error
					// placement for
					// each input type
					if (element.attr("name") == "gender") { // for uniform radio
						// buttons, insert
						// the after the
						// given container
						error.addClass("no-left-padding").insertAfter(
								"#form_gender_error");
					} else if (element.attr("name") == "payment[]") { // for
						// uniform
						// radio
						// buttons,
						// insert
						// the
						// after
						// the
						// given
						// container
						error.addClass("no-left-padding").insertAfter(
								"#form_payment_error");
					} else {
						error.insertAfter(element); // for other inputs, just
						// perform default behavoir
					}
				},

				invalidHandler : function(event, validator) { // display error
					// alert on form
					// submit
					success.hide();
					error.show();
					// App.scrollTo(error, -200);
				},

				highlight : function(element) { // hightlight error inputs
					// console.log("highlight:" + element);
					// console.log("highlight:" + $(element));
					$(element).closest('.help-inline').removeClass('ok'); // display
					// OK
					// icon
					$(element).closest('.responsive').removeClass('success')
							.addClass('error'); // set error class to the
					// control group
				},
				unhighlight : function(element) { // revert the change dony by
					// hightlight
					// console.log("unhighlight:" + element);
					// console.log("unhighlight:" + $(element));
					$(element).closest('.responsive').removeClass('error'); // set
					// error
					// class
					// to
					// the
					// control
					// group
				},

				success : function(label) {
					if (label.attr("for") == "gender"
							|| label.attr("for") == "payment[]") { // for
						// checkboxes
						// and radio
						// buttons,
						// no need
						// to show
						// OK icon
						label.closest('.responsive').removeClass('error')
								.addClass('success');
						label.remove(); // remove error label here
					} else { // display success icon for other inputs
						label.addClass('valid ok') // mark the current input as
						// valid and display OK icon
						.closest('.responsive').removeClass('error').addClass(
								'success'); // set success class to the control
						// group
					}
				},

				submitHandler : function(form) {
					success.show();
					error.hide();
					// add here some ajax code to submit your form or just call
					// form.submit() if you want to submit the form without ajax
				}

			});

			var displayConfirm = function() {
				$('.display-value', form)
						.each(
								function() {
									var input = $('[name="'
											+ $(this).attr("data-display")
											+ '"]', form);
									if (input.is(":text")
											|| input.is("textarea")) {
										$(this).html(input.val());
									} else if (input.is("select")) {
										$(this).html(
												input.find('option:selected')
														.text());
									} else if (input.is(":radio")
											&& input.is(":checked")) {
										$(this).html(input.attr("data-title"));
									} else if ($(this).attr("data-display") == 'card_expiry') {
										$(this)
												.html(
														$(
																'[name="card_expiry_mm"]',
																form).val()
																+ '/'
																+ $(
																		'[name="card_expiry_yyyy"]',
																		form)
																		.val());
									} else if ($(this).attr("data-display") == 'payment') {
										var payment = [];
										$('[name="payment[]"]').each(
												function() {
													payment.push($(this).attr(
															'data-title'));
												});
										$(this).html(payment.join("<br>"));
									}
								});
			}

			// default form wizard
			$('.button-submit').click(function() {
				if (form.valid() == false) {
					return false;
				}

				var saveBtn = $(this);
				$(this).attr("disabled", "disabled");
				$("#close").attr("disabled", "disabled");

				var custViewVo = {};
				custViewVo.custId = $("#custId").val();
				custViewVo.custName = $("#custName").val();
				custViewVo.mobile = $("#mobile").val();
				custViewVo.idCard = $("#idCard").val();
				custViewVo.idType = $("#idType").val();
				custViewVo.sex = $("#sex").val();
				custViewVo.createTime = $("#createTime").val();
				custViewVo.custSource = $("#custSource").val();
				if (custViewVo.custSource == 20) {
					custViewVo.custSourceOther = $("#custSourceOther").val();
				}

				$.dopConfirm("确认保存吗.", null, function(r) {
					if (r) {
						$.ajax({
							url : 'save.json',// 请求url
							type : "POST",
							async : true,
							dataType : "json",
							contentType : "application/json",
							data : JSON.stringify(custViewVo),
							timeout : 30000,
							success : function(data) {
								if(data.code){
									$.dopAlert(data.msg, null, function(r) {
										saveBtn.removeAttr("disabled");
										$("#close").removeAttr("disabled");
										TableManaged.fnDraw();
										$('#createCustBaseDiv').modal('hide');
									});
								}else{
									$.dopAlert(data.msg);
									if(data.msg=="您填写的移动电话重复"){
										$("#mobile").val("");
									}else{
										$("#idCard").val("");
									}
									saveBtn.removeAttr("disabled");
									$("#close").removeAttr("disabled");
								}
							},
							error : function(data) {
								$.dopAlert("保存出现异常,请重试!");
								saveBtn.removeAttr("disabled");
								$("#close").removeAttr("disabled");
							}
						});
					} else {
						saveBtn.removeAttr("disabled");
						$("#close").removeAttr("disabled");
					}
				});
			});
		}
	};
}();
