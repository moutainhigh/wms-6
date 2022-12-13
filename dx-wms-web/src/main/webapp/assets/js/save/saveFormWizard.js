
var FormWizard = function() {
	
	return {
		// main function to initiate the module
		init : function() {
			if (!jQuery().bootstrapWizard) {
				return;
			}
			function format(state) {
				if (!state.id)
					return state.text; // optgroup
				return "<img class='flag' src='assets/image/flags/" + state.id.toLowerCase() + ".png'/>&nbsp;&nbsp;" + state.text;
			}
			var form = $('#save_form');
			var error = $('.alert-error', form);
			var success = $('.alert-success', form);
			// 校验
			// 公用
			jQuery.validator.addMethod("checkProvince", function(value, element) {
				if (value <= 0) {
					return false;
				}
				return true;
			}, "请选择所在省.");

			jQuery.validator.addMethod("checkCity", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请选择所在市.");

			jQuery.validator.addMethod("checkDistrict", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请选择所在区县.");
			jQuery.validator.addMethod("checkStreetInfo", function(value, element) {
				var reg1 = /^[0-9]*$/;
				var reg2 = /^\s*$/;
				if (reg1.test(value.replace(/\s+/g, "")) || reg2.test(value)) {
					return false;
				}
				return true;
			}, "街道信息不能为空或纯数字.");
			jQuery.validator.addMethod("checkCustSourceOther", function(value, element) {
				if (value == '') {
					return false;
				}
				return true;
			}, "客户其他来源不能为空");
			jQuery.validator.addMethod("checkZip", function(value, element) {
				// 邮编
				var reg = /^[0-9][0-9]{5}$/;
				if (reg.test(value)) {
					return true;
				}
				return false;
			}, "邮编不符合规范.");
			// 银行
			var bankMsg = '请选择银行.';
			jQuery.validator.addMethod("checkBankCategory", function(value, element) {
				if (value == '-1') {
					return false;
				}
//				if( $(element).attr("name") == "payBankCategory" && $("#payWayId").val() == 2 &&(value == 2 || value == 6 || value == 15 || value == 16)){
//					bankMsg = '当前平台不支持委托划扣.';
//					$.validator.messages.checkBankCategory = bankMsg;
//					return false;
//				}
				return true;
			}, bankMsg);
				
			// 合同编号
			jQuery.validator.addMethod("checkContractCode", function(value, element) {
				var reg = /^[D][X][F][0-9]{13}$/;
				if (!reg.test(value)) {
					return false;
				}
				return true;
			}, "合同编号为DXF大写字母+13位数字.");
			// 支行
			jQuery.validator.addMethod("checkOtherSubBank", function(value, element) {
				if (value != '-1') {
					var reg = /^[\u4E00-\u9FA5]+$/;
					if (reg.test(value)) {
						return true;
					}
					return false;
				}
			}, "支行不能为空，且必须为汉字.");
			// 支行
			jQuery.validator.addMethod("checkSubBank", function(value, element) {
				if (value!='-1') {
					return true;
				}
				
				return false;
				
			}, "请选择支行");
			
			// 户名
			jQuery.validator.addMethod("checkAccountName", function(value, element) {
				if (value != '') {
					var reg = /^[\u4E00-\u9FA5]+$/;
					if (reg.test(value)) {
						return true;
					}
					return false;
				}
			}, "户名不能为空，且必须为汉字.");
			
			// 账号
			jQuery.validator.addMethod("checkAccountNum", function(value, element) {
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
				return false;
			}, "输入账号有误.");

			//            
			// 个人信息
			// 客户姓名
			jQuery.validator.addMethod("checkCustName", function(value, element) {
				if (value != '') {
					var reg = /^[\u4E00-\u9FA5]+$/;
					if (reg.test(value)) {
						return true;
					}
					return false;
				}
			}, "姓名不能为空，且必须为汉字.");

			// 客户姓名拼音
			jQuery.validator.addMethod("checkCustNameSpell", function(value,element) {
				if (value != '') {
					var flag = true;
					var custInfoCheckVo = {};
					custInfoCheckVo.custName = $(element).parent().parent().prev().find("input").first().val();
					if (error.hide()==true) {
						$.ajax({
							url : base + '/common/check_spellName.json',// 请求url
							type : "POST",
							async : true,
							dataType : "json",
							contentType : "application/json",
							data : JSON.stringify(custInfoCheckVo),
							timeout : 30000,
							async: false,
							success : function(data) {
								if (data.custNameSpell != value) {
									flag = false;
								}
							},
							error : function(data) {
								$.dopAlert("获取名字拼音 异常 ");
							}
						});
					}
					if(!flag){
						return flag;
					}
					var reg = /^[A-Za-z]+$/;
					if (reg.test(value)) {
						return true;
					}
					return false;
				} else {
					return false;
				}
			}, "拼音必须与名字匹配!");

			// 性别
			jQuery.validator.addMethod("checkSex", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请选择性别.");

			// 证件类型
			jQuery.validator.addMethod("checkIdType", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请选择证件类型.");
			
			// 身份证号码验证
			jQuery.validator.addMethod("checkIdCard",function(value, element) {
				if ($("#idType").val() == 1) {
					var idCard = value;
					var Y, JYM;
					var S, M;
					var idcard_array = new Array();
					idcard_array = idCard.split("");
					var reg_18 = /^[1-9][0-7]\d{4}((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))\d{3}(\d|X)?$/;
					var reg_15 = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9]|[1|2]\d)|3[0-1])\d{3}$/;
					if (reg_15.test(idCard)) {
						return true;
					} else if (reg_18.test(idCard)) {
						if(idcard_array.length==17){
							return false;
						}
						// 计算校验位
						var S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
							  + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
							  + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
							  + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
							  + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
							  + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
							  + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
							  + parseInt(idcard_array[7]) * 1
							  + parseInt(idcard_array[8]) * 6
							  + parseInt(idcard_array[9]) * 3;
						Y = S % 11;
						M = "F";
						JYM = "10X98765432";
						M = JYM.substr(Y, 1);
						/* 判断校验位 */
						if (M == idcard_array[17].toUpperCase()) {
							return true;
							/* 检测ID的校验位false; */
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else if ($("#idType").val() == 2) {
					var rex = /^((G\d{8})|(P\.?\d{7})|((S\.?\d{7})|(S\d{8}))|((14|15)\d{7})|(E\d{8}))$/;
					if (rex.test(value)) {
						return true
					}
					return false;
				} else if ($("#idType").val() == 4) {
					var rex = /^[HM]{1}\d{10}$/;
					if (rex.test(value)) {
						return true
					}
					return false;
				} else if ($("#idType").val() == 3) {
					var reg = /^[\u4E00-\u9FA5]+$/;
					for (var i = 0; i < value.length; i++) {
						if (reg.test(value[i])) {
							return false;
						}
					}
					return true;
				}
			}, "证件号码不符合规范.");

			// 新增客户身份证号码验证
			jQuery.validator.addMethod("checkcustViewidCard", function(value, element) {
				if ($("#custViewidType").val() == 1) {
					var idCard = value;
					var Y, JYM;
					var S, M;
					var idcard_array = new Array();
					idcard_array = idCard.split("");
					var reg_18 = /^[1-9][0-7]\d{4}((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))\d{3}(\d|X)?$/;
					var reg_15 = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9]|[1|2]\d)|3[0-1])\d{3}$/;
					if (reg_15.test(idCard)) {
						return true;
					} else if (reg_18.test(idCard)) {
						// 计算校验位
						var S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
							  + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
							  + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
							  + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
							  + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
							  + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
							  + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
							  + parseInt(idcard_array[7]) * 1
							  + parseInt(idcard_array[8]) * 6
							  + parseInt(idcard_array[9]) * 3;
						Y = S % 11;
						M = "F";
						JYM = "10X98765432";
						M = JYM.substr(Y, 1);
						/* 判断校验位 */
						if (M == idcard_array[17].toUpperCase()) {
							return true;
							/* 检测ID的校验位false; */
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else if ($("#custViewidType").val() == 2) {
					var rex = /^((G\d{8})|(P\.?\d{7})|((S\.?\d{7})|(S\d{8}))|((14|15)\d{7})|(E\d{8}))$/;
					if (rex.test(value)) {
						return true
					}
					return false;
				} else if ($("#custViewidType").val() == 4) {
					var rex = /^[HM]{1}\d{10}$/;
					if (rex.test(value)) {
						return true
					}
					return false;
				} else if ($("#custViewidType").val() == 3) {
					var reg = /^[\u4E00-\u9FA5]+$/;
					for (var i = 0; i < value.length; i++) {
						if (reg.test(value[i])) {
							return false;
						}
					}
					return true;
				}
			}, "证件号码不符合规范.");

			// 联系人身份证号码验证
			jQuery.validator.addMethod("checkLinkmanIdCard", function(value, element) {
				
				if (value == '') {
					return true;
				} else {
					if ($("#linkmanIdType").val() == 1) {
						var idCard = $("#linkmanIdCard").val();
						var Y, JYM;
						var S, M;
						var idcard_array = new Array();
						idcard_array = idCard.split("");
						// console.log("len" + idcard_array.length);
						// var reg_18 =
						// /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;
						var reg_18 = /^[1-9][0-7]\d{4}((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))\d{3}(\d|X|x)?$/;
						var reg_15 = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9]|[1|2]\d)|3[0-1])\d{3}$/;
						if (reg_15.test(idCard)) {
							return true;
						} else if (reg_18.test(idCard)) {
							// 计算校验位
							var S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
								  + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9 
								  + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
								  + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
								  + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
								  + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
								  + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
								  + parseInt(idcard_array[7]) * 1
								  + parseInt(idcard_array[8]) * 6
								  + parseInt(idcard_array[9]) * 3;
							Y = S % 11;
							M = "F";
							JYM = "10X98765432";
							M = JYM.substr(Y, 1);
							/* 判断校验位 */
							if (M == idcard_array[17].toUpperCase()) {
								return true;
								/* 检测ID的校验位false; */
							} else {
								return false;
							}
						} else {
							return false;
						}
					} else if ($("#linkmanIdType").val() == 2) {
						var rex = /^((G\d{8})|(P\.?\d{7})|(S\.?\d{7})|((14|15)\d{7})|(E\d{8}))$/;
						if (rex.test(value)) {
							return true
						}
						return false;
					} else if ($("#linkmanIdType").val() == 4) {
						var rex = /^[HM]{1}\d{10}$/;
						if (rex.test(value)) {
							return true
						}
						return false;
					} else if ($("#linkmanIdType").val() == 3) {
						var reg = /^[\u4E00-\u9FA5]+$/;
						for (var i = 0; i < value.length; i++) {
							if (reg.test(value[i])) {
								return false;
							}
						}
						return true;
					}
				}
			}, "联系人证件号码不符合规范.");
			jQuery.validator.addMethod("checkMobile", function(value, element) {
				if (value != '') {
					// 手机号
					var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
					if (reg.test(value)) {
						return true;
					}
				}
				return false;
			}, "移动电话不符合规范.");

			jQuery.validator.addMethod("checkLinkManMobile", function(value, element) {
				$("#selectOne").html("");
				if (value != '') {
					// 手机号
					var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
					if (!reg.test(value)) {
						return false;
					}
				}
				return true;
			}, "移动电话不符合规范.");
			jQuery.validator.addMethod("checkSignMobile", function(value, element) {
				if (value != '' && ($("#payWayId").val() == 3 || $("#payWayId").val()==2)) {
					// 手机号
					var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
					if (reg.test(value)) {
						return true;
					}
				}
				return false;
			}, "移动电话不符合规范.");

			jQuery.validator.addMethod("checkCompanyName", function(value, element) {
				var reg = /^\s+$/;
				if (value == '' || reg.test(value)) {
					return false;
				}
				return true;
			}, "请输入单位名称.");

			// 关系
			jQuery.validator.addMethod("checkLinkmanRelation", function(value, element) {
				if (value != '') {
					var reg = /^[\u4E00-\u9FA5]+$/;
					if (reg.test(value)) {
						return true;
					}
					return false;
				}
			}, "关系不能为空，且必须为汉字.");

			// 接受文件方式
			jQuery.validator.addMethod("checkMsgWay", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请选择接受文件方式.");

			// 客户来源
			jQuery.validator.addMethod("checkCustSource", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请选择客户来源.");

			// 客户分类
			jQuery.validator.addMethod("checkCustCategory", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请选择客户分类.");
			jQuery.validator.addMethod("checkZoneCode", function(value, element) {
				//获取电话号码的值
				var val=$(element).closest(".ml160").find(".span5 ").find("input").val();
				if (value != '' || val!="") {
					// 区号
					var reg = /^0[1-9][0-9]{1,2}$/;
					if (!reg.test(value)) {
						return false;
					}
				}
				return true;
			}, "区号不符合规范.");
			jQuery.validator.addMethod("checkTel", function(value, element) {
				//获取区号的值
				var val=$(element).closest(".ml160").find(".span4").find("input").val();
				if (value != '' || val !="") {
					//var reg = /^[0-9]{7,8}$/;
					$(element).siblings("span[for='telNumMsg']").remove();
					var reg = /^(\d{7}|\d{8}|\d{9}|\d{10})$/;
					if (!reg.test(value)) {
						return false;
					}
				}
				return true;
			}, "电话号码不符合规范.");

			jQuery.validator.addMethod("checkRelationRemarkOther", function(value, element) {
				if ($("#hasOther").attr("checked") == "checked") {
					if (value.trim() == '') {
						return false;
					}
				}
				return true;
			}, "请输入关系.");

			// 个人信息
			jQuery.validator.addMethod("checkCustomerSource", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请选择客户来源.");

			// 邮箱
			jQuery.validator.addMethod("checkEmail", function(value, element) {
				if (value != '') {
					// 邮箱
					var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})$/;
					if (reg.test(value)) {
						return true;
					}
				}
				return false;
			}, "邮箱不符合规范.");

			// 出借方式
			jQuery.validator.addMethod("checkProductId", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请选择出借方式.");

			// 出借日期
			jQuery.validator.addMethod("checkExpectLenderDate", function(value, element) {
				if (value == '') {
					return false;
				}
				return true;
			}, "请填写出借日期.");

			// 签单日期
			jQuery.validator.addMethod("checkSignDate", function(value, element) {
				if (value == '') {
					return false;
				}
				return true;
			}, "请填写签单日期.");

			// 开户日期
			jQuery.validator.addMethod("checkOpenDate", function(value, element) {
				if (value == '') {
					return false;
				}
				return true;
			}, "请填写开户日期.");
			// 出生日期
			jQuery.validator.addMethod("checkBirthDate", function(value, element) {
				if (value == '') {
					return false;
				}
				return true;
			}, "请填写出生日期.");
			
			// 出借金额
			var comment="出借金额有误.";
			jQuery.validator.addMethod("checkLenderAmount", function(value, element) {
				if (value == '') {
					$(element).siblings(".help-inline").html("");
					return false;
				}else{
					// 1.数字整额
					var rex = /^[1-9]{1}\d*$/;
					if (!rex.test(value)) {
						return false;
					}
					if (parseFloat(value) < 50000) {
						comment="出借金额不能少于50000元.";
						$.validator.messages.checkLenderAmount = comment; 
						return false;
					}
					if (parseFloat(value) % 10000 != 0) {
						$(element).siblings(".help-inline").html("");
						comment="出借金额以10000元为单位.";
						$.validator.messages.checkLenderAmount = comment;
						return false;
					}
					if ('dueApply' == $("#biz").val()){
						var flag = true;
						if(null != $("#initApplyId").val() || "undefined" != typeof($("#initApplyId").val())){
							var lenderAmount = parseFloat($(".lenderAmount").val());
							$.ajax({
								url : base + "/process/getLenderApply.json",
								type : "GET",
								async : false,
								dataType : "json",
								contentType : "application/json",
								data : {"lenderApplyId":$("#initApplyId").val()},
								timeout : 3000,
								success : function(data) {
									if(lenderAmount>parseFloat(data.lenderAmount)){
										$(".lenderAmount").siblings(".help-inline").css({"color":"#B94A48"}).html("");
										flag = false;
										comment="出借金额不能超过"+data.lenderAmount+"元.";
									}
								},
								error : function(data) {
									$.dopAlert("原单查询失败.");
								}
							});
							$.validator.messages.checkLenderAmount = comment; 
							return flag;
							
						}
					}
					return true;
				}
				
				return true;
			}, comment);
			// 回收方式
			jQuery.validator.addMethod("checkRecovery", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请选择回收方式.");
			// 支付方式
			jQuery.validator.addMethod("checkPayWayId", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请填选择支付方式.");
			// 特殊收益
			jQuery.validator.addMethod("checkIsIncome", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请填特殊收益");
			
			// 特殊额度
			jQuery.validator.addMethod("checkIsIncome", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请填特殊额度");
			jQuery.validator.addMethod("checkSpecialBenefit", function(value, element) {
				// var reg = /^(?:[1-9]\d{0,1}(?:\.\d{2})?|0\.\d{2})$/;
				var reg = /^\d+(\.\d+)?$/;
				if (!reg.test(value) || value == '') {
					return false;
				}
				return true;
			}, "请规范填写收益比例.");

			// 出借金额
			jQuery.validator.addMethod("checkBankInfo", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请填账户信息.");
			jQuery.validator.addMethod("checkPayAccountName", function(value, element) {
				if (value != '') {
					var reg = /^[\u4E00-\u9FA5]+$/;
					if (reg.test(value)) {
						return true;
					}
				}
				return false;
			}, "请输入汉字");
			jQuery.validator.addMethod("checkWechat", function(value, element) {
				if (value != '') {
					var reg = /^[^\u4E00-\u9FA5]+$/;
					if (reg.test(value)) {
						return true;
					}
					return false;
				}
				return true;
			}, "微信号不能为汉字");
			
			jQuery.validator.addMethod("checkEmployeeNo", function(value, element) {
				if (value) {
					return true;
				}
				return false;
			}, "请输入员工编号");
			jQuery.validator.addMethod("checkSystemAccount", function(value, element) {
				if (value) {
					return true;
				}
				return false;
			}, "请输入理财管理系统账号");
			jQuery.validator.addMethod("checkMaritalStatus", function(value, element) {
				if (value!='-1') {
					return true;
				}
				return false;
			}, "请选择婚姻状况");
			jQuery.validator.addMethod("checkNationality", function(value, element) {
				if (value!='-1') {
					return true;
				}
				return false;
			}, "请选择国籍");
			jQuery.validator.addMethod("checkNation", function(value, element) {
				if (value!='-1') {
					return true;
				}
				return false;
			}, "请选择民族");
			jQuery.validator.addMethod("checkPoliticStatus", function(value, element) {
				if (value!='-1') {
					return true;
				}
				return false;
			}, "请选择政治面貌");
			jQuery.validator.addMethod("checkEducation", function(value, element) {
				if (value!='-1') {
					return true;
				}
				return false;
			}, "请选择文化程度");
			jQuery.validator.addMethod("checkJobCategory", function(value, element) {
				if (value!='-1') {
					return true;
				}
				return false;
			}, "请选择工作性质");
			jQuery.validator.addMethod("checkCensusNature", function(value, element) {
				if (value!='-1') {
					return true;
				}
				return false;
			}, "请选择户籍性质");
			jQuery.validator.addMethod("checkEntrysource", function(value, element) {
				if (value!='-1') {
					return true;
				}
				return false;
			}, "请选择入职来源");
			jQuery.validator.addMethod("checkAppllation", function(value, element) {
				if (value!='-1') {
					return true;
				}
				return false;
			}, "请选择称谓");
			jQuery.validator.addMethod("checkServiceUnit", function(value, element) {
				if (value!='-1') {
					return true;
				}
				return false;
			}, "请选择服务单位");
			jQuery.validator.addMethod("checkMarket", function(value, element) {
				if ($.trim(value)!='') {
					return true;
				}
				return false;
			}, "请填写备注");
			
			jQuery.validator.addMethod("checkProvice", function(value, element) {
				if (value!='-1') {
					return true;
				}
				return false;
			}, "请选择省");
			
			form.validate({
				doNotHideMessage : true, // this option enables to show the
				// error/success messages on tab
				// switch.
				errorElement : 'span', // default input error message container
				errorClass : 'validate-inline', // default input error message
				// class
				focusInvalid : false, // do not focus the last invalid input
				rules : {
					// 个人信息
					// 客户姓名
					custName : {
						checkCustName : true
					},
					custNameSpell : {
						checkCustNameSpell : true
					},
					// nationality : {
					// checkNationality : true
					// },
					// 性别
					sex : {
						checkSex : true,
					},
					// 证件类型
					idType : {
						checkIdType : true,
					},
					// 证件号码
					idCard : {
						checkIdCard : true,
					},
					education:{
						checkEducation:true,
					},
					// 新增客户证件号码
					custViewidCard : {
						checkcustViewidCard : true,
					},
					idCardNum : {
						checkIdCard : true,
					},
					linkmanIdCard : {
						checkLinkmanIdCard : true,
					},
					birthDate : {
						checkBirthDate : true,
					},

					// 手机
					mobile : {
						checkMobile : true
					},
					// 手机
					mobileNum : {
						checkMobile : true
					},
					// 单位名称
					companyName : {
						checkCompanyName : true
					},

					// 银行地址-省
					payProvinceRegionCode : {
						checkProvince : true
					},
					// 银行地址-省
					refundProvinceRegionCode : {
						checkProvince : true
					},
					// 通讯地址-省
					provinceRegionCode : {
						checkProvince : true
					},
					// 通讯地址-市
					cityRegionCode : {
						checkCity : true
					},
					// 银行地址-市
					payCityRegionCode : {
						checkCity : true
					},
					// 银行地址-市
					refundCityRegionCode : {
						checkCity : true
					},
					// 通讯地址-区
					districtRegionCode : {
						checkDistrict : true
					},
					// /通讯地址-街道
					streetInfo : {
						checkStreetInfo : true
					},
					// /通讯地址-邮编
					zipCode : {
						checkZip : true,
						required : true
					},
					// /固定电话 区号
					areaCode : {
						checkZoneCode : true
					},
					// /固定电话 电话号
					telNum : {
						checkTel : true
					},
						// 联系人固定电话 区号
					linkmanAreaCode : {
						checkZoneCode : true
					},
					// /联系人固定电话 电话号
					linkmanTelNum : {
						checkTel : true
					},
					// 特殊收益
					specialBenefit : {
						checkSpecialBenefit : true
					},
					linkmanName : {
						checkCustName : true
					},
					linkmanNameSpell : {
						checkCustNameSpell : true
					},
					linkmanSex : {
						checkSex : true
					},
					linkmanRelation : {
						checkLinkmanRelation : true
					},
					// 手机
					linkmanMobile : {
						checkLinkManMobile : true
					},
					// 签约手机
					signMobile : {
						checkSignMobile : true
					},
					// 汇款
					payBankCategory : {
						checkBankCategory : true
					},
					//支付其他支行 
					payOtherSubBank :{
						checkOtherSubBank :true
					},			
					
					remitAccountName : {
						checkAccountName : true
					},
					remitAccountNum : {
						checkAccountNum : true
					},
					custSourceOther : {
						checkCustSourceOther : true
					},
					refundProvinceRegionCode : {
						//校验省不能不选择
						checkProvice : true 
					},
					// 回款
					refundBankCategory : {
						checkBankCategory : true
					},
					
					refundSubBank : {
						checkSubBank : true
					},
					//回款  其他支行
				    refundOtherSubBank :{
				    	checkOtherSubBank :true
				    },		
					refundAccountName : {
						checkAccountName : true
					},
					refundAccountNum : {
						checkAccountNum : true
					},
					payAccountNum : {
						checkAccountNum : true
					},
					paySubBank : {
						checkSubBank : true
					},
					payAccountName : {
						checkAccountName : true
					},
					msgWay : {
						checkMsgWay : true
					},
					custSource : {
						checkCustSource : true
					},
					custCategory : {
						checkCustCategory : true
					},
					payAccountName : {
						checkPayAccountName : true
					},
					// 特殊收益
					isIncome : {
						checkIsIncome : true
					},			
					//特殊额度备注
					specialLimitRemark:{
						checkMarket:true
					},
					//特殊收益备注
					specialBenefitRemark:{
						checkMarket:true
					},
					// 邮箱
					accountEmail : {
						checkEmail : true,
					},
					
					// 合同编号
					contractCode:{
						checkContractCode:true,
						remote: {
							url: base + "/common/check_contract_code.json",
							data:{
								contractCode: function(){return $(".contractCode").val();},
								lenderApplyId: function(){ return $("#lenderApplyId").val()},
							}
						}
					},
					
					// 出借方式
					productId : {
						checkProductId : true
					},
					// 出借日期
					expectLenderDateBegin : {
						checkExpectLenderDate : true
					},
					// 出借日期
					expectLenderDateEnd : {
						checkExpectLenderDate : true
					},
					// 开户日期
					openDate : {
						checkOpenDate : true
					},
					signDate : {
						checkSignDate : true
					},
					// 出借金额
					lenderAmount : {
						checkLenderAmount : true
					},
					bankInfo : {
						checkBankInfo : true
					},
					payWayId : {
						checkPayWayId : true
					},
					lenderIncomeRatio : {
						checkLenderIncomeRatio : true
					},
					wechat : {
						checkWechat : true
					},
					// 回收方式
					recovery : {
						checkRecovery : true
					},
					//人事员工编号
					employeeNo:{
						checkEmployeeNo:true
					},
					//理财系统账户
					systemAccount:{
						checkSystemAccount:true
					},
					//有效时间起
					effecitiveDateBegin:{
						checkPlannedEntryDate:true
					},
					//有效时间止
					effecitiveDateEnd:{
						checkPlannedEntryDate:true
					},
					//生日
					birthDate:{
						checkBirthDate:true
					},
					//婚姻
					HrmaritalStatus:{
						checkMaritalStatus:true
					},
					//国籍
					nationality:{
						checkNationality:true
					},
					//民族
					nation:{
						checkNation:true
					},
					//服务单位
					serviceUnit:{
						checkServiceUnit:true
					},
					//政治面貌
					politicStatus:{
						checkPoliticStatus:true
					},
					//学历
					Hreducation:{
						checkEducation:true
					},
					//工作性质
					jobCategory:{
						checkJobCategory:true
					},
					//入职日期
					entryDate:{
						checkPlannedEntryDate:true
					},
					//户籍性质
					censusNature:{
						checkCensusNature:true
					},
					//户籍地址
					permanentProvince:{
						checkProvince:true
					},
					permanentCity:{
						checkCity:true
					},
					permanentDistrict:{
						checkDistrict:true
					},
					streetInfo:{
						checkStreetInfo:true
					},
					//现居住地址
					residenceProvince:{
						checkProvince:true
					},
					residenceCity:{
						checkCity:true
					},
					residenceDistrict:{
						checkDistrict:true
					},
					residenceAdd:{
						checkStreetInfo:true
					},
					//入职来源
					entrysource:{
						checkEntrysource:true
					},
					//称谓
					appllation:{
						checkAppllation:true
					},
					//工作单位
					workUtil:{
						checkCompanyName:true
					}
				},
				messages : { // custom messages for radio buttons and
					// checkboxes
					'payment[]' : {
						required : "Please select at least one option",
						minlength : jQuery.format("Please select at least one option")
					},
					contractCode : {
						remote: "合同编号已存在."
					}
				},
				
				
				errorPlacement : function(error, element) { // render error
					// placement for lenderAmount
					// each input type
					if (element.attr("name") == "gender") { // for uniform radio
						error.addClass("no-left-padding").insertAfter(
								"#form_gender_error");
					} else if (element.attr("name") == "payment[]") { // for
						error.addClass("no-left-padding").insertAfter("#form_payment_error");
					} else {
						error.insertAfter(element); // for other inputs, just
					}
				},
				invalidHandler : function(event, validator) { // display error
					// alert on form
					// submit
					success.hide();
					error.show();
					App.scrollTo(error, -200);
				},
				highlight : function(element) { // hightlight error inputs
					$(element).closest('.help-inline').removeClass('ok'); // display
					// OK
					// icon
					$(element).closest('.responsive').removeClass('success').addClass('error'); // set error class to the
					// control group
				},
				unhighlight : function(element) { // revert the change dony by
					// hightlight
					$(element).closest('.responsive').removeClass('error'); // set
					// error
					// class
					// to
					// the
					// control
					// group
				},
				success : function(label) {
					if (label.attr("for") == "gender" || label.attr("for") == "payment[]") { // for
						// checkboxes
						// and radio
						// buttons,
						// no need
						// to show
						// OK icon
						label.closest('.responsive').removeClass('error').addClass('success');
						label.remove(); // remove error label here
					} else if(label.attr("for") == "linkmanMobile"&&label.prev().val()=="" ){ 
						label.addClass('valid ok').closest('.responsive').removeClass('error').removeClass('success');
					}else{// display success icon for other inputs
						label.addClass('valid ok').closest('.responsive').removeClass('error').addClass('success'); // set success class to the control
						// group
					}
				},
				submitHandler : function(form) {
					success.show();
					error.hide();
					// add here some ajax code to submit your form or just call
					// form.submit() if you want to submit the form without ajax
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

			// default form wizard
			$('#save_wizard').bootstrapWizard({
				'nextSelector' : '.button-next',
				'previousSelector' : '.button-previous',
				onTabClick : function(tab, navigation, index) {
					return false;
				},
				onNext : function(tab, navigation, index) {
					form.valid();
					if (!form.valid()) {
						return false;
					}
					// 自定义方法
					if (save(tab, navigation, index) == false) {
						return false;
					}
					success.hide();
					error.hide();
					var total = navigation.find('li').length;
					var current = index + 1;
					// set wizard title
					$('.step-title', $('#save_wizard')).text('Step ' + (index + 1) + ' of '+ total);
					// set done steps
					jQuery('li', $('#save_wizard')).removeClass("done");
					var li_list = navigation.find('li');
					for (var i = 0; i < index; i++) {
						jQuery(li_list[i]).addClass("done");
					}
					if (current == 1) {
						$('#save_wizard').find('.button-previous').hide();
					} else {
						$('#save_wizard').find('.button-previous').show();
					}
					if (current >= total) {
						$('#save_wizard').find('.button-next').hide();
						$('#save_wizard').find('.button-submit').show();
						displayConfirm();
					} else {
						$('#save_wizard').find('.button-next').show();
						$('#save_wizard').find('.button-submit').hide();
					}
					App.scrollTo($('.page-title'));
				},
				onPrevious : function(tab, navigation, index) {
					success.hide();
					error.hide();
//					if (previous(tab, navigation, index) == false) {
//						return false;
//					}
					var total = navigation.find('li').length;
					var current = index + 1;
					// set wizard title
					$('.step-title', $('#save_wizard')).text('Step ' + (index + 1) + ' of ' + total);
					// set done steps
					jQuery('li', $('#save_wizard')).removeClass("done");
					var li_list = navigation.find('li');
					for (var i = 0; i < index; i++) {
						jQuery(li_list[i]).addClass("done");
					}
					if (current == 1) {
						$('#save_wizard').find('.button-previous').hide();
					} else {
						$('#save_wizard').find('.button-previous').show();
					}
					if (current >= total) {
						$('#save_wizard').find('.button-next').hide();
						$('#save_wizard').find('.button-submit').show();
					} else {
						$('#save_wizard').find('.button-next').show();
						$('#save_wizard').find('.button-submit').hide();
					}
					App.scrollTo($('.page-title'));
				},
				onTabShow : function(tab, navigation, index) {
					var total = navigation.find('li').length;
					var current = index + 1;
					var $percent = (current / total) * 100;
					$('#save_wizard').find('.bar').css({
						width : $percent + '%'
					});
					if(index==3 || ($("#resKey").val()=="wmsCustLenderApply" && index==2)){
						$("#fileUploadFormFrom").show();
						$(".tab-content").css({"margin-top":"6.8%"});
						showRefFolders();
					}else{
						$("#fileUploadFormFrom").hide();
						$(".tab-content").css({"margin-top":"0px"});
					}
				}
			});
			$('#save_wizard').find('.button-previous').hide();
			$('#save_wizard .button-submit').click(function() {
				if (form.valid() == false) {
					return false;
				}
				save("", "", 4);
			}).hide();
		}
	};
}();