package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.List;

public class LendingObject extends AbstractIdentifiable {

	private List<LendingInformation> lendingInfo;
	private ObjectInformation objectInformation;

	public List<LendingInformation> getLendingInfo() {
		return lendingInfo;
	}

	public void setLendingInfo(List<LendingInformation> lendingInfo) {
		this.lendingInfo = lendingInfo;
	}

	public ObjectInformation getObjectInformation() {
		return objectInformation;
	}

	public void setObjectInformation(ObjectInformation objectInformation) {
		this.objectInformation = objectInformation;
	}
}
