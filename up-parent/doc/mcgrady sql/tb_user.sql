/*
Navicat MySQL Data Transfer

Source Server         : MySql-localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-12 17:44:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '用户名',
  `password` varchar(60) DEFAULT NULL COMMENT '密码',
  `salt` varchar(60) DEFAULT NULL COMMENT '加密盐',
  `email` varchar(50) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `active` tinyint(4) DEFAULT '1',
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `lastLoginTime` datetime DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `status` tinyint(4) DEFAULT '1',
  `nickname` varchar(50) DEFAULT NULL,
  `userRealName` varchar(50) DEFAULT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `modify_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1027 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1003', 'admin', '41cf29348ee71a60c9e7e025e63784d5', '374956983b', 'admin@163.com', '2', '1', '2017-09-12 17:19:19', '2017-09-12 17:40:25', '2017-09-12', '1', null, 'hao', '1315774565', null, '2017-09-12 17:19:19');
INSERT INTO `tb_user` VALUES ('1017', '0mcgrady1', '51847b07cffbdbecaba808434d65e17b', 'eb7274bb42', '0245682819@163.com', '1', '1', '2017-09-12 17:38:50', null, '2017-09-12', '1', null, 'peng', '18802953162', null, '2017-09-12 17:38:50');
INSERT INTO `tb_user` VALUES ('1018', '1mcgrady1', '4b15cbbf7bea4d2c56e61100e2fc8601', 'a2421f55df', '1245682819@163.com', '1', '1', '2017-09-12 17:38:50', null, '2017-09-12', '1', null, 'peng', '18802953162', null, '2017-09-12 17:38:50');
INSERT INTO `tb_user` VALUES ('1019', '2mcgrady1', 'd8e2baba9d84d36349b1b55a9be1fa3e', '85c4d234d6', '2245682819@163.com', '1', '1', '2017-09-12 17:38:50', null, '2017-09-12', '1', null, 'peng', '18802953162', null, '2017-09-12 17:38:50');
INSERT INTO `tb_user` VALUES ('1020', '3mcgrady1', '0310c775fb0575ea87c6a4279d97ea38', '6478fad21b', '3245682819@163.com', '1', '1', '2017-09-12 17:38:50', null, '2017-09-12', '1', null, 'peng', '18802953162', null, '2017-09-12 17:38:50');
INSERT INTO `tb_user` VALUES ('1021', '4mcgrady1', '51d3d3f3d80a15a003a3df3c2783c7bf', 'a0d55f0943', '4245682819@163.com', '1', '1', '2017-09-12 17:38:50', null, '2017-09-12', '1', null, 'peng', '18802953162', null, '2017-09-12 17:38:50');
