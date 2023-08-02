DROP TABLE IF EXISTS dogs;

CREATE TABLE security (
    id int auto_increment PRIMARY KEY, float couponPercent, varchar(3) bondCurrency, varchar(50) cusip, int faceValue,
    varchar(50) isin, varchar(10) bondsMaturityDate, varchar(10) status, varchar(4) type, varchar(50) issuerName

);

CREATE TABLE users (
    id int auto_increment PRIMARY KEY, varchar(50) username
);

CREATE TABLE book (
    id int auto_increment PRIMARY KEY, varchar(20) bookName
);

CREATE TABLE book_user (
    bookID int, FOREIGN KEY (bookID) REFERENCES book(id), int userID, FOREIGN KEY (userID) REFERENCES users(id);
);

CREATE TABLE counter_party (
    id int auto_increment PRIMARY KEY, varchar(50) bondHolder
);

CREATE TABLE trade (
    id int auto_increment PRIMARY KEY, varchar(4) tradeType, varchar(3) tradeCurrency, int quantity,
        varchar(10) tradeSettleDate, varchar(10) tradeStatus, varchar(10) tradeDate, float unitPrice,
        int counterPartyID, FOREIGN KEY (counterPartyID) REFERENCES counter_party(id),
        int securityID, FOREIGN KEY (securityID) REFERENCES security(id),
        int bookID, FOREIGN KEY (bookID) REFERENCES book(id)
);

