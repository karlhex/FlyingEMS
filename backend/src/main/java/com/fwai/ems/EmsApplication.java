package com.fwai.ems;

import org.springframework.context.ApplicationContext;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

		@Bean
		public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
				return args -> {
						System.out.println("Let's inspect the beans provided by spring boot");
				};
		}
}
