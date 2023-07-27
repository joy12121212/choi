package java1.day11.Ex4디자인패턴1;

public class 고객 {

}

/*

소프트웨어 디자인 패턴
	- 클래스 역할에 따른 분업 구분 [ 유지보수 용이 , 특정 부분만 수정 가능 ]
	1. MVC
		M : model		[java , db 등]
				C: controller	[java]
		V : view		[html,js,css]
		
		
	고객 [view]			----> 서빙/요리사	[controller]	----DTO------> 냉장고 [dao]
	-요구/응답 받는 입장		- 요구에 따라 응답하는 입장					- 원본의 데이터 저장소/접근장소
	-입/출력 되는 구역			- 가공, 유효성검사, 전달,로직 구역				- 저장, CRUD 
	-html/js				- java
	
	[model]
	*DTO : Date Transfer Object : 데이터 이동 객체
	*DAO : Date Access Object : 데이터에 접근하는 객체















*/