/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-13 22:57:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `tb_dictionary`;
CREATE TABLE `tb_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `description` longtext,
  `name` varchar(100) DEFAULT NULL,
  `sequence` int(11) DEFAULT '0',
  `dict_type` varchar(100) NOT NULL DEFAULT '0',
  `del_flag` tinyint(1) DEFAULT '0',
  `parent_id` bigint(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ah1isfy5alow4rtkty9vri85r` (`code`),
  KEY `FKnd95at2xgu5eb9http5x3jdk` (`parent_id`),
  CONSTRAINT `tb_dictionary_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `tb_dictionary` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1022 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_dictionary
-- ----------------------------
INSERT INTO `tb_dictionary` VALUES ('1', '101', '', '男', '0', '1001', '0', null);
INSERT INTO `tb_dictionary` VALUES ('2', '102', '', '女', '0', '1001', '0', null);
INSERT INTO `tb_dictionary` VALUES ('3', '0', '', '未删除', '0', '1002', '0', null);
INSERT INTO `tb_dictionary` VALUES ('4', '1', '', '已删除', '0', '1002', '0', null);
