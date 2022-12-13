var TableManaged;

$().ready(function() {
    TableManaged = $('#resultList').dataTable({
        "bDestroy": true,
        // 销毁
        "bFilter": false,
        // 不显示搜索框
        "bSort": true,
        // 排序功能
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "sAjaxSource": 'moveApprove.json',
        // 请求url
        "sServerMethod": "POST",
        "bServerSide": true,
        // 异步请求
        "fnServerParams": function(aoData) {
            aoData.push({
            	"name": "positionId",
                "value": $(".positionName").val()
        },
        {
            "name": "jobCategory",
            "value": $(".jobCategory").val()
        },
        {
        	"name": "name",
            "value": $(".employeeName").val()
        },
        {
        	"name": "mobilePhone",
            "value": $(".mobile").val()
        });
        },
        "aoColumns": [{
            "mData": "name",
            "bSortable": false,
            "sClass": "txt-center"
        },
        {
            "mData": "sexView",
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
            	return "<button type='button' class='btn mini blue' onclick='getchange(\""
                +full.positionId+"\",\""
                +data+"\",\""+full.taskId+"\",\""+full.targetOrg+"\",\""+full.targetPosition+"\",\""+full.procInsId+"\")'>审批</button>"
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
        }
    });
});

$(function() {
	$("#query").click(function(){
		console.log("=="+$(".employeeName").val());
		TableManaged.fnDraw();
	});
	/*$(".positionName").change(function(){
		if($(".jobCategory").val()=='-1'){
			$(".positionName").val(-1);
			$.dopAlert("请先选择工作性质.");
		}
	});*/
	$("#reset").click(function() {
		$(".jobCategory").val(-1);
		$(".positionName").val(-1);
		$(".employeeName").val("");
		$(".mobile").val("");
	});
});


function getchange(positionId,employeeId,taskId,targetOrg,targetPosition,procInsId) {
	var url = base+'/hrApprove/moveApprove_start.json?positionId=' +positionId+'&employeeId='+employeeId+'&taskId='+taskId
	+'&targetOrg='+targetOrg+'&targetPosition='+targetPosition+'&procInsId='+procInsId;	
	$.get(url, function(data) {
		$('#peoplechange').html(data);
	});
    $('#peoplechange').modal({
        show: true
    });
}
