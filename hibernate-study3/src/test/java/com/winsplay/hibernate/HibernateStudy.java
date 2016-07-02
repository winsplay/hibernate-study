package com.winsplay.hibernate;

/**
 * 
 * @author winsplay92@gmail.com
 * 
 * 
 */

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.winsplay.hibernate.bean.Dept;
import com.winsplay.hibernate.bean.Emp;

public class HibernateStudy {

	private Session session = null;
	private Emp emp = null;
	private Dept dept = null;
	
	
	@Before
	public void setup(){
		session = HibernateORMFactoryHandler.getSession();
		
		
		dept = new Dept();
		dept.setDeptNo(1000);
		dept.setdName("Human Resource");
		
		
		emp = new Emp();
		emp.setEname("w.winstead");
		emp.setSalary("60000000");
		emp.setDept(dept);
				
	}
	
	@Test
	public void basicUse(){
		session = HibernateORMFactoryHandler.getSession();
		session.beginTransaction();
		
		session.save(emp);
		
		session.getTransaction().commit();
	}

	@Test
	public void getRows(){
		session.beginTransaction();
		
		List<Emp> empList = null;
		
		empList = session.createQuery("from Emp").list();

		System.out.println("//EMP LIST//");
		for(Emp emp : empList){
			System.out.print(emp.getEmpno() + "\t");
			System.out.print(emp.getEname() + "\t");
			System.out.print(emp.getSalary() + "\t");
			System.out.println();
		}
		System.out.println();
		
		session.getTransaction().commit();
		
	}
	
	@Test
	public void getAssociatedData(){
		
		session.beginTransaction();
		
		List<?> empList = (List<Emp>)session.createQuery("from Emp as emp inner join emp.dept as dept").list();

		for(int i=0; i<empList.size(); i++){
			Object[] rows = (Object[]) empList.get(i);
			Emp emp = (Emp)rows[0];
			Dept dept = (Dept)rows[1];
			
			System.out.println(emp.getEmpno() + "\t" + emp.getEname() + "\t" + emp.getSalary() + "\t" + dept.getdName());
			
		}

		session.getTransaction().commit();
	}
	
	
	
	
}
