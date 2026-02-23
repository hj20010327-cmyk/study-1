package quiz.quiz1_2;

public class TvingExam {

	public static void main(String[] args) {

		Naver naver = new Naver();
		naver.join("lys","1234");
		naver.join("lys","1234");
		Kakao kakao = new Kakao();
		kakao.join("asdf","asdfd");
		
		Tving tving = new Tving();
		
		tving.tvingLogin(naver);
		tving.tvingLogin(kakao);
	}

}
