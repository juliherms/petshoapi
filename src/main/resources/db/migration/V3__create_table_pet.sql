create table TB_PET (
    id bigint not null auto_increment,
    name varchar(30) not null,
    tutor_id bigint not null,
    breed_id bigint not null,
    primary key(id),
    foreign key(tutor_id) references TB_USER(id),
    foreign key(breed_id) references TB_BREED(id)
);

insert into TB_PET values(1,'Fred',1,4);