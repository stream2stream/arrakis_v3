-- Insert User Data
INSERT INTO Users (user_id, user_name, user_email, user_password)
VALUES
    (1, 'admin', 'admin','password');


-- Insert Book Data
INSERT INTO Book (book_id, book_name)
VALUES
    (1, 'trading_book_1'),
    (2, 'trading_book_2'),
    (3, 'Trading_book_3'),
    (4, 'Trading_book_4'),
    (5, 'Trading_book_6');


--- Insert Counter Party Data
INSERT INTO Counter_Party (counter_party_id, counter_party_name)
VALUES
    (1, 'CounterParty1'),
    (2, 'CounterParty2'),
    (3, 'CounterParty3'),
    (4, 'CounterParty4'),
    (5, 'CounterParty5'),
    (6, 'CounterParty6'),
    (7, 'CounterParty7'),
    (8, 'CounterParty8'),
    (9, 'CounterParty9');

-- Insert Security Data
INSERT INTO Security (isin, bond_currency, cusip, face_value_mn, issuer_name, bond_maturity_date, s_status, s_type, coupon_percent)
VALUES
    ('XS1988387210', 'USD', NULL, 1000, 'BNPParibasIssu 4,37% Microsoft Corp (USD)', '2021-08-05', 'active', 'CORP', 4.37),
    ('USN0280EAR64', 'USD', '123456780', 900, 'Airbus 3.15%  USD', '2021-07-30', 'active', 'CORP', 3.15),
    ('A12356111', 'USD', '123456bh0', 900, 'UBS Facebook (USD)', '2021-09-30', 'active', 'CORP', 2),
    ('USU02320AG12', 'USD', 'AMZN 3.15 08/22/27 REGS', 900, 'Amazon', '2021-08-03', 'active', 'CORP', 3.15),
    ('GB00B6460505', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 0.75),
    ('GB00B6460506', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 0.75),
    ('GB00B6460507', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 0.75),
    ('GB00B6460508', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 0.75),
    ('GB00B6460509', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 0.75),
    ('GB00B6460510', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 0.75),
    ('GB00B6460511', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 0.75),
    ('GB00B6460512', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 0.75),
    ('GB00B6460513', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 0.75),
    ('GB00B6460514', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 0.75),
    ('GB00B6460515', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 0.75),
    ('US87973RAA86', 'USD', '87973RAA8', 690, 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S', '2021-08-06', 'active', 'SOVN',2.02),
    ('IE00B29LNP31', 'USD', '87973RAA8', 340, 'First Norway Alpha Kl.IV', '2030-12-22', 'active', 'SOVN', 1.123);


-- Insert Trade Data
INSERT INTO Trade (
    trade_id, trade_type, trade_currency, quantity, trade_settlement_date,
    trade_status, trade_date, unit_price, book_id, isin, bond_holder
)
VALUES
    (1, 'buy', 'USD', 50, '2021-08-04', 'open', '2021-05-13', 90, 1, 'XS1988387210', 'AZ Holdings Inc'),
    (2, 'sell', 'GBP', 40, '2021-08-04', 'open', '2021-02-04', 89.56, 1, 'XS1988387210', 'AZ Holdings Inc'),
    (3, 'buy', 'USD', 1000, '2021-08-23', 'open', '2021-05-13', 105.775, 2, 'USN0280EAR64', 'Acme co'),
    (4, 'sell', 'GBP', 900, '2021-09-10', 'open', '2021-02-04', 105.775, 2, 'USN0280EAR64', 'Acme Co'),
    (5, 'buy', 'USD', 50, '2021-08-23', 'open', '2021-05-13', 90, 3, 'A12356111', 'Sovereign Investments'),
    (6, 'buy', 'USD', 1000, '2021-08-23', 'open', '2021-05-13', 105.775, 2, 'USN0280EAR64', 'Astra Trading Ltd'),
    (7, 'sell', 'USD', 50, '2021-08-23', 'open', '2021-05-13', 90, 3, 'A12356111', 'Sovereign Investments'),
    (8, 'buy', 'GBP', 60, '2021-09-27', 'open', '2021-02-04', 98.56, 4, 'GB00B6460505', 'Muncipal Gov Of Orange County'),
    (9, 'buy', 'USD', 50, '2021-08-23', 'open', '2021-08-23', 98.56, 4, 'GB00B6460505', 'Muncipal Gov Of Orange County'),
    (10, 'buy', 'GBP', 1100, '2021-09-27', 'open', '2021-09-27', 110.35, 5, 'GB00B6460507', 'Goldman Sachs'),
    (11, 'sell', 'GBP', 900, '2021-09-28', 'open', '2021-09-28', 110.35, 5, 'GB00B6460506', 'Goldman Sachs'),
    (12, 'buy', 'GBP', 2000, '2021-09-29', 'open', '2021-09-29', 110.35, 5, 'GB00B6460507', 'UBS'),
    (13, 'sell', 'GBP', 2000, '2021-09-30', 'open', '2021-09-30', 110.35, 5, 'GB00B6460508', 'UBS'),
    (14, 'buy', 'GBP', 1000, '2021-10-01', 'open', '2021-10-01', 110.35, 5, 'GB00B6460509', 'Barclays'),
    (15, 'buy', 'GBP', 900, '2019-10-02', 'open', '2019-10-02', 110.35, 5, 'GB00B6460510', 'Barclays'),
    (16, 'sell', 'GBP', 1900, '2019-10-03', 'open', '2019-10-03', 110.35, 5, 'GB00B6460511', 'Barclays'),
    (17, 'buy', 'GBP', 600, '2018-10-04', 'open', '2018-10-04', 110.35, 5, 'GB00B6460512', 'British Telecom'),
    (18, 'buy', 'GBP', 600, '2019-10-05', 'open', '2019-10-05', 110.35, 5, 'GB00B6460513', 'Pension Holdings'),
    (19, 'buy', 'GBP', 700, '2021-06-06', 'open', '2021-06-06', 110.35, 5, 'GB00B6460514', 'Pension Holdings'),
    (20, 'sell', 'GBP', 1300, '2021-10-07', 'open', '2011-10-07', 110.35, 5, 'GB00B6460515', 'Pension Holdings'),
    (21, 'buy', 'USD', 60, '2021-09-27', 'open', '2012-02-04', 100.13, 4, 'US87973RAA86', 'Zurich Pension fund 4'),
    (22, 'buy', 'USD', 50, '2021-08-23', 'open', '2012-08-23', 100.13, 4, 'US87973RAA86', 'Zurich Pension fund 4'),
    (23, 'buy', 'USD', 75, '2021-09-27', 'open', '2013-02-04', 100.13, 4, 'US87973RAA86', 'Zurich Pension fund 4'),
    (24, 'buy', 'USD', 50, '2021-08-23', 'open', '2014-08-23', 100.13, 4, 'US87973RAA86', 'Zurich Pension fund 4'),
    (25, 'buy', 'USD', 300, '2021-09-27', 'open', '2016-02-04', 98.76, 4, 'IE00B29LNP31', 'Zurich Pension fund 4'),
    (26, 'buy', 'USD', 300, '2021-08-23', 'open', '2012-08-23', 98.76, 4, 'IE00B29LNP31', 'Zurich Pension fund 4'),
    (27, 'buy', 'USD', 300, '2021-09-27', 'open', '2013-04-02', 98.76, 4, 'IE00B29LNP31', 'Zurich Pension fund 4'),
    (28, 'sell', 'USD', 300, '2021-08-23', 'open', '2015-08-23', 98.76, 4, 'IE00B29LNP31', 'Zurich Pension fund 4');


-- delete (just for testing)
INSERT INTO dogs (dog_id, name, age) VALUES (1, 'Einstein', 3);
INSERT INTO dogs (dog_id, name, age) VALUES (2, 'Kaya', 5);
INSERT INTO dogs (dog_id, name, age) VALUES (3, 'Lassie', 7);