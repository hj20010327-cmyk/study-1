package sec05._static;

import java.util.Scanner;

public class Calc {

	String color;
	
	// 어차피 변수이긴 하다
	// 정적멤버, 공용변수, 클래스 변수
	static int price = 10;
	static double pi = price;
	
	String c2 = color;
//	static String c3 = color;	
	
	{
		System.out.println("필드에 있는 실행 블럭");
	}
	static {
		System.out.println("필드에 있는 static 실행 블럭");
	}
	
	
//	pirce = 100;
	
	Calc() {
		System.out.println("Calc 생성자 실행");
		
//		this.price = 10;
//		Calc.price = 10;
	}
	
	
	static void test() {
		System.out.println("잘 된다");
//		this.color = 10;		// color는 static이 아니라 가져다 쓸 수 없음
	}
	
	
}
