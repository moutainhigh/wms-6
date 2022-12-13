/**
 * 上传文件
 * @param uploadBtnId	上传按钮id
 * @param url			请求url
 * @param otherFun		上传成功回调函数
 * @param isReadonly	影响是否只读
 */
function uploadFiles(uploadBtnId, url, otherFun, isReadonly, validFun,formId) {
	if(!formId) {
		formId = "fileUploadFormFrom";
	}
	$("#"+uploadBtnId).click(function() {
		var $modelDiv = $(this).closest("form.uploadForm");
		var $file = $modelDiv.find("input.file");
		var $upLoadImg = $modelDiv.find("div.upLoadImg");
		var $uploadBtn = $(this);
		var $fileName = $(".fileupload-preview").text();
		if(validFun) {
			if(!validExcelFile($.trim($file.val()),checkFileSize($file[0]),uploadBtnId)){
				return false;
			}
		} else {
			if(!validateFile($.trim($file.val()),checkFileSize($file[0]),uploadBtnId)){
				return false;
			}
		}
		$uploadBtn.attr("disabled", "disabled");// 上传期间使上传、关闭按钮失效
		$upLoadImg.show();
		$("#"+formId).ajaxSubmit({
			type : "post",
			url : url,
			// data : $('#fileUploadFormFrom').formSerialize(),不需要
			enctype : 'multipart/form-data',
			resetForm : true,
			async : false,
			timeout: 300000,
			success : function(data) {
				if (data.code) {
					if(otherFun) {
						otherFun(data, isReadonly);
					}
					$upLoadImg.hide();// 隐藏上传窗口
					$.dopAlertWithNoBtns("上传文件[" + $fileName + "]成功.");// 提示上传结果
					videosQuery();
				} else {
					$upLoadImg.hide();// 隐藏上传窗口
					if(data.msg!="") {
						$.dopAlert(data.msg);// 提示上传错误信息
					} else {
						$.dopAlert("上传文件[" + $fileName + "]失败.");
					}
				}
				$uploadBtn.removeAttr("disabled");
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$.dopAlert("上传文件[" + $file.val() + "]异常."+ textStatus);
				$upLoadImg.hide();
				$uploadBtn.removeAttr("disabled");
			}
		});
	});
}

function getModel(vdFile, len, isReadonly) {
	return "<div class='span3 file' style='margin-left: 0px;margin-bottom: 10px;'>" +
				"<div style='width:100%;height:auto;'>" +
					"<a data-toggle='modal' class='vdfile' " +
						"data-id='"+vdFile.employeeVideoId+"' " +
						"data-path='"+vdFile.filePath+"' " +
						"data-saveName='"+vdFile.saveFileName+"' " +
						"data-sname='"+vdFile.sourceFileName+"' " +
						"data-type='"+vdFile.fileType+"' " +
						"data-size='"+len+"' title='' href='#responsive'>" +
					"<img src='"+resBase+"/image/file150921.jpg' alt=''><br/>" +
					"<strong>" +
						"<span>"+vdFile.sourceFileName+"."+vdFile.fileType+"</span>" +
					"</strong>" +
					"</a>" +
					"<br>" +
				"</div>" + 
				(isReadonly ? "" : "<div style='width:100%;height:auto;'>" +
										"<span class='btn red deletebtn'>" +
											"<span class='icon-trash'></span>&nbsp;删除" +
										"</span>" +
										"<br>" +
									"</div>") +
				
			"</div>"
}

function initEntryFiles(data, isReadonly) {
	$("#fileInfo").html("");
	// 获取数据源并显示
	if(data && data.result) {
		for(var i in data.result) {
			$("#fileInfo").append(getModel(data.result[i], data.result.length, isReadonly));
		}
	}
}

function checkFileSize(obj) {
	var size = 0;
	if (obj.files[0]) {
		size = obj.files[0].size / 1048576;
	}
	return Number(size);
}

function validBaseFile(fileName, fileSize,allowTypes,uploadBtnId) {
	var btnalert = ""; 
	if(uploadBtnId=="importBtn"){
		btnalert="请导入预入职名单";
	}else{
		btnalert="请选择上传文件";
	}
	
	if (!fileName) {
		$.dopAlert(btnalert);
		return false;
	}
	if (fileSize <= 0) {
		$.dopAlert(btnalert);
		return false;
	}
	
	var fileArr = fileName.split(".");
	var ftype =  fileArr[fileArr.length - 1].toUpperCase();
	if (fileArr.length > 2 || fileArr.length <= 1 || $.inArray(ftype,allowTypes) == -1) {
		$.dopAlert("请选择正确文件格式上传");
		return false;
	}
	return validFileSize(ftype,fileSize);
}

function validateFile(fileName,fileSize,uploadBtnId) {
	if(!validBaseFile(fileName,fileSize,["RAR","JPG","PNG","PDF"],uploadBtnId)) {
		return false;
	}
	
	return true;
}

