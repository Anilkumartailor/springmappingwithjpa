package com.imlabs.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imlabs.model.ContactMysql;
import com.imlabs.repositories.ContactRepositoryMysql;
@Service
@Transactional
public class ContactServiceImpl implements ContactService {
    
	@Autowired
	ContactRepositoryMysql contactRepositoryMysql;
	@Override
	public ContactMysql insertContact(ContactMysql contact) {
		return contactRepositoryMysql.save(contact);
		
	}

	@Override
	public List<ContactMysql> findAllContacts() {
		return contactRepositoryMysql.findAll();
	}

	@Override
	public void deleteContact(long id) {
		contactRepositoryMysql.delete(id);
		
	}

	@Override
	public void updateContact(ContactMysql contact) {
		contactRepositoryMysql.save(contact);
		
	}

	@Override
	public ContactMysql getContactById(long id) {
		return contactRepositoryMysql.findOne(id);
	}

	@Override
	public List<ContactMysql> findContactsForArea(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
