package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Library extends AbstractIdentifiable{
	
	private String name;
	private String street;
	private String adressNo;
	private String zipCode;
	private String city;
	private String phoneNo;
	
	@OneToMany(targetEntity = Staff.class)
	private List<Staff> staff;
	
	@ManyToMany(targetEntity = LendingObject.class)
	private List<LendingObject> lendingObject;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAdressNo() {
		return adressNo;
	}
	public void setAdressNo(String adressNo) {
		this.adressNo = adressNo;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public List<Staff> getStaff() {
		return staff;
	}
	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}
	public List<LendingObject> getLendingObject() {
		return lendingObject;
	}
	public void setLendingObject(List<LendingObject> lendingObject) {
		this.lendingObject = lendingObject;
	}
	
	

}
