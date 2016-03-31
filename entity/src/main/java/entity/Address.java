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
@Table (name = "address")
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    private Integer id;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "street")
    private String street;
    
    @Column(name = "houseNumber")
    private Integer houseNumber;
    
    @Column(name = "roomNumber")
    private Integer roomNumber;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="address")
    private Set<Client> clients;
    
    public Address() {
    }
    
    public Address(Integer id, String city, String street, Integer houseNumber, Integer roomNumber) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.roomNumber = roomNumber;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public Integer getHouseNumber() {
        return houseNumber;
    }
    
    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }
    
    public Integer getRoomNumber() {
        return roomNumber;
    }
    
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    public Set<Client> getClients() {
        return clients;
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
