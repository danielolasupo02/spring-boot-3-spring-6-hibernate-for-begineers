package com.luv2code.appdemo;

import com.luv2code.appdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {
		// call the business method
		theAccountDAO.addAccount();

		// do it again!
		System.out.println("\n Let's call it again!\n");

		// call the business method again
		theAccountDAO.addAccount();
	}

}
