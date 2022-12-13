$(function() {
	// 删除加载时添加的虚线

	$("#tab1 .familyMember:first").find(".lineSolid").remove();
	$("#tab1 .learnExperience:first").find(".lineSolid").remove();
	$("#tab1 .workExperience:first").find(".lineSolid").remove();
	$("#tab1 .trainExperience:first").find(".lineSolid").remove();
	$("#tab1 .familyMember:first").find(".deleteFamily").remove();
	$("#tab1 .learnExperience:first").find(".deleteLearn").remove();
	$("#tab1 .workExperience:first").find(".deleteWork").remove();
	$("#tab1 .trainExperience:first").find(".deleteTrain").remove();
	$("#tab1 .jobCategory").attr("disabled", "disabled");
	//城市民族服务单位默认选项 
	if($(".country").val()=="-1"){
		$(".country").val("1");
	}
	if($(".nation").val()=="-1"){
		$(".nation").val("1");
	}
	if($(".country").val()!="1"){
		$(".nation").attr("disabled", "disabled");
		$(".nation").val("-1");
	}
	if($(".workUnit").val()=="-1"){
		$(".workUnit").val("1");
	}
	// 需要置灰的文本框
	setDisabled([ "employeeId", "userId", "name", "sex", "certType", "certNo",
			"department", "positionId", "payAccountName", "bankName",
			"payBankCategory" ]);
	//设置城市区位置
	$(".censusAddress , .homeAddress").parent().prev().text("");
	// 设置长度
	setMaxlength({
		"censusZipCode" : 6,
		"homeZipCode" : 6,
		"censusAddress" : 50,
		"homeAddress" : 50,
		"hrEmail" : 40,
		"mobilePhone" : 11,
		"familyName" : 6,
		"familyName0" : 6,
		"fyMobilePhone" : 11,
		"fyMobilePhone0" : 11,
		"fyWorkUnit" : 30,
		"learnSchool" : 30,
		"learnMajor" : 10,
		"companyName" : 30,
		"companyDepart" : 10,
		"duties" : 10,
		"trainingOrg" : 30,
		"trainingProject" : 20,
		"certificate" : 20,
		"fundAccount" : 12,
		"bankCardNo" :	19
	});
	
	$(".fundAccount").parent().parent().find(".required").hide();

	$("#tab1 .familyMember").each(function(index, item) {
		if (index === 0) {
			return true;
		}
	})

	// 给学习经历五个框绑定一个校验事件，五个框要么都填，要么不填，否则会报提示
	$("#tab1 .learnExperience").each(function(index, item) {
		$(item).find("input[name^='learnStartdate']").rules("add", {
			"checkLearn" : false
		});
		$(item).find("input[name^='learnEnddate']").rules("add", {
			"checkLearn" : false
		});
		$(item).find("input[name^='learnSchool']").rules("add", {
			"checkLearn" : false
		});
		$(item).find("input[name^='learnMajor']").rules("add", {
			"checkLearn" : false
		});
		$(item).find("select[name^='isGraduate']").rules("add", {
			"checkLearn" : false
		});

	})

	$("#tab1 .workExperience").each(function(index, item) {
		$(item).find("input[name^='entryDateBegin']").rules("add", {
			"checkWork" : false
		});
		$(item).find("input[name^='quitDate']").rules("add", {
			"checkWork" : false
		});
		$(item).find("input[name^='companyName']").rules("add", {
			"checkWork" : false
		});
		$(item).find("input[name^='companyDepart']").rules("add", {
			"checkWork" : false
		});
		$(item).find("input[name^='duties']").rules("add", {
			"checkWork" : false
		});

	})

	$("#tab1 .trainExperience").each(function(index, item) {
		$(item).find("input[name^='startDate']").rules("add", {
			"checkTrain" : false
		});
		$(item).find("input[name^='endDate']").rules("add", {
			"checkTrain" : false
		});
		$(item).find("input[name^='trainingOrg']").rules("add", {
			"checkTrain" : false
		});
		$(item).find("input[name^='trainingProject']").rules("add", {
			"checkTrain" : false
		});
		$(item).find("input[name^='certificate']").rules("add", {
			"checkTrain" : false
		});

	})

	// 根据户籍地址省获取市
	$(".censusProvinceCode").change(
			function() {
				$(".censusCityCode option[value!='-1']").remove();
				$(".censusAreaCode option[value!='-1']").remove();
				$("input[name='censusAddress']").val("").focus();
				$.getJSON(base + '/common/region.json?param=' + this.value,
						function(data) {
							$.each(data, function(index, item) {
								$(".censusCityCode").append(
										"<option value='" + item.area_code_id
												+ "'>" + item.area_code_name
												+ "</option>");
							});
						});
			});

	// 获取区
	$(".censusCityCode").change(
			function() {
				$(".censusAreaCode option[value!='-1']").remove();
				$("input[name='censusAddress']").val("").focus();
				$.getJSON(base + '/common/region.json?param=' + this.value,
						function(data) {
							$.each(data, function(index, item) {
								$(".censusAreaCode").append(
										"<option value='" + item.area_code_id
												+ "'>" + item.area_code_name
												+ "</option>");
							});
						});
			});

	// 现居地址获取省市
	$(".homeProvinceCode").change(
			function() {
				$(".homeCityCode option[value!='-1']").remove();
				$(".homeAreaCode option[value!='-1']").remove();
				$("input[name='homeAddress']").val("").focus();
				$.getJSON(base + '/common/region.json?param='
						+ $(".homeProvinceCode").val(), function(data) {
					$.each(data, function(index, item) {
						$(".homeCityCode").append(
								"<option value='" + item.area_code_id + "'>"
										+ item.area_code_name + "</option>");
					});
				});
			});

	// 获取区
	$(".homeCityCode").change(
			function() {
				$(".homeAreaCode option[value!='-1']").remove();
				$("input[name='homeAddress']").val("").focus();
				$.getJSON(base + '/common/region.json?param='
						+ $(".homeCityCode").val(), function(data) {
					$.each(data, function(index, item) {
						$(".homeAreaCode").append(
								"<option value='" + item.area_code_id + "'>"
										+ item.area_code_name + "</option>");
					});
				});
			});

	// 开户银行省获取市
	$(".bankProvinceCode").change(
			function() {
				$(".bankCityCode option[value!='-1']").remove();
				$.getJSON(base + '/common/region.json?param=' + this.value,
						function(data) {
							$.each(data, function(index, item) {
								$(".bankCityCode").append(
										"<option value='" + item.area_code_id
												+ "'>" + item.area_code_name
												+ "</option>");
							});
						});

			});

	// 根据开户银行省市获取支行信息
	$(".bankCityCode").change(
			function() {
				$(".openAddress option[value!='-1']").remove();
				var bankVo = {};
				bankVo.provinceCode = $(".bankProvinceCode").val();
				bankVo.cityCode = this.value;
				bankVo.bankCode = "CMB";
				$.ajax({
					url : base + '/common/bank.json',
					type : 'POST',
					async : false,
					dataType : 'json',
					contentType : 'application/json',
					data : JSON.stringify(bankVo),
					timeout : 30000,
					success : function(data) {
						if (data && data != "") {
							$.each(data, function(index, item) {
								$(".openAddress").append(
										"<option value='" + item.subBankName
												+ "'>" + item.subBankName
												+ "</option>");
								$(".openAddress").val = item.subBankName;
							});
						}
						$(".openAddress").append(
								"<option value='1'>其他</option>");
						return;
					},
					error : function(data) {
						$.dopAlert("获取支行信息异常.");
						return false;
					}
				});
			});

	// 支行下拉框为1时表示其他
//	if ($(".openAddress").val() == '1') {
//		$(".otherBank").show();
//	}

	// 如果支行选择其他，则显示其他支行
	$(".openAddress").change(function() {
		$(".otherBank").hide();
		var openAddress = this.value;
		if (openAddress == '1') {
			$(".otherBank").show();
		}
	});

	// 1表示公积金缴纳地为上海，2表示外省
	var isshanghai = $("#tab2 .isshanghai").val();
	if (isshanghai == '1') {
		$("#tab2 .provinceOut").hide();
		$("#tab2 .provinceIn").show();
	} else {
		$("#tab2 .provinceOut").show();
		$("#tab2 .provinceIn").hide();
	}

	// 缴纳地不一样显示对应的信息
	$("#tab2 .isshanghai").change(function() {
		var city = this.value;
		if (city == '1') {
			$("#tab2 .provinceOut").hide();
			$("#tab2 .provinceIn").show();
		}
		if (city == '2') {
			$("#tab2 .provinceOut").show();
			$("#tab2 .provinceIn").hide();
		}
	});

	// 公积金为外省时，根据省code获取市
	$(".insuredProvinceCode").change(
			function() {
				$(".insuredCityCode option[value!='-1']").remove();
				$.getJSON(base + '/common/region.json?param=' + this.value,
						function(data) {
							$.each(data, function(index, item) {
								$(".insuredCityCode").append(
										"<option value='" + item.area_code_id
												+ "'>" + item.area_code_name
												+ "</option>");
							});
						});

			});

	// 国籍为中国时，民族不置灰
	$("#tab1 .country").change(function() {
		$("#tab1 .nation").attr("disabled", "disabled");
		if (this.value == '1') {
			$("#tab1 .nation").removeAttr("disabled");
		} else {
			$("#tab1 .nation").val('-1');
		}
	});
	$(".birthDate").change(function() {
		var thisTime = new Date();
		thisTime.setHours(23);
		thisTime.setMinutes(59);
		thisTime.setSeconds(59);
		if (this.value > thisTime) {
			$(".birthDate").val("");
		}
	});
	// 单选框的值如果与后台传值一样，则被选中
	$("#tab2").find("input:radio[name='firstOpenSocial']").each(
			function(index, item) {
				var firstSocial = this.value;
				var firstSocial2 = $(this).attr("dataValue");
				if (firstSocial == firstSocial2) {
					$(this).attr("checked", "checked");
				}
			});

	// $("input:radio[name='firstOpenSocial']").change(function(){
	// if($(this).val()==1){
	// $("#tab2").find("input:radio[name='removeSocial']").each(function(index,item){
	// if($(this).val()==2){
	// $(this).attr("checked","checked");
	// }else{
	// $(this).attr("disabled",true);
	// }
	// });
	// }
	// });

	$("#tab2").find("input:radio[name='removeSocial']").each(
			function(index, item) {
				var removeSocial = this.value;
				var removeSocial2 = $(this).attr("dataValue");
				if (removeSocial == removeSocial2) {
					$(this).attr("checked", "checked");
				}
			});

	$("input:radio[name='firstOpenFund']").change(
			function() {
				if ($(this).val() == 1) {
					$(".fundAccount").parent().parent().find(".required").hide();
					$("#tab2").find("input:radio[name='removeFund']").each(
							function(index, item) {
								if ($(this).val() == 2) {
									$(this).attr("checked", "checked");
								} else {
									$(this).attr("disabled", true);
								}
							});
				}else{
					$(".fundAccount").parent().parent().find(".required").show();
				}
				
			});

	$("#tab2").find("input:radio[name='firstOpenFund']").each(
			function(index, item) {
				var firstFund = this.value;
				var firstFund2 = $(this).attr("dataValue");
				if (firstFund == firstFund2) {
					$(this).attr("checked", "checked");
				}
			});

	$("#tab2").find("input:radio[name='removeFund']").each(
			function(index, item) {
				var removeFund = this.value;
				var removeFund2 = $(this).attr("dataValue");
				if (removeFund == removeFund2) {
					$(this).attr("checked", "checked");
				}
			});

	$("#tab2").find("input:radio[name='firstInsured']").each(
			function(index, item) {
				var firstInsured = this.value;
				var firstInsured2 = $(this).attr("dataValue");
				if (firstInsured == firstInsured2) {
					$(this).attr("checked", "checked");
				}
			});
	firstOpenSocialChange();
	firstOpenFundChange();

});

