package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.Date;

public class LendingInformation extends AbstractIdentifiable {
	
	private Date lendingDate;
	private Date dueDate;
	private Date returnDate;
	private float fee;
	private State state;
	private Staff staff;
	private Customer customer;
	
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getLendingDate() {
		return lendingDate;
	}
	public void setLendingDate(Date lendingDate) {
		this.lendingDate = lendingDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}

}
