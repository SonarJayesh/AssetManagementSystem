package com.jayesh.assetmanagement.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {

	public static SessionFactory sessionFactory;
	
	private HibernateUtil() {
		
	}
	
	public static SessionFactory getSessionFactoryInstatce() {
		
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Assets.class);
			sessionFactory = configuration.buildSessionFactory();
		}
		return sessionFactory;
	};
}