function firstOpenSocialChange() {
	if ($("input:radio[name='firstOpenSocial'][value=1]").attr("checked") == "checked") {
		$("#tab2").find("input:radio[name='removeSocial']").each(
				function(index, item) {
					if ($(this).val() == 2) {
						$(this).attr("checked", "checked");
					} else {
						$(this).attr("disabled", true);
					}
				});
	} else {
		$("#tab2").find("input:radio[name='removeSocial']").each(
				function(index, item) {
					if ($(this).val() == 1) {
						$(this).attr("disabled", false);
					}
				});
	}
}

function firstOpenFundChange() {
	if ($("input:radio[name='firstOpenFund'][value=1]").attr("checked") == "checked") {
		$("#tab2").find("input:radio[name='removeFund']").each(
				function(index, item) {
					if ($(this).val() == 2) {
						$(this).attr("checked", "checked");
					} else {
						$(this).attr("disabled", true);
					}
				});
	} else {
		$("#tab2").find("input:radio[name='removeFund']").each(
				function(index, item) {
					if ($(this).val() == 1) {
						$(this).attr("disabled", false);
					}
				});
	}
}

// 设置长度
function setMaxlength(data) {
	$.each(data, function(key, value) {
		$("." + key).attr("maxlength", value);
	});
}

// 置灰
function setDisabled(data) {
	$.each(data, function(index, item) {
		$("." + item).attr("disabled", "disabled");
	});
}

