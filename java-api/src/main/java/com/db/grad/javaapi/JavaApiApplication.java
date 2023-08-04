package com.db.grad.javaapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan("com.db.grab.javaapi")
public class JavaApiApplication {


	public static void main(String[] args) {

		SpringApplication.run(JavaApiApplication.class, args);
	}

}
