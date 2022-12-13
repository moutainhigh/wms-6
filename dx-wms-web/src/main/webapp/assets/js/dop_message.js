
// alert编写
jQuery.dopAlert = function(message, imageUrl, fu) {
	var page_content = $(document.body);// $("div[class = 'page-content']");
	var alertMessage = '确定要关闭吗？ ';
	var imageTag = '';
	if (message) {
		alertMessage = message;
	}
	if (imageUrl) {
		imageTag = "<img src='" + imageUrl + "' />";
	}
	var content = '<div id="dop_alert_Modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true" style="width:300px;position:absolute;left:900px;top:200px;">'
				+ '<div class="modal-header">'
				+ '<h4 class="modal-title" style="text-align:left;">提示</h4>'
				+ '</div>'
				+ '<div class="modal-body"> '
				+ imageTag
				+ alertMessage
				+ '</div>'
				+ '<div class="modal-footer">'
				+ '<button class="btn blue" type="button" id="okDopAlertButton">确定</button>'
				+ '</div>'
				+ '</div>';
	// 添加alert弹出框
	var dop_alert_Modal = [];
	function addAlert() {
		$('#dop_alert_Modal').modal('hide');
		if($('#dop_alert_Modal')){
			$('#dop_alert_Modal').remove();
		}
		page_content.append(content);
		var dop_alert_Modal_Interval = window.setInterval(function() {
			dop_alert_Modal = $('#dop_alert_Modal');
			if (dop_alert_Modal.length > 0) {
				dop_alert_Modal.modal({
					backdrop : 'static',
					keyboard : false
				});
				dop_alert_Modal.on('hidden.bs.modal', function(e) {
					dop_alert_Modal.remove();
				});
				dop_alert_Modal.show();
				
				$("#okDopAlertButton").bind("click", function() {
					callBack();
				});
				clearInterval(dop_alert_Modal_Interval);
			}
		}, 50);
	}

	addAlert();
	
	function callBack(){
		if(fu){
			fu();
		}
		$.dopAlert.destoryAlert();
	}
};
// 销毁alert弹出框
jQuery.dopAlert.destoryAlert = function() {
	$('#dop_alert_Modal').modal('hide');
};

// confirm编写
jQuery.dopConfirm = function(message, imageUrl, fn) {
	var page_content = $(document.body);// $("div[class = 'page-content']");
	var alertMessage = '确定要操作吗？ ';
	var r;
	var imageTag = '';
	if (message) {
		alertMessage = message;
	}
	if (imageUrl) {
		imageTag = "<img src='" + imageUrl + "' />";
	}			   
	var content = '<div id="dop_confirm_Modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true" style="width:300px;position:absolute;left:900px;top:200px;">'
			+ '<div class="modal-header"><h4 class="modal-title" style="text-align:left;">提示</h4></div><div class="modal-body">'
			+ imageTag
			+ alertMessage
			+ '</div><div class="modal-footer"><button class="btn blue" id="okDopConfirmButton" type="button">确定</button><button class="btn red" type="button" id="destoryDopConfirmButton">取消</button></div></div></div></div>';
	// 添加confirm弹出框
	var dop_Confirm_Modal = [];
	function addConfirm() {
		$('#dop_confirm_Modal').next(".modal-backdrop").remove();
		$('#dop_confirm_Modal').remove();
		
		page_content.append(content);
		var dop_confirm_Modal_Interval = window.setInterval(function() {
			dop_Confirm_Modal = $('#dop_confirm_Modal');
			if (dop_Confirm_Modal.length > 0) {
				dop_Confirm_Modal.modal({
					backdrop : 'static',
					keyboard : false
				});
				dop_Confirm_Modal.on('hidden.bs.modal', function(e) {
					dop_Confirm_Modal.remove();
				});
				dop_Confirm_Modal.show();
				$("#destoryDopConfirmButton").bind("click", function() {
					callBack(false);
				});
				$("#okDopConfirmButton").bind("click", function() {
					callBack(true);
				});
				clearInterval(dop_confirm_Modal_Interval);
			}
		}, 50);
	}
	// 处理回调
	function callBack(r) {
		$.dopConfirm.destoryConfirm();
		fn(r);
	}

	addConfirm();
};
// 销毁confirm弹出框
jQuery.dopConfirm.destoryConfirm = function() {
	//$('#dop_confirm_Modal').click();
	
	$('#dop_confirm_Modal').hide();
	$('#dop_confirm_Modal').modal('hide');
};

