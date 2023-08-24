
//1. 회원가입 메소드
function signup(){ console.log('signup 왔어요')

	// html 정보 가져오기
	let midInput = document.querySelector('.mid').value;
	let mpwdInput = document.querySelector('.mpwd').value;
	let mpwdconfirmInput = document.querySelector('.mpwdconfirm').value;
	let memailInput = document.querySelector('.memail').value;
	let mimgInput = document.querySelector('.mimg').value;

	// 객체화
	let info = {
		mid : midInput, mpwd : mpwdInput , memail : memailInput,
		mimg : mimgInput
	}
	console.log(info);

	// 아작스
	  $.ajax({
      url :  "/jspweb/MemberController",
      method : "post" , 
      data : info ,
      success : r=>{console.log('통신성공')} ,
      error :  e=>{}
      });

}