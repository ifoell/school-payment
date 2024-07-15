-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: school_management
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

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
-- Table structure for table `achieve_student_regist`
--

DROP TABLE IF EXISTS `achieve_student_regist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `achieve_student_regist` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `student_regist_id` int(5) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `level` varchar(30) DEFAULT NULL,
  `updated_by` int(5) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achieve_student_regist`
--

LOCK TABLES `achieve_student_regist` WRITE;
/*!40000 ALTER TABLE `achieve_student_regist` DISABLE KEYS */;
/*!40000 ALTER TABLE `achieve_student_regist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `homeroom_t` int(5) DEFAULT NULL,
  `updated_by` int(5) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `class_teacher_FK` (`homeroom_t`),
  CONSTRAINT `class_teacher_FK` FOREIGN KEY (`homeroom_t`) REFERENCES `teacher` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,'10A',1,NULL,'2024-07-15 11:53:16');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nat_exam_student_regist`
--

DROP TABLE IF EXISTS `nat_exam_student_regist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nat_exam_student_regist` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `student_regist_id` int(5) NOT NULL,
  `nat_exam_subject_id` int(5) NOT NULL,
  `score` float DEFAULT NULL,
  `total_score` float DEFAULT NULL,
  `avg_score` float DEFAULT NULL,
  `updated_by` int(5) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nat_exam_student_regist`
--

LOCK TABLES `nat_exam_student_regist` WRITE;
/*!40000 ALTER TABLE `nat_exam_student_regist` DISABLE KEYS */;
/*!40000 ALTER TABLE `nat_exam_student_regist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nat_exam_subject`
--

DROP TABLE IF EXISTS `nat_exam_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nat_exam_subject` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `updated_by` int(5) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nat_exam_subject`
--

LOCK TABLES `nat_exam_subject` WRITE;
/*!40000 ALTER TABLE `nat_exam_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `nat_exam_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parents`
--

DROP TABLE IF EXISTS `parents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parents` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `gender` enum('Male','Female') DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `occupation` varchar(100) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `is_alive` enum('Y','N') DEFAULT 'Y',
  `updated_by` int(5) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parents`
--

LOCK TABLES `parents` WRITE;
/*!40000 ALTER TABLE `parents` DISABLE KEYS */;
INSERT INTO `parents` VALUES (1,'Ahmad  Mabruk','Male','Jl. ','Karyawan','Parents','Y',NULL,'2024-07-15 15:17:58');
/*!40000 ALTER TABLE `parents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `payment_type_id` int(5) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `status` smallint(1) DEFAULT NULL,
  `payment_date` datetime DEFAULT NULL,
  `updated_by` int(5) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `payment_payment_type_FK` (`payment_type_id`),
  CONSTRAINT `payment_payment_type_FK` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (5,2,500000,1,'2024-07-15 21:34:34',NULL,'2024-07-15 21:34:34'),(6,1,500000,1,'2024-07-15 21:29:41',NULL,'2024-07-15 21:29:41'),(7,1,500000,1,'2024-07-15 21:35:28',NULL,'2024-07-15 21:35:28');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_type`
--

DROP TABLE IF EXISTS `payment_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_type` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `updated_by` int(5) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_type`
--

LOCK TABLES `payment_type` WRITE;
/*!40000 ALTER TABLE `payment_type` DISABLE KEYS */;
INSERT INTO `payment_type` VALUES (1,'Uang Pendaftaran','Bayar Pendaftaran',100000,NULL,'2024-07-15 15:20:29'),(2,'Uang Gedung','Bayar Uang Gedung',500000,NULL,'2024-07-15 15:37:37'),(3,'SPP','Bayar SPP',50000,NULL,'2024-07-15 15:39:34');
/*!40000 ALTER TABLE `payment_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `school` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `nss` varchar(20) DEFAULT NULL,
  `npsn` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `website` varchar(30) DEFAULT NULL,
  `accredited` varchar(5) DEFAULT NULL,
  `accr_year` year(4) DEFAULT NULL,
  `updated_by` int(5) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (1,'SMP Al Furuqi','Jl. Kemang Raya Utara No. 29, Kec. Kemang, Kab. Kembang, Jawa Utara','1234567878','1112223334','877478','info@alfuruqi.sch.id','alfuruqi.sch.id','B',2021,NULL,'2024-07-15 10:24:09');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `s_id_number` varchar(20) DEFAULT NULL,
  `nat_s_id_number` varchar(30) DEFAULT NULL,
  `gender` enum('Male','Female') DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `class_id` int(5) DEFAULT NULL,
  `parents_id` int(5) DEFAULT NULL,
  `status` enum('A','I') NOT NULL,
  `entry_year` year(4) NOT NULL,
  `updated_by` int(5) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Rohimun Karim','202006001','8288829918','Male','Jl.',1,1,'A',2020,NULL,'2024-07-15 15:09:10');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_payment`
--

DROP TABLE IF EXISTS `student_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `student_regist_id` int(11) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_payment`
--

LOCK TABLES `student_payment` WRITE;
/*!40000 ALTER TABLE `student_payment` DISABLE KEYS */;
INSERT INTO `student_payment` VALUES (3,1,NULL,5),(4,1,NULL,6);
/*!40000 ALTER TABLE `student_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_regist`
--

DROP TABLE IF EXISTS `student_regist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_regist` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `gender` enum('M','F') DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `distance` int(5) DEFAULT NULL,
  `b_place` varchar(100) DEFAULT NULL,
  `b_date` date DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `religion` varchar(10) DEFAULT NULL,
  `school_origin_id` int(5) DEFAULT NULL,
  `certificate_number` varchar(100) DEFAULT NULL,
  `regis_date` datetime DEFAULT NULL,
  `parents_id` int(5) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `updated_by` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_regist`
--

LOCK TABLES `student_regist` WRITE;
/*!40000 ALTER TABLE `student_regist` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_regist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `class_id` int(5) NOT NULL,
  `schedule_day` varchar(10) DEFAULT NULL,
  `updated_by` int(5) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Matematika 1',1,'Senin',NULL,'2024-07-14 17:29:34'),(2,'Bahasa Indonesia 1',1,'Senin',NULL,'2024-07-14 17:28:43'),(4,'IPA 1',1,'Senin',NULL,'2024-07-15 11:03:32'),(5,'IPS 1',1,'Selasa',NULL,'2024-07-15 11:03:44');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `gender` enum('Male','Female') DEFAULT NULL,
  `unique_number` varchar(100) DEFAULT NULL COMMENT 'NUPTK (Unique Number for Educator and Education Personnel)',
  `entry_year` year(4) DEFAULT NULL,
  `updated_by` int(5) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Supardi Al Farisi','Male','626628881782',2020,NULL,'2024-07-15 11:22:41'),(3,'Gozy Faruq','Male','626628881783',2020,NULL,'2024-07-15 11:05:09'),(4,'Gozy Al Faruq','Male','626628881783',2020,NULL,'2024-07-15 11:12:43'),(5,'Abdurrahim Al Mubarak','Male','626628881785',2020,NULL,'2024-07-15 11:18:55');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_subject`
--

DROP TABLE IF EXISTS `teacher_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_subject` (
  `teacher_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  PRIMARY KEY (`teacher_id`,`subject_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `teacher_subject_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE,
  CONSTRAINT `teacher_subject_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_subject`
--

LOCK TABLES `teacher_subject` WRITE;
/*!40000 ALTER TABLE `teacher_subject` DISABLE KEYS */;
INSERT INTO `teacher_subject` VALUES (1,1),(1,4),(4,2),(4,5),(5,1),(5,4);
/*!40000 ALTER TABLE `teacher_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'school_management'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-15 21:39:01
