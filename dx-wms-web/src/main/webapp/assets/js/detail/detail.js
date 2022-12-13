$(function() {
	$(".switch").live("click", function() {
		var id = $(this).attr("folderId");
		if($(this).hasClass("blue")){
			if($("#editModal")!=undefined){
			if($("#editModal").attr("class")=="modal hide fade edit-modal"){
				$("#editModal").html("");
			}
			}
			$("span[class='btn switch red']").removeClass("red");
			$("span[class='btn switch']").addClass("blue");
			$("span[class='btn switch blue']").html("展开");
			$(this).removeClass("blue");
			$(this).addClass("red");
			$(this).html("收起");
			$("#vFile").html($("#" +  id).html());
		}else{
			$(this).removeClass("red");
			$(this).addClass("blue");
			$(this).html("展开");
			$("#vFile").html("");
		}
		
	});
	$(".detail").live("click", function() {
		var url = "";
		if($(this).attr("custAccountId") != "" && $(this).attr("custAccountId") != null){
			url = base + "/detail/account_detail.json?id="+ $(this).attr("custAccountId");
		}else{
			url = base + "/detail/apply_detail.json?id="+ $(this).attr("lenderApplyId");
		}
		
		$.get(url, function(data) {
	        $('#detailModal').html(data);
	    });
	    $('#detailModal').modal({
	        show : true
	    });		
	    if($(this).attr("lenderApplyId") >0){
		    $('#editModal').html('');
		    url = base + "/detail/lenderApply.json?lenderApplyId="+ $(this).attr("lenderApplyId");
		    $.get(url, function(data) {
		    	setTimeout(function(){
					if(data.parentId!=null){
						$("#payInfo").children().slice(0,2).remove();
					}
				},1000);
		    });
		}
	});
});



