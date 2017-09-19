/*
Navicat MySQL Data Transfer

Source Server         : MySql-localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-19 18:02:17
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
INSERT INTO `tb_resource` VALUES ('1', '系统资源', null, null, '0', '0/', null, '0', null, '1', null);
INSERT INTO `tb_resource` VALUES ('2', '系统管理', 'system', '', '1', '0/1/', null, null, null, '1', null);
INSERT INTO `tb_resource` VALUES ('3', '用户管理', 'system_user', 'system/user', '2', '0/1/2/', null, null, null, '1', null);
