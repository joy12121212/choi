let id_list = [] // 회원가입 아이디 저장 리스트
let pw_list = [] // 회원가입 비밀번호 저장 리스트


function signlist () {
	
	let id = document.querySelector(".sid").value	
	let pw = document.querySelector(".spw").value
	
	if( id.length >=8 && pw.length >=8){
		id_list.push(id)
		pw_list.push(pw)
		alert('회원등록 완료')
	}else{  alert('등록 실패')}

	
	document.querySelector(".sid").value = ""
	document.querySelector(".spw").value = ""

}


function loginlist(){
	
	let id1 = document.querySelector(".lid").value
	let pw1 = document.querySelector(".lpw").value
	

	if( id_list.indexOf(id1) != -1 && id_list.indexOf(id1) == pw_list.indexOf(pw1) )
	{
		alert('로그인 성공')
		
	} else{alert('로그인 실패')}
	
	document.querySelector(".lid").value = ""
	document.querySelector(".lpw").value = ""	
}
