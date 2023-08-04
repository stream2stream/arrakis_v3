DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS booksUsers;
DROP TABLE IF EXISTS trades;

CREATE TABLE users (
    userid INT NOT NULL AUTO_INCREMENT,
    bondholder VARCHAR(100) NOT NULL,
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
    bondholder VARCHAR(250) NOT NULL,
    bookname VARCHAR(250) NOT NULL,
    PRIMARY KEY (bookuserid)
);


CREATE TABLE trades (
    tradeid int NOT NULL AUTO_INCREMENT,
    tradetype VARCHAR(250) NOT NULL,
    bookname VARCHAR(100) NOT NULL,
    isin VARCHAR(100) NOT NULL,
    tradecurrency VARCHAR(250) NOT NULL,
    tradedate VARCHAR(100) NOT NULL,
    tradestatus VARCHAR(50) NOT NULL,
    tradesettlementdate VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (tradeid)
);

CREATE table credentials (
    CREDENTIALS_ID int not null auto_increment,
    FIRST_NAME varchar(100) not null,
    LAST_NAME varchar(100) not null,
    EMAIL varchar(100) not null,
    PASSWORD varchar(100) not null,
    PRIMARY KEY (CREDENTIALS_ID)
);


