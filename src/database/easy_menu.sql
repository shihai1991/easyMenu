/*
SQLyog Ultimate v11.27 (64 bit)
MySQL - 5.5.35-log : Database - easy_menu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`easy_menu` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `easy_menu`;

/*Table structure for table `sys_resources` */

DROP TABLE IF EXISTS `sys_resources`;

CREATE TABLE `sys_resources` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `text` varchar(45) DEFAULT NULL COMMENT '标题',
  `type` varchar(45) DEFAULT NULL COMMENT '资源类型',
  `url` varchar(100) DEFAULT NULL COMMENT 'URL',
  `parentid` int(11) DEFAULT NULL COMMENT '父ID',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `icon` varchar(100) DEFAULT NULL COMMENT '标志图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_resources` */

insert  into `sys_resources`(`id`,`text`,`type`,`url`,`parentid`,`remark`,`status`,`icon`) values (100,'firstLevelMenu1','user','#',NULL,'icon information could see the font-awesome o','use','icon-cogs'),(110,'firstLevelMenu2','user','#',NULL,NULL,'use','icon-user'),(120,'firstLevelMenu3','user','#',NULL,NULL,'use','icon-bar-chart'),(130,'firstLevelMenu4','user','#',NULL,NULL,'use','icon-desktop'),(10001,'SecondLevelMenu11','user','#',100,NULL,'use','icon-cog'),(10002,'SecondLevelMenu12','user','#',100,NULL,'use','icon-cog'),(11001,'SecondLevelMenu21','user','#',110,NULL,'use','icon-wrench'),(12001,'SecondLevelMenu31','user','#',120,NULL,'use','icon-bar-chart'),(13001,'SecondLevelMenu41','user','#',130,NULL,'use','icon-time'),(13002,'SecondLevelMenu42','user','#',130,NULL,'use','icon-time');

/*Table structure for table `sys_roles_resources` */

DROP TABLE IF EXISTS `sys_roles_resources`;

CREATE TABLE `sys_roles_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `rid` int(11) DEFAULT NULL COMMENT '角色ID',
  `resid` int(11) DEFAULT NULL COMMENT '资源ID',
  `organization_id` int(11) DEFAULT NULL COMMENT '组织ID',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_10` (`rid`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`rid`) REFERENCES `sys_roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `sys_roles_resources` */

insert  into `sys_roles_resources`(`id`,`rid`,`resid`,`organization_id`,`status`) values (1,1,10001,NULL,'normal'),(2,1,10002,NULL,'normal'),(3,1,11001,NULL,'normal'),(4,1,12001,NULL,'normal'),(5,1,13001,NULL,'normal'),(6,1,13002,NULL,'normal');

/*Table structure for table `sys_users_roles` */

DROP TABLE IF EXISTS `sys_users_roles`;

CREATE TABLE `sys_users_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uid` int(11) DEFAULT NULL COMMENT '用户ID',
  `rid` int(11) DEFAULT NULL COMMENT '角色ID',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_9` (`rid`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`rid`) REFERENCES `sys_roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_users_roles` */

insert  into `sys_users_roles`(`id`,`uid`,`rid`,`status`) values (1,1,1,'normal');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
