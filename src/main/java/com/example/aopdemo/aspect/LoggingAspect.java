package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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

        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account account) {
                System.out.println("Account Name: " + account.getName());
                System.out.println("Account Level: " + account.getLevel());
            }
        }
    }


    @AfterReturning(
            pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println(TAG + " Executing @AfterRunning on method: " + method);

        // print out the result

        System.out.println(TAG + " Result is = " + result);

    }

    @AfterThrowing(pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "myExc")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable myExc) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println(TAG + " Executing @AfterThrowing on method: " + method);

        // print out the result

        System.out.println(TAG + " The exception is = " + myExc);
    }

    @After("execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println(TAG + " Executing @After (finally) on method: " + method);
    }

    @Around("execution(* com.example.aopdemo.service.*.getFortune(..))")
    Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out which method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println(TAG + " Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute the method
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception exc) {
            // we are handling the exception here and not rethrowing it to the calling program.
            System.out.println(exc.getMessage());
            result = "No result";
        }

        // get emd timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n====> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }
}
