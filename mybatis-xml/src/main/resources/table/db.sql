CREATE database data_center DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci

CREATE TABLE `sys_user`  (
  `key_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_uuid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `update_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`key_id`) USING BTREE,
  UNIQUE INDEX `index_1`(`user_uuid`) USING BTREE,
  INDEX `index_2`(`user_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `sys_user_auth`  (
  `key_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_uuid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `expired_account` int(1) DEFAULT NULL COMMENT '账户是否过期(0未过期、1已过期)',
  `expired_password` int(1) DEFAULT NULL COMMENT '密码是否过期(0未过期、1已过期)',
  `locked` int(1) DEFAULT NULL COMMENT '账户是否锁定(0未锁定、1已锁定)',
  `enabled` int(1) DEFAULT NULL COMMENT '账户是否激活(0未激活、1已激活)',
  PRIMARY KEY (`key_id`) USING BTREE,
  UNIQUE INDEX `index_1`(`user_uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `sys_role`  (
  `key_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_uuid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `roleName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `createTime` datetime(0) DEFAULT NULL,
  `updateTime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`key_id`) USING BTREE,
  UNIQUE INDEX `index_1`(`roleUuid`) USING BTREE,
  INDEX `index_2`(`enabled`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `sys_user_role_rel`  (
  `key_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userUuid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `roleUuid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`key_id`) USING BTREE,
  UNIQUE INDEX `index_1`(`userUuid`) USING BTREE,
  UNIQUE INDEX `index_2`(`roleUuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `sys_privilege`  (
  `key_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `privilegeUuid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `privilegeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `privilegeUrl` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `createTime` datetime(0) DEFAULT NULL,
  `updateTime` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`key_id`) USING BTREE,
  UNIQUE INDEX `index_1`(`privilegeUuid`) USING BTREE,
  INDEX `index_2`(`enabled`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `sys_role_privilege_rel`;
CREATE TABLE `sys_role_privilege_rel`  (
  `key_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleUuid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `privilegeUuid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`key_id`) USING BTREE,
  UNIQUE INDEX `index_1`(`roleUuid`) USING BTREE,
  UNIQUE INDEX `index_2`(`privilegeUuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
