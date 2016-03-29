package com.java.tour_firm;

import com.java.tour_firm.service.CityService;
import com.java.tour_firm.service.CountryService;

public class App {
    public static void main( String[] args ) {
    	CountryService countryS = new CountryService();
//        countryS.addCountry(new Country(0, "Thailand"));
//        System.out.println("Element added");
//        System.out.println(countryS.getCountryById(20));
//        countryS.deleteCountry(countryS.getCountryById(20));
//        System.out.println("Element deleted");
//        System.out.println(countryS.getCountryById(20));
    	System.out.println(countryS.getAllCountries());
    	
        CityService cityS = new CityService();
//        cityS.addCity(new City(0, "Santorini", countryS.getCountryById(2)));
//        System.out.println("Element added");
//        System.out.println(cityS.getCityById(11));
//        cityS.deleteCity(cityS.getCityById(11));
//        System.out.println("Element deleted");
//        System.out.println(cityS.getCityById(11));
        System.out.println(cityS.getAllCities());        
    }
}
