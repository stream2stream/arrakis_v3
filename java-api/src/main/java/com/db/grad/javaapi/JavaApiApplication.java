package com.db.grad.javaapi;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JavaApiApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(JavaApiApplication.class, args);
	}



	@Autowired
	BondRepository bondRepository;
	@Override
	public void run(String... args) throws Exception{
		List<Bond> bonds = bondRepository.findAll();
		for(Bond bond: bonds){
			System.out.println(bond);
		}
	}

}
