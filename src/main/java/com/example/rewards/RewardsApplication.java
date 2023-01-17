package com.example.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class RewardsApplication {

	@RequestMapping("/")
	String home() {
		return "Here is the homepage!";
	}

	public static void main(String[] args) {
		SpringApplication.run(RewardsApplication.class, args);
	}

}
