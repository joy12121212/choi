1. select * from member_tbl_02;
2. select * from money_tbl_02;
3. 2. select * from money_tbl_02 mo, member_tbl_02 m;


4. select * from
	money_tbl_02 mo inner join member_tbl_02 m 
	on mo.custno = m.custno;
	
5. 필요한 필드
	select 
		m.custno , m.custname , m.grade
		form money_tbl_02 mo inner join member_tbl_02 m
		on mo.custno = m.custno;
		
		select
			m.custno , m.custname, mgrade
			from money_tbl_02 mo inner join membet_tbl_02 m
			on mo.custno = m.custno
			group by (m.custno,m.custname,m.grade);
			
			select
		m.custno , m.custname, m.grade , sum(mo.price)
		from money_tbl_02 mo inner join membet_tbl_02 m
		on mo.custno = m.custno
		group by (m.custno,m.custname,m.grade);
		
		


8. 매출이 많은 순으로 - 가격 합산이 높은 순으로 정렬
		select
			m.custno as custno,
			m.custname as custname,
			m.grade as grade,
			sum(mo.price) as sum
			from money_tbl_02 mo inner join membet_tbl_02 m
			on mo.custno = m.custno
			group by (m.custno,m.custname,m.grade) order by sum(mo.price) desc;
			