var ff = 0;
function previous() {
	if (ff == 1) {
		return false;
	}
}
function previous(tab, navigation, index) {
	if (index == 0) {
		$("#next").html("下一页");
	}
	if (index == '1') {
		$("#createEntryDiv #uploadDiv").hide();
	}
	if (index == '2') {
		$("#createEntryDiv #uploadDiv").show();
		$("#tab4").removeClass("tab-pane active");
		$("#tab4").addClass("tab-pane");
	}
}
var flagSave = true;
// 个人信息，公积金，入职启动流程，重新提交保存
function save(tab, navigation, index) {
	var employeeEntryVo = {};
	// 保存个人信息
	if (index == 1) {
		$('#createEntryDiv .form').scrollTop(0);
		var form = $("#createEntryDiv #entry_form");
		if (form.valid() == false) {
			return false;
		}
		employeeEntryVo.step = "1";
		employeeEntryVo.employeeVo = getEmployeeVo();
		employeeEntryVo.detailInfoVo = getDetailInfoVo();
		employeeEntryVo.familyVos = getFamilyVo();
		employeeEntryVo.educationVos = getEducationVo();
		employeeEntryVo.workExperienceVos = getWork();
		employeeEntryVo.trainedExperienceVos = getTrain();
		push(employeeEntryVo);
	}
	// 保存公积金
	if (index == 2) {
		var isshanghai = $("#tab2").find("select[name='isshanghai']").val();
		if (isshanghai == '1') {
			var firstOpenSocial = $("#tab2").find(
					"input:radio[name='firstOpenSocial']:checked").val();
			var removeSocial = $("#tab2").find(
					"input:radio[name='removeSocial']:checked").val();
			var firstOpenFund = $("#tab2").find(
					"input:radio[name='firstOpenFund']:checked").val();
			var removeFund = $("#tab2").find(
					"input:radio[name='removeFund']:checked").val();
			if (!firstOpenSocial || !removeSocial || !firstOpenFund
					|| !removeFund) {
				$.dopAlert("请将信息填写完整.");
				flagSave = false;
				return false;
			}
			flagSave = true;
		}
		if (isshanghai == '2') {
			var firstInsured = $("#tab2").find(
					"input:radio[name='firstInsured']:checked").val();
			if (!firstInsured) {
				$.dopAlert("请将信息填写完整.");
				flagSave = false;
				return false;
			}
			flagSave = true;
		}
		employeeEntryVo.socialVo = getSocial();
		employeeEntryVo.step = "2";
		employeeEntryVo.employeeId = $("#createEntryDiv #employeeId").val();
		push(employeeEntryVo);
		if (flagSave) {
			$("#uploadDiv").show();
		}
		$("#tab2").removeClass("tab-pane active");
		$("#tab2").addClass("tab-pane");
	}
	if(index == 3){
		var filevalidate1 = true;
		var filevalidate2 = true;
		var filevalidate3 = true;
		var filevalidate4 = true;
		console.log("submit");
		$("#vFile > input[name='videosImg']").each(function(){
			arrImgDetailList = $(this).val().split(";");
			sourceFileName=arrImgDetailList[3]
			if(arrImgDetailList[3].indexOf("身份证")>=0){
				filevalidate1=false;
			}
			if(arrImgDetailList[3].indexOf("学历证明")>=0){
				filevalidate2=false;
			}
			if(arrImgDetailList[3].indexOf("户口本")>=0){
				filevalidate3=false;
			}
			if(arrImgDetailList[3].indexOf("体检报告")>=0){
				filevalidate4=false;
			}
		});
		
		if(filevalidate1 || filevalidate2 || filevalidate3 || filevalidate4){
			$.dopAlert("请上传入职材料");
			return false;
		}
		if($("input[name='firstWorkDate']").val()!=''){
			var workDate = true;
			$("#vFile > input[name='videosImg']").each(function(){
				arrImgDetailList = $(this).val().split(";");
				if(arrImgDetailList[3].indexOf("离职证明")>=0){
					workDate=false;
				}
			});
			if(workDate){
				$.dopAlert("请上传离职证明");
				return false;
			}
		}
		
		$("#uploadDiv").hide();
	}
	
//	if (index == '3') {
//		var fileLength = getFileNumber();
//		var firstDate = $("#createEntryDiv .firstWorkDate").val();
//		if (firstDate && fileLength.lzzm === 0) {
//			$.dopAlert("请上传离职证明.");
//			flagSave = false;
//			return false;
//		}
//		if (!fileLength.sfz || !fileLength.hkb || !fileLength.tjbg
//				|| !fileLength.xlzm) {
//			$.dopAlert("请将材料上传完整.");
//			flagSave = false;
//			return false;
//		}
//		flagSave = true;
//		$("#createEntryDiv #uploadDiv").hide();
//	}
	// 提交启动流程
	if (index == '4') {
		var employeeEntryVo = {};
		employeeEntryVo.approveType = '1';
		employeeEntryVo.approveMsg = $("#tab4").find(
				"textarea[name='approveMsg']").val();
		employeeEntryVo.employeeId = $("#createEntryDiv #employeeId").val();
		var procInsId = $("#createEntryDiv #procInsId").val();
		var taskId = $("#createEntryDiv #taskId").val();
		if (taskId != null && taskId != "null") {
			employeeEntryVo.procInsId = procInsId;
			employeeEntryVo.taskId = taskId;
			employeeEntryVo.formStatus = "1";
			$.ajax({
				url : base + '/hrApprove/entry_approve.json',
				type : 'POST',
				async : false,
				dataType : 'json',
				contentType : 'application/json',
				data : JSON.stringify(employeeEntryVo),
				timeout : 30000,
				success : function(data) {
					if (data.isSuccess == '1') {
						$('#createEntryDiv').modal('hide');
						TableManaged.fnDraw();
						$.dopAlert("重新提交成功.");
						return;
					}
					$.dopAlert("重新提交失败.");
					return false;
				},
				error : function(data) {
					$.dopAlert("重新提交异常.");
					return false;
				}
			});
		} else {
			$.ajax({
				url : base + '/hrEntry/entrySave.json',
				type : 'POST',
				async : false,
				dataType : 'json',
				contentType : 'application/json',
				data : JSON.stringify(employeeEntryVo),
				timeout : 30000,
				success : function(data) {
					if (data.isSuccess == '1') {
						$('#createEntryDiv').modal('hide');
						TableManaged.fnDraw();
						$.dopAlert("保存成功.");
						return false;
					}
					$.dopAlert("保存员工信息失败.");
					return false;
				},
				error : function(data) {
					$.dopAlert("保存员工信息异常.");
					return false;
				}
			});
		}

	}

	return flagSave;

}
// 个人信息和公积金页面保存方法
function push(employeeEntryVo) {
	$
			.ajax({
				url : base + '/hrEntry/entrySave.json',
				type : 'POST',
				async : false,
				dataType : 'json',
				contentType : 'application/json',
				data : JSON.stringify(employeeEntryVo),
				timeout : 30000,
				success : function(data) {
					if (data.isSuccess == '1') {
						if (data.employeeFamilyIds != null) {
							for (var i = 0; i < data.employeeFamilyIds.length; i++) {
								var idsIn = false;
								$(".employeeFamilyId")
										.each(
												function(index, element) {
													idsIn = $(this).val() == data.employeeFamilyIds[i];
												});

								if (!idsIn) {
									$(".employeeFamilyId")
											.each(
													function(index, element) {
														if (index == i) {
															$(this)
																	.val(
																			data.employeeFamilyIds[i])
														}
													});
								}
							}
						}
						if (data.employeeEducationIds != null) {
							for (var i = 0; i < data.employeeEducationIds.length; i++) {
								var idsIn = false;
								$(".employeeEducationId")
										.each(
												function(index, element) {
													idsIn = $(this).val() == data.employeeEducationIds[i];
												});

								if (!idsIn) {
									$(".employeeEducationId")
											.each(
													function(index, element) {
														if (index == i) {
															$(this)
																	.val(
																			data.employeeEducationIds[i])
														}
													});
								}
							}
						}
						if (data.employeeWorkExperienceIds != null) {
							for (var i = 0; i < data.employeeWorkExperienceIds.length; i++) {
								var idsIn = false;
								$(".employeeWorkExperienceId")
										.each(
												function(index, element) {
													idsIn = $(this).val() == data.employeeWorkExperienceIds[i];
												});

								if (!idsIn) {
									$(".employeeWorkExperienceId")
											.each(
													function(index, element) {
														if (index == i) {
															$(this)
																	.val(
																			data.employeeWorkExperienceIds[i])
														}
													});
								}
							}
						}
						if (data.trainedIds != null) {
							for (var i = 0; i < data.trainedIds.length; i++) {
								var idsIn = false;
								$(".trainedId")
										.each(
												function(index, element) {
													idsIn = $(this).val() == data.trainedIds[i];
												});

								if (!idsIn) {
									$(".trainedId").each(
											function(index, element) {
												if (index == i) {
													$(this).val(
															data.trainedIds[i])
												}
											});
								}
							}
						}
						flagSave = true;
						return;
					}
					$.dopAlert("保存员工信息失败.");
					flagSave = false;
					return false;
				},
				error : function(data) {
					$.dopAlert("保存员工信息异常.");
					flagSave = false;
				}
			});
}
function doCloseDiv() {
	$("#createEntryDiv").modal('hide');
}
$("#submit_form #tab2").find("#city").change(function() {
	var city = this.value;
	if (city == '1') {
		$("#provinceIn").show();
		$("#provinceOut").hide();
	}
	if (city == '2') {
		$("#provinceIn").hide();
		$("#provinceOut").show();
	}
});

