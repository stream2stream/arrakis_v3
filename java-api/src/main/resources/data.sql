-- Book Data
INSERT INTO book (id,status,type,name) VALUES (1, 'active', 'CORP', 'trading_book_1');
INSERT INTO book (id,status,type,name) VALUES (2, 'active', 'CORP', 'trading_book_2');
INSERT INTO book (id,status,type,name) VALUES (3, 'active', 'CORP', 'trading_book_3');
INSERT INTO book (id,status,type,name) VALUES (4, 'active', 'SOVN', 'trading_book_4');
INSERT INTO book (id,status,type,name) VALUES (5, 'active', 'GOVN', 'trading_book_6');

--Security Data
INSERT INTO security (id,coupon_percent,bond_currency,cusip, face_value, isin, issuer_name, bond_maturity_date) VALUES (1,4.37,'USD','',1000,'XS1988387210','BNPParibasIssu 4,37% Microsoft Corp (USD)','2021-08-05');
INSERT INTO security (id,coupon_percent,bond_currency,cusip, face_value, isin, issuer_name, bond_maturity_date) VALUES (2,3.15,'USD','123456780',900,'USN0280EAR64','Airbus 3.15%  USD','2021-07-30');
INSERT INTO security (id,coupon_percent,bond_currency,cusip, face_value, isin, issuer_name, bond_maturity_date) VALUES (3,2,'USD','123456bh0',900,'A123456111','UBS Facebook (USD)','2021-09-30');
INSERT INTO security (id,coupon_percent,bond_currency,cusip, face_value, isin, issuer_name, bond_maturity_date) VALUES (4,2.02,'USD','87973RAA8',690,'US87973RAA86','TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S','2021-08-06');
INSERT INTO security (id,coupon_percent,bond_currency,cusip, face_value, isin, issuer_name, bond_maturity_date) VALUES (5,0.75,'GBP','BDCHBW8',900,'GB00B6460510','HM Treasury United Kingdon','2021-08-09');