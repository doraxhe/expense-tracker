drop database expense_tracker_db;
create database expense_tracker_db;
use expense_tracker_db;
show tables;

create table expenses (id bigint not null, name varchar(255), amount float(0), category varchar(255), description varchar(255), user_id bigint, primary key (id));
create table hibernate_sequences (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name));
insert into hibernate_sequences(sequence_name, next_val) values ('default',0);
create table name (id bigint not null, first_name varchar(255), middle_name varchar(255), last_name varchar(255), primary key (id));
create table user (id bigint not null, name_id bigint, primary key (id));

select * from expenses;
select * from user;
select * from name;







