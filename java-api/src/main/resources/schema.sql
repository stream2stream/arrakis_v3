DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS trades;
DROP TABLE IF EXISTS book_user;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS security;
DROP TABLE IF EXISTS counter_party;
DROP TABLE IF EXISTS bonds;

CREATE TABLE dogs (
    dog_id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
);

CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_name VARCHAR(250) NOT NULL
);

CREATE TABLE book_user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE security (
    id INT PRIMARY KEY AUTO_INCREMENT,
    isin VARCHAR(50) DEFAULT NULL,
    cusip VARCHAR(50) DEFAULT NULL,
    issuer_name VARCHAR(250) NOT NULL,
    maturity_date VARCHAR(50) NOT NULL,
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
    id INT PRIMARY KEY AUTO_INCREMENT
    book_id INT NOT NULL,
    security_id INT NOT NULL,
    counter_party_id INT NOT NULL,
    currency VARCHAR(5) NOT NULL,
    status VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    unit_price FLOAT NOT NULL,
    buy_sell VARCHAR(50) NOT NULL,
    trade_date VARCHAR(50) NOT NULL,
    settlement_date VARCHAR(50) NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (security_id) REFERENCES security(id),
    FOREIGN KEY (counter_party_id) REFERENCES counter_party(id)
);

CREATE TABLE bonds (
    id INT NOT NULL,
    bond_maturity_date VARCHAR(250) NOT NULL,
    isin VARCHAR(250) NOT NULL
);

CREATE VIEW IF NOT EXISTS all_bonds2 as
SELECT dog_id as id, name, age FROM dogs;

CREATE VIEW IF NOT EXISTS all_bonds as
SELECT  id, bond_maturity_date, isin from bonds;
