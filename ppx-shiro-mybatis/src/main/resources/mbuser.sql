create table 'mb_user' (
    'id' bigint(20) not null auto_increment,
    'username' varchar(50) not null,
    'password' varchar(32) not null,
    'phone' varchar(20) default null,
    'email' varchar(50) default null,
    'created' datetime not null,
    'update' datetime not null,
    primary key ('id'),
    unique key 'username' ('username') using btree,
    unique key 'phone' ('phone') using btree,
    unique key 'email' ('email') using btree)
    engine=InnoDB AUTO_INCREMENT=37 default CHARSET=utf8;



select * from mb_user;
