drop database if exists sqldb4web;

create database sqldb4web;

use sqldb4web;

drop database if exists member;

create table member (
mno int not null auto_increment,
mid varchar(20) not null unique, 
mpw varchar(20) not null , 
mname varchar(20) not null , 
mphone varchar(20) not null unique,
primary key(mno)
);