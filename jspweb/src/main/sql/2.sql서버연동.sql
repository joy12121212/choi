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
use sqldb4web;

/* 테이블의 모든 레코드 검색 */

select * from member;

/* 회원가입 : mno 자둥부여 이므로 생략 */

insert into member (mid , mpw , mname , mphone) values ( 'gggg' , '1234' , '공아지' , '010-1234-1234');
#insert into member (mid , mpw , mname , mphone) values ( ? , ? , ? , ?);

/* 로그인 */

select * from member where mid = 'gggg' and mpw = '1234';		# 로그인 성공
select * from member where mid = 'gggg' and mpw = '1124111';		# 로그인 실패 / 비밀번호 틀림

/* 아이디 / 전화번호 중복체크 ( 유효성 검사 ) */
select * from member where mphone = '010-1234-1234';
select * from member where mid = 'gggg';

/* 아이디 비밀번호 찾기 */
select * from member where mid = 'gggg' and mpw='1234';
select * from member where mname = '공아지' and mphone = '010-1234-1234';

/* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 자바에서는  ' ' 안에  ? 넣어서 매개변수로 받아야 된다 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

/* 비밀번호 수정 */
update member set mpw = '121212' where mno = 2;

/* 회원정보수정 */
update member set mname = '공마아라' , mphone = '1234-1234' where mno = 1;


/* 회원탈퇴 */

delete from member where mno = 1;

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


select * from board;




# 테이블 합치기 
# 1. select * from 테이블명1, 테이블명2  
select * from member, board;
# 2 테이블 합치는데 기준 !! [ pk --- fk ]
   # member pk = mno / board fk = mno
   # 1. 조건 조인 [ pk필드와 fk필드가 일치하면 검색 ] * 일반 조건들과 가독성 떨어짐 [ 조인을 위한 조건인지 식별 ]
select * from member, board where member.mno = board.mno;
   # 테이블명이 길어지면 sql문도 길어져서 별칭
select * from member m, board b where m.mno = b.mno;
   # 2. 자연 조인 [ 자동으로 두 테이블간 pk필드와 fk필드를 식별해서 조인 ] * pk, fk 다수일때 힘듬
select * from member natural join board;
select * from member m natural join board b;
   # * 내가 보고 싶은 것만 필드 골라서 출력 
    # b.* : board 테이블 모든 필드 
    # m.mid : member 테이블의 mid 필드  
select b.*, m.* from member m natural join board b;
select b.*, m.mid from member m natural join board b;
select b.*, m.mid from member m natural join board b order by b.bdate desc;
select b.*, m.mid from member m natural join board b where b.bno = 3;
update board set bview = 1 where bno = 1; 
select * from member;
select * from board;
select * from message;
select * from board where  mno = 3;

update board set btitle = ?  ,bcontent = ?  where bno = ?;

use sqldb4web;

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
