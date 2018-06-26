-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proiect
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `masini`
--

DROP TABLE IF EXISTS `masini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `masini` (
  `idmasina` int(11) NOT NULL AUTO_INCREMENT,
  `numeClient` varchar(45) DEFAULT NULL,
  `nrInmat` varchar(45) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `modelul` varchar(45) DEFAULT NULL,
  `culoarea` varchar(45) DEFAULT NULL,
  `dataParcare` varchar(45) DEFAULT NULL,
  `nrTelefon` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmasina`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masini`
--

LOCK TABLES `masini` WRITE;
/*!40000 ALTER TABLE `masini` DISABLE KEYS */;
INSERT INTO `masini` VALUES (1,'Pop Andrei','B31MIP','Volkswagen','Bora','albastru','24.04.2018','0744418930'),(2,'Paul Grigorescu','CJ30GRP','Renault','Captur','verde','07.05.2018','0755313931'),(3,'Stanescu Andreea','B01INS','Audi','A3','gri metalizat','16.05.2018','0760475321'),(4,'Cristea Simona','CJ14SVD','Dacia','Sandero','alb','12.02.2018','0759833932'),(5,'Popa Viorel','PH02EUR','Mercedes','S-Class','negru','30.04.2018','0749828934'),(6,'Marin Petre','MS90LEZ','Toyota','Avensis','alb','07.06.2018','0749318935'),(8,'Diaconu Camelia','BN12POC','Volkswagen','Beetle','alb','17.06.2018','0749418937'),(9,'Popescu Sergiu','MS01BRS','Volkswagen','Golf','galben','04.05.2018','0742718338'),(10,'Negru Mirela','BZ24NMR','Dacia','Logan','gri','25.04.2018','0748405320'),(11,'Oprea Paul','SB85FRD','Ford','Focus','negru','14.04.2018','0749818940'),(12,'Nita Pop','B33POP','Volkswagen','Touareg','maro','18.04.2018','0748305364'),(13,'Ene Mircea','CJ99STM','Renault','Megane','argintiu','01.05.2018','0749318942'),(14,'Puscas Maria','BV20IBA','Audi','A4','gri metalizat','16.05.2018','0759818931'),(15,'Nistor Vlad','CJ21HMY','Dacia','Duster','alb','01.02.2018','0749818924'),(16,'Ionescu George','CT05NNC','Mercedes','E-Class','negru','30.04.2018','0749818945'),(17,'Diaconu Sorin','MS80LAQ','Toyota','Avensis','argintiu','09.06.2018','0744918946'),(18,'Nistor Gabriel','BN33RNO','Opel','Astra','rosu','02.05.2018','0760275816'),(19,'Pop Mircea','CJ01PWR','Volkswagen','Beetle','maro','02.06.2018','0749818948'),(20,'Costache Puscas','MS01VLD','Volkswagen','Fox','argintiu','04.06.2018','0742218949'),(21,'Ionita Mirela','CJ18DCA','Dacia','Sandero','gri','23.04.2018','0761475821'),(22,'Rosu Paul','B89FRT','Ford','Fiesta','maro','14.03.2018','0749318951'),(23,'Mihai Pop','B44MIP','Volkswagen','Bora','albastru','24.04.2018','0749218952'),(24,'Popescu Alin','BV45GRP','Renault','Clio','verde','12.05.2018','0749818953'),(25,'Stoica Dana','B21INA','Audi','A3','gri metalizat','13.05.2018','0749818954'),(26,'Popescu Vlad','SB01SVD','Dacia','Duster','alb','20.02.2018','0755803931'),(28,'Stan George','MS18LAQ','Toyota','Avensis','alb','09.04.2018','0749818957'),(30,'Dima Camelia','CJ05POV','Volkswagen','Beetle','alb','01.06.2018','0749818959'),(31,'Costache Marcela','MS19VPP','Volkswagen','Tiguan','galben','04.04.2018','0759803930'),(32,'Stanciu Maria','CJ35NOP','Dacia','Logan','gri','21.04.2018','0749818961'),(33,'Albu Paul','B83BMP','Ford','Focus','argintiu','11.06.2018','0749818962'),(34,'Stanescu Mihaela','BZ45MVP','Volkswagen','Bora','argintiu','23.04.2018','0742818963'),(35,'Dobrescu Tudor','CJ99GRP','Renault','Megane','verde','08.05.2018','0749818964'),(36,'Georgescu Dana','SM22ITA','Audi','A4','maro','10.05.2018','0744435360'),(37,'Oprea Simona','SM78VRT','Dacia','Solenza','argintiu','15.02.2018','0749818966'),(38,'Stoica Sorin','PH43RAV','Mercedes','E-Class','negru','26.04.2018','0749838927'),(39,'Mocanu Sorin','MS77VVE','Toyota','Avensis','alb','01.06.2018','0741435821'),(40,'Voinea Gabriel','BN23SST','Opel','Astra','rosu','02.06.2018','0749818369'),(41,'Popescu Alexandra','CJ12PYY','Volkswagen','Beetle','maro','05.05.2018','0749818970'),(42,'Dobre Ioan','MS01BST','Volkswagen','Lupo','argintiu','07.06.2018','0759803950'),(43,'Oprea Daniela','CJ18JUI','Dacia','Sandero','argintiu','25.04.2018','0749818972'),(44,'Preda Paul','BN89FRD','Ford','Fiesta','negru','14.05.2018','0749818973'),(45,'Nistor Dan','BV67NUP','Volkswagen','Bora','albastru','20.04.2018','0749818974'),(46,'Grigorescu Mircea','CJ36GRP','Renault','Megane','verde','18.05.2018','0751275321'),(47,'Ionescu Alina ','B46IFR','Audi','A3','gri metalizat','16.05.2018','0742518926'),(48,'Florea Vlad','CJ88SVD','Dacia','Logan','argintiu','20.02.2018','0749818977'),(50,'Mihai Petre','MS99LAQ','Toyota','Avensis','alb','09.03.2018','0749838979'),(51,'Marin Gabriel','SM33NIK','Opel','Vectra','rosu','03.06.2018','0749818980'),(52,'Pop Marcela','SB40YBT','Volkswagen','Touran','alb','06.05.2018','0749818981'),(53,'Voicu Vlad','BV25VLD','Volkswagen','Golf','galben','07.06.2018','0749818982'),(54,'Nemes Mirela','CJ67NMR','Dacia','Logan','gri','16.04.2018','0759803911'),(55,'Barbu Paul','B83NST','Ford','Focus','negru','02.06.2018','0743518984'),(56,'Florea Andrei','BV33MAN','Volkswagen','Touareg','albastru','24.04.2018','0743518985'),(57,'Nistor Paula','CJ02GRP','Renault','Clio','verde','09.05.2018','0749838386'),(58,'Florea Alina','BN35ANB','Audi','A5','gri metalizat','16.05.2018','0748475821'),(59,'Vladescu Siomna','CJ01SVD','Dacia','Sandero','alb','15.02.2018','0749818928'),(60,'Nemes George','PH09MNB','Mercedes','S-Class','argintiu','30.04.2018','0759803312'),(61,'Mihai Barbu','SB96LRB','Toyota','Avensis','alb','02.05.2018','0748475361'),(62,'Popescu Daniel','SM43NIK','Opel','Meriva','rosu','02.06.2018','0749818991'),(63,'Pop Camelia','CJ79POC','Volkswagen','Beetle','alb','17.05.2018','0750303311'),(64,'Dima Alexandru','CT08QRT','Volkswagen','Golf','galben','04.05.2018','0749818993'),(65,'Stan Mirela','MM18CNO','Dacia','Logan','gri','25.04.2018','0750275311'),(66,'Rusu Alexandru','BZ23FFE','Ford','Fiesta','negru','13.05.2018','0749818995');
/*!40000 ALTER TABLE `masini` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-26 13:15:35
