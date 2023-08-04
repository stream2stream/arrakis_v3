package com.db.grad.javaapi;

import com.db.grad.javaapi.repository.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JavaApiApplication {
	@Autowired
	private BondRepository bondRepository;
	public static void main(String[] args) {
		SpringApplication.run(JavaApiApplication.class, args);
	}

}
