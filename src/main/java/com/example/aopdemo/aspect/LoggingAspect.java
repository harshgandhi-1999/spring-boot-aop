package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Below are point cur declarations for multiple reuse
    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    private String PREFIX="====>>>>";

    // this is where we add all our related advices for logging

    // this below is point cut expression in inverted commas

    // below expression will match only for addAccount method inside AccountDAO class or interface
    // "execution(public void com.example.aopdemo.dao.AccountDAO.addAccount())"

    // below expression will match for addAccount method inside any class
    // "execution(public void *.addAccount())"

    // below expression will match for addAccount method having any return type of any class
    // "execution(public * *.addAccount())"

    // below expression will match for addAccount method in package having any return type, any class, any method, 0 or more arguments
    // "execution(* com.example.aopdemo.dao.*.*(..))"

    // access modifiers are optional in pointcut expression, so we can also omit them

    // below expression is for matching paramater type - here we have to write full path rather than just Account
    // "execution(* add*(com.example.aopdemo.Account))"

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println(PREFIX + " Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println(PREFIX + " Executing @Before advice on performApiAnalytics()");
    }
}
