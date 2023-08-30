/*직원 이미지*/
function preimg(obj){
	
	console.log(obj)
	
	let file = new FileReader();
	
	file.readAsDataURL(obj.files[0])
	
	file.onload = e =>{
		console.log(e.target.result)
		document.querySelector('.preimg').src=e.target.result;
	} 
	
	
	
}


function signup(){
	console.log('사인업들어왓어요')
	let hrmForm = document.querySelectorAll('.hrmForm')[0]
	console.log(hrmForm)
	
	let signupData = new FormData(hrmForm)
	console.log(signupData)
	
	$.ajax({
      url :  "/jspweb/HrmController",
      method : "post" , 
      data : signupData ,
      contentType : false,
      processData : false,
      success : r => {console.log('사인업 통신 성공?')
      
      if(r){
		  alert('직원등록 성공')

	  }
      else{
		  alert('직원등록 실패')
	  }
      
      } ,
      error :  e => {e}
      });
	
	
	
	
}

