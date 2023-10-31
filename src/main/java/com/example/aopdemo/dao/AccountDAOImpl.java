package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + ": Adding an Account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": Do Work");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": getName() called");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName() called");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode() called");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode() called");
        this.serviceCode = serviceCode;
    }
}
