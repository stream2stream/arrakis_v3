INSERT INTO bondsdata (trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date,
                       unit_price, coupon_percent, bond_currency, cusip, face_value, isin, issuer_name,
                       bond_maturity_date, status, type, book_name, bond_holder)
VALUES ('BUY', 'USD', 100, '2019-01-01', 'SETTLED', '2019-01-01', 100.00, 0.05, 'USD', 'US9128285C83', 100,
        'US9128285C83', 'US TREASURY NOTE', '2020-01-01', 'ACTIVE', 'TREASURY', 'trading_book_1', 'HOLDER1'),
       ('BUY', 'USD', 100, '2019-01-01', 'SETTLED', '2019-01-01', 100.00, 0.05, 'USD', 'US9128285C83', 100,
        'XS1988387210', 'US TREASURY NOTE', '2020-01-01', 'ACTIVE', 'TREASURY', 'trading_book_2', 'HOLDER2'),
       ('BUY', 'USD', 100, '2019-01-01', 'SETTLED', '2019-01-01', 100.00, 0.05, 'USD', 'US9128285C83', 100,
        'USN0280EAR64', 'US TREASURY NOTE', '2020-01-01', 'ACTIVE', 'TREASURY', 'Trading_book_3', 'HOLDER3'),
       ('BUY', 'USD', 100, '2019-01-01', 'SETTLED', '2019-01-01', 100.00, 0.05, 'USD', 'US9128285C83', 100, 'A12356111',
        'US TREASURY NOTE', '2020-01-01', 'ACTIVE', 'TREASURY', 'BOOK4', 'HOLDER4'),
       ('BUY', 'USD', 100, '2019-01-01', 'SETTLED', '2019-01-01', 100.00, 0.05, 'USD', 'US9128285C83', 100,
        'US9128285C83', 'US TREASURY NOTE', '2020-01-01', 'ACTIVE', 'TREASURY', 'Trading_book_5', 'HOLDER5'),
       ('BUY', 'USD', 100, '2019-01-01', 'SETTLED', '2019-01-01', 100.00, 0.05, 'USD', 'US9128285C83', 100,
        'GB00B6460507', 'US TREASURY NOTE', '2020-01-01', 'ACTIVE', 'TREASURY', 'Trading_book_6', 'HOLDER6');

INSERT INTO users (firebase_user_id)
VALUES ('gGnVWdj6GCUmwF26nhG2UuYzNel1'),
       ('sQh0i0365ngk49ZRQTpAEuR4btB3');

INSERT INTO trading_books (user_id, books)
VALUES (1, 'trading_book_2'),
       (1, 'Trading_book_3'),
       (2, 'trading_book_1'),
       (2, 'Trading_book_6'),
       (2, 'Trading_book_4');
