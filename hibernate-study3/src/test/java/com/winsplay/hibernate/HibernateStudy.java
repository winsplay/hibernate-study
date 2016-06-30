package com.winsplay.hibernate;

/**
 * 
 * @author winsplay92@gmail.com
 * 
 * 
 */

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.winsplay.hibernate.bean.EmployeeBean;

public class HibernateStudy {

	
	@Test
	public void basicUsage(){
		
		SessionFactory sessionFactory = new Configuration().configure( new File("D:\\new_git\\hibernate-study\\src\\main\\resources\\META-INF\\hibernate.cfg.xml")).buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		EmployeeBean emp = new EmployeeBean();
		emp.setEname("winsplay");
		emp.setSalary("40000000");
		
		session.save(emp);
		
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
		
	}
}
