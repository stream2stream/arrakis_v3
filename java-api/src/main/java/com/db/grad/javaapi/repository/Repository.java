package com.db.grad.javaapi.repository;


import com.db.grad.javaapi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

@Repository
interface BookRepository extends JpaRepository<Book, Long> {
}

@Repository
interface BookUserRepository extends JpaRepository<BookUser, Long> {
}

@Repository
interface UserRepository extends JpaRepository<User, Long> {
}

@Repository
interface TradeRepository extends JpaRepository<Trade, Long> {
}

@Repository
interface BondRepository extends JpaRepository<Bond, Long> {
}