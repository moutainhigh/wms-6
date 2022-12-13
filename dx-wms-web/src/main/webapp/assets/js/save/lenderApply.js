/**
 * 【投资申请】、【续投】的保存
 */
function saveLenderApplyInfo() {
	paramSaverVo.apply = getApply();
	paramSaverVo.finances = getFinances();
	paramSaverVo.conditions = getLenderConditions();
	$.ajax({
		url : base + '/save/apply_save.json',
		type : "POST",
		async : false,
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(paramSaverVo),
		success : function(data) {
			if (data != null) {
				console.log("~~~~~~~~~~lenderApplyId="+data.apply.lenderApplyId);
				$("#lenderApplyId").val(data.apply.lenderApplyId);
				$("#lenderUniqueId").val(data.apply.lenderApplyId);
				//回显特殊信息的Id
				for ( var k in data.conditions) {
					if (data.conditions[k].lenderConditionCategory == 1) {
						$("#specialBenefitId").val(
								data.conditions[k].lenderConditionId);
					}
					if (data.conditions[k].lenderConditionCategory == 2) {
						$("#specialLimitId").val(
								data.conditions[k].lenderConditionId);
					}
				}
				//回显支付信息的custFinanceId
				$.each(data.finances,function(index,finance){
					if(finance.accountCategory==1){
						$("#payCustFinanceId").val(finance.custFinanceId);
					}
					if(finance.accountCategory==2){
						$("#refundCustFinanceId").val(finance.custFinanceId);
					}
				});
				$('#uploadDiv,#fileUploadFormFrom').show();
				// 每次保存后使div的滚动条回答顶部
				$(".tab-content").scrollTop(0);
			} else {
				$.dopAlert("保存出现异常,请重试");
			}
		},
		error : function(data) {
			$.dopAlert("请求超时");
			$(this).removeAttr("disabled");
			$(".close-modal").removeAttr("disabled");
		}
	});

}

/**
 * 【投资申请】获得出借申请信息
 * 
 * @returns
 */
function getApply() {
	var lenderApply = {};
	if ($("#lenderApplyId").val() != null) {
		lenderApply.lenderApplyId = $("#lenderApplyId").val();
	}
	lenderApply.custAccountId = $("#custAccountId").val();
	lenderApply.contractCode = $(".contractCode").val();
	lenderApply.productId = $("#productId").val();
	lenderApply.expectLenderDateBegin = $(".expectLenderDateBegin").val();
	lenderApply.expectLenderDateEnd = $(".expectLenderDateEnd").val();
	lenderApply.lenderAmount = $(".lenderAmount").val();
	lenderApply.payWayId = $("#payWayId").val();
	lenderApply.signDate = $(".signDate").val();
	lenderApply.formStatus=$("#formStatus").val();
	if ($("#signMobile").val() != null) {
		lenderApply.signMobile = $("#signMobile").val();
	}
	lenderApply.recovery = $(".recovery").val();
	// 续期
	if ('dueApply' == $("#biz").val() ) {
		if( $("#initApplyId").val() != null){
			lenderApply.parentId = $("#initApplyId").val();
		}
	}
	if ($("#parentId").val() != null && $("#parentId").val()!='') {
		lenderApply.parentId = $("#parentId").val();
	}
	return lenderApply;
}

/**
 * 【投资申请】获得客户金融信息
 * 
 * @returns {Array}
 */
function getFinances() {
	var custFinances = [];
	if ('dueApply' == $("#biz").val()) {
		// 续期
		custFinances.push(getDuePayCustFinance());
		custFinances.push(getRefundCustFinance());
	} else {
		custFinances.push(getPayCustFinance());
		custFinances.push(getRefundCustFinance());
	}
	return custFinances;
}

/**
 * 【投资申请】获得客户支付帐户信息
 */
function getPayCustFinance() {
	var custFinance = {};
	if ($("#payCustFinanceId").val() != null
			|| $("#payCustFinanceId").val() != '') {
		custFinance.custFinanceId = $("#payCustFinanceId").val();
	}
	if ($("#lenderApplyId").val() != null) {
		custFinance.lenderApplyId = $("#lenderApplyId").val();
	}
	custFinance.accountCategory = 1;
	custFinance.bankCategory = $(".payBankCategory").val();
	if ($("#paySubBank").val() == -2) {
		custFinance.subBank = $(".payOtherSubBank").val();
	} else {
		custFinance.subBank = $("#paySubBank").val();
	}
	custFinance.provinceRegionCode = $(".payProvinceRegionCode").val();
	custFinance.cityRegionCode = $("#payCityRegionCode").val();
	custFinance.accountName = $(".payAccountName").val();
	custFinance.accountNum = $(".payAccountNum").val();
	return custFinance;
}

