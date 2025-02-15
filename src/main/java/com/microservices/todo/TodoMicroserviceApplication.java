package com.microservices.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:messages.properties")
@EnableAspectJAutoProxy
public class TodoMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodoMicroserviceApplication.class, args);
	}
}
