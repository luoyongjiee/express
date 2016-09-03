/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50172
Source Host           : localhost:3306
Source Database       : express

Target Server Type    : MYSQL
Target Server Version : 50172
File Encoding         : 65001

Date: 2016-09-03 14:30:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pick_up
-- ----------------------------
DROP TABLE IF EXISTS `pick_up`;
CREATE TABLE `pick_up` (
  `id` int(11) NOT NULL,
  `express` varchar(2) DEFAULT NULL COMMENT '快递',
  `count` int(11) DEFAULT NULL COMMENT '数目',
  `code` varchar(100) DEFAULT NULL COMMENT '编号',
  `pick_up_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
