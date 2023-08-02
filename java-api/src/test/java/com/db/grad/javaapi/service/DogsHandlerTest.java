package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DogsHandlerTest
{
    @Mock
    private DogsRepository itsDogsRepo;

    @InjectMocks
    private DogHandler cut;

    @Test
    public  void    add_a_dog_return_number_of_dogs_in_repo_is_one()
    {
        // arrange
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        Mockito.when(itsDogsRepo.save(theDog)).thenReturn(theDog);
        Mockito.when(itsDogsRepo.count()).thenReturn(1L);
        cut.addDog( theDog );

        int expectedResult = 1;

        // act
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Ignore
    @Test
    public  void    update_dog_that_exists_returns_dog_id()
    {
        // arrange
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        Mockito.when(itsDogsRepo.save(theDog)).thenReturn(theDog);
        Dog expectedDog = cut.addDog( theDog );
        Dog dogToUpdate = theDog;
        String dogToFind = "Frank";
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );
        Mockito.when(itsDogsRepo.save(dogToUpdate)).thenReturn(dogToUpdate);

        // act
        dogToUpdate.setName("Charlie");
        Dog actualDog = cut.updateDogDetails( dogToUpdate );

        // assert
        assertEquals( expectedDog, actualDog );
    }
}
