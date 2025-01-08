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
-- Table structure for table `learning_center`
--

DROP TABLE IF EXISTS `learning_center`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `learning_center` (
  `learning_center_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `capacity` int(11) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `webpage` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `established_date` date DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`learning_center_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `learning_center`
--

LOCK TABLES `learning_center` WRITE;
/*!40000 ALTER TABLE `learning_center` DISABLE KEYS */;
INSERT INTO `learning_center` VALUES (1,'Tech Academy','123 Main St, Springfield',150,'+1 555-1234','https://techacademy.com','contact@techacademy.com','2010-05-20','2024-12-30 13:47:36'),(2,'Code Academy','456 Elm St, Rivertown',200,'+1 555-5678','https://codeacademy.com','info@codeacademy.com','2015-09-12','2024-12-30 13:47:36'),(3,'Dev School','789 Oak St, Greenfield',100,'+1 555-9101','https://devschool.com','support@devschool.com','2012-03-15','2024-12-30 13:47:36'),(4,'Learn Hub','101 Pine St, Lakeview',120,'+1 555-1122','https://learnhub.com','hello@learnhub.com','2018-01-10','2024-12-30 13:47:36'),(5,'Innovate Learning','202 Maple St, Hilltop',180,'+1 555-3344','https://innovatelearning.com','contact@innovatelearning.com','2016-07-08','2024-12-30 13:47:36'),(6,'FutureTech Academy','56 Innovation Blvd, Silicon Valley, CA',250,'+1 408-555-0012','https://futuretechacademy.com','info@futuretechacademy.com','2012-09-15','2024-12-30 13:51:22'),(7,'The Coding Grove','324 Greenway Ave, Forest Hills, NY',150,'+1 718-555-0114','https://codinggrove.com','contact@codinggrove.com','2014-05-22','2024-12-30 13:51:22'),(8,'Global Learning Hub','9000 World Plaza, Los Angeles, CA',500,'+1 323-555-0978','https://globalhub.com','support@globalhub.com','2005-11-30','2024-12-30 13:51:22'),(9,'Tech Innovators Institute','1123 Tech Rd, Boston, MA',180,'+1 617-555-1235','https://techinnovators.com','info@techinnovators.com','2017-01-10','2024-12-30 13:51:22'),(10,'Skyline University','777 Heights St, New York, NY',1000,'+1 212-555-7632','https://skylineuniversity.com','admissions@skylineuniversity.com','1990-04-05','2024-12-30 13:51:22'),(11,'CodeLabs Academy','2897 Developer Way, Chicago, IL',80,'+1 312-555-8523','https://codelabsacademy.com','hello@codelabsacademy.com','2018-08-14','2024-12-30 13:51:22'),(12,'NextGen Learning Center','459 University Dr, Austin, TX',300,'+1 512-555-6704','https://nextgenlearning.com','enroll@nextgenlearning.com','2010-12-01','2024-12-30 13:51:22'),(13,'Brainwave Institute','213 Mindset Ave, Denver, CO',120,'+1 303-555-2347','https://brainwaveinstitute.com','info@brainwaveinstitute.com','2016-07-22','2024-12-30 13:51:22'),(14,'Creative Minds Academy','5801 Art District St, Miami, FL',250,'+1 305-555-4321','https://creativemindsacademy.com','contact@creativemindsacademy.com','2019-03-18','2024-12-30 13:51:22'),(15,'TechTrail Academy','1023 Innovation Street, Seattle, WA',200,'+1 206-555-3456','https://techtrailacademy.com','help@techtrailacademy.com','2015-06-27','2024-12-30 13:51:22');
/*!40000 ALTER TABLE `learning_center` ENABLE KEYS */;
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
