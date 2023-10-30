package com.example.aopdemo.dao;

public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Adding an Account");
    }
}
