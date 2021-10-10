create table TB_USER (
       id bigint not null auto_increment,
       email varchar(50) not null,
       name  varchar(50) not null,
       primary key (id)
);

insert into TB_USER values (1,'juliherms@gmail.com','juliherms');
insert into TB_USER values (2,'carlos@gmail.com','carlos');
insert into TB_USER values (3,'marcos@gmail.com','marcos');
insert into TB_USER values (4,'jose@gmail.com','jose');