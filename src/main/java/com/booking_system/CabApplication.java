package com.booking_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.booking_system", "com.repository"})
@EnableJpaRepositories(basePackages = "com.repository")
public class CabApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabApplication.class, args);
	}

}
