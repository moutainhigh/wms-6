$(".arrow-down").click(function(){
	if($(this).next().is(':hidden')){
		$(this).next().show();
	}else{
		$(this).next().hide();
	}
});
$("ul li").click(function(){
	$(".navigationTitle").hide();
	//$("#fixShow").nextAll().hide();
	if($(this).index()==0){
		$("#persionInfo").show();
	}else if($(this).index()==1){
		$("#connectionInfo").show();
	}else if($(this).index()==2){
		$("#refundInfo").show();
	}else{
		$("#imageInfo").show();
	}
});

var TableManaged;
$().ready(function() {
	 TableManaged =  $('#linkmanInfo').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"bAutoWidth":false,//自动宽度
     	"bLengthChange":false,//是否显示每页大小的下拉框
     	"bInfo":false,//是否显示表格的一些信息
     	"bProcessing":false,//是否显示“正在处理”这个提示信息
     	//"bScrollInfinite":true,//是否无限滚动
     	"bPaginate": false, //翻页功能
     	//"bScrollCollapse":true,//适当的时候缩起滚动视图
     	"sScrollX": "100%",//是否开启水平滚动
     	"sScrollY": "50%",//是否开启垂直滚动
    	"sAjaxSource": 'list.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
         "fnServerParams": function (aoData) {
        	 aoData.push({"name" : "custName", "value" :""},
						{"name" : "idCard","value" : ""},
						{"name" : "registerTimeBegin","value" : ""},
						{"name" : "registerTimeEnd","value" : ""},
						{"name" : "mobile","value" : ""});
         },
         "aoColumns" : [{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	}],
         //回调函数
	         "fnDrawCallback":function(){
	        		$('#linkmanInfo').mergeCell({
	        			cols: [0,1,2,5,8,9,10]
	        		}); 
//	        		$('#linkmanInfo').closest(".dataTables_scroll").prev().remove();
//	        		$('#linkmanInfo').closest(".dataTables_scroll").next().remove();
	         }
     });
	 
//*********************************************************************//	 
	 TableManaged =  $('#table1').dataTable({
			"bDestroy":true,//销毁
	     	"bFilter": false,//不显示搜索框
	     	"bSort": true, //排序功能
	     	"bAutoWidth":false,//自动宽度
	     	"bLengthChange":false,//是否显示每页大小的下拉框
	     	"bInfo":false,//是否显示表格的一些信息
	     	"bProcessing":false,//是否显示“正在处理”这个提示信息
	     	//"bScrollInfinite":true,//是否无限滚动
	     	"bPaginate": false, //翻页功能
	     	//"bScrollCollapse":true,//适当的时候缩起滚动视图
	     	"sScrollX": "100%",//是否开启水平滚动
	     	"sScrollY": "300px",//是否开启垂直滚动
	     	"sScrollXInner":"100%",
	     	"sScrollYInner":"100%",
	     	"iScrollLoadGap":5,
	    	"sAjaxSource": 'list.json',//请求url
	     	"sServerMethod": "POST",
	 		"bServerSide": true,  //异步请求
	         "fnServerParams": function (aoData) {
	        	 aoData.push({"name" : "custName", "value" :""},
							{"name" : "idCard","value" : ""},
							{"name" : "registerTimeBegin","value" : ""},
							{"name" : "registerTimeEnd","value" : ""},
							{"name" : "mobile","value" : ""});
	         },
	         "aoColumns" : [{
	     		"mData" : "custName",
	     		"bSortable" : false,
	     		"sClass" : "txt-center"
	     	},{    		
	     		"mData" : "custName",
	     		"bSortable" : false,
	     		"sClass" : "txt-center"
	    	},{    		
	     		"mData" : "custName",
	     		"bSortable" : false,
	     		"sClass" : "txt-center"
	    	},{    		
	     		"mData" : "custName",
	     		"bSortable" : false,
	     		"sClass" : "txt-center"
	    	},{    		
	     		"mData" : "custName",
	     		"bSortable" : false,
	     		"sClass" : "txt-center"
	    	},{    		
	     		"mData" : "custName",
	     		"bSortable" : false,
	     		"sClass" : "txt-center"
	    	}],
	         //回调函数
		         "fnDrawCallback":function(){
		        		$('#table1').mergeCell({
		        			cols: [0,1,2,5]
		        		}); 
		        		$('#table1').closest(".dataTables_scroll").prev().remove();
		        		$('#table1').closest(".dataTables_scroll").next().remove();
		         }
	     });
});

