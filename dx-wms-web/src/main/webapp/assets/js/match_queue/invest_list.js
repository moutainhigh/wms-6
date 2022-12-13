var TableManaged;
$().ready(function() {
	TableManaged =  $('#resultList').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"120%",
    	"sAjaxSource": 'invest.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
        "fnServerParams": function ( aoData ) {
             aoData.push( 
            		 	 { "name": "custName", "value": $("#custName").val()},
            		 	 { "name": "lenderWay", "value": $("#lenderWay").val()}
                        );
         },
         "aoColumns" : [{
     		"mData" : "matchBizBaseId",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"mRender" : function(data, type, full) {
     			return "<input type='checkbox' value='" + JSON.stringify(full) + "' />";
         	}	
     	},{
      		"mData" : "lenderCode",
      		"bSortable" : false,
      		"sClass" : "txt-center"
     	},{
     		"mData" : "matchCustName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "matchCustIdCard",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "lenderCustCode",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "productView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "initTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "applyDateView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
    		"mData" : "bizDateView",
    		"bSortable" : false,
    		"sClass" : "txt-center"
    	},{
    		"mData" : "enterDateView",
    		"bSortable" : false,
    		"sClass" : "txt-center"
    	}],
         "aLengthMenu": [
             [ 50, 100],
             [ 50, 100] // change per page values here
         ],
         // set the initial value
         "iDisplayLength": 50,
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
        		if(fsv == "-1" || fsv == -1) {
        			$("#resultList_wrapper li").addClass("disabled");
        		}
         }
     });
});

function count(){
	$.ajax({
		url : baseUrl + '/matchQueue/invest_count.json',// 请求url
		type : "POST",
		async: false,
		dataType : "json",
		contentType : "application/json",
		timeout : 5000,
		success : function(data) {	
			var html = "";
			if(data.items != null && data.items.length>0){
				for(var i = 0 ; i < data.items.length;i++){
					html = html + "<tr><td>" + data.items[i].productView + "</td><td>" + data.items[i].num + "</td><td>" + data.items[i].totalAmountView + "</td></tr>";
				}
			}
			html = html	+ "<tr><th>总计</th><th>" +data.totalCount + "</th><th>" + data.totalAmountView + "</th></tr>"
			$("#sum").html(html);
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			$.dopAlert("操作异常");
		}
	});
}
$(function(){ 
	$("#query").click(function(){ 
		TableManaged.fnDraw();
		count();
	});
	$("#all").click(function(){ 
		var check = all.checked;
		$("input[type='checkbox']").each(function() {
			$(this).attr("checked", check);
			check ? $(this).parent().addClass('checked') : $(this).parent().removeClass('checked');
		});
	});
	$("#reset").click(function(){ 
		$("#matchQueueForm").find(":input").not(":button,:submit,:reset,:hidden").val("").removeAttr("checked").removeAttr("selected");
		$("select[name=resultList_length]").val(50);
	});
	
	$("#add").click(function(){
		var checkFlag = false;
		var items = [];
		$(":checkbox").each(function(i) {		
			if ($(this).attr("checked")) {
				var val = $(this).val();
				if(val != '-1' ){
					checkFlag = true;	
					items.push($.parseJSON(val));
				}
			}
		});
		if (!checkFlag) {
			$.dopAlert("请选择需要加入队列的数据");
			return false;
		}
		
		//to do
		$.dopConfirm("确定要加入队列吗", null, function(r) {
			if(r){
				$.ajax({
					url : baseUrl + '/matchQueue/invest_join.json',// 请求url
					type : "POST",
					async: false,
					dataType : "json",
					contentType : "application/json",
					data : JSON.stringify(items),
					timeout : 5000,
					success : function(data) {	
						var total = data.total;
						var success = data.success;
					    var error = data.error;
					    var msg = "<table class='table table-striped table-bordered table-hover'>"
							+ "<thead><tr><th>总计</th><th>成功</th><th>失败</th></tr></thead>"
							+ "<tbody><tr><td>" + data.totalNum + "</td><td>" + data.successNum + "</td><td>" + data.errorNum + "</td></tr>"
							+ "<tr><td>" + data.totalAmountView + "</td><td>" + data.successAmountView + "</td><td>" + data.errorAmountView + "</td></tr></tbody>"
							+ "</table>";
					    $("#all").removeAttr("checked");
					    $("#all").parent().removeClass("checked");
					    $.dopAlert(msg);
					    TableManaged.fnDraw();
					    count();
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						$.dopAlert("操作异常");
					}
				});
			}
		});		
	});
	
});

function chooseAll(all){
	var check = all.checked;
	$("input[type='checkbox']").each(function() {
		$(this).attr("checked", check);
		check ? $(this).parent().addClass('checked') : $(this).parent().removeClass('checked');
	});
}
