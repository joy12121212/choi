

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
#insert into visitlog(writer , pw , content ) values (?,?,?);

# 2. 호출

select * from visitlog order by date desc;


# 3. 수정 [ 필수 조건 : 누구 수정 ? ]

#update visitlog set content = ? where vno = ? and pw = ?;

# 4. 삭제 [ 필수 조건 : 누구 삭제 ? ]

delete from visitlog; /* 모든 레코드 삭제 */

#delete from visitlog where vno = 3 and pw = 1234; /* vno 가 3이고 pw가 1234 라면 삭제  */
#delete from visitlog where vno = ? and pw = ?; /* vno 가 3이고 pw가 1234 라면 삭제  */




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
#insert into accountbook(content , money , date) values ('1' , 1 , '2023-04-18');

# 출력
select * from accountbook order by date desc; # 최신 입력값 순서대로

# 수정
#update accountbook set content = ? where ano = ?;

# 삭제
#delete from accountbook where ano = ?;


#ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 회원가입 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

use jspweb;
drop table if exists member;

create table member (
	mno int auto_increment primary key,
    mid varchar(30) not null unique,
    mpwd varchar(20) not null,
    memail varchar(20) not null unique,
    mimg longtext 		# 프로밀 미등록시 기본 프로필 사용
);

select * from member;


# 회원가입
#insert into member(mid , mpwd , memail , mimg) values (? , ? , ? ,?) ;
# 테스트 insert into member(mid , mpwd , memail , mimg) values ('회원가입' , '1234' , 'eee' ,'default');
# 출력
select * from member ;
# 수정
#update member set mpwd = ?;
# 삭제
#delete from member where mno = 9;

# 아이디 중복 검사 - 있다 없다 검사 // row 1
# select * from member where mid = 'asdf';
#select * from member where mid = 'adfasdf';
#select * from member order by mno ;

#select * from member where mid = ? and mpwd = ?;

drop table if exists hrm;
create table hrm (
sno int auto_increment primary key,
sname varchar(20) not null,
sphone varchar(20) not null,
sposition varchar(10) not null,
simg longtext ,
sdate datetime default now()

);
use jspweb;
select * from hrm;

#insert into hrm (sname , sphone , sposition , simg) values (? , ? , ? , ?);

select * from member order by mno asc;
select * from hrm;

# 회원정보 호출
#select mno , mid , memail , mimg from member where mid = ?;

#delete from member where mno = 1 and mpwd = 'a1234';

#update member set mimg = ? where mno = ?;


#ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ회원제 게시판 db 설계ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ#

use jspweb;

# 게시판 카테고리
drop table if exists bcategory;
create table bcategory (
	bcno int auto_increment primary key,
	bcname varchar(30) not null
);

#샘플
insert into bcategory value(1 , '공지사항');
insert into bcategory value(2 , '자유게시판');
insert into bcategory value(3 , '노하우');

# 게시판
drop table if exists board;
create table board(
	bno int auto_increment primary key, 
	btitle varchar(100) not null,
	bcontent longtext ,
	bfile  longtext ,
	bdate datetime default now() ,
	bview int default 0,
	mno int,
	bcno int,
	foreign key(mno) references member (mno) on delete cascade, #회원탈퇴시 게시물도 같이 삭제 [ 제약 조건],
	foreign key(bcno) references bcategory (bcno) on delete cascade on update cascade

);

select * from bcategory;
select * from board;

# 게시물 등록
#insert into board (btitle , bcontent , bfile , mno , bcno) values ( ? , ? , ? , ? ,?);

# 게시물 출력
select bno, btitle , bfile , bdate , bview from board;
	# 게시물 테이블과 회원 테이블 join 합치기 [ pk - fk ]
    # 게시물 테이블내 작성자 번호와 회원테이블의 작성자번호가 같으면
select  b.bno, b.btitle, b.bfile , b.bdate ,b.bview , m.mid from board b natural join member m;
# b 와 m 은 별칭
	# 게시물 테이블 , 회원테이블 , 게시물 카테고리테이블 3개도 되나?
    
#b.* 테이블 전체 다 가져오기
select b.* , m.mid , m.mimg , bc.bcname from board b natural join bcategory bc natural join member m order by b.bdate desc;


