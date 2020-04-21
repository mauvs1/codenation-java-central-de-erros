package com.errorcenter.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ApiErrorCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiErrorCenterApplication.class, args);
	}

}
