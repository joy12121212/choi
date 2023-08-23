


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
