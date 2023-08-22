package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.User;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}


	@Bean
		public User user(){
			return new User (
				"Juan",
				"Juseanto",
				"juseanto@gmail.com",
				18
			) ;
		}

}
