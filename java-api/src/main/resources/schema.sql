DROP TABLE IF EXISTS dogs;

CREATE TABLE security (
    id int auto_increment PRIMARY KEY, couponPercent float,  bondCurrency varchar(3),cusip varchar(50), faceValue int,
    isin varchar(50),issuerName varchar(60), bondMaturityDate varchar(10),status varchar(10),type varchar(4)

);

CREATE TABLE users (
    id int auto_increment PRIMARY KEY, username varchar(50)
);

CREATE TABLE book (
    id int auto_increment PRIMARY KEY, bookName varchar(20)
);

CREATE TABLE book_user (
    bookID int,userID int, FOREIGN KEY (bookID) REFERENCES book(id),  FOREIGN KEY (userID) REFERENCES users(id)
);

CREATE TABLE counter_party (
    id int auto_increment PRIMARY KEY, bondHolder varchar(50)
);

CREATE TABLE trade (
    id int auto_increment PRIMARY KEY,tradeType varchar(4),tradeCurrency varchar(3), quantity int,
        tradeSettlementDate varchar(10),tradeStatus varchar(10), tradeDate varchar(10), unitPrice float,
        counterPartyID int, securityID int,bookID int,
        FOREIGN KEY (counterPartyID) REFERENCES counter_party(id),
        FOREIGN KEY (securityID) REFERENCES security(id),
        FOREIGN KEY (bookID) REFERENCES book(id)
);

