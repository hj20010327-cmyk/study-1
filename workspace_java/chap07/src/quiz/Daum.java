package quiz;

public class Daum extends Login{

	// @Override
	// ... login(...)
	// 출력 결과만 변경
	// "다음 로그인 성공", "다음 로그인 실패"

	
	Daum(String id, String pw) {
		super(id, pw);
	}

	@Override
	void login(String id, String pw) {
		if (loginCheck(id, pw) == true) {
			System.out.println("다음 로그인 성공");
		} else {
			System.out.println("다음 로그인 실패");
		}
	}
}
