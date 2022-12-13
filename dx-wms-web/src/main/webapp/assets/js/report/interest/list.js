var TableManaged;
$(function(){ 
	 TableManaged =  $('#result').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"200%",
    	"sAjaxSource": 'list.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
        "fnServerParams": function (aoData) {
             aoData.push({ "name": "lenderCode", "value": $("#lenderCode").val()},
            		 	{ "name": "billDay", "value": $("#billDay").val()},
           		 	 	{ "name": "countTime", "value": $("#countTime").val()});
         },
         "aoColumns" : [{
     		"mData" : "lenderCode",
     		"bSortable" : false,
     		"sWidth":"150px",
     		"sClass" : "txt-center"
     	},{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sWidth":"100px",
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "idCard",
     		"bSortable" : false,
     		"sWidth":"150px",
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "accountLevel",
     		"bSortable" : false,
     		"sWidth":"100px",
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
				return "<span class='badge badge-important'>" + data + "</span>";
         	}
    	},{    		
     		"mData" : "productName",
     		"bSortable" : false,
     		"sWidth":"170px",
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "billDay",
     		"bSortable" : false,
     		"sWidth":"80px",
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "icomeView",
     		"bSortable" : false,
     		"sWidth":"200px",
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "bankInfo",
     		"bSortable" : false,
     		"sWidth":"320px",
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "bankNum",
     		"bSortable" : false,
     		"sWidth":"100px",
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "accountName",
     		"bSortable" : false,
     		"sWidth":"100px",
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "orgView",
     		"bSortable" : false,
     		"sWidth":"100px",
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "dataView",
     		"bSortable" : false,
     		"sWidth":"80px",
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
 			var fsv = $("#result_length select[name='result_length']").val();
         }
     });

	 $("#query").live("click",function(){ 
		 if(($("#billDay").val() != '-1' && $("#countTime").val() == '') || ($("#billDay").val() == '-1' && $("#countTime").val() != '')){
			 $.dopAlert("账单日,统计时间必须同时选择");
			 return;
		 }
		 TableManaged.fnDraw();
	});

	 /**
	 * excel导出
	 */
	 $("#report").live(
		"click",
		function() {
			var lenderCode = $("#lenderCode").val();
			var billDay = $(
					"#billDay").val();
			var countTime = $("#countTime")
					.val();
			if (lenderCode == '' && billDay == '-1'
					&& countTime == ''
					) {
				$.dopAlert("导出前请先选择条件！");
				return;
			}
			if (($("#billDay").val() != '-1' && $("#countTime").val() == '') || ($("#billDay").val() == '-1' && $("#countTime").val() != '')) {
				$.dopAlert("请选择账单日和统计日期!");
				return;
			}
			//导出列表时导出按钮不可选
			 $("#report").attr("disabled", "disabled");
			 //定时释放导出列表按钮
			 window.setInterval(function(){
				 $("#report").removeAttr("disabled");
			 }, 10000);//
			var url = base
					+ "/report/interest/excelExoprt.json?"
					+ $("#queryForm").serialize();
			$.dopAlert("正在生成报表文件，请不要刷新页面，耐心等候");
			window.setInterval(function(){
				$("#okDopAlertButton").click();
			 }, 10000);//
			window.location.href = url
		});

	 
	 
});	
