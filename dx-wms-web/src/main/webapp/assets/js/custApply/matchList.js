var TableManagedMatch;
$(function(){
	$(".tab-content").scrollTop(0);
	//初始化重新匹配列表
	TableManagedMatch =  $('#matchResult').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"150%",
     	"sScrollY":"160px",
     	"sAjaxSource": base+'/operate/creditor.json',
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
 		"fnServerParams": function (aoData) {
            aoData.push({ "name": "lenderCode", "value": $("#lenderCode").val()});
        },
        "aoColumns" : [{
     		"mData" : "poolId",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
     			return "<input type='checkbox'  value='" + data + "' name='reMatch'/>";
    		}
     	},{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "idCard",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "transAmount",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "payAmount",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "workState",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "loanType",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "repayBeginDateVo",
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
        	 $("#matchResult_wrapper .row-fluid").css("margin-top","-5px");
             var fsv = $("#matchResult_length select[name='matchResult_length']").val();
    		 if(fsv == "-1" || fsv == -1) {
    			$("#matchResult_wrapper li").addClass("disabled");
    		 }
         }
     });
});


/**
 * 全选/取消全选
 */
$('#matchAll').click(function () {
    var $checkbox = $(':checkbox[name="reMatch"]');
    $checkbox.attr('checked', this.checked)
});

