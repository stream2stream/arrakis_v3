INSERT INTO trades (isin, book_name, bond_holder, trade_status, unit_price, trade_currency,
trade_type, trade_date, trade_settlement_date, quantity
) VALUES('XS1988387210', 'trading_book_1', 'AZ Holdings Inc', 'open', 90, 'USD', 'buy', '2021-05-13', '2021-04-08', 50)


INSERT INTO bonds (isin	type, issuer_name, bond_maturity_date, face_value,
bond_currency, coupon_percent, status, cusip
) VALUES('XS1988387210', 'CORP', 'BNPParibasIssu 4,37% Microsoft Corp (USD)',
'2021-05-08', 1000, 'USD', 4.37, 'active', NULL)
