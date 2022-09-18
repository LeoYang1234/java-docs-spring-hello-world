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
		long start  = System.currentTimeMillis();
        long count = 0;
        for(long x=0;x<Integer.MAX_VALUE ;x++){
            count+=1;
        }
        long end = System.currentTimeMillis();
		return "I will cause high CPU!";
	}
}
