/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-10-26 23:12:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_district
-- ----------------------------
DROP TABLE IF EXISTS `tb_district`;
CREATE TABLE `tb_district` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `parent_code` varchar(10) DEFAULT NULL,
  `parent_codes` varchar(50) DEFAULT NULL,
  `is_show` tinyint(1) DEFAULT '1',
  `is_leaf` tinyint(1) DEFAULT '1' COMMENT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_district
-- ----------------------------
INSERT INTO `tb_district` VALUES ('1', '00', '全国', '', null, '1', '0');
INSERT INTO `tb_district` VALUES ('2', '110000', '陕西省', '00', '00', '1', '1');
INSERT INTO `tb_district` VALUES ('3', '120000', '河南省', '00', '00', '1', '1');
INSERT INTO `tb_district` VALUES ('4', '130000', '北京市', '00', '00', '1', '1');
INSERT INTO `tb_district` VALUES ('5', '111100', '西安市', '110000', '00.100000', '1', '1');
INSERT INTO `tb_district` VALUES ('6', '111200', '咸阳市', '110000', '00.100000', '1', '1');
INSERT INTO `tb_district` VALUES ('7', '121100', '郑州市', '120000', '00.110000', '1', '1');
INSERT INTO `tb_district` VALUES ('8', '121200', '菏泽市', '120000', '00.110000', '1', '1');
INSERT INTO `tb_district` VALUES ('45', '131100', '朝阳区', '130000', null, '1', '1');
INSERT INTO `tb_district` VALUES ('48', '131200', '大山区', '130000', null, '1', '1');
INSERT INTO `tb_district` VALUES ('49', '140000', '江西省', '00', null, '1', '1');
INSERT INTO `tb_district` VALUES ('50', '141100', '上饶市', '140000', null, '1', '1');
INSERT INTO `tb_district` VALUES ('51', '141200', '九江市', '140000', null, '1', '1');
INSERT INTO `tb_district` VALUES ('52', '141111', '婺源县', '141100', null, '1', '1');
