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
    				$.each(val, function() {
    				$selectCities.append('<option value="' + this.id + '">' + this.name + '</option>');
    				});
    			});
			}
		});
	});
	
	$('select[name=cityValue]').on('change', function() {
		var cityId = $('select[name=cityValue]').val();
		var $selectHotels = $('select[name=hotelValue]');
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
    			$.each(data, function(key, val){
    				$.each(val, function() {
    				$selectHotels.append('<option value="' + this.id + '">' + this.name + '</option>');
    				});
    			});
			}
		});
	});
});

