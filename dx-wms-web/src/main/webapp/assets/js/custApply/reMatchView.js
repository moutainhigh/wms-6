$(function(){
	//使滚动条在最顶端
	$(".tab-content").scrollTop(0);
	//初始化重新匹配列表
	showFilesOnly();
});

/**
 * 预提交重新匹配
 */
function reMatchUI(){
	var fileLength = $("#vFile > div").length;
	if(fileLength <= 0) {
		$.dopAlertWithNoBtns("请先上传回执拒绝的影像文件.");
		return false;
	}
	
	var checkFlag = false;
	var poolIds = [];
	$(":checkbox[name='reMatch']").each(function(i) {		
		if ($(this).attr("checked")) {
			var val = $(this).val();
			if(val != '-1' ){
				checkFlag = true;						
				poolIds.push(val);
			}
			return;
		}
	});
	
	if(!checkFlag){
		$.dopAlertWithNoBtns('请选择拒绝的债权数据');
		return false;
	}

	if(poolIds!=null){
		$("input:checkbox","#matchResult_wrapper").attr("disabled","disabled");
		$.dopConfirm("确认重新匹配吗？", null, function(r) {
			if (r) {
				confirmReMatch(poolIds);
			}
			$("input:checkbox","#matchResult_wrapper").removeAttr("disabled");
		});
		
	}else{
		$.dopAlert("请选择需要重新匹配的债权数据");
	}
	
}

/**
 * 确定重新匹配的提交
 * @param poolIds
 * @param lenderCode
 * @param lenderApplyId
 */
function confirmReMatch(poolIds){
	var lenderPushDataVo = {};
	lenderPushDataVo.lenderApplyId = $("#lenderApplyId").val();
	lenderPushDataVo.cmAction = "createAccount";
	lenderPushDataVo.appCode = "wms";
	lenderPushDataVo.resKey = "wmsRefuseReceipt";
	lenderPushDataVo.lenderCode = $("#lenderCode").val();
	lenderPushDataVo.poolIds=poolIds;
	lenderPushDataVo.action = "uploadPaymentVouchers";
	lenderPushDataVo.approveComment= $("#approveComment").val();
	$.ajax({
		url : base+'/operate/submitReMatch.json',
		type : "POST",
		async : true,
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(lenderPushDataVo),
		timeout : 3000,
		success : function(data) {
			if (data.code) {
				$.dopAlert("操作成功");
				TableManaged.fnDraw();
				$("#returnMatchDiv").modal("hide");
			} else {
				$.dopAlert(data.msg);
			}
		},
		error : function(data) {
			$.dopAlert("请求超时");
		}
	});

}

/**
 * 关闭重新匹配div层,同事移除tr、checkbox标签上的click事件
 */
function doCloseDiv(){
	$("#reMatchList").empty();
	$(".portlet-body","#form_wizard_1").scrollTop(0);
	$(".tableBox","#tableFirst").scrollLeft(0);
	$('#returnMatchDiv').html("").modal('hide');
}



