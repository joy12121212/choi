/*

//기본 세팅

Server Tomcat v9.0 Server at localhost failed to start.
이거 오류 뜨면 http url 중복 있을 수 있음


function 예제1(){
	
	$.ajax({
		url : "" ,						// 통신할 http 주소
		data : "",						// 보내는 데이터
		method :"" ,					// get , poust , put , delete
		success : ()=>{console.log(result)},				// 통신 성공
		error : ()=>{console.log(result)}					// 통신 실패
		
	});
	
}

*/
//1. 예제
console.log('연결됐나요')


function 예제1(){
	
	$.ajax({
		url : "http://localhost/jspweb/Test06" ,						// 통신할 http 주소
		data : {'value1' : 'jsdata'},										// 보내는 데이터
		method :"get" ,									// get , poust , put , delete
		success : function 함수(result){console.log(result)},				// 통신 성공
		error : function 함수(){}					// 통신 실패
		
	});
	
}

function 예제2(){
	
	// 입력 받은 데이터를 가져온다
	let nameData = document.querySelector('.name').value;
	let ageData = document.querySelector('.age').value;
	
	// 객체화
	let info = {
		name : nameData, age : ageData
	}
	
	
	$.ajax({
		url : "http://localhost/jspweb/Test07" ,
		data : info,
		method :"get" ,					
		success : function 함수(result){console.log('통신성공')}
		});	
	
}		


















