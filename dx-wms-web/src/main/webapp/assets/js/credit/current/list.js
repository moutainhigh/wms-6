function stat(){
	$('#statBody').html('');
	$.ajax({
		url : base + "/credit/stat/current.json" ,// 请求url
		type : "POST",
		async: false,
		dataType : "html",
		contentType : "application/json",
		timeout : 10000,
		success : function(data) {
			$('#statBody').html(data);	
		}
	});	
}