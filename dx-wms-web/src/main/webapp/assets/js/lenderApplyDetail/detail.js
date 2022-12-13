$(function(){ 
   showAccountInfo($("#custAccountId").val());
   showVideoInfo($("#custAccountId").val());
   showApplyInfo($("#custAccountId").val());
});

function showAccountInfo(custAccountId){
	var url =base + '/wealthManagementInfo/applyPersonInfo.json?type=1&custAccountId='+custAccountId+"&lenderCode="+$("#lenderCode").val();
	$.post(url,{}, function(data,status) {
        $('#applyPersonInfo').html(data);
    });
}

function showVideoInfo(custAccountId){
	var url =base + '/wealthManagementInfo/applyVideoInfo.json?custAccountId='+custAccountId+'&lenderApplyId='+$("#lenderApplyId").val()+'&lenderCode='+$("#lenderCode").val();
	$.post(url,{}, function(data,status) {
        $('#applyVideoInfo').html(data);
    });
}

function showApplyInfo(custAccountId){
	var url =base + '/wealthManagementInfo/applyInfo.json?type=1&custAccountId='+custAccountId+'&lenderApplyId='+$("#lenderApplyId").val()+'&lenderCode='+$("#lenderCode").val();
	$.post(url,{}, function(data,status) {
        $('#applyInfo').html(data);
    });
}

function doCloseDiv(){
	TableManaged.fnDraw();
	$('#wealthManagementInfoDiv').modal('hide');
}

