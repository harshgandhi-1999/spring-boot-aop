package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import com.example.aopdemo.service.TrafficFortuneService;
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
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
        return runner -> {
            //demoBeforeAdvice(accountDAO,membershipDAO);
            //demoAfterReturningAdvice(accountDAO);
            //demoAfterThrowingAdvice(accountDAO);
            //demoAfterAdvice(accountDAO);
            //demoAroundAdvice(trafficFortuneService);
            demoAroundAdviceHandleException(trafficFortuneService);
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

    // after advice works as a finally in try catch
    private void demoAfterAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;

        try {
            // make a boolean flag just to simulate the exception
            boolean flag;
            accounts = accountDAO.findAccounts(true);
        } catch (Exception e) {
            System.out.println("\n\nMain program: ...caught exception: " + e);
        }

        System.out.println("\n\nMain program: demoAfterAdvice");
        System.out.println("----------------");

        System.out.println(accounts + "\n");
    }

    private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("\n\nMain program: demoAfterAdvice");
        System.out.println("\nCalling getFortune()");

        String data = trafficFortuneService.getFortune();

        System.out.println("\nMy fortune is: " + data);
        System.out.println("\nFinished");
    }

    private void demoAroundAdviceHandleException(TrafficFortuneService trafficFortuneService){
        System.out.println("\n\nMain program: demoAfterAdvice");
        System.out.println("\nCalling getFortune()");

        // taking flag for simulating the exception
        boolean flag = true;
        String data = trafficFortuneService.getFortune(flag);

        System.out.println("\nMy fortune is: " + data);
        System.out.println("\nFinished");
    }
}
