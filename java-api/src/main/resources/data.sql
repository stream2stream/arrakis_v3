-- TO DO: input user details here

INSERT INTO dogs (dog_id, name, age) VALUES (1, 'Einstein', 3);
INSERT INTO dogs (dog_id, name, age) VALUES (2, 'Kaya', 5);
INSERT INTO dogs (dog_id, name, age) VALUES (3, 'Lassie', 7);
--INSERT INTO bond  SELECT "ISIN",max("CUSIP") FROM CSVREAD('C:\working\arrakis_v3\java-api\src\main\\resources\db-bonds-data.csv') GROUP BY "ISIN";

INSERT INTO bond (unit_price, coupon_percent, bond_currency, cusip, face_value, isin, issuer_name, bond_maturity_date, bond_status, bond_type, bond_book_number) SELECT max("UNIT_PRICE"), max("COUPON_PERCENT"), max("BOND_CURRENCY"), max("CUSIP"), max("face_value (mn)"), "ISIN", max("ISSUER_NAME"),  max(PARSEDATETIME("BOND_MATURITY_DATE", 'dd/MM/yyyy')), max("STATUS"), max("TYPE"), max(lower("BOOK_NAME")) FROM CSVREAD('C:\working\arrakis_v3\java-api\src\main\\resources\db-bonds-data.csv') GROUP BY "ISIN";
--