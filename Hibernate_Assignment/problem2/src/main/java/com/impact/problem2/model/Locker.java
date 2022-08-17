package com.impact.problem2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Locker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LOCKERID")
	private int lockerId;

	@Column(name = "LOCKERTYPE")
	private String lockerType;

	@Column(name = "RENT")
	private int rent;

	public Locker() {
	}

	public Locker(int lockerId, String lockerType, int rent) {
		this.lockerId = lockerId;
		this.lockerType = lockerType;
		this.rent = rent;
	}

	public int getLockerId() {
		return lockerId;
	}

	public void setLockerId(int lockerId) {
		this.lockerId = lockerId;
	}

	public String getLockerType() {
		return lockerType;
	}

	public void setLockerType(String lockerType) {
		this.lockerType = lockerType;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Locker [lockerId=" + lockerId + ", lockerType=" + lockerType + ", rent=" + rent + "]";
	}

	
}
