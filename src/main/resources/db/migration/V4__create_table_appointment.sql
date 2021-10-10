create table TB_APPOINTMENT (
       id bigint not null auto_increment,
       create_date datetime not null,
       user_id bigint not null,
       pet_id bigint not null,
       scheduled_date datetime not null,
       annotation varchar(3000),
       primary key (id),
       foreign key(user_id) references TB_USER(id),
       foreign key(pet_id) references TB_PET(id)

);

insert into TB_APPOINTMENT values(1,now(),1,1,now(),'teste');