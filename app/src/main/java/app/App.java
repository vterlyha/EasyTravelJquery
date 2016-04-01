package app;

import java.util.List;

import entity.City;
import entity.Country;
import service.BookingService;
import service.CityService;
import service.ClientService;
import service.CountryService;
import service.HotelService;

public class App {
	
    public static void main( String[] args ) {
//    	CountryService countryS = new CountryService();
//        countryS.addCountry(new Country(0, "Thailand"));
//        System.out.println("Element added");
//        System.out.println(countryS.getCountryById(20));
//        countryS.deleteCountry(countryS.getCountryById(20));
//        System.out.println("Element deleted");
//        System.out.println(countryS.getCountryById(20));
//    	System.out.println(countryS.getAllCountries());
//    	
//        CityService cityS = new CityService();
//        cityS.addCity(new City(0, "Santorini", countryS.getCountryById(2)));
//        System.out.println("Element added");
//        System.out.println(cityS.getCityById(11));
//        cityS.deleteCity(cityS.getCityById(11));
//        System.out.println("Element deleted");
//        System.out.println(cityS.getCityById(11));
//        System.out.println(cityS.getAllCities());
//        
//        CityService cs = new CityService();
//          System.out.println(cs.findAllHotels("Burgas"));
//        
//        HotelService hs = new HotelService();
//          System.out.println(hs.findAllHotels(2));
//        
//        BookingService bs = new BookingService();
//        System.out.println(bs.findFreeAllHotels(2));
//        
//        BookingService bs2 = new BookingService();
//        System.out.println(bs2.findAllVisas(1));
//        
        ClientService clientService = new ClientService();
        System.out.println(clientService.findAllCountriesClientVisited(1));
//        
//        HotelService hs2 = new HotelService();
//        List <Object[]> list = hs2.findInfoAboutHotels(2);
//        for (Object [] o : list) {
//            System.out.print((Long)o[0] + " ");
//            System.out.println(((Double)o[1]).intValue());
//        }
    }
}
