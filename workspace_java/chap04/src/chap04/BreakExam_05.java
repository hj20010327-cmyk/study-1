package chap04;

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
		
		
		
	}

}
