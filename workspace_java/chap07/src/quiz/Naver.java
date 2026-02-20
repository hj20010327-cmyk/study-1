package quiz;

public class Naver extends Login{

	// @Override 
	// ... login(...)
	// 출력 결과만 변경
	// "네이버 로그인 성공", "네이버 로그인 실패"
	

	Naver(String id, String pw) {
		super(id, pw);
	}

	@Override
	void login(String id, String pw) {
		if (loginCheck(id, pw) == true) {
			System.out.println("네이버 로그인 성공");
		} else {
			System.out.println("네이버 로그인 실패");
		}
	}
	
	
}
