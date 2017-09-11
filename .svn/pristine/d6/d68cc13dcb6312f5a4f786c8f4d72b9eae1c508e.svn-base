/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50551
Source Host           : localhost:3306
Source Database       : db1st

Target Server Type    : MYSQL
Target Server Version : 50551
File Encoding         : 65001

Date: 2017-02-24 17:50:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(55) DEFAULT NULL COMMENT '新闻标题',
  `tag` varchar(25) DEFAULT NULL COMMENT '标签',
  `content` varchar(12550) DEFAULT NULL COMMENT '文章内容',
  `img` varchar(255) DEFAULT NULL COMMENT '文章图片地址',
  `author` varchar(25) DEFAULT NULL COMMENT '作者',
  `create_time` varchar(25) DEFAULT NULL COMMENT '创作时间',
  `views` int(11) DEFAULT '2017' COMMENT '阅读人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
