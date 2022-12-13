var TableManagedStat;
$().ready(function() {
	TableManagedStat =  $('#statList').dataTable({
		"bDestroy":true,//销毁
	 	"bFilter": false,//不显示搜索框
	 	"bSort": true, //排序功能
	 	"sScrollX": "100%",
	 	"sScrollXInner":"100%",
		"sAjaxSource": 'credit_count.json',//请求url
	 	"sServerMethod": "POST",
		"bServerSide": true,  //异步请求
	    "aoColumns" : [{
	 		"mData" : "billDay",
	 		"bSortable" : false,
	 		"sClass" : "txt-center"
	 	},{
	 		"mData" : "num",
	 		"bSortable" : false,
	 		"sClass" : "txt-center"
	 	},{
	 		"mData" : "totalAmountView",
	 		"bSortable" : false,
	 		"sClass" : "txt-center"
	 	}],
	    // set the initial value
	    "iDisplayLength": -1,
	    "bPaginate": false,
	    "aoColumnDefs": [{
	    	'bSortable': false,
	        'aTargets': [0]
	    }],
	    //回调函数
	    "fnDrawCallback":function( oSettings ) {
	    	$("#query").removeAttr("disabled");
	        var fsv = $("#resultList_length select[name='resultList_length']").val();
	    	if(fsv == "-1" || fsv == -1) {
	    		$("#resultList_wrapper li").addClass("disabled");
	    	}
	     }
	 });
});
var TableManagedStat_;
$().ready(function() {
	TableManagedStat_ =  $('#statList_').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"100%",
    	"sAjaxSource": 'credit_count.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
        "aoColumns" : [{
     		"mData" : "billDay",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "num",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "totalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	}],
        // set the initial value
        "iDisplayLength": -1,
        "bPaginate": false,
        "aoColumnDefs": [{
                 'bSortable': false,
                 'aTargets': [0]
         }],
         //回调函数
         "fnDrawCallback":function( oSettings ) {
             $("#query").removeAttr("disabled");
             var fsv = $("#resultList_length select[name='resultList_length']").val();
        		if(fsv == "-1" || fsv == -1) {
        			$("#resultList_wrapper li").addClass("disabled");
        		}
         }
     });
});