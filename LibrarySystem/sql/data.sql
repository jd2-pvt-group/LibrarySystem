-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.35 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2014-02-03 15:42:27
-- --------------------------------------------------------
USE librarydb;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;
-- Dumping data for table librarydb.author: ~0 rows (approximately)
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
/*!40000 ALTER TABLE `author` ENABLE KEYS */;

-- Dumping data for table librarydb.book: ~0 rows (approximately)
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

-- Dumping data for table librarydb.book_author: ~0 rows (approximately)
/*!40000 ALTER TABLE `book_author` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_author` ENABLE KEYS */;

-- Dumping data for table librarydb.book_exemplar: ~0 rows (approximately)
/*!40000 ALTER TABLE `book_exemplar` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_exemplar` ENABLE KEYS */;

-- Dumping data for table librarydb.book_exemplar_user: ~0 rows (approximately)
/*!40000 ALTER TABLE `book_exemplar_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_exemplar_user` ENABLE KEYS */;

-- Dumping data for table librarydb.book_exemplar_user_history: ~0 rows (approximately)
/*!40000 ALTER TABLE `book_exemplar_user_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_exemplar_user_history` ENABLE KEYS */;

-- Dumping data for table librarydb.book_genre: ~0 rows (approximately)
/*!40000 ALTER TABLE `book_genre` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_genre` ENABLE KEYS */;

-- Dumping data for table librarydb.book_serial: ~0 rows (approximately)
/*!40000 ALTER TABLE `book_serial` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_serial` ENABLE KEYS */;

-- Dumping data for table librarydb.genre: ~0 rows (approximately)
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;

-- Dumping data for table librarydb.global_setting: ~0 rows (approximately)
/*!40000 ALTER TABLE `global_setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `global_setting` ENABLE KEYS */;

-- Dumping data for table librarydb.permission: ~1 rows (approximately)
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` (`ID`, `CODE`, `DESCRIPTION`) VALUES
	(1, 'CAN_LOGIN', 'user can login to system');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;

-- Dumping data for table librarydb.publisher: ~0 rows (approximately)
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
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
