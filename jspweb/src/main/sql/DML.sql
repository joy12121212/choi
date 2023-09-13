/*
DML

insert
	insert into 테이블명(필드명 , 필드명) values (값 , 값);
 

select
	select * from 테이블명									-> 모든 레코드 검색
    select 필드명 , 필드명 from 테이블명						-> 특정 레코드 검색
	select * from 테이블명 where 조건절						-> 조건 충족하는 레코드 검색	[ 모든 필드 출력 ]
    select 필드명 , 필드명 from 테이블명 where 조건절			-> 조건 충족하는 레코드 검색	[ 특정 필드 출력 ]

update
	update 테이블명 set 필드명 = 수정할값;						-> 싹 다 바꿈
	update 테이블명 set 필드명 = 수정할값 where 조건절;			-> 특정 값만 바꿈
    
delete
	delete from 테이블명;									-> 싹 다 삭제
    delete form 테이블명 where 조건절;						-> 특정 레코드만 삭제


자바와 연동해서 사용할거라면 ? -> 매개변수 대입

	- 회원가입
	insert into 테이블명(필드명 , 필드명) values (? , ?);   
	- 아이디 / 전화번호 중복 검사
    select * from 테이블명 where 필드명 = ? ;
    - 비밀번호 수정
    update 테이블명 set 필드명 = ? , 필드명 = ? , 필드명 = ? ;
    - 회원탈퇴
    delete from 테이블명 where 필드명 = ? ;


















*/