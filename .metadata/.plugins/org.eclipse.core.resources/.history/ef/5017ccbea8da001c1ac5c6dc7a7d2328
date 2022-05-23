package com.qa.SpringbootExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootExampleApplication.class, args);
		
	   

	    Object byName = context.getBean("Hello");
	    String byType = context.getBean(String.class);
	    String byBoth = context.getBean("Hello", String.class);

	    System.out.println(byName);
	    System.out.println(byType);
	    System.out.println(byBoth);
	}

	   @Bean
	    public String Hello() {
	        return "Hello, World";
	    }
}
