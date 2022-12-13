function ss() {
	window.location.href = "list.htm";
}

/**
 * 确认提交销售客服
 */
var ff = 0;
function submitToSalesService() {
	if (ff == 1) {
		return false;
	}
	for (var i = 0; i < sunFileNumberArr.length; i++) {
		if (i == sunFileNumberArr.length - 1) {
			continue;
		}
		if (parseInt($("#" + sunFileNumberArr[i]).html()) == 0) {
			ff = 1;
			$.dopAlert("确认提交销售客服之前,请先上传完整文件", null, function(r) {
				ff = 0;
			});
			return false;
		}
	}

	var conditions = {};
	conditions.cmAction = "createAccount";
	conditions.action = "submitToSalesService";
	conditions.appCode = $("#appCode").val();
	conditions.resKey = $("#resKey").val();
	conditions.custAccountId = $("#userUniqueId").val();
	conditions.lenderApplyId = $("#lenderUniqueId").val();
	conditions.lenderCustCode = $("#lenderCustCode").val();
	ff = 1;
	$.dopConfirm("确认提交销售客服？", null, function(r) {
		if (r) {
			$.ajax({
				url : base + '/operate/submitToSalesService.json',// 请求url
				type : "POST",
				async : true,
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(conditions),
				timeout : 30000,
				success : function(data) {
					if (!data) {
						$.dopAlert("提交销售客服失败.");
					} else {
						$.dopAlert("提交销售客服成功.");
						// window.open(baseUrl + "/custAccountApply/list.htm");
						TableManaged.fnDraw();
						$('#createCustAccountDiv').modal('hide');
						$('#createCustApplyDiv').modal('hide');
					}
				},
				error : function(data) {
					$.dopAlert("提交销售客服异常");
				}
			});
		} else {
			ff = 0;
		}
	});
}

/**
 * 设置上传的div随tab2共同显示或隐藏
 */
function doShowOrHideUploadDiv() {
	if ($("#tab3").is(":hidden")) {
		$("#uploadDiv").hide();
	} else {
		$("#uploadDiv").show();
	}
}

