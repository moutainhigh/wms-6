var TableManaged;
$().ready(function() {
	 TableManaged =  $('#result').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"140%",
    	"sAjaxSource": 'list.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
         "fnServerParams": function (aoData) {
             aoData.push({ "name": "lenderCode", "value": $("#lenderCode").val()},
            		 	{ "name": "custName", "value": $("#custName").val()});
         },
         "aoColumns" : [{
    		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "8%"
    	},{    		
     		"mData" : "lenderCode",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "lenderCustCode",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "idCard",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "initTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{
     		"mData" : "productName",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
     	},{    		
     		"mData" : "currentTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "dateView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "billDayView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "6%"
    	},{    		
     		"mData" : "interestBeginTimeView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "poolId",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
     			if(full.productName == '需变更产品'){
     				return "<button disabled='disabled' type='button' class='btn mini red update' data='" + data + "' product='" + full.productName + "'>变更</button>";
     			}else{
     				return "<button type='button' class='btn mini red update' data='" + data + "' product='" + full.productName + "'>变更</button>";
     			}
     		}
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

	$("#query").click(function(){ 
		TableManaged.fnDraw();
	});
	$(".update").live('click',function(){
		var poolId = $(this).attr("data");
		console.log($(this).val("data"));
		var productName = $(this).attr("product");
		var newProductName = productName == "达信宝"?"月利盈":"达信宝";
		$.dopConfirm("您确定将[" + productName + "]变更为[" + newProductName + "]吗?", null, function(r) {
			if(r){
				$.ajax({
					url : base + '/op/invest/update/update.json?poolId=' + poolId,// 请求url
					type : "GET",
					async: false,
					dataType : "json",
					contentType : "application/json",
					timeout : 10000,
					success : function(data) {
						if(data.result){
							TableManaged.fnDraw();
						}
						$.dopAlert(data.msg);		    
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						$.dopAlert('操作异常');	
					}
				});
			}
		});
	});
});