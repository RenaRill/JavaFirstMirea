package com.example.Java2_14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.Java2_14", "com.example.Java2_14.configuration"})
public class Java214Application {

	public static void main(String[] args) {
		SpringApplication.run(Java214Application.class, args);
	}

}
