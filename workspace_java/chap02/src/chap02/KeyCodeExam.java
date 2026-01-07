package chap02;

import java.util.Scanner;

public class KeyCodeExam {

	public static void main(String[] args) {

		System.out.println(1);
		System.out.println(2);
		
		System.out.print(3);
		System.out.print(4);
		
		System.out.println(5);
		System.out.println(); // <br> 처럼 엔터
		System.out.println(6);
		System.out.println("--------------------");
		
		String name = "이용상";
		int age = 20;
//		System.out.printf("이름: "+ name + "나이: " + age);
		System.out.printf("이름: %s, 나이: %d\n", name, age);
		System.out.println(1111);
		
		
		///////////////////////
		// 입력
		
		int keyCode;
		
		// 예외가 발생해도 넘어가게 해주는 코드
		// Scanner 연습하려고 주석 처리
		/*
		try {
			System.out.print("입력하시오 >> ");
			keyCode = System.in.read();
			System.out.println("keyCode: " + keyCode);
			
			keyCode = System.in.read();
			System.out.println("keyCode: " + keyCode);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		// 이클립스 단축기
		/*
		 * 한줄 지우기 : Ctrl + d
		 * 한줄 복사 : Ctrl + Alt + 위 아래 방향키
		 * 주석 단축키 : Ctrl + /
		 * 자동 정렬 : Ctrl + Shift + f
		 * improt 자동 : Ctrl + Shift + O
		 */
		
		Scanner scanner = new Scanner(System.in); 
		// 엔터까지의 모든 글씨
		String inputData = scanner.nextLine();
		System.out.println("inputData: "+ inputData);
		
		// 엔터쳤을 때 첫번째 띄어쓰기까지만
//		inputData = scanner.next();
//		System.out.println("inputData: "+ inputData);
		
		// 문제
		// 나이를 입력하고 + 1 해서 출력
		
		System.out.print("나이를 입력하세요");
//		String age2 = scanner.nextLine();
//		int age3 = Integer.parseInt(age2);
		
		int age3 = scanner.nextInt();
		
		
		System.out.println("내년엔 "+ (age3+1)+ "살 입니다");
		
		
	}

}
