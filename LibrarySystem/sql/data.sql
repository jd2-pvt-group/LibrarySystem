-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.35 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2014-02-15 12:29:03
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;
-- Dumping data for table librarydb.author: ~5 rows (approximately)
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` (`ID`, `FIRST_NAME`, `LAST_NAME`) VALUES
	(1, 'Lev', 'Tolstoy'),
	(2, 'Stiven', 'King'),
	(3, 'Richard', 'Castle'),
	(4, 'Boogie', 'Man'),
	(5, 'Alex', 'Pushkin');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;

-- Dumping data for table librarydb.book: ~3 rows (approximately)
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`ID`, `ISBN`, `NAME`, `DESCRIPTION`, `BOOK_SERIAL_ID`, `PUBLISHER_ID`) VALUES
	(1, 'isbn1', 'bookName1', 'bookDescription1', 3, 5),
	(2, 'isbn2', 'bookName2', 'bookDescription2', 5, 2),
	(3, 'isbn3', 'bookName3', 'bookDescription3', 5, 2);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

-- Dumping data for table librarydb.book_author: ~5 rows (approximately)
/*!40000 ALTER TABLE `book_author` DISABLE KEYS */;
INSERT INTO `book_author` (`BOOK_ID`, `AUTHOR_ID`) VALUES
	(3, 2),
	(2, 3),
	(1, 4),
	(2, 4),
	(1, 5);
/*!40000 ALTER TABLE `book_author` ENABLE KEYS */;

-- Dumping data for table librarydb.book_exemplar: ~6 rows (approximately)
/*!40000 ALTER TABLE `book_exemplar` DISABLE KEYS */;
INSERT INTO `book_exemplar` (`ID`, `BOOK_ID`, `LIBRARY_CODE`, `IS_ACTIVE`) VALUES
	(1, 1, '4', 1),
	(2, 2, '1', 0),
	(3, 1, '3', 0),
	(6, 1, '1', 0),
	(8, 1, '2', 1),
	(9, 3, '1', 0);
/*!40000 ALTER TABLE `book_exemplar` ENABLE KEYS */;

-- Dumping data for table librarydb.book_exemplar_user: ~0 rows (approximately)
/*!40000 ALTER TABLE `book_exemplar_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_exemplar_user` ENABLE KEYS */;

-- Dumping data for table librarydb.book_exemplar_user_history: ~0 rows (approximately)
/*!40000 ALTER TABLE `book_exemplar_user_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_exemplar_user_history` ENABLE KEYS */;

-- Dumping data for table librarydb.book_genre: ~9 rows (approximately)
/*!40000 ALTER TABLE `book_genre` DISABLE KEYS */;
INSERT INTO `book_genre` (`BOOK_ID`, `GENRE_ID`) VALUES
	(1, 1),
	(2, 1),
	(2, 2),
	(3, 2),
	(1, 3),
	(2, 3),
	(2, 4),
	(3, 4),
	(1, 5);
/*!40000 ALTER TABLE `book_genre` ENABLE KEYS */;

-- Dumping data for table librarydb.book_serial: ~5 rows (approximately)
/*!40000 ALTER TABLE `book_serial` DISABLE KEYS */;
INSERT INTO `book_serial` (`ID`, `NAME`, `DESCRIPTION`) VALUES
	(1, 'bookSerial1', 'bookSerial description1'),
	(2, 'bookSerial2', 'bookSerial description2'),
	(3, 'bookSerial3', 'bookSerial description3'),
	(4, 'bookSerial4', 'bookSerial description4'),
	(5, 'bookSerial5', 'bookSerial description5');
/*!40000 ALTER TABLE `book_serial` ENABLE KEYS */;

-- Dumping data for table librarydb.genre: ~5 rows (approximately)
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` (`ID`, `NAME`, `DESCRIPTION`) VALUES
	(1, 'genre1', 'genre1 description'),
	(2, 'genre2', 'genre2 description'),
	(3, 'genre3', 'genre3 description'),
	(4, 'genre4', 'genre4 description'),
	(5, 'genre5', 'genre5 description');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;

-- Dumping data for table librarydb.global_setting: ~0 rows (approximately)
/*!40000 ALTER TABLE `global_setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `global_setting` ENABLE KEYS */;

-- Dumping data for table librarydb.permission: ~1 rows (approximately)
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` (`ID`, `CODE`, `DESCRIPTION`) VALUES
	(1, 'CAN_LOGIN', 'user can login to system');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;

-- Dumping data for table librarydb.publisher: ~5 rows (approximately)
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` (`ID`, `NAME`, `ADDRESS`) VALUES
	(1, 'publisher1', 'publisher1 description'),
	(2, 'publisher2', 'publisher2 description'),
	(3, 'publisher3', 'publisher3 description'),
	(4, 'publisher4', 'publisher4 description'),
	(5, 'publisher5', 'publisher5 description');
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;

-- Dumping data for table librarydb.role: ~3 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`ID`, `NAME`, `DESCRIPTION`) VALUES
	(1, 'root', 'root role'),
	(3, 'manager', 'manager role'),
	(4, 'user', 'user role');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping data for table librarydb.role_permission: ~1 rows (approximately)
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` (`ROLE_ID`, `PERMISSION_ID`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;

-- Dumping data for table librarydb.user: ~1 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`ID`, `LOGIN`, `PASSWORD`, `FIRST_NAME`, `LAST_NAME`, `PASS_NUMBER`, `ADDRESS`, `IS_ACTIVE`) VALUES
	(1, 'user', '1', 'user_F_N', 'user_L_N', '787687', 'city', 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping data for table librarydb.user_role: ~1 rows (approximately)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`USER_ID`, `ROLE_ID`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
