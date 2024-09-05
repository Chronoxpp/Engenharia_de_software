-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema primeiroprograma
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `primeiroprograma` ;

-- -----------------------------------------------------
-- Schema primeiroprograma
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `primeiroprograma` DEFAULT CHARACTER SET utf8 ;
USE `primeiroprograma` ;

-- -----------------------------------------------------
-- Table `primeiroprograma`.`perfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primeiroprograma`.`perfil` ;

CREATE TABLE IF NOT EXISTS `primeiroprograma`.`perfil` (
  `idperfil` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(20) NOT NULL UNIQUE,
  `descricao` VARCHAR(100) NOT NULL UNIQUE,
  PRIMARY KEY (`idperfil`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `primeiroprograma`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `primeiroprograma`.`usuario` ;

CREATE TABLE IF NOT EXISTS `primeiroprograma`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(200) NOT NULL,
  `login` VARCHAR(50) NOT NULL UNIQUE,
  `senha` VARCHAR(255) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `idperfil` INT NOT NULL,
  PRIMARY KEY (`idusuario`),
  CONSTRAINT `fk_usuario_perfil`
    FOREIGN KEY (`idperfil`)
    REFERENCES `primeiroprograma`.`perfil` (`idperfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
