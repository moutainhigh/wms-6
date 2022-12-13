var TableManaged;
$(function(){ 
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
             aoData.push({ "name": "lenderCode", "value": $("#lenderCode").val()},
            		 	{ "name": "productId", "value": $("#productId").val()},
            		 	{ "name": "filterAmountFrom", "value": $("#matchAmountFrom").val()},
           		 	 	{ "name": "filterAmountTo", "value": $("#matchAmountTo").val()},
            		 	{ "name": "createDateBegin", "value": $("#createDateBegin").val()},
            		 	{ "name": "createDateEnd", "value": $("#createDateEnd").val()},
            		 	{ "name": "category", "value": $("#category").val()});
         },
         "aoColumns" : [{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "idCard",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "lenderCode",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "initAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "undoAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "productView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "categoryView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "dateView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "poolId",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
     			return "<button type='button' class='btn mini red one' data='" + JSON.stringify(full) + "'>匹配</button>";
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
        	stat();
 			$("#result_wrapper .row-fluid").css("margin-top","10px");
 			var fsv = $("#result_length select[name='result_length']").val();
 			if (fsv == "-1" || fsv == -1) {
 				$("#result_wrapper li").addClass("disabled");
 			}
         }
     });

	$("#query").unbind("click").bind("click",function(){ 
		TableManaged.fnDraw();
	});
	$("#matchAmountFrom").change(function() {
		if(!(/^(([1-9]\d*)|\d)(\.\d{1,2})?$/).test($(this).val())){
			$(this).val('');
			return;
		}
		if($("#matchAmountTo").val()!=''){
			var to = Math.round($("#matchAmountTo").val()*100);
			var from = Math.round($(this).val()*100);
			if(from > to){
				$(this).val('');
				return;
			}
		}
	});

	$("#matchAmountTo").change(function() {
		if(!(/^(([1-9]\d*)|\d)(\.\d{1,2})?$/).test($(this).val())){
			$(this).val('');
			return;
		}
		if($("#matchAmountFrom").val()!=''){
			var from = Math.round($("#matchAmountFrom").val()*100);
			var to = Math.round($(this).val()*100);
			if(from > to){
				$(this).val('');
				return;
			}
		}
	});
	$(".one").live("click", function() {
		$('#findModal').html('');
		$.ajax({
			url : base + "/match/add/one.json" ,// 请求url
			type : "POST",
			async: false,
			dataType : "html",
			contentType : "application/json",
			data : $(this).attr('data'),
			timeout : 10000,
			success : function(data) {
				$('#findModal').html(data);	
				$('#findModal').modal({
					show : true
				});
			}
		});	
	});
	
});	
