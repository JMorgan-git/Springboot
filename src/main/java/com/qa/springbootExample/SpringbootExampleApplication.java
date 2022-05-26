package com.qa.springbootExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class SpringbootExampleApplication {

	public static void main(String[] args) {
		//ApplicationContext context = 
		SpringApplication.run(SpringbootExampleApplication.class, args);
		
//		Object byName = context.getBean("hello");
//		String byType = context.getBean(String.class);
//		String byBoth = context.getBean("hello", String.class);
//		
//		System.out.println(byName);
//		System.out.println(byType);
//		System.out.println(byBoth);
	}

}
