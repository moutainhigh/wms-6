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
			$("#country_list").select2({
				placeholder : "Select",
				allowClear : true,
				formatResult : format,
				formatSelection : format,
				escapeMarkup : function(m) {
					return m;
				}
			});
			var form = $('#submit_form');
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
				if ($("#custSource").val() == 20) {
					if (value != '') {
						var reg = /^[\u4E00-\u9FA5]+$/;
						if (reg.test(value)) {
							return true;
						}
					}
					return false;
				}
				return true;
			},"请输入其他客户来源，且必须为汉字.");
			jQuery.validator.addMethod("checkZip", function(value, element) {
				// 邮编
				var reg = /^[0-9][0-9]{5}$/;
				if (reg.test(value)) {
					return true;
				}
				return false;
			}, "邮编不符合规范.");
			// 银行
			jQuery.validator.addMethod("checkBankCategory", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请选择银行.");
			// 合同编号
			jQuery.validator.addMethod("checkContractCode", function(value, element) {
				var reg = /^[D][X][F][0-9]{13}$/;
				if (!reg.test(value)) {
					return false;
				}
				return true;
			}, "合同编号为DXF大写字母+13位数字.");
			// 支行
			jQuery.validator.addMethod("checkSubBank", function(value, element) {
				if (value == '-1') {
					return false;
				}
				return true;
			}, "请选择支行.");
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
					var reg = /^[A-Za-z]+$/;
					if (reg.test(value)) {
						return true;
					}
					return false;
				} else {
					return false;
				}
			}, "姓名 (拼音) 只能为字母");

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
					var rex = /^((G\d{8})|(P\.?\d{7})|(S\.?\d{7})|((14|15)\d{7})|(E\d{8}))$/;
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
					console.log("=22=="+idcard_array[17]);
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
				if (value != '') {
					// 手机号
					var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
					if (!reg.test(value)) {
						return false;
					}
				}else{
					var inputs=$(element).closest(".span6").siblings(".span6").find("input");
					if($(inputs[0]).val()=="" ||$(inputs[1]).val()==""){
						$(element).closest(".span6").removeClass("success");
						$("#selectOne").html("移动电话和固定电话至少选择一项");
					}
				}
				return true;
			}, "移动电话不符合规范.");
			jQuery.validator.addMethod("checkSignMobile", function(value, element) {
				if (value != '' && ($("#payWayId").val() == 3 || $("#payWayId").val() == 2)) {
					// 手机号
					var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
					if (reg.test(value)) {
						return true;
					}
				}
				return false;
			}, "移动电话不符合规范.");
			jQuery.validator.addMethod("checkTerminalCode", function(value, element) {
				if (value != '') {
					return false;
				}
				return true;
			}, "终端号不能为空.");
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
				var val=$(element).parent().siblings(".span6").find("input").val();
				if (value != '' || val!='') {
					// 区号
					var reg = /^0[1-9][0-9]{1,2}$/;
					if (!reg.test(value)) {
						return false;
					}
				}
				return true;
			}, "区号不符合规范.");
			jQuery.validator.addMethod("checkTel", function(value, element) {
				var val=$(element).parent().siblings(".span5").find("input").val();
				if (value != '' || val!='') {
					// 电话
					var reg = /^[0-9]{7,8}$/;
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
			jQuery.validator.addMethod("checkTradeTime", function(value, element) {
				if (value == '') {
					return false;
				}
				return true;
			}, "请填写划扣日期.");
			// 出借金额
			jQuery.validator.addMethod("checkLenderAmount", function(value, element) {
				if (value == '') {
					return false;
				}
				else if (productId == '13') {
					// 1.数字整额
					var rex = /^[1-9]{1}\d*$/;
					if (!rex.test(value)) {
						return false;
					}
					if (parseFloat(value) < 50000) {
						return false;
					}
					if (parseFloat(value) % 10000 != 0) {
						return false;
					}
					return true;
				} else if (productId == '16') {
					// 1.数字整额
					var rex = /^[1-9]{1}\d*$/;
					if (!rex.test(value)) {
						return false;
					}
					if (parseFloat(value) < 50000) {
						return false;
					}
					if (parseFloat(value) % 10000 != 0) {
						return false;
					}
					return true;
				} else {
					// 1.数字整额
					var rex = /^[1-9]{1}\d*$/;
					if (!rex.test(value)) {
						return false;
					}
					if (parseFloat(value) < 50000) {
						return false;
					}
					if (parseFloat(value) % 10000 != 0) {
						return false;
					}
					return true;
				}
				return true;
			}, "出借金额有误.");
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
			jQuery.validator.addMethod("checkLenderIncomeRatio", function(value, element) {
				if ($("#isIncome").val() == '1' || value != '') {
					// var reg = /^(?:[1-9]\d{0,1}(?:\.\d{2})?|0\.\d{2})$/;
					var reg = /^\d+(\.\d+)?$/;
					if (!reg.test(value)) {
						return false;
					}
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
					terminalCode : {
						checkTerminalCode : true
					},
					// 银行地址-省
					payprovinceRegionCode : {
						checkProvince : true
					},
					// 银行地址-省
					refundprovinceRegionCode : {
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
					paycityRegionCode : {
						checkCity : true
					},
					// 银行地址-市
					refundcityRegionCode : {
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
						checkLenderIncomeRatio : true
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
					remitSubBank : {
						checkSubBank : true
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
					// 回款
					refundBankCategory : {
						checkBankCategory : true
					},
					refundSubBank : {
						checkSubBank : true
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
					refundOtherAddress : {
						checkOtherSubBank : true
					},
					payOtherAddress : {
						checkOtherSubBank : true
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
					// 邮箱
					email : {
						checkEmail : true
					},
					// 合同编号
					contractCode : {
						checkContractCode : true,
						remote: {
							url: base + "/common/check_contract_code.json",
							data:{
								contractCode: function(){return $("#contractCode").val();},
								lenderApplyId: function(){return $("#lenderApplyId").val();}
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
					tradeTime : {
						checkTradeTime : true
					},
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
					}
					
				},
				messages : { // custom messages for radio buttons and
					// checkboxes
					'payment[]' : {
						required : "Please select at least one option",
						minlength : jQuery.format("Please select at least one option")
					},
					contractCode:{
						remote: "合同编号重复."
					}
				},
				errorPlacement : function(error, element) { // render error
					// placement for lenderAmount
					// each input type
					if (element.attr("name") == "gender") { // for uniform radio
						// buttons, insert
						// the after the
						// given container
						error.addClass("no-left-padding").insertAfter(
								"#form_gender_error");
					} else if (element.attr("name") == "lenderAmount") {
						error.insertAfter(element.next(".rmb2"));
					} else if (element.attr("name") == "payment[]") { // for
						// uniform
						// radio
						// buttons,
						// insert
						// the
						// after
						// the
						// given
						// container
						error.addClass("no-left-padding").insertAfter("#form_payment_error");
					} else {
						error.insertAfter(element); // for other inputs, just
						// perform default behavoir
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
					} else { // display success icon for other inputs
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
			$('#form_wizard_1').bootstrapWizard({
				'nextSelector' : '.button-next',
				'previousSelector' : '.button-previous',
				onTabClick : function(tab, navigation, index) {
					return false;
				},
				onNext : function(tab, navigation, index) {
					success.hide();
					error.hide();
					if (form.valid() == false) {
						return false;
					}
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
		}
	};
}();