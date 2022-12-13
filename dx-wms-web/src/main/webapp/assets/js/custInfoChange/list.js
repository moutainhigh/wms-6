var TableManaged;
function queryData(){
	TableManaged = $('#resultList').dataTable({
		"bDestroy" : true,// 销毁
		"bFilter" : false,// 不显示搜索框
		"bSort" : true, // 排序功能
		"sScrollX" : "100%",
		"sScrollXInner" : "100%",
		"sAjaxSource" : 'custInfo_do.json',// 请求url
		"sServerMethod" : "POST",
		"bServerSide" : true, // 异步请求
		"fnServerParams" : function(aoData) {
			aoData.push({
				"name" : "custName","value" : $("#custNameQuery").val()
			}, {"name" : "idCard","value" : $("#idCardQuery").val()
			}, {"name" : "mobile","value" : $("#mobileQuery").val()
			}, {"name" : "lenderCustCode","value" : $("#lenderCustCode").val()
			}, {"name" : "accountStatus","value" : $("#status").val()
			});
		},
		"aoColumns" : [
				{
					"mData" : "lenderCustCode",
					"bSortable" : false,
					"sWidth" : "18%",
					"sClass" : "txt-center"
				},
				{
					"mData" : "custName",
					"bSortable" : false,
					"sWidth" : "15%",
					"sClass" : "txt-center"
				},
				{
					"mData" : "idCard",
					"bSortable" : false,
					"sWidth" : "18%",
					"sClass" : "txt-center"
				},
				{
					"mData" : "accountStatus",
					"bSortable" : false,
					"sWidth" : "17%",
					"sClass" : "txt-center"
				},
				{
					"mData" : "custAccountId",
					"bSortable" : false,
					"sWidth" : "25%",
					"sClass" : "txt-center",
					"mRender" : function(data,type, full) {
						return "<button type='button' class='btn mini blue' onclick='infoChange(" + full.custAccountId +")'  >信息变更</button>"
    					+ "&nbsp;<button type='button' class='btn mini blue' onclick='changeRecord(" + full.custAccountId +")'  >变更记录</button>"
					}
				} ],
				"aLengthMenu": [
				       	     [ 20, 40, 60, 80, 100, -1],
				       	     [ 20, 40, 60, 80, 100, "全部"] // change per page values here
				       	  ],
		// set the initial value
		"iDisplayLength" : 20,
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
		}
	});
}

//按Enter查询
document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
	if(event.keyCode ==13){
		TableManaged.fnPageChange(0);
	}
}
$(function(){
	$("#lenderCustCode").attr("maxlength",21);
	$("#idCardQuery").attr("maxlength",18);
	$("#mobileQuery").attr("maxlength",11);
	$("#query").click(function(){
		TableManaged.fnPageChange(0);
	});
	$("#reset").click(function(){
		$("#custNameQuery").val("");
		$("#idCardQuery").val("");
		$("#mobileQuery").val("");
		$("#lenderCustCode").val("");
		$("#status").val("");
	});
});

//信息变更按钮
function infoChange(custAccountId) {
	var url = 'custInfo_change.json?changeId=' + custAccountId;
	$.get(url, function(data) {
		$("#createCustBaseDiv").html(data);
	});
	$("#createCustBaseDiv").modal({
		show : true
	});
};

//变更记录
function changeRecord(custAccountId){
	var url = base+'/infoChange/custInfo_record.json?custAccountId='+custAccountId+'&lenderApplyId=-1';
	$.get(url,function(data){
		$("#changeLogDiv").html(data);
		$("#pkId").val(custAccountId);
	});
	$("#changeLogDiv").modal({
		show:true
	});
}