$(function() {
	varContractCode = $("#contractCode").val();
	$("#tab2 input").removeAttr("disabled");
	$("#tab2 select").removeAttr("disabled");
	$("#bigLenderAmount").attr("disabled", "disabled");
	$("#payAccountName").attr("disabled", "disabled");
	$("#refundAccountName").attr("disabled", "disabled");
	$("#contractCode").attr("maxlength", 16);
	varcustSource = $("#custSource").val();
	varcustSourceOther = $("#custSourceOther").val();
	$("#bigLenderAmount").attr("disabled", "disabled");
	$("#bankInfoDiv").hide();
	$("#expectLenderDateBegin").val(
			$("#expectLenderDateBegin").val().substring(0, 10));
	$("#expectLenderDateEnd").val(
			$("#expectLenderDateEnd").val().substring(0, 10));
	$("#signDate").val($("#signDate").val().substring(0, 10));
	if ($("#custSource").val() != 20) {
		$("#custSourceOtherDiv").hide();
	}
	showAccountInfo($("#custAccountId").val());

	if ($("#payWayId").val() == '3') {
		$("#signMobileDiv").show();
	} else {
		$("#signMobileDiv").hide();
	}

	if ($("#bankInfo").val() == 3) {
		$("#bankInfoDiv").show();
	} else {
		$("#bankInfoDiv").hide();
	}
	$("#bankInfo").change(function() {
		if ($("#bankInfo").val() == 3) {
			$("#bankInfoDiv").show();
		} else {
			$("#bankInfoDiv").hide();
		}
	});

	var lenderCode = $("#lenderCode").val();
	if (null != lenderCode && $.trim(lenderCode) != "" && lenderCode.length > 3) {
		$("#fianCode").val(lenderCode.substr(lenderCode.length - 3, 3));
	}

	// 显示影像文件夹
	showRefFolders();

	$("#uploadDiv").hide();
	setInterval("doShowOrHideUploadDiv()", 500);

	// 特殊情况说明
	$("input[name='specialData']").each(
			function(index, item) {
				if (item.checked == true) {
					$("#" + item.value + " input").removeAttr("disabled");
					$("#" + item.value + " textarea").removeAttr("disabled");
				} else {
					$("#" + this.value + " input").attr("disabled", "disabled")
							.val("");
					$("#" + this.value + " textarea").attr("disabled",
							"disabled").val("");
				}
			});

	$("input[name='specialData']")
			.change(
					function() {

						if ("specialCredits" == this.value) {
							var productId = $("#productId").val();
							var lenderAmount = $("#lenderAmount").val();// 出借金额
							if (("13" == productId && parseFloat(lenderAmount) > 300000)
									|| ("16" == productId && parseFloat(lenderAmount) > 500000)) {
								if (this.checked) {
									$("#" + this.value + " input").removeAttr(
											"disabled");
									$("#" + this.value + " textarea")
											.removeAttr("disabled");
								} else {
									$("#" + this.value + " input").attr(
											"disabled", "disabled").val("");
									$("#" + this.value + " textarea").attr(
											"disabled", "disabled").val("");
								}
							} else {
								// this.checked = false;
								$(this).prop("checked", false);
								$(this).parent().removeClass("checked");
								$.dopAlert("出借金额并未超出上限或所选产品没有出借上限,无需填写特殊额度信息");
							}
						} else {
							if (this.checked) {
								$("#" + this.value + " input").removeAttr(
										"disabled");
								$("#" + this.value + " textarea").removeAttr(
										"disabled");
							} else {
								$("#" + this.value + " input").attr("disabled",
										"disabled").val("");
								$("#" + this.value + " textarea").attr(
										"disabled", "disabled").val("");
							}
						}
					});

	$("#productId")
			.change(
					function() {
						var productId = this.value;
						var lenderAmount = $("#lenderAmount").val();// 出借金额
						if (("13" == productId && parseFloat(lenderAmount) > 300000)
								|| ("16" == productId && parseFloat(lenderAmount) > 500000)) {

						} else {
							// 申请的理财方式 出借的金额未超出上限
							$("input[name='specialData']").each(
									function(index, item) {
										if ("specialCredits" == item.value) {
											// item.checked = false;
											$(item).prop("checked", false);
											$(item).parent().removeClass(
													"checked");
											$("#specialCredits input").attr(
													"disabled", "disabled")
													.val("");
											$("#specialCredits textarea").attr(
													"disabled", "disabled")
													.val("");
										}
									});
						}
					});

});
$("#specialLimit").blur(function() {
	var lenderAmount = $("#lenderAmount").val();// 出借金额
	var specialLimit = $("#specialLimit").val();
	if (parseFloat(lenderAmount) != parseFloat(specialLimit)) {
		$.dopAlert("特殊额度与出借金额不一致");
		$("#specialLimit").val("");
	}
});

