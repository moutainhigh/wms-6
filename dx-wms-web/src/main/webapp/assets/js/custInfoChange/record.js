var TableManagerd;
function queryRecordData(){
	TableManagerd = $('#resultRecordList').dataTable({
		"bDestroy" : true,// 销毁
		"bFilter" : false,// 不显示搜索框
		"bSort" : true, // 排序功能
		"sScrollX" : "100%",
		"sScrollXInner" : "100%",
		"sAjaxSource" : 'custInfo_record_do.json',// 请求url
		"sServerMethod" : "POST",
		"bServerSide" : true, // 异步请求
		"fnServerParams" : function(aoData) {
			aoData.push({
				"name" : "pkId","value" : $("#pkId").val()
			});
		},
		"aoColumns" : [
				{
					"mData" : "lenderCustCode",
					"bSortable" : false,
					"sWidth" : "75px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "custName",
					"bSortable" : false,
					"sWidth" : "50px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "changeProject",
					"bSortable" : false,
					"sWidth" : "50px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "originalContent",
					"bSortable" : false,
					"sWidth" : "50px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "changeContent",
					"bSortable" : false,
					"sWidth" : "50px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "createTime",
					"bSortable" : false,
					"sWidth" : "100px",
					"sClass" : "txt-center"
				}],
		"aLengthMenu" : [ [ 15, 20, -1 ],
				[ 15, 20, "全部" ] // change
									// per page
									// values
									// here
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
//			$("#query").removeAttr("disabled");
//			var fsv = $("#resultRecordList_length select[name='resultRecordList_length']").val();
//			if (fsv == "-1" || fsv == -1) {
//				$("#resultRecordList_wrapper li").addClass("disabled");
//			}
		}
	});
}
//变更记录关闭按钮
$("#close").click(function(){
	TableManagerd.fnPageChange(0);
	$("#changeLogDiv").modal('hide');
});