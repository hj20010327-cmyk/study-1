package quiz1;

import java.util.ArrayList;
import java.util.Scanner;

public class CalcQuiz {
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
	String a = "1";
	        int b = 9;
	        System.out.println(Integer.parseInt(a) * b);  문자열숫자를 인트로 형변환 하는 방법중 하나 입니다.
	*/
	
	// 일단 사칙연산 메소드 4개 만들고
	// 배열 만들기 String으로
	// 배열에 scanner 받아서 배열 저장
	// Exam 파일에서 조건문으로 사칙연산 뭐인지 결정
	
	
	
	int plus(int x, int y) {		// 더하기
		return x + y;
	}
	int minus(int x, int y) {		// 빼기
		return x - y;
	}
	double divide(int x, int y) {	// 나누기
		if(y == 0) {
			System.out.println("0으로 나눌 수 없습니다");
			return 0;
		}
		return (double)x / y;
	}
	int multi(int x, int y) {		// 곱하기
		return x * y;
	}
	ArrayList<String> play = new ArrayList<>();  // 배열 만들기
	String x;
	String op;
	String y;
	
	ArrayList<String> input() {
		Scanner scan = new Scanner(System.in);	// 배열을 scanner로 받은걸로 채우기
		x = scan.nextLine();		// scan으로 받아서 x
		play.add(x);				// x 배열에다가 저장
		op = scan.nextLine();
		play.add(op);
		y = scan.nextLine();
		play.add(y);
		
		return play;
	}
	
	
	
}
