-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: funding_system
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_num` int unsigned NOT NULL AUTO_INCREMENT,
  `address_id` varchar(45) NOT NULL,
  `address_state` varchar(45) NOT NULL,
  `address_city` varchar(45) NOT NULL,
  `address_line` varchar(45) NOT NULL,
  PRIMARY KEY (`address_num`),
  UNIQUE KEY `address_num_UNIQUE` (`address_num`),
  KEY `user_id_idx` (`address_id`),
  CONSTRAINT `address_customer_id` FOREIGN KEY (`address_id`) REFERENCES `customer` (`customer_id`) ON UPDATE CASCADE,
  CONSTRAINT `address_seller_id` FOREIGN KEY (`address_id`) REFERENCES `seller` (`seller_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` varchar(45) NOT NULL,
  `admin_pw` varchar(45) DEFAULT NULL,
  `admin_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_id_UNIQUE` (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calculate`
--

DROP TABLE IF EXISTS `calculate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calculate` (
  `calculate_num` int unsigned NOT NULL,
  `calculate_funding` int unsigned DEFAULT NULL,
  `calculate_seller` varchar(45) DEFAULT NULL,
  `calculate_admin` varchar(45) DEFAULT NULL,
  `calculate_cost` int unsigned DEFAULT NULL,
  `calculate_At` datetime DEFAULT NULL,
  PRIMARY KEY (`calculate_num`),
  UNIQUE KEY `calculate_num_UNIQUE` (`calculate_num`),
  KEY `calculate_admin_idx` (`calculate_admin`),
  KEY `calculate_seller_idx` (`calculate_seller`),
  KEY `calculate_funding_idx` (`calculate_funding`),
  CONSTRAINT `calculate_admin` FOREIGN KEY (`calculate_admin`) REFERENCES `admin` (`admin_id`) ON UPDATE CASCADE,
  CONSTRAINT `calculate_funding` FOREIGN KEY (`calculate_funding`) REFERENCES `funding` (`funding_num`) ON UPDATE CASCADE,
  CONSTRAINT `calculate_seller` FOREIGN KEY (`calculate_seller`) REFERENCES `funding` (`funding_seller`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calculate`
--

LOCK TABLES `calculate` WRITE;
/*!40000 ALTER TABLE `calculate` DISABLE KEYS */;
/*!40000 ALTER TABLE `calculate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` varchar(45) NOT NULL,
  `customer_pw` varchar(45) DEFAULT NULL,
  `customer_name` varchar(20) DEFAULT NULL,
  `customer_phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `user_id_UNIQUE` (`customer_id`),
  KEY `user_id_idx` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery` (
  `deliver_num` int NOT NULL AUTO_INCREMENT,
  `delivery_order` int unsigned NOT NULL,
  `delivery_customer` varchar(45) NOT NULL,
  `delivery_address` varchar(100) DEFAULT NULL,
  `delivery_name` varchar(20) DEFAULT NULL,
  `delivery_phone` varchar(15) DEFAULT NULL,
  `delivery_request` text,
  `delivery_billing` varchar(20) DEFAULT NULL,
  `delivery_courier` varchar(20) DEFAULT NULL,
  `deliver_address` int unsigned NOT NULL,
  PRIMARY KEY (`deliver_num`),
  UNIQUE KEY `deliver_num_UNIQUE` (`deliver_num`),
  KEY `delivery_order_idx` (`delivery_order`),
  KEY `deliver_customer_idx` (`delivery_customer`),
  KEY `delivery_address_idx` (`deliver_address`),
  CONSTRAINT `deliver_customer` FOREIGN KEY (`delivery_customer`) REFERENCES `order` (`order_customer`) ON UPDATE CASCADE,
  CONSTRAINT `delivery_address` FOREIGN KEY (`deliver_address`) REFERENCES `order` (`order_address`) ON UPDATE CASCADE,
  CONSTRAINT `delivery_order` FOREIGN KEY (`delivery_order`) REFERENCES `order` (`order_num`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funding`
--

DROP TABLE IF EXISTS `funding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funding` (
  `funding_num` int unsigned NOT NULL AUTO_INCREMENT,
  `funding_seller` varchar(45) NOT NULL,
  `funding_banner` text,
  `funding_title` varchar(50) DEFAULT NULL,
  `funding_content` text,
  `funding_createAt` datetime DEFAULT NULL,
  `funding_deleteAt` datetime DEFAULT NULL,
  `funding_openAt` datetime DEFAULT NULL,
  `funding_closeAt` datetime DEFAULT NULL,
  `funding_purpose` int DEFAULT NULL,
  `funding_hits` int DEFAULT NULL,
  `funding_categori` varchar(45) DEFAULT NULL,
  `funding_state` varchar(10) DEFAULT NULL,
  `funding_fee` int DEFAULT NULL,
  PRIMARY KEY (`funding_num`),
  KEY `funding_seller_idx` (`funding_seller`),
  CONSTRAINT `funding_seller` FOREIGN KEY (`funding_seller`) REFERENCES `seller` (`seller_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funding`
--

LOCK TABLES `funding` WRITE;
/*!40000 ALTER TABLE `funding` DISABLE KEYS */;
/*!40000 ALTER TABLE `funding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funding_answer`
--

DROP TABLE IF EXISTS `funding_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funding_answer` (
  `answer_num` int NOT NULL AUTO_INCREMENT,
  `answer_seller` varchar(45) NOT NULL,
  `answer_question` int unsigned NOT NULL,
  `answer_content` text,
  `answer_at` datetime DEFAULT NULL,
  PRIMARY KEY (`answer_num`),
  UNIQUE KEY `answer_num_UNIQUE` (`answer_num`),
  KEY `answer_seller_id_idx` (`answer_seller`),
  KEY `answer_qna_num_idx` (`answer_question`),
  CONSTRAINT `answer_qna_num` FOREIGN KEY (`answer_question`) REFERENCES `funding_question` (`question_num`) ON UPDATE CASCADE,
  CONSTRAINT `answer_seller_id` FOREIGN KEY (`answer_seller`) REFERENCES `seller` (`seller_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funding_answer`
--

LOCK TABLES `funding_answer` WRITE;
/*!40000 ALTER TABLE `funding_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `funding_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funding_content`
--

DROP TABLE IF EXISTS `funding_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funding_content` (
  `content_num` int unsigned NOT NULL AUTO_INCREMENT,
  `content_funding` int unsigned DEFAULT NULL,
  `content_numbering` int DEFAULT NULL,
  `content_content` text,
  PRIMARY KEY (`content_num`),
  UNIQUE KEY `content_num_UNIQUE` (`content_num`),
  KEY `content_funding_idx` (`content_funding`),
  CONSTRAINT `content_funding` FOREIGN KEY (`content_funding`) REFERENCES `funding` (`funding_num`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funding_content`
--

LOCK TABLES `funding_content` WRITE;
/*!40000 ALTER TABLE `funding_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `funding_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funding_like`
--

DROP TABLE IF EXISTS `funding_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funding_like` (
  `like_num` int NOT NULL,
  `like_customer` varchar(45) DEFAULT NULL,
  `like_funding` int unsigned DEFAULT NULL,
  `like_At` datetime DEFAULT NULL,
  PRIMARY KEY (`like_num`),
  KEY `like_customer_idx` (`like_customer`),
  KEY `like_funding_idx` (`like_funding`),
  CONSTRAINT `like_customer` FOREIGN KEY (`like_customer`) REFERENCES `customer` (`customer_id`) ON UPDATE CASCADE,
  CONSTRAINT `like_funding` FOREIGN KEY (`like_funding`) REFERENCES `funding` (`funding_num`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funding_like`
--

LOCK TABLES `funding_like` WRITE;
/*!40000 ALTER TABLE `funding_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `funding_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funding_modify`
--

DROP TABLE IF EXISTS `funding_modify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funding_modify` (
  `modify_num` int NOT NULL,
  `modify_seller` varchar(45) NOT NULL,
  `modify_funding` int unsigned NOT NULL,
  `modify_at` datetime DEFAULT NULL,
  `modify_part` varchar(20) DEFAULT NULL,
  `modify_history` text,
  PRIMARY KEY (`modify_num`),
  KEY `history_funding_num_idx` (`modify_funding`),
  KEY `modify_seller_id_idx` (`modify_seller`),
  CONSTRAINT `modify_funding_num` FOREIGN KEY (`modify_funding`) REFERENCES `funding` (`funding_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `modify_seller_id` FOREIGN KEY (`modify_seller`) REFERENCES `seller` (`seller_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funding_modify`
--

LOCK TABLES `funding_modify` WRITE;
/*!40000 ALTER TABLE `funding_modify` DISABLE KEYS */;
/*!40000 ALTER TABLE `funding_modify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funding_option`
--

DROP TABLE IF EXISTS `funding_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funding_option` (
  `option_num` int unsigned NOT NULL AUTO_INCREMENT,
  `option_funding` int unsigned DEFAULT NULL,
  `option_numbering` int DEFAULT NULL,
  `option_name` varchar(50) DEFAULT NULL,
  `option_price` int unsigned NOT NULL,
  PRIMARY KEY (`option_num`),
  UNIQUE KEY `detail_num_UNIQUE` (`option_num`),
  KEY `option_funding_idx` (`option_funding`),
  CONSTRAINT `option_funding` FOREIGN KEY (`option_funding`) REFERENCES `funding` (`funding_num`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funding_option`
--

LOCK TABLES `funding_option` WRITE;
/*!40000 ALTER TABLE `funding_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `funding_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funding_payment`
--

DROP TABLE IF EXISTS `funding_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funding_payment` (
  `payment_num` int unsigned NOT NULL,
  `payment_customer` varchar(45) DEFAULT NULL,
  `payment_order` int unsigned DEFAULT NULL,
  `payment_total` int unsigned DEFAULT NULL,
  `payment_way` varchar(45) DEFAULT NULL,
  `payment_At` datetime DEFAULT NULL,
  PRIMARY KEY (`payment_num`),
  UNIQUE KEY `payment_num_UNIQUE` (`payment_num`),
  KEY `payment_customer_idx` (`payment_customer`),
  KEY `payment_order_idx` (`payment_order`),
  CONSTRAINT `payment_customer` FOREIGN KEY (`payment_customer`) REFERENCES `order` (`order_customer`) ON UPDATE CASCADE,
  CONSTRAINT `payment_order` FOREIGN KEY (`payment_order`) REFERENCES `order` (`order_num`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funding_payment`
--

LOCK TABLES `funding_payment` WRITE;
/*!40000 ALTER TABLE `funding_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `funding_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funding_question`
--

DROP TABLE IF EXISTS `funding_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funding_question` (
  `question_num` int unsigned NOT NULL AUTO_INCREMENT,
  `qusetion_customer` varchar(45) NOT NULL,
  `question_funding` int unsigned NOT NULL,
  `question_title` varchar(50) DEFAULT NULL,
  `qusetion_content` text,
  `question_at` datetime DEFAULT NULL,
  `question_state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`question_num`),
  UNIQUE KEY `qna_num_UNIQUE` (`question_num`),
  KEY `qna_customer_id_idx` (`qusetion_customer`),
  KEY `qna_funding_num_idx` (`question_funding`),
  CONSTRAINT `funding_question_customer` FOREIGN KEY (`qusetion_customer`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `funding_question_funding` FOREIGN KEY (`question_funding`) REFERENCES `funding` (`funding_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funding_question`
--

LOCK TABLES `funding_question` WRITE;
/*!40000 ALTER TABLE `funding_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `funding_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funding_review`
--

DROP TABLE IF EXISTS `funding_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funding_review` (
  `review_num` int unsigned NOT NULL AUTO_INCREMENT,
  `review_customer` varchar(45) NOT NULL,
  `review_funding` int unsigned NOT NULL,
  `review_title` varchar(50) DEFAULT NULL,
  `review_content` text,
  `review_at` datetime DEFAULT NULL,
  `review_rate` int unsigned DEFAULT NULL,
  PRIMARY KEY (`review_num`),
  UNIQUE KEY `review_num_UNIQUE` (`review_num`),
  KEY `review_funding_idx` (`review_funding`),
  KEY `review_customer_idx` (`review_customer`),
  CONSTRAINT `review_customer` FOREIGN KEY (`review_customer`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `review_funding` FOREIGN KEY (`review_funding`) REFERENCES `funding` (`funding_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funding_review`
--

LOCK TABLES `funding_review` WRITE;
/*!40000 ALTER TABLE `funding_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `funding_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `notice_num` int unsigned NOT NULL,
  `notice_admin` varchar(45) DEFAULT NULL,
  `notice_title` varchar(50) DEFAULT NULL,
  `notice_content` text,
  `notice_At` datetime DEFAULT NULL,
  PRIMARY KEY (`notice_num`),
  UNIQUE KEY `notice_num_UNIQUE` (`notice_num`),
  KEY `notice_admin_idx` (`notice_admin`),
  CONSTRAINT `notice_admin` FOREIGN KEY (`notice_admin`) REFERENCES `admin` (`admin_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_num` int unsigned NOT NULL AUTO_INCREMENT,
  `order_customer` varchar(45) NOT NULL,
  `order_fundind` int unsigned NOT NULL,
  `order_option` int unsigned DEFAULT NULL,
  `order_price` int unsigned DEFAULT NULL,
  `order_count` int DEFAULT NULL,
  `order_At` datetime DEFAULT NULL,
  `order_request` text,
  `order_address` int unsigned NOT NULL,
  PRIMARY KEY (`order_num`),
  UNIQUE KEY `order_num_UNIQUE` (`order_num`),
  KEY `order_useri_id_idx` (`order_customer`),
  KEY `order_funding_idx` (`order_fundind`),
  KEY `order_option_idx` (`order_option`),
  KEY `order_price_idx` (`order_price`),
  KEY `order_address_idx` (`order_address`),
  CONSTRAINT `order_address` FOREIGN KEY (`order_address`) REFERENCES `address` (`address_num`) ON UPDATE CASCADE,
  CONSTRAINT `order_customer` FOREIGN KEY (`order_customer`) REFERENCES `customer` (`customer_id`) ON UPDATE CASCADE,
  CONSTRAINT `order_funding` FOREIGN KEY (`order_fundind`) REFERENCES `funding_option` (`option_funding`) ON UPDATE CASCADE,
  CONSTRAINT `order_option` FOREIGN KEY (`order_option`) REFERENCES `funding_option` (`option_num`) ON UPDATE CASCADE,
  CONSTRAINT `order_price` FOREIGN KEY (`order_price`) REFERENCES `funding_option` (`option_num`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller`
--

DROP TABLE IF EXISTS `seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seller` (
  `seller_id` varchar(45) NOT NULL,
  `seller_pw` varchar(45) DEFAULT NULL,
  `seller_licenese` text,
  `seller_number` varchar(15) DEFAULT NULL,
  `seller_profile` text,
  `seller_name` varchar(50) DEFAULT NULL,
  `seller_phone` varchar(15) DEFAULT NULL,
  `seller_person_name` varchar(15) DEFAULT NULL,
  `seller_person_phone` varchar(20) DEFAULT NULL,
  `seller_state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`seller_id`),
  UNIQUE KEY `seller_user_id_UNIQUE` (`seller_id`),
  KEY `user_id_idx` (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller`
--

LOCK TABLES `seller` WRITE;
/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_answer`
--

DROP TABLE IF EXISTS `system_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_answer` (
  `answer_num` int unsigned NOT NULL AUTO_INCREMENT,
  `answer_question` int unsigned NOT NULL,
  `answer_admin` varchar(45) NOT NULL,
  `answer_at` datetime DEFAULT NULL,
  `answer_content` text,
  PRIMARY KEY (`answer_num`),
  UNIQUE KEY `answer_num_UNIQUE` (`answer_num`),
  KEY `system_answer_admin_idx` (`answer_admin`),
  KEY `system_qna_idx` (`answer_question`),
  CONSTRAINT `system_answer_admin` FOREIGN KEY (`answer_admin`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `system_qna` FOREIGN KEY (`answer_question`) REFERENCES `system_question` (`question_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_answer`
--

LOCK TABLES `system_answer` WRITE;
/*!40000 ALTER TABLE `system_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_question`
--

DROP TABLE IF EXISTS `system_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_question` (
  `question_num` int unsigned NOT NULL AUTO_INCREMENT,
  `quesiton_customer` varchar(45) NOT NULL,
  `question_admin` varchar(45) NOT NULL,
  `quesiton_title` varchar(50) DEFAULT NULL,
  `question_content` text,
  `question_at` datetime DEFAULT NULL,
  `question_state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`question_num`),
  UNIQUE KEY `qna_num_UNIQUE` (`question_num`),
  KEY `qna_customer_id_idx` (`quesiton_customer`),
  KEY `system_qna_admin_idx` (`question_admin`),
  CONSTRAINT `system_qna_admin` FOREIGN KEY (`question_admin`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `system_qna_userid` FOREIGN KEY (`quesiton_customer`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_question`
--

LOCK TABLES `system_question` WRITE;
/*!40000 ALTER TABLE `system_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-04 13:56:49
