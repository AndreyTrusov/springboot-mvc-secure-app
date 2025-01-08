-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: localhost    Database: mvcproject_1
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `company` varchar(100) DEFAULT NULL,
  `job_title` varchar(50) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `is_active` tinyint(1) DEFAULT 1,
  `last_login` datetime DEFAULT NULL,
  `profile_picture` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Alice Johnson','alice.johnson@example.com','test','123-456-7890','TechCorp','Software Engineer',1,'2024-01-01 09:00:00',1,'2024-12-26 00:00:00','bob.jpg','123 Elm Street, Springfield, USA','Female','1990-05-15'),(2,'Bob Smith','bob.smith@example.com','test','987-654-3210','HealthCare Inc.','Data Analyst',2,'2024-02-15 10:30:00',1,'2024-12-20 11:45:00','bob.jpg','456 Oak Street, Shelbyville, USA','Male','1985-08-20'),(3,'tt','tt@a2works.biz','$2a$10$TDIzZ576xj/Uv6JUvkV5euSEEuwiMrx1qG7XCfuCmet8AixgJwDFy',NULL,NULL,NULL,1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,NULL,NULL,NULL),(4,'tttt','tttt@a2works.biz','$2a$10$XMuZi.7s42hOyIMwV6UQYuWpqaPdOvb3XH.u6L7yhJvvuTyebkBLm',NULL,NULL,NULL,1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,NULL,NULL,NULL),(5,'te','rt@a2works.biz','$2a$10$IrdXb0AYcpS9H5LHX3kTaeLWj1E9HOyhViZZ8kVwvyKsTuOFcYKpa',NULL,NULL,NULL,1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,NULL,NULL,NULL),(6,'2222','test01@a2works.biz','$2a$10$pXuuS6wfTF2rodpMtXtnW.E2Z/lIiZAhzmTCMCSvqTAoKImVkBE6.',NULL,NULL,NULL,1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,NULL,NULL,NULL),(7,'Andrei Trusau','2323@a2works.biz','$2a$10$Z4dKm6KUqPCz9KKEX.ib5.sI4uQZBpwSJQFf/7y6OJM1DDz2xJV6C',NULL,NULL,NULL,1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,NULL,NULL,NULL),(8,'32532','42@4','$2a$10$EpXtND5TdKXpOV3DE2qhDeZ3LPQJwy/ncSvVpGKH4iLzi3by8jT8S',NULL,NULL,NULL,1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,NULL,NULL,NULL),(9,'5555','5555@a2works.biz','$2a$10$ARGk5cTg34DhS8jfP0zUNe/ScYe5Tpe8T0SeqJlpgnph7nZ2SuY0C',NULL,NULL,NULL,1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,NULL,NULL,NULL),(10,'123321','123321@a2works.biz','$2a$10$YJgHdHSA5M8UO6Wl9/GaXu6mKOfT9.L6u/K2iS32pnOrnYIECYxe6',NULL,NULL,NULL,1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,NULL,NULL,NULL),(11,'5555','55555@mail.ru','$2a$10$ABY4VMjrhVix0BfoNEpTzua.N04tOVTQIpq08S0mgvt0bGcH1CP7.',NULL,NULL,NULL,1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,NULL,NULL,NULL),(12,'Andrei Trusau','s222l@gmail.com','$2a$10$YFcQphXiHYDUAVoddGJz/esFlF9z9qdJAuPUiDp7TrP02aiRvfEqu',NULL,NULL,NULL,1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,NULL,NULL,NULL),(13,'test','test@testtt','111111','+4219508809','company','CEO',1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,'Srojarensa 10G','Female',NULL),(14,'aaa','test1@test1','$2a$10$YOWYt3uxL5mGPgTGWdWzUO/k3hOe8qgtx9UH6uCyvxfINb/UHsm5S',NULL,NULL,NULL,1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,NULL,NULL,NULL),(15,'maminka','mam@m','$2a$10$5XgUqsiGTH9p5AaR2yCQzOaLm.8iWIlTrdPpJWSedTcVMsf3pv59u',NULL,NULL,NULL,1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,NULL,NULL,NULL),(16,'Andrei Trusau','q@qqq','$2a$10$/z20zkLu2t/Jq/7bZ2RaXOhtHu///fVfGahT/Co5/TXfnlLlXvfJu','3253523','No company','lalka',1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,'bezdomnyj','Male',NULL),(17,'Andrei Trusau','qwqw@qwe','$2a$10$1xVBL94YYPbZnjX2qECmZefG5LjeWNz2dlBQdoDPebN4Gdy5T3IDm',NULL,NULL,NULL,1,'2024-12-28 00:00:00',1,'2024-12-28 00:00:00',NULL,NULL,NULL,NULL),(18,'name','w@w','$2a$10$iR8reldqQvb/XtIPFf5JU.pak8pu/esqHxYTF7OgtgMXhMXlGDB6m','123-456-7890','TechCorp','Software Engineer',3,'2024-01-01 09:00:00',1,'2024-12-26 14:00:00','bob.jpg','123 Elm Street, Springfield, USA','Female','1990-05-15'),(19,'andy','e@eee','$2a$10$fPutmr9mQ3oVXde6T35oPee9ZLvn/JXZ4ZMttEdYO93VMN6n0H172',NULL,NULL,NULL,1,'2024-12-30 00:00:00',1,'2024-12-30 00:00:00',NULL,NULL,NULL,NULL),(20,'admin_profile','e@e','$2a$10$fPutmr9mQ3oVXde6T35oPee9ZLvn/JXZ4ZMttEdYO93VMN6n0H172','123-456-7890','TechCorp','Software Engineer',3,'2024-01-01 09:00:00',1,'2024-12-26 14:00:00','bob.jpg','123 Elm Street, Springfield, USA','Female',NULL),(21,'Andrei Trusau','testtest1@a2works.biz','$2a$10$P9Uxm45itVTcILuRcW9jauPG77PzjJTsrOrO92ka1vbSyZ3qdUjyC',NULL,NULL,NULL,1,'2024-12-30 00:00:00',1,'2024-12-30 00:00:00',NULL,NULL,NULL,NULL),(22,'Andrei Trusau','test01t@a2works.biz','$2a$10$cSkyI2JNiVjmpsvrCA7eGOJB6Z99MljoMTDX0M74jB4c4FNK7dc.S',NULL,NULL,NULL,1,'2024-12-30 00:00:00',1,'2024-12-30 00:00:00',NULL,NULL,NULL,NULL),(23,'Andrei Trusau','test01tT@a2works.biz','$2a$10$DCipZ2Rwp7QAm7BwuU/5wu6eLNZPz5s5/F8RnhiJZ1Eo/4B8Ptvtu',NULL,NULL,NULL,1,'2024-12-30 00:00:00',1,'2024-12-30 00:00:00',NULL,NULL,NULL,NULL),(24,'Admin','admin@admin.com','$2a$10$yz/HGxd//f0uq123K17zRuXytImYFe5M0d8Qf23DhHfRQrLsHyM9y','','','',3,'2024-12-30 00:00:00',1,'2024-12-30 00:00:00',NULL,'','Male',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-30 15:59:18
