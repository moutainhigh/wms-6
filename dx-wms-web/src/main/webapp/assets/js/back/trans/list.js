var TableManaged;
$(function(){ 
	TableManaged =  $('#result').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"221%",
     	"sAjaxSource": 'list.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
 		"fnServerParams": function (aoData) {
 		   aoData.push({ "name": "lenderCode", "value": $("#lenderCode").val()},
       		 	       { "name": "billDay", "value": $("#billDay").val()},
       		 	       { "name": "transTimeBegin", "value": $("#transTimeBegin").val()},
       		 	       { "name": "transTimeEnd", "value": $("#transTimeEnd").val()},
 		   			   { "name": "productId", "value": $("#productId").val()});
        },
        "aoColumns" : [{
        	"mData" : "poolId",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "3%",
     		"mRender" : function(data, type, full) {
     			return "<input type='checkbox' value='" + JSON.stringify(full) + "' />";
     		}
    	},{
     		"mData" : "billDay",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "4%"
     	},{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "4%"
     	},{    		
    		"mData" : "idCard",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "5%"
     	},{    		
     		"mData" : "lenderCode",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "5%"
    	},{    		
     		"mData" : "productName",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "5%"
    	},{    		
     		"mData" : "totalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "5%"
    	},{    		
     		"mData" : "interestBeginTimeView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "5%"
    	},{    		
     		"mData" : "transTimeView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "5%"
    	},{    		
     		"mData" : "transTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "6%"
    	},{    		
     		"mData" : "payTimeView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "6%"
    	},{    		
     		"mData" : "payTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "6%"
    	},{    		
     		"mData" : "backBankView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
    	},{    		
     		"mData" : "backAccountName",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "4%"
    	},{    		
     		"mData" : "backAccountNum",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "6%"
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
	
	$("#all").click(function(){
		var check = all.checked;
		$("input[type='checkbox']").each(function() {
			$(this).attr("checked", check);
			check ? $(this).parent().addClass('checked') : $(this).parent().removeClass('checked');
		});
	});
	$(".push").live('click', function() {
		var checkFlag = false;
		var items = [];
		$(":checkbox").each(function(i) {
			if ($(this).attr("checked")) {
				var val = $(this).val();
				if (val != '-1') {
					checkFlag = true;
					items.push($.parseJSON(val));
				}
			}
		});
		if (!checkFlag) {
			$.dopAlert('请勾选您要推送的数据!');
			return false;
		}
		// post to controller
		$.ajax({
			url : base + "/back/trans/push.json",// 请求url
			type : "POST",
			async: false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(items),
			timeout : 5000,
			success : function(data) {
				$.dopAlert(data.msg);
				TableManaged.fnDraw();
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$(".error").html('操作异常');
			}
		});	
	});
	
	
	/**
	 * 导出excel
	 */
	$("#excelReport").live(
			"click",
			function() {
				var lenderCode = $("#lenderCode").val();
				var billDay = $("#billDay").val();
				var transTimeBegin = $(
						"#transTimeBegin").val();
				var transTimeEnd = $("#transTimeEnd")
						.val();
				var productId = $("#productId").val();
				if (lenderCode==''&& billDay == '-1' 
						&& transTimeBegin == ''
						&& transTimeEnd == ''
						&& productId=='-1') {
					$.dopAlert("导出前请先选择条件！");
					return;
				}
				if (transTimeBegin != ''&& transTimeEnd == '') {
					$.dopAlert("请选择转让结束日期！");
					return;
				}
				/*var begin = $("#transTimeBegin").val()
						.split("-");
				var end = $("#transTimeEnd").val().split(
						"-");
				var result = end[2] - begin[2];
				console.log(result);
				if (result > 5) {
					$.dopAlert("请选择5天内的数据！");
					return;
				}*/
				
				//导出列表时导出按钮不可选
				 $("#excelReport").attr("disabled", "disabled");
				 //定时释放导出列表按钮
				 window.setInterval(function(){
					 $("#excelReport").removeAttr("disabled");
				 }, 10000);//
				var url = base
						+ "/back/trans/excelExport.json?"
						+ $("#queryForm").serialize();
				$.dopAlert("正在生成报表文件，请不要刷新页面，耐心等候");
				window.setInterval(function(){
					$("#okDopAlertButton").click();
				 }, 10000);//
				window.location.href = url
			});
	
			$("#transTimeEnd").live("change", function(){
						var transTimeBegin = $("#transTimeBegin").val();
						var transTimeEnd = $("#transTimeEnd").val();
						
						if (''==transTimeBegin){
							$("#transTimeEnd").val("");
						}else{
							var beginArray = $("#transTimeBegin").val().split("-");
							var endArray = $("#transTimeEnd").val().split("-");
							var begin = new Date(beginArray[0], beginArray[1], beginArray[2]);
							var end = new Date(endArray[0], endArray[1], endArray[2]);
							var result = ((end.getTime()-begin.getTime())/(1000*60*60*24));
							if(result<0){
								$("#transTimeEnd").val("");
							}
						}
					});
});