function previous(tab, navigation, index) {
	if (index == 0) {
		$("#next").html("下一页");
	}
}
function save(tab, navigation, index) {
	var flag = true;
	if (index == 1) {
		$("#next").html("保存");
	}
	if (index == 2) {
		var subFlag = true;
		// 特殊情况数据校验
		var lenderAmount = $("#lenderAmount").val();
		var productId = $("#productId").val();
		if ("13" == productId || "16" == productId) {
			if (("13" == productId && parseFloat(lenderAmount) > 300000)
					|| ("16" == productId && parseFloat(lenderAmount) > 500000)) {

				var specialLimit = $("#specialLimit").val(); // 特殊额度
				if (lenderAmount != specialLimit) {
					$.dopAlert("特殊额度应当和出借金额一致");
					$("#specialLimit").val("");
					subFlag = false;
				}
				var specialLimitRemark = $("#specialLimitRemark").val();
				if (null == specialLimitRemark
						|| "" == $.trim(specialLimitRemark)) {
					$.dopAlert("请输入特殊额度备注");
					subFlag = false;
				}
			} else {
				// 申请的理财方式 出借的金额未超出上限
				$("input[name='specialData']").each(
						function(index, item) {
							if ("specialCredits" == item.value
									&& item.checked == true) {
								item.checked = false;
								$("#specialCredits input").attr("disabled",
										"disabled").val("");
								$("#specialCredits textarea").attr("disabled",
										"disabled").val("");
								$("#specialLimit").val("");
								$("#specialLimitRemark").val("");
							}
						});
			}
		}

		if (!subFlag) {
			return false;
		}

		var beginDate = $("#expectLenderDateBegin").val();
		var endDate = $("#expectLenderDateEnd").val();
		var d1 = new Date(beginDate);
		var d2 = new Date(endDate);
		if (beginDate != "" && endDate != "" && d1 > d2) {
			$.dopAlert("预计出借起始日期不能大于预计出借终止日期！");
			return false;
		}

		$("input[name='specialData']")
				.each(
						function(index, item) {
							if ("specialProfits" == item.value
									&& item.checked == true) {
								var specialBenefit = $("#specialBenefit").val();
								if (null == specialBenefit
										|| "" == $.trim(specialBenefit)) {
									$.dopAlert("请输入特殊收益");
									subFlag = false;
								}
								// var rex =
								// /^(?:[1-9]\d{0,1}(?:\.\d{2})?|0\.\d{2})$/;
								var rex = /^\d+(\.\d+)?$/;
								if (!rex.test(specialBenefit)) {
									$.dopAlert("特殊收益应当为数字");
									subFlag = false;
								}
								var specialBenefitRemark = $(
										"#specialBenefitRemark").val();
								if (null == specialBenefitRemark
										|| "" == $.trim(specialBenefitRemark)) {
									$.dopAlert("请输入特殊收益备注");
									subFlag = false;
								}
							}
						});

		if (!subFlag) {
			return false;
		}

		var flag = true;
		if ($("#contractCode").val() != ''
				&& $("#contractCode").val() != varContractCode) {
			var custInfoCheckVo = {};
			custInfoCheckVo.contractCode = $("#contractCode").val();
			$.ajax({
				url : base + '/common/check_contract_code.json',// 请求url
				type : "POST",
				async : false,
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(custInfoCheckVo),
				timeout : 30000,
				success : function(data) {
					if (!data) {
						$("#contractCode").val('');
						flag = false;
						$.dopAlert("合同编号重复");
						return false;
					}
				},
				error : function(data) {
					$.dopAlert("校验申请审核异常");
					flag = false;
					return false;
				}
			});
		}

		if ($("#payWayId").val() != 1
				&& ($("#payBankCategory").val() == 2 || $("#payBankCategory")
						.val() == 6)) {
			$.dopAlert("当前平台不支持中国农业银行、中国招商银行进行直接划扣/委托划扣");
			return false;
		}
		if ($("#payprovinceRegionCode").val() == -1
				|| $("#paycityRegionCode").val() == -1
				|| $("#refundprovinceRegionCode").val() == -1
				|| $("#refundcityRegionCode").val() == -1) {
			$.dopAlert("请选择银行所属省市");
			return false;
		}
		var custAccountApplyVo = getCustAccountApplyVo();
		var custAccount = {};
		custAccountApplyVo.custAccount = custAccount;
		custAccountApplyVo.custAccount.custAccountId = $("#custAccountId")
				.val();
		if ($("#lenderCode").val() != '' || $("#lenderCode").val() != null) {
			var lenCode = $("#lenderCode").val();
			var ll = lenCode.substring(18, 21);
			$("#fianCode").val(ll);
		}
		if (flag) {
			$
					.ajax({
						url : base + '/custApply/save.json',// 请求url
						type : "POST",
						async : false,
						dataType : "json",
						contentType : "application/json",
						data : JSON.stringify(custAccountApplyVo),
						timeout : 30000,
						success : function(data) {
							if (data != null) {
								$("#userUniqueId").val(
										data.custAccount.custAccountId);
								$("#lenderApplyId").val(
										data.lenderApply.lenderApplyId);
								$("#lenderUniqueId").val(
										data.lenderApply.lenderApplyId);
								$("#lenderCustCode").val(
										data.lenderApply.lenderCustCode);
								$("#contractCode").val(
										data.lenderApply.contractCode);
								varContractCode = $("#contractCode").val();
								if (data.custFinances != null
										&& data.custFinances.length > 0) {
									for (var i = 0; i < data.custFinances.length; i++) {
										var item = data.custFinances[i];
										if (item.accountCategory == 1) {
											$("#payCustFinanceId").val(
													item.custFinanceId);

										}
										if (item.accountCategory == 2) {
											$("#refundCustFinanceId").val(
													item.custFinanceId);

										}
									}
								}
								if (data.lenderConditions != null
										&& data.lenderConditions.length > 0) {
									for (var i = 0; i < data.lenderConditions.length; i++) {
										var item = data.lenderConditions[i];
										if (item.lenderConditionCategory == 2) {
											// 额度
											$("#specialLimitId").val(
													item.lenderConditionId);

										}
										if (item.lenderConditionCategory == 1) {
											// 收益
											$("#specialBenefitId").val(
													item.lenderConditionId);

										}
									}
								}
								showRefFolders();
								flag = true;
							} else {
								$.dopAlert("保存出现异常,请重试");
								flag = false;
							}
						},
						error : function(data) {
							$.dopAlert("保存出现异常,请重试");
							flag = false;
						}
					});
		}
	}
	return flag;
}

