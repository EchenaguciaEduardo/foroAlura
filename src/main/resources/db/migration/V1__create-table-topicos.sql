create table topics(
    id bigint not null auto_increment,
    tittle varchar(100) not null unique,
    message varchar(100) not null unique,
    create_date datetime not null,
    status varchar(50) not null,
    author varchar(100) not null,
    course varchar(100) not null,

    primary key(id)
);
