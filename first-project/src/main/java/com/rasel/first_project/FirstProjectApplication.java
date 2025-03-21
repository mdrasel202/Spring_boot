package com.rasel.first_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirstProjectApplication.class, args);
	}

}
