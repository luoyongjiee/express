/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50172
Source Host           : localhost:3306
Source Database       : express

Target Server Type    : MYSQL
Target Server Version : 50172
File Encoding         : 65001

Date: 2016-09-26 23:28:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(200) DEFAULT NULL COMMENT '用户的唯一标识',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机',
  `building_num` varchar(2) DEFAULT NULL COMMENT '宿舍栋数',
  `building_code` varchar(10) DEFAULT NULL COMMENT '宿舍号',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `nickname` varchar(200) DEFAULT NULL COMMENT '昵称',

  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
