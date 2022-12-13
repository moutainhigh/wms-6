/**
 * 初始化信息
 */
$(function() {
	// if($("#biz").val()=="dueApply"&&$(".expectLenderDateBegin").val()==""&&$(".expectLenderDateEnd").val()==""){
	// getDueDate();
	// }
	if ($("#parentId").val() != '') {
		$("#initApplyId").val($("#parentId").val());
	}
	initOtherInfo();
	InitCondition();
});

/**
 * 初始化其它一些信息
 */
function initOtherInfo() {
	$(".refundOtherSubBank").closest(".row-fluid").hide();
	$(".payOtherSubBank").closest(".row-fluid").hide();
	// 设置输入文本框的最大长度
	setMaxlength({
		".industry" : 10,
		".companyName" : 30,
		".post" : 10,
		".zipCode" : 6,
		".accountEmail" : 40,
		".wechat" : 30,
		".linkmanName" : 6,
		".linkmanAreaCode" : 4,
		".linkmanTelNum" : 8,
		".linkmanNameSpell" : 40,
		".linkmanRelation" : 6,
		".linkmanIdCard" : 18,
		".linkmanMobile" : 11,
		".contractCode" : 16,
		".lenderAmount" : 8,
		".specialBenefit" : 10,
		"#areaCode" : 4,
		"#telNum" : 8,
		"#streetInfo" : 50,
		"#linkmanAreaCode" : 4,
		"#linkmanTelNum" : 8,
		"#signMobile" : 11,
		".payAccountNum" : 25,
		".refundAccountNum" : 25,
		"#specialBenefitRemark" : 30,
		"#specialLimitRemark" : 30,
		".payOtherSubBank" : 40,
		".refundOtherSubBank" : 40
	});

	// apply 提交销售客服 ，account且客户编号为空的时候为确认开户，反之为保存
	if ($("#biz").val() == 'apply') {
		$("#createUserAccount").text("提交销售客服");
	} else {
		$("#createUserAccount").text("确认开户");
		if (null != $("#lenderCustCode").val()
				&& $.trim($("#lenderCustCode").val()) != "") {
			$("#createUserAccount").text("保存");
		}
	}

	// 页面初始化时使滚动条位置显示在最顶端
	$(".tab-content").scrollTop(0);

	// 支付方式为直接划扣和委托划扣时显示签约手机
	if ($("#payWayId").val() == '3' || $("#payWayId").val() == '2') {
		$("#signMobileDiv").show();
	} else {
		$("#signMobileDiv").hide();
	}

	if ($(".linkmanIdType").val() == '-1') {
		$(".linkmanIdCard").attr("disabled", "disabled");
	}
}

// function getDueDate(){
// var LenderApply = {};
// LenderApply.lenderApplyId = $("#lenderId").val();
// $.ajax({
// url : base + '/save/lenderApply.json?',// 请求url
// type : "POST",
// async : true,
// dataType : "json",
// contentType : "application/json",
// data : JSON.stringify(LenderApply),
// timeout : 30000,
// success : function(data) {
// var dueDate = new Date(data.dueDate);
// var defaultDate = new
// Date(dueDate.getFullYear()+"/"+(dueDate.getMonth()+1)+"/"+(dueDate.getDate()+1));
// var month = defaultDate.getMonth()+1;
// var year = defaultDate.getFullYear();
// var day = defaultDate.getDate();
// if(month<10){
// month="0"+month;
// }
// if(day<10){
// day="0"+day;
// }
// var date = year+"-"+month+"-"+day;
// $(".expectLenderDateBegin").val(date);
// $(".expectLenderDateEnd").val(date);
// },
// error : function(data) {
// $.dopAlert("获取到期日失败 ");
// }
// });
// }
/**
 * 初始化加回显特殊情况说明的信息
 */
function InitCondition() {
	// 开始初始化特殊情况说明输入框
	var conditions = [ ".specialLimit", "#specialLimitRemark",
			".specialBenefit", "#specialBenefitRemark",
			"input[value='specialCredits']" ];
	$.each(conditions, function(index, item) {
		$(item).attr("disabled", "disabled");
	});

	// 当前客户有特殊额度时就使相应的备注框可编辑状态
	if ($("#specialLimitId").val() != "") {
		$("input[value='specialCredits']").attr("checked", true);
		$("#specialLimitRemark").removeAttr("disabled");
	}

	// 当前客户有特殊收益时就使相应的备注框可编辑状态
	if ($("#specialBenefitId").val() != "") {
		$("input[value='specialProfits']").attr("checked", true);
		$(".specialBenefit").removeAttr("disabled");
		$("#specialBenefitRemark").removeAttr("disabled");
	}

	// 开始除掉特殊收益后面的%号、特殊额度后面的元字
	var specials = [ ".specialBenefit", ".specialLimit" ];
	$.each(specials, function(index, item) {
		var special = $.trim($(item).val());
		if (!isEmptyString(special)) {
			$(item).val($.trim(special.substring(0, special.length - 1)))
		}
	});
}

