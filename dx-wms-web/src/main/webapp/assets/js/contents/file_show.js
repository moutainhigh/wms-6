/**
 * readonly : true 所有影像文件仅可预览
 * 
 */

function getWmsObject() {
	var conditions = {};
	conditions.appCode = $("#appCode").val();
	conditions.resKey = $("#resKey").val();
	conditions.custAccountId = $("#userUniqueId").val();
	var lenderApplyId = $("#lenderUniqueId").val();
	if (isEmptyString(lenderApplyId)) {
		lenderApplyId = $("#lenderApplyId").val();
	}
	conditions.lenderApplyId = lenderApplyId;
	conditions.lenderCustCode = $("#lenderCustCode").val();
	conditions.lenderCode = $("#lenderCode").val();
	return conditions;
}

$(function() {
});

/**
 * 影像图标路径设置
 * 
 * @param fileType
 *            影像文件类型
 * @returns {String}
 */
function getPicUrlByFileType(fileType) {
	if (isEmptyString(fileType)) {
		return "";
	}
	if ("RAR" == fileType.toUpperCase()) {
		return resBase + "/image/file150921.jpg";
	} else if ("PNG" == fileType.toUpperCase()) {
		return resBase + "/image/file150921.jpg";
	} else if ("JPG" == fileType.toUpperCase()) {
		return resBase + "/image/file150921.jpg";
	} else if ("PDF" == fileType.toUpperCase()) {
		return resBase + "/image/file150921.jpg";
	}
	return "";
}

/**
 * 上传文件校验
 * 
 * @param fileName
 *            文件名
 * @param fileSize
 *            文件类型
 * @returns {Boolean}
 */
function validateFile(fileName, fileSize) {
	if (isEmptyString(fileName)) {
		$.dopAlert("请选择需要上传的影像文件");
		return false;
	}
	if (parseFloat(fileSize) <= 0) {
		$.dopAlert("请选择需要上传的影像文件");
		return false;
	}
	var fileArr = fileName.split(".");
	if (fileArr.length > 2
			|| fileArr.length <= 1
			|| (fileArr[fileArr.length - 1].toUpperCase() != "RAR"
					&& fileArr[fileArr.length - 1].toUpperCase() != "JPG"
					&& fileArr[fileArr.length - 1].toUpperCase() != "PNG" && fileArr[fileArr.length - 1]
					.toUpperCase() != "PDF")) {
		$.dopAlert("请选择正确文件格式上传");
		return false;
	}
	if (fileArr[fileArr.length - 1].toUpperCase() == "RAR") {
		// 大于20M
		if (parseFloat(fileSize) > 20) {
			$.dopAlert("您上传的文件过大,请重新选择");
			return false;
		}
	} else {
		if (parseFloat(fileSize) > 1) {
			$.dopAlert("您上传的文件过大,请重新选择");
			return false;
		}
	}
	return true;
}

/**
 * 文件夹 - 文件
 */
function showFilesWithFolder() {
	// 1.展示所有文件夹
	// window.parent.showRefFolders();
	showRefFolders();
	// 2.收起文件
	$("#vFile").html("");
}

/**
 * 文件
 */
function showFilesOnly() {
	var currentFileDir = $("#currentFileDir").val();
	if (isEmptyString(currentFileDir)) {
		return false;
	}
	doShowFiles(currentFileDir);
}

/**
 * 生效支付凭证 影像文件
 */
function makePaymentVouchersFilesEffective() {
	var conditions = getWmsObject();
	conditions.cmAction = "createAccount";
	conditions.action = "uploadPaymentVouchers";
	conditions.fileDirId = $("#currentFileDir").val();

	$.ajax({
		url : base + '/contentManage/makeFilesEffective.json',// 请求url
		type : "POST",
		async : true,
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(conditions),
		timeout : 30000,
		success : function(data) {

		},
		error : function(data) {

		}
	});
}

/**
 * 文件上传 param uploadBtnId 上传文件按钮的id
 */
