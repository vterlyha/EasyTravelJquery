package entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This class describes clients of travel agency live.  
 * 
 * This Client entity has a one to many relationship with Booking
 * entity and many to one with Address entity.
 * 
 * @author Volodymyr Terlyha, Taras Varvariuk
 */
@Entity
@NamedQueries({
    @NamedQuery(name="getAllCountriesClientVisited", 
    		query="select countries.name "
            + "from Country countries "
            + "right join Booking bookings on (countries.id = bookings.country.id) "
            + "where bookings.client.id=:clientId"),
    @NamedQuery(name = "countVisas",
    		query = "select count(ctr.id) "
    		+ "from Booking book "
    		+ "join book.client cl "
    		+ "join book.country ctr "
    		+ "where cl.id = :clientId ")
    })
@Table (name = "clients")
public class Client {
    
	/**
     * Describes the client id. Unique value.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)         
    private Integer id;
    
    /**
     * Describes clients first name.
     */
    @Column(name = "firstName")
    private String firstName;
    
    /**
     * Describes clients last name.
     */
    @Column(name = "lastName")
    private String lastName;
    
    /**
     * Describes clients sex.
     */
    @Column(name = "sex")
    private String sex;
    
    /**
     * Describes clients email.
     */
    @Column(name = "email")
    private String email;
    
    /**
     * Describes clients phoneNumber.
     */
    @Column(name = "phoneNumber")
    private Integer phoneNumber;
    
    /**
     * Describes address where client lives.
     * Has a many to one relationship to address table.
     */
    @ManyToOne(fetch=FetchType.LAZY, optional=false, targetEntity=Address.class, cascade={CascadeType.ALL})
    @JoinColumn(name="addressId", referencedColumnName="id")
    private Address address;
    
    /**
     * Describes all bookings associated with the client.
     * Has a one to many relationship to bookings table.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy="client")
    private Set<Booking> bookings;
    
    /**
     * Constructor without parameters.
     */ 
    public Client() {
    }
    
    /**
     * Constructor with parameters.
     */ 
    public Client(Integer id, String firstName, String lastName, String sex, String email, Integer phoneNumber, 
            Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
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
     * Get value of column firstName.
     * 
     * @return value of column firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set value of column firstName.
     * 
     * @param firstName
     *            value of column firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get value of column lastName.
     * 
     * @return value of column lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set value of column lastName.
     * 
     * @param lastName
     *            value of column lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get value of column sex.
     * 
     * @return value of column sex.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Set value of column sex.
     * 
     * @param sex
     *            value of column sex.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Get value of column email.
     * 
     * @return value of column email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value of column email.
     * 
     * @param email
     *            value of column email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get value of column phoneNumber.
     * 
     * @return value of column phoneNumber.
     */
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set value of column phoneNumber.
     * 
     * @param phoneNumber
     *            value of column phoneNumber.
     */
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Get value of column address.
     * 
     * @return value of column address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set value of column address.
     * 
     * @param address
     *            value of column address.
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    
    /**
     * Get value of column bookings.
     * 
     * @return value of column bookings.
     */
    public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
 
    /**
     * Set value of column bookings.
     * 
     * @param bookings
     *            value of column bookings.
     */
    public Set<Booking> getBookings() {
        return bookings;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }        
        if (getClass() != obj.getClass()) {
            return false;
        }
        Client other = (Client) obj;
        if (id != other.id) {
            return false;
        }      
        if (firstName != other.firstName) {
            return false;
        }        
        if (lastName != other.lastName) {
            return false;
        }       
        if (sex != other.sex) {
            return false;
        }       
        if (email != other.email) {
            return false;
        }
        if (phoneNumber != other.phoneNumber) {
            return false;
        }
        if (address != other.address) {
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
        return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex +
               ", email=" + email + ", phoneNumber=" + phoneNumber + ",adress=" + address + "]";
    }
}
