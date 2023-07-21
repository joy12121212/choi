package java1.day07;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex1_파일처리 {
	public static void main(String[] args) throws IOException {
		
		// 스택영역 : 함수는 호출시 메모리할당 , 종료시 메모리 초기화 = 사용할때만 메모리 // 휘발성
		// 힙영역 : 객체/배열은 참조하는 스택이 없으면 자동으로 메모리 초기화(삭제)
			// ---> ram 주기억장치 : 현재 처리된 명령어 저장 -> 전기 x -> 저장x -> 휘발성
		// 영구저장 : 
			// ---> 보조기억장치 : 명령어를 영구 저장 -> 전기x 저장o -> 비휘발성
		// Ex1_파일처리.java
			// 저장위치 : c드라이브  ~ ~
			// 실행[ctrl + F11] : 실행중에 필요한 메모리(변수,객체, 배열 등) -> 주기억장치
			// 실행중인 메모리를 다음에 사용 하려면 주기억장치 메모리를 보조기억장치에 저장 / 불러오기
		
			// String a = scanner.next(); ---> c드라이브에 저장
			// 컴퓨터 종료 후 다음날
			// String a = scanner.next(); ---> c드라이브에서 가져오기	
		
		// 파일처리 라이브러리 ( 미리 만들어진 클래스/메소드)
			// * 스트림 : 자바 외부와 통신할때 사용 통로 [ 바이트 단위 ]
				// * 통신하다가 갑자기 오류 발생할수도 있음 [ * 필수 : 미리 예외처리/오류처리 ] 
			// 1. FileOutputStream : 파일 내보내기/저장 관련된 메소드 제공하는 class
				// new FileOutputStream("파일경로"); : 해당 파일과 연동/연결
				// 파일 경로 : 
					// 상대경로 : 프로젝트명 생략 -> ./src/패키지명/파일명
					// 절대경로 : C:\Users\504\git\choi_BC\backend\src\java1\dya07\Ex1_파일처리.java
			// 2. 제공하는 함수.write()
				//1. .write( 바이트 배열 ) : 1바이트=영어 한글자 , 2바이트=한글 한글자 / 바이트배열 = 여러글자
				//2. 문자열.getByte()해당 문자열을 바이트배열 변환
		
			Scanner scanner = new Scanner(System.in);  // 입력한 값이 바이트로 들어옴
			String str = scanner.nextLine(); // 입력값 받은 바이트열을 문자로 변환 // 0100 이거를 글자로 바꿔줌
		
		// 1. 파일 처리 [ 저장 ]
			// 파일 출력 스트림 객체 선언 [파일 경로 필수]
		FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/day07/Ex2_test.txt");
			// 파일 출력 스트림 객체를 이용한 내ㅐ보내기 메소드 사용 [ 바이트 단위 ] 
		
		byte [] instrar = str.getBytes(); // 문자열은 바이트열로 변환 후 내보내기
		
		fileOutputStream.write( instrar );
	}//main
}
