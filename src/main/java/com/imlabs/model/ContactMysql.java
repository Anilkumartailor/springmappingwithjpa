package com.imlabs.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="CONTACT")
public class ContactMysql implements Serializable {
	private static final long serialVersionUID = 3968962156550448305L;
	@Id
	@GeneratedValue
	long contact_id;
	@NotNull
	String name;
	@NotNull
	String dob;
	@NotNull
	String gender;
	@NotNull
	String contact_no;
	@NotNull
	String email;
	@ManyToOne(fetch=FetchType.LAZY )
    @JoinColumn(name="area_id")
	@JsonBackReference
	AreaContactMysql area;
	public ContactMysql() {
		super();
	}
	
	public ContactMysql(String name, String dob, String gender, String contact_no, String email,
			AreaContactMysql area) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.contact_no = contact_no;
		this.email = email;
		this.area = area;
	}

	public long getContact_id() {
		return contact_id;
	}
	public void setContact_id(long contact_id) {
		this.contact_id = contact_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AreaContactMysql getArea() {
		return area;
	}
	public void setArea(AreaContactMysql area) {
		this.area = area;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
