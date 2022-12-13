var TableManaged;

$().ready(function() {
	$("#custName").attr("maxlength", 20);
	$("#idCard").attr("maxlength", 18);
	
	 TableManaged =  $('#resultList').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"100%",
    	"sAjaxSource": 'quality.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
         "fnServerParams": function ( aoData ) {
             aoData.push( 
            		 	 { "name": "custName", "value": $("#custNameQuery").val()},
            		 	 { "name": "idCard", "value": $("#idCardQuery").val()},
              		     { "name": "signDateBegin", "value": $("#signDateBegin").val()},
              		     { "name": "signDateEnd", "value": $("#signDateEnd").val()},
              		     { "name": "lenderCode", "value": $("#lenderCodeQuery").val()},
              		     { "name": "lenderAmountArea", "value": $("#lenderAmountQuery").val()},
              		     { "name": "bizBillDay", "value": $("#bizBillDayQuery").val()},
              		     { "name" : "currentStep","value" : $("#currentStepQuery").val()},
              		     { "name" : "type","value" : $("#type").val()},
              		     { "name": "productId", "value": $("#loanWayQuery").val()}
                        );
         },
         "aoColumns" : [{
     		"mData" : "lenderCode",
     		"bSortable" : false,
     		"sWidth":"70px",
     		"sClass" : "txt-center",
			"mRender" : function(data, type, full) {
			    if(full.parentId > 0 ) {
			    	return "<span style='color:red'>" + data + "</span>";
			    } else {
			    	return "<span >" + data + "</span>";
			    }
			}
     	},{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sWidth":"100px",
     		"sClass" : "txt-center"
     	},{
      		"mData" : "idCard",
      		"bSortable" : false,
      		"sWidth":"100px",
      		"sClass" : "txt-center"
     	},
     	{
     		"mData" : "product",
     		"bSortable" : false,
     		"sWidth":"50px",
     		"sClass" : "txt-center"
     	},{
     		"mData" : "lenderAmountView",
     		"bSortable" : false,
     		"sWidth" : "75px",
     		"sClass" : "txt-center"
     	},{
     		"mData" : "signDate",
     		"bSortable" : false,
     		"sWidth" : "50px",
     		"sClass" : "txt-center"
     	},{
			"mData" : "payWay",
			"bSortable" : false,
			"sWidth" : "50px",
			"sClass" : "txt-center"
		},{
    		"mData" : "formStatus",
    		"bSortable" : false,
    		"sWidth":"50px",
    		"sClass" : "txt-center",
    		"mRender" : function(data, type, full) {
    			if (data == "10"){
    				return "<button type='button' class='btn mini blue' onclick='checkQuality(\"" + full.custAccountId + "\",\""+full.lenderApplyId+"\",\""+ full.lenderCode +"\")'  >质检</button>";
    			}
    			return "";
			}
    	}],
    	"aLengthMenu": [
    	       	     [ 20, 40, 60, 80, 100, -1],
    	       	     [ 20, 40, 60, 80, 100, "全部"] // change per page values here
    	       	  ],
         // set the initial value
         "iDisplayLength": 20,
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


$(function(){ 
	$("#query").click(function(){ 
		TableManaged.fnDraw();
	});
	
	$("#reset").click(function(){ 
		$("#custNameQuery").val("");
		$("#signDateBegin").val("");
		$("#signDateEnd").val("");
		$("#loanWayQuery").val("");
		$("#idCardQuery").val("");
		$("#lenderCodeQuery").val("");
		$("#lenderAmountQuery").val("-1");
		$("#currentStepQuery").val("-1");
		$("#bizBillDayQuery").val("");
	});
		
});


function checkQuality(custAccountId,lenderApplyId,lenderCode) {
	var url =base + "/process/quality_create.json?custAccountId="+custAccountId+"&lenderApplyId="+lenderApplyId;
	$.get(url, function(data) {
        $('#detailModal').html(data);
    });
    $('#detailModal').modal({
        show : true
    });
}


function closed() {
	$('#failReasonDiv').modal("hide");
	$("#dealDetail").hide();
	$("#showFailReason").html("未说明出资失败理由");
}


$("#signDateBegin").change(function() {
	if (null != this.value && $.trim(this.value) != "") {
		var dateArr = this.value.split("-");
		var year = dateArr[0];
		var month = dateArr[1];
		var day = dateArr[2];
		var selDate = new Date();
		selDate.setFullYear(year, month - 1, day);
		if (selDate <= new Date()) {
			
		} else {
			$("#signDateBegin").val("");
		}
	}

	});

	$("#signDateEnd").change(function() {
	if (null != this.value && $.trim(this.value) != "") {
		var dateArr = this.value.split("-");
		var year = dateArr[0];
		var month = dateArr[1];
		var day = dateArr[2];
		var selDate = new Date($("#signDateEnd").val());
		selDate.setFullYear(year, month - 1, day);
		if ( selDate >= new Date($("#signDateBegin").val())){

		} else {
			$("#signDateEnd").val("");
		}
	}
	});