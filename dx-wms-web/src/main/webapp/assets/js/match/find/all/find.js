$(function(){ 
	$(".match-save").hide();
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
		var url =  base + $("#biz").val() + '/one/next.json';
		$.get(url, function(data) {
			if(data){
				$('#findBody').html(data);
				$(".find-next").hide();
				$("#join").hide();
				$(".match").show();
				$(".find-last").show();
				$(".match-save").show();
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
				$(".match-save").hide();
				$(".error").html('');
			}
		});
	});
	$(".match-save").unbind("click").bind('click',function(){	
		$.ajax({
			url : base + $("#biz").val() + '/save.json' ,// 请求url
			type : "POST",
			async: false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(items()),
			timeout : 10000,
			success : function(data) {
				$(".error").html(data.msg);			    
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				$(".error").html('操作异常');	
			}
		});	
	});
	$(".match").unbind("click").bind('click',function(){		
		var needAmount = Math.round( $("#needAmount").html()*100);
		var matchAmounts = 0;
		$("input[name='matchAmount']").each(function() {
			matchAmounts = matchAmounts + Math.round($(this).val()*100);
		});
		if(needAmount != matchAmounts){
			var remain =  needAmount - matchAmounts;
			$(".error").html('匹配失败,剩余' + remain/100 + '元,未匹配.');
			return;
		}
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
	$("input[name='matchAmount']").each(function() {
		if(Math.round($(this).val()*100)>0 ){
			var item = {};
			item.matchAmount = $(this).val();
			item.totalAmount = $(this).attr('undoAmount');
			item.creditPoolId = $(this).attr('poolId');
			item.investPoolId = $('#poolId').val();	
			items.push(item);
		}
	});
	//console.log(items);
	return items;
}