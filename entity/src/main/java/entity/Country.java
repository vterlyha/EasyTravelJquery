package entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "visaRequired")
	private Boolean visaRequired;
	
	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private Set<City> cities;
	
	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private Set<Booking> bookings;

	public Country() {}
	
	public Country(Integer id, String name, Boolean visaRequired) {
		super();
		this.id = id;
		this.name = name;
		this.visaRequired = visaRequired;
	}

	public Boolean getVisaRequired() {
		return visaRequired;
	}

	public void setVisaRequired(Boolean visaRequired) {
		this.visaRequired = visaRequired;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public Set<City> getCities() {
		return cities;
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
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	    	return false;
        if (getClass() != obj.getClass())
            return false;
        Country other = (Country) obj;
        if (id != other.id) {
            return false;
        }
        if (name != other.name) {
            return false;
        }
        if (cities != other.cities) {
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
        return "Country [id=" + id + ", name=" + name + "]";
    }
}
