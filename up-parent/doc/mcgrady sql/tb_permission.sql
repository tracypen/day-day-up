/*
Navicat MySQL Data Transfer

Source Server         : MySql-localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-12 17:43:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `name` varchar(255) NOT NULL COMMENT '权限名字',
  `permission` varchar(255) NOT NULL COMMENT '权限key',
  `description` varchar(255) DEFAULT NULL COMMENT '上级权限',
  `is_show` tinyint(1) NOT NULL DEFAULT '0' COMMENT '权限排序',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`permission`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
