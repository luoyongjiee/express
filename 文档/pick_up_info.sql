/*
Navicat MySQL Data Transfer

Source Server         : 192.168.9.224
Source Server Version : 50622
Source Host           : 192.168.9.224:3306
Source Database       : zipkin

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2016-09-07 20:11:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pick_up_info
-- ----------------------------
DROP TABLE IF EXISTS `pick_up_info`;
CREATE TABLE `pick_up_info` (
  `id` int(11) DEFAULT NULL,
  `pick_up_id` int(11) DEFAULT NULL COMMENT 'pick_up表的主键',
  `express_code` varchar(50) DEFAULT NULL COMMENT '快递编号',
  `express` varchar(20) DEFAULT NULL COMMENT '快递',
  `count` int(11) DEFAULT NULL COMMENT '数目',
  `express_date` datetime DEFAULT NULL COMMENT '快递时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