function uploadFiles(uploadBtnId) {
	$("#" + uploadBtnId).click(function() {
		var $modelDiv = $(this).closest("form.uploadForm");
		var $file = $modelDiv.find("input.file");
		var $upLoadImg = $modelDiv.find("div.upLoadImg");
		var $fileShowModel = $modelDiv.find("input.fileShowModel");
		var $uploadBtn = $(this);
		var showModel = $fileShowModel.val();
		var $fileName = $(".fileupload-preview").text();
		
		if (!validateFile($.trim($file.val()), checkFileSize($file[0]))) {
			return false;
		}
		$uploadBtn.attr("disabled", "disabled");
		// 上传期间使上传、关闭按钮失效
		
		$upLoadImg.show();
		$("#fileUploadFormFrom").ajaxSubmit({
			type : "post",
			url : base + "/contentManage/upload.json",
			// data : $('#fileUploadFormFrom').formSerialize(),不需要
			enctype : 'multipart/form-data',
			async : false,
			success : function(data) {
				if (data.code) {
					if (isEmptyString(showModel) || "folder" == showModel) {
						// 1.展示所有文件夹
						// window.parent.showRefFolders();
						showRefFolders();
						// 2.收起文件
						$("#vFile").html("");
					} else if ("file" == showModel) {
						showFilesOnly();
					}
					// 3.隐藏上传窗口
					$upLoadImg.hide();
					// 4.提示上传结果
					$(".file_del").click();
					$.dopAlertWithNoBtns("上传文件[" + $fileName + "]成功.");
				} else {
					$upLoadImg.hide();
					$.dopAlert(data.msg);
				}
				$uploadBtn.removeAttr("disabled");
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$.dopAlert("上传文件[" + $fileName + "]异常." + textStatus);
				$upLoadImg.hide();
				$uploadBtn.removeAttr("disabled");
			}
		});
	});
}

// 存放所有文件夹信息
var folders = new Array();
// 存放所有子文件数量的span 的id组合
var sunFileNumberArr = new Array();

/**
 * 页面加载完后显示所有文件夹
 */
function showRefFolders() {
	var ctxhtml = "";
	$("#vFolder").html(ctxhtml);
	var conditions = getWmsObject();

	$.ajax({
		url : base + '/contentManage/getFolders.json',// 请求url
		type : "POST",
		async : true,
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(conditions),
		timeout : 30000,
		success : function(data) {
			$.each(data, function(index, item) {
				folders[index] = item;
				sunFileNumberArr[index] = item.folderCode + "Num";
				ctxhtml += "<div class='span3' style='margin:auto;'>";
				ctxhtml += "<input type='hidden' name='" + item.folderCode
						+ "FolderPath' id='" + item.folderCode
						+ "FolderPath' value='" + item.fileDirId + "'  />";
				ctxhtml += "<div style='width:100%;height:auto;'>";
				ctxhtml += "<img src='" + resBase + "/image/u37.png' alt='"
						+ item.folderName + "-文件夹'"
						+ "style='width:40%;length:40%;' ></img><br /><br />";
				ctxhtml += "</div>";
				ctxhtml += "<div style='width:100%;height:auto;'>";
				ctxhtml += "<strong><span>" + item.folderName + "(<span id='"
						+ item.folderCode + "Num" + "'>" + item.sunFileNumber
						+ "</span>)</span></strong><br /><br />";
				ctxhtml += "</div>";
				ctxhtml += "<div style='width:100%;height:auto;'>";
				ctxhtml += "<span class='btn blue' id='" + item.folderCode
						+ "OpenBtn' onclick='doOpenFiles(folders[" + index
						+ "])'>";
				ctxhtml += "<span class='icon-folder-open'></span>&nbsp;展开";
				ctxhtml += "</span>";
				ctxhtml += "<span class='btn red' style='display:none' id='"
						+ item.folderCode
						+ "CloseBtn' onclick='doCloseFiles(folders[" + index
						+ "])'>";
				ctxhtml += "<span class='icon-folder-close'></span>&nbsp;收起";
				ctxhtml += "</span>";
				ctxhtml += "</div>";
				ctxhtml += "</div>";
				$("#vFolder").append(ctxhtml);
				ctxhtml = "";
			});
		},
		error : function(data) {
			$.dopAlert("保存出现异常,请重试");
			flag = false;
		}
	});
}

/**
 * 获取影像文件列表元素的模板
 * 
 * @param sourceFileName
 *            图片全名
 * @param updator
 *            修改人
 * @param videoDataId
 *            影像编号
 * @param iconUrl
 *            影像图标路径
 * @param imgUrl
 *            影像源路径
 */
function getFileModel(folderCodeNum, fileName, fileId, iconUrl, imgUrl,
		currentFileDir, fileSaveName, filePath, fileType, fileSourceName,
		fileNum) {
	var tmpsString = fileSaveName + ";" + filePath + ";" + fileType + ";"
	+ fileName + ";";
	var modelString = "<input type='hidden' name='videosImg' value='" + tmpsString
	+ "'/>"
	 modelString += "<div class='span3' style='margin-left: 20px;' id='"
			+ fileId + "FileDiv'>";
	var tmpString = fileSaveName + ";" + filePath + ";" + fileType + ";"
			+ fileSourceName + ";";
	modelString += "<input type='hidden' name='videoImg' value='" + tmpString
			+ "'/>"
	modelString += "<div style='width:100%;height:auto;'>";
	modelString += "<a data-toggle='modal' onclick='videoImgClick(\"" + fileId
			+ "\",\"" + fileSaveName + "\",\"" + fileType + "\",\""
			+ fileSourceName + "\",\"" + fileNum
			+ "\")' title='' href='#responsive'>";
	modelString += "<img src='" + iconUrl
			+ "' alt=''><br /></img><strong><span>" + fileName
			+ "</span></strong>";
	modelString += "</a>";
	modelString += "<br />";
	modelString += "</div>";
	modelString += "<div style='width:100%;height:auto;'>";
	modelString += "<span class='btn red' onclick='del(" + fileId + ","
			+ currentFileDir + ",\"" + folderCodeNum + "\",\"" + fileName
			+ "\")'>";
	modelString += "<span class='icon-trash'></span>&nbsp;删除";
	modelString += "</span>";
	modelString += "<br />";
	modelString += "</div>";
	modelString += "</div>";
	return modelString;
}

