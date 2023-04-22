create database capstone;

use capstone;

create table travels
(id int NOT NULL auto_increment primary key,
name char(30),
age int,
dateofboard date,
origin char(30),
destination char(30),
pickuppoint char(50),
fairprice int,
distance int,
AC char(5)
);

desc travels;

select * from travels;

drop table travels;

truncate table travels;