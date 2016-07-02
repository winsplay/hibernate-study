package com.winsplay.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

public class Person {

	private Long personId;
	private int age;
	private String firstName;
	private String lastName;
	
	private Set<Event> events = new HashSet<Event>();
	
	
	public Person() {}


	public Long getPersonId() {
		return personId;
	}


	public void setPersonId(Long personId) {
		this.personId = personId;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Set<Event> getEvents() {
		return events;
	}


	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	
	
	
}
