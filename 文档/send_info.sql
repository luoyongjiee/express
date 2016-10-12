/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50172
Source Host           : localhost:3306
Source Database       : express

Target Server Type    : MYSQL
Target Server Version : 50172
File Encoding         : 65001

Date: 2016-09-26 23:24:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for send_info
-- ----------------------------
DROP TABLE IF EXISTS `send_info`;
CREATE TABLE `send_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `sender_name` varchar(20) DEFAULT NULL COMMENT '寄件人姓名',
  `sender_phone` varchar(20) DEFAULT NULL COMMENT '寄件人电话',
  `sender_room_num` varchar(10) DEFAULT NULL COMMENT '寄件人宿舍号',
  `sender_builder_num` varchar(10) DEFAULT NULL COMMENT '寄件人宿舍栋数',
  `receiver_name` varchar(20) DEFAULT NULL COMMENT '收件人姓名',
  `receiver_phone` varchar(20) DEFAULT NULL COMMENT '收件人电话',
  `receiver_address` varchar(100) DEFAULT NULL COMMENT '收件人地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;
