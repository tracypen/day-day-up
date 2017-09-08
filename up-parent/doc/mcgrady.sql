drop table if exists tb_user;

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
  id                   int not null auto_increment comment '主键',
  name                 VARCHAR(30) comment '用户名',
  password             VARCHAR(60) comment '密码',
  salt                 VARCHAR(60) comment '加密盐',
  email                VARCHAR(50),
  gender               tinyint,
  active               tinyint,
  createDate           datetime default CURRENT_TIMESTAMP,
  lastLoginTime        datetime,
  birthday             date,
  status               tinyint,
  nickname             VARCHAR(50),
  userRealName         VARCHAR(50),
  qq                   VARCHAR(15),
  avatar               VARCHAR(255),
  modify_date          datetime default CURRENT_TIMESTAMP,
  primary key (id)
)
  auto_increment = 1000;

alter table tb_user comment '用户表';




