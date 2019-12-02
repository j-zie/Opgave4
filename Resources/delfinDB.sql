DROP SCHEMA IF exists delfinDB;
Create schema delfinDB;
Use delfinDB;
	

#Eventuelt tilføj skyldigt beløb
DROP TABLE IF EXISTS Medlem;
CREATE TABLE Medlem (
	medlemID int NOT NULL AUTO_INCREMENT,
    rolleID int,
	navn varchar(45),
	efternavn varchar(45),
	adresse varchar(45),
	email varchar(45),
	alder int NOT NULL,
	telefonnummer varchar(45) NOT NULL,
	betalingsDato datetime,
	aktivtMedlem boolean NOT NULL,
PRIMARY KEY (medlemID)
);

DROP TABLE IF EXISTS Resultater;
CREATE TABLE Resultater (
    medlemID INT NOT NULL,
    staevneNavn varchar(50),
    disciplin varchar(50),
    dato date,
    tid time,
    FOREIGN KEY (medlemID) REFERENCES Medlem(medlemID)
);
    

INSERT INTO Medlem (navn, efternavn, adresse, email, alder, telefonnummer,
betalingsDato, aktivtMedlem)
VALUES ("Jon", "Jones", "Florida, en vej 20", "kontaktjon@gmail.com", 20, "112", '2012-06-18 10:34:09',true);
INSERT INTO Medlem (navn, efternavn, adresse, email, alder, telefonnummer,
betalingsDato, aktivtMedlem)
VALUES ("Maria", "Tusindeben", "jomfruøerne, en anden vej 19", "kontaktmaria@gmail.com", 40, "112", '2012-06-18 10:34:09',true);
INSERT INTO Resultater(medlemID, staevneNavn, disciplin, dato, tid)
VALUES (1, "Verdensmesterskaberne", "Butterfly", '2019-07-18', "00:05:20")