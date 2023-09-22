console.log('payment js 실행')
//포인트 지급 테스트

//setPoint(1000,"회원가입축하")

//결제, 연동

IMP.init('imp35471862') // 예: 'imp00000000a'


function requestPay() {
	  
	  // 만약에 결제방식을 선택하지 않으면
	  if(pay_method ==''){alert('결제 방식을 선택 하세요');return;}
	  // 결제 금액이 선택하지 않으면
	  if(amount == 0){alert('결제 금액을 선택 하세요'); return;}
	  
	  // 주문번호 만들기 -> 고유성 - pk - 식별키
	  // 날짜(밀리초)+상품코드+회원번호 조합해서 설계
	  let now = new Date(); console.log(now) // 현재 날짜 가져오기
	  let time = now.getTime(); // 현재 시간 밀리초로 가져오기
	  let merchant_uid = time+"-p-"+loginMid; console.log(merchant_uid)
	  
	  
	  
    IMP.request_pay({
      pg: "html5_inicis.INIBillTst",
      pay_method: pay_method,
      merchant_uid: "ORD20180131-0000011",   // 주문번호
      name: "노르웨이 회전 의자",
      amount: amount,                         // 숫자 타입
      buyer_email: "gildong@gmail.com",
      buyer_name: "때애앵",
      buyer_tel: "010-7777-7777",
      buyer_addr: "서울특별시 강남구 오전동",
      buyer_postcode: "01181"
    }, rsp => {
    if (rsp.success) {

    } else {alert('결제성공');
    // 포인트 적립 기능처리
    setPoint(amount,"포인트 충전")
    // 결제내역 테이블 기능처리 [구현x]
    
    }
  });
		

}//requestPay


let pay_method =''; // 결제 방식 선택 함수
function onPayMethod(method){pay_method = method;}


let amount =0;// 결제 금액 선택 함수
function onAmount(value){amount = value;  }







// 1. 포인트 사용  
function setPoint(mpamount , mpcomment){
	// 로그인 상태 확인
	if(loginState == false){return;}
	
	$.ajax({
		
		url : "/jspweb/PointController",
		method : "post",
		async : false, // 응답이 올대까지 대기상태 - 동기식 , 반대 - 비동기식
		data : {mpamount : mpamount ,mpcomment : mpcomment },
		success : r=>{console.log(r)},
		error : e=>{console.log(e)}
		
	})

}

// getPoint()
// 2. 포인트 확인
function getPoint(){

	if(loginState == false){return;}
	
	$.ajax({
		
		url : "/jspweb/PointController",
		method : "get",
		async : false,
		data : {type : "pcheck"},
		success : r=>{console.log(r)},
		error : e=>{console.log(e)}
		
	})
	
}//getPoint



getPointList()
// 3. 포인트 사용 내역
function getPointList(){
	if(loginState == false){return;}

	$.ajax({
		
		url : "/jspweb/PointController",
		method : "get",
		async : false,		
		data : {type : "plist"},
		success : r=>{console.log(r)},
		error : e=>{console.log(e)}
		
	})
	
}//getPointList






