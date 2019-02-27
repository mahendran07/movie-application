create table moviedetail
(id int,
name VARCHAR2(50) NOT NULL, constraint pk_movie_id PRIMARY KEY(id));

create table theaterdetail
(id int,
name VARCHAR2(50) NOT NULL,
place VARCHAR2(60) NOT NULL,
amount NUMBER(10) NOT NULL, constraint pk_theater_id PRIMARY KEY(id));

create table movieintheater
(id int,
theaterid int,
movieid int,
show VARCHAR2(20) NOT NULL,
showdate Date NOT NULL, constraint pk_movietheater_id PRIMARY KEY(id),
constraint fk_theater_id FOREIGN KEY (theaterid) REFERENCES theaterdetail(id),
constraint fk_movie_id FOREIGN KEY (movieid) REFERENCES moviedetail(id));

desc moviedetail;

desc theaterdetail;

desc movieintheater;

create sequence seq_movie_id 
start with 1
increment by 1;

create sequence seq_theater_id
start with 1
increment by 1;

create sequence seq_movietheater_id
start with 1
increment by 1;

create table register
(id int,
name VARCHAR2(30) NOT NULL,
email VARCHAR2(35) NOT NULL,
phonenumber NUMBER(10),
password VARCHAR2(30), constraint pk_register_id PRIMARY KEY(id));

create sequence seq_register_id
start with 1
increment by 1;

ALTER TABLE movieintheater ADD total_ticket NUMBER(10);