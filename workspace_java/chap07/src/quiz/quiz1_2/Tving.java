package quiz.quiz1_2;

import java.util.Scanner;

public class Tving {

	Scanner scan = new Scanner(System.in);
	void tvingLogin(OAuth oauth) {
		
		if(oauth.login(scan.nextLine(),scan.nextLine())) {
			System.out.println("Tving 메인 페이지 표시");
		} else {
			System.out.println("다시 로그인 하세요");
		}
		
	}
	
}
