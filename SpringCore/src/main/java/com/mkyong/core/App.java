package com.mkyong.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mkyong.config.AppConfig;

public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// Testing for Bean Scopes such as SINGLETON(default) and PROTOTYPE
		CustomerBo cust1 = (CustomerBo) context.getBean("customer");
		cust1.printMsg("Hello 1");
		System.out.println(cust1.toString());
		
		CustomerBo cust2 = (CustomerBo) context.getBean("customer");
		System.out.println(cust2.toString());
		System.out.println("Singleton SCOPE test for Customer : " + (cust1==cust2));		
		
		SchedulerBo sch1 = (SchedulerBo) context.getBean("scheduler");
		sch1.printMsg("Hello 2");
		System.out.println(sch1.toString());
		
		SchedulerBo sch2 = (SchedulerBo) context.getBean("scheduler");
		System.out.println(sch2.toString());
		System.out.println("Prototype SCOPE test for Scheduler : " + (sch1==sch2));
		
		context.close();
	}
}
