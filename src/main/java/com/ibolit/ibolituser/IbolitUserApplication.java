package com.ibolit.ibolituser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
public class IbolitUserApplication{

	public static void main(String[] args) {
		SpringApplication.run(IbolitUserApplication.class, args);
	}

}
