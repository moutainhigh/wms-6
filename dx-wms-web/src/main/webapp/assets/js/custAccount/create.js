function ss() {
	window.location.href = "list.htm";
}

function waitforexport(){
	doCreateUserAccounttype=true;
	$('#waitexper').modal('hide');
}

//初始化其他来源清空文本框
//$(function(){
//	$("#custSourceOther").val("");
//});

/**
 * 确认开户
 */
var doCreateUserAccounttype=true;
function doCreateUserAccount() {
	
	var rm = "开户";
	var lenderCustCode = $("#lenderCustCode").val();
	if(null != lenderCustCode && $.trim(lenderCustCode) != "") {
			rm = "保存";
	}
	for (var i = 0; i < sunFileNumberArr.length; i++) {
		if (parseInt($("#" + sunFileNumberArr[i]).html()) == 0) {
//			if(doCreateUserAccounttype){
//				doCreateUserAccounttype=false;
//			$('#waitexper').modal({
//				show : true
//			});
//			
//			}
			$.dopAlert("确认"+rm+"之前,请先上传完整文件");
			return;
		}
	}

	var conditions = {};
	conditions.cmAction = "createAccount";
	conditions.action = "createUserAccount";// 指定操作行为是确认开户
	conditions.appCode = $("#appCode").val();
	conditions.resKey = $("#resKey").val();
	conditions.custAccountId = $("#userUniqueId").val();
	
	$.dopConfirm("确认"+rm+"吗？", null, function(r) {
		if (r) {
			$.ajax({
				url : base + '/custAccountApply/createUserAccount.json',// 请求url
				type : "POST",
				async : true,
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(conditions),
				timeout : 30000,
				success : function(data) {
					if (!data) {
						$.dopAlert(rm+"失败.");
					} else {
						$.dopAlert(rm+"成功.");
						// window.open(baseUrl + "/custAccountApply/list.htm");
						TableManaged.fnDraw();
						$('#detailModal').modal('hide');
					}
				},
				error : function(data) {
					$.dopAlert(rm+"异常");
				}
			});
		}
	});
	
}


$("#linkmanMobile").blur(function(){
	$("#selectOne").html("");
});
$("#linkmanAreaCode").blur(function(){
	$("#selectOne").html("");
});
$("#linkmanTelNum").blur(function(){
	$("#selectOne").html("");
});

function previous(tab, navigation, index){
}

function save(tab, navigation, index) {
	//紧急联系人手机和固定电话选择其一
	$("#selectOne").html("");
	if(isEmptyString($("#linkmanMobile").val()) && (isEmptyString($("#linkmanAreaCode").val()) || isEmptyString($("#linkmanTelNum").val()))){
		$("#selectOne").html("移动电话或固定电话选填一个");
		return false;
	}
	if(index ==1 ){
		var custAccountApplyVo = getCustAccountApplyVo(index);
		var flag = true;
		$.ajax({
			url : base + '/custAccountApply/save.json',// 请求url
			type : "POST",
			async : false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(custAccountApplyVo),
			timeout : 30000,
			success : function(data) {
					if(data.custAccount != null){
						$("#custAccountId").val(data.custAccount.custAccountId);
						$("#userUniqueId").val(data.custAccount.custAccountId);
						$("#custCommId").val(data.custComm.custCommId);
						$("#custLinkmanId").val(data.custLinkman.custLinkmanId);
						$("#custProfessionId").val(data.custProfession.custProfessionId);
						flag=true;
					}else {
						$.dopAlert("保存出现异常,请重试");
						flag = false;
					}
				},
				error: function(data){
					$.dopAlert("保存出现异常,请重试");
					flag = false;
				}
			});
		return flag;
	}
}
function isEmptyString(str){
	if(str == null || $.trim(str) == "" || $.trim(str) == "null"){
		return true;
	}
	return false;
}
/**
 * 设置上传的div随tab2共同显示或隐藏
 */
