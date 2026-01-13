package chap04;

import java.util.Scanner;

public class BreakExam_05 {

	public static void main(String[] args) {
		
		int count = 0;
		while(true) {
			int num = (int) (Math.random()*6) +1;
			System.out.println("주사위: " +num);
			count++;
			if (num == 6) {
				break;
			}
		}
		System.out.println("프로그램 종료 총:" + count );
		
		// 총 5명이 순차적으로 주사위를 던져서
		// 각자 6이 나올때까지  6이 나오면 다음사람
		count=0;
		for (int i=1; i<=5; i++) {
			while(true) {
				int num = (int) (Math.random()*6) +1;
				System.out.println("주사위: " +num);
				count++;
				if (num == 6) {
					break; // while 소속이라서 while 중단
				}
			}
			System.out.println("프로그램 종료");
		}
		
		// 총 4층의 주차건물이 있음
		// 각 층에는 10대의 자리가 있음
		// 내 차는 1층 첫번째부터 17번쨰에 있음
		int count2 = 0;
		boolean flag = false;
		for (int j=1; j<=4; j++) {
			
			for(int i=1; i<=10; i++) {
				count2++;
				System.out.println(j+ ", " +i);
				if (count2 >= 17) {
					System.out.println("!!!!!!!!!!");
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
			
		}
		
		for(int i =1; i<=10; i++) {
			if(i%2 ==0) {
				continue;
			}
			System.out.println(i); 
		}
		System.out.println("-----------");
		
		// 문제 1
		// 1-1 : 책 184p 처럼 만들기
		// 1-2
		// 		예금 : 음수 불가
		// 		출금 : 음수 불가 + 잔고초과 불가
		//		메뉴 외 선택 불가
//		Scanner scan = new Scanner(System.in);
//		int w;
//		int m = 10000;
//		int r;
//		r= 0;
//		do {
//			System.out.println("-----------------------------------");
//			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
//			System.out.println("-----------------------------------");
//			w = scan.nextInt();
//			System.out.println("선택 > " + w);
//			if (w == 1) {
//				 System.out.println("예금액 > " + m);
//			} else if (w == 2) {
//				r = scan.nextInt();
//				m -= r;
//				System.out.println("출금액 > " + r);
//				
//			} else if (w == 3) {
//				System.out.println("잔고 > " + m);
//			}
//		} while (w != 4); {
//		
//		}
//		System.out.println("종료합니다");
		Scanner scan = new Scanner(System.in);
		int w;
		int m = 0;
		int r;
		int t;
		t=0;
		r= 0;
		do {
			System.out.println("-----------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------------");
			w = scan.nextInt();
			System.out.println("선택 > " + w);
			if (w == 1) {
				t = scan.nextInt();
				if (t < 0) { // 음수일때
					System.out.println("금액을 제대로 입력해주세요");
				} else if (t > 10000000) { // 일일 예금 초과
					System.out.println("1회 예금 금액을 초과했습니다");
				} else {
				m += t;
				System.out.println("예금액 > " + t);
				}
			} else if (w == 2) {
				r = scan.nextInt();
				if (r <0) { // 음수 일때
					System.out.println("금액을 제대로 입력해주세요");
				} else if (r > t) { // 잔액 부족할 때
					System.out.println("잔액이 부족합니다");
				} else {
				m -= r;
				System.out.println("출금액 > " + r);
				}
			} else if (w == 3) {
				System.out.println("잔고 > " + m);
			} else if (w > 4 || w <= 0){
				System.out.println("메뉴를 다시 입력해주세요");
			}
		} while (w != 4); 
		System.out.println("종료합니다");
		
		
		
		
		
	}	
	

}