function getDuePayCustFinance() {
	var custFinance = {};
	if ($("#payCustFinanceId").val() != null
			|| $("#payCustFinanceId").val() != '') {
		custFinance.custFinanceId = $("#payCustFinanceId").val();
	}
	if ($("#lenderApplyId").val() != null) {
		custFinance.lenderApplyId = $("#lenderApplyId").val();
	}
	custFinance.accountCategory = 1;
	return custFinance;
}

/**
 * 【投资申请】获得客户回款帐户信息
 * 
 * @returns {___anonymous14777_14778}
 */
function getRefundCustFinance() {
	var custFinance = {};
	if ($("#refundCustFinanceId").val() != null
			|| $("#refundCustFinanceId").val() != '') {
		custFinance.custFinanceId = $("#refundCustFinanceId").val();
	}
	if ($("#lenderApplyId").val() != null) {
		custFinance.lenderApplyId = $("#lenderApplyId").val();
	}
	custFinance.accountCategory = 2;
	custFinance.bankCategory = $(".refundBankCategory").val();
	if ($("#refundSubBank").val() == -2) {
		custFinance.subBank = $(".refundOtherSubBank").val();
	} else {
		custFinance.subBank = $("#refundSubBank").val();
	}
	custFinance.provinceRegionCode = $(".refundProvinceRegionCode").val();
	custFinance.cityRegionCode = $("#refundCityRegionCode").val();
	custFinance.accountName = $(".refundAccountName").val();
	custFinance.accountNum = $(".refundAccountNum").val();
	return custFinance;
}

/**
 * 【投资申请】获得特殊情况信息
 */
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

/**
 * 【投资申请】获取超额相关信息
 */
function getSpecialLimitInfo() {
	var lenderCondition = {};
	if ($("#specialLimitId").val() != null || $("#specialLimitId").val() != '') {
		lenderCondition.lenderConditionId = $("#specialLimitId").val();
	}
	lenderCondition.lenderConditionVal = $(".specialLimit").val();
	lenderCondition.lenderConditionRemark = $("#specialLimitRemark").val();
	// 1:"收益",2:"超额"
	lenderCondition.lenderConditionCategory = 2;
	return lenderCondition;
}

/**
 * 【投资申请】获取收益相关信息
 */
function getSpecialBenefitInfo() {
	var lenderCondition = {};
	if ($("#specialBenefitId").val() != null
			|| $("#specialBenefitId").val() != '') {
		lenderCondition.lenderConditionId = $("#specialBenefitId").val();
	}
	lenderCondition.lenderConditionVal = $.trim($(".specialBenefit").val());
	lenderCondition.lenderConditionRemark = $("#specialBenefitRemark").val();
	// 1:"收益",2:"超额"
	lenderCondition.lenderConditionCategory = 1;
	return lenderCondition;
}

/**
 * 【投资申请】确认
 */
