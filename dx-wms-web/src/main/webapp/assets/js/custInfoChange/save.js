
function doChangeCloseDiv(){
	$('#createCustBaseDiv').modal('hide');
}
//通过身份证返回出生日期
$("#idCardNum").blur(function() {
	if($("#idCardNum").val()!=''  && $("#idType").val() == 1){
		var custInfoCheckVo = {};
		custInfoCheckVo.idCard = $("#idCardNum").val();
		$.ajax({
			url : base + '/common/change_birthday.json',// 请求url
			type : "POST",
			async : false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(custInfoCheckVo),
			timeout : 30000,
			success : function(data) {
				if($("#idType").val()==1 ){
            		var idCard = $("#idCardNum").val();
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

////校验电话号码是否存在
//var flag = true;
//function checkMobileNum(){
//	if($("#mobileNum").val()!='' && $("#mobileNum").val()!=mobile ){
//		var custInfoCheckVo = {};
//		if($("#custId").val()>0){
//			custInfoCheckVo.custId = $("#custId").val();
//		}
//		custInfoCheckVo.mobile = $("#mobileNum").val();
//		$.ajax({
//			url : base + '/common/check_custInfo.json',// 请求url
//			type : "POST",
//			async : false,
//			dataType : "json",
//			contentType : "application/json",
//			data : JSON.stringify(custInfoCheckVo),
//			timeout : 30000,
//			success : function(data) {
//				if(!data){
//					$("#mobileNum").val('');
//					$.dopAlert("移动电话重复");
//					flag =false;
//				}
//			},
//			error : function(data) {
//				$.dopAlert("校验申请审核异常");
//			}
//		});
//	}
//}
//
//function checkIdCardNum(){
//	var flag = true;
//	if($("#idCardNum").val()==varIdCard){
//		flag = true;
//	}
//	if($("#idCardNum").val()!='' && $("#idCardNum").val()!=varIdCard){
//		if($("#idType").val()==4 && $("#idCardNum").val()!=""){
//			var idCard = $("#idCardNum").val();
//			var rex = /^[HM]{1}\d{10}$/;
//			if(rex.test(idCard)) {
//			}else {
//				//$.dopAlert("港澳居民往来大陆通行证号码不符合规范");
//				return;
//			}
//		}
//		
//		if($("#idType").val()==1 && $("#idCardNum").val().indexOf("x") >0){
//			return false;
//		}
//		var custInfoCheckVo = {};
//		custInfoCheckVo.idCard = $("#idCardNum").val();
//		$.ajax({
//			url : base + '/common/check_custInfo.json',// 请求url
//			type : "POST",
//			async : false,
//			dataType : "json",
//			contentType : "application/json",
//			data : JSON.stringify(custInfoCheckVo),
//			timeout : 30000,
//			success : function(data) {
//				if(!data){
//					$("#idCardNum").val('');
//					$.dopAlert("证件号码重复");
//					flag = false;
//				}
//			},
//			error : function(data) {
//				$.dopAlert("校验申请审核异常");
//			}
//		});
//	}
//	return flag;
//}

//验证证件号码是否重复
function checkIdCardNum(){
	var flag = true;
	var custInfoCheckVo = {};
	custInfoCheckVo.custId = $("#custId").val();
	custInfoCheckVo.idCard = $("#idCardNum").val();
	 $.ajax({
			url : base + '/common/check_custInfo.json',// 请求url
			type : "POST",
			async : false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(custInfoCheckVo),
			timeout : 30000,
			success : function(data) {
				if(!data){
					$.dopAlert("证件号码重复");
				}
				flag = data;
				},
				error: function(data){
					$.dopAlert("校验申请审核异常");
				}
			});
	 return flag ;
}

////验证手机号码是否重复
function checkMobileNum(){
	var flag = true;
	var custInfoCheckVo = {};
	custInfoCheckVo.custId = $("#custId").val();
	custInfoCheckVo.mobile = $("#mobileNum").val();
	$.ajax({
		url : base + '/common/check_custInfo.json',// 请求url
		type : "POST",
		async : false,
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(custInfoCheckVo),
		timeout : 30000,
		success : function(data) {
			if(!data){
				$("#saveChange").removeAttr("disabled","disabled");
				$.dopAlert("移动电话重复");
			}
			flag = data;
			},
			error: function(data){
				$("#saveChange").removeAttr("disabled","disabled");
				$.dopAlert("校验申请审核异常");
			}
		});
	return flag;
}



//保存
function doSaveChange() {
	$("#saveChange").attr("disabled","disabled");
	var form = $('#submit_form');
	if (form.valid() == false) {
		return false;
	}
	if(!checkMobileNum()||!checkIdCardNum()){
		$('.alert-success').hide();
		$('.alert-error').show();
		return false;
	}
	$('.alert-error').hide();
	$('.alert-success').show();
	if(!flag){
		return false;
	}
	//紧急联系人手机和固定电话选择其一
	$("#selectOne").html("");
	if(isEmptyString($("#linkmanMobile").val()) && (isEmptyString($("#linkmanAreaCode").val()) || isEmptyString($("#linkmanTelNum").val()))){
		$("#selectOne").html("移动电话或固定电话选填一个");
		return false;
	}
		var custAccountApplyVo = getChangeCustAccountApplyVo();
		 $.dopConfirm("是否确定保存？",null,function(r){
			  if(r){
				  $.ajax({
						url : base + '/infoChange/custInfo_save.json',// 请求url
						type : "POST",
						async : false,
						dataType : "json",
						contentType : "application/json",
						data : JSON.stringify(custAccountApplyVo),
						timeout : 30000,
						success : function(data) {
								if(data.code){
									TableManaged.fnDraw();
									$.dopAlert("保存成功");
									$('#createCustBaseDiv').modal('hide')
									
								}else {
									$("#saveChange").removeAttr("disabled","disabled");
									$.dopAlert(data.msg);
									if(data.msg=="您填写的手机号码重复"){
										$("#mobile").val("");
									}else{
										$("#idCardNum").val("");
									}
								}
							},
							error: function(data){
								$("#saveChange").removeAttr("disabled","disabled");
								$.dopAlert("保存出现异常,请重试");
								
							}
						});
					
			  }
			  $("#saveChange").removeAttr("disabled","disabled");
			 });
		 
	
}
function isEmptyString(str){
	if(str == null || $.trim(str) == "" || $.trim(str) == "null"){
		return true;
	}
	return false;
}
$(function(){
	mobile = $("#mobileNum").val();
	varIdCard = $("#idCardNum").val();
	$("#custName").attr("maxlength", 20);
	$("#mobileNum").attr("maxlength", 11);
	sourPermanentCity = $("#cityRegionCode option[value='" + $("#cityRegionCode").attr("source_val") + "']").text();
	sourPermanentDistrict = $("#districtRegionCode option[value='" + $("#districtRegionCode").attr("source_val") + "']").text();

	if($("#idType").val() == "-1") {
		$("#idCardNum").attr("disabled","disabled");
	}
	$("#idType").change(function(){
		if(this.value == "-1") {
			$("#idCardNum").attr("disabled","disabled").val("");
		} else {
			$("#idCardNum").removeAttr("disabled");
		}
	});	
});
function getChangeCustAccountApplyVo(){
	var custAccountApplyVo = {};
	var logs = [];
	custAccountApplyVo.custAccount = getChangeCustAccount(logs);
	custAccountApplyVo.custProfession = getChangeCustProfession(logs);
	custAccountApplyVo.custComm=getChangeCustComm(logs);
	custAccountApplyVo.custLinkman=getChangeCustLinkman(logs);
	custAccountApplyVo.logs = logs;
	return custAccountApplyVo;
}
function getChangeCustAccount(logs){
	var custAccount={};
	custAccount.custAccountId=$("#custAccountId").val();
	custAccount.lenderCustCode=$("#customerId").val();
	custAccount.custCode=$("#custCode").val();
	custAccount.custName=$("#custName").val();
	if($("#custName").val()!=$("#custName").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_account SET cust_name ='"+$("#custName").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'cust_name';
		logJsonDto.columnNameChs = '姓名';
		logJsonDto.sourceValueEng = $("#custName").attr("source_val");
		logJsonDto.sourceValueChs = $("#custName").attr("source_val");
		logJsonDto.updateValueEng = $("#custName").val();
		logJsonDto.updateValueChs = $("#custName").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_account';
		logJsonDto.tableNameChs = '客户账户表';
		logJsonDto.tablePkId = $("#custAccountId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custAccount.custNameSpell = $("#custNameSpell").val();
	if($("#custNameSpell").val()!=$("#custNameSpell").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_account SET cust_name_spell ='"+$("#custNameSpell").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'cust_name_spell';
		logJsonDto.columnNameChs = '姓名拼音';
		logJsonDto.sourceValueEng = $("#custNameSpell").attr("source_val");
		logJsonDto.sourceValueChs = $("#custNameSpell").attr("source_val");
		logJsonDto.updateValueEng = $("#custNameSpell").val();
		logJsonDto.updateValueChs = $("#custNameSpell").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_account';
		logJsonDto.tableNameChs = '客户账户表';
		logJsonDto.tablePkId = $("#custAccountId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	if($("#sex").val()!='-1'){
		custAccount.sex=$("#sex").val();
	}
	
	if($("#sex").val()!=$("#sex").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_account SET sex ='"+$("#sex").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'sex';
		logJsonDto.columnNameChs = '性别';
		logJsonDto.sourceValueEng = $("#sex").attr("source_val");
		logJsonDto.sourceValueChs = $("#sex option[value='"+$("#sex").attr("source_val")+"']").text();
		logJsonDto.updateValueEng = $("#sex").val();
		logJsonDto.updateValueChs = $("#sex option[value='"+$("#sex").val()+"']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_account';
		logJsonDto.tableNameChs = '客户账户表';
		logJsonDto.tablePkId = $("#custAccountId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custAccount.nationality=$("#nationality").val();
	if($("#maritalStatus").val()!='-1'){
		custAccount.maritalStatus=$("#maritalStatus").val();
		if($("#maritalStatus").val()!=$("#maritalStatus").attr("source_val")){
			var log = {};
			log.tableName = 't_cust_account';
			log.pkId = $("#custAccountId").val();
			log.dbSql = "UPDATE t_cust_account SET marital_status ='"+$("#maritalStatus").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
			var logJsonDto = {};
			logJsonDto.columnNameEng = 'marital_status';
			logJsonDto.columnNameChs = '婚姻';
			logJsonDto.sourceValueEng = $("#maritalStatus").attr("source_val");
			logJsonDto.sourceValueChs = $("#maritalStatus option[value='"+$("#maritalStatus").attr("source_val")+"']").text();
			logJsonDto.updateValueEng = $("#maritalStatus").val();
			logJsonDto.updateValueChs = $("#maritalStatus option[value='"+$("#maritalStatus").val()+"']").text();
			logJsonDto.checkStep = $("#checkStep").val();
			logJsonDto.tableNameEng = 't_cust_account';
			logJsonDto.tableNameChs = '客户账户表';
			logJsonDto.tablePkId = $("#custAccountId").val();
			log.logJsonDto = logJsonDto;
			logs.push(log);
		}
	}
	
	
	custAccount.commonLanguage=1;
	if($("#idType").val()!='-1'){
		custAccount.idType=$("#idType").val();
	}
	
	if($("#idType").val()!=$("#idType").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_account SET id_type ='"+$("#idType").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'id_type';
		logJsonDto.columnNameChs = '证件类型';
		logJsonDto.sourceValueEng = $("#idType").attr("source_val");
		logJsonDto.sourceValueChs = $("#idType option[value='"+$("#idType").attr("source_val")+"']").text();
		logJsonDto.updateValueEng = $("#idType").val();
		logJsonDto.updateValueChs = $("#idType option[value='"+$("#idType").val()+"']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_account';
		logJsonDto.tableNameChs = '客户账户表';
		logJsonDto.tablePkId = $("#custAccountId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custAccount.idCard=$("#idCardNum").val();
	if($("#idCardNum").val()!=$("#idCardNum").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_account SET id_card ='"+$("#idCardNum").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'id_card';
		logJsonDto.columnNameChs = '证件号码';
		logJsonDto.sourceValueEng = $("#idCardNum").attr("source_val");
		logJsonDto.sourceValueChs = $("#idCardNum").attr("source_val");
		logJsonDto.updateValueEng = $("#idCardNum").val();
		logJsonDto.updateValueChs = $("#idCardNum").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_account';
		logJsonDto.tableNameChs = '客户账户表';
		logJsonDto.tablePkId = $("#custAccountId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custAccount.birthDate=$("#birthDate").val();
	if($("#birthDate").val()!=$("#birthDate").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_account SET birth_date ='"+$("#birthDate").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'birth_date';
		logJsonDto.columnNameChs = '出生日期';
		logJsonDto.sourceValueEng = $("#birthDate").attr("source_val");
		logJsonDto.sourceValueChs = $("#birthDate").attr("source_val");
		logJsonDto.updateValueEng = $("#birthDate").val();
		logJsonDto.updateValueChs = $("#birthDate").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_account';
		logJsonDto.tableNameChs = '客户账户表';
		logJsonDto.tablePkId = $("#custAccountId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custAccount.mobile=$("#mobileNum").val();
	if($("#mobileNum").val()!=$("#mobileNum").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_account SET mobile ='"+$("#mobileNum").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'mobile';
		logJsonDto.columnNameChs = '移动电话';
		logJsonDto.sourceValueEng = $("#mobileNum").attr("source_val");
		logJsonDto.sourceValueChs = $("#mobileNum").attr("source_val");
		logJsonDto.updateValueEng = $("#mobileNum").val();
		logJsonDto.updateValueChs = $("#mobileNum").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_account';
		logJsonDto.tableNameChs = '客户账户表';
		logJsonDto.tablePkId = $("#custAccountId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	
	if($("#education").val()!='-1'){
		custAccount.education=$("#education").val();
		if($("#education").val()!=$("#education").attr("source_val")){
			var log = {};
			log.tableName = 't_cust_account';
			log.pkId = $("#custAccountId").val();
			log.dbSql = "UPDATE t_cust_account SET education ='"+$("#education").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
			var logJsonDto = {};
			logJsonDto.columnNameEng = 'education';
			logJsonDto.columnNameChs = '最高学历';
			logJsonDto.sourceValueEng = $("#education").attr("source_val");
			logJsonDto.sourceValueChs = $("#education option[value='"+$("#education").attr("source_val")+"']").text();
			logJsonDto.updateValueEng = $("#education").val();
			logJsonDto.updateValueChs = $("#education option[value='"+$("#education").val()+"']").text();
			logJsonDto.checkStep = $("#checkStep").val();
			logJsonDto.tableNameEng = 't_cust_account';
			logJsonDto.tableNameChs = '客户账户表';
			logJsonDto.tablePkId = $("#custAccountId").val();
			log.logJsonDto = logJsonDto;
			logs.push(log);
		}
	}
	
	
	if($("#msgWay").val()!='-1'){
		custAccount.msgWay=$("#msgWay").val();
	}
	if($("#msgWay").val()!=$("#msgWay").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_account SET msg_way ='"+$("#msgWay").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'msg_way';
		logJsonDto.columnNameChs = '接受文件方式';
		logJsonDto.sourceValueEng = $("#msgWay").attr("source_val");
		logJsonDto.sourceValueChs = $("#msgWay option[value='"+$("#msgWay").attr("source_val")+"']").text();
		logJsonDto.updateValueEng = $("#msgWay").val();
		logJsonDto.updateValueChs = $("#msgWay option[value='"+$("#msgWay").val()+"']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_account';
		logJsonDto.tableNameChs = '客户账户表';
		logJsonDto.tablePkId = $("#custAccountId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custAccount.openDate=$("#openDate").val();
	if($("#openDate").val()!=$("#openDate").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_account SET open_date ='"+$("#openDate").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'open_date';
		logJsonDto.columnNameChs = '开户日期';
		logJsonDto.sourceValueEng = $("#openDate").attr("source_val");
		logJsonDto.sourceValueChs = $("#openDate").attr("source_val");
		logJsonDto.updateValueEng = $("#openDate").val();
		logJsonDto.updateValueChs = $("#openDate").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_account';
		logJsonDto.tableNameChs = '客户账户表';
		logJsonDto.tablePkId = $("#custAccountId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	
	if($("#custSource").val()!='-1'){
		custAccount.custSource=$("#custSource").val();
	}
	
	if($("#custSource").val()!=$("#custSource").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_account SET cust_source ='"+$("#custSource").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'cust_source';
		logJsonDto.columnNameChs = '客户来源';
		logJsonDto.sourceValueEng = $("#custSource").attr("source_val");
		logJsonDto.sourceValueChs = $("#custSource option[value='"+$("#custSource").attr("source_val")+"']").text();
		logJsonDto.updateValueEng = $("#custSource").val();
		logJsonDto.updateValueChs = $("#custSource option[value='"+$("#custSource").val()+"']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_account';
		logJsonDto.tableNameChs = '客户账户表';
		logJsonDto.tablePkId = $("#custAccountId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	
	if($("#custSource").val()=='20'){
		custAccount.custSourceOther=$("#custSourceOther").val();
	}
	
	if($("#custSourceOther").val()!=$("#custSourceOther").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_account SET cust_source_other ='"+$("#custSourceOther").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'cust_source_other';
		logJsonDto.columnNameChs = '客户来源-其他';
		logJsonDto.sourceValueEng = $("#custSourceOther").attr("source_val");
		logJsonDto.sourceValueChs = $("#custSourceOther").attr("source_val");
		logJsonDto.updateValueEng = $("#custSourceOther").val();
		logJsonDto.updateValueChs = $("#custSourceOther").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_account';
		logJsonDto.tableNameChs = '客户账户表';
		logJsonDto.tablePkId = $("#custAccountId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	
	
	if($("#custCategory").val()!='-1'){
		custAccount.custCategory=$("#custCategory").val();
	}
	if($("#custCategory").val()!=$("#custCategory").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_account SET cust_category ='"+$("#custCategory").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'cust_category';
		logJsonDto.columnNameChs = '客户分类';
		logJsonDto.sourceValueEng = $("#custCategory").attr("source_val");
		logJsonDto.sourceValueChs = $("#custCategory option[value='"+$("#custCategory").attr("source_val")+"']").text();
		logJsonDto.updateValueEng = $("#custCategory").val();
		logJsonDto.updateValueChs = $("#custCategory option[value='"+$("#custCategory").val()+"']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_account';
		logJsonDto.tableNameChs = '客户账户表';
		logJsonDto.tablePkId = $("#custAccountId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	return custAccount;
}
function getChangeCustProfession(logs){
	var custProfession={};
	custProfession.custProfessionId=$("#custProfessionId").val();
	custProfession.custAccountId=$("#custAccountId").val();
	
	if($("#profession").val()!='-1'){
		custProfession.profession=$("#profession").val();
		if($("#profession").val()!=$("#profession").attr("source_val")){
			var log = {};
			log.tableName = 't_cust_account';
			log.pkId = $("#custAccountId").val();
			log.dbSql = "UPDATE t_cust_profession SET profession ='"+$("#profession").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
			var logJsonDto = {};
			logJsonDto.columnNameEng = 'profession';
			logJsonDto.columnNameChs = '职业';
			logJsonDto.sourceValueEng = $("#profession").attr("source_val");
			logJsonDto.sourceValueChs = $("#profession option[value='"+$("#profession").attr("source_val")+"']").text();
			logJsonDto.updateValueEng = $("#profession").val();
			logJsonDto.updateValueChs = $("#profession option[value='"+$("#profession").val()+"']").text();
			logJsonDto.checkStep = $("#checkStep").val();
			logJsonDto.tableNameEng = 't_cust_profession';
			logJsonDto.tableNameChs = '客户职业表';
			logJsonDto.tablePkId = $("#custProfessionId").val();
			log.logJsonDto = logJsonDto;
			logs.push(log);
		}
	}
	
	custProfession.industry=$("#industry").val();
	if($("#industry").val()!=$("#industry").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_profession SET industry ='"+$("#industry").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'industry';
		logJsonDto.columnNameChs = '行业';
		logJsonDto.sourceValueEng = $("#industry").attr("source_val");
		logJsonDto.sourceValueChs = $("#industry").attr("source_val");
		logJsonDto.updateValueEng = $("#industry").val();
		logJsonDto.updateValueChs = $("#industry").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_profession';
		logJsonDto.tableNameChs = '客户职业表';
		logJsonDto.tablePkId = $("#custProfessionId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custProfession.companyName=$("#companyName").val();
	if($("#companyName").val()!=$("#companyName").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_profession SET company_name ='"+$("#companyName").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'company_name';
		logJsonDto.columnNameChs = '单位名称';
		logJsonDto.sourceValueEng = $("#companyName").attr("source_val");
		logJsonDto.sourceValueChs = $("#companyName").attr("source_val");
		logJsonDto.updateValueEng = $("#companyName").val();
		logJsonDto.updateValueChs = $("#companyName").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_profession';
		logJsonDto.tableNameChs = '客户职业表';
		logJsonDto.tablePkId = $("#custProfessionId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custProfession.post=$("#post").val();
	if($("#post").val()!=$("#post").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_profession SET post ='"+$("#companyName").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'post';
		logJsonDto.columnNameChs = '职位';
		logJsonDto.sourceValueEng = $("#post").attr("source_val");
		logJsonDto.sourceValueChs = $("#post").attr("source_val");
		logJsonDto.updateValueEng = $("#post").val();
		logJsonDto.updateValueChs = $("#post").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_profession';
		logJsonDto.tableNameChs = '客户职业表';
		logJsonDto.tablePkId = $("#custProfessionId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	return custProfession;
}
function getChangeCustComm(logs){
	var custComm = {};
	custComm.custCommId=$("#custCommId").val();
	custComm.custAccountId=$("#custAccountId").val();
	
	if($("#provinceRegionCode").val()!='-1'){
		custComm.provinceRegionCode= $("#provinceRegionCode").val();
	}
	if($("#provinceRegionCode").val()!=$("#provinceRegionCode").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_comm SET province_region_code ='"+$("#provinceRegionCode").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'province_region_code';
		logJsonDto.columnNameChs = '通讯地址-省';
		logJsonDto.sourceValueEng = $("#provinceRegionCode").attr("source_val");
		logJsonDto.sourceValueChs = $("#provinceRegionCode option[value='"+$("#provinceRegionCode").attr("source_val")+"']").text();
		logJsonDto.updateValueEng = $("#provinceRegionCode").val();
		logJsonDto.updateValueChs = $("#provinceRegionCode option[value='"+$("#provinceRegionCode").val()+"']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_comm';
		logJsonDto.tableNameChs = '客户通讯表';
		logJsonDto.tablePkId = $("#custCommId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	
	if($("#cityRegionCode").val()!='-1'){
		custComm.cityRegionCode= $("#cityRegionCode").val();
	}
	if($("#cityRegionCode").val()!=$("#cityRegionCode").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_comm SET city_region_code ='"+$("#cityRegionCode").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'city_region_code';
		logJsonDto.columnNameChs = '通讯地址-市';
		logJsonDto.sourceValueEng = $("#cityRegionCode").attr("source_val");
		logJsonDto.sourceValueChs = sourPermanentCity;
		logJsonDto.updateValueEng = $("#cityRegionCode").val();
		logJsonDto.updateValueChs = $("#cityRegionCode option[value='"+$("#cityRegionCode").val()+"']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_comm';
		logJsonDto.tableNameChs = '客户通讯表';
		logJsonDto.tablePkId = $("#custCommId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	
	if($("#districtRegionCode").val()!='-1'){
		custComm.districtRegionCode= $("#districtRegionCode").val();
	}
	if($("#districtRegionCode").val()!=$("#districtRegionCode").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_comm SET district_region_code ='"+$("#cityRegionCode").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'district_region_code';
		logJsonDto.columnNameChs = '通讯地址-区';
		logJsonDto.sourceValueEng = $("#districtRegionCode").attr("source_val");
		logJsonDto.sourceValueChs = sourPermanentDistrict;
		logJsonDto.updateValueEng = $("#cityRegionCode").val();
		logJsonDto.updateValueChs = $("#districtRegionCode option[value='"+$("#districtRegionCode").val()+"']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_comm';
		logJsonDto.tableNameChs = '客户通讯表';
		logJsonDto.tablePkId = $("#custCommId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custComm.streetInfo= $("#streetInfo").val();
	if($("#streetInfo").val()!=$("#streetInfo").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_comm SET street_info ='"+$("#provinceRegionCode").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'street_info';
		logJsonDto.columnNameChs = '通讯地址-街道';
		logJsonDto.sourceValueEng = $("#streetInfo").attr("source_val");
		logJsonDto.sourceValueChs = $("#streetInfo").attr("source_val");
		logJsonDto.updateValueEng = $("#streetInfo").val();
		logJsonDto.updateValueChs = $("#streetInfo").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_comm';
		logJsonDto.tableNameChs = '客户通讯表';
		logJsonDto.tablePkId = $("#custCommId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custComm.zipCode= $("#zipCode").val();
	if($("#zipCode").val()!=$("#zipCode").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_comm SET zip_code ='"+$("#zipCode").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'zip_code';
		logJsonDto.columnNameChs = '邮政编码';
		logJsonDto.sourceValueEng = $("#zipCode").attr("source_val");
		logJsonDto.sourceValueChs = $("#zipCode").attr("source_val");
		logJsonDto.updateValueEng = $("#zipCode").val();
		logJsonDto.updateValueChs = $("#zipCode").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_comm';
		logJsonDto.tableNameChs = '客户通讯表';
		logJsonDto.tablePkId = $("#custCommId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custComm.areaCode= $("#areaCode").val();
	if($("#areaCode").val()!=$("#areaCode").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_comm SET area_code ='"+$("#areaCode").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'area_code';
		logJsonDto.columnNameChs = '固定电话-区号';
		logJsonDto.sourceValueEng = $("#areaCode").attr("source_val");
		logJsonDto.sourceValueChs = $("#areaCode").attr("source_val");
		logJsonDto.updateValueEng = $("#areaCode").val();
		logJsonDto.updateValueChs = $("#areaCode").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_comm';
		logJsonDto.tableNameChs = '客户通讯表';
		logJsonDto.tablePkId = $("#custCommId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custComm.telNum= $("#telNum").val();
	if($("#telNum").val()!=$("#telNum").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_comm SET tel_num ='"+$("#telNum").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'tel_num';
		logJsonDto.columnNameChs = '固定电话-号码';
		logJsonDto.sourceValueEng = $("#telNum").attr("source_val");
		logJsonDto.sourceValueChs = $("#telNum").attr("source_val");
		logJsonDto.updateValueEng = $("#telNum").val();
		logJsonDto.updateValueChs = $("#telNum").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_comm';
		logJsonDto.tableNameChs = '客户通讯表';
		logJsonDto.tablePkId = $("#custCommId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custComm.email= $("#email").val();
	if($("#email").val()!=$("#email").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_comm SET email ='"+$("#email").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'email';
		logJsonDto.columnNameChs = '邮箱';
		logJsonDto.sourceValueEng = $("#email").attr("source_val");
		logJsonDto.sourceValueChs = $("#email").attr("source_val");
		logJsonDto.updateValueEng = $("#email").val();
		logJsonDto.updateValueChs = $("#email").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_comm';
		logJsonDto.tableNameChs = '客户通讯表';
		logJsonDto.tablePkId = $("#custCommId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custComm.wechat = $("#wechat").val();
	if($("#wechat").val()!=$("#wechat").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_comm SET wechat ='"+$("#wechat").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'wechat';
		logJsonDto.columnNameChs = '微信';
		logJsonDto.sourceValueEng = $("#wechat").attr("source_val");
		logJsonDto.sourceValueChs = $("#wechat").attr("source_val");
		logJsonDto.updateValueEng = $("#wechat").val();
		logJsonDto.updateValueChs = $("#wechat").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_comm';
		logJsonDto.tableNameChs = '客户通讯表';
		logJsonDto.tablePkId = $("#custCommId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	return custComm;
}
function getChangeCustLinkman(logs){
	var custLinkman = {};
	custLinkman.custLinkmanId = $("#custLinkmanId").val();
	custLinkman.custAccountId = $("#custAccountId").val();
	custLinkman.linkmanName = $("#linkmanName").val();
	if($("#linkmanName").val()!=$("#linkmanName").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_linkman SET linkman_name ='"+$("#linkmanName").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'linkman_name';
		logJsonDto.columnNameChs = '紧急联系人';
		logJsonDto.sourceValueEng = $("#linkmanName").attr("source_val");
		logJsonDto.sourceValueChs = $("#linkmanName").attr("source_val");
		logJsonDto.updateValueEng = $("#linkmanName").val();
		logJsonDto.updateValueChs = $("#linkmanName").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_linkman';
		logJsonDto.tableNameChs = '客户联系人表';
		logJsonDto.tablePkId = $("#custLinkmanId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custLinkman.linkmanNameSpell = $("#linkmanNameSpell").val();
	if($("#linkmanNameSpell").val()!=$("#linkmanNameSpell").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_linkman SET linkman_name_spell ='"+$("#linkmanNameSpell").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'linkman_name_spell';
		logJsonDto.columnNameChs = '紧急联系人拼音';
		logJsonDto.sourceValueEng = $("#linkmanNameSpell").attr("source_val");
		logJsonDto.sourceValueChs = $("#linkmanNameSpell").attr("source_val");
		logJsonDto.updateValueEng = $("#linkmanNameSpell").val();
		logJsonDto.updateValueChs = $("#linkmanNameSpell").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_linkman';
		logJsonDto.tableNameChs = '客户联系人表';
		logJsonDto.tablePkId = $("#custLinkmanId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	
	if($("#linkmanSex").val()!='-1'){
		custLinkman.linkmanSex = $("#linkmanSex").val();
	}
	if($("#linkmanSex").val()!=$("#linkmanSex").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_linkman SET linkman_sex ='"+$("#linkmanSex").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'linkman_sex';
		logJsonDto.columnNameChs = '紧急联系人性别';
		logJsonDto.sourceValueEng = $("#linkmanSex").attr("source_val");
		logJsonDto.sourceValueChs = $("#linkmanSex option[value='"+$("#linkmanSex").attr("source_val")+"']").text();
		logJsonDto.updateValueEng = $("#linkmanSex").val();
		logJsonDto.updateValueChs = $("#linkmanSex option[value='"+$("#linkmanSex").val()+"']").text();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_linkman';
		logJsonDto.tableNameChs = '客户联系人表';
		logJsonDto.tablePkId = $("#custLinkmanId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custLinkman.linkmanRelation = $("#linkmanRelation").val();
	if($("#linkmanRelation").val()!=$("#linkmanRelation").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_linkman SET linkman_relation ='"+$("#linkmanRelation").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'linkman_relation';
		logJsonDto.columnNameChs = '与紧急联系人关系';
		logJsonDto.sourceValueEng = $("#linkmanRelation").attr("source_val");
		logJsonDto.sourceValueChs = $("#linkmanRelation").attr("source_val");
		logJsonDto.updateValueEng = $("#linkmanRelation").val();
		logJsonDto.updateValueChs = $("#linkmanRelation").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_linkman';
		logJsonDto.tableNameChs = '客户联系人表';
		logJsonDto.tablePkId = $("#custLinkmanId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	
	if($("#linkmanIdType").val()!='-1'){
		custLinkman.linkmanIdType = $("#linkmanIdType").val();
		if($("#linkmanIdType").val()!=$("#linkmanIdType").attr("source_val")){
			var log = {};
			log.tableName = 't_cust_account';
			log.pkId = $("#custAccountId").val();
			log.dbSql = "UPDATE t_cust_linkman SET linkman_id_type ='"+$("#linkmanIdType").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
			var logJsonDto = {};
			logJsonDto.columnNameEng = 'linkman_id_type';
			logJsonDto.columnNameChs = '紧急联系人证件';
			logJsonDto.sourceValueEng = $("#linkmanIdType").attr("source_val");
			logJsonDto.sourceValueChs = $("#linkmanIdType option[value='"+$("#linkmanIdType").attr("source_val")+"']").text();
			logJsonDto.updateValueEng = $("#linkmanIdType").val();
			logJsonDto.updateValueChs = $("#linkmanIdType option[value='"+$("#linkmanIdType").val()+"']").text();;
			logJsonDto.checkStep = $("#checkStep").val();
			logJsonDto.tableNameEng = 't_cust_linkman';
			logJsonDto.tableNameChs = '客户联系人表';
			logJsonDto.tablePkId = $("#custLinkmanId").val();
			log.logJsonDto = logJsonDto;
			logs.push(log);
		}
	}
	
	custLinkman.linkmanIdCard = $("#linkmanIdCard").val();
	if($("#linkmanIdCard").val()!=$("#linkmanIdCard").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_linkman SET linkman_id_card ='"+$("#linkmanIdCard").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'linkman_id_card';
		logJsonDto.columnNameChs = '紧急联系人证件号码';
		logJsonDto.sourceValueEng = $("#linkmanIdCard").attr("source_val");
		logJsonDto.sourceValueChs = $("#linkmanIdCard").attr("source_val");
		logJsonDto.updateValueEng = $("#linkmanIdCard").val();
		logJsonDto.updateValueChs = $("#linkmanIdCard").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_linkman';
		logJsonDto.tableNameChs = '客户联系人表';
		logJsonDto.tablePkId = $("#custLinkmanId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custLinkman.linkmanMobile = $("#linkmanMobile").val();
	if($("#linkmanMobile").val()!=$("#linkmanMobile").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_linkman SET linkman_mobile ='"+$("#linkmanMobile").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'linkman_mobile';
		logJsonDto.columnNameChs = '紧急联系人移动电话';
		logJsonDto.sourceValueEng = $("#linkmanMobile").attr("source_val");
		logJsonDto.sourceValueChs = $("#linkmanMobile").attr("source_val");
		logJsonDto.updateValueEng = $("#linkmanMobile").val();
		logJsonDto.updateValueChs = $("#linkmanMobile").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_linkman';
		logJsonDto.tableNameChs = '客户联系人表';
		logJsonDto.tablePkId = $("#custLinkmanId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custLinkman.areaCode = $("#linkmanAreaCode").val();
	if($("#linkmanAreaCode").val()!= $("#linkmanAreaCode").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_linkman SET area_code ='"+$("#linkmanAreaCode").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'area_code';
		logJsonDto.columnNameChs = '紧急联系人固定电话-区号';
		logJsonDto.sourceValueEng = $("#linkmanAreaCode").attr("source_val");
		logJsonDto.sourceValueChs = $("#linkmanAreaCode").attr("source_val");
		logJsonDto.updateValueEng = $("#linkmanAreaCode").val();
		logJsonDto.updateValueChs = $("#linkmanAreaCode").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_linkman';
		logJsonDto.tableNameChs = '客户联系人表';
		logJsonDto.tablePkId = $("#custLinkmanId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	custLinkman.telNum = $("#linkmanTelNum").val();
	if($("#linkmanTelNum").val()!=$("#linkmanTelNum").attr("source_val")){
		var log = {};
		log.tableName = 't_cust_account';
		log.pkId = $("#custAccountId").val();
		log.dbSql = "UPDATE t_cust_linkman SET tel_num ='"+$("#linkmanTelNum").val()+"' WHERE cust_account_id ="+$("#custAccountId").val();
		var logJsonDto = {};
		logJsonDto.columnNameEng = 'tel_num';
		logJsonDto.columnNameChs = '紧急联系人固定电话-号码';
		logJsonDto.sourceValueEng = $("#linkmanTelNum").attr("source_val");
		logJsonDto.sourceValueChs = $("#linkmanTelNum").attr("source_val");
		logJsonDto.updateValueEng = $("#linkmanTelNum").val();
		logJsonDto.updateValueChs = $("#linkmanTelNum").val();
		logJsonDto.checkStep = $("#checkStep").val();
		logJsonDto.tableNameEng = 't_cust_linkman';
		logJsonDto.tableNameChs = '客户联系人表';
		logJsonDto.tablePkId = $("#custLinkmanId").val();
		log.logJsonDto = logJsonDto;
		logs.push(log);
	}
	return custLinkman;
}