$("#payWayId").change(
		function() {
			if ($("#payWayId").val() == '2' || $("#payWayId").val() == '3') {
				$("#signMobileDiv").show();
			} else {
				$("#signMobile").val("");
				$("#signMobileDiv").hide();
			}
			// 重置
			$("#signMobile").val("");
			$(this).closest(".span5").siblings(".span5").removeClass("success")
					.removeClass("error").find(".validate-inline").text("");
		});

// 设置最大长度
function setMaxlength(data) {
	$.each(data, function(key, value) {
		$(key).attr("maxlength", value);
	});
}

// 输入姓名自动带出其拼音
$(".linkmanName").blur(function() {
	if ($(".linkmanName").val() != '') {
		var custInfoCheckVo = {};
		custInfoCheckVo.custName = $(".linkmanName").val();
		$.ajax({
			url : base + '/common/check_spellName.json',// 请求url
			type : "POST",
			async : true,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(custInfoCheckVo),
			timeout : 30000,
			success : function(data) {
				if (data.custNameSpell != null) {
					$(".linkmanNameSpell").val(data.custNameSpell);
				}
			},
			error : function(data) {
				$.dopAlert("获取名字拼音 异常 ");
			}
		});
	}
});

// 当改变省的下拉框值时，市中下拉框出现相应的市
$(".provinceRegionCode").change(
		function() {
			$("#cityRegionCode option[value!='-1']").remove();
			$("#streetInfo").val('');
			$("#streetInfo").parent().removeClass("error").removeClass(
					"success");
			if ($("#streetInfo").next().hasClass("validate-inline")) {
				$("#streetInfo").next().remove();
			}
			$("#districtRegionCode option[value!='-1']").remove();
			$.getJSON(base + '/common/region.json?param='
					+ $(".provinceRegionCode").val(), function(data) {
				$.each(data, function(index, item) {
					$("#cityRegionCode").append(
							"<option value='" + item.area_code_id + "'>"
									+ item.area_code_name + "</option>");
				});
			});
		});

$("#cityRegionCode").change(
		function() {
			$("#districtRegionCode option[value!='-1']").remove();
			$("#streetInfo").val('');
			$("#streetInfo").parent().removeClass("error").removeClass(
					"success");
			if ($("#streetInfo").next().hasClass("validate-inline")) {
				$("#streetInfo").next().remove();
			}
			$.getJSON(base + '/common/region.json?param='
					+ $("#cityRegionCode").val(), function(data) {
				$.each(data, function(index, item) {
					$("#districtRegionCode").append(
							"<option value='" + item.area_code_id + "'>"
									+ item.area_code_name + "</option>");
				});
			});
		});

// 区改动，街道为空
$("#districtRegionCode").change(function() {
	$("#streetInfo").val('');
	$("#streetInfo").parent().removeClass("error").removeClass("success");
	if ($("#streetInfo").next().hasClass("validate-inline")) {
		$("#streetInfo").next().remove();
	}
});

// 输入数字自动带出其中文大写
$(".lenderAmount").blur(function() {
	if ($(".lenderAmount").val() != '') {
		var custInfoCheckVo = {};
		var rex = /^[1-9]{1}\d*$/
		if (!rex.test($(".lenderAmount").val())) {
			return false;
		}
		custInfoCheckVo.lenderAmount = $(".lenderAmount").val();
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
					$(".bigLenderAmount").val(data.bigLenderAmount);
				}
			},
			error : function(data) {
				$.dopAlert("获取数字大写 异常 ");
			}
		});
	}
});

/**
 * 【开户】、【投资申请】、续投的保存
 * 
 * @param tab
 * @param navigation
 * @param index
 * @returns {Boolean}
 */
