/*
Navicat MySQL Data Transfer

Source Server         : mysql-connection
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : myjava

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2016-07-04 23:06:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `money` int(255) DEFAULT NULL,
  `accountName` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1000', '张三', '1');
INSERT INTO `account` VALUES ('1', '李四', '2');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('Jack1', '8881', '1');
INSERT INTO `admin` VALUES ('Jack2', '8882', '2');
INSERT INTO `admin` VALUES ('Jack3', '8883', '3');
INSERT INTO `admin` VALUES ('Jack4', '8884', '4');
INSERT INTO `admin` VALUES ('Jack5', '8885', '5');
INSERT INTO `admin` VALUES ('Jack6', '8886', '6');
INSERT INTO `admin` VALUES ('Jack7', '8887', '7');
INSERT INTO `admin` VALUES ('Jack8', '8888', '8');
INSERT INTO `admin` VALUES ('Jack9', '8889', '9');
INSERT INTO `admin` VALUES ('Jack10', '88810', '10');
INSERT INTO `admin` VALUES ('Jack11', '88811', '11');
INSERT INTO `admin` VALUES ('Jack12', '88812', '12');
INSERT INTO `admin` VALUES ('Jack13', '88813', '13');
INSERT INTO `admin` VALUES ('Jack14', '88814', '14');
INSERT INTO `admin` VALUES ('Jack15', '88815', '15');
INSERT INTO `admin` VALUES ('Jack16', '88816', '16');
INSERT INTO `admin` VALUES ('Jack17', '88817', '17');
INSERT INTO `admin` VALUES ('Jack18', '88818', '18');
INSERT INTO `admin` VALUES ('Jack19', '88819', '19');
INSERT INTO `admin` VALUES ('Jack20', '88820', '20');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '王五', '男');
INSERT INTO `student` VALUES ('2', '王小', '男');
INSERT INTO `student` VALUES ('3', '张三', '男');
INSERT INTO `student` VALUES ('4', '李四', '女');
INSERT INTO `student` VALUES ('5', '李小小', '女');
INSERT INTO `student` VALUES ('8', '黄河', '男');
INSERT INTO `student` VALUES ('7', '李小子', '男');
INSERT INTO `student` VALUES ('9', '长江', '男');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Procedure structure for pro_findById
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_findById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_findById`(IN `sid` int)
BEGIN
	#Routine body goes here...
	select * from student WHERE id=sid;
END
;;
DELIMITER ;
