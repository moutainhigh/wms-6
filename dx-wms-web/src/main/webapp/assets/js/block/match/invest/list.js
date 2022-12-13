var TableManagedInvest;
$(function(){ 
	TableManagedInvest =  $('#resultInvest').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"100%",
     	"sScrollY":"300px",
     	"sAjaxSource": 'invest/list.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
 		"fnServerParams": function (aoData) {
            aoData.push({ "name": "userId", "value": $("#userId").val()});
        },
        "aoColumns" : [{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "20%"
     	},{    		
    		"mData" : "idCard",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "20%"
     	},{    		
     		"mData" : "lenderCode",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "undoAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	}],
         "aLengthMenu": [
             [-1],
             ["全部"] // change per page values here
         ],
         // set the initial value
         "iDisplayLength": 5,
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
        	 $("#resultInvest_wrapper .dataTables_scrollHeadInner").width("100%");
        	 $("#resultInvest_wrapper .dataTable").width("99%");
        	 $("#resultInvest_wrapper .txt-center").width("20%");
        	 $("#resultInvest_wrapper .row-fluid").css("margin-top","5px");
             var fsv = $("#resultInvest_length select[name='result_length']").val();
    		 if(fsv == "-1" || fsv == -1) {
    			$("#resultInvest_wrapper li").addClass("disabled");
    		 }
         }
     });	
});