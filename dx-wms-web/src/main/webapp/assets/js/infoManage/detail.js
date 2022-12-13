$(function(){
	$("body").addClass("page-sidebar-closed");
});


$("#dirs").change(function(){
	$("#imageDataportlet :first > div").not("#dir,#fileTitle").hide();
	var id = $(this).val();
	id == -1 ? $("#fileName").show() : $("#"+id).show();
	$("#"+id +" > select").val("-1");
});

$(".files").live("change",function(){
	var url = base+$(this).val();
	$("#flashObj").attr("data","");
	$("#flashObj").attr("data",url);
});
