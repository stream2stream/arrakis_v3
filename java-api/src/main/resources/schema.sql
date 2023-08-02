

CREATE TABLE IF NOT EXISTS users (
    email varchar(50) check (email like '%@%.%') NOT NULL PRIMARY KEY,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS books(
    book_number INT NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS book_users (
    book INT FOREIGN KEY REFERENCES books(book_number),
    users VARCHAR(100) FOREIGN KEY REFERENCES users(email)
);

CREATE TABLE IF NOT EXISTS bond(
    isin VARCHAR(12) PRIMARY KEY,
    cusip VARCHAR(30) NOT NULL,
    unit_price FLOAT NOT NULL,
    coupon_percent FLOAT NOT NULL,
    bond_currency ENUM('USD','GBP') NOT NULL,
    issuer_name VARCHAR(200) NOT NULL,
    face_value INT NOT NULL,
    bond_maturity_date DATE NOT NULL,
    bond_status ENUM('active', 'inactive') NOT NULL,
    bond_type ENUM('CORP','GOVN','SOVN') NOT NULL,
    bond_book_nr INT FOREIGN KEY REFERENCES books(book_number)
);

CREATE TABLE IF NOT EXISTS trade (
    trade_id INT PRIMARY KEY,
    trade_type ENUM('sell', 'buy') NOT NULL,
    trade_currency ENUM('USD','GBP') NOT NULL,
    quantity INT NOT NULL,
    trade_settlement_date DATE NOT NULL,
    trade_status ENUM('open', 'closed') NOT NULL,
    trade_date DATE NOT NULL,
    bond_holder INT FOREIGN KEY REFERENCES bond_holder(bond_holder_id)
);

CREATE TABLE IF NOT EXISTS bond_holder(
    bond_holder_id INT AUTO_INCREMENT PRIMARY KEY,
    bond_holder_name VARCHAR(100) NOT NULL
);