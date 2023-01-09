DROP DATABASE IF EXISTS heroSightings;
CREATE DATABASE heroSightings;

USE heroSightings;

CREATE TABLE Hero (
  heroId INT NOT NULL PRIMARY KEY auto_increment, 
  heroName VARCHAR(25) NOT NULL,
  heroDesc VARCHAR(140),
  superpower VARCHAR(25) NOT NULL
);

CREATE TABLE Location (
  locationName VARCHAR(25) NOT NULL,
  addressInfo VARCHAR(140),
  locationDesc VARCHAR(140),
  coordinates VARCHAR(25) NOT NULL PRIMARY KEY
);

CREATE TABLE Sighting (
sightingID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
coordinates VARCHAR(25) NOT NULL,
sightingDate DATE NOT NULL,
heroId INT NOT NULL,
FOREIGN KEY(heroId) REFERENCES Hero(heroId),
FOREIGN KEY(coordinates) REFERENCES Location(coordinates)
);

CREATE TABLE Villan (
villanId INT NOT NULL PRIMARY KEY auto_increment,
villanName VARCHAR(25) NOT NULL,
villanDesc VARCHAR(25),
superpower VARCHAR(25) NOT NULL,
heroId INT NOT NULL,
FOREIGN KEY(heroId) REFERENCES Hero(heroId)
);