var TableManaged;
function queryData(){
	TableManaged = $('#resultList').dataTable({
		"bDestroy" : true,// 销毁
		"bFilter" : false,// 不显示搜索框
		"bSort" : true, // 排序功能
		"sScrollX" : "100%",
		"sScrollXInner" : "170%",
		"sAjaxSource" : 'investInfo_do.json',// 请求url
		"sServerMethod" : "POST",
		"bServerSide" : true, // 异步请求
		"fnServerParams" : function(aoData) {
			aoData.push({"name" : "lenderCode","value" : $("#lenderCode").val()
			}, {"name" : "custName","value" : $("#custNameQuery").val()
			},{"name" : "productId","value" : $("#loanWayQuery").val()
			},{"name" : "lenderAmountArea","value" : $("#loanAmount").val()
			},{"name" : "orgId","value" : $("#salesDepartment").val()
			},{"name" : "currentStep","value" : $("#currentStep").val()
			},{"name" : "signDateBegin","value" : $("#signDateBegin").val()
			}, {"name" : "signDateEnd","value" : $("#signDateEnd").val()
			});
		},
		"aoColumns" : [
				{
					"mData" : "lenderCode",
					"bSortable" : false,
					"sWidth" : "130px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "custName",
					"bSortable" : false,
					"sWidth" : "50px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "idCard",
					"bSortable" : false,
					"sWidth" : "100px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "productIdView",
					"bSortable" : false,
					"sWidth" : "50px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "lenderAmount",
					"bSortable" : false,
					"sWidth" : "60px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "signDate",
					"bSortable" : false,
					"sWidth" : "80px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "salesDepartment",
					"bSortable" : false,
					"sWidth" : "80px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "clusterName",
					"bSortable" : false,
					"sWidth" : "50px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "teamName",
					"bSortable" : false,
					"sWidth" : "50px",
					"sClass" : "txt-center",
				},
				{
					"mData" : "custManager",
					"bSortable" : false,
					"sWidth" : "50px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "currentStep",
					"bSortable" : false,
					"sWidth" : "50px",
					"sClass" : "txt-center",
					"mRender" : function(data, type, full) {
						if (data == "质检拒绝" || data == "投资审核拒绝") {
							return "<span class='label label-important'>"
									+ data + "</span>";
						} else {
							return "<span class='label label-info'>"
									+ data + "</span>";
						}
					}
				},
				{
					"mData" : "settlementDate",
					"bSortable" : false,
					"sWidth" : "80px",
					"sClass" : "txt-center"
				},
				{
					"mData" : "perfectDegree",
					"bSortable" : false,
					"sWidth" : "150px",
					"sClass" : "txt-center",
					"mRender" : function(data,type, full) {
						return "<button type='button' class='btn mini blue' onclick='infoChange("
						+ full.custAccountId
						+ ","
						+ full.lenderApplyId
						+ ")'  >信息变更</button>"
						+ "&nbsp;<button type='button' class='btn mini blue' onclick='infoRecord("
						+ full.lenderApplyId
						+ ")'  >变更记录</button>";
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
			var fsv = $(
					"#resultList_length select[name='resultList_length']")
					.val();
			if (fsv == "-1" || fsv == -1) {
				$("#resultList_wrapper li")
						.addClass("disabled");
			}
		}
	});
}


$(function() {
	$("#custNameQuery").attr("maxlength", 20);
	$("#lenderCode").attr("maxlength", 30);
	$("#query").click(function() {
		TableManaged.fnDraw();
	});
	$("#reset").click(function(){
		$("#custNameQuery").val('');
		$("#lenderCode").val('');
		$("#loanWayQuery").val('');
		$("#loanAmount").val('');
		$("#salesDepartment").val('');
		$("#currentStep").val('');
		$("#signDateBegin").val('');
		$("#signDateEnd").val('');
		TableManaged.fnDraw();
	});
});

//信息变更按钮
function infoChange(custAccountId,lenderApplyId){
	var url = base+"/infoChange/investInfo_change.json?changeId="+lenderApplyId;
	$.get(url,function(data){
		$("#investInfoChangeDiv").html(data);
	});
	$("#investInfoChangeDiv").modal({
		show:true
	});
}
//变更记录按钮
function infoRecord(lenderApplyId){
	var url = base+"/infoChange/investInfo_record.json?custAccountId=-1&lenderApplyId="+lenderApplyId;
	$.get(url,function(data){
		$("#investLogDiv").html(data);
	});
	$("#investLogDiv").modal({
		show:true
	});
}

//日期时间格式验证

//获取带系统当前时间的制定格式数组
function getDateArrays(obj){
	var dateArray=[];
	var sysDate = new Date();
	dateArray.push(new Date(sysDate.getFullYear() + "/"
			+ (sysDate.getMonth() + 1) + "/" + sysDate.getDate()));
	for(var i = 0 ; i < obj.length ; i++){
		dateArray.push(replaceDate(obj[i]))
	}
	return dateArray;
}

function replaceDate(dateStr){
	var dateArr = $(dateStr).val().split("-");
	var curDate = new Date(dateArr[0]+ "/"+ dateArr[1] + "/" + dateArr[2]);
	return curDate;
}
