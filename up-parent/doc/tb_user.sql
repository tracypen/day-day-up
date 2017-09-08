/*
Navicat MySQL Data Transfer

Source Server         : MySql-localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-08 17:30:26
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
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1000', 'mcgrady', '81255cb0dca1a5f304328a70ac85dcbd', '123456', 'mcgrady@163.com', '1', '1', '2017-09-08 10:55:25', '2017-09-08 15:38:51', '2017-09-05', '1', 'mcgrady', '路人甲', '123456789', null, '2017-09-08 10:56:09');
INSERT INTO `tb_user` VALUES ('1001', 'admin', '81255cb0dca1a5f304328a70ac85dcbd', '123456', 'admin@163.com', '2', '1', '2017-09-08 17:23:16', null, '2017-09-08', '1', null, 'hao', '1315774565', null, '2017-09-08 17:23:16');
INSERT INTO `tb_user` VALUES ('1002', 'admin1', '81255cb0dca1a5f304328a70ac85dcbd', '123456', 'admin@163.com', '2', '1', '2017-09-08 17:26:07', null, '2017-09-08', '1', null, 'hao', '1315774565', null, '2017-09-08 17:26:07');
