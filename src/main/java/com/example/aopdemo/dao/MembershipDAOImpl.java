package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + ": Adding an Membership Account");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": Go to sleep");
    }
}
