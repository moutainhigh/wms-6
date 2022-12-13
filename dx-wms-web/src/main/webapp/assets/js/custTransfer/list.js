var TableManaged = null;

function queryData() {
	TableManaged =  $('#resultList').dataTable({
		"bDestroy":true,//销毁
     	"bFilter": false,//不显示搜索框
     	"bSort": true, //排序功能
     	"sScrollX": "100%",
     	"sScrollXInner":"100%",
    	"sAjaxSource": 'list_do.json',//请求url
     	"sServerMethod": "POST",
 		"bServerSide": true,  //异步请求
         "fnServerParams": function ( aoData ) {
             aoData.push( 
            		 	 { "name": "lenderCustCode", "value": $("#lenderCustCodeQuery").val()},
            		 	 { "name": "custName", "value": $("#custNameQuery").val()},
            		 	 { "name": "mobile", "value": $("#mobileQuery").val()},
              		     { "name": "idCard", "value": $("#idCardQuery").val()},
              		     { "name": "orgId", "value": $("#orgIdQuery").val()},
              		     { "name": "cluster", "value": $("#clusterQuery").val()},
              		     { "name": "teamId", "value": $("#teamQuery").val()},
              		     { "name": "custManagerId", "value": $("#custManagerIdQuery").val()}
                        );
         },
         "aoColumns" : [
		{
			"mData" : "custId",
			"bSortable" : false,
			"sWidth":"20px",
			"sClass" : "txt-center",
			"mRender" : function(data, type, full) {
				return "<input type='checkbox' name='users' value='"+data+"'>";
			}
		},{
     		"mData" : "lenderCustCode",
     		"bSortable" : false,
     		"sWidth":"70px",
     		"sClass" : "txt-center"
     	},{
     		"mData" : "custName",
     		"bSortable" : false,
     		"sWidth":"140px",
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "idCard",
     		"bSortable" : false,
     		"sWidth":"100px",
     		"sClass" : "txt-center"
     	},{    		
     		"mData" : "orgName",
     		"bSortable" : false,
     		"sWidth":"150px",
     		"sClass" : "txt-center"
     	},{
     		"mData" : "clusterName",
     		"bSortable" : false,
     		"sWidth":"40px",
     		"sClass" : "txt-center"
     	},{
      		"mData" : "teamName",
      		"bSortable" : false,
      		"sWidth":"100px",
      		"sClass" : "txt-center"
     	},{
     		"mData" : "custManagerName",
     		"bSortable" : false,
     		"sWidth":"150px",
     		"sClass" : "txt-center"
     	},{
     		"mData" : "accountStatus",
     		"bSortable" : false,
     		"sWidth":"150px",
     		"sClass" : "txt-center"
     	},
     	{
			"mData" : "lenderCustCode",
			"bSortable" : false,
			"sClass" : "txt-center",
			"sWidth" : "100px",
			"mRender" : function(data,type, full) {
				return "<button type='button' class='btn mini blue one' data="
						+ data + " >转移记录</button>";
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
    		 if(fsv == "-1" || fsv == -1) {
    			$("#resultList_wrapper li").addClass("disabled");
    		 }
    		 // $("#selectAll").attr("checked",false);
    		 $("#selectAll").parent().removeClass("checked");
         }
     });
}

/**
 * 全选或取消全选
 */
function selOrCancelAll(opt) {
	if(opt) {
		$("input[name='users']").each(function(index,item){
			if(!this.checked) {
				$(this).attr("checked",true);
			}
		})
	} else {
		$("input[name='users']").each(function(index,item){
			if(this.checked) {
				$(this).attr("checked",false);
			}
		})
	}
}

$(function(){ 
	$("#query").click(function(){ 
		if($("#orgIdQuery").val()>0 && $("#custManagerIdQuery").val()<0){
			$.dopAlert("请选择客户经理");
		}else {
			if(TableManaged) {
				TableManaged.fnDraw();
			} else {
				queryData();
			}
		}
	}); 
	
	$("#reset").click(function(){ 
		$("#lenderCustCodeQuery").val("");
		$("#custNameQuery").val("");
		$("#mobileQuery").val("");
		$("#idCardQuery").val("");
		$("#orgIdQuery").val("-1");
		initSelectInput("clusterQuery");
		initSelectInput("teamQuery");
		initSelectInput("custManagerIdQuery");
		TableManaged.fnDraw();
	});
	
	$("#transfer").click(function(){
		var trsArr = [];
		$("input[name='users']:checked").each(function(index,item) {
			trsArr[index] = item.value;
        });
        if(!(trsArr.join())) {
        	$.dopAlert("请先选择需要勾选的数据");
       	 	return ;
        }
		$('#transferFrame').modal({
	        show : true
	    });
		initTransferFrame();
	});
	
	$("#selectAll").change(function(){
		selOrCancelAll(this.checked);
	});
	
	$("#orgIdQuery").change(function(){
		initClusters(this.value,"clusterQuery");
		initSelectInput("teamQuery");
		initSelectInput("custManagerIdQuery");
	});
	
	$("#clusterQuery").change(function(){
		initTeams(this.value, $(this).find("option:selected").text(), "teamQuery", "custManagerIdQuery",false);
		initSelectInput("custManagerIdQuery");
	});
	
	$("#teamQuery").change(function(){
		initCustManagers(this.value, "custManagerIdQuery",false);
	});
	
	$("#orgIdFrame").change(function(){
		initClusters(this.value,"clusterFrame");
		initSelectInput("teamFrame");
		initSelectInput("custManagerFrame");
	});
	
	$("#clusterFrame").change(function(){
		initTeams(this.value, $(this).find("option:selected").text(), "teamFrame", "custManagerFrame",true);
		initSelectInput("custManagerFrame");
	});
	
	$("#teamFrame").change(function(){
		initCustManagers(this.value, "custManagerFrame",true);
	});
	
	$(".one").live("click", function() {
		$('#findModal').html('');
		$.ajax({
			url : base + "/custTransfer/log.json?lenderCustCode="+$(this).attr("data"),// 请求url
			type : "POST",
			async: false,
			dataType : "html",
			contentType : "application/json",
			timeout : 10000,
			success : function(data) {
				$('#findModal').modal({
					show : true
				});
				$('#findModal').html(data);	
			}
		});
	});
	
	$("#transferBtnFrame").click(function(){
		
		var trsArr = [];
		$("input[name='users']:checked").each(function(index,item) {
			trsArr[index] = item.value;
        })
        if(trsArr.join()) {
        	// selected
        	if("-1" == $("#orgIdFrame").val()){
        		$.dopAlert("请选择营业部");
        	} else if("-1" == $("#clusterFrame").val()){
        		$.dopAlert("请选择大团");
        	} else if("-1" == $("#teamFrame").val()){
        		$.dopAlert("请选择团队");
        	} else if("-1" == $("#custManagerFrame").val()) {
        		$.dopAlert("请选择客户经理");
        	} else {
        		$.dopConfirm("确认转移?",null,function(r){
        			if(r) {
        				transferStart(trsArr.join());
        				
        			}
        			$("#transferBtnFrame").removeAttr("disabled","disabled");
                	$("#closeBtnFrame").removeAttr("disabled","disabled");
        		})
        	$("#transferBtnFrame").attr("disabled","disabled");
        	$("#closeBtnFrame").attr("disabled","disabled");
        	}
        } else {
        	// not selected
        	$.dopAlert("请先选择需要勾选的数据");
        }

	});
	
	$("#closeBtnFrame").click(function(){
		initCloseFrame();
	});
});

var submitFlag = false;

function transferStart(custIds) {
	// 防重复提交投资审核
	if(submitFlag) {
		return ;
	}
	submitFlag = true;
	$("#transferBtnFrame").attr("disabled","disabled");
	var custTransferQueryVo = {};
	custTransferQueryVo.custIds = custIds;
	custTransferQueryVo.orgId = $("#orgIdFrame").val();
	custTransferQueryVo.cluster = $("#clusterFrame").val();
	custTransferQueryVo.teamId = $("#teamFrame").val();
	custTransferQueryVo.custManagerId = $("#custManagerFrame").val();
	
	$.ajax({
		type : "post",
		url : "transfers.json?",
		data : JSON.stringify(custTransferQueryVo),
		dataType : "json",
		contentType : "application/json",
		async : false,
		success : function(data) {
			if(data) {
				TableManaged.fnDraw();
				$.dopAlertWithNoBtns("客户转移成功");
				initCloseFrame();
			} else {
				$.dopAlert("客户转移失败");
			}
			$("#transferBtnFrame").removeAttr("disabled");
			submitFlag = false;
		},
		error : function(data) {
			$("#transferBtnFrame").removeAttr("disabled");
			submitFlag = false;
		}
	});
}

function initSelect(orgId,selectId) {
	initSelectInput(selectId);
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
					$("#"+selectId).append("<option value='"+datas[o].orgId+"'>"+datas[o].name+"</option>");
				}  
			}
		}
	});
}

