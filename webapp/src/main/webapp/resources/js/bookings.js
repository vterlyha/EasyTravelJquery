$(document).ready(function() {
	
	$('select[name=countryValue]').on('change', function() {
		   function getCitiesByCountryId() {
			   var countryId = $('select[name=countryValue]').val();
			      $.ajax({
			    	type: 'GET',
			        url: 'getCitiesByCountryId',
			        data: {"countryId" : countryId},
			        success: function(data) {
			        	alert("Hello");
			        }
			      });
			    }
		});
});

