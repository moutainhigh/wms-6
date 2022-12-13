var TableManaged;
$().ready(function() {
	TableManaged = $('#resultList').dataTable({
		"bDestroy" : true,// 销毁
		"bFilter" : false,// 不显示搜索框
		"bSort" : true, // 排序功能
		"sScrollX" : "100%",
		"sScrollXInner" : "130%",
		"sAjaxSource" : 'list_do.json',// 请求url
		"sServerMethod" : "POST",
		"bServerSide" : true, // 异步请求
		"fnServerParams" : function(aoData) {
			aoData.push(
				{"name" : "custName","value" : $("#custName").val()},
				{"name" : "currentStep","value" : $("#currentStep").val()},
				{"name" : "signDateBegin","value" : ($("#signDateBegin").val())},
				{"name" : "signDateEnd", "value" : ($("#signDateEnd").val())},
				{"name" : "productId","value" : $("#loanWay").val()},
				{"name" : "lenderCode","value" : ($("#lenderCode").val())},
				{"name" : "custManager","value" : ($("#custManager").val())},
				{"name" : "lenderAmountArea","value" : ($("#lenderAmount").val())}
			); 
		},
		"aoColumns" : [{
			"mData" : "lenderCode",
			"bSortable" : false,
			"sClass" : "txt-center",
		},{
			"mData" : "custName",
			"bSortable" : false,
			"sClass" : "txt-center",
		},{
			"mData" : "idCard",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "productView",
			"bSortable" : false,
			"sClass" : "txt-center",
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
			"sClass" : "txt-center",
		},{
			"mData" : "dueDateView",
			"bSortable" : false,
			"sClass" : "txt-center",
		},{
			"mData" : "statementDateView",
			"bSortable" : false,
			"sClass" : "txt-center",
		},{
			"mData" : "clusterView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "teamView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "managerView",
			"bSortable" : false,
			"sClass" : "txt-center",
		},{
			"mData" : "formStatus",
			"bSortable" : false,
			"sClass" : "txt-center",
			"mRender" : function(data,type,full) {
				if (data == "11" || data == "13") {
					return "<span class='label label-important'>" + full.formStatusView + "</span>";
				} else {
					return "<span class='label label-info'>" + full.formStatusView + "</span>";
				}
		}}],
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
		"aoColumnDefs" : [ {
			'bSortable' : false,
			'aTargets' : [ 0 ]
		} ],
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
	$("#custName").attr("maxlength", 6);
	$("#idCard").attr("maxlength", 18);
	$("#lenderCode").attr("maxlength", 21);
	
	
	$("#query").click(function() {
		TableManaged.fnDraw();
	});

	$("#reset").click(function() {
		$("#lenderCode").val("");
		$("#custName").val("");
		$("#loanWay").val("-1");
		$("#lenderAmount").val("-1");
		$("#custManager").val("-1");
		$("#currentStep").val("-1");
		$("#signDateBegin").val("");
		$("#signDateEnd").val("");
	});
});

$("#signDateBegin").change(function() {
	if (null != this.value && $.trim(this.value) != "") {
		var dateArr = this.value.split("-");
		var year = dateArr[0];
		var month = dateArr[1];
		var day = dateArr[2];
		var selDate = new Date();
		selDate.setFullYear(year, month - 1, day);
		if (selDate > new Date()) {
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
		var selDate = new Date($("#signDateEnd").val());
		selDate.setFullYear(year, month - 1, day);
		if (selDate < new Date($("#signDateBegin").val())){
			$("#signDateEnd").val("");
		}
	}
});
