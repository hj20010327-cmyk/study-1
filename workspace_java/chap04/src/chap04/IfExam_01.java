package chap04;

import java.util.Scanner;

public class IfExam_01 {

	public static void main(String[] args) {
		
		int score = 95;
		
		boolean over90 = score >= 90;
		
		{
			System.out.println("항상 실행되는 실행 블럭");
		}
		
		// 만약에
		if(over90) {
			System.out.println("90 이상입니다.");
		}
//		if(over90) System.out.println("90 이상입니다.");
		// 실행문 하나일 때 중괄호 생략 가능
		// 왠만하면 중괄호 써서 코드짜기
		
		if(score < 90) {
			System.out.println("90 미만입니다.");
		}
		
		// 정 반대일 경우 !를 활용하는 것도 좋다
		if( !(score >= 90) ) {
			System.out.println("90 미만입니다.");
		}
		
		if( score >= 90 ) {
			System.out.println("90 이상입니다.");
		} else { // 그렇지 않으면
			System.out.println("90 미만입니다.");
		}
		// else가 있으면 무조건 하나는 실행되는게 보장된다
		
		if( score >= 90 ) {
			System.out.println("90 이상");
		}
		// * 이전과 관계 없이 무조건 다시 판단
		if (score < 100 && score >= 80) {
			System.out.println("80 ~ 100");
		}
		System.out.println("-------------");
		if( score >= 90 ) {
			System.out.println("90 이상");
//		} else if (score < 100 && score >= 80) {
//		} else if (score < 90 && score >= 80) {
		} else if(score >= 80) {
			// * 위의 if나 else if가 false일 때만 판단
			System.out.println("90미만 80이상");
		} else if(score >= 70) {
			System.out.println("80미만 70이상");
		} else {
			System.out.println("70미만");
		}
		
		// 97점이면
		// 		90이상
		//		95이상
		// 92점이면
		// 		90이상
		
		if ( score >= 95 ) {
			System.out.println("90 이상");
			System.out.println("95 이상");
		} else if( score >= 90 ) {
			System.out.println("90 이상");
		}
		if ( score >= 90 ) {
//			System.out.println("90 이상");
			if( score >= 95 ) {
				System.out.println("95 이상");
			}
		if( score >= 90 && score >= 95 ) {
			System.out.println("95 이상");
		}
		
		}
	
		
		// 홀짝
		int x = 3;
		if (x%2 == 0 ){
//		if (x%2 != 0 ){
		System.out.println("짝수");
		} else {
		System.out.println("홀수");
		}
		
		//랜덤
		double random1 = Math.random();
		System.out.println("random1: "+ random1);
		
		// Math. random()
		// 0 <= Math. random() < 1
		// 0 ~ 0.999999999999
		
		// 0과 1을 구하는 (홀짝)
		// 정교한 방식
		// 0*2 <= Math. random()*2 < 1*2 
		// 0 ~ 1.9999999999999
		// int로 형 변환 해서 정수만 남기기
		double rand2 = Math.random(); // 0~0.999999
		double temp1 = rand2 * 2; // 0~1.99999
		int result = (int) temp1;
		System.out.println("랜덤 홀짝");
		if(result == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");			
		}
		
		// 1 ~ 6까지 구하기 (주사위)
		// 0*6 <= Math. random()*6 < 1*6
		// 0 ~ 5.9999999999
		// int로 바꾸고
		// +1 하면 1 ~ 6
		rand2 = Math. random();
		double temp2 = rand2 * 6; // 0 ~ 5.99999999999
		int result0 = (int)temp2; // 0 ~ 5
		result = result0 + 1; // 1~ 6
		System.out.println("주사위 결과: " + result);
		
		// 5~10까지 구하기
		rand2 = Math. random();
		temp2 = rand2 * 6;	// 0 ~ 5.99999999
		result0 = (int)temp2; // 0 ~ 5
		result = result0 + 5 ; // 5 ~ 10
		System.out.println("5~10까지: " + result);
		
		// 변수로 범위를 잡아서 보편화
		int min = 5;
		int max = 10;
		rand2 = Math. random();
		temp2 = (int) (rand2 * (max - min + 1)) + min;
		
		// 쉬운 방식
		rand2 = Math.random();
		temp2 = rand2 * 100000;
		result0 = (int)temp2;
		result = ( result0 % 6 ) + 1;
		
		
		// 로또 번호
		// 1 ~ 45까지 6개의 숫자를 랜덤으로 뽑아서 제출
		// 단, 중복없이
		rand2 = Math.random();
		double rand3 = Math.random();
		double rand4 = Math.random();
		double rand5 = Math.random();
		double rand6 = Math.random();
		double rand7 = Math.random();
		
		double temp4 = rand2 * 100000;
		double temp5 = rand3 * 100000;
		double temp6 = rand4 * 100000;
		double temp7 = rand5 * 100000;
		double temp8 = rand6 * 100000;
		double temp9 = rand7 * 100000;
		
		int wow1 = (int) temp4;
		int wow2 = (int) temp5;
		int wow3 = (int) temp6;
		int wow4 = (int) temp7;
		int wow5 = (int) temp8;
		int wow6 = (int) temp9;
		result = (wow1 % 46) + 1;
		int result2 = (wow2 % 46) + 1;
		int result3 = (wow3 % 46) + 1;
		int result4 = (wow4 % 46) + 1;
		int result5 = (wow5 % 46) + 1;
		int result6 = (wow6 % 46) + 1;
		
		
		System.out.print(result + " ");
		System.out.print(result2 + " ");
		System.out.print(result3 + " ");
		System.out.print(result4 + " ");
		System.out.print(result5 + " ");		
		System.out.println(result6);
		
		
		// 임의의 수를 입력받아 
		// 문제 1
		// "양수" , 0 , "음수" 판단하여 출력
		
		Scanner scan = new Scanner(System.in);
//		int num = scan.nextInt();
//		if (num < 0) {
//			System.out.println("음수");
//		} else if(num > 0) {
//			System.out.println("양수");
//		} else System.out.println("0");
//		System.out.println("num: " + num);
		
		// 문제 2
		// 홀수인지 짝수인지 판단하여 출력
		
//		int num1 = scan.nextInt();
//		
//		if (num1%2 == 1) {
//			System.out.println("홀수");
//		} else {
//			System.out.println("짝수");
//		}
		
		// 문제 3
		// 임의의 두 수 x, y를 받아서
		// 둘 중에 큰 값 출력

//		int x1 = scan.nextInt();
//		int y1 = scan.nextInt();
//		
//		if (x1< y1) {
//			System.out.println(y1);
//		} else {
//			System.out.println(x1);
//		}
		
		// 문제 4
		// 임의의 money를 입력 받아서
		// 7000원 이상이면 "택시타자" 출력
		// 7000~3000 사이면 "버스타자" 출력
		// 3000 미만이면 "걸어가자" 출력
		
//		int money = scan.nextInt();
//		if (money >= 7000) {
//			System.out.println("택시타자");
//		} else if(money >= 3000) {
//			System.out.println("버스타자");
//		} else System.out.println("걸어가자");
		
		// 문제 5
		// '가위', '바위', '보' 입력 받아서
		// 5-1 컴퓨터는 항상 '바위'만 낼 경우
		// 5-2 컴퓨터도 random으로
		// '이겼다', '비겼다', '졌다' 출력
		
		//5-1
//		Scanner scan2 = new Scanner(System.in);
//		String rsp = scan2.nextLine();
//		if (rsp.equals("보")) {
//			System.out.println("바위 \n 내가 이겼다!");
//		}
//		if (rsp.equals("바위")) {
//			System.out.println("바위 \n 비겼다");
//		}
//		if (rsp.equals("가위")) {
//			System.out.println("바위 \n 내가 졌다...");
//		}
		
		// 5-2
		
//		Scanner scan3 = new Scanner(System.in);
//		String rsp1 = scan3.nextLine();
//		double rsp2 = Math.random();
//		double tem = (rsp2 * 100000);
//		int resul = (int)tem % 3; 
//		if (rsp1.equals("가위")) {
//			if (resul == 0) {
//				System.out.println("가위 \n 비겼습니다");
//			}
//			if (resul == 1) {
//				System.out.println("바위 \n 졌습니다");
//			}
//			if (resul == 2) {
//				System.out.println("보 \n 이겼습니다");
//			}
//		}
//		if (rsp1.equals("바위")) {
//			if (resul == 0) {
//				System.out.println("가위 \n 이겼습니다");
//			}
//			if (resul == 1) {
//				System.out.println("바위 \n 비겼습니다");
//			}
//			if (resul == 2) {
//				System.out.println("보 \n 졌습니다");
//			}
//		}
//		if (rsp1.equals("보")) {
//			if (resul == 0) {
//				System.out.println("가위 \n 졌습니다");
//			}
//			if (resul == 1) {
//				System.out.println("바위 \n 이겼습니다");
//			}
//			if (resul == 2) {
//				System.out.println("보 \n 비겼습니다");
//			}
//		}
		
		// 문제 6
		// 임의의 세 수 x, y, z 를 받아서
		// z가 x~y 사이에 있는지(포함) 판단
		
//		Scanner scan4 = new Scanner(System.in);
//		int a = scan4.nextInt();
//		int b = scan4.nextInt();
//		int c = scan4.nextInt();
//		if (c <= b && c >= a) {
//			System.out.println("c가 a와b 사이에 있습니다");
//		} else {
//			System.out.println("c가 a와b 사이에 있지 않습니다");
//		}
		
		// 문제 7
		// 月을 입력 받아서
		// 계절 출력
		// 13, -1 등 입력하면 "정확히 입력해주세요" 출력
		
//		Scanner scan5 = new Scanner(System.in);
//		int month = scan5.nextInt();
//		if (month >= 3 && month <= 5 ) {
//			System.out.println("봄이 왔습니다");
//		} else if(month >= 6 && month <= 8) {
//			System.out.println("여름이 왔습니다");
//		} else if(month >= 9 && month <= 11) {
//			System.out.println("가을이 왔습니다");
//		} else if(month == 12 || month <= 2 && month >= 1) {
//			System.out.println("겨울이 왔습니다");
//		} else {
//			System.out.println("정확히 입력해주세요");
//		}
		
		// 문제 8
		// 임의의 수를 입력 받아서 다음과 같이 출력
		// 예 : 125
		// 출력: 입력한 수는 100보다 크고, 양수이고, 홀수입니다.
		
//		Scanner scan6 = new Scanner(System.in);
//		int what = scan6.nextInt();
//		String str = "";
//		if (what > 100) {
//			str = "100보다 크고";
//		} else if (what < 100) {
//			str = "100보다 작고";
//		} else {
//			str = "100이고";
//		}
//		if (what > 0) {
//			str += " 양수이고";
//		} else {
//			str += " 음수이고";
//		}
//		if ( what%2 == 0) {
//			str += " 짝수입니다.";
//		} else {
//			str += " 홀수입니다.";
//		}
//		System.out.println(str);		
				
				
				
//		if (what > 100) {
//			if(what > 0) {
//				if(what%2 == 1) {
//					System.out.println("입력한 수는 100보다 크고, 양수이고, 홀수입니다");
//				}
//			}
//			if(what > 0) {
//				if(what%2 == 0) {
//					System.out.println("입력한 수는 100보다 크고, 양수이고, 짝수입니다");
//				}
//			}
//		}
//		if (what < 100) {
//			if(what > 0) {
//				if(what%2 == 1) {
//					System.out.println("입력한 수는 100보다 작고, 양수이고, 홀수입니다");
//				}
//			}
//			if(what > 0) {
//				if(what%2 == 0) {
//					System.out.println("입력한 수는 100보다 작고, 양수이고, 짝수입니다");
//				}
//			}
//			if(what < 0) {
//				if(what%2 == 1) {
//					System.out.println("입력한 수는 100보다 작고, 음수이고, 홀수입니다");
//				}
//			}
//			if(what < 0) {
//				if(what%2 == 0) {
//					System.out.println("입력한 수는 100보다 작고, 음수이고, 짝수입니다");
//				}
//			}
//		}
		
		// 문제 9
		// 온도를 입력받아서 다음과 같이 출력
		// 예 : -3
		// 출력: 영하 3도입니다
		// 예 : 5
		// 영상 5도 입니다
		
//		Scanner scan8 = new Scanner(System.in);
//		int tempt = scan8.nextInt();
//		String str = ""; 
//		if (tempt >= 0) {
//			str = "영상 " + tempt; 
//		} else {
//			str = "영하 " + (tempt*-1);
//		}
//		System.out.println(str + "도 입니다");
		
		// 응용문제
		// 문제 10
		// 시, 분을 입력 받아서 35분 후의 시, 분을 출력
		// 3, 51을 입력받으면
		// 4시 26분 출력
		
//		Scanner scan10 = new Scanner(System.in);
//		int tim = scan10.nextInt();
//		int minute = scan10.nextInt();
//		String time = ""; // 3시 51분 266분 
//		int total = tim*60 + minute + 35;
//		int result12 = total/60;
//		int result60 = total%60;
//		System.out.println(result12+ "시 " + result60 + "분" );
		
		// 문제 11
		// 두 자리 숫자를 입력받아서
		// 10의 자리와 1의 자리가 같은지 판단
		// 예 : 77 => 같음 , 94 => 다름
		
//		Scanner scan11 = new Scanner(System.in);
//		int ten = scan11.nextInt();
//		int ten1 = ten/10;
//		int one = ten%10;
//		if (ten1 == one) {
//			System.out.println("같음");
//		} else {
//			System.out.println("다름");
//		} 
		
		// 문제 12
		// 1~99까지 369게임
		// 임의의 수를 받아서 3,6,9 숫자가 있으면 "박수" 출력
		// 없으면 그 숫자 그대로 출력
		// 예 : 33 => 박수, 31 => 박수, 12 => 12, 14 => 14
		
//		Scanner scan12 = new Scanner(System.in);
//		int three = scan12.nextInt();
//		int three10 = three / 10;
//		int three1 = three % 10;
//		if (three10 == 3 || three10 == 6 || three10 == 9) {
//			System.out.println("짝");
//		} else if (three1 == 3 || three1 == 6 || three1 == 9) {
//			System.out.println("짝");
//		} else {
//			System.out.println(three);
//		}
		
		// 문제 13
		// 사각형의 한쪽 모서리 :  x1 : 10, y1 : 20
		// 반대편 모서리 : x2: 90, y2 : 100
		// 입력받은 두 수를 좌표로 하는 점이 사각형에 겹치는가
		
//		Scanner scan13 = new Scanner(System.in);
//		int four = scan13.nextInt();
//		int five = scan13.nextInt();
//		int x1 = 10;
//		int y1 = 20;
//		int x2 = 90;
//		int y2 = 100;
//		if (four >= x1 && four <= x2) {
//			if (five >=y1 && five <= y2) {
//				System.out.println("겹칩니다");
//			}
//		} else {
//			System.out.println("안겹칩니다");
//		}
		
		
	}

} 
