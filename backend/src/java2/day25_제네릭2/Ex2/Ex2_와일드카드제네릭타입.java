package java2.day25_제네릭2.Ex2;

public class Ex2_와일드카드제네릭타입 {
	public static void main(String[] args) {

			// 1. 사람 객체
		Person person = new Person();
			// 2. 지원자 객체 [ 지원자 객ㅊ에 사람 객체를 생성자 대입 ]
		Applicant<Person> applicant = new Applicant<Person>(person);				
			// 3. 모든 지원 가능한 코스 등록 함수	
		Course.registerCourse1(applicant);
			// 1번 2번을 한줄로 줄이면
		// Course.registerCourse1(new Applicant<Person>(new Person()));		
		
		// 1. 모든 사람이 신청 가능
		Course.registerCourse1(new Applicant<Person>(new Person()));
		Course.registerCourse1(new Applicant<Worker>(new Worker()));
		Course.registerCourse1(new Applicant<Student>(new Student()));
		Course.registerCourse1(new Applicant<HightStudent>(new HightStudent()));
		Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		System.out.println();
		
		// 2. 학생만 등록 가능
		
		Course.registerCourse2(new Applicant<Student>(new Student()));
		Course.registerCourse2(new Applicant<HightStudent>(new HightStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		System.out.println();
		// 3. 직장인 및 일반인만 등록 가능
		
		Course.registerCourse3(new Applicant<Person>(new Person()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));

	
	}

}
