INSERT INTO dogs (dog_id, name, age) VALUES (1, 'Einstein', 3);
INSERT INTO dogs (dog_id, name, age) VALUES (2, 'Kaya', 5);
INSERT INTO dogs (dog_id, name, age) VALUES (3, 'Lassie', 7);

BULK INSERT Bonds
FROM 'C:/Users/Admin/Downloads/db-bonds-data.csv'
WITH (
    FIELDTERMINATOR = ',',
    ROWTERMINATOR = '\n',
    FIRSTROW = 2
);