function validFileSize(ftype,fileSize) {
	if (ftype === "RAR") {
		// 大于20M
		if (fileSize > 20) {
			$.dopAlert("您上传的文件过大,请重新选择");
			return false;
		}
	} else if(ftype === "XLS") {
		// XLS文件大小不限定
	} else {
		if (fileSize > 1) {
			$.dopAlert("您上传的文件过大,请重新选择");
			return false;
		}
	}
	return true;
}


function validExcelFile(fileName,fileSize,uploadBtnId) {
	return validBaseFile(fileName,fileSize,["XLS"],uploadBtnId);
}

function del(fileId, employeeId, sourceFileName,successFun, isReadonly) {
	$.dopConfirm("确认删除文件[" + sourceFileName + "]吗？", null, function(r) {
		if (r) {
			$.ajax({
				url : base + '/hrFile/deleteFiles.json',// 请求url
				type : "POST",
				async : true,
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify({"employeeVideoId":fileId,"employeeId":employeeId}),
				timeout : 30000,
				success : function(data) {
					if(data) {
						if(data.isSuccess == 1) {
							$.dopAlertWithNoBtns("删除文件[" + sourceFileName + "]成功.");
							videosQuery();
						} else {
							$.dopAlert("删除文件[" + sourceFileName + "]失败.");
						}
					}
				},
				error : function(data) {
					$.dopAlert("删除文件[" + sourceFileName + "]异常");
				}
			});
		}
	});
}

function initFileEvents(isReadonly) {
	var path,saveName,sname,type,size;
	$("#fileInfo").on("click","a.vdfile",function(){
		path = $(this).data().id;
		saveName = $(this).data().savename;
		sname = $(this).data().sname;
		type = $(this).data().type;
		size = $(this).data().size;
		videoImgClick(path,saveName,type,sname,size);
	});
	var $group,fileId,fileName;
	$("#fileInfo").on("click","span.deletebtn",function(){
		$group = $(this).closest("div.file").find("a.vdfile");
		fileId = $group.data().id;
		fileName = $group.data().sname;
		del(fileId,employeeId,fileName,initEntryFiles,isReadonly);
	});
}

function getFileNumber() {
	var $vdfile = $("#fileInfo a.vdfile");
	return {
		lzzm:$vdfile.find("span:contains('离职证明')").length,
		sfz:$vdfile.find("span:contains('身份证')").length,
		hkb:$vdfile.find("span:contains('户口本')").length,
		tjbg:$vdfile.find("span:contains('体检报告')").length,
		xlzm:$vdfile.find("span:contains('学历证明')").length
	};
}

function getFileNames(newFileName) {
	var nfiles = [],sname;
	$("#fileInfo a.vdfile").each(function(index,item) {
		sname = $(item).data().sname;
		nfiles.push($(item).data().sname);
	});
	return $.inArray(newFileName,nfiles);
}

function videosQuery(){
	var employeeId = $("#employeeId").val();
	$.ajax({
		url : base + '/hrFile/queryFile.json?employeeId=' + employeeId,// 请求url
		type : "POST",
		async : true,
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			if(data){
				$("#fileInfo").html("<div class='control-group' id='vFile' style='text-align:center;height:auto;'></div>");
				for(var i in data) {
					var filenum=parseInt(i)+1;
					$("#vFile").append("<input type='hidden' name='videosImg' value='"+data[i].saveFileName+";"+data[i].filePath+";"+data[i].fileType+";"+data[i].sourceFileName+"."+data[i].fileType+"'/>"+
		                          "<div id='"+data[i].employeeVideoId+"FileDiv'>"+
		                 "<input type='hidden' name='videoImg' value='"+data[i].employeeVideoId+";"+data[i].filePath+";"+data[i].fileType+";"+data[i].sourceFileName+"."+data[i].fileType+"'/><div style='margin-left: 0px;margin-bottom: 10px;' class='span3 file del"+data[i].employeeVideoId+"'>"+
							"<div><a href='#responsive' title='' data-size='"+filenum+"' data-type='"+data[i].fileType+"' data-sname='"+data[i].sourceFileName+"' data-savename='"+data[i].saveFileName+"' data-path='"+data[i].filePath+"' data-id='"+data[i].employeeVideoId+"' class='vdfile' data-toggle='modal'>"+
							"<img alt='' src='"+resBase+"/image/file150921.jpg'><br><strong><span>"+data[i].sourceFileName+"."+data[i].fileType+"</span></strong></a><br></div>"+
							"<div style='width:100%;height:auto;'>"+
								"<span class='btn red deletebtn'>"+
									"<span class='icon-trash'></span>&nbsp;删除</span><br></div></div></div>");
				}
				
			}
		},
		error : function(data) {
		}
	});
}

