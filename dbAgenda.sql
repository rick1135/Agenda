create database  dbAgenda;
use dbAgenda;

create table contato(
	idcontato int primary key auto_increment,
    nome varchar(50) not null,
    fone varchar(15) not null,
	email varchar(50)
);

/*CRUD CREATE */
insert into contato (nome, fone, email) values ('Alberto Henrique', '38991092834', 'rick1135@hotmail.com');

/* CRUD READ */
select * from contato;