package java1.day07;


import java.io.File;
import java.io.FileInputStream;
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
					//해당 경로에 파일이 없으면 자동 생성 , 새로쓰기
				// new FileOutputStream("파일경로",true); : 해당 파일과 연동/연결
				//해당 경로에 파일이 없으면 자동 생성 , 이어쓰기

				// 파일 경로 : 
					// 상대경로 : 프로젝트명 생략 -> ./src/패키지명/파일명
					// 절대경로 : C:\Users\504\git\choi_BC\backend\src\java1\dya07\Ex1_파일처리.java
			// 2. 제공하는 함수.write()
				//1. .write( 바이트 배열 )		: 1바이트=영어 한글자 , 2바이트=한글 한글자 / 바이트배열 = 여러글자
				//2. 문자열.getByte()			: 해당 문자열을 바이트배열 변환
				//3. .read(바이트 배열)		: 해당 객체와 연결된 파일의 바이트 읽어오기
		
		
			// 3. 파일		: 파일에 관련 메소드 제공
				// 메소드
					// 1. 존재 여부	: file.exists()
					// 2. 삭제		: file.delete()
					// 3. 경로		: getPath()
					// 4. 크기(바이트)	: file.length() : 파일의 용량을 long 타입으로 반환
		
		
			Scanner scanner = new Scanner(System.in);  // 입력한 값이 바이트로 들어옴
			String str = scanner.nextLine(); // 입력값 받은 바이트열을 문자로 변환 // 0100 이거를 글자로 바꿔줌
		
		// 1. 파일 처리 [ 저장 ]
			// 파일 출력 스트림 객체 선언 [파일 경로 필수]
		FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/day07/Ex2_test.txt" , true);
			// 파일 출력 스트림 객체를 이용한 내ㅐ보내기 메소드 사용 [ 바이트 단위 ] 
		
		byte [] insAar = str.getBytes(); // 문자열은 바이트열로 변환 후 내보내기
		
		fileOutputStream.write( insAar );
		
		// 2. 파일처리 [ 불러오기 ]
			//1. 파일 입력 스트림 객체 선언 [ 파일 경로 ]
		FileInputStream fileInputStream = new FileInputStream("./src/java1/day07/Ex2_test.txt");
			//2. 파일 입력 스트림 객체를 이용한 파일 내용 읽어오기 [ 바이트 단위 ]
		byte[] outstrar = new byte[1000]; // 파일의 바이트만크 배열 선언 // 정확한 파일의 용량 알 수 없음//임의로 1000 입력
		fileInputStream.read(outstrar);
			//3. 저장한 바이트배열을 문자열로 변환
		String str1 = new String(outstrar); 
		
		System.out.println(str1); // 용량을 크게 하면 나머지 빈 공간은 공백 처리 한다//쓸데없이 용량 차지
		
		//3. 외부파일 불러오기 [csv 불러오기]
		
		FileInputStream 복권파일 = new FileInputStream("./src/java1/day07/로또.csv");
			//해당 파일의 용량 알기 [40,960 바이트]
		File file = new File("./src/java1/day07/로또.csv");
			System.out.println("파일 있나요" + file.exists());
			// file.delete(); -> 삭제
			System.out.println("파일 경로" + file.getPath());
			System.out.println("파일 바이트(크기)" + file.length());
		byte[] 복권파일바이트 = new byte [(int)file.length()];
		
			//읽어오기
		복권파일.read(복권파일바이트);
			//바이트배열 -> 문자열 변환
		String 복권파일정보 = new String(복권파일바이트);
		System.out.println(복권파일정보);
		
			// 외부 파일 불러 오기
		String 경로 = "./src/java1/day07/전국관광지정보표준데이터.csv";
		//입력 객체 생성
		FileInputStream 관광지파일 = new FileInputStream(경로);
		//파일 정보 객체 생성
		File file2 = new File(경로);
		//용량 만큼의 바이트배열 선언
		byte[] 관광지파일바이트배열 = new byte [(int)file2.length()];
		//읽어온 바이트를 해당 배열에 저장
		관광지파일.read(관광지파일바이트배열); 
		//바이트배열 -> 문자열로 변환
		//String 관광지파일정보 = new String(관광지파일바이트배열 , "UTF-8"); // 문자열에 한글 있을경우
		String 관광지파일정보 = new String(관광지파일바이트배열 , "EUC-KR"); // 문자열에 한글 있을 경우
//		System.out.println(관광지파일정보);
		
		System.out.println(관광지파일정보.split("\n")[0]);
		System.out.println(관광지파일정보.split("\n")[0].split(",")[0]);
		
		
		
		
		
		
		
		
		
	}//main
}
