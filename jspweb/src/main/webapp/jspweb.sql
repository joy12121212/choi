


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




use jspweb;
drop table if exists member;

create table member (
	mno int auto_increment primary key,		-- 회원번호
    mid varchar(10) not null unique,		-- 회원 id 중복 불가 , 공백 불가
    mpwd varchar(20) not null,				-- 공백 불가
    memail varchar(20) not null unique,		-- 공백 불가 , 중복 불가
    mimg longtext default 'default.jpg'		-- 회원 프로필의 이미지사진 이름 , 공백 가능
);