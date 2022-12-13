var TableManaged;
$().ready(function() {
	TableManaged = $('#resultList').dataTable({
		"bDestroy" : true,// 销毁
		"bFilter" : false,// 不显示搜索框
		"bSort" : true, // 排序功能
		"sScrollX" : "100%",
		"sScrollXInner" : "150%",
		"sAjaxSource" : 'list_do.json',// 请求url
		"sServerMethod" : "POST",
		"bServerSide" : true, // 异步请求
		"fnServerParams" : function(aoData) {
			aoData.push(
				{"name" : "custName","value" : $("#custNameQuery").val()}, 
				{"name" : "idCard","value" : $("#idCardQuery").val()}, 
				{"name" : "settlementDateBegin","value" : $("#settlementDateBegin").val()}, 
				{"name" : "settlementDateEnd","value" : $("#settlementDateEnd").val()}, 
				{"name" : "lenderCode","value" : $("#lenderCodeQuery").val()},
				{"name" : "productId","value" : $("#loanWayQuery").val()},
				{"name" : "lenderAmountArea","value" : $("#lenderAmountQuery").val()},
				{"name" : "currentStep","value" : $("#currentStepQuery").val()}
			);
		},
		"aoColumns" : [{
			"mData" : "lenderCode",
			"bSortable" : false,
			"sClass" : "txt-center",
		},{
			"mData" : "custName",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "idCard",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "mobile",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "productView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "lenderAmountView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "signDateView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "settleDateView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "dueDateView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "statementDateView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "formStatus",
			"bSortable" : false,
			"sClass" : "txt-center",
			"mRender" : function(data,type,full) {
				if (data == "11" || data == "13" ) {
					return "<span class='label label-error'>" + full.formStatusView + "</span>";
				}else {
					return "<span class='label label-info'>" + full.formStatusView + "</span>";
				}
			}
		},{
			"mData" : "lenderApplyId",
			"bSortable" : false,
			"sWidth" : "10%",
			"sClass" : "txt-center",	
			"mRender" : function(data,type, full) {
				if (full.formStatus == '18') {
					 return  '<button type=\'button\' class=\'btn mini red\' onclick=\'failReason("'
                     + full.approveComment
                     + '")\' >失败原因</button>'
					 +"&nbsp<button type='button' class='btn mini blue detail' lenderApplyId=" + full.lenderApplyId + " >详情</button>";
                }else{
                	return "<button type='button' class='btn mini blue detail' lenderApplyId=" + full.lenderApplyId + " >详情</button>";
                }
			}
		}],
		"aLengthMenu": [
		       	     [ 20, 40, 60, 80, 100, -1],
		       	     [ 20, 40, 60, 80, 100, "全部"] // change per page values here
		       	  ],
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
		"aoColumnDefs" : [{
			'bSortable' : false,
			'aTargets' : [ 0 ]
		}],
		// 回调函数
		"fnDrawCallback" : function(oSettings) {
			$("#query").removeAttr("disabled");
			var fsv = $("#resultList_length select[name='resultList_length']").val();
			if (fsv == "-1" || fsv == -1) {
				$("#resultList_wrapper li").addClass("disabled");
			}
		}
	});
});

$(function() {
	$("#custNameQuery").attr("maxlength", 6);
	$("#idCardQuery").attr("maxlength", 18);
	$("#lenderCodeQuery").attr("maxlength", 21);
	
	$("#query").click(function() {
		TableManaged.fnDraw();
	});
	
	$("#reset").click(function() {
		$("#custNameQuery").val("");
		$("#settlementDateBegin").val("");
		$("#settlementDateEnd").val("");
		$("#lenderCodeQuery").val("");
		$("#idCardQuery").val("");
		$("#loanWayQuery").val(-1);
		$("#currentStepQuery").val(-1);
		$("#lenderAmountQuery").val(-1);	
	});
	
});



function isEmptyString(str) {
	if (null == str || $.trim(str) == "") {
		return true;
	}
	return false;
}


function failReason(approveComment) {
   
    if (approveComment != '' && approveComment != 'null') {
        $('#showFailReason').html(approveComment);
    }
    $('#failReasonDiv').modal({
        show: true
    });
    // 给遮罩层添加关闭div层事件
    $('.modal-backdrop').attr('onclick', 'closed()');
}

/*$("#settlementDateEnd").change(function() {
	if (null != this.value && $.trim(this.value) != "") {
		var dateArr = this.value.split("-");
		var year = dateArr[0];
		var month = dateArr[1];
		var day = dateArr[2];
		var selDate = new Date($("#settlementDateEnd").val());
		selDate.setFullYear(year, month - 1, day);
		if ( selDate >= new Date($("#settlementDateBegin").val())){

		} else {
			$("#settlementDateEnd").val("");
		}
	}
	});

$("#settlementDateBegin").change(function() {
	if (null != this.value && $.trim(this.value) != "") {
		var dateArr = this.value.split("-");
		var year = dateArr[0];
		var month = dateArr[1];
		var day = dateArr[2];
		var selDate = new Date($("#settlementDateBegin").val());
		selDate.setFullYear(year, month - 1, day);
		if ( selDate <= new Date($("#settlementDateEnd").val())){

		} else {
			$("#settlementDateEnd").val("");
		}
	}
	});*/