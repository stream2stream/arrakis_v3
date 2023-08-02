package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;
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
    private SecurityHandler cut;

    @Test
    public  void    add_a_dog_return_number_of_dogs_in_repo_is_one()
    {
        // arrange
        Security theDog = new Security();
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

    @Test
    public  void    add_several_dogs_return_number_of_dogs_match_number_added()
    {
        // arrange
        Security theDog = new Security();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Security();
        theDog.setName("Frank");
        cut.addDog( theDog );
        theDog = new Security();
        theDog.setName("Penny");
        cut.addDog( theDog );
        Mockito.when(itsDogsRepo.count()).thenReturn(3L);

        int expectedResult = 3;

        // act
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Ignore
    @Test
    public  void    add_dog_and_remove_dog_return_number_of_dogs_is_zero()
    {
        // arrange
        Security theDog = new Security();
        theDog.setName("Bruno");
        Mockito.when(itsDogsRepo.save(theDog)).thenReturn(theDog);
        Security uniqueDog = cut.addDog( theDog );

        Optional<Security> opt = Optional.of(theDog);
        Mockito.when(itsDogsRepo.findById(theDog.getId())).thenReturn(opt);

        long expectedResult = 0;
        boolean expectedStatus = true;

        // act
        boolean actualStatus = cut.removeDog( uniqueDog.getId() );
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
        verify(itsDogsRepo, times(1)).delete(theDog);
    }

    // This test covers the other logic path in cut.removeDog()
    @Ignore
    @Test
    public  void    add_dog_and_remove_dog_that_doess_not_exist_return_number_of_dogs_is_one()
    {
        // arrange
        Security theDog = new Security();
        theDog.setName("Bruno");
        Security uniqueDog = cut.addDog( theDog );

        long invalidId = 33;
        long expectedResult = 1;
        boolean expectedStatus = false;

        Optional<Security> opt = Optional.empty();
        Mockito.when(itsDogsRepo.findById(invalidId)).thenReturn(opt);

        Mockito.when(itsDogsRepo.count()).thenReturn(1L);

        // act
        // There is no dog with ID == 33
        boolean actualStatus = cut.removeDog( invalidId );
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
        verify(itsDogsRepo, times(0)).delete(theDog);
    }

    @Test
    public  void    find_dog_by_valid_id_returns_one_dog()
    {
        // arrange
        Security theDog = new Security();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Security();
        theDog.setName("Frank");
        Mockito.when(itsDogsRepo.save(theDog)).thenReturn(theDog);
        Security addedDog = cut.addDog( theDog );
        Security expectedDog = theDog;
        theDog = new Security();
        theDog.setName("Penny");
        cut.addDog( theDog );

        Security jpaDog = addedDog;
        Optional<Security> opt = Optional.of(addedDog);
        Mockito.when(itsDogsRepo.findById(addedDog.getId())).thenReturn(opt);

        // act
        Security actualResult = cut.getDogById( addedDog.getId() );

        // assert
        assertEquals( expectedDog.getId(), actualResult.getId() );
        assertEquals( expectedDog.getName(), actualResult.getName() );
    }

    @Ignore
    @Test
    public  void    find_dog_by_invalid_id_returns_null_dog()
    {
        // arrange
        Security theDog = new Security();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Security();
        theDog.setName("Frank");
        cut.addDog( theDog );
        theDog = new Security();
        theDog.setName("Penny");
        cut.addDog( theDog );
        long invalidId = 33;

        Optional<Security> opt = Optional.empty();
        Mockito.when(itsDogsRepo.findById(invalidId)).thenReturn(opt);

        // act
        assertThrows(NoSuchElementException.class, () -> {
            cut.getDogById( invalidId );
        });
    }

    @Test
    public  void    find_dog_by_name_returns_one_dog()
    {
        // arrange
        Security theDog = new Security();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Security();
        theDog.setName("Frank");
        cut.addDog( theDog );
        Security expectedDog = theDog;
        String dogToFind = "Frank";
        theDog = new Security();
        theDog.setName("Penny");
        cut.addDog( theDog );
        ArrayList<Security> expectedList = new ArrayList<>();
        expectedList.add(expectedDog);
        Mockito.when(itsDogsRepo.findByName(Mockito.any())).thenReturn(expectedList);

        // act
        Security actualResult = cut.getDogByName( dogToFind );

        // assert
        assertEquals( expectedDog.getId(), actualResult.getId() );
        assertEquals( expectedDog.getName(), actualResult.getName() );
    }


    @Test
    public  void    find_dog_by_name_returns_null_because_many_dogs_with_same_name()
    {
        // arrange
        Security theDog = new Security();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Security();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        Security expectedDog = theDog;
        String dogToFind = "Bruno";
        theDog = new Security();
        theDog.setName("Penny");
        cut.addDog( theDog );
        ArrayList<Security> expectedList = new ArrayList<>();
        Mockito.when(itsDogsRepo.findByName(Mockito.any())).thenReturn(expectedList);

        // act
        Security actualResult = cut.getDogByName( dogToFind );

        // assert
        assertNull( actualResult );
    }

    @Test
    public  void    find_dog_by_invalid_name_returns_null_dog()
    {
        // arrange
//        DogHandler cut = new DogHandler();
        Security theDog = new Security();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Security();
        theDog.setName("Frank");
        cut.addDog( theDog );
        theDog = new Security();
        theDog.setName("Penny");
        cut.addDog( theDog );
        ArrayList<Security> expectedList = new ArrayList<>();
        Mockito.when(itsDogsRepo.findByName(Mockito.any())).thenReturn(expectedList);

        // act
        Security actualResult = cut.getDogByName( "Selvyn" );

        // assert
        assertNull( actualResult );
    }

    @Ignore
    @Test
    public  void    update_dog_that_exists_returns_dog_id()
    {
        // arrange
        Security theDog = new Security();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Security();
        theDog.setName("Frank");
        Mockito.when(itsDogsRepo.save(theDog)).thenReturn(theDog);
        Security expectedDog = cut.addDog( theDog );
        Security dogToUpdate = theDog;
        String dogToFind = "Frank";
        theDog = new Security();
        theDog.setName("Penny");
        cut.addDog( theDog );
        Mockito.when(itsDogsRepo.save(dogToUpdate)).thenReturn(dogToUpdate);

        // act
        dogToUpdate.setName("Charlie");
        Security actualDog = cut.updateDogDetails( dogToUpdate );

        // assert
        assertEquals( expectedDog, actualDog );
    }
}
