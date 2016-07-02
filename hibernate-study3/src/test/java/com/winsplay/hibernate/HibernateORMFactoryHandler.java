package com.winsplay.hibernate;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateORMFactoryHandler {

	
	private static final SessionFactory sessionFactory = new Configuration().configure( new File("D:\\java_git\\hibernate-study3\\src\\main\\resources\\META-INF\\hibernate.cfg.xml")).buildSessionFactory();
	
	public static Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
}
