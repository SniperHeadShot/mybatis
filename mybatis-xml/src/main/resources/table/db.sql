create database mybatis default character set utf8 collate utf8_general_ci

use mybatis;

CREATE TABLE `sys_privilege` (
  `keyId` bigint(20) NOT NULL AUTO_INCREMENT,
  `privilegeUuid` varchar(32) DEFAULT NULL,
  `privilegeName` varchar(50) DEFAULT NULL,
  `privilegeUrl` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`keyId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role` (
  `keyId` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleUuid` varchar(32) DEFAULT NULL,
  `roleName` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`keyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role_privilege_rel` (
  `keyId` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleUuid` varchar(32) DEFAULT NULL,
  `privilegeUuid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`keyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user` (
  `keyId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userUuid` varchar(32) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`keyId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user_role_rel` (
  `keyId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userUuid` varchar(32) DEFAULT NULL,
  `roleUuid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`keyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;