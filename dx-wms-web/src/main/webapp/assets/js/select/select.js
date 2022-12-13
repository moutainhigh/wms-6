var selectList;
$().ready(function() {
	selectList =  $('#selectList').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"100%",
     	"sScrollY": "210px",
    	"sAjaxSource": base + '/select/' + $("#biz").val() + '_select.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
        "fnServerParams": function ( aoData ) {
             aoData.push({ "name": "custName", "value": $("#selectForm .custName").val()},
            		 	 { "name": "idCard", "value": $("#selectForm .idCard").val()});
        },
        "aoColumns" : [{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "idTypeView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
     		"mData" : "idCard",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
      		"mData" : "mobile",
      		"bSortable" : false,
      		"sClass" : "txt-center"
     	},{
     		"mData" : "sexView",
     		"bSortable" : false,
     		"sClass" : "txt-center"
     	},{
    		"mData" : "id",
    		"bSortable" : false,
    		"sClass" : "txt-center",
    		"mRender" : function(data, type, full) {
    			return "<input type='button' class='btn mini blue choose' bizId=" + data +" value='选择' />";
    		}
    	}],
         "aLengthMenu": [
             [ 5 ],
             [ 5 ] // change per page values here
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
        	 $("#selectList_wrapper .dataTables_scrollHeadInner").width("100%");
        	 $("#selectList_wrapper .dataTable").width("99%");
        	 $("#selectList_wrapper .txt-center").width("15%");
             var fsv = $("#resultCustList_length select[name='resultCustList_length']").val();
        		if(fsv == "-1" || fsv == -1) {
        			$("#selectList_wrapper li").addClass("disabled");
        		}
         }
     });
});

$(function(){ 
	$("#selectForm .custName").attr("maxlength", 6);
	$("#selectForm .idCard").attr("maxlength", 18);
	$("#selectForm .query").click(function(){ 
		selectList.fnDraw();
	});	
	$("#selectForm .choose").live("click", function() {
		var url = {};
		if($("#biz").val()=='view'){
			//选择潜在客户 请求创建开户
			url = base + "/save/account_create.json?id=" + $(this).attr("bizId");
		}else{
			//选择开户，请求投资
			url = base + "/save/apply_create.json?id=" + $(this).attr("bizId");
		}
	    $.get(url, function(data) {
	        $('#editModal').html(data);
	    });
	});	
	
	//改变样式
	$("input[value='关闭']").css({
		"margin-top":"-15px"
	}).parent().css({
		"margin-top":"-10px",
		"height":"10px"
	});
});



