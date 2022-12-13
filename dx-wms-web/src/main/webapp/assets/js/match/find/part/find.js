$(function(){ 
	$(".find-next").unbind("click").bind('click',function(){
		$(".error").html('');
		if(checkItems()){
			$(".error").html('请先推荐债权后去匹配。');
			return;
		}
		if(checkAmount()){
			$(".error").html('请推荐足额债权后再进行匹配.');
			return;
		}
		var url =  base + $("#biz").val() + '/more/next.json';
		$.get(url, function(data) {
			if(data){
				$('#findBody').html(data);
				$(".find-next").hide();
				$("#join").hide();
				$(".match").show();
				$(".find-last").show();
				$(".error").html('');
			}
		});
	});	
	$(".find-last").unbind("click").bind('click',function(){
		var url =  base + $("#biz").val() + "/back.json";
		$.get(url, function(data) {
			if(data){
				$('#findBody').html(data);
				$(".find-next").show();
				$("#join").show();
				$(".match").hide();
				$(".find-last").hide();
				$(".error").html('');
			}
		});
	});
	$(".match").unbind("click").bind('click',function(){
		$(".error").html('匹配中,请稍后...');
		$.ajax({
			url : base + $("#biz").val() + '/match.json' ,// 请求url
			type : "POST",
			async: false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(items()),
			timeout : 10000,
			success : function(data) {
				if(data.result){
					$.dopAlert(data.msg);
					TableManaged.fnDraw();
					$('#findModal').html("");
					$('#findModal').modal('hide');
				}else{
					$(".error").html(data.msg);
				}
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				$(".error").html('操作异常');	
			}
		});	
	});
});
function items(){
	var items = [];
	$(".matchAmount").each(function() {	
		var item = {};
		item.totalAmount = $(this).attr('totalAmount');
		item.matchAmount = $(this).attr('matchAmount');
		item.creditPoolId = $(this).attr('creditPoolId');
		item.investPoolId = $(this).attr('investPoolId');
		items.push(item);
	});
	//console.log(items);
	return items;
}