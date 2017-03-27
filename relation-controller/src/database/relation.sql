/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.16-log : Database - relation
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`relation` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `relation`;

/*Table structure for table `append` */

DROP TABLE IF EXISTS `append`;

CREATE TABLE `append` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

/*Data for the table `append` */

insert  into `append`(`id`,`description`,`create_date`) values (48,'测试一','2017-03-19 12:15:06'),(49,'测试二','2017-03-19 12:21:16'),(50,'测试三','2017-03-19 13:02:36'),(51,'罗二傻','2017-03-22 11:41:06'),(52,'add','2017-03-22 11:51:18'),(53,'少年英雄罗二傻','2017-03-22 13:00:29'),(54,'少年英雄罗二傻2','2017-03-22 13:10:26'),(55,'罗三傻','2017-03-22 16:27:56'),(56,'罗五傻','2017-03-23 09:31:23'),(57,'罗六傻','2017-03-23 09:44:31'),(58,'罗六傻','2017-03-23 10:15:36'),(59,'罗七傻','2017-03-23 10:25:59'),(60,'螺丝刀','2017-03-23 10:33:39');

/*Table structure for table `rs_account` */

DROP TABLE IF EXISTS `rs_account`;

CREATE TABLE `rs_account` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `balance` decimal(20,2) DEFAULT NULL,
  `accumulat_increase` decimal(20,2) DEFAULT NULL,
  `accumulat_decrease` decimal(20,2) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_date` datetime DEFAULT NULL,
  `operater` varchar(255) DEFAULT NULL,
  `last_balance` decimal(20,2) DEFAULT NULL,
  `rs_name` varchar(255) DEFAULT NULL,
  `re_num` varchar(255) DEFAULT NULL,
  `version` int(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `spell` varchar(255) DEFAULT NULL,
  `first_spell` varchar(255) DEFAULT NULL,
  `personMark` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1' COMMENT 'true',
  `operateAmount` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8;

/*Data for the table `rs_account` */

insert  into `rs_account`(`id`,`balance`,`accumulat_increase`,`accumulat_decrease`,`create_date`,`modify_date`,`operater`,`last_balance`,`rs_name`,`re_num`,`version`,`description`,`spell`,`first_spell`,`personMark`,`status`,`operateAmount`) values (1,'462.00','462.00',NULL,'2017-03-22 13:15:52','2017-03-23 11:16:17',NULL,'451.00','田七',NULL,NULL,'少年英雄罗二傻2','tianqi','TQ',NULL,NULL,NULL),(2,'710.00','710.00',NULL,'2017-03-23 09:47:26','2017-03-23 11:16:20',NULL,'688.00','罗二他妹',NULL,NULL,'罗六傻','luoertamei','LETM',NULL,NULL,'123.00'),(3,'234.00','234.00',NULL,'2017-03-23 09:55:07',NULL,NULL,NULL,'张三',NULL,NULL,'罗六傻','zhangsan','ZS',NULL,NULL,'234.00'),(4,'124.00','124.00',NULL,'2017-03-23 09:55:07',NULL,NULL,NULL,'王五',NULL,NULL,'罗六傻','wangwu','WW',NULL,NULL,'124.00'),(169,'55.00','55.00',NULL,'2017-03-19 13:03:01','2017-03-19 13:19:46',NULL,'33.00','张三',NULL,NULL,'测试三','zhangsan','ZS','张三',0,NULL),(170,'44.00','44.00',NULL,'2017-03-19 13:03:01',NULL,NULL,NULL,'李四',NULL,NULL,'测试三','lisi','LS','李四',0,NULL),(171,'55.00','55.00',NULL,'2017-03-19 13:03:01',NULL,NULL,NULL,'王五',NULL,NULL,'测试三','wangwu','WW','王五',0,NULL);

/*Table structure for table `transaction_flow` */

DROP TABLE IF EXISTS `transaction_flow`;

CREATE TABLE `transaction_flow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rs_name` varchar(255) DEFAULT NULL,
  `rs_num` int(11) DEFAULT NULL,
  `operateAmount` decimal(20,2) DEFAULT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` varchar(255) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rs_relation_transaction_fk` (`rs_num`),
  CONSTRAINT `rs_relation_transaction_fk` FOREIGN KEY (`rs_num`) REFERENCES `rs_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `transaction_flow` */

insert  into `transaction_flow`(`id`,`rs_name`,`rs_num`,`operateAmount`,`date_create`,`description`,`status`) values (1,'田七',1,'11.00','2017-03-23 15:46:21','少年英雄罗二傻2',1),(2,'田七',1,'11.00','2017-03-22 17:16:45','少年英雄罗二傻2',1),(3,'田七',1,'11.00','2017-03-22 17:18:51','少年英雄罗二傻2',1),(4,'田七',1,'44.00','2017-03-22 17:24:11','罗三傻',1),(5,'田七',1,'77.00','2017-03-22 17:58:37','罗三傻',1),(7,'田七',1,'33.00','2017-03-23 09:47:23','罗六傻',1),(8,'罗二他妹',2,'123.00','2017-03-23 09:47:28','罗六傻',1),(9,'田七',1,'33.00','2017-03-23 09:55:07','罗六傻',1),(10,'罗二他妹',2,'222.00','2017-03-23 09:55:07','罗六傻',1),(11,'张三',3,'234.00','2017-03-23 09:55:07','罗六傻',1),(12,'王五',4,'124.00','2017-03-23 09:55:07','罗六傻',1),(15,'田七',1,'33.00','2017-03-23 10:16:06','罗六傻',1),(16,'罗二他妹',2,'123.00','2017-03-23 10:16:06','罗六傻',1),(17,'田七',1,'11.00','2017-03-23 10:26:17','罗七傻',1),(18,'罗二他妹',2,'22.00','2017-03-23 10:26:17','罗七傻',1),(19,'田七',1,'11.00','2017-03-23 10:34:07','螺丝刀',1),(20,'罗二他妹',2,'44.00','2017-03-23 10:34:13','螺丝刀',1),(21,'田七',1,'11.00','2017-03-23 10:36:02','螺丝刀',1),(22,'罗二他妹',2,'44.00','2017-03-23 10:36:05','螺丝刀',1),(23,'田七',1,'11.00','2017-03-23 10:38:33','螺丝刀',1),(24,'罗二他妹',2,'44.00','2017-03-23 10:38:34','螺丝刀',1),(25,'田七',1,'11.00','2017-03-23 10:50:41','罗七傻',1),(26,'罗二他妹',2,'22.00','2017-03-23 10:50:45','罗七傻',1),(27,'田七',1,'11.00','2017-03-23 10:53:33','罗七傻',1),(28,'罗二他妹',2,'22.00','2017-03-23 10:53:37','罗七傻',1),(29,'田七',1,'11.00','2017-03-23 11:08:49','罗七傻',1),(30,'罗二他妹',2,'22.00','2017-03-23 11:08:49','罗七傻',1),(31,'田七',1,'11.00','2017-03-23 11:16:18','罗七傻',1),(32,'罗二他妹',2,'22.00','2017-03-23 11:16:21','罗七傻',1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `passWord` varchar(255) DEFAULT NULL,
  `actualName` varchar(255) DEFAULT NULL,
  `valid` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
