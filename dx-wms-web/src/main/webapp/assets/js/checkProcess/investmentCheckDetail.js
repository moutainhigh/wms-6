$(function() {
	showAccountInfo($("#custAccountId").val());
	showVideoInfo($("#custAccountId").val());
	showApplyInfo($("#custAccountId").val());
	showApproveInfo($("#custAccountId").val());
	setInterval("showButtons()", 500);
});

/**
 * 不同信息页面显示的按钮不一样（关闭、提交执委会、拒绝）
 */
function showButtons() {
	if ($("#tab_1_1").is(":hidden") == false) {
		$("#close_tab").show();
		$("#submit_tab").hide();
		$("#refuse_tab").hide();
		$("#tab_1_1 input").attr("disabled", "disabled");
		$("#tab_1_1 select").attr("disabled", "disabled");
	} else if ($("#tab_1_2").is(":hidden") == false) {
		$("#close_tab").show();
		$("#submit_tab").hide();
		$("#refuse_tab").hide();
		$("#tab_1_2 input").attr("disabled", "disabled");
		$("#tab_1_2 select").attr("disabled", "disabled");
		$("#tab_1_2 textarea").attr("disabled", "disabled");
	} else if ($("#tab_1_3").is(":hidden") == false) {
		$("#close_tab").show();
		$("#submit_tab").hide();
		$("#refuse_tab").hide();
	}else if ($("#tab_1_4").is(":hidden") == false) {
		$("#close_tab").show();
		$("#submit_tab").show();
		$("#refuse_tab").show();
	}
}


function showAccountInfo(custAccountId) {
	var url = base + '/process/applyPersonInfo.json?type=2' + '&custAccountId='
			+ custAccountId + "&lenderCode=" + $("#lenderCode").val();
	$.post(url, {}, function(data, status) {
		$('#applyPersonInfo').html(data);
	});
	$("#applyPersonInfo input").attr("disabled", "disabled");
	$("#applyPersonInfo select").attr("disabled", "disabled");
}

function showVideoInfo(custAccountId) {
	var url = 'applyVideoInfo.json?custAccountId=' + custAccountId
			+ '&lenderApplyId=' + $("#lenderApplyId").val() + '&lenderCode='
			+ $("#lenderCode").val();
	$.post(url, {}, function(data, status) {
		$('#applyVideoInfo').html(data);
	});
}

function showApplyInfo(custAccountId) {
	var url = 'applyInfo.json?custAccountId=' + custAccountId
			+ '&lenderApplyId=' + $("#lenderApplyId").val();
	$.post(url, {}, function(data, status) {
		$('#applyInfo').html(data);
	});
}

/**
 * 显示审批信息
 * @param custAccountId
 */
function showApproveInfo(custAccountId) {
	var url = base + '/process/approveInfo.json?custAccountId='
			+ custAccountId + '&lenderApplyId=' + $("#lenderApplyId").val()
			+ '&lenderCode=' + $("#lenderCode").val();
	$.post(url, {}, function(data, status) {
		$('#approveInfo').html(data);
	});
}

function doCloseTab() {
	if (ff == 1) {
		return false;
	}
	TableManaged.fnDraw();
	$('#createCustApplyDiv').modal('hide');
}

/**
 * 关闭当前网页
 */
function closeWebPage() {
	if (navigator.userAgent.indexOf("MSIE") > 0) {
		if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
			window.opener = null;
			window.close();
		} else {
			window.open('', '_top');
			window.top.close();
		}
	} else if (navigator.userAgent.indexOf("Firefox") > 0) {
		// window.location.href = 'about:blank ';
		// window.open('','_parent','');
		// window.opener = window;
		window.close();
	} else {
		window.opener = null;
		window.open('', '_self', '');
		window.close();
	}
}
var ff = 0;
function doSubmitTab(action) {
	if (ff == 1) {
		return false;
	}
	var approveComment = $("#approveComment").val();
	if (null == approveComment || "" == $.trim(approveComment)) {
		ff = 1;
		$.dopAlert("审批内容为空,请填写!!!!", null, function(r) {
			ff = 0;
		});
		return false;
	}
	var custAccountId = $("#custAccountId").val();
	var lenderApplyId = $("#lenderApplyId").val();
	var lenderCode = $("#lenderCode").val();

	var businessQuality = {};
	businessQuality.custAccountId = custAccountId;
	businessQuality.approveComment = approveComment;
	businessQuality.lenderApplyId = lenderApplyId;
	businessQuality.lenderCode = lenderCode;
	businessQuality.currentAction = action;

	var rm = "";
	if ("1" == action) {
		rm = "提交运营";
	} else {
		rm = "拒绝";
	}
	ff = 1;
	$.dopConfirm("确认" + rm + "?", null, function(r) {
		if (r) {
			$.ajax({
				url : base + '/operate/submit.json',// 请求url
				type : "POST",
				async : true,
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(businessQuality),
				timeout : 30000,
				success : function(data) {
					if (data) {
						if (data.code == "101") {
							$.dopAlert(rm + "成功");
							TableManaged.fnDraw();
							$('#createCustApplyDiv').modal('hide');
						} else {
							$.dopAlert(rm + "失败");
						}
					} else {
						$.dopAlert(rm + "出现异常,请重试");
					}
				},
				error : function(data) {
					$.dopAlert(rm + "出现异常,请重试");
				}
			});
		} else {
			ff = 0;
		}
	});
}
