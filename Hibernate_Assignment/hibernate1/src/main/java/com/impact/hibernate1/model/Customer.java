package com.impact.hibernate1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Details")
public class Customer {

	@Id
	@Column(name = "CUSTOMERID")
	private int customerId;

	@Column(name = "CUSTOMERNAME")
	private String customerName;

	public Customer() {

	}

	public Customer(int customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
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

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + "]";
	}

	
}
