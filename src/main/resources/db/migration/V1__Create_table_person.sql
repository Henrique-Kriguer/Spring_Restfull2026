-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.41 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.14.0.7165
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para rest_with_spring_boot
CREATE DATABASE IF NOT EXISTS `rest_with_spring_boot` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rest_with_spring_boot`;

-- Copiando estrutura para tabela rest_with_spring_boot.person
CREATE TABLE IF NOT EXISTS `person` (
                                        `id` bigint NOT NULL AUTO_INCREMENT,
                                        `address` varchar(100) NOT NULL,
    `first_name` varchar(80) NOT NULL,
    `gender` varchar(6) NOT NULL,
    `last_name` varchar(80) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela rest_with_spring_boot.person: ~10 rows (aproximadamente)
INSERT INTO `person` (`id`, `address`, `first_name`, `gender`, `last_name`) VALUES
                                                                                (1, 'Guaratinguetá , 232 - SP - Brasil', 'Henrique', 'Male', 'The Boss - Kriguer '),
                                                                                (3, 'Guaratinguetá - SP - Brasil', 'Francisco', 'Male', 'Kriguer'),
                                                                                (4, 'Guaratinguetá - SP - Brasil', 'João', 'Male', 'Kriguer'),
                                                                                (5, 'Guaratinguetá - SP - Brasil', 'Simone', 'Male', 'Kriguer'),
                                                                                (9, 'Londres , Great Britain', 'Billy', 'Male', 'Idol - Pop rock music'),
                                                                                (11, 'New York , USA', 'Elvis', 'Male', 'Presley'),
                                                                                (14, 'Chicago, USA', 'Milles', 'Male', 'Davis'),
                                                                                (20, 'Paris, France', 'Jean Luc', 'Male', 'Ponty');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
