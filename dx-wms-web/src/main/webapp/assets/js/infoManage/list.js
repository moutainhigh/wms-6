var TableManaged;
$().ready(function() {
	TableManaged = $('#resultList').dataTable({
						"bDestroy" : true,// 销毁                                                                                                                           
						"bFilter" : false,// 不显示搜索框
						"bSort" : true, // 排序功能
						"sScrollX" : "100%",
						"sScrollXInner" : "150%",
						"sAjaxSource" : 'list.json',// 请求url
						"sServerMethod" : "POST",
						"bServerSide" : true, // 异步请求
						"fnServerParams" : function(aoData) {
							aoData.push(
							{
								"name" : "lenderCode",
								"value" : $("#lenderCode").val()
							},{
								"name" : "custName",
								"value" : $("#custName").val()
							}, {
								"name" : "idCard",
								"value" : $("#idCard").val()
							}, {
								"name" : "productId",
								"value" : $("#productId").val()
							},{
								"name" : "currentStep",
								"value" : $("#currentStep").val()
							});
						},
						"aoColumns" : [
								{
									"mData" : "lenderCode",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "custName",
									"bSortable" : false,
									"sClass" : "txt-center"
								},
								{
									"mData" : "idCard",
									"bSortable" : false,
									"sClass" : "txt-center"
								},
								{
									"mData" : "productIdView",
									"bSortable" : false,
									"sClass" : "txt-center"
								},
								{
									"mData" : "lenderAmountView",
									"bSortable" : false,
									"sClass" : "txt-center"
								},
								{
									"mData" : "signDateView",
									"bSortable" : false,
									"sClass" : "txt-center"
								},
								{
									"mData" : "formStatus",
									"bSortable" : false,
									"sClass" : "txt-center",
									"mRender" : function(data, type, full) {
										if (data == "11" || data == "13") {
											return "<span class='label label-important'>" + full.formStatusView + "</span>";
										} else {
											return "<span class='label label-info'>" + full.formStatusView + "</span>";
										}
									}
								},
								{
									"mData" : "settleDateView",
									"bSortable" : false,
									"sClass" : "txt-center"
								},
								{
									"mData" : "satementDateView",
									"bSortable" : false,
									"sClass" : "txt-center"
								},
								{
									"mData" : "dueDateView",
									"bSortable" : false,
									"sClass" : "txt-center"
								},
								{
									"mData" : "lenderCode",
									"bSortable" : false,
									"sClass" : "txt-center",
									"mRender" : function(data,
											type, full) {
										return "<button type='button' class='btn mini red detail' lenderApplyId='"
												+ full.lenderApplyId
												+ "' >详情</button>";
									}
								}
								],

								"aLengthMenu": [
								       	     [ 20, 40, -1],
								       	     [ 20, 40, "全部"] // change per page values here
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
							var fsv = $(
									"#resultList_length select[name='resultList_length']")
									.val();
							if (fsv == "-1" || fsv == -1) {
								$("#resultList_wrapper li")
										.addClass("disabled");
							}
						}
					});
		$("#query").click(function() {
			TableManaged.fnDraw();
		});
			$("#reset").click(function() {
			$("#lenderCode").val("");
			$("#custName").val("");
			$("#idCard").val("");
			$("#productId").val(-1);
			$("#currentStep").val(-1);
		});
});

$(".detail").live("click",function() {
	var url = base+"/detail/detail.htm?lenderApplyId="+$(this).attr("lenderApplyId");
	window.open(url);
});





	
	