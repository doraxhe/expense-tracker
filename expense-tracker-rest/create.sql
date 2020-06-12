create table expenses (id bigint not null, amount float(0), category varchar(255), description varchar(255), name varchar(255), user_id bigint, primary key (id))
create table hibernate_sequences (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name))
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
create table name (id bigint not null, first_name varchar(255), last_name varchar(255), middle_name varchar(255), primary key (id))
create table user (id bigint not null, name_id bigint, primary key (id))
alter table if exists expenses add constraint FK2qife4sxyeoi1kwgvg769ks8y foreign key (user_id) references user
alter table if exists user add constraint FK8rnruj5hoj6iui6bhpul0f90b foreign key (name_id) references name