function doShowOrHideUploadDiv(){
	if($("#tab2").is(":hidden")){
		$("#uploadDiv").hide();
	} else{
		$("#uploadDiv").show();
	}
}

$(function(){
	varMobile = $("#mobile").val();
	varIdCard = $("#idCard").val();
	
	//省
	$("#provinceRegionCode").change(function() {
		$("#cityRegionCode option").remove();
		$("#cityRegionCode").append("<option value='-1'>请选择市</option>");
		$("#districtRegionCode option").remove();
		$("input[name='streetInfo']").val("");
		$("#districtRegionCode").append("<option value='-1'>请选择区</option>");
		$.getJSON(base + '/common/region.json?param=' + $("#provinceRegionCode").val(), function(data) {
			$.each(data, function(index, item) {
				$("#cityRegionCode").append("<option value='" + item.area_code_id + "'>" + item.area_code_name + "</option>");
			});
		});
		if ($("#equalsPermanent").attr("checked") == "checked") {
			$("#residenceProvince").val($("#provinceRegionCode").val());
			$("#residenceProvince").attr("disabled", "disabled");
			$("#residenceCity option").remove();
			
			$("#residenceCity").append("<option value='-1'>请选择市</option>");
			$("#residenceDistrict option").remove();
			$("#residenceDistrict").append("<option value='-1'>请选择区</option>");
		}
	});
	//市
	$("#cityRegionCode").change(function() {
		$("#districtRegionCode option").remove();
		$("input[name='streetInfo']").val("");
		$("#districtRegionCode").append("<option value='-1'>请选择区</option>");
		$.getJSON(base + '/common/region.json?param=' + $("#cityRegionCode").val(), function(data) {
			$.each(data, function(index, item) {
				$("#districtRegionCode").append("<option value='" + item.area_code_id + "'>" + item.area_code_name + "</option>");
			});
		});
		if ($("#equalsPermanent").attr("checked") == "checked") {
			$("#residenceCity option").remove();
			$("#cityRegionCode option").each(function(){
			$("#residenceCity").append("<option value='" + $(this).val() + "'>" + $(this).html() + "</option>");
			})	
			$("#residenceCity").val($("#cityRegionCode").val());
			$("#residenceCity").attr("disabled", "disabled");
			$("#residenceDistrict option").remove();
			$("#residenceDistrict").append("<option value='-1'>请选择区</option>");
		}
		
	});
	//区
	$("#districtRegionCode").change(function() {
		$("input[name='streetInfo']").val("");
		if ($("#equalsPermanent").attr("checked") == "checked") {
			$("#residenceDistrict option").remove();
			$("#districtRegionCode option").each(function(){
				$("#residenceDistrict").append("<option value='" + $(this).val() + "'>" + $(this).html() + "</option>");
			})	
			$("#residenceDistrict").val($("#districtRegionCode").val());
			$("#residenceDistrict").attr("disabled", "disabled");
		}
	});
//	$("#custName").change(function() {
//		if($("#custName") != null){
//		$.getJSON(base + '/common/check_spellName.json?param=' + $("#custNameSpell").val(), function(data) {
//			$.each(data, function(Trans2PinYin) {
//				$("#custNameSpell").append("value='" + Trans2PinYin.getPinYin(custInfoCheckVo.getCustName()));
//			})
//		
//		})
//		})
//	});
	
	// 显示影像文件夹
//	showRefFolders();
	
	$("#uploadDiv").hide();
	setInterval("doShowOrHideUploadDiv()",500);
	
	if($("#idType").val() == '-1') {
		$("#idCardNum").attr("disabled","disabled");
	}else{
		$("#idCardNum").removeAttr("disabled");
	}
	
	if($("#linkmanIdType").val() == '-1') {
		$("#linkmanIdCard").attr("disabled","disabled");
	}else{
		$("#linkmanIdCard").removeAttr("disabled");
	}
	
	$("#idType").live("change",function(){
		$("input[name='idCardNum']").val("");
		var idType = this.value;
		if($(this).val() == '-1') {
			$("#idCardNum").attr("disabled","disabled");
		} else {
			$("#idCardNum").removeAttr("disabled");
		}$("#idCardNum").closest(".responsive").removeClass("success").removeClass("error");
		if($("#idCardNum").next().hasClass("validate-inline")){
			$("#idCardNum").next().remove();
		}
	});	
	
	$("#linkmanIdType").live("change",function(){
		$("input[name='linkmanIdCard']").val("");
		var linkmanIdType = this.value;
		if($(this).val() == '-1') {
			$("#linkmanIdCard").attr("disabled","disabled");
		} else {
			$("#linkmanIdCard").removeAttr("disabled");
		}$("#linkmanIdCard").closest(".responsive").removeClass("success").removeClass("error");
		if($("#linkmanIdCard").next().hasClass("validate-inline")){
			$("#linkmanIdCard").next().remove();
		}
	});
	
	if($("#custSource").val()!=20){
		$("#custSourceOtherDiv").hide();
	}
	
	var mobile = $("#mobile").val();
	if(null != mobile && "" != $.trim(mobile)) {
		$("#mobile").attr("readonly","readonly");
	}
	
})
function getCustAccountApplyVo(index){
	var custAccountApplyVo = {};
	custAccountApplyVo.custAccount = getCustAccount();
	if(index==1){
		custAccountApplyVo.custProfession = getCustProfession();
		custAccountApplyVo.custComm=getCustComm();
		custAccountApplyVo.custLinkman=getCustLinkman();
	}
	return custAccountApplyVo;
}

