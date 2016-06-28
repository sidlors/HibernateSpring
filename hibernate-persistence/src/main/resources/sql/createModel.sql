-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema systembank
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema systembank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `systembank` DEFAULT CHARACTER SET utf8 ;
USE `systembank` ;

-- -----------------------------------------------------
-- Table `systembank`.`banco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `systembank`.`banco` (
  `idBanco` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idBanco`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `systembank`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `systembank`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `apaterno` VARCHAR(30) NOT NULL,
  `amaterno` VARCHAR(50) NOT NULL,
  `edad` INT(11) NOT NULL,
  `idBanco` INT(11) NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `RefBanco2` (`idBanco` ASC),
  CONSTRAINT `RefBanco2`
    FOREIGN KEY (`idBanco`)
    REFERENCES `systembank`.`banco` (`idBanco`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `systembank`.`tipocuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `systembank`.`tipocuenta` (
  `idTipoCuenta` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idTipoCuenta`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `systembank`.`cuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `systembank`.`cuenta` (
  `idCuenta` INT(11) NOT NULL AUTO_INCREMENT,
  `numeroCuenta` INT(11) NOT NULL,
  `idTipoCuenta` INT(11) NOT NULL,
  `idCliente` INT(11) NOT NULL,
  PRIMARY KEY (`idCuenta`),
  INDEX `RefTipoCuenta3` (`idTipoCuenta` ASC),
  INDEX `RefCliente4` (`idCliente` ASC),
  CONSTRAINT `RefCliente4`
    FOREIGN KEY (`idCliente`)
    REFERENCES `systembank`.`cliente` (`idCliente`),
  CONSTRAINT `RefTipoCuenta3`
    FOREIGN KEY (`idTipoCuenta`)
    REFERENCES `systembank`.`tipocuenta` (`idTipoCuenta`))
ENGINE = InnoDB
AUTO_INCREMENT =1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `systembank`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `systembank`.`perfil` (
  `idPerfil` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idPerfil`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `systembank`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `systembank`.`login` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `apaterno` VARCHAR(30) NULL DEFAULT NULL,
  `amaterno` VARCHAR(30) NULL DEFAULT NULL,
  `usuario` VARCHAR(10) NOT NULL,
  `password` VARCHAR(10) NOT NULL,
  `idPerfil` INT(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `RefPerfil12` (`idPerfil` ASC),
  CONSTRAINT `RefPerfil12`
    FOREIGN KEY (`idPerfil`)
    REFERENCES `systembank`.`perfil` (`idPerfil`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `systembank`.`tipomovimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `systembank`.`tipomovimiento` (
  `idTipoMovimiento` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idTipoMovimiento`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `systembank`.`movimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `systembank`.`movimiento` (
  `idMovimiento` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `monto` DECIMAL(9,2) NOT NULL,
  `idCuenta` INT(11) NOT NULL,
  `idTipoMovimiento` INT(11) NOT NULL,
  PRIMARY KEY (`idMovimiento`),
  INDEX `RefCuenta7` (`idCuenta` ASC),
  INDEX `RefTipoMovimiento9` (`idTipoMovimiento` ASC),
  CONSTRAINT `RefCuenta7`
    FOREIGN KEY (`idCuenta`)
    REFERENCES `systembank`.`cuenta` (`idCuenta`),
  CONSTRAINT `RefTipoMovimiento9`
    FOREIGN KEY (`idTipoMovimiento`)
    REFERENCES `systembank`.`tipomovimiento` (`idTipoMovimiento`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;