drop database if exists sqldb4web;

create database sqldb4web;

use sqldb4web;

drop database if exists member;

create table member (
mno int not null auto_increment,
mid varchar(20) not null unique, 
mpw varchar(20) not null , 
mname varchar(20) not null , 
mphone varchar(20) not null unique,
primary key(mno)
);

drop table if exists board;
create table board(
   bno      int auto_increment,      # 정수, 자동번호 부여
    btitle   varchar(50) not null,   # 문자50, 공백 불가 
    bcontent longtext,            # 긴글[4G]
    bdate datetime default now(),   # 날짜/시간, 기본값을 레코드삽입기준 자동 
    bview int default 0,         # 정수, 기본값을 0
    mno int,                  # 작성자의 회원번호 [ 작성자의 식별번호 ]
    primary key(bno),            # 제약조건 [ PK ]
   foreign key(mno) references member(mno) on delete cascade    # 회원탈퇴[PK레코드 삭제] 되면 FK의 레코드 값이 같이 삭제
);



drop table if exists message;
create table message (
pno int not null auto_increment,
psender int not null,
ptaker int not null,
pcontent varchar(100) not null,
pdate datetime default now(),
preply varchar(100) ,
primary key (pno),
foreign key(ptaker) references member(mno),
foreign key(psender) references member (mno)

);