create database mybatis default character set utf8 collate utf8_general_ci

use mybatis;

create table `country`
(
    `id`          int          not null auto_increment,
    `countryName` varchar(100) null,
    `countryCode` varchar(20)  null,
    primary key (`id`)
)

insert into country (`countryName`, `countryCode`)
values ('中国', 'CN'),
       ('美国', 'US'),
       ('俄罗斯', 'RU'),
       ('英国', 'GB'),
       ('法国', 'FR');