package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean flag) {

        if (flag) {
            throw new RuntimeException("Runtime excpetion in findAccounts");
        }

        List<Account> accounts = new ArrayList<>();

        // create sample accounts
        accounts.add(new Account("abc","1"));
        accounts.add(new Account("def","2"));
        accounts.add(new Account("ghi","3"));

        return accounts;
    }

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
