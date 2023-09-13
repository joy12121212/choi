/*


[MYSQL 8.x] SQL 
   * 대소문자 구분X
   -DDL   데이터베이스 정의어
      1. create        데이터베이스/테이블 생성
         create database DB명;
         create database TABLE명( 속성명 타입 제약조건 , 속성명 타입 제약조건 )
      2. drop      데이터베이스/테이블 삭제 
         drop database DB명;
         drop database if exists DB명;
         drop table if exists TABLE명;
      3. alter      데이터베이스/테이블 수정
      4. truncate   테이블 내 데이터 삭제 
      5. rename   테이블 이름 수정 
      6. show      데이터베이스 검색
         show databases
      7. use       데이터베이스 사용 선택 
         use DB명

   -DML   데이터베이스 조작어 
      1. insert
         insert into 테이블명 values( 값1, 값2, 값3, 값4 )         모든 필드의 값 대입해서 레코드 삽입할때. 
         insert into 테이블명( 필드명 , 필드명 , 필드명 ) values( 값1, 값2, 값3)   특정 필드의 값 대입해서 레코드 삽입할때.
      2. select 
         select 필드명 , 필드명 from 테이블명            모든 레코드 검색 [ *특정 필드만 표시 ] 
         select * from 테이블명                모든 레코드 검색 [ *모든 필드 표시 ]
         [ 1. where 조건 ]
            select * from 테이블명 where 조건
            - select * from member where  bno = 3;      : 회원번호가 3인 레코드 
         [ 2. order by 정렬 ]
            select * from 테이블명 order by 정렬기준필드명 정렬기준[ asc:오름차순/desc:내림차순 ] 
            - select * from member order by point desc        : 포인트 필드 기준으로 내림차순 
         [ 3. limit 검색결과 레코드표시제한 ]         
            select * from 테이블명 limit 레코드수
            select * from 테이블명 limit 시작레코드번호[0~] , 레코드수 
            - select * from member limit 3         : 3개 레코드
            - select * from member limit 2 , 5         : 3번째 레코드부터 5개 레코드 
         [ ----- 작성순서 ]
            select * from 테이블명 where 조건절 order by 정렬필드 정렬기준 limit 레코드수 

         [ 조인 JOIN ]
            * 두 테이블 1개 필드 이상의 값이 동일한 존재!! [ *대부분 PK-FK 관계 ]
            1. 조건 JOIN [ 교집합 ]
               select * from 테이블명A , 테이블명B where 테이블명A.필드명 = 테이블명B.필드명 
               select * from 테이블명A  a , 테이블명B b where a.필드명 = b.필드명 
            2. 자연 조인 [ 교집합 ]
               select * from 테이블명A  a natual join 테이블명B b 
             
      3. update
         update 테이블명 set 수정할필드명 = 수정할값 where 조건 
      4. delete 
         delete from 테이블명 where 조건 
   -DCL   데이터베이스 제어어
      1. grant
      2. revoke
   -TCL   트랜잭션 제어어
      1. commit
      2. rollback 
---------------------------------------------------------------------------------------------------------
    < 데이터 필드 타입 > 
   - 정수
      tinyint       [1]   : -128~127
      smallint      [2]   : +-3만정도
      mediumint   [3]   : +-8백만정도
      int      [4]   : +-21억정도
      bigint      [8]   : +-21억이상 
   - 실수
      float      [4]   : 소수점 7자리 
      double      [8]   : 소수점 15자리 
   - 문자
      char(길이)   [고정]   : 저장할 데이터의 글자수가 정확히 정해져 있는경우
      varchar(길이)   [가변]   : 저장할 데이터의 글자수가 정확하지 않을때
   - 대용량 문자 
      text         : 1~65535
      mediumtext      : 1~16000000
      longtext      [4G] 
   - 날짜
      date         : YYYY-MM-DD   YYYY.MM.DD 형식   [ - , . ] 형식 
      time         : HH:MM:SS [ : ] 형식 
      datetime         : YYYY-MM-DD HH:MM:SS
   - 논리
      boolean      [1]   : true = 1 / false = 0    <==> tinyint
---------------------------------------------------------------------------------------------------------
   <제약조건>
   - pk
      primary key( pk사용할필드명 )
   - fk
      foreign key( fk사용할필드명 ) references pk테이블명(pk필드명) [선택옵션]
      [선택옵션]
         on delete/update cascade   : PK필드의 값이 삭제/수정 되었을때 FK필드 같이 삭제/수정
         on delete/update restrict   : (기본값) PK필드의 값이 삭제/수정 되었을때 FK필드의 값이 존재하면 불가능 
         on delete/update no action   : 아무런 변화 없음 
         on delete/update set null   : PK필드의 값이 삭제/수정 되었을때 FK필드을 특정 값[NULL]으로 수정         
   - auto_increment
      필드명 타입  auto_increment   * [PK필드에서만 사용가능]
   - not null 해당 필드의 null 대입 금지 
      필드명 타입 not null
   - unique 해당 필드의 중복값 대입 금지 
      필드명 타입 unique
   - default 레코드 삽입시 필드의 값이 없으면 기본값 대입 *[삽입할 필드의 값이 있으면 해당 값 대입]
      필드명 타입 default 값 
---------------------------------------------------------------------------------------------------------
   <연산자>
      1. 산술   +더하기   -빼기 *곱하기 /나누기 div몫 mod나머지
      2. 비교   =같다 !=같지않다. >초과 <미만 >=이상 <=이하
      3. 논리   and이면서 or이거나 not부정
      4. 기타 
         필드명 between 시작값 and 끝값 
         필드명 in( 값1 , 값2 , 값3 )
         필드명 like '%값%'         % : 모든 문자 수 대응    
         필드명 like '_값_'         _ : _ 개수만큼 문자 수 대응 
         필드명 is null         null 이면       [* 필드명 = null 사용 불가 ]
         필드명 not null         null 아니면 
---------------------------------------------------------------------------------------------------------
   <기타기워드>
      1. 별칭 : 검색결과나 연산시 테이블명/필드명 에 별명
         필드명 as 별칭명    , 테이블명 as 별칭명
         필드명 별칭명     , 테이블명 별칭명 
      2. distinct : 필드의 값 중복 제거 
         select distinct 필드명 from 테이블명 
---------------------------------------------------------------------------------------------------------
< 함수 >


# 1. 날짜 함수
   # 1. now() : YYYY-MM-DD hh:mm:ss 반환
select now(); 
   # 2. curdate() : YYYY-MM-DD 반환
select curdate();
   # 3. curtime() : hh:mm:ss 반환
select curtime();
   # 4. year(날짜), month(월), day(날짜), weekday(날짜), last_day(날짜)
   #    해당 날짜     월         일        요일[월=0 일=6]  해당 월의 마지막 일 반환
select year(now()), month(now()), day(now()), weekday(now()), last_day('2023-08-14');

# 5. hour(시간), minute(시간), second(시간),
# 해당 시간       해당 분       해당 초
select hour(now()), minute(now()), second(now());

# 6. date_format(필드명, '형식') : 날짜/시간 형식 기준으로 변환
# 형식 : %y 두자리 년도, %Y 네자리 년도, %m 두자리 월 %M 영문명 월, %c 1자리(2자리) 월 %d 두자리 일, %D 영문명 서순 일, %e 한자리 일, %W 영문 요일, %a 영문 약자 요일
select date_format('2023-08-01', '%y - %Y - %m - %M - %c - %d - %D - %e - %W - %a') as day;

# 시간형식 : %H 두자리 시, %i 2자리 분, %S 2자리 초
select date_format(now(), '%H - %i - %S');
         
         
         
         
         
         
         
         
*/



