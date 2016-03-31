package implementation;

import dao.AddressDAO;
import entity.Address;

public class AddressDAOImpl extends ElementDAOImpl<Address, Long> implements AddressDAO {

    public AddressDAOImpl() {
        super(Address.class);
    }
}
