package com.app;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class SpringBootJsonDocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJsonDocApplication.class, args);
	}

}
