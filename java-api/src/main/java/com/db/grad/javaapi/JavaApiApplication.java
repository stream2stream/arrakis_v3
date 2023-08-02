package com.db.grad.javaapi;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaApiApplication implements CommandLineRunner {

	@Autowired
	BondsService bondsService;

	public static void main(String[] args) {
		SpringApplication.run(JavaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for(Bond bond : bondsService.getBonds()) {
			System.out.println(bond.getIsin());
		}
	}
}
