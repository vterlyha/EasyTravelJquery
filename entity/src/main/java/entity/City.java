package entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="findAllHotelsByCityName", 
			query="SELECT hotels.name FROM Hotel hotels, City cities "
	        + "WHERE cities.id = hotels.city.id and cities.name =:cityName"),
	@NamedQuery(name = "City.getCityByCountryId", 
			query = "select city.name "
			+ "from City city "
			+ "join city.country ctr "
			+ "where city.id = :countryId ")
})

@Table(name = "cities")
public class City {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(optional=false, targetEntity=Country.class)
	@JoinColumn(name="countryId")
	private Country country;
	
	@OneToMany(mappedBy="city")
	private Set<Hotel> hotels;
	
	@OneToMany(mappedBy="city")
	private Set<Booking> bookings;

	public City() {}
	
	public City(Integer id, String name, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public Set<Hotel> getHotels() {
		return hotels;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	    	return false;
        if (getClass() != obj.getClass())
            return false;
        City other = (City) obj;
        if (id != other.id) {
            return false;
        }
        if (name != other.name) {
            return false;
        }
        if (country != other.country) {
            return false;
        }
        return true;
    }    
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    
    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + 
        		name + ", country=" + country + "]";
    }
	    
}
