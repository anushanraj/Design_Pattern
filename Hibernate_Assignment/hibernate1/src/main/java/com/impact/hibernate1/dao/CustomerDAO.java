package com.impact.hibernate1.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.impact.hibernate1.model.Customer;
import com.impact.hibernate1.util.HibernateUtil;

public class CustomerDAO implements ICustomer {

	public void addCustomer(Customer customer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transcaction = session.beginTransaction();
		session.save(customer);
		transcaction.commit();
		session.close();

	}

	public void getCustomer(int customerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Customer customer = session.get(Customer.class, customerId);
		System.out.println("Name " + customer);
		session.close();

	}

	public void updateCustomer(Integer customerId, String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transcaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, customerId);
		customer.setCustomerName(name);
		session.update(customer);
		transcaction.commit();
		session.close();
	}

	public void deleteCustomer(int customerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transcaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, customerId);
		session.delete(customer);
		transcaction.commit();
		session.close();
	}

}
