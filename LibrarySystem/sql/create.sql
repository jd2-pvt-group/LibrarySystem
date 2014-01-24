-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.35 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2014-01-25 00:11:10
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for librarydb
CREATE DATABASE IF NOT EXISTS `librarydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `librarydb`;


-- Dumping structure for table librarydb.author
CREATE TABLE IF NOT EXISTS `author` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(50) NOT NULL,
  `LAST_NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.book
CREATE TABLE IF NOT EXISTS `book` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(50) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) DEFAULT '0',
  `BOOK_SERIAL_ID` int(11) DEFAULT NULL,
  `PUBLISHER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ISBN` (`ISBN`),
  KEY `FK_B_BOOK_SERIAL` (`BOOK_SERIAL_ID`),
  KEY `FK_B_PUBLISHER` (`PUBLISHER_ID`),
  CONSTRAINT `FK_B_BOOK_USER_HISTORY` FOREIGN KEY (`ID`) REFERENCES `book_user_history` (`BOOK_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_B_BOOK_SERIAL` FOREIGN KEY (`BOOK_SERIAL_ID`) REFERENCES `book_serial` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_B_BOOK_USER` FOREIGN KEY (`ID`) REFERENCES `book_user` (`BOOK_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_B_PUBLISHER` FOREIGN KEY (`PUBLISHER_ID`) REFERENCES `publisher` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.book_author
CREATE TABLE IF NOT EXISTS `book_author` (
  `BOOK_ID` int(10) NOT NULL,
  `AUTHOR_ID` int(10) NOT NULL,
  PRIMARY KEY (`BOOK_ID`,`AUTHOR_ID`),
  KEY `FK_BA_AUTHOR` (`AUTHOR_ID`),
  CONSTRAINT `FK_BA_BOOK` FOREIGN KEY (`BOOK_ID`) REFERENCES `book` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_BA_AUTHOR` FOREIGN KEY (`AUTHOR_ID`) REFERENCES `author` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.book_genre
CREATE TABLE IF NOT EXISTS `book_genre` (
  `BOOK_ID` int(10) NOT NULL,
  `GENRE_ID` int(10) NOT NULL,
  PRIMARY KEY (`BOOK_ID`,`GENRE_ID`),
  KEY `FK_BG_GENRE` (`GENRE_ID`),
  CONSTRAINT `FK_BG_BOOK` FOREIGN KEY (`BOOK_ID`) REFERENCES `book` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_BG_GENRE` FOREIGN KEY (`GENRE_ID`) REFERENCES `genre` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.book_serial
CREATE TABLE IF NOT EXISTS `book_serial` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.book_user
CREATE TABLE IF NOT EXISTS `book_user` (
  `BOOK_ID` int(10) NOT NULL,
  `USER_ID` int(10) NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  `IS_CONTINUED` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`BOOK_ID`),
  KEY `FK_BU_USER` (`USER_ID`),
  CONSTRAINT `FK_BU_BOOK` FOREIGN KEY (`BOOK_ID`) REFERENCES `book` (`ID`),
  CONSTRAINT `FK_BU_USER` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.book_user_history
CREATE TABLE IF NOT EXISTS `book_user_history` (
  `BOOK_ID` int(10) NOT NULL,
  `USER_ID` int(10) NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  `IS_CONTINUED` tinyint(1) NOT NULL,
  `IS_IN_TIME` tinyint(1) NOT NULL,
  PRIMARY KEY (`BOOK_ID`),
  KEY `FK_BUH_USER` (`USER_ID`),
  CONSTRAINT `FK_BUH_BOOK` FOREIGN KEY (`BOOK_ID`) REFERENCES `book` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_BUH_USER` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.genre
CREATE TABLE IF NOT EXISTS `genre` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.global_setting
CREATE TABLE IF NOT EXISTS `global_setting` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `VALUE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.permission
CREATE TABLE IF NOT EXISTS `permission` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CODE` (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.publisher
CREATE TABLE IF NOT EXISTS `publisher` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `ADDRESS` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.role
CREATE TABLE IF NOT EXISTS `role` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` int(10) NOT NULL,
  `DESCRIPTION` int(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.role_permission
CREATE TABLE IF NOT EXISTS `role_permission` (
  `ROLE_ID` int(10) NOT NULL,
  `PERMISSION_ID` int(10) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`PERMISSION_ID`),
  KEY `FK_RP_PERMISSION` (`PERMISSION_ID`),
  CONSTRAINT `FK_RP_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_RP_PERMISSION` FOREIGN KEY (`PERMISSION_ID`) REFERENCES `permission` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.user
CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `FIRST_NAME` varchar(50) NOT NULL,
  `LAST_NAME` varchar(50) NOT NULL,
  `PASS_NUMBER` varchar(50) NOT NULL,
  `ADDRESS` varchar(200) DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `PASS_NUMBER` (`PASS_NUMBER`),
  UNIQUE KEY `LOGIN` (`LOGIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table librarydb.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `USER_ID` int(10) NOT NULL,
  `ROLE_ID` int(10) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `FK_UR_ROLE` (`ROLE_ID`),
  CONSTRAINT `FK_UR_USER` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_UR_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
