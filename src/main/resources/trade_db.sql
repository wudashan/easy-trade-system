/*
 Navicat Premium Data Transfer

 Source Server         : trade
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : trade_db

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 19/11/2017 23:45:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for trade
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exchange_rate` decimal(10,6) NOT NULL,
  `foreign_amount` decimal(10,3) NOT NULL,
  `foreign_amount_type` varchar(36) COLLATE utf8_bin NOT NULL,
  `foreign_trade_direction` varchar(255) COLLATE utf8_bin NOT NULL,
  `rmb_amount` decimal(10,3) NOT NULL,
  `status` varchar(255) COLLATE utf8_bin NOT NULL,
  `trade_id` char(36) COLLATE utf8_bin NOT NULL,
  `user_id` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_trade_id_user_id` (`trade_id`,`user_id`) USING BTREE,
  KEY `idx_trade_id_user_id_status` (`trade_id`,`user_id`,`status`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for trade_statistics
-- ----------------------------
DROP TABLE IF EXISTS `trade_statistics`;
CREATE TABLE `trade_statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,3) NOT NULL,
  `amount_type` varchar(36) COLLATE utf8_bin NOT NULL,
  `statistics_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
