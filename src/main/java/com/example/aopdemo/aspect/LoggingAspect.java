package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    private static final String TAG = "\n========== LoggingAspect:";

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

    @Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println(TAG + " Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println(TAG + " Method = " + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();

        for(Object arg: args){
            System.out.println(arg);

            if(arg instanceof Account account){
                System.out.println("Account Name: " + account.getName());
                System.out.println("Account Level: " + account.getLevel());
            }
        }
    }

}
