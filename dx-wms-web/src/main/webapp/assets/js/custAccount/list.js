var TableManaged;
$().ready(function() {
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
             aoData.push({ "name": "custName", "value": $("#custNameQuery").val()},
            		 	 { "name": "idCard", "value": $("#idCardQuery").val()},
              		     { "name": "openDateBegin", "value": $("#openDateBegin").val()},
              		     { "name": "openDateEnd", "value": $("#openDateEnd").val()},
              		     { "name": "mobile", "value": $("#mobileQuery").val()});
         },
         "aoColumns" : [{
     		"mData" : "lenderCustCode",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "16%"
     	},{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"	
     	},{    		
     		"mData" : "idCard",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "16%"
     	},{
     		"mData" : "mobile",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "16%"
     	},{
     		"mData" : "openDateView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
     	},{
     		"mData" : "dataStatusView",
     		"bSortable" : false,
     		"sClass" : "txt-center",
     		"sWidth" : "10%"
     	},{
    		"mData" : "dataStatus",
    		"bSortable" : false,
    		"sClass" : "txt-center",
    		"mRender" : function(data, type, full) {
    			var buttons = "";
    			if(data == 'A' || data == 'F'){
    				buttons = "<input type='button' custAccountId=" + full.custAccountId + " class='btn mini red ml1 edit' value='编辑' />";			
				}  
    			//待认证状态  编辑/详情
    			if(full.lenderCustCode != "" && full.lenderCustCode != null){
    				buttons = buttons +  "<input type='button' custAccountId=" + full.custAccountId + " class='btn mini red ml1 apply' value='申请' />";
    			}		  			
    			buttons = buttons + "<input type='button' custAccountId=" + full.custAccountId + " class='btn mini blue ml1 detail' value='详情' />";
    			return buttons;
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
	        $("#result_wrapper .row-fluid").css("margin-top","10px");
	        if(fsv == "-1" || fsv == -1) {
    			$("#resultList_wrapper li").addClass("disabled");
    		}
         }
     });
});


$(function(){ 
	$("#custNameQuery").attr("maxlength", 6);
	$("#idCardQuery").attr("maxlength", 18);
	$("#mobileQuery").attr("maxlength", 11);
	$("#query").click(function(){ 
		TableManaged.fnDraw();
	});
	
	$("#reset").click(function(){ 
		$("#accountForm").find(":input").not(":button,:submit,:reset,:hidden").val("").removeAttr("checked").removeAttr("selected");
		$("select[name=result_length]").val(15);
	});
	
	//创建
	$("#create").click(function(){
		var url = base + "/select/view.json";
		$.get(url, function(data) {
	        $('#editModal').html(data);
	    });
	    $('#editModal').modal({
	        show : true
	    });
	});
	
	//申请投资
	$(".apply").live("click", function() {
		var url = base + "/save/apply_create.json?id=" + $(this).attr("custAccountId");
	    $.get(url, function(data) {
	        $('#editModal').html(data);
	    });
	    $('#editModal').modal({
	        show : true
	    });
	});

	$(".edit").live("click", function() {
		var url = base + "/save/account_edit.json?id=" + $(this).attr("custAccountId");
	//	var url ='create.json?custId=-1&custAccountId=' + $(this).attr("custAccountId");
		$.get(url, function(data) {
	        $('#editModal').html(data);
	    });
	    $('#editModal').modal({
	        show : true
	    });
	});	
	
});




