package com.mkyong.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
    	System.out.println("In SecureAccess method...");
    }
    
    @Before("execution(* *(..))")
    public void before() {
    	System.out.println("In BEFORE Aspect method");
    }

    @Around("execution(* com.mkyong.aop.MessageCommunicator.deliver(..))")
    public void secure(ProceedingJoinPoint preJoinPoint) throws Throwable {
        System.out.println("Checking and authenticating user..." + preJoinPoint.getSignature());
        authenticator.authenticate();
        preJoinPoint.proceed();
        System.out.println("Back to Aspect method");
    }
    
    @AfterReturning(
    		pointcut="execution(* *(..))", 
    		returning="output")
    public void afterReturning(JoinPoint joinPoint, Object output) {
    	System.out.println("In AFTER RETURNING Aspect method");
    	System.out.println("output: " + output);
    }
    
    @AfterThrowing(
    		pointcut="execution(* *())", 
    		throwing="error")
    public void afterReturning(JoinPoint joinPoint, Throwable error) {
    	System.out.println("In AFTER THROWING Aspect method");
    	System.out.println("error: " + error);
    }  
    
    @After("execution(* *(..))")
    public void after() {
    	System.out.println("In AFTER Aspect method");
    }    
}
