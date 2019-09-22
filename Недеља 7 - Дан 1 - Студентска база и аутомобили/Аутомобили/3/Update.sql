UPDATE Kupovina
SET Cena = 25000
where IdK in (SELECT id from Kupac WHERE kupac.Ime = "Zoran")
AND IdA in (SELECT id from Automobil where IdM in (SELECT id from Model where model.Marka = "Audi" and model.Model = "A4"))

UPDATE Nabavka
SET Cena = 33000
where IdD in (SELECT id from Dobavljac WHERE dobavljac.id = 3)