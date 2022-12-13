var TableManaged;
$().ready(function() {
	 TableManaged =  $('#result').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"240%",
    	"sAjaxSource": 'list.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
         "fnServerParams": function (aoData) {
             aoData.push({ "name": "custName", "value": $("#custName").val()},
            		 	{ "name": "idCard", "value": $("#idCard").val()},
            		 	{ "name": "contractNo", "value": $("#contractNo").val()},
           		 	 	{ "name": "repayDay", "value": $("#repayDay").val()},
            		 	{ "name": "createDateBegin", "value": $("#createDateBegin").val()},
            		 	{ "name": "createDateEnd", "value": $("#createDateEnd").val()});
         },
         "aoColumns" : [{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "idCard",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "contractNo",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "repayDay",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "initTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "repayBeginDateView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "initPeriod",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "remainPeriod",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "rateYearView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "productView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "repayAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "rateMonthView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "repayPeriod",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "currentTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "currentDoneAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "currentUndoAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "lastTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "lastDoneAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "lastUndoAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "lastInterestView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "lastCapitalView",
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
	        var fsv = $("#resultList_length select[name='resultList_length']").val();
	        $("#result_wrapper .row-fluid").css("margin-top","10px");
	        if(fsv == "-1" || fsv == -1) {
    			$("#resultList_wrapper li").addClass("disabled");
    		}
         }
     });
});


$(function(){ 
	$("#query").click(function(){ 
		TableManaged.fnDraw();
	});
	
	/**
	 * 导出excel
	 */
	$(".excelReport").live(
			"click",
			function() {
				var custName = $("#custName").val();
				var idCard = $("#idCard").val();
				var contractNo = $("#contractNo").val();
				var repayDay = $("#repayDay").val();
				var createDateBegin = $(
						"#createDateBegin").val();
				var createDateEnd = $("#createDateEnd")
						.val();
				if (custName==''&& idCard == '' 
						&& contractNo == '' 
						&& repayDay=='-1'
						&& createDateBegin == ''
						&& createDateEnd == '') {
					$.dopAlert("导出前请先选择条件！");
					return;
				}
				if (createDateBegin != ''&& createDateEnd == '') {
					$.dopAlert("请选择统计终止日期！");
					return;
				}
				var beginArray = $("#createDateBegin").val()
						.split("-");
				var endArray = $("#createDateEnd").val().split(
						"-");
				var begin = new Date(beginArray[0], beginArray[1], beginArray[2]);
				var end = new Date(endArray[0], endArray[1], endArray[2]);
				var result = ((end.getTime()-begin.getTime())/(1000*60*60*24));
				console.log(result);
				if (result > 30) {
					$.dopAlert("请选择30天内的数据！");
					return;
				}
				//导出列表时导出按钮不可选
				 $(".excelReport").attr("disabled", "disabled");
				 //定时释放导出列表按钮
				 window.setInterval(function(){
					 $(".excelReport").removeAttr("disabled");
				 }, 10000);//
				var url = base
						+ "/credit/pool/excelExport.json?"
						+ $("#queryForm").serialize();
				$.dopAlert("正在生成报表文件，请不要刷新页面，耐心等候");
				window.setInterval(function(){
					$("#okDopAlertButton").click();
				 }, 10000);//
				window.location.href = url
			});
});