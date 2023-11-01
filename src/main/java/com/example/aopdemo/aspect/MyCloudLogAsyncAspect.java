package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    private static final String TAG = "\n========== MyCloudLogAsyncAspect:";

    @Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudASync() {
        System.out.println(TAG + " Executing @Before advice for logToCloudAsync()");
    }
}
