$(function(){ 
	var form = $('#entry_form');
	var error = $('.alert-error', form);
	var success = $('.alert-success', form);
	jQuery.validator.addMethod("checkName", function(value, element) {
		if (value != '') {
			var reg = /^[\u4E00-\u9FA5]+$/;
			if (reg.test(value)) {
				return true;
			}
		}
		$(element).focus();
		return false;
	}, "姓名不符合规范.");
	// 证件类型
	jQuery.validator.addMethod("checkSelect", function(value, element) {
		if (value == '-1') {
			$(element).focus();
			return false;
		}
		return true;
	}, "请选择至少一项.");
	jQuery.validator.addMethod("checkCertValidStart", function(value, element) {
		if (value=='') {
			$(element).nextAll('span').remove(); 
			$(element).css({"border-color": "#b94a48"});
			$(element).after('<span class="validate-inline" for='+$(element).attr('name')+'>请填写日期.</span>');
			$(element).next().css({"color": "#b94a48"});
			return false;
		}
		$(element).css({"border-color": "#468847"});
		$(element).next().css({"color": "#468847"});
		return true;
	}, "请填写日期.");
	jQuery.validator.addMethod("checkSchool", function(value, element) {
		if (value!='') {
			return true;
		}
		$(element).focus();
		return false;
	}, "请填写学校.");
	jQuery.validator.addMethod("checkMajor", function(value, element) {
		if (value!='') {
			return true;
		}
		$(element).focus();
		return false;
	}, "请填写专业.");
	jQuery.validator.addMethod("checkDepart", function(value, element) {
		if (value!='') {
			return true;
		}
		$(element).focus();
		return false;
	}, "请填写部门.");
	jQuery.validator.addMethod("checkDuty", function(value, element) {
		if (value!='') {
			return true;
		}
		$(element).focus();
		return false;
	}, "请填写职务.");
	// 账号
	jQuery.validator.addMethod("checkBankCardNo", function(value, element) {
		if (value != '') {
			var reg = /^(\d{16}|\d{17}|\d{18}|\d{19})$/;
			if (reg.test(value)) {
				var lastNum = value.substr(value.length - 1, 1);// 取出最后一位（与luhm进行比较）
				var first15Num = value.substr(0, value.length - 1);// 前15或18位
				var newArr = new Array();
				for (var i = first15Num.length - 1; i > -1; i--) { // 前15或18位倒序存进数组
					newArr.push(first15Num.substr(i, 1));
				}
				var arrJiShu = new Array(); // 奇数位*2的积 <9
				var arrJiShu2 = new Array(); // 奇数位*2的积 >9
				var arrOuShu = new Array(); // 偶数位数组
				for (var j = 0; j < newArr.length; j++) {
					if ((j + 1) % 2 == 1) {// 奇数位
						if (parseInt(newArr[j]) * 2 < 9){
							arrJiShu.push(parseInt(newArr[j]) * 2);
						}else{
							arrJiShu2.push(parseInt(newArr[j]) * 2);
						}	
					} else{
						// 偶数位
						arrOuShu.push(newArr[j]);
					}	
				}
				var jishu_child1 = new Array();// 奇数位*2 >9 的分割之后的数组个位数
				var jishu_child2 = new Array();// 奇数位*2 >9 的分割之后的数组十位数
				for (var h = 0; h < arrJiShu2.length; h++) {
					jishu_child1.push(parseInt(arrJiShu2[h]) % 10);
					jishu_child2.push(parseInt(arrJiShu2[h]) / 10);
				}
				var sumJiShu = 0; // 奇数位*2 < 9 的数组之和
				var sumOuShu = 0; // 偶数位数组之和
				var sumJiShuChild1 = 0; // 奇数位*2 >9 的分割之后的数组个位数之和
				var sumJiShuChild2 = 0; // 奇数位*2 >9 的分割之后的数组十位数之和
				var sumTotal = 0;
				for (var m = 0; m < arrJiShu.length; m++) {
					sumJiShu = sumJiShu + parseInt(arrJiShu[m]);
				}

				for (var n = 0; n < arrOuShu.length; n++) {
					sumOuShu = sumOuShu + parseInt(arrOuShu[n]);
				}
				for (var p = 0; p < jishu_child1.length; p++) {
					sumJiShuChild1 = sumJiShuChild1 + parseInt(jishu_child1[p]);
					sumJiShuChild2 = sumJiShuChild2 + parseInt(jishu_child2[p]);
				}
				// 计算总和
				sumTotal = parseInt(sumJiShu) + parseInt(sumOuShu)
						 + parseInt(sumJiShuChild1) + parseInt(sumJiShuChild2);
				// 计算Luhm值
				var k = parseInt(sumTotal) % 10 == 0 ? 10 : parseInt(sumTotal) % 10;
				var luhm = 10 - k;
				if (lastNum == luhm && value != '') {
					$("#value").html("Luhm验证通过");
					return true;
				} else {
					$("#value").html("银行卡号必须符合Luhm校验");
					return false;
				}
			}

		}
		$(element).focus();
		return false;
	}, "账号不符合规范.");
	jQuery.validator.addMethod("checkZip", function(value, element) {
		// 邮编
		var reg = /^[0-9]{6}$/;
		if (reg.test(value)) {
			return true;
		}
		$(element).focus();
		return false;
	}, "邮编不符合规范.");
	jQuery.validator.addMethod("checkStreetInfo", function(value, element) {
		var reg1 = /^[0-9]*$/;
		var reg2 = /^\s*$/;
		if (reg1.test(value.replace(/\s+/g, "")) || reg2.test(value)) {
			$(element).focus();
			return false;
		}
		return true;
	}, "街道信息不符合规范.");
	jQuery.validator.addMethod("checkMobile", function(value, element) {
		if (value != '') {
			// 手机号
			var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
			if (reg.test(value)) {
				return true;
			}
		}
		$(element).focus();
		return false;
	}, "移动电话不符合规范.");
	
	jQuery.validator.addMethod("checkEmail", function(value, element) {
		if (value != '') {
			// 邮箱
			var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})$/;
			if (reg.test(value)) {
				return true;
			}
		}
		$(element).focus();
		return false;
	}, "邮箱不符合规范.");
	jQuery.validator.addMethod("checkCompanyName", function(value, element) {
		var reg = /^\s+$/;
		if (value == '' || reg.test(value)) {
			$(element).focus();
			return false;
		}
		return true;
	}, "请输入单位名称.");
	jQuery.validator.addMethod("checkOrg", function(value, element) {
		if (value == '') {
			$(element).focus();
			return false;
		}
		return true;
	}, "请输入培训机构.");
	jQuery.validator.addMethod("checkProject", function(value, element) {
		if (value == '') {
			$(element).focus();
			return false;
		}
		return true;
	}, "请输入培训项目.");
	jQuery.validator.addMethod("checkCate", function(value, element) {
		if (value == '') {
			$(element).focus();
			return false;
		}
		return true;
	}, "请输入证书.");
	
	jQuery.validator.addMethod("checkOtherAddress", function(value, element) {
		if (value == '') {
			$(element).focus();
			return false;
		}
		return true;
	}, "请输入其他支行.");
	jQuery.validator.addMethod("checkLearn", function(value, element) {
		if(!value || value=='-1'){
			var v1 = $(element).attr("name");
			var list=[];
			$(element).parents(".learnExperience").find(":input:visible").each(function(){
				list.push($(this).attr("name"));
			});
			for(var i = 0; i < list.length; i++){
    			if(v1 != list[i]){
    				if($("."+list[i]).val().trim()!='' && $("."+list[i]).val().trim()!='-1'){
    					return false;
    				}
    			}
    		}
			return true;
		}
		return true;
	}, "请填写信息");
	jQuery.validator.addMethod("checkWork", function(value, element) {
		if(!value || value=='-1'){
			var v1 = $(element).attr("name");
			var list=[];
			$(element).parents(".workExperience").find(":input:visible").each(function(){
				list.push($(this).attr("name"));
			});
			for(var i = 0; i < list.length; i++){
    			if(v1 != list[i]){
    				if($("."+list[i]).val().trim()!='' && $("."+list[i]).val().trim()!='-1'){
    					return false;
    				}
    			}
    		}
			return true;
		}
		return true;
	}, "请填写信息");
	
	jQuery.validator.addMethod("checkTrain", function(value, element) {
		if(!value || value=='-1'){
			var v1 = $(element).attr("name");
			var list=[];
			$(element).parents(".trainExperience").find(":input:visible").each(function(){
				list.push($(this).attr("name"));
			});
			for(var i = 0; i < list.length; i++){
    			if(v1 != list[i]){
    				if($("."+list[i]).val().trim()!='' && $("."+list[i]).val().trim()!='-1'){
    					return false;
    				}
    			}
    		}
			return true;
		}
		return true;
	}, "请填写信息");
	jQuery.validator.addMethod("checkFundAccount", function(value, element) {
		var firstOpenFund=$("#tab2").find("input:radio[name='firstOpenFund']:checked").val();
		if(firstOpenFund==1){
			return true;
		}else{
			var reg = /^\d{9,12}$/;
			if(value&&reg.test(value)){
				return true;
			}
			$(element).focus();
			return false;
		}
	}, "个人公积金账号不符合规范.");
	
	form.validate({
		doNotHideMessage : true, 
		errorElement : 'span',
		errorClass : 'validate-inline', 
		focusInvalid : false, 
		rules : {
			certValidStart:{
				checkCertValidStart:true
			},
			certValidEnd:{
				checkCertValidStart:true
			},
			birthDate:{
				checkCertValidStart:true
			},
			entryDate:{
				checkCertValidStart:true
			},
			maritalStatus:{
				checkSelect:true
			},
			country:{
				checkSelect:true
			},
			nation:{
				checkSelect:true
			},
			workUnit:{
				checkSelect:true
			},
			politicalStatus:{
				checkSelect:true
			},
			HrEducation:{
				checkSelect:true
			},
			censusRegister:{
				checkSelect:true
			},
			censusProvinceCode:{
				checkSelect:true
			},
			censusCityCode:{
				checkSelect:true
			},
			censusAreaCode:{
				checkSelect:true
			},
			homeProvinceCode:{
				checkSelect:true
			},
			homeCityCode:{
				checkSelect:true
			},
			homeAreaCode:{
				checkSelect:true
			},
			entrySource:{
				checkSelect:true
			},
			bankProvinceCode:{
				checkSelect:true
			},
			bankCityCode:{
				checkSelect:true
			},
			openAddress:{
				checkSelect:true
			},
			otherAddress:{
				checkOtherAddress:true
			},
			insuredProvinceCode:{
				checkSelect:true
			},
			insuredCityCode:{
				checkSelect:true
			},
			relationShip:{
				checkSelect:true
			},
			censusZipCode:{
				checkZip:true
			},
			homeZipCode:{
				checkZip:true
			},
			censusAddress:{
				checkStreetInfo:true
			},
			homeAddress:{
				checkStreetInfo:true
			},
			mobilePhone:{
				checkMobile:true,
//				remote: {
//					url: base + "/common/check_hrMobile.json",
//					data:{
//						mobile: function(){ return $(".mobilePhone").val()}
//					}
//				}
			},
			hrEmail:{
				checkEmail:true
			},
			bankCardNo:{
				checkBankCardNo:true,
//				remote:{
//					url: base + "/common/check_hrBankCardNo.json",
//					data:{
//						bankCardNo: function(){
//							return $(".bankCardNo").val()
//						}
//					}
//				}
			},
			familyName:{
				checkName:true
			},
			fyWorkUnit:{
				checkCompanyName:true
			},
			fyMobilePhone:{
				checkMobile:true
			},
			fundAccount:{
				checkFundAccount:true
			},
		},
		messages : { 
			mobilePhone : {
				remote: "移动电话已存在."
			},
			idCard : {
				remote: "证件号已存在."
			},
			bankCardNo :{
				remote: "账号已存在."
			}
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element); 
		},
		invalidHandler : function(event, validator) { 
			success.hide();
			error.show();
		},
		highlight : function(element) { 
			$(element).closest('.help-inline').removeClass('ok'); 
			$(element).closest('.responsive').removeClass('success').addClass('error'); 
		},
		unhighlight : function(element) {
			$(element).closest('.responsive').removeClass('error'); 
		},
		success : function(label) {
			label.addClass('valid ok').closest('.responsive').removeClass('error').addClass('success'); 
		}
	});
	var displayConfirm = function() {
		$('.display-value', form).each(function() {
			var input = $('[name="' + $(this).attr("data-display") + '"]', form);
			if (input.is(":text") || input.is("textarea")) {
				$(this).html(input.val());
			} else if (input.is("select")) {
				$(this).html(input.find('option:selected').text());
			} else if (input.is(":radio") && input.is(":checked")) {
				$(this).html(input.attr("data-title"));
			} else if ($(this).attr("data-display") == 'card_expiry') {
				$(this).html($('[name="card_expiry_mm"]',form).val()+ '/' + $('[name="card_expiry_yyyy"]',form).val());
			} else if ($(this).attr("data-display") == 'payment') {
				var payment = [];
				$('[name="payment[]"]').each(function() {
					payment.push($(this).attr('data-title'));
				});
				$(this).html(payment.join("<br>"));
			}
		});
	}
	$('#form_wizard_1').bootstrapWizard({
		'nextSelector' : '.button-next',
		'previousSelector' : '.button-previous',
		onTabClick : function(tab, navigation, index) {
			return false;
		},
		onNext : function(tab, navigation, index) {
			
			success.hide();
			error.hide();
			if($("#save").attr("disabled")=="disabled"){
				return false;
			}
			
			if (form.valid() == false) {
				return false;
			}
//			console.log("==3=="+save(tab, navigation, index));
			// 自定义方法
			if (save(tab, navigation, index) == false) {
				return false;
			}
			var total = navigation.find('li').length;
			var current = index + 1;
			// set wizard title
			$('.step-title', $('#form_wizard_1')).text('Step ' + (index + 1) + ' of '+ total);
			// set done steps
			jQuery('li', $('#form_wizard_1')).removeClass("done");
			var li_list = navigation.find('li');
			for (var i = 0; i < index; i++) {
				jQuery(li_list[i]).addClass("done");
			}
			if (current == 1) {
				$('#form_wizard_1').find('.button-previous').hide();
			} else {
				$('#form_wizard_1').find('.button-previous').show();
			}
			if (current >= total) {
				$('#form_wizard_1').find('.button-next').hide();
				$('#form_wizard_1').find('.button-submit').show();
				displayConfirm();
			} else {
				$('#form_wizard_1').find('.button-next').show();
				$('#form_wizard_1').find('.button-submit').hide();
			}
			App.scrollTo($('.page-title'));
		
		},
		onPrevious : function(tab, navigation, index) {
			success.hide();
			error.hide();
			if (previous(tab, navigation, index) == false) {
				return false;
			}
			var total = navigation.find('li').length;
			var current = index + 1;
			// set wizard title
			$('.step-title', $('#form_wizard_1')).text('Step ' + (index + 1) + ' of ' + total);
			// set done steps
			jQuery('li', $('#form_wizard_1')).removeClass("done");
			var li_list = navigation.find('li');
			for (var i = 0; i < index; i++) {
				jQuery(li_list[i]).addClass("done");
			}
			if (current == 1) {
				$('#form_wizard_1').find('.button-previous').hide();
			} else {
				$('#form_wizard_1').find('.button-previous').show();
			}
			if (current >= total) {
				$('#form_wizard_1').find('.button-next').hide();
				$('#form_wizard_1').find('.button-submit').show();
			} else {
				$('#form_wizard_1').find('.button-next').show();
				$('#form_wizard_1').find('.button-submit').hide();
			}
			App.scrollTo($('.page-title'));
		},
		onTabShow : function(tab, navigation, index) {
			var total = navigation.find('li').length;
			var current = index + 1;
			var $percent = (current / total) * 100;
			if(index==2){
				$(".tab-content").css("margin-top","5.6%");
			}else{
				$(".tab-content").css("margin-top","0px");
			}
			$('#form_wizard_1').find('.bar').css({
				width : $percent + '%'
			});
		}
	});
	$('#form_wizard_1').find('.button-previous').hide();
	$('#form_wizard_1 .button-submit').click(function() {
		if (form.valid() == false) {
			return false;
		}
		save("", "", 4);
	}).hide();
	
});