// 删除家庭信息
function deleteFamily(event) {
	deleteInfo(event, ".familyMember", "employeeFamilyId", 2);
}

// 删除学校信息
function deleteLearn(event) {
	deleteInfo(event, ".learnExperience", "employeeEducationId", 3);
}

// 删除工作信息
function deleteWork(event) {
	deleteInfo(event, ".workExperience", "employeeWorkExperienceId", 5);
}

// 删除培训信息
function deleteTrain(event) {
	deleteInfo(event, ".trainExperience", "trainedId", 4);
}

// 删除添加信息请求
function deleteInfo(event, parentDiv, deleteName, infoType) {
	var rm = "删除"
	var id = event.id;
	var family = $("#" + id).parents(parentDiv);
	var deleteId = family.find("input[name^=" + deleteName + "]").val();
	$(".deletetype").attr("disabled", "disabled");
	$("#save").attr("disabled", "disabled");
	$(".close-modal").attr("disabled", "disabled");
	$.dopConfirm("确认" + rm + "吗？", null, function(r) {
		if (r) {
			if (!deleteId) {
				family.remove();
				$(".deletetype").attr("disabled", false);
				$("#save").attr("disabled", false);
				$(".close-modal").attr("disabled", false);
				return;
			} else {
				var employeeEntryVo = {};
				employeeEntryVo.deleteId = deleteId;
				employeeEntryVo.infoType = infoType;
				$.ajax({
					url : base + '/hrEntry/delete.json',
					type : 'POST',
					async : false,
					dataType : 'json',
					contentType : 'application/json',
					data : JSON.stringify(employeeEntryVo),
					timeout : 30000,
					success : function(data) {

						if (data.isSuccess == '1') {
							family.remove();
							$(".deletetype").attr("disabled", false);
							$("#save").attr("disabled", false);
							$(".close-modal").attr("disabled", false);
							return;
						}
						$.dopAlert(data.msg);
						$(".deletetype").attr("disabled", false);
						$("#save").attr("disabled", false);
						$(".close-modal").attr("disabled", false);
						return false;
					},
					error : function(data) {
						$(".deletetype").attr("disabled", false);
						$("#save").attr("disabled", false);
						$(".close-modal").attr("disabled", false);
						$.dopAlert("删除信息异常.");
					}
				});
			}
		} else {
			$(".deletetype").attr("disabled", false);
			$("#save").attr("disabled", false);
			$(".close-modal").attr("disabled", false);
		}
	});
}