drop database if exists sqldb6web;
create database sqldb6web;
use sqldb6web;
# 1. 회원테이블
drop table if exists member;
create table member(            # 아이돌 그룹
   mid char(8) not null ,         # 식별키       최대 8자리
    mname varchar(10) not null ,   # 그룹명      최대 10자리
    mnumber int not null ,         # 인원수      정수 +-21억정도
    maddr char(2) not null ,       # 지역      최대 2자리
    mphone1 char(3) ,            # 지역번호   최대 2자리 
    mphone2 char(8) ,            # 전화번호    최대 8자리
    mheight smallint ,            # 평균키       정수 +-3만정도
   mdebut date ,               # 데뷔일       yyyy-mm-dd 
    primary key ( mid )            # 제약조건 
);
# 2. 구매테이블
drop table if exists buy;
create table buy(
   bnum int auto_increment ,          # 구매번호   정수    자동번호 부여 
    mid char(8),                  # 구매자      FK 
    bpname char(6) not null ,         # 제품명      최대 6자리 
    bgname char(4) ,                # 분류명       최대   4자리
    bprice int not null ,            # 가격       정수 
    bamout smallint not null ,         # 구매수량   정수 
    primary key(bnum) ,               # 제약조건 
    foreign key ( mid ) references member(mid) # 제약조건 
);

# 샘플데이터 
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);



# 2 집계 함수
select sum(bamout) as 총구매수량 from buy;			# 1. sum ( 필드명 )	 : 해당 필드의 값 총 합계
select avg(bamout) as 구매수량평균 from buy;		# 2. avg ( 필드명 )	 : 해당 필드의 값 평균
select max(mheight) as 가장큰키 from member;		# 3. max ( 필드명 )	 : 해당 필드의 최대 값
select min(mheight) as 가장작은키 from member; 	# 4. min ( 필드명 )	 : 해당 필드의 최소 값
select count(bamout) as 구매횟수 from buy;			# 5. count ( 필드명 )	 : 해당 필드의 레코드 수 [ null 미포함 ]
select count(*) as 구매회수 from buy;				# 6. count ( * )	 : 해당 필드의 레코드 수 [ null 포함 ]


# 3 수학 함수

select abs(100) , abs(-100);									# 7. abs	: 절대값
select ceil(10.1) , ceil(10.4) , ceil(10.5) , ceil(10.0);		# 8. ceil	: 올림
select floor(10.1) , floor(10.4) , floor(10.5) , floor(10.0);	# 9. floor	: 내림
select round(10.1) , round(10.4) , round(10.5) , round(10.0);	# 10. round	: 반 올림

# 11. round	(필드값 , 표시할자리수): 반 올림 [ 5 이상 ]
select round(1.23456789 , 1) , round(1.23456789 , 4) , round(1.23456789 , 7);

# 12. truncate	(필드값 , 표시할자리수): 자리 버림
select truncate(1.23456789 , 1) , truncate(1.23456789 , 4) , truncate(1.23456789 , 7);
select pow(10 , 2)				# 13. pow( 값 , 몇승 )	: 제곱 



