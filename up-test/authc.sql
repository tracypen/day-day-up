#获取系统所有资源
select id, NAME, identity, url, parent_id, parent_ids, icon, weight, permissions, is_show, OWNER from t_resource order by weight asc ;

#获取系统所有操作权限
select id, NAME, permission, description, is_show from t_permission order by id ;

#获取某一用户的角色
 select * from t_auth where user_id = 148554;


#根据角色 ids 查询对应角色（包括对资源操作的权限集合）
SELECT
	r.id rid,
	r. NAME,
	r.role,
	r.description,
	r.is_show,
	p.id pid,
	p.role_id,
	p.resource_id,
	p.permission_ids
FROM
	t_role r
LEFT OUTER JOIN t_role_resource_permission p ON r.id = p.role_id
WHERE
	r.id IN (2,3,1050,1054)