// 改变称谓其他家庭成员清空
$("select[name^='relationShip']").live("change", function() {
	// 从底层找到顶层
	$(this).closest(".familyMember").find("input[type='text']").val("");

});
// 添加家庭成员
$("#addMember").on(
		"click",
		function() {
			var flag = true;
			$("#tab1 .familyMember").each(
					function(index, item) {
						var relationShip = $(item).find(
								"select[name^='relationShip']").val();
						var familyName = $(item).find(
								"input[name^='familyName']").val();
						var fyWorkUnit = $(item).find(
								"input[name^='fyWorkUnit']").val();
						var fyMobilePhone = $(item).find(
								"input[name^='fyMobilePhone']").val();
						if (relationShip == '-1' || !familyName || !fyWorkUnit
								|| !fyMobilePhone) {
							$.dopAlert("请将信息填写完整.");
							flag = false;
							return false;
						}
					});
			if (!flag) {
				return;
			}
			var today = new Date().getTime();
			$(".familyMember:last").after($("#familyInfo").html());
			$("#tab1 .familyMember:last").find("select[name^='relationShip']")
					.first().attr("name", "relationShip" + today);
			var familyApp = $("#tab1 .familyMember:last").find(
					"select[name^='relationShip']").first();
			$(familyApp).rules("add", {
				"checkSelect" : true
			});
			$("#tab1 .familyMember:last").find("input[name^='familyName']")
					.first().attr("name", "familyName" + today);
			var familyName = $("#tab1 .familyMember:last").find(
					"input[name^='familyName']").first();
			$(familyName).rules("add", {
				"checkName" : true
			});
			$("#tab1 .familyMember").find("input[name^='familyName']").attr(
					"maxlength", 6);
			$("#tab1 .familyMember:last").find("input[name^='fyWorkUnit']")
					.first().attr("name", "fyWorkUnit" + today);
			var familyUtil = $("#tab1 .familyMember:last").find(
					"input[name^='fyWorkUnit']").first();
			$(familyUtil).rules("add", {
				"checkCompanyName" : true
			});
			$("#tab1 .familyMember").find("input[name^='fyWorkUnit']").attr(
					"maxlength", 30);
			$("#tab1 .familyMember:last").find("input[name^='fyMobilePhone']")
					.first().attr("name", "fyMobilePhone" + today);
			var familyMobile = $("#tab1 .familyMember:last").find(
					"input[name^='fyMobilePhone']").first();
			$(familyMobile).rules("add", {
				"checkMobile" : true
			});
			$("#tab1 .familyMember").find("input[name^='fyMobilePhone']").attr(
					"maxlength", 11);
			$("#tab1 .familyMember").find("#deleteFamily").attr("id",
					"deleteFamily" + today)

		});

