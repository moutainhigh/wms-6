function approveto(formStatus){
	var employeeEntryVo = {};
	employeeEntryVo.employeeId=$("#employeeId").val();
	employeeEntryVo.taskId=$("#taskId").val();
	employeeEntryVo.procInsId=$("#procInsId").val();
	employeeEntryVo.formStatus=formStatus;
	employeeEntryVo.approveMsg=$("#approveMsg").val();
	var formStatusmsg = "确定通过审批？";
	if(formStatus==2){
		formStatusmsg = "该申请将回退至发起人，确认拒绝？";
	}
	$.dopConfirm(formStatusmsg, null, function(r) {
		if (r) {
			$.ajax({
				url : base + '/hrApprove/move_approve.json',// 请求url
				type : "POST",
				async : true,
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(employeeEntryVo),
				timeout : 30000,
				success : function(data) {
					if (data) {
						if(data.isSuccess==1){
							if (formStatus==1) {
								$.dopAlert("异动成功");
								TableManaged.fnDraw();
								$('#peoplechange').modal('hide');
							}else{
								$.dopAlert("拒绝成功");
								TableManaged.fnDraw();
								$('#peoplechange').modal('hide');
							}
						}else{
						$.dopAlert("失败");	
						}
					}
					
				},
				error : function(data) {
					$.dopAlert("异动异常");
				}
			});
		}
	});
}

$("#close").on("click", function() {
	$("#peoplechange").modal('hide');
});
$(function() {
	//getrealOrg();
});