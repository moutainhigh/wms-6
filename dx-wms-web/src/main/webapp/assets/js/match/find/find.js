$(function(){ 
	$(".match").hide();
	$(".find-last").hide();
	$(".close-modal").unbind("click").bind("click", function() {
		var url =  base + $("#biz").val() + "/close.json";
		$.get(url, function(data) {
			if(data){
				$('#findModal').html("");
				$('#findModal').modal('hide');
				TableManaged.fnDraw();
			}
		});
	});
	$("#join").click(function(){
		var checkFlag = false;
		var items = [];
		$("input[name='creditItem']").each(function() {	
			if ($(this).attr("checked")) {
				var val = $(this).val();
				if(val != '-1' ){
					checkFlag = true;						
					items.push($.parseJSON(val));
				}
			}
		});
		if (!checkFlag) {
			$(".error").html("请选择您要推荐的债权");
			return false;
		}
		//post to controller		
		$.ajax({
			url : base + $("#biz").val() + '/join.json' ,// 请求url
			type : "POST",
			async: false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(items),
			timeout : 10000,
			success : function(data) {
				if(data.result){
					$("#all").removeAttr("checked");
				    $("#all").parent().removeClass("checked");
				    $("#totalAmounts").html(data.total.totalAmounts);
				    $("#matchAmounts").html(data.total.matchAmounts);
				    $("#remainAmounts").html(data.total.remainAmounts);
				    $("#totalCounts").html(data.total.totalCounts);
				    $("#matchCounts").html(data.total.matchCounts);
				    TableManagedFind.fnDraw();
				}
				$(".error").html(data.msg);	
				
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				$(".error").html('操作异常');	
			}
		});	
	});	
});
function checkItems(){
	$("input[name='creditItem']").each(function() {		
		if ($(this).attr("checked")) {
			return true;
		}
	});
}
function checkAmount(){
	var needAmount = Math.round($("#needAmount").html()*100);
	var totalAmounts = Math.round($("#totalAmounts").html()*100);
	return needAmount > totalAmounts;
}