package com.java.tour_firm.service;

import java.util.List;

import com.java.tour_firm.dao.DAOFactory;
import com.java.tour_firm.entity.Address;

public class AddressService {
    
    public void addAddress(Address address) {
        DAOFactory.getInstance().getAddressDAO().addElement(address);
    }
    
    public void updateAddress(Address address) {
        DAOFactory.getInstance().getAddressDAO().updateElement(address);
    }
    
    public Address getAddressById(Integer addressId) {
        return DAOFactory.getInstance().getAddressDAO()
                .getElementByID(addressId);
    }
    
    public List<Address> getAllAddresses() {
        return DAOFactory.getInstance().getAddressDAO()
                .getAllElements();
    }
    
    public void deleteAddress(Address address) {
        DAOFactory.getInstance().getAddressDAO().deleteElement(address);
    }
}
