var TableManaged;
$(function() {
	TableManaged = $('#result').dataTable({
		"bDestroy" : true,// 销毁
		"bFilter" : false,// 不显示搜索框
		"bSort" : true, // 排序功能
		"sScrollX" : "100%",
		"sScrollXInner" : "154%",
		"sAjaxSource" : 'list.json',// 请求url
		"sServerMethod" : "POST",
		"bServerSide" : true, // 异步请求
		"fnServerParams" : function(aoData) {
			aoData.push({"name" : "lenderCode","value" : $("#lenderCode").val()},
						{"name" : "billDay","value" : $("#billDay").val()},
						{"name" : "productId","value": $("#productId").val()});
		},
		"aoColumns" : [{
			"mData" : "poolId",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth" : "2%",
			"mRender" : function(data, type, full) {
				return "<input type='checkbox' value='" + JSON.stringify(full) + "' />";
			}
		},{
			"mData" : "custName",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth" : "6%"
		},{
			"mData" : "idCard",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth" : "8%"
		},{
			"mData" : "lenderCode",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth" : "8%"
		},{
			"mData" : "productName",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth" : "6%"
		},{
			"mData" : "lenderIncomeAmountView",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth" : "14%"
		},{
			"mData" : "billDayView",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth" : "6%"
		},{
			"mData" : "levelView",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth" : "8%"
		},{
			"mData" : "backBankView",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth" : "10%"
		},{
			"mData" : "backAccountName",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth" : "6%"
		},{
			"mData" : "backAccountNum",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth" : "6%"
		},{
			"mData" : "orgView",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth" : "8%"
		}],
		"aLengthMenu": [
		        	    [ 15, 20, -1],
		        	    [ 15, 20, "全部"] // change per page values here
		        	 ],
		// set the initial value
		"iDisplayLength" : 15,
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
			$("#result_wrapper .row-fluid").css("margin-top",
					"10px");
			if (fsv == "-1" || fsv == -1) {
				$("#resultList_wrapper li")
						.addClass("disabled");
			}
		}
	});
	$("#query").click(function() {
		TableManaged.fnDraw();
	});

	$("#all").click(function() {
		var check = all.checked;
		$("input[type='checkbox']").each(function() {
			$(this).attr("checked", check);
			check ? $(this).parent().addClass('checked') : $(this).parent().removeClass('checked');
		});
	});
	$(".push").live('click', function() {
		var checkFlag = false;
		var items = [];
		$(":checkbox").each(function(i) {
			if ($(this).attr("checked")) {
				var val = $(this).val();
				if (val != '-1') {
					checkFlag = true;
					items.push($.parseJSON(val));
				}
			}
		});
		if (!checkFlag) {
			$.dopAlert('请勾选您要推送的数据!');
			return false;
		}
		// post to controller
		$.ajax({
			url : base + "/back/usual/push.json",// 请求url
			type : "POST",
			async: false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(items),
			timeout : 5000,
			success : function(data) {
				$.dopAlert(data.msg);
				TableManaged.fnDraw();
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$(".error").html('操作异常');
			}
		});	
	});
	
	/**
	 * 导出excel
	 */
	$("#excelReport").live(
			"click",
			function() {
				var lenderCode = $("#lenderCode").val();
				var billDay = $("#billDay").val();
				var productId = $("#productId").val();
				if (lenderCode==''&& billDay == '-1' 
						&& productId=='-1') {
					$.dopAlert("导出前请先选择条件！");
					return;
				}
				//导出列表时导出按钮不可选
				 $("#excelReport").attr("disabled", "disabled");
				 //定时释放导出列表按钮
				 window.setInterval(function(){
					 $("#excelReport").removeAttr("disabled");
				 }, 10000);//
				var url = base
						+ "/back/usual/excelExport.json?"
						+ $("#queryForm").serialize();
				$.dopAlert("正在生成报表文件，请不要刷新页面，耐心等候");
				window.setInterval(function(){
					$("#okDopAlertButton").click();
				 }, 20000);//
				window.location.href = url
			});
});





