package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PublicApiInCloudDeployApplication {
public String PORT = System.getenv("PORT");
	public static void main(String[] args) {
		SpringApplication.run(PublicApiInCloudDeployApplication.class, args);
	}

}
