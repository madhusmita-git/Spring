package com.mkyong.common;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.service.CustomerService;

public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"spring-autoscan-config.xml"});
		CustomerService ser = (CustomerService) context.getBean("customerService");
		System.out.println(ser);
		System.out.println("Context contain DAO: " + context.containsBean("customerDAO"));
		context.close();
	}

}
