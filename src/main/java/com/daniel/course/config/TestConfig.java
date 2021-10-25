package com.daniel.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.daniel.course.entities.User;
import com.daniel.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Daniel Rocha Maia","danrochamaia@gmail.com", "981419682", "1357");
		User u2 = new User(null, "Cassius Lixo","lixocassius@gmail.com", "95454548", "3porquinhos");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
	
}
