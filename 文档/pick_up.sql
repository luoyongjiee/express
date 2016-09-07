/*
Navicat MySQL Data Transfer

Source Server         : 192.168.9.224
Source Server Version : 50622
Source Host           : 192.168.9.224:3306
Source Database       : zipkin

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2016-09-07 20:11:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pick_up
-- ----------------------------
DROP TABLE IF EXISTS `pick_up`;
CREATE TABLE `pick_up` (
  `id` int(11) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机',
  `building_num` varchar(2) DEFAULT NULL COMMENT '宿舍栋数',
  `building_code` varchar(10) DEFAULT NULL COMMENT '宿舍号',
  `create_time` datetime DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
