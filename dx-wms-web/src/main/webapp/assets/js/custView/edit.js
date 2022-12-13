$(function() {
	$(".custName").attr("maxlength", 6);
	$(".idCard").attr("maxlength", 18);
	$(".mobile").attr("maxlength", 11);
	$(".custSourceOther").attr("maxlength", 30);
	if ($(".idType").val() < 0) {
		$(".idCard").attr("disabled", "disabled");
	}
	if ($(".custSource").val() == '20') {
		$(".hide-div").show();
	} else {
		$(".hide-div").hide();
	}
	
	$(".custSource").live("change", function() {
		if ($(this).val() == '20') {
			$(".hide-div").show();
			
		} else {
			$(".hide-div").hide();
			$("input.custSourceOther").val("");
		}
	});
	$(".idType").live("change", function() {
		$(".idCard").val("");
		var spanFlag=$(".idCard").siblings();
		$(spanFlag).text("");
		if ($(this).val() != '-1') {
			$('.idCard').removeAttr("disabled");
		} else {
			$(".idCard").attr("disabled", "disabled");
		}
	});
	$(".save").unbind("click").bind("click", function() {
		var form = $('#submit_form');
		if (!form.valid()) {
			return;
		}
		if (!form.valid()) {
			return;
		}
		$(this).attr("disabled", "disabled");
		$(".close-modal").attr("disabled", "disabled");
		$.ajax({
			url : 'save.json',// 请求url
			type : "POST",
			async : false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(get(form.serializeArray())),
			timeout : 3000,
			success : function(data) {
				$.dopAlert(data.msg);
				if (data.result) {
					TableManaged.fnDraw();
					$('#editModal').modal('hide');
				}
				$(".save").removeAttr("disabled");
				$(".close-modal").removeAttr("disabled");

			},
			error : function(data) {
				$.dopAlert("请求超时");
				$(".save").removeAttr("disabled");
				$(".close-modal").removeAttr("disabled");
			}
		});

	});
});

function get(json) {
	var o = {};
	$.each(json, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
}
