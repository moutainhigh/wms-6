var TableManaged;
$().ready(function() {
	TableManaged =  $('#result').dataTable({
		"bDestroy":true,// 销毁
     	"bFilter": false,// 不显示搜索框
     	"bSort": true, // 排序功能
     	"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
    	"sAjaxSource": 'list.json',// 请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  // 异步请求
        "fnServerParams": function ( aoData ) {
             aoData.push({ "name": "lenderCode", "value": $("#lenderCode").val()},
        		 	 	 { "name": "custName", "value": $("#custName").val()},
            		 	 { "name": "idCard", "value": $("#idCard").val()},
            		 	 { "name": "productId", "value": $("#productId").val()},
              		     { "name": "currentStepKey", "value": $("#currentStepKey").val()});
         },
         "aoColumns" : [{
      		"mData" : "lenderCode",
      		"bSortable" : false,
      		"sClass" : "txt-center"
     	},{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "8%"
     	},{
     		"mData" : "idCard",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "productView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "8%"
     	},{
     		"mData" : "lenderAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "statusView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "8%",
     		"mRender" : function(data, type, full) {
         		if(full.currentStepKey == '21'){
         			return "<span class='label label-success'>" + data + "</span>";
             	}
         		if(full.currentStepKey == '20'){
         			return "<span class='label label-danger'>" + data + "</span>";
         		}
         		return "<span class='label label-info'>" + data + "</span>";
            }
     	},{
    		"mData" : "currentStepKey",
    		"bSortable" : false,
    		"sClass" : "txt-center",
    		"sWidth" : "8%",
    		"mRender" : function(data, type, full) {
         		if(data == '20' || data == '21'){
         			return  ""
         		}
         		return "<button type='button' class='btn mini blue cancel' lenderCode='" + full.lenderCode + "' >客户放弃</button>";
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
         // 回调函数
         "fnDrawCallback":function( oSettings ) {
             $("#query").removeAttr("disabled");
             $("#result_wrapper .row-fluid").css("margin-top","5px");
             var fsv = $("#result_length select[name='result_length']").val();
        		if(fsv == "-1" || fsv == -1) {
        			$("#result_wrapper li").addClass("disabled");
        		}
         }
     });
});

$(function(){ 
	$("#query").live("click",function(){ 
		TableManaged.fnDraw();
	});
	
	$("#reset").live("click",function(){ 
		$("#investInfoForm").find(":input").not(":button,:submit,:reset,:hidden").val("").removeAttr("checked").removeAttr("selected");
		$("select[name=resultList_length]").val(15);
	});
	$(".cancel").live("click", function() {
		var lenderCode = $(this).attr('lenderCode');
		$.dopConfirm("您确定撤销投资[" + lenderCode + "]吗?", null, function(r) {
			if(r){
				var lenderCodes = [];
				lenderCodes.push(lenderCode);
				$.ajax({
					url : baseUrl + '/op/invest/cancel.json',// 请求url
					type : "POST",
					async: false,
					dataType : "json",
					contentType : "application/json",
					data : JSON.stringify(lenderCodes),
					timeout : 5000,
					success : function(data) {	
						$.dopAlert(data.msg);
						TableManaged.fnDraw();
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						$.dopAlert("操作异常");
					}
				});
			}
		});	
	});
	
});