function getFileReadOnlyModel(fileName,fileId, icUrl, igUrl, fileSaveName, filePath,
		fileType, fileSourceName, fileNum) {
	var tmpsString = fileSaveName + ";" + filePath + ";" + fileType + ";"
	+ fileName + ";";
	var modelString = "<input type='hidden' name='videosImg' value='" + tmpsString
	+ "'/>"
	 modelString += "<div class='span3' style='margin-left: 20px;' id='"
		+ fileId + "FileDiv'>";
	var tmpString = fileSaveName + ";" + filePath + ";" + fileType + ";"
			+ fileSourceName + ";";
	modelString += "<input type='hidden' name='videoImg' value='" + tmpString
			+ "'/>"
	modelString += "<div style='width:100%;height:auto;'>";
	
	modelString += "<a data-toggle='modal' onclick='videoImgClick(\"" + fileId
	+ "\",\"" + fileSaveName + "\",\"" + fileType + "\",\""
	+ fileSourceName + "\",\"" + fileNum
	+ "\")' title='' href='#responsive'>";
	modelString += "<img src='" + icUrl
	+ "' alt=''><br /></img><strong><span>" + fileName
	+ "</span></strong>";
	modelString += "</a>";
	modelString += "<br />";
	modelString += "</div>";
	modelString += "</div>";
	return modelString;
}

/**
 * 展开文件夹
 * 
 * @param fileIndex
 */
function doOpenFiles(folder) {
	var it = "";
	for (var i = 0; i < folders.length; i++) {
		it = folders[i];
		if (it == folder) {
			$("#" + it.folderCode + "OpenBtn").hide();
			$("#" + it.folderCode + "CloseBtn").show();
		} else {
			$("#" + it.folderCode + "OpenBtn").show();
			$("#" + it.folderCode + "CloseBtn").hide();
		}
	}
	$("#vFile").html("");
	$("#currentFileDir").val(folder.fileDirId);
	var conditions = getWmsObject();
	conditions.cmAction = "getFileStoreFile";
	conditions.fileDirId = folder.fileDirId;
	$.ajax({
		url : base + '/contentManage/queryFiles.json?tmp=' + new Date(),// 请求url
		type : "POST",
		async : true,
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(conditions),
		timeout : 30000,
		success : function(data) {
			$.each(data, function(index, item) {
				if ($("#readonly").val() == "true") {
					var fl = getFileReadOnlyModel(item.fileName,item.fileId,
							getPicUrlByFileType(item.fileType), item.fileUrl,
							item.fileSaveName, item.filePath, item.fileType,
							item.fileSourceName, (index+1));
					$("#vFile").append(fl);
				} else {
					if (1 == parseInt(folder.isEdit)) {
						var fl = "";
						if (conditions.resKey == 'wmsCustLenderApply'
								&& folder.fileDirId < 5) {
							fl = getFileReadOnlyModel(item.fileName,item.fileId,
									getPicUrlByFileType(item.fileType),
									item.fileUrl, item.fileSaveName,
									item.filePath, item.fileType,
									item.fileSourceName, (index+1));
						} else {
							fl = getFileModel(folder.folderCode + "Num",
									item.fileName, item.fileId,
									getPicUrlByFileType(item.fileType),
									item.fileUrl, $("#currentFileDir").val(),
									item.fileSaveName, item.filePath,
									item.fileType, item.fileSourceName,
									(index+1));
						}
						$("#vFile").append(fl);
					} else if (0 == parseInt(folder.isEdit)) {
						var fl = getFileReadOnlyModel(item.fileName,item.fileId,
								getPicUrlByFileType(item.fileType),
								item.fileUrl, item.fileSaveName, item.filePath,
								item.fileType, item.fileSourceName,
								(index+1));
						$("#vFile").append(fl);
					}
				}
			});
		},
		error : function(data) {
		}
	});

}

