package com.java.tour_firm.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "bookings")
public class Booking {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dateFrom")
    private Date dateFrom;

    @Column(name = "dateTo")
    private Date dateTo;
    
    @Column(name = "visaSerial")
    private Integer visaSerial;

    @ManyToOne(fetch=FetchType.LAZY, optional=false, targetEntity=Country.class, cascade={CascadeType.ALL})
    @JoinColumn(name="countryId", referencedColumnName="id")
    private Country country;

    @ManyToOne(fetch=FetchType.LAZY, optional=false, targetEntity=City.class, cascade={CascadeType.ALL})
    @JoinColumn(name="cityId", referencedColumnName="id")
    private City city;

    @ManyToOne(fetch=FetchType.LAZY, optional=false, targetEntity=Hotel.class, cascade={CascadeType.ALL})
    @JoinColumn(name="hotelId", referencedColumnName="id")
    private Hotel hotel;

    @ManyToOne(fetch=FetchType.LAZY, optional=false, targetEntity=Client.class, cascade={CascadeType.ALL})
    @JoinColumn(name="clientId", referencedColumnName="id")
    private Client client;

    @Column(name = "roomQuantity")
    private Integer roomQuantity;

    public Booking() {
    }
    
    public Booking(Integer id, Date dateFrom, Date dateTo, Country country, City city, Hotel hotel, 
    			 Client client, Integer roomQuantity ) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.country = country;
        this.city = city;
        this.hotel = hotel;
        this.client = client;
        this.roomQuantity = roomQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getRoomQuantity() {
        return roomQuantity;
    }

    public void setRoomQuantity(Integer roomQuantity) {
        this.roomQuantity = roomQuantity;
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
        Booking other = (Booking) obj;
        if (id != other.id) {
            return false;
        }      
        if (dateFrom != other.dateFrom) {
            return false;
        }        
        if (dateTo != other.dateTo) {
            return false;
        }       
        if (country != other.country) {
            return false;
        }       
        if (city != other.city) {
            return false;
        }
        if (hotel != other.hotel) {
            return false;
        }
        if (client != other.client) {
            return false;
        }
        if (roomQuantity != other.roomQuantity) {
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
        return "Booking [id=" + id + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", country=" + country +
               ", city=" + city + ", hotel=" + hotel + ", roomQuantity=" + roomQuantity + "]";
    }

}
