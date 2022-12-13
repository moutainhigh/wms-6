$("#reset").click(function(){ 
	$("#queryForm").find(":input").not(":button,:submit,:reset,:hidden").val("").removeAttr("checked").removeAttr("selected").parent().removeClass('checked');;
	$("#queryForm").find("select").val("-1");
	$("select[name=result_length]").val(15);   
});