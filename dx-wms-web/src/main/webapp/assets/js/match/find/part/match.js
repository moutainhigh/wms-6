var TableManagedMatch;
$(function(){ 
	TableManagedMatch =  $('#matchResult').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"100%",
     	"sScrollY":"270px",
     	"sAjaxSource": 'more/match.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
        "aoColumns" : [{
     		"mData" : "investName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "lenderCode",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "totalAmount",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
     			return "<span class='label label-info'>" + data + "</span>";
     		}
     	},{
     		"mData" : "creditName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{   		
     		"mData" : "matchAmount",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
     			return "<span class='label label-info matchAmount' totalAmount='" + full.totalAmount + "' investPoolId='" + full.investPoolId + "' creditPoolId='" + full.creditPoolId + "' matchAmount='" + data + "'>" + data + "</span>";
     		}
    	}],
         "aLengthMenu": [
             [ 5,  -1],
             [ 5, "全部"] // change per page values here
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
        	 //$("#findResult_wrapper .dataTables_scrollHeadInner").width("100%");
        	 //$("#findResult_wrapper .dataTable").width("99%");
        	 //$("#findResult_wrapper .txt-center").width("15%");
        	 $("#findResult_wrapper .row-fluid").css("margin-top","5px");
             var fsv = $("#findResult_length select[name='findResult_length']").val();
    		 if(fsv == "-1" || fsv == -1) {
    			$("#findResult_wrapper li").addClass("disabled");
    		 }
         }
     });
	
});