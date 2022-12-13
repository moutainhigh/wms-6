$("#positionName").change(function(){
	$(".levelId").remove();
	if($("#positionName").val()!=-1){
	var positionId=$("#positionName").val();
	$.ajax({
		type : "post",
		url :  'queryLevel.json?positionId='+positionId,
		dataType : "json",
		async : false,
		success : function(datas) {
			if(datas) {
				for(var o in datas){
					if(datas[o].levelId!=null){
						$("#levelName").show();
						$("#levelName").append("<option class='levelId' value='"+datas[o].levelId+"'>"+datas[o].levelName+"</option>");
					}else{
						$("#levelName").hide();
					}
				}
			}
			}
		});
	
	$(".orgId").remove();
	$.ajax({
		type : "post",
		url : "queryDepart.json?positionId="+positionId,
		dataType : "json",
		async : false,
		success : function(datas) {
			if(datas) {
				for(var o in datas){
					if(datas[o].orgId!=null){
					$("#orgName").append("<option class='orgId' value='"+datas[o].orgId+"'>"+datas[o].orgGroupName+"</option>");
					}
				}
			}
			}
		});
	}
});


$("#submitto").click(function() {
	var positionId=$("#positionName").val();
	var levelId=$("#levelName").val();
	var orgId=$("#orgName").val();
	var employeeId=$("#employeeId").val();
	$.ajax({
		type : "post",
		url : base+"/inService/approveto.json?positionId="+positionId+"&levelId="+levelId+"&orgId="+orgId+"&employeeId="+employeeId,
		dataType : "json",
		async : false,
		success : function(datas) {
			if(datas.isSuccess==1) {
				TableManaged.fnDraw();
				$.dopAlert("异动申请成功");
				$('#peoplechange').modal('hide');
			}else{
				$.dopAlert(datas.msg);
				TableManaged.fnDraw();
				$('#peoplechange').modal('hide');
			}
			}
		});
});
$("#close").on("click", function() {
	$("#peoplechange").modal('hide');
});

$(function() {
	//getrealOrg();
});