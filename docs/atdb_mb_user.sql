create table  if not exists mb_user
(
    id       int auto_increment
        primary key,
    username varchar(32) null,
    password varchar(32) null,
    phone    varchar(64) null,
    email    varchar(64) null,
    created  datetime    not null,
    updated  datetime    not null,
    constraint mb_user_username_uindex
        unique (username)
);


INSERT INTO atdb.mb_user (id, username, password, phone, email, created, updated) VALUES (1, 'string', 'string', 'string', 'string', '2019-08-25 12:43:53', '2019-08-25 12:43:53');