CREATE DATABASE server_template CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

use server_template;

create table t_template_user
(
    user_id varchar(64) default '' not null primary key ,
    info varchar(512) default '' not null comment '测试信息字段',
    created_time timestamp default now() not null comment '记录创建时间',
    updated_time timestamp default now() not null comment '记录更新时间',
    deleted bool default false not null comment '逻辑删除字段'
) comment '测试用户表'