function save(tab, navigation, index) {
	paramSaverVo = {};
	paramSaverVo.indexId = index;
	var bizIndex = $("#biz").val() + index;

	// if(bizIndex=="apply2"&&$(".payBankCategory").val()==7){
	// if($("#payWayId").val()==2||$("#payWayId").val()==3){
	// if($(".lenderAmount").val()>50000){
	// $.dopAlert("当前平台不支持兴业银行 委托划扣/直接划扣 超过5万");
	// return false;
	// }
	// }
	// }
	// 保存账户基本信息
	if (bizIndex == "account2") {
		saveBaseInfo();
	}
	// 保存账户的详细信息
	if (bizIndex == "account3") {
		// 紧急联系人手机和固定电话选择其一
		$("#selectOne").html("");
		if (isEmptyString($("#linkmanMobile").val())
				&& (isEmptyString($(".linkmanAreaCode").val()) || isEmptyString($(
						".linkmanTelNum").val()))) {
			$("#selectOne").css({
				"margin-left" : "-150px"
			});
			$("#selectOne").html("移动电话或固定电话选填一个");
			return false;
		}
		saveAccountInfo();
	}
	// 投资申请和续投
	if (parseFloat(bizIndex.indexOf("pply2")) > -1) {
//		if ($("#payWayId").val() == 2
//				&& ($(".payBankCategory").val() == 2
//						|| $(".payBankCategory").val() == 6
//						|| $(".payBankCategory").val() == 15 || $(
//						".payBankCategory").val() == 16)) {
//			$.dopAlert("当前平台不支持中国农业银行、中国招商银行、上海银行、交通银行进行委托划扣");
//			return false;
//		}
		saveLenderApplyInfo();
	}
	// 改最后提交的按钮文字
	if ($("#biz").val().indexOf("pply") > -1) {
		$("#createUserAccount").text("提交销售客服");
	}
	if ($("#biz").val() == "account") {
		$("#lenderCustCode").val() == '' ? $("#createUserAccount").text("确认开户")
				: $("#createUserAccount").text("保存");
	}
	// 每次保存后使div的滚动条回到顶部
	$(".tab-content").scrollTop(0);

}

/**
 * 判断字符串是否为空
 */
function isEmptyString(str) {
	if (str == "" || str == null || $.trim(str) == "" || $.trim(str) == "null") {
		return true;
	}
	return false;
}

/**
 * 【开户】、【投资申请】的确认操作
 */
var doCreateUserAccounttype = true;
function doCreateUserAccount() {
	if ($("#biz").val() == 'account') {
		createAccount();
	} else {
		createApply();
	}

}

// 判断证件为选择时变成成灰色
$(".linkmanIdType").live(
		"change",
		function() {
			$("input[name='linkmanIdCard']").val("");
			var linkmanIdType = this.value;
			if ($(this).val() != '-1') {
				$(".linkmanIdCard").removeAttr("disabled", "disabled");
			} else {
				$(".linkmanIdCard").attr("disabled", "disabled");
				// 等于-1时 改变证件类型时清空证件号码和提示信息
			}
			$(".linkmanIdCard").closest(".responsive ").removeClass("error")
					.removeClass("success");
			if ($(".linkmanIdCard").next().hasClass("validate-inline")) {
				$(".linkmanIdCard").next().remove();
			}
		});

// 验证出生日期和开户日期
$(".date-picker").live(
		"change",
		function() {
			if ($(this).attr("name") == "expectLenderDateBegin"
					|| $(this).attr("name") == "expectLenderDateEnd") {
				return;
			}
			var dateArray = getDateArray(this);
			if (dateArray[0] > dateArray[1]) {
				$(this).val("");
				$(this).siblings("span").removeClass("ok");
			} else {
				$(this).siblings("span").addClass("ok valid").text("");
			}
		});

$(".payBankCategory").change(
		function() {
			$("#paySubBank option").remove();
			$("#paySubBank").append("<option value='-1'>请选择支行</option>");
			$(".payOtherSubBank").closest(".row-fluid").hide();
			if ($(".payBankCategory").val() == -1) {
			} else {
				$.ajax({
					url : base + '/process/subBank.json?bankCode='
							+ $(".payBankCategory").val()
							+ '&paycityRegionCode='
							+ $("#payCityRegionCode").val()
							+ '&payprovinceRegionCode='
							+ $(".payProvinceRegionCode").val(),// 请求url
					type : "POST",
					async : false,
					dataType : "json",
					contentType : "application/json",
					timeout : 30000,
					success : function(data) {
						if (data != null && data != "") {
							$.each(data, function(index, item) {
								$("#paySubBank").append(
										"<option value='" + item.subBankName
												+ "'>" + item.subBankName
												+ "</option>");
							});
						}
						$("#paySubBank").append(
								"<option value='-2'>其他</option>");
					},
					error : function(data) {
						$.dopAlert("支行查询失败");
					}
				});
			}
		});

