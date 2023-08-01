#한줄 주석
# 확대 축소, 컨트롤 + 마우스 휠
-- 한줄 주석
/* 여러줄 주석 */

/*
	데이터 베이스	: 데이터 [자료] , 베이스 [모임]
		- 종류
			1. 계층형 데이터 베이스 : 트리형태
            2. 네트워크형 데이터 베이스 : 양방향 형태
            3. 공개형 데이터 베이스 : 행과 열로 구성된 테이블[표] 형태
            4. NoSql 데이터 베이스 : key , value 로 되어있음

		- 용어
			dba [데이터 베이스 관리자]
				- 개발자
			dbms	[데이터 베이스 관리 시스템]
				- mysql , oracle
            db [데이터 베이스]
				- 실제 데이터저장된 곳 = db server
                - 메모리 [16진수/기계어] : 개발자 직접 관리 어려움
		
        - 관계   // 자바랑 똑같음  이클립스 -> JVM -> 메모리 
        
			dba		------------> db [x]
			개발자				기계어
			dba		------------> dbms ------> db  [ㅇ]
			개발자			  관리 시스템		기계어 조작 


		- SQL	: db 조작/관리/제어 할때사용되는 언어/문법 (대소문자 구분x)
			1. DDL [데이터 베이스 정의어]
				- create(만들다)		: 데이터베이스 테이블 생성
					- creat database db명;
                    - create table member(필드명 속성명 , 필드명 속성명 , 필드명 속성명);
                - drop				: 데이터베이스 테이블 삭제
					-drop database db명;
                    -drop database if exists db명;
                    -drop table 테이블명;
                    
                - alter(변경,바꾸다)	: 테이블 속성 수정
                - truncate(잘라내다)	: 테이블 내 데이터 초기화/삭제
                - rename			: 테이블 이름 변경
					show databases;	:데이터베이스 전체 목록 보기
                    show variables like 'datadir'; : 로컬 주소 확인
				- use 				: 사용할 db 선택 // 굵은글자로 됨
            2. DML [데이터 베이스 조작어]
				- select(선택)	: 테이블에 레코드(행) 삽입
					- select * from 테이블명; : 테이블내 모든 필드의 레코드 검색 [ * 와일드카드 = 모든 ]
                - insert(삽입)		: 테이블에 레코드(행) 검색
                - update			: 테이블에 레코드(행) 수정
                - delete			: 테이블에 레코드(행) 삭제
            3. DCL [데이터 베이스 제어어]
				- grant(승인하다)		: 사용자 권한 부여
                - revoke(취소하다)	: 사용자 권한 취소
            4. TCL [트랜잭션 제어어]
				- commit(맡기다)		: !! 트랜잭션 [명령어 단위] 완료
                - rollback			: 트랜잭션 [명령어 단위] 취소
                
        - 테이블 용어
			테이블 [표]
            
			속성 == 열 == colum == 필드 -> 테이븡의 열(가로)
				학번		학생명	전화번호			주소
                1010	ㄱㄱㄱ	010-111-1111	안산
				2020	ㅅㅅㅅ	010-111-2222	안양
                
                학번필드, 학생명필드, 전화번호필드, 주소필드 라고 읽는다
			
           속성 == row == 행 == 레코드 : 테이블의 행
				1번 레코드, 2번 레코드, 3번 레코드 라고 읽는다

			★행과 열의★ '관계형' 데이터베이스

		- 데이터 필드 타입 [mysql 기준 / dmbs 마다 조금씩 다름]
			  		+- 21억		  -127~128		+-3만  	 +- 8백만	   21억 이상
			- 정수형	: ★★int(4) , tinyint(1) smallint(2) mediumint(3) biging(8) // 바이트
            - 실수형	: float(4) , ★★double(8) // 바이트
            - 문자	: 
					[최소 1 ~ 최대 255 글자수 까지] 
					char(문자길이-고정길이)-배열 저장할 데이터의 글자수가 제한된경우/딱 맞는경우 
                    [최소1 ~ 최대 65535 글자수 까지]
					권장★ varchar(문자길이-가변길이)-리스트 저장할 데이터의 글자수가 정해져 있지 않는 경우
            - 날짜	: ★★★date(yyyy-mm-dd), time(hh:mm:ss) , datetime(yyyy-mm-dd hh:mm:ss) //저장 형식
            - 대용량	: 
					text(최소1~최대65535) 
                    mediumtext(최소1~최대1600만)
                    longtext(4GB)		: 게시물 내용물, 첨부파일, 이미지, 동영상 저장시
            - 논리	: boolean(1) // 바이트

*/