// errAlert编写
jQuery.dopErr = function(message, imageUrl) {
	var page_content = $(document.body);// $("div[class = 'page-content']");
	var alertMessage = '关闭 ';
	var imageTag = '';
	if (message) {
		alertMessage = message;
	}
	if (imageUrl) {
		imageTag = "<img src='" + imageUrl + "' />";
	}
	var content = '<div id="dop_err_Modal" class="modal fade" aria-hidden="true" role="basic" tabindex="-1" style="display: none;"><div class="modal-dialog" style="width: 400px;margin-top:140px;"><div class="modal-content"><div class="modal-header">	<button class="close" aria-hidden="true" onclick="jQuery.dopErr.destoryAlert()" type="button"></button><h4 class="modal-title" style="text-align:left;">异常信息</h4></div><div class="modal-body"> '
			+ imageTag
			+ '<div  style="resize:none; border:1px solid #CCC;width:338px;margin-bottom:-20px; height:180px; overflow:auto">'
			+ alertMessage
			+ '</div>'
			+ '</div><div class="modal-footer"><button class="btn blue" type="button" onclick="jQuery.dopErr.destoryAlert()">确定</button></div></div></div></div>';
	// 添加alert弹出框
	var dop_err_Modal = [];
	function addAlert() {
		$('#dop_err_Modal').remove();
		page_content.append(content);
		var dop_alert_Modal_Interval = window.setInterval(function() {
			dop_err_Modal = $('#dop_err_Modal');
			if (dop_err_Modal.length > 0) {
				dop_err_Modal.modal({
					backdrop : 'static',
					keyboard : false
				});
				dop_err_Modal.on('hidden.bs.modal', function(e) {
					dop_err_Modal.remove();
				});
				dop_err_Modal.modal("show");
				clearInterval(dop_alert_Modal_Interval);
			}
		}, 50);
	}

	addAlert();
};
// 销毁ErrAlert弹出框
jQuery.dopErr.destoryAlert = function() {
	 $('#dop_err_Modal').modal("hide");
};

//alert编写
jQuery.dopAlertWithNoBtns = function(message, imageUrl, fu) {
	var page_content = $(document.body);// $("div[class = 'page-content']");
	var alertMessage = '确定要关闭吗？ ';
	var imageTag = '';
	if (message) {
		alertMessage = message;
	}
	if (imageUrl) {
		imageTag = "<img src='" + imageUrl + "' />";
	}
	var content = '<div id="dop_alert_Modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true" style="width:300px;position:absolute;left:900px;top:200px;">'
				+ '<div class="modal-header">'
				+ '<h4 class="modal-title" style="text-align:left;">提示</h4>'
				+ '</div>'
				+ '<div class="modal-body"> '
				+ imageTag
				+ alertMessage
				+ '</div>'
				+ '<div class="modal-footer">'
				+ '</div>'
				+ '</div>';
	// 添加alert弹出框
	var dop_alert_Modal = [];
	function addAlert() {
		$('#dop_alert_Modal').modal('hide');
		if($('#dop_alert_Modal')){
			$('#dop_alert_Modal').remove();
		}
		page_content.append(content);
		var dop_alert_Modal_Interval = window.setInterval(function() {
			dop_alert_Modal = $('#dop_alert_Modal');
			if (dop_alert_Modal.length > 0) {
				dop_alert_Modal.modal({
					backdrop : 'static',
					keyboard : false
				});
				dop_alert_Modal.on('hidden.bs.modal', function(e) {
					dop_alert_Modal.remove();
				});
				dop_alert_Modal.show();
				
				clearInterval(dop_alert_Modal_Interval);
			}
		}, 50);
	}

	addAlert();
	
	// 设置确认窗口1s后自动关闭
	window.setTimeout(function(){
		$.dopAlert.destoryAlert();
	},1000);
	
};