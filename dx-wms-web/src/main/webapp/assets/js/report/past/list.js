var TableManaged;
$().ready(function() {
	TableManaged = $('#result')
			.dataTable(
					{
						"bDestroy" : true,// 销毁
						"bFilter" : false,// 不显示搜索框
						"bSort" : true, // 排序功能
						"sScrollX" : "100%",
						"sScrollXInner" : "110%",
						"sAjaxSource" : 'list.json',// 请求url
						"sServerMethod" : "POST",
						"bServerSide" : true, // 异步请求
						"fnServerParams" : function(aoData) {
							aoData
									.push(
											{
												"name" : "lenderCode",
												"value" : $(
														"#lenderCode")
														.val()
											},
											{
												"name" : "idCard",
												"value" : $(
														"#idCard")
														.val()
											},
											{ 
												"name": "reportDay", 
												"value": $("#reportDay")
														.val()
											});
						},
						"aoColumns" : [
								{
									"mData" : "lenderCode",
									"bSortable" : false,
									"sWidth" : "2%",
									"sClass" : "txt-center",
									"mRender" : function(data,
											type, full) {
										return "<input  type=checkbox  lenderCode='"
												+ full.lenderCode
												+ "' createTimePre='"+full.createTimePre
												+ "' reportDayPre='"+full.reportDayPre
												+ "'/>";
									}
								},
								{
									"mData" : "custName",
									"bSortable" : false,
									"sClass" : "txt-center",
									"sWidth" : "3%"
								},
								{
									"mData" : "idCard",
									"bSortable" : false,
									"sClass" : "txt-center",
									"sWidth" : "4%"
								},
								{
									"mData" : "lenderCode",
									"bSortable" : false,
									"sClass" : "txt-center",
									"sWidth" : "3%"
								},
								{
									"mData" : "lenderAmountView",
									"bSortable" : false,
									"sClass" : "txt-center",
									"sWidth" : "3%"
								},
								{
									"mData" : "backMatchAmountView",
									"bSortable" : false,
									"sClass" : "txt-center",
									"sWidth" : "3%"
								},
								{
									"mData" : "productName",
									"bSortable" : false,
									"sClass" : "txt-center",
									"sWidth" : "3%"
								},
								{
									"mData" : "reportDay",
									"bSortable" : false,
									"sClass" : "txt-center",
									"sWidth" : "3%"
								},
								{
									"mData" : "investDayView",
									"bSortable" : false,
									"sClass" : "txt-center",
									"sWidth" : "3%"
								},
								{
									"mData" : "lenderCode",
									"bSortable" : false,
									"sClass" : "txt-center",
									"sWidth" : "3%",
									"mRender" : function(data,
											type, full) {
										return "<button type='button' class='btn mini red review' lenderCode='"
												+ full.lenderCode
												+ "' createTimePre='"+full.createTimePre
												+ "' reportDayPre='"+full.reportDayPre
												+ "' >预览</button>";
									}
								} ],
								"aLengthMenu": [
						    	        	    [ 20, 50, -1],
						    	        	    [ 20, 50, "全部"] // change per page values here
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
				            $("#all").attr('checked', false);
							$("#all").parent().removeClass("checked");
							$("#query").removeAttr("disabled");
							var fsv = $(
									"#resultList_length select[name='resultList_length']")
									.val();
							$("#result_wrapper .row-fluid")
									.css("margin-top", "10px");
							if (fsv == "-1" || fsv == -1) {
								$("#resultList_wrapper li")
										.addClass("disabled");
							}
						}
					});
	
	$("#query").click(function() {
		var reportDay = $("#reportDay").val();
		
		if ('-1'==reportDay) {
			
			$.dopAlert("查询前请先选择报告日！");
			return;
		}
		TableManaged.fnDraw();
	});
	
					
	//导出按钮点击弹出列表和pdf导出按钮
	$(".report").live("click", function(e) {
		$("#waitexper").show();
		$(".report").hide();
	});
	
	
	/**
	 * 全选/取消全选
	 */
	$("#all").click(function() {
		var $checkbox = $(":checkbox", "#result");
		$checkbox.attr("checked", this.checked)
	});
	
	//点击空白区域隐藏导出列表和pdf按钮
	$("body").click(
		function(e) {
			if ($(e.target).is("input")
					|| $(e.target).is("button")
					|| $( e.target ).closest(".dataTables_length").length != 0
					|| $( e.target ).closest(".dataTables_scroll").length != 0
//								|| $( e.target ).closest(".dataTables_info").length != 0
					|| $( e.target ).closest(".span12").length != 0
					|| $( e.target ).closest(".portlet-title").length != 0
					|| $( e.target ).closest(".modal").length != 0
					|| $(e.target).is("a")
					|| $(e.target).is("span")
					) {
				return;
			}
			$("#waitexper").hide();
			$(".report").show();
		});
	
	/**
	 *  下载往期匹配协议excel
	 */
	$(".excelReport").live("click",function() {
		var pastParamVo = {};
		var lenderCode = $("#lenderCode").val();
		var idCard = $("#idCard").val();
		var reportDay = $("#reportDay").val();


		if (""==lenderCode&&""==idCard&&"-1"==reportDay) {
			$.dopAlert("请选择所要导出的往期匹配报告的条件!");
			return;
		}
		
		pastParamVo.isQuery = "query";
		pastParamVo.lenderCode = lenderCode;
		pastParamVo.idCard = idCard;
		pastParamVo.reportDay = reportDay;

		execute('excel',pastParamVo);
		
	});
	
	/**
	 * 下载往期匹配协议pdf
	 */
	$(".pdfReport").live('click',function() {
		var pastParamVo = {};
		var processResult = [];
		var createTimePre=""
		var reportDayPre = "";

		$("input:checked", "#result > tbody").each(
						function() {
							processResult.push($(this).attr("lenderCode"));
							createTimePre = $(this).attr("createTimePre");
							reportDayPre = $(this).attr("reportDayPre");
							});
		if (processResult.length == 0) {
			$.dopAlert("请选择所要导出的往期匹配报告!");
			return;
		}
		
		if($("#all").is(':checked')){
			var pastParamVo = {};
			var lenderCode = $("#lenderCode").val();
			var idCard = $("#idCard").val();
			var reportDay = $("#reportDay").val();


			if (""==lenderCode&&""==idCard&&"-1"==reportDay) {
				$.dopAlert("您已点击全选按钮,往期匹配详情导出条件不能为空!");
				return;
			}
			pastParamVo.isQuery = "query";
			pastParamVo.lenderCode = lenderCode;
			pastParamVo.idCard = idCard;
			pastParamVo.reportDay = reportDay;
			
			processResult=[];
		}


		pastParamVo.createTimePre = createTimePre;
		pastParamVo.reportDayPre = reportDayPre;
		pastParamVo.lenderCodes = processResult;
		execute('pdf',pastParamVo);
	});
	
	function execute(biz , pastParamVo){
		$.ajax({
			type : "POST",
			async : true,
			dataType : "json",
			contentType : "application/json",
				data : JSON.stringify(pastParamVo),
			url : base+ "/report/past/"+biz+"_report.json",
			success : function(data) {
					$.dopAlert(data.msg);
			},
			error : function(data) {
				$.dopAlert(data.msg);
			}
		});
	}
	
	$(".review").live("click",function() {
		$('#reportModal').html('');
		var lenderCode=$(this).attr("lenderCode");
		var createTimePre = $(this).attr("createTimePre");
		var reportDayPre = $(this).attr("reportDayPre");
		var pastPreviewParamVo = {};
		pastPreviewParamVo.createTimePre = createTimePre;
		pastPreviewParamVo.reportDayPre = reportDayPre;
		pastPreviewParamVo.lenderCode = lenderCode;
		$.ajax({
				type : "POST",
				async : true,
				dataType : "html",
				contentType : "application/json",
				url : base+ "/report/past/preview.json",// 请求url
				data : JSON.stringify(pastPreviewParamVo),
				timeout : 10000,
				success : function(data) {
					$('#reportModal').html(
							data);
					$('#reportModal').modal({
						show : true
					});
					}
				});
			});
	
	
	
	
	/**
	 * 处理导出协议文件的名称
	 * 
	 * @param tds:每一行中checkbox的兄弟td
	 * @param processResult
	 * @param lenderCode
	 */
	function dealProtocolFileName(tds, processResult,
			lenderCode) {
		var processResultVo = {};
		// 协议文件的前缀
		var suffix = "首期债权转让及受让协议 ";
		// 获取匹配日期
		var matchDate = $(tds[26]).text().replace("-", "")
				.replace("-", "");
		var name = $(tds[2]).text()+" ";
		// 拼接获取协议文件名称
		var protocolFileName = suffix + matchDate + " "+name+lenderCode;
			processResultVo.lenderCode = lenderCode;
			processResultVo.protocolFileName = protocolFileName;
			processResult.push(processResultVo);
		}
	}
);

