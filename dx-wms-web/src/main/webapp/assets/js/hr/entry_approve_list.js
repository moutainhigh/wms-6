var TableManaged;

$().ready(function() {
	TableManaged = $('#resultList').dataTable({
		"bDestroy" : true,// 销毁
		"bFilter" : false,// 不显示搜索框
		"bSort" : true, // 排序功能
		"sScrollX" : "100%",
		"sScrollXInner" : "100%",
		"sAjaxSource" : 'entryApprove.json',// 请求url
		"sServerMethod" : "POST",
		"bServerSide" : true, // 异步请求
		"fnServerParams" : function(aoData) {
			aoData.push(
				{"name" : "positionId","value" : $(".positionName").val()}, 
				{"name" : "name","value" : $(".employeeName").val()}, 
				{"name" : "mobilePhone","value" : $(".mobile").val()},
				{"name": "jobCategory","value": $(".jobCategory").val()}
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
			"mData" : "employeeId",
			"bSortable" : false,
			"sClass" : "txt-center",
			"mRender" : function(data, type, full) {
				return "<button type='button' class='btn mini blue approve' onclick='approveDetail(\""+data+"\",\""
                +full.procInsId+"\",\""+full.taskId+"\")'  class='btn mini blue approve'>审批</button>";
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
	$(".employeeName").attr("maxlength", 6);
	$(".mobile").attr("maxlength", 11);

	$("#query").click(function() {
		TableManaged.fnDraw();
	});

	$("#reset").click(function() {
		$(".jobCategory").val(-1);
		$(".positionName").val(-1);
		$(".employeeName").val("");
		$(".mobile").val("");
	});
	/*$(".positionName").change(function(){
		if($(".jobCategory").val()=='-1'){
			$(".positionName").val(-1);
			$.dopAlert("请先选择工作性质.");
			return;
		}
	});*/
	
});


function approveDetail(employeeId,procInsId,taskId){
	 var url = base + "/hrApprove/emp_entry_approve.json?employeeId="+employeeId+'&procInsId='+procInsId+'&taskId='+taskId;
		$.get(url, function(data) {
	        $('#detailModal').html(data);
	    });
	    $('#detailModal').modal({
	        show : true
	    });	
 }