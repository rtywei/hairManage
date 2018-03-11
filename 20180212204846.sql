/*
MySQL Backup
Database: mysql
Backup Time: 2018-02-12 20:48:48
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `mysql`.`account`;
DROP TABLE IF EXISTS `mysql`.`customer`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `money` double(255,0) NOT NULL,
  `description` varchar(255) COLLATE utf8_bin NOT NULL,
  `flag` int(255) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ' ',
  `username` varchar(255) CHARACTER SET utf8 NOT NULL,
  `sex` int(255) DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

