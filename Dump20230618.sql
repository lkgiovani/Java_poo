CREATE DATABASE  IF NOT EXISTS `sale_house` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sale_house`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: sale_house
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `casa`
--

DROP TABLE IF EXISTS `casa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `casa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int DEFAULT NULL,
  `tittle` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `manyBathrooms` int DEFAULT NULL,
  `manySuites` int DEFAULT NULL,
  `manyBedroom` int DEFAULT NULL,
  `manyGarage` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `casa_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casa`
--

LOCK TABLES `casa` WRITE;
/*!40000 ALTER TABLE `casa` DISABLE KEYS */;
INSERT INTO `casa` VALUES (1,1,'Casa no campo','Casa aconchegante com jardim e vista panorâmica','casa1.jpg',200000,2,1,3,1),(2,2,'Casa na praia','Casa ampla com acesso direto à praia','casa2.jpg',300000,3,2,4,1),(3,3,'Casa na cidade','Casa moderna no coração da cidade','casa3.jpg',250000,2,1,2,0),(4,1,'Casa no campo 2','Casa com ampla área verde e piscina','casa4.jpg',350000,3,2,4,1),(5,2,'Casa na praia 2','Casa com vista para o mar e acesso privativo à praia','casa5.jpg',400000,4,3,5,1);
/*!40000 ALTER TABLE `casa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movel`
--

DROP TABLE IF EXISTS `movel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int DEFAULT NULL,
  `tittle` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `movel_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movel`
--

LOCK TABLES `movel` WRITE;
/*!40000 ALTER TABLE `movel` DISABLE KEYS */;
INSERT INTO `movel` VALUES (1,1,'Sofá de couro','Sofá de couro preto em ótimo estado','sofa1.jpg',1500,'Móveis de Sala'),(2,2,'Cama de casal','Cama de casal com colchão ortopédico','cama1.jpg',1200,'Móveis de Quarto'),(3,3,'Mesa de jantar','Mesa de jantar com tampo de vidro e 6 cadeiras','mesa1.jpg',800,'Móveis de Sala'),(4,1,'Guarda-roupa','Guarda-roupa de madeira maciça com 3 portas','guarda-roupa1.jpg',2000,'Móveis de Quarto'),(5,2,'Escrivaninha','Escrivaninha com gavetas e prateleiras','escrivaninha1.jpg',500,'Móveis de Escritório');
/*!40000 ALTER TABLE `movel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `sobrenome` varchar(50) DEFAULT NULL,
  `dataNascimento` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `cpf_cnpj` varchar(50) DEFAULT NULL,
  `telefone` varchar(50) DEFAULT NULL,
  `cep` int DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,NULL,NULL,NULL,'1234',NULL,NULL,NULL,NULL,NULL,NULL,'1234'),(2,'João','Silva','1980-01-01','joao@email.com','123.456.789-00','1234567890',12345,'Rua A','SP','Centro','senha123'),(3,'Maria','Santos','1990-02-02','maria@email.com','987.654.321-00','9876543210',54321,'Rua B','RJ','Copacabana','senha456'),(4,'Pedro','Ferreira','1985-03-03','pedro@email.com','111.222.333-00','1112223330',11111,'Rua C','MG','Barreiro','senha789');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-18 13:40:28
