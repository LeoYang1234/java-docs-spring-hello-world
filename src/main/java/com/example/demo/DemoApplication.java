package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String sayHello() {
		return "Hello World!";
	}
	@RequestMapping("/helloAzure")
	String sayHelloFromAzure() {
		return "Hello from Azure!";
	}
	@RequestMapping("/highCPU")
	String highCPU() {
		final int NUM_TESTS = 1000;
    	long start = System.nanoTime();
    	for (int i = 0; i < NUM_TESTS; i++) {
        spin(500);
    	}
		return "I will cause high CPU!";
	}
}
