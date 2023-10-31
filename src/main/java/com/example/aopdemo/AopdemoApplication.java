package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner -> {
			demoBeforeAdvice(accountDAO,membershipDAO);
		};
	}

	private void demoBeforeAdvice(AccountDAO accountDAO,MembershipDAO membershipDAO){
		Account account = new Account();
		accountDAO.addAccount(account,true);
		accountDAO.doWork();
		accountDAO.setServiceCode("23");
		accountDAO.setName("abc");
		accountDAO.getServiceCode();
		accountDAO.getName();

		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
	}
}
