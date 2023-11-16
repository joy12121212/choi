
function onJoin(){
	
	// joinFrom 안에 데이터들 유효성 검사
	const joinForm=document.joinForm;

	//joinForm.custno.focus()	해당 폼 위치로 마우스 커서 이동 시킨다
	if(joinForm.custno.value== "") {alert('회원번호을 입력해주세요');joinForm.custno.focus();	// 해당 위치로 마우스커서 이동
	 return false;}
	if(joinForm.custname.value== "") {alert('회원성명을 입력해주세요');joinForm.custname.focus();	// 해당 위치로 마우스커서 이동
	 return false;}
	if(joinForm.phone.value== "") {alert('회원연락처를 입력해주세요');joinForm.phone.focus();	// 해당 위치로 마우스커서 이동
	 return false;}
	if(joinForm.address.value== "") {alert('회원주소를 입력해주세요');joinForm.address.focus();	// 해당 위치로 마우스커서 이동
	 return false;}
	if(joinForm.joindate.value== "") {alert('가입일자 입력해주세요');joinForm.joindate.focus();	// 해당 위치로 마우스커서 이동
	 return false;}
	if(joinForm.grade.value== "") {alert('회원등급을 입력해주세요');joinForm.grade.focus();	// 해당 위치로 마우스커서 이동
	 return false;}
	if(joinForm.city.value== "") {alert('도시코드를 입력해주세요');joinForm.city.focus();	// 해당 위치로 마우스커서 이동
	 return false;}

	alert('회원등록이 완료되었습니다')


	// 폼 가져오기 document.폼이름.submit();           submit() 얘는 전송  reset() 폼초기화
	document.joinForm.submit();


}