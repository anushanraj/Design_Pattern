package com.impact.problem4Agg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Director {

	@Id
	@Column(name = "DIRECTORID")
	private String directorId;

	@Column(name = "DIRECTORNAME")
	private String directorName;

	@Column(name = "BORNIN")
	private Integer bornIn;

	public Director() {
	}

	public Director(String directorId, String directorName, Integer bornIn) {
		this.directorId = directorId;
		this.directorName = directorName;
		this.bornIn = bornIn;
	}

	public String getDirectorId() {
		return directorId;
	}

	public void setDirectorId(String directorId) {
		this.directorId = directorId;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Integer getBornIn() {
		return bornIn;
	}

	public void setBornIn(Integer bornIn) {
		this.bornIn = bornIn;
	}

	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", directorName=" + directorName + ", bornIn=" + bornIn + "]";
	}

}
