/*
MySQL Data Transfer
Source Host: localhost
Source Database: tianshanghotel
Target Host: localhost
Target Database: tianshanghotel
Date: 2018/11/5 ����һ ���� 10:59:16
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(50) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
CREATE TABLE `customer` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `cardid` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `startTime` timestamp NULL DEFAULT NULL,
  `endTime` timestamp NULL DEFAULT NULL,
  `roomid` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for depts
-- ----------------------------
CREATE TABLE `depts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `parentId` int(11) DEFAULT NULL COMMENT '上级部门',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- ----------------------------
-- Table structure for emp
-- ----------------------------
CREATE TABLE `emp` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employeeid` int(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `age` int(20) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `addr` varchar(100) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for room
-- ----------------------------
CREATE TABLE `room` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `roomid` int(20) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for room_customer
-- ----------------------------
CREATE TABLE `room_customer` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `customerid` int(20) NOT NULL,
  `roomid` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐  密码加密时前缀，使加密后的值不同',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `valid` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常  默认值 ：1',
  `deptId` int(11) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '4ebd394fbd25e495e0753a7dc9889a8e', '7adb778c-e7d3-4dd3-a3c5-5f80a158006d');
INSERT INTO `customer` VALUES ('1', '6546546', '张三1', '546546', '2018-09-05 11:30:44', '2018-09-05 11:30:44', '101');
INSERT INTO `customer` VALUES ('2', '654654654', '李四', '6546546', '2018-09-04 10:48:31', '2018-09-12 10:48:33', '101');
INSERT INTO `customer` VALUES ('3', '1', 'ssafa1', '1', '2018-02-01 02:01:00', '2018-02-01 02:01:00', '101');
INSERT INTO `depts` VALUES ('2', 'dept-a', null, '1', 'dept-a ..', '2018-04-19 18:59:09', '2018-04-19 18:59:09', 'admin', 'admin');
INSERT INTO `depts` VALUES ('3', 'dept-b', null, '2', '1111', '2018-04-19 19:15:05', '2018-04-19 19:15:05', null, null);
INSERT INTO `depts` VALUES ('4', 'dept-aa', '2', '1', '', '2018-04-22 18:10:58', '2018-04-22 22:11:47', null, null);
INSERT INTO `emp` VALUES ('2', '2132123', 'ssafa', '13', '11', '1', '2112');
INSERT INTO `emp` VALUES ('3', '2132123', 'ssafa111', '13', '11', '1', '1');
INSERT INTO `room` VALUES ('1', '101', '单人间', '200', '1', '2018-09-05 11:35:09');
INSERT INTO `room` VALUES ('2', '102', '双人间', '350', '1', '2018-04-19 18:59:09');
INSERT INTO `room_customer` VALUES ('2', '2', '102');
INSERT INTO `room_customer` VALUES ('9', '1', '101');
INSERT INTO `users` VALUES ('1', 'admin', '4ebd394fbd25e495e0753a7dc9889a8e', '7adb778c-e7d3-4dd3-a3c5-5f80a158006d', 'admin@t.cn', '13624356789', '1', '3', null, '2018-08-31 16:10:32', null, 'admin');
INSERT INTO `users` VALUES ('2', 'zhangli', 'bdcf69375bdb532e50279b91eb00940d', '5e7cbd36-e897-4951-b42b-19809caf3caa', 'zhangli@t.cn', '13678909876', '0', '3', '2017-07-18 10:01:51', '2018-04-22 20:49:19', null, 'admin');
INSERT INTO `users` VALUES ('3', 'wangke', 'c5dc32ec66041aeddf432b3146bd2257', '5e3e1475-1ea9-4a6a-976e-b07545827139', 'wangke@t.cn', '18678900987', '1', '3', '2017-07-18 11:40:53', '2018-04-22 20:48:52', null, null);
INSERT INTO `users` VALUES ('4', 'zhangql', '+HBpqtPuj9KLBIpneR5X0A==', 'ed487fac-9952-45c9-acaa-21dab9c689cc', 'zhangql@t.cn', '13678909876', '1', '2', '2017-07-18 12:17:30', '2018-04-22 20:48:04', null, null);
INSERT INTO `users` VALUES ('5', 'fanwei', '1acab7425d6dfae670f26bd160518902', '34fbedb2-e135-4f8d-b595-24360edc348d', 'fanwei@t.cn', '13876545678', '1', '3', '2017-07-20 17:03:22', '2018-04-22 20:47:49', null, null);
INSERT INTO `users` VALUES ('6', 'wumei', '431ebdcccf3404787a144f9ba669a8e2', '8a14f46f-7a17-4dfe-85ab-08e63cb618ce', 'wumei@t.cn', '13567898765', '1', '2', '2017-07-21 10:57:40', '2018-04-22 20:46:49', null, null);
INSERT INTO `users` VALUES ('7', 'user-003', '689c673a0d8bda7ee795dd45a126ae96', '3faa1d2b-a99f-4ffb-9d29-0e71563258af', 't@t.com', '123', '1', '3', '2018-01-12 23:19:58', '2018-04-22 20:46:07', null, 'admin');
INSERT INTO `users` VALUES ('9', 'user-002', 'e10adc3949ba59abbe56e057f20f883e', null, 't@t.com', '123', '1', '3', '2018-01-12 23:20:31', '2018-04-22 20:45:55', null, null);
INSERT INTO `users` VALUES ('12', 'user-001', '5bf6593afd106aa544000d559f0c2241', '9528e727-2901-4746-8558-9010d9607da2', 't@t.com', '123', '1', '3', '2018-01-13 01:48:32', '2018-04-22 20:45:37', null, null);
INSERT INTO `users` VALUES ('13', 'user-c', '2630d8bd50c76abf001a9daceeae97e6', '30fff766-e245-4a93-9f5e-6eb2c2cec494', 't@t.com', '123456', '0', '3', '2018-01-13 02:01:56', '2018-04-22 20:43:58', null, 'admin');
INSERT INTO `users` VALUES ('15', 'user-b', '2ce586af95c6431112092f653659c85f', 'eaedbaee-d760-40e4-b71e-ccecf01b6187', 't@t.com', '123456', '1', '3', '2018-01-13 02:02:06', '2018-04-22 20:54:10', null, 'admin');
INSERT INTO `users` VALUES ('16', 'user-a', '710058cf374a38d76510d009f63bf28d', 'e8e35b96-bbdd-4090-81ee-b71a36141760', '1@t.com', '121212', '1', '2', '2018-04-22 19:43:11', '2018-09-03 17:24:15', null, 'admin');
INSERT INTO `users` VALUES ('20', '哈工大', '64c140ec40345f58463950bf1c549478', '794277e7-c52b-46ef-9b2b-0828703eccbc', '', '', '1', null, '2018-09-04 20:28:33', '2018-09-04 20:28:33', null, null);
INSERT INTO `users` VALUES ('21', '杨帆', '64025851ab74e3299ca68172d5be499b', 'd7a88e9b-9584-4aa5-b988-cbc2fc7ca5f2', 'yf@com', '123564565898', '1', null, '2018-09-04 20:43:19', '2018-09-04 20:43:19', null, null);
