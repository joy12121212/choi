console.log('아작스 통신')

//예제1
function 예제1() {console.log('예제1 실행')

	$.ajax({
		//url : "http://localhost/jspweb/Test02",
		url : "/jspweb/Test02",
		method : "get",
		success : function 함수명(result) {console.log(result)}
		
	})

};

//예제2
function 예제2() {console.log('예제2 실행')

	$.ajax({
		url : "/jspweb/Test03",
		method : "get",
		success : function 함수명(result) {console.log(result)}
		
	})

};


//예제3
function 예제3() {console.log('예제3 실행')

	$.ajax({
		url : "/jspweb/Test04",
		method : "get",
		success : function 함수명(result) {console.log(result)
		console.log(result.title)}
		
	})

};


//예제4
function 예제4() {console.log('예제4 실행')

	$.ajax({
		url : "/jspweb/Test05",
		method : "get",
		success : function 함수명(result) {console.log(result)
		}
		
	})//ajax

};
/*
	$.ajax({
		url : "통신할경로/서블릿주소" ,
		method : "통신방법 : get , post , put , delete  중에 선택" ,
		success : funtion 함수명(통신반환변수){통신 성공 했을때 실행 코드}
		error : funtion 함수명(통신반환변수){통신 실패 했을때 실행 코드}
	})
		1. success : funtion 함수명 (통신반환변수) {통신성공 실행 코드}
		1. success : funtion (통신반환변수) {통신성공 실행 코드}
		1. success : (통신반환변수) =>{통신성공 실행 코드}

	ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
	서블릿
		- request : 요청 객체
		- response : 응답 객체
			- response.getWriter().print(); : 데이터 응답
			- response.setContentType("전송 데이터 타입명;인코딩 타입명");	: 출력할 데이터의 타입 혹은 인코딩

				- 1. 문자전송[default]
					response.setContentType("text/html;charset=UTF-8");
				- 2. json 전송
					response.setContentType("application/json;charset=UTF-8");
	
	jackson : java 객체를 json 형식에 대한 다양한 클래스 제공
		1.objectMapper 클래스 : java 객체를 json 식으로 변환		

*/
