SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `TransporteBD` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `TransporteBD` ;

-- -----------------------------------------------------
-- Table `TransporteBD`.`Tipo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Tipo` (
  `idTipo` INT NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idTipo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Marca`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Marca` (
  `idMarca` INT NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idMarca`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Modelo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Modelo` (
  `idModelo` INT NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idModelo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Movil`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Movil` (
  `tuc` INT NOT NULL ,
  `num_chasis` INT NOT NULL ,
  `num_motor` INT NOT NULL ,
  `num_patente` INT NOT NULL ,
  `observacion` TEXT NULL ,
  `anio` DATE NOT NULL ,
  `Tipo_idTipo` INT NOT NULL ,
  `Marca_idMarca` INT NOT NULL ,
  `Modelo_idModelo` INT NOT NULL ,
  PRIMARY KEY (`tuc`) ,
  INDEX `fk_Movil_Tipo_idx` (`Tipo_idTipo` ASC) ,
  INDEX `fk_Movil_Marca1_idx` (`Marca_idMarca` ASC) ,
  INDEX `fk_Movil_Modelo1_idx` (`Modelo_idModelo` ASC) ,
  CONSTRAINT `fk_Movil_Tipo`
    FOREIGN KEY (`Tipo_idTipo` )
    REFERENCES `TransporteBD`.`Tipo` (`idTipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movil_Marca1`
    FOREIGN KEY (`Marca_idMarca` )
    REFERENCES `TransporteBD`.`Marca` (`idMarca` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movil_Modelo1`
    FOREIGN KEY (`Modelo_idModelo` )
    REFERENCES `TransporteBD`.`Modelo` (`idModelo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Ruta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Ruta` (
  `idRuta` INT NOT NULL ,
  `num_ruta` INT NULL ,
  `kilometro` INT NULL ,
  `cruce_con_ruta` VARCHAR(45) NULL ,
  `cruce_senial` TINYINT(1) NULL ,
  `tipo` VARCHAR(45) NULL ,
  PRIMARY KEY (`idRuta`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Cruce_tren`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Cruce_tren` (
  `idCruce_tren` INT NOT NULL ,
  `cruce_tren` TINYINT(1) NULL ,
  `barrera` TINYINT(1) NULL ,
  `cruce_senial` TINYINT(1) NULL ,
  `estado_barrera` VARCHAR(45) NULL ,
  PRIMARY KEY (`idCruce_tren`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Semaforo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Semaforo` (
  `idSemaforo` INT NOT NULL ,
  `semaforo` TINYINT(1) NULL ,
  `funciona` TINYINT(1) NULL ,
  `intermitente` TINYINT(1) NULL ,
  `color` VARCHAR(45) NULL ,
  PRIMARY KEY (`idSemaforo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Calzada`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Calzada` (
  `idCalzada` INT NOT NULL ,
  `tipo` TEXT NULL ,
  `estado` TEXT NULL ,
  PRIMARY KEY (`idCalzada`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Localidad`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Localidad` (
  `idLocalidad` INT NOT NULL ,
  `nombre` VARCHAR(45) NULL ,
  PRIMARY KEY (`idLocalidad`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Region`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Region` (
  `idRegion` INT NOT NULL ,
  `pais` VARCHAR(45) NULL ,
  `provincia` VARCHAR(45) NULL ,
  `codigo_postal` INT NULL ,
  `Localidad_idLocalidad` INT NOT NULL ,
  PRIMARY KEY (`idRegion`) ,
  INDEX `fk_Region_Localidad1_idx` (`Localidad_idLocalidad` ASC) ,
  CONSTRAINT `fk_Region_Localidad1`
    FOREIGN KEY (`Localidad_idLocalidad` )
    REFERENCES `TransporteBD`.`Localidad` (`idLocalidad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Lugar_Sinisestro`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Lugar_Sinisestro` (
  `idLugar_Sinisestro` INT NOT NULL ,
  `interseccion` VARCHAR(200) NULL ,
  `calle` VARCHAR(200) NULL ,
  `Ruta_idRuta` INT NULL ,
  `Cruce_tren_idCruce_tren` INT NULL ,
  `Semaforo_idSemaforo` INT NULL ,
  `Calzada_idCalzada` INT NULL ,
  `Region_idRegion` INT NOT NULL ,
  PRIMARY KEY (`idLugar_Sinisestro`) ,
  INDEX `fk_Lugar_Sinisestro_Ruta1_idx` (`Ruta_idRuta` ASC) ,
  INDEX `fk_Lugar_Sinisestro_Cruce_tren1_idx` (`Cruce_tren_idCruce_tren` ASC) ,
  INDEX `fk_Lugar_Sinisestro_Semaforo1_idx` (`Semaforo_idSemaforo` ASC) ,
  INDEX `fk_Lugar_Sinisestro_Calzada1_idx` (`Calzada_idCalzada` ASC) ,
  INDEX `fk_Lugar_Sinisestro_Region1_idx` (`Region_idRegion` ASC) ,
  CONSTRAINT `fk_Lugar_Sinisestro_Ruta1`
    FOREIGN KEY (`Ruta_idRuta` )
    REFERENCES `TransporteBD`.`Ruta` (`idRuta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Lugar_Sinisestro_Cruce_tren1`
    FOREIGN KEY (`Cruce_tren_idCruce_tren` )
    REFERENCES `TransporteBD`.`Cruce_tren` (`idCruce_tren` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Lugar_Sinisestro_Semaforo1`
    FOREIGN KEY (`Semaforo_idSemaforo` )
    REFERENCES `TransporteBD`.`Semaforo` (`idSemaforo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Lugar_Sinisestro_Calzada1`
    FOREIGN KEY (`Calzada_idCalzada` )
    REFERENCES `TransporteBD`.`Calzada` (`idCalzada` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Lugar_Sinisestro_Region1`
    FOREIGN KEY (`Region_idRegion` )
    REFERENCES `TransporteBD`.`Region` (`idRegion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Carnet`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Carnet` (
  `idCarnet` INT NOT NULL ,
  `fecha_venc` DATE NULL ,
  PRIMARY KEY (`idCarnet`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Datos_Conductor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Datos_Conductor` (
  `idDatos_Conductor` INT NOT NULL ,
  `apenom` VARCHAR(45) NOT NULL ,
  `edad` INT NOT NULL ,
  `genero` VARCHAR(45) NOT NULL ,
  `dni` INT NOT NULL ,
  `domicilio` VARCHAR(45) NOT NULL ,
  `estado_civil` VARCHAR(45) NOT NULL ,
  `examen_alcohol` VARCHAR(45) NULL ,
  `conductor_hab` TINYINT(1) NULL ,
  `propio_asegurado` TINYINT(1) NULL ,
  `rel_asegurado` VARCHAR(45) NULL ,
  `fecha_nac` DATE NOT NULL ,
  `Carnet_idCarnet` INT NOT NULL ,
  `Region_idRegion` INT NOT NULL ,
  PRIMARY KEY (`idDatos_Conductor`) ,
  INDEX `fk_Datos_Conductor_Carnet1_idx` (`Carnet_idCarnet` ASC) ,
  INDEX `fk_Datos_Conductor_Region1_idx` (`Region_idRegion` ASC) ,
  CONSTRAINT `fk_Datos_Conductor_Carnet1`
    FOREIGN KEY (`Carnet_idCarnet` )
    REFERENCES `TransporteBD`.`Carnet` (`idCarnet` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Datos_Conductor_Region1`
    FOREIGN KEY (`Region_idRegion` )
    REFERENCES `TransporteBD`.`Region` (`idRegion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Datos_Asegurado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Datos_Asegurado` (
  `idAsegurado` INT NOT NULL ,
  `apenom` VARCHAR(45) NULL ,
  `dni` INT NULL ,
  `domicilio` VARCHAR(45) NULL ,
  `telefono` VARCHAR(45) NULL ,
  `Region_idRegion` INT NOT NULL ,
  PRIMARY KEY (`idAsegurado`) ,
  INDEX `fk_Datos_Asegurado_Region1_idx` (`Region_idRegion` ASC) ,
  CONSTRAINT `fk_Datos_Asegurado_Region1`
    FOREIGN KEY (`Region_idRegion` )
    REFERENCES `TransporteBD`.`Region` (`idRegion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Conductor_Otro`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Conductor_Otro` (
  `idConductor_Otro` INT NOT NULL ,
  `apenom` VARCHAR(45) NULL ,
  `dni` INT NULL ,
  `domicilio` VARCHAR(45) NULL ,
  `telefono` INT NULL ,
  `genero` VARCHAR(45) NULL ,
  `estado_civil` VARCHAR(45) NULL ,
  `fecha_nac` DATE NULL ,
  `conductor_hab` TINYINT(1) NULL ,
  `Region_idRegion` INT NULL ,
  `Carnet_idCarnet` INT NULL ,
  PRIMARY KEY (`idConductor_Otro`) ,
  INDEX `fk_Conductor_Otro_Region1_idx` (`Region_idRegion` ASC) ,
  INDEX `fk_Conductor_Otro_Carnet1_idx` (`Carnet_idCarnet` ASC) ,
  CONSTRAINT `fk_Conductor_Otro_Region1`
    FOREIGN KEY (`Region_idRegion` )
    REFERENCES `TransporteBD`.`Region` (`idRegion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Conductor_Otro_Carnet1`
    FOREIGN KEY (`Carnet_idCarnet` )
    REFERENCES `TransporteBD`.`Carnet` (`idCarnet` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Denunciante`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Denunciante` (
  `idDenunciante` INT NOT NULL ,
  `apenom` VARCHAR(45) NULL ,
  `dni` INT NULL ,
  `genero` VARCHAR(45) NULL ,
  `domicilio` VARCHAR(45) NULL ,
  `detalle` VARCHAR(45) NULL ,
  `Region_idRegion` INT NOT NULL ,
  PRIMARY KEY (`idDenunciante`) ,
  INDEX `fk_Denunciante_Region1_idx` (`Region_idRegion` ASC) ,
  CONSTRAINT `fk_Denunciante_Region1`
    FOREIGN KEY (`Region_idRegion` )
    REFERENCES `TransporteBD`.`Region` (`idRegion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Otro_Vehiculo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Otro_Vehiculo` (
  `idOtro_Vehiculo` INT NOT NULL ,
  `apenom` VARCHAR(45) NULL ,
  `edad` INT NULL ,
  `dni` VARCHAR(45) NULL ,
  `marca` VARCHAR(45) NULL ,
  `modelo` VARCHAR(45) NULL ,
  `tipo` VARCHAR(45) NULL ,
  `dominio` VARCHAR(45) NULL ,
  `anio` DATE NULL ,
  `num_motor` INT NULL ,
  `num_chasis` VARCHAR(45) NULL ,
  `Region_idRegion` INT NOT NULL ,
  `detelles` VARCHAR(45) NULL ,
  `uso_vehiculo` TINYINT(1) NULL ,
  `tipo_uso` INT NULL ,
  `alcoholemia` INT NULL ,
  `propietario` TINYINT(1) NULL ,
  `Conductor_Otro_idConductor_Otro` INT NULL ,
  PRIMARY KEY (`idOtro_Vehiculo`) ,
  INDEX `fk_Otro_Vehiculo_Region1_idx` (`Region_idRegion` ASC) ,
  INDEX `fk_Otro_Vehiculo_Conductor_Otro1_idx` (`Conductor_Otro_idConductor_Otro` ASC) ,
  CONSTRAINT `fk_Otro_Vehiculo_Region1`
    FOREIGN KEY (`Region_idRegion` )
    REFERENCES `TransporteBD`.`Region` (`idRegion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Otro_Vehiculo_Conductor_Otro1`
    FOREIGN KEY (`Conductor_Otro_idConductor_Otro` )
    REFERENCES `TransporteBD`.`Conductor_Otro` (`idConductor_Otro` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Siniestro_Tiempo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Siniestro_Tiempo` (
  `idSinistro` INT NOT NULL ,
  `fecha_siniestro` DATE NOT NULL ,
  `turno` VARCHAR(45) NULL ,
  `tiempo` VARCHAR(45) NULL ,
  `hora` TIME NULL ,
  PRIMARY KEY (`idSinistro`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TransporteBD`.`Formulario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `TransporteBD`.`Formulario` (
  `idFormulario` INT NOT NULL ,
  `aseguradora` VARCHAR(45) NULL ,
  `num_poliza` INT NULL ,
  `num_siniestro` INT NULL ,
  `fecha` DATE NULL ,
  `aclaracion` VARCHAR(45) NULL ,
  `firma` VARCHAR(45) NULL ,
  `Lugar_Sinisestro_idLugar_Sinisestro` INT NOT NULL ,
  `Datos_Conductor_idDatos_Conductor` INT NOT NULL ,
  `Datos_Asegurado_idAsegurado` INT NOT NULL ,
  `Movil_tuc` INT NOT NULL ,
  `Otro_Vehiculo_idOtro_Vehiculo` INT NOT NULL ,
  `Denunciante_idDenunciante` INT NOT NULL ,
  `detalles` TEXT NULL ,
  `Siniestro_Tiempo_idSinistro` INT NOT NULL ,
  PRIMARY KEY (`idFormulario`) ,
  INDEX `fk_Formulario_Lugar_Sinisestro1_idx` (`Lugar_Sinisestro_idLugar_Sinisestro` ASC) ,
  INDEX `fk_Formulario_Datos_Conductor1_idx` (`Datos_Conductor_idDatos_Conductor` ASC) ,
  INDEX `fk_Formulario_Datos_Asegurado1_idx` (`Datos_Asegurado_idAsegurado` ASC) ,
  INDEX `fk_Formulario_Movil1_idx` (`Movil_tuc` ASC) ,
  INDEX `fk_Formulario_Otro_Vehiculo1_idx` (`Otro_Vehiculo_idOtro_Vehiculo` ASC) ,
  INDEX `fk_Formulario_Denunciante1_idx` (`Denunciante_idDenunciante` ASC) ,
  INDEX `fk_Formulario_Siniestro_Tiempo1_idx` (`Siniestro_Tiempo_idSinistro` ASC) ,
  CONSTRAINT `fk_Formulario_Lugar_Sinisestro1`
    FOREIGN KEY (`Lugar_Sinisestro_idLugar_Sinisestro` )
    REFERENCES `TransporteBD`.`Lugar_Sinisestro` (`idLugar_Sinisestro` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Formulario_Datos_Conductor1`
    FOREIGN KEY (`Datos_Conductor_idDatos_Conductor` )
    REFERENCES `TransporteBD`.`Datos_Conductor` (`idDatos_Conductor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Formulario_Datos_Asegurado1`
    FOREIGN KEY (`Datos_Asegurado_idAsegurado` )
    REFERENCES `TransporteBD`.`Datos_Asegurado` (`idAsegurado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Formulario_Movil1`
    FOREIGN KEY (`Movil_tuc` )
    REFERENCES `TransporteBD`.`Movil` (`tuc` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Formulario_Otro_Vehiculo1`
    FOREIGN KEY (`Otro_Vehiculo_idOtro_Vehiculo` )
    REFERENCES `TransporteBD`.`Otro_Vehiculo` (`idOtro_Vehiculo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Formulario_Denunciante1`
    FOREIGN KEY (`Denunciante_idDenunciante` )
    REFERENCES `TransporteBD`.`Denunciante` (`idDenunciante` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Formulario_Siniestro_Tiempo1`
    FOREIGN KEY (`Siniestro_Tiempo_idSinistro` )
    REFERENCES `TransporteBD`.`Siniestro_Tiempo` (`idSinistro` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
