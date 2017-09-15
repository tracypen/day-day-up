/*
Navicat MySQL Data Transfer

Source Server         : MySql-localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-15 17:46:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_dictionary_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_dictionary_type`;
CREATE TABLE `tb_dictionary_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(20) NOT NULL,
  `description` longtext,
  `name` varchar(100) DEFAULT NULL,
  `del_flag` tinyint(1) DEFAULT '0',
  `is_fixed` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hrpfljty1s5rqoii84gwvtscw` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2010 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of tb_dictionary_type
-- ----------------------------
INSERT INTO `tb_dictionary_type` VALUES ('2007', '1001', '', '性别', '0', '1');
INSERT INTO `tb_dictionary_type` VALUES ('2008', '1002', '', '删除状态', '0', '1');
INSERT INTO `tb_dictionary_type` VALUES ('2009', '1003', '测试', '测试', '0', '1');
