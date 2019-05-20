/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : roompicker

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-05-20 07:09:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for guests
-- ----------------------------
DROP TABLE IF EXISTS `guests`;
CREATE TABLE `guests` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of guests
-- ----------------------------
INSERT INTO `guests` VALUES ('1', 'TuanAnh', 'A01');
INSERT INTO `guests` VALUES ('2', 'DucNguyen', 'A02');
INSERT INTO `guests` VALUES ('3', 'HoaHuong', 'A03');
INSERT INTO `guests` VALUES ('4', 'TuanAnh2', 'A04');
INSERT INTO `guests` VALUES ('5', 'DucNguyen', 'A05');
INSERT INTO `guests` VALUES ('6', 'HoaHuong', 'A06');

-- ----------------------------
-- Table structure for hosted_at
-- ----------------------------
DROP TABLE IF EXISTS `hosted_at`;
CREATE TABLE `hosted_at` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guest_id` int(11) DEFAULT NULL,
  `occupied_room_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hosted_at
-- ----------------------------

-- ----------------------------
-- Table structure for occupied_rooms
-- ----------------------------
DROP TABLE IF EXISTS `occupied_rooms`;
CREATE TABLE `occupied_rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `check_in` datetime DEFAULT NULL,
  `check_out` datetime DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `reservation_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of occupied_rooms
-- ----------------------------
INSERT INTO `occupied_rooms` VALUES ('1', '2019-05-12 13:16:50', null, '3', '1');
INSERT INTO `occupied_rooms` VALUES ('2', '2019-05-12 14:17:28', null, '4', '2');
INSERT INTO `occupied_rooms` VALUES ('3', '2019-05-12 13:00:54', null, '1', '3');

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_in` datetime DEFAULT NULL,
  `date_out` datetime DEFAULT NULL,
  `made_by` varchar(255) DEFAULT NULL,
  `guest_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES ('1', '2019-05-12 13:00:00', '2019-05-17 12:30:00', null, '1');
INSERT INTO `reservation` VALUES ('2', '2019-05-12 13:00:00', '2019-05-18 12:30:00', null, '2');
INSERT INTO `reservation` VALUES ('3', '2019-05-12 13:00:00', '2019-05-30 12:30:00', null, '3');

-- ----------------------------
-- Table structure for reserved_rooms
-- ----------------------------
DROP TABLE IF EXISTS `reserved_rooms`;
CREATE TABLE `reserved_rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number_of_room` int(11) DEFAULT NULL,
  `room_type_id` int(11) DEFAULT NULL,
  `reservation_id` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '0' COMMENT '0:pending,1:confirmed;2:canceled',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reserved_rooms
-- ----------------------------
INSERT INTO `reserved_rooms` VALUES ('1', '1', '2', '1', '1');
INSERT INTO `reserved_rooms` VALUES ('2', '1', '2', '2', '1');
INSERT INTO `reserved_rooms` VALUES ('3', '1', '1', '3', '1');

-- ----------------------------
-- Table structure for rooms
-- ----------------------------
DROP TABLE IF EXISTS `rooms`;
CREATE TABLE `rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '1' COMMENT 'on1,off0',
  `smoke` tinyint(4) DEFAULT '0' COMMENT '1yes,0no',
  `room_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbpj0f3wbck1eefnny9wyy5w1o` (`room_type_id`),
  CONSTRAINT `FKbpj0f3wbck1eefnny9wyy5w1o` FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rooms
-- ----------------------------
INSERT INTO `rooms` VALUES ('1', 'P01', '1', '1', null, '1');
INSERT INTO `rooms` VALUES ('2', 'P02', '2', '1', null, '1');
INSERT INTO `rooms` VALUES ('3', 'D01', '3', '1', null, '2');
INSERT INTO `rooms` VALUES ('4', 'D02', '4', '1', null, '2');
INSERT INTO `rooms` VALUES ('5', 'D03', '5', '1', null, '2');
INSERT INTO `rooms` VALUES ('6', 'D04', '6', '1', null, '2');
INSERT INTO `rooms` VALUES ('7', 'D05', '7', '1', null, '2');

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `max_capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_type
-- ----------------------------
INSERT INTO `room_type` VALUES ('1', 'premium', '2');
INSERT INTO `room_type` VALUES ('2', 'deluxe', '2');
