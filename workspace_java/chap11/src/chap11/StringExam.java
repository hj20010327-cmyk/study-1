package chap11;

public class StringExam {

	public static void main(String[] args) {

		System.gc();
		
		String s1 = "영일이삼사오육칠팔구삼사";
	
		char c = s1.charAt(1);
		System.out.println(c);
		c = 'c';
//		char c1 = s1.charAt(100);
		
		int i1 = s1.indexOf("삼사");
		System.out.println(i1);
		
		int i2 = s1.indexOf("삼오");
		System.out.println(i2); // 없으면 -1
		
		int i3 = s1.lastIndexOf("삼사");
		System.out.println(i3);
		
		String email = "todair@naver.com";
		// 이메일 양식 점검
		// @하나, .하나 있는가
		if(email.indexOf("@")!= -1 && email.indexOf(".") != -1) {
			System.out.println("이메일 형식입니다");
		} else {
			System.out.println("이메일 아님");
		}
		
		int index = -1;
		for(int i=0; i<email.length(); i++) {
			if(email.charAt(i) == '@') {
				index = i;
				break;
			}
		}
		
		String s2 = s1.replace("삼사", "34");
		System.out.println("s1: "+ s1);
		System.out.println("s2: "+ s2);
		// replace는 모두 바꿔준다
		
		String s3 = s1.substring(5, 8);
		System.out.println("s3: "+ s3);
		
		// 문제1
		// 아까 email에서 id만 출력
		
		String id = email.substring(0,email.indexOf('@'));
		System.out.println("id: "+ id);
		
		// 문제2
		// 123456-1234567
		// 성별 출력하기
		
		String num = "123456-1234567";
		String s = num.substring(num.indexOf('-')+1,num.indexOf('-')+2);
		
		if(s.equals("1") || s.equals("3")) {
			System.out.println("남자입니다");
		} else if (s.equals("2") || s.equals("4")) {
			System.out.println("여자입니다");
		} else {
			System.out.println("주민번호가 잘못되었습니다");
		}
		
		char s4 = '한';
		char s5 = '한';
		if(s4 == s5) {
			System.out.println("같음");
		}
		
		String s6 = " 글 to the 씨  ";
		System.out.println("["+ s6.trim() +"]");
		
		String menu = "유빈: 짜곱, 민호: 짬뽕, 선생님: 제육덮밥, 찬솔: 짜곱, 용상: 차돌짬뽕, 령: 차돌짬뽕";
		
		// regex
		String[] menus = menu.split(", ");
		for(String m : menus) {
			System.out.println(m);
		}
		
		String url = "blog.naver.com";
		// split의 전달인자는 정규 표현식을 사용
		// 단순한 String이 아님에 주의
		// .은 정규 표현식에 예약어
//		String[] urls = url.split(".");
//		String[] urls = url.split("\\."); // .을 표현하는 방법 1
		String[] urls = url.split("[.]"); // .을 표현하는 방법 2
		for(String m : urls) {
			System.out.println(m);
		}
		
		String str1 = ""+10;
		String str2 = String.valueOf(10);
		
		String a = "a";
		a += "b";
		a = a + "c";
		
		// StringBuffer
		// 메모리를 효율적으로 사용한다
		// 스레드에 안전하다(Thread-safe)
		
		StringBuffer sb = new StringBuffer("a");
		sb.append("b");
		sb.append("c");
		String d = sb.toString();
		
		// StringBuffer보다 쬐끔 빠름
		// 스레드에 안전하지 않다
		StringBuilder sb2 = new StringBuilder("a");
		sb2.append("b");
		sb2.append("c");
		
		int vol = -3;
		if(vol < 0) {
			vol = 0;
		}
		vol = Math.max(0, Math.min(10, vol));
		
		
	}

}
