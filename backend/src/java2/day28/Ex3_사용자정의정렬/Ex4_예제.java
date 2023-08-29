package java2.day28.Ex3_사용자정의정렬;

import java.util.TreeSet;

public class Ex4_예제 {
	public static void main(String[] args) {
		
		FruitComparator fruitComparator = new FruitComparator();
		
		TreeSet<Fruit> treeSet = new TreeSet<>(fruitComparator);
		
		
		//3. 무작위 객체 대입
		
		treeSet.add(new Fruit("포도", 1110));
		treeSet.add(new Fruit("사과", 113240));
		treeSet.add(new Fruit("감자", 112310));
		treeSet.add(new Fruit("옥수수", 13450));
		
		System.out.println("이진트리 상태 : " + treeSet);
		
	}

}
