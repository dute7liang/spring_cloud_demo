/*
Navicat MySQL Data Transfer

Source Server         : duteliang
Source Server Version : 50724
Source Host           : 47.107.155.58:3306
Source Database       : dubbo_test

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-12-25 10:38:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_t
-- ----------------------------
DROP TABLE IF EXISTS `product_t`;
CREATE TABLE `product_t` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `num` int(11) DEFAULT NULL COMMENT '商品数量',
  `price` decimal(11,2) DEFAULT NULL COMMENT '商品价格',
  `type` int(11) DEFAULT NULL COMMENT '商品类型 0-水果 1-电子',
  `begin_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='产品表';
