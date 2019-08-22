create database phc;
use phc;
create table member(
	id varchar(20) primary key,
	pwd varchar(20),
	name varchar(20),
	height int(20),
	weight int(20),
	age int(10),
	gender char(10),
	gcal int(20),
	gdate int(20),
	main int(20),
	gkg int(20)
);

ALTER TABLE member change gkg lkcal int;

create table diet(
	did int(10) primary key,
	dname varchar(20),
	dcal int(10),
	carb int(10),
	prot int(10),
	fat int(10)
);
drop table mydiet;
create table mydiet(
	mydid int(10) primary key auto_increment,
	id varchar(20),
	date date,
	amount int(20),
	did	int(10),
	time int(10),
	foreign key (id) references member(id),
	foreign key (did) references diet(did)
);

insert into mydiet values(last_insert_id()+1,'test','2019-08-19',3,3,0);

create table exercise(
	eid	int(10) primary key auto_increment,
	ename varchar(20),
	kind char(10),
	contents varchar(1000),
	img	varchar(30),
	eCal int(10)
);

create table MyExer(
	myeid int(10) primary key auto_increment,
	id varchar(20),
	date date,
	amount int(20),
	eid int(10),
	result boolean,
	foreign key (id) references member(id),
	foreign key (eid) references exercise(eid)
);




