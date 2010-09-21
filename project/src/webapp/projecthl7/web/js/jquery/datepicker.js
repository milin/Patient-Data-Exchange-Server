$(function() {
		$('#dateJob').datepicker({
		dateFormat:'dd-mm-yy', 
		changeMonth: true,
		changeYear: true,
		showOn: 'button', buttonImage: 'css/base/images/calendar.gif', buttonImageOnly: true
		});
		$('#dateBird').datepicker({
		dateFormat:'dd-mm-yy',
		changeMonth: true,
		changeYear: true,
		showOn: 'button', buttonImage: 'css/base/images/calendar.gif', buttonImageOnly: true
		});
		$('#dataExpire').datepicker({
		dateFormat:'dd-mm-yy',
		changeMonth: true,
		changeYear: true,
		showOn: 'button', buttonImage: 'css/base/images/calendar.gif', buttonImageOnly: true	
		});
	});

	