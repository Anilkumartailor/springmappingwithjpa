package com.imlabs.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.imlabs.model.AddressMysql;
import com.imlabs.model.AreaContactMysql;
import com.imlabs.model.ContactMysql;
import com.imlabs.services.AddressService;
import com.imlabs.services.AreaContactService;
import com.imlabs.services.ContactService;

@RestController
@EnableAutoConfiguration
public class ContactController {
	@Autowired
	ContactService contactService;
	@Autowired
	AddressService addressservice;
	@Autowired
	AreaContactService areaContactService;
	//method to list all contact
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ResponseEntity<List<ContactMysql>> listAllContacts() {
    	System.out.println("+++++++++++++++++++++++++++++++++ok1");
        List<ContactMysql> contacts = contactService.findAllContacts(); 
        if(contacts.isEmpty()){
            return new ResponseEntity<List<ContactMysql>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<ContactMysql>>(contacts, HttpStatus.OK);
    }
  //method to list a contact with specific id
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactMysql> getContactById(@PathVariable("id") long id) {
    	System.out.println("+++++++++++++++++++++++++++++++++ok2");
        System.out.println("Fetching Contact with id " + id);
        ContactMysql contact = contactService.getContactById(id);
        if (contact == null) {
            System.out.println("Contact with id " + id + " not found");
            return new ResponseEntity<ContactMysql>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ContactMysql>(contact, HttpStatus.OK);
    }
    //method to create a new contact
    @RequestMapping(value = "/areacontact/{id}/contact", method = RequestMethod.POST , consumes={"application/json"})
    public ResponseEntity<Void> createContact(@PathVariable("id") long id ,@RequestBody Map contact,    UriComponentsBuilder ucBuilder) {
    	System.out.println("+++++++++++++++++++++++++++++++++ok3");
    	System.out.println("hello");
        System.out.println("Creating Contact " + contact.get("name").toString());
        AreaContactMysql area=areaContactService.getAreaById(id);

        ContactMysql courseMysql =  new ContactMysql(contact.get("name").toString() ,contact.get("dob").toString() ,contact.get("gender").toString(),contact.get("contact_no").toString(),contact.get("email").toString(), area);
       
       ContactMysql pk= contactService.insertContact(courseMysql);
       // AreaMysql pk=  areaService.insertArea(areaMysql);
        System.out.print("88888888888888888888888888888888888888888888888888888888888888888888888888888888888==="+pk.getContact_id());
    	
        AddressMysql addressMysql = new AddressMysql(contact.get("street").toString(),contact.get("city").toString(),contact.get("state").toString(),contact.get("zipcode").toString(),pk);
	       addressservice.insertAddress(addressMysql);
 
        HttpHeaders headers = new HttpHeaders();
       // headers.setLocation(ucBuilder.path("/course/{id}").buildAndExpand(course.get("id").toString()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  //method to update a contact
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ContactMysql> updateContact(@PathVariable("id") long id, @RequestBody Map course) {
    	System.out.println("+++++++++++++++++++++++++++++++++ok4");
        System.out.println("Updating Contact " + id);
         
        ContactMysql currentContact = contactService.getContactById(id);
         
        if (currentContact==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<ContactMysql>(HttpStatus.NOT_FOUND);
        }
 
        currentContact.setName(course.get("name").toString());
        currentContact.setDob(course.get("dob").toString());
        currentContact.setGender(course.get("gender").toString());
        currentContact.setContact_no(course.get("contact_no").toString());
        currentContact.setEmail(course.get("email").toString());
        
        contactService.updateContact(currentContact); 	        
        return new ResponseEntity<ContactMysql>(currentContact, HttpStatus.OK);
    }
    //method to delete a contact
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ContactMysql> deleteCourse(@PathVariable("id") long id) {
    	System.out.println("+++++++++++++++++++++++++++++++++ok5");
        System.out.println("Fetching & Deleting Contact with id " + id);
 
        ContactMysql contact = contactService.getContactById(id);
        if (contact == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<ContactMysql>(HttpStatus.NOT_FOUND);
        }
 
        contactService.deleteContact(id);
        return new ResponseEntity<ContactMysql>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(value = "/areacontact/contact/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ContactMysql>> listAllContactForArea(@PathVariable("id") long id) {
    	System.out.println("+++++++++++++++++++++++++++++++++ok6");
        List<ContactMysql> contacts = contactService.findContactsForArea(id);
        if(contacts.isEmpty()){
            return new ResponseEntity<List<ContactMysql>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<ContactMysql>>(contacts, HttpStatus.OK);
    }
 
    
    
}
