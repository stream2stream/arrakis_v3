DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS bonds;

CREATE TABLE dogs (
    dog_id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE bonds (
    id INT NOT NULL,
    bond_maturity_date VARCHAR(250) NOT NULL,
    isin VARCHAR(250) NOT NULL
);

CREATE VIEW IF NOT EXISTS all_bonds2 as
SELECT dog_id as id, name, age FROM dogs;

CREATE VIEW IF NOT EXISTS all_bonds as
SELECT  id, bond_maturity_date, isin from bonds;