function doShowFiles(fileDirId) {
	$("#vFile").html("");
	var conditions = getWmsObject();
	conditions.cmAction = "getFileStoreFile";
	conditions.fileDirId = fileDirId;

	$.ajax({
		url : base + '/contentManage/queryFiles.json?tmp=' + new Date(),// 请求url
		type : "POST",
		async : true,
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(conditions),
		timeout : 30000,
		success : function(data) {
			$.each(data, function(index, item) {
				if ($("#readonly").val() == "true") {
					var fl = getFileReadOnlyModel(item.fileName,item.fileId,
							getPicUrlByFileType(item.fileType), item.fileUrl,
							item.fileSaveName, item.filePath, item.fileType,
							item.fileSourceName, (index+1));
					$("#vFile").append(fl);
				} else {
					$("#vFile").append(
							getFileModel("tempNum", item.fileName, item.fileId,
									getPicUrlByFileType(item.fileType),
									item.fileUrl, fileDirId, item.fileSaveName,
									item.filePath, item.fileType,
									item.fileSourceName, (index+1)));
				}
			});
			$("#vFile").append("<br /><br />");
		},
		error : function(data) {
		}
	});

}

/**
 * 收起文件夹
 * 
 * @param fileIndex
 */
function doCloseFiles(item) {
	$("#" + item.folderCode + "OpenBtn").show();
	$("#" + item.folderCode + "CloseBtn").hide();
	$("#vFile").html("");
	$("#currentFileDir").val("");
}

/**
 * 删除指定的影像文件
 * 
 * @param sourceFileName
 *            图片全名
 * @param videoDataId
 *            影像编号
 * @param updator
 *            修改人
 */
function del(fileId, currentFileDir, codeNum, sourceFileName) {
	var appCode = $("#appCode").val();
	var conditions = getWmsObject();
	conditions.cmAction = "deleteFile";
	conditions.fileId = fileId;
	conditions.fileDirId = currentFileDir;
	//让上一页和保存安妮隐藏
	$('#save_wizard').find('.button-previous').hide();
	$('#save_wizard').find('.button-next').hide();
	$("#save_wizard").find(".button-submit").hide();
	$.dopConfirm("确认删除文件[" + sourceFileName + "]吗？", null, function(r) {
		if (r) {
			$
					.ajax({
						url : base + '/contentManage/deleteFiles.json',// 请求url
						type : "POST",
						async : true,
						dataType : "json",
						contentType : "application/json",
						data : JSON.stringify(conditions),
						timeout : 30000,
						success : function(data) {
							if (!data) {
								$.dopAlert("删除文件[" + sourceFileName + "]失败.");
							} else {
								$.dopAlertWithNoBtns("删除文件[" + sourceFileName
										+ "]成功.");
								$("#" + fileId + "FileDiv").remove();

								if (parseInt($("#" + codeNum).html()) != 0) {
									$("#" + codeNum).html(
											$("#" + codeNum).html() - 1);
								}
							}
						},
						error : function(data) {
							$.dopAlert("删除文件[" + sourceFileName + "]异常");
						}
					});
		}
		
		var hide=$('#save_wizard').find('.button-next').css("display");
		//让上一页和保存按钮显示
		if(hide=="none"){
			$("#save_wizard").find(".button-submit").show();
		}
		if(hide=="inline-block"){
			$('#save_wizard').find('.button-next').show();
		}
		$('#save_wizard').find('.button-previous').show();
	});
}

/**
 * 计算上传文件的大小(兆)
 * 
 * @returns {Number}
 */
function checkFileSize(obj) {
	var size = 0;
	if (obj.files[0]) {
		size = obj.files[0].size / 1048576;
	}
	return Number(size);
}

/**
 * js判断字符串是否以参数str为开头
 * 
 * @param str
 */
String.prototype.startWith = function(str) {
	if (str == null || str == "" || this.length == 0
			|| str.length > this.length)
		return false;
	if (this.substr(0, str.length) == str)
		return true;
	else
		return false;
	return true;
}

/**
 * 判断字符串是否是空字符串
 * 
 * @param str
 * @returns {Boolean}
 */
function isEmptyString(str) {
	if (null == str || "" == $.trim(str) || "null" == $.trim(str)) {
		return true;
	}
	return false;
}

/**
 * 关闭当前网页
 */
function closeWebPage() {
	if (navigator.userAgent.indexOf("MSIE") > 0) {
		if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
			window.opener = null;
			window.close();
		} else {
			window.open('', '_top');
			window.top.close();
		}
	} else if (navigator.userAgent.indexOf("Firefox") > 0) {
		// window.location.href = 'about:blank ';
		// window.open('','_parent','');
		// window.opener = window;
		window.close();
	} else {
		window.opener = null;
		window.open('', '_self', '');
		window.close();
	}
}
