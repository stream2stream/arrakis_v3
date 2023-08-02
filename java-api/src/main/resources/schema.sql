-- DROP TABLE IF EXISTS dogs;
--
-- CREATE TABLE dogs (
--     dog_id INT NOT NULL,
--     name VARCHAR(250) NOT NULL,
--     age INT NOT NULL
-- );
DROP TABLE IF EXISTS bonds;

CREATE TABLE bonds (
    coupon_percent float NOT NULL,
    bond_currency varchar NOT NULL,
    cusip varchar,
    face_value int NOT NULL,
    isin varchar PRIMARY KEY,
    bond_maturity date NOT NULL,
    issuer_name varchar NOT NULL,
    status varchar NOT NULL,
    type varchar NOT NULL
);

-- DROP TABLE IF EXISTS books;
--
-- CREATE TABLE books (
--     name varchar PRIMARY KEY
-- );
--
-- DROP TABLE IF EXISTS users;
--
-- CREATE TABLE users ( // who is the user? ask Sel
--     id int PRIMARY KEY
-- );
--
-- DROP TABLE IF EXISTS counterparties;
--
-- CREATE TABLE counterparties (
--     id int PRIMARY KEY AUTO_INCREMENT,
--     name varchar NOT NULL,
-- );
--
-- DROP TABLE IF EXISTS trades;
--
-- CREATE TABLE trades (
--     id int PRIMARY KEY AUTO_INCREMENT,
--     trade_type varchar NOT NULL,
--     trade_currency varchar NOT NULL,
--     quantity int NOT NULL,
--     trade_status varchar NOT NULL,
--     trade_date date NOT NULL,
--     isin int NOT NULL, // foreign key
--     book_name varchar NOT NULL, // foreign key
--     bond_holder varchar NOT NULL, // foreign key
--     FOREIGN key (isin) REFERENCES bonds (isin),
--     FOREIGN key (book_name) REFERENCES books (name),
--     FOREIGN key (bond_holder) REFERENCES counterparties (name),
-- );