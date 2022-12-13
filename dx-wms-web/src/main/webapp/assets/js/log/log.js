$(function() {
	$(".log").live("click", function() {
		var url = base + "/log/log.json?applyId=" + $(this).attr('lenderApplyId')
		$.get(url, function(data) {
	        $('#logModal').html(data);
	    });
	    $('#logModal').modal({
	        show : true
	    });	
	});
});