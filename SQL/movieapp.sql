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

ALTER TABLE register ADD status int DEFAULT 0;

//Admin can directly register with status 1.
insert into register(id,name,email,phonenumber,password,status)VALUES(seq_register_id.NEXTVAL,'Mahendran','mahesh22696@gmail.com',8098355378,'Mahe$22',1);

ALTER TABLE theaterdetail ADD screen int; 

ALTER TABLE theaterdetail DROP COLUMN screen;

CREATE TABLE theaterscreen
(id int,
theaterid int,
screen int,
totalseats int,
availabledate Date,constraint pk_theaterscreen_id PRIMARY KEY(id),
constraint fk_theaterscreen_id FOREIGN KEY (theaterid) REFERENCES theaterdetail(id));

ALTER TABLE theaterdetail DROP COLUMN amount;

ALTER TABLE theaterdetail ADD ownername VARCHAR2(40) NOT NULL;

ALTER TABLE movieintheater DROP COLUMN total_ticket;

ALTER TABLE movieintheater ADD screen_no VARCHAR2(30) NOT NULL;

ALTER TABLE movieintheater ADD amount NUMBER(10) NOT NULL;

ALTER TABLE theaterscreen MODIFY totalseats VARCHAR2(20);

ALTER TABLE theaterscreen MODIFY totalseats NUMBER(10);

ALTER TABLE theaterscreen MODIFY screen VARCHAR2(20);

ALTER TABLE theaterscreen DROP COLUMN availabledate;

create sequence seq_theaterscreen_id
start with 1
increment by 1;

ALTER TABLE theaterscreen MODIFY screen VARCHAR2(20) UNIQUE;

ALTER TABLE movieintheater ADD FOREIGN KEY(screen_no) REFERENCES theaterscreen(screen);

ALTER TABLE register MODIFY password VARCHAR2(30) NOT NULL;

ALTER TABLE register MODIFY phonenumber NUMBER(10) NOT NULL;

ALTER TABLE register MODIFY status NUMBER(1) DEFAULT 0;