/********************开始验证日期********************/

//开始检验有效时间
/**
 * 验证有效时间(起)
 */
$(".certValidStart").live("change", function() {
	var dateArray=getDateArray(this);
	if(dateArray[0]>dateArray[1]){
		$(this).val("");
		$(this).valid();
	}
	compareDate(1,this);
	$(this).valid();
});

/**
 * 验证有效时间(止)
 */
$(".certValidEnd").live("change", function() {
	compareDate(2,this);
	$(this).valid();
});

//开始检验生日时间
/**
 * 验证出生日期
 */
$(".birthDate").live("change", function() {
	var dateArray=getDateArray(this);
	if(dateArray[0]>dateArray[1]){
		$(this).val("");
		$(this).valid();
	}
	$(this).valid();
});

//开始检验首次参加工作年月
/**
 * 验证首次参加工作年月
 */
$(".firstWorkDate").live("change", function() {
	var dateArray=getDateArray(this);
	if(dateArray[0]>dateArray[1]){
		$(this).val("");
		$(this).valid();
	}
});

//开始检验学习时间
/**
 * 验证学习时间(起)
 */
$("input[name^='learnStartdate']").live("change", function() {
	var dateArray=getDateArray(this);
	if(dateArray[0]>dateArray[1]){
		$(this).val("");
		$(this).valid();
	}
	compareDate(1,this);
	$(this).valid();
});

