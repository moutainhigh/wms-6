var TableManaged;
$(function(){ 
	 TableManaged =  $('#result').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"300%",
    	"sAjaxSource": 'list.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
        "fnServerParams": function (aoData) {
             aoData.push({ "name": "lenderCustCode", "value": $("#lenderCustCode").val()},
            		 	{ "name": "lenderCode", "value": $("#lenderCode").val()},
           		 	 	{ "name": "billDay", "value": $("#billDay").val()},
           		 	 	{ "name": "countTime", "value": $("#countTime").val()});
         },
         "aoColumns" : [{
				"mData" : "lenderCode",
				"bSortable" : false,
				"sWidth" : "2%",
				"sClass" : "txt-center",
				"mRender" : function(data,
						type, full) {
					return '<input  type="checkbox"  value="'
							+ data + '"/>';
				}
			},{
     		"mData" : "lenderCustCode",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "custAddress",
     		"bSortable" : false,
     		"sWidth":"450px",
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "zipCode",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "reportPeriodBeginView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "billDay",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "accountLevel",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "lenderCode",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "productView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "initLoanDayView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "initTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "lastTotalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "totalAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "recycleAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "loanAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "incomeView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "accountManageRateView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "accountManageAmountView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
    	},{    		
     		"mData" : "totalAmountView",
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
         //回调函数
         "fnDrawCallback":function( oSettings ) {
        	$("#query").removeAttr("disabled");
 			var fsv = $("#result_length select[name='result_length']").val();
         }
     });
});	

$("#query").live("click",function(){ 
if(($("#billDay").val() == '-1' || $("#countTime").val() == '') ){
	 $.dopAlert("请选择账单日,统计时间!");
	 return;
}
TableManaged.fnDraw();
});


/**
 * 全选/取消全选
 */
$("#all").click(function() {
	var $checkbox = $(":checkbox", "#result");
	$checkbox.attr("checked", this.checked)
});


//导出按钮点击弹出列表和pdf导出按钮
$(".report").live("click", function(e) {
	$("#waitexper").show();
	$(".report").hide();
});

//点击空白区域隐藏导出列表和pdf按钮
$("body").click(
	function(e) {
		if ($(e.target).is("input")
				|| $(e.target).is("button")
				|| $( e.target ).closest(".dataTables_length").length != 0
				|| $( e.target ).closest(".dataTables_scroll").length != 0
//							|| $( e.target ).closest(".dataTables_info").length != 0
				|| $( e.target ).closest(".span12").length != 0
				|| $( e.target ).closest(".portlet-title").length != 0
				|| $( e.target ).closest(".modal").length != 0
				|| $(e.target).is("a")
				|| $(e.target).is("span")
				) {
			return;
		}
		$("#waitexper").hide();
		$(".report").show();
	});



/**
 * 下载新增匹配首期协议
 */
$(".pdfReport").live('click',function() {
	var fundParamVo = {};
	var processResult = [];
	$("input:checked", "#result > tbody").each(
					function() {
						processResult.push($(this).val());
						});
	if (processResult.length == 0) {
		$.dopAlert("请选择所要导出的资金报告!");
		return;
	}
	if (($("#billDay").val() == '-1' || $("#countTime").val() == '') ) {
		$.dopAlert("请选择账单日,统计时间!");
		return;
	}
	fundParamVo.billDay = $("#billDay").val();
	fundParamVo.countTime = $("#countTime").val();
	if(!$("#all").is(':checked')){
		fundParamVo.lenderCodes = processResult;
	}
	execute('pdf',fundParamVo);
});

/**
* excel导出
*/
$(".excReport").live("click",function() {
	var lenderCode = $("#lenderCode").val();
	var lenderCustCode = $("#lenderCustCode").val();
	var billDay = $("#billDay").val();
	var countTime = $("#countTime").val();
	if (lenderCode == '' && billDay == '-1'
			&& countTime == ''&& lenderCustCode == ""
			) {
		$.dopAlert("导出前请先选择条件！");
		return;
	}
	if (($("#billDay").val() == '-1' || $("#countTime").val() == '') ) {
		$.dopAlert("请选择账单日,统计时间!");
		return;
	}
	var fundParamVo = {};
	fundParamVo.billDay = billDay;
	fundParamVo.countTime = countTime;
	fundParamVo.lenderCustCode = lenderCustCode;
	fundParamVo.lenderCode = lenderCode;
	execute('excel',fundParamVo);
});

function execute(biz , fundParamVo){
	$.ajax({
		type : "POST",
		async : true,
		dataType : "json",
		contentType : "application/json",
			data : JSON.stringify(fundParamVo),
		url : base+ "/report/fund/"+biz+"_report.json",
		success : function(data) {
				$.dopAlert(data.msg);
		},
		error : function(data) {
			$.dopAlert(data.msg);
		}
	});
}


