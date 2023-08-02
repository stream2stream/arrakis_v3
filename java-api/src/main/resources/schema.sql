DROP TABLE IF EXISTS bonds;

CREATE TABLE bonds (
    isin VARCHAR(250) NOT NULL,
    type VARCHAR(250) NOT NULL,
    issuer_name VARCHAR(250) NOT NULL,
    bond_maturity_date DATE NOT NULL,
    face_value INT NOT NULL,
    bond_currency VARCHAR(10) NOT NULL,
    coupon_percent FLOAT NOT NULL,
    status VARCHAR(100) NOT NULL,
    cusip VARCHAR(100),
    PRIMARY KEY (isin)
);

DROP TABLE IF EXISTS trades;

CREATE TABLE trades (
    isin VARCHAR(250) NOT NULL,
    book_name VARCHAR(250) NOT NULL,
    bond_holder VARCHAR(250) NOT NULL,
    trade_status VARCHAR(20) NOT NULL,
    unit_price FLOAT NOT NULL,
    trade_currency VARCHAR(10) NOT NULL,
    trade_type VARCHAR(10) NOT NULL,
    trade_date DATE NOT NULL,
    trade_settlement_date DATE NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (isin)
);