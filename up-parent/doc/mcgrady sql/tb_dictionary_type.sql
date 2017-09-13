/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-13 22:57:40
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hrpfljty1s5rqoii84gwvtscw` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2007 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of tb_dictionary_type
-- ----------------------------
INSERT INTO `tb_dictionary_type` (code,description,name,del_flag) VALUES ( '10101', '', '性别', '0');
INSERT INTO `tb_dictionary_type` (code,description,name,del_flag) VALUES ( '10102', '', '删除状态', '0');
INSERT INTO `tb_dictionary_type` (code,description,name,del_flag) VALUES ( '21001', '测试', 'MINGZI', '0');
