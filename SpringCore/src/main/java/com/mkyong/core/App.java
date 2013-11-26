package com.mkyong.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mkyong.config.AppConfig;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerBo cust = (CustomerBo) context.getBean("customer");
		cust.printMsg("Hello 1");
		
		SchedulerBo sch = (SchedulerBo) context.getBean("scheduler");
		sch.printMsg("Hello 2");
	}
}
