package com.educandoweb.curse.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curse.entities.User;
import com.educandoweb.curse.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	//para fazer um objeto depender de outro, vc tem que declarar essa dependência
	//para que o spring possa resolver essa dependencia e usar uma instancia do UserRepository no TestConfig use o @Autowired
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// tudo que colocar dentro desse método vai ser executado quando a aplicação for iniciada
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 		
	
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}

}
