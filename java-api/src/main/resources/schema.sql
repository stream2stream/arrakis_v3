
Drop Table IF exists Security;
Drop table if exists Transactions;

CREATE TABLE Security (
    isin VARCHAR(50) NOT NULL PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    issuer VARCHAR(250) INT NOT NULL,
    maturity DATE NOT NULL,
    faceValue int NOT NULL,
    bondCurrency varchar(10) NOT NULL,
    coupon float not null,
    status varchar(20) not null,
);

Create table Trade (
    trade_id int not null AUTO_INCREMENT PRIMARY KEY,
    isin varchar(50) not null,
    book_id int not null,
    trade_date DATE not null,
    trade_settlement_date DATE not null,
    trade_type varchar(10) not null,
    trade_currency varchar(10) not null,
    trade_status varchar(10) not null,
    unit_price int not null,
    quantity int not null,
    FOREIGN KEY (book_id) REFERENCES Book(book_id),
    FOREIGN KEY (isin) REFERENCES Security(isin)




);
create table Book(
    book_id int not null AUTO_INCREMENT primary key,
    book_name varchar(50) not null,
    user_id int not null

);

create table users(
    user_id int not null AUTO_INCREMENT PRIMARY KEY,
    bond_holder_name varchar(250) not null,
    book_id varchar(50) not null,
    Foreign key (book_id) REFERENCES book(book_id)
);