// 添加学习经历
$("#addLearnExperience").on(
		"click",
		function() {
			var flag = true;
			$("#tab1 .learnExperience").each(
					function(index, item) {
						var learnStartdate = $(item).find(
								"input[name^='learnStartdate']").val();
						var learnEnddate = $(item).find(
								"input[name^='learnEnddate']").val();
						var learnSchool = $(item).find(
								"input[name^='learnSchool']").val();
						var learnMajor = $(item).find(
								"input[name^='learnMajor']").val();
						var isGraduate = $(item).find(
								"select[name^='isGraduate']").val();
						if (!learnStartdate || !learnEnddate || !learnSchool
								|| !learnMajor || isGraduate == '-1') {
							$.dopAlert("可将信息填写完整.");
							flag = false;
							return true;
						}
					});
			if (!flag) {
				return false;
			}
			$(".learnExperience:last").after($("#learnInfo").html());
			var today = new Date().getTime();
			$("#tab1 .learnExperience:last").find(
					"input[name^='learnStartdate']").first().attr("name",
					"learnStartdate" + today);
			var lrStartdate = $("#tab1 .learnExperience:last").find(
					"input[name^='learnStartdate']").first();
			// 添加的日期重新加载方法
			$(lrStartdate).datepicker();
			$(lrStartdate).rules("add", {
				"checkCertValidStart" : false
			});
			$("#tab1 .learnExperience:last")
					.find("input[name^='learnEnddate']").first().attr("name",
							"learnEnddate" + today);
			var lrEnddat = $("#tab1 .learnExperience:last").find(
					"input[name^='learnEnddate']").first();
			$(lrEnddat).datepicker();
			$(lrEnddat).rules("add", {
				"checkCertValidStart" : true
			});
			$("#tab1 .learnExperience:last").find("input[name^='learnSchool']")
					.first().attr("name", "learnSchool" + today);
			var lrSchool = $("#tab1 .learnExperience:last").find(
					"input[name^='learnSchool']").first();
			$(lrSchool).rules("add", {
				"checkSchool" : true
			});
			$(lrSchool).attr("maxlength", 30);
			$("#tab1 .learnExperience:last").find("input[name^='learnMajor']")
					.first().attr("name", "learnMajor" + today);
			var lrMajor = $("#tab1 .learnExperience:last").find(
					"input[name^='learnMajor']").first();
			$(lrMajor).rules("add", {
				"checkMajor" : true
			});
			$(lrMajor).attr("maxlength", 10);
			$("#tab1 .learnExperience:last").find("select[name^='isGraduate']")
					.first().attr("name", "isGraduate" + today);
			var lrGraduate = $("#tab1 .learnExperience:last").find(
					"select[name^='isGraduate']").first();
			$(lrGraduate).rules("add", {
				"checkSelect" : true
			});
			$("#tab1 .learnExperience").find("#deleteLearn").attr("id",
					"deleteLearn" + today);
		});

// 添加工作经历
$(".addWorkExperience").on(
		"click",
		function() {
			var flag = true;
			$("#tab1 .workExperience").each(
					function(index, item) {
						var entryDateBegin = $(item).find(
								"input[name^='entryDateBegin']").val();
						var quitDate = $(item).find("input[name^='quitDate']")
								.val();
						var companyName = $(item).find(
								"input[name^='companyName']").val();
						var companyDepart = $(item).find(
								"input[name^='companyDepart']").val();
						var duties = $(item).find("input[name^='duties']")
								.val();
						if (!entryDateBegin || !quitDate || !companyName
								|| !companyDepart || !duties) {
							$.dopAlert("请将信息填写完整.");
							flag = false;
							return false;
						}
					});
			if (!flag) {
				return false;
			}
			$(".workExperience:last").after($("#workInfo").html());
			var today = new Date().getTime();
			$("#tab1 .workExperience:last").find(
					"input[name^='entryDateBegin']").first().attr("name",
					"entryDateBegin" + today);
			var wEntryDate = $("#tab1 .workExperience:last").find(
					"input[name^='entryDateBegin']").first();
			$(wEntryDate).datepicker();
			$(wEntryDate).rules("add", {
				"checkCertValidStart" : true
			});
			$("#tab1 .workExperience:last").find("input[name^='quitDate']")
					.first().attr("name", "quitDate" + today);
			var wQuitDate = $("#tab1 .workExperience:last").find(
					"input[name^='quitDate']").first();
			$(wQuitDate).datepicker();
			$(wQuitDate).rules("add", {
				"checkCertValidStart" : true
			});
			$("#tab1 .workExperience:last").find("input[name^='companyName']")
					.first().attr("name", "companyName" + today);
			var wCompanyName = $("#tab1 .workExperience:last").find(
					"input[name^='companyName']").first();
			$(wCompanyName).rules("add", {
				"checkCompanyName" : true
			});
			$(wCompanyName).attr("maxlength", 30);
			$("#tab1 .workExperience:last")
					.find("input[name^='companyDepart']").first().attr("name",
							"companyDepart" + today);
			var wDepart = $("#tab1 .workExperience:last").find(
					"input[name^='companyDepart']").first();
			$(wDepart).rules("add", {
				"checkDepart" : true
			});
			$(wDepart).attr("maxlength", 10);
			$("#tab1 .workExperience:last").find("input[name^='duties']")
					.first().attr("name", "duties" + today);
			var WDuty = $("#tab1 .workExperience:last").find(
					"input[name^='duties']").first();
			$(WDuty).rules("add", {
				"checkDuty" : true
			});
			$("#tab1 .workExperience").find("#deleteWork").attr("id",
					"deleteWork" + today)
		});

