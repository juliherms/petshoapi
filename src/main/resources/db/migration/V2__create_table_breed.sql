create table TB_BREED (
      id bigint not null auto_increment,
      name varchar(30) not null,
      characteristics varchar(300) not null,
      primary key(id)
);

insert into TB_BREED values (1,'Akita','Leal,amigo e brincalhão');
insert into TB_BREED values (2,'Basset hound','Paciente,teimoso e charmoso');
insert into TB_BREED values (3,'Beagle','Alegre, companheiro e aventureiro');
insert into TB_BREED values (4,'Maltês','Gentil, brincalhão e afetuoso');
