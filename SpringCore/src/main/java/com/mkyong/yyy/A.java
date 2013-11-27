package com.mkyong.yyy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mkyong.xxx.B;
import com.mkyong.xxx.C;

@Component("A")
public class A {

	private B bbb;
	private C ccc;
	private static ApplicationContext context;
	
	public A() {
		System.out.println("creating bean A: " + this);
	}
	
	@Autowired
	public void setBbb(B bbb) {
		System.out.println("setting A.bbb with " + bbb);
		this.bbb = bbb;
	}

	@Autowired
	public void setCcc(C ccc) {
		System.out.println("setting A.ccc with " + ccc);
		this.ccc = ccc;
	}
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		context.getBean("A");
	}
}