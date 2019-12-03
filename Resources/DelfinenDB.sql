-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DelfinenDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `DelfinenDB` ;

-- -----------------------------------------------------
-- Schema DelfinenDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DelfinenDB` DEFAULT CHARACTER SET utf8 ;
USE `DelfinenDB` ;

-- -----------------------------------------------------
-- Table `DelfinenDB`.`Rolle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DelfinenDB`.`Rolle` ;

CREATE TABLE IF NOT EXISTS `DelfinenDB`.`Rolle` (
  `rolleID` INT NOT NULL AUTO_INCREMENT,
  `rolleName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`rolleID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DelfinenDB`.`ActivityForm`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DelfinenDB`.`ActivityForm` ;

CREATE TABLE IF NOT EXISTS `DelfinenDB`.`ActivityForm` (
  `activityFormID` INT NOT NULL AUTO_INCREMENT,
  `activityForm` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`activityFormID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DelfinenDB`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DelfinenDB`.`User` ;

CREATE TABLE IF NOT EXISTS `DelfinenDB`.`User` (
  `userID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `adresse` VARCHAR(45) NOT NULL,
  `zip` INT NOT NULL,
  `town` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` INT NOT NULL,
  `age` INT NOT NULL,
  `startDate` DATETIME NOT NULL,
  `payDate` DATETIME NOT NULL,
  `subscription` DECIMAL(10,2) NOT NULL,
  `active` INT NOT NULL,
  `activityFormID` INT NOT NULL,
  `rolleID` INT NOT NULL,
  PRIMARY KEY (`userID`, `activityFormID`, `rolleID`),
  INDEX `rolleID_idx` (`rolleID` ASC) VISIBLE,
  INDEX `activityFormID_idx` (`activityFormID` ASC) VISIBLE,
  CONSTRAINT `rolleID`
    FOREIGN KEY (`rolleID`)
    REFERENCES `DelfinenDB`.`Rolle` (`rolleID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `activityFormID`
    FOREIGN KEY (`activityFormID`)
    REFERENCES `DelfinenDB`.`ActivityForm` (`activityFormID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DelfinenDB`.`Subscription`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DelfinenDB`.`Subscription` ;

CREATE TABLE IF NOT EXISTS `DelfinenDB`.`Subscription` (
  `subscriptionID` INT NOT NULL AUTO_INCREMENT,
  `subscriptionName` VARCHAR(45) NOT NULL,
  `subscriptionPrice` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`subscriptionID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DelfinenDB`.`Disciplines`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DelfinenDB`.`Disciplines` ;

CREATE TABLE IF NOT EXISTS `DelfinenDB`.`Disciplines` (
  `disciplinesID` INT NOT NULL AUTO_INCREMENT,
  `discipline` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`disciplinesID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DelfinenDB`.`UserDisciplines`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DelfinenDB`.`UserDisciplines` ;

CREATE TABLE IF NOT EXISTS `DelfinenDB`.`UserDisciplines` (
  `userID` INT NOT NULL,
  `disciplinesID` INT NOT NULL,
  PRIMARY KEY (`userID`, `disciplinesID`),
  INDEX `disciplinesID_idx` (`disciplinesID` ASC) VISIBLE,
  CONSTRAINT `userID`
    FOREIGN KEY (`userID`)
    REFERENCES `DelfinenDB`.`User` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `disciplinesID`
    FOREIGN KEY (`disciplinesID`)
    REFERENCES `DelfinenDB`.`Disciplines` (`disciplinesID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DelfinenDB`.`Results`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DelfinenDB`.`Results` ;

CREATE TABLE IF NOT EXISTS `DelfinenDB`.`Results` (
  `resultsID` INT NOT NULL AUTO_INCREMENT,
  `disciplinesID` INT NOT NULL,
  `userID` INT NOT NULL,
  `time` VARCHAR(45) NOT NULL,
  `date` DATETIME NOT NULL,
  `event` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`resultsID`, `userID`, `disciplinesID`),
  INDEX `disciplinID_idx` (`disciplinesID` ASC) VISIBLE,
  INDEX `medlemID_idx` (`userID` ASC) VISIBLE,
  CONSTRAINT `disciplinID`
    FOREIGN KEY (`disciplinesID`)
    REFERENCES `DelfinenDB`.`Disciplines` (`disciplinesID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `medlemID`
    FOREIGN KEY (`userID`)
    REFERENCES `DelfinenDB`.`User` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
