package com.impact.problem2.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMERID")
	private int customerId;

	@Column(name = "CUSTOMERNAME")
	private String customerName;

	@Column(name = "DATEOFBIRTH")
	private Date dateOfBirth;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PHONENO")
	private int phoneNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "LOCKAERID")
	private Locker lockerId;

	public Customer() {
	}

	public Customer(int customerId, String customerName, Date dateOfBirth, String address, int phoneNo,
			Locker lockerId) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNo = phoneNo;
		this.lockerId = lockerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Locker getLockerId() {
		return lockerId;
	}

	public void setLockerId(Locker lockerId) {
		this.lockerId = lockerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + ", phoneNo=" + phoneNo + ", lockerId=" + lockerId + "]";
	}

}
