var TableManaged;
$().ready(function() {
	 TableManaged =  $('#result').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"100%",
    	"sAjaxSource": 'list.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
         "fnServerParams": function (aoData) {
             aoData.push({ "name": "initMatchDateBegin", "value": $("#initMatchDateBegin").val()},
            		 	 { "name": "initMatchDateEnd", "value": $("#initMatchDateEnd").val()});
         },
         "aoColumns" : [{
     		"mData" : "dateView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "numView1",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "amountView1",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{
     		"mData" : "numView16",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "amountView16",
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
});