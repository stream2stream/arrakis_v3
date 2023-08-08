DROP TABLE IF EXISTS bondsdata CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS trading_books CASCADE;

CREATE TABLE bondsdata
(
    id                    INT AUTO_INCREMENT PRIMARY KEY,
    trade_type            VARCHAR(10),
    trade_currency        VARCHAR(10),
    quantity              INT,
    trade_settlement_date DATE,
    trade_status          VARCHAR(10),
    trade_date            DATE,
    unit_price            DECIMAL(10, 2),
    coupon_percent        DECIMAL(10, 3),
    bond_currency         VARCHAR(10),
    cusip                 VARCHAR(50),
    face_value            INT,
    isin                  VARCHAR(50),
    issuer_name           VARCHAR(100),
    bond_maturity_date    DATE,
    status                VARCHAR(10),
    type                  VARCHAR(10),
    book_name             VARCHAR(50),
    bond_holder           VARCHAR(50)
);

CREATE TABLE users
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    firebase_user_id VARCHAR(50) UNIQUE
);

CREATE TABLE trading_books
(
    user_id INT,
    books   VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES users (id)
);