function createApply() {
	var conditions = {};
	conditions.cmAction = "createAccount";
	conditions.action = "submitToSalesService";
	conditions.appCode = $("#appCode").val();
	conditions.resKey = $("#resKey").val();
	conditions.custAccountId = $("#userUniqueId").val();
	conditions.lenderApplyId = $("#lenderApplyId").val();
	conditions.lenderCustCode = $("#lenderCustCode").val();
	ff = 1;
	for (var i = 0; i < sunFileNumberArr.length; i++) {
//		if (i == sunFileNumberArr.length - 1) {
//			continue;
//		}
		if (parseInt($("#" + sunFileNumberArr[i]).html()) == 0) {
			ff=1;
			$.dopAlert("确认提交销售客服之前,请先上传完整文件", null, function(r){
				ff=0;
			});
			return false;
		}
	}
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
						$('#editModal').modal('hide');
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

// 特殊收益checkbox改变时事件
$("input[name='specialData']").change(function() {
	if (this.checked == true) {
		$(".specialBenefit").removeAttr("disabled");
		$("#specialBenefitRemark").removeAttr("disabled");
	} else {
		reset(".specialBenefit");
		reset("#specialBenefitRemark");
	}
});

/**
 * 重置特殊收益和特殊收益的备注
 * 
 * @param id
 */
function reset(id) {
	var cssStyle = "#ccc";
	if (id == ".specialBenefit") {
		cssStyle = "#e5e5e5";
	}
	$(id).val("").attr("disabled", "disabled").siblings(".validate-inline")
			.text("").removeClass("ok");
	$(id).css({
		"border-color" : cssStyle
	}).parent().siblings("label").css({
		"color" : "black"
	});
}

// 出借金额文本框失去焦点时验证【出借金额】
$("input[name='lenderAmount']").blur(function() {
	checkLenderAmount();
});

// 当滚动条滚动时验证【出借金额】
$("#tab_apply").closest(".tab-content").bind("scroll", function() {
	checkLenderAmount();
});

// 在出借金额输入时验证【出借金额】
$("input[name='lenderAmount']").keypress(function() {
	checkLenderAmount();
});

// 当【出借方式】改变时验证【出借金额】
$("#productId").change(function() {
	checkLenderAmount();
});

/**
 * 对【出借金额】判断
 */
function checkLenderAmount() {
	/*alert($("#biz").val());*/
	var productId = $("#productId").val();
	var lenderAmount = parseFloat($(".lenderAmount").val());// 出借金额
	if(lenderAmount % 10000 == 0 ){
		//续投时与出借本金进行比较
		if(oldLenderAmount!="" && lenderAmount>oldLenderAmount){
			$(".lenderAmount").siblings(".help-inline").css({"color":"#B94A48"}).html("");
			return;
		}
		if (("13" == productId && lenderAmount > 300000)
				|| ("16" == productId && lenderAmount > 500000)) {
			//清空validate中的提示信息
			$(".lenderAmount").siblings(".validate-inline").html("");
			//提示信息
			$(".lenderAmount").siblings(".help-inline").css({"color":"#B94A48"}).html("金额超限，已自动填写特殊额度");
			//将出借金额赋给特殊额度,且将文本框设置为不可编辑状态
			$(".specialLimit").val(lenderAmount).attr("disabled", "disabled");
			//是特殊额度的checkbox选中，且不可编辑
			$("input[value='specialCredits']").attr("checked", true).attr("disabled", "disabled");
			//使特殊额度备注的文本框为可编辑状态
			$("#specialLimitRemark").removeAttr("disabled");
			return;
		} 
	}
	//清空出借金额的提示
	$(".lenderAmount").siblings(".help-inline").html("");
	//清空特殊额度
	$(".specialLimit").val("");
	//使得特殊额度的checkbox不被选中
	$("input[value='specialCredits']").attr("checked", false);
	//移除文本框相关的颜色
	$("#specialLimitRemark").closest(".span5").removeClass("error").removeClass("success");
	//清空特殊额度的值和相关提示信息（恢复原始状态）
	$("#specialLimitRemark").val("").attr("disabled", "disabled").siblings(".validate-inline").text("");
}


/**
 * 出借本金
 */
var oldLenderAmount="";

/**
 * 根据出借申请-编号获取出借本金
 * @param lenderApplyId
 */
function getOldLenderAmount(lenderApplyId){
	var LenderApply = {};
	LenderApply.lenderApplyId = lenderApplyId;
	$.ajax({
		url : base + '/save/lenderApply.json?',// 请求url
		type : "POST",
		async : true,
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(LenderApply),
		timeout : 30000,
		success : function(data) {
			oldLenderAmount=parseFloat(data.lenderAmount);
		},
		error:function(){
			$.dopAlert("获取出借金额失败  ");
		}
		
	});
}

/**
 * 页面加载完成后获取出借金额
 */
/*$(function(){
	if($("#biz").val()=="dueApply"){
		alert($("#initApplyId").val());
		getLenderAmount($("#initApplyId").val());
	}else{
		oldLenderAmount="";
	}
});
*/
$(".lenderAmount","#save_form").live("focus",function(){
	if($("#biz").val()=="dueApply"){
		getOldLenderAmount($("#initApplyId").val());
	}else{
		oldLenderAmount="";
	}
});