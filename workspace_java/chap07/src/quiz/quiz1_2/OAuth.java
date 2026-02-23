package quiz.quiz1_2;

public class OAuth {

	String id;
	String pw;
	
	boolean join(String id, String pw) {
		
		if (id == null || id.trim() == "" ) {
			return false;
		}
		
		if (this.id == null) {
			this.id = id;
			System.out.println("회원가입 성공");
		} else {
			if(!this.id.equals(id)) {
				this.id = id;
				System.out.println("회원가입 성공");
			} else {
				System.out.println("중복된 아이디입니다");
				return false;
			}
		}
		this.pw = pw;
		return true;
	}
	
	
	
	boolean loginCheck(String id, String pw) {
//		if(this.id.equals(id) && this.pw.equals(pw)) {
//			return true;
//		} else {
//			return false;
//		}
		return this.id.equals(id) && this.pw.equals(pw);
		
	}
	
	boolean login(String id, String pw) {

//		if(loginCheck(id, pw)) {
//			System.out.println("로그인 성공");
//		} else {
//			System.out.println("로그인 실패");
//		}
		return loginCheck(id, pw);
		
	}
	
	
	
	
}
