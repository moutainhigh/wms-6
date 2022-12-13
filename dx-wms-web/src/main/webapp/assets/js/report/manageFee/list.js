var TableManaged;
$(function(){ 
	 TableManaged =  $('#result').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"150%",
    	"sAjaxSource": 'list.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
        "fnServerParams": function (aoData) {
             aoData.push({ "name": "lenderCode", "value": $("#lenderCode").val()},
            		 	{ "name": "billDay", "value": $("#billDay").val()},
            		 	{ "name": "statisticDate", "value": $("#statisticDate").val()});
         },
         "aoColumns" : [{    		
     		"mData" : "lenderCode",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "idCard",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "accountLevelName",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
    						return "<span class='badge badge-important'>" + data + "</span>";
             			}
    	},{    		
     		"mData" : "productName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "billDay",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "accountManagementFeeView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "bankName",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "12%"
    	},{    		
     		"mData" : "accountName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "accountNum",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "orgName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "statisticDate",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	}],
         "aLengthMenu": [
             [ 15, 20, -1],
             [ 15, 20, "全部"] // change per page values here
         ],
         // set the initial value
         "iDisplayLength": 15,
         "sPaginationType": "bootstrap",
         "oLanguage": {
         	"sLengthMenu" : "每页显示 _MENU_ 条记录",
 			"sZeroRecords" : "抱歉， 没有找到",
 			"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
 			"sInfoEmpty": "显示 0 至 0 共 0 项",
             "oPaginate": {
                 "sPrevious": "上一页",
                 "sNext": "下一页"
             }
         },
         "aoColumnDefs": [{
                 'bSortable': false,
                 'aTargets': [0]
             }
         ],
         //回调函数
         "fnDrawCallback":function( oSettings ) {
        	$("#query").removeAttr("disabled");
//        	stat();
 			$("#result_wrapper .row-fluid").css("margin-top","10px");
 			var fsv = $("#result_length select[name='result_length']").val();
 			if (fsv == "-1" || fsv == -1) {
 				$("#result_wrapper li").addClass("disabled");
 			}
         }
     });

	$("#query").unbind("click").bind("click",function(){ 
		var billDay = $("#billDay").val();
		var statisticDate = $("#statisticDate").val();
		if ((billDay == '-1' && statisticDate != '') || (billDay != '-1' && statisticDate == '') ) {
			$.dopAlert("请填入账单日和统计日期！"); 
			return;
		}
		TableManaged.fnDraw();
	});
	/**
	 * excel导出
	 */
	$(".report").live(
			"click",
			function() {
				var lenderCode = $("#lenderCode").val();
				var billDay = $("#billDay").val();
				var statisticDate = $("#statisticDate").val();
				if (lenderCode=='' && billDay == '-1' && statisticDate == '') {
					$.dopAlert("导出前请先选择条件！");
					return;
				}
				if ((billDay == '-1' && statisticDate != '') || (billDay != '-1' && statisticDate == '')) {
					$.dopAlert("请同时选择账单日和统计日期！");
					return;
				}
				//导出列表时导出按钮不可选
				 $(".report").attr("disabled", "disabled");
				 //定时释放导出列表按钮
				 window.setInterval(function(){
					 $(".report").removeAttr("disabled");
				 }, 10000);//
				var url = base
						+ "/report/manage/excelExoprt.json?"
						+ $("#queryForm").serialize();
				$.dopAlert("正在生成报表文件，请不要刷新页面，耐心等候");
				window.setInterval(function(){
					$("#okDopAlertButton").click();
				 }, 10000);//
				window.location.href = url
			});
});	
