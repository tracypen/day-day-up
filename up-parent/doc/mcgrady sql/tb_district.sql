/*
Navicat MySQL Data Transfer

Source Server         : MySql-localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-10-25 17:54:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_district
-- ----------------------------
DROP TABLE IF EXISTS `tb_district`;
CREATE TABLE `tb_district` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `name` varchar(60) NOT NULL,
  `parent_code` varchar(10) DEFAULT NULL,
  `parent_codes` varchar(50) DEFAULT NULL,
  `is_show` tinyint(1) NOT NULL DEFAULT '1',
  `is_leaf` tinyint(1) DEFAULT '1' COMMENT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_district
-- ----------------------------
INSERT INTO `tb_district` VALUES ('1', '00', '全国', '', null, '1', '0');
INSERT INTO `tb_district` VALUES ('2', '100000', '陕西省', '00', '00', '1', '1');
INSERT INTO `tb_district` VALUES ('3', '110000', '河南省', '00', '00', '1', '1');
INSERT INTO `tb_district` VALUES ('4', '120000', '北京市', '00', '00', '1', '1');
INSERT INTO `tb_district` VALUES ('5', '100100', '西安市', '100000', '00.100000', '1', '1');
INSERT INTO `tb_district` VALUES ('6', '100200', '咸阳市', '100000', '00.100000', '1', '1');
INSERT INTO `tb_district` VALUES ('7', '110100', '郑州市', '110000', '00.110000', '1', '1');
INSERT INTO `tb_district` VALUES ('8', '110200', '菏泽市', '110000', '00.110000', '1', '1');
INSERT INTO `tb_district` VALUES ('9', '110300', '新郑市', '110000', '00.110000', '1', '1');
INSERT INTO `tb_district` VALUES ('10', '110400', '洛阳市', '110000', '00.110000', '1', '1');
INSERT INTO `tb_district` VALUES ('11', '110500', '三门峡市', '110000', '00.110000', '1', '1');
INSERT INTO `tb_district` VALUES ('12', '110600', '安阳市', '110000', '00.110000', '1', '1');
INSERT INTO `tb_district` VALUES ('13', '100400', '安康市', '100000', '00.100000', '1', '1');
INSERT INTO `tb_district` VALUES ('14', '100500', '延安市', '100000', '00.100000', '1', '1');
INSERT INTO `tb_district` VALUES ('15', '100600', '榆林市', '100000', '00.100000', '1', '1');
INSERT INTO `tb_district` VALUES ('16', '100700', '汉中市', '100000', '00.100000', '1', '1');
INSERT INTO `tb_district` VALUES ('17', '100800', '渭南市', '100000', '00.100000', '1', '1');
INSERT INTO `tb_district` VALUES ('18', '100900', '临潼市', '100000', '00.100000', '1', '1');
INSERT INTO `tb_district` VALUES ('19', '101000', '宝鸡市', '100000', '00.100000', '1', '1');
INSERT INTO `tb_district` VALUES ('20', '100201', '武功县', '100200', '00.100000.100200', '1', '1');
INSERT INTO `tb_district` VALUES ('21', '100202', '乾县', '100200', '00.100000.100200', '1', '1');
INSERT INTO `tb_district` VALUES ('22', '100203', '旬邑县', '100200', '00.100000.100200', '1', '1');
INSERT INTO `tb_district` VALUES ('23', '100204', '淳化县', '100200', '00.100000.100200', '1', '1');
INSERT INTO `tb_district` VALUES ('24', '100205', '三原县', '100200', '00.100000.100200', '1', '1');
INSERT INTO `tb_district` VALUES ('26', '101001', '眉县', '101000', null, '1', '1');
