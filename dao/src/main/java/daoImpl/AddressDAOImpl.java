package daoImpl;

import org.springframework.stereotype.Repository;

import dao.AddressDAO;
import entity.Address;

@Repository
public class AddressDAOImpl extends ElementDAOImpl<Address, Long> implements AddressDAO {

    public AddressDAOImpl() {
        super(Address.class);
    }
}
