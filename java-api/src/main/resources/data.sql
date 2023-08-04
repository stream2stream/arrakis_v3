INSERT INTO BOOK (book_name)
SELECT DISTINCT book_name FROM TEST;

INSERT INTO USERS (issuer_name)
SELECT DISTINCT issuer_name FROM TEST;

INSERT INTO COUNTERPARTY (bond_holder)
SELECT DISTINCT bond_holder FROM TEST;

INSERT INTO BOOKUSER (user_id, book_id)
SELECT DISTINCT U.USER_ID, B.BOOK_ID FROM USERS U, BOOK B;

INSERT INTO SECURITY (ISIN, CUSIP, TYPE, ISSUER_NAME, MATURITY_DATE, FACEVALUE, BONDCURRENCY, COUPON, STATUS)
SELECT ISIN, CUSIP, TYPE, ISSUER_NAME, BOND_MATURITY_DATE, "face_value (mn)", BOND_CURRENCY, COUPON_PERCENT, STATUS FROM TEST;


-- INSERT INTO TRADE (security_id, book_id, bond_holder_id, trade_date, trade_settlement_date, trade_type, trade_currency, trade_status, unit_price, quantity)
-- SELECT S.security_id, B.book_id, C.bond_holder_id, T.trade_date, T.trade_settlement_date, T.trade_type, T.trade_currency, T.trade_status, T.unit_price, T.quantity
-- FROM TEST T
-- LEFT JOIN BOOK B ON T.BOOK_NAME = B.BOOK_NAME
-- LEFT JOIN SECURITY S ON T.STATUS = S.STATUS
-- LEFT JOIN COUNTERPARTY C ON T.BOND_HOLDER = C.BOND_HOLDER;

INSERT INTO TRADE (book_id, bond_holder_id, trade_date, trade_settlement_date, trade_type, trade_currency, trade_status, unit_price, quantity)
SELECT B.book_id, C.bond_holder_id, T.trade_date, T.trade_settlement_date, T.trade_type, T.trade_currency, T.trade_status, T.unit_price, T.quantity
FROM TEST T
LEFT OUTER JOIN BOOK B ON T.BOOK_NAME = B.BOOK_NAME
-- LEFT OUTER JOIN SECURITY S ON T.STATUS = S.STATUS
LEFT OUTER JOIN COUNTERPARTY C ON T.BOND_HOLDER = C.BOND_HOLDER;


