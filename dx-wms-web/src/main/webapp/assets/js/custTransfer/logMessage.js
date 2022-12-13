var TableManagedLog;
$(function(){ 
	TableManagedLog =  $('#result').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"200%",
     	"sAjaxSource": 'queryLog.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
 		"fnServerParams": function (aoData) {
 		   aoData.push({ "name": "lenderCustCode", "value": $("#lenderCustCode").val()});
        },
        "aoColumns" : [{
			"mData" : "lenderCustCode",
			"bSortable" : false,
			"sClass" : "txt-center",
		},
		{
			"mData" : "custName",
			"bSortable" : false,
			"sClass" : "txt-center",
		},
		{
			"mData" : "fromOrgName",
			"bSortable" : false,
			"sClass" : "txt-center",
		},
		{
			"mData" : "fromBigTeamName",
			"bSortable" : false,
			"sClass" : "txt-center",
		},
		{
			"mData" : "fromTeamName",
			"bSortable" : false,
			"sClass" : "txt-center",
		},
		{
			"mData" : "fromUserName",
			"bSortable" : false,
			"sClass" : "txt-center",
		},
		{
			"mData" : "toOrgName",
			"bSortable" : false,
			"sClass" : "txt-center",
		},
		{
			"mData" : "toBigTeamName",
			"bSortable" : false,
			"sClass" : "txt-center",
		},
		{
			"mData" : "toTeamName",
			"bSortable" : false,
			"sClass" : "txt-center",
		},
		{
			"mData" : "toUserName",
			"bSortable" : false,
			"sClass" : "txt-center",
		},
		{
			"mData" : "createTimeView",
			"bSortable" : false,
			"sClass" : "txt-center",
		}],
    	"aLengthMenu": [
    	      [ 10, 20, -1],
    	      [ 10, 20, "全部"] // change per page values here
    	  ],
         // set the initial value
         "iDisplayLength": 10,
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
         }
     });
	
});
