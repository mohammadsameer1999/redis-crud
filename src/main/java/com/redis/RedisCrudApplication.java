package com.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisCrudApplication {

	public static void main(String[] args) {
		System.out.println("hello");
		SpringApplication.run(RedisCrudApplication.class, args);
	}

}
