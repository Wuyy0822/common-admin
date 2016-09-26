DELIMITER ;
delete from t_user;
delete from t_role;
delete from t_resource;

insert into t_user values(1,'admin','d3c59d25033dbf980d29554025c23a75','admin',false,'8d78869f470951332959580424d4bf4f', '1', false);
insert into t_resource values(1, '资源', 'menu', '', 0, '0/', '', true);

insert into t_resource values(11, '组织机构管理', 'menu', '/organization', 1, '0/1/', 'organization:*', true);
insert into t_resource values(12, '组织机构新增', 'button', '', 11, '0/1/11/', 'organization:create', true);
insert into t_resource values(13, '组织机构修改', 'button', '', 11, '0/1/11/', 'organization:update', true);
insert into t_resource values(14, '组织机构删除', 'button', '', 11, '0/1/11/', 'organization:delete', true);
insert into t_resource values(15, '组织机构查看', 'button', '', 11, '0/1/11/', 'organization:view', true);

insert into t_resource values(21, '用户管理', 'menu', '/user', 1, '0/1/', 'user:*', true);
insert into t_resource values(22, '用户新增', 'button', '', 21, '0/1/21/', 'user:create', true);
insert into t_resource values(23, '用户修改', 'button', '', 21, '0/1/21/', 'user:update', true);
insert into t_resource values(24, '用户删除', 'button', '', 21, '0/1/21/', 'user:delete', true);
insert into t_resource values(25, '用户查看', 'button', '', 21, '0/1/21/', 'user:view', true);

insert into t_resource values(31, '资源管理', 'menu', '/resource', 1, '0/1/', 'resource:*', true);
insert into t_resource values(32, '资源新增', 'button', '', 31, '0/1/31/', 'resource:create', true);
insert into t_resource values(33, '资源修改', 'button', '', 31, '0/1/31/', 'resource:update', true);
insert into t_resource values(34, '资源删除', 'button', '', 31, '0/1/31/', 'resource:delete', true);
insert into t_resource values(35, '资源查看', 'button', '', 31, '0/1/31/', 'resource:view', true);

insert into t_resource values(41, '角色管理', 'menu', '/role', 1, '0/1/', 'role:*', true);
insert into t_resource values(42, '角色新增', 'button', '', 41, '0/1/41/', 'role:create', true);
insert into t_resource values(43, '角色修改', 'button', '', 41, '0/1/41/', 'role:update', true);
insert into t_resource values(44, '角色删除', 'button', '', 41, '0/1/41/', 'role:delete', true);
insert into t_resource values(45, '角色查看', 'button', '', 41, '0/1/41/', 'role:view', true);

insert into t_role values(1, 'admin', '超级管理员', '11,21,31,41', true);