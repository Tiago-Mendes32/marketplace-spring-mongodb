package com.legacy.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.legacy.model.entities.User;
import com.legacy.repositories.UserRepository;

@Configuration
public class InstanciationTest implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User(null, "Tiago", "Mendes", "50434220841", LocalDate.parse("2001-07-02"));
		
		userRepository.save(user);
	}

}
