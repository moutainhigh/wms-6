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
        "aoColumns" : [{
     		"mData" : "user",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "investSize",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
     			if(data == 0){
     				return data;
     			}
     			return "<a href='javascript:;' class='invest' data='" + full.userId + "'>" + data + "</a>";
    		}
     	},{    		
     		"mData" : "creditSize",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
     			if(data == 0){
     				return data;
     			}
     			return "<a href='javascript:;' class='credit' data='" + full.userId + "'>" + data + "</a>";
    		}
    	},{    		
     		"mData" : "userId",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
     			return "<button type='button' class='btn mini red remove' data='" + data + "' user='" + full.user + "'>销毁</button>";
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
        	 $("#result_wrapper .row-fluid").css("margin-top","5px");
             var fsv = $("#result_length select[name='result_length']").val();
    		 if(fsv == "-1" || fsv == -1) {
    			$("#result_wrapper li").addClass("disabled");
    		 }
         }
     });
	 $(".remove").live('click',function(){
		var userId = $(this).attr("data");
		$.dopConfirm("您确定销毁[" + $(this).attr("user") + "]的操作吗?", null, function(r) {
			if(r){
				$.ajax({
					url : base + '/block/match/remove.json?userId=' + userId,// 请求url
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
	
	$(".invest").live('click',function(){
		$('#findModal').html('');
		$.ajax({
			url : base + '/block/match/invest/init.json?userId=' + $(this).attr("data") ,// 请求url
			type : "POST",
			async: false,
			dataType : "html",
			contentType : "application/json",
			timeout : 10000,
			success : function(data) {
				$('#findModal').html(data);	
				$('#findModal').modal({
					show : true
				});
			}
		});	
	});
	$(".credit").live('click',function(){
		$('#findModal').html('');
		$.ajax({
			url : base + '/block/match/credit/init.json?userId=' + $(this).attr("data") ,// 请求url
			type : "POST",
			async: false,
			dataType : "html",
			contentType : "application/json",
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

	