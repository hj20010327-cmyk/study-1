package quiz;

public class Login {

	// id, password
	// 생성할 떄 받아서 저장
	// 1. 전달인자로 받은 id, pw를
	// 2. loginCheck로 보내고
	// 3. 결과 출력
	// 3-1 "로그인 성공", "로그인 실패"
	
	String id;
	String pw;
	
	Login(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	boolean loginCheck(String id, String pw) {
		if(this.id.equals(id) && this.pw.equals(pw)) {
			return true;
		} else {
			return false;
		}
	}
	
	void login(String id, String pw) {
		if (loginCheck(id, pw)) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}
	
}
