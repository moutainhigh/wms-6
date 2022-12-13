var TableManaged;
var fieldVisiable={};
$()
.ready(
		function() {
			TableManaged = $('#resultList')
					.dataTable(
							{
								"bDestroy" : false,// 销毁
								"bFilter" : false,// 不显示搜索框
								"bSort" : true, // 排序功能
								"sScrollX" : "100%",
								"sScrollXInner" : "500%",
								"sAjaxSource" : 'list_do.json',// 请求url
								"sServerMethod" : "POST",
								"bServerSide" : true, // 异步请求
								"fnServerParams" : function(aoData) {
									
									aoData.push({
										"name" : "productId",
										"value" : $("#loanWayQuery")
												.val()
									},{
										"name" : "lenderAmountArea",
										"value" : $("#lenderAmountQuery")
												.val()
									},{
										"name" : "settlementDateBeg",
										"value" : $("#settlementDateBegQuery")
												.val()
									},{
										"name" : "settlementDateEnd",
										"value" : $("#settlementDateEndQuery")
												.val()
									},{
										"name" : "areaOrgIds",
										"value" : $("#areaOrgIdsQuery")
												.val()
									},{
										"name" : "branchOfficeIds",
										"value" : $("#branchOfficeQuery")
												.val()
									},{
										"name" : "orgId",
										"value" : $("#orgIdQuery")
												.val()
									},{
										"name" : "cluster",
										"value" : $("#clusterIdQuery")
												.val()
									},{
										"name" : "teamId",
										"value" : $("#teamIdQuery")
												.val()
									},{
										"name" : "statementDate",
										"value" : $("#statementDateQuery")
												.val()
									}
									,{
										"name" : "chooselistvalue",
										"value" : $("#chooselistvalue")
												.val()
									});
								},
								"aoColumns" : [{
											"mData" : "signDate",
											"bSortable" : false,
											"sWidth" : "4%",
											"sClass" : "signDate"
										},
										{
											"mData" : "lenderCode",
											"bSortable" : false,
											"sWidth" : "1%",
											"sClass" : "lenderCode"
										},
										{
											"mData" : "custName",
											"bSortable" : false,
											"sWidth" : "3%",
											"sClass" : "custName"
										},
										{
											"mData" : "sex",
											"bSortable" : false,
											"sWidth" : "1%",
											"sClass" : "sex",
											"mRender" : function(data,
													type, full) {
												if(data==1){
													return "男"
												}else if(data==2){
													return "女"
												}else{
													return "";
												}
											}
										},
										{
											"mData" : "idCard",
											"sWidth" : "5%",
											"bSortable" : false,
											"sClass" : "idCard"
										},
										{
											"mData" : "productName",
											"sWidth" : "3%",
											"bSortable" : false,
											"sClass" : "productName"
										},
										{
											"mData" : "lenderAmount",
											"bSortable" : false,
											"sWidth" : "3%",
											"sClass" : "lenderAmount"
										},
										{
											"mData" : "settlementDate",
											"bSortable" : false,
											"sWidth" : "4%",
											"sClass" : "settlementDate"
										},
										{
											"mData" : "statementDate",
											"bSortable" : false,
											"sWidth" : "3%",
											"sClass" : "statementDate"
										},
										{
											"mData" : "matchDate",
											"bSortable" : false,
											"sWidth" : "3%",
											"sClass" : "matchDate"
										},
										{
											"mData" : "custCategory",
											"bSortable" : false,
											"sWidth" : "3%",
											"sClass" : "custCategory"
										},
										{
											"mData" : "expectLenderDate",
											"bSortable" : false,
											"sWidth" : "5%",
											"sClass" : "expectLenderDate"
										},
										{
											"mData" : "payWayName",
											"bSortable" : false,
											"sWidth" : "4%",
											"sClass" : "payWayName"
										},
										{
											"mData" : "giveBankCategory",
											"bSortable" : false,
											"sWidth" : "3%",
											"sClass" : "giveBankCategory"
										},
										{
											"mData" : "giveAccountNum",
											"bSortable" : false,
											"sWidth" : "5%",
											"sClass" : "giveAccountNum"
										},
										{
											"mData" : "getBankCategory",
											"bSortable" : false,
											"sWidth" : "3%",
											"sClass" : "getBankCategory"
										},
										{
											"mData" : "giveAccountNum",
											"bSortable" : false,
											"sWidth" : "5%",
											"sClass" : "giveAccountNum"
										},
										{
											"mData" : "accountName",
											"bSortable" : false,
											"sWidth" : "5%",
											"sClass" : "accountName"
										},
										{
											"mData" : "address",
											"bSortable" : false,
											"sWidth" : "7%",
											"sClass" : "address"
										},
										{
											"mData" : "zipCode",
											"bSortable" : false,
											"sWidth" : "4%",
											"sClass" : "zipCode"
										},
										{
											"mData" : "areaName",
											"bSortable" : false,
											"sWidth" : "4%",
											"sClass" : "areaName"
										},
										{
											"mData" : "branchOfficeName",
											"bSortable" : false,
											"sWidth" : "4%",
											"sClass" : "branchOfficeName"
										},
										{
											"mData" : "orgName",
											"bSortable" : false,
											"sWidth" : "4%",
											"sClass" : "orgName"
										},
										{
											"mData" : "clusterName",
											"bSortable" : false,
											"sWidth" : "2%",
											"sClass" : "clusterName"
										},
										{
											"mData" : "teamName",
											"bSortable" : false,
											"sWidth" : "2%",
											"sClass" : "teamName"
										},
										{
											"mData" : "teamUserName",
											"bSortable" : false,
											"sWidth" : "3%",
											"sClass" : "teamUserName"
										},
										{
											"mData" : "createUser",
											"bSortable" : false,
											"sWidth" : "2%",
											"sClass" : "createUser"
										},
										{
											"mData" : "msgWay",
											"bSortable" : false,
											"sWidth" : "4%",
											"sClass" : "msgWay"
										},
										{
											"mData" : "email",
											"bSortable" : false,
											"sWidth" : "2%",
											"sClass" : "email"
										}],
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
			
			
		});

$(function(){
	hidelist();
	$("#query").live("click",function(){ 
		allLenderAmount();
		TableManaged.fnDraw();
		
	});
	allLenderAmount();
});

$("#export").click(function() {
	$('#waitexper').modal({
		show : true
	});
	var choosevalue="";
    $("#sample_2_column_toggler input[type='checkbox']").each(function(){
    	if($(this).is(':checked')){
    	choosevalue+=$(this).val()+",";
    	}
      });
	window.location.href = 'export.json?productId='+$("#loanWayQuery").val()
	+"&lenderAmountArea="+$("#lenderAmountQuery").val()
	+"&settlementDateBeg="+$("#settlementDateBegQuery").val()
	+"&settlementDateEnd="+$("#settlementDateEndQuery").val()
	+"&areaOrgIds="+$("#areaOrgIdsQuery").val()
	+"&branchOfficeIds="+$("#branchOfficeQuery").val()
	+"&orgId="+$("#orgIdQuery").val()
	+"&cluster="+$("#clusterIdQuery").val()
	+"&teamId="+$("#teamIdQuery").val()
	+"&statementDate="+$("#statementDateQuery").val()
	+"&chooselistvalue="+choosevalue;
	self.setInterval("waitforexport()",15000);
});
function waitforexport(){
	$('#waitexper').modal('hide');
}
function hidelist(){
	$("#sample_2_column_toggler").html("");
	var choosevalue="";
	$("#tableName").children("tr").children("th").each(function(index, domEle){
		$("#sample_2_column_toggler").append("<label><input type='checkbox' checked data-column='"+index+"' value='"+$(this).text()+"' onclick='checktableName("+index+");'>"+$(this).text()+"</label>")
	});
	
}
$("#orgIdQuery").change(function(){
	$(".clusterId").remove();
	$(".teamId").remove();
	if($("#orgIdQuery").val()!=-1){
		
		
	var orgId=$("#orgIdQuery").val();
	$.ajax({
		type : "post",
		url : "orgs.json?orgId="+orgId,
		dataType : "json",
		async : false,
		success : function(datas) {
			if(datas) {
				for(var o in datas){
					if("综合部" == datas[o].name) {
						continue;
					}
					$("#clusterIdQuery").append("<option class='clusterId' value='"+datas[o].orgId+"'>"+datas[o].name+"</option>");
				}  
			}
		}
	});
	}
});
$("#clusterIdQuery").change(function(){
	$(".teamId").remove();
	if($("#clusterIdQuery").val()!=-1){
		
	var orgId=$("#clusterIdQuery").val();
	$.ajax({
		type : "post",
		url : "orgs.json?orgId="+orgId,
		dataType : "json",
		async : false,
		success : function(datas) {
			if(datas) {
				for(var o in datas){
					if("综合部" == datas[o].name) {
						continue;
					}
					$("#teamIdQuery").append("<option class='teamId' value='"+datas[o].orgId+"'>"+datas[o].name+"</option>");
				}  
			}
		}
	});
	}
});

$("#areaOrgIdsQuery").change(function(){
	$(".branchOffice").remove();
	$(".org").remove();
	$(".clusterId").remove();
	$(".teamId").remove();
	if($("#areaOrgIdsQuery").val()!=-1){
		
	var orgId=$("#areaOrgIdsQuery").val();
	$.ajax({
		type : "post",
		url : "branchOfficeByorgs.json?orgId="+orgId,
		dataType : "json",
		async : false,
		success : function(datas) {
			if(datas) {
				for(var o in datas){
					if("综合部" == datas[o].name) {
						continue;
					}
					$("#branchOfficeQuery").append("<option class='branchOffice' value='"+datas[o].orgId+"'>"+datas[o].name+"</option>");
				}  
			}
		}
	});
	}
});

$("#branchOfficeQuery").change(function(){
	$(".org").remove();
	$(".clusterId").remove();
	$(".teamId").remove();
	if($("#branchOfficeQuery").val()!=-1){
		
		var orgId=$("#branchOfficeQuery").val();
		$.ajax({
			type : "post",
			url : "branchOfficeInOrgs.json?orgId="+orgId,
			dataType : "json",
			async : false,
			success : function(datas) {
				if(datas) {
					for(var o in datas){
						if("综合部" == datas[o].name) {
							continue;
						}
						$("#orgIdQuery").append("<option class='org' value='"+datas[o].orgId+"'>"+datas[o].name+"</option>");
					}  
				}
			}
		});
		}
	});

$("#reset").click(function() {
$("#loanWayQuery").val("-1");
$("#lenderAmountQuery").val("-1");
$("#settlementDateBegQuery").val("");
$("#settlementDateEndQuery").val("");
$("#areaOrgIdsQuery").val("-1");
$("#branchOfficeQuery").val("-1");
$("#orgIdQuery").val("-1");
$("#clusterIdQuery").val("-1");
$("#teamIdQuery").val("-1");
$("#statementDateQuery").val("-1");
});
$("#settlementDateBegQuery").change(function(){
	if(null != this.value && $.trim(this.value) != ""){
		var begDate = new Date($("#settlementDateBegQuery").val()); 
		if($("#settlementDateEndQuery").val()!=null && $.trim($("#settlementDateEndQuery").val()) != ""){
			var endDate = new Date($("#settlementDateEndQuery").val());
			if(begDate>endDate){
				$("#settlementDateBegQuery").val("");
			}
		}
	}
});

$("#settlementDateEndQuery").change(function(){
	if(null != this.value && $.trim(this.value) != ""){
		var endDate = new Date($("#settlementDateEndQuery").val()); 
		if($("#settlementDateBegQuery").val()!=null && $.trim($("#settlementDateBegQuery").val()) != ""){
			var begDate = new Date($("#settlementDateBegQuery").val());
			if(begDate>endDate){
				$("#settlementDateEndQuery").val("");
			}
		}
	}
});

$("#beforechoose").click(function() {
	 var choosevalue = $('#beforechoose option:selected').val();
	 var choosetext = $('#beforechoose option:selected').text();
	 $("#beforechoose option[value='"+choosevalue+"']").remove();
	 $("#choosed").append("<option value="+choosevalue+">"+choosetext+"</option>");
});

$("#choosed").click(function() {
	 var choosevalue = $('#choosed option:selected').val();
	 var choosetext = $('#choosed option:selected').text();
	 $("#choosed option[value='"+choosevalue+"']").remove();
	 $("#beforechoose").append("<option value="+choosevalue+">"+choosetext+"</option>");
});
$("#updatelist").click(function() {
	$("#choosed option").each(function(){
		var cho = $("#chooselistvalue").val();
		var thecho = $(this).val()+",";
		   if(cho.indexOf(thecho)<0){
		    cho+=thecho;
		   $("#chooselistvalue").val(cho);
		   }
		   //$("."+$(this).val()).hide();
		   var iCol = parseInt($(this).val());
           var bVis = TableManaged.fnSettings().aoColumns[iCol].bVisible;
           TableManaged.fnSetColumnVis(iCol, (bVis ? false : true));
		  });
	var thstext = "";
	$("#beforechoose option").each(function(){
		var cho = $("#chooselistvalue").val();
		var thecho = $(this).val()+",";
		   if(cho.indexOf(thecho)>0){
		    cho=cho.replace(thecho,"");
		   $("#chooselistvalue").val(cho);
		   
		   }
		   
		   thstext+=$(this).text()+",";
		   $("#showlistvalue").val(thstext);
		  // $("."+$(this).val()).show();
		  });
	$('#listupdate').modal('hide');
});
$("#closechoose").click(function() {
	$('#listupdate').modal('hide');
});
function allLenderAmount(){
	var reportManagementQueryVo={};
	reportManagementQueryVo.productId=$("#loanWayQuery").val();
	reportManagementQueryVo.lenderAmountArea=$("#lenderAmountQuery").val();
	reportManagementQueryVo.settlementDateBeg=$("#settlementDateBegQuery").val();
	reportManagementQueryVo.settlementDateEnd=$("#settlementDateEndQuery").val();
	reportManagementQueryVo.areaOrgIds=$("#areaOrgIdsQuery").val();
	reportManagementQueryVo.branchOfficeIds=$("#branchOfficeQuery").val();
	reportManagementQueryVo.orgId=$("#orgIdQuery").val();
	reportManagementQueryVo.cluster=$("#clusterIdQuery").val();
	reportManagementQueryVo.teamId=$("#teamIdQuery").val();
	reportManagementQueryVo.statementDate=$("#statementDateQuery").val();
	$.ajax({
		url : base + '/reportManagement/allLenderAmount.json',// 请求url
		type : "POST",
		async : true,
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(reportManagementQueryVo),
		success : function(data) {
			if (data) {
				if(data.investment!=null){
					$("#investment").html("总投资:"+data.investment);
					$("#allLenderAmount").html("出借总额："+data.allLenderAmount);
				}else{
					$("#investment").html("总投资:");
					$("#allLenderAmount").html("出借总额：");
				}
			}else{
				$("#investment").html("总投资:");
				$("#allLenderAmount").html("出借总额：");
			}
		},
		
	});
}
function checktableName(tableindex){
    /* Get the DataTables object again - this is not a recreation, just a get of the object */
    var iCol = parseInt(tableindex);
    var bVis = TableManaged.fnSettings().aoColumns[iCol].bVisible;
    TableManaged.fnSetColumnVis(iCol, (bVis ? false : true));
    
};


