/*
Navicat MySQL Data Transfer

Source Server         : MySql-localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-12 17:43:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(255) NOT NULL COMMENT '角色名字',
  `role` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `is_show` tinyint(4) DEFAULT NULL,
  `role_type` varchar(10) DEFAULT NULL,
  `parent_id` varchar(10) DEFAULT NULL,
  `parent_ids` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('0000000001', '管理员', 'admin', '系统管理员', '1', null, null, null);
INSERT INTO `tb_role` VALUES ('0000000002', '测试角色', 'sys_admin', '测试', '1', null, null, null);
