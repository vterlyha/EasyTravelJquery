package daoImpl;

import org.springframework.stereotype.Repository;

import dao.CountryDAO;
import entity.Country;

@Repository
public class CountryDAOImpl extends ElementDAOImpl<Country, Long> implements CountryDAO {

	public CountryDAOImpl() {
		super(Country.class);
	}
}
