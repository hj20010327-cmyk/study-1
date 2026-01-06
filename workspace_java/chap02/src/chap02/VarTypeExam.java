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
		long l1 = 2200000000L;
		long l2 = 30;
		
		String s1 = "이용상";
		System.out.println("s1: " + s1);
		
		String s2 = "이\"용상\"";
		System.out.println("s2: " + s2);
		
		// \n : html의 br태그랑 같음 (줄바꿈)
		String s3 = "\\이\t용\n상";
		System.out.println("s3: " + s3);
		
	}

}
