package com.winsplay.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.winsplay.hibernate.bean.Event;

public class HibernateTutorial {

	
	@Test
	public void manyToMany(){
		Session session = HibernateORMFactoryHandler.getSession();
		
		session.beginTransaction();
		
		Event ev = new Event();
		ev.setTitle("My Event");
		ev.setDt(new Date());

		session.save(ev);
		
		session.getTransaction().commit();
	}
	
	
	@Test
	public void listData(){
		Session session = HibernateORMFactoryHandler.getSession();
		
		session.beginTransaction();
		
		List<Event> list =  (List<Event>)session.createQuery("from Event").list();
		
		System.out.println("// list output");
		for(Event e : list){
			System.out.println(e.getTitle() + "\t" + e.getDt());
		}
		
		session.getTransaction().commit();
		
	}
	
	
}
