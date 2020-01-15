create database mybatis default character set utf8 collate utf8_general_ci

use mybatis;

create table `sys_user`
(
    `keyId`      bigint not null auto_increment,
    `userUuid`   varchar(32),
    `username`   varchar(50),
    `password`   varchar(50),
    `email`      varchar(50),
    `phone`      varchar(50),
    `extInfo`    text,
    `img`        varchar(50),
    `createTime` varchar(20),
    `updateTime` varchar(20),
    primary key (`keyId`)
);

create table `sys_role`
(
    `keyId`      bigint not null auto_increment,
    `roleUuid`   varchar(32),
    `roleName`   varchar(50),
    `createTime` varchar(20),
    `updateTime` varchar(20),
    primary key (`keyId`)
);

create table `sys_privilege`
(
    `keyId`         bigint not null auto_increment,
    `privilegeUuid` varchar(32),
    `privilegeName` varchar(50),
    `privilegeUrl`  varchar(50),
    `createTime`    varchar(20),
    `updateTime`    varchar(20),
    primary key (`keyId`)
);

create table `sys_user_role_rel`
(
    `keyId`    bigint not null auto_increment,
    `userUuid` varchar(32),
    `roleUuid` varchar(32),
    primary key (`keyId`)
);

create table `sys_role_privilege_rel`
(
    `keyId`         bigint not null auto_increment,
    `roleUuid`      varchar(32),
    `privilegeUuid` varchar(32),
    primary key (`keyId`)
);