function getCustAccount(){
	var custAccount={};
	if($("#custAccountId").val()!=null){
		custAccount.custAccountId=$("#custAccountId").val();
	}
	if($("#custCode").val()!=null){
		custAccount.custCode=$("#custCode").val();
	}
	custAccount.custName=$("#custName").val();
	custAccount.education=$("#education").val();
	if($("#custNameSpell").val()!=null){
		custAccount.custNameSpell = $("#custNameSpell").val();
	}
	custAccount.sex=$("#sex").val();
	custAccount.nationality=$("#nationality").val();
	
	if($("#maritalStatus").val()!='-1' && $("#maritalStatus").val()!=null){
		custAccount.maritalStatus=$("#maritalStatus").val();
	}
	if($("#commonLanguage").val()!=null){
		custAccount.commonLanguage=1;
	}
	custAccount.idType=$("#idType").val();
	custAccount.idCard=$("#idCard").val();
	
	if($("#birthDate").val()!=null){
		custAccount.birthDate=$("#birthDate").val();
	}
	if($("#openDate").val()!=null){
		custAccount.openDate=$("#openDate").val();
	}
		
	custAccount.mobile=$("#mobile").val();
	
	if($("#msgWay").val()!='-1' && $("#msgWay").val()!=null){
		custAccount.msgWay=$("#msgWay").val();
	}
	if($("#custSource").val()!='-1' && $("#custSource").val()!=null){
		custAccount.custSource=$("#custSource").val();
	}
	if($("#custSourceOther").val()!=null){
		custAccount.custSourceOther=$("#custSourceOther").val();
	}
	if($("#custCategory").val()!='-1' && $("#custCategory").val()!=null){
		custAccount.custCategory=$("#custCategory").val();
	}
	
	return custAccount;
}
function getCustProfession(){
	var custProfession = {};
	if($("#custProfessionId").val()!=null){
		custProfession.custProfessionId=$("#custProfessionId").val();
	}
	if($("#profession").val()!='-1' && $("#profession").val()!=null){
		custProfession.profession=$("#profession").val();
	}
	if($("#industry").val()!=null){
		custProfession.industry=$("#industry").val();
	}
	custProfession.companyName=$("#companyName").val();
	if($("#post").val()!=null){
		custProfession.post=$("#post").val();
	}
	return custProfession;
}

