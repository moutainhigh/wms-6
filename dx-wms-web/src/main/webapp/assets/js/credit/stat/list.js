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
             aoData.push({ "name": "createDateBegin", "value": $("#createDateBegin").val()},
            		 	 { "name": "createDateEnd", "value": $("#createDateEnd").val()});
         },
         "aoColumns" : [{
     		"mData" : "dateView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "numOneView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "amountOneView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "numSixteenView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "amountSixteenView",
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
	        stat();
	        var fsv = $("#resultList_length select[name='resultList_length']").val();
	        $("#result_wrapper .row-fluid").css("margin-top","10px");
	        if(fsv == "-1" || fsv == -1) {
    			$("#resultList_wrapper li").addClass("disabled");
    		}
         }
     });
	$("#query").click(function(){ 
		TableManaged.fnDraw();
	});
	$(".row-details").live("click", function() {
		var nTr = $(this).parents('tr')[0];
		if (TableManaged.fnIsOpen(nTr)){
            /* This row is already open - close it */
            $(this).addClass("row-details-close").removeClass("row-details-open");
            TableManaged.fnClose( nTr );
        }else{
            /* Open this row */                
            $(this).addClass("row-details-open").removeClass("row-details-close");
            TableManaged.fnOpen( nTr, fnFormatDetails(TableManaged, nTr), 'details' );
        }
	});
	
	function fnFormatDetails ( oTable, nTr ){
		var aData = oTable.fnGetData( nTr );
		$.ajax({
			url : baseUrl + '/credit/stat/detail.json?dateId=' + aData.dateId,// 请求url
			type : "GET",
			async: false,
			dataType : "html",
			contentType : "application/json",
			timeout : 5000,
			success : function(data) {
				html = data;			     
			}
		});
        return html;
    }
	

});