var TableManagedMatch;
$(function(){ 
	TableManagedMatch =  $('#matchResult').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"100%",
     	"sScrollY":"270px",
     	"sAjaxSource": 'one/match.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
        "aoColumns" : [{
     		"mData" : "credit.custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{   		
     		"mData" : "matchAmount",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
     			return "<input type='text' id='match_" + full.credit.poolId + "' name='matchAmount' class='small m-wrap matchAmount' undoAmount='" + full.credit.undoAmount + "' poolId='"+ full.credit.poolId + "' value='" + data + "'>";
     		}
    	},{    		
     		"mData" : "credit.undoAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
     			return "<span class='label label-info'><a href='javascript:;' class='copy'  poolId='"+ full.credit.poolId + "'>" + data + "</a></span>";
     		}
    	},{    		
     		"mData" : "credit.initAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "credit.initPeriod",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "credit.remainPeriod",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "credit.rateYearView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "credit.portDayView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "credit.productView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "credit.poolId",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
     			return "<button type='button' class='btn mini red remove' data='" + JSON.stringify(full.credit) + "' >移除</button>";
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

	$(".remove").live('click',function(){
		var items = [];
		items.push($.parseJSON($(this).attr('data')));
		//post to controller		
		$.ajax({
			url : base + $("#biz").val() + '/remove.json?poolId=' + $('#poolId').val() ,// 请求url
			type : "POST",
			async: false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(items),
			timeout : 10000,
			success : function(data) {
				if(data.result){
					$("#totalCounts").html(data.total.totalCounts);
					$("#totalAmounts").html(data.total.totalAmountsView);
					$("#matchCounts").html(data.total.matchCounts);
					$("#matchAmounts").html(data.total.matchAmounts);
					var remainAmounts =  Math.round($("#needAmount").html()*100) - Math.round(data.total.matchAmounts*100);
					$("#remainAmounts").html(remainAmounts/100);
					TableManagedMatch.fnDraw();
				}
			    $(".error").html(data.msg);			    
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				$(".error").html('操作异常');	
			}
		});	
	});
	
	$(".copy").live('click',function(){
		$(".error").html('');
		var id = "#match_" + $(this).attr('poolId');
		var matchAmount = Math.round($(id).attr('undoAmount')*100);
		$(id).val(matchAmount/100);
		var needAmount = Math.round($("#needAmount").html()*100);
		var matchAmounts = 0;
		$("input[name='matchAmount']").each(function() {
			matchAmounts = matchAmounts + Math.round($(this).val()*100);
		});
		if(needAmount <= matchAmounts){
			$(id).val((matchAmount-(matchAmounts-needAmount))/100);
		}
		total();
	});
	
	$(".matchAmount").live('blur',function(){
		$(".error").html('');
		if(!(/^(([1-9]\d*)|\d)(\.\d{1,2})?$/).test($(this).val())){
			$(this).val('0');
			$(".error").html('匹配金额必须为金额格式.');
			total();
			return;
		}
		var matchAmount = Math.round($(this).val()*100);
		if(matchAmount == 0){
			total();
			return;
		}
		var undoAmount = Math.round( $(this).attr('undoAmount')*100);
		if( matchAmount > undoAmount){
			$(this).val('0');
			$(".error").html('匹配金额不能大于剩余债权.');	
			total();
			return;
		}
		var needAmount = Math.round( $("#needAmount").html()*100);
		var matchAmounts = 0;
		$("input[name='matchAmount']").each(function() {
			matchAmounts = matchAmounts + Math.round($(this).val()*100);
		});
		if(needAmount < matchAmounts){
			$(this).val('0');
			$(".error").html('匹配金额大于未匹配金额.');
			total();
			return;
		}
		total();
	});
	
	function total(){
		var matchCounts = 0;
		var matchAmounts = 0;
		$("input[name='matchAmount']").each(function() {
			if(Math.round($(this).val()*100)>0 ){
				matchCounts ++;
				matchAmounts = matchAmounts + Math.round($(this).val()*100);
			}
		});
		var needAmount = Math.round( $("#needAmount").html()*100);
		var remainAmounts = needAmount - matchAmounts;
		$("#matchCounts").html(matchCounts);
		$("#matchAmounts").html(matchAmounts/100);
		$("#remainAmounts").html(remainAmounts/100);
	}
});