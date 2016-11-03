package de.dhbw.stuttgart.swe2.library.jpa;

import javax.persistence.Entity;

@Entity
public abstract class PrintMedia extends ObjectInformation {
	
	private Integer pageNo;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

}
