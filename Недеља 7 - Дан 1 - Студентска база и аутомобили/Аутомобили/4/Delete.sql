DELETE FROM Nabavka
WHERE IdA in (SELECT id FROM Automobil where IdM = 2) 

DELETE FROM Automobil
WHERE id in (SELECT id FROM Automobil where IdM = 2)

DELETE FROM Model
WHERE id in (SELECT id FROM Model where id = 2)

DELETE from Nabavka
WHERE IdA not in (SELECT IdA from Kupovina)

DELETE from Automobil
WHERE id not in (SELECT IdA from Kupovina)