// 添加培训经历
$(".addTrainExperience").on(
		"click",
		function() {
			var flag = true;
			$("#tab1 .trainExperience").each(
					function(index, item) {
						var startDate = $(item)
								.find("input[name^='startDate']").val();
						var endDate = $(item).find("input[name^='endDate']")
								.val();
						var trainingOrg = $(item).find(
								"input[name^='trainingOrg']").val();
						var trainingProject = $(item).find(
								"input[name^='trainingProject']").val();
						var certificate = $(item).find(
								"input[name^='certificate']").val();
						if (!startDate || !endDate || !trainingOrg
								|| !trainingProject || !certificate) {
							$.dopAlert("请将信息填写完整.");
							flag = false;
							return false;
						}
					});
			if (!flag) {
				return false;
			}
			$("#tab1 .trainExperience").after($("#trainInfo").html());
			var today = new Date().getTime();
			$("#tab1 .trainExperience:last").find("input[name^='startDate']")
					.first().attr("name", "startDate" + today);
			var startDate = $("#tab1 .trainExperience:last").find(
					"input[name^='startDate']").first();
			$(startDate).datepicker();
			$(startDate).rules("add", {
				"checkCertValidStart" : true
			});
			$("#tab1 .trainExperience:last").find("input[name^='endDate']")
					.first().attr("name", "endDate" + today);
			var endDate = $("#tab1 .trainExperience:last").find(
					"input[name^='endDate']").first();
			$(endDate).datepicker();
			$(endDate).rules("add", {
				"checkCertValidStart" : true
			});
			$("#tab1 .trainExperience:last").find("input[name^='trainingOrg']")
					.first().attr("name", "trainingOrg" + today);
			var trainingOrg = $("#tab1 .trainExperience:last").find(
					"input[name^='trainingOrg']").first();
			$(trainingOrg).rules("add", {
				"checkOrg" : true
			});
			$(trainingOrg).attr("maxlength", 30);
			$("#tab1 .trainExperience:last").find(
					"input[name^='trainingProject']").first().attr("name",
					"trainingProject" + today);
			var trainingProject = $("#tab1 .trainExperience:last").find(
					"input[name^='trainingProject']").first();
			$(trainingProject).rules("add", {
				"checkProject" : true
			});
			$(trainingProject).attr("maxlength", 20);
			$("#tab1 .trainExperience:last").find("input[name^='certificate']")
					.first().attr("name", "certificate" + today);
			var certificate = $("#tab1 .trainExperience:last").find(
					"input[name^='certificate']").first();
			$(certificate).rules("add", {
				"checkCate" : true
			});
			$(certificate).attr("maxlength", 20);
			$("#tab1 .trainExperience").find("#deleteTrain").attr("id",
					"deleteTrain" + today)
		});

// 获取个人基本信息
function getEmployeeVo() {
	var employeeVo = {};
	employeeVo.employeeId = $("#createEntryDiv #employeeId").val();
	employeeVo.name = $("#tab1 .name").val();
	employeeVo.sex = $("#tab1").find("input[colName='sex']").val();
	employeeVo.mobilePhone = $("#tab1 .mobilePhone").val();
	employeeVo.certType = $("#tab1").find("input[colName='certType']").val();
	employeeVo.certNo = $("#tab1 .certNo").val();
	employeeVo.entryDate = $("#tab1 .entryDate").val();
	employeeVo.jobCategory = $("#tab1").find("input[colName='jobCategory']")
			.val();
	return employeeVo;
}

// 获取个人详情
function getDetailInfoVo() {
	var detailInfoVo = {};
	detailInfoVo.employeeDetailId = $("#tab1").find(
			"input[name='employeeDetailId']").val();
	detailInfoVo.entrySource = $("#tab1 .entrySource").val();
	detailInfoVo.certValidStart = $("#tab1 .certValidStart").val();
	detailInfoVo.certValidEnd = $("#tab1 .certValidEnd").val();
	detailInfoVo.birthDate = $("#tab1 .birthDate").val();
	detailInfoVo.email = $("#tab1 .hrEmail").val();
	detailInfoVo.politicalStatus = $("#tab1 .politicalStatus").val();
	detailInfoVo.degree = $("#tab1 .HrEducation").val();
	detailInfoVo.country = $("#tab1 .country").val();
	if ($("#tab1 .country").val() == '1') {
		detailInfoVo.nation = $("#tab1 .nation").val();
	}
	detailInfoVo.workUnit = $("#tab1 .workUnit").val();
	detailInfoVo.maritalStatus = $("#tab1 .maritalStatus").val();
	detailInfoVo.firstWorkDate = $("#tab1 .firstWorkDate").val();
	detailInfoVo.censusProvinceCode = $("#tab1 .censusProvinceCode").val();
	detailInfoVo.censusRegister = $("#tab1 .censusRegister").val();
	detailInfoVo.censusCityCode = $("#tab1 .censusCityCode").val();
	detailInfoVo.censusAreaCode = $("#tab1 .censusAreaCode").val();
	detailInfoVo.censusAddress = $("#tab1 .censusAddress").val();
	detailInfoVo.censusZipCode = $("#tab1 .censusZipCode").val();
	detailInfoVo.homeProvinceCode = $("#tab1 .homeProvinceCode").val();
	detailInfoVo.homeCityCode = $("#tab1 .homeCityCode").val();
	detailInfoVo.homeAreaCode = $("#tab1 .homeAreaCode").val();
	detailInfoVo.homeAddress = $("#tab1 .homeAddress").val();
	detailInfoVo.homeZipCode = $("#tab1 .homeZipCode").val();
	detailInfoVo.bankProvinceCode = $("#tab1 .bankProvinceCode").val();
	detailInfoVo.bankCityCode = $("#tab1 .bankCityCode").val();
	detailInfoVo.bankCardNo = $("#tab1 .bankCardNo").val();
	var openAdd = $("#tab1 .openAddress").val();
	if (openAdd != '-1' && openAdd != '1') {
		detailInfoVo.openAddress = $("#tab1 .openAddress").find(
				"option:selected").text();
	}
	if (openAdd == '1') {
		detailInfoVo.otherAddress = $("#tab1 .otherAddress").val();
	}
	return detailInfoVo;
}

