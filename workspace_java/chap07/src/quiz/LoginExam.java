package quiz;

public class LoginExam {

	public static void main(String[] args) {

		Naver naver = new Naver("abcd", "abcd");
		naver.login("abcd","abcd");
		
		Daum daum = new Daum("abcd", "abc");
		daum.login("abcd", "abc");
		
	}

}
