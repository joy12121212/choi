package java2.day21;

import java.util.Iterator;

public class Ex2_예외처리 {
	public static void main(String[] args) {
		String[] array = {"100", "1oo"};
		
		for (int i = 0; i <= array.length; i++) { // 배열 인덱스는 0 과 1 밖에 없는데 포문은 2 까지 돌라고 함 -> 인덱스가 없는데 뭘 돌아 ? 하면서 오류가 발생
			
			try {
				int value = Integer.parseInt(array[i]); // 1번 인덱스 값은 숫자가 아니라 문자다 // 그래서 인트로 형변환 불가
				System.out.println("array[ " + i + "] " + array[i]);
			}
			
			// 예외클래스 catch 작성순서 : 하위 예외 클래스 블록 먼저 작성, 상위 클래스 블록은 나중에 작성 -> 안에서 밖으로 캐치문 작성
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 인덱스가 초과됨 " + e.getMessage());  // Index 2 out of bounds for length 2
			} 
			catch (NumberFormatException e) {
				System.out.println("숫자로 변환할 수 없음 " + e.getMessage());  //For input string: "1oo"
			}
			catch (NullPointerException | ClassCastException e) {System.out.println("뭐냐"+e);}
			catch (Exception e) {System.out.println("예외 발생했다"+ e);};
		}// for
		
	}//main

}//class