/**
 * 验证学习时间(止)
 */
$("input[name^='learnEnddate']").live("change", function() {
	compareDate(2,this);
	$(this).valid();
});

//开始检验工作时间
/**
 * 验证工作时间(起)
 */
$("input[name^='entryDateBegin']").live("change", function() {
	var dateArray=getDateArray(this);
	if(dateArray[0]>dateArray[1]){
		$(this).val("");
		$(this).valid();
	}
	compareDate(1,this);
	$(this).valid();
});

/**
 * 验证工作时间(止)
 */
$("input[name^='quitDate']").live("change", function() {
	compareDate(2,this);
	$(this).valid();
});

//开始检验培训时间
/**
 * 验证培训时间(起)
 */
$("input[name^='startDate']").live("change", function() {
	console.log($(this));
	var dateArray=getDateArray(this);
	if(dateArray[0]>dateArray[1]){
		$(this).val("");
		$(this).valid();
	}
	compareDate(1,this);
	$(this).valid();
});


/**
 * 验证培训时间(止)
 */
$("input[name^='endDate']").live("change", function() {
	compareDate(2,this);
	$(this).valid();
});

/**
 *获得日期数组
 */
function getDateArray(obj){
	var dateArray=[];
	var selDate = new Date($(obj).val());
	var curDate = new Date();
	dateArray.push(selDate);
	dateArray.push(curDate);
	return dateArray;
}

