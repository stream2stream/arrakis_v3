//package com.db.grad.javaapi.service;
//
//import com.db.grad.javaapi.model.Bond;
//import com.db.grad.javaapi.repository.BondsRepository;
//import org.junit.Ignore;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//public class BondHandlerTest
//{
//    @Mock
//    private BondsRepository itsDogsRepo;
//
//    @InjectMocks
//    private BondHandler cut;
//
//    @Test
//    public  void    add_a_dog_return_number_of_dogs_in_repo_is_one()
//    {
//        // arrange
//        Bond theBond = new Bond();
//        theBond.setName("Bruno");
//        Mockito.when(itsDogsRepo.save(theBond)).thenReturn(theBond);
//        Mockito.when(itsDogsRepo.count()).thenReturn(1L);
//        cut.addDog(theBond);
//
//        int expectedResult = 1;
//
//        // act
//        long actualResult = cut.getNoOfDogs();
//
//        // assert
//        assertEquals( expectedResult, actualResult );
//    }
//
//    @Test
//    public  void    add_several_dogs_return_number_of_dogs_match_number_added()
//    {
//        // arrange
//        Bond theBond = new Bond();
//        theBond.setName("Bruno");
//        cut.addDog(theBond);
//        theBond = new Bond();
//        theBond.setName("Frank");
//        cut.addDog(theBond);
//        theBond = new Bond();
//        theBond.setName("Penny");
//        cut.addDog(theBond);
//        Mockito.when(itsDogsRepo.count()).thenReturn(3L);
//
//        int expectedResult = 3;
//
//        // act
//        long actualResult = cut.getNoOfDogs();
//
//        // assert
//        assertEquals( expectedResult, actualResult );
//    }
//
//    @Ignore
//    @Test
//    public  void    add_dog_and_remove_dog_return_number_of_dogs_is_zero()
//    {
//        // arrange
//        Bond theBond = new Bond();
//        theBond.setName("Bruno");
//        Mockito.when(itsDogsRepo.save(theBond)).thenReturn(theBond);
//        Bond uniqueBond = cut.addDog(theBond);
//
//        Optional<Bond> opt = Optional.of(theBond);
//        Mockito.when(itsDogsRepo.findById(theBond.getId())).thenReturn(opt);
//
//        long expectedResult = 0;
//        boolean expectedStatus = true;
//
//        // act
//        boolean actualStatus = cut.removeDog( uniqueBond.getId() );
//        long actualResult = cut.getNoOfDogs();
//
//        // assert
//        assertEquals( expectedStatus, actualStatus);
//        assertEquals( expectedResult, actualResult );
//        verify(itsDogsRepo, times(1)).delete(theBond);
//    }
//
//    // This test covers the other logic path in cut.removeDog()
//    @Ignore
//    @Test
//    public  void    add_dog_and_remove_dog_that_doess_not_exist_return_number_of_dogs_is_one()
//    {
//        // arrange
//        Bond theBond = new Bond();
//        theBond.setName("Bruno");
//        Bond uniqueBond = cut.addDog(theBond);
//
//        long invalidId = 33;
//        long expectedResult = 1;
//        boolean expectedStatus = false;
//
//        Optional<Bond> opt = Optional.empty();
//        Mockito.when(itsDogsRepo.findById(invalidId)).thenReturn(opt);
//
//        Mockito.when(itsDogsRepo.count()).thenReturn(1L);
//
//        // act
//        // There is no dog with ID == 33
//        boolean actualStatus = cut.removeDog( invalidId );
//        long actualResult = cut.getNoOfDogs();
//
//        // assert
//        assertEquals( expectedStatus, actualStatus);
//        assertEquals( expectedResult, actualResult );
//        verify(itsDogsRepo, times(0)).delete(theBond);
//    }
//
//    @Test
//    public  void    find_dog_by_valid_id_returns_one_dog()
//    {
//        // arrange
//        Bond theBond = new Bond();
//        theBond.setName("Bruno");
//        cut.addDog(theBond);
//        theBond = new Bond();
//        theBond.setName("Frank");
//        Mockito.when(itsDogsRepo.save(theBond)).thenReturn(theBond);
//        Bond addedBond = cut.addDog(theBond);
//        Bond expectedBond = theBond;
//        theBond = new Bond();
//        theBond.setName("Penny");
//        cut.addDog(theBond);
//
//        Bond jpaBond = addedBond;
//        Optional<Bond> opt = Optional.of(addedBond);
//        Mockito.when(itsDogsRepo.findById(addedBond.getId())).thenReturn(opt);
//
//        // act
//        Bond actualResult = cut.getDogById( addedBond.getId() );
//
//        // assert
//        assertEquals( expectedBond.getId(), actualResult.getId() );
//        assertEquals( expectedBond.getName(), actualResult.getName() );
//    }
//
//    @Ignore
//    @Test
//    public  void    find_dog_by_invalid_id_returns_null_dog()
//    {
//        // arrange
//        Bond theBond = new Bond();
//        theBond.setName("Bruno");
//        cut.addDog(theBond);
//        theBond = new Bond();
//        theBond.setName("Frank");
//        cut.addDog(theBond);
//        theBond = new Bond();
//        theBond.setName("Penny");
//        cut.addDog(theBond);
//        long invalidId = 33;
//
//        Optional<Bond> opt = Optional.empty();
//        Mockito.when(itsDogsRepo.findById(invalidId)).thenReturn(opt);
//
//        // act
//        assertThrows(NoSuchElementException.class, () -> {
//            cut.getDogById( invalidId );
//        });
//    }
//
//    @Test
//    public  void    find_dog_by_name_returns_one_dog()
//    {
//        // arrange
//        Bond theBond = new Bond();
//        theBond.setName("Bruno");
//        cut.addDog(theBond);
//        theBond = new Bond();
//        theBond.setName("Frank");
//        cut.addDog(theBond);
//        Bond expectedBond = theBond;
//        String dogToFind = "Frank";
//        theBond = new Bond();
//        theBond.setName("Penny");
//        cut.addDog(theBond);
//        ArrayList<Bond> expectedList = new ArrayList<>();
//        expectedList.add(expectedBond);
//        Mockito.when(itsDogsRepo.findByName(Mockito.any())).thenReturn(expectedList);
//
//        // act
//        Bond actualResult = cut.getDogByName( dogToFind );
//
//        // assert
//        assertEquals( expectedBond.getId(), actualResult.getId() );
//        assertEquals( expectedBond.getName(), actualResult.getName() );
//    }
//
//
//    @Test
//    public  void    find_dog_by_name_returns_null_because_many_dogs_with_same_name()
//    {
//        // arrange
//        Bond theBond = new Bond();
//        theBond.setName("Bruno");
//        cut.addDog(theBond);
//        theBond = new Bond();
//        theBond.setName("Bruno");
//        cut.addDog(theBond);
//        Bond expectedBond = theBond;
//        String dogToFind = "Bruno";
//        theBond = new Bond();
//        theBond.setName("Penny");
//        cut.addDog(theBond);
//        ArrayList<Bond> expectedList = new ArrayList<>();
//        Mockito.when(itsDogsRepo.findByName(Mockito.any())).thenReturn(expectedList);
//
//        // act
//        Bond actualResult = cut.getDogByName( dogToFind );
//
//        // assert
//        assertNull( actualResult );
//    }
//
//    @Test
//    public  void    find_dog_by_invalid_name_returns_null_dog()
//    {
//        // arrange
////        DogHandler cut = new DogHandler();
//        Bond theBond = new Bond();
//        theBond.setName("Bruno");
//        cut.addDog(theBond);
//        theBond = new Bond();
//        theBond.setName("Frank");
//        cut.addDog(theBond);
//        theBond = new Bond();
//        theBond.setName("Penny");
//        cut.addDog(theBond);
//        ArrayList<Bond> expectedList = new ArrayList<>();
//        Mockito.when(itsDogsRepo.findByName(Mockito.any())).thenReturn(expectedList);
//
//        // act
//        Bond actualResult = cut.getDogByName( "Selvyn" );
//
//        // assert
//        assertNull( actualResult );
//    }
//
//    @Ignore
//    @Test
//    public  void    update_dog_that_exists_returns_dog_id()
//    {
//        // arrange
//        Bond theBond = new Bond();
//        theBond.setName("Bruno");
//        cut.addDog(theBond);
//        theBond = new Bond();
//        theBond.setName("Frank");
//        Mockito.when(itsDogsRepo.save(theBond)).thenReturn(theBond);
//        Bond expectedBond = cut.addDog(theBond);
//        Bond bondToUpdate = theBond;
//        String dogToFind = "Frank";
//        theBond = new Bond();
//        theBond.setName("Penny");
//        cut.addDog(theBond);
//        Mockito.when(itsDogsRepo.save(bondToUpdate)).thenReturn(bondToUpdate);
//
//        // act
//        bondToUpdate.setName("Charlie");
//        Bond actualBond = cut.updateDogDetails(bondToUpdate);
//
//        // assert
//        assertEquals(expectedBond, actualBond);
//    }
//}
