package sec04.method02;

public class Calc {
	
	// 메소드 선언
	void powerOn() {
		int a;
		a = 10;
		
		System.out.println("전원을 켭니다");
	}

	// 잠깐 return 배우고 왔음
	
	int plus(int x, int y) {
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		
		int result = x + y;
		return result;
	}
	/**
	 * javadoc 주석
	 * 두 정수를 입력 받아서
	 * 나누기한 결과를 x/y
	 * double로 돌려주는 메소드
	 * 단, y가 0일때는 "0으로 나눌 수 없다"고 출력
	 * 		0을 돌려 줌
	 * 
	 *  메소드명 : divide
	 *  전달인자 : int x, int y
	 *  리턴타입 : double
	 *  
	 *  @param int x, int y
	 *  @return double
	 *  @author lys010327@naver.com
	 */
	double divide(int x, int y) {
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		if (y == 0) {
			System.out.println("0으로 나눌 수 없다");
			return 0;
		} else {
//			System.out.println(result);
			return (double)x / y;
		}
//		if (y == 0) {
//			System.out.println("0으로 나눌 수 없다");
//			return 0;
//		}
//		return (double)x / y;
		
//		double result1 = 0;
//		if (y == 0) {
//			System.out.println("0으로 나눌 수 없다");
//			result1 = 0;
//		} else {
//			result1 = (double)x / y;
//		}
//		return result1;
		
		/*
		Calc 클래스에 숫자와 문자를 받을수 있는 
		scanner ,더하기, 빼기 , 나누기 , 곱하기 Method를 만든다.

		CalcExam 클래스 에서 

		scanner 메소드를 호출하여 
		1번째 숫자 , 2번째 연산자 , 3번째 숫자 를 입력하여 ArrayList 로 return 을 받는다.
		연산자를 if 하여 연산자에 맞는 메소드에 숫자를 보내 리턴받고 출력한다. 

		scanner 은 String 으로 받아서 형변환 가능 , 0번째 숫자  , 1번째 문자 , 2번째 숫자 로 받아도 됨

		예 

		>"1 * 2"

		>"2 입니다."
		*/
		
		
		
	}
}
