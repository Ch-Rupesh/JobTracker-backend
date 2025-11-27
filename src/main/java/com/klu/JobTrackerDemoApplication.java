package com.klu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.klu")
@EnableJpaRepositories(basePackages = "com.klu")
public class JobTrackerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobTrackerDemoApplication.class, args);
	}

}
