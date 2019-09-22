CREATE TABLE Automobil(
	id integer primary key AUTOINCREMENT UNIQUE,
	RegBr INTEGER UNIQUE,
	IdM INTEGER,
	FOREIGN KEY (IdM) REFERENCES Model(id)
)

CREATE TABLE Dobavljac(
	id INTEGER primary key UNIQUE,
	Naziv TEXT,
	BrDobavljenih INTEGER
)

CREATE TABLE Kupac(
	id integer primary key AUTOINCREMENT UNIQUE,
	Ime TEXT,
	Prezime TEXT,
	BrLK INTEGER,
	BrKupljenih INTEGER
)

CREATE TABLE Kupovina(
	IdA INTEGER primary key,
	IdK INTEGER,
	DatumVreme date,
	Cena INTEGER,
	FOREIGN KEY (IdA) REFERENCES Automobil(id),
	FOREIGN KEY (IdK) REFERENCES Kupac(id)
)

CREATE TABLE Model(
	id integer primary key AUTOINCREMENT UNIQUE,
	Marka TEXT,
	Model TEXT,
	BrProdatih INTEGER,
	BrNabavljenih integer,
	Profit INTEGER
)

CREATE TABLE Nabavka(
	IdA INTEGER primary key,
	DatumVreme date,
	IdD INTEGER,
	Cena INTEGER,
	FOREIGN KEY (IdA) REFERENCES Automobil(id)
	Foreign KEY (IdD) REFERENCES Dobavljac(id)
)
	