$(".refundBankCategory").change(
		function() {
			$("#refundSubBank option").remove();
			$("#refundSubBank").append("<option value='-1'>请选择支行</option>");
			$(".refundOtherSubBank").closest(".row-fluid").hide();
			if ($(".refundBankCategory").val() == -1) {
			} else {
				$.ajax({
					url : base + '/process/subBank.json?bankCode='
							+ $(".refundBankCategory").val()
							+ '&paycityRegionCode='
							+ $("#refundCityRegionCode").val()
							+ '&payprovinceRegionCode='
							+ $(".refundProvinceRegionCode").val(),// 请求url
					type : "POST",
					async : false,
					dataType : "json",
					contentType : "application/json",
					timeout : 30000,
					success : function(data) {
						if (data != null && data != "") {
							$.each(data, function(index, item) {
								$("#refundSubBank").append(
										"<option value='" + item.subBankName
												+ "'>" + item.subBankName
												+ "</option>");
							});
						}
						$("#refundSubBank").append(
								"<option value='-2'>其他</option>");
					},
					error : function(data) {
						$.dopAlert("支行查询失败");
					}
				});
			}
		});

$(".payProvinceRegionCode").change(
		function() {
			$(".payOtherSubBank").closest(".row-fluid").hide();
			$("#payCityRegionCode option").remove();
			$("#payCityRegionCode").append("<option value='-1'>请选择市</option>");
			$(".payBankCategory").val("-1");
			$("#paySubBank option").remove();
			$("#paySubBank").append("<option value='-1'>请选择</option>");
			$.ajax({
				url : base + '/common/region.json?param='
						+ $(".payProvinceRegionCode").val(),
				type : "POST",
				async : false,
				dataType : "json",
				contentType : "application/json",
				timeout : 30000,
				success : function(data) {
					$.each(data, function(index, item) {
						$("#payCityRegionCode").append(
								"<option value='" + item.area_code_id + "'>"
										+ item.area_code_name + "</option>");
					});
				},
				error : function(data) {
					$.dopAlert("城市查询失败");
				}
			});
		});

$(".refundProvinceRegionCode").change(
		function() {
			$(".refundOtherSubBank").closest(".row-fluid").hide();
			$("#refundCityRegionCode option").remove();
			$("#refundCityRegionCode").append(
					"<option value='-1'>请选择市</option>");
			$(".refundBankCategory").val("-1");
			$("#refundSubBank option").remove();
			$("#refundSubBank").append("<option value='-1'>请选择</option>");
			$.ajax({
				url : base + '/common/region.json?param='
						+ $(".refundProvinceRegionCode").val(),
				type : "POST",
				async : false,
				dataType : "json",
				contentType : "application/json",
				timeout : 30000,
				success : function(data) {
					$.each(data, function(index, item) {
						$("#refundCityRegionCode").append(
								"<option value='" + item.area_code_id + "'>"
										+ item.area_code_name + "</option>");
					});
				},
				error : function(data) {
					$.dopAlert("城市查询失败");
				}
			});
		});

$("#payCityRegionCode").change(function() {
	$("#paySubBank option").remove();
	$("#paySubBank").append("<option value='-1'>请选择</option>");
	$(".payBankCategory").val("-1");
	$(".payOtherSubBank").closest(".row-fluid").hide();
});

$("#refundCityRegionCode").change(function() {
	$(".refundBankCategory").val("-1");
	$("#refundSubBank option").remove();
	$("#refundSubBank").append("<option value='-1'>请选择</option>");
	$(".refundOtherSubBank").closest(".row-fluid").hide();
});

$("#paySubBank").change(function() {
	if ($("#paySubBank").val() == -2) {
		$(".payOtherSubBank").closest(".row-fluid").show();
		$(".payOtherSubBank").val("");
	} else {
		$(".payOtherSubBank").closest(".row-fluid").hide();
	}
});

$("#refundSubBank").change(function() {
	if ($("#refundSubBank").val() == -2) {
		$(".refundOtherSubBank").closest(".row-fluid").show();
		$(".refundOtherSubBank").val("");
	} else {
		$(".refundOtherSubBank").closest(".row-fluid").hide();
	}
});

// 关闭弹出层时刷新列表数据
$(".close-modal").click(function() {
	TableManaged.fnDraw();
});
