package com.imlabs.services;

import java.util.List;

import com.imlabs.model.ContactMysql;

public interface ContactService {

	ContactMysql insertContact(ContactMysql course);
    List<ContactMysql> findAllContacts();
    void deleteContact(long id);
    void updateContact(ContactMysql course);
    ContactMysql getContactById(long id);
    List<ContactMysql> findContactsForArea(long id);
}
