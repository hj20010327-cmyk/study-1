package chap03;

public class OpExam {

	public static void main(String[] args) {
		
		int x = 10;
		
		x++;
		System.out.println("x: "+ x);
		
		x = 10;
		x = x + 1;
		// 나한테 + 1 해서 다시 나한테 저장할 때
		// 줄여쓰는 형태
		x += 1; // 위와 같은 코드
		x++; 	// 위와 같은 코드
				// 단, +1만 가능
		x = 10;
		++x;
		System.out.println("++x: "+ x);
		
		x = 10;
		x--;
		--x;
		System.out.println("x: "+ x);
		System.out.println();
		
		x = 10;
		int z = ++x;
		System.out.println("z(++x): "+ z);
		System.out.println("x(++x): "+ x);
		System.out.println();
		
		x = 10;
		z = x++;
		System.out.println("z(x++): "+ z);
		System.out.println("x(x++): "+ x);
		
		x = 10;
		System.out.println( ("x++: " + x++) + (" x: "+x) );
		
		x = 10;
		//  10 + 12
		z = x++ + ++x;
		// 예측 : 21
		System.out.println("z: " + z);
		
		x = 1;
		// 1   -  1
		z = x++ - --x * x++ - x--;
		// 단항을 먼저 해야됨
		// z와 x의 출력값
		// 예측 z: -1
		// 예측 x: 2
		System.out.println("z: " + z);
		System.out.println("x: " + x);
		
		
		// 나누기 할 때 0으로 나누지 않도록 조심
		int b = 10;
//		int c = b / 0;
		
		double d = 7.3;
		double e = d / 0;
		System.out.println("d/0: "+ e); // Infinity
		
		// %는 나머지
		int f = 10 % 3;
		System.out.println(f);
		// 특징이 0부터 ~ 나머지 하는 숫자보다 하나 작은 것만 나온다 
		
		// 문제 7 
				/*
				 * 숫자 149
				 * ---------
				 * 출력 결과
				 * ---------
				 * "백의 자리 : 1"
				 * "십의 자리 : 4"
				 * "일의 자리 : 9"
				 */
		/*
		int num = 149;
		int hun = num / 100;
		int ten = num % 100 / 10;
		int one = num % 10;
		System.out.println(hun);
		System.out.println(ten);
		System.out.println(one);
		*/
	
		System.out.println(0.1);
		System.out.println(0.1f);
		System.out.println(0.1 == 0.1f);
		// 소수점은 근사치로 저장된다
		// 그나마 같은 타입으로 변환해서 비교하면 수월하다
		
		String s1 = "s1";
		String s2 = "s1";
		System.out.println(s1.equals(s2 )); 
		System.out.println("asdfasd".equals (s1));
		// 글씨는 무조건 equals()로 비교한다
		
		int c1 = 22;
		int c2 = 4;
		System.out.println("몫: "+ (c1/c2) );
		System.out.println("나머지: "+ (c1%c2));
		
		// 문제 1
		// 돈이 10000원
		// 1. 4500원 짜리 쌍화차를 최대 몇잔 마실수 있는가
		// 2. 그리고 남는 돈은?
		int bill = 10000;
		int ssang = 4500;
		System.out.println("몇잔?: " + bill/ssang);
		System.out.println("남은돈: " + bill%ssang);
		// 문제 2
		// 올영에서 꿀홍차가 8000원인데
		// 15% 세일! 가격은?
		int hong = 8000;
		int sale = (int)(hong- hong*0.15);
		System.out.println("15% 세일한 가격: " +sale);
		
		// 문제 3-0
		// 1234를 1200만 남기시오
		  int num1 = 1234;
		  int num2 = num1/100*100;
		  System.out.println(num2);
		
		// 문제 3
		double v1 = 1000;
		double v2 = 794.0;
		double v3 = (int)(v1/v2 *1000);
		// v1 / v2를 소수점 3자리까지만 출력하시오
		// 오칙연산만
		System.out.println( v3 / 1000 );
		
		
		// 문제 4
		// 17000원이 있을 때
		// 5천원 몇장
		// 1천원 몇장
		int a1 = 17000;
		int a2 = 5000;
		int a3 = 1000;
		int a4 = a1/a2;
		System.out.println("5천원짜리: " + a4 + "장");
		int a5 = a1 % a2;
//		int a5 = a1 - (a4*a2);
		int a6 = a5 / a3;
		System.out.println("천원짜리: " + a6 + "장");
		
		
	}

}