function getDateArrays(obj){
		var dateArray=[];
		var sysDate = new Date();
		dateArray.push(new Date(sysDate.getFullYear() + "/"
				+ (sysDate.getMonth() + 1) + "/" + sysDate.getDate()));
		for(var i = 0 ; i < obj.length ; i++){
			dateArray.push(replaceDate(obj[i]))
		}
		return dateArray;
}
function replaceDate(dateStr){
	var dateArr = $(dateStr).val().split("-");
	var curDate = new Date(dateArr[0]+ "/"+ dateArr[1] + "/" + dateArr[2]);
	return curDate;
}
/**
 * 比较前（起）后（止）两个日期的大小
 */
function compareDate(flag,selDate){
	var input=$(selDate).parent().parent().siblings().find("input");
	var dateArray_1=getDateArray(selDate);
	var dateArray_2=getDateArray(input);
	//当起始时间大于互等于截止时间时清空截止时间
	if(flag==1){
		if(dateArray_1[0]>=dateArray_2[0]){
			$(input).val("");
		}
	}
	//当截止时间小于或等于起始时间时清空截止时间
	if(flag==2){
		if(dateArray_1[0]<=dateArray_2[0]){
			$(selDate).val("");
		}
	}
}



/********************结束验证日期********************/

//入职日期验证
$(".entryDate").change(
		function() {
			var flag = $("#status").val();
			if (null != this.value && $.trim(this) != "") {
				var dateArray = getDateArrays(new Array(this,"#plandate","#plandate"));
				var lastDate = dateArray[0];
				if(null != $("#entryDate").val() && $.trim($("#entryDate").val()) != ""){
					var endArray = getDateArrays(new Array("#entryDate"));
					lastDate =  endArray[1];
				}
				var selDate = dateArray[1];
				var planDate = dateArray[2];
				var endDate = dateArray[3];
				var curDate = dateArray[0];
				endDate.setDate(endDate.getDate()+5);
				if(flag=="入职"){
					if (selDate >= curDate&& selDate<=planDate) {
						$(".entryDate").valid();
					} else {
						$(".entryDate").val("");
						$(".entryDate").valid();
					}
				}else{
					if (selDate >= lastDate&& selDate<=endDate) {
						$(".entryDate").valid();
					} else {
						$(".entryDate").val("");
						$(".entryDate").valid();
					}
				}
		}
	});
