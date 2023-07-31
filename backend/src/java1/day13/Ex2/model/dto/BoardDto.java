package java1.day13.Ex2.model.dto;

public class BoardDto {
	//싱글톤X : 게시물1개 당 DTO 1개 이기 때문에
	
	// 1. 필드
		// 작성자(문자열) , 내용 (문자열) , 조회수 (int)
	
	private String writer;
	private String content;
	private int view;

	
	
	// 2. 생성자
	
	// 빈 생성자
	public BoardDto() {	} 
	
	// 풀 생성자
	public BoardDto(String writer, String content, int view) {
		super();
		this.writer = writer;
		this.content = content;
		this.view = view;
	}

	// (선택) 게시물 등록시 사용되는 생성자
	public BoardDto(String writer, String content) {
		super();
		this.writer = writer;
		this.content = content;
	}
	
	
	
	// 3. 메소드
	
	// 1. setter , getter
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	//2. toString()
	@Override
	public String toString() {
		return "BoardDto [writer=" + writer + ", content=" + content + ", view=" + view + "]";
	}

	
	
}



/*
	DTO : 이동객체
		1. 객체에 저장할 필드 선정
			1. private 으로 필드 선언 [ 권장 ] : 객체네 필드 직접적인 x
			2. 타입
			3. 필드명

		2. 생성자
			1. 빈생성자
			2. 풀생성자
			3. 그외 사요엥 따라 선언
	
		3. 메소드	
			1. setter , getter	: 필드가 private 라서 직접 접근 불가 / 메소드 이용한 간접 접근
				set 필드명()	: 필드에 값 대입할때 사용하는 메소드
				ger 필드명()	: 필드에 값 호출할때 사용되는 메소드
			2. toString()	: 객체 호출시 주소값이 반환되어 내용 못봄//내용 확인하려면 이거 씀









*/
