package java1.day13.Ex2.model.dao;

import java.util.ArrayList;

import java1.day13.Ex2.model.dto.BoardDto;

public class BoardDao {
	// 싱글톤 : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
	
	// 1. 객체 생성
	private static BoardDao boardDao = new BoardDao();
	
	// 2. 외부로부터 싱ㄱ르톤 호출할 수 있도록 getInstance	
	public static BoardDao getInstance() {return boardDao;}
	
	// 3.외부 객체 생성 차단	
	private BoardDao() {}
	
	
	
	// 게시물 여러개 저장하는 곳
		// 1. 배열
	public BoardDto[] boardDtoArray = new BoardDto[100];
		// 2. 리스트 : 배열을 쉽게 사용할 수 있도록 다양한 함수 ㅈ공
		// 얘는 고정길이 정해놓은 값 만큼만 사용 가능
	public ArrayList<BoardDto> boardDtoList = new ArrayList<>();
		// ArrayList : 배열처럼 사용 가능한 클래스 객체 선언
			// <클래스> : 리스트안에 여러개 객체를 저장할 객체의 타입
				// boardList : 리스트 객체 변수명
		// 얘는 가변길이 // 무한대

	public ArrayList<BoardDto> board = new ArrayList<>();







}

/*

	- 배열 : boarDtoArray
		boardList = [boarDto] [boarDto] [boarDto] [boarDto]
					   0		1		   2		3
					   
		- 배열에서 값 호출하는 방법
		배열명[인덱스]
		
		
		

	- 리스트 : boardList
		가변길이 - 저장하는 개수만큼 자동으로 저장할 수 있는 길이
	boardDtoList = [boarDto boarDto boarDto boarDto boarDto]

	- 리스트객체명.add(저장할거) : 해당 리스트에 객체를 저장 [ 마지막 인덱스 뒤로 객체 추가 ]
		
	- 리스트에서 값 호출하는 방법
		- 리스트객체명.get(인덱스번호)

	- 리스트에 값 삭제하는 방법
		- 리스트객체명.remove(인덱스) : 해당 인덱스의 객체를 삭제 후 한칸씩 당기기 해줌





*/





