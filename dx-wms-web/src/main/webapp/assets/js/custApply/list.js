var TableManaged;

function lenderApply(custAccountId) {
	window.open(base + "/process/add_create.json?custAccountId="+custAccountId+"&lenderApplyId=-1");
}

$().ready(function() {
	TableManaged = $('#resultList').dataTable({
		"bDestroy" : true,// 销毁
		"bFilter" : false,// 不显示搜索框
		"bSort" : true, // 排序功能
		"sScrollX" : "100%",
		"sScrollXInner" : "130%",
		"sAjaxSource" : 'add.json',// 请求url
		"sServerMethod" : "POST",
		"bServerSide" : true, // 异步请求
		"fnServerParams" : function(aoData) {
			aoData.push({
				"name" : "custName",
				"value" : $("#custNameQuery")
						.val()
			}, {
				"name" : "idCard",
				"value" : $("#idCardQuery")
						.val()
			}, {
				"name" : "signDateBegin",
				"value" : $("#signDateBegin")
						.val()
			}, {
				"name" : "signDateEnd",
				"value" : $("#signDateEnd")
						.val()
			}, {
				"name" : "productId",
				"value" : $("#loanWayQuery")
						.val()
			}, {
				"name" : "mobile",
				"value" : $("#mobile").val()
			}, {
				"name" : "lenderCode",
				"value" : $("#lenderCodeQuery").val()
			}, {
				"name" : "lenderAmountArea",  
				"value" : $("#lenderAmountQuery").val()
			});
		},
		"aoColumns" : [{
			"mData" : "lenderCode",
			"bSortable" : false,
			"sWidth":"50px",
			"sClass" : "txt-center",
			"mRender" : function(data, type, full) {
			    if(full.parentId > 0 ) {
			    	return "<span style='color:red'>" + data + "</span>";
			    } else {
			    	return "<span >" + data + "</span>";
			    }
			}
		},
		{
			"mData" : "custName",
			"bSortable" : false,
			"sWidth":"70px",
			"sClass" : "txt-center"
		},
		{
			"mData" : "idCard",
			"bSortable" : false,
			"sWidth":"70px",
			"sClass" : "txt-center"
		},
		{
			"mData" : "mobile",
			"bSortable" : false,
			"sWidth":"70px",
			"sClass" : "txt-center"
		},
		{
			"mData" : "signDate",
			"bSortable" : false,
			"sWidth":"70px",
			"sClass" : "txt-center"
		},
		{
			"mData" : "product",
			"bSortable" : false,
			"sWidth":"70px",
			"sClass" : "txt-center"
		},

		{
			"mData" : "lenderAmountView",
			"bSortable" : false,
			"sWidth":"70px",
			"sClass" : "txt-center"
		},
		{
			"mData" : "payWay",
			"bSortable" : false,
			"sWidth":"70px",
			"sClass" : "txt-center"
		},
		{
			"mData" : "formStatusView",
			"bSortable" : false,
			"sWidth":"70px",
			"sClass" : "txt-center"
		},
		{
			"mData" : "formStatus",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth":"100px",
			"mRender" : function(data, type, full) {
				if (data == "11" || data == "13") {
					return "<button type='button' class='btn mini red' onclick='editProcess(\""
					+full.lenderApplyId
					+ "\",\""
					+ full.payWay
					+ "\")'  >重新提交</button>"
					+ "&nbsp;<button type='button' class='btn mini blue detail' lenderApplyId="+full.lenderApplyId+" tempPayWay="+full.payWay+">详情</button>";
				} 
				return "<button type='button' class='btn mini blue' onclick='editProcess(\""
					+ full.lenderApplyId
					+ "\",\""
					+ full.payWay
					+ "\")'  >编辑</button>"
					+ "&nbsp;<button type='button' class='btn mini blue detail' lenderApplyId="+full.lenderApplyId+" tempPayWay="+full.payWay+">详情</button>";
				}
		} ],
		"aLengthMenu": [
		       	     [ 20, 40, 60, 80, 100, -1],
		       	     [ 20, 40, 60, 80, 100, "全部"] // change per page values here
		       	  ],
		// set the initial value
		"iDisplayLength" : 20,
		"sPaginationType" : "bootstrap",
		"oLanguage" : {
			"sLengthMenu" : "每页显示 _MENU_ 条记录",
			"sZeroRecords" : "抱歉， 没有找到",
			"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
			"sInfoEmpty" : "显示 0 至 0 共 0 项",
			"oPaginate" : {
				"sPrevious" : "上一页",
				"sNext" : "下一页"
			}
		},
		"aoColumnDefs" : [ {
			'bSortable' : false,
			'aTargets' : [ 0 ]
		} ],
		// 回调函数
		"fnDrawCallback" : function(oSettings) {
			$("#query").removeAttr("disabled");
			var fsv = $(
					"#resultList_length select[name='resultList_length']")
					.val();
			if (fsv == "-1" || fsv == -1) {
				$("#resultList_wrapper li")
						.addClass("disabled");
							}
						}
					});
});

