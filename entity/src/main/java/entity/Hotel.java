package entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name="findAllRoomsInHotelsByCityId", 
    		query="select hotels.roomQuantity "
            + "from Hotel hotels where hotels.city.id=:cityId"),
    
    @NamedQuery(name="findAvgRoomsBookingAndCountClientsForHotel", 
    		query="select count(bookings.client.id), "
            + "avg(bookings.dateTo - bookings.dateFrom) as AvgClientsStaying "
            + "from Booking bookings where bookings.hotel.id=:hotelId"),
    
    @NamedQuery(name = "Hotel.getRoomQuantity", 
			query = "select hot.roomQuantity "
			+ "from Hotel hot "
			+ "where hot.id = :hotId ")
})
@Table(name = "hotels")
public class Hotel {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "roomQuantity")
	private Integer roomQuantity;
	
	@ManyToOne(optional=false, targetEntity=City.class)
	@JoinColumn(name = "cityId")
	private City city;
	
	@OneToMany(mappedBy="hotel")
	private Set<Booking> bookings;
	
	public Hotel(){}
	
	public Hotel(Integer id, String name, City city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public Integer getRoomQuantity() {
		return roomQuantity;
	}

	public void setRoomQuantity(Integer roomQuantity) {
		this.roomQuantity = roomQuantity;
	}

	public Set<Booking> getBookings() {
		return bookings;
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	    	return false;
        if (getClass() != obj.getClass())
            return false;
        Hotel other = (Hotel) obj;
        if (id != other.id) {
            return false;
        }
        if (name != other.name) {
            return false;
        }
        if (city != other.city) {
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
        return "Hotel [id=" + id + ", name=" + name + ", "
        		+ "city=" + city + "]";
    }
}
