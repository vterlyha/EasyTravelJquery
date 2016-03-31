package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AddressDAO;
import entity.Address;

@Service
public class AddressService {
    
    @Autowired
    private AddressDAO addressDao;
    
    public AddressService() {
    }
    
    @Transactional
    public void addAddress(Address address) {
        addressDao.addElement(address);
    }
    
    @Transactional
    public void updateAddress(Address address) {
        addressDao.updateElement(address);
    }
    
    @Transactional
    public Address getAddressById(Long addressId) {
        return addressDao.getElementByID(addressId);
    }
    
    @Transactional
    public List<Address> getAllAddresses() {
        return addressDao.getAllElements();
    }
    
    @Transactional
    public void deleteAddress(Address address) {
        addressDao.deleteElement(address);
    }
}
