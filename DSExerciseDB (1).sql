CREATE DATABASE IF NOT EXISTS `DSExercise`;
USE `DSExercise`;
DROP TABLE `municipalemployee`;
SELECT * FROM `authorities`;


CREATE TABLE `administrator` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`password`  varchar(45) DEFAULT NULL,
`email` varchar(45) UNIQUE DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `citizen` (
`AMKA` int(11) UNIQUE NOT NULL,
`fullName` varchar(45) DEFAULT NULL,
`municipalHouse` varchar(45) DEFAULT NULL,
`password` varchar(45)  DEFAULT NULL,
`email` varchar(45) UNIQUE DEFAULT NULL,
`address` varchar(45) DEFAULT NULL,
`age` varchar(45) DEFAULT NULL,
PRIMARY KEY (`AMKA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pet` (
`numberOfMicrochip` varchar(45) UNIQUE NOT NULL,
`race` varchar(45) DEFAULT NULL,
`gender` varchar(45) DEFAULT NULL,
`dateOfBirth` varchar(45) DEFAULT NULL,
`amkaOwner` int(11) DEFAULT NULL,
PRIMARY KEY (`numberOfMicrochip`),
KEY `FK_DETAIL_amkaOwner_citizen` (`amkaOwner`),
CONSTRAINT `FK_DETAIL_pet` FOREIGN KEY (`amkaOwner`) REFERENCES `citizen` (`AMKA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `vet` (
`AMKA` int(11) UNIQUE NOT NULL,
`fullName` varchar(45) DEFAULT NULL,
`municipalHouse` varchar(45) DEFAULT NULL,
`password` varchar(45)  DEFAULT NULL,
`email` varchar(45) UNIQUE DEFAULT NULL,
`age` int(11) DEFAULT NULL,
PRIMARY KEY (`AMKA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `municipalEmployee` (
`AMKA` int(11) UNIQUE NOT NULL,
`fullName` varchar(45) DEFAULT NULL,
`municipalHouse` varchar(45) DEFAULT NULL,
`password` varchar(45)  DEFAULT NULL,
`email` varchar(45) UNIQUE DEFAULT NULL,
PRIMARY KEY (`AMKA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
`AMKA` int(11) UNIQUE NOT NULL,
`fullName` varchar(45) DEFAULT NULL,
PRIMARY KEY (`AMKA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `administrator` VALUES
(1,'1234','david@hua.gr'),
(2,'12345','john@hua.gr'),
(3,'123456','ajay@hua.gr');

INSERT INTO `citizen` values
(0123456789,'Panagiotis','Patra','12345','panosmemail','kapou',13),
(1234567890,'Rafail','Kalamata','1234','rafailemail','kapou allou',14);

INSERT INTO `vet` values
(01,'Panagiotis','Patra','12345','panosmemail',13),
(12,'Rafail','Kalamata','1234','rafailemail',14);

INSERT INTO `municipalEmployee` values
(1,'Panagiotis','Patra','12345','panosmemail'),
(2,'Rafail','Kalamata','1234','rafailemail');

INSERT INTO `pet` values
('123','pitbull','arseniko','kapote','0123456789'),
('1234','rontvailer','thhlyko','pote','1234567890');

CREATE TABLE IF NOT EXISTS `user_security` (
 `email` varchar(50) UNIQUE NOT NULL,
 `password` varchar(100) NOT NULL,
 `enabled` tinyint(1) NOT NULL,
 PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `authorities` (
 `email` varchar(50) UNIQUE NOT NULL,
 `authority` varchar(50) NOT NULL,
 UNIQUE KEY `ix_auth_email` (`email`,`authority`),
 CONSTRAINT `fk_authorities_users` FOREIGN KEY (`email`) REFERENCES `user_security` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user_security` (`email`, `password`, `enabled`) VALUES
   ('argiris', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1),
   ('root', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1);

INSERT INTO `authorities` (`email`, `authority`) VALUES
   ('root', 'ROLE_ADMIN'),
   ('argiris', 'ROLE_USER');
   
CREATE TABLE `vet_pet` (
`vet_amka` int(11) NOT NULL,
`pet_microchip` varchar(45) NOT NULL,
PRIMARY KEY (`vet_amka`,`pet_microchip`),
KEY `FK_VET_idx` (`vet_amka`),
CONSTRAINT `FK_VET` FOREIGN KEY (`vet_amka`)
REFERENCES `vet` (`AMKA`)
ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `FK_PET` FOREIGN KEY (`pet_microchip`)
REFERENCES `pet` (`numberOfMicrochip`)
ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `municipalEmployee_pet` (
`municipalEmployee_amka` int(11) NOT NULL,
`pet_microchip` varchar(45) NOT NULL,
PRIMARY KEY (`municipalEmployee_amka`,`pet_microchip`),
KEY `FK_municipalEmployee_idx` (`municipalEmployee_amka`),
CONSTRAINT `FK_municipalEmployee` FOREIGN KEY (`municipalEmployee_amka`)
REFERENCES `municipalemployee` (`AMKA`)
ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `FK_PET2` FOREIGN KEY (`pet_microchip`)
REFERENCES `pet` (`numberOfMicrochip`)
ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `municipalEmployee_citizen` (
`municipalEmployee_amka` int(11) NOT NULL,
`citizen_amka` int(11) NOT NULL,
PRIMARY KEY (`municipalEmployee_amka`,`citizen_amka`),
KEY `FK_municipalEmployee_idx` (`municipalEmployee_amka`),
CONSTRAINT `FK_municipalEmployee2` FOREIGN KEY (`municipalEmployee_amka`)
REFERENCES `municipalemployee` (`AMKA`)
ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `FK_CITIZEN` FOREIGN KEY (`citizen_amka`)
REFERENCES `citizen` (`AMKA`)
ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

