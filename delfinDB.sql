DROP SCHEMA IF exists delfinDB;
Create schema delfinDB;
Use delfinDB;


#Eventuelt tilføj skyldigt beløb
DROP TABLE IF EXISTS Medlem;
Create Table Medlem (
	medlemID int not null AUTO_INCREMENT,
    rolleID int,
	navn varchar(45),
	efternavn varchar(45),
	adresse varchar(45),
	email varchar(45),
	alder int NOT NULL,
	telefonnummer int NOT NULL,
	betalingsDato datetime,
	aktivtMedlem boolean NOT NULL,
    foreign key(rolleID) REFERENCES Rolle(rolleID),
PRIMARY KEY (MedlemID)
);

DROP TABLE IF EXISTS Disipliner;
CREATE TABLE Discipliner (
disciplinID int NOT NULL AUTO_INCREMENT,
disciplin varchar(45),
PRIMARY KEY (DisciplinID)
);

DROP TABLE IF EXISTS MedlemDiscipliner;
CREATE TABLE MedlemDiscipliner (
	medlemID int NOT NULL,
	disciplinID int NOT NULL,
	PRIMARY KEY(medlemID, DisciplinID),	
	foreign key (medlemID) references Medlem(MedlemID),
	foreign key (disciplinID) references Discipliner(DisciplinerID)
);

DROP TABLE IF EXISTS Rolle; 
CREATE TABLE Rolle (
	rolleID int NOT NULL AUTO_INCREMENT,
    rolle varchar(40),
    PRIMARY KEY(rolleID)
);

#Repræsentering af tid skal måske ændres
DROP TABLE IF EXISTS Resultater;
CREATE TABLE Resultater(
	resultatID int NOT NULL AUTO_INCREMENT,
    disciplinID int,
    medlemID int,
    tid varchar(30),
    dato datetime,
    stævne varchar(30),
    konkurrenceResultat boolean,
    PRIMARY KEY(disciplinID, medlemID, resultatID),
    foreign key (disciplinID) REFERENCES Disciplin(DisciplinID),
	foreign key (medlemID) REFERENCES Medlem(MedlemID)
);
