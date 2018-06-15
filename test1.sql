/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50087
Source Host           : localhost:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50087
File Encoding         : 65001

Date: 2018-06-10 09:42:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `need`
-- ----------------------------
DROP TABLE IF EXISTS `need`;
CREATE TABLE `need` (
  `nd_id` tinyint(4) NOT NULL auto_increment,
  `jgmc` varchar(50) collate utf8_unicode_ci default '',
  `txdz` varchar(50) collate utf8_unicode_ci default '',
  `dwwz` varchar(50) collate utf8_unicode_ci default '',
  `email` varchar(50) collate utf8_unicode_ci default '',
  `lxr` varchar(50) collate utf8_unicode_ci default '',
  `phone` varchar(50) collate utf8_unicode_ci default '',
  `cz` varchar(50) collate utf8_unicode_ci default '',
  `jgsx` varchar(50) collate utf8_unicode_ci default '',
  `jgjj` varchar(50) collate utf8_unicode_ci default '',
  `nd_name` varchar(50) collate utf8_unicode_ci default NULL,
  `nd_gs` varchar(50) collate utf8_unicode_ci default '',
  `keyw` varchar(50) collate utf8_unicode_ci default '',
  `yjlx` varchar(50) collate utf8_unicode_ci default '',
  `xkfl` varchar(50) collate utf8_unicode_ci default '',
  `ssly` varchar(50) collate utf8_unicode_ci default '',
  `yyhy` varchar(50) collate utf8_unicode_ci default '',
  `hzms` varchar(50) collate utf8_unicode_ci default '',
  `ztz` varchar(50) collate utf8_unicode_ci default '',
  `qyzc` varchar(50) collate utf8_unicode_ci default '',
  `yhdk` varchar(50) collate utf8_unicode_ci default NULL,
  `qtrz` varchar(50) collate utf8_unicode_ci default '',
  `nd_state` tinyint(4) default '1',
  PRIMARY KEY  (`nd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of need
-- ----------------------------
INSERT INTO `need` VALUES ('1', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'q', 'w', 'e', '实验发展', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', '2');
INSERT INTO `need` VALUES ('2', '1', 'z', 'n', '+', '+', '+', '+', '+', '+', '+', '+', '+', '研究发展', '+', '+', '+', '+', '+', '+', '\"', '\"', '1');
INSERT INTO `need` VALUES ('3', '', '', '', '', '', '', '', '', '机构简介（单位基本情况，研究基础等，限200字）', 'a', '重大科技需求概述（主要内容、技术指标、预期经济和社会效益等，限500字）', '', '实验发展', '', '', '', '', '', '', '', '', '1');
INSERT INTO `need` VALUES ('4', '', '', '', '', '', '', '', '企业,高等院校', '机构简介（单位基本情况，研究基础等，限200字）', 'a', '重大科技需求概述（主要内容、技术指标、预期经济和社会效益等，限500字）', '', '基础研究', '学科A', '', '', '', '', '', '', '', '3');
INSERT INTO `need` VALUES ('5', '总经理', '1', '1', '1', '1', '1', '1', '高等院校', '机构简介（单位基本情况，研究基础等，限200字）\r\n11', '1', '重大科技需求概述（主要内容、技术指标、预期经济和社会效益等，限500字）\r\n111', '1', '基础研究', '学科B', '', '', '独立开发', '1', '1', '1', '1', '3');
INSERT INTO `need` VALUES ('6', '中国建设银行', '石家庄', 'www.21', '123@qq.com', '史蒂夫', '15732135980', 'adsf', '企业', 'aaa', '生物制药', '制药', 'key', '基础研究', '学科C', '', '', '独立开发', '55', '55', '55', '55', '2');
INSERT INTO `need` VALUES ('7', '中国建设银行', '石家庄', '啊', '@qqcom', 'a ', '15732135980', 'a', '企业', 's', 'a', 'dd', 'key', '基础研究', '学科A', '', '', '技术转让', '', '', '', '', '2');
INSERT INTO `need` VALUES ('9', '中国建设银行', '河北省石家庄市', 'www.danwe.com', '1@qq.com', '张三', '15523124321', '86 519-85129131', '企业', '简介……', '软件开发', '预计竞经济', 'key', '基础研究', '学科C', '', '', '独立开发,技术入股', '5', '5', '5', '', '1');
INSERT INTO `need` VALUES ('10', '石家庄铁道大学', '石家庄铁道大学', 'www.stdu.com', '@123.com', '李四', '15321245214', '86 519-85129131', '企业', '简介……', '数学建模', '概述……', 'key', '应用研究', '', ',光机电一体化,新能源与高校节能技术', '教学', '独立开发,技术入股', '5', '5', '5', '5', '1');
INSERT INTO `need` VALUES ('11', '中国建设银行', '', '', '', '', '', '', '', '', 'aa', '', '', '应用研究', '', '', 'null', '', '', '', '', '', '1');
INSERT INTO `need` VALUES ('12', '中国建设银行', '', '', '', '', '', '', '', '', 'aaa', '', '', '研究发展', '', '', 'null', '', '', '', '', '', '1');
INSERT INTO `need` VALUES ('13', '中国建设银行', '', '', '', '', '', '', '', '', 'aaaa', '', '', '应用研究', '', '', 'null', '', '', '', '', '', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(50) collate utf8_unicode_ci NOT NULL,
  `password` varchar(50) collate utf8_unicode_ci default NULL,
  `phone` varchar(50) collate utf8_unicode_ci default NULL,
  `userid` varchar(50) collate utf8_unicode_ci default NULL,
  `workplace` varchar(50) collate utf8_unicode_ci default NULL,
  `institution` varchar(50) collate utf8_unicode_ci default NULL,
  `truename` varchar(50) collate utf8_unicode_ci default NULL,
  `id` int(11) NOT NULL,
  `name` varchar(255) collate utf8_unicode_ci default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('11', '123456', '15732135800', '130225199432193452', '所属单位', '河北省石家庄铁道大学', '啊啊', '0', null, null);
INSERT INTO `user` VALUES ('2', '2', '2', '2', '2', '2', '2', '0', null, null);
INSERT INTO `user` VALUES ('3', '3', '3', '3', '3', '3', '3', '0', null, null);
INSERT INTO `user` VALUES ('fdsgl', 'hanhan', '15732133353', '13112519941116141X', 'kjb', 'lkbl', 'kb', '0', null, null);
INSERT INTO `user` VALUES ('许磊', '1234567', '15732135980', '130225199912217765', '中国建设银行', '中国建设银行', '3', '0', null, null);
