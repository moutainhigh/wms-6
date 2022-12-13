function doInvestCloseDiv() {
	$('#investInfoChangeDiv').modal('hide');
}
function investInfo() {
	$("#productId").attr("disabled", "disabled");
	$("#lenderAmount").attr("disabled", "disabled");
	$("#payAccountName").removeAttr("disabled");
	$("#refundAccountName").removeAttr("disabled");
	$("#payAccountName").attr("disabled", "disabled");
	$("#refundAccountName").attr("disabled", "disabled");
	$("#specialLimit").attr("disabled", "disabled");
	$("#specialBenefit").attr("disabled", "disabled");

	// $("#signMobileDiv").hide();
}
$(function() {
	sourcePaycityRegionCode = $(
			"#paycityRegionCode option[value='"
					+ $("#paycityRegionCode").attr("source_val") + "']").text();
	sourceRefundcityRegionCode = $(
			"#refundcityRegionCode option[value='"
					+ $("#refundcityRegionCode").attr("source_val") + "']")
			.text();
});
function doInvestSaveChange() {

	var form = $("#submit_form");
	if (form.valid() == false) {
		return false;
	}
	$("#saveChange").attr("disabled", "disabled");
	$(".alert-error").hide();
	$(".alert-success").show();
	if (!flag) {
		return false;
	}
	if ($("#payWayId").val() == 2
			&& ($("#payBankCategory").val() == 2
					|| $("#payBankCategory").val() == 6
					|| $(".payBankCategory").val() == 15 || $(
					".payBankCategory").val() == 16)) {
		$.dopAlert("当前平台不支持中国农业银行、中国招商银行、上海银行、交通银行进行委托划扣");
		return false;
	}

	var custAccountApplyVo = getInvestCustAccountApplyVo();
	$.dopConfirm("是否确定保存？", null, function(r) {
		if (r) {
			$.ajax({
				url : base + '/infoChange/investInfo_save.json',// 请求url
				type : "POST",
				async : false,
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(custAccountApplyVo),
				timeout : 30000,
				success : function(data) {
					if (data.code) {
						TableManaged.fnPageChange(0);
						$.dopAlert("保存成功");
						$('#investInfoChangeDiv').modal('hide')

					} else {
						$("#saveChange").removeAttr("disabled", "disabled");
						$.dopAlert(data.msg);
						if (data.msg == "您填写的合同编号重复") {
							$("#contractCode").val("");
						}
					}
				},
				error : function(data) {
					$("#saveChange").removeAttr("disabled", "disabled");
					$.dopAlert("保存出现异常,请重试");

				}
			});

		}
		$("#saveChange").removeAttr("disabled", "disabled");
	});

}
function getInvestCustAccountApplyVo() {
	var custAccountApplyVo = {};
	var logs = [];
	custAccountApplyVo.lenderApply = getInvestLenderApply(logs);
	custAccountApplyVo.custFinances = getInvestCustFinances(logs);
	custAccountApplyVo.lenderConditions = getInvestLenderConditions(logs);
	custAccountApplyVo.custAccount = getInvestCustAccount();
	custAccountApplyVo.logs = logs;
	return custAccountApplyVo;
}
function getInvestCustAccount() {
	custAccount = {};
	custAccount.custAccountId = $("#custAccountId").val();
	return custAccount;
}
function getInvestLenderApply(logs) {
	var lenderApply = {};
	lenderApply.custAccountId = $("#custAccountId").val();
	lenderApply.lenderApplyId = $("#lenderApplyId").val();
	lenderApply.contractCode = $("#contractCode").val();
	if ($("#contractCode").val() != $("#contractCode").attr("source_val")) {
		log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_lender_apply SET contract_code ='"
				+ $("#contractCode").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'contract_code';
		logJsonDto.columnNameChs = '合同编号';
		logJsonDto.sourceValueEng = $("#contractCode").attr("source_val");
		logJsonDto.sourceValueChs = $("#contractCode").attr("source_val");
		logJsonDto.updateValueEng = $("#contractCode").val();
		logJsonDto.updateValueChs = $("#contractCode").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_lender_apply';
		logJsonDto.tableNameChs = '出借申请表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	lenderApply.productId = $("#productId").val();
	lenderApply.expectLenderDateBegin = $("#expectLenderDateBegin").val();
	if ($("#expectLenderDateBegin").val() != $("#expectLenderDateBegin").attr(
			"source_val")) {
		log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_lender_apply SET expect_lender_date_begin ='"
				+ $("#expectLenderDateBegin").val()
				+ "' WHERE lender_apply_id =" + $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'expect_lender_date_begin';
		logJsonDto.columnNameChs = '预计出借日期-起';
		logJsonDto.sourceValueEng = $("#expectLenderDateBegin").attr(
				"source_val");
		logJsonDto.sourceValueChs = $("#expectLenderDateBegin").attr(
				"source_val");
		logJsonDto.updateValueEng = $("#expectLenderDateBegin").val();
		logJsonDto.updateValueChs = $("#expectLenderDateBegin").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_lender_apply';
		logJsonDto.tableNameChs = '出借申请表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	lenderApply.expectLenderDateEnd = $("#expectLenderDateEnd").val();
	if ($("#expectLenderDateEnd").val() != $("#expectLenderDateEnd").attr(
			"source_val")) {
		log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_lender_apply SET expect_lender_date_end ='"
				+ $("#expectLenderDateEnd").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'expect_lender_date_end';
		logJsonDto.columnNameChs = '预计出借日期-止';
		logJsonDto.sourceValueEng = $("#expectLenderDateEnd")
				.attr("source_val");
		logJsonDto.sourceValueChs = $("#expectLenderDateEnd")
				.attr("source_val");
		logJsonDto.updateValueEng = $("#expectLenderDateEnd").val();
		logJsonDto.updateValueChs = $("#expectLenderDateEnd").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_lender_apply';
		logJsonDto.tableNameChs = '出借申请表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	if ($("#lenderAmount").val() != '-1') {
		lenderApply.lenderAmount = $("#lenderAmount").val();
	}

	lenderApply.payWayId = $("#payWayId").val();
	if ($("#lenderAmount").val() != '-1'
			&& $("#payWayId").val() != $("#payWayId").attr("source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_lender_apply SET pay_way_id ='"
				+ $("#payWayId").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'pay_way_id';
		logJsonDto.columnNameChs = '支付方式';
		logJsonDto.sourceValueEng = $("#payWayId").attr("source_val");
		logJsonDto.sourceValueChs = $(
				"#payWayId option[value='" + $("#payWayId").attr("source_val")
						+ "']").text();
		logJsonDto.updateValueEng = $("#payWayId").val();
		logJsonDto.updateValueChs = $(
				"#payWayId option[value='" + $("#payWayId").val() + "']")
				.text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_lender_apply';
		logJsonDto.tableNameChs = '出借申请表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	lenderApply.signDate = $("#signDate").val();
	if ($("#signDate").val() != $("#signDate").attr("source_val")) {
		log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_lender_apply SET sign_date ='"
				+ $("#signDate").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'sign_date';
		logJsonDto.columnNameChs = '签单日期';
		logJsonDto.sourceValueEng = $("#signDate").attr("source_val");
		logJsonDto.sourceValueChs = $("#signDate").attr("source_val");
		logJsonDto.updateValueEng = $("#signDate").val();
		logJsonDto.updateValueChs = $("#signDate").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_lender_apply';
		logJsonDto.tableNameChs = '出借申请表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	lenderApply.signMobile = $("#signMobile").val();
	if ($("#signMobile").val() != $("#signMobile").attr("source_val")) {
		log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_lender_apply SET sign_mobile ='"
				+ $("#signMobile").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'sign_mobile';
		logJsonDto.columnNameChs = '签约手机';
		logJsonDto.sourceValueEng = $("#signMobile").attr("source_val");
		logJsonDto.sourceValueChs = $("#signMobile").attr("source_val");
		logJsonDto.updateValueEng = $("#signMobile").val();
		logJsonDto.updateValueChs = $("#signMobile").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_lender_apply';
		logJsonDto.tableNameChs = '出借申请表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	if ($("#recovery").val() != '-1') {
		lenderApply.recovery = $("#recovery").val();
	}
	if ($("#recovery").val() != '-1'
			&& $("#recovery").val() != $("#recovery").attr("source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_lender_apply SET recovery ='"
				+ $("#recovery").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'recovery';
		logJsonDto.columnNameChs = '回收方式';
		logJsonDto.sourceValueEng = $("#recovery").attr("source_val");
		logJsonDto.sourceValueChs = $(
				"#recovery option[value='" + $("#recovery").attr("source_val")
						+ "']").text();
		logJsonDto.updateValueEng = $("#recovery").val();
		logJsonDto.updateValueChs = $(
				"#recovery option[value='" + $("#recovery").val() + "']")
				.text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_lender_apply';
		logJsonDto.tableNameChs = '出借申请表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	return lenderApply;
}
function getInvestCustFinances(logs) {
	var custFinances = [];
	custFinances.push(getInvestPayCustFinance(logs));
	custFinances.push(getInvestRefundCustFinance(logs));
	return custFinances;
}
function getInvestPayCustFinance(logs) {
	custFinance = {};
	custFinance.accountCategory = 1;
	custFinance.custFinanceId = $("#payCustFinanceId").val();
	custFinance.custAccountId = $("#custAccountId").val();
	custFinance.lenderApplyId = $("#lenderApplyId").val();
	if ($("#payprovinceRegionCode").val() != '-1') {
		custFinance.provinceRegionCode = $("#payprovinceRegionCode").val();
	}
	if ($("#payprovinceRegionCode").val() != '-1'
			&& $("#payprovinceRegionCode").val() != $("#payprovinceRegionCode")
					.attr("source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_cust_finance SET province_region_code ='"
				+ $("#payprovinceRegionCode").val()
				+ "' WHERE lender_apply_id =" + $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'province_region_code';
		logJsonDto.columnNameChs = '支付账户-省';
		logJsonDto.sourceValueEng = $("#payprovinceRegionCode").attr(
				"source_val");
		logJsonDto.sourceValueChs = $(
				"#payprovinceRegionCode option[value='"
						+ $("#payprovinceRegionCode").attr("source_val") + "']")
				.text();
		logJsonDto.updateValueEng = $("#payprovinceRegionCode").val();
		logJsonDto.updateValueChs = $(
				"#payprovinceRegionCode option[value='"
						+ $("#payprovinceRegionCode").val() + "']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_finance';
		logJsonDto.tableNameChs = '客户金融表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	if ($("#paycityRegionCode").val() != '-1') {
		custFinance.cityRegionCode = $("#paycityRegionCode").val();
	}
	if ($("#paycityRegionCode").val() != '-1'
			&& $("#paycityRegionCode").val() != $("#paycityRegionCode").attr(
					"source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_cust_finance SET city_region_code ='"
				+ $("#paycityRegionCode").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'city_region_code';
		logJsonDto.columnNameChs = '支付账户-市';
		logJsonDto.sourceValueEng = $("#paycityRegionCode").attr("source_val");
		logJsonDto.sourceValueChs = sourcePaycityRegionCode;
		logJsonDto.updateValueEng = $("#paycityRegionCode").val();
		logJsonDto.updateValueChs = $(
				"#paycityRegionCode option[value='"
						+ $("#paycityRegionCode").val() + "']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_finance';
		logJsonDto.tableNameChs = '客户金融表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	if ($("#payBankCategory").val() != '-1') {
		custFinance.bankCategory = $("#payBankCategory").val();
	}

	if ($("#payBankCategory").val() != '-1'
			&& $("#payBankCategory").val() != $("#payBankCategory").attr(
					"source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_cust_finance SET bank_category ='"
				+ $("#payBankCategory").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'bank_category';
		logJsonDto.columnNameChs = '支付账户-开户银行';
		logJsonDto.sourceValueEng = $("#payBankCategory").attr("source_val");
		logJsonDto.sourceValueChs = $(
				"#payBankCategory option[value='"
						+ $("#payBankCategory").attr("source_val") + "']")
				.text();
		logJsonDto.updateValueEng = $("#payBankCategory").val();
		logJsonDto.updateValueChs = $(
				"#payBankCategory option[value='" + $("#payBankCategory").val()
						+ "']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_finance';
		logJsonDto.tableNameChs = '客户金融表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custFinance.subBank = ($("#paySubBank").val() == -2) ? $("#payOtherAddress")
			.val()
			: $("#paySubBank").val();
	if ($("#paySubBank").val() != $("#paySubBank").attr("source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_cust_finance SET sub_bank ='"
				+ $("#paySubBank").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'sub_bank';
		logJsonDto.columnNameChs = '支付账户-支行';
		logJsonDto.sourceValueEng = $("#paySubBank").attr("source_val");
		logJsonDto.sourceValueChs = $("#paySubBank").attr("source_val");
		logJsonDto.updateValueEng = custFinance.subBank;
		logJsonDto.updateValueChs = custFinance.subBank;
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_finance';
		logJsonDto.tableNameChs = '客户金融表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custFinance.accountName = $("#payAccountName").val();
	custFinance.accountNum = $("#payAccountNum").val();
	if ($("#payAccountNum").val() != $("#payAccountNum").attr("source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_cust_finance SET account_num ='"
				+ $("#payAccountNum").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'account_num';
		logJsonDto.columnNameChs = '支付账户-账户';
		logJsonDto.sourceValueEng = $("#payAccountNum").attr("source_val");
		logJsonDto.sourceValueChs = $("#payAccountNum").attr("source_val");
		logJsonDto.updateValueEng = $("#payAccountNum").val();
		logJsonDto.updateValueChs = $("#payAccountNum").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_finance';
		logJsonDto.tableNameChs = '客户金融表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	return custFinance;
}
function getInvestRefundCustFinance(logs) {
	custFinance = {};
	custFinance.accountCategory = 2;
	custFinance.custFinanceId = $("#refundCustFinanceId").val();
	custFinance.custAccountId = $("#custAccountId").val();
	custFinance.lenderApplyId = $("#lenderApplyId").val();
	if ($("#refundprovinceRegionCode").val() != '-1') {
		custFinance.provinceRegionCode = $("#refundprovinceRegionCode").val();
	}
	if ($("#refundprovinceRegionCode").val() != '-1'
			&& $("#refundprovinceRegionCode").val() != $(
					"#refundprovinceRegionCode").attr("source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_cust_finance SET province_region_code ='"
				+ $("#refundprovinceRegionCode").val()
				+ "' WHERE lender_apply_id =" + $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'province_region_code';
		logJsonDto.columnNameChs = '回款账户-省';
		logJsonDto.sourceValueEng = $("#refundprovinceRegionCode").attr(
				"source_val");
		logJsonDto.sourceValueChs = $(
				"#refundprovinceRegionCode option[value='"
						+ $("#refundprovinceRegionCode").attr("source_val")
						+ "']").text();
		logJsonDto.updateValueEng = $("#payprovinceRegionCode").val();
		logJsonDto.updateValueChs = $(
				"#refundprovinceRegionCode option[value='"
						+ $("#refundprovinceRegionCode").val() + "']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_finance';
		logJsonDto.tableNameChs = '客户金融表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	if ($("#refundcityRegionCode").val() != '-1') {
		custFinance.cityRegionCode = $("#refundcityRegionCode").val();
	}
	if ($("#refundcityRegionCode").val() != '-1'
			&& $("#refundcityRegionCode").val() != $("#refundcityRegionCode")
					.attr("source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_cust_finance SET city_region_code ='"
				+ $("#refundcityRegionCode").val()
				+ "' WHERE lender_apply_id =" + $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'city_region_code';
		logJsonDto.columnNameChs = '回款账户-市';
		logJsonDto.sourceValueEng = $("#refundcityRegionCode").attr(
				"source_val");
		logJsonDto.sourceValueChs = sourceRefundcityRegionCode;
		logJsonDto.updateValueEng = $("#refundcityRegionCode").val();
		logJsonDto.updateValueChs = $(
				"#refundcityRegionCode option[value='"
						+ $("#refundcityRegionCode").val() + "']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_finance';
		logJsonDto.tableNameChs = '客户金融表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	if ($("#refundBankCategory").val() != '-1') {
		custFinance.bankCategory = $("#refundBankCategory").val();
	}

	if ($("#refundBankCategory").val() != '-1'
			&& $("#refundBankCategory").val() != $("#refundBankCategory").attr(
					"source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_cust_finance SET bank_category ='"
				+ $("#refundBankCategory").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'bank_category';
		logJsonDto.columnNameChs = '回款账户-开户银行';
		logJsonDto.sourceValueEng = $("#refundBankCategory").attr("source_val");
		logJsonDto.sourceValueChs = $(
				"#refundBankCategory option[value='"
						+ $("#refundBankCategory").attr("source_val") + "']")
				.text();
		logJsonDto.updateValueEng = $("#refundBankCategory").val();
		logJsonDto.updateValueChs = $(
				"#refundBankCategory option[value='"
						+ $("#refundBankCategory").val() + "']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_finance';
		logJsonDto.tableNameChs = '客户金融表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custFinance.subBank = ($("#refundSubBank").val() == -2) ? $(
			"#refundOtherAddress").val() : $("#refundSubBank").val();
	if ($("#refundSubBank").val() != $("#refundSubBank").attr("source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_cust_finance SET sub_bank ='"
				+ $("#refundSubBank").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'sub_bank';
		logJsonDto.columnNameChs = '回款账户-支行';
		logJsonDto.sourceValueEng = $("#refundSubBank").attr("source_val");
		logJsonDto.sourceValueChs = $("#refundSubBank").attr("source_val");
		logJsonDto.updateValueEng = custFinance.subBank;
		logJsonDto.updateValueChs = custFinance.subBank;
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_finance';
		logJsonDto.tableNameChs = '客户金融表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custFinance.accountName = $("#refundAccountName").val();
	custFinance.accountNum = $("#refundAccountNum").val();
	if ($("#refundAccountNum").val() != $("#refundAccountNum").attr(
			"source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_cust_finance SET account_num ='"
				+ $("#refundAccountNum").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'account_num';
		logJsonDto.columnNameChs = '回款账户-账户';
		logJsonDto.sourceValueEng = $("#refundAccountNum").attr("source_val");
		logJsonDto.sourceValueChs = $("#refundAccountNum").attr("source_val");
		logJsonDto.updateValueEng = $("#refundAccountNum").val();
		logJsonDto.updateValueChs = $("#refundAccountNum").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_finance';
		logJsonDto.tableNameChs = '客户金融表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	return custFinance;
}
function getInvestLenderConditions(logs) {
	var lenderConditions = [];
	$("input[name='specialData']").each(function(index, item) {
		// specialCredits 额度 specialProfits收益
		if ("specialProfits" == item.value && item.checked == true) {
			lenderConditions.push(getInvestSpecialBenefitInfo(logs));
		} else if ("specialCredits" == item.value && item.checked == true) {
			lenderConditions.push(getInvestSpecialLimitInfo(logs));
		}
	});
	return lenderConditions;
}
function getInvestSpecialLimitInfo(logs) {
	var lenderCondition = {};
	if ($("#specialLimitId").val() != null || $("#specialLimitId").val() != '') {
		lenderCondition.lenderConditionId = $("#specialLimitId").val();
	}
	lenderCondition.lenderApplyId = $("#lenderApplyId").val();
	lenderCondition.lenderConditionVal = $("#specialLimit").val();
	if ($("#specialLimit").val() != $("#specialLimit").attr("source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_lender_condition SET lender_condition_val ='"
				+ $("#specialLimit").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'lender_condition_val';
		logJsonDto.columnNameChs = '特殊额度';
		logJsonDto.sourceValueEng = $("#specialLimit").attr("source_val");
		logJsonDto.sourceValueChs = $("#specialLimit").attr("source_val");
		logJsonDto.updateValueEng = $("#specialLimit").val();
		logJsonDto.updateValueChs = $("#specialLimit").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_lender_condition';
		logJsonDto.tableNameChs = '出借情况特殊表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	lenderCondition.lenderConditionRemark = $("#specialLimitRemark").val();
	if ($("#specialLimitRemark").val() != $("#specialLimitRemark").attr(
			"source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_lender_condition SET lender_condition_remark ='"
				+ $("#specialLimitRemark").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'lender_condition_remark';
		logJsonDto.columnNameChs = '特殊额度-备注';
		logJsonDto.sourceValueEng = $("#specialLimitRemark").attr("source_val");
		logJsonDto.sourceValueChs = $("#specialLimitRemark").attr("source_val");
		logJsonDto.updateValueEng = $("#specialLimitRemark").val();
		logJsonDto.updateValueChs = $("#specialLimitRemark").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_lender_condition';
		logJsonDto.tableNameChs = '出借情况特殊表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	// 1:"收益",2:"超额"
	lenderCondition.lenderConditionCategory = 2;
	return lenderCondition;
}
function getInvestSpecialBenefitInfo(logs) {
	var lenderCondition = {};
	if ($("#specialBenefitId").val() != null
			|| $("#specialBenefitId").val() != '') {
		lenderCondition.lenderConditionId = $("#specialBenefitId").val();
	}
	lenderCondition.lenderApplyId = $("#lenderApplyId").val();
	lenderCondition.lenderConditionVal = $("#specialBenefit").val();
	if ($("#specialBenefit").val() != $("#specialBenefit").attr("source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_lender_condition SET lender_condition_val ='"
				+ $("#specialBenefit").val() + "' WHERE lender_apply_id ="
				+ $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'lender_condition_val';
		logJsonDto.columnNameChs = '特殊收益';
		logJsonDto.sourceValueEng = $("#specialBenefit").attr("source_val");
		logJsonDto.sourceValueChs = $("#specialBenefit").attr("source_val");
		logJsonDto.updateValueEng = $("#specialBenefit").val();
		logJsonDto.updateValueChs = $("#specialBenefit").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_lender_condition';
		logJsonDto.tableNameChs = '出借情况特殊表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	lenderCondition.lenderConditionRemark = $("#specialBenefitRemark").val();
	if ($("#specialBenefitRemark").val() != $("#specialBenefitRemark").attr(
			"source_val")) {
		var log = {};
		log.tableName = 't_lender_apply';
		log.pkId = $("#lenderApplyId").val();
		log.dbSql = "UPDATE t_lender_condition SET lender_condition_remark ='"
				+ $("#specialBenefitRemark").val()
				+ "' WHERE lender_apply_id =" + $("#lenderApplyId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'lender_condition_remark';
		logJsonDto.columnNameChs = '特殊收益-备注';
		logJsonDto.sourceValueEng = $("#specialBenefitRemark").attr(
				"source_val");
		logJsonDto.sourceValueChs = $("#specialBenefitRemark").attr(
				"source_val");
		logJsonDto.updateValueEng = $("#specialBenefitRemark").val();
		logJsonDto.updateValueChs = $("#specialBenefitRemark").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_lender_condition';
		logJsonDto.tableNameChs = '出借情况特殊表';
		logJsonDto.tablePkId = $("#lenderApplyId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	// 1:"收益",2:"超额"
	lenderCondition.lenderConditionCategory = 1;
	return lenderCondition;
}
