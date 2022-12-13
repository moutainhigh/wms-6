var TableManaged;
$().ready(function() {
	TableManaged = $('#result').dataTable({
		"bDestroy" : true,// 销毁
		"bFilter" : false,// 不显示搜索框
		"bSort" : true, // 排序功能
		"sScrollX" : "100%",
		"sScrollXInner" : "100%",
		"sAjaxSource" : 'list.json',// 请求url
		"sServerMethod" : "POST",
		"bServerSide" : true, // 异步请求
		"fnServerParams" : function(aoData) {
			aoData.push({"name" : "custName", "value" : $("#custName").val()},
						{"name" : "idCard","value" : $("#idCard").val()},
						{"name" : "registerTimeBegin","value" : $("#registerTimeBegin").val()},
						{"name" : "registerTimeEnd","value" : $("#registerTimeEnd").val()},
						{"name" : "mobile","value" : $("#mobile").val()});
		},
		"aoColumns" : [{
			"mData" : "custName",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "idTypeView",
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
			"mData" : "sexView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "custSourceView",
			"bSortable" : false,
			"sClass" : "txt-center",
			"mRender" : function(data,type, full) {
				if (null == data|| $.trim(data) == ""|| data.length <= 13) {
					return data;
				} else {
					return "<div class='sourceOther' id='sourceOther' title="
							+ data+ ">"+ data.substr(0,13)+ "...)" +
							"</div>"
				}
			}
		},{
			"mData" : "registerTimeView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "dataStatus",
			"bSortable" : false,
			"sClass" : "txt-center",
			"mRender" : function(data,type, full) {
				if (full.dataStatus == 'A'|| full.dataStatus == 'F') {
					return "<button type='button' class='btn mini red edit' custId="+ full.custId+ ">编辑</button>";
				}
				return "";
			}
		}],
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
			$("#result_wrapper .row-fluid").css("margin-top","10px");
			var fsv = $("#result_length select[name='result_length']").val();
			if (fsv == "-1" || fsv == -1) {
				$("#result_wrapper li").addClass("disabled");
			}
		}
	});
});


//开始日期
$("#registerTimeBegin").change(function() {
	if (null != this.value && $.trim(this.value) != "") {
		var dateArr = this.value.split("-");
		var year = dateArr[0];
		var month = dateArr[1];
		var day = dateArr[2];
		var selDate = new Date();
		selDate.setFullYear(year, month - 1, day);

		if (selDate <= new Date()) {

		} else {
			$("#registerTimeBegin").val("");
		}
	}

});

//结束日期
$("#registerTimeEnd").change(function() {
	if (null != this.value && $.trim(this.value) != "") {
		var dateArr = this.value.split("-");
		var year = dateArr[0];
		var month = dateArr[1];
		var day = dateArr[2];
		var selDate = new Date($("#registerTimeBegin").val());
		selDate.setFullYear(year, month - 1, day);
		console.log("==1="+selDate);
		if (selDate >= new Date($("#registerTimeBegin").val()) && selDate<= new Date) {

		} else {
			$("#registerTimeEnd").val("");
		}
	}
});


$(function() {
	$("#custName").attr("maxlength", 6);
	$("#idCard").attr("maxlength", 18);
	$("#mobile").attr("maxlength", 11);
	$("#query").unbind("click").bind("click", function() {
		TableManaged.fnDraw();
	});
	$("#reset").live("click", function() {
		$("#viewForm").find(":input").not(":button,:submit,:reset,:hidden").val("").removeAttr("checked").removeAttr("selected");
		$("select[name=result_length]").val(15);
	});
	$("#create").unbind("click").bind("click", function() {
		var url = 'edit.json?custId=-1';
		$.get(url, function(data) {
			$('#editModal').html(data);
		});
		$('#editModal').modal({
			show : true
		});
	});
	$(".edit").live("click", function() {
		var custId = $(this).attr("custId");
		var url = 'edit.json?custId=' + custId;
		$.get(url, function(data) {
			$('#editModal').html(data);
		});
		$('#editModal').modal({
			show : true
		});
	});
});

