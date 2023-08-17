console.log('1_통신.js')

// 예제1

function 예제1() {console.log('예제1실행한다')
// https://jsonplaceholder.typicode.com/
// 외부 사이트에 json 데이터 통신
	// ajax : jquery 라이브러리에서 외부와 통신하는 통신함수 제공
	// jquery : js 언어로 여러개 함수를 제공하는 라이브러리
	// <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	// jquery 최신 버전 불러오기


	/*
		1. 정의 : js 언어에서 외부와 통신하는 목적
		2. 형태 : $.ajax();
		3. ★필수★!! : jquery 라이브러리 필수 <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		4. 매개변수 : 객체 { 속성 : 값 , 속성 : 값 , 속성 : 값 }
			1. url 속성 : 통신할 대상/링크
			2. http 통신 메소드 : post , get , put , delete
			3. success 결과속성 : 통신 성공시 반환된 데이터를 함수의 매개변수로 전달

	*/

	$.ajax(
		{url : "https://jsonplaceholder.typicode.com/posts" , 
		method : "get" , 
		success : function(result){console.log(result)} ,
		// success : ()=>{console.log(result)} 익명함수 가능
		});

}


function 예제2() {console.log('예제2실행')

		$.ajax(
			{url : "../test01" , 										// 통신할 경로
			method : "get" , 										// 통신할 방식
			success : function(result){console.log(result)} ,	// 결과 확인
			// success : ()=>{console.log(result)} 익명함수 가능
		});
	
}