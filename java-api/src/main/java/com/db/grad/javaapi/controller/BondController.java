package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class BondController {
    private AppService s;

    @Autowired
    public BondController(AppService s)
    {
        this.s = s;
    }

    @GetMapping("/getAllBonds")
    public List<Bond> getAllBonds(){
        return s.getAllBonds();
    }

    @GetMapping("/getAllTrades")
    public List<Trade> getAllTrade(){
        return s.getAllTrades();
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return s.getAllBooks();
    }



    //These need userId param
    // USE OF THESE API LOOKS LIKE THIS: ./getBondsByUserId?userId=0
    @GetMapping("/getBondsByUserId")
    public List<Bond> getBondsByUserId(@RequestParam int userId) {
        return s.findBondsByUserId(userId);
    }

    //USE OF API LOOKS LIKE THIS: /getTradesByBondIdAndUserId?bondId=1&userId=1
    @GetMapping("/getTradesByBondIdAndUserId")
    public List<Trade> getBondsByBondIdAndUserId(@RequestParam int bondId, @RequestParam int userId) {
        return s.findTradesByBondIdAndUserId(bondId, userId);
    }



//    // USE OF THESE API LOOKS LIKE THIS: ./getBondsIn5Days?date=2023-08-10&userId=1
    @GetMapping("/getBondsIn5Days")
    public List<Bond> findUserBondsWithMaturityDateInFiveDays(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam int userId) {
        return s.findUserBondsWithMaturityDateInFiveDays(date, userId);
    }
    // USE OF THESE API LOOKS LIKE THIS: ./getBondsBefore5Days?date=2023-08-10&userId=1
    @GetMapping("/getBondsBefore5Days")
    public List<Bond> findUserBondsWithMaturityDateFiveDaysBefore(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam int userId) {
        return s.findUserBondsWithMaturityDateFiveDaysBefore(date, userId);
    }






    // USE OF THESE API LOOKS LIKE THIS: ./getBondsByBookId?bookId=0
    @GetMapping("/getBondsByBookId")
    public List<Bond> getBondsByBookId(@RequestParam int bookId) {
        return s.findBondsByBookId(bookId);
    }

//    // USE OF THESE API LOOKS LIKE THIS: ./getBondsIn5Days?date=2023-08-10
//    @GetMapping("/getBondsIn5Days")
//    public List<Bond> findBondsWithMaturityDateInFiveDays(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
//        return s.findBondsWithMaturityDateInFiveDays(date);
//    }
//    // USE OF THESE API LOOKS LIKE THIS: ./getBondsBefore5Days?date=2023-08-10
//    @GetMapping("/getBondsBefore5Days")
//    public List<Bond> findBondsWithMaturityDateFiveDaysBefore(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
//        return s.findBondsWithMaturityDateFiveDaysBefore(date);
//    }

    //FUNCTION FOR TESTING
    //    /getBondsBefore5Days?bondId=1
    @GetMapping("/getTradesByBondId")
    public List<Trade> getTradesByBookId(@RequestParam int bondId) {
        return s.findTradesByBondId(bondId);
    }



    //  curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "username=newUser123" http://localhost:8080/api/addUserByName
    @PostMapping("/addUserByName")
    public ResponseEntity<User> addUserByUsername(@RequestParam String username) {
        User newUser = s.addUserByName(username);
        return ResponseEntity.ok(newUser);
    }


    // curl -X POST -H "Content-Type: application/json" -d "[1, 2, 3]" http://localhost:8080/api/users/1/assignBooks
    @PostMapping("/users/{userId}/assignBooks")
    public ResponseEntity<Void> assignBooksToUser(
            @PathVariable int userId,
            @RequestBody List<Integer> bookIds) {
        s.assignBooksToUser(userId, bookIds);
        return ResponseEntity.ok().build();
    }

}