/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50172
Source Host           : localhost:3306
Source Database       : express

Target Server Type    : MYSQL
Target Server Version : 50172
File Encoding         : 65001

Date: 2016-10-16 22:21:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pick_up
-- ----------------------------
DROP TABLE IF EXISTS `pick_up`;
CREATE TABLE `pick_up` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机',
  `building_num` varchar(2) DEFAULT NULL COMMENT '宿舍栋数',
  `building_code` varchar(10) DEFAULT NULL COMMENT '宿舍号',
  `create_time` datetime DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `pay_status` varchar(255) DEFAULT NULL COMMENT '0:未支付 1：已支付',
  `money` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
