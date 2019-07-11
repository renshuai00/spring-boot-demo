/*
Navicat MySQL Data Transfer

Source Server         : 59.208.245.176
Source Server Version : 100121
Source Host           : 59.208.245.176:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 100121
File Encoding         : 65001

Date: 2019-07-11 11:48:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `state` char(1) DEFAULT '1' COMMENT '数据状态。state=1 有效；state=0 无效。',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('70', 'renshuai', '26', '0', '2019-07-10 20:54:31');
INSERT INTO `t_users` VALUES ('71', 'renshuai', '26', '0', '2019-07-10 20:58:42');
INSERT INTO `t_users` VALUES ('72', 'renshuai', '26', '0', '2019-07-10 20:58:56');
INSERT INTO `t_users` VALUES ('73', 'renshuai', '26', '0', '2019-07-10 20:59:12');
INSERT INTO `t_users` VALUES ('74', 'renshuai4', '25', '1', '2019-07-10 21:13:54');
INSERT INTO `t_users` VALUES ('75', 'renshuai5', '25', '1', '2019-07-10 21:41:20');
INSERT INTO `t_users` VALUES ('76', 'renshuai3', '25', '1', '2019-07-10 21:45:52');
INSERT INTO `t_users` VALUES ('77', 'renshuai3', '25', '1', '2019-07-11 10:21:58');
INSERT INTO `t_users` VALUES ('78', 'renshuai3', '25', '1', '2019-07-11 11:40:10');
