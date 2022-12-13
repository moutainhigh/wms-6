$("input[name$='Begin']").live("change", function() {
		if($(this).attr("name")=="expectLenderDateBegin"){
			compareToSysDate(this);
			return;
		}
		var dateArray=getDateArray(this);
		if(dateArray[0]>dateArray[1]){
			$(this).val("");
		}
		compareDate(1,this);
});

$("input[name$='End']").live("change", function() {
	var input=$(this).parent().parent().siblings().find("input");
	if($(this).attr("name")=="expectLenderDateEnd"){
		compareDate(3,this);
		return;
	}
	if($(input).val()==""){
		$(this).val("");
	}
	compareDate(2,this);
});

/**
 * 判断日期是否小于系统时间,小于则清空当前时间 
 */
function judgeWithSysDate(obj){
	var dateArray = getDateArray();
	if(dateArray[0]<dateArray[1]){
		$(obj).val("");
	}
}

/**
 * 判断首日期是否小于系统系统时间和大于尾日期
 */

function compareToSysDate(obj){
	var nextDate = $(obj).parent().parent().next().find("input");
	var dates = getDateArray(obj);
	if(dates[0]<dates[1]){
		$(obj).val("")
	}
	if($(nextDate).val()!=''){
		var nextDates = getDateArray(nextDate);
		if(nextDates[0]<dates[0]){
			$(nextDate).val("");
		}
	}
}

/**
 *获得日期数组
 */
function getDateArray(obj){
//	var dateArray=[];
//	var dateArr = $(obj).val().split("-");
//	var year = dateArr[0];
//	var month = dateArr[1];
//	var day = dateArr[2];
//	var selDate = new Date($(obj).val());
//	selDate.setFullYear(year, month - 1, day);
//	var curDate = new Date();
//	dateArray.push(selDate);
//	dateArray.push(curDate);
//	return dateArray;
	var dateArray=[];
	var sysDate = new Date();
	dateArray.push(replaceDate(obj));
	dateArray.push(new Date(sysDate.getFullYear() + "/"
			+ (sysDate.getMonth() + 1) + "/" + sysDate.getDate()));
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
	//当起始时间晚于截止时间时清空截止时间
	if(flag==1){
		if(dateArray_1[0]>dateArray_2[0]){
			$(input).val("");
		}
	}
	if(flag==2){
		//当截止时间早于起始时间,或截止时间晚于系统时间清空截止时间
		if(dateArray_1[0]<dateArray_2[0]||dateArray_1[0]>dateArray_1[1]){
			$(selDate).val("");
		}
	}
	if(flag==3){
		//当截止时间早于起始时间,或截止时间早于系统时间清空截止时间
		if(dateArray_1[0]<dateArray_2[0]||dateArray_1[0]<dateArray_1[1]){
			$(selDate).val("");
		}
	}
}
