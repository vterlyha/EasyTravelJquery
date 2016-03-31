package implementation;

import dao.CountryDAO;
import entity.Country;

public class CountryDAOImpl extends ElementDAOImpl<Country, Long> implements CountryDAO {

	public CountryDAOImpl() {
		super(Country.class);
	}
}
