INSERT INTO dogs (dog_id, name, age) VALUES (1, 'Einstein', 3);
INSERT INTO dogs (dog_id, name, age) VALUES (2, 'Kaya', 5);
INSERT INTO dogs (dog_id, name, age) VALUES (3, 'Lassie', 7);

INSERT INTO users (name, email, password) VALUES ('Bianca Serban', 'bianca@email.com', '123');
INSERT INTO users (name, email, password) VALUES ('Nicolas Muler', 'nicolas@email.com', '123');
INSERT INTO users (name, email, password) VALUES ('Catalin Badulescu', 'cata@email.com', '123');

--INSERT INTO books(bookName)
--SELECT  "book_name"
--FROM CSVREAD( ".\\db-bonds-data.csv", 'book_name', NULL );

INSERT INTO books (bookName)
SELECT DISTINCT book_name FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');

INSERT INTO book_user(book_id, user_id) VALUES (1, 1);
INSERT INTO book_user(book_id, user_id) VALUES (1, 2);
INSERT INTO book_user(book_id, user_id) VALUES (2, 1);
INSERT INTO book_user(book_id, user_id) VALUES (2, 3);
INSERT INTO book_user(book_id, user_id) VALUES (3, 2);

-- for H2 Console
--SELECT *
--FROM BOOK_USER a
--JOIN BOOKS b ON a.book_id = b.id JOIN USERS c on a.user_id = c.id;

INSERT INTO counter_party (name)
SELECT DISTINCT bond_holder FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');

INSERT INTO security (isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status)
SELECT DISTINCT isin, cusip, issuer_name, PARSEDATETIME(bond_maturity_date, 'd/M/yyyy'), coupon_percent, type, "face_value (mn)", bond_currency, status
FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');

INSERT INTO trades(book_id, counter_party_id, security_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date)
SELECT book_id, counterparty_id, security_id, trade_currency, trade_status, quantity, unit_price, trade_type, PARSEDATETIME(trade_date,'d/M/yyyy') , PARSEDATETIME(trade_settlement_date, 'd/M/yyyy')
FROM CSVREAD('.\\java-api\\src\\main\\resources\\trades.csv');







