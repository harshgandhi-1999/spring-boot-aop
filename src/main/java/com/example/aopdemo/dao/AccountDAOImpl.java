package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + ": Adding an Account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": Do Work");
        return false;
    }
}