function getCustComm(){
	var custComm = {};
	if($("#custCommId").val()!=null){
		custComm.custCommId=$("#custCommId").val();
	}
	custComm.zipCode= $("#zipCode").val();
	custComm.areaCode= $("#areaCode").val();
	custComm.telNum= $("#telNum").val();
	custComm.email= $("#email").val();
	custComm.wechat = $("#wechat").val();
	custComm.provinceRegionCode= $("#provinceRegionCode").val();
	custComm.cityRegionCode= $("#cityRegionCode").val();
	custComm.districtRegionCode= $("#districtRegionCode").val();
	custComm.streetInfo= $("#streetInfo").val();
	return custComm;
}
function getCustLinkman(){
	var custLinkman={};
	if($("#custLinkmanId").val()!=null){
		custLinkman.custLinkmanId=$("#custLinkmanId").val();
	}
	custLinkman.linkmanName = $("#linkmanName").val();
	if($("#linkmanNameSpell").val()!=null){
		custLinkman.linkmanNameSpell = $("#linkmanNameSpell").val();
	}
	custLinkman.linkmanSex = $("#linkmanSex").val();
	custLinkman.linkmanRelation = $("#linkmanRelation").val();
	if($("#linkmanIdType").val()!='-1' && $("#linkmanIdType").val()!=null){
		custLinkman.linkmanIdType = $("#linkmanIdType").val();
	}
	if($("#linkmanIdType").val()!='-1' && $("#linkmanIdCard").val()!='-1' && $("#linkmanIdCard").val()!=null){
		custLinkman.linkmanIdCard = $("#linkmanIdCard").val();
	}
	custLinkman.linkmanMobile = $("#linkmanMobile").val();
	if($("#linkmanAreaCode").val()!=null && $("#linkmanTelNum").val()!=null ){
		custLinkman.areaCode = $("#linkmanAreaCode").val();
		custLinkman.telNum = $("#linkmanTelNum").val();
	}
	
	return custLinkman;
}


function initCustAccount(){
	if($("#custAccountId").val()!='' || $("#custAccountId").val()>0){
		$("#selectButton").hide();
		$("#nextPage").show();
	}else{
		$("#selectButton").show();
		$("#nextPage").hide();
	}
	
	$("#custName").attr("disabled", "disabled");
	$("#mobile").attr("disabled", "disabled");
	$("#idType").attr("disabled", "disabled");
	$("#idCard").attr("disabled", "disabled");
	$("#sex").attr("disabled", "disabled");
	$("#custSource").attr("disabled", "disabled");
	$("#custSourceOther").attr("disabled", "disabled");
	
	$("#custNameSpell").attr("maxlength", 100);
	$("#nationality").attr("disabled", "disabled");
	$("#commonLanguage").attr("disabled", "disabled");
	$("#birthDate").removeAttr("disabled");
	$("#idCard").attr("maxlength", 18);
	$("#mobile").attr("maxlength", 11);
	$("#custSourceOther").attr("maxlength", 50);
	if($("#custSource").val()!=20){
		$("#RustSourceOtherDiv").hide();
	}
	$("#custSource").change(function() {
		if ($("#custSource").val() == '20') {
			$("#custSourceOtherDiv").show();
		} else {
			$("#custSourceOtherDiv").hide();
		}
	});
}

function initCustComm(){
	$("#streetInfo").attr("maxlength", 50);
	$("#zipCode").attr("maxlength", 6);
	$("#areaCode").attr("maxlength", 4);
	$("#telNum").attr("maxlength", 8);
	$("#email").attr("maxlength", 40);
	$("#wechat").attr("maxlength", 30);
}
function initCustLinkman(){
	$("#linkmanName").attr("maxlength", 6);
	$("#linkmanNameSpell").attr("maxlength", 20);
	$("#linkmanRelation").attr("maxlength", 6);
	$("#linkmanIdCard").attr("maxlength", 18);
	$("#linkmanMobile").attr("maxlength", 11);
	$("#linkmanAreaCode").attr("maxlength", 4);
	$("#linkmanTelNum").attr("maxlength", 8);
}
function initCustProfession(){
	$("#industry").attr("maxlength", 10);
	$("#companyName").attr("maxlength", 30);
	$("#post").attr("maxlength", 10);
}

