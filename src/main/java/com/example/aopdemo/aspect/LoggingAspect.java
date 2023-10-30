package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private String PREFIX="====>>>>";

    // this is where we add all our related advices for logging

    // this below is point cut expression in inverted commas

    // below expression will match only for addAccount method inside AccountDAO class or interface
    @Before("execution(public void com.example.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println(PREFIX + " Executing @Before advice on addAccount()");
    }
}
