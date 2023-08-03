-- CREATE TABLE `bonds` (
--     `id` int NOT NULL AUTO_INCREMENT,
--     `isin` varchar(50) DEFAULT NULL,
--     `cusip` varchar(50) DEFAULT NULL,
--     `issuer_name` varchar(255) NOT NULL,
--     `bond_maturity` date NOT NULL,
--     `coupon_percent` float NOT NULL,
--     `type` varchar(255) NOT NULL,
--     `face_value` float NOT NULL,
--     `bond_currency` varchar(10) NOT NULL,
--     `status` varchar(32) DEFAULT NULL,
--     PRIMARY KEY (`id`)
-- )
DROP TABLE bonds IF EXISTS;

CREATE TABLE bonds (
    isin varchar(50) PRIMARY KEY,
    cusip varchar(50),
    bond_currency varchar(10) NOT NULL,
    face_value int NOT NULL,
    bond_maturity date NOT NULL,
    coupon_percent float NOT NULL,
    issuer_name varchar(255) NOT NULL,
    status varchar(32) NOT NULL,
    type varchar(255) NOT NULL
);