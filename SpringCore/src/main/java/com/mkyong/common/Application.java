package com.mkyong.common;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.aop.MessageCommunicator;

public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new 
				ClassPathXmlApplicationContext("classpath:spring-config.xml");

        MessageCommunicator communicator = (MessageCommunicator) ctx.getBean("messageCommunicator");
        System.out.println("--------------------------------");
        communicator.deliver("Hello World");
        System.out.println("--------------------------------");
        communicator.deliver("Marco", "Hello World");
        System.out.println("--------------------------------");
        communicator.deliver(true);
        System.out.println("--------------------------------");
        communicator.deliver();
        System.out.println("--------------------------------");
        
        ctx.close();
	}

}
