package com.example.oauthtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OauthtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthtestApplication.class, args);
		
//	    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    
//	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	    System.out.printf("secret : %s\n", passwordEncoder.encode("secret"));
	}

}
