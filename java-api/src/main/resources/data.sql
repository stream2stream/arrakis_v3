INSERT INTO book (name) VALUES ('trading_book_1');
INSERT INTO book (name) VALUES ('trading_book_2');
INSERT INTO book (name) VALUES ('trading_book_3');
INSERT INTO book (name) VALUES ('trading_book_4');
INSERT INTO book (name) VALUES ('trading_book_5');
INSERT INTO book (name) VALUES ('trading_book_6');

INSERT INTO users (name, email) VALUES ('username', 'user@mail.de');

INSERT INTO book_users (book_id, user_id) VALUES ((SELECT id from book where name='trading_book_3'), (SELECT id from users where name='username'));
INSERT INTO book_users (book_id, user_id) VALUES ((SELECT id from book where name='trading_book_6'), (SELECT id from users where name='username'));

INSERT INTO security (isin, cusip, issuer_name, coupon_percent, bond_currency, face_value, maturity_date, status, type) VALUES ('XS1988387210', '', 'BNPParibasIssu 4,37% Microsoft Corp (USD)', 4.37, 'USD', 1000, '2021-08-05', 'active', 'CORP');
INSERT INTO security (isin, cusip, issuer_name, coupon_percent, bond_currency, face_value, maturity_date, status, type) VALUES ('USN0280EAR64', '123456780', 'Airbus 3.15%  USD', 3.15, 'USD', 900, '2021-07-30', 'active', 'CORP');
INSERT INTO security (isin, cusip, issuer_name, coupon_percent, bond_currency, face_value, maturity_date, status, type) VALUES ('A12356111', '123456bh0', 'UBS Facebook (USD)', 2, 'USD', 900, '2021-09-30', 'active', 'CORP');
INSERT INTO security (isin, cusip, issuer_name, coupon_percent, bond_currency, face_value, maturity_date, status, type) VALUES ('USU02320AG12', 'AMZN 3.15 08/22/27 REGS', 'Amazon', 3.15, 'USD', 900, '2021-08-03', 'active', 'CORP');
INSERT INTO security (isin, cusip, issuer_name, coupon_percent, bond_currency, face_value, maturity_date, status, type) VALUES ('GB00B6460505', 'BDCHBW8', 'HM Treasury United Kingdon', 0.75, 'GBP', 900, '2021-08-09', 'active', 'GOVN');
INSERT INTO security (isin, cusip, issuer_name, coupon_percent, bond_currency, face_value, maturity_date, status, type) VALUES ('US87973RAA86', '87973RAA8', 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S', 2.02, 'USD', 690, '2021-08-06', 'active', 'SOVN');
INSERT INTO security (isin, cusip, issuer_name, coupon_percent, bond_currency, face_value, maturity_date, status, type) VALUES ('IE00B29LNP31', '87973RAA8', 'First Norway Alpha Kl.IV', 1.123, 'USD', 340, '2030-12-22', 'active', 'SOVN');

INSERT INTO counter_party (bond_holder) VALUES ('AZ Holdings Inc');
INSERT INTO counter_party (bond_holder) VALUES ('Acme co');
INSERT INTO counter_party (bond_holder) VALUES ('Sovereign Investments');
INSERT INTO counter_party (bond_holder) VALUES ('Astra Trading Ltd');
INSERT INTO counter_party (bond_holder) VALUES ('Muncipal Gov Of Orange County');
INSERT INTO counter_party (bond_holder) VALUES ('Goldman Sachs');
INSERT INTO counter_party (bond_holder) VALUES ('UBS');
INSERT INTO counter_party (bond_holder) VALUES ('Barclays');
INSERT INTO counter_party (bond_holder) VALUES ('British Telecom');
INSERT INTO counter_party (bond_holder) VALUES ('Pension Holdings');
INSERT INTO counter_party (bond_holder) VALUES ('Zurich Pension fund 4');

