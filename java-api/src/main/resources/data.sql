INSERT INTO bonds
    (coupon_percent, bond_currency, cusip, face_value, isin, issuer_name, bond_maturity, status, type)
VALUES
    (2, 'USD', '123456bh0', 900, 'A12356111', 'UBS Facebook (USD)', ' 2023-08-30', 'active', 'CORP'),
    (0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460505', 'HM Treasury United Kingdon', '2021-09-08', 'active', 'GOVN'),
    (1.123, 'USD', '87973RAA8', 340, 'IE00B29LNP31', 'First Norway Alpha Kl.IV', '2030-12-22', 'active', 'SOVN'),
    (2.02, 'USD', '87973RAA8', 690, 'US87973RAA86', 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S', '2021-08-06', 'active', 'SOVN'),
    (3.15, 'USD', '123456780', 900, 'USN0280EAR64', 'Airbus 3.15%  USD', '2021-07-30', 'active', 'CORP'),
    (3.15, 'USD', 'AMZN 3.15 08/22/27 REGS', 900, 'USU02320AG12', 'Amazon', '2021-08-03', 'active', 'CORP');
-- INSERT INTO dogs (dog_id, name, age) VALUES (1, 'Einstein', 3);
-- INSERT INTO dogs (dog_id, name, age) VALUES (2, 'Kaya', 5);
-- INSERT INTO dogs (dog_id, name, age) VALUES (3, 'Lassie', 7);