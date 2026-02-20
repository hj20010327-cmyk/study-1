package sec01;

public class StudentExam {

	public static void main(String[] args) {

		Student student = new Student("이용상", "934231-1234567", 1);
		
		System.out.println("이름: " + student.name);
		System.out.println("주민번호: " + student.ssn);	  // 부모에게 상속받은 필드 출력
		System.out.println("학번: " + student.studentNo);
		
		
	}

}
