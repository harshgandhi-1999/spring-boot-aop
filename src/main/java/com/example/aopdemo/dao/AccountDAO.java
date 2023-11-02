package com.example.aopdemo.dao;

import com.example.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAccounts();

    List<Account> findAccounts(boolean flag);

    void addAccount(Account account, boolean flag);

    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);
}
