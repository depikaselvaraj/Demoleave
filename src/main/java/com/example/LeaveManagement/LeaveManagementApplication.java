package com.example.LeaveManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@Configuration
@EnableJpaRepositories
@SpringBootApplication
public class LeaveManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveManagementApplication.class, args);
	}

}
