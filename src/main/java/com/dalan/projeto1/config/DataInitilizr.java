package com.dalan.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.dalan.projeto1.entity.User;
import com.dalan.projeto1.repository.UserRepository;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {

			createUser("Aleandro Pereira Dalan", "aleandrodalan@gmail.com");
			createUser("João da Silva","joaosilva@gmail.com");
			createUser("Fulano de Tal", "fulanotal@gmail.com");
			
		}
		
		User user = userRepository.findByEmail("aleandrodalan@gmail.com");

		System.out.println(user.getName());

	}
	
	public void createUser(String name, String email) {
		
		User user = new User(name, email);
		
		userRepository.save(user);
		
		
	}

}
