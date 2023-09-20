console.log('wishlist js 실행')

/*

	1. document.querySelector(선택자) : dom 객체 1개 가져오기
	1. document.querySelectorAll(선택자) : dom 객체 여러개 가져오기

*/
getWishList()

let checkIndex = []; // 현재 체크된 인덱스

let checkList = document.querySelectorAll('.checkbox');
	console.log(checkList);
	
		// dom객체명.addEventListener('이벤트' , 이벤트 발생 후 결과값 반환 (e)=>{})
checkList[0].addEventListener('click' , (e)=>{
	console.log('첫번째 체크박스 누름')
	console.log(checkList[0].Checked); 
	// type 이 checkbox 인 인풋 박스는 Checked 속성 이용한 체크여부 확인//true 체크함 / false 체크안함
	
	// 첫번째 체크 박스가 체크되면 다른 모든 체크박스도 체크됨
	if(checkList[0].checked==true){
		checkList.forEach(check=>{check.checked = true;})
	}
	else{checkList.forEach(check=>{check.checked = false;})
	}
		
})



if(localStorage == false){
	alert('로그인이 필요합니다.')
	location.href="/jspweb/member/login.jsp"}


function getWishList(){

	
	$.ajax({
		
		url : "/jspweb/PwishListController",
		method : "get",
		async: false,
		data : {type : "findByAll"},
		success : jsonArray=>{ console.log(jsonArray)
		
		let table = document.querySelector('.table')
		let html = `
				<tr class="table-light">
					<th width="5%"><input class="checkbox" type="checkbox"></th>
					<th width="5%">이미지</th>
					<th width="40%">제품정보</th>
					<th width="10%">가격</th>
					<th width="10%">비고</th>
				</tr>`;			
		jsonArray.forEach(p=>{
				html+=`
			<tr>
				<td><input class="checkbox"  type="checkbox"></td>
				<td><img src="/jspweb/product/img/${Object.values(p.imgList)[0]}" width="100%"/></td>
				<td>${p.pname}</td>
				<td>${p.pprice.toLocaleString()} 원</td>
				<td> <button onclick="deleteWish(${p.pno})" class="btn btn-outline-dark"  type="button"> 삭제 </button> </td>
			</tr>`
			
		})
		table.innerHTML=html;
		
	},
		erroe: e=>{ console.log(e)}
	})//ajax
	
}//getWishList

function deleteWish(pno){
	
	$.ajax({
		url : "/jspweb/PwishListController",
		method : "delete",
		data : {},
		success : result =>{
			console.log(result)
			
		},
		error : e=>{console.log(e)}
		
		
		
	})
	
	
}

















