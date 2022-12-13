$("input[name$='AmountFrom']").live("change", function() {
	if(!(/^(([1-9]\d*)|\d)(\.\d{1,2})?$/).test($(this).val())){
		$(this).val('');
		return;
	}
});

$("input[name$='AmountTo']").live("change", function() {
	if(!(/^(([1-9]\d*)|\d)(\.\d{1,2})?$/).test($(this).val())){
		$(this).val('');
		return;
	}
});