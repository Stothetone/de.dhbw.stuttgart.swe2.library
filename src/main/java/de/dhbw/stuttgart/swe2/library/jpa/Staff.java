package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Staff extends Person {
	
	private String persNo;
	private float salary;
	
	@OneToMany(targetEntity = LendingInformation.class)
	private List<LendingInformation> lendingInfo;
	
	public String getPersNo() {
		return persNo;
	}
	public void setPersNo(String persNo) {
		this.persNo = persNo;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public List<LendingInformation> getLendingInfo() {
		return lendingInfo;
	}
	public void setLendingInfo(List<LendingInformation> lendingInfo) {
		this.lendingInfo = lendingInfo;
	}

}
