drop table if exists t_user;
drop table if exists t_resource;
drop table if exists t_role;

#用户表
create table t_user (
  id int auto_increment,
  username varchar(100),
  password varchar(100),
  nickname varchar(100),
  status boolean DEFAULT false,
  salt varchar(100),
  role_ids varchar(100),
  locked bool default false,
  constraint pk_t_user primary key(id)
) charset=utf8 ENGINE=InnoDB;

create unique index idx_t_user_username on t_user(username);

#角色表
create table t_role (
  id int auto_increment,
  name varchar(100),
  description varchar(100),
  resource_ids varchar(100),
  available bool default false,
  constraint pk_t_role primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_t_role_resource_ids on t_role(resource_ids);

#资源表
create table t_resource (
  id int auto_increment,
  name varchar(100),
  type varchar(50),
  url varchar(200),
  parent_id int,
  parent_ids varchar(100),
  permission varchar(100),
  available bool default false,
  level int,
  position int,
  constraint pk_t_resource primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_t_resource_parent_id on t_resource(parent_id);
create index idx_t_resource_parent_ids on t_resource(parent_ids);





