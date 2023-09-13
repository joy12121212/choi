drop database if exists sqldb5web;
create database sqldb5web;
use sqldb5web;
create table table1 (데이터1 int , 데이터2 varchar(100));

insert into table1 (데이터1 , 데이터2) values ( 1, '유재석');

select * from table1;

insert into table1 (데이터1 , 데이터2) values ( 2, '깡호동');

select * from table1 where 데이터2 = '깡호동';		# 데이터2 의 필드값이 깡호동인 레코드 검색 [ 모든 필드 표시 ]

update table1 set 데이터1 = 3;		# 모든 레코드의 데이터1 필드의 값을 3으로 변경

update table1 set 데이터1 = 2 where 데이터2 = '유재석'; 		# 데이터2의 필드값이 '유재석'인 레코드의 데이터1 필드값을 2로 변경

# delete from table1;		# 코든 레코드를 삭제
delete from table1 where 데이터2 = '유재석';		# 데이터2  필드의 값이 '유재석'인 레코드 삭제





# 1. insert [create] / 회원가입 ,글쓰기, 제품등록 , 주문 , 대여 등등 ~
	# insert into 테이블명 ( 필드명 , 필드명 ) values ( 값 , 값 );

# 2. select [read] / 로그인, 아이디찾기, 비밀번호찾기, 글 목록 등등 ~ 
	# select * from 테이블명 / select 필드명 from 테이블명
		# select 필드명 from 테이블명 where 조건절
        
# 3. update [update]
	# update 테이블명 set 필드명(수정값) , 필드명(수정값)
	# update 테이블명 set 필드명(수정값) , 필드명(수정값) where 조건절
    
# 4. delete [delete]
	# delete from 테이블명 
	# delete from 테이블명 where 조건절




