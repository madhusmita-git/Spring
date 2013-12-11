package com.mkyong.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.dao.ICustomerDAO;
import com.mkyong.model.Customer;

public class CustomerService {

	public static void main(String args[]) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-config.xml");
		
		ICustomerDAO custDao = (ICustomerDAO) ctx.getBean("JdbcCustomerDAO");
		//Customer cust = new Customer(6, "NAME6", 26);
		//custDao.insert(cust);
		
		Properties custProp = new Properties();
		try {
			custProp.load(CustomerService.class.getResourceAsStream("../../../customer/customer_default.properties"));
			System.out.println("CUSTID: " + custProp.getProperty("customer.custid"));
			System.out.println("NAME: " + custProp.getProperty("customer.name"));
			System.out.println("AGE: " + custProp.getProperty("customer.age"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int custId = new Random(System.currentTimeMillis()).nextInt(100);
		Customer custBean = (Customer) ctx.getBean("customer", custId, 
				custProp.getProperty("customer.name") + custId, 
				Integer.parseInt(custProp.getProperty("customer.age")) + custId);
		System.out.println(custBean);
		custDao.insert(custBean);	
		
		Customer customer1 = custDao.findByCustomerId(custId);
		System.out.println(customer1);
		
		ctx.close();
	}
}
