DROP TABLE IF EXISTS dogs;

CREATE TABLE dogs (
    dog_id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    role VARCHAR(250) NOT NULL
);

CREATE TABLE book_user (
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN key (book_id) REFERENCES book (id),
    FOREIGN key (user_id) REFERENCES user (id)
)

CREATE TABLE security (
    id INT AUTO_INCREMENT PRIMARY KEY,
    isin VARCHAR(50),
    cusip VARCHAR(50),
    issuer_name VARCHAR(250) NOT NULL,
    maturity_date DATE NOT NULL,
    coupon FLOAT NOT NULL,
    type VARCHAR(250) NOT NULL,
    face_value FLOAT NOT NULL,
    currency VARCHAR(10) NOT NULL,
    status VARCHAR(50) NOT NULL
)

CREATE TABLE trades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    security_id INT NOT NULL,
--    counterparty_id INT NOT NULL,
    currency VARCHAR(10) NOT NULL,
    status VARCHAR(50) NOT NULL
    quantity INT NOT NULL,
    unit_price FLOAT NOT NULL,
    buy_sell VARCHAR(50) NOT NULL,
    trade_date DATE NOT NULL,
    settlement_date DATE NOT NULL,
    FOREIGN key (book_id) REFERENCES book (id),
    FOREIGN key (security_id) REFERENCES security (id),
--    FOREIGN key (counterparty_id) REFERENCES counterparty (id),

)