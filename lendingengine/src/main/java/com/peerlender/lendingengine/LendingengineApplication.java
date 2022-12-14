package com.peerlender.lendingengine;

import com.peerlender.lendingengine.domain.model.Balance;
import com.peerlender.lendingengine.domain.model.Currency;
import com.peerlender.lendingengine.domain.model.Money;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LendingengineApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(LendingengineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User john = new User("John", "John", "A", 25, "developer", new Balance());
		User peter = new User("Peter", "Peter", "B", 21, "teacher", new Balance());
		john.topUp(new Money(100, Currency.USD));
		peter.topUp(new Money(100, Currency.USD));
		userRepository.save(john);
		userRepository.save(peter);
		userRepository.save(new User("Sarah", "Sarah", "C", 28, "pilot", new Balance()));
	}
}
