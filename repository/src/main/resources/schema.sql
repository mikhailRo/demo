DROP DATABASE IF EXISTS `testdb`;
CREATE DATABASE IF NOT EXISTS `testdb`;
USE `testdb`;
create table org
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);
