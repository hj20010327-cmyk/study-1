package chap04;

import java.util.Scanner;

public class ForExam_03 {

	public static void main(String[] args) {
		
		int sum = 0;
		
		// for문의 기본 형식
//		for(;;) {
//			
//		}
		
//		for(int i=1; i<=100; i++) {
//		for(int i=1; i<=100; i = i + 1) {
//		for(int i=1; i<=100; i = i + 2) {
//		for( i = 1; i<=100; i = i + 2) {
		int i = 0;
		i = 1;
		for( ; i<=100; i++) {
			sum = sum + i;
//			sum += i;
		}
		System.out.println(sum);
		System.out.println(i); 
	
		// 1~10까지 출력
		for ( int u = 1; u<=10; u++) {
			System.out.println(u);		 
		}
		
		
		// 1+1+1+1+1
		// 1씩 더하는 것을 5번 하고싶다
		int sum1 = 0;
		sum1 = sum1 +1;
		sum1 = sum1 +1;
		sum1 = sum1 +1;
		sum1 = sum1 +1;
		sum1 = sum1 +1;
		System.out.println(sum1);
		
		// 시작 값
		// 종료 조건
		int sum2 = 0;
		for(int j=1; j<=5; j++) {
			sum2 = sum2 +1;
		}
		System.out.println(sum2);
		
		
		// 1~5까지 합을 구하기
		sum = 0;
		sum = sum + 1;
		sum = sum + 2;
		sum = sum + 3;
		sum = sum + 4;
		sum = sum + 5;
		
		sum = 0;
		int k = 1;
		sum = sum + k; // k == 1
		k++;		
		sum = sum + k; // k == 2
		k++;		
		sum = sum + k; // k == 3
		
		for(k = 1; k <=5; k++) {
			sum = sum + k;
		}
		/*
		 * 반복문 만드는 원리
		 * 
		 * 1. 반복 되는 것 찾기
		 * 		Ctrl + c, v 했을 때 바뀌지 않는 것 찾기
		 * 
		 * 2. 반복 되지 않는 것의
		 * 		2-1. 규칙(패턴) 찾기
		 * 		2-2. 변수로 바꿔서 더 이상 바뀌지 않게 만들기
		 * 
		 * 3. 시작 값 파악
		 * 4. 종료 조건 파악
		 */
		
		// 깜짝 퀴즈
		// 구구단 2단 출력
		// 2 x 1 = 2
		// 2 x 2 = 4
		
		int nine = 2;
//		nine1 = nine * 1;
//		y++;
//		nine1 = nine * 2;
//		nine1 = nine * 3;
		
		int y = 1;
//		nine1 = nine * y;
		
		for(y = 1; y<=9; y++) {
			int nine1 = nine * y;
			System.out.println(nine + " x " + y + " = " + nine1 );
		}
		
		// 10부터 1까지 출력
		int z;
		for (z = 10; z >= 1; z-- ) {
			System.out.println(z + " ");
		}
		// 10부터 2까지 짝수만 출력
		for (z = 10; z >= 2; z--) {
			if( z%2 == 0) {
				System.out.print(z + " ");
			}
		}
		for (z = 10; z >= 2; z -= 2) {
			System.out.print(z + " ");
		} // 이게 더 좋은 방식
		System.out.println();
		
		// ----------꼭 풀 수 있어야됨------------
		// 문제 1
		// 1~ 5까지 출력하되 홀수인지 짝수인지 같이 출력
		// 예) 1 : 홀수
		//	   2 : 짝수
		int num;
		for (num  = 1; num <= 5; num++) {
			if(num%2 == 0) {
				System.out.println(num + ": 짝수");
			} else {
				System.out.println(num + ": 홀수");
			}
		}
		
		// 문제 2
		// 1~ 100까지 홀수의 합과 개수
		sum = 0;
		int count = 0;
		
		
		for (num = 1; num <= 100; num++ ) {
			if (num%2 == 1) {
				sum = sum + num;
				count++;
			}
		}
		System.out.print(sum + " ");
		System.out.println(count);
		// 문제 3
		// 1~입력 받은 수 까지 더하기

		Scanner scan = new Scanner(System.in);
		int rsp1 = scan.nextInt();
		sum = 0;
		for (num =1; num <= rsp1; num++) {
			sum = sum + num;
		}
		System.out.println(sum);
		
		// ----- 조금 난이도 있는 ---------
		// 문제 4
		// 1 ~ 10까지 3개씩 옆으로
		//	1  2  3
		//	4  5  6
		//  7  8  9
		//	10
		
		String str1 = "";
		for (num = 1; num <= 10; num++ ) {
			if (num%3 == 0) {
				System.out.println(" " + num);
			} else {
			System.out.print(" " +num);
			}
			
		}
			
		System.out.println();
		
		// ----- 2중 for문 ---
		// 문제 1
		// 구구단 모든 단 출력
		int t;
		int p;
		for (t = 2; t <= 9; t++) {
			System.out.println("   " + t + "단");
			for (p = 1; p <= 9; p++) {
				int r = t * p;
				System.out.println( t + " x " + p + " = " + r);
			}
		}
		
		// 문제 2
		// 구구단 단마다 출력
		
		// 문제 3
		// 구구단 3단씩 옆으로 출력
		
		// 문제 4
		// 주사위 2개를 굴려서 
		// 나올 수 있는 모든 조합 출력
		
		// 문제 5
		// 주사위 2개를 굴려서
		// 합 별로 출력
		
		// 문제 6
		// 주사위 2개를 굴려서 나올 조합에서
		// 중복 없이 출력
		// 예 : [1,2] [2.1] 중복이라서 [1,2]
		// 중복이라는 개수
		
		// 1~ 100까지 쓰는데 10의 배수마다 엔터치기
//		int e;
//		String str="";
//		for (e = 1; e <= 100; e++) {
//			if ( e%10 == 0) {
//				 str = e +"\n";				
//			} else {
//				str = e+ "";
//			str += (e%10 == 0) ? e + " \n" : e + " ";
//		}
//			
//			System.out.println(str);
			
			
		
	}
}
