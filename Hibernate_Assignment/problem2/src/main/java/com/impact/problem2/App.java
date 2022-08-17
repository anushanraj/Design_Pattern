package com.impact.problem2;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.impact.problem2.model.Customer;
import com.impact.problem2.model.Locker;
import com.impact.problem2.util.HibernateUtil;

/**
 * Locker Facility
 *
 */
public class App {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		System.out.println("Create");
		Customer customer1 = new Customer();
		customer1.setCustomerName("Jenny");
		try {
			customer1.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2000"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		customer1.setAddress("Bang");
		customer1.setPhoneNo(11233);

		Locker locker = new Locker();
		locker.setLockerType("small");
		locker.setRent(1000);

		customer1.setLockerId(locker);

		Transaction transcaction = session.beginTransaction();
		Serializable customerId = session.save(customer1);
		transcaction.commit();

		Customer customer = session.load(Customer.class, customerId);
		System.out.println(customer);
		session.close();
	}
}
