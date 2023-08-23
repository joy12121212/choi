package java2.day24_제네릭.Ex1;

import 과제.과제11.model.dto.MemberDto;

public class Ex1_제네릭 {
	public static void main(String[] args) {
		// 왜 하는가? 하나의 필드에 여러가지 타입을 데이터를 저장하고 싶음
		// 1. 제네릭을 사용하지 않을때 [p570]		
		Box2 box2 = new Box2();
		// 자식 객체는 부모 객체로 대입 [ 자동 타입 변환 ]
		box2.content = 1;
		box2.content = "안녕";
		box2.content = new MemberDto();
		
		// 부모는 자식 멤버를 사용할 수 없다 // 강제 타입 변환 해야지
			//1. 타입 알고 있을때 (형변환 할 타입 )
			MemberDto dto = (MemberDto)box2.content;
			dto.getMid();
			System.out.println(dto);
			//2. instanceOf 타입 조사 후 사용
			if (box2.content instanceof MemberDto) {}  // 이짓은 비효율, 하지마라
	
		// 2. 제네릭을 사용할때 [p572]
			Box<String> box1 = new Box<>();
			box1.content = "안녕하세요";
			String str = box1.content;
			System.out.println(str);
			
			Box<Integer> box3 = new Box<>();
			box3.content = 100;
			int a = box3.content;
			System.out.println(a);
			
			Box<MemberDto> box4 = new Box<>();
			box4.content = new MemberDto();
			MemberDto dto2 = box4.content;
			System.out.println(dto2);
			
	}
	

}
