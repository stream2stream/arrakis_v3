
Drop table IF exists Trade;
Drop table IF exists bookuser;
Drop Table IF exists users;
Drop Table IF exists CounterParty;
Drop Table IF exists Book;
Drop Table IF exists Security;

CREATE TABLE TEST AS SELECT * FROM CSVREAD('C:/work/arrakis_v3/java-api/src/main/resources/db-bonds-data.csv');

create table Book(
    book_id int not null AUTO_INCREMENT primary key,
    book_name varchar(50) not null

);

create table users(
    user_id int not null AUTO_INCREMENT PRIMARY KEY,
    issuer_name varchar(255) not null,
    email VARCHAR (255)  default null,
    role VARCHAR (255) default null

);

create table CounterParty(
    bond_holder_id int not null AUTO_INCREMENT PRIMARY KEY,
    bond_holder varchar(250) not null

);

create table bookuser(
    user_id int not null,
    book_id int not null,
    PRIMARY KEY (book_id,user_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (book_id) REFERENCES Book(book_id)
);

CREATE TABLE Security(
    security_id int Not Null AUTO_INCREMENT PRIMARY KEY,
    isin VARCHAR(50) DEFAULT NULL,
    cusip VARCHAR (50) DEFAULT NULL,
    type VARCHAR(50) DEFAULT NULL,
    issuer_name VARCHAR(250) NOT NULL,
    maturity_date varchar(10) DEFAULT NULL,
    faceValue float NOT NULL,
    bondCurrency varchar(10) NOT NULL,
    coupon float not null,
    status varchar(20) not null
);

Create table Trade(
    trade_id int not null AUTO_INCREMENT PRIMARY KEY,
    security_id int not null,
    book_id int not null,
    bond_holder_id int not null,
    trade_date varchar(10) not null,
    trade_settlement_date varchar(10) not null,
    trade_type varchar(10) not null,
    trade_currency varchar(10) not null,
    trade_status varchar(10) not null,
    unit_price float not null,
    quantity int not null,
    FOREIGN KEY (book_id) REFERENCES Book(book_id),
    FOREIGN KEY (security_id) REFERENCES Security(security_id),
    FOREIGN KEY (bond_holder_id) REFERENCES CounterParty(bond_holder_id)

);







