/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50172
Source Host           : localhost:3306
Source Database       : express

Target Server Type    : MYSQL
Target Server Version : 50172
File Encoding         : 65001

Date: 2016-09-26 23:29:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pick_up_info
-- ----------------------------
DROP TABLE IF EXISTS `pick_up_info`;
CREATE TABLE `pick_up_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pick_up_id` int(11) DEFAULT NULL COMMENT 'pick_up表的主键',
  `express_code` varchar(50) DEFAULT NULL COMMENT '快递编号',
  `express` varchar(20) DEFAULT NULL COMMENT '快递',
  `count` int(11) DEFAULT NULL COMMENT '数目',
  `express_date` datetime DEFAULT NULL COMMENT '快递时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
