$(function() {
	$(".certNo").attr("maxlength", 18);
//	$(".certNo").attr("disabled", "disabled");
	$(".positionId").change(
		function() {
			$(".levelId option[value!='-1']").remove();
			$(".orgId option[value!='-1']").remove()
			var position = this.value;
			if (position == '-1') {
				return;
			}
			$.ajax({
				url : base + "/hr/queryLevel.json?positionId=" + position+ "",
				success : function(data) {
					$.each(data,function(index, item) {
						if (item.levelId) {
							$(".levelId").show();
							$(".levelId").append("<option value='"+ item.levelId + "'>"+ item.levelName+ "</option>");
						}else{
							$(this).siblings("span").removeClass("ok");
							$(".levelId").hide();
						}
					});
				}
			});
			$.ajax({
				url : base + "/hr/queryOrg.json?positionId=" + position+ "",
				success : function(data) {
					$.each(data, function(index, item) {
						if (item.orgId) {
							$(".orgId").append("<option value='" + item.orgId + "'>"+ item.orgGroupName+ "</option>");
						}
					});
				}
			});
		});
	setMaxlength({"name":6,"proBasicSalary":10,"proPerformanceSalary":10,"regularBasicSalary":10,"regularPerformanceSalary":10});
});

function setMaxlength(data){
	$.each(data,function(key,value){
		$("."+key).attr("maxlength",value);
	});
}
$(".certType").change(function() {
	$(".certNo").val("");
	var idType = this.value;
	$(".certNo").attr("disabled", "disabled");
	if (idType != '-1') {
		$(".certNo").removeAttr("disabled", "disabled");
		if (idType == '1') {
			$(".certNo").attr("maxlength", 18);
		} else {
			$(".certNo").attr("maxlength", 9);
		}
	}

});

$(".button-submit").on("click", function() {
	var form = $("#submit_form");
	if (!form.valid()) {
		return false;
	}
	$.dopConfirm("确认保存吗.", null, function(r) {
		if (r) {
			$.ajax({
				url : base + '/hrEntry/save.json',
				type : 'POST',
				async : false,
				dataType : 'json',
				contentType : 'application/json',
				data : JSON.stringify(get(form.serializeArray())),
				timeout : 30000,
				success : function(data) {
					if (data[$(".certNo").val()].isSuccess == '1') {
						$("#createBaseDiv").modal('hide');
						TableManaged.fnDraw();
						$.dopAlert("保存成功.");
					} else {
						$.dopAlert(data[$(".certNo").val()].msg);
					}
				},
				error : function(data) {
					$.dopAlert("保存员工信息异常.");
				}
			});
		}
	});
});

$(".button-close").on("click", function() {
	$("#createBaseDiv").modal('hide');
});

$(".plannedEntryDate").change(
	function() {
		if (null != this.value && $.trim(this.value) != "") {
			var dateArr = this.value.split("-");
			var year = dateArr[0];
			var month = dateArr[1];
			var day = dateArr[2];
			var selDate = new Date($(".plannedEntryDate").val());
			var sysDate = new Date();
			var curDate = new Date(sysDate.getFullYear() + "/"
					+ (sysDate.getMonth() + 1) + "/" + sysDate.getDate())
			selDate.setFullYear(year, month - 1, day);
			if (selDate >= curDate) {
				$(".plannedEntryDate").valid();
			} else {
				$(".plannedEntryDate").val("");
				$(".plannedEntryDate").valid();
			}
	}
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
