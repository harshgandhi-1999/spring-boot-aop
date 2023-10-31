package com.example.aopdemo.dao;

import com.example.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean flag);

    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);
}
