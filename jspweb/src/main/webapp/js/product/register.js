console.log('레지스터js 실행')

function onRegister(){
	// 1. form dom 객체 호출
	let registerForm = document.querySelectorAll('.registerForm')[0];
	let formdata = new FormData(registerForm);
	console.log(formdata)
	
	$.ajax({	
		url : "/jspweb//productInfoController",
		method : "post",
		data : formdata,
		contentType : false,
		processData : false,
		success : result => {console.log(result)}
	});
	
	
}