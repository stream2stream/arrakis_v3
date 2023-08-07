DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS booksUsers;
DROP TABLE IF EXISTS trades;

CREATE TABLE users (
    userid INT NOT NULL AUTO_INCREMENT,
    bondholder VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL,
    PRIMARY KEY (userid)
);

CREATE TABLE books (
    bookid INT NOT NULL AUTO_INCREMENT,
    bookname VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    bondmaturitydate VARCHAR(100),
    issuername VARCHAR(200) NOT NULL,
    isin VARCHAR(100) NOT NULL,
    facevalue INT NOT NULL,
    cusip VARCHAR(100),
    bondcurrency VARCHAR(100) NOT NULL,
    couponpercent DOUBLE NOT NULL,
    unitprice DOUBLE NOT NULL,
    PRIMARY KEY (bookid)
);

CREATE TABLE booksusers (
    bookuserid int AUTO_INCREMENT,
    userid int NOT NULL,
    bookid int NOT NULL,
    PRIMARY KEY (bookuserid)
);


CREATE TABLE trades (
    tradeid int NOT NULL AUTO_INCREMENT,
    tradetype VARCHAR(250) NOT NULL,
    bookid VARCHAR(100) NOT NULL,
    isin VARCHAR(100) NOT NULL,
    tradecurrency VARCHAR(250) NOT NULL,
    tradedate VARCHAR(100) NOT NULL,
    tradestatus VARCHAR(50) NOT NULL,
    tradesettlementdate VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (tradeid)
);
