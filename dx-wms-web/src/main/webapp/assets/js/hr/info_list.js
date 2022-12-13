var TableManaged;

function query() {
	TableManaged = $('#resultList').dataTable({
		"bDestroy" : true,// 销毁
		"bFilter" : false,// 不显示搜索框
		"bSort" : true, // 排序功能
		"sScrollX" : "100%",
		"sScrollXInner" : "100%",
		"sAjaxSource" : 'list.json',// 请求url
		"sServerMethod" : "POST",
		"bServerSide" : true, // 异步请求
		"fnServerParams" : function(aoData) {
			aoData.push(
				{"name" : "positionId","value" : $(".positionName").val()}, 
				{"name" : "name","value" : $(".employeeName").val()}, 
				{"name" : "mobilePhone","value" : $(".mobile").val()}, 
				{"name" : "formStatus","value" : $(".formStatus").val()},
				{"name" : "orgId","value" : $("#orgId").val()},
				{"name" : "jobCategory","value" : $(".jobCategory").val()}
			);
		},
		"aoColumns" : [
		{
			"mData" : "name",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "sexView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "departmentView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "positionView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "jobCategoryView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "mobilePhone",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "entryDate",
			"bSortable" : false,
			"sClass" : "txt-center",
			
		},
		{
			"mData" : "dataStatus",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "employeeId",
			"bSortable" : false,
			"sClass" : "txt-center",
			"mRender" : function(data) {
				return "<button type='button' class='btn mini blue detail mWidth' onclick='approveDetail("+data+")' >详情</button>";
			}

		} ],
		"aLengthMenu" : [
            [ 15, 20, -1 ],
			[ 15, 20, "全部" ]
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
			var fsv = $("#resultList_length select[name='resultList_length']").val();
			if (fsv == "-1" || fsv == -1) {
				$("#resultList_wrapper li").addClass("disabled");
			}
			var $cont = $("#content");
			var $leftd,$rigthd;
			if($cont.length > 0) {
				$leftd = $cont.find("div.portlet-body").eq(0);
				$rigthd = $cont.find("div.portlet-body").eq(1);
				$leftd.height($rigthd.height());
			}
		}
	});
}

$(function() {
	$(".employeeName").attr("maxlength", 6);
	$(".mobile").attr("maxlength", 11);
	$("#query").click(function() {
		/*var position = $(".positionName").val();
		var jobCate = $(".jobCategory").val();
		if(position!='-1'&&jobCate=='-1'){
			$.dopAlert("请选择工作性质");
			return;
		}*/
		TableManaged.fnDraw();
	});

	$("#reset").click(function() {
		$(".employeeName").val("");
		$(".positionName").val("-1");
		$(".mobile").val("");
		$(".formStatus").val("-1");
		$(".jobCategory").val("-1");
		$("#orgId").val("");
	});
	 
});

function approveDetail(employeeId){
	 var url = base + "/detail/employee_detail.json?id="+employeeId;
		$.get(url, function(data) {
	        $('#detailModal').html(data);
	    });
	    $('#detailModal').modal({
	        show : true
	    });	
}



