package com.imlabs.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.imlabs.model.AreaContactMysql;
import com.imlabs.services.AreaContactService;

@RestController
@EnableAutoConfiguration
public class AreaContactController {
	@Autowired
	AreaContactService areaContactService;
	 //method to list all areas----
    @RequestMapping(value = "/areacontact", method = RequestMethod.GET)
    public ResponseEntity<List<AreaContactMysql>> listAllAreas() {
    	System.out.println("=======================================ok1");
        List<AreaContactMysql> areas = areaContactService.findAllAreas();
        //if list  of selected areas is empty
        if(areas.isEmpty()){
            return new ResponseEntity<List<AreaContactMysql>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<AreaContactMysql>>(areas, HttpStatus.OK);
    }
  //method to fetch an area with specific id----
    @RequestMapping(value = "/areacontact/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AreaContactMysql> getArea(@PathVariable("id") long id) {
    	System.out.println("=======================================ok2");
        System.out.println("Fetching Area with id " + id);
        AreaContactMysql area = areaContactService.getAreaById(id);
        if (area == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<AreaContactMysql>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AreaContactMysql>(area, HttpStatus.OK);
    }
  //method to create an area
    @RequestMapping(value = "/areacontact", method = RequestMethod.POST , consumes={"application/json"})
    public ResponseEntity<Void> createArea(@Valid @RequestBody Map areacontact,    UriComponentsBuilder ucBuilder) {
    	System.out.println("=======================================ok3");
        System.out.println("Creating Area " + areacontact.get("area_name"));
          
        AreaContactMysql areaMysql = new AreaContactMysql(areacontact.get("area_name").toString(),areacontact.get("address").toString());
        areaContactService.insertArea(areaMysql);
        
    	
 
        HttpHeaders headers = new HttpHeaders();
       // headers.setLocation(ucBuilder.path("/area/{id}").buildAndExpand(area.get("id").toString()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    	
    	
    }
    //method to update an area
    @RequestMapping(value = "/areacontact/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AreaContactMysql> updateArea(@PathVariable("id") long id, @RequestBody Map areacontact) {
    	System.out.println("=======================================ok4");
        System.out.println("Updating Area " + id);
         
        AreaContactMysql currentArea = areaContactService.getAreaById(id);
         
        if (currentArea==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<AreaContactMysql>(HttpStatus.NOT_FOUND);
        }
 
        currentArea.setArea_name(areacontact.get("area_name").toString());
        currentArea.setAddress(areacontact.get("address").toString());
        
        
        areaContactService.updateArea(currentArea); 	        
        return new ResponseEntity<AreaContactMysql>(currentArea, HttpStatus.OK);
    }
  //method to delete a area
    @RequestMapping(value = "/areacontact/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<AreaContactMysql> deleteArea(@PathVariable("id") long id) {
    	System.out.println("=======================================ok5");
        System.out.println("Fetching & Deleting Area with id " + id);
 
        AreaContactMysql area = areaContactService.getAreaById(id);
        if (area == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<AreaContactMysql>(HttpStatus.NOT_FOUND);
        }
 
        areaContactService.deleteArea(id);
        return new ResponseEntity<AreaContactMysql>(HttpStatus.NO_CONTENT);
    }
    
    
}
