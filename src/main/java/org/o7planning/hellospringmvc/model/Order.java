package org.o7planning.hellospringmvc.model;

public class Order {
	private Person person;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Person person) {
		super();
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	

}
