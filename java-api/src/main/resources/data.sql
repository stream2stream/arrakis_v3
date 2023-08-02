INSERT INTO dogs (dog_id, name, age) VALUES (1, 'Einstein', 3);
INSERT INTO dogs (dog_id, name, age) VALUES (2, 'Kaya', 5);
INSERT INTO dogs (dog_id, name, age) VALUES (3, 'Lassie', 7);

INSERT INTO book (name) VALUES ('trading_book_1');
INSERT INTO book (name) VALUES ('trading_book_2');
INSERT INTO book (name) VALUES ('trading_book_3');
INSERT INTO book (name) VALUES ('trading_book_4');
INSERT INTO book (name) VALUES ('trading_book_5');
INSERT INTO book (name) VALUES ('trading_book_6');

INSERT INTO user (name, email) VALUES ('username', 'user@mail.de');

INSERT INTO book_user (book_id, user_id) VALUES (3, 1);
INSERT INTO book_user (book_id, user_id) VALUES (6, 1);

INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('XS1988387210', '', 'BNPParibasIssu 4,37% Microsoft Corp (USD)', '2021-08-05', 4.37, 'CORP', 1000, 'USD', 'active');
--INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('XS1988387210', '', 'BNPParibasIssu 4,37% Microsoft Corp (USD)', '2021-08-05', 4.37, 'CORP', 1000, 'GBP', 'active');