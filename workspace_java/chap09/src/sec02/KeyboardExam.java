package sec02;

public class KeyboardExam {

	public static void main(String[] args) {

		Keyboard k1 = new KeyboardImpl();
		String key = k1.press(13);
		System.out.println("k1 key : " + key);

		
		// 익명 객체
		// 부모를 딱 하나만 가질 수 있다(인터페이스 포함)
		Keyboard k2 = new Keyboard(){

			@Override
			public String press(int keyCode) {
				if(keyCode == 13) {
					return "Enter";
				}
				return "뭔가 눌림";
			}
		};
	
	}

}
