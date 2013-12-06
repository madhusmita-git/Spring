package com.mkyong.aop;

import org.springframework.stereotype.Component;

@Component
public class MessageCommunicator {

    public void deliver(String message) {
        System.out.println(message);
    }

    public void deliver(String person, String message) {
        System.out.println(person + ", " + message);
    }
    
    public String deliver(boolean flag) {
        System.out.println(flag);
        return "Flag: " + flag;
    }
    
    public void deliver() throws RuntimeException{
    	System.out.println("Exception");
    	throw new RuntimeException("From deliver exception method");
    }
    
    
    
}
