drop database if exists PracticaProgramaciónRuben;
CREATE DATABASE if not exists PracticaProgramaciónRuben;
USE PracticaProgramaciónRuben;

create table if not exists Autor
(	
	numAutor int,
	nombre varchar(30),
	ape1 varchar(30),
	ape2 varchar(30),
    numLibros int,
    
    constraint pk_Autor primary key (numAutor)
);

create table if not exists Editorial
(
	numEditorial int,
	nombre varchar(30),
	numTotalLibros int,
    
    constraint pk_Editorial primary key (numEditorial)
);

create table if not exists Libro
(
    isbn varchar(20),
    titulo varchar(30),
    genero varchar(30),
    numEditorial int,
    numAutor int,
    
    constraint pk_Libro primary key (isbn),
    
    constraint fk_Libro_Autor foreign key (numAutor)
    references Autor(numAutor) on delete no action on update cascade,
    
    constraint fk_Libro_Editorial foreign key (numEditorial)
    references Editorial(numEditorial) on delete no action on update cascade
);

select * from Autor;
select * from Editorial;
select * from Libro;