function initCustManagers(orgId,custManagerInputId,isTransfer) {
//	initSelectInput("custManagerIdQuery");
	initSelectInput(custManagerInputId);
	if(parseInt(orgId) != -1) {
		var trsArr = [];
		$("input[name='users']:checked").each(function(index,item) {
			trsArr[index] = item.value;
        })
		$.ajax({
			type : "post",
			url : "custManagers.json?orgId="+orgId+"&custIds="+trsArr.join()+"&isTransfer="+isTransfer,
			dataType : "json",
			async : false,
			success : function(datas) {
				if(datas) {
					for(var o in datas){
						$("#"+custManagerInputId).append("<option value='"+datas[o].userId+"'>"+datas[o].name+"("+datas[o].userName+")"+"</option>");
					}  
				}
			}
		});
	}
}

function initClusters(orgId,clusterInputId) {
	if(parseInt(orgId) != -1) {
		initSelect(orgId,clusterInputId);
	} else {
		initSelectInput(clusterInputId);
	}
}

/**
 * js判断字符串是否以参数str为开头
 * 
 * @param str
 */
String.prototype.startWith = function(str) {
	if (str == null || str == "" || this.length == 0
			|| str.length > this.length)
		return false;
	if (this.substr(0, str.length) == str)
		return true;
	else
		return false;
	return true;
}

