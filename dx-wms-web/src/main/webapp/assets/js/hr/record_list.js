var TableManaged;
$(function(){
	$("#query").click(function() {
		TableManaged.fnDraw();
	});
	$("#reset").click(function() {
		$("#jobCategory").val("-1");
		$("#positionName").val("-1");
		$("#employeeName").val("");
		$("#mobile").val("");
		$("#orgId").val("");
	});
	$("#resultList").on("click","button.detail",function(){
		initApproveLog($(this).attr("data-employeeid"));
	});
	$("#close").click(function(){
		$("#logModel").modal('hide');
	});
	/*$("#positionName").change(function() {
		if(this.value != "-1" && $("#jobCategory").val() === "-1") {
			$("#positionName").val("-1");
			$.dopAlert("请先选择工作性质.");
		}
	});*/
	$("#jobCategory").change(function(){
		if(this.value === "-1" && $("#positionName").val() != "-1") {
			$("#positionName").val("-1");
		}
	});
});

function query() {
	$("#query").attr("disabled","disabled");
	TableManaged = $('#resultList').dataTable({
		"bDestroy" : true,// 销毁
		"bFilter" : false,// 不显示搜索框
		"bSort" : true, // 排序功能
		"sScrollX" : "100%",
		"sScrollXInner" : "100%",
		"sAjaxSource" : biz+'.json',// 请求url
		"sServerMethod" : "POST",
		"bServerSide" : true, // 异步请求
		"fnServerParams" : function(aoData) {
			aoData.push(
				{"name" : "jobCategory","value" : $("#jobCategory").val()},	
				{"name" : "positionId","value" : $("#positionName").val()}, 
				{"name" : "name","value" : $("#employeeName").val()}, 
				{"name" : "mobilePhone","value" : $("#mobile").val()},
				{"name" : "orgId","value" : $("#orgId").val()}
			);
		},
		"aoColumns" : [
		{
			"mData" : "name",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "sexView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "departmentView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "positionView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
            "mData": "jobCategoryView",
            "bSortable": false,
            "sClass": "txt-center"
        },
		{
			"mData" : "mobilePhone",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "entryDate",
			"bSortable" : false,
			"sClass" : "txt-center",
			
		},
		{
			"mData" : "employeeId",
			"bSortable" : false,
			"sClass" : "txt-center",
			"mRender" : function(data) {
				return "<button type='button' class='btn mini blue detail' data-employeeid='" + data + "' >日志</button>";
			}

		} ],
		"aLengthMenu" : [
            [ 15, 20, -1 ],
			[ 15, 20, "全部" ]
		],
		// set the initial value
		"iDisplayLength" : 15,
		"sPaginationType" : "bootstrap",
		"oLanguage" : {
			"sLengthMenu" : "每页显示 _MENU_ 条记录",
			"sZeroRecords" : "抱歉， 没有找到",
			"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
			"sInfoEmpty" : "显示 0 至 0 共 0 项",
			"oPaginate" : {
				"sPrevious" : "上一页",
				"sNext" : "下一页"
			}
		},
		"aoColumnDefs" : [ {
			'bSortable' : false,
			'aTargets' : [ 0 ]
		} ],
		// 回调函数
		"fnDrawCallback" : function(oSettings) {
			$("#query").removeAttr("disabled");
			var fsv = $("#resultList_length select[name='resultList_length']").val();
			if (fsv == "-1" || fsv == -1) {
				$("#resultList_wrapper li").addClass("disabled");
			}
			var $cont = $("#content");
			var $leftd,$rigthd;
			if($cont.length > 0) {
				$leftd = $cont.find("div.portlet-body").eq(0);
				$rigthd = $cont.find("div.portlet-body").eq(1);
				$leftd.height($rigthd.height());
			}
		}
	});
}

function initApproveLog(employeeId) {
	$("#entryRecords").find("tbody.results").html("");
	$("#moveRecords").find("tbody.results").html("");
    $.ajax({
        url: base+'/hrApproveLog/showLog.json?employeeId='+employeeId,
        // 请求url
        type: "POST",
        async: false,
        dataType: "json",
        contentType: "application/json",
        timeout: 30000,
        success: function(data) {
            if (data) {
            	var arr = [];
            	if(data.entryRecords && data.entryRecords.length > 0) {
            		$("#entryRecords").find("tbody.results").html(dealDatas(data.entryRecords));
            		arr.push("entryRecords");
            		$("#entryRecords").show();
            	} else {
            		$("#entryRecords").hide();
            	}
            	if(data.moveRecords && data.moveRecords.length > 0) {
            		$("#moveRecords").find("tbody.results").html(dealDatas(data.moveRecords));
            		arr.push("moveRecords");
            		$("#moveRecords").show();
            	} else {
            		$("#moveRecords").hide();
            	}
            	if(arr.length > 0) {
            		$("#logModel").modal({show:true});
            	} else {
            		$.dopAlertWithNoBtns("暂无审批日志.");
            	}
            } else {
            	$.dopAlert("查询日志出错.");
            }
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
			$.dopAlert("查询日志异常");
		}
    });
}

Date.prototype.Format = function(fmt) 
{ // author: meizz
    var o = { 
            "M+" : this.getMonth()+1,                 //月份 
            "d+" : this.getDate(),                    //日 
            "h+" : this.getHours(),                   //小时 
            "m+" : this.getMinutes(),                 //分 
            "s+" : this.getSeconds(),                 //秒 
            "q+" : Math.floor((this.getMonth()+3)/3), //季度 
            "S"  : this.getMilliseconds()             //毫秒 
    }; 
    if(/(y+)/.test(fmt)) 
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
    for(var k in o) 
        if(new RegExp("("+ k +")").test(fmt)) 
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
    return fmt; 
}

function dealDatas(records) {
	var res = {"1":"通过","2":"回退","3":"拒绝","4":"放弃"};
	var text = "";
	for(var i in records) {
		text += "<tr>" +
					"<td>"+records[i].userName+"</td>" +
					"<td>"+(new Date(records[i].ctime)).Format("yyyy-MM-dd hh:mm:ss")+"</td>" +
					"<td>"+records[i].action+"</td>" +
					"<td>"+records[i].content+"</td>" +
				"</tr>";
	}
	return text;
}




