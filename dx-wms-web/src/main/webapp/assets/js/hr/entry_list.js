var TableManaged;

$().ready(function() {
	TableManaged = $('#resultList').dataTable({
		"bDestroy" : true,// 销毁
		"bFilter" : false,// 不显示搜索框
		"bSort" : true, // 排序功能
		"sScrollX" : "100%",
		"sScrollXInner" : "100%",
		"sAjaxSource" : 'entry.json',// 请求url
		"sServerMethod" : "POST",
		"bServerSide" : true, // 异步请求
		"fnServerParams" : function(aoData) {
			aoData.push(
				{"name" : "positionId","value" : $(".positionName").val()}, 
				{"name" : "name","value" : $(".employeeName").val()}, 
				{"name" : "mobilePhone","value" : $(".mobile").val()},
				{"name" : "formStatus","value" : $(".employeeStatus").val()},
				{"name" : "jobCategory","value" : $(".jobCategory").val()}
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
			"mData" : "jobCategoryView",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "mobilePhone",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "plannedEntryDate",
			"bSortable" : false,
			"sClass" : "txt-center",
			
		},
		{
			"mData" : "dataStatus",
			"bSortable" : false,
			"sClass" : "txt-center"
		},
		{
			"mData" : "dataStatus",
			"bSortable" : false,
			"sClass" : "txt-center",
			"mRender" : function(data,type,full) {
				if(full.dataStatus=='预入职'){
					return "<button type='button' class='btn mini red'  onclick='entryDetail("+full.employeeId+","+full.taskId+","+full.procInsId+",this)'>入职</button>";
				}else{
					return "<button type='button' class='btn mini red mW1'  onclick='entryDetail("+full.employeeId+","+full.taskId+","+full.procInsId+",this)'>重新提交</button>";
				}
				
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
		}
	});
});
$(function() {
	//当是营业部经理助理的时候，有下载模板和导入按钮
	if(!$(".isShow").val()){
		$("#load").hide();
		$("#import").hide();
	}
	$(".employeeName").attr("maxlength", 6);
	$(".mobile").attr("maxlength", 11);
	$("#query").click(function() {
		/*var position = $(".positionName").val();
		var jobCate = $(".jobCategory").val();
		if(position!='-1'&&jobCate=='-1'){
			$.dopAlert("请选择工作性质");
			return;
		}*/
		TableManaged.fnDraw();
	});

	$("#reset").click(function() {
		$(".employeeName").val("");
		$(".positionName").val("-1");
		$(".mobile").val("");
		$(".jobCategory").val("-1");
	});
	
	//创建按钮
	$("#create").click(function(){
		var url = base+"/hrEntry/create.json";
		$.get(url,function(data){
			$("#createBaseDiv").html(data);
		});
		$("#createBaseDiv").modal({
			show:true
		});
	});
	$("#import").click(function(){
		$("#importData").modal({
			show:true
		});
	});
	$("#load").click(function(){
		$('#loadModel').addClass("in");
		$("#loadModel").show();
	});
	
	$("#importBtn").click(function(){
		importData();
	});
	$("#loadModel .close-modal").click(function(){
		$("#loadModel").hide();
	});
});

function importData() {
	var types = ["xls","xlsx"];
	var filename = $.trim($("#importData").find("input.file").val());
	if(filename) {
		$("#fileImportForm").ajaxForm({
			type : "post",
			timeout : 360000, // 六分钟超时
			url : base + "/dataDeal/importHRData.json",
			enctype : 'multipart/form-data',
			resetForm : false,
			async : false,
			success : function(data) {
				if (data.code) {
					$('#importData').modal('hide');
					TableManaged.fnDraw();
					$.dopAlert("导入[" + filename + "]成功!");
				} else {
					$.dopAlert("导入[" + filename + "]失败!");
					$('#importData').modal('hide');
				}
			},
			error : function() {
				$.dopAlert('上传文件异常!');
			}
		});
	}
}

$("#loadModel #confirm").on("click",function(){
	var positionName = $('#loadModel .position').find("option:selected").text();
	var position = $('#loadModel .position').val();
	if(position=='-1'){
		return false;
	}
	console.log("=="+positionName);
	var url = base+ "/hrEntry/excelExoprt.json?"+$.param({position:position,name:positionName});
	  $.dopAlert("正在下载，请不要刷新页面，耐心等候");
	  window.location.href = url;
	  $('#loadModel').hide();
	  $("#loadModel").attr("aria-hidden","true");
	  $('#loadModel').removeClass("in");
	  $('.modal-backdrop').remove();
});
//入职按钮
function entryDetail(employeeId,taskId,procInsId,status){
	var url = base+"/hrEntry/entryDetail.json?employeeId="+employeeId+"&taskId="+taskId+"&procInsId="+procInsId;
	$.get(url,function(data){
		$("#createEntryDiv").html(data);
		$("#status").val($(status).text());
		$("#plandate").val($(status).parent().prevAll().eq(1).text());
	});
	$("#createEntryDiv").modal({show:true});
}
