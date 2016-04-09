$(document).ready(function() {

	$('select[name=countryValue]').on('change', function() {
		var countryId = $('select[name=countryValue]').val();
		var $selectCities = $('select[name=cityValue]');
		var citiesList = '&(citiesList)';
		$.ajax({
			type : "GET",
			url : "getCitiesByCountryId",
			data : {
				"countryId" : countryId
			},
			dataType:'JSON',
			success : function(data) {
				$selectCities.html('');
    			$.each(data, function(key, val){
    				$.each(val, function(city) {
    				$selectCities.append('<option id="' + city.id + '">' + city.name + '</option>');
    				});
    			});
			}
		});
	});
});

