

// 등록 
function acbwrite(){ console.log('acbwrite 실행 정상')
	// html input 에 입력 받은걸 가져와서 저장 한다
	
	let acbContent = document.querySelector('.acbContent').value;
	console.log('받아온 acbContent ' + acbContent);
	let acbMoney = document.querySelector('.acbMoney').value;
	console.log('받아온 acbMoney ' + acbMoney);
	let acbDate = document.querySelector('.acbDate').value;
	console.log('받아온 acbDate ' + acbDate);	
	
	let info = {
		content : acbContent, 
		money : acbMoney ,
		date : acbDate
	}
	console.log(info);
	
	$.ajax({
      url :  "/jspweb/AccountBookController",
      method : "post" , 
      data : info ,
      success : function f(r){console.log('통신성공')
      	if(r == true){
			  alert('등록 성공'); acbread();
			  acbContent = '';
			  acbMoney = '';
			  acbDate = '';
		  }else{alert('등록 실패')}
      
      } ,
      error :  function f (r){}
  	 });
	
	
}
 acbread();
// 출력
function acbread(){
	
	   $.ajax({
      url :  "/jspweb/AccountBookController",
      method : "get" , 
      data : "" ,
      success : function f(r){
		  // 어디에 출력 할지
		  let output = document.querySelector('.acb_Frint');
		  // 무엇을 출력 할건지
		  let html =``; 
		  
		  for(let i = 0; i <r.length; i++){
			  html +=`
			<div> 
				<div>${r[i].content}</div>
				<div>${r[i].money}</div>
				<div>${r[i].date}</div>

				<div>
				<button onclick="acbupdate(${r[i].ano})" type="button">수정</button>
				<button onclick="acbdelete(${r[i].ano})" type="button">삭제</button>
				</div>
			
			</div>`
			  
		  }
		output.innerHTML = html;
		  
	  } ,
      error :  function f (r){}
      });
	
	
	
	
}

// 수정
function acbupdate(ano){
	acbread();
	 console.log(ano);
	 // 수정할 내용
	 let content = prompt('수정할 내용');
	 
	   $.ajax({
      url :  "/jspweb/AccountBookController",
      method : "put" , 
      data : {ano : ano , content : content} ,
      success : function f(r){
		  if(r == true){
			  alert('수정 성공');acbread();
		  }else{alert('수정 실패')}
	  } ,
      error :  function f (r){console.log(r)}
      });
	
	
}

// 삭제


function acbdelete(ano){
	
	$.ajax({
      url :  "/jspweb/AccountBookController",
      method : "delete" , 
      data : {ano : ano } ,
      success : function f(r){
		  if(r == true){
			  alert('삭제 성공');acbread();
		  }else{alert('삭제 실패')}
	  } ,
      error :  function f (r){}
      });
	
	
}