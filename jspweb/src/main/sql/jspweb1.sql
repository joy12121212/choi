

drop database if exists jspweb;
create database jspweb;
use jspweb;
drop table if exists visitlog;
create table visitlog (
vno 		int auto_increment primary key,
writer		varchar(30) not null,
pw			varchar(10) not null,
content 	mediumtext not null,
date 		datetime default now()
);

select * from visitlog;



# 1. 저장 / insert / 레코드 추가
insert into visitlog(writer , pw , content ) values (?,?,?);

# 2. 호출

select * from visitlog order by date desc;


# 3. 수정 [ 필수 조건 : 누구 수정 ? ]

update visitlog set content = ? where vno = ? and pw = ?;

# 4. 삭제 [ 필수 조건 : 누구 삭제 ? ]

delete from visitlog; /* 모든 레코드 삭제 */

delete from visitlog where vno = 3 and pw = 1234; /* vno 가 3이고 pw가 1234 라면 삭제  */
delete from visitlog where vno = ? and pw = ?; /* vno 가 3이고 pw가 1234 라면 삭제  */




# ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ가계부 테이블 생성 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ #

use jspweb;

drop table if exists accountbook;
create table accountbook (
ano int auto_increment primary key , 
content text not null, 
money int not null, 
date date );


select * from accountbook;
# 등록
insert into accountbook(content , money , date) values ('1' , 1 , '2023-04-18');

# 출력
select * from accountbook order by date desc; # 최신 입력값 순서대로

# 수정
update accountbook set content = ? where ano = ?;

# 삭제
delete from accountbook where ano = ?;


#ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 회원가입 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

use jspweb;
drop table if exists member;

create table member (
	mno int auto_increment primary key,
    mid varchar(10) not null unique,
    mpwd varchar(20) not null,
    memail varchar(20) not null unique,
    mimg longtext 		# 프로밀 미등록시 기본 프로필 사용
);

select * from member;

# 회원가입
insert into member(mid , mpwd , memail , mimg) values (? , ? , ? ,?);
# 테스트 insert into member(mid , mpwd , memail , mimg) values ('회원가입' , '1234' , 'eee' ,'default');
# 출력
select * from member ;
# 수정
update member set mpwd = ?;
# 삭제
delete from memeber where mno = ?;

# 아이디 중복 검사 - 있다 없다 검사 // row 1
# select * from member where mid = 'asdf';
select * from member where mid = ?;
