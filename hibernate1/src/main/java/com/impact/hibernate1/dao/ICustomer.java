package com.impact.hibernate1.dao;

import com.impact.hibernate1.model.Customer;

public interface ICustomer {

	public void addCustomer(Customer customer);

	public void getCustomer(int customerId);

	public void updateCustomer(Integer customerId,String name);

	public void deleteCustomer(int customerId);

}