function showAccountInfo(custAccountId) {
	var url = base + '/process/account.json?type=1&custAccountId='
			+ custAccountId;
	$.post(url, {}, function(data, status) {
		$('#account').html(data);
	});
}
function getCustAccount() {
	var custAccount = {};
	if ($("#custSource").val() != '-1' && $("#custSource").val() != null) {
		custAccount.custSource = $("#custSource").val();
	}
	if ($("#custSourceOther").val() != null) {
		custAccount.custSourceOther = $("#custSourceOther").val();
	}
	return custAccount;
}

function getCustAccountApplyVo() {
	var custAccountApplyVo = {};
	custAccountApplyVo.lenderApply = getLenderApply();
	custAccountApplyVo.custFinances = getCustFinances();
	custAccountApplyVo.lenderConditions = getLenderConditions();
	return custAccountApplyVo;
}

function getLenderApply() {
	var lenderApply = {};
	if ($("#lenderApplyId").val() != null) {
		lenderApply.lenderApplyId = $("#lenderApplyId").val();
	}
	if ($("#parentId").val() != null) {
		lenderApply.parentId = $("#parentId").val();
	}
	lenderApply.contractCode = $("#contractCode").val();
	lenderApply.productId = $("#productId").val();
	lenderApply.expectLenderDateBegin = $("#expectLenderDateBegin").val();
	lenderApply.expectLenderDateEnd = $("#expectLenderDateEnd").val();
	lenderApply.recovery=$("#recovery").val();
	lenderApply.lenderAmount = $("#lenderAmount").val();
	lenderApply.payWayId = $("#payWayId").val();
	lenderApply.signDate = $("#signDate").val();
	lenderApply.signMobile = $("#signMobile").val();
	return lenderApply;
}

function getCustFinances() {
	var custFinances = [];
	custFinances.push(getPayCustFinance());
	custFinances.push(getRefundCustFinance());
	return custFinances;
}
function getRefundCustFinance() {
	var custFinance = {};
	if ($("#refundCustFinanceId").val() != null
			|| $("#refundCustFinanceId").val() != '') {
		custFinance.custFinanceId = $("#refundCustFinanceId").val();
	}
	custFinance.accountCategory = 2;
	custFinance.bankCategory = $("#refundBankCategory").val();
	custFinance.provinceRegionCode = $("#refundprovinceRegionCode").val();
	custFinance.cityRegionCode = $("#refundcityRegionCode").val();
	custFinance.subBank = $("#refundSubBank").val();
	custFinance.accountName = $("#refundAccountName").val();
	custFinance.accountNum = $("#refundAccountNum").val();
	return custFinance;
}
function getPayCustFinance() {
	var custFinance = {};
	if ($("#payCustFinanceId").val() != null
			|| $("#payCustFinanceId").val() != '') {
		custFinance.custFinanceId = $("#payCustFinanceId").val();
	}
	custFinance.accountCategory = 1;
	custFinance.bankCategory = $("#payBankCategory").val();
	custFinance.subBank = $("#paySubBank").val();
	custFinance.provinceRegionCode = $("#payprovinceRegionCode").val();
	custFinance.cityRegionCode = $("#paycityRegionCode").val();
	custFinance.accountName = $("#payAccountName").val();
	custFinance.accountNum = $("#payAccountNum").val();
	return custFinance;
}

