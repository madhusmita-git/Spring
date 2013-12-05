package com.mkyong.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecurityAspect {
	private Authenticator authenticator = new Authenticator();

    @Pointcut("execution(* com.mkyong.aop.MessageCommunicator.deliver(..))")
    public void secureAccess() {
    }

    @Before("secureAccess()")
    public void secure() {
        System.out.println("Checking and authenticating user...");
        authenticator.authenticate();
    }
}
