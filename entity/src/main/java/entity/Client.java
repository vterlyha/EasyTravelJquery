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

@Entity
@NamedQueries({
    @NamedQuery(name="getAllCountriesClientVisited", 
    		query="select countries.name "
            + "from Country countries "
            + "right join Booking bookings on (countries.id = bookings.country.id) "
            + "where bookings.client.id=:clientId"),
    @NamedQuery(name = "Client.countVisas",
    		query = "select count(ctr.id) "
    		+ "from Booking book "
    		+ "join book.client cl "
    		+ "join book.country ctr "
    		+ "where cl.id = :clientId ")
    })
@Table (name = "clients")
public class Client {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)         
    private Integer id;
    
    @Column(name = "firstName")
    private String firstName;
    
    @Column(name = "lastName")
    private String lastName;
    
    @Column(name = "sex")
    private String sex;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phoneNumber")
    private Integer phoneNumber;
    
    @ManyToOne(optional=false, targetEntity=Address.class, cascade={CascadeType.ALL})
    @JoinColumn(name="addressId", referencedColumnName="id")
    private Address address;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="client")
    private Set<Booking> bookings;
    
    public Client() {
    }
    
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
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
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