/**
 * 初始化team列表
 * @param clusterId	
 * @param clusterName
 * @param teamInputId	team下拉表单的id
 * @param custManagerInputId	客户经理下拉表单的id
 * @returns {Boolean}	true -- 客户经理下拉列表需要初始化
 * 						false -- 不需要
 */
function initTeams(clusterId, clusterName, teamInputId,custManagerInputId,isTransfer) {
	initSelectInput(teamInputId);
	if(parseInt(clusterId) != -1) {
		if(clusterName.startWith("Team")) {
			$("#"+teamInputId).append("<option value='"+clusterId+"'>"+clusterName+"</option>");
			if(isTransfer) {
				initCustManagers(clusterId,custManagerInputId,true);
			} else {
				initCustManagers(clusterId,custManagerInputId,false);
			}
			
			return false;
		} else {
			initSelect(clusterId,teamInputId);
		}
	}
	return true;
}

function initTransferFrame() {
	$("#orgIdFrame").val("-1");
	initSelectInput("clusterFrame");
	initSelectInput("teamFrame");
	initSelectInput("custManagerFrame");
}


/**
 * 关闭转移界面
 */
function initCloseFrame() {
	$('#transferFrame').modal("hide");
	initTransferFrame();
}

/**
 * 下拉列表初始化
 * @param selectId
 */
function initSelectInput(selectId) {
	$("#"+selectId).html("<option value='-1'>请选择</option>");
}