$(function() {
	$("#custName").attr("maxlength", 20);
	$("#idCard").attr("maxlength", 18);
	$("#mobile").attr("maxlength", 11);
	$("#query").click(function() {
		TableManaged.fnDraw();
	});

	$("#reset").click(
			function() {
				$("#custNameQuery").val("");
				$("#signDateBegin").val("");
				$("#signDateEnd").val("");
				$("#mobile").val("");
				$("#idCardQuery").val("");
				$("#loanWayQuery").val("-1");
				$("#lenderAmountQuery").val("-1");
				$("#lenderCodeQuery").val("");
				$("#matchQueueForm").find(":input").not(
						":button,:submit,:reset,:hidden").val("").removeAttr(
						"checked").removeAttr("selected");
				$("select[name=resultList_length]").val(15);
			});

	$("#create").click(function() {
		var url = base + "/select/account.json";
		$.get(url, function(data) {
			$('#editModal').html(data);
		});
		$('#editModal').modal({
			show : true
		});
	});
	
	$(".edit").live("click",function(){
		var url = base + "/save/apply_edit.json?id="+$(this).attr("lenderApplyId");
		$.get(url, function(data) {
			$('#editModal').html(data);
		});
		$('#editModal').modal({
			show : true
		});
	});
});
function closed() {
	$('#failReasonDiv').modal("hide");
	$("#dealDetail").hide();
	$("#showFailReason").html("未说明出资失败理由");
}

function editProcess(lenderApplyId, payWay) {
	var url = base + "/save/apply_edit.json?id="+lenderApplyId;
	if(payWay=="续投"){
		url = base + "/save/dueApply_edit.json?id="+lenderApplyId;
	}
	$.get(url, function(data) {
		$('#editModal').html(data);
	});
	$('#editModal').modal({
		show : true
	});
	
//	var url = base + "/process/add_create.json?custAccountId=" + custAccountId
//			+ "&lenderApplyId=" + lenderApplyId;
//	$.get(url, function(data) {
//		$('#detailModal').html(data);
//	});
//	$('#detailModal').modal({
//		show : true
//	});
}

/*$("#signDateBegin").change(function() {
	if (null != this.value && $.trim(this.value) != "") {
		var dateArr = this.value.split("-");
		var year = dateArr[0];
		var month = dateArr[1];
		var day = dateArr[2];
		var selDate = new Date();
		selDate.setFullYear(year, month - 1, day);

		if (selDate <= new Date()) {

		} else {
			$("#signDateBegin").val("");
		}
	}

});

$("#signDateEnd").change(function() {
	if (null != this.value && $.trim(this.value) != "") {
		var dateArr = this.value.split("-");
		var year = dateArr[0];
		var month = dateArr[1];
		var day = dateArr[2];
		var selDate = new Date($("#signDateBegin").val());
		selDate.setFullYear(year, month - 1, day);

		if (selDate >= new Date($("#signDateBegin").val())) {

		} else {
			$("#signDateEnd").val("");
		}
	}
});
*/


//function AccountDetail(custAccountId, lenderApplyId) {
//	var url = base + "/detail/detailApply.json?type=2&custAccountId="
//			+ custAccountId + "&lenderApplyId=" + lenderApplyId;
//	$.get(url, function(data) {
//		$('#detailModal').html(data);
//	});
//	$('#detailModal').modal({
//		show : true
//	});
//}

