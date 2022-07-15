package com.dantas.teste.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dantas.teste.entities.User;
import com.dantas.teste.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(12345678912L, "Carlos Dantas","carlosdanats485@gmail.com" );
		User u2 = new User(12345678912L, "Alberto Filho","albertofilho485@gmail.com");
 
		userRepository.saveAll(Arrays.asList(u1, u2));

	}

}