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
        "aoColumns" : [{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "lenderCode",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "applyCustName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "idCard",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "bizContractCode",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "transferTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "transferEaAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "creditorRateView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "transferEaCapitalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "transferEaInterestAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "interestMarginView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "currentTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "initTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "initEaBillAmountView",
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
    	}],
         "aLengthMenu": [
             [ 5,  -1],
             [ 5, "全部"] // change per page values here
         ],
         // set the initial value
         "iDisplayLength": 15,
         "bPaginate": false,
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
        	 $("#result_wrapper .row-fluid").css("margin-top","5px");
             var fsv = $("#result_length select[name='result_length']").val();
    		 if(fsv == "-1" || fsv == -1) {
    			$("#result_wrapper li").addClass("disabled");
    		 }
         }
     });
});