/*---------------------------------데이터베이스 만들기-----------------------*/
# 예1 : 데이터베이스 (여러개의 테이블들이 저장할 수 있는 공간) 생성
create database sqldb1;
	# create : 생성한다.
    # database : 데이터베이스.
    # sqldb1 : 이름 [아무거나,대소문자 구분x, 키워드x(java 자료형처럼 쓰지마라)]
    # ;		: 개행
		# 해당 명령어 줄에 커서 위치 후 컨트롤 엔터 // 액션 아웃풋에 초록색 동그라미 뜨면 성공
        # 네비게이터 ★새로고침★
create database sqldb2; # 얘네들은 폴더라고 생각하면 된다
create database sqldb3;
create database sqldb4;		
create database sqldb5;


# 예2 : 데이터베이스 목록 보기

show databases;

# 예3 : 데이터베이스 저장소 확인

show variables like 'datadir';

# 예4 : 데이터베이스 삭제
drop database sqldb1;
drop database sqldb2;
drop database sqldb3;
drop database sqldb4;
drop database sqldb5;

# 예5 : 데이터베이스 존재했을때 삭제 [만약에 데이터베이스 없을때 삭제 명령어 실행시 오류 발생]
drop database if exists sqldb1;

create database sqldb2;

# 예6 : 여러개의 데이터베이스중 사용할 데이터베이스 선택
use sqldb1;
use sqldb2;

# 활용 1	: 데이터 베이스 새롭게 생성 하세요
# 1. 데이터 베이스 존재시 삭제처리
drop database if exists test1;
# 2. 데이터 배이스 생성
create database test1;
# 3. 데이터 베이스 사용 준비
use test1;

/* ----------------테이블 만들기-----------------*/
# 테이블은 데이터베이스 안에 저장 된다[무슨 데이터베이스에 테이블 생성할건지 use db명;  필수]
# 예1 : 테이블 새어
use sqldb1; # 테이블을 생성할 데이터베이스 선택

create table member(아이디 text, 비밀번호 text);
	# crete	: 생성한다.
    # table : 테이블을
    # member : 멤버라는 이름의
    # ( )	: 테이블의 속성/열/필드 정의
		# 열(가로 - 제목)만들기 - (필드명 타입 , 필드명 타입 , 필드명 타입) 

# 예2 : 테이블 확인
select * from member;

# 예3 : 테이블 삭제
drop table member;


# 활용 2 :
/*
	문제1 : 웹개발 하는데 db저장소 'sqldb1web' 이름으로 db 생성
    문제2 : 해당 db에 멤버라는 테이블 생성
		id 문자열 최대 20글자 , 비밀번호 문자열 최대 10글자
 
*/

drop database if exists sqldb1web;

create database sqldb1web;
use sqldb1web;
drop table if exists member;
create table member (아이디 varchar(20) , 비밀번호 varchar(20) );
select * from member;

/* 
	문제2
	문제1 : 웹개발 하는데 db저장소 'sqldb1web2' 이름으로 db 생성
    문제2 : 해당 db에 board 테이블 생성
		no (최대21억)
        title(문자열 최대100)
        content(문자열 최대 6만5천 이상)
        view (최대 21억)
		datetime (날짜/시간)

*/

drop database if exists sqldb1web2;
create database sqldb1web2;
use sqldb1web2;
drop table if exists board;
create table board (번호 int , title varchar(100) , content longtext , view int , 날짜 datetime);
select * from board;

