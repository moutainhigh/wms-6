/**
 * 【开户操作】保存客户基本信息
 */
function saveBaseInfo() {
	paramSaverVo.account = getCustAccount();
	paramSaverVo.profession = getCustProfession();
	$.ajax({
		url : base + '/save/account_save.json',
		type : "POST",
		async : false,
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(paramSaverVo),
		timeout : 3000,
		success : function(data) {
			if (data != null ) {
				$("#custAccountId").val(data.account.custAccountId);
				$("#userUniqueId").val(data.account.custAccountId);
				$("#custProfessionId").val(data.profession.custProfessionId);
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
 * 【开户操作】保存客户详细信息
 */
function saveAccountInfo() {
	paramSaverVo.comm = getCustComm();
	paramSaverVo.linkman = getCustLinkman();
	$.ajax({
		url : base + '/save/account_save.json',
		type : "POST",
		async : false,
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(paramSaverVo),
		timeout : 3000,
		success : function(data) {
			if (data != null ) {
				$("#custCommId").val(data.comm.custCommId);
				$("#custLinkmanId").val(data.linkman.custLinkmanId);
			} else {
				$.dopAlert("保存出现异常,请重试");
			}
			$('#uploadDiv,#fileUploadFormFrom').show();
		},
		error : function(data) {
			$.dopAlert("请求超时");
			$(this).removeAttr("disabled");
			$(".close-modal").removeAttr("disabled");
		}
	});
}

/**
 * 【开户操作】获得客户基本信息
 * @returns
 */
function getCustAccount() {
	var custAccount = {};
	custAccount.custName = $("#custName").val();
	custAccount.custNameSpell = $("#custNameSpell").val();
	custAccount.sex = $("#sex").val();
	custAccount.nationality = "中国";
	custAccount.commonLanguage = 1;
	custAccount.idType = $("#idType").val();
	custAccount.idCard = $("#idCard").val();
	custAccount.mobile = $("#mobile").val();
	custAccount.custSource = $("#custSource").val();
	custAccount.custCode = $("#custCode").val();
	if ($("#custSourceOther").val() != "") {
		custAccount.custSourceOther = $("#custSourceOther").val();
	}
	if ($("#custAccountId").val() != "") {
		custAccount.custAccountId = $("#custAccountId").val();
	}
	custAccount.education = $(".education").val();
	if ($(".maritalStatus").val() != '-1' && $(".maritalStatus").val() != null) {
		custAccount.maritalStatus = $(".maritalStatus").val();
	}
	if ($(".birthDate").val() != null) {
		custAccount.birthDate = $(".birthDate").val();
	}
	if ($(".openDate").val() != null) {
		custAccount.openDate = $(".openDate").val();
	}
	if ($(".msgWay").val() != '-1' && $(".msgWay").val() != null) {
		custAccount.msgWay = $(".msgWay").val();
	}
	if ($(".custCategory").val() != '-1' && $(".custCategory").val() != null) {
		custAccount.custCategory = $(".custCategory").val();
	}
	return custAccount;
}

/**
 * 【开户操作】获得用户职业信息
 * @returns
 */
function getCustProfession() {
	var custProfession = {};
	if ($("#custProfessionId").val() != null) {
		custProfession.custProfessionId = $("#custProfessionId").val();
	}
	if ($(".profession").val() != '-1' && $(".profession").val() != null) {
		custProfession.profession = $(".profession").val();
	}
	if ($(".industry").val() != null) {
		custProfession.industry = $(".industry").val();
	}
	custProfession.companyName = $(".companyName").val();
	if ($(".post").val() != null) {
		custProfession.post = $(".post").val();
	}
	return custProfession;
}

/**
 * 【开户操作】获得客户通讯信息
 * @returns
 */
function getCustComm() {
	var custComm = {};
	if ($("#custCommId").val() != null) {
		custComm.custCommId = $("#custCommId").val();
	}
	if ($("#custAccountId").val() != null) {
		custComm.custAccountId = $("#custAccountId").val();
	}
	custComm.zipCode = $(".zipCode").val();
	custComm.areaCode = $("#areaCode").val();
	custComm.telNum = $("#telNum").val();
	custComm.email = $(".accountEmail").val();
	custComm.wechat = $(".wechat").val();
	custComm.provinceRegionCode = $(".provinceRegionCode").val();
	custComm.cityRegionCode = $("#cityRegionCode").val();
	custComm.districtRegionCode = $("#districtRegionCode").val();
	custComm.streetInfo = $("#streetInfo").val();
	return custComm;
}

/**
 * 【开户操作】获得客户联系人
 * @returns
 */
function getCustLinkman() {
	var custLinkman = {};
	if ($("#custAccountId").val() != null) {
		custLinkman.custAccountId = $("#custAccountId").val();
	}
	if ($("#custLinkmanId").val() != null) {
		custLinkman.custLinkmanId = $("#custLinkmanId").val();
	}
	custLinkman.linkmanName = $(".linkmanName").val();
	if ($(".linkmanNameSpell").val() != null) {
		custLinkman.linkmanNameSpell = $(".linkmanNameSpell").val();
	}
	custLinkman.linkmanSex = $(".linkmanSex").val();
	custLinkman.linkmanRelation = $(".linkmanRelation").val();
	if ($(".linkmanIdType").val() != '-1' && $(".linkmanIdType").val() != null) {
		custLinkman.linkmanIdType = $(".linkmanIdType").val();
	}
	if ($(".linkmanIdType").val() != '-1' && $(".linkmanIdCard").val() != '-1'
			&& $(".linkmanIdCard").val() != null) {
		custLinkman.linkmanIdCard = $(".linkmanIdCard").val();
	}
	custLinkman.linkmanMobile = $("#linkmanMobile").val();
	if ($(".linkmanAreaCode").val() != null
			&& $(".linkmanTelNum").val() != null) {
		custLinkman.areaCode = $(".linkmanAreaCode").val();
		custLinkman.telNum = $(".linkmanTelNum").val();
	}

	return custLinkman;
}


/**
 * 【开户操作】确认
 */
function createAccount(){
	var rm = "开户";
	var lenderCustCode = $("#lenderCustCode").val();
	if(null != lenderCustCode && $.trim(lenderCustCode) != "") {
			rm = "保存";
	}
	for (var i = 0; i < sunFileNumberArr.length; i++) {
		if (parseInt($("#" + sunFileNumberArr[i]).html()) == 0) {
			$.dopAlert("确认"+rm+"之前,请先上传完整文件");
			return;
		}
	}

	var conditions = {};
	conditions.cmAction = "createAccount";
	conditions.action = "createUserAccount";// 指定操作行为是确认开户
	conditions.appCode = $("#appCode").val();
	conditions.resKey = $("#resKey").val();
	conditions.custAccountId = $("#userUniqueId").val();
	
	$.dopConfirm("确认"+rm+"吗？", null, function(r) {
		if (r) {
			$.ajax({
				url : base + '/custAccountApply/createUserAccount.json',// 请求url
				type : "POST",
				async : true,
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(conditions),
				timeout : 30000,
				success : function(data) {
					if (!data) {
						$.dopAlert(rm+"失败.");
					} else {
						$.dopAlert(rm+"成功.");
						// window.open(baseUrl + "/custAccountApply/list.htm");
						TableManaged.fnDraw();
						$('#editModal').modal('hide');
					}
				},
				error : function(data) {
					$.dopAlert(rm+"异常");
				}
			});
		}
	});
}

