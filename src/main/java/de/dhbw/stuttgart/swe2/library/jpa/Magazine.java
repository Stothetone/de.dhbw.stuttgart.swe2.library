package de.dhbw.stuttgart.swe2.library.jpa;

public class Magazine extends PrintMedia {

	private Integer issue;

	public Integer getIssue() {
		return issue;
	}

	public void setIssue(Integer issue) {
		this.issue = issue;
	}
}
