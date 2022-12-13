var ff = 0;
$("#refuse_tab").hide();
function refuse() {
	if (ff == 1) {
		return false;
	}
}
function refuse(tab, navigation) {
	console.log(navigation+","+tab);
	var msg = $('#approveMsg').val();
	if (!msg) {
		$.dopAlert("审批内容不能为空"	);
		 $('#previous_tab').attr('disabled', true);
		 $('#refuse_tab').attr('disabled', true);
		 $('#submit_tab').attr('disabled', true);
		 $('#refuse_tab').unbind();
		 $("#okDopAlertButton").click(function(){
			 $('#previous_tab').attr('disabled', false);
			 $('#refuse_tab').attr('disabled', false);
			 $('#submit_tab').attr('disabled', false);
			 $('#refuse_tab').click(function(){
				 if (refuse(tab, navigation) == false) {
						return false;
					}
			 });
		 });
		return false;
	}
	submit("2", "拒绝");
	flagSave = false;
	
	return flagSave;
}
var flagSave = true;
function save(tab, navigation, index) {
	if (index == '3') {
		$("#refuse_tab").show();
	}
	if (index == '4') {
		submit("1", "审批");
	}
	return flagSave;
}

$(function() {
	$("#approveMsg").attr("maxlength", 100);
});

$(function(){
	$("#refuse_tab").click(function(tab, navigation){
		console.log("refuse_tab");
		if (refuse(tab, navigation) == false) {
			return false;
		}
	});
});


function submit(formStatu, operation) {
	var employeeEntryVo = {};
	employeeEntryVo.employeeId = $("#detailModal #employeeId").val();
	employeeEntryVo.procInsId = $("#detailModal #procInsId").val();
	employeeEntryVo.taskId = $("#detailModal #taskId").val();
	employeeEntryVo.formStatus = formStatu;
	employeeEntryVo.approveMsg = $("#detailModal #approveMsg").val();
	$.ajax({
		url : base + '/hrApprove/entry_approve.json',
		type : 'POST',
		async : false,
		dataType : 'json',
		contentType : 'application/json',
		data : JSON.stringify(employeeEntryVo),
		timeout : 30000,
		success : function(data) {
			if (data.isSuccess == '1') {
				$('#detailModal').modal('hide');
				TableManaged.fnDraw();
				$.dopAlert(operation + "成功.");
				return;
			}
			$.dopAlert(operation + "失败.");
			return false;
		},
		error : function(data) {
			$.dopAlert(operation + "异常.");
			return false;
		}
	});
};

