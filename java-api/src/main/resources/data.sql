INSERT INTO bonds
    (coupon_percent, bond_currency, cusip, face_value, isin, issuer_name, bond_maturity, status, type)
VALUES
    (2, 'USD', '123456bh0', 900, 'A12356111', 'UBS Facebook (USD)', '30/09/2021', 'active', 'CORP'),
    (0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460505', 'HM Treasury United Kingdon', '9/8/21', 'active', 'GOVN'),
    (1.123, 'USD', '87973RAA8', 340, 'IE00B29LNP31', 'First Norway Alpha Kl.IV', '22/12/2030', 'active', 'SOVN'),
    (2.02, 'USD', '87973RAA8', 690, 'US87973RAA86', 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S', '6/8/21', 'active', 'SOVN'),
    (3.15, 'USD', '123456780', 900, 'USN0280EAR64', 'Airbus 3.15%  USD', '30/07/2021', 'active', 'CORP'),
    (3.15, 'USD', 'AMZN 3.15 08/22/27 REGS', 900, 'USU02320AG12', 'Amazon', '3/8/21', 'active', 'CORP');
-- INSERT INTO dogs (dog_id, name, age) VALUES (1, 'Einstein', 3);
-- INSERT INTO dogs (dog_id, name, age) VALUES (2, 'Kaya', 5);
-- INSERT INTO dogs (dog_id, name, age) VALUES (3, 'Lassie', 7);