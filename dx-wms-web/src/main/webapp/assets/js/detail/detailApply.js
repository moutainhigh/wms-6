
function closePage() {
	TableManaged.fnDraw();
	$('#createCustApplyDiv').modal('hide');
}

$(function(){ 
   showAccountInfo($("#custAccountId").val());
   showApplyInfo($("#custAccountId").val(),$("#lenderApplyId").val());
   showVideoInfo($("#custAccountId").val(),$("#lenderApplyId").val());

   $("#uploadDiv").hide();
});

function showAccountInfo(custAccountId){
	var url =base + "/detail/account.json?custAccountId="+custAccountId;
	$.post(url,{}, function(data,status) {
		$('#account').html(data);
    });
	$("#account input").attr("disabled", "disabled");
	$("#account select").attr("disabled", "disabled");
}

function showApplyInfo(custAccountId,lenderApplyId){
	var url =base + "/detail/apply.json?custAccountId="+custAccountId+"&lenderApplyId="+lenderApplyId;
	$.post(url,{}, function(data) {
		$('#applyDiv').html(data);
	});
	$("#account input").attr("disabled", "disabled");
	$("#account select").attr("disabled", "disabled");
}

function showVideoInfo(custAccountId,lenderApplyId){
	var url =base + "/detail/applyVideoInfo.json?custAccountId="+custAccountId+"&lenderApplyId="+lenderApplyId+"&type=1";
	$.post(url,{}, function(data,status) {
        $('#applyVideoInfo').html(data);
    });
}
