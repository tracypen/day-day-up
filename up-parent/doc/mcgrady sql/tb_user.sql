/*
Navicat MySQL Data Transfer

Source Server         : MySql-localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-10-25 17:54:35
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
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1062 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1060', 'mcgrady', '51847b07cffbdbecaba808434d65e17b', 'eb7274bb42', '0245682819@163.com', '2', '1', '2017-09-12 17:38:50', '2017-10-25 17:48:49', '2017-09-06', '1', null, 'peng', 'peng', 'http://oxqtfspj0.bkt.clouddn.com/FkJt5fMKdu6QubwHtP0Zg9hYviIO', '2017-09-12 17:38:50', '1882594111');
INSERT INTO `tb_user` VALUES ('1061', 'youbatis', 'cde6b6103ba1e6846db382e1cf40bd8a', '06ea9a495f', '18802953162@163.com', '1', '1', '2017-10-16 10:55:02', null, '2017-10-16', '1', null, 'youbatis', 'youbatis', null, '2017-10-16 10:55:02', '18802953162');
