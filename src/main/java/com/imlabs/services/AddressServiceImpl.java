package com.imlabs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imlabs.model.AddressMysql;
import com.imlabs.repositories.AddressRepositoryMysql;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressRepositoryMysql addressRepositoryMysql;

	@Override
	public void insertAddress(AddressMysql address) {
		// TODO Auto-generated method stub
		addressRepositoryMysql.save(address);
	}

	@Override
	public List<AddressMysql> findAllAddress() {
		// TODO Auto-generated method stub
		addressRepositoryMysql.findAll();
		return null;
	}

	@Override
	public void deleteAddress(long id) {
		// TODO Auto-generated method stub
		addressRepositoryMysql.delete(id);
		
	}

	@Override
	public void updateAddress(AddressMysql address) {
		// TODO Auto-generated method stub
		addressRepositoryMysql.save(address);
		
	}

	@Override
	public AddressMysql getAddressById(long id) {
		// TODO Auto-generated method stub
		addressRepositoryMysql.findOne(id);
		return null;
	}
	
}
