var TableManaged;
$().ready(function() {
	TableManaged = $('#result')
			.dataTable(
					{
						"bDestroy" : true,// 销毁
						"bFilter" : false,// 不显示搜索框
						"bSort" : true, // 排序功能
						"sScrollX" : "100%",
						"sScrollXInner" : "4500px",
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
												"name" : "initMatchDateBegin",
												"value" : $(
														"#initMatchDateBegin")
														.val()
											},
											{
												"name" : "initMatchDateEnd",
												"value" : $(
														"#initMatchDateEnd")
														.val()
											});
						},
						"aoColumns" : [
								{
									"mData" : "lenderCode",
									"bSortable" : false,
									"sClass" : "txt-center",
									"mRender" : function(data,
											type, full) {
										return '<input  type="checkbox"  value="'
												+ data + '"/>';
									}
								},
								{
									"mData" : "applyDateView",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "lenderCode",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "custName",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "sexView",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "idCard",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "productName",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "initTotalAmountView",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "custCategoryView",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "lenderDateView",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "payWayView",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "buckleBankCategoryView",
									"bSortable" : false,
									"sClass" : "txt-center",
									"sWidth" : "7%"
								},
								{
									"mData" : "buckleAccountNum",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "buckleAccountName",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "returnBankCategoryView",
									"bSortable" : false,
									"sClass" : "txt-center",
									"sWidth" : "7%"
								},
								{
									"mData" : "returnAccountNum",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "returnAccountName",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "custAddress",
									"bSortable" : false,
									"sClass" : "txt-center",
									"sWidth" : "10%"
								},
								{
									"mData" : "zipCode",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "teamView",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "managerView",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "area",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "orgIdView",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "msgWayView",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "email",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "mobile",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "billDay",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "initMatchTimeView",
									"bSortable" : false,
									"sClass" : "txt-center",
								},
								{
									"mData" : "lenderCode",
									"bSortable" : false,
									"sClass" : "txt-center",
									"mRender" : function(data,
											type, full) {
										return "<button type='button' class='btn mini red review' data='"
												+ data
												+ "' >预览</button>";
									}
								} ],
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
		TableManaged.fnDraw();
	});
					
	//导出按钮点击弹出列表和pdf导出按钮
	$(".report").live("click", function(e) {
		$("#waitexper").show();
		$(".report").hide();
	});
	
//	/**
//	 * 全选/反选
//	 */
//	$("#all").click(function() {
//		$("#result :checkbox").each(function() {
//			if ($(this).is(':checked')) {
//				$(this).attr("checked", false);
//			} else {
//				$(this).attr("checked", true);
//			}
//		});
//	});
	
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
	 * excel导出
	 */
	$(".listReport").live(
			"click",
			function() {
				var lenderCode = $("#lenderCode").val();
				var idCard = $("#idCard").val();
				var initMatchDateBegin = $(
						"#initMatchDateBegin").val();
				var initMatchDateEnd = $("#initMatchDateEnd")
						.val();
				if (lenderCode == '' && idCard == ''
						&& initMatchDateBegin == ''
						&& initMatchDateEnd == '') {
					$.dopAlert("导出前请先选择条件！");
					return;
				}
				if (initMatchDateEnd == '') {
					$.dopAlert("请选择匹配结束日期！");
					return;
				}
				var begin = $("#initMatchDateBegin").val()
						.split("-");
				var end = $("#initMatchDateEnd").val().split(
						"-");
				var result = end[2] - begin[2];
				console.log(result);
				if (result > 5) {
					$.dopAlert("请选择5天内的数据！");
					return;
				}
				//导出列表时导出按钮不可选
				 $(".listReport").attr("disabled", "disabled");
				 //定时释放导出列表按钮
				 window.setInterval(function(){
					 $(".listReport").removeAttr("disabled");
				 }, 10000);//
				var url = base
						+ "/invest/pool/excelExoprt.json?"
						+ $("#queryForm").serialize();
				$.dopAlert("正在生成报表文件，请不要刷新页面，耐心等候");
				window.setInterval(function(){
					$("#okDopAlertButton").click();
				 }, 10000);//
				window.location.href = url
			});
	
	$(".review").live("click",function() {
		$('#reportModal').html('');
		$.ajax({
				url : base+ "/reportManagement/init.json?biz=first&lenderCode="+ $(this).attr("data"),// 请求url
				type : "POST",
				async : false,
				dataType : "html",
				contentType : "application/json",
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
	 * 下载新增匹配首期协议
	 */
	$(".pdfReport").live('click',function() {
				var processResultVo = {};
				var processResult = [];
				$("input:checked", "#result > tbody").each(
								function() {
									dealProtocolFileName($(this).parent().siblings('td'),processResult,$(this).val());
									});
				if (processResult.length == 0) {
					$.dopAlert("请选择所要导出的首期协议!");
					return;
				}
				if (processResult.length > 20) {
					$.dopAlert("请选择少于20条数据");
					return;
				}
				//导出pdf时导出按钮不可选
				 $(".pdfReport").attr("disabled", "disabled");
				 //定时释放导出pdf按钮
				 window.setInterval(function(){
					 $(".pdfReport").removeAttr("disabled");
				 }, 10000);//
				$.dopAlert("正在生成首期协议PDF，请不要刷新页面，耐心等候");
				processResultVo.processResult = processResult;
						$.ajax({
							type : "POST",
							async : true,
							dataType : "json",
							contentType : "application/json",
							data : JSON.stringify(processResultVo),
							url : base+ "/reportManagement/pdf.json",
							success : function(data) {
								if (data.msg == "ok") {
									$("#okDopAlertButton").click();
									window.location.href = base+ "/reportManagement/download.json?path="+ data.path;
								} 
								if(data.msg == "error"){
									$.dopAlert("导出失败");
								}
							},
							error : function(data) {
								$.dopAlert(data.cause);
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
	});
