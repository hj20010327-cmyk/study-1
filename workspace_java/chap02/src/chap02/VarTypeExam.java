package chap02;

public class VarTypeExam {

	public static void main(String[] args) {

		byte b1;
		b1 = 127;
		System.out.println("b1: "+b1);
//		b1 = 128;
		
		char c1 = 65;
		System.out.println("c1: " + c1);
		char c2 = 65 + 2;
		System.out.println("c2: " + c2);
		char c3 = 'B';
		System.out.println("c3 - c1: " + (c3 - c1));
		
		// L 또는 l을 붙이면 명시적인 long
//		long l1 = 2200000000; 에러
//		long l1 = 2200000000L;
//		long l2 = 30;
		
		String s1 = "이용상";
		System.out.println("s1: " + s1);
		
		String s2 = "이\"용상\"";
		System.out.println("s2: " + s2);
		
		// \n : html의 br태그랑 같음 (줄바꿈)
		String s3 = "\\이\t용\n상";
		System.out.println("s3: " + s3);
		
		System.out.println("글씨"+3);
		System.out.println("글씨"+ 3 + 2); // 글씨32
		System.out.println("글씨"+ (3 + 2)); // 글씨5
		System.out.println( 3 + 2 + "글씨"); // 5글씨
		
//		int a = 3.14; 
		
		//float 거의 안씀
		float f1 = 3.14f;
		System.out.println("f1: " + f1);
		
		//double을 많이 쓴다
		double d1 = 3.14;
		System.out.println("d1: " + d1);
		
		float f2 = 0.1234567890123f;
		System.out.println("f2: " + f2);
		//float의 정밀도 : 소수점 7자리
		
		double d2 = 0.12345678901234567890;
		System.out.println("d2: " + d2);
		// double의 정밀도 : 소수점 16자리
		
		double d3 = 5e3;
		System.out.println("d3: " + d3);
		
		boolean stop = true;
		boolean start = false;
		System.out.println("stop: " + stop);
		
		
		// 문제 1
		// 내 나이를 저장
		int age;
		age = 26;
		System.out.println("age: " + age);
		// 문제 2
		// 운전면허가 있다/없다
		
		boolean drive = true;
		System.out.println("drive: " + drive);
		// 문제 3
		// 우리집에 있는 스마트폰의 개수
		int smart = 5;
		System.out.println("smart: " + smart);
		
		// 문제 4
		// 내 이름 저장
		String name = "이용상";
		System.out.println("name: " + name);		
		
		// 문제 5
		// 1평은 3.3제곱미터입니다. 
		// 5평이 몇 제곱미터인지 (계산해서) 저장
		
		double meter = 3.3;
		System.out.println("meter: " + (meter*5));
		
		// 문제 6
		// 1-1 : 두 변수 x, y에 각각 숫자를 넣고
		// 출력결과 : "3 > 4 결과는 false  입니다."
		int x = 3;
		int y = 4;
		System.out.println(x + ">" + y + "의 결과는 " + (x > y) + "입니다");
		//6-2 : x , y 값 바꿔서 정답 나오는지 출력
		System.out.println(x + "<" + y + "의 결과는 " + (x < y) + "입니다");
		
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
		int num = 1*100 + 4*10 + 9;
		int n100 = num / 100;
		System.out.println("백의 자리: " + n100);
		int n10 = (num-(n100*100))/10;
		System.out.println("십의 자리: " + n10);
		int n1 = (num-(num/10*10));
		System.out.println("일의 자리: " + n1);
		
		
		// 문제 8
		// 회식비 43000원
		// 참석인원 4명
		// 인 당 얼마?
		//8-1 : 디테일하게 원 단위 까지
		// 8-2 : 만원 단위까지만 받기
		// 8-3 : 주최자 내야될 돈?
		
		int bill = 43000;
		int billman = bill/4;
		System.out.println("참석인원: " + billman + "원");
		int billmans = billman/10000*10000;
		System.out.println("만원단위: "+ billmans + "원");
		int billmand = billmans + (billman-billmans)*4;
		System.out.println("주최자: " + billmand + "원");
		System.out.println( "주최자: " + (bill - billmans*3) + "원");
		
		// 문제 9
		String left = "오예스";
		String right = "사탕";
		
		String center;
		center = left;
		left= right;
		right= center;
		
		
		// 뭔가 하기
		System.out.println("left: " + left);
		System.out.println("right: " + right);
		
		
	}

}
