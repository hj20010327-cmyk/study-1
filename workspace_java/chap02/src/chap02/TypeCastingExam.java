package chap02;

public class TypeCastingExam {

	public static void main(String[] args) {
		
		int intValue = 10;
		byte byteValue = (byte)intValue;
						// intValue를 int에서 byte로 바꿔줌		
		System.out.println(byteValue);
		
		// 여기서 ()는 우선 순위 연산자
		int a = 2 * ( 3 + 4 );
		
		// 여기서 ()는 형 변환 연산자
		byte byteValue2 = (byte)intValue;
		// 괄호마다 의미가 다르다
		intValue = 200;
		byteValue = (byte)intValue;
		// 정확히는 비트를 2의 보수로 계산한 결과가 나온다
		// 즉, 예상하기 힘들다
		System.out.println(byteValue);
		
		double d1 = 3.14;
		float f1 = (float)d1;
		
//		long l1 = (long)2200000000; 
	             // 22억을 먼저 int로 인식해서 안됨
		
		
		double d2 = -3.14;
		int i1 = (int)d2;
		System.out.println("i1: " + i1);
		
		// 작은 것에서 큰 것으로 변환할때
		// 형 변환 생략 가능
		int i2 = 100;
		long l2 = (long)i2;
		long l3 = i2;
		long l4 = 100; // 앞에 long 생략
		
		int i3 = 2100000000;
		int i4 = 2100000000;
		int i5 = i3 + i4;
		System.out.println("i5: " + i5); // i5: -94967296
		
		int i6 = 10;
		long l6 = 4L;
//		int i7 = i6 + l6;
//		long l7 = (long)i6+ l6; 
		long l7 = i6 + l6;
		// int는 long으로 자동 형 변환이 된다
		// int + long 연산 시 int가 long이 되고 결과도 long이 된다
		
		int i7 = 10;
		double d7 = 5.5;
		double d8 = i7 + d7;
		System.out.println("d8:[15.5?] "+ d8);
		
		double d9 = 10 / 4;
//		int i9 = 10 / 4;
//		d9 = i9;
		System.out.println("d9: " + d9);
		
		double d10 = 10.0 / 4;
		System.out.println("d10: " + d10);
		
//		double d11 = (double)10 / (double)4;
		double d11 = (double)10 / 4;
		System.out.println("d11: " + d11);
		
		
		// 문자를 숫자로 바꾸기
		String s1 = "123";
		int i12 = Integer.parseInt(s1);
		System.out.println(i12 + 1);
		
//		String s2 = "123";
//		int i13 = (int)s2; // 형 변환 안됨( 지원하지 않음 ) 
		
//		String s3 = "123a";
//		int i14 = Integer.parseInt(s3); // NumberFormatException
		// 에러나 예외가 발생하면 즉시 java 종료
//		System.out.println(i14);
		
		int i15 = 123;
		String str = String.valueOf(i15); // 숫자를 문자로
		System.out.println(str + 1);
		
		// 가장 쉽게 숫자를 문자로 바꾸는 방법
		String str1 = "" + i15;
		
		
		
	}

}
