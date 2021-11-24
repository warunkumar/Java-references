package com.sample.springbootbankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootSampleAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootSampleAppApplication.class, args);
	}

}
