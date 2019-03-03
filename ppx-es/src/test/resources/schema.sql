create table es_user
(
  id bigint auto_increment
    primary key,
  avatar varchar(255) null,
  create_time datetime null,
  email varchar(255) null,
  last_login_name datetime null,
  last_update_time datetime null,
  name varchar(255) null,
  password varchar(255) null,
  phone_number varchar(255) null,
  status int not null
)
;

