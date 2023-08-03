DROP TABLE IF EXISTS Users;

CREATE TABLE Users (
   user_id INT NOT NULL AUTO_INCREMENT,
   user_name VARCHAR(255),
   user_email VARCHAR(255),
   user_password VARCHAR(255),
   PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS Book;

CREATE TABLE Book (
   book_id INT NOT NULL AUTO_INCREMENT,
   book_name VARCHAR(255),
   PRIMARY KEY (book_id)
);

DROP TABLE IF EXISTS Counter_Party;

CREATE TABLE Counter_Party (
   counter_party_id INT NOT NULL AUTO_INCREMENT,
   counter_party_name VARCHAR(255),
   PRIMARY KEY(counter_party_id)
);

DROP TABLE IF EXISTS Security;

CREATE TABLE Security (
   isin VARCHAR(255) PRIMARY KEY,  
   bond_currency VARCHAR(4),
   cusip VARCHAR(255),
   face_value_mn DOUBLE,
   issuer_name VARCHAR(255),
   bond_maturity_date DATE,
   s_status VARCHAR(50),
   s_type VARCHAR(50),
   coupon_percent  DOUBLE
);

DROP TABLE IF EXISTS Trade;

CREATE TABLE Trade (
   trade_id INT NOT NULL AUTO_INCREMENT,
   trade_type VARCHAR(50),
   trade_currency VARCHAR(4),
   quantity INT,
   trade_settlement_date DATE,
   trade_status VARCHAR(50),
   trade_date DATE,
   unit_price  DOUBLE,
   book_id INT,
   isin VARCHAR(255),
   bond_holder VARCHAR(255),
   PRIMARY KEY (trade_id),
   FOREIGN KEY (book_id) REFERENCES Book(book_id),
   FOREIGN KEY (isin) REFERENCES Security(isin)
);

DROP TABLE IF EXISTS Book_User;

CREATE TABLE Book_User (
   user_id INT,
   book_id INT,
   PRIMARY KEY (user_id, book_id),
   FOREIGN KEY (user_id) REFERENCES Users(user_id),
   FOREIGN KEY (book_id) REFERENCES Book(book_id)
);

--delete (just for testing)
DROP TABLE IF EXISTS dogs;

CREATE TABLE dogs (
    dog_id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    age INT NOT NULL
);