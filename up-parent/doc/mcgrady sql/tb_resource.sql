/*
Navicat MySQL Data Transfer

Source Server         : MySql-localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-12 17:43:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_resource
-- ----------------------------
DROP TABLE IF EXISTS `tb_resource`;
CREATE TABLE `tb_resource` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `identity` varchar(100) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `parent_ids` varchar(200) DEFAULT NULL,
  `icon` varchar(200) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `permissions` varchar(300) DEFAULT NULL,
  `is_show` tinyint(1) DEFAULT '1',
  `owner` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_resource
-- ----------------------------
