var TableManaged;
$().ready(function() {
	TableManaged =  $('#resultList').dataTable({
		"bDestroy":true,// 销毁
     	"bFilter": false,// 不显示搜索框
     	"bSort": true, // 排序功能
     	"sScrollX": "100%",
        "sScrollXInner": "120%",
        "bScrollCollapse": true,
    	"sAjaxSource": 'list.json',// 请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  // 异步请求
        "fnServerParams": function ( aoData ) {
             aoData.push( 
            		 	 { "name": "custName", "value": $("#custName").val()},
        		 	 	 { "name": "productId", "value": $("#productId").val()},
            		 	 { "name": "lenderCode", "value": $("#lenderCode").val()},
            		 	 { "name": "billDay", "value": $("#billDay").val()},
              		     { "name": "matchDateBegin", "value": $("#matchDateBegin").val()},
              		     { "name": "matchDateEnd", "value": $("#matchDateEnd").val()},
              		     { "name": "initMatchDateBegin", "value": $("#initMatchDateBegin").val()},
            		     { "name": "initMatchDateEnd", "value": $("#initMatchDateEnd").val()},
            		     { "name": "transDateBegin", "value": $("#transDateBegin").val()},
              		     { "name": "transDateEnd", "value": $("#transDateEnd").val()}
                        );
         },
         "aoColumns" : [{
      		"mData" : "poolId",
      		"bSortable" : false,
      		"sClass" : "txt-center",
			"mRender" : function(data, type, full) {
         		return "<span class='row-details row-details-close'></span>";
            }
     	},{
      		"mData" : "lenderCode",
      		"bSortable" : false,
      		"sClass" : "txt-center"
     	},
     	{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},
    	{
     		"mData" : "productView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},
     	{
     		"mData" : "initTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},
     	{
     		"mData" : "billDay",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},
     	{
     		"mData" : "transTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},
     	{
     		"mData" : "transCreditorAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},
     	{
     		"mData" : "transTimeView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},
     	{
     		"mData" : "interestBeginTimeView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},
     	{
    		"mData" : "initMatchTimeView",
    		"bSortable" : false,
    		"sClass" : "txt-center"
    	},
     	{
    		"mData" : "matchDateView",
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
         // 回调函数
         "fnDrawCallback":function( oSettings ) {
             $("#query").removeAttr("disabled");
             var fsv = $("#resultList_length select[name='resultList_length']").val();
        		if(fsv == "-1" || fsv == -1) {
        			$("#resultList_wrapper li").addClass("disabled");
        		}
         }
     });
});

$(function(){ 
	$("#query").live("click",function(){ 
		TableManaged.fnDraw();
	});
	
	$("#reset").live("click",function(){ 
		$("#matchQueueForm").find(":input").not(":button,:submit,:reset,:hidden").val("").removeAttr("checked").removeAttr("selected");
		$("select[name=resultList_length]").val(15);
	});
	$("#export").live("click",function(){
		window.location.href = "export.htm?lenderCode=" + $("#lenderCode").val() + "&billDay=" + $("#billDay").val()
							 + "&matchDateBegin=" + $("#matchDateBegin").val() + "&matchDateEnd=" + $("#matchDateEnd").val();
	});
	$(".detail").live("click", function() {
		var bizId = $(this).attr('bizId');
		$('#matchModel').html('');
		$.ajax({
			url : baseUrl + '/matchView/detail.json?bizId=' + bizId,// 请求url
			type : "GET",
			async: false,
			contentType : "application/text",
			timeout : 5000,
			success : function(data) {
				$('#matchModel').html(data);
				$('#matchModel').modal({
				    show : true
				});
			}
		});
	});
	$(".download").live("click", function() {
		var bizId = $(this).attr('bizId');
		var custName = $(this).attr('custName');
		$(this).attr("disabled","disabled");
	    window.location.href="download.htm?bizId=" + bizId + "&custName=" + custName;
	});
	
	function fnFormatDetails ( oTable, nTr ){
		 var aData = oTable.fnGetData( nTr );
         var sOut = '<table>';
         if(aData){
        	 for(var i=1 ; i <= aData.currentPeriod ; i++){
        		 if(i == 1){
        			 sOut += "<tr><td><span class='badge badge-important'>第 " + i + "期</span></td><td><button type='button' class='btn mini blue detail' bizId='" + aData.bizId + "'>首期债权及受让协议</button></td></tr>";
        		 }else{
        			 sOut += '<tr><td>第' + i + '期：</td><td></td></tr>';
        		 }
        	 }
         }
         sOut += '</table>';   
         return sOut;
    }
	$(".row-details").live("click", function() {
		var nTr = $(this).parents('tr')[0];
		if ( TableManaged.fnIsOpen(nTr) )
        {
            /* This row is already open - close it */
            $(this).addClass("row-details-close").removeClass("row-details-open");
            TableManaged.fnClose( nTr );
        }
        else
        {
            /* Open this row */                
            $(this).addClass("row-details-open").removeClass("row-details-close");
            TableManaged.fnOpen( nTr, fnFormatDetails(TableManaged, nTr), 'details' );
        }
	});
});

function chooseAll(all){
	var check = all.checked;
	$("input[type='checkbox']").each(function() {
		$(this).attr("checked", check);
		check ? $(this).parent().addClass('checked') : $(this).parent().removeClass('checked');
	});
}


