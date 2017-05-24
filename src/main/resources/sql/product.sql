/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50551
Source Host           : localhost:3306
Source Database       : db1st

Target Server Type    : MYSQL
Target Server Version : 50551
File Encoding         : 65001

Date: 2017-02-24 17:50:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL COMMENT '产品名',
  `description` varchar(2550) DEFAULT NULL COMMENT '产品描述',
  `img01` varchar(255) DEFAULT NULL COMMENT '产品图片',
  `img02` varchar(255) DEFAULT NULL COMMENT '产品图片',
  `img03` varchar(255) DEFAULT NULL COMMENT '产品图片',
  `img04` varchar(255) DEFAULT NULL COMMENT '产品图片',
  `img05` varchar(255) DEFAULT NULL COMMENT '产品图片',
  `price` int(11) DEFAULT '0' COMMENT '单价',
  `currency` varchar(5) DEFAULT '￥' COMMENT '货币单位',
  `type` varchar(25) DEFAULT NULL COMMENT '产品类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