function initCustFinance(){
	$("#remitSubBank").attr("maxlength", 50);
	$("#remitAccountName").attr("maxlength", 20);
	$("#remitAccountNum").attr("maxlength", 30);
	$("#refundSubBank").attr("maxlength", 11);
	$("#refundAccountName").attr("maxlength", 25);
	$("#refundAccountNum").attr("maxlength", 30);
	
}
function initChangeInfo(){
	$("#customerId").attr("disabled", "disabled");
	$("#nationality").attr("disabled", "disabled");
	$("#commonLanguage").attr("disabled", "disabled");
	$("#custName").attr("maxlength", 6);
	$("#custNameSpell").attr("maxlength", 20);
	$("#birthDate").removeAttr("disabled");
	$("#idCardNum").attr("maxlength", 18);
	$("#mobileNum").attr("maxlength", 11);
	$("#custSourceOther").attr("maxlength", 30);
	if($("#custSource").val()!=20){
		$("#RustSourceOtherDiv").hide();
	}else{
		$("#RustSourceOtherDiv").show();
	}
	$("#custSource").change(function() {
		if ($("#custSource").val() == '20') {
			$("#custSourceOtherDiv").show();
		} else {
			$("#custSourceOtherDiv").hide();
			$("#custSourceOther").val("");
		}
	});
}

//输入姓名自动带出其拼音
$("#custName").blur(function() {
	if($("#custName").val()!=''){
		var custInfoCheckVo = {};
		custInfoCheckVo.custName = $("#custName").val();
		$.ajax({
			url : base + '/common/check_spellName.json',// 请求url
			type : "POST",
			async : true,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(custInfoCheckVo),
			timeout : 30000,
			success : function(data) {
				if(data.custNameSpell!=null){
					$("#custNameSpell").val(data.custNameSpell);
				}
			},
			error : function(data) {
				$.dopAlert("获取名字拼音 异常 ");
			}
		});
	}
});

//输入姓名自动带出其拼音
$("#linkmanName").blur(function() {
	if($("#linkmanName").val()!=''){
		var custInfoCheckVo = {};
		custInfoCheckVo.custName = $("#linkmanName").val();
		$.ajax({
			url : base + '/common/check_spellName.json',// 请求url
			type : "POST",
			async : true,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(custInfoCheckVo),
			timeout : 30000,
			success : function(data) {
				if(data.custNameSpell!=null){
					$("#linkmanNameSpell").val(data.custNameSpell);
				}
			},
			error : function(data) {
				$.dopAlert("获取名字拼音 异常 ");
			}
		});
	}
});

