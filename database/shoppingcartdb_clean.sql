-- MySQL dump 10.13  Distrib 9.1.0, for Win64 (x86_64)
--
-- Host: localhost    Database: shoppingcartdb_new
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.10-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `consumers`
--

DROP TABLE IF EXISTS `consumers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consumers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumers`
--

LOCK TABLES `consumers` WRITE;
/*!40000 ALTER TABLE `consumers` DISABLE KEYS */;
INSERT INTO `consumers` VALUES (1,'Arjun Malhotra','arjun.malhotra@example.com'),(2,'Neha Reddy','neha.reddy@example.com'),(3,'Rahul Singh','rahul.singh@example.com'),(4,'Ananya Sharma','ananya.sharma@example.com'),(5,'Vikas Mehra','vikas.mehra@example.com'),(6,'Sneha Tiwari','sneha.tiwari@example.com'),(7,'Manoj Kumar','manoj.kumar@example.com'),(8,'Isha Mishra','isha.mishra@example.com'),(9,'Rohan Desai','rohan.desai@example.com'),(10,'Meera Kaul','meera.kaul@example.com');
/*!40000 ALTER TABLE `consumers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  `payment_method` varchar(50) DEFAULT NULL,
  `card_number` varchar(20) DEFAULT NULL,
  `exp_date` varchar(5) DEFAULT NULL,
  `cvv` varchar(4) DEFAULT NULL,
  `cardholder_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,34999.00,'Credit Card','4111111111111111','12/25','123','Arjun Malhotra'),(2,2,1299.50,'Debit Card','5454545454545454','11/24','456','Neha Reddy'),(3,3,55000.00,'Credit Card','4000123412341234','08/26','789','Rahul Singh'),(4,4,2150.75,'UPI',NULL,NULL,NULL,'Ananya Sharma'),(5,5,7800.20,'Debit Card','5105105105105100','07/25','321','Vikas Mehra'),(6,6,999.99,'Credit Card','6011000990139424','09/23','654','Sneha Tiwari'),(7,7,25999.00,'Credit Card','3566002020360505','05/27','987','Manoj Kumar'),(8,8,1899.00,'UPI',NULL,NULL,NULL,'Isha Mishra'),(9,9,799.49,'Debit Card','6011111111111117','04/26','159','Rohan Desai'),(10,10,450.00,'UPI',NULL,NULL,NULL,'Meera Kaul');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'iPhone 14 Pro',129900.00),(2,'Samsung Galaxy S23',84999.00),(3,'HP Pavilion x360 Laptop',62999.00),(4,'Dell Inspiron 15',58999.00),(5,'Sony WH-1000XM5 Headphones',29999.00),(6,'boAt Airdopes 141',1499.00),(7,'Apple MacBook Air M2',114900.00),(8,'Lenovo Legion 5 Pro',142999.00),(9,'Realme Narzo 60',17999.00),(10,'Redmi Note 13 Pro',23999.00),(11,'JBL Flip 6 Bluetooth Speaker',8999.00),(12,'Fire-Boltt Ninja Smartwatch',1999.00),(13,'Canon EOS 1500D DSLR Camera',42999.00),(14,'Mi LED Smart TV 43 Inch',26999.00),(15,'LG 260 L Double Door Refrigerator',24490.00),(16,'Samsung 6.5kg Washing Machine',18990.00),(17,'Philips Air Fryer',9990.00),(18,'Prestige Induction Cooktop',3499.00),(19,'Noise ColorFit Pulse 2',1999.00),(20,'OnePlus Nord CE 3 Lite',19999.00),(21,'Asus ROG Strix Gaming Laptop',134999.00),(22,'Logitech Wireless Mouse M235',799.00),(23,'HP 680 Ink Cartridge',749.00),(24,'SanDisk 128GB Pendrive',1099.00),(25,'TP-Link WiFi Range Extender',1499.00);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'arjun21','arjun21@gmail.com','arjun@123'),(2,'neha_r','neha.r@gmail.com','neha@456'),(3,'rahul_singh','rahul_singh@yahoo.com','rahul@789'),(4,'ananya22','ananya22@hotmail.com','ananya@321'),(5,'vikas_mehra','vikas.mehra@gmail.com','vikas@abc'),(6,'sneha_tiwari','sneha_t@yahoo.com','sneha@def'),(7,'manojkumar','manoj.kumar@gmail.com','manoj@pass'),(8,'isha.m','isha.m@gmail.com','isha@pass'),(9,'rohan_d','rohan.d123@gmail.com','rohan@xyz'),(10,'meera.k','meera.k@gmail.com','meera@pass');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-12  2:56:12