// 获取家庭信息
function getFamilyVo() {
	var familyVos = [];
	$("#tab1 .familyMember")
			.each(
					function(index, item) {
						var familyVo = {};
						familyVo.employeeFamilyId = $(item).find(
								"input[name^=employeeFamilyId]").val();
						familyVo.relationShip = $(item).find(
								"select[name^='relationShip']").val();
						familyVo.name = $(item).find(
								"input[name^='familyName']").val();
						familyVo.mobilePhone = $(item).find(
								"input[name^='fyMobilePhone']").val();
						familyVo.workUnit = $(item).find(
								"input[name^='fyWorkUnit']").val();
						familyVos.push(familyVo);
					});
	return familyVos;
}

// 学校信息
function getEducationVo() {
	var educationVos = [];
	$("#tab1 .learnExperience")
			.each(
					function(index, item) {
						var educationVo = {};
						var employeeEducationId = $(item).find(
								"input[name^='employeeEducationId']").val();
						educationVo.employeeEducationId = employeeEducationId;
						var school = $(item).find("input[name^='learnSchool']")
								.val();
						educationVo.school = school;
						var startdate = $(item).find(
								"input[name^='learnStartdate']").val();
						educationVo.startdate = startdate;
						var enddate = $(item).find(
								"input[name^='learnEnddate']").val();
						educationVo.enddate = enddate;
						var major = $(item).find("input[name^='learnMajor']")
								.val();
						educationVo.major = major
						var isGraduate = $(item).find(
								"select[name^='isGraduate']").val();
						educationVo.isGraduate = isGraduate;
						if (school && startdate && enddate && major
								&& isGraduate != '-1') {
							educationVos.push(educationVo);
						}

					});
	return educationVos;
}

// 工作经历
function getWork() {
	var workExperienceVos = [];
	$("#tab1 .workExperience")
			.each(
					function(index, item) {
						var workExperienceVo = {};
						var employeeWorkExperienceId = $(item).find(
								"input[name^='employeeWorkExperienceId']")
								.val();
						workExperienceVo.employeeWorkExperienceId = employeeWorkExperienceId;
						var companyName = $(item).find(
								"input[name^='companyName']").val();
						workExperienceVo.companyName = companyName;
						var entryDate = $(item).find(
								"input[name^='entryDateBegin']").val();
						workExperienceVo.entryDate = entryDate;
						var quitDate = $(item).find("input[name^='quitDate']")
								.val();
						workExperienceVo.quitDate = quitDate;
						var department = $(item).find(
								"input[name^='companyDepart']").val();
						workExperienceVo.department = department;
						var duties = $(item).find("input[name^='duties']")
								.val();
						workExperienceVo.duties = duties;
						if (companyName && entryDate && quitDate && department
								&& duties) {
							workExperienceVos.push(workExperienceVo);
						}
					});
	return workExperienceVos;
}

// 培训经历
function getTrain() {
	var trainedExperienceVos = [];
	$("#tab1 .trainExperience").each(
			function(index, item) {
				var trainedExperienceVo = {};
				var trainedId = $(item).find("input[name^='trainedId']").val();
				trainedExperienceVo.trainedId = trainedId;
				var trainingOrg = $(item).find("input[name^='trainingOrg']")
						.val();
				trainedExperienceVo.trainingOrg = trainingOrg;
				var startDate = $(item).find("input[name^='startDate']").val();
				trainedExperienceVo.startDate = startDate;
				var endDate = $(item).find("input[name^='endDate']").val();
				trainedExperienceVo.endDate = endDate;
				var trainingProject = $(item).find(
						"input[name^='trainingProject']").val();
				trainedExperienceVo.trainingProject = trainingProject;
				var certificate = $(item).find("input[name^='certificate']")
						.val();
				trainedExperienceVo.certificate = certificate;
				if (trainingOrg && startDate && endDate && trainingProject
						&& certificate) {
					trainedExperienceVos.push(trainedExperienceVo);
				}
			});
	return trainedExperienceVos;
}

function getSocial() {
	var socialVo = {};
	var whether = $("#tab2").find("select[name='isshanghai']").val()
	socialVo.isshanghai = whether;
	socialVo.employeeSocialSecurityId = $("#tab2").find(
			"input[name='employeeSocialSecurityId']").val();
	if (whether == '1') {
		socialVo.fundAccount = $("#tab2 .fundAccount").val();
		socialVo.firstOpenSocial = $("#tab2").find(
				"input:radio[name='firstOpenSocial']:checked").val();
		socialVo.removeSocial = $("#tab2").find(
				"input:radio[name='removeSocial']:checked").val();
		socialVo.firstOpenFund = $("#tab2").find(
				"input:radio[name='firstOpenFund']:checked").val();
		socialVo.removeFund = $("#tab2").find(
				"input:radio[name='removeFund']:checked").val();

	}
	if (whether == '2') {
		socialVo.insuredProvinceCode = $("#tab2 .insuredProvinceCode").val();
		socialVo.insuredCityCode = $("#tab2 .insuredCityCode").val();
		socialVo.firstInsured = $("#tab2").find(
				"input:radio[name='firstInsured']:checked").val();
	}
	return socialVo;
}

/**
 * 检验手机号码的唯一性
 * @returns {Boolean}
 */
//function checkMobilePhone(){
//	var mobilePhone=$(".mobilePhone").val();
//	var flag=true;
//	$.ajax({
//		url : base + "/common/check_hrMobile.json",
//		type : 'POST',
//		async : false,
//		data : "mobile="+mobilePhone,
//		success : function(data) {
//			flag=data;
//		}
//	});
//	if(!flag){
//		$(".mobilePhone").focus();
//	}
//	return flag;
//}
