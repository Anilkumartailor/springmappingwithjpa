package com.imlabs.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
 
@Entity
@Table(name="AREACONTACT")
public class AreaContactMysql implements Serializable{
	private static final long serialVersionUID = -5802292203597113317L;
	@Id
	@GeneratedValue
	long area_id;
	@NotNull
	String area_name;
	@NotNull
	String address;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="area") 
	@JsonManagedReference
	@JsonIgnore
	Set<ContactMysql> acontact=new HashSet<ContactMysql>();
	
	public AreaContactMysql() {
		super();
	}
	

	public AreaContactMysql(String area_name, String address) {
		super();
		this.area_name = area_name;
		this.address = address;
	}







	public long getArea_id() {
		return area_id;
	}



	public void setArea_id(long area_id) {
		this.area_id = area_id;
	}



	public String getArea_name() {
		return area_name;
	}



	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Set<ContactMysql> getAcontact() {
		return acontact;
	}



	public void setAcontact(Set<ContactMysql> acontact) {
		this.acontact = acontact;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
}
