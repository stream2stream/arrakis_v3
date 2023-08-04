--DROP table IF EXISTS users;
--DROP table IF EXISTS security;
--DROP table IF EXISTS counterparty;
--DROP table IF EXISTS book;
--DROP table IF EXISTS trades;
--DROP table IF EXISTS book_users;
--CREATE DATABASE  bonds ;
--use bonds;

CREATE TABLE book(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    role varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE counterparty(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE  book_users (
     book_id  int NOT NULL,
     users_id  int NOT NULL,
     PRIMARY KEY (book_id,users_id),
     FOREIGN KEY (book_id) REFERENCES book(id),
     FOREIGN KEY (users_id) REFERENCES users(id)
);

CREATE TABLE  security (
     id  int NOT NULL AUTO_INCREMENT,
     isin  varchar(50) DEFAULT NULL,
     cusip  varchar(50) DEFAULT NULL,
     issuer_name  varchar(255) NOT NULL,
     maturity_date  date NOT NULL,
     coupon  float NOT NULL,
     type  varchar(255) NOT NULL,
     face_value  float NOT NULL,
     currency  varchar(10) NOT NULL,
     status  varchar(32) NOT NULL,
    PRIMARY KEY ( id )
);

CREATE TABLE  trades (
     id  int NOT NULL AUTO_INCREMENT,
     book_id  int NOT NULL,
     security_id  int NOT NULL,
     counterparty_id  int NOT NULL,
     currency  varchar(10) NOT NULL,
     status  varchar(32) NOT NULL,
     quantity  int NOT NULL,
     unit_price  float NOT NULL,
     buy_sell  varchar(32) NOT NULL,
     trade_date  date NOT NULL,
     settlement_date  date NOT NULL,
    PRIMARY KEY ( id ),
    FOREIGN KEY (security_id) REFERENCES security(id),
    FOREIGN KEY (counterparty_id) REFERENCES counterparty(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
);

