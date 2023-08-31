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

sread();
function signup(){
	console.log('사인업들어왓어요')
	let hrmForm = document.querySelectorAll('.hrmForm')[0]
	console.log(hrmForm)
	
	let signupData = new FormData(hrmForm)
	console.log(signupData)
	
	let sname = document.querySelector('.sname').value;
	console.log(sname)
	let sphone = document.querySelector('.sphone').value;
	console.log(sphone)		
	
	let nj=/^[가-힣]{2,20}$/
	let pj=/^\d{3}-\d{3,4}-\d{4}$/;	
	
	if(nj.test(sname) && pj.test(sphone)){
		$.ajax({
	      url :  "/jspweb/HrmController",
	      method : "post" , 
	      data : signupData ,
	      contentType : false,
	      processData : false,
	      success : r => {console.log('사인업 통신 성공?')
	      
	      if(r == true) {alert('직원등록 성공');sread();}
	      else {alert('직원등록 실패') }
	      } ,
     error :  e => {e}
      });
      }//if
		else{alert('다시 입력해주세요')}
}
sread();
function sread(){
		console.log

			
		$.ajax({
			
			url : "/jspweb/HrmController" ,
			method : "get" ,
			data : "",
			success : r=> { console.log('sread에서 r 실행값 : ' + r)
				let output = document.querySelector('.sinfo')
				let html =``;
				
				for(let i = 0; i <r.length; i++){
					html+=`
	
					<div>${r[i].sno}</div><div>${r[i].sname}</div><div>${r[i].sphone}</div>
					
					<div>${r[i].sposition}</div>
					<img class="smig2" src="/jspweb/hrm/img/${r[i].simg}"/>
					<div>${r[i].sdate}</div>`
					}
					output.innerHTML=html;
				},
			error : e=>{console.log(e)}		
		});

}



