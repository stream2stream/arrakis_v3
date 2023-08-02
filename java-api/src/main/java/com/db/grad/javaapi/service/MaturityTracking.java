package com.db.grad.javaapi.service;
import com.db.grad.javaapi.model.*; // Import the model classses
import com.db.grad.javaapi.repository.*; // Import the security repo
import org.springframework.beans.factory.annotation.Autowired; // Importing the springboot framework
import org.springframework.stereotype.Service;

@Service
public class MaturityTracking {
    // Private variable for repo
    private BondsRepository bondsRepository;

    // Constructor for the class
    @Autowired
    public MaturityTracking(BondsRepository bondsRepository) {
        this.bondsRepository = bondsRepository;
    }


}