function getLenderConditions() {
	var lenderConditions = [];
	$("input[name='specialData']").each(function(index, item) {
		// specialCredits 额度 specialProfits收益
		if ("specialProfits" == item.value && item.checked == true) {
			lenderConditions.push(getSpecialBenefitInfo());
		} else if ("specialCredits" == item.value && item.checked == true) {
			lenderConditions.push(getSpecialLimitInfo());
		}
	});
	return lenderConditions;
}

function getSpecialLimitInfo() {
	var lenderCondition = {};
	if ($("#specialLimitId").val() != null || $("#specialLimitId").val() != '') {
		lenderCondition.lenderConditionId = $("#specialLimitId").val();
	}
	lenderCondition.lenderConditionVal = $("#specialLimit").val();
	lenderCondition.lenderConditionRemark = $("#specialLimitRemark").val();
	// 1:"收益",2:"超额"
	lenderCondition.lenderConditionCategory = 2;
	return lenderCondition;
}

function getSpecialBenefitInfo() {
	var lenderCondition = {};
	if ($("#specialBenefitId").val() != null
			|| $("#specialBenefitId").val() != '') {
		lenderCondition.lenderConditionId = $("#specialBenefitId").val();
	}
	lenderCondition.lenderConditionVal = $("#specialBenefit").val();
	lenderCondition.lenderConditionRemark = $("#specialBenefitRemark").val();
	// 1:"收益",2:"超额"
	lenderCondition.lenderConditionCategory = 1;
	return lenderCondition;
}

// 输入数字自动带出其中文大写
$("#lenderAmount").blur(function() {
	if ($("#lenderAmount").val() != '') {
		var custInfoCheckVo = {};
		var rex = /^[1-9]{1}\d*$/;
		if (!rex.test($("#lenderAmount").val())) {
			return false;
		}
		custInfoCheckVo.lenderAmount = $("#lenderAmount").val();
		if($("#parentId").val()>0){
			custInfoCheckVo.parentId = $("#parentId").val();
		}
		
		$.ajax({
			url : base + '/common/change_amount.json',// 请求url
			type : "POST",
			async : false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(custInfoCheckVo),
			timeout : 30000,
			success : function(data) {
				if (data.bigLenderAmount != null) {
					$("#bigLenderAmount").val(data.bigLenderAmount);
				}else{
					$("#lenderAmount").val("");
					$.dopAlert("续投金额不能大于原出借本金");
				}
			},
			error : function(data) {
				$.dopAlert("获取数字大写 异常 ");
			}
		});
	}
});

function doCloseDiv() {
	if (ff == 1) {
		return false;
	}
	TableManaged.fnDraw();
	$('#createCustApplyDiv').modal('hide');
	$('#createCustAccountDiv').modal('hide');
}

function previous() {
	if (ff == 1) {
		return false;
	}
}

$("#lenderAmount").blur(function() {
	var productId = $("#productId").val();
	var lenderAmount = $("#lenderAmount").val();
	$("#beyondRmb").html("");
	if (productId == "13" && parseFloat(lenderAmount) > 300000) {
		$("#beyondRmb").html("您的出借金额超出当前产品出借上限，请进行特殊额度申请");
	} else if (productId == "16" && parseFloat(lenderAmount) > 500000) {
		$("#beyondRmb").html("您的出借金额超出当前产品出借上限，请进行特殊额度申请");
	}
//	if ($("#maxAmount").val() > 0 && $("#parentId").val() > 0
//			&& $("#maxAmount").val() < lenderAmount && lenderAmount >0) {
//		$("#beyondRmb").html("续投金额不能大于原出借本金");
//	}
});

