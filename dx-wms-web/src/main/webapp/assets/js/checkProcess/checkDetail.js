$(function() {
	initPages();
	setInterval("showButtons()", 500);
});


/**
 * 不同信息页面显示的按钮不一样（关闭、提交、拒绝）
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
/**
 * 初始化投资信息、影像信息、审批信息
 */
function initPages(){
	var pageIds=["applyPersonInfo","applyVideoInfo","applyInfo","approveInfo"];
	$.each(pageIds,function(index,item){
		showPageInfo(index,item);
	});
}

/**
 * 显示质检页面信息
 * @param index
 * @param id
 */
function showPageInfo(index,id){
	var url="";
	if(index==0){
		url = base + '/process/'+id+'.json?type=2' + '&custAccountId='
		+ $("#custAccountId").val() + "&lenderCode=" + $("#lenderCode").val();
		
	}else{
		url = id+'.json?custAccountId=' + $("#custAccountId").val()
		+ '&lenderApplyId=' + $("#lenderApplyId").val() + '&lenderCode='
		+ $("#lenderCode").val();
	}
	$.post(url, {}, function(data, status) {
		$('#'+id).html(data);
	});
	if(index==0){
		$("#"+id+" input").attr("disabled", "disabled");
		$("#"+id+" select").attr("disabled", "disabled");
	}
}

function doCloseTab(id) {
	if (ff == 1) {
		return false;
	}
	TableManaged.fnDraw();
	$('#'+id).modal('hide');
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
function doSubmitTab(action,id,curObject) {
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
	/*if ("1" == action) {
		rm = $(curObject).text();
	} else {
		rm = $(curObject).text();
	}*/
	rm=$.trim($(curObject).text());
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
					console.log(data.result);
					if (data.result) {
						$.dopAlert(rm + "成功");
						TableManaged.fnDraw();
						$('#detailModal').modal('hide');
						$('#createCustApplyDiv').modal('hide');
					} else {
						$.dopAlert(rm + "失败");
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