//通过身份证返回出生日期
$("#idCard").blur(function() {
	if($("#idCard").val()!=''  && $("#idType").val() == 1){
		var custInfoCheckVo = {};
		custInfoCheckVo.idCard = $("#idCard").val();
		$.ajax({
			url : base + '/common/change_birthday.json',// 请求url
			type : "POST",
			async : true,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(custInfoCheckVo),
			timeout : 30000,
			success : function(data) {
				if($("#idType").val()==1 ){
            		var idCard = $("#idCard").val();
            		var Y, JYM;
            		var S, M;
            		var idcard_array = new Array();
            		idcard_array = idCard.split("");
				var reg_18 = /^[1-9][0-7]\d{4}((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))\d{3}(\d|X|x)?$/; 
        		var reg_15 =  /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
        		if(reg_15.test(idCard)){ 
        			
        				return $("#birthDate").val(data.birthDate);
        		
        			
        		}else if(reg_18.test(idCard)){
        			// 计算校验位
        			var S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7 +
        			(parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9 +
        			(parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10 +
        			(parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5 +
        			(parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8 +
        			(parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4 +
        			(parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2 +
        			parseInt(idcard_array[7]) * 1 +
        			parseInt(idcard_array[8]) * 6 +
        			parseInt(idcard_array[9]) * 3;
        			Y = S % 11;
        			M = "F";
        			JYM = "10X98765432";
        			M = JYM.substr(Y, 1);
        			/* 判断校验位 */
        			if (M ==idcard_array[17].toUpperCase()) {
        				$("#birthDate").val(data.birthDate);
        			}
        		}
				}
			
			},
        		
			error : function(data) {
				$.dopAlert("获取生日异常 ");
			}
		});
		
	}
});

//function selectCust(){
//	var url ='selectCust.json';
//	$.get(url, function(data) {
//        $('#createCustAccountDiv').html(data);
//    });
//    $('#createCustAccountDiv').modal({
//        show : true
//    });
//	//window.open( base + "/custAccountApply/select.htm");
//}


function doCloseDiv(){
	TableManaged.fnDraw();
	$('#detailModal').modal('hide');
}

//校验电话号码是否存在
$("#mobile").blur(function() {
	if($("#mobile").val()!=''&& $("#mobile").val()!=varMobile){
		var custInfoCheckVo = {};
		custInfoCheckVo.mobile = $("#mobile").val();
		$.ajax({
			url : base + '/common/check_custInfo.json',// 请求url
			type : "POST",
			async : true,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(custInfoCheckVo),
			timeout : 30000,
			success : function(data) {
				if(!data){
					$("#mobile").val('');
					$.dopAlert("移动电话重复");
				}
			},
			error : function(data) {
				$.dopAlert("校验申请审核异常");
			}
		});
	}
});

//校验证件号码是否存在
var flag =true;
$("#idCard").blur(function() {
	if($("#idCard").val()!=varIdCard){
		flag = true;
	}
	if($("#idCard").val()!='' && $("#idCard").val()!=varIdCard){
		if($("#idType").val()==4 && $("#idCard").val()!=""){
			var idCard = $("#idCard").val();
			var rex = /^[HM]{1}\d{10}$/;
			if(rex.test(idCard)) {
			}else {
				//$.dopAlert("港澳居民往来大陆通行证号码不符合规范");
				return;
			}
		}
		
		if($("#idType").val()==1 && $("#idCard").val().indexOf("x") >0){
			return false;
		}
		var custInfoCheckVo = {};
		custInfoCheckVo.idCard = $("#idCard").val();
		$.ajax({
			url : base + '/common/check_custInfo.json',// 请求url
			type : "POST",
			async : true,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(custInfoCheckVo),
			timeout : 30000,
			success : function(data) {
				if(!data){
					$("#idCard").val('');
					$.dopAlert("证件号码重复");
					flag = false;
					return false;
				}
				flag = true;
			},
			error : function(data) {
				$.dopAlert("校验申请审核异常");
			}
		});
	}
});

$("#openDate").change(function() {
	if (null != this.value && $.trim(this.value) != "") {
		var dateArr = this.value.split("-");
		var year = dateArr[0];
		var month = dateArr[1];
		var day = dateArr[2];
		var selDate = new Date();
		selDate.setFullYear(year, month - 1, day);

		if (selDate <= new Date()) {

		} else {
			$("#openDate").val("");
		}
	}

});

$("#birthDate").change(function() {
	if (null != this.value && $.trim(this.value) != "") {
		var dateArr = this.value.split("-");
		var year = dateArr[0];
		var month = dateArr[1];
		var day = dateArr[2];
		var selDate = new Date();
		selDate.setFullYear(year, month - 1, day);

		if (selDate <= new Date()) {

		} else {
			$("#birthDate").val("");
		}
	}
});
