package service;

import java.util.List;

import dao.DAOFactory;
import entity.Address;

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
