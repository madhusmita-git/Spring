package com.mkyong.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Customer {
	//@Value("${customer.custid}")
	private int custId;
	
	//@Value("${customer.name}")
	private String name;
	
	//@Value("${customer.age}")
	private int age;
	
	//private Properties properties;
 
	public Customer() {
	
	}

	public Customer(int custId, String name, int age) {
		this.custId = custId;
		this.name = name;
		this.age = age;
	}

	public int getCustId() {
		return custId;
	}
	
	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	} 
	
	@Override
	public String toString() {
		return "Customer [ID: " + custId + ", NAME: " + name + " , AGE: " + age + "]";
	}
 
}