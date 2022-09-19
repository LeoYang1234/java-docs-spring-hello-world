package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Vector;

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
	
	@RequestMapping("/highMEM")
	String highMEM() {
		Vector v = new Vector();
    	for(long x=0;x<Integer.MAX_VALUE ;x++)
    	{
      		byte b[] = new byte[1048576];
      		v.add(b);
    	}
		return "I will cause high memory!";
	}

	@RequestMapping(value = "/error/{id}")
	@ResponseBody
	public String getIDBySimplePathWithPathVariable(
  		@PathVariable("id") long id) {
    		return "Get a specific id=" + id;
	}

	@RequestMapping(value = "/error/{id}/param/{num}")
	@ResponseBody
	public String getIDandNumByPathVariable(
  		@PathVariable long id, @PathVariable long num) {
			long aNum = id/num;
    		return "Division of the two params are " + aNum;
	}
}
