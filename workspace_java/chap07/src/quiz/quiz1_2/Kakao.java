package quiz.quiz1_2;

public class Kakao extends OAuth {

	@Override
	boolean join(String id, String pw) {

		if (id == null || id.trim() == "") {
			return false;
		}

		if (this.id == null) {
			this.id = id;
			System.out.println("카카오 회원가입 성공");
		} else {
			if (!this.id.equals(id)) {
				this.id = id;
				System.out.println("카카오 회원가입 성공");
			} else {
				System.out.println("중복된 아이디입니다");
				return false;
			}
		}
		this.pw = pw;
		return true;
	}

	boolean login(String id, String pw) {
		System.out.println("카카오로 로그인합니다");
		return loginCheck(id, pw);
		
	}

}
