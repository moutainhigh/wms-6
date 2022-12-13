$(function() {
	if(status=="Q"||biz!="employee"){
		document.getElementById("print-btn").style.display="none";
	}
	$(".btn-print").click(function() {
		var url = base+"/hrPrint/print.json?employeeId="+employeeId;
		window.open(url);
	});
});