package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {
            //demoBeforeAdvice(accountDAO,membershipDAO);
            //demoAfterReturningAdvice(accountDAO);
            demoAfterThrowingAdvice(accountDAO);
        };
    }

    private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        Account account = new Account();
        accountDAO.addAccount(account, true);
        accountDAO.doWork();
        accountDAO.setServiceCode("23");
        accountDAO.setName("abc");
        accountDAO.getServiceCode();
        accountDAO.getName();

        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();
    }

    private void demoAfterReturningAdvice(AccountDAO accountDAO) {
        List<Account> accounts = accountDAO.findAccounts();

        System.out.println("\n\nMain program: AfterReturningAdvice");
        System.out.println("----------------");

        System.out.println(accounts + "\n");
    }


    private void demoAfterThrowingAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;

        try {
            // make a boolean flag just to simulate the exception
            boolean flag;
            accounts = accountDAO.findAccounts(true);
        } catch (Exception e) {
            System.out.println("\n\nMain program: ...caught exception: " + e);
        }

        System.out.println("\n\nMain program: demoAfterThrowingAdvice");
        System.out.println("----------------");

        System.out.println(accounts + "\n");
    }
}
