package com.merkol.aopdemo;

import com.merkol.aopdemo.dao.AccountDAO;
import com.merkol.aopdemo.dao.MembershipDAO;
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
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call the business method
		Account theAccount = new Account();
		accountDAO.addAccount(theAccount, true);
		accountDAO.doWork();

		System.out.println();

		// call membership business method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
	}

}