$("#expectLenderDateBegin").change(
		function() {
			if (null != this.value && $.trim(this.value) != "") {
				var dateArr = this.value.split("-");
				var year = dateArr[0];
				var month = dateArr[1];
				var day = dateArr[2];
				var sysDate = new Date();
				var curDate = new Date(sysDate.getFullYear() + "/"
						+ (sysDate.getMonth() + 1) + "/" + sysDate.getDate())
				var selDate = new Date(this.value);
				var endDate = new Date($("#expectLenderDateEnd").val());
				selDate.setFullYear(year, month - 1, day);
				if (selDate >= curDate) {
					if (endDate != null && $.trim(endDate) != ""
							&& selDate > endDate) {
						$("#expectLenderDateBegin").val("")
						// $.dopAlert("出借日期(起)应小于出借日期(止)");
					}
				} else {
					$("#expectLenderDateBegin").val("");
				}
			}
		});

$("#expectLenderDateEnd").change(function() {
	if (null != this.value && $.trim(this.value) != "") {
		var dateArr = this.value.split("-");
		var year = dateArr[0];
		var month = dateArr[1];
		var day = dateArr[2];
		var selDate = new Date($("#expectLenderDateEnd").val());
		selDate.setFullYear(year, month - 1, day);
		if (selDate >= new Date($("#expectLenderDateBegin").val())) {

		} else {
			$("#expectLenderDateEnd").val("");
		}
	}
});

$("#payWayId").change(function() {
	if (this.value == "3") {
		$("#idCard").attr("disabled", "disabled").val("");
	} else {
		$("#idCard").removeAttr("disabled");
	}
});

$("#payWayId").change(function() {
	if ($("#payWayId").val() == '3') {
		$("#signMobileDiv").show();
	} else {
		$("#signMobile").val("");
		$("#signMobileDiv").hide();
	}
});

$("#signDate").change(function() {
	if (null != this.value && $.trim(this.value) != "") {
		var dateArr = this.value.split("-");
		var year = dateArr[0];
		var month = dateArr[1];
		var day = dateArr[2];
		var selDate = new Date();
		selDate.setFullYear(year, month - 1, day);

		if (selDate <= new Date()) {

		} else {
			$("#signDate").val("");
		}
	}

});

$("#refundprovinceRegionCode").change(
		function() {
			$("#refundcityRegionCode option").remove();
			$("#refundcityRegionCode").append(
					"<option value='-1'>请选择市</option>");
			$.getJSON(base + '/common/region.json?param='
					+ $("#refundprovinceRegionCode").val(), function(data) {
				$.each(data, function(index, item) {
					$("#refundcityRegionCode").append(
							"<option value='" + item.area_code_id + "'>"
									+ item.area_code_name + "</option>");
				});
			});
		});
$("#payprovinceRegionCode").change(
		function() {
			$("#paycityRegionCode option").remove();
			$("#paycityRegionCode").append("<option value='-1'>请选择市</option>");
			$.getJSON(base + '/common/region.json?param='
					+ $("#payprovinceRegionCode").val(), function(data) {
				$.each(data, function(index, item) {
					$("#paycityRegionCode").append(
							"<option value='" + item.area_code_id + "'>"
									+ item.area_code_name + "</option>");
				});
			});
		});
// $("#save").click(function(){
// if(($("#lenderIncomeRatio").val()==null || $("#lenderIncomeRatio").val()==""
// || $("#lenderIncomeRatio").val().length <=0) && $("#isIncome").val()==1 ){
//		
// return false;
// }
// } ]
var flag = true;
// 校验合同编号是否存在
$("#contractCode").blur(
		function() {
			var reg = /^[D][X][F][0-9]{13}$/;
			if ($("#contractCode").val() == varContractCode) {
				flag = true;
			}
			if ($("#contractCode").val() != ''
					&& $("#contractCode").val() != varContractCode
					&& reg.test($("#contractCode").val())) {
				var custInfoCheckVo = {};
				custInfoCheckVo.contractCode = $("#contractCode").val();
				$.ajax({
					url : base + '/common/check_contract_code.json',// 请求url
					type : "POST",
					async : false,
					dataType : "json",
					contentType : "application/json",
					data : JSON.stringify(custInfoCheckVo),
					timeout : 30000,
					success : function(data) {
						if (!data) {
							$("#contractCode").val('');
							flag = false;
							$.dopAlert("合同编号重复");
							return false;
						}
						flag = true;
					},
					error : function(data) {
						$.dopAlert("校验申请审核异常");
					}
				});
			}
		});
