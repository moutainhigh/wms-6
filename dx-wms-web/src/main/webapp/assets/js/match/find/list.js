var TableManagedFind;
$(function(){ 
	if(!$(".find-next")){
		$("#findQuery").hide();
		$("#findReset").hide();
		$("#sort").hide();
	}
	TableManagedFind =  $('#findResult').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"100%",
     	"sScrollY":"150px",
     	"sAjaxSource": 'credit.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
        "fnServerParams": function (aoData) {
             aoData.push({ "name": "sort", "value": $("#sort").val()},
              		 	 { "name": "poolId", "value": $("#poolId").val()},
            		 	 { "name": "filterAmountFrom", "value": $("#remainAmountFrom").val()},
           		 	     { "name": "filterAmountTo", "value": $("#remainAmountTo").val()},
	           		 	 { "name": "remainPeriodFrom", "value": $("#remainPeriodFrom").val()},
	       		 	     { "name": "remainPeriodTo", "value": $("#remainPeriodTo").val()},
            		 	 { "name": "userId", "value": $("#userId").val()},
            		 	 { "name": "isFilter", "value": $("#isFilter").val()},
            		 	 { "name": "repayDay", "value": $("#repayDay").val()});
         },
        "aoColumns" : [{
     		"mData" : "poolId",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%",
     		"mRender" : function(data, type, full) {
     			return "<input type='checkbox' name='creditItem' value='" + JSON.stringify(full) + "' />";
    		}
     	},{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
     	},{    		
     		"mData" : "rateView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "undoAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%",
     		"mRender" : function(data, type, full) {
     			return "<span class='label label-info'>" + data + "</span>" ;
     		}
    	},{    		
     		"mData" : "initAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "initPeriod",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "remainPeriod",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "rateYearView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "portDayView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "productView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	}],
         "aLengthMenu": [
             [ 5, 10, 20 , 100 , -1],
             [ 5, 10, 20 , 100 ,"全部"] // change per page values here
         ],
         // set the initial value
         "iDisplayLength": 5,
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
        	 $("#queryCredit").removeAttr("disabled");
        	 $("#findResult_wrapper .dataTables_scrollHeadInner").width("98%");
        	 $("#findResult_wrapper .dataTable").width("99%");
        	 $("#findResult_wrapper .txt-center").width("10%");
        	 $("#findResult_wrapper .row-fluid").css("margin-top","5px");
             var fsv = $("#findResult_length select[name='findResult_length']").val();
    		 if(fsv == "-1" || fsv == -1) {
    			$("#findResult_wrapper li").addClass("disabled");
    		 }
         }
    });
	
	$("#sort").change(function(){
		$("#findForm").find(":input").not(":button,:submit,:reset,:hidden").removeAttr("checked");
		TableManagedFind.fnDraw();
	});
	$("#findQuery").click(function(){
		$("#findForm").find(":input").not(":button,:submit,:reset,:hidden").removeAttr("checked");
		TableManagedFind.fnDraw();
	});
	$("#findReset").click(function(){
		$("#findForm").find(":input").not(":button,:submit,:reset,:hidden,:checkbox").val("").removeAttr("checked").removeAttr("selected");
		$("#findForm").find("select").val("ASC");
		$("select[name=findResult_length]").val(5);
	});
	$("#all").click(function(){
		var check = all.checked;
		$("input[name='creditItem']").each(function() {	
			$(this).attr("checked", check);
			check ? $(this).parent().addClass('checked') : $(this).parent().removeClass('checked');
		});
	});
	
	$("#remainAmountFrom").change(function() {
		$('.error').html('');
		if(!(/^(([1-9]\d*)|\d)(\.\d{1,2})?$/).test($(this).val())){
			$(this).val('');
			$('.error').html('剩余债权必须为金额格式.');
			return;
		}
		if($("#remainAmountTo").val()!=''){
			var to = Math.round($("#remainAmountTo").val()*100);
			var from = Math.round($(this).val()*100);
			if(from > to){
				$(this).val('');
				$('.error').html('剩余债权区间选择非法.');
				return;
			}
		}
	});

	$("#remainAmountTo").change(function() {
		$('.error').html('');
		if(!(/^(([1-9]\d*)|\d)(\.\d{1,2})?$/).test($(this).val())){
			$(this).val('');
			$('.error').html('剩余债权必须为金额格式.');
			return;
		}
		if($("#remainAmountFrom").val()!=''){
			var from = parseInt($("#remainAmountFrom").val());
			var to = parseInt($(this).val());
			if(from > to){
				$(this).val('');
				$('.error').html('剩余债权区间选择非法.');
				return;
			}
		}
	});
	
	$("#remainPeriodFrom").change(function() {
		$('.error').html('');
		if(!(/^[1-9]\d*$/).test($(this).val())){
			$(this).val('');
			$('.error').html('剩余期限必须为正整数.');
			return;
		}
		if($("#remainPeriodTo").val()!=''){
			var to = parseInt($("#remainPeriodTo").val());
			var from = parseInt($(this).val());
			if(from > to){
				$(this).val('');
				$('.error').html('剩余期限区间选择非法.');
				return;
			}
		}
	});

	$("#remainPeriodTo").change(function() {
		$('.error').html('');
		if(!(/^[1-9]\d*$/).test($(this).val())){
			$(this).val('');
			$('.error').html('剩余期限必须为正整数.');
			return;
		}
		if($("#remainPeriodFrom").val()!=''){
			var from = Math.round($("#remainPeriodFrom").val()*100);
			var to = Math.round($(this).val()*100);
			if(from > to){
				$(this).val('');
				$('.error').html('剩余期限区间选择非法.');
				return;
			}
		}
	});
});