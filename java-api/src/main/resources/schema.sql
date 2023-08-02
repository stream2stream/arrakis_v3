DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS trades;
DROP TABLE IF EXISTS book_user;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS security;
DROP TABLE IF EXISTS counter_party;

CREATE TABLE dogs (
    dog_id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
);

CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    bookName VARCHAR(250) NOT NULL
);

--CREATE TABLE book_user (
--    id INT PRIMARY KEY AUTO_INCREMENT,
--    book_id INT FOREIGN KEY REFERENCES books(id)
--);
CREATE TABLE security (
    id INT PRIMARY KEY AUTO_INCREMENT,
    isin VARCHAR(50) DEFAULT NULL,
    cusip VARCHAR(50) DEFAULT NULL,
    issuer_name VARCHAR(250) NOT NULL,
    maturity_date DATE NOT NULL,
    coupon FLOAT NOT NULL,
    type VARCHAR(250) NOT NULL,
    face_value FLOAT NOT NULL,
    currency VARCHAR(5) NOT NULL,
    status VARCHAR(50) DEFAULT NULL
);
CREATE TABLE counter_party (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL
);

CREATE TABLE trades (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT NOT NULL,
    security_id INT NOT NULL,
    counter_party_id INT NOT NULL,
    currency VARCHAR(5) NOT NULL,
    status VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    unit_price FLOAT NOT NULL,
    buy_sell VARCHAR(50) NOT NULL,
    trade_date DATE NOT NULL,
    settlement_date DATE NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (security_id) REFERENCES security(id),
    FOREIGN KEY (counter_party_id) REFERENCES counter_party(id)
    );


