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
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `is_private` tinyint(1) DEFAULT 0,
  `created_by` int(11) NOT NULL,
  `description` text DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`event_id`),
  KEY `created_by` (`created_by`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `User` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (51,'Tech Conference 2024',0,1,'A large-scale conference bringing together tech professionals, industry leaders, and startups to discuss the latest trends in technology and innovation.','2024-12-30 15:31:52'),(52,'AI Workshop: Exploring the Future',1,2,'An exclusive hands-on workshop for data scientists and AI enthusiasts to explore cutting-edge AI techniques and frameworks. Limited to 30 participants.','2024-12-30 15:31:52'),(53,'Codeathon 2024',0,3,'A competitive coding event where developers of all skill levels come together to build innovative solutions within 48 hours. Open to public participation.','2024-12-30 15:31:52'),(54,'Creative Design Summit',1,4,'An exclusive event for top designers in the industry, offering workshops on the latest design trends, tools, and techniques.','2024-12-30 15:31:52'),(55,'Blockchain Expo',0,5,'A global event focused on blockchain technologies, cryptocurrencies, and decentralized applications. Keynote speakers from major blockchain companies.','2024-12-30 15:31:52'),(56,'Data Science Bootcamp',1,6,'A 6-week intensive bootcamp designed to train aspiring data scientists. Hands-on projects and mentorship from industry professionals.','2024-12-30 15:31:52'),(57,'Startup Pitch Night',0,7,'An open event for startups to pitch their innovative ideas to a panel of investors. The best pitch wins funding for their next stage of growth.','2024-12-30 15:31:52'),(58,'Cybersecurity Symposium',1,8,'A private event for cybersecurity professionals to discuss the latest threats, vulnerabilities, and defense strategies in the ever-evolving world of cyber threats.','2024-12-30 15:31:52'),(59,'Digital Marketing Conference',0,9,'A comprehensive conference focusing on the latest trends in digital marketing, including social media strategies, SEO, and influencer marketing.','2024-12-30 15:31:52'),(60,'Startup Ecosystem Meet-up',0,10,'A casual networking event for entrepreneurs, investors, and innovators to exchange ideas and build connections within the startup ecosystem.','2024-12-30 15:31:52');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
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
