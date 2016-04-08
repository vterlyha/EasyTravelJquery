$(document).ready(function() {

	$('select[name=countryValue]').on('change', function() {
		var countryId = $('select[name=countryValue]').val();
		var $selectCities = $('select[name=cityValue]');
		$.ajax({
			type : "GET",
			url : "cities",
			data : {
				"countryId" : countryId
			},
			success : function(data) {
    			$.each(data, function(key, val){
    				$selectCities.append('<option id="' + val.id + '">' + val.name + '</option>');
    			});
			}
		});
	});
});

