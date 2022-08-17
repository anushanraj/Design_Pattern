package com.impact.problem3Hql.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.impact.problem3Hql.model.Director;
import com.impact.problem3Hql.model.HollyWood;
import com.impact.problem3Hql.model.Movie;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
				settings.put(Environment.URL,
						"jdbc:sqlserver://localhost;databaseName=Impact14;instanceName=SQLEXPRESS;trustServerCertificate=true");
				settings.put(Environment.USER, "sa");
				settings.put(Environment.PASS, "password_123");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2012Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Movie.class);
				configuration.addAnnotatedClass(HollyWood.class);
				configuration.addAnnotatedClass(Director.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			} catch (Exception e) {
				System.err.println("Initial Session Factory creation failed " + e);
				throw new ExceptionInInitializerError(e);
			}
		}
		return sessionFactory;

	}

}
