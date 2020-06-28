DROP DATABASE IF EXISTS `test-db`;
CREATE DATABASE IF NOT EXISTS `test-db`;
USE `test-db`;
create table org
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);
