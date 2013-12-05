package com.mkyong.aop;

import org.springframework.stereotype.Component;

@Component
public class Authenticator {

    public void authenticate() {
        System.out.println("Authenticated");
    }

}