# 개별 글 출력
select * from board where bno= 1;
#select * from board where bno= ?;
# ------- 게시물의 모든정보 + 작성자 id , 작성자 프로필 , 카테고리 이름 필요함 게시물 3개를 합쳐야 됨
# ------- board fk 필드를 이용해서 연결된 pk 필드의 다른 필드정보 호출
select b.* , m.mid , m.mimg from board b natural join member m;

select b.* , m.mid , m.mimg ,bc.bcname
from board b 
natural join member m
natural join bcategory bc
where b.bno = 1
order by b.bdate desc;


# 조회수 증가
update board set bview = bview+1 where bno = ?;

# 게시물 삭제
delete from board where bno = ?;


# 게시물 수정
update board set btitle = ? , bcontent = ? , bfile = ? , bcno = ? where bno = ?;

# 게시물수 제한 두기
select b.* , m.mid , m.mimg ,bc.bcname
from board b 
natural join member m
natural join bcategory bc
where b.bno = 1
order by b.bdate desc limit 4;


# 게시물수 제한 두기 [ limit 시작번호 , 레코드수 : 시작번호레코드부터 레코드수만큼 조회]
select b.* , m.mid , m.mimg ,bc.bcname
from board b 
natural join member m
natural join bcategory bc
where b.bno = 1
order by b.bdate desc limit 4;

# limit 3  -> 3개 , limit 3, 6  -> 3번부터 6개


# 레코드 수 구하기

select count(*) from board;

# 카테고리별 게시물 수
select count(*) from board b where b.bcno = 1; # 카테고리1 - 공지사항 의 게시물 수 2 = 자유게시판, 3 = 노하우



# --------------- 제품 ----------------------- #

# pk 상위 테이블 먼저 생성
# 1. 제품 카테고리
drop table if exists pcategory;
create table pcategory(
	pcno int auto_increment primary key,
	pcname varchar(20) not null );

# 샘플
insert pcategory(pcname) values('노트북');
insert pcategory(pcname) values('컴퓨터');        
insert pcategory(pcname) values('핸드폰');
        
# 2. 제품
drop table if exists product;
create table product(
	pno int auto_increment primary key,
    pname varchar(100) not null,
    pcontent longtext,
    pprice int unsigned default 0,		# signed 기본값:음수사용 / unsigned(음수 사용 안함 음수만큼의 메모리를 양수로 사용(0~42억 정도)
    pstate tinyint default 0 not null,			#[ ex) 0 판매중 , 1 거래중 , 2 판매완료 ]               
    pdate datetime default now(),
    plat varchar(40),
    plng varchar(40),
    pcno int ,
    mno int,
	foreign key (pcno) references pcategory(pcno) on delete set null on update cascade, # 자동삭제
    foreign key (mno) references member(mno) on delete set null on update cascade # 자동삭제
);

# 3. 제품 이미지
drop table if exists productimg;
create table productimg(
	pimgno int auto_increment primary key,
    pimg longtext,
    pno int,
    foreign key (pno) references product(pno) on delete set null on update cascade
);


# 1. 제품등록 [ 제품등록 후 이미지 등록 - > 왜 ? 이미지 등록시 제품번호 pk 필요함 ]

insert into product(pcno,pname,pcontent,pprice,plat,plng,mno) 
	values( ? , ? , ? , ? , ? , ? , ? );

	# 제품 등록 후 해당 제품pk번호를 이미지 테이블에 이미지와 같이 저장
insert into productimg(pimg , pno) values(? , ?);

select * from product;
select * from productimg;

delete from product where pno = 5;

select pno from product where ? >= plat and ? <= plat and ? >=plng and ? <=plng order by pdate;


use jspweb;
drop table if exists pwishlist;
create table pwishlist(
	mno int not null,
    pno int not null,
    foreign key(mno) references member(mno) on delete cascade on update cascade, -- 회원이 탈퇴하면 찜하기 목록 같이 삭제
    foreign key(pno) references product(pno) on delete cascade on update cascade -- 제품이 삭제되면 찜하기 목록에서 없는 제품으로 대입 null 대입
);

# bigint / unsigned -> 음수 없음 양수만



