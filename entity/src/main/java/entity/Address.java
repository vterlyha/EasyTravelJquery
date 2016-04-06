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

/**
 * This class describes address where clients of travel agency live.  
 * 
 * This Address entity has a one to many relationship with the Client
 * entity.
 * 
 * @author Volodymyr Terlyha, Taras Varvariuk
 */
@Entity
@Table (name = "address")
public class Address {

	/**
     * Describes the address id. Unique value.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    private Integer id;
    
    /**
     * Describes the city where client lives.
     */
    @Column(name = "city")
    private String city;
    
    /**
     * Describes the street where client lives.
     */
    @Column(name = "street")
    private String street;
    
    /**
     * Describes the houseNumber where client lives.
     */
    @Column(name = "houseNumber")
    private Integer houseNumber;
    
    /**
     * Describes the roomNumberNumber where client lives.
     */
    @Column(name = "roomNumber")
    private Integer roomNumber;
    
    /**
     * Describes all the clients that are associated with this address.
     * Has a one to many relationship to clients table.
     */    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="address")
    private Set<Client> clients;
    
    /**
     * Constructor without parameters.
     */ 
    public Address() {
    }
    
    /**
     * Constructor with parameters.
     */ 
    public Address(Integer id, String city, String street, Integer houseNumber, Integer roomNumber) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.roomNumber = roomNumber;
    }
    
    /**
     * Get value of column id.
     * 
     * @return value of column id.
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Set value of column id.
     * 
     * @param id
     *            value of column id.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Get value of column city.
     * 
     * @return value of column city.
     */
    public String getCity() {
        return city;
    }
    
    /**
     * Set value of column city.
     * 
     * @param city
     *            value of column city.
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * Get value of column street.
     * 
     * @return value of column street.
     */
    public String getStreet() {
        return street;
    }
    
    /**
     * Set value of column street.
     * 
     * @param street
     *            value of column street.
     */
    public void setStreet(String street) {
        this.street = street;
    }
    
    /**
     * Get value of column houseNumber.
     * 
     * @return value of column houseNumber.
     */
    public Integer getHouseNumber() {
        return houseNumber;
    }
    
    /**
     * Set value of column houseNumber.
     * 
     * @param houseNumber
     *            value of column houseNumber.
     */
    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }
    
    /**
     * Get value of column roomNumber.
     * 
     * @return value of column roomNumber.
     */
    public Integer getRoomNumber() {
        return roomNumber;
    }
    
    /**
     * Set value of column roomNumber.
     * 
     * @param roomNumber
     *            value of column roomNumber.
     */
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }    
    
    /**
     * Get all clients associated with this address.
     * 
     * @return of all clients associated with this address.
     */
    public Set<Client> getClients() {
        return clients;
    }
    
    /**
     * Changes list of clients for this address.
     * 
     * @param id
     *            list of clients for this address.
     */
    public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (id != other.id) {
            return false;
        }
        if (city != other.city) {
            return false;
        }
        if (street != other.street) {
            return false;
        }
        if (houseNumber != other.houseNumber) {
            return false;
        }
        if (roomNumber != other.roomNumber) {
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
        return "Adress [id=" + id + ", city=" + city + ", street=" + street + ", houseNumber=" + houseNumber +
               ", rooomNumber=" + roomNumber + "]";
    }
}
