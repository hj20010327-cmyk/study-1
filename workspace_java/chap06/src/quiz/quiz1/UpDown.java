package quiz.quiz1;

import java.util.Scanner;

public class UpDown {

	// 1~ 10까지 정답
	
	double answer = Math.random();
	
	void ans () {
		int a = (int)(answer*10);
//		System.out.println(a);
		boolean boo = false;
		int count = 0;
		while(true) {
			Scanner scan = new Scanner(System.in);
			int userans = scan.nextInt();
			if(userans > a) {
				System.out.println("다운");
				count++;
			} else if (userans < a) {
				System.out.println("업");
				count++;
			} else {
				count++;
				System.out.println("정답입니다 " + count + "번 실행되었습니다.");
				boo = true;
				break;
			}
//			if (boo == true) {
//				System.out.println("정답");
//			}
		}
	}
//	} else {
//		System.out.println("정답");
//	}
	// Scanner
	
//	void user() {
//		Scanner scan = new Scanner(System.in);
//		int userans = scan.nextInt();
//		if(userans > a) {
//			System.out.println("다운");
//		} else if (userans < a) {
//			System.out.println("업");
//		} else {
//			System.out.println("정답");
//		}
//		
//	}
	
	// 정답이랑 Scanner받은거 비교
	
	// 정답이랑 같으면 "정답" 출력
	
}
