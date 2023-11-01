package com.merkol.aopdemo;

import com.merkol.aopdemo.dao.AccountDAO;
import com.merkol.aopdemo.dao.MembershipDAO;
import com.merkol.aopdemo.service.TrafficFortuneService;
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
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
		return runner -> {
			//demoTheBeforeAdvice(accountDAO, membershipDAO);
			// demoTheAfterReturningAdvice(accountDAO);
			//demoTheAfterThrowingAdvice(accountDAO);
			//demoTheAfterAdvice(accountDAO);
			//demoTheAroundAdvice(trafficFortuneService);
			//demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");
		System.out.println("Calling getFortune()\n");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("My fortune is: " + data);

		System.out.println("Finished!");

	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()\n");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("My fortune is: " + data);

		System.out.println("Finished!");

	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()\n");


		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("My fortune is: " + data);

		System.out.println("Finished!");

	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		// cal method to find the accounts
		List<Account> theAccounts =  null;
		try {
			boolean tripWire = false;
			accountDAO.findAccounts(tripWire);
		}
		catch (Exception exp) {
			System.out.println("\n\nMain Program: ... caught exception " + exp);
		}

		// display the accounts
		System.out.println("----------Main program: demoTheAfterThrowingAdvice----------");
		System.out.println(theAccounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		// cal method to find the accounts
		List<Account> theAccounts =  null;
		try {
			boolean tripWire = true;
			accountDAO.findAccounts(tripWire);
		}
		catch (Exception exp) {
			System.out.println("\n\nMain Program: ... caught exception " + exp);
		}

		// display the accounts
		System.out.println("----------Main program: demoTheAfterThrowingAdvice----------");
		System.out.println(theAccounts);
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		// cal method to find the accounts
		List<Account> theAccounts =  accountDAO.findAccounts();

		// display the accounts
		System.out.println("----------Main program: demoTheAfterReturningAdvice----------");
		System.out.println(theAccounts);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call the business method
		Account theAccount = new Account();
		theAccount.setName("Metehan");
		theAccount.setLevel("Platinum");
		accountDAO.addAccount(theAccount, true);
		accountDAO.doWork();

		// call the accountdao getter/setter methods
		accountDAO.setName("Metehan");
		accountDAO.setServiceCode("Platinum");

		String name = accountDAO.getName();
		String serviceCode
				= accountDAO.getServiceCode();

		// call membership business method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
	}

}
