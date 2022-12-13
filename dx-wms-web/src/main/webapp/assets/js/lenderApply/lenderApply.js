var TableManaged;

function showCustomers(){
	$("#custName").attr("maxlength", 20);
	$("#idCard").attr("maxlength", 18);
	$("#mobile").attr("maxlength", 11);
	 TableManaged =  $('#resultCustList').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"100%",
    	"sAjaxSource": 'select.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
         "fnServerParams": function ( aoData ) {
             aoData.push( 
            		 	 { "name": "custName", "value": $("#custName").val()},
            		 	 { "name": "idCard", "value": $("#idCard").val()}
                        );
         },
         "aoColumns" : [{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sWidth":"12%",
     		"sClass" : "txt-center"
     	},{
     		"mData" : "idType",
     		"bSortable" : false,
     		"sWidth":"15%",
     		"sClass" : "txt-center"
     	},{
     		"mData" : "idCard",
     		"bSortable" : false,
     		"sWidth":"18%",
     		"sClass" : "txt-center"
     	},{
      		"mData" : "mobile",
      		"bSortable" : false,
      		"sWidth":"14%",
      		"sClass" : "txt-center"
     	},
     	{
     		"mData" : "sex",
     		"bSortable" : false,
     		"sWidth":"7%",
     		"sClass" : "txt-center"
     	},
     	{
    		"mData" : "custId",
    		"bSortable" : false,
    		"sWidth":"50px",
    		"sClass" : "txt-center",
    		"mRender" : function(data, type, full) {
    			return "<button type='button' class='btn mini blue' onclick='selectProcess(" + full.custId +")'  >选择</button>";
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
             var fsv = $("#resultCustList_length select[name='resultCustList_length']").val();
        		if(fsv == "-1" || fsv == -1) {
        			$("#resultCustList_wrapper li").addClass("disabled");
        		}
         }
     });
	
}

$(function(){ 
	showCustomers();
	$("#page2").hide();
	$("#page3").hide();
	$("#page4").hide();
	
	
	$("#queryCust").click(function(){ 
		showCustomers();
	});
	
	$("#resetCust").click(function(){ 
		$("#page1 #custName").val("");
		$("#page1 #idCard").val("");
	});
	
});

/**
 * 选择理财申请用户
 * @param custId	理财申请用户
 */
function selectProcess(custId){
	var url = 'create.json?type=2&custAccountId='+custId;
    
    $("#page1").hide();
    $("#page2").show();
    $("#page3").hide();
    $("#page4").hide();
    
    
    $.ajax({
        async: false,                
        type : "post",                         
        url : url,                
        dataType : "json",
        success : function(data) {                
               
        }
   });
    // ??????????
//    $.post(url, function(data) {
//        $('#createCustAccountDiv').html(data);         
//    });
//    $('#createCustAccountDiv').modal({
//        show : true
//    });
	//window.location.href=base + "/custView/create.htm?custId="+custId;
}


