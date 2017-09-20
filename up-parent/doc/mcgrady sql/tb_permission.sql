/*
Navicat MySQL Data Transfer

Source Server         : MySql-localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mcgrady

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-20 17:49:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `name` varchar(255) NOT NULL COMMENT '权限名字',
  `permission` varchar(255) NOT NULL COMMENT '权限key',
  `description` varchar(255) DEFAULT NULL COMMENT '上级权限',
  `is_show` tinyint(1) NOT NULL DEFAULT '0' COMMENT '权限排序',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`permission`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission` VALUES ('0000000001', '查询', 'query', '条件查询权限', '1');
INSERT INTO `tb_permission` VALUES ('0000000002', '列表', 'list', '列表展示权限', '0');
INSERT INTO `tb_permission` VALUES ('0000000003', '创建', 'creat', '创建数据权限', '1');
INSERT INTO `tb_permission` VALUES ('0000000004', '修改', 'update', '修改数据权限', '0');
INSERT INTO `tb_permission` VALUES ('0000000005', '删除', 'delete', '删除数据权限', '0');
INSERT INTO `tb_permission` VALUES ('0000000006', '查看', 'view', '查看单调数据详情权限', '0');
INSERT INTO `tb_permission` VALUES ('0000000007', '下载', 'download', '下载权限', '0');
INSERT INTO `tb_permission` VALUES ('0000000008', '打印', 'print', '打印权限', '0');
INSERT INTO `tb_permission` VALUES ('0000000009', '导入', 'import', '导入权限', '0');
INSERT INTO `tb_permission` VALUES ('0000000010', '导出', 'export', '导出权限', '0');
