INSERT INTO trades (isin, book_name, bond_holder_id, trade_status, unit_price, trade_currency,
trade_type, trade_date, trade_settlement_date, quantity
) VALUES('XS1988387210', 'trading_book_1', 1, 'open', 90, 'USD', 'buy', '2021-05-13', '2021-04-08', 50)


INSERT INTO bonds (isin, type, issuer_id, bond_maturity_date, face_value,
bond_currency, coupon_percent, status, cusip
) VALUES('XS1988387210', 'CORP', 1,
'2021-05-08', 1000, 'USD', 4.37, 'active', NULL)

INSERT INTO trades_counter_parties (id, bond_holder_name)
VALUES(1, 'AZ Holdings Inc')

INSERT INTO bonds_counter_parties (id, issuer_name)
VALUES(1, 'BNPParibasIssu 4,37% Microsoft Corp (USD)')
