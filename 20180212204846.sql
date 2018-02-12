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
BEGIN;
LOCK TABLES `mysql`.`account` WRITE;
DELETE FROM `mysql`.`account`;
INSERT INTO `mysql`.`account` (`id`,`money`,`description`,`flag`,`userId`,`date`) VALUES (1, 10, '烫头', 1, 1, '2018-02-09'),(2, 20, '充值', 0, 1, '2018-02-07'),(3, 40, '充值', 0, 1, '2018-02-06'),(4, 30, '充值', 0, 1, '2018-02-04'),(5, 20, '理发', 1, 1, '2018-02-06'),(6, 20, '理发', 1, 1, '2018-02-14'),(7, 30, '充值', 0, 1, '2018-02-19'),(8, 10, '染头', 1, 1, '2017-12-20'),(9, 20, '按摩', 1, 1, '2017-11-14'),(10, 20, '充值', 0, 1, '2016-05-23'),(11, 40, '洗头', 1, 1, '2017-01-03');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `mysql`.`customer` WRITE;
DELETE FROM `mysql`.`customer`;
INSERT INTO `mysql`.`customer` (`id`,`username`,`sex`,`phone`) VALUES (1, '卫源', 0, '15234832667'),(2, '马中杰', 1, '1'),(3, '马乐', 1, '2'),(4, '刘蕊', 1, '3'),(5, '王怡舒', 1, '4'),(6, '王雯雯', 1, '5'),(7, '李倩', 1, '6'),(8, '里佳莹', 1, '7'),(9, '张小娜', 1, '8'),(10, '刘琬', 1, '9'),(11, '郭思维', 1, '10'),(12, '陈卓然', 1, '11'),(13, '毛效军', 1, '12'),(14, '李倩茹', 1, '13'),(15, '张辉', 1, '14'),(16, '石磊', 0, '5'),(17, '刘波', 0, '5'),(18, '刘群', 0, '151'),(19, '鹏鹏', 0, '153'),(20, '崔健', 0, '12434'),(50, '李茉芳', 1, '15231565156');
UNLOCK TABLES;
COMMIT;
