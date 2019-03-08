create table moviedetail
(id int,
name VARCHAR2(50) NOT NULL, constraint pk_movie_id PRIMARY KEY(id));

ALTER TABLE moviedetail MODIFY id NUMBER(10);

create table theaterdetail
(id int,
name VARCHAR2(50) NOT NULL,
place VARCHAR2(60) NOT NULL,
amount NUMBER(10) NOT NULL, constraint pk_theater_id PRIMARY KEY(id));

ALTER TABLE theaterdetail MODIFY id NUMBER(10);

create table movieintheater
(id int,
theaterid int,
movieid int,
show VARCHAR2(20) NOT NULL,
showdate Date NOT NULL, constraint pk_movietheater_id PRIMARY KEY(id),
constraint fk_theater_id FOREIGN KEY (theaterid) REFERENCES theaterdetail(id),
constraint fk_movie_id FOREIGN KEY (movieid) REFERENCES moviedetail(id));

ALTER TABLE movieintheater MODIFY id NUMBER(10);

ALTER TABLE movieintheater MODIFY theaterid NUMBER(10);

ALTER TABLE movieintheater MODIFY movieid NUMBER(10);

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

ALTER TABLE register MODIFY id NUMBER(10);

create sequence seq_register_id
start with 1
increment by 1;

drop sequence seq_register_id;
ALTER TABLE movieintheater ADD total_ticket NUMBER(10);

select * from moviedetail;

commit;

select * from theaterdetail;

delete from theaterdetail;

ALTER TABLE register ADD status int DEFAULT 0;

desc register;

select * from register;

desc register;

delete from register;

select * from movieintheater;

desc movieintheater;

delete from movieintheater;
commit;

insert into register(id,name,email,phonenumber,password,status)VALUES(seq_register_id.NEXTVAL,'Mahendran','mahesh22696@gmail.com',8098355378,'Mahe$22',1);

select * from register;

select status from register where email='mahesh22696@gmail.com' and password='Mahe$22';

select name,email,phonenumber from register where name='mahesh' and email='mahesh@gmail.com' and phonenumber=9943029823;

delete from register where id=3;

desc register;

delete from theaterdetail;

select * from moviedetail;

select * from theaterdetail;

select * from movieintheater;

select theaterid,show,showdate,total_ticket from movieintheater where movieid=2;

commit;

ALTER TABLE theaterdetail ADD screen int; 

ALTER TABLE theaterdetail DROP COLUMN screen;

CREATE TABLE theaterscreen
(id int,
theaterid int,
screen int,
totalseats int,
availabledate Date,constraint pk_theaterscreen_id PRIMARY KEY(id),
constraint fk_theaterscreen_id FOREIGN KEY (theaterid) REFERENCES theaterdetail(id));

ALTER TABLE theaterscreen MODIFY id NUMBER(10);

ALTER TABLE theaterscreen MODIFY theaterid NUMBER(10);

ALTER TABLE theaterscreen MODIFY screen NUMBER(10);

ALTER TABLE theaterscreen MODIFY totalseats NUMBER(10);


desc theaterscreen;

desc register;

desc moviedetail;

desc theaterdetail;

desc movieintheater;

desc theaterscreen;

select * from theaterdetail;

commit;

ALTER TABLE theaterdetail DROP COLUMN amount;

ALTER TABLE theaterdetail ADD ownername VARCHAR2(40) NOT NULL;

desc register;

desc moviedetail;

desc theaterdetail;

desc movieintheater;

ALTER TABLE movieintheater DROP COLUMN total_ticket;

ALTER TABLE movieintheater ADD screen_no VARCHAR2(30) NOT NULL;

ALTER TABLE movieintheater ADD amount NUMBER(10) NOT NULL;

desc register;

desc moviedetail;

desc theaterdetail;

desc theaterscreen;

desc movieintheater;

ALTER TABLE theaterscreen MODIFY screen VARCHAR2(20) NOT NULL;

ALTER TABLE theaterscreen MODIFY totalseats NUMBER(10);

desc theaterscreen;

ALTER TABLE theaterscreen MODIFY screen VARCHAR2(20);

ALTER TABLE theaterscreen DROP COLUMN availabledate;

create sequence seq_theaterscreen_id
start with 1
increment by 1;
drop sequence seq_theaterscreen_id;
commit;
delete from theaterscreen;

select * from theaterscreen;

desc movieintheater;

desc theaterscreen;

ALTER TABLE theaterscreen MODIFY screen VARCHAR2(20) UNIQUE;

ALTER TABLE movieintheater ADD FOREIGN KEY(screen_no) REFERENCES theaterscreen(screen);

desc movieintheater;

select * from movieintheater;
commit;
delete from movieintheater where id = 26;

select * from moviedetail;

select * from theaterdetail;

select id,theaterid,show,showdate,screen_no,amount from movieintheater where movieid=1;

select * from register;

select * from theaterscreen;

desc theaterscreen;

select * from user_cons_columns where table_name='THEATERSCREEN';

ALTER TABLE theaterscreen DROP CONSTRAINT SYS_C004136;

select * from user_cons_columns where table_name='MOVIEINTHEATER';

ALTER TABLE MOVIEINTHEATER DROP CONSTRAINT SYS_C004137;

commit;

select * from movieintheater;

UPDATE theaterscreen SET screen='screen-1' WHERE theaterid=55;

delete from movieintheater where id=34;

ALTER TABLE register MODIFY password VARCHAR2(30) NOT NULL;

ALTER TABLE register MODIFY phonenumber NUMBER(10) NOT NULL;

ALTER TABLE register MODIFY status NUMBER(1) DEFAULT 0;

select * from register;

insert into register(id,name,email,phonenumber,password,status)VALUES(seq_register_id.NEXTVAL,'Mahendran','mahesh22696@gmail.com',8098355378,'Mahe$22',1);
commit;
desc moviedetail;
desc theaterdetail;
desc movieintheater;
desc theaterscreen;
select * from movieintheater;
select * from register;
select * from theaterdetail;
select * from theaterscreen;

select td.name as theartername,md.name as moviename,mt.show as shows,mt.showdate as showdate,mt.screen_no as screen_no,ts.totalseats as seats,mt.amount as amount from movieintheater mt
join theaterdetail td on td.id=theaterid
join moviedetail md on md.id=movieid
join theaterscreen ts on ts.theaterid=mt.THEATERID;



select td.id as id,td.name as theatername,td.place as theaterplace,md.name as moviename,mt.show as shows,mt.showdate as showdate,mt.screen_no as screen_no,ts.totalseats as seats,mt.amount as amount from movieintheater mt
join theaterdetail td on td.id=theaterid
join moviedetail md on md.id=movieid
join theaterscreen ts on ts.theaterid=mt.THEATERID where theaterid=55 and movieid=81;

desc register;
desc moviedetail;
desc theaterdetail;
desc movieintheater;
desc theaterscreen;

select * from moviedetail;
select * from movieintheater;
select * from theaterscreen;
select * from theaterdetail;

delete from moviedetail;

delete from movieintheater;

delete from theaterdetail;

delete from theaterscreen;

commit;



desc register;

desc moviedetail;

desc theaterdetail;

desc theaterscreen;













