/*
Navicat MySQL Data Transfer

Source Server         : MySql-localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-27 18:00:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_system_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_log`;
CREATE TABLE `tb_system_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `module` varchar(200) DEFAULT NULL,
  `description` longtext,
  `content` longtext,
  `ip` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `del_flag` int(11) DEFAULT '0',
  `modify_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `response_time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_system_log
-- ----------------------------
INSERT INTO `tb_system_log` VALUES ('8', 'mcgrady', '系统字典数据', '删除数据字典', '[类名]:com.hp.up.business.service.impl.DictionaryServiceImpl,[方法]:deleteById,[参数]:4,[IP]:192.168.2.48', '192.168.2.48', '2017-09-27 15:11:00', '0', '2017-09-27 15:11:00', null);
INSERT INTO `tb_system_log` VALUES ('9', 'mcgrady', '系统字典数据', '删除数据字典', '[类名]:com.hp.up.business.service.impl.DictionaryServiceImpl,[方法]:deleteById,[参数]:3,[IP]:0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2017-09-27 17:40:21', '0', '2017-09-27 17:40:21', null);
