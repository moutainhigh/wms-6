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
							aoData.push({
								"name" : "custName",
								"value" : $("#custNameQuery").val()
							}, {
								"name" : "currentStep",
								"value" : $("#currentStepQuery").val()
							}, {
								"name" : "signDateBegin",
								"value" : ($("#signDateBegin").val())
							}, {
								"name" : "signDateEnd",
								"value" : ($("#signDateEnd").val())
							}, {
								"name" : "lenderCode",
								"value" : ($("#lenderCodeQuery").val())
							}, {
								"name" : "lenderAmountArea",
								"value" : ($("#lenderAmountQuery").val())
							}, {
								"name" : "orgId",
								"value" : ($("#orgIdQuery").val())
							}, 
							{
								"name" : "productId",
								"value" : $("#loanWayQuery").val()
							},
							{
								"name" : "mobile",
								"value" : $("#mobileQuery").val()
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
									"mData" : "productView",
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
									"mData" : "settleDateView",
									"bSortable" : false,
									"sClass" : "txt-center"
								},
								{
									"mData" : "dueDateView",
									"bSortable" : false,
									"sClass" : "txt-center"
								},
								{
									"mData" : "statementDateView",
									"bSortable" : false,
									"sClass" : "txt-center"
								},
								{
									"mData" : "orgView",
									"bSortable" : false,   
									"sClass" : "txt-center",
									"sWidth": "120px"
								},
								{
									"mData" : "clusterView",
									"bSortable" : false,
									"sClass" : "txt-center"
								},
								{
									"mData" : "teamView",
									"bSortable" : false,
									"sClass" : "txt-center"
								},
								{
									"mData" : "managerView",
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
									"mData" : "lenderApplyId",
									"bSortable" : false,
									"sClass" : "txt-center",
									"mRender" : function(data, type, full) {
										return "<button type='button' class='btn mini blue log' lenderApplyId='" + data + "' class='btn mini blue log'>日志</button>";
									}
								}
								],

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
	$("#custNameQuery").attr("maxlength", 6);
	$("#lenderCodeQuery").attr("maxlength", 21);
	$("#mobileQuery").attr("maxlength", 11);
	
	$("#query").click(function() {
		TableManaged.fnDraw();
	});
	$("#reset").click(function() {
		$("#custNameQuery").val("");
		$("#currentStepQuery").val(-1);
		$("#signDateBegin").val("");
		$("#signDateEnd").val("");
		$("#lenderCodeQuery").val("");
		$("#lenderAmountQuery").val(-1);
		$("#orgIdQuery").val(-1);
		$("#loanWayQuery").val(-1);
		$("#mobileQuery").val("");
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
		var selDate = new Date($("#signDateEnd").val());
		selDate.setFullYear(year, month - 1, day);
		if ( selDate >= new Date($("#signDateBegin").val())){

		} else {
			$("#signDateEnd").val("");
		}
	}
	});
	
	/**
     * 导出excel
     */
    $(".excelReport").live(
            "click",
            function() {
            	var signDateBegin = $("#signDateBegin").val();
            	var signDateEnd = $("#signDateEnd").val();
            	
            	var custNameQuery = $("#custNameQuery").val();
            	var currentStepQuery = $("#currentStepQuery").val();
            	var lenderCodeQuery = $("#lenderCodeQuery").val();
            	var lenderAmountQuery = $("#lenderAmountQuery").val();
            	var orgIdQuery = $("#orgIdQuery").val();
            	var loanWayQuery = $("#loanWayQuery").val();
            	var mobileQuery = $("#mobileQuery").val();
            	if (signDateBegin != ''&& signDateEnd == '') {
					$.dopAlert("请选择签单终止日期！");
					return;
				}
            	var custName = $("#custNameQuery").val();
                //导出列表时导出按钮不可选
                 $(".excelReport").attr("disabled", "disabled");
                 //定时释放导出列表按钮
                 window.setInterval(function(){
                     $(".excelReport").removeAttr("disabled");
                 }, 10000);//

                var url = base
                        + "/wealthManagementInfo/excelExport.json?"
                        + "custNameQuery="+custNameQuery+"&currentStepQuery="+currentStepQuery
                        + "&lenderCodeQuery="+lenderCodeQuery
                        + "&lenderAmountQuery="+lenderAmountQuery+"&orgIdQuery="+orgIdQuery
                        + "&loanWayQuery="+loanWayQuery+"&mobileQuery="+mobileQuery
                        + "&signDateBegin="+signDateBegin+"&signDateEnd="+signDateEnd;
                $.dopAlert("正在生成报表文件，请不要刷新页面，耐心等候");
                window.setInterval(function(){
                    $("#okDopAlertButton").click();
                 }, 10000);//
                window.location.href = url
            });
