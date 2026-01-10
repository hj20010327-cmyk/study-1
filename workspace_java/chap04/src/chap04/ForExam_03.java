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
//		sum = 0;
//		int count = 0;
//		
//		
//		for (num = 1; num <= 100; num++ ) {
//			if (num%2 == 1) {
//				sum = sum + num;
//				count++;
//			}
//		}
//		System.out.print(sum + " ");
//		System.out.println(count);
		// 문제 3
		// 1~입력 받은 수 까지 더하기

//		Scanner scan = new Scanner(System.in);
//		int rsp1 = scan.nextInt();
//		sum = 0;
//		for (num =1; num <= rsp1; num++) {
//			sum = sum + num;
//		}
//		System.out.println(sum);
		
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
		t = 2;
		int p;
		p = 1;
		for (t = 2; t <= 9; t++) {
			System.out.println("   " + t + "단");
			for (p = 1; p <= 9; p++) {
				int r = t * p;
				System.out.println( t + " x " + p + " = " + r);
			}
		}
		
		// 문제2
        // 구구단 단마다 옆으로 출력
        // 2x1=2 2x2=4...
		
		for ( t=2; t <= 9; t++) {
			System.out.println(" " + t + "단");
			for (p = 1; p <= 9; p++) {
				int m = t * p;
				if (p == 9) {
				System.out.println(t + " x " + p + " = " + m);
				} else {
					System.out.print(t + " x " + p + " = " + m + " ");
				}
			}
		}
        
        // 문제3
        // 구구단 3단씩 옆으로 출력
        // 2x1=2 3x1=3 4x1=4
        // 2x2=4 3x2=6 4x2=8
        // 2x3=6...
        t = 2;
        p = 1;
		for (p = 1; p <= 9; p++) {
			for (t = 2; t<=9; t++) {
				int o = t * p;
				if (t == 9) {
				System.out.println(t + "x" + p + " = " + o);
				} else {
					System.out.print(t + "x" + p + " = " + o + " ");
				}
			}
			
		}
        // 문제4
        // 주사위 2개를 굴려서
        // 나올 수 있는 모든 조합 출력
        // [1,1] [1,2] [6,6]
		
		int dice1;
		int dice2;
		for (dice1 = 1; dice1 <= 6; dice1++) {
			for (dice2 =1; dice2 <=6; dice2++) {
				if (dice2 == 6) {
				System.out.println( "[" + dice1 + "," +  dice2 + "]");
				} else {
					System.out.print( "[" + dice1 + "," +  dice2 + "]" + " ");					
				}
			}
		}
		
        
        // 문제5
        // 주사위 2개를 굴려서
        // 합 별로 출력
        // 합2 : [1,1]
        // 합3 : [1,2] [2,1]
		
//		합h = dice1+ dice2
//		h 2 3 4 5 6 ... 2부터 하나씩 증가
//		주사위 두개 합이 h면 되는데
//		if (h == dice1 + dice2) {
//			System.out.println(합 h: [dice1, dice2]);		
//		}
		
		int h;
		dice1 = 1;
		dice2 = 1;
		String str3;
		str3 = "";
		for (h = 2; h <= 12; h++) {
			str3 = "합" + h + ": ";
		for (dice1 = 1; dice1 <= 6; dice1++) {
			for (dice2 =1; dice2 <=6; dice2++) {
				if (h == dice1 + dice2) {					
					str3 += "[" + dice1 + "," + dice2 + "]";
					} 
				}			
			}
			System.out.println(str3);	// h의 반복문 안에서 주사위 반복문이 다 끝나서 출력해야 되므로 
										// 주사위 반복문 다음에 출력해야함
		}
		System.out.println();
	
		
        // 문제6
        // 주사위 2개를 굴려서 나올 조합에서
        // 중복 없이 출력
        // 예: [1,2] [2,1] 중복이라서 [1,2]
		
		// 주사위 2개 굴리는데
		// 중복이 없어야됨
		// 1,1 1,2 2,1
		// dice2가 dice1의 값에서 시작하면 없어지나?
		// dice1이 1이면 dice2 1부터 시작 1,1 ~ 1,6 출력
		// dice1이 2면 dice2 2부터 시작 2,2 ~ 2,6 출력 2,1 출력 안됨
		// dice1이 3이면 dice2 3부터 시작 3,3 ~ 3,6    3,1 3,2 출력 안됨 // 미친 유레카
		
		for (dice1 = 1; dice1 <= 6; dice1++) {
			for (dice2 = dice1; dice2 <=6; dice2++) {
				if (dice2 == 6) {
					System.out.println( "[" + dice1 + "," +  dice2 + "]");
				} else {
						System.out.print( "[" + dice1 + "," +  dice2 + "]" + " ");					
				}
			}			
		}
		
		// 피라미드 만들기
//		---*---  1           4줄일땐  3 1   5줄일땐  4 1
//		--***--  3 * =2*line-1        2 2			 3 2
//		-*****-  5                    1 3			 2 3
//	    *******  7					  0 4			 1 4
//											         0 5 						
//	         										얘네 둘 합 = 줄 개수	minus + line = n	
//		이걸 어떻게 만들까					4줄이라면       첫번쨰줄일때		3  +  1 = 4	 minus는 3개
//		4줄이 반복  															 2  +  2 = 4   minus가 n-line일때 멈춰야됨
//		- 가 반복 되는데 그다음 줄에는 *가 늘어남 (2개씩) 2n-1 
//		- 반복되고 * 쓰고 - 다시 반복 => 반복문 3개 써야됨	
//		
//		
//		
		int line;
		int star;
		int minus;
		int n = 4;
		star = 1;
		for (line= 1; line<= n; line++) {
			for (minus =1; minus <= n - line ; minus++ ) {
				System.out.print("-");
			}
			for (star = 1; star <= 2*line -1; star++ ) {
				System.out.print("*");
			}
			for (minus =1; minus <= n - line ; minus++ ) {
				System.out.print("-");
			}
		System.out.println();
		}
		for (line= n-1; line>= 1; line--) {
			for (minus =1; minus <= n - line ; minus++ ) {
				System.out.print("-");
			}
			for (star = 1; star <= 2*line -1; star++ ) {
				System.out.print("*");
			}
			for (minus =1; minus <= n - line ; minus++ ) {
				System.out.print("-");
			}
			System.out.println();
		}
		
		
		
		
		
		
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
