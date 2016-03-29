package com.java.tour_firm.dao;

public class DAOFactory {
	
	private AddressDAO addressDAO = null;
    private BookingDAO bookingDAO = null;
    private ClientDAO clientDAO = null;
	private CountryDAO countryDAO = null;
	private CityDAO cityDAO = null;
	private HotelDAO hotelDAO = null;
	
	private static DAOFactory instance = null;
	
	private DAOFactory() {
		countryDAO = new CountryDAO();
		cityDAO = new CityDAO();
		hotelDAO = new HotelDAO();
		addressDAO = new AddressDAO();
		bookingDAO = new BookingDAO();
		clientDAO = new ClientDAO();
	}
	
	public static synchronized DAOFactory getInstance() {
		if (instance == null)
			instance = new DAOFactory();
		return instance;
	}
	
	public AddressDAO getAddressDAO() {
        return addressDAO;
    }
	
	public BookingDAO getBookingDAO() {
        return bookingDAO;
    }
	
	public ClientDAO getClientDAO() {
        return clientDAO;
    }

	public CountryDAO getCountryDAO() {
		return countryDAO;
	}

	public CityDAO getCityDAO() {
		return cityDAO;
	}

	public HotelDAO getHotelDAO() {
		return hotelDAO;
	}
}
