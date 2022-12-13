
$(function(){
	if ($("#payWayName").val() == "直接划扣") {
		$("#uploadDiv").css("top","32%");
		$("#remit").hide();
		$("#directDraw").show();
		$("#directDrawDiv").show();
		getPostCode();
		
	}if($("#payWayName").val() == "汇款"){
		$("#uploadDiv").css("top","23%");
		$("#remit").show();
		$("#directDraw").hide();
		$("#directDrawDiv").hide();
	}
	showFilesOnly();
	filedivcontrol();
});

function doCloseDiv(){
	$('#createCustApplyDiv').html("").modal('hide');
}

function filedivcontrol(){
	$("#vFile").children(".span3").css("white-space","nowrap");
}

//获取pos终端编号
function getPostCode(){
	$.ajax({
		url :	base+"/process/postCode.json",// 请求url
		type : "POST",
		async : true,
		dataType : "json",
		contentType : "application/json",	
		success : function(data) {
			$("#terminalCode").val(data.postCode);
		},
		error : function(data) {
			$.dopAlert("Pos终端号查询失败");
		}
	});
}
$("#tradeTime").change(function(){
	var dateArray = getDateArray(this);
	if(dateArray[0]>dateArray[1]){
		$(this).val("");
	}
});

function doSubmitPaymentVouchers(){
	if($("#terminalCode").val()==""&&$("#payWayName").val() == "直接划扣"){
		$.dopAlertWithNoBtns("终端号不能为空");
		return false;
	}
	if($("#tradeTime").val()==""&&$("#payWayName").val() == "直接划扣"){
		$.dopAlertWithNoBtns("划扣时间不能为空");
		return false;
	}
	var fileLength = $("#vFile > div").length;
	if(fileLength <= 0) {
		$.dopAlertWithNoBtns("请先上传支付凭证的影像文件.");
		return false;
	}
	var lenderPushDataVo = {};
	lenderPushDataVo.lenderApplyId = $("#lenderUniqueId").val();
	lenderPushDataVo.cmAction = "createAccount";
	lenderPushDataVo.action = "uploadPaymentVouchers";
	lenderPushDataVo.appCode = "wms";
	lenderPushDataVo.resKey = "wmsPaymentVouchers";
	lenderPushDataVo.lenderCode = $("#lenderCode").val();
	lenderPushDataVo.tradeTime= $("#tradeTime").val();
	lenderPushDataVo.terminalCode=$("#terminalCode").val();
	
	$.dopConfirm("确认"+$("#payWayName").val()+".", null, function(r) {
		if(r){
			$.ajax({
				url :	base+"/operate/confirm_push.json",// 请求url
				type : "POST",
				async : true,
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(lenderPushDataVo),
				timeout : 30000,
				success : function(data) {
					if(data.code){
						$.dopAlert("操作成功");
						TableManaged.fnDraw();
						$('#createCustApplyDiv').html("").modal('hide');
					}else{
						$.dopAlert(data.msg);
						TableManaged.fnDraw();
					}
				},
				error : function(data) {
					$.dopAlert("委托划扣异常");
				}
			});
		}
	});
}
