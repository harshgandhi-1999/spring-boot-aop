package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

// adding Aspect here is optional if we are just having pointcut expressions in this class
public class AopExpressions {

    // Below are point cut declarations for multiple reuse
    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {
    }
}
