INSERT INTO Model(Marka,Model,BrProdatih,BrNabavljenih,Profit)
VALUES  ("BMW", "X6", 10, 20, 10000),
	("BMW", "X7", 5, 12, 14000),
	("Audi", "A8", 4, 10, 20000),
	("Audi", "A4", 6, 15, 15000),
	("Lada", "Niva", 20, 50, 10000),
	("Yugo", "Coral 45", 50, 100, 12000)

INSERT INTO Kupac(Ime, Prezime, BrLK, BrKupljenih)
VALUES  ("Zoran", "Milicevic", 12345678, 2),
	("Cvijan", "Peranovic", 12345678, 1),
	("Ivana", "Stepanovic", 12345678, 1),
	("Dusan", "Bobicic", 12345678, 1)

INSERT INTO Dobavljac(Naziv, BrDobavljenih)
VALUES  ("YugoMotors", 30),
	("SerbiaCarImport", 20),
	("BelgradeImport", 10)

INSERT INTO Automobil(RegBr, IdM)
VALUES  (145, 1),
	(126, 1),
	(123, 2),		
	(125, 2),
	(111, 3),
	(128, 3),
	(175, 4),
	(179, 4),
	(012, 5),
	(1088, 5),
	(001, 6),
	(1488, 6)

INSERT INTO Nabavka(IdA, DatumVreme, IdD, Cena)
VALUES  (5, '2010-01-01', 3, 30000),
	(6, '2010-01-01', 3, 30000),
	(7, '2010-01-01', 3, 30000),
	(8, '2010-01-01', 3, 30000)

INSERT INTO Nabavka(IdA, DatumVreme, IdD, Cena)
VALUES  (9, '2000-02-01', 1, 2000),
	(10, '2000-02-01', 1, 2000),
	(11, '2000-02-01', 1, 2000),
	(12, '2000-02-01', 1, 2000)

INSERT INTO Nabavka(IdA, DatumVreme, IdD, Cena)
VALUES  (1, '2013-01-01', 2, 20000),
	(2, '2013-01-01', 2, 20000),
	(3, '2013-01-01', 2, 20000),
	(4, '2013-01-01', 2, 20000)