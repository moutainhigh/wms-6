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
								"sScrollXInner" : "300%",
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
										"name" : "cluster",
										"value" : $("#clusterIdQuery")
												.val()
									},{
										"name" : "teamId",
										"value" : $("#teamIdQuery")
												.val()
									}
									,{
										"name" : "chooselistvalue",
										"value" : $("#chooselistvalue")
												.val()
									},{
										"name" : "createUser",
										"value" : $("#createUserQuery")
												.val()
									},{
										"name" : "orgVoIdQuery",
										"value" : $("#orgVoIdQuery")
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
											"sWidth" : "3%",
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
											"mData" : "settlementDate",
											"bSortable" : false,
											"sWidth" : "4%",
											"sClass" : "settlementDate"
										},
										
										
										{
											"mData" : "payWayName",
											"bSortable" : false,
											"sWidth" : "4%",
											"sClass" : "payWayName"
										},
										
										{
											"mData" : "clusterName",
											"bSortable" : false,
											"sWidth" : "3%",
											"sClass" : "clusterName"
										},
										{
											"mData" : "teamName",
											"bSortable" : false,
											"sWidth" : "3%",
											"sClass" : "teamName"
										},
										{
											"mData" : "teamUserName",
											"bSortable" : false,
											"sWidth" : "2%",
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
										}],
								"aLengthMenu" : [ [ 25, 50, -1 ],
										[ 25, 50, "全部" ] // change
															// per page
															// values
															// here
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
	allLenderAmount();
	hidelist();
	$("#query").live("click",function(){ 
		allLenderAmount();
		TableManaged.fnDraw();
		
	});
	$("#export").live("click",function(){
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
		+"&cluster="+$("#clusterIdQuery").val()
		+"&teamId="+$("#teamIdQuery").val()
		+"&custName="+$("#custNameQuery").val()
		+"&createUser="+$("#createUserQuery").val()
		+"&orgVoIdQuery="+$("#orgVoIdQuery").val()
		+"&chooselistvalue="+choosevalue;
		
		self.setInterval("waitforexport()",15000);
	});
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
$("#teamIdQuery").change(function(){
	$(".userId").remove();
	if($("#teamIdQuery").val()!=-1){
		
	var orgId=$("#teamIdQuery").val();
	$.ajax({
		type : "post",
		url : "custManagers.json?orgId="+orgId,
		dataType : "json",
		async : false,
		success : function(datas) {
			if(datas) {
				for(var o in datas){
					if("综合部" == datas[o].name) {
						continue;
					}
					$("#createUserQuery").append("<option class='userId' value='"+datas[o].userId+"'>"+datas[o].name+"</option>");
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
$("#clusterIdQuery").val("-1");
$("#teamIdQuery").val("-1");
$("#statementDateQuery").val("-1");
$("#createUserQuery").val("-1");
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

$("#listset").click(function() {
	$("#beforechoose").html("<option value='signDate'>签单日期</option>" +
			                  "<option value='lenderCode'>出借编号</option>" +
			                  "<option value='custName'>客户姓名</option>" +
			                  "<option value='sex'>性别</option>" +
			                  "<option value='productName'>出借方式</option>" +
			                  "<option value='lenderAmount'>出借金额</option>" +
			                  "<option value='custCategory'>客户分类</option>" +
			                  "<option value='expectLenderDate'>预计出借日期</option>" +
			                  "<option value='settlementDate'>生效日期</option>" +
			                  "<option value='payWayName'>支付方式</option>" +
			                  "<option value='clusterName'>大团</option>" +
			                  "<option value='teamName'>团队</option>" +
			                  "<option value='teamUserName'>团队经理</option>" +
			                  "<option value='createUser'>客户经理</option>" +
			                  "<option value='msgWay'>接受文件方式</option>" );
	$("#choosed").html("");
	$('#listupdate').modal({
		show : true
	});
	
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
		   $("."+$(this).val()).hide();
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
		   $("."+$(this).val()).show();
		  });
	$('#listupdate').modal('hide');
});
$("#closechoose").click(function() {
	$('#listupdate').modal('hide');
})
function allLenderAmount(){
	var reportManagementQueryVo={};
	reportManagementQueryVo.productId=$("#loanWayQuery").val();
	reportManagementQueryVo.lenderAmountArea=$("#lenderAmountQuery").val();
	reportManagementQueryVo.settlementDateBeg=$("#settlementDateBegQuery").val();
	reportManagementQueryVo.settlementDateEnd=$("#settlementDateEndQuery").val();
	reportManagementQueryVo.orgVoIdQuery=$("#orgVoIdQuery").val();
	reportManagementQueryVo.cluster=$("#clusterIdQuery").val();
	reportManagementQueryVo.teamId=$("#teamIdQuery").val();
	reportManagementQueryVo.createUser=$("#createUserQuery").val();
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

$('#sample_2_column_toggler input[type="checkbox"]').change(function(){
    /* Get the DataTables object again - this is not a recreation, just a get of the object */
    var iCol = parseInt($(this).attr("data-column"));
    var bVis = TableManaged.fnSettings().aoColumns[iCol].bVisible;
    TableManaged.fnSetColumnVis(iCol, (bVis ? false : true));
});

