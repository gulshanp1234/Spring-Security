package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.security.models.User;
import com.spring.security.repository.UserRepository;


@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setEmail("gulshan@gmail.com");
		user.setUsername("gulshan");
		user.setPassword(this.bCryptPasswordEncoder.encode("gulshan@123"));
		user.setRole("ROLE_NORMAL");
		
		this.userRepository.save(user);
		
		User user1 = new User();
		user1.setEmail("prince@gmail.com");
		user1.setUsername("prince");
		user1.setPassword(this.bCryptPasswordEncoder.encode("prince@123"));
		user1.setRole("ROLE_ADMIN");
		
		this.userRepository.save(user1);
		
	}

}
