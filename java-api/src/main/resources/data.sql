-- TO DO: input user details here

INSERT INTO dogs (dog_id, name, age) VALUES (1, 'Einstein', 3);
INSERT INTO dogs (dog_id, name, age) VALUES (2, 'Kaya', 5);
INSERT INTO dogs (dog_id, name, age) VALUES (3, 'Lassie', 7);


INSERT INTO bond (unit_price, coupon_percent, bond_currency, cusip, face_value, isin, issuer_name, bond_maturity_date, bond_status, bond_type) SELECT max("UNIT_PRICE"), max("COUPON_PERCENT"), max("BOND_CURRENCY"), max("CUSIP"), max("face_value (mn)"), "ISIN", max("ISSUER_NAME"),  max(PARSEDATETIME("BOND_MATURITY_DATE", 'dd/MM/yyyy')), max("STATUS"), max("TYPE") FROM CSVREAD('C:\working\arrakis_v3\java-api\src\main\\resources\db-bonds-data.csv') GROUP BY "ISIN";
INSERT INTO books (book_number) SELECT DISTINCT lower("BOOK_NAME") FROM CSVREAD('C:\working\arrakis_v3\java-api\src\main\\resources\db-bonds-data.csv');
INSERT INTO users (email, password) SELECT "EMAIL", "PASSWORD" FROM CSVREAD('C:\working\arrakis_v3\java-api\src\main\\resources\users.csv');
INSERT INTO book_users (book, user_email) SELECT "BOOK", "USER_EMAIL" FROM CSVREAD('C:\working\arrakis_v3\java-api\src\main\\resources\bookusers.csv');