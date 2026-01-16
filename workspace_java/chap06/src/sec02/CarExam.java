package sec02;

public class CarExam {

	static int a = 10;
	
	public static void main(String[] args) {

		Car myCar = new Car();
		
		System.out.println(myCar.company);
		myCar.company = "부가티";
		System.out.println(myCar.company);
		
		System.out.println(myCar.speed);
		myCar.speed = 170;
		System.out.println(myCar.speed);
		
		Car myCar2 = new Car();
		System.out.println(myCar2.company);
		
		System.out.println("a: " + a);
		
		
		// 깜짝퀴즈
		// China 클래스 만들기
		// 필드
		//   	name // 가게 이름
		// 		address // 주소
		// 		menus // 2개 이상의 메뉴를 가지는 메뉴 목록
		// ChinaExam
		// 		중국집을 2개 생성해서
		//		1. 필드값 출력
		// 		2. 필드값 바꾸고 출력
		
	}

}
