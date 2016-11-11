-- --------------------------------------------------------
-- Host:                         172.16.99.13
-- Versione server:              5.7.9-log - MySQL Community Server (GPL)
-- S.O. server:                  Win64
-- HeidiSQL Versione:            9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dump della struttura del database es4novembre
CREATE DATABASE IF NOT EXISTS `es4novembre` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `es4novembre`;

-- Dump della struttura di tabella es4novembre.autore
DROP TABLE IF EXISTS `autore`;
CREATE TABLE IF NOT EXISTS `autore` (
  `CODICE_AUTORE` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(30) NOT NULL,
  `COGNOME` varchar(30) NOT NULL,
  `ANNO_NASCITA` int(11) NOT NULL,
  `NAZIONALITA` varchar(20) NOT NULL,
  `CODICE_GENERE` int(11) NOT NULL,
  PRIMARY KEY (`CODICE_AUTORE`),
  KEY `genere_n_pagine_fk` (`CODICE_GENERE`),
  CONSTRAINT `genere_n_pagine_fk` FOREIGN KEY (`CODICE_GENERE`) REFERENCES `genere` (`CODICE_GENERE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella es4novembre.autore: ~13 rows (circa)
DELETE FROM `autore`;
/*!40000 ALTER TABLE `autore` DISABLE KEYS */;
INSERT INTO `autore` (`CODICE_AUTORE`, `NOME`, `COGNOME`, `ANNO_NASCITA`, `NAZIONALITA`, `CODICE_GENERE`) VALUES
	(1, 'Homer', 'Gigiolino', 1265, 'COSMOPOLITA', 3),
	(2, 'Homer', 'Rowling', 1965, 'COSMOPOLITA', 2),
	(3, 'Homer', 'Christie', 1890, 'COSMOPOLITA', 1),
	(4, 'Homer', 'Weir', 1972, 'COSMOPOLITA', 4),
	(5, 'Homer', 'Sbirix', 1900, 'COSMOPOLITA', 5),
	(6, 'Homer', 'Eco', 1929, 'COSMOPOLITA', 2),
	(7, 'Homer', 'Crespo', 1895, 'COSMOPOLITA', 2),
	(8, 'Homer', 'Treno', 1928, 'COSMOPOLITA', 2),
	(9, 'Homer', 'Mmmm', 287, 'COSMOPOLITA', 7),
	(10, 'Homer', 'Einstein', 1889, 'COSMOPOLITA', 6),
	(11, 'Homer', 'Fede', 1862, 'COSMOPOLITA', 8),
	(13, 'Homer', 'Landy', 1985, 'COSMOPOLITA', 1),
	(14, 'Homer', 'McFellen', 1908, 'COSMOPOLITA', 9),
	(32, 'Giuseppe', 'Simone', 1974, 'Nevianese', 2);
/*!40000 ALTER TABLE `autore` ENABLE KEYS */;

-- Dump della struttura di tabella es4novembre.cliente
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `CODICE_CLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(30) NOT NULL,
  `COGNOME` varchar(30) NOT NULL,
  `INDIRIZZO` varchar(150) NOT NULL,
  `NUM_TELEFONO` varchar(20) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  PRIMARY KEY (`CODICE_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella es4novembre.cliente: ~12 rows (circa)
DELETE FROM `cliente`;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`CODICE_CLIENTE`, `NOME`, `COGNOME`, `INDIRIZZO`, `NUM_TELEFONO`, `EMAIL`) VALUES
	(1, 'Alessio', 'Pizzinat', 'Via Ravaschieri 33', '3384855823', 'alessio.pizzinat@gmail.com'),
	(2, 'Marco', 'Bianchi', 'Via Fumagalli 28', '3456789012', 'marco.bianchi@outlook.com'),
	(3, 'Andrea', 'Colleoni', 'Via Roma, 1', '34567654', 'andrea@colleoni.info'),
	(4, 'Andrea', 'Colleoni', 'Via Roma, 1', '34567654', 'andrea@colleoni.info'),
	(5, 'Andrea', 'Colleoni', 'Via Roma, 1', '34567654', 'andrea@colleoni.info'),
	(6, 'Andrea', 'Colleoni', 'Via Roma, 1', '34567654', 'andrea@colleoni.info'),
	(7, 'Andrea', 'Colleoni', 'Via Roma, 1', '34567654', 'andrea@colleoni.info'),
	(8, 'Andrea', 'Colleoni', 'Via Milano, 1', '34567654', 'andrea@colleoni.info'),
	(9, 'Andrea', 'Colleoni', 'Via Roma, 1', '34567654', 'andrea@colleoni.info'),
	(10, 'Andrea', 'Colleoni', 'Via Roma, 1', '34567654', 'andrea@colleoni.info'),
	(11, 'Andrea', 'Colleoni', 'Via Milano, 666', '34567654', 'andrea@colleoni.info'),
	(12, 'Andrea', 'Colleoni', 'Via Milano, 666', '34567654', 'andrea@colleoni.info');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Dump della struttura di tabella es4novembre.genere
DROP TABLE IF EXISTS `genere`;
CREATE TABLE IF NOT EXISTS `genere` (
  `CODICE_GENERE` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIZIONE` varchar(100) NOT NULL,
  `EPOCA` varchar(100) NOT NULL,
  PRIMARY KEY (`CODICE_GENERE`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella es4novembre.genere: ~8 rows (circa)
DELETE FROM `genere`;
/*!40000 ALTER TABLE `genere` DISABLE KEYS */;
INSERT INTO `genere` (`CODICE_GENERE`, `DESCRIZIONE`, `EPOCA`) VALUES
	(1, 'Giallo', 'Moderna'),
	(2, 'Narrativa', 'Moderna'),
	(3, 'Tecnologia', 'Moderna'),
	(4, 'Fantascienza', 'Moderna'),
	(5, 'Fantasy', 'Moderna'),
	(6, 'Scienza', 'Moderna'),
	(7, 'Scienza', 'Classica'),
	(8, 'Avventura', 'Moderna'),
	(9, 'Spionaggio', 'Moderna'),
	(10, 'Animazione', 'Moderna');
/*!40000 ALTER TABLE `genere` ENABLE KEYS */;

-- Dump della struttura di tabella es4novembre.libro
DROP TABLE IF EXISTS `libro`;
CREATE TABLE IF NOT EXISTS `libro` (
  `ISBN` varchar(40) NOT NULL,
  `TITOLO` varchar(200) NOT NULL,
  `CASA_EDITRICE` varchar(100) NOT NULL,
  `ANNO_PUBBLICAZIONE` int(11) NOT NULL,
  `N_PAGINE` int(11) NOT NULL,
  `CODICE_GENERE` int(11) NOT NULL,
  `CODICE_AUTORE` int(11) NOT NULL,
  PRIMARY KEY (`ISBN`),
  KEY `genere_libro_fk` (`CODICE_GENERE`),
  KEY `n_pagine_libro_fk` (`CODICE_AUTORE`),
  CONSTRAINT `genere_libro_fk` FOREIGN KEY (`CODICE_GENERE`) REFERENCES `genere` (`CODICE_GENERE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `n_pagine_libro_fk` FOREIGN KEY (`CODICE_AUTORE`) REFERENCES `autore` (`CODICE_AUTORE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella es4novembre.libro: ~21 rows (circa)
DELETE FROM `libro`;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` (`ISBN`, `TITOLO`, `CASA_EDITRICE`, `ANNO_PUBBLICAZIONE`, `N_PAGINE`, `CODICE_GENERE`, `CODICE_AUTORE`) VALUES
	(' 978-8845269707', 'Il Signore degli Anelli', 'Rusconi', 1955, 1359, 5, 5),
	('234-234-234234', 'Teoria della Relatività Ristretta', 'Apogeo', 1909, 150, 7, 10),
	('2342-4234-24', 'Arenario', 'Rizzoli', 1940, 75, 7, 9),
	('2345676543', 'Manuale di Java', 'Emit', 2016, 10, 1, 1),
	('3141516135', 'La Divina Commedia', 'Cea', 1290, 1035, 3, 1),
	('978-88-04-37085-7', 'Il Barone Rampante', 'Barone', 1957, 263, 2, 8),
	('978-88-04-37087-1', 'Il Visconte Dimezzato', 'Mondadori', 1951, 280, 2, 8),
	('978-88-04-39741-1', 'Assassinio sull\'Orient Express', 'Mondadori', 1934, 215, 1, 3),
	('978-88-04-48202-4', 'Il Cavaliere Senza Testa', 'Mondadori', 1960, 126, 2, 8),
	('978-88-045-0759-8', '10 Piccoli Indiani', 'Mondadori', 1939, 181, 1, 3),
	('978-88-425-2292-8', 'Il Corsaro Nero', 'Mursia', 1898, 373, 8, 11),
	('978-88-452-0705-6', 'Il Nome della Rosa', 'Giunti', 1985, 950, 1, 6),
	('978-88-459-2716-4', 'Siddharta', 'Adelphi', 1970, 280, 2, 7),
	('978-88-462-0247-3', 'Il Silmarillion', 'Allen & Unwin', 1977, 600, 5, 5),
	('978-88-541-6938-8', 'The Martian', 'Newton Compton', 2011, 379, 4, 4),
	('978-88-7782-702-5', 'Harry Potter e la pietra filosofale', 'Salani', 1997, 293, 2, 2),
	('978-88-7782-703-3', 'Harry Potter e la camera dei segreti', 'Salani', 1998, 307, 2, 2),
	('978-88-7782-852-8', 'Harry Potter e il Prigioniero di Azkaban', 'Salani', 1999, 470, 5, 2),
	('978-88-8246-804-0', 'Moonraker', 'Guanda', 2005, 250, 9, 14),
	('978-88-8451-344-8', 'Harry Potter e l\'Ordine della Fenice', 'Salani', 2003, 980, 5, 2),
	('a', 'b', 'c', 4, 4, 4, 4);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;

-- Dump della struttura di tabella es4novembre.prestito
DROP TABLE IF EXISTS `prestito`;
CREATE TABLE IF NOT EXISTS `prestito` (
  `CODICE_CLIENTE` int(11) NOT NULL,
  `ISBN` varchar(40) NOT NULL,
  `DATA_PRESTITO` date NOT NULL,
  `DATA_RESTITUZIONE` date DEFAULT NULL,
  PRIMARY KEY (`CODICE_CLIENTE`,`ISBN`,`DATA_PRESTITO`),
  KEY `libro_new_tableprestito_fk` (`ISBN`),
  CONSTRAINT `cliente_prestito_fk` FOREIGN KEY (`CODICE_CLIENTE`) REFERENCES `cliente` (`CODICE_CLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `libro_new_tableprestito_fk` FOREIGN KEY (`ISBN`) REFERENCES `libro` (`ISBN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella es4novembre.prestito: ~3 rows (circa)
DELETE FROM `prestito`;
/*!40000 ALTER TABLE `prestito` DISABLE KEYS */;
INSERT INTO `prestito` (`CODICE_CLIENTE`, `ISBN`, `DATA_PRESTITO`, `DATA_RESTITUZIONE`) VALUES
	(1, ' 978-8845269707', '2016-11-08', NULL),
	(1, '978-88-541-6938-8', '2016-11-08', '2017-01-01'),
	(2, '978-88-7782-703-3', '2016-11-08', '2016-11-08');
/*!40000 ALTER TABLE `prestito` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
