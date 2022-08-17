package com.impact.hibernate1.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

			sessionFactory = configuration.buildSessionFactory();

		} catch (Exception e) {
			System.err.println("Initial Session Factory creation failed " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

//	public static SessionFactory getSessionFactory() {
//		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		return sf;
//	}

}
