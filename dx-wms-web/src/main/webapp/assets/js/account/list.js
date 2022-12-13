var TableManaged;
$().ready(function() {
	TableManaged =  $('#resultList').dataTable({
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
             aoData.push( 
            		 	 { "name": "custName", "value": $("#custName").val()},
        		 	 	 { "name": "accountLevelId", "value": $("#accountLevelId").val()}
                        );
         },
         "aoColumns" : [
        {
			"mData" : "matchUserId",
			"bSortable" : false,
			"sClass" : "txt-center",
			"mRender" : function(data, type, full) {
         		return "<span class='row-details row-details-close' matchUserId='" + data + "'></span>";
            }
		},
        {
      		"mData" : "custName",
      		"bSortable" : false,
      		"sClass" : "txt-center"
     	},
     	{
     		"mData" : "idCard",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},
    	{
     		"mData" : "currentAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},
     	{
     		"mData" : "investNum",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},
     	{
     		"mData" : "accountLevelName",
     		"bSortable" : false,
     		"sClass" : "txt-center",
			"mRender" : function(data, type, full) {
				return "<span class='badge badge-important'>" + data + "</span>";
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
		$("#investInfoForm").find(":input").not(":button,:submit,:reset,:hidden").val("").removeAttr("checked").removeAttr("selected");
		$("select[name=resultList_length]").val(15);
	});
	
	function fnFormatDetails ( oTable, nTr ){
		var aData = oTable.fnGetData( nTr );
        var matchUserId = aData.matchUserId;
        var sOut = "";
        $.ajax({
			url : baseUrl + '/account/detail.json?matchUserId=' + matchUserId,// 请求url
			type : "GET",
			async: false,
			contentType : "application/text",
			timeout : 5000,
			success : function(datas) {
				sOut = "<table class='table table-hover'>";
			    sOut += '<thead><tr><th>出借编号</th><th>出借方式</th><th>出借金额</th><th>当前期数</th><th>账单日</th><th>当前资产价值</th><th>投资生效日</th><th>数据状态</th></tr></thead><tbody>';
			    for(var i = 0 ; i < datas.length;i++){
			    	var data = datas[i];
			    	sOut += "<tr><td>" + data.lenderCode + "</td><td>" + data.productView + "</td><td>" 
			    	 	 + data.lenderAmountView + "</td><td>" + data.currentPeriod + "</td><td>" 
			    	 	 + data.billDay + "</td><td>" + data.currentAmountView + "</td><td>"
			    	 	 + data.effectDateView + "</td><td><span class='label label-success'>" + data.dataStatusView + "</span></td></tr>";
			     }   
			     sOut += '</tbody></table>';
			     
			}
		});
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
	
	/**
	 * 上传影像资料
	 */
	$("#import").live("click", function() {
		$('#importData').modal({
			show : true
		});
	});
	/**
	 * 导出excel
	 */
	$(".excelReport").live(
			"click",
			function() {
				var custName = $("#custName").val();
				var accountLevelId = $("#accountLevelId").val();
				
				//导出列表时导出按钮不可选
				 $(".excelReport").attr("disabled", "disabled");
				 //定时释放导出列表按钮
				 window.setInterval(function(){
					 $(".excelReport").removeAttr("disabled");
				 }, 10000);//


				var url = base
						+ "/account/excelExport.json?"
						+ $("#queryForm").serialize();
				$.dopAlert("正在生成报表文件，请不要刷新页面，耐心等候");
				window.setInterval(function(){
					$("#okDopAlertButton").click();
				 }, 10000);//
				window.location.href = url
			});
	
});



