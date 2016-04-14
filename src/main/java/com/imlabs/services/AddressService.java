package com.imlabs.services;

import java.util.List;

import com.imlabs.model.AddressMysql;
public interface AddressService {
	void insertAddress(AddressMysql address);
    List<AddressMysql> findAllAddress();
    void deleteAddress(long id);
    void updateAddress(AddressMysql address);
    AddressMysql getAddressById(long id);
}
