$(document).ready(function() {

	$('select[name=countryId]').on('change', function() {
		var countryId = $('select[name=countryId]').val();
		var $selectCities = $('select[name=cityId]');
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
				$selectCities.append('<option>Select city</option>');
				$.each(data, function(key, val) {
                    $.each(val, function(keyInner, valueInner) {
                        $selectCities.append('<option value="' + valueInner.id + '">' +
                                             valueInner.name + '</option>');
                    });
                });
			}
		});
	});
	
	$('select[name=cityId]').on('change', function() {
		var cityId = $('select[name=cityId]').val();
		var $selectHotels = $('select[name=hotelId]');
		var citiesList = '&(citiesList)';
		$.ajax({
			type : "GET",
			url : "getHotelsByCityId",
			data : {
				"cityId" : cityId
			},
			dataType:'JSON',
			success : function(data) {
				$selectHotels.html('');
				$selectHotels.append('<option>Select hotel</option>');
				$.each(data, function(key, val) {
                    $.each(val, function(keyInner, valueInner) {
                        $selectHotels.append('<option value="' + valueInner.id + '">' +
                                             valueInner.name + '</option>');
                    });
                });
			}
		});
	});
});

