
var pageCount=0; 
var totalPage = 0;

$(document).ready(function(){
	var mydiv=document.getElementById("imgChangeDiv");
	var htmlval = $("#imgChangeDiv").html();
	if(null != htmlval && $.trim(htmlval) != "") {
		$("#imgChangeDiv").html("");
	}
	mydiv.style="position:absolute;z-index:10;float:right;overflow:hidden;display:inline-block;width:80%;text-align:center;";
	
	var fileName =document.createElement("input");
	fileName.style="border:none;font-weight:bold;";
	fileName.value="";
	fileName.id = "fileImgName";
	mydiv.appendChild(fileName);
	
	var backButton =document.createElement("input");
	backButton.type="button";
	backButton.value="上一页";
	backButton.id = "backVideoImg";
	backButton.className="btn blue";
	mydiv.appendChild(backButton);
	
	var pageView =document.createElement("input");
	pageView.style="border:none;width:80px;text-align:center;";
	pageView.value="";
	pageView.id = "pageViewName";
	mydiv.appendChild(pageView);
	
	var nextButton =document.createElement("input");
	nextButton.type="button";
	nextButton.value="下一页";
	nextButton.id = "nextVideoImg";
	nextButton.className="btn blue";
	mydiv.appendChild(nextButton);
	
});


var filevic="";//访问文件名
var filevicPath="";// 访问文件路径
var filevicType = ""; // 访问文件的类型

/**
 * 
 * @param filePath	访问文件名
 * @param saveFileName	访问文件路径
 * @param fileType		访问文件的类型
 * @param sourceFileName	文件源名称
 * @param fileSize			文件页数
 */
function videoImgClick(fileId,saveFileName,fileType,sourceFileName,fileSize){
	
	filevic = saveFileName;
	filevicPath = $("#"+fileId+"FileDiv > input").val();
	if(filevicPath.indexOf(";")>=0){
		if(filevicPath.split(";").length>=1){
			filevicPath=filevicPath.split(";")[1];
		}
	}
	filevicType = fileType;
	var videoCount = 0;
	$("#vFile > input[name='videosImg']").each(function(){
		videoCount++;
	});
	
	var arrImgDetailList = new Array();
	
	$("#vFile > input[name='videosImg']").each(function(){
		
		arrImgDetailList = $(this).val().split(";");
		if(arrImgDetailList[0]==saveFileName){
			sourceFileName = arrImgDetailList[3];
			return false;
		}
	});
	pageCount = fileSize;
	totalPage = videoCount;
	$("#backVideoImg").attr("onclick","backVideoImgClick(filevicPath,filevic,filevicType);");  
	$("#nextVideoImg").attr("onclick","nextVideoImgClick(filevicPath,filevic,filevicType);");  
	$("#fileImgName").val(sourceFileName+'    ');
	$("#pageViewName").val(pageCount+'/'+totalPage);
	
	var filePathStr = filevicPath +"/"+ filevic +".swf";
	initPage(filePathStr);
}

function backVideoImgClick(filePath,saveFileName,fileType){
	var imgGotoBool = false;
	var checkImgBool = false;
	var arrImgList = new Array();
	$("#vFile > input[name='videosImg']").each(function(i){
		arrImgList[i]=$(this).val();
	});
	if(pageCount<=1){
		return;
	}
	arrImgList.reverse();
	var arrImgDetailList = new Array();
	for(var img in arrImgList){
		arrImgDetailList = arrImgList[img].split(";");
		if(arrImgDetailList[0]==filevic){
			imgGotoBool = true;
		}else if(imgGotoBool){
			filevic = arrImgDetailList[0];
			filevicPath = arrImgDetailList[1];
			filevicType = arrImgDetailList[2];
			pageCount--;
			$("#fileImgName").val(arrImgDetailList[3]+'    ');
			$("#pageViewName").val(pageCount+'/'+totalPage);
			imgGotoBool = false;
			checkImgBool = false;
		}
	}
	
	if(checkImgBool){
		return;
	}
	
	var filePathStr = filevicPath +"/"+ filevic +".swf";
	initPage(filePathStr);
}


function nextVideoImgClick(filePath,saveFileName,fileType){
	//var fileSwf = filePath + "/" + saveFileName + ".swf"
	var imgGotoBool = false;
	var checkImgBool = true;
	var arrImgDetailList = new Array();
	$("#vFile > input[name='videosImg']").each(function(){
		arrImgDetailList = $(this).val().split(";");
		if(arrImgDetailList[0]==filevic){
			imgGotoBool = true;
		}else if(imgGotoBool){
			filevic = arrImgDetailList[0];
			filevicPath = arrImgDetailList[1];
			filevicType = arrImgDetailList[2];
			pageCount++;
			$("#fileImgName").val(arrImgDetailList[3]+'    ');
			$("#pageViewName").val(pageCount+'/'+totalPage);
			imgGotoBool = false;
			checkImgBool = false;
		}
	});
	if(checkImgBool){
		return;
	}
	
	var filePathStr = filevicPath +"/"+ filevic +".swf";
	initPage(filePathStr);
}


function initPage(filePathStr) {
	filePathStr="/"+filePathStr;
	$('#imgModal').modal({
        show : true
    });
	$('#documentViewer').FlexPaperViewer({ 
		config : {
			SWFFile : escape(filePathStr),
            Scale : 0.6,
            ZoomTransition : 'easeOut',
            ZoomTime : 0.5,
            ZoomInterval : 0.2,
            FitPageOnLoad : false,
            FitWidthOnLoad : true,
            FullScreenAsMaxWindow : false,
            ProgressiveLoading : false,
            MinZoomSize : 0.2,
            MaxZoomSize : 5,
            SearchMatchAll : false,
            InitViewMode : 'Portrait',
            RenderingOrder : 'flash,html',
            StartAtPage : '',
            ViewModeToolsVisible : true,
            ZoomToolsVisible : true,
            NavToolsVisible : true,
            CursorToolsVisible : true,
            SearchToolsVisible : true,
            WMode : 'window'
		}
	});
}
