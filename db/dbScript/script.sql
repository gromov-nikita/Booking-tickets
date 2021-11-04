-- MySQL Script generated by MySQL Workbench
-- Tue Nov  2 19:24:57 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema booking_tickets
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema booking_tickets
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `booking_tickets` DEFAULT CHARACTER SET utf8 ;
USE `booking_tickets` ;

-- -----------------------------------------------------
-- Table `booking_tickets`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tickets`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `passportID` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `passportID_UNIQUE` (`passportID` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking_tickets`.`Transport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tickets`.`Transport` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(45) NOT NULL,
  `amountOfSeats` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `registrationNumber_UNIQUE` (`number` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking_tickets`.`Trip`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tickets`.`Trip` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP NOT NULL,
  `transportID` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `FK_Transport-Trip_idx` (`transportID` ASC) VISIBLE,
  CONSTRAINT `FK_Transport-Trip`
    FOREIGN KEY (`transportID`)
    REFERENCES `booking_tickets`.`Transport` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking_tickets`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tickets`.`Order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userID` INT NOT NULL,
  `tripID` INT NOT NULL,
  `seat` INT NOT NULL,
  `price` DOUBLE NOT NULL,
  `status` ENUM('CANCELED', 'ACTIVELY', 'DELETED') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `FK_User-Order_idx` (`userID` ASC) VISIBLE,
  INDEX `FK_Trip-Order_idx` (`tripID` ASC) VISIBLE,
  CONSTRAINT `FK_User-Order`
    FOREIGN KEY (`userID`)
    REFERENCES `booking_tickets`.`User` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_Trip-Order`
    FOREIGN KEY (`tripID`)
    REFERENCES `booking_tickets`.`Trip` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking_tickets`.`Country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tickets`.`Country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking_tickets`.`City`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tickets`.`City` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `countryID` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `FK_Country-City_idx` (`countryID` ASC) VISIBLE,
  CONSTRAINT `FK_Country-City`
    FOREIGN KEY (`countryID`)
    REFERENCES `booking_tickets`.`Country` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking_tickets`.`Point`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tickets`.`Point` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tripID` INT NOT NULL,
  `cityFromID` INT NOT NULL,
  `cityToID` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `FK_Trip-Point_idx` (`tripID` ASC) VISIBLE,
  INDEX `FK_City-Point_idx` (`cityFromID` ASC) VISIBLE,
  INDEX `FK_CityTo-Point_idx` (`cityToID` ASC) VISIBLE,
  CONSTRAINT `FK_Trip-Point`
    FOREIGN KEY (`tripID`)
    REFERENCES `booking_tickets`.`Trip` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_CityFrom-Point`
    FOREIGN KEY (`cityFromID`)
    REFERENCES `booking_tickets`.`City` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_CityTo-Point`
    FOREIGN KEY (`cityToID`)
    REFERENCES `booking_tickets`.`City` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking_tickets`.`Comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tickets`.`Comment` (
  `id` INT NOT NULL,
  `orderID` INT NOT NULL,
  `text` LONGTEXT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `FK_Order-Comment_idx` (`orderID` ASC) VISIBLE,
  CONSTRAINT `FK_Order-Comment`
    FOREIGN KEY (`orderID`)
    REFERENCES `booking_tickets`.`Order` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
