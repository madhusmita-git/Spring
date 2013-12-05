package com.mkyong.common;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.aop.MessageCommunicator;

public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new 
				ClassPathXmlApplicationContext("classpath:spring-config.xml");

        MessageCommunicator communicator = (MessageCommunicator) ctx.getBean("messageCommunicator");
        communicator.deliver("Hello World");
        communicator.deliver("Marco", "Hello World");
        
        ctx.close();
	}

}
