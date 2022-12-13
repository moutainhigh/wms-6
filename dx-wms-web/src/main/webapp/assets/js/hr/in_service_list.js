
var TableManaged;

function query() {
    TableManaged = $('#resultList').dataTable({
        "bDestroy": true,
        // 销毁
        "bFilter": false,
        // 不显示搜索框
        "bSort": true,
        // 排序功能
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "sAjaxSource": 'inService.json',
        // 请求url
        "sServerMethod": "POST",
        "bServerSide": true,
        // 异步请求
        "fnServerParams": function(aoData) {
            aoData.push(
            		{"name" : "positionId","value" : $(".positionName").val()}, 
    				{"name" : "name","value" : $(".employeeName").val()}, 
    				{"name" : "mobilePhone","value" : $(".mobile").val()}, 
    				{"name" : "orgId","value" : $("#orgId").val()},
    				{"name" : "jobCategory","value" : $(".jobCategory").val()},
    				{"name": "employeeNo","value": $(".employeeNo").val()}
            );
        },
        "aoColumns": [{
            "mData": "name",
            "bSortable": false,
            "sClass": "txt-center"
        },
        {
            "mData": "employeeNo",
            "bSortable": false,
            "sClass": "txt-center"
        },
        {
            "mData": "departmentView",
            "bSortable": false,
            "sClass": "txt-center"
        },
        {
            "mData": "positionView",
            "bSortable": false,
            "sClass": "txt-center"
        },
        {
            "mData": "jobCategoryView",
            "bSortable": false,
            "sClass": "txt-center"
        },
        {
            "mData": "mobilePhone",
            "bSortable": false,
            "sClass": "txt-center"
        },
        {
            "mData": "entryDate",
            "bSortable": false,
            "sClass": "txt-center"
        },
        {
            "mData": "employeeId",
            "bSortable": false,
            "sClass": "txt-center",
            "mRender": function(data, type, full) {
            	if(full.isTransaction==2){
                return "<button type='button' class='btn mini blue' onclick='getchange(\""
                +full.positionId+"\",\""
                +data+"\")'>异动</button>"
            	}else{
            		return "";
            	}
            }
        }],
        "aLengthMenu": [[15, 20, -1], [15, 20, "全部"] // change
        // per page
        // values
        // here
        ],
        // set the initial value
        "iDisplayLength": 15,
        "sPaginationType": "bootstrap",
        "oLanguage": {
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sZeroRecords": "抱歉， 没有找到",
            "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
            "sInfoEmpty": "显示 0 至 0 共 0 项",
            "oPaginate": {
                "sPrevious": "上一页",
                "sNext": "下一页"
            }
        },
        "aoColumnDefs": [{
            'bSortable': false,
            'aTargets': [0]
        }],
        // 回调函数
        "fnDrawCallback": function(oSettings) {
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

$(function() {
	$("#jobCategory").val(-1);
	$("#positionId").val(-1);
	$("#name").val("");
	$("#mobile").val("");
	$("#employeeNo").val("");
	initInservice();
    $("#query").live("click",
    function() {
        TableManaged.fnDraw();
    });
});

$("#reset").click(function() {
	$(".employeeName").val("");
	$(".positionName").val("-1");
	$(".mobile").val("");
	$(".employeeNo").val("");
	$(".jobCategory").val("-1");
	$("#orgId").val("");
});

function getchange(positionId,employeeId) {
	var url = base+'/inService/inService_start.json?positionId=' +positionId+'&employeeId='+employeeId;	
	$.get(url, function(data) {
		$('#peoplechange').html(data);
	});
    $('#peoplechange').modal({
        show: true
    });
}

function initInservice(){
	if($("#isRSZG").val()){
		$("#RSZG").show();
	}else{
		$("#RSZG").hide();
	}
	$("#name").attr("maxlength", 6);
	$("#mobilePhone").attr("maxlength", 10);
	$("#employeeNo").attr("maxlength", 8);
}
