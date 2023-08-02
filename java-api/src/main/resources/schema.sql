Drop Table IF exists Security;
Drop table IF exists Trade;
Drop Table IF exists users;
Drop Table IF exists CounterParty;
Drop Table IF exists Book;

CREATE TABLE Security (
    security_id int Not Null AUTO_INCREMENT PRIMARY KEY,
    isin VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    issuer VARCHAR(250) INT NOT NULL,
    maturity DATE NOT NULL,
    faceValue int NOT NULL,
    bondCurrency varchar(10) NOT NULL,
    coupon float not null,
    status varchar(20) not null,
);

create table CounterParty(
    bond_holder_id int not null AUTO_INCREMENT PRIMARY KEY,
    bond_holder varchar(250) not null,

);

Create table Trade (
    trade_id int not null AUTO_INCREMENT PRIMARY KEY,
    security_id int not null,
    book_id int not null,
    issuer_id int not null,
    trade_date DATE not null,
    trade_settlement_date DATE not null,
    trade_type varchar(10) not null,
    trade_currency varchar(10) not null,
    trade_status varchar(10) not null,
    unit_price int not null,
    quantity int not null,
    FOREIGN KEY (book_id) REFERENCES Book(book_id),
    FOREIGN KEY (security_id) Security(security_id),
    FOREIGN KEY (issuer_id) CounterParty(issuer_id)

);
create table Book(
    book_id int not null AUTO_INCREMENT primary key,
    book_name varchar(50) not null,

);


create table users(
    user_id int not null AUTO_INCREMENT PRIMARY KEY,
    issuer varchar(250) not null,

);
create table bookuser(
    bookuser_id int not null AUTO_INCREMENT PRIMARY KEY,
    user_id int not null,
    book_id int not null,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (book_id) REFERENCES Book(book_id),


);


