# jdbc와 연결할 db 선언

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

select * from member;

# 1. 회원가입 [ 테이블에 레코드 삽입 ]

insert into member( mid , mpw , mname , mphone) values ('aaa' , '1234' , '이젠' , '010-1010-1010');

select mid from member;
select mid , mpw from member;  # 필요한 값만 호출/확인

select mid , mpw from member where mid = 'aaa';		# 만약에 mid 필드에 'qwe' 문자열있는 레코드 검색
select mid , mpw from member where mpw = '1234';	# 만약에 mpw 필드에 '1234' 문자열있는 레코드 검색

# 자바의 문자열로 변환 한다면
select mid , mpw from member where mid = ? and mpw = ? ;	# mid 가 aaa 이면서 mpw 가 1234 인 레코드를 찾는다



# 2. 로그인 [ 테이블에 값 검색(select) ]

/*
	1. 테이블의 필드에 해당하는 레코드 검색
		select 필드명 from 테이블명
	2. 테이블의 모든필드[*] 에 해당하는 레코드 검색 << * 와일드카드
	
	3. 필드에 조건 추가		[where 조건절 (필드명 연산자 값 )]
		select 필드명		from 테이블명 where 조건
    
*/