//function confirmProcess(lenderApplyId, payWayId) {
//	if (payWayId == "汇款" || payWayId == "直接划扣") {
//		showUploadPaymentVouchersWindow(lenderApplyId);
//	}
//
//	var lenderPushDataVo = {};
//	lenderPushDataVo.payWay = payWayId;
//	lenderPushDataVo.lenderApplyId = lenderApplyId;
//	if (payWayId == "委托划扣") {
//		$.dopConfirm("确认委托划扣吗？", null, function(r) {
//			if (r) {
//				$.ajax({
//					url : 'confirm_push.json',// 请求url
//					type : "POST",
//					async : true,
//					dataType : "json",
//					contentType : "application/json",
//					data : JSON.stringify(lenderPushDataVo),
//					timeout : 30000,
//					success : function(data) {
//						if (data.code) {
//							$.dopAlert("操作成功");
//							TableManaged.fnDraw();
//						} else {
//							$.dopAlert(data.msg);
//							TableManaged.fnDraw();
//						}
//					},
//					error : function(data) {
//						$.dopAlert("委托划扣异常");
//					}
//				});
//			}
//		});
//	}
//}
//
//function showUploadPaymentVouchersWindow(lenderApplyId) {
//	var url = base
//			+ "/custApply/voucher.json?lenderApplyId="
//			+ lenderApplyId
//			+ "&appCode=wms&resKey=wmsPaymentVouchers&cmAction=getFileStoreDirectory";
//	$.get(url, function(data) {
//		$('#createCustApplyDiv').html(data);
//	});
//	$('#createCustApplyDiv').modal({
//		show : true
//	});
//}
//
//function giveUp(lenderApplyId){
//	var lenderPushDataVo = {};
//	lenderPushDataVo.lenderApplyId = lenderApplyId;
//	$.dopConfirm("确认取消出资吗？", null, function(r) {
//		if (r) {
//			$.ajax({
//				url : 'giveUp.json',// 请求url
//				type : "POST",
//				async : true,
//				dataType : "json",
//				contentType : "application/json",
//				data : JSON.stringify(lenderPushDataVo),
//				timeout : 30000,
//				success : function(data) {
//					if (data.code) {
//						$.dopAlert("取消出资成功");
//						TableManaged.fnDraw();
//					}else {
//						$.dopAlert(data.msg);
//						TableManaged.fnDraw();
//					}
//				},
//				error : function(data) {
//					$.dopAlert("取消出资异常");
//				}
//			});
//		}
//	});
//}
//
//function reMatch(lenderApplyId) {
//	var lenderPushDataVo = {};
//	lenderPushDataVo.lenderApplyId = lenderApplyId;
//	$.dopConfirm("确认重新匹配吗？", null, function(r) {
//		if (r) {
//			$.ajax({
//				url : 'reMatch.json',// 请求url
//				type : "POST",
//				async : true,
//				dataType : "json",
//				contentType : "application/json",
//				data : JSON.stringify(lenderPushDataVo),
//				timeout : 30000,
//				success : function(data) {
//					if (data.code) {
//						$.dopAlert("拒绝匹配");
//						TableManaged.fnDraw();
//					}
//				},
//				error : function(data) {
//					$.dopAlert("重新匹配异常");
//				}
//			});
//		}
//	});
//}
//
//function failReason(lenderApplyId, payWayId, approveComment) {
//	varLenderApplyId = lenderApplyId;
//	if (payWayId == "委托划扣") {
//		$("#dealDetail").show();
//		//$('#dealDetail').modal('hide');
//	}else{
//		$("#dealDetail").hide();
//	}
//	
//	if(approveComment.length>0 && approveComment !="null"){
//		$("#showFailReason").html(approveComment);
//	}
//	$('#failReasonDiv').modal({
//		show : true
//	});
//}
//
//function dealDetail() {
//	var url = base + "/custApply/dealDetail.json?lenderApplyId=" + varLenderApplyId;
//	$.ajax({
//		type : "post",
//		url : url,
//		dataType : "json",
//		async : false,
//		success : function(datas) {
//			$("#dealDetailList").html("");
//			var tabHTML = "";
//			if (datas && datas.length>0 ) {		
//				for(var i = 0; i < datas.length; i++) {
//					var tempData = datas[i];
//				   	tabHTML += "<tr>";
//					tabHTML += "<td>" + tempData.tradeCommitTime + "</td>";
//					tabHTML += "<td>" + tempData.tradeAmount + "</td>";
//					tabHTML += "<td>" + tempData.tradeResult + "</td>";
//					tabHTML += "<td>" + tempData.remark + "</td>";
//					tabHTML += "</tr>";
//		   		}
//		   		$("#dealDetailList").html(tabHTML);
//			} 
//		}
//	});
//	
//	$('#dealDetailDiv').modal({
//		show : true
//	